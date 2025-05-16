package tda.ArbolBB;

import java.util.LinkedList;
import java.util.List;

public class TElementoAB<T> implements IElementoAB<T> {
    private Comparable etiqueta;
    private T datos;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;

    public TElementoAB(Comparable etiqueta, T datos) {
        this.etiqueta = etiqueta;
        this.datos = datos;
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    public TElementoAB<T> getPadre(Comparable unaEtiqueta) {
        if (hijoIzq != null && hijoIzq.getEtiqueta().compareTo(unaEtiqueta) == 0 ||
                hijoDer != null && hijoDer.getEtiqueta().compareTo(unaEtiqueta) == 0) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0 && hijoIzq != null) {
            return hijoIzq.getPadre(unaEtiqueta);
        } else if (unaEtiqueta.compareTo(etiqueta) > 0 && hijoDer != null) {
            return hijoDer.getPadre(unaEtiqueta);
        } else {
            return null;
        }
    }


    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    public TElementoAB<T> getHijoIzq() {
        return this.hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return this.hijoDer;
    }


    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            return (this.hijoIzq != null) ? this.hijoIzq.buscar(unaEtiqueta) : null;
        } else if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            return (this.hijoDer != null) ? this.hijoDer.buscar(unaEtiqueta) : null;
        }
        return this;
    }

    public T getDatos() {
        return this.datos;
    }

    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = this.hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = this.hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        return quitarNodo();

    }

    public TElementoAB quitarNodo() {

        if (hijoIzq == null) {
            return hijoDer;
        }
        if (hijoDer == null) {
            return hijoIzq;
        }

        TElementoAB elHijo = this.hijoIzq;
        TElementoAB elPadre = this;
        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }
        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(this.hijoIzq);
        }
        elHijo.setHijoDer(this.hijoDer);
        return elHijo;
    }

    public int obtenerTamaño() {
        int tamañoIzq = 0;
        int tamañoDer = 0;

        if (this.hijoIzq == null && this.hijoDer == null) {
            return 1;
        }
        if (this.hijoIzq != null) {
            tamañoIzq = this.hijoIzq.obtenerTamaño();
        }
        if (this.hijoDer != null) {
            tamañoDer = hijoDer.obtenerTamaño();
        }

        return 1 + tamañoIzq + tamañoDer;
    }

    public boolean insertar(IElementoAB<T> nodo) {
        TElementoAB elemento= (TElementoAB<T>) nodo;
        if (elemento.getEtiqueta().compareTo(this.etiqueta) == 0) {
            return false;
        } else if (elemento.getEtiqueta().compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq == null) {
                this.hijoIzq = elemento;
                return true;
            } else {
                return this.hijoIzq.insertar(elemento);
            }
        } else {
            if (this.hijoDer == null) {
                this.hijoDer = elemento;
                return true;
            } else {
                return this.hijoDer.insertar(elemento);
            }
        }
    }

    public void preOrden(LinkedList<T> unaLista) {
        unaLista.add(this.datos);
        if (this.hijoIzq != null) {
            this.hijoIzq.preOrden(unaLista);
        }
        if (this.hijoDer != null) {
            this.hijoDer.preOrden(unaLista);
        }
    }


    public void inOrden(LinkedList<T> unaLista) {
        if (this.hijoIzq != null) {
            this.hijoIzq.inOrden(unaLista);
        }
        unaLista.add(this.datos);
        if (this.hijoDer != null) {
            this.hijoDer.inOrden(unaLista);
        }

    }

    public void postOrden(LinkedList<T> unaLista) {
        if (this.hijoIzq != null) {
            this.hijoIzq.postOrden(unaLista);
        }
        if (this.hijoDer != null) {
            this.hijoDer.postOrden(unaLista);
        }
        unaLista.add(this.datos);
    }

    public int obtenerAltura() {
        int AlturaIzq = 0;
        int AlturaDer = 0;
        if (this.hijoIzq == null && this.hijoDer == null) {
            return 1;
        }
        if (this.hijoIzq != null) {
            AlturaIzq = this.hijoIzq.obtenerAltura();
        }
        if (this.hijoDer != null) {
            AlturaDer = this.hijoDer.obtenerAltura();
        }
        return 1 + Math.max(AlturaIzq, AlturaDer);
    }

    public int cantHojas() {
        int HojasIzq = 0;
        int HojasDer = 0;
        if (this.hijoIzq == null && this.hijoDer == null) {
            return 1;
        }
        if (this.hijoIzq != null) {
            HojasIzq = this.hijoIzq.cantHojas();
        }
        if (this.hijoDer != null) {
            HojasDer = this.hijoDer.cantHojas();
        }
        return HojasIzq + HojasDer;
    }

    public int encontarNivel(int nivelActual, Comparable clave) {
        if (this.etiqueta.compareTo(clave) == 0) {
            return nivelActual;
        } else if (this.etiqueta.compareTo(clave) > 0) {
            if (this.hijoIzq != null) {
                return this.hijoIzq.encontarNivel(nivelActual + 1, clave);
            }
            return -1;
        } else {
            if (this.hijoDer != null) {
                return this.hijoDer.encontarNivel(nivelActual + 1, clave);
            }
            return -1;
        }

    }

    public int cantNodosNivel(int nivelActual, int nivelBuscado) {
        int hijosNivelIzq = 0;
        int hijosNivelDer = 0;
        if (nivelActual == nivelBuscado) {
            return 1;
        }
        if (this.hijoIzq != null) {
            hijosNivelIzq = this.hijoIzq.cantNodosNivel(nivelActual + 1, nivelBuscado);
        }
        if (this.hijoDer != null) {
            hijosNivelDer = this.hijoDer.cantNodosNivel(nivelActual + 1, nivelBuscado);
        }
        return hijosNivelIzq + hijosNivelDer;
    }

    public void hojaYNivel(int nivelActual) {
        if (this.hijoIzq == null && this.hijoDer == null) {
            System.out.println("Nivel: " + nivelActual + " - Hoja: " + this.etiqueta);
        }
        if (this.hijoIzq != null) {
            this.hijoIzq.hojaYNivel(nivelActual + 1);
        }
        if (this.hijoDer != null) {
            this.hijoDer.hojaYNivel(nivelActual + 1);
        }

    }

    public void verificarEsABB(List<Comparable> lista) {
        if (this.hijoIzq != null) {
            this.hijoIzq.verificarEsABB(lista);
        }
        lista.add(this.etiqueta);

        if (this.hijoDer != null) {
            this.hijoDer.verificarEsABB(lista);
        }
    }

    public Comparable getMenorClave() {

        if (this.hijoIzq == null) {
            return this.etiqueta;
        } else {
            return this.hijoIzq.getMenorClave();
        }
    }

    public Comparable getMayorClave() {

        if (this.hijoDer == null) {
            return this.etiqueta;
        } else {
            return this.hijoDer.getMayorClave();
        }
    }

    public Comparable getClaveInmediataAnterior(Comparable clave) {
        Comparable claveInmediata = null;

        if (this.etiqueta.compareTo(clave) < 0) {
            // La clave actual es una candidata válida
            claveInmediata = this.etiqueta;

            if (this.hijoDer != null) {
                Comparable posible = this.hijoDer.getClaveInmediataAnterior(clave);

                if (posible != null && posible.compareTo(claveInmediata) > 0) {
                    claveInmediata = posible; // hay una mejor candidata en el hijo derecho
                }
            }

        } else {
            if (this.hijoIzq != null) {
                claveInmediata = this.hijoIzq.getClaveInmediataAnterior(clave);
            }
        }

        return claveInmediata;
    }

    public void setHijoIzq(IElementoAB<T> elemento) {
        hijoIzq = (TElementoAB<T>) elemento;
    }

    public void setHijoDer(IElementoAB<T> elemento) {
        hijoDer = (TElementoAB<T>) elemento;
    }

}
