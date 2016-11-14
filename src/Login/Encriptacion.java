/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.util.Random;

/**
 *
 * @author aleja_000
 */
public class Encriptacion {
    char[] datos;
    
    public Encriptacion(){
        datos = new char[100];
        datos[0] = 'A';
        datos[1] = 'B';
        datos[2] = 'C';
        datos[3] = 'D';
        datos[4] = 'E';
        datos[5] = 'F';
        datos[6] = 'G';
        datos[7] = 'H';
        datos[8] = 'I';
        datos[9] = 'J';
        datos[10] = 'K';
        datos[11] = 'L';
        datos[12] = 'M';
        datos[13] = 'N';
        datos[14] = 'O';
        datos[15] = 'P';
        datos[16] = 'Q';
        datos[17] = 'R';
        datos[18] = 'S';
        datos[19] = 'T';
        datos[20] = 'U';
        datos[21] = 'V';
        datos[22] = 'W';
        datos[23] = 'X';
        datos[24] = 'Y';
        datos[25] = 'Z';
        datos[26] = 'a';
        datos[27] = 'b';
        datos[28] = 'c';
        datos[29] = 'd';
        datos[30] = 'e';
        datos[31] = 'f';
        datos[32] = 'g';
        datos[33] = 'h';
        datos[34] = 'i';
        datos[35] = 'j';
        datos[36] = 'k';
        datos[37] = 'l';
        datos[38] = 'm';
        datos[39] = 'n';
        datos[40] = 'o';
        datos[41] = 'p';
        datos[42] = 'q';
        datos[43] = 'r';
        datos[44] = 's';
        datos[45] = 't';
        datos[46] = 'u';
        datos[47] = 'v';
        datos[48] = 'w';
        datos[49] = 'x';
        datos[50] = 'y';
        datos[51] = 'z';
        datos[52] = '0';
        datos[53] = '1';
        datos[54] = '2';
        datos[55] = '3';
        datos[56] = '4';
        datos[57] = '5';
        datos[58] = '6';
        datos[59] = '7';
        datos[60] = '8';
        datos[61] = '9';
        datos[62] = '[';
        datos[63] = '*';
        datos[64] = ']';
        datos[65] = '^';
        datos[66] = '_';
        datos[67] = '{';
        datos[68] = '|';
        datos[69] = '}';
        datos[70] = '~';
        datos[71] = '!';
        datos[72] = '"';
        datos[73] = '#';
        datos[74] = '$';
        datos[75] = '%';
        datos[76] = '&';
        datos[77] = '+';
        datos[78] = '(';
        datos[79] = ')';
        datos[80] = '*';
        datos[81] = '+';
        datos[82] = ',';
        datos[83] = '-';
        datos[84] = '.';
        datos[85] = '/';
        datos[86] = ':';
        datos[87] = ';';
        datos[88] = '<';
        datos[89] = '=';
        datos[90] = '>';
        datos[91] = '?';
        datos[92] = '@';
        datos[93] = '`';
        datos[94] = '¿';
        datos[95] = '®';
        datos[96] = '¶';
        datos[97] = '«';
        datos[98] = '»';
        datos[99] = '¡';
    }
    
