from copy import copy


def freuency_attack(S, N):
     
    plaintext = [None] * 10
     
    frequency_array = [0] * 26
     
    # Store which alphabet is used already
    used = [0] * 26
     
    # Traverse the string S
    for i in range(N):
        if S[i] != ' ':
            frequency_array[ord(S[i]) - 65] += 1

    reverse_sorted_freq_array = copy(frequency_array)    
    # Sort the array in descending order
    reverse_sorted_freq_array.sort(reverse = True)

    # Stores the string formed from
    # concatanating the english letters
    # in the decreasing frequency in the
    # english language    
    T = "ETAOINSHRDLCUMWFGYPBVKJXQZ"    
     
    # Itearate over the range [0, 10]
    for i in range(10):
        ch = -1
         
        # Iterate over the range [0, 26]
        for j in range(26):
            if reverse_sorted_freq_array[i] == frequency_array[j] and used[j] == 0:
                used[j] = 1
                ch = j
                break
             
        if ch == -1:
            break
         
        # Store the numerical equivalent of letter
        # at ith index of array letter_frequency
        x = ord(T[i]) - 65
         
        # Calculate the probable shift used
        # in monoalphabetic cipher
        x = x - ch
         
        # Temporary string to generate one
        # plaintext at a time
        curr = ""
         
        # Generate the probable ith plaintext
        # string using the shift calculated above
        for k in range(N):
             
            # Insert whitespaces as it is
            if S[k] == ' ':
                curr += " "
                continue
             
            # Shift the kth letter of the
            # cipher by x
            y = ord(S[k]) - 65
            y += x
             
            if y < 0:
                y += 26
            if y > 25:
                y -= 26
             
            # Add the kth calculated/shifted
            # letter to temporary string    
            curr += chr(y + 65)
             
        plaintext[i] = curr
     
    # Print the generated 10 possible plaintexts    
    for i in range(10):
        print(plaintext[i])
 
 
if __name__ == "__main__":

    input = input("Enter the cipher text you want to attack on:")
    
    freuency_attack(input, len(input))