public class Nodo<T> {
    private T etiqueta;
    private int hijoMasIzquierdo;
    private int hermanoDerecho;

    public Nodo() {
        this.etiqueta = null; // Nodo vacío
        this.hijoMasIzquierdo = -1; // Indica "nulo"
        this.hermanoDerecho = -1; // Indica "nulo"
    }

    public T getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(T etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getHijoMasIzquierdo() {
        return hijoMasIzquierdo;
    }

    public void setHijoMasIzquierdo(int hijoMasIzquierdo) {
        this.hijoMasIzquierdo = hijoMasIzquierdo;
    }

    public int getHermanoDerecho() {
        return hermanoDerecho;
    }

    public void setHermanoDerecho(int hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }

    @Override
    public String toString() {
        return "Etiqueta: " + etiqueta +
                ", Hijo más izquierdo: " + hijoMasIzquierdo +
                ", Hermano derecho: " + hermanoDerecho;
    }
}
