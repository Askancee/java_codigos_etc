# Java: número real en memoria y valor de una resistencia por colores

Resolución de la tarea de las **imágenes del código en NetBeans**, que tiene dos partes, más el material para exponerla a compañeros que no saben Java.

## Empieza aquí

| Archivo | Para qué |
|---|---|
| **[`Guia_Java_Numero_Real_y_Resistencia.pdf`](Guia_Java_Numero_Real_y_Resistencia.pdf)** | La guía completa: teoría, programas explicados, pruebas y guion (51 páginas) |
| **[`Guion_de_Exposicion.pdf`](Guion_de_Exposicion.pdf)** | Solo el guion de la exposición (10 páginas), para tenerlo a mano al presentar |

También se puede leer en GitHub, por capítulos:

| Capítulo | Contenido |
|---|---|
| [Cómo usar esta guía](guia/00_presentacion.md) | Qué hay en la carpeta, orden de lectura y notas sobre el código de las imágenes |
| [Java desde cero](guia/01_java_desde_cero.md) | Java explicado a partir de C++: estructura, `Scanner`, `System.out.print`, `switch` con `String`, `equals`, métodos y las pistas grises de NetBeans (`s:`, `a:`, `b:`) |
| [Parte 1 — Número real en memoria](guia/02_numero_real_en_memoria.md) | Bits y bytes, binario, decimales infinitos, notación científica, **IEEE 754** (`float` y `double`), sesgo, bit implícito, ejemplos −6.75 y 0.1, valores especiales, little-endian y el programa Java |
| [Parte 2 — Resistencia por colores](guia/03_resistencia_por_colores.md) | Resistencias y código de colores, análisis del programa de clase, **el programa nuevo** (colores → valor) con pseudocódigo, diagrama de flujo, explicación línea por línea, pruebas y versión mejorada |
| [Guion de exposición](guia/04_guion_de_exposicion.md) | Estructura y tiempos, diapositivas sugeridas, qué decir, demostraciones, preguntas frecuentes y plan B |

## Programas (proyectos de NetBeans)

| Proyecto | Clase principal | Qué hace |
|---|---|---|
| [`Parte1_Numero_Real_en_Memoria/`](Parte1_Numero_Real_en_Memoria/) | [`Numero_Real_en_Memoria`](Parte1_Numero_Real_en_Memoria/src/main/java/com/mycompany/numero_real_en_memoria/Numero_Real_en_Memoria.java) | Convierte un número a binario paso a paso y muestra los bits reales del `float` y del `double`, el hexadecimal, el orden de los bytes en la RAM y el error de redondeo |
| [`Parte2_Valor_Resistencia_segun_Colores/`](Parte2_Valor_Resistencia_segun_Colores/) | [`Valor_Resistencia_segun_Colores_Bandas`](Parte2_Valor_Resistencia_segun_Colores/src/main/java/com/mycompany/valor_resistencia_segun_colores_bandas/Valor_Resistencia_segun_Colores_Bandas.java) | Pide los **nombres de los colores** de las 3 bandas y calcula el **valor de la resistencia** (en Ohm y en kOhm/MOhm/GOhm) |
| (mismo proyecto) | [`Valor_Resistencia_Version_Mejorada`](Parte2_Valor_Resistencia_segun_Colores/src/main/java/com/mycompany/valor_resistencia_segun_colores_bandas/Valor_Resistencia_Version_Mejorada.java) | Opcional: usa métodos y lee la 4.ª banda (tolerancia) |

**Cómo ejecutarlos:** en NetBeans, *File → Open Project…* → elegir la carpeta del proyecto → <kbd>F6</kbd>. Los datos se escriben en la ventana *Output*. (La versión mejorada: clic derecho sobre el archivo → *Run File*.)

## Código original de las imágenes

[`imagenes_originales/`](imagenes_originales/) contiene las 5 capturas y la **transcripción completa** en [`Colores_bandas_segun_valor_Resistencia_Varios2.java`](imagenes_originales/Colores_bandas_segun_valor_Resistencia_Varios2.java), con la misma numeración de líneas que las capturas. Las líneas 51–64 (que no se veían) se reconstruyeron siguiendo el mismo patrón, y el final (la «sexta imagen») es:

```java
            if(n==0)
                opc = 1;
        }
        System.out.print("\n****** FIN *******");
    }
}
```

El `s:` que se ve en NetBeans antes del texto **no se escribe**: es una pista visual del editor con el nombre del parámetro.
