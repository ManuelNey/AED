package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tda.ArbolAVL.ArbolAVL;
import tda.ArbolAVL.ElementoAVL;
import tda.ArbolBB.ArbolBB;
import tda.ArbolBB.IElementoAB;
import tda.ArbolBB.TElementoAB;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TestsAVL<T> {
    private ArbolAVL<T> arbol;

    @BeforeEach
    public void setup() {
        arbol = new ArbolAVL();
    }

    @Test
    public void insertarDesbalanceLinealHaciaLaDerechaRAIZND() {
        arbol.insertar(56, 34);
        arbol.insertar(65, null);
        arbol.insertar(70, null);

        assertEquals(65, arbol.getRaiz().getEtiqueta());
        assertEquals(56, arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(70, arbol.getRaiz().getHijoDer().getEtiqueta());
    }
}
    /*
    @Test
    public void insertarDesbalanceDerechaIzquierdaRAIZND(){
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL65=new ElementoAVL(65,"ElementoAVL");
        IElementoAVL elementoAVL70=new ElementoAVL(70,"ElementoAVL");

        arbol.insertar(56,elementoAVL56);
        arbol.insertar(70,elementoAVL70);
        arbol.insertar(65,elementoAVL65);

        assertEquals(65,arbol.getRaiz().getEtiqueta());
        assertEquals(56,arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());

    }

    @Test
    public void insertarDesbalanceLinealHaciaLaIzquierdaRAIZND(){
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL65=new ElementoAVL(65,"ElementoAVL");
        IElementoAVL elementoAVL70=new ElementoAVL(70,"ElementoAVL");

        arbol.insertar(70,elementoAVL70);
        arbol.insertar(65,elementoAVL65);
        arbol.insertar(56,elementoAVL56);

        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(56,arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(65,arbol.getRaiz().getEtiqueta());

    }


    @Test
    public void insertarDesbalanceIzquierdaDerechaRAIZND(){
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL65=new ElementoAVL(65,"ElementoAVL");
        IElementoAVL elementoAVL70=new ElementoAVL(70,"ElementoAVL");

        arbol.insertar(70,elementoAVL70);
        arbol.insertar(56,elementoAVL56);
        arbol.insertar(65,elementoAVL65);

        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(56,arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(65,arbol.getRaiz().getEtiqueta());
    }

    @Test
    public void insertarDesbalanceIzquierdaDerecha(){
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL65=new ElementoAVL(65,"ElementoAVL");
        IElementoAVL elementoAVL70=new ElementoAVL(70,"ElementoAVL");
        IElementoAVL elementoAVL57=new ElementoAVL(57,"ElementoAVL");
        IElementoAVL elementoAVL59=new ElementoAVL(59,"ElementoAVL");

        arbol.insertar(65,elementoAVL65);
        arbol.insertar(59,elementoAVL59);
        arbol.insertar(70,elementoAVL70);
        arbol.insertar(56,elementoAVL56);
        arbol.insertar(57,elementoAVL57);

        assertEquals(65,arbol.getRaiz().getEtiqueta());
        assertEquals(57,arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
    }


    @Test
    public void insertarDesbalanceDerechaIzquierda(){
        IElementoAVL elementoAVL59=new ElementoAVL(59,"ElementoAVL");
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL77=new ElementoAVL(77,"ElementoAVL");
        IElementoAVL elementoAVL82=new ElementoAVL(82,"ElementoAVL");
        IElementoAVL elementoAVL80=new ElementoAVL(80,"ElementoAVL");

        arbol.insertar(59,elementoAVL59);
        arbol.insertar(56,elementoAVL56);
        arbol.insertar(77,elementoAVL77);

        arbol.insertar(82,elementoAVL82);

        arbol.insertar(80,elementoAVL80);

        assertEquals(59,arbol.getRaiz().getEtiqueta());
        assertEquals(56,arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(80,arbol.getRaiz().getHijoDer().getEtiqueta());
    }

    @Test
    public void insertarDesbalanceLinealHaciaLaIzquierda(){
        IElementoAVL elementoAVL59=new ElementoAVL(59,"ElementoAVL");
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL77=new ElementoAVL(77,"ElementoAVL");
        IElementoAVL elementoAVL82=new ElementoAVL(82,"ElementoAVL");
        IElementoAVL elementoAVL80=new ElementoAVL(80,"ElementoAVL");

        arbol.insertar(80,elementoAVL80);
        arbol.insertar(82,elementoAVL82);
        arbol.insertar(77,elementoAVL77);
        arbol.insertar(59,elementoAVL59);
        arbol.insertar(56,elementoAVL56);

        assertEquals(80,arbol.getRaiz().getEtiqueta());
        assertEquals(59,arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(82,arbol.getRaiz().getHijoDer().getEtiqueta());

    }


    @Test
    public void insertarDesbalanceLinealHaciaLaDerecha(){
        IElementoAVL elementoAVL59=new ElementoAVL(59,"ElementoAVL");
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL77=new ElementoAVL(77,"ElementoAVL");
        IElementoAVL elementoAVL82=new ElementoAVL(82,"ElementoAVL");
        IElementoAVL elementoAVL80=new ElementoAVL(80,"ElementoAVL");

        arbol.insertar(59,elementoAVL59);
        arbol.insertar(56,elementoAVL56);
        arbol.insertar(77,elementoAVL77);
        arbol.insertar(80,elementoAVL80);
        arbol.insertar(82,elementoAVL82);

        assertEquals(59,arbol.getRaiz().getEtiqueta());
        assertEquals(56,arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(80,arbol.getRaiz().getHijoDer().getEtiqueta());
    }

    @Test
    public void EliminarElementoRaiz(){
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL65=new ElementoAVL(65,"ElementoAVL");
        IElementoAVL elementoAVL70=new ElementoAVL(70,"ElementoAVL");
        arbol.insertar(56,elementoAVL56);
        arbol.insertar(65,elementoAVL65);
        arbol.insertar(70,elementoAVL70);
        arbol.eliminar(56);
        assertEquals(65,arbol.getRaiz().getEtiqueta());
        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceLinealHaciaLaDerechaRAIZND(){
        IElementoAVL elementoAVL50=new ElementoAVL(50,"ElementoAVL");
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL65=new ElementoAVL(65,"ElementoAVL");
        IElementoAVL elementoAVL70=new ElementoAVL(70,"ElementoAVL");
        arbol.insertar(56,elementoAVL56);
        arbol.insertar(50,elementoAVL50);
        arbol.insertar(65,elementoAVL65);
        arbol.insertar(70,elementoAVL70);
        arbol.eliminar(50);
        assertEquals(65,arbol.getRaiz().getEtiqueta());
        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(56,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceLinealHaciaLaIzquierdaRAIZND(){
        IElementoAVL elementoAVL50=new ElementoAVL(50,"ElementoAVL");
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL65=new ElementoAVL(65,"ElementoAVL");
        IElementoAVL elementoAVL70=new ElementoAVL(70,"ElementoAVL");
        arbol.insertar(65,elementoAVL65);
        arbol.insertar(70,elementoAVL70);
        arbol.insertar(56,elementoAVL56);
        arbol.insertar(50,elementoAVL50);
        arbol.eliminar(70);
        assertEquals(56,arbol.getRaiz().getEtiqueta());
        assertEquals(65,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(50,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceDerechaIzquierdaRAIZND(){
        IElementoAVL elementoAVL50=new ElementoAVL(50,"ElementoAVL");
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL65=new ElementoAVL(65,"ElementoAVL");
        IElementoAVL elementoAVL70=new ElementoAVL(70,"ElementoAVL");
        arbol.insertar(56,elementoAVL56);
        arbol.insertar(50,elementoAVL50);
        arbol.insertar(70,elementoAVL70);
        arbol.insertar(65,elementoAVL65);
        arbol.eliminar(50);
        assertEquals(65,arbol.getRaiz().getEtiqueta());
        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(56,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceIzquierdaDerechaRAIZND(){
        IElementoAVL elementoAVL50=new ElementoAVL(50,"ElementoAVL");
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL65=new ElementoAVL(65,"ElementoAVL");
        IElementoAVL elementoAVL70=new ElementoAVL(70,"ElementoAVL");
        arbol.insertar(65,elementoAVL65);
        arbol.insertar(70,elementoAVL70);
        arbol.insertar(50,elementoAVL50);
        arbol.insertar(56,elementoAVL56);
        arbol.eliminar(70);
        assertEquals(56,arbol.getRaiz().getEtiqueta());
        assertEquals(65,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(50,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceLinealHaciaLaDerecha(){
        IElementoAVL elementoAVL50=new ElementoAVL(50,"ElementoAVL");
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL65=new ElementoAVL(65,"ElementoAVL");
        IElementoAVL elementoAVL70=new ElementoAVL(70,"ElementoAVL");
        IElementoAVL elementoAVL57=new ElementoAVL(57,"ElementoAVL");
        IElementoAVL elementoAVL77=new ElementoAVL(77,"ElementoAVL");
        IElementoAVL elementoAVL49=new ElementoAVL(49,"ElementoAVL");

        arbol.insertar(56,elementoAVL56);
        arbol.insertar(50,elementoAVL50);
        arbol.insertar(65,elementoAVL65);
        arbol.insertar(57,elementoAVL57);
        arbol.insertar(70,elementoAVL70);
        arbol.insertar(49,elementoAVL49);
        arbol.insertar(77,elementoAVL77);
        arbol.eliminar(57);
        assertEquals(56,arbol.getRaiz().getEtiqueta());
        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(50,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceLinealHaciaLaIzquierda(){
        IElementoAVL elementoAVL50=new ElementoAVL(50,"ElementoAVL");
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL65=new ElementoAVL(65,"ElementoAVL");
        IElementoAVL elementoAVL70=new ElementoAVL(70,"ElementoAVL");
        IElementoAVL elementoAVL57=new ElementoAVL(57,"ElementoAVL");
        IElementoAVL elementoAVL77=new ElementoAVL(77,"ElementoAVL");
        IElementoAVL elementoAVL49=new ElementoAVL(49,"ElementoAVL");

        arbol.insertar(65,elementoAVL65);
        arbol.insertar(77,elementoAVL77);
        arbol.insertar(56,elementoAVL56);
        arbol.insertar(70,elementoAVL70);
        arbol.insertar(57,elementoAVL57);
        arbol.insertar(50,elementoAVL50);
        arbol.insertar(49,elementoAVL49);
        arbol.eliminar(57);
        assertEquals(65,arbol.getRaiz().getEtiqueta());
        assertEquals(77,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(50,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceDerechaIzquierda(){
        IElementoAVL elementoAVL50=new ElementoAVL(50,"ElementoAVL");
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL65=new ElementoAVL(65,"ElementoAVL");
        IElementoAVL elementoAVL70=new ElementoAVL(70,"ElementoAVL");
        IElementoAVL elementoAVL57=new ElementoAVL(57,"ElementoAVL");
        IElementoAVL elementoAVL77=new ElementoAVL(77,"ElementoAVL");
        IElementoAVL elementoAVL49=new ElementoAVL(49,"ElementoAVL");

        arbol.insertar(56,elementoAVL56);
        arbol.insertar(50,elementoAVL50);
        arbol.insertar(65,elementoAVL65);
        arbol.insertar(49,elementoAVL49);
        arbol.insertar(57,elementoAVL57);
        arbol.insertar(77,elementoAVL77);
        arbol.insertar(70,elementoAVL70);
        arbol.eliminar(57);

        assertEquals(56,arbol.getRaiz().getEtiqueta());
        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(50,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceIzquierdaDerecha(){
        IElementoAVL elementoAVL50=new ElementoAVL(50,"ElementoAVL");
        IElementoAVL elementoAVL56=new ElementoAVL(56,"ElementoAVL");
        IElementoAVL elementoAVL65=new ElementoAVL(65,"ElementoAVL");
        IElementoAVL elementoAVL70=new ElementoAVL(70,"ElementoAVL");
        IElementoAVL elementoAVL57=new ElementoAVL(57,"ElementoAVL");
        IElementoAVL elementoAVL77=new ElementoAVL(77,"ElementoAVL");
        IElementoAVL elementoAVL49=new ElementoAVL(49,"ElementoAVL");

        arbol.insertar(65,elementoAVL65);
        arbol.insertar(77,elementoAVL77);
        arbol.insertar(56,elementoAVL56);
        arbol.insertar(70,elementoAVL70);
        arbol.insertar(57,elementoAVL57);
        arbol.insertar(49,elementoAVL49);
        arbol.insertar(50,elementoAVL50);
        arbol.eliminar(57);

        assertEquals(65,arbol.getRaiz().getEtiqueta());
        assertEquals(77,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(50,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }
}

     */
