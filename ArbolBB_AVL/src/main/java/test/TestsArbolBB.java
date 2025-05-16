package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tda.ArbolBB.ArbolBB;
import tda.ArbolBB.IElementoAB;
import tda.ArbolBB.TElementoAB;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class TestsArbolBB {

    private ArbolBB<Integer> arbol;

    @BeforeEach
    void init() {

        arbol = new ArbolBB<>();
    }

    @Test
    void dadoArbolVacio_cuandoInsertarEntoncesArbolNoVacio() {
        // Dado
        assertTrue(arbol.esVacio());

        // Cuando
        boolean resultado = arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));

        // Entonces
        assertTrue(resultado);
        assertFalse(arbol.esVacio());
    }

    @Test
    void dadoArbolConElementos_cuandoInsertarElementoExistenteEntoncesFalso() {
        // Dado
        arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));
        assertFalse(arbol.esVacio());

        // Cuando
        boolean resultado = arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));

        // Entonces
        assertFalse(resultado);
    }

    @Test
    void dadoArbolVacio_cuandoBuscarEntoncesNull() {
        // Dado
        assertTrue(arbol.esVacio());

        // Cuando
        Integer resultado = arbol.buscar(Integer.valueOf(10));

        // Entonces
        assertNull(resultado);
    }

    @Test
    void dadoArbolConElementos_cuandoBuscarElementoExistenteEntoncesElemento() {
        // Dado
        arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));

        // Cuando
        Integer resultado = arbol.buscar(Integer.valueOf(10));

        // Entonces
        assertNotNull(resultado);
        assertEquals(Integer.valueOf(10), resultado);
    }

    @Test
    void dadoArbolConElementos_cuandoBuscarElementoNoExistenteEntoncesNull() {
        // Dado
        arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));

        // Cuando
        Integer resultado = arbol.buscar(Integer.valueOf(20));

        // Entonces
        assertNull(resultado);
    }

    @Test
    void dadoArbolVacio_cuandoVaciarEntoncesFalso() {
        // Dado
        assertTrue(arbol.esVacio());

        // Cuando
        boolean resultado = arbol.vaciar();

        // Entonces
        assertFalse(resultado);
    }

    @Test
    void dadoArbolConElementos_cuandoVaciarEntoncesVerdadero() {
        // Dado
        arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));
        assertFalse(arbol.esVacio());

        // Cuando
        boolean resultado = arbol.vaciar();

        // Entonces
        assertTrue(resultado);
        assertTrue(arbol.esVacio());
    }

    @Test
    void dadoArbolVacio_cuandoInOrdenEntoncesListaVacia() {
        // Dado
        assertTrue(arbol.esVacio());

        // Cuando
        List<Integer> resultado = arbol.inOrden();

        // Entonces
        //assertNull(resultado);
        assertTrue(resultado.isEmpty());
    }

    @Test
    void dadoArbolConElementos_cuandoInOrdenEntoncesListaOrdenada() {
        // Dado
        arbol.insertar(Integer.valueOf(20), Integer.valueOf(20));
        arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));
        arbol.insertar(Integer.valueOf(30), Integer.valueOf(30));

        // Cuando
        List<Integer> resultado = arbol.inOrden();

        // Entonces
        assertNotNull(resultado);
        assertArrayEquals(new Integer[]{Integer.valueOf(10), Integer.valueOf(20), Integer.valueOf(30)}, resultado.toArray(new Integer[0]));
    }

    @Test
    void dadoArbolConElementos_cuandoPreOrdenEntoncesListaPreOrden() {
        // Dado
        arbol.insertar(Integer.valueOf(20), Integer.valueOf(20));
        arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));
        arbol.insertar(Integer.valueOf(30), Integer.valueOf(30));

        // Cuando
        List<Integer> resultado = arbol.preOrden();

        // Entonces
        assertNotNull(resultado);
        assertArrayEquals(new Integer[]{Integer.valueOf(20), Integer.valueOf(10), Integer.valueOf(30)}, resultado.toArray(new Integer[0]));
    }

    @Test
    void dadoArbolConElementos_cuandoPostOrdenEntoncesListaPostOrden() {
        // Dado
        arbol.insertar(Integer.valueOf(20), Integer.valueOf(20));
        arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));
        arbol.insertar(Integer.valueOf(30), Integer.valueOf(30));

        // Cuando
        List<Integer> resultado = arbol.postOrden();

        // Entonces
        assertNotNull(resultado);
        assertArrayEquals(new Integer[]{Integer.valueOf(10), Integer.valueOf(30), Integer.valueOf(20)}, resultado.toArray(new Integer[0]));
    }

    @Test
    void dadoArbolVacio_cuandoEliminarEntoncesNoCambios() {
        // Dado
        assertTrue(arbol.esVacio());

        // Cuando
        arbol.eliminar(Integer.valueOf(10));

        // Entonces
        assertTrue(arbol.esVacio());
    }

    @Test
    void dadoArbolConElementos_cuandoEliminarElementoNoExistenteEntoncesArbolInalterado() {
        // Dado
        arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));
        assertFalse(arbol.esVacio());

        // Cuando
        arbol.eliminar(Integer.valueOf(20));

        // Entonces
        assertFalse(arbol.esVacio());
        assertNotNull(arbol.buscar(Integer.valueOf(10)));
    }

    @Test
    void dadoArbolConElementos_cuandoEliminarElementoExistenteEntoncesElementoEliminado() {
        // Dado
        arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));
        arbol.insertar(Integer.valueOf(20), Integer.valueOf(20));
        arbol.insertar(Integer.valueOf(30), Integer.valueOf(30));
        assertFalse(arbol.esVacio());

        // Cuando
        arbol.eliminar(Integer.valueOf(20));

        // Entonces
        assertNull(arbol.buscar(Integer.valueOf(20)));
        assertNotNull(arbol.buscar(Integer.valueOf(10)));
        assertNotNull(arbol.buscar(Integer.valueOf(30)));
    }

    @Test
    void CalcularTamañoDelArbol(){
        ArbolBB<Integer> arbol = new ArbolBB<>();
        assertEquals(0,arbol.obtenerTamaño());

        arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));
        assertEquals(1,arbol.obtenerTamaño());

        arbol.insertar(Integer.valueOf(12),Integer.valueOf(12));
        arbol.insertar(Integer.valueOf(15),Integer.valueOf(15));
        arbol.insertar(Integer.valueOf(9),Integer.valueOf(9));
        assertEquals(4,arbol.obtenerTamaño());
    }

    @Test
    void CalcularAlturaDelArbol(){
        ArbolBB<Integer> arbol = new ArbolBB<>();
        //Caso Arbol Vacio
        assertEquals(-1,arbol.obtenerAltura());
        //Caso Arbol solo raiz
        arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));
        assertEquals(1,arbol.obtenerAltura());

        arbol.insertar(Integer.valueOf(12),Integer.valueOf(12));
        arbol.insertar(Integer.valueOf(15),Integer.valueOf(15));
        arbol.insertar(Integer.valueOf(9),Integer.valueOf(9));
        arbol.insertar(Integer.valueOf(11),Integer.valueOf(11));
        arbol.insertar(Integer.valueOf(13),Integer.valueOf(13));
        arbol.insertar(Integer.valueOf(14),Integer.valueOf(14));
        arbol.insertar(Integer.valueOf(8),Integer.valueOf(8));
        arbol.insertar(Integer.valueOf(16),Integer.valueOf(16));
        assertEquals(5,arbol.obtenerAltura());
    }

    @Test
    void CantidadHojas(){
        ArbolBB<Integer> arbol = new ArbolBB<>();
        assertEquals(0,arbol.cantHojas());

        arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));
        assertEquals(1,arbol.cantHojas());

        arbol.insertar(Integer.valueOf(12),Integer.valueOf(12));
        arbol.insertar(Integer.valueOf(15),Integer.valueOf(15));
        arbol.insertar(Integer.valueOf(9),Integer.valueOf(9));
        arbol.insertar(Integer.valueOf(11),Integer.valueOf(11));
        arbol.insertar(Integer.valueOf(13),Integer.valueOf(13));
        arbol.insertar(Integer.valueOf(14),Integer.valueOf(14));
        arbol.insertar(Integer.valueOf(8),Integer.valueOf(8));
        arbol.insertar(Integer.valueOf(16),Integer.valueOf(16));
        assertEquals(4,arbol.cantHojas());
    }

    @Test
    void EncontrarNivelActual(){
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(Integer.valueOf(7), Integer.valueOf(7));
        arbol.insertar(Integer.valueOf(5), Integer.valueOf(5));
        arbol.insertar(Integer.valueOf(19), Integer.valueOf(19));
        arbol.insertar(Integer.valueOf(3), Integer.valueOf(3));
        arbol.insertar(Integer.valueOf(2), Integer.valueOf(2));
        arbol.insertar(Integer.valueOf(4), Integer.valueOf(4));
        arbol.insertar(Integer.valueOf(6), Integer.valueOf(6));
        assertEquals(3,arbol.encontrarNivel(Integer.valueOf(4)));
    }

    @Test
    void encontrarNodosNivel(){
        ArbolBB<Integer> arbol = new ArbolBB<>();
        assertEquals(0,arbol.cantNodosNivel(0));
        arbol.insertar(Integer.valueOf(8), Integer.valueOf(8));
        arbol.insertar(Integer.valueOf(5), Integer.valueOf(5));
        arbol.insertar(Integer.valueOf(1), Integer.valueOf(1));
        arbol.insertar(Integer.valueOf(2), Integer.valueOf(2));
        arbol.insertar(Integer.valueOf(6), Integer.valueOf(6));
        arbol.insertar(Integer.valueOf(12), Integer.valueOf(12));
        arbol.insertar(Integer.valueOf(9), Integer.valueOf(9));
        arbol.insertar(Integer.valueOf(14), Integer.valueOf(14));
        arbol.insertar(Integer.valueOf(13), Integer.valueOf(13));
        assertEquals(1,arbol.cantNodosNivel(0));
        assertEquals(2,arbol.cantNodosNivel(1));
        assertEquals(4,arbol.cantNodosNivel(2));
        assertEquals(2,arbol.cantNodosNivel(3));
        assertEquals(0,arbol.cantNodosNivel(20));
    }

    @Test
    void hojaYNivel(){
        ArbolBB<Integer> arbol = new ArbolBB<>();
        //Arbol vacio
        arbol.hojaYNivel();
        //Arbol solo con raiz
        arbol.insertar(Integer.valueOf(8), Integer.valueOf(8));
        arbol.hojaYNivel();
        //Arbol con solo 1 hoja a la izquierda
        arbol.insertar(Integer.valueOf(5), Integer.valueOf(5));
        arbol.insertar(Integer.valueOf(1), Integer.valueOf(1));
        arbol.hojaYNivel();
        arbol.insertar(Integer.valueOf(6), Integer.valueOf(6));
        arbol.insertar(Integer.valueOf(12), Integer.valueOf(12));
        arbol.insertar(Integer.valueOf(9), Integer.valueOf(9));
        arbol.insertar(Integer.valueOf(14), Integer.valueOf(14));
        arbol.hojaYNivel();
    }

    @Test
    void EsArbolBinarioDeBusqueda(){
        ArbolBB<Integer> arbol = new ArbolBB<>();
        assertFalse(arbol.verificarEsABB());
        arbol.insertar(Integer.valueOf(8), Integer.valueOf(8));
        arbol.insertar(Integer.valueOf(5), Integer.valueOf(5));
        arbol.insertar(Integer.valueOf(1), Integer.valueOf(1));
        arbol.insertar(Integer.valueOf(2), Integer.valueOf(2));
        arbol.insertar(Integer.valueOf(6), Integer.valueOf(6));
        arbol.insertar(Integer.valueOf(12), Integer.valueOf(12));
        arbol.insertar(Integer.valueOf(9), Integer.valueOf(9));
        arbol.insertar(Integer.valueOf(14), Integer.valueOf(14));
        arbol.insertar(Integer.valueOf(13), Integer.valueOf(13));
        assertTrue(arbol.verificarEsABB());
    }
    @Test
    void NoEsArbolBinarioDeBusqueda(){
        IElementoAB elementoAB1=new TElementoAB(Integer.valueOf(1),Integer.valueOf(1));
        IElementoAB elementoAB2=new TElementoAB(Integer.valueOf(2),Integer.valueOf(2));
        IElementoAB elementoAB3=new TElementoAB(Integer.valueOf(3),Integer.valueOf(3));
        elementoAB2.setHijoDer(elementoAB1);
        elementoAB2.setHijoIzq(elementoAB3);
        ArbolBB arbolBB=new ArbolBB();
        arbolBB.setRaiz(elementoAB2);
        assertFalse(arbolBB.verificarEsABB());
    }
    @Test
    void tamañoDisminuyeTrasEliminar() {
        ArbolBB<Integer> arbol = new ArbolBB<>();
        arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));
        arbol.insertar(Integer.valueOf(5), Integer.valueOf(5));
        arbol.insertar(Integer.valueOf(15), Integer.valueOf(15));
        assertEquals(3, arbol.obtenerTamaño());

        arbol.eliminar(Integer.valueOf(5));
        assertEquals(2, arbol.obtenerTamaño());


    }

    @Test
    void testAlturaActualizadaTrasEliminar() {
        ArbolBB<Integer> arbol = new ArbolBB<>();

        arbol.insertar(Integer.valueOf(10), Integer.valueOf(10));
        arbol.insertar(Integer.valueOf(5), Integer.valueOf(5));
        arbol.insertar(Integer.valueOf(20), Integer.valueOf(20));
        arbol.insertar(Integer.valueOf(15), Integer.valueOf(15));

        assertEquals(3, arbol.obtenerAltura());

        arbol.eliminar(Integer.valueOf(15));
        assertEquals(2, arbol.obtenerAltura());

        arbol.eliminar(Integer.valueOf(20));
        assertEquals(2, arbol.obtenerAltura());

        arbol.eliminar(Integer.valueOf(5));
        assertEquals(1, arbol.obtenerAltura());

        arbol.eliminar(Integer.valueOf(10));
        assertEquals(-1, arbol.obtenerAltura());
    }




}
