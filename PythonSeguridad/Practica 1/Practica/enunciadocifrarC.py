def cifradoCesarAlfabetoInglesMAY(cadena, n):
    """Devuelve un cifrado Cesar Generalizado (+n)"""
    # Definir la nueva cadena resultado
    resultado = ''
    # Realizar el "cifrado", sabiendo que A = 65, Z = 90, a = 97, z = 122
    i = 0
    while i < len(cadena):
        # Recoge el caracter a cifrar
        ordenClaro = ord(cadena[i])
        ordenCifrado = 0
        # Cambia el caracter a cifrar
        if (ordenClaro >= 65 and ordenClaro <= 90):
            ordenCifrado = (((ordenClaro - 65) + int(n)) % 26) + 65
        # Añade el caracter cifrado al resultado
        if (ordenClaro >= 97 and ordenClaro <= 122):
            ordenCifrado = (((ordenClaro - 97) + int(n)) % 26) + 97

        resultado = resultado + chr(ordenCifrado)
        i = i + 1
    # devuelve el resultado
    return resultado

claroCESARMAY = 'veni vidi vinci auria'
print(claroCESARMAY)
print("Introduce un cifrado: ")
n = input()
cifradoCESARMAY = cifradoCesarAlfabetoInglesMAY(claroCESARMAY,n)
print(cifradoCESARMAY)
