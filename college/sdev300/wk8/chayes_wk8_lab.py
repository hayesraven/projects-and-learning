"""
Name: Cameron Hayes
Date: 25APR2022
Title: Week 6 Graded Lab
Purpose: Simple website provided by Flask
"""
import os
import re
import logging
from datetime import datetime
from logging.handlers import RotatingFileHandler
from flask import Flask, render_template, redirect, url_for, flash, request
from flask_sqlalchemy import SQLAlchemy
from flask_login import LoginManager, UserMixin, current_user
from flask_login import login_required, login_user, logout_user
from werkzeug.security import generate_password_hash, check_password_hash
from flask_wtf import FlaskForm
from wtforms import StringField,PasswordField,SubmitField,BooleanField
from wtforms.validators import DataRequired,Email,EqualTo,ValidationError

app = Flask(__name__)

"""Sets up SQL DB for user registration/login"""
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///mydb.db'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
db = SQLAlchemy(app)

"""Sets up secret key for sessions"""
SECRET_KEY = os.urandom(32)
app.config['SECRET_KEY'] = SECRET_KEY

"""Set up login manager"""
login_manager = LoginManager()
login_manager.init_app(app)

def log_func(filename):
    """Configures a log file for the website"""
    log_format = "%(asctime)s [%(levelname)s] %(message)s"

    log_dir = os.getcwd()+'/log'
    log_file = log_dir + '/' + filename + '.log'

    global LOG
    LOG = logging.getLogger(log_file)
    handler = RotatingFileHandler(filename, maxBytes=5000000, backupCount=3)
    formatter = logging.Formatter(log_format)
    handler.setFormatter(formatter)
    LOG.addHandler(handler)
    LOG.setLevel(logging.DEBUG)
    return LOG

def password_check(form, field):
    """
    Verify the strength of 'password'
    Returns a dict indicating the wrong criteria
    A password is considered strong if:
        12 characters length or more
        1 digit or more
        1 symbol or more
        1 uppercase letter or more
        1 lowercase letter or more
    """
    # calculating the length
    if not len(field.data) >= 12:
        raise ValidationError('Password must be 12 characters or longer')

    # searching for digits
    if not re.search(r"\d", field.data):
        raise ValidationError('Password must contain at least one digit')

    # searching for uppercase
    if not re.search(r"[A-Z]", field.data):
        raise ValidationError('Password must contain at least one uppercase letter')

    # searching for lowercase
    if not re.search(r"[a-z]", field.data):
        raise ValidationError('Password must contain at least one lowercase letter')

    # searching for symbols
    if not re.search(r"[ !#$%&'()*+,-./[\\\]^_`{|}~"+r'"]', field.data):
        raise ValidationError('Password must contain at least one special character')

class User(UserMixin, db.Model):
    """User class for registration/login"""
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(50), index=True, unique=True)
    email = db.Column(db.String(150), unique = True, index = True)
    password_hash = db.Column(db.String(150))
    joined_at = db.Column(db.DateTime(), default = datetime.utcnow, index = True)

    """User methods"""
    def set_password(self, password):
        """Hash given password"""
        self.password_hash = generate_password_hash(password)

    def check_password(self, password):
        """Compare given password to hashed stored password"""
        return check_password_hash(self.password_hash,password)

class RegistrationForm(FlaskForm):
    """Registration Class for registering users"""
    username = StringField('username', validators =[DataRequired()])
    email = StringField('Email', validators=[DataRequired(),Email()])
    password1 = PasswordField('Password', validators = [DataRequired(), password_check])
    password2 = PasswordField('Confirm Password',
                              validators = [DataRequired(),EqualTo('password1')])
    submit = SubmitField('Register')

class LoginForm(FlaskForm):
    """Login Class for logging in users"""
    email = StringField('Email',validators=[DataRequired(), Email()])
    password = PasswordField('Password', validators=[DataRequired()])
    remember = BooleanField('Remember Me')
    submit = SubmitField('Login')

class UpdateForm(FlaskForm):
    """Update Password Class for updating user passwords"""
    oldpassword = PasswordField('Old Password', validators = [DataRequired()])
    newpassword = PasswordField('New Password', validators = [DataRequired(), password_check])
    submit = SubmitField('Update')

def known_pass_check(password):
    """Compares password against a list of known passwords"""
    with open("commonpasswords.txt", "r", encoding="utf-8") as pass_file:
        for pass_line in pass_file:
            known_word = pass_line.strip()
            if known_word in password.lower():
                return -1
    return 0

@login_manager.user_loader
def load_user(user_id):
    """Fetches current user id"""
    return User.query.get(user_id)

@app.route("/forbidden",methods=['GET', 'POST'])
@login_required
def protected():
    """Unauthorized page"""
    return redirect(url_for('forbidden.html'))

@app.route("/logout")
# @login_required
def logout():
    """Log user out"""
    logout_user()
    return redirect(url_for('home'))

@app.route('/register', methods = ['POST','GET'])
def register():
    """Registration Form"""
    form = RegistrationForm()
    if form.validate_on_submit():
        user = User(username = form.username.data, email = form.email.data)
        if known_pass_check(form.password1.data) < 0:
            flash('You really should use a more secure password!')
        user.set_password(form.password1.data)
        db.session.add(user)
        db.session.commit()
        return redirect(url_for('login'))
    return render_template('registration.html', form=form)

@app.route('/login', methods=['GET', 'POST'])
def login():
    """Login Form"""
    form = LoginForm()
    if form.validate_on_submit():
        remote_addr = request.environ['REMOTE_ADDR']
        user = User.query.filter_by(email = form.email.data).first()
        if user is not None and user.check_password(form.password.data):
            login_user(user)
            LOG.info("Successful login from %s", remote_addr)
            next_request = request.args.get("next")
            return redirect(next_request or url_for('home'))
        LOG.info("Failed login from %s", remote_addr)
        flash('Invalid email address or Password.')
    return render_template('login.html', form=form)

@app.route("/update", methods=['GET', 'POST'])
@login_required
def update():
    """Update Password form """
    form = UpdateForm()
    if form.validate_on_submit():
        if current_user.check_password(form.oldpassword.data):
            if known_pass_check(form.newpassword.data) < 0:
                flash('You really should use a more secure password!')
            current_user.set_password(form.newpassword.data)
            db.session.commit()
            next_request = request.args.get("next")
            return redirect(next_request or url_for('home'))
    return render_template('update.html', form=form)

@app.route("/")
def home():
    """Main Homepage"""
    curr_date = datetime.today().strftime("%d %B %Y")
    return render_template("index.html", content=curr_date)

@app.route("/places/")
@login_required
def places():
    """Places I want to live"""
    return render_template("places.html")

@app.route("/cars/")
@login_required
def cars():
    """Vehicles I want to buy"""
    return render_template("cars.html")

@app.route("/videogames/")
@login_required
def videogames():
    """Video games I'm excited for"""
    return render_template("videogames.html")

if __name__ == "__main__":
    db.create_all()
    LOG = log_func('website')
    app.run()
