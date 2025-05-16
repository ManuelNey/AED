package tda.ArbolAVL;

import tda.ArbolBB.IElementoAB;
import tda.ArbolBB.TElementoAB;

public class ElementoAVL<T> extends TElementoAB<T> {
    private int altura;

    public ElementoAVL(Comparable etiqueta, T dato)
    {
        super(etiqueta, dato);
        altura = 0;
    }
    private static int obtenerAlturaDadoNodo(ElementoAVL elementoAVL)
    {
        if (elementoAVL.getHijoDer() == null && elementoAVL.getHijoIzq() == null)
        {
            return -1;
        }
        return elementoAVL.altura;
    }
    private void actualizarAltura()
    {
        altura = 1 + Math.max(obtenerAlturaDadoNodo((ElementoAVL) getHijoDer()),obtenerAlturaDadoNodo((ElementoAVL) getHijoIzq()));
    }

    private boolean insertar()
}
