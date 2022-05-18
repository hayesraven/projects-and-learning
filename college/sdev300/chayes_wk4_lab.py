"""
Name: Cameron Hayes
Date: 14APR2022
Title: Week 4 Graded Lab
Purpose: Menu driven program with fun matrix work
and a password generator
"""
import hashlib
import re
import numpy as np
import pandas as pd

ERROR_NOT_INT = "ERROR: Invalid input, please enter only integers"
ERROR_BAD_INPUT = "ERROR: Invalid input, please only enter y for yes or n for no"

def get_phone():
    """Gets phone number for the user"""
    user_phone = ""
    check_phone = re.compile(r"^[0-9]{3}-[0-9]{3}-[0-9]{4}$")

    while True:
        user_phone = str(input("Please enter your phone number (XXX-XXX-XXXX): "))
        if re.fullmatch(check_phone, user_phone):
            break
        print("ERROR: Invalid input, please enter a phone number in the below format:")
        print("XXX-XXX-XXXX\n")

def get_zip():
    """Grabs the user's zip code"""
    user_zip = ""
    check_zip = re.compile(r"^[0-9]{5}-[0-9]{4}$")

    while True:
        user_zip = str(input("Please enter your zip code (XXXXX-XXXX): "))
        if re.fullmatch(check_zip, user_zip):
            break
        print("ERROR: Invalid input, please enter a zip code in the below format:")
        print("XXXXX-XXXX\n")

def matrix_builder():
    """Builds the matrix """
    matrix = []
    row_input = ""
    check_row_input = re.compile(r"^[0-9]\s[0-9]\s[0-9]$")

    for i in range(1,4):
        while True:
            row_input = str(input("Enter three single digits in row " + str(i) +
                                  ", separated by a space: "))
            if re.fullmatch(check_row_input, row_input):
                for int_input in row_input:
                    if int_input != ' ':
                        matrix.append(int(int_input))
                break
            print("ERROR: Input does not match requested format, please try again")

    return matrix

def get_mean(matrix, choice):
    """Used to grab the mean for the rows and columns of the final matrix"""
    mean = 0
    mean_list = []
    rows, columns = matrix.shape

    if choice == 'row':
        for i in range(0,rows):
            for j in range(0,columns):
                mean += matrix[i][j]
            mean_list.append(round((mean / rows), 3))
            mean = 0

    if choice == 'col':
        for i in range(0,columns):
            for j in range(0,rows):
                mean += matrix[j][i]
            mean_list.append(round((mean / columns), 3))
            mean = 0

    return mean_list

def matrix_calc():
    """Matrix game"""
    matrix_menu = ""
    final_matrix = np.empty([3, 3])

    print("\nWe will now build the first matrix")
    first_matrix = np.array(matrix_builder(), dtype=int).reshape(3,3)
    print("\nYour first matrix is: \n" +
          str(pd.DataFrame(first_matrix, index=list('   '), columns=list('   '))))
    print("\nWe will now build the second matrix")
    second_matrix = np.array(matrix_builder(), dtype=int).reshape(3,3)
    print("\nYour second matrix is: \n" +
          str(pd.DataFrame(second_matrix, index=list('   '), columns=list('   '))))

    print("\nSelect a matrix operation from the list below:\n")
    print("a. Addition")
    print("b. Subtraction")
    print("c. Matrix multiplication")
    print("d. Element by element multiplication")

    while matrix_menu == "":
        matrix_menu = str(input("Please select one of the above options:\n"))
        match matrix_menu:
            case "a":
                final_matrix = np.add(first_matrix, second_matrix)
            case "b":
                final_matrix = np.subtract(first_matrix, second_matrix)
            case "c":
                final_matrix = np.matmul(first_matrix, second_matrix)
            case "d":
                final_matrix = np.multiply(first_matrix, second_matrix)
            case _:
                matrix_menu = ""
                print("\nInvalid option, please enter only a through d\n")

    print("Your final matrix is: \n" +
          str(pd.DataFrame(final_matrix, index=list('   '), columns=list('   '))) + "\n")
    print("Your final matrix, transposed, is: \n" +
          str(pd.DataFrame(np.transpose(final_matrix),
                           index=list('   '), columns=list('   '))) + "\n")
    print("The means of the rows are: \n" + str(get_mean(final_matrix, 'row')) + "\n")
    print("The means of the columns are: \n" + str(get_mean(final_matrix, 'col')) + "\n")

