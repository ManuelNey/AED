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
    private ArbolAVL<String> arbol;

    @BeforeEach
    public void setup() {
        arbol = new ArbolAVL();
    }

    @Test
    public void insertarDesbalanceLinealHaciaLaDerechaRAIZND() {
        arbol.insertar(56,"56");
        arbol.insertar(65, "65");
        arbol.insertar(70, "70");

        assertEquals(65, arbol.getRaiz().getEtiqueta());
        assertEquals(56, arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(70, arbol.getRaiz().getHijoDer().getEtiqueta());
    }

    @Test
    public void insertarDesbalanceDerechaIzquierdaRAIZND(){
        arbol.insertar(56,"56");
        arbol.insertar(70,"70");
        arbol.insertar(65,"65");

        assertEquals(65,arbol.getRaiz().getEtiqueta());
        assertEquals(56,arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());

    }

    @Test
    public void insertarDesbalanceLinealHaciaLaIzquierdaRAIZND(){
        arbol.insertar(70,"70");
        arbol.insertar(65,"65");
        arbol.insertar(56,"56");

        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(56,arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(65,arbol.getRaiz().getEtiqueta());

    }


    @Test
    public void insertarDesbalanceIzquierdaDerechaRAIZND(){
        arbol.insertar(70,"70");
        arbol.insertar(56,"56");
        arbol.insertar(65,"65");

        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(56,arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(65,arbol.getRaiz().getEtiqueta());
    }

    @Test
    public void insertarDesbalanceIzquierdaDerecha(){
        arbol.insertar(65,"65");
        arbol.insertar(59,"59");
        arbol.insertar(70,"70");
        arbol.insertar(56,"56");
        arbol.insertar(57,"57");

        assertEquals(65,arbol.getRaiz().getEtiqueta());
        assertEquals(57,arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
    }


    @Test
    public void insertarDesbalanceDerechaIzquierda(){
        arbol.insertar(59,"59");
        arbol.insertar(56,"56");
        arbol.insertar(77,"77");
        arbol.insertar(82,"82");
        arbol.insertar(80,"80");

        assertEquals(59,arbol.getRaiz().getEtiqueta());
        assertEquals(56,arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(80,arbol.getRaiz().getHijoDer().getEtiqueta());
    }

    @Test
    public void insertarDesbalanceLinealHaciaLaIzquierda(){
        arbol.insertar(80,"80");
        arbol.insertar(82,"82");
        arbol.insertar(77,"77");
        arbol.insertar(59,"59");
        arbol.insertar(56,"56");

        assertEquals(80,arbol.getRaiz().getEtiqueta());
        assertEquals(59,arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(82,arbol.getRaiz().getHijoDer().getEtiqueta());

    }


    @Test
    public void insertarDesbalanceLinealHaciaLaDerecha(){
        arbol.insertar(59,"59");
        arbol.insertar(56,"56");
        arbol.insertar(77,"77");
        arbol.insertar(80,"80");
        arbol.insertar(82,"82");

        assertEquals(59,arbol.getRaiz().getEtiqueta());
        assertEquals(56,arbol.getRaiz().getHijoIzq().getEtiqueta());
        assertEquals(80,arbol.getRaiz().getHijoDer().getEtiqueta());
    }

    @Test
    public void EliminarElementoRaiz(){
        arbol.insertar(56,"56");
        arbol.insertar(65,"65");
        arbol.insertar(70,"70");
        arbol.eliminar(56);
        assertEquals(65,arbol.getRaiz().getEtiqueta());
        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceLinealHaciaLaDerechaRAIZND(){
        arbol.insertar(56,"56");
        arbol.insertar(50,"50");
        arbol.insertar(65,"65");
        arbol.insertar(70,"70");
        arbol.eliminar(50);
        assertEquals(65,arbol.getRaiz().getEtiqueta());
        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(56,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceLinealHaciaLaIzquierdaRAIZND(){
        arbol.insertar(65,"elementoAVL65");
        arbol.insertar(70,"elementoAVL70");
        arbol.insertar(56,"elementoAVL56");
        arbol.insertar(50,"elementoAVL50");
        arbol.eliminar(70);
        assertEquals(56,arbol.getRaiz().getEtiqueta());
        assertEquals(65,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(50,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceDerechaIzquierdaRAIZND(){
        arbol.insertar(56,"elementoAVL56");
        arbol.insertar(50,"elementoAVL50");
        arbol.insertar(70,"elementoAVL70");
        arbol.insertar(65,"elementoAVL65");
        arbol.eliminar(50);
        assertEquals(65,arbol.getRaiz().getEtiqueta());
        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(56,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceIzquierdaDerechaRAIZND(){
        arbol.insertar(65,"elementoAVL65");
        arbol.insertar(70,"elementoAVL70");
        arbol.insertar(50,"elementoAVL50");
        arbol.insertar(56,"elementoAVL56");
        arbol.eliminar(70);
        assertEquals(56,arbol.getRaiz().getEtiqueta());
        assertEquals(65,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(50,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceLinealHaciaLaDerecha(){
        arbol.insertar(56,"elementoAVL56");
        arbol.insertar(50,"elementoAVL50");
        arbol.insertar(65,"elementoAVL65");
        arbol.insertar(57,"elementoAVL57");
        arbol.insertar(70,"elementoAVL70");
        arbol.insertar(49,"elementoAVL49");
        arbol.insertar(77,"elementoAVL77");
        arbol.eliminar(57);
        assertEquals(56,arbol.getRaiz().getEtiqueta());
        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(50,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceLinealHaciaLaIzquierda(){
        arbol.insertar(65,"elementoAVL65");
        arbol.insertar(77,"elementoAVL77");
        arbol.insertar(56,"elementoAVL56");
        arbol.insertar(70,"elementoAVL70");
        arbol.insertar(57,"elementoAVL57");
        arbol.insertar(50,"elementoAVL50");
        arbol.insertar(49,"elementoAVL49");
        arbol.eliminar(57);
        assertEquals(65,arbol.getRaiz().getEtiqueta());
        assertEquals(77,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(50,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceDerechaIzquierda(){
        arbol.insertar(56,"elementoAVL56");
        arbol.insertar(50,"elementoAVL50");
        arbol.insertar(65,"elementoAVL65");
        arbol.insertar(49,"elementoAVL49");
        arbol.insertar(57,"elementoAVL57");
        arbol.insertar(77,"elementoAVL77");
        arbol.insertar(70,"elementoAVL70");
        arbol.eliminar(57);

        assertEquals(56,arbol.getRaiz().getEtiqueta());
        assertEquals(70,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(50,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }

    @Test
    public void EliminarDesbalanceIzquierdaDerecha(){
        arbol.insertar(65,"elementoAVL65");
        arbol.insertar(77,"elementoAVL77");
        arbol.insertar(56,"elementoAVL56");
        arbol.insertar(70,"elementoAVL70");
        arbol.insertar(57,"elementoAVL57");
        arbol.insertar(49,"elementoAVL49");
        arbol.insertar(50,"elementoAVL50");
        arbol.eliminar(57);

        assertEquals(65,arbol.getRaiz().getEtiqueta());
        assertEquals(77,arbol.getRaiz().getHijoDer().getEtiqueta());
        assertEquals(50,arbol.getRaiz().getHijoIzq().getEtiqueta());
    }
}


