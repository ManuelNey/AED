
public class Genealogia {
    /**
     * Calcula el parentesco entre dos personas en un árbol genealógico.
     * 
     * @param raiz     Nodo raíz del árbol.
     * @param persona1 Nodo que representa a la primera persona.
     * @param persona2 Nodo que representa a la segunda persona.
     * @return ResultadoParentesco con los grados de parentesco y el tipo (consanguinidad o político).
     */
    public static ResultadoParentesco calcularParentesco(IElementoAB<Persona> raiz, IElementoAB<Persona> persona1, IElementoAB<Persona> persona2) {
        if(raiz == null) {
            return null;
        }
        ResultadoParentesco  c1 = calcularParentesco(raiz.getHijoIzq(), persona1, persona2);
        ResultadoParentesco  c2 = calcularParentesco(raiz.getHijoDer(), persona1, persona2);

        if(c1 == null && c2 == null) {
            if(raiz.getEtiqueta().equals(persona1.getEtiqueta())  || raiz.getEtiqueta().equals(persona2.getEtiqueta())) {
                return new ResultadoParentesco(1, null);
            }
            else {
                return null;
            }
        }
        if(c1 != null && c2 != null) {
            return new ResultadoParentesco(c1.getGrados() + c2.getGrados(), "politico");
        }
        ResultadoParentesco c = c1 == null ? c2 : c1;

        if (raiz.getEtiqueta() == persona1.getEtiqueta() || raiz.getEtiqueta() == persona2.getEtiqueta()) {
            return new ResultadoParentesco(c.getGrados(), "consanguineo");
        }
        if(c.getTipoParentesco() != null) {
            return c;
        }
        return new ResultadoParentesco(c.getGrados() +1, null);
    }
}