def matrix_game():
    """Generates a matrix based on user input"""
    input_cont = ""

    while input_cont != "n":
        input_cont = str(input("Do you want to play the matrix game? (y or n) "))
        if input_cont == "y":
            get_phone()
            get_zip()
            matrix_calc()
        elif input_cont not in ("y","n"):
            print(ERROR_BAD_INPUT)

def salt_password(user_input):
    """Salting function"""
    salted = []
    salt_odd = "123!@#45"
    salt_even = "6$%^789&"
    salt_time = 2

    for i in user_input:
        if salt_time % 2 == 0:
            salted.append(salt_even)
        else:
            salted.append(salt_odd)
        salted.append(i)

    salted_input = (''.join(salted))
    return salted_input

def password_calc():
    """Generate passwords after salting user input"""
    user_input = list(input("Please enter your new password! (no spaces)\n"))
    salted_input = salt_password(user_input).encode()

    print("\nSalting complete, uncrackable passwords coming at ya!\n")
    print("md5 -> \t\t\t" + hashlib.md5(salted_input).hexdigest())
    print("sha3_512 -> \t\t" + hashlib.sha3_512(salted_input).hexdigest())
    print("sha384 -> \t\t" + hashlib.sha384(salted_input).hexdigest())
    print("sha512 -> \t\t" + hashlib.sha512(salted_input).hexdigest())
    print("sha1 -> \t\t" + hashlib.sha1(salted_input).hexdigest())
    print("sha224 -> \t\t" + hashlib.sha224(salted_input).hexdigest())
    print("blake2s -> \t\t" + hashlib.blake2s(salted_input).hexdigest())
    print("blake2b -> \t\t" + hashlib.blake2b(salted_input).hexdigest())
    print("Shake_128 -> \t\t" + hashlib.shake_128(salted_input).hexdigest(20))
    print("Shake_256 -> \t\t" + hashlib.shake_256(salted_input).hexdigest(20))
    print("\nWhoa, that was a lot! See if anything can crack 'em!")

    print("\nAlright now we're going to offer up some different ones and try" +
          "if Crackstation can crack any of these\n")
    
    password_list = ["easyone", "pickles", "itssolate", "beingsicksucks",
                     "todayisApr14!","comingup with these can be hard",
                     "reBiyL5H2gUcrO5riS!N","f54cha6uDredlPAn!wra6wI#iDed4Q=t6OPrLtRl!AWu",
                     "b?I2","C-yuk5zlp0ltridruxOdo", salt_password("pickles"),
                     salt_password("lordimtired"),salt_password("this is good")]

    for i in password_list:
        print(i + ":");
        print(hashlib.md5(i.encode()).hexdigest())
        print(hashlib.sha256(i.encode()).hexdigest())
        print(hashlib.sha512(i.encode()).hexdigest() + "\n")

def main():
    """Main execution function"""
    selection = 0
    print("\nWelcome to Week 4's Program!\n")

    while selection != 3:
        print("\n1. Matrix calculator")
        print("2. Password calculator")
        print("3. Exit")

        try:
            selection = int(input("\nPlease select one of the above options:\n"))
            match selection:
                case 1:
                    matrix_game()
                case 2:
                    password_calc()
                case 3:
                    print("\nExiting...\nThank you for using this week's program!\n")
                case _:
                    print("\nInvalid option, please enter only integers 1 through 3\n")
        except ValueError:
            print(ERROR_NOT_INT)

main()