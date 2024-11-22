//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public  class ArbolBinario<T> {
    private Nodo<T>[] nodos;
    private int cursor;

    public ArbolBinario() {
        nodos = new Nodo[25];
        for (int i = 0; i < nodos.length; i++) {
            nodos[i] = new Nodo<>();
        }
        cursor = 0; // Comienza vacío
    }

    public boolean crear(T etiqueta, int padre, boolean esHijoIzquierdo) {
        if (cursor >= nodos.length || padre >= cursor) {
            return false; // No hay espacio o el padre no existe
        }

        nodos[cursor].setEtiqueta(etiqueta);

        if (padre == -1) { // Nodo raíz
            cursor++;
            return true;
        }

        if (esHijoIzquierdo) {
            nodos[padre].setHijoMasIzquierdo(cursor);
        } else {
            int actual = nodos[padre].getHijoMasIzquierdo();
            if (actual == -1) {
                nodos[padre].setHijoMasIzquierdo(cursor);
            } else {
                while (nodos[actual].getHermanoDerecho() != -1) {
                    actual = nodos[actual].getHermanoDerecho();
                }
                nodos[actual].setHermanoDerecho(cursor);
            }
        }
        cursor++;
        return true;
    }

    public void imprimirArbol() {
        System.out.println("Cursor\tEtiqueta\tHijoIzq\tHermanoDer");
        for (int i = 0; i < cursor; i++) {
            System.out.printf("%d\t%s\t\t%d\t\t%d\n", i,
                    nodos[i].getEtiqueta(),
                    nodos[i].getHijoMasIzquierdo(),
                    nodos[i].getHermanoDerecho());
        }
    }


}