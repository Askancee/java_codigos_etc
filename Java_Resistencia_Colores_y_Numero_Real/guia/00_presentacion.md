# Cómo usar esta guía

Esta carpeta resuelve la tarea de las **imágenes del código en NetBeans**, que tiene **dos partes**:

| Parte | Pregunta | Qué se entrega |
|---|---|---|
| **1** | ¿Cómo se almacena un **número real** en la memoria de la computadora? | Teoría desde cero (binario, notación científica, estándar IEEE 754), diagramas y un **programa Java** que muestra los bits reales de cualquier número |
| **2** | Rehacer el programa de las imágenes para que, **en vez de ingresar números, se ingresen los nombres de los colores** y el programa dé **el número de cada banda** como resultado | Teoría de resistencias y código de colores, el **programa Java** nuevo (colores → número de cada banda), una **ampliación** que además calcula el valor de la resistencia, explicación línea por línea, pruebas y una versión mejorada opcional |
| **Exposición** | ¿Cómo explicarlo a compañeros que no saben Java? | Un **guion de exposición** general y dos **guiones detallados** (uno por parte): qué decir, demostraciones y preguntas frecuentes |

## Archivos de esta carpeta

| Archivo o carpeta | Contenido |
|---|---|
| `Guia_Java_Numero_Real_y_Resistencia.pdf` | Esta guía completa en PDF (para leer o imprimir) |
| `Guion_de_Exposicion.pdf` | Solo el guion de la exposición, para tenerlo a mano el día de la presentación |
| `Parte1_Numero_Real_en_Memoria/` | Proyecto de NetBeans (Maven) del programa de números reales |
| `Parte2_Valor_Resistencia_segun_Colores/` | Proyecto de NetBeans (Maven) de la resistencia: el programa de los números de las bandas, la ampliación que calcula el valor y la versión mejorada |
| `imagenes_originales/` | Las capturas del código de clase y su **transcripción completa** en un archivo `.java` |
| `diagramas/` | Todas las figuras de la guía |
| `guia/` | El texto de esta guía (se lee en GitHub) y los guiones detallados (también en PDF) |

## Orden de lectura recomendado

1. **Java desde cero**: lo mínimo de Java para entender los programas, explicado a partir de lo que ya saben de C++.
2. **Parte 1 — El número real en memoria**.
3. **Parte 2 — La resistencia por colores**.
4. **Guion de exposición**: cómo presentarlo.
5. **Guiones detallados** (capítulos 05 y 06): para preparar cada parte a fondo.

Si van a exponer en grupo, todos deberían leer el capítulo «Java desde cero» y luego cada uno profundizar en la parte que va a presentar.

## Sobre el código de las imágenes

- Las capturas mostraban las líneas 1–50 y 67–98. Las líneas **51–64** no se veían: se reconstruyeron siguiendo exactamente el mismo patrón del programa (y coinciden con la numeración de las capturas). Lo que faltaba al final (la «sexta imagen») es:

```java
            if(n==0)
                opc = 1;
        }
        System.out.print("\n****** FIN *******");
    }
}
```

- Los recuadros grises que se ven en NetBeans, como **`s:`**, **`source:`**, **`a:`** y **`b:`**, **no son parte del código**: NetBeans los dibuja para indicar el nombre de cada parámetro. No se escriben (ver el capítulo «Java desde cero»). Por eso, la última línea correcta es simplemente `System.out.print("\n****** FIN *******");`.
- La transcripción completa está en `imagenes_originales/Colores_bandas_segun_valor_Resistencia_Varios2.java`; compila y funciona igual que el original.

## Todo fue probado

- Todos los programas se compilaron con Maven (como lo hace NetBeans) y también para Java 8, sin advertencias.
- Las ejecuciones que aparecen en la guía son **salidas reales**.
- El programa de los números de las bandas se verificó automáticamente con las **1 000 combinaciones** posibles de colores (10 × 10 × 10) y con colores no válidos: todas muestran los números correctos.
- La ampliación (el valor de la resistencia) se verificó con sus **1 200 combinaciones** (10 × 10 × 12): todas dan el valor correcto. La versión mejorada se verificó con sus 10 800 combinaciones.
