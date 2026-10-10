
package com.mycompany.numero_real_en_memoria;

import java.math.BigDecimal;
import java.util.Scanner;

/*
 * COMO SE ALMACENA UN NUMERO REAL EN LA MEMORIA (estandar IEEE 754)
 * -----------------------------------------------------------------
 * Para el numero que escriba el usuario, el programa muestra:
 *   1) La conversion a binario "a mano", paso a paso (como en papel).
 *   2) Los 32 bits que Java guarda para un float:
 *        1 bit de signo | 8 bits de exponente | 23 bits de mantisa
 *   3) Los 64 bits que Java guarda para un double:
 *        1 bit de signo | 11 bits de exponente | 52 bits de mantisa
 *   4) Como quedan esos bytes en la memoria RAM (orden little-endian).
 *   5) El valor EXACTO que quedo guardado y el error de redondeo.
 * Ademas tiene una opcion de "curiosidades" (0.1 + 0.2, etc.).
 */
public class Numero_Real_en_Memoria
{

    public static void main(String[] args)
    {
        Scanner datos = new Scanner(System.in);
        String opc = "";

        while(!opc.equals("0"))
        {
            System.out.print("\n========== NUMEROS REALES EN MEMORIA (IEEE 754) ==========");
            System.out.print("\n 1) Analizar un numero real");
            System.out.print("\n 2) Curiosidades (errores de redondeo)");
            System.out.print("\n 0) Salir");
            System.out.print("\nElija una opcion: ");
            opc = datos.next();

            switch(opc)
            {
                case "1":
                    System.out.print("Ingrese un numero real (ej: -6.75   0.1   4700): ");
                    String texto = datos.next().replace(',', '.');   // acepta 6,75 o 6.75
                    analizar(texto);
                    break;
                case "2":
                    curiosidades();
                    break;
                case "0":
                    break;
                default:
                    System.out.print("Opcion no valida\n");
            }
        }
        System.out.print("\n****** FIN *******\n");
    }

    // ==================================================================
    // Analiza el numero: paso a paso + lo que Java guarda (float y double)
    // ==================================================================
    static void analizar(String texto)
    {
        float f;
        double d;
        try
        {
            f = Float.parseFloat(texto);      // version de 32 bits
            d = Double.parseDouble(texto);    // version de 64 bits
        }
        catch(NumberFormatException e)        // si escribieron algo que no es numero
        {
            System.out.print(" * \"" + texto + "\" no es un numero valido\n");
            return;
        }
        pasoAPaso(texto, f);
        mostrarFloat(texto, f);
        mostrarDouble(texto, d);
    }

