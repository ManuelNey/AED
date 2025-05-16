package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tda.ListaEnlazada.Lista;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
class TestsListaEnlazada {
    private Lista<String> lista;

    @BeforeEach
    void setUp() {
        lista = new Lista<>();
    }

    @Test
    void testEsVaciaCuandoSeCrea() {
        assertTrue(lista.esVacia());
    }

    @Test
    void testInsertarYBuscar() {
        lista.insertar("dato1", 1);
        assertEquals("dato1", lista.buscar(1));
    }

    @Test
    void testInsertarMultiplesYBuscar() {
        lista.insertar("dato1",1);
        lista.insertar("dato2", 2);
        lista.insertar("dato3", 3);
        assertEquals("dato2", lista.buscar(2));
        assertEquals("dato3", lista.buscar(3));
    }

    @Test
    void testEliminarElementoExistente() {
        lista.insertar("dato1", 1);
        lista.insertar("dato2", 2);
        assertTrue(lista.eliminar(1));
        assertNull(lista.buscar(1));  // el buscar tiene problemas igual, ojo
    }

    @Test
    void testEliminarElementoInexistente() {
        lista.insertar("dato1", 1);
        assertFalse(lista.eliminar(99));
    }

    @Test
    void testCantElementos() {
        assertEquals(0, lista.cantElementos());
        lista.insertar("dato1", 1);
        assertEquals(1, lista.cantElementos());
        lista.insertar("dato2", 2);
        lista.insertar("dato3", 3);
        assertEquals(3, lista.cantElementos());
    }

    @Test
    void testImprimir() {
        lista.insertar("dato1", 1);
        lista.insertar("dato2", 2);
        String esperado = "1\n2";
        assertEquals(esperado, lista.imprimir("\n"));
    }
}
