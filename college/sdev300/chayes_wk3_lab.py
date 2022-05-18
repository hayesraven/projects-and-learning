"""
Name: Cameron Hayes
Date: 04APR2022
Title: Week 3 Graded Lab
Purpose: Menu driven program with information about the states,
allows user to edit info and pull images.
"""
import matplotlib.pyplot as plt
import matplotlib.image as mpimg
from chayes_wk3_lab_data_file import states

"""Constants"""
ERROR_NOT_INT = "ERROR: Please enter only an integer"

def get_input():
    """Allows user to search for a state"""
    str_input = ""
    """Executes until user selects a state that matches one in the dictionary, 
    or until the user chooses to abandon the selection or provides invalid input"""
    while str_input != "n":
        str_input = str(input("\nPlease enter the state you are looking for: "))
        for key, value in states.items():
            if str_input.lower() == value.get('name').lower():
                return key
        str_input = str(input("State not found, would you like to try again?(y/n) "))
        if str_input not in ("y","n"):
            print("\nInvalid input, returning to main menu...\n")
            return 0
    print("\nAcknowledged, returning to main menu...\n")
    return 0

def display_states():
    """Displays all states and their stored information"""
    """Lambda used in place of identify function"""
    for j in sorted(states, key=lambda x: (states[x]['name'])):
        for key, value in states.items():
            if j == key:
                print("Name: " + value.get('name') +
                      "\nCapital: " + value.get('capital') +
                      "\nPopulation: " + str(value.get('population')) +
                      "\nFlower: " + value.get('flower') + "\n")

def search_state():
    """Searches for the requested state, pulls all info and
    displays a picture of the state flower"""
    tmp_int = get_input()
    if tmp_int != 0:
        print("Requested State: " + states[tmp_int].get('name') +
              "\nCapital: " + states[tmp_int].get('capital') +
              "\nPopulation: " + str(states[tmp_int].get('population')) +
              "\nFlower: " + states[tmp_int].get('flower') + "\n")
        plt.imshow(mpimg.imread(states[tmp_int].get('image')))
        plt.show()

def graph_state():
    """Pulls the top five most populated states and displays a bar graph"""
    tmp_int = 0
    bar_names = []
    bar_values = []
    """Sorts the dictionary based highest population values and
    then pulls the top five for bar graph display"""
    for j in sorted(states, key=lambda x: (states[x]['population']), reverse=True):
        for key, value in states.items():
            if j == key:
                bar_names.append(value.get('name'))
                bar_values.append(value.get('population') / 1000000)
        tmp_int += 1
        if tmp_int == 5:
            break
    plt.bar(bar_names,bar_values)
    plt.title('Top Five Most Populated States')
    plt.xlabel('States')
    plt.ylabel('Population(millions)')
    plt.ylim(0, 50)
    plt.show()

def update_state():
    """Searches for the requested state and allows the user to update the population value"""
    tmp_int = get_input()
    if tmp_int != 0:
        print("Requested State: " + states[tmp_int].get('name') +
              "\nCurrent Population: " + str(states[tmp_int].get('population')) + "\n")

        """Takes population input from user and validates if its less than one 
        or invalid input"""
        while True:
            try:
                population = int(input("Enter the updated population:\n"))
                if population >= 1:
                    break
                print("Population must be 1 or greater")
            except ValueError:
                print(ERROR_NOT_INT)

        states[tmp_int]['population'] = population

        print("Population updated!\n")
        print("Requested State: " + states[tmp_int].get('name') +
              "\nCurrent Population: " + str(states[tmp_int].get('population')) + "\n")

def main():
    """Main execution function"""
    selection = 0

    print("\nWelcome to the state program!\n")

    while selection != 5:
        print("Available options:\n")
        print("1. Display all states")
        print("2. Search for a state")
        print("3. Show the top five populated states")
        print("4. Update the population for a state")
        print("5. Exit program\n")

        try:
            selection = int(input("Please select one of the above options:\n"))
            match selection:
                case 1:
                    display_states()
                case 2:
                    search_state()
                case 3:
                    graph_state()
                case 4:
                    update_state()
                case 5:
                    print("\nExiting...\nThank you for using the state program!\n")
                case _:
                    print("\nInvalid option, please enter only integers 1 through 6\n")
        except ValueError:
            print(ERROR_NOT_INT)

main()