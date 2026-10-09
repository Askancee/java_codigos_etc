# Parte IV — Repaso final

## 17. Checklist antes del parcial (respondido)

La hoja de ejercicios termina con una lista de comprobación. Aquí está **cada punto con su respuesta corta** y dónde repasarlo.

**1. Puedo diferenciar algoritmo, código fuente y programa ejecutable.**
*Algoritmo*: los pasos para resolver el problema (independiente del lenguaje). *Código fuente*: el algoritmo escrito en C++ (archivo `.cpp`, texto legible). *Ejecutable*: el código traducido a lenguaje máquina por el compilador (archivo `.exe`). → Parte I, sección 2.

**2. Puedo identificar entradas, procesos y salidas de un problema.**
*Entrada*: los datos que el programa no conoce y debe pedir. *Proceso*: los cálculos o transformaciones (fórmulas, `substr`, etc.). *Salida*: lo que se debe mostrar. Preséntalo en una tabla con variable, tipo y justificación. → Sección 4.1 y ejercicios 2, 8 y 10.

**3. Puedo elegir tipos de datos apropiados en C++.**
Texto → `string`; un carácter → `char`; entero → `int`; con decimales → `double`; sí/no → `bool`. Códigos, DNI y teléfonos → `string`. → Secciones 10.4 y 10.5, ejercicio 1.

**4. Comprendo la diferencia entre `cin` y `getline()`.**
`cin >>` lee hasta el primer espacio y deja el Enter en el buffer; sirve para números y palabras sueltas. `getline(cin, s)` lee la línea completa con espacios y consume el Enter; sirve para nombres. Si un `getline` viene después de un `cin >>`, usa `getline(cin >> ws, s)`. → Sección 11, ejercicio 5.

**5. Puedo usar `length()`, `find()`, `substr()` y `replace()`.**
`length()` → cantidad de caracteres. `find(t)` → posición de la primera aparición (o `string::npos`). `substr(inicio, cantidad)` → copia una parte. `replace(inicio, cantidad, nuevo)` → cambia una parte (modifica el original). Los índices empiezan en 0. → Sección 15, ejercicios 6, 7 y 10.

**6. Comprendo división entera, conversión de tipos y precedencia.**
`int / int` corta los decimales (`10 / 4 = 2`). Para división real, convierte **antes** de dividir: `static_cast<double>(a) / b`. Precedencia: `( )` → `* / %` → `+ -`; a igual precedencia, de izquierda a derecha. → Secciones 12 y 13, ejercicios 3 y 4.

**7. Puedo leer y corregir fragmentos sencillos de código.**
Revisa siempre: ¿falta algún `;` o `#include`? ¿Cada variable tiene el tipo correcto? ¿Se lee con `cin` un texto con espacios? ¿Hay una división entre enteros? ¿Los índices de `substr` empiezan en 0 y el segundo número es una cantidad? ¿Se usa una variable antes de darle valor? → Ejercicios 3, 5 y la lista de errores frecuentes de abajo.

**8. Puedo elaborar pseudocódigo antes de programar.**
Plantilla: `Algoritmo Nombre` → `Definir … Como …` → `Leer …` → asignaciones con `←` → `Escribir …` → `FinAlgoritmo`. Cada línea luego se traduce a una línea de C++. → Sección 5.

**9. Puedo interpretar un diagrama de clase UML básico.**
Tres compartimentos: nombre / atributos (`- nombre : tipo`) / operaciones (`+ nombre() : retorno`). `-` = privado, `+` = público, `void` = no devuelve nada. → Sección 8, ejercicio 9.

**10. Puedo desarrollar un programa integrador básico en C++.**
Receta: 1) tabla E-P-S con tipos; 2) dibuja los índices de los textos; 3) lee primero los textos con `getline` y después los números con `cin`; 4) extrae con `substr`; 5) calcula con `double`; 6) muestra con `fixed << setprecision(2)`; 7) haz la prueba de escritorio. → Ejercicio 10.

## 18. Los 15 errores más frecuentes

| # | Error | Cómo evitarlo |
|---|---|---|
| 1 | Olvidar el `;` al final de una instrucción | Revisa cada línea antes de compilar |
| 2 | Escribir `Cout`, `Cin`, `Main` con mayúscula | C++ distingue mayúsculas: `cout`, `cin`, `main` |
| 3 | Usar `string`/`getline` sin `#include <string>`, o `setprecision` sin `#include <iomanip>` | Usa la plantilla de la sección 9 |
| 4 | Dividir enteros esperando decimales (`10 / 4`) | Convierte antes: `static_cast<double>(10) / 4` o usa `4.0` |
| 5 | `static_cast<double>(a / b)` | El cast va **antes** de dividir: `static_cast<double>(a) / b` |
| 6 | `porcentaje / 100` con `porcentaje` entero | Declara `double porcentaje` o divide entre `100.0` |
| 7 | Leer un nombre completo con `cin >>` | Usa `getline(cin, nombre)` |
| 8 | `getline` después de `cin >>` (lee vacío) | `getline(cin >> ws, texto)` o lee primero los textos |
| 9 | Contar los índices desde 1 | Los índices empiezan en **0**; dibuja el texto con sus índices |
| 10 | Usar el 2.º parámetro de `substr` como posición final | Es la **cantidad** de caracteres |
| 11 | Olvidar el `+ 1` al extraer lo que está después de un separador | `s.substr(pos + 1)` |
| 12 | `replace` con la cantidad del texto nuevo en vez del viejo | `replace(inicio, largoDelViejo, nuevo)` |
| 13 | `char c = "A";` o `string s = 'Hola';` | Simples para `char`, dobles para texto |
| 14 | Guardar códigos o DNI como `int` | Usa `string` (conserva ceros y permite `substr`) |
| 15 | Calcular antes de leer los datos | Orden: declarar → leer → calcular → mostrar |

