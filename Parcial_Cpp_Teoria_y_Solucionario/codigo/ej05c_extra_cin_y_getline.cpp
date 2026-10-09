// =============================================================
// Ejercicio 5 - EXTRA: la trampa de mezclar "cin >>" con getline()
// -------------------------------------------------------------
// Despues de "cin >> edad;" el Enter (el caracter '\n') se queda
// esperando en el buffer de entrada. Un getline() que venga despues
// lo encuentra y "lee" una linea VACIA.
// Solucion: getline(cin >> ws, nombre);   (ws salta espacios y Enter)
//           o bien:  cin.ignore();  antes del getline.
// =============================================================

#include <iostream>
#include <string>
using namespace std;

int main() {
    int edad;
    string nombre;

    cout << "Ingrese su edad: ";
    cin >> edad;                      // lee el numero, pero deja el '\n' en el buffer

    cout << "Ingrese nombre completo: ";
    getline(cin >> ws, nombre);       // "cin >> ws" descarta el '\n' pendiente

    cout << "Cliente: " << nombre << " (" << edad << " anios)" << endl;
    return 0;
}