    // ==================================================================
    // 1) CONVERSION A MANO (para float de 32 bits), igual que en papel
    // ==================================================================
    static void pasoAPaso(String texto, float javaF)
    {
        System.out.print("\n----- PASO A PASO (como en papel), formato float de 32 bits -----\n");
        BigDecimal num;                       // BigDecimal: hace cuentas decimales EXACTAS
        try
        {
            num = new BigDecimal(texto);
        }
        catch(NumberFormatException e)        // NaN, Infinity, etc.
        {
            System.out.print("(Valor especial: no tiene paso a paso, mire los bits abajo)\n");
            return;
        }
        BigDecimal abs = num.abs();
        if(num.signum() == 0 || abs.compareTo(new BigDecimal("1E9")) >= 0
                             || abs.compareTo(new BigDecimal("1E-6")) < 0)
        {
            System.out.print("(Para cero o numeros muy grandes/pequenos"
                             + " se omite el paso a paso)\n");
            return;
        }

        // ---- Paso 1: el signo ----
        int signo = (num.signum() < 0) ? 1 : 0;
        System.out.print("1) Signo: " + (signo == 1 ? "negativo -> bit de signo = 1"
                                                    : "positivo -> bit de signo = 0") + "\n");

        // ---- Paso 2: parte entera -> binario (divisiones sucesivas entre 2) ----
        long entero = abs.longValue();                           // ej: 6.75 -> 6
        BigDecimal fraccion = abs.subtract(new BigDecimal(entero)); // ej: 6.75 -> 0.75
        String binEntero = "";
        if(entero == 0)
        {
            binEntero = "0";
            System.out.print("2) Parte entera = 0  ->  en binario tambien es 0\n");
        }
        else
        {
            System.out.print("2) Parte entera = " + entero
                             + "  (dividir entre 2 y anotar el resto)\n");
            long q = entero;
            while(q > 0)
            {
                System.out.print("      " + q + " / 2 = " + (q / 2)
                                 + "   resto " + (q % 2) + "\n");
                binEntero = (q % 2) + binEntero;      // cada resto se escribe a la IZQUIERDA
                q = q / 2;
            }
            System.out.print("   => " + entero + " en binario = " + binEntero
                             + "  (restos leidos de abajo hacia arriba)\n");
        }

        // ---- Paso 3: parte fraccionaria -> binario (multiplicar por 2) ----
        if(fraccion.signum() == 0)
            System.out.print("3) Parte fraccionaria = 0  ->  no hay bits despues del punto\n");
        else
            System.out.print("3) Parte fraccionaria = " + limpio(fraccion)
                             + "  (multiplicar por 2 y anotar la parte entera)\n");
        String binFrac = "";
        BigDecimal fr = fraccion;
        int pasos = 0;
        while(fr.signum() > 0 && pasos < 64)
        {
            BigDecimal producto = fr.multiply(new BigDecimal(2));
            int bit = (producto.compareTo(BigDecimal.ONE) >= 0) ? 1 : 0;
            if(pasos < 10)                        // solo mostramos los 10 primeros pasos
                System.out.print("      " + limpio(fr) + " x 2 = " + limpio(producto)
                                 + "   -> bit " + bit + "\n");
            binFrac = binFrac + bit;
            fr = producto.subtract(new BigDecimal(bit));   // queda solo lo de despues del punto
            pasos++;
        }
        boolean infinito = fr.signum() > 0;       // nunca llego a 0: binario infinito (periodico)
        if(pasos > 10)
            System.out.print("      ... (" + (pasos - 10) + " pasos mas)\n");
        if(infinito)
            System.out.print("   => NUNCA llega a 0: en binario este numero"
                             + " tiene infinitos digitos\n");
        if(binFrac.equals(""))
            binFrac = "0";
        System.out.print("   => numero completo en binario = " + binEntero + "."
                         + recortar(binFrac, 32) + (infinito ? "..." : "") + "\n");

        // ---- Paso 4: normalizar -> 1.xxxxx x 2^exponente ----
        int exponente;
        String despuesDelPunto;                    // bits que quedan despues de "1."
        if(entero > 0)
        {
            exponente = binEntero.length() - 1;    // el punto se corre a la izquierda
            despuesDelPunto = binEntero.substring(1) + binFrac;
        }
        else
        {
            int k = binFrac.indexOf('1');          // primer 1 despues del punto
            exponente = -(k + 1);                  // el punto se corre a la derecha
            despuesDelPunto = binFrac.substring(k + 1);
        }
        System.out.print("4) Normalizar (dejar un solo 1 antes del punto):\n");
        System.out.print("      1." + recortar(despuesDelPunto, 32) + (infinito ? "..." : "")
                         + " x 2^" + exponente + "\n");

        // ---- Paso 5: exponente con sesgo (bias) de 127 ----
        int expGuardado = exponente + 127;
        System.out.print("5) Exponente guardado = " + exponente + " + 127 = " + expGuardado
                         + "  ->  " + aBinario(expGuardado, 8) + " (8 bits)\n");

        // ---- Paso 6: mantisa = 23 bits despues del punto (el "1." no se guarda) ----
        String relleno = despuesDelPunto + "000000000000000000000000";   // completamos con ceros
        String mantisa = relleno.substring(0, 23);
        boolean bit24 = relleno.charAt(23) == '1';
        boolean hayMasUnos = relleno.substring(24).contains("1") || infinito;
        System.out.print("6) Mantisa: se toman 23 bits despues del punto"
                         + " (el \"1.\" NO se guarda)\n");
        System.out.print("      " + mantisa + " | " + relleno.charAt(23)
                         + " ...  <- el bit 24 decide el redondeo\n");
        if(bit24 && (hayMasUnos || mantisa.endsWith("1")))
        {
            long m = Long.parseLong(mantisa, 2) + 1;    // se suma 1 al ultimo bit
            if(m == 8388608)                            // 2^23: la mantisa se desbordo
            {
                m = 0;
                expGuardado++;
            }
            mantisa = aBinario(m, 23);
            System.out.print("      el bit 24 es 1 -> se REDONDEA hacia arriba: "
                             + mantisa + "\n");
        }
        else
            System.out.print("      el resto se descarta (redondeo hacia abajo)\n");

        // ---- Paso 7: armar los 32 bits y comparar con Java ----
        String aMano = signo + " | " + aBinario(expGuardado, 8) + " | " + mantisa;
        String deJava = separar(aBinario(Float.floatToIntBits(javaF), 32), 8);
        System.out.print("7) Resultado a mano : " + aMano + "\n");
        System.out.print("   Lo que guardo Java: " + deJava
                         + (aMano.equals(deJava) ? "   <- COINCIDEN" : "   <- difieren") + "\n");
    }

