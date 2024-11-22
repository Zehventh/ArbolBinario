public static void main(String[] args) {
    ArbolBinario<String> arbol = new ArbolBinario<>();
    arbol.crear("A", -1, true); // Nodo raíz
    arbol.crear("B", 0, true); // Hijo izquierdo de A
    arbol.crear("C", 0, false); // Hermano derecho de B
    arbol.crear("D", 1, true); // Hijo izquierdo de B
    arbol.crear("E", 1, false); // Hermano derecho de D

    arbol.imprimirArbol();
}
