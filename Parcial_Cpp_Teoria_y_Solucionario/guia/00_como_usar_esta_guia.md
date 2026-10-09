# Cómo usar esta guía

Esta guía acompaña a la hoja **«10 ejercicios de preparación para el Examen Parcial»** del curso **Lenguajes de Programación I** (semanas 1 a 7, lenguaje C++).

Está escrita para alguien que **empieza desde cero**: no se da por sabido qué es una variable, un compilador, un pseudocódigo o un diagrama de flujo. Primero se explica la teoría con ejemplos sencillos y después se resuelve **cada ejercicio paso a paso**.

## Qué encontrarás en cada ejercicio resuelto

Cada uno de los 10 ejercicios trae, cuando corresponde:

1. **Qué se evalúa**: los conceptos que el profesor quiere ver.
2. **Análisis Entrada – Proceso – Salida (E-P-S)** y la elección justificada de los tipos de datos.
3. **Pseudocódigo**.
4. **Diagrama de flujo**.
5. **Código C++ completo y comentado** (todos fueron compilados y probados).
6. **Ejecución real** del programa (lo que aparece en la pantalla).
7. **Prueba de escritorio**: seguir el programa «a mano», instrucción por instrucción.
8. **Errores frecuentes y variantes** que pueden aparecer en el examen.

## Mapa de la guía

| Parte | Contenido | Para qué sirve |
|---|---|---|
| **I. Fundamentos** | Computadora, programa, algoritmo, lenguajes de programación, compilación, E-P-S, pseudocódigo, diagramas de flujo, prueba de escritorio, UML | Entender las ideas que el examen da por sabidas |
| **II. C++ desde cero** | Estructura de un programa, variables y tipos, `cin`/`cout`/`getline`, operadores, precedencia, conversión de tipos, formato de salida, `string`, `struct` y `class` | Tener todas las herramientas para programar |
| **III. Ejercicios resueltos** | Los 10 ejercicios de la hoja, uno por uno | Practicar con soluciones completas |
| **IV. Repaso final** | Checklist respondido, errores frecuentes, hoja resumen, autoevaluación con respuestas y glosario | Repasar rápido antes del examen |

## Los 10 ejercicios de un vistazo

| N.º | Tema | Nivel | Idea clave |
|---|---|---|---|
| [1](03_ejercicios_resueltos.md#ejercicio-1--tipos-de-datos-y-variables) | Tipos de datos y variables | Básico | `string`, `int`, `double`, `bool`, `char` |
| [2](03_ejercicios_resueltos.md#ejercicio-2--entrada-proceso-y-salida) | Entrada, proceso y salida | Básico | Estructura de cualquier programa |
| [3](03_ejercicios_resueltos.md#ejercicio-3--trazado-de-expresiones) | Trazado de expresiones | Medio | División entera y `static_cast` |
| [4](03_ejercicios_resueltos.md#ejercicio-4--precedencia-de-operadores) | Precedencia de operadores | Medio | `* / %` antes que `+ -` |
| [5](03_ejercicios_resueltos.md#ejercicio-5--debugging-de-entrada-con-string) | Debugging de entrada con `string` | Medio | `cin >>` vs. `getline()` |
| [6](03_ejercicios_resueltos.md#ejercicio-6--procesamiento-de-código-con-substr) | Procesamiento de código con `substr()` | Medio | Índices desde 0 |
| [7](03_ejercicios_resueltos.md#ejercicio-7--búsqueda-y-reemplazo-en-strings) | Búsqueda y reemplazo en strings | Medio-alto | `length()`, `find()`, `substr()`, `replace()` |
| [8](03_ejercicios_resueltos.md#ejercicio-8--problema-comercial-integrado) | Problema comercial integrado | Medio-alto | Fórmulas + 2 decimales |
| [9](03_ejercicios_resueltos.md#ejercicio-9--uml-básico--c) | UML básico + C++ | Avanzado | Clase, atributos y operaciones |
| [10](03_ejercicios_resueltos.md#ejercicio-10--caso-integrador-de-preparación) | Caso integrador | Avanzado | Todo junto, sin `if` ni bucles |

## Cómo estudiar con esta guía

| Si tienes… | Haz esto |
|---|---|
| **Varios días** | Lee las Partes I y II completas. Luego intenta cada ejercicio **tú solo, en papel**, y recién después compáralo con la solución. |
| **Un solo día** | Lee la Parte II (secciones 9 a 15) y resuelve los ejercicios 2, 3, 4, 5, 7 y 10. |
| **Una hora** | Lee la *Hoja resumen* y la lista de *Errores frecuentes* de la Parte IV, y repasa los ejercicios 3, 5 y 10. |

> [!TIP]
> Estudiar programación es como aprender a nadar: leer ayuda, pero **lo que de verdad funciona es practicar**. Escribe el código a mano (en el examen probablemente será en papel), luego cópialo en la computadora y compruébalo.

## Dónde practicar (gratis)

- **Sin instalar nada**: compiladores en línea como *OnlineGDB* (onlinegdb.com, elige el lenguaje C++) o *Programiz* (programiz.com/cpp-programming/online-compiler).
- **Instalado en tu computadora**: *Dev-C++* (versión de Embarcadero), *Code::Blocks* (la versión que trae MinGW) o *Visual Studio Code* con el compilador MinGW.
- **Para pseudocódigo y diagramas de flujo**: *PSeInt*, que además dibuja el diagrama de flujo a partir de tu pseudocódigo.

## Archivos de esta carpeta

- `codigo/`: los programas C++ de cada ejercicio (`ej01_...cpp` hasta `ej10_...cpp`). Se pueden abrir con cualquiera de los programas de arriba.
- `diagramas/`: todos los diagramas de flujo y figuras de la guía.
- `Enunciado_original_10_ejercicios.pdf`: la hoja original de ejercicios.

## Convenciones usadas

- Lo que se escribe en el código va en `letra monoespaciada`.
- En pseudocódigo, la flecha `←` significa **asignación** («guardar en»): `pago ← horas * tarifa`.
- En los **archivos de código** evitamos tildes y la letra ñ dentro del texto que se muestra (escribimos `Anio` en lugar de `Año`). No es un error: así el texto se ve bien en cualquier consola, incluida la de Windows, que suele mostrar mal esas letras. El propio profesor lo hace en sus códigos (`"Marron"`, `"numero"`). **En el examen en papel sí puedes escribir con tildes.**
- Los índices de un `string` siempre empiezan en **0**.