    // ==================================================================
    // 2) LO QUE JAVA GUARDA PARA UN float (32 bits)
    // ==================================================================
    static void mostrarFloat(String texto, float f)
    {
        int bits = Float.floatToIntBits(f);       // Java nos da los 32 bits del float
        String b = aBinario(bits, 32);
        String s = b.substring(0, 1);             // 1 bit de signo
        String e = b.substring(1, 9);             // 8 bits de exponente
        String m = b.substring(9);                // 23 bits de mantisa
        int expGuardado = Integer.parseInt(e, 2);
        String hex = aHexadecimal(b);

        System.out.print("\n----- LO QUE JAVA GUARDA: float (32 bits = 4 bytes) -----\n");
        System.out.print("Bits        : " + s + " | " + e + " | " + m + "\n");
        System.out.print("Signo       : " + s
                         + (s.equals("1") ? "  (negativo)" : "  (positivo)") + "\n");
        System.out.print("Exponente   : " + e + " = " + expGuardado
                         + explicarExponente(expGuardado, 127, 255) + "\n");
        System.out.print("Mantisa     : " + m + "\n");
        System.out.print("Hexadecimal : " + hex + "\n");
        System.out.print("En la RAM   : " + bytesEnMemoria(hex) + "  (little-endian)\n");
        System.out.print("Java lo imprime como : " + f + "\n");
        if(!Float.isNaN(f) && !Float.isInfinite(f))
        {
            BigDecimal guardado = new BigDecimal(f);    // valor EXACTO de esos 32 bits
            System.out.print("Valor EXACTO guardado: " + guardado.toPlainString() + "\n");
            mostrarError(texto, guardado);
        }
    }

    // ==================================================================
    // 3) LO QUE JAVA GUARDA PARA UN double (64 bits)
    // ==================================================================
    static void mostrarDouble(String texto, double d)
    {
        long bits = Double.doubleToLongBits(d);   // Java nos da los 64 bits del double
        String b = aBinario(bits, 64);
        String s = b.substring(0, 1);             // 1 bit de signo
        String e = b.substring(1, 12);            // 11 bits de exponente
        String m = b.substring(12);               // 52 bits de mantisa
        int expGuardado = Integer.parseInt(e, 2);
        String hex = aHexadecimal(b);

        System.out.print("\n----- LO QUE JAVA GUARDA: double (64 bits = 8 bytes) -----\n");
        System.out.print("Bits        : " + s + " | " + e + " | " + m + "\n");
        System.out.print("Signo       : " + s
                         + (s.equals("1") ? "  (negativo)" : "  (positivo)") + "\n");
        System.out.print("Exponente   : " + e + " = " + expGuardado
                         + explicarExponente(expGuardado, 1023, 2047) + "\n");
        System.out.print("Mantisa     : " + m + "\n");
        System.out.print("Hexadecimal : " + hex + "\n");
        System.out.print("En la RAM   : " + bytesEnMemoria(hex) + "  (little-endian)\n");
        System.out.print("Java lo imprime como : " + d + "\n");
        if(!Double.isNaN(d) && !Double.isInfinite(d))
        {
            BigDecimal guardado = new BigDecimal(d);    // valor EXACTO de esos 64 bits
            System.out.print("Valor EXACTO guardado: " + guardado.toPlainString() + "\n");
            mostrarError(texto, guardado);
        }
    }

