// =============================================================
// Ejercicio 3 - Trazado de expresiones              (Nivel: Medio)
// Objetivo: comprender la division entera y la conversion de tipos.
// =============================================================

#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    // ---------- Codigo del enunciado ----------
    int a = 10;
    int b = 4;

    double x = a / b;                       // int / int -> division ENTERA: 10 / 4 = 2
                                            // (el .5 se pierde ANTES de guardar en x)
    double y = static_cast<double>(a) / b;  // double / int -> division REAL: 10.0 / 4 = 2.5

    cout << x << endl;    // muestra 2   (cout no muestra el ".0" por defecto)
    cout << y << endl;    // muestra 2.5

    // ---------- Extra: variantes que suelen aparecer en examen ----------
    cout << endl << "--- Variantes ---" << endl;
    cout << "a % b                       = " << a % b << endl;                       // 2 (resto)
    cout << "a / 4.0                     = " << a / 4.0 << endl;                     // 2.5
    cout << "static_cast<double>(a / b)  = " << static_cast<double>(a / b) << endl;  // 2 (tarde!)
    cout << "1.0 * a / b                 = " << 1.0 * a / b << endl;                 // 2.5

    // Con fixed y setprecision(1) se ve el decimal aunque sea .0
    cout << fixed << setprecision(1);
    cout << "x con 1 decimal             = " << x << endl;                           // 2.0
    cout << "y con 1 decimal             = " << y << endl;                           // 2.5

    return 0;
}
