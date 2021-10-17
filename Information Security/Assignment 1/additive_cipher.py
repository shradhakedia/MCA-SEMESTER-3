def additive_encrypt(plain_text, shift):

    encrypted_text = ""
    for character in plain_text[:]:
        if(character.islower()):
            encrypted_text += chr((ord(character) + shift - 97) % 26 + 97)
        elif(character.isupper()):
            encrypted_text += chr((ord(character) + shift - 65) % 26 + 65)
        else:
            encrypted_text += character    

    return encrypted_text


def additive_decrypt():

    decrypted_text = ""
    for character in encrypted_text[:]:
        if(character.islower()):
            decrypted_text += chr((ord(character) - shift - 97) % 26 + 97)
        elif(character.isupper()):
            decrypted_text += chr((ord(character) - shift - 65) % 26 + 65)
        else:
            decrypted_text += character   

    return decrypted_text

if __name__ == '__main__':
    
    plain_text = input("Enter the plain text: ")
    shift = int(input("Enter the additive number to shift: "));
    print(f"Plain Text: {plain_text}")
    encrypted_text = additive_encrypt(plain_text, shift)
    print(f"Ciphered Text: {encrypted_text}")
    print(f"Deciphered Text: {additive_decrypt()} \n")