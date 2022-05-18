import sys
"""
Name: Cameron Hayes
Date: 22MAR2022
Purpose: simulates a voter application form
"""

def cont_func ():
    """
    This function prompts the user if they want to continue processing
    their application and allows them to quit if they want
    """
    
    answer = ""
    while (answer != 'yes' or answer != 'no'):
        answer = str(input("Do you want to continue the voter registration? yes/no\n"))
        if answer == 'no':
            print("Goodbye!")
            sys.exit()
        elif answer == 'yes':
            return
        print("INVALID INPUT: Please only enter yes or no.")

print("Welcome to the Python Voter Registration Application\n")
cont_func()

#Ask the user for first name
FIRST_NAME = str(input("What is your first name?\n"))
cont_func()

#Ask the user for last name
LAST_NAME = str(input("What is your last name?\n"))
cont_func()

#Ask the user for age and check to make sure its a valid age
AGE = int(input("What is your age?\n"))
if (AGE > 99 or AGE < 18):
    print("We cannot process your application at this time.")
    sys.exit()
cont_func()

#Ask the user if they are a U.S. citizen and quit if they are not
CITIZENSHIP = str(input("Are you a U.S. citizen? yes/no \n"))
if CITIZENSHIP != 'yes':
    print("We cannot process your application at this time.")
    sys.exit()
cont_func()

#Ask the user for their state and validate its a valid string
STATE = str(input("What state do you live in?\n"))
if len(STATE) > 2:
    print("INVALID INPUT: Exiting...")
    sys.exit()
cont_func()

#Ask the user for their zipcode
ZIPCODE = str(input("What is your zipcode?\n"))

#Print the stored information
print("\nThanks for registering to vote. Here is the information we've received:\n")
print("Name: " + FIRST_NAME + " " + LAST_NAME)
print("Age: " + str(AGE))
print("U.S. Citizen: " + CITIZENSHIP)
print("State: " + STATE)
print("Zipcode: " + ZIPCODE)
print("Thanks for trying the Voter Registration Application. ")
print("Your voter registration card should be shipped within 3 weeks.")
