// =============================================================
// Ejercicio 9 - UML basico + C++                    (Nivel: Avanzado)
// VERSION COMPLETA (class): traduccion fiel del diagrama UML.
// -------------------------------------------------------------
//   UML                                C++
//   - atributo  (privado)       ->     private:
//   + operacion (publica)       ->     public:
//   - precio : double           ->     double precio;
//   + calcularValorStock(): double ->  double calcularValorStock()
// =============================================================

#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

class Producto {
private:                        // "-" en UML: solo la propia clase los usa
    string codigo;
    string nombre;
    double precio;
    int    stock;

public:                         // "+" en UML: se pueden usar desde main
    // Constructor: se ejecuta al crear el objeto y le da sus valores iniciales
    Producto(string c, string n, double p, int s) {
        codigo = c;
        nombre = n;
        precio = p;
        stock  = s;
    }

    void mostrarDatos() {
        cout << "Codigo : " << codigo << endl;
        cout << "Nombre : " << nombre << endl;
        cout << "Precio : S/ " << precio << endl;
        cout << "Stock  : " << stock << " unidades" << endl;
    }

    double calcularValorStock() {
        return precio * stock;
    }
};

int main() {
    cout << fixed << setprecision(2);

    // Creamos un objeto de la clase Producto (se llama al constructor)
    Producto p1("PRD-0012", "Mouse inalambrico", 45.90, 30);

    p1.mostrarDatos();
    cout << "Valor del stock: S/ " << p1.calcularValorStock() << endl;

    // p1.precio = 10;   // ERROR de compilacion: precio es private

    return 0;
}
