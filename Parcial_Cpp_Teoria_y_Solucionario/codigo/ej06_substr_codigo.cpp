// =============================================================
// Ejercicio 6 - Procesamiento de codigo con substr() (Nivel: Medio)
// Codigo universitario con formato:  FIEE-2026-0145
//   FIEE = facultad, 2026 = anio, 0145 = correlativo
// -------------------------------------------------------------
// Indices de cada caracter (se empieza a contar desde 0):
//   F  I  E  E  -  2  0  2  6  -  0  1  4  5
//   0  1  2  3  4  5  6  7  8  9  10 11 12 13
// substr(inicio, cantidad) copia "cantidad" caracteres desde "inicio".
// =============================================================

#include <iostream>
#include <string>
using namespace std;

int main() {
    string codigo;

    // ENTRADA (el codigo no tiene espacios, por eso basta con cin >>)
    cout << "Ingrese el codigo universitario (ej. FIEE-2026-0145): ";
    cin >> codigo;

    // PROCESO: extraemos cada parte con substr(inicio, cantidad)
    string facultad    = codigo.substr(0, 4);    // desde el indice 0, 4 caracteres
    string anio        = codigo.substr(5, 4);    // desde el indice 5, 4 caracteres
    string correlativo = codigo.substr(10, 4);   // desde el indice 10, 4 caracteres

    // SALIDA
    cout << "Facultad: "    << facultad    << endl;
    cout << "Anio: "        << anio        << endl;   // en papel se escribe con enie
    cout << "Correlativo: " << correlativo << endl;

    // Pregunta del enunciado: que devuelve codigo.substr(5,4)?
    cout << "codigo.substr(5,4) devuelve: " << codigo.substr(5, 4) << endl;

    return 0;
}