## 19. Hoja resumen

### Esqueleto de un programa

```cpp
#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

int main() {
    // declarar → leer → calcular → mostrar
    return 0;
}
```

### Tipos de datos

| Dato | Tipo | Ejemplo |
|---|---|---|
| Entero | `int` | `int edad = 19;` |
| Con decimales | `double` | `double precio = 850.50;` |
| Un carácter | `char` | `char inicial = 'T';` |
| Verdadero/falso | `bool` | `bool aprobado = true;` |
| Texto / códigos | `string` | `string codigo = "FIEE-2026-0145";` |

### Entrada y salida

| Quiero… | Código |
|---|---|
| Mostrar | `cout << "Total: " << total << endl;` |
| Leer un número o una palabra | `cin >> variable;` |
| Leer una línea con espacios | `getline(cin, texto);` |
| `getline` después de `cin >>` | `getline(cin >> ws, texto);` |
| 2 decimales (todo lo que sigue) | `cout << fixed << setprecision(2);` |
| Ancho fijo para el siguiente dato | `cout << setw(10) << dato;` |

### Operadores y reglas

- Precedencia: `( )` → unarios → `* / %` → `+ -` → `<<` → comparaciones → `&&` → `||` → `=`.
- Igual precedencia: de **izquierda a derecha** (excepto asignaciones y unarios).
- `int / int` = división entera. `%` = resto (solo enteros).
- División real con enteros: `static_cast<double>(a) / b`.
- `int x = 9.99;` guarda 9 (se corta, no se redondea).

### Funciones de `string` (con `s = "Hola Mundo"`)

| Función | Resultado |
|---|---|
| `s.length()` | `10` |
| `s[0]` | `'H'` |
| `s.find("Mundo")` | `5` (o `string::npos` si no está) |
| `s.substr(5, 5)` | `"Mundo"` (desde 5, toma 5) |
| `s.substr(5)` | `"Mundo"` (desde 5 hasta el final) |
| `s.replace(0, 4, "Chau")` | `s` queda `"Chau Mundo"` |
| Antes de la posición `p` | `s.substr(0, p)` |
| Después de la posición `p` | `s.substr(p + 1)` |

### Pseudocódigo ↔ C++

| Pseudocódigo | C++ |
|---|---|
| `Definir x Como Entero / Real / Cadena / Caracter / Logico` | `int / double / string / char / bool x;` |
| `Leer x` | `cin >> x;` o `getline(cin, x);` |
| `Escribir "texto", x` | `cout << "texto" << x;` |
| `x ← expresión` | `x = expresión;` |

### Diagrama de flujo

Óvalo = Inicio/Fin · Paralelogramo = Leer/Escribir · Rectángulo = Proceso · Rombo = Decisión · Flechas = orden.

### UML → C++

`- atributo : tipo` → `private: tipo atributo;` · `+ operacion() : tipo` → `public: tipo operacion() { … }` · `void` = no devuelve nada.

## 20. Autoevaluación

Responde sin mirar y luego revisa las respuestas al final. Todas fueron comprobadas ejecutando el código.

1. ¿Qué muestra `cout << 17 / 5 << " " << 17 % 5;`?
2. ¿Qué valor guarda `double r = 9 / 2;`?
3. ¿Y `double r = 9 / 2.0;`?
4. ¿Cuánto vale `2 + 3 * 4 % 5`?
5. ¿Cuánto vale `20 / 4 / 2`?
6. Con `string s = "Lenguajes";`, ¿qué devuelve `s.length()`?
7. ¿Qué devuelve `s.substr(3, 4)`?
8. ¿Qué devuelve `s.find("aje")`?
9. Con `string t = "UNMSM-FIEE";`, escribe una instrucción que extraiga `"FIEE"` usando `find`.
10. ¿Qué tipo de dato usarías para un número de celular? ¿Por qué?
11. ¿Qué imprime `cout << (double)(7 / 2);`?
12. ¿Qué imprime `cout << static_cast<double>(7) / 2;`?
13. Si el usuario escribe `Ana Maria` y el programa hace `cin >> nombre;`, ¿qué se guarda?
14. ¿Por qué un `getline` que va después de `cin >> edad;` lee un texto vacío? ¿Cómo se soluciona?
15. ¿Qué muestra `cout << fixed << setprecision(2) << 3.14159;`?
16. En UML, ¿qué significa `- saldo : double`?
17. Escribe en C++ la declaración de la operación UML `+ calcularPromedio() : double`.
18. Encuentra los dos errores: `int main() { Cout << "Hola" }` (asumiendo que los `#include` y el `using namespace std;` están bien).
19. ¿Cómo queda `correo` después de `string correo = "ana@gmail.com"; correo.replace(4, 5, "outlook");`?
20. Con `string u = "Programa";`, ¿qué muestra `cout << u[0] << u[u.length() - 1];`?

