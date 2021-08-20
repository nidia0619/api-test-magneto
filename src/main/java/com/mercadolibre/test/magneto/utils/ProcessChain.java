package com.mercadolibre.test.magneto.utils;

public class ProcessChain {

    /**
     * Metodo que verifica que la secuencia del ADN sea la correcta
     *
     * @param str - Array de String con el ADN
     * @param validate - campo que trae las letras que se pueden usar para la
     * validacion de cada base nitrogenada del ADN
     * @return Verdadero si cumple con la validacion, false si no
     */
    public static boolean validate(String[] str, String validate) {
        for (String s : str) {
            char[] charArray = s.toCharArray();
            if (charArray.length > 0 && charArray.length == str[0].toCharArray().length) {
                for (char c : charArray) {
                    if (!validate.contains(String.valueOf(c))) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo que realiza la conversion de un array de String a una matriz de
     * (NxN)
     *
     * @param str - Array de String con el ADN
     * @return Matriz donde cada fila es un valor del array de String y las
     * columnas con la longitud de ese String
     */
    public static char[][] convertArray(String[] str) {
        char m[][] = new char[str.length][str.length];
        for (int i = 0; i < str.length; i++) {
            char[] charArray = str[i].toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                m[i][j] = charArray[j];
            }
        }
        return m;
    }

    /**
     * Metodo que se encarga de indicar si un humano es mutante, verificando su
     * secuencia de cuatro letras iguales​, de forma oblicua, horizontal o
     * vertica
     *
     * @param m - Matriz con las secuencias de todo el ADN
     * @return Verdadero si es mutante, false si es humano
     */
    public static boolean isMutant(char[][] m) {
        int sum = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length - 3; j++) {
                if (m[i][j] == m[i][j + 1] && m[i][j] == m[i][j + 2] && m[i][j] == m[i][j + 3]) {
                    sum++;
                }
                if (m[j][i] == m[j + 1][i] && m[j][i] == m[j + 2][i] && m[j][i] == m[j + 3][i]) {
                    sum++;
                }
                if (i < m.length - 3) {
                    if (m[i][j] == m[i + 1][j + 1] && m[i][j] == m[i + 2][j + 2] && m[i][j] == m[i + 3][j + 3]) {
                        sum++;
                    }
                }
                if (i >= m.length - 3) {
                    if (m[i][j] == m[i - 1][j + 1] && m[i][j] == m[i - 2][j + 2] && m[i][j] == m[i - 3][j + 3]) {
                        sum++;
                    }
                }
            }
        }
        return (sum >= 2);
    }
}
