def cifradoMonoAlfabetico(cadena):
    # Definir la nueva cadena resultado
    resultado = ''
    clave = 'CIFRA'
    # Realizar el "cifrado", sabiendo que A = 65, Z = 90, a = 97, z = 122
    i = 0
    j = 0
    while i < len(cadena):
        # Recoge el caracter a cifrar
        ordenClaro = ord(cadena[i])
        ordenCifrado = 0
        ordcifra = ord(clave[j])
        # Cambia el caracter a cifrar
        if (ordenClaro >= 65 and ordenClaro <= 90):
            ordenCifrado = (((ordenClaro - 65) + (ordcifra - 65)) % 26) + 65
            j = j + 1

        if j > 4
            j = j - 5

        resultado = resultado + chr(ordenCifrado)
        i = i + 1
    # devuelve el resultado
    return resultado

claroCESARMAY = 'HOLAAMIGOS'
print(claroCESARMAY)
cifradoCESARMAY = cifradoMonoAlfabetico(claroCESARMAY)
print(cifradoCESARMAY)
