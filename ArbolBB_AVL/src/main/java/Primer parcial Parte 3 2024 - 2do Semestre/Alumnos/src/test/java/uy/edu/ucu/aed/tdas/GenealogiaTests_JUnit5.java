import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Genealogia;
import Persona;
import ResultadoParentesco;

import static org.junit.jupiter.api.Assertions.*;


class GenealogiaTests_JUnit5 {


    private IElementoAB<Persona> jose;
    private IElementoAB<Persona> ana;
    private IElementoAB<Persona> luis;
    private IElementoAB<Persona> clara;
    private IElementoAB<Persona> pedro;
    private IElementoAB<Persona> marta;
    private IElementoAB<Persona> juan;


    @BeforeEach
    void init() {
        IElementoAB<Persona> jose = new TElementoAB<>("Jose", new Persona("Jose"));
        IElementoAB<Persona> ana = new TElementoAB<>("Ana", new Persona("Ana"));
        IElementoAB<Persona> luis = new TElementoAB<>("Luis", new Persona("Luis"));
        IElementoAB<Persona> clara = new TElementoAB<>("Clara", new Persona("Clara"));

        IElementoAB<Persona> pedro = new TElementoAB<>("Pedro", new Persona("Pedro"));
        pedro.setHijoIzq(jose);
        pedro.setHijoDer(ana);

        IElementoAB<Persona> marta = new TElementoAB<>("Marta", new Persona("Marta"));
        marta.setHijoIzq(luis);
        marta.setHijoDer(clara);

        IElementoAB<Persona> juan = new TElementoAB<>("Juan", new Persona("Juan"));
        juan.setHijoIzq(pedro);
        juan.setHijoDer(marta);

    }

    @Test
    void personas_consanguineas() {
        ResultadoParentesco r1 = Genealogia.calcularParentesco(juan, new TElementoAB<Persona>("Juan", new Persona("Juan")), new TElementoAB<Persona>("Ana", new Persona("Ana")));
        Assertions.assertEquals(r1.toString(),"Juan");
    }

    @Test
    void persona_noexistente() {
        IElementoAB<Persona> fantasma = new TElementoAB<>("Fantasma", new Persona("Fantasma"));
        ResultadoParentesco r2 = Genealogia.calcularParentesco(juan, new TElementoAB<Persona>("Juan", new Persona("Juan")), fantasma);
        Assertions.assertEquals(r2.toString(),"Juan");
    }

    @Test
    void personas_politicas() {
        ResultadoParentesco r3 = Genealogia.calcularParentesco(juan , new TElementoAB<Persona>("Jose", new Persona("Jose")), new TElementoAB<Persona>("Marta", new Persona("Marta")));
        Assertions.assertEquals(r3.toString(),"Jose");
    }
}
