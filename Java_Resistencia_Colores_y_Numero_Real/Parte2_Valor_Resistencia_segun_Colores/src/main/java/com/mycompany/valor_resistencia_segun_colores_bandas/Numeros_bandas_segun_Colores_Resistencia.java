
package com.mycompany.valor_resistencia_segun_colores_bandas;

import java.util.Scanner;

/*
 * NUMERO DE CADA BANDA SEGUN SU COLOR
 * ------------------------------------
 * Es el programa visto en clase (Colores_bandas_segun_valor_Resistencia_Varios2)
 * hecho AL REVES:
 *   - En clase : se ingresaba el NUMERO de cada banda y se mostraba su COLOR.
 *   - Aqui     : se ingresa el NOMBRE del COLOR de cada banda y se muestra
 *                su NUMERO.
 *   Ejemplo: amarillo, violeta, rojo  ->  4, 7, 2
 *
 * Codigo de colores: negro 0, marron 1, rojo 2, naranja 3, amarillo 4,
 *                    verde 5, azul 6, violeta 7, gris 8, blanco 9
 */
public class Numeros_bandas_segun_Colores_Resistencia
{

    public static void main(String[] args)
    {
        Scanner datos = new Scanner(System.in);   // para leer lo que se escribe en el teclado
        byte opc = 0;                             // 0 = seguir, 1 = terminar

        System.out.print("===== NUMERO DE CADA BANDA SEGUN SU COLOR =====");
        System.out.print("\nColores validos (escribalos sin tildes):");
        System.out.print("\n  negro, marron, rojo, naranja, amarillo,");
        System.out.print("\n  verde, azul, violeta, gris, blanco\n");

        while(opc==0)
        {
            String colorb1, colorb2, colorb3;     // colores que escribe el usuario
            int ncb1 = 0, ncb2 = 0, ncb3 = 0;     // numero de cada banda
            int sw = 0;                           // 0 = colores correctos, 1 = hubo un error

            // ---------- ENTRADA: se leen los NOMBRES de los colores ----------
            // toLowerCase() pasa todo a minusculas: "ROJO" y "Rojo" quedan como "rojo"
            System.out.print("\nIngrese el color de la Primera Banda: ");
            colorb1 = datos.next().toLowerCase();
            System.out.print("Ingrese el color de la Segunda Banda: ");
            colorb2 = datos.next().toLowerCase();
            System.out.print("Ingrese el color de la Tercera Banda: ");
            colorb3 = datos.next().toLowerCase();

            // ---------- PROCESO: convertir cada color en su numero ----------
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
            switch(colorb3)
            {
                case "negro":    ncb3 = 0;
                                 break;
                case "marron":   ncb3 = 1;
                                 break;
                case "rojo":     ncb3 = 2;
                                 break;
                case "naranja":  ncb3 = 3;
                                 break;
                case "amarillo": ncb3 = 4;
                                 break;
                case "verde":    ncb3 = 5;
                                 break;
                case "azul":     ncb3 = 6;
                                 break;
                case "violeta":  ncb3 = 7;
                                 break;
                case "gris":     ncb3 = 8;
                                 break;
                case "blanco":   ncb3 = 9;
                                 break;
                default: sw = 1;
                         System.out.print("\n * El color de la Tercera Banda ("
                                          + colorb3 + ") No es valido");
            }

            // ---------- SALIDA: el numero de cada banda ----------
            if(sw==0)
            {
                System.out.print("\nEl numero de color de la Primera Banda (" + colorb1
                                 + ") es: " + ncb1);
                System.out.print("\nEl numero de color de la Segunda Banda (" + colorb2
                                 + ") es: " + ncb2);
                System.out.print("\nEl numero de color de la Tercera Banda (" + colorb3
                                 + ") es: " + ncb3);
                System.out.print("\nNumeros de las bandas: " + ncb1 + " - " + ncb2
                                 + " - " + ncb3);
            }
            else
                System.out.print("\nNo se puede mostrar: revise los colores.");

            System.out.print("\n\nPara terminar Ingrese <0>  (otro valor para continuar)");
            System.out.print("\nDesea terminar? ");
            String n = datos.next();          // se lee como texto: no falla si escriben una letra
            if(n.equals("0"))                 // los String se comparan con equals, NO con ==
                opc = 1;
        }
        System.out.print("\n****** FIN *******\n");
    }
}
