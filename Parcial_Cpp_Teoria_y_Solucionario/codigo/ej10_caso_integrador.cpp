// =============================================================
// Ejercicio 10 - Caso integrador de preparacion     (Nivel: Avanzado)
// Restriccion: SIN if, switch, for, while ni do-while (solo secuencia).
// -------------------------------------------------------------
// Codigo de venta:  TEC-2026-0087-LIM
//   T  E  C  -  2  0  2  6  -  0  0  8  7  -  L  I  M
//   0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16
//   categoria = substr(0, 3)   -> "TEC"
//   anio      = substr(4, 4)   -> "2026"
//   operacion = substr(9, 4)   -> "0087"
//   sede      = substr(14, 3)  -> "LIM"
// =============================================================

#include <iostream>
#include <iomanip>     // fixed, setprecision
#include <string>      // string, getline, substr
using namespace std;

int main() {
    // ================= DECLARACION DE VARIABLES =================
    string codigoVenta, cliente, producto;
    double precioUnitario, porcentajeDescuento;
    int    cantidad;

    // ======================== ENTRADA ===========================
    // Primero leemos TODOS los textos con getline y al final los numeros
    // con cin >>. Asi evitamos la trampa del '\n' que deja cin >>.
    cout << "Codigo de venta (ej. TEC-2026-0087-LIM): ";
    getline(cin, codigoVenta);
    cout << "Nombre del cliente: ";
    getline(cin, cliente);
    cout << "Nombre del producto: ";
    getline(cin, producto);
    cout << "Precio unitario: ";
    cin >> precioUnitario;
    cout << "Cantidad: ";
    cin >> cantidad;
    cout << "Porcentaje de descuento: ";
    cin >> porcentajeDescuento;

    // ======================== PROCESO ===========================
    // Parte A - Procesamiento de la cadena con substr(inicio, cantidad)
    string categoria = codigoVenta.substr(0, 3);
    string anio      = codigoVenta.substr(4, 4);
    string operacion = codigoVenta.substr(9, 4);
    string sede      = codigoVenta.substr(14, 3);

    // Parte B - Calculos
    double subtotal       = precioUnitario * cantidad;
    double montoDescuento = subtotal * (porcentajeDescuento / 100);
    double total          = subtotal - montoDescuento;

    // ======================== SALIDA ============================
    // Parte C - Resumen (tildes omitidas a proposito: ver nota del codigo 1)
    cout << fixed << setprecision(2);
    cout << endl;
    cout << "============ RESUMEN DE VENTA ============" << endl;
    cout << endl;
    cout << "Cliente:         " << cliente << endl;
    cout << "Producto:        " << producto << endl;
    cout << endl;
    cout << "Categoria:       " << categoria << endl;
    cout << "Anio:            " << anio << endl;
    cout << "Operacion:       " << operacion << endl;
    cout << "Sede:            " << sede << endl;
    cout << endl;
    cout << "Precio unitario: S/ " << precioUnitario << endl;
    cout << "Cantidad:        " << cantidad << endl;
    cout << "Subtotal:        S/ " << subtotal << endl;
    cout << "Descuento:       S/ " << montoDescuento << endl;
    cout << "TOTAL:           S/ " << total << endl;

    return 0;
}
