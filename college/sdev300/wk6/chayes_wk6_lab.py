"""
Name: Cameron Hayes
Date: 25APR2022
Title: Week 6 Graded Lab
Purpose: Simple website provided by Flask
"""
from datetime import datetime
from flask import Flask, render_template

app = Flask(__name__)

@app.route("/")
def home():
    """Main Homepage"""
    curr_date = datetime.today().strftime("%d %B %Y")
    return render_template("index.html", content=curr_date)

@app.route("/places/")
def places():
    """Places I want to live"""
    return render_template("places.html")

@app.route("/cars/")
def cars():
    """Vehicles I want to buy"""
    return render_template("cars.html")

@app.route("/videogames/")
def videogames():
    """Video games I'm excited for"""
    return render_template("videogames.html")

if __name__ == "__main__":
    app.run()
