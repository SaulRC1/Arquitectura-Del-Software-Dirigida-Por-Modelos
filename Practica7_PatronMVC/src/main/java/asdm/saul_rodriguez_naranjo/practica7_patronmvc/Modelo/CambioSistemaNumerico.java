/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica7_patronmvc.Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SaulRC1
 */
public class CambioSistemaNumerico {

    private static CambioSistemaNumerico cambioSistemaNumerico
            = new CambioSistemaNumerico();

    private Map<String, String> hexadecimalKeys;

    ArrayList<String> numerosLeidosDesdeFichero;

    /**
     * Constructor privado para seguir patron Singleton
     */
    private CambioSistemaNumerico() {
        this.hexadecimalKeys = new HashMap<String, String>();

        for (int i = 0; i < 10; i++) {
            this.hexadecimalKeys.put(String.valueOf(i), String.valueOf(i));
        }

        this.hexadecimalKeys.put("10", "A");
        this.hexadecimalKeys.put("11", "B");
        this.hexadecimalKeys.put("12", "C");
        this.hexadecimalKeys.put("13", "D");
        this.hexadecimalKeys.put("14", "E");
        this.hexadecimalKeys.put("15", "F");

    }

    public static CambioSistemaNumerico getCambioSistemaNumericoInstance() {
        return CambioSistemaNumerico.cambioSistemaNumerico;
    }

    public String decimalAOctal(int decimal) {
        int numero = decimal;
        String resultadoEnOctal = "";

        while (numero >= 8) {
            resultadoEnOctal += numero % 8;
            numero = numero / 8;
            System.out.println(resultadoEnOctal);
        }

        resultadoEnOctal += numero;
        System.out.println(resultadoEnOctal);

        char[] resultadoReverse = resultadoEnOctal.toCharArray();

        resultadoEnOctal = "";

        for (int i = resultadoReverse.length - 1; i >= 0; i--) {
            resultadoEnOctal += resultadoReverse[i];
        }

        return resultadoEnOctal;
    }

    public String decimalAHexadecimal(int decimal) {
        int numero = decimal;
        String resultadoEnHexadecimal = "";

        while (numero >= 16) {
            //System.out.println(numero%16);
            resultadoEnHexadecimal += this.hexadecimalKeys.get(String.valueOf(numero % 16));
            numero = numero / 16;
            System.out.println(resultadoEnHexadecimal);
        }

        resultadoEnHexadecimal += numero;
        System.out.println(resultadoEnHexadecimal);

        char[] resultadoReverse = resultadoEnHexadecimal.toCharArray();

        resultadoEnHexadecimal = "";

        for (int i = resultadoReverse.length - 1; i >= 0; i--) {
            resultadoEnHexadecimal += resultadoReverse[i];
        }

        return resultadoEnHexadecimal;
    }

    public String decimalABinario(int decimal) {

        int numero = decimal;
        String resultadoEnBinario = "";

        while (numero >= 2) {
            resultadoEnBinario += numero % 2;
            numero = numero / 2;
            System.out.println(resultadoEnBinario);
        }

        resultadoEnBinario += numero;
        System.out.println(resultadoEnBinario);

        char[] resultadoReverse = resultadoEnBinario.toCharArray();

        resultadoEnBinario = "";

        for (int i = resultadoReverse.length - 1; i >= 0; i--) {
            resultadoEnBinario += resultadoReverse[i];
        }

        return resultadoEnBinario;
    }

    public void abrirFichero(File fichero) throws FileNotFoundException, IOException {
        this.numerosLeidosDesdeFichero = new ArrayList<>();

        BufferedReader ficheroDeLectura = new BufferedReader(new FileReader(fichero));
        String linea = "";

        while (linea != null) {

            linea = ficheroDeLectura.readLine();
            if (linea != null) {
                String[] separadoPorEspacios = linea.split(" ");
                System.out.println(separadoPorEspacios[1]);
                this.numerosLeidosDesdeFichero.add(separadoPorEspacios[1]);
            }

        }

        ficheroDeLectura.close();
    }

    public void escribirFichero(String path, ArrayList<String> datosAEscribir) throws IOException {

        File fichero = new File(path);

        FileWriter escribirFichero = new FileWriter(fichero);

        int index = 1;

        for (String dato : datosAEscribir) {
            escribirFichero.write(index + ": " + dato + "\n");
            index++;
        }

        escribirFichero.close();
    }

    public ArrayList<String> getNumerosLeidosDesdeFichero() {
        return this.numerosLeidosDesdeFichero;
    }
}
