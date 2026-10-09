// =============================================================
// Ejercicio 9 - UML basico + C++                    (Nivel: Avanzado)
// VERSION SIMPLIFICADA (struct): la "estructura" que pide el enunciado.
// -------------------------------------------------------------
// Un struct agrupa varios datos relacionados bajo un mismo nombre.
// Aqui ademas le agregamos las dos operaciones del diagrama UML.
// =============================================================

#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

struct Producto {
    // ---- Atributos (datos) ----
    string codigo;     // texto: puede tener letras y ceros a la izquierda
    string nombre;     // texto
    double precio;     // real: tiene decimales
    int    stock;      // entero: unidades disponibles

    // ---- Operaciones (funciones que pertenecen al struct) ----
    void mostrarDatos() {
        cout << "Codigo : " << codigo << endl;
        cout << "Nombre : " << nombre << endl;
        cout << "Precio : S/ " << precio << endl;
        cout << "Stock  : " << stock << " unidades" << endl;
    }

    double calcularValorStock() {
        return precio * stock;        // valor de todas las unidades en almacen
    }
};

int main() {
    cout << fixed << setprecision(2);

    Producto p;                       // p es un OBJETO (una variable) de tipo Producto
    p.codigo = "PRD-0012";            // con el punto (.) accedemos a cada atributo
    p.nombre = "Mouse inalambrico";
    p.precio = 45.90;
    p.stock  = 30;

    p.mostrarDatos();                 // llamamos a la operacion
    cout << "Valor del stock: S/ " << p.calcularValorStock() << endl;

    return 0;
}
