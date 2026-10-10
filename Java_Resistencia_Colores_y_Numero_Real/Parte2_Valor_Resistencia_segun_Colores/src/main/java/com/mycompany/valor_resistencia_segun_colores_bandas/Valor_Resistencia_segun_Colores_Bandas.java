
package com.mycompany.valor_resistencia_segun_colores_bandas;

import java.util.Scanner;

/*
 * VALOR DE UNA RESISTENCIA SEGUN LOS COLORES DE SUS BANDAS
 * ---------------------------------------------------------
 * Es la version "al reves" del programa visto en clase
 * (Colores_bandas_segun_valor_Resistencia_Varios2):
 *   - En clase : se ingresaban NUMEROS y se mostraban los COLORES.
 *   - Aqui     : se ingresan los NOMBRES de los colores y el programa
 *                calcula el VALOR de la resistencia en Ohm.
 *
 *   Valor = (numero banda 1 x 10 + numero banda 2) x 10^(numero banda 3)
 *   Ejemplo: amarillo(4) violeta(7) rojo(2) -> 47 x 10^2 = 4700 Ohm
 */
public class Valor_Resistencia_segun_Colores_Bandas
{

    public static void main(String[] args)
    {
        Scanner datos = new Scanner(System.in);   // para leer lo que se escribe en el teclado
        byte opc = 0;                             // 0 = seguir, 1 = terminar

        System.out.print("===== VALOR DE UNA RESISTENCIA SEGUN SUS COLORES =====");
        System.out.print("\nColores validos (escribalos sin tildes):");
        System.out.print("\n  negro, marron, rojo, naranja, amarillo,");
        System.out.print("\n  verde, azul, violeta, gris, blanco");
        System.out.print("\n  (en la Tercera Banda tambien: dorado y plateado)\n");

        while(opc==0)
        {
            String colorb1, colorb2, colorb3;     // colores que escribe el usuario
            int ncb1 = 0, ncb2 = 0, ncb3 = 0;     // numero que le corresponde a cada color
            int sw = 0;                           // 0 = colores correctos, 1 = hubo un error

            // ---------- ENTRADA: se leen los NOMBRES de los colores ----------
            // toLowerCase() pasa todo a minusculas: "ROJO" y "Rojo" quedan como "rojo"
            System.out.print("\nIngrese el color de la Primera Banda: ");
            colorb1 = datos.next().toLowerCase();
            System.out.print("Ingrese el color de la Segunda Banda: ");
            colorb2 = datos.next().toLowerCase();
            System.out.print("Ingrese el color de la Tercera Banda: ");
            colorb3 = datos.next().toLowerCase();

            // ---------- PROCESO 1: convertir cada color en su numero ----------
            switch(colorb1)
            {
                case "negro":    ncb1 = 0;
                                 break;
                case "marron":   ncb1 = 1;
                                 break;
                case "rojo":     ncb1 = 2;
                                 break;
                case "naranja":  ncb1 = 3;
                                 break;
                case "amarillo": ncb1 = 4;
                                 break;
                case "verde":    ncb1 = 5;
                                 break;
                case "azul":     ncb1 = 6;
                                 break;
                case "violeta":  ncb1 = 7;
                                 break;
                case "gris":     ncb1 = 8;
                                 break;
                case "blanco":   ncb1 = 9;
                                 break;
                default: sw = 1;
                         System.out.print("\n * El color de la Primera Banda ("
                                          + colorb1 + ") No es valido");
            }
            switch(colorb2)
            {
                case "negro":    ncb2 = 0;
                                 break;
                case "marron":   ncb2 = 1;
                                 break;
                case "rojo":     ncb2 = 2;
                                 break;
                case "naranja":  ncb2 = 3;
                                 break;
                case "amarillo": ncb2 = 4;
                                 break;
                case "verde":    ncb2 = 5;
                                 break;
                case "azul":     ncb2 = 6;
                                 break;
                case "violeta":  ncb2 = 7;
                                 break;
                case "gris":     ncb2 = 8;
                                 break;
                case "blanco":   ncb2 = 9;
                                 break;
                default: sw = 1;
                         System.out.print("\n * El color de la Segunda Banda ("
                                          + colorb2 + ") No es valido");
            }
            // La Tercera Banda es el MULTIPLICADOR: ncb3 es la potencia de 10
            switch(colorb3)
            {
                case "negro":    ncb3 = 0;      // x 1
                                 break;
                case "marron":   ncb3 = 1;      // x 10
                                 break;
                case "rojo":     ncb3 = 2;      // x 100
                                 break;
                case "naranja":  ncb3 = 3;      // x 1 000
                                 break;
                case "amarillo": ncb3 = 4;      // x 10 000
                                 break;
                case "verde":    ncb3 = 5;      // x 100 000
                                 break;
                case "azul":     ncb3 = 6;      // x 1 000 000
                                 break;
                case "violeta":  ncb3 = 7;      // x 10 000 000
                                 break;
                case "gris":     ncb3 = 8;      // x 100 000 000
                                 break;
                case "blanco":   ncb3 = 9;      // x 1 000 000 000
                                 break;
                case "dorado":   ncb3 = -1;     // x 0.1
                                 break;
                case "plateado": ncb3 = -2;     // x 0.01
                                 break;
                default: sw = 1;
                         System.out.print("\n * El color de la Tercera Banda ("
                                          + colorb3 + ") No es valido");
            }

            // ---------- PROCESO 2 y SALIDA ----------
            if(sw==0)
            {
                System.out.print("\nEl numero de la Primera Banda (" + colorb1 + ") es: " + ncb1);
                System.out.print("\nEl numero de la Segunda Banda (" + colorb2 + ") es: " + ncb2);
                System.out.print("\nLa Tercera Banda (" + colorb3 + ") multiplica por: 10^"
                                 + ncb3);

                double vr = ncb1 * 10 + ncb2;          // 2 primeras bandas: 4 y 7 -> 47
                if(ncb3 >= 0)
                    vr = vr * Math.pow(10, ncb3);      // 47 x 10^2 = 4700
                else
                    vr = vr / Math.pow(10, -ncb3);     // dorado: 47 / 10 = 4.7 (ver nota 1)

                System.out.print("\nEl valor de la Resistencia es: " + vr + " Ohm");

                // Ademas lo mostramos en la unidad mas comoda (ver nota 2)
                if(vr >= 1000000000)
                    System.out.print("\nEquivale a: " + (vr / 1000000000) + " GOhm");
                else if(vr >= 1000000)
                    System.out.print("\nEquivale a: " + (vr / 1000000) + " MOhm");
                else if(vr >= 1000)
                    System.out.print("\nEquivale a: " + (vr / 1000) + " kOhm");
            }
            else
                System.out.print("\nNo se puede calcular: revise los colores.");

            System.out.print("\n\nPara terminar Ingrese <0>  (otro valor para continuar)");
            System.out.print("\nDesea terminar? ");
            String n = datos.next();          // se lee como texto: no falla si escriben una letra
            if(n.equals("0"))                 // los String se comparan con equals, NO con ==
                opc = 1;
        }
        System.out.print("\n****** FIN *******\n");
    }
}

/*
 * NOTA 1 - Por que DIVIDIMOS entre 10 en vez de multiplicar por 0.1:
 *   0.1 no se puede guardar exacto en binario (ver Parte 1: numeros reales
 *   en memoria). Por eso 12 * 0.1 da 1.2000000000000002, mientras que
 *   12 / 10 da 1.2 (el valor guardado mas cercano posible).
 *
 * NOTA 2 - Java muestra los double muy grandes en notacion cientifica:
 *   47000000.0 se imprime como 4.7E7 (es decir 4.7 x 10^7). Por eso
 *   tambien mostramos el valor en kOhm, MOhm o GOhm.
 */
