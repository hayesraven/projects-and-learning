"""
Name: Cameron Hayes
Date: 25APR2022
Title: Week 6 Graded Lab
Purpose: Simple website provided by Flask
"""
import os
from pickle import FALSE
import re
from datetime import datetime
from flask import Flask, render_template, redirect, url_for, flash, request
from flask_sqlalchemy import SQLAlchemy
from flask_login import LoginManager, UserMixin
from flask_login import login_required, login_user, logout_user
from sqlalchemy import true
from werkzeug.security import generate_password_hash, check_password_hash
from flask_wtf import FlaskForm
from wtforms import StringField,PasswordField,SubmitField,BooleanField
from wtforms.validators import DataRequired,Email,EqualTo

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
    password1 = PasswordField('Password', validators = [DataRequired()])
    password2 = PasswordField('Confirm Password',
                              validators = [DataRequired(),EqualTo('password1')])
    submit = SubmitField('Register')
    
    

class LoginForm(FlaskForm):
    """Login Class for logging in users"""
    email = StringField('Email',validators=[DataRequired(), Email()])
    password = PasswordField('Password', validators=[DataRequired()])
    remember = BooleanField('Remember Me',validators= [DataRequired()])
    submit = SubmitField('Login')

def password_check(password):
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
    length_error = 0
    digit_error = 0
    uppercase_error = 0
    lowercase_error = 0
    symbol_error = 0
    
    # calculating the length
    if (len(password) >= 12):
        length_error = 1

    # searching for digits
    if re.search(r"\d", password):
        digit_error = 1

    # searching for uppercase
    if re.search(r"[A-Z]", password):
        uppercase_error = 1

    # searching for lowercase
    if re.search(r"[a-z]", password):
        lowercase_error = 1

    # searching for symbols
    if re.search(r"[ !#$%&'()*+,-./[\\\]^_`{|}~"+r'"]', password):
        symbol_error = 1

    # overall result
    password_ok = (length_error and digit_error and uppercase_error
                       and lowercase_error and symbol_error)

    return password_ok

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
        if password_check(form.password1.data):
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
        user = User.query.filter_by(email = form.email.data).first()
        if user is not None and user.check_password(form.password.data):
            login_user(user)
            next_request = request.args.get("next")
            return redirect(next_request or url_for('home'))
        flash('Invalid email address or Password.')
    return render_template('login.html', form=form)

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
    app.run()
