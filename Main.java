public static void main(String[] args) {
    ArbolBinario<String> arbol = new ArbolBinario<>();

    int nodo1 = arbol.CREA("1",
            arbol.CREA("2"),
            arbol.CREA("3"),
            arbol.CREA("4",
                    arbol.CREA("6"),
                    arbol.CREA("7")
            )
    );

    System.out.println("Raíz: " + nodo1);
    System.out.println("Orden Previo: " + arbol.ordPrev(nodo1));
    System.out.println("Orden Simétrico: " + arbol.ordSim(nodo1));
    System.out.println("Orden Posterior: " + arbol.ordPos(nodo1));
    arbol.imprimirArbol();
}