### Respuestas

1. `3 2` (17 / 5 = 3 con resto 2).
2. `4` (división entera: 9 / 2 = 4; se guarda 4.0).
3. `4.5`.
4. `4` → primero `3 * 4 = 12`, luego `12 % 5 = 2`, al final `2 + 2 = 4`.
5. `2` → de izquierda a derecha: `(20 / 4) / 2 = 5 / 2 = 2`.
6. `9`.
7. `"guaj"` (índices 3, 4, 5 y 6: g-u-a-j).
8. `5` (la `a` de «aje» está en el índice 5).
9. `t.substr(t.find("-") + 1)` → `"FIEE"`.
10. `string`: no se hacen cálculos con él y puede empezar con 0 o tener `+51`.
11. `3`: primero `7 / 2 = 3` (enteros) y luego se convierte a 3.0.
12. `3.5`.
13. Solo `"Ana"`: `cin >>` se detiene en el espacio.
14. Porque `cin >>` deja el Enter (`'\n'`) en el buffer y `getline` lo toma como una línea vacía. Solución: `getline(cin >> ws, texto);` o `cin.ignore();` antes del `getline`.
15. `3.14`.
16. Es un **atributo privado** llamado `saldo` de tipo `double`.
17. Dentro de la clase, en la sección `public:` → `double calcularPromedio();` (o con su cuerpo `{ … }`).
18. `Cout` debe escribirse `cout` (C++ distingue mayúsculas de minúsculas) y falta el `;` después de `"Hola"`. Además, en el curso siempre se termina `main` con `return 0;`.
19. `"ana@outlook.com"` (se borran 5 caracteres desde el índice 4, «gmail», y se pone «outlook»).
20. `Pa` (primer y último carácter).

## 21. Glosario

| Término | Significado |
|---|---|
| **Algoritmo** | Secuencia finita, ordenada y precisa de pasos para resolver un problema |
| **Asignación** | Guardar un valor en una variable (`=` en C++, `←` en pseudocódigo) |
| **Asociatividad** | Regla que decide el orden entre operadores de igual precedencia |
| **Biblioteca** | Código ya hecho que se incluye con `#include` (`iostream`, `string`, `iomanip`) |
| **Bit / byte** | Bit: unidad mínima (0 o 1). Byte: 8 bits |
| **Buffer de entrada** | Zona donde espera lo que el usuario escribió hasta que el programa lo lee |
| **Clase** | Molde que define atributos y operaciones (UML / `class`) |
| **Código fuente** | El programa escrito en un lenguaje (archivo `.cpp`) |
| **Comentario** | Texto que el compilador ignora (`//` o `/* */`) |
| **Compilador** | Programa que traduce el código fuente a lenguaje máquina |
| **Concatenar** | Unir textos (`+` con `string`) |
| **Constante** | Valor que no cambia (`const double IGV = 0.18;`) |
| **Constructor** | Método especial que inicializa un objeto al crearlo |
| **Declaración** | Crear una variable indicando su tipo (`int edad;`) |
| **Diagrama de flujo** | Representación gráfica de un algoritmo |
| **Enlazador (linker)** | Une el código traducido con las bibliotecas y genera el ejecutable |
| **Expresión** | Combinación de valores y operadores que produce un resultado |
| **Identificador** | Nombre de una variable, función o clase |
| **Índice** | Posición de un carácter en un texto (empieza en 0) |
| **Inicializar** | Dar el primer valor a una variable |
| **Literal** | Valor escrito directamente en el código (`25`, `2.5`, `'A'`, `"Hola"`) |
| **Método / operación** | Función que pertenece a una clase |
| **Objeto** | Ejemplar concreto de una clase, con sus propios valores |
| **Precedencia** | Prioridad de un operador sobre otro |
| **Programa ejecutable** | Archivo en lenguaje máquina listo para ejecutarse (`.exe`) |
| **Prueba de escritorio** | Ejecutar un algoritmo a mano anotando los valores de las variables |
| **Pseudocódigo** | Algoritmo escrito en lenguaje natural estructurado |
| **Semántica** | El significado de las instrucciones |
| **Sintaxis** | Las reglas de escritura de un lenguaje |
| **`static_cast`** | Conversión explícita de tipo (`static_cast<double>(a)`) |
| **UML** | Lenguaje gráfico estándar para diseñar programas |
| **Variable** | Espacio de memoria con nombre, tipo y valor |

---

**¡Éxitos en el parcial!** Si entendiste los 10 ejercicios de esta guía, entendiste los contenidos de las semanas 1 a 7.
