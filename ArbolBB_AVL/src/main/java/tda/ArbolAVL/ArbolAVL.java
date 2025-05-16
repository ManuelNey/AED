package tda.ArbolAVL;

import tda.ArbolBB.ArbolBB;

public class ArbolAVL<T> extends ArbolBB<T> {
    public ArbolAVL()
    {
        super();
    }
    public boolean insertar(Comparable etiqueta, T unDato) {
        if (etiqueta == null || unDato == null) {
            return false;
        }
        ElementoAVL<T> elemento = new ElementoAVL<T>(etiqueta, unDato);
        if (super.getRaiz() == null) {
            super.setRaiz((ElementoAVL) elemento);
            return true;
        }
        else {
            ElementoAVL elementoBuscado = (ElementoAVL) getRaiz().buscar(etiqueta);
            if (elementoBuscado != null) {
                return false;
            }
            ElementoAVL raiz= (ElementoAVL) getRaiz();
            setRaiz(raiz.insertar(elementoBuscado));
            return true;
        }
    }
}
