package tda.ArbolBB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArbolBB<T> implements IArbolBB<T> {
    private IElementoAB<T> raiz;

    private int contador;

    public ArbolBB() {
        raiz = null;
        this.contador = 0;
    }

    public void setRaiz(IElementoAB<T> unaRaiz) {
        this.raiz = unaRaiz;
    }

    public int getContador() {
        return this.contador;
    }


    public T buscar(Comparable unaEtiqueta) {
        if (this.raiz == null) {
            return null;
        }
        IElementoAB<T> elemento = this.raiz.buscar(unaEtiqueta);
        if (elemento != null) {
            return elemento.getDatos();
        } else {
            return null;
        }
    }

    public void eliminar(Comparable unaEtiqueta) {
        if (raiz != null) {
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }

    public List<T> preOrden() {
        LinkedList<T> lista = new LinkedList<>();
        if (this.raiz == null) {
            return lista;
        } else {
            raiz.preOrden(lista);
            return lista;
        }
    }

    public List<T> inOrden() {
        LinkedList<T> lista = new LinkedList<>();
        if (this.raiz == null) {
            return lista;
        } else {
            raiz.inOrden(lista);
            return lista;
        }
    }

    public List<T> postOrden() {
        LinkedList<T> lista = new LinkedList<>();
        if (this.raiz == null) {
            return lista;
        } else {
            raiz.postOrden(lista);
            return lista;
        }
    }

    public boolean esVacio() {
        if (this.raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean vaciar() {
        if (this.raiz == null) {
            return false;
        } else {
            this.raiz = null;
            return true;
        }
    }

    public IElementoAB<T> getRaiz() {
        return this.raiz;
    }

    public boolean insertar(Comparable unaEtiqueta, T unDato) {
        if (this.raiz == null) {
            this.raiz = new TElementoAB<>(unaEtiqueta, unDato);
            this.contador++;
            return true;
        } else {
            boolean resultado = this.raiz.insertar(new TElementoAB<>(unaEtiqueta, unDato));
            if (resultado) {
                this.contador++;
            }
            return resultado;
        }
    }

    public int obtenerTamaño() {
        if (this.raiz == null) {
            return 0;
        } else {
            return raiz.obtenerTamaño();
        }
    }

    public int obtenerAltura() {
        if (this.raiz == null) {
            return -1;
        } else {
            TElementoAB raizNodo = (TElementoAB<T>) raiz ;
            return raizNodo.obtenerAltura();
        }
    }

    public int cantHojas() {
        if (this.raiz == null) {
            return 0;
        } else {
            TElementoAB raizNodo = (TElementoAB<T>) raiz ;
            return raizNodo.cantHojas();
        }
    }

    public int encontrarNivel(Comparable clave) {
        if (this.raiz == null) {
            return -1;
        } else {
            TElementoAB raizNodo = (TElementoAB<T>) raiz ;
            return raizNodo.encontarNivel(0, clave);
        }
    }

    public int cantNodosNivel(int nivelBuscado) {
        if (this.raiz == null) {
            return 0;
        } else {
            TElementoAB raizNodo = (TElementoAB<T>) raiz ;
            return raizNodo.cantNodosNivel(0, nivelBuscado);
        }
    }

    public void hojaYNivel() {
        if (this.raiz == null) {
            System.out.println("El Arbol está vacío");
        } else {
            TElementoAB raizNodo = (TElementoAB<T>) raiz ;
            raizNodo.hojaYNivel(0);
        }
    }

    public boolean verificarEsABB() {
        if (raiz == null) {
            return false;
        } else {
            List<Comparable> lista = new ArrayList<>();
            TElementoAB raizNodo = (TElementoAB<T>) raiz ;
            raizNodo.verificarEsABB(lista);
            for (int i = 1; i <= lista.size() - 1; i++) {
                if (lista.get(i - 1).compareTo(lista.get(i)) > 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public Comparable getMenorClave() {

        if (raiz == null) return null;
        TElementoAB raizNodo = (TElementoAB<T>) raiz ;
        return raizNodo.getMenorClave();
    }

    public Comparable getMayorClave() {

        if (raiz == null) return null;
        TElementoAB raizNodo = (TElementoAB<T>) raiz ;
        return raizNodo.getMayorClave();
    }

    public Comparable getClaveInmediataAnterior(Comparable clave) {

        if (raiz == null) return null;
        TElementoAB raizNodo = (TElementoAB<T>) raiz ;
        return raizNodo.getClaveInmediataAnterior(clave);
    }
}