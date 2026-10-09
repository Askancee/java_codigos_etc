// =============================================================
// Ejercicio 4 - Precedencia de operadores           (Nivel: Medio)
// Objetivo: reforzar precedencia y asociatividad.
// Regla: primero ( ), luego * / %  (de izquierda a derecha),
//        y al final + -            (de izquierda a derecha).
// =============================================================

#include <iostream>
using namespace std;

int main() {
    int a = 8;
    int b = 3;
    int c = 2;

    // ---------- Expresiones tal como las da el enunciado ----------
    cout << "A) a + b * c   = " << a + b * c   << endl;   // 8 + 6      = 14
    cout << "B) (a + b) * c = " << (a + b) * c << endl;   // 11 * 2     = 22
    cout << "C) a % b + c   = " << a % b + c   << endl;   // 2 + 2      = 4
    cout << "D) a / b * c   = " << a / b * c   << endl;   // 2 * 2      = 4

    // ---------- Las mismas, con parentesis explicitos ----------
    cout << endl;
    cout << "A) a + (b * c) = " << a + (b * c) << endl;   // 14
    cout << "B) (a + b) * c = " << (a + b) * c << endl;   // 22 (ya tenia parentesis)
    cout << "C) (a % b) + c = " << (a % b) + c << endl;   // 4
    cout << "D) (a / b) * c = " << (a / b) * c << endl;   // 4

    // ---------- Si agrupamos distinto, el resultado cambia ----------
    cout << endl;
    cout << "a / (b * c)    = " << a / (b * c) << endl;   // 8 / 6 = 1
    cout << "a % (b + c)    = " << a % (b + c) << endl;   // 8 % 5 = 3

    return 0;
}
