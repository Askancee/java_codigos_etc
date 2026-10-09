// =============================================================
// Ejercicio 8 - Problema comercial integrado      (Nivel: Medio-alto)
// -------------------------------------------------------------
// ENTRADA : producto (string), precio unitario (double),
//           cantidad (int), porcentaje de descuento (double)
// PROCESO : subtotal  = precio * cantidad
//           descuento = subtotal * (porcentaje / 100)
//           total     = subtotal - descuento
// SALIDA  : subtotal, descuento y total con 2 decimales
// =============================================================

#include <iostream>
#include <iomanip>     // fixed, setprecision
#include <string>      // string, getline
using namespace std;

int main() {
    // ---------- Declaracion de variables ----------
    string producto;       // nombre del producto (puede tener espacios)
    double precio;         // precio unitario (con decimales)
    int    cantidad;       // unidades compradas (entero)
    double porcentaje;     // % de descuento (puede ser 7.5)
    double subtotal, descuento, total;

    // ---------- ENTRADA ----------
    cout << "Producto: ";
    getline(cin, producto);        // primero el texto (getline), luego los numeros (cin)
    cout << "Precio: ";
    cin >> precio;
    cout << "Cantidad: ";
    cin >> cantidad;
    cout << "Descuento (%): ";
    cin >> porcentaje;

    // ---------- PROCESO ----------
    subtotal  = precio * cantidad;
    descuento = subtotal * (porcentaje / 100);   // 7.5 / 100 = 0.075
    total     = subtotal - descuento;

    // ---------- SALIDA ----------
    cout << fixed << setprecision(2);            // desde aqui: 2 decimales
    cout << endl;
    cout << "========= DETALLE DE LA COMPRA =========" << endl;
    cout << "Producto       : " << producto << endl;
    cout << "Precio unitario: S/ " << precio << endl;
    cout << "Cantidad       : " << cantidad << endl;
    cout << "Descuento      : " << porcentaje << " %" << endl;
    cout << "----------------------------------------" << endl;
    cout << "Subtotal       : S/ " << subtotal << endl;
    cout << "Monto descuento: S/ " << descuento << endl;
    cout << "TOTAL A PAGAR  : S/ " << total << endl;

    return 0;
}
