import TArbolBB;
import TElementoAB;
import IElementoAB;
import ManejadorArchivosGenerico;

public class Main {
    public static void main(String[] args) {

        ManejadorArchivosGenerico manage = new ManejadorArchivosGenerico();
        Persona Ana = new Persona("Ana");
        Persona Bruno = new Persona("Bruno");
        Persona Carlos = new Persona("Carlos");
        Persona Diego = new Persona("Diego");
        Persona Fernanda = new Persona("Fernanda");
        Persona Elizabeth = new Persona("Elizabeth");
        Persona Gabriel = new Persona("Gabriel");
        Persona Gabriel2 = new Persona("Gabriel2");

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

        // a) Juan y Ana
        ResultadoParentesco r1 = Genealogia.calcularParentesco(juan, new TElementoAB<Persona>("Juan", new Persona("Juan")), new TElementoAB<Persona>("Ana", new Persona("Ana")));

        // b) Juan y persona no existente
        IElementoAB<Persona> fantasma = new TElementoAB<>("Fantasma", new Persona("Fantasma"));
        ResultadoParentesco r2 = Genealogia.calcularParentesco(juan, new TElementoAB<Persona>("Juan", new Persona("Juan")), fantasma);

        // c) José y Marta
        ResultadoParentesco r3 = Genealogia.calcularParentesco(juan , new TElementoAB<Persona>("Jose", new Persona("Jose")), new TElementoAB<Persona>("Marta", new Persona("Marta")));
        String [] resultados = {r1.toString(),r2.toString(),r3.toString()};

        manage.escribirArchivo("resultados.txt", resultados);



    }
}
