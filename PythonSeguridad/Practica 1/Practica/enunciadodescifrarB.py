def descifradoCesarAlfabetoInglesMAY(cadena):

    # Definir la nueva cadena resultado
    resultado = ''
    # Realizar el "descifrado", sabiendo que A = 65, Z = 90, a = 97, z = 122
    i = 0
    while i < len(cadena):
        # Recoge el caracter a cifrar
        ordenClaro = ord(cadena[i])
        ordenDescifrado = 0
        # Cambia el caracter a cifrar
        if (ordenClaro >= 65 and ordenClaro <= 90):
            ordenDescifrado = (((ordenClaro - 65) - 3) % 26) + 65

        if (ordenClaro >= 97 and ordenClaro <= 122):
            ordenDescifrado = (((ordenClaro - 97) - 3) % 26) + 97
        # Añade el caracter cifrado al resultado
        resultado = resultado + chr(ordenDescifrado)
        i = i + 1
    # devuelve el resultado
    return resultado

claroCESARMAY = 'veni vidi vinci auria'
print(claroCESARMAY)
cifradoCESARMAY = descifradoCesarAlfabetoInglesMAY(claroCESARMAY)
print(cifradoCESARMAY)
