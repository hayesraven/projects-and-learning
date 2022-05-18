"""
Name: Cameron Hayes
Date: 17APR2022
Title: Week 5 Graded Lab
Purpose: Menu driven program to perform analysis on CSVs
"""
import matplotlib.pyplot as plt
import pandas as pd

ERROR_NOT_INT = "ERROR: Invalid input, please enter only integers"
HOUSING_FILE = pd.read_csv(r'C:\Users\hayes\OneDrive\Desktop\Code\SDEV300\Week5\Housing.csv')
POPCHANGE_FILE = pd.read_csv(r'C:\Users\hayes\OneDrive\Desktop\Code\SDEV300\Week5\PopChange.csv')

def statistics_display(file, col, orig):
    """Function used to display statistics"""
    print("Statistics for column " + str(col) + ":")
    print("Count: " + str(round(file[col].count(), 3)))
    print("Mean: " + str(round(file[col].mean(), 3)))
    print("Standard Deviation: " + str(round(file[col].std(), 3)))
    print("Min: " + str(round(file[col].min(), 3)))
    print("Max: " + str(round(file[col].max(), 3)))
    print("The histogram for this column is now displayed.\n")
    if orig == 'Pop':
        file = file[(file[col] > file[col].quantile(0.01)) & (file[col] < file[col].quantile(0.99))]
    file.hist(column=col)
    plt.show()

def population_menu():
    """Menu function for population analysis"""
    selection = 0
    print("\nYou've selected population analysis.\n")

    while selection != 4:
        print("1. Pop Apr 1")
        print("2. Pop Jul 1")
        print("3. Change Pop")
        print("4. Return to Main Menu")

        try:
            selection = int(input("\nPlease select an option:\n"))
            match selection:
                case 1:
                    statistics_display(POPCHANGE_FILE, 'Pop Apr 1', 'Pop')
                case 2:
                    statistics_display(POPCHANGE_FILE, 'Pop Jul 1', 'Pop')
                case 3:
                    statistics_display(POPCHANGE_FILE, 'Change Pop', 'Pop')
                case 4:
                    print("\nReturning to main menu...")
                case _:
                    print("\nInvalid option, please enter only integers 1 through 4\n")
        except ValueError:
            print(ERROR_NOT_INT)

def housing_menu():
    """Menu function for housing analysis"""
    selection = 0
    print("\nYou've selected housing analysis.\n")

    while selection != 6:
        print("1. AGE")
        print("2. BEDRMS")
        print("3. BUILT")
        print("4. ROOMS")
        print("5. UTILITY")
        print("6. Return to Main Menu")

        try:
            selection = int(input("\nPlease select an option:\n"))
            match selection:
                case 1:
                    statistics_display(HOUSING_FILE, 'AGE', 'House')
                case 2:
                    statistics_display(HOUSING_FILE, 'BEDRMS', 'House')
                case 3:
                    statistics_display(HOUSING_FILE, 'BUILT', 'House')
                case 4:
                    statistics_display(HOUSING_FILE, 'ROOMS', 'House')
                case 5:
                    statistics_display(HOUSING_FILE, 'UTILITY', 'House')
                case 6:
                    print("\nReturning to main menu...")
                case _:
                    print("\nInvalid option, please enter only integers 1 through 6\n")
        except ValueError:
            print(ERROR_NOT_INT)

def main():
    """Main execution"""
    selection = 0

    while selection != 3:
        print("1. Population Data")
        print("2. Housing Data")
        print("3. Exit")

        try:
            selection = int(input("\nPlease select the file you want to analyze:\n"))
            match selection:
                case 1:
                    population_menu()
                case 2:
                    housing_menu()
                case 3:
                    print("\nExiting...\nThank you for using this week's program!\n")
                case _:
                    print("\nInvalid option, please enter only integers 1 through 3\n")
        except ValueError:
            print(ERROR_NOT_INT)

print("\nWelcome to Week 5's Program!\n")
main()