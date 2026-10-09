
package com.mycompany.valor_resistencia_segun_colores_bandas;

import java.util.Scanner;

/*
 * VERSION MEJORADA (OPCIONAL) - Para mostrar si el profesor pregunta
 * "se puede mejorar?". Hace lo mismo que la version principal, pero:
 *   1) Usa METODOS (static) para no repetir el mismo switch 3 veces.
 *   2) Lee una CUARTA banda: la TOLERANCIA (dorado = +-5%, etc.)
 *      y calcula el rango minimo y maximo de la resistencia.
 *   3) Muestra el resultado siempre en la unidad mas comoda.
 * Para ejecutarla en NetBeans: clic derecho sobre el archivo > Run File (Shift+F6).
 */
public class Valor_Resistencia_Version_Mejorada
{

    // Devuelve el numero (0 a 9) que corresponde a un color, o -1 si no es valido.
    static int numeroDelColor(String color)
    {
        switch(color)
        {
            case "negro":    return 0;
            case "marron":   return 1;
            case "rojo":     return 2;
            case "naranja":  return 3;
            case "amarillo": return 4;
            case "verde":    return 5;
            case "azul":     return 6;
            case "violeta":  return 7;
            case "gris":     return 8;
            case "blanco":   return 9;
            default:         return -1;
        }
    }

    // Potencia de 10 del multiplicador (3ra banda). Devuelve -99 si no es valido.
    static int potenciaMultiplicador(String color)
    {
        if(color.equals("dorado"))
            return -1;                        // x 0.1
        if(color.equals("plateado"))
            return -2;                        // x 0.01
        int numero = numeroDelColor(color);   // negro..blanco -> 0..9
        if(numero == -1)
            return -99;
        return numero;
    }

    // Tolerancia en % (4ta banda). Devuelve -1 si el color no tiene tolerancia.
    static double toleranciaDelColor(String color)
    {
        switch(color)
        {
            case "marron":   return 1;
            case "rojo":     return 2;
            case "verde":    return 0.5;
            case "azul":     return 0.25;
            case "violeta":  return 0.1;
            case "gris":     return 0.05;
            case "dorado":   return 5;
            case "plateado": return 10;
            case "ninguno":  return 20;       // resistencia sin cuarta banda
            default:         return -1;
        }
    }

    // Convierte un valor en Ohm al texto mas comodo: 4700 -> "4.7 kOhm"
    static String conUnidad(double ohm)
    {
        String unidad = " Ohm";
        if(ohm >= 1000000000)
        {
            ohm = ohm / 1000000000;
            unidad = " GOhm";
        }
        else if(ohm >= 1000000)
        {
            ohm = ohm / 1000000;
            unidad = " MOhm";
        }
        else if(ohm >= 1000)
        {
            ohm = ohm / 1000;
            unidad = " kOhm";
        }
        // Redondeamos a 6 decimales para quitar el "ruido" de los double
        // (por ejemplo 0.10200000000000001 -> 0.102). Ver Parte 1.
        ohm = Math.round(ohm * 1000000) / 1000000.0;
        return ohm + unidad;
    }

    public static void main(String[] args)
    {
        Scanner datos = new Scanner(System.in);
        String respuesta = "";

        System.out.print("===== RESISTENCIA DE 4 BANDAS (version mejorada) =====\n");

        while(!respuesta.equals("0"))
        {
            System.out.print("\nBanda 1 (1er digito)   : ");
            int d1 = numeroDelColor(datos.next().toLowerCase());
            System.out.print("Banda 2 (2do digito)   : ");
            int d2 = numeroDelColor(datos.next().toLowerCase());
            System.out.print("Banda 3 (multiplicador): ");
            int pot = potenciaMultiplicador(datos.next().toLowerCase());
            System.out.print("Banda 4 (tolerancia; si no tiene escriba ninguno): ");
            double tol = toleranciaDelColor(datos.next().toLowerCase());

            if(d1 == -1 || d2 == -1 || pot == -99 || tol == -1)
            {
                System.out.print("\n * Algun color no es valido para su banda. Intente de nuevo.\n");
            }
            else
            {
                double valor = d1 * 10 + d2;
                if(pot >= 0)
                    valor = valor * Math.pow(10, pot);
                else
                    valor = valor / Math.pow(10, -pot);

                double margen = valor * tol / 100;   // cuanto puede variar
                System.out.print("\nValor nominal : " + conUnidad(valor) + "  +-" + tol + " %");
                System.out.print("\nValor minimo  : " + conUnidad(valor - margen));
                System.out.print("\nValor maximo  : " + conUnidad(valor + margen) + "\n");
            }

            System.out.print("\nPara terminar Ingrese <0>  (otro valor para continuar): ");
            respuesta = datos.next();
        }
        System.out.print("\n****** FIN *******\n");
    }
}