    public String encriptar(String dato){
        
        String datoEncriptado = "";
        char[] datoParticionado = explode(dato);
        Random indice = new Random();
        int peso1 = (int) (indice.nextDouble() * 100 );
        int peso2 = (int) (indice.nextDouble() * 100 );
        int peso3 = (int) (indice.nextDouble() * 100 );
        
        System.out.println(peso1);
        System.out.println(peso2);
        System.out.println(peso3);
        int tamañoCadena = dato.length();
        int[] posicionesContrasena = new int[tamañoCadena];
        
        for (int i = 0; i < tamañoCadena; i++) {
            posicionesContrasena[i] = encontrarPosicion(datoParticionado[i]);
        }

        int posicion = 0;
        int iteracion = 1;
        for (int i = 0; i < tamañoCadena; i++) {
            switch (iteracion) {
                case 1:
                    while (posicion < peso1 ){
                        if (posicionesContrasena[i] > 98){
                            posicionesContrasena[i] = 0;
                        }
                        else {
                            posicionesContrasena[i] = posicionesContrasena[i] + 1;
                        }
                        posicion = posicion + 1;
                    }   posicion = 0;
                    iteracion = 2;
                    break;
                case 2:
                    while (posicion < peso2 ){
                        if (posicionesContrasena[i] > 98){
                            posicionesContrasena[i] = 0;
                        }
                        else {
                            posicionesContrasena[i] = posicionesContrasena[i] + 1;
                        }
                        posicion = posicion + 1;
                    }   posicion = 0;
                    iteracion = 3;
                    break;
                default:
                    iteracion = 1;
                    while (posicion < peso3 ){
                        if (posicionesContrasena[i] > 98){
                            posicionesContrasena[i] = 0;
                        }
                        else {
                            posicionesContrasena[i] = posicionesContrasena[i] + 1;
                        }
                        posicion = posicion + 1;
                    }   posicion = 0;
                    break;
            }
        }
        
        char[] datoReconstruido = new char[tamañoCadena*2];
        
        for (int i = 0; i < tamañoCadena; i++){
            datoReconstruido[i] = datos[posicionesContrasena[i]];
        }
        for (int i = tamañoCadena; i < tamañoCadena*2; i++){
            datoReconstruido[i] = datos[(int) (indice.nextDouble() * 100)];
        }
        
        tamañoCadena = datoReconstruido.length;
        
        posicionesContrasena = new int[tamañoCadena];
        
        for (int i = 0; i < tamañoCadena; i++) {
            posicionesContrasena[i] = encontrarPosicion(datoReconstruido[i]);
        }

        iteracion = 1;
        posicion = 0;
        for (int i = 0; i < tamañoCadena; i++) {
            switch (iteracion) {
                case 1:
                    while (posicion < (tamañoCadena*peso1) ){
                        if (posicionesContrasena[i] > 98){
                            posicionesContrasena[i] = 0;
                        }
                        else {
                            posicionesContrasena[i] = posicionesContrasena[i] + 1;
                        }
                        posicion = posicion + 1;
                    }   posicion = 0;
                    iteracion = 2;
                    break;
                case 2:
                    while (posicion < (tamañoCadena*peso2) ){
                        if (posicionesContrasena[i] > 98){
                            posicionesContrasena[i] = 0;
                        }
                        else {
                            posicionesContrasena[i] = posicionesContrasena[i] + 1;
                        }
                        posicion = posicion + 1;
                    }   posicion = 0;
                    iteracion = 3;
                    break;
                default:
                    iteracion = 1;
                    while (posicion < (tamañoCadena*peso3) ){
                        if (posicionesContrasena[i] > 98){
                            posicionesContrasena[i] = 0;
                        }
                        else {
                            posicionesContrasena[i] = posicionesContrasena[i] + 1;
                        }
                        posicion = posicion + 1;
                    }   posicion = 0;
                    break;
            }
        }
        
        datoReconstruido = new char[tamañoCadena+(tamañoCadena/2)];
        
        int contador = 0;
        for (int i = 0; i < datoReconstruido.length; i = i + 3) {
            datoReconstruido[i] = datos[posicionesContrasena[contador]];
            contador = contador + 1;
        }
        
        for (int i = 1; i < datoReconstruido.length; i = i + 3) {
            datoReconstruido[i] = datos[posicionesContrasena[contador]];
            contador = contador +1;
        }
        for (int i = 2; i < datoReconstruido.length; i = i + 3) {
            datoReconstruido[i] = datos[(int) (indice.nextDouble() * 100)];
        }
        
        datoEncriptado = String.valueOf(datoReconstruido);
        return datoEncriptado;
         
    }
    
    private char[] explode(String cadena){
        char[] resultado = new char[cadena.length()];
        for (int i=0; i<cadena.length(); i++){
            resultado[i] = cadena.charAt(i);
        }
        return resultado;
    }
    
    public int encontrarPosicion(char cadena){
        
        int retorno = 0;
        
        for (int i= 0; i < datos.length; i++){
            if (datos[i] == cadena) {
                retorno = i;
                break;
            }
        }
        
        return retorno;
    }
    
    public String desencriptar(int peso1, int peso2, int peso3, String contrasena){
        String datoEncriptado = "";
        
        char[] encriptado = explode(contrasena);
        char[] extraer = new char[(encriptado.length/3)];
        int contador = 0;
        for(int i = 0; i < extraer.length; i++){
            extraer[i] = encriptado[contador];
            contador = contador + 3;
        }
        int[] posicionesContrasena = new int[extraer.length];
        
        for (int i = 0; i < extraer.length; i++) {
            posicionesContrasena[i] = encontrarPosicion(extraer[i]);
        }
        
        int x1 = ((extraer.length*2 + 1)*peso1);
        int x2 = ((extraer.length*2 + 1)*peso2);
        int x3 = ((extraer.length*2 + 1)*peso3);
        int posicion = 0;
        int iteracion = 1;
        for (int i = 0; i < extraer.length; i++) {
            switch (iteracion) {
                case 1:
                    while (posicion < x1){
                        if (posicionesContrasena[i] < 1){
                            posicionesContrasena[i] = 99;
                        }
                        else {
                            posicionesContrasena[i] = posicionesContrasena[i] - 1;
                        }
                        posicion = posicion + 1;
                    }   posicion = 0;
                    iteracion = 2;
                    break;
                case 2:
                    while (posicion < x2){
                        if (posicionesContrasena[i] < 1){
                            posicionesContrasena[i] = 99;
                        }
                        else {
                            posicionesContrasena[i] = posicionesContrasena[i] - 1;
                        }
                        posicion = posicion + 1;
                    }   posicion = 0;
                    iteracion = 3;
                    break;
                default:
                    iteracion = 1;
                    while (posicion < x3){
                        if (posicionesContrasena[i] < 1){
                            posicionesContrasena[i] = 99;
                        }
                        else {
                            posicionesContrasena[i] = posicionesContrasena[i] - 1;
                        }
                        posicion = posicion + 1;
                    }   posicion = 0;
                    break;
            }
        }
        char[] datoReconstruido = new char[extraer.length];
        
        for (int i = 0; i < datoReconstruido.length; i++){
            datoReconstruido[i] = datos[posicionesContrasena[i]];
        }
      
        datoEncriptado = String.valueOf(datoReconstruido);
        return datoEncriptado;
    }
}