    // ==================================================================
    // 4) CURIOSIDADES: por que los reales "fallan" en la computadora
    // ==================================================================
    static void curiosidades()
    {
        System.out.print("\n----- CURIOSIDADES DE LOS NUMEROS REALES -----\n");

        double suma = 0.1 + 0.2;
        System.out.print("1) 0.1 + 0.2 = " + suma + "\n");
        System.out.print("   0.1 + 0.2 == 0.3 ?  " + (suma == 0.3) + "\n");
        System.out.print("   Por eso se comparan con tolerancia: Math.abs(suma - 0.3) < 1e-9 ?  "
                         + (Math.abs(suma - 0.3) < 1e-9) + "\n");

        double acumulado = 0;
        for(int i = 1; i <= 10; i++)
            acumulado = acumulado + 0.1;
        System.out.print("2) Sumar 0.1 diez veces da: " + acumulado + "  (no exactamente 1.0)\n");

        float grande = 16777217f;
        System.out.print("3) float 16777217 se guarda como " + (long) grande
                         + "  (el float solo tiene 24 bits de precision, ~7 cifras)\n");
        System.out.print("   double 16777217 se guarda como " + (long) 16777217.0
                         + "  (~16 cifras)\n");

        System.out.print("4) 1/3 en float  = " + (1.0f / 3) + "\n");
        System.out.print("   1/3 en double = " + (1.0 / 3) + "\n");

        System.out.print("5) Distancia al siguiente float despues de 1.0       : "
                         + Math.ulp(1.0f) + "\n");
        System.out.print("   Distancia al siguiente float despues de 1000000.0 : "
                         + Math.ulp(1000000.0f) + "\n");
        System.out.print("   (mientras mas grande el numero,"
                         + " mas separados estan los valores posibles)\n");

        System.out.print("6) Valores especiales: 1.0/0 = " + (1.0 / 0)
                         + " ;  -1.0/0 = " + (-1.0 / 0) + " ;  0.0/0 = " + (0.0 / 0) + "\n");

        System.out.print("7) Resistencia marron-rojo-dorado: 12 * 0.1 = " + (12 * 0.1)
                         + "   pero 12 / 10.0 = " + (12 / 10.0) + "\n");
    }

    // ==================================================================
    // Metodos auxiliares (herramientas pequenas)
    // ==================================================================

    // Escribe "valor" en binario usando exactamente nBits (rellena con ceros a la izquierda)
    static String aBinario(long valor, int nBits)
    {
        String s = Long.toBinaryString(valor);
        while(s.length() < nBits)
            s = "0" + s;
        return s.substring(s.length() - nBits);
    }

    // Convierte una cadena de bits a hexadecimal (cada 4 bits = 1 digito hex)
    static String aHexadecimal(String bits)
    {
        String hex = "";
        for(int i = 0; i < bits.length(); i += 4)
        {
            int valor = Integer.parseInt(bits.substring(i, i + 4), 2);   // 4 bits -> 0..15
            hex = hex + Integer.toHexString(valor).toUpperCase();           // 0..15 -> 0..F
        }
        return hex;
    }

    // En la RAM (procesadores Intel/AMD) los bytes se guardan del MENOS significativo al MAS
    // significativo (little-endian). Ej: 3DCCCCCD -> [+0]CD [+1]CC [+2]CC [+3]3D
    static String bytesEnMemoria(String hex)
    {
        String r = "";
        int nBytes = hex.length() / 2;
        for(int i = 0; i < nBytes; i++)
        {
            int fin = hex.length() - 2 * i;
            r = r + "[+" + i + "]" + hex.substring(fin - 2, fin) + " ";
        }
        return r.trim();
    }

    static String explicarExponente(int expGuardado, int sesgo, int maximo)
    {
        if(expGuardado == 0)
            return "  (todo ceros: el numero es 0 o subnormal)";
        if(expGuardado == maximo)
            return "  (todo unos: Infinito o NaN)";
        return "  ->  exponente real = " + expGuardado + " - " + sesgo
               + " = " + (expGuardado - sesgo);
    }

    // Diferencia entre el numero que escribio el usuario y el que realmente quedo guardado
    static void mostrarError(String texto, BigDecimal guardado)
    {
        try
        {
            BigDecimal escrito = new BigDecimal(texto);
            BigDecimal error = guardado.subtract(escrito);
            if(error.signum() == 0)
                System.out.print("Error de redondeo    : 0  (se guardo EXACTO)\n");
            else
                System.out.print("Error de redondeo    : " + error.toPlainString() + "\n");
        }
        catch(NumberFormatException e)
        {
            // el texto no era decimal (por ejemplo "NaN"): no se calcula el error
        }
    }

    // "1.50" -> "1.5" (quita ceros sobrantes al final para que se lea mejor)
    static String limpio(BigDecimal x)
    {
        if(x.signum() == 0)
            return "0";
        return x.stripTrailingZeros().toPlainString();
    }

    // Recorta una cadena larga para mostrarla en pantalla
    static String recortar(String s, int max)
    {
        if(s.length() <= max)
            return s;
        return s.substring(0, max);
    }

    // "0011..." -> "0 | 01111011 | 1001..." (signo | exponente | mantisa)
    static String separar(String bits, int bitsExponente)
    {
        return bits.substring(0, 1) + " | " + bits.substring(1, 1 + bitsExponente)
               + " | " + bits.substring(1 + bitsExponente);
    }
}
