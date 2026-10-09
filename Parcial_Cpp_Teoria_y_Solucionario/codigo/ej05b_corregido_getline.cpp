// =============================================================
// Ejercicio 5 - Debugging de entrada con string     (Nivel: Medio)
// VERSION CORREGIDA: usamos getline() para leer la linea completa.
// Si el usuario escribe: Juan Carlos Perez
// el programa muestra:   Cliente: Juan Carlos Perez
// =============================================================

#include <iostream>
#include <string>
using namespace std;

int main() {
    string nombre;

    cout << "Ingrese nombre completo: ";
    getline(cin, nombre);             // lee TODO hasta que el usuario presiona Enter

    cout << "Cliente: " << nombre << endl;
    return 0;
}
