// =============================================================
// Ejercicio 2 - Entrada, proceso y salida           (Nivel: Basico)
// Calcula el pago de un trabajador:  Pago = Horas x Tarifa
// -------------------------------------------------------------
// ENTRADA : horas trabajadas (int), pago por hora (double)
// PROCESO : pago = horas * tarifa
// SALIDA  : pago total (double, con 2 decimales)
// =============================================================

#include <iostream>
#include <iomanip>     // para fixed y setprecision (formato de decimales)
using namespace std;

int main() {
    // 1) Declaracion de variables
    int    horas;      // horas trabajadas (numero entero)
    double tarifa;     // pago por hora en soles (tiene decimales: 25.50)
    double pago;       // resultado: pago total

    // 2) ENTRADA: pedimos los datos al usuario
    cout << "Horas trabajadas: ";
    cin >> horas;
    cout << "Pago por hora: ";
    cin >> tarifa;

    // 3) PROCESO: aplicamos la formula
    pago = horas * tarifa;          // int * double -> el resultado es double

    // 4) SALIDA: mostramos el resultado con 2 decimales
    cout << fixed << setprecision(2);
    cout << "Pago total: S/ " << pago << endl;

    return 0;
}
