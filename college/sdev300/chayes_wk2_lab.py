"""
Name: Cameron Hayes
Date: 26MAR2022
Title: Week 2 Graded Lab
Purpose: Menu driven program with lots of functionality
"""
from datetime import date
from multiprocessing.sharedctypes import Value
import secrets
import string
import math

ERROR_LESS_THAN_ONE = "ERROR: Please enter an integer equal to or greater than 1"
ERROR_NOT_INT = "ERROR: Please enter only an integer"

def gen_password():
    """This function generates a "random" password for the user"""
    options = ""
    use_lower = ""
    use_upper = ""
    use_num = ""
    use_symbols = ""
    data_lower = string.ascii_lowercase
    data_upper = string.ascii_uppercase
    data_num = string.digits
    data_symbols = string.punctuation
    msg_lower = "Do you want to use lowercase characters? y/n\n"
    msg_upper = "Do you want to use uppercase characters? y/n\n"
    msg_num = "Do you want to use numbers? y/n\n"
    msg_symbols = "Do you want to use special characters? y/n\n"
    msg_error = "ERROR: Please only enter 'y' (for yes) or 'n' (for no)."

    data_password_list = [data_lower, data_upper, data_num, data_symbols]
    msg_password_list = [msg_lower, msg_upper, msg_num, msg_symbols, msg_error]
    use_password_list = [use_lower, use_upper, use_num, use_symbols]

    while True:
        try:
            pass_len = int(input("\nPlease enter your password length (1-100 characters):\n"))
            if (pass_len >= 1 and pass_len <= 100):
                break
            print("ERROR: Invalid length selected. Please try again")
        except ValueError:
            print("ERROR: Please enter only integers from 1 to 100")

    for i in range(0,4):
        while True:
            use_password_list[i] = str(input(msg_password_list[i]))
            if use_password_list[i] in ('y','n'):
                if use_password_list[i] == 'y':
                    options += data_password_list[i]
                break
            print(msg_password_list[4])

    return ''.join(secrets.choice(options) for i in range(pass_len))

def calc_percent():
    """This function calculates a percentage for the user"""
    msg_numer = "\nPlease enter the numerator: \n"
    msg_denom = "Please enter the denominator: \n"
    msg_places = "Please enter the number of decimal places: \n"
    data_numer = 0
    data_denom = 0
    data_places = 0
    msg_percent_list = [msg_numer, msg_denom, msg_places]
    data_percent_list = [data_numer, data_denom, data_places]

    for i in range(0,3):
        while True:
            try:
                data_percent_list[i] = int(input(msg_percent_list[i]))
                if data_percent_list[i] >= 1:
                    break
                print(ERROR_LESS_THAN_ONE)
            except ValueError:
                print(ERROR_NOT_INT)

    answer = (data_percent_list[0] / data_percent_list[1]) * 100

    return round(answer,data_percent_list[2])

def calc_day_count():
    """This function returns the number of days until July 4, 2025"""
    return (date(2025,7,4) - date.today()).days

def calc_tri_leg():
    """This formula uses the Law of Cosines to calculate a missing length of a triangle"""
    msg_side_a = "\nPlease enter the length of side A: \n"
    msg_side_b = "Please enter the length of side B: \n"
    msg_angle_c = "Please enter the length of angle C: \n"
    data_side_a = 0
    data_side_b = 0
    data_angle_c = 0
    msg_tri_leg_list = [msg_side_a, msg_side_b, msg_angle_c]
    data_tri_leg_list = [data_side_a, data_side_b, data_angle_c]

    for i in range(0,3):
        while True:
            try:
                data_tri_leg_list[i] = int(input(msg_tri_leg_list[i]))
                if data_tri_leg_list[i] >= 1:
                    break
                print(ERROR_LESS_THAN_ONE)
            except ValueError:
                print(ERROR_NOT_INT)

    side_c = math.sqrt((data_tri_leg_list[0]**2) + (data_tri_leg_list[1]**2)
    - (2 * data_tri_leg_list[0] * data_tri_leg_list[1] * math.cos(data_tri_leg_list[2])))

    return round(side_c,3)

def calc_cyl_vol():
    """This formula calculates the volume of a cylinder"""
    msg_height = "\nPlease enter the height of the cylinder: \n"
    msg_radius = "Please enter the radius of the cylinder: \n"
    data_height = 0
    data_radius = 0
    msg_vol_list = [msg_height,msg_radius]
    data_vol_list = [data_height,data_radius]

    for i in range(0,2):
        while True:
            try:
                data_vol_list[i] = int(input(msg_vol_list[i]))
                if data_vol_list[i] >= 1:
                    break
                print(ERROR_LESS_THAN_ONE)
            except ValueError:
                print(ERROR_NOT_INT)

    vol_cyl = math.pi * (data_vol_list[0]**2) * data_vol_list[1]

    return round(vol_cyl,3)

def main():
    """Main execution function"""
    selection = 0

    print("\nWelcome to the most useful program in the world!\n")

    while selection != 6:
        print("Available options:\n")
        print("1. Generate secure password")
        print("2. Calculate and format a percentage")
        print("3. Calculate number of days from today to July 4, 2025")
        print("4. Calculate the leg of a triangle using the Law of Cosines")
        print("5. Calculate the volume of a right circular cylinder")
        print("6. Exit program\n")
        
        try: 
            selection = int(input("Please select one of the above options:\n"))
            match selection:
                case 1:
                    password = gen_password()
                    print("\nHere's your new password -->  " + str(password) + "\n")
                case 2:
                    percentage = calc_percent()
                    print("\nThe answer is " + str(percentage) + ".\n")
                case 3:
                    days = calc_day_count()
                    print("\nThere are " + str(days) + " days left until July 4, 2025.\n")
                case 4:
                    angle = calc_tri_leg()
                    print("\nThe length of side C is " + str(angle) + ".\n")
                case 5:
                    volume = calc_cyl_vol()
                    print("\nThe volume of your cylinder is " + str(volume) + ".\n")
                case 6:
                    print("\nExiting...\nThank you for using the most useful program in the world!")
                case _:
                    print("\nInvalid option, please enter only integers 1 through 6\n")
        except ValueError:
            print(ERROR_NOT_INT)

main()