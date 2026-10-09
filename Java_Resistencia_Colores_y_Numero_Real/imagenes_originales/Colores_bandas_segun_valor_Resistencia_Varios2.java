
package com.mycompany.colores_bandas_segun_valor_resistencia_varios2;

import java.util.Scanner;

public class Colores_bandas_segun_valor_Resistencia_Varios2
{

    public static void main(String[] args)
    {
        byte opc = 0;
        while(opc==0)
        {
            int ncb1,ncb2,ncb3;
            String colorb1="",colorb2="",colorb3="";
            Scanner datos = new Scanner(System.in);
            System.out.print("\nIngrese el numero de color de la Primera Banda: ");
            ncb1 = datos.nextByte();
            if(ncb1 >= 0 && ncb1 <= 9)
            {
                    System.out.print("\nIngrese el numero de color de la Segunda Banda: ");
                    ncb2 = datos.nextByte();
                    int sw = 0;
                    //System.out.print("\nEl valor ingresado es: nroc = "+nroc);
                    switch(ncb1)
                    {
                        case 0: colorb1 = "Negro";
                                break;
                        case 1: colorb1 = "Marron";
                                break;
                        case 2: colorb1 = "Rojo";
                                break;
                        case 9: colorb1 = "Blanco";
                                break;
                        case 8: colorb1 = "Gris";
                                break;
                        case 3: colorb1 = "Naranja";
                                break;
                        case 4: colorb1 = "Amarillo";
                                break;
                        default: sw = 1;
                    }
                    switch(ncb2)
                    {
                        case 0: colorb2 = "Negro";
                                break;
                        case 1: colorb2 = "Marron";
                                break;
                        case 2: colorb2 = "Rojo";
                                break;
                        case 9: colorb2 = "Blanco";
                                break;
                        case 8: colorb2 = "Gris";
                                break;
                        case 3: colorb2 = "Naranja";
                                break;
                        case 4: colorb2 = "Amarillo";
                                break;
                        default: sw = 1;
                    }
                    System.out.print("\nIngrese el numero de color de la Tercera Banda: ");
                    ncb3 = datos.nextByte();
                    switch(ncb3)
                    {
                        case 0: colorb3 = "Negro";
                                break;
                        case 1: colorb3 = "Marron";
                                break;
                        case 2: colorb3 = "Rojo";
                                break;
                        case 9: colorb3 = "Blanco";
                                break;
                        case 8: colorb3 = "Gris";
                                break;
                        case 3: colorb3 = "Naranja";
                                break;
                        case 4: colorb3 = "Amarillo";
                                break;
                        default: sw = 1;
                    }
                    if(sw==0)
                    {
                        System.out.print("\nEl color de la Primera Banda es: "+colorb1);
                        System.out.print("\nEl color de la Segunda Banda es: "+colorb2);
                        System.out.print("\nEl color de la Tercera Banda es: "+colorb3);
                        double vr = ncb1 * 10 + ncb2;
                        vr = vr * Math.pow(10, ncb3);
                        System.out.print("\nEl valor de la Resistencia es: "+vr+" Ohm");
                    }

            }
            else
                System.out.print("\nEl valor de la primera Banda que ingreso usted No es valido\n");

            System.out.print("\nPara terminar Ingrese <0>\n");
            System.out.print("\nDesea terminar? ");
            byte n =datos.nextByte();
            if(n==0)
                opc = 1;
        }
        System.out.print("\n****** FIN *******");
    }
}
