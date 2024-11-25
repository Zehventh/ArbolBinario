import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ArbolBinario<T> {
    private Nodo<T>[] nodos;
    private int cursor;
    private int raiz;

    @SuppressWarnings("unchecked")
    public ArbolBinario() {
        nodos = new Nodo[100]; // Tamaño inicial del árbol
        for (int i = 0; i < nodos.length; i++) {
            nodos[i] = new Nodo<>();
        }
        cursor = 0;
        raiz = -1; // Árbol inicialmente vacío
    }

    public int CREA(T etiqueta, int... hijos) {
        if (cursor >= nodos.length) {
            throw new RuntimeException("No hay espacio para más nodos.");
        }

        int nuevoNodo = cursor++;
        nodos[nuevoNodo].setEtiqueta(etiqueta);

        if (hijos.length > 0) {
            nodos[nuevoNodo].setHijoMasIzquierdo(hijos[0]);

            for (int i = 0; i < hijos.length - 1; i++) {
                nodos[hijos[i]].setHermanoDerecho(hijos[i + 1]);
            }
        }

        if (raiz == -1) {
            raiz = nuevoNodo; // Establecer la raíz si es el primer nodo
        }

        return nuevoNodo;
    }

    public int getRaiz() {
        return raiz;
    }

    public void anula() {
        cursor = 0;
        raiz = -1;
    }

    public int padre(int n) {
        for (int i = 0; i < cursor; i++) {
            int hijo = nodos[i].getHijoMasIzquierdo();
            while (hijo != -1) {
                if (hijo == n) return i;
                hijo = nodos[hijo].getHermanoDerecho();
            }
        }
        return -1; // No tiene padre
    }

    public int hijoMasIzquierdo(int n) {
        return nodos[n].getHijoMasIzquierdo();
    }

    public int hermanoDerecho(int n) {
        return nodos[n].getHermanoDerecho();
    }

    public T etiqueta(int n) {
        return nodos[n].getEtiqueta();
    }

    public List<Integer> ordPrev(int nodo) {
        List<Integer> resultado = new ArrayList<>();
        if (nodo == -1) return resultado;

        resultado.add(nodo);
        int hijo = nodos[nodo].getHijoMasIzquierdo();
        while (hijo != -1) {
            resultado.addAll(ordPrev(hijo));
            hijo = nodos[hijo].getHermanoDerecho();
        }
        return resultado;
    }

    public List<Integer> ordSim(int nodo) {
        List<Integer> resultado = new ArrayList<>();
        if (nodo == -1) return resultado;

        int hijo = nodos[nodo].getHijoMasIzquierdo();
        if (hijo != -1) resultado.addAll(ordSim(hijo));
        resultado.add(nodo);

        while (hijo != -1) {
            hijo = nodos[hijo].getHermanoDerecho();
            if (hijo != -1) resultado.addAll(ordSim(hijo));
        }
        return resultado;
    }

    public List<Integer> ordPos(int nodo) {
        List<Integer> resultado = new ArrayList<>();
        if (nodo == -1) return resultado;

        int hijo = nodos[nodo].getHijoMasIzquierdo();
        while (hijo != -1) {
            resultado.addAll(ordPos(hijo));
            hijo = nodos[hijo].getHermanoDerecho();
        }
        resultado.add(nodo);
        return resultado;
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