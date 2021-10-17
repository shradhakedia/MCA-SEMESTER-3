import math

from hill_cipher import main

def affine_encrypt(plain_text, a, b):

    encrypted_text = ""
    for character in plain_text[:]:
        if(character.isupper()):
            encrypted_text += chr((a * (ord(character) - 65) + b) % 26 + 65)
        elif(character.islower()):
            encrypted_text += chr((a * (ord(character) - 97) + b) % 26 + 97)
        else:
            encrypted_text += character

    return encrypted_text

def affine_decrypt(encrypted_text, a, b):
    
    decrypted_text = ""
    for character in encrypted_text[:]:
        if(character.isupper()):
            decrypted_text += chr((affine_inverse(a) * (ord(character) - 65 - b)) % 26 + 65)
        elif(character.islower()):
            decrypted_text += chr((affine_inverse(a) * (ord(character) - 97 - b)) % 26 + 97)
        else:
            decrypted_text += character

    return decrypted_text


def affine_inverse(a):

    for a_inverse in range(1, 27):
        check = (a * a_inverse) % 26
        if (check == 1):
            return a_inverse
    

if __name__ == '__main__':

    plain_text = input("Enter the plain text: ")
    a = int(input("Enter a (coprime to 26, not equal to 1): "))

    if(math.gcd(a, 26) != 1):
        raise Exception("Wrong value of 'a' Entered.")

    b = int(input("Enter b: "))
    print("\n----Performing Cipher----")
    encrypted_text = affine_encrypt(plain_text, a, b)
    print(f"encrypted text: {encrypted_text}")
    print("\n----Performing Decipher----")
    decrypted_text = affine_decrypt(encrypted_text, a, b)
    print(f"decrypted text: {decrypted_text} \n")



