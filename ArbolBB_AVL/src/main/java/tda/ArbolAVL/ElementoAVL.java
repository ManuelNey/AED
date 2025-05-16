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
    public ElementoAVL<T> insertar(ElementoAVL<T> nuevoElemento) {
        int comparable = getEtiqueta().compareTo(nuevoElemento.getEtiqueta());
        if (comparable == 0) {
            return this;
        } else if (comparable < 0) {
            if (getHijoDer() == null) {
                setHijoDer(nuevoElemento);
            } else {
                ElementoAVL HijoDerecho = (ElementoAVL) getHijoDer();
                setHijoDer(HijoDerecho.insertar(nuevoElemento));
            }
        } else {
            if (getHijoIzq() == null) {
                setHijoIzq(nuevoElemento);
            } else {
                ElementoAVL HijoIzquierdo = (ElementoAVL) getHijoIzq();
                setHijoIzq(HijoIzquierdo.insertar(nuevoElemento));
            }
        }
        actualizarAltura();

        return balancear();

    }
    public ElementoAVL<T> eliminar(Comparable unaEtiqueta) {
        int comparable = getEtiqueta().compareTo(unaEtiqueta);
        if (comparable > 0) {
            if (getHijoIzq() != null) {
                setHijoIzq(getHijoIzq().eliminar(unaEtiqueta));
                actualizarAltura();
                return balancear();
            }
            return this;
        } else if (comparable < 0) {
            if (getHijoDer() != null) {
                setHijoDer(getHijoDer().eliminar(unaEtiqueta));
                actualizarAltura();
                return balancear();
            }
            return this;
        } else {
            ElementoAVL nuevoNodoConEliminacion = (ElementoAVL) quitarNodo();
            if (nuevoNodoConEliminacion != null) {
                actualizarAltura();
                return ((ElementoAVL<T>) nuevoNodoConEliminacion).balancear();
            } else {
                return nuevoNodoConEliminacion;
            }
        }
    }
    private ElementoAVL<T> balancear() {
        int diferencia = obtenerAlturaDadoNodo((ElementoAVL) getHijoIzq())- obtenerAlturaDadoNodo((ElementoAVL) getHijoDer());
        if (diferencia > 1) {
            ElementoAVL elementoIzq = (ElementoAVL) getHijoIzq();
            if (obtenerAlturaDadoNodo((ElementoAVL) elementoIzq.getHijoDer()) > obtenerAlturaDadoNodo((ElementoAVL) elementoIzq.getHijoIzq())) {
                return rotarLR(this);
            } else {
                return rotarLL(this);
            }
        }
        else if (diferencia < -1) {
            ElementoAVL elementoDer = (ElementoAVL) getHijoDer();
            if (obtenerAlturaDadoNodo((ElementoAVL)elementoDer.getHijoIzq()) > obtenerAlturaDadoNodo((ElementoAVL)elementoDer.getHijoDer())) {
                return rotarRL(this);
            } else {
                return rotarRR(this);
            }
        }
        return this;
    }

    private ElementoAVL<T> rotarLL(ElementoAVL<T> k2) {
        ElementoAVL k1 = (ElementoAVL) k2.getHijoIzq();
        k2.setHijoIzq(k1.getHijoDer());
        k1.setHijoDer(k2);
        k2.actualizarAltura();
        k1.actualizarAltura();
        return k1;
    }

    private ElementoAVL<T> rotarRR(ElementoAVL<T> k1) {
        ElementoAVL<T> k2 = (ElementoAVL) k1.getHijoDer();
        k1.setHijoDer(k2.getHijoIzq());
        k2.setHijoIzq(k1);
        k1.actualizarAltura();
        k2.actualizarAltura();
        return k2;
    }

    private ElementoAVL rotarLR(ElementoAVL k3) {
        k3.setHijoIzq(rotarRR((ElementoAVL)k3.getHijoIzq()));
        ElementoAVL<T> result = rotarLL(k3);
        result.actualizarAltura();
        return result;
    }

    private ElementoAVL rotarRL(ElementoAVL k1) {
        k1.setHijoDer(rotarLL((ElementoAVL)k1.getHijoDer()));
        ElementoAVL<T> result = rotarRR(k1);
        result.actualizarAltura();
        return result;
    }
}
