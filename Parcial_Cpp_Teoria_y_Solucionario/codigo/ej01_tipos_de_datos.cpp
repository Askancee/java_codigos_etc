// =============================================================
// Ejercicio 1 - Tipos de datos y variables          (Nivel: Basico)
// Objetivo: elegir el tipo de dato C++ adecuado para cada dato
//           y declarar las variables correspondientes.
// =============================================================
// Nota: en los codigos evitamos tildes y la letra enie para que
// el texto se vea bien en cualquier consola (Windows, Linux, etc.).

#include <iostream>
#include <string>      // necesario para poder usar el tipo string
using namespace std;

int main() {
    // ---------- Declaracion + inicializacion ----------
    string nombreCompleto  = "Ana Lucia Torres Vega"; // texto (puede tener espacios)
    int    edad            = 19;                      // numero entero, sin decimales
    double notaFinal       = 15.75;                   // numero real (con decimales)
    string codigoMatricula = "202601234";             // es un CODIGO: se guarda como texto
    bool   aprobado        = true;                    // solo puede ser true o false
    char   inicialApellido = 'T';                     // UN solo caracter, comillas simples

    // ---------- Mostramos los valores para comprobar ----------
    cout << "Nombre completo : " << nombreCompleto << endl;
    cout << "Edad            : " << edad << endl;
    cout << "Nota final      : " << notaFinal << endl;
    cout << "Codigo matricula: " << codigoMatricula << endl;
    cout << "Aprobado        : " << aprobado << "   (cout muestra 1 = true, 0 = false)" << endl;
    cout << "Aprobado (texto): " << boolalpha << aprobado << endl;  // boolalpha -> true/false
    cout << "Inicial apellido: " << inicialApellido << endl;

    // ---------- Extra: bytes que ocupa cada tipo (sizeof) ----------
    cout << endl << "--- Bytes que ocupa cada tipo en memoria ---" << endl;
    cout << "int    : " << sizeof(int)    << " bytes" << endl;
    cout << "double : " << sizeof(double) << " bytes" << endl;
    cout << "char   : " << sizeof(char)   << " byte"  << endl;
    cout << "bool   : " << sizeof(bool)   << " byte"  << endl;

    return 0;
}
