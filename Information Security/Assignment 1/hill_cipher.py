def det_inverse(input):
    possible_inverses = [1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25]
    if input not in possible_inverses:
        raise Exception(f"inverse for determinant {input} does not exist. There are only 12 possibilties for the determinant: 1,3,5,7,9,11,15,17,19,21,23,25.")

    for inverse in range(1, 27):
        check = (input * inverse) % 26
        if (check == 1):
            return inverse


def get_matrix_inverse(m):

    determinant = (m[0][0]*m[1][1]-m[0][1]*m[1][0]) % 26;
    
    # determinant should be between 0 - 26
    if(determinant < 0):
        determinant = 26 + determinant
    

    print(determinant)
    det_inv = det_inverse(determinant)
    print(det_inv)

    # for 2x2 matrix the elements other than diagonal matrix becomes negative, so keep its value in between 0 - 26
    m[0][1] = 26 - m[0][1] 
    m[1][0] = 26 - m[1][0] 


    return [[(m[1][1] * det_inv) % 26, (m[0][1] * det_inv) % 26],
            [(m[1][0] * det_inv) % 26, (m[0][0] * det_inv) % 26]]


def hill_cipher(key_matrix, input_matrix):

    num_of_cols = len(input_matrix[0])
    output_matrix = [[0] * num_of_cols for x in range(2)]

    for row in range(2):
        for col in range(num_of_cols):
            output_matrix[row][col] = 0
            for i in range(2):
                output_matrix[row][col] += (key_matrix[row][i] * input_matrix[i][col]) 
            output_matrix[row][col] %= 26;

    return output_matrix



def main(plain_text, key):

    size = len(plain_text) // 2
    key_matrix = [[0] * 2 for x in range(2)]
    plain_text_matrix = [[0] * size for x in range(2)]

    index = 0
    for row in range(2):
        for col in range(2):
            key_matrix[row][col] = ord(key[index]) % 65;
            index += 1

    index1 = 0
    for row in range(2):
        for col in range(size):
            plain_text_matrix[row][col] = ord(plain_text[index1]) % 65
            index1 += 1

    encrypted_matrix = hill_cipher(key_matrix, plain_text_matrix)
    encrypted_text = ""
    for row in range(2):
        for col in range(len(encrypted_matrix[0])):
            encrypted_text += chr(encrypted_matrix[row][col] + 65)
    print("Encrypted Text: ", encrypted_text)
    
    decrypted_matrix = hill_cipher(get_matrix_inverse(key_matrix), encrypted_matrix)
    decrypted_text = ""
    for row in range(2):
        for col in range(len(decrypted_matrix[0])):
            decrypted_text += chr(decrypted_matrix[row][col] + 65)
    print("Decrypted Text: ", decrypted_text)    
     

if __name__ == '__main__':

    plain_text = input("Enter the message: ")
    if (len(plain_text) % 2) != 0:
        plain_text += "X"

    key = input("Enter the 4 length key for 2 X 2 matrix: ")
    main(plain_text, key)

      


    