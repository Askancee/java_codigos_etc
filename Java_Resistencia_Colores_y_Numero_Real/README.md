# Java: número real en memoria y resistencia por colores

Resolución de la tarea de las **imágenes del código en NetBeans**, que tiene dos partes, más el material para exponerla a compañeros que no saben Java.

## Empieza aquí

| Archivo | Para qué |
|---|---|
| **[`Guia_Java_Numero_Real_y_Resistencia.pdf`](Guia_Java_Numero_Real_y_Resistencia.pdf)** | La guía completa: teoría, programas explicados, pruebas y guion (60 páginas) |
| **[`Guion_de_Exposicion.pdf`](Guion_de_Exposicion.pdf)** | Solo el guion de la exposición (11 páginas), para tenerlo a mano al presentar |
| **[`guia/Guion_Programa_Colores_Bandas.pdf`](guia/Guion_Programa_Colores_Bandas.pdf)** | Guion **detallado** para exponer el programa de los colores (clase `Main`): qué decir, el porqué de cada parte del código, demostración, prueba de escritorio, experimentos y preguntas (23 páginas) |
| **[`guia/Teoria_Numero_Real_en_Memoria.pdf`](guia/Teoria_Numero_Real_en_Memoria.pdf)** | **Teoría completa** de cómo se almacena un número real: el signo, el exponente y el sesgo, la mantisa y el bit implícito, los valores especiales, el redondeo y los errores, con diagramas, ejemplos y ejercicios resueltos (30 páginas) |
| **[`guia/Guion_Numero_Real_en_Memoria.pdf`](guia/Guion_Numero_Real_en_Memoria.pdf)** | Guion **detallado** para exponer cómo se almacena un número real en la memoria, con el razonamiento paso a paso, lo que se escribe en la pizarra y una demostración (19 páginas) |

También se puede leer en GitHub, por capítulos:

| Capítulo | Contenido |
|---|---|
| [Cómo usar esta guía](guia/00_presentacion.md) | Qué hay en la carpeta, orden de lectura y notas sobre el código de las imágenes |
| [Java desde cero](guia/01_java_desde_cero.md) | Java explicado a partir de C++: estructura, `Scanner`, `System.out.print`, `switch` con `String`, `equals`, métodos y las pistas grises de NetBeans (`s:`, `a:`, `b:`) |
| [Parte 1 — Número real en memoria](guia/02_numero_real_en_memoria.md) | Bits y bytes, binario, decimales infinitos, notación científica, **IEEE 754** (`float` y `double`), sesgo, bit implícito, ejemplos −6.75 y 0.1, valores especiales, little-endian y el programa Java |
| [Parte 2 — Resistencia por colores](guia/03_resistencia_por_colores.md) | Resistencias y código de colores, análisis del programa de clase, **el programa nuevo** (colores → número de cada banda) y su **ampliación** (colores → valor), cada uno con pseudocódigo, diagrama de flujo, explicación línea por línea y pruebas; versión mejorada |
| [Guion de exposición](guia/04_guion_de_exposicion.md) | Estructura y tiempos, diapositivas sugeridas, qué decir, demostraciones, preguntas frecuentes y plan B |
| [Guion detallado: programa de los colores](guia/05_guion_programa_colores_bandas.md) | El programa `Main` (colores → número de cada banda) bloque por bloque: qué decir, por qué está hecho así, demostración, experimentos «¿qué pasa si…?», preguntas difíciles y el código con números de línea |
| [Teoría completa: número real en memoria](guia/07_teoria_numero_real_en_memoria.md) | La teoría a fondo, sin indicaciones para exponer: bits y binario, decimales infinitos, punto fijo y punto flotante, IEEE 754, **signo**, **exponente y sesgo**, **mantisa y bit implícito**, codificar y decodificar, valores especiales, redondeo y ULP, errores en las operaciones, Java, glosario y ejercicios |
| [Guion detallado: número real en memoria](guia/06_guion_numero_real_en_memoria.md) | Del gancho «0.1 + 0.2» a IEEE 754: qué decir, por qué funciona así, pizarra paso a paso (−6.75 y 0.1), demostración y preguntas difíciles |

## Programas (proyectos de NetBeans)

| Proyecto | Clase (programa) | Qué hace |
|---|---|---|
| [`Parte1_Numero_Real_en_Memoria/`](Parte1_Numero_Real_en_Memoria/) | [`Numero_Real_en_Memoria`](Parte1_Numero_Real_en_Memoria/src/main/java/com/mycompany/numero_real_en_memoria/Numero_Real_en_Memoria.java) | Convierte un número a binario paso a paso y muestra los bits reales del `float` y del `double`, el hexadecimal, el orden de los bytes en la RAM y el error de redondeo |
| [`Parte2_Valor_Resistencia_segun_Colores/`](Parte2_Valor_Resistencia_segun_Colores/) | [`Numeros_bandas_segun_Colores_Resistencia`](Parte2_Valor_Resistencia_segun_Colores/src/main/java/com/mycompany/valor_resistencia_segun_colores_bandas/Numeros_bandas_segun_Colores_Resistencia.java) | Pide los **nombres de los colores** de las 3 bandas y da **el número de cada banda** (amarillo, violeta, rojo → `4 - 7 - 2`) |
| (mismo proyecto) | [`Valor_Resistencia_segun_Colores_Bandas`](Parte2_Valor_Resistencia_segun_Colores/src/main/java/com/mycompany/valor_resistencia_segun_colores_bandas/Valor_Resistencia_segun_Colores_Bandas.java) | Ampliación: con esos números calcula el **valor de la resistencia** (en Ohm y en kOhm/MOhm/GOhm) |
| (mismo proyecto) | [`Valor_Resistencia_Version_Mejorada`](Parte2_Valor_Resistencia_segun_Colores/src/main/java/com/mycompany/valor_resistencia_segun_colores_bandas/Valor_Resistencia_Version_Mejorada.java) | Opcional: usa métodos y lee la 4.ª banda (tolerancia) |

**Cómo ejecutarlos:** en NetBeans, *File → Open Project…* → elegir la carpeta del proyecto. <kbd>F6</kbd> ejecuta la clase principal del proyecto (en la Parte 2, la del valor). Para `Numeros_bandas_segun_Colores_Resistencia` y la versión mejorada: abrir el archivo → clic derecho → *Run File* (<kbd>Shift</kbd> + <kbd>F6</kbd>). Los datos se escriben en la ventana *Output*.

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
