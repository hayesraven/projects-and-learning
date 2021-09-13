def is_isogram(string):
    # Checks for isogram in string
    for letter in string:  
        # The first test checks to see if there are more than one instance of a character in a string regardless of position or lettercase
        if (string.count(letter) > 1 or string.count(letter.swapcase()) > 1):
            return False;
        # The second test checks to see if a character exists exactly once in both cases, also failing as an isogram
        elif (string.count(letter) and string.count(letter.swapcase()) == True): 
            return False;
        # If both tests pass, the test moves to the next letter
        else:
            pass;
    return True;
