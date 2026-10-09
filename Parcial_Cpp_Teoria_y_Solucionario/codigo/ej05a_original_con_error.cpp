// =============================================================
// Ejercicio 5 - Debugging de entrada con string     (Nivel: Medio)
// VERSION ORIGINAL (CON ERROR), tal como aparece en el enunciado.
// Si el usuario escribe: Juan Carlos Perez
// el programa muestra solo:  Cliente: Juan
// Motivo: "cin >>" deja de leer en el primer espacio en blanco.
// =============================================================

#include <iostream>
#include <string>
using namespace std;

int main() {
    string nombre;

    cout << "Ingrese nombre completo: ";
    cin >> nombre;                    // <-- PROBLEMA: lee solo hasta el primer espacio

    cout << "Cliente: " << nombre;
    return 0;
}
