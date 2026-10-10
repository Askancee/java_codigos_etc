# Parcial C++: teoría desde cero y solucionario

Guía de estudio para los **10 ejercicios de preparación para el Examen Parcial** de Lenguajes de Programación I (semanas 1–7, C++), pensada para alguien que **empieza desde cero**.

## Empieza aquí

**[`Guia_Parcial_Cpp_desde_Cero.pdf`](Guia_Parcial_Cpp_desde_Cero.pdf)** — la guía completa (82 páginas, con índice navegable). La hoja original está en [`Enunciado_original_10_ejercicios.pdf`](Enunciado_original_10_ejercicios.pdf).

También se puede leer directamente en GitHub, por capítulos:

| Capítulo | Contenido |
|---|---|
| [Cómo usar esta guía](guia/00_como_usar_esta_guia.md) | Mapa de la guía, los 10 ejercicios de un vistazo, cómo estudiar y dónde practicar |
| [Parte I — Fundamentos](guia/01_fundamentos.md) | Computadora y programa · algoritmo vs. código fuente vs. ejecutable · lenguajes de programación (niveles, compilador e intérprete, compilación en C++, tipos de errores) · análisis Entrada–Proceso–Salida · **pseudocódigo** · **diagramas de flujo** · prueba de escritorio · UML básico |
| [Parte II — C++ desde cero](guia/02_cpp_desde_cero.md) | Estructura de un programa · variables y tipos · `cin`, `getline`, `cout` · operadores y precedencia · división entera y `static_cast` · `iomanip` · `string` (`length`, `find`, `substr`, `replace`) · `struct` y `class` |
| [Parte III — Ejercicios resueltos](guia/03_ejercicios_resueltos.md) | Los 10 ejercicios con análisis E-P-S, pseudocódigo, diagrama de flujo, código, ejecución real, prueba de escritorio y errores frecuentes |
| [Parte IV — Repaso final](guia/04_repaso_final.md) | Checklist del parcial respondido, 15 errores frecuentes, hoja resumen, autoevaluación con respuestas y glosario |

## Código de los ejercicios (`codigo/`)

| Archivo | Ejercicio |
|---|---|
| [`ej01_tipos_de_datos.cpp`](codigo/ej01_tipos_de_datos.cpp) | 1 — Tipos de datos y variables |
| [`ej02_pago_trabajador.cpp`](codigo/ej02_pago_trabajador.cpp) | 2 — Entrada, proceso y salida |
| [`ej03_division_entera.cpp`](codigo/ej03_division_entera.cpp) | 3 — División entera y `static_cast` |
| [`ej04_precedencia.cpp`](codigo/ej04_precedencia.cpp) | 4 — Precedencia de operadores |
| [`ej05a_original_con_error.cpp`](codigo/ej05a_original_con_error.cpp) · [`ej05b_corregido_getline.cpp`](codigo/ej05b_corregido_getline.cpp) · [`ej05c_extra_cin_y_getline.cpp`](codigo/ej05c_extra_cin_y_getline.cpp) | 5 — `cin` vs. `getline` (original, corregido y la trampa de mezclarlos) |
| [`ej06_substr_codigo.cpp`](codigo/ej06_substr_codigo.cpp) | 6 — `substr()` con el código universitario |
| [`ej07_correo.cpp`](codigo/ej07_correo.cpp) | 7 — `length()`, `find()`, `substr()`, `replace()` |
| [`ej08_tienda_descuento.cpp`](codigo/ej08_tienda_descuento.cpp) | 8 — Problema comercial con 2 decimales |
| [`ej09a_producto_struct.cpp`](codigo/ej09a_producto_struct.cpp) · [`ej09b_producto_clase.cpp`](codigo/ej09b_producto_clase.cpp) | 9 — UML a C++ (`struct` simplificado y `class` completa) |
| [`ej10_caso_integrador.cpp`](codigo/ej10_caso_integrador.cpp) | 10 — Caso integrador (sin `if` ni bucles) |

Todos compilan sin advertencias (`g++ -std=c++17 -Wall -Wextra -pedantic`). Para probarlos: ábrelos en Dev-C++, Code::Blocks o Visual Studio Code, o pégalos en un compilador en línea (OnlineGDB, Programiz).

> En los archivos de código se evitan tildes y la ñ en el texto que se muestra (por ejemplo, `Anio`) para que se vea bien en cualquier consola de Windows. En el examen en papel sí se escriben con tildes.

## Diagramas (`diagramas/`)

Diagramas de flujo de cada ejercicio, símbolos de diagramas de flujo, estructuras de control, compilación, índices de `string`, el buffer de entrada (`cin` vs. `getline`), árboles de evaluación de expresiones y el diagrama UML de la clase `Producto`.
