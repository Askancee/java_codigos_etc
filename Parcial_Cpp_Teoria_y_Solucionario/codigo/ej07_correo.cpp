// =============================================================
// Ejercicio 7 - Busqueda y reemplazo en strings  (Nivel: Medio-alto)
// Objetivo: usar length(), find(), substr() y replace().
// -------------------------------------------------------------
//   a l u m n o @ u n i v  e  r  s  i  d  a  d  .  e  d  u  .  p  e
//   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
// =============================================================

#include <iostream>
#include <string>
using namespace std;

int main() {
    string correo = "alumno@universidad.edu.pe";

    // 1) Longitud: cantidad total de caracteres
    int longitud = correo.length();                  // 25

    // 2) Posicion (indice) donde esta la @
    int posArroba = correo.find("@");                // 6

    // 3) Usuario: todo lo que esta ANTES de la @
    //    (desde el indice 0, tantos caracteres como indica posArroba)
    string usuario = correo.substr(0, posArroba);    // "alumno"

    // 4) Dominio: todo lo que esta DESPUES de la @
    //    (sin segundo parametro, substr copia hasta el final)
    string dominio = correo.substr(posArroba + 1);   // "universidad.edu.pe"

    // 5) Reemplazar "universidad" por "unmsm"
    //    replace(inicio, cuantos_borrar, texto_nuevo) MODIFICA la cadena,
    //    por eso trabajamos sobre una copia y conservamos el original.
    string nuevoCorreo = correo;
    int posPalabra = nuevoCorreo.find("universidad");   // 7
    nuevoCorreo.replace(posPalabra, 11, "unmsm");        // 11 = letras de "universidad"

    // SALIDA
    cout << "Correo original: " << correo      << endl;
    cout << "Longitud: "        << longitud    << endl;
    cout << "Posicion de @: "   << posArroba   << endl;
    cout << "Usuario: "         << usuario     << endl;
    cout << "Dominio: "         << dominio     << endl;
    cout << "Nuevo correo: "    << nuevoCorreo << endl;

    return 0;
}
