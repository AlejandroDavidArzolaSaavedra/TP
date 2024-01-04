package tp.practicas;
import java.lang.Math;
import java.util.Arrays;
/**
 * Clase que representa operaciones con conjuntos de Strings
 * @date : 30/10/2021
 */
public class ConjuntoDeStrings {

    private String[] conjuntoVacio;
    
    /** 
     * Constructor con parametros de la clase ConjuntoDeStrings
     * 
     * @param conjunto Numero variable de referencias a Strings
     */
    public ConjuntoDeStrings(String... conjunto) {
        String[] conjuntoModificado = new String[conjunto.length];
        // Eliminamos los repetidos y los caracteres null
        conjuntoModificado = elementosRepetidos(conjunto);
        conjuntoModificado = elementosRepetidosNoVacios(conjuntoModificado);
        this.conjuntoVacio = conjuntoModificado;
    }
    
    /**
     * Metodo auxiliar para eliminar los elementos repetidos
     * 
     * @param elementos Elementos del conjunto
     * @return Conjunto sin valores repetidos
     */
    private String[] elementosRepetidos(String[] elementos) {
        // Conjunto sin repetir pero longitud original
        String[] elementosSinRepetir = new String[elementos.length];
        boolean bandera = false;
        for (int i = 0; i < elementos.length; i++) {
            for (int j = i + 1; j < elementos.length; j++) {
                if (elementos[i] == elementos[j])
                    bandera = true;
            }
            // Comprobacion elemento repetido
            if (!bandera)
                elementosSinRepetir[i] = elementos[i];
            bandera = false;
        }
        return elementosSinRepetir;
    }
    
    /**
     * Metodo auxiliar para eliminar los elementos nulos
     * 
     * @param elementos Elementos del conjunto
     * @return conjunto sin valores nulos
     */
    private String[] elementosRepetidosNoVacios(String[] elementos) {
        int elementosNoNulos = 0; // Contador de elementos null 
        int iterador = 0;
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] != null)
                elementosNoNulos++;
        }
        String[] elementosSinRepetir = new String[elementosNoNulos];
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] != null) {
                elementosSinRepetir[iterador] = elementos[i];
                iterador++;
            }
        }
        return elementosSinRepetir;
    }
    
    /**
     * Metodo que devuelve el numero de elementos del conjunto
     * 
     * @return Longitud del conjunto
     */
    public int cardinal() {
        return this.conjuntoVacio.length;
    }
    
    /**
     * Metodo que devuelve el true si esta vacio o false si no lo está
     * 
     * @return verdadero o falso si está vacío
     */
    public boolean estáVacío() {
        return this.conjuntoVacio.length == 0 ? true : false;
    }
    
    /**
     * Metodo que añade un nuevo elemento al conjunto
     * Si no se encuentra en el conjunto original.
     * 
     * @param nuevoElemento Elemento nuevo para añadir al conjunto
     * @return verdadero o falso si lo añadio o no
     */
    public boolean añade(String nuevoElemento) {
        boolean bandera = false;
        // Copia del conjunto original
        String[] copia = Arrays.copyOf(this.conjuntoVacio, cardinal());
        for (int i = 0; i < copia.length; i++) {
            if (copia[i].equals(nuevoElemento))
                bandera = true;
        }
        if (bandera) {
            return false;
        }
        else {
            // Reseteo conjunto original
            this.conjuntoVacio = new String[this.conjuntoVacio.length+1];
            for (int i = 0; i < copia.length; i++) {
                this.conjuntoVacio[i] = copia[i];
            }
            this.conjuntoVacio[this.conjuntoVacio.length - 1] = nuevoElemento;
            return true;
        }
    }
    
    /**
     * Metodo que indica si el elemento pertenece al conjunto original
     * 
     * @param nuevoElemento Elemento nuevo a comprobar del conjunto original
     * @return verdadero o falso si pertence al conjunto original  o no
     */
    public boolean pertenece(String nuevoElemento) {
        boolean bandera = false;
        for (int i = 0; i < this.conjuntoVacio.length; i++) {
            if (this.conjuntoVacio[i].equals(nuevoElemento))
                bandera = true;
        }
        return bandera;
    }
    
    /**
     * Metodo que une dos cojuntos 
     * 
     * @param nuevoConjunto Conjunto a añadir al conjunto original
     * @return Conjunto resultante de la Union
     */
    public ConjuntoDeStrings unión(ConjuntoDeStrings nuevoConjunto) {
        ConjuntoDeStrings conjuntoResultante = new ConjuntoDeStrings(conjuntoVacio);
        for (int i = 0; i < nuevoConjunto.cardinal(); i++) {
            conjuntoResultante.añade(nuevoConjunto.conjuntoVacio[i]);
        }
        return conjuntoResultante;
    }
    
    /**
     * Metodo que recoge los elementos comunes de  dos conjuntos 
     * 
     * @param nuevoConjunto Conjunto a comparar del conjunto original
     * @return Conjunto resultante de la intersección
     */
    public ConjuntoDeStrings intersección(ConjuntoDeStrings nuevoConjunto) {
        ConjuntoDeStrings conjuntoResultante = new ConjuntoDeStrings();
        for (int i = 0; i < conjuntoVacio.length; i++) {
            if (nuevoConjunto.pertenece(conjuntoVacio[i]))
                conjuntoResultante.añade(conjuntoVacio[i]);
        }
        return conjuntoResultante;
    }
    
    /**
     * Metodo que recoge los elementos diferentes de  dos cojuntos 
     * 
     * @param nuevoConjunto Conjunto a comparar del conjunto original
     * @return Conjunto resultante de elementos que difieren de los conjuntos
     */
    public ConjuntoDeStrings diferencia(ConjuntoDeStrings nuevoConjunto) {
        
        ConjuntoDeStrings conjuntoResultante = new ConjuntoDeStrings();
        for (int i = 0; i < conjuntoVacio.length; i++) {
            if (!nuevoConjunto.pertenece(conjuntoVacio[i]))
                conjuntoResultante.añade(conjuntoVacio[i]);
        }
        return conjuntoResultante;
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        boolean detectar = false;
        int contador = 0;
        int tope;
        ConjuntoDeStrings comparable = new ConjuntoDeStrings(this.conjuntoVacio);
       // Comparamos referencias
        if (obj instanceof ConjuntoDeStrings) {
            ConjuntoDeStrings comparar = (ConjuntoDeStrings) obj;
            if (comparar == comparable) {
                resultado = true; 
            }
            else {
            // Comparamos objetos aun con diferente orden
                tope = Math.max(comparable.cardinal(), comparar.cardinal());
                for (int i = 0; i < comparable.cardinal(); i++) {
                    for (int j = 0; j < comparar.cardinal(); j++) {
                        if (comparable.conjuntoVacio[i].equals(comparar.conjuntoVacio[j]))
                            detectar = true;
                    }
                    // Iguales
                    if (detectar == true)
                        contador++;
                    detectar = false;
                }
                return contador == tope ? true : false;
            }
        }
        return resultado;
    }
    
    /**
     * Metodo para saber si el conjunto por parametro esta contenido en el original
     * 
     * @param nuevoConjunto Conjunto a comparar
     * @return verdadero o falso si esta o no contenido en el Conjunto original
     */
    public boolean contenido(ConjuntoDeStrings nuevoConjunto) {
        int contador = 0;
        String[] copiaNuevoConjunto = new String[nuevoConjunto.cardinal()];
        copiaNuevoConjunto = nuevoConjunto.elementos();
        for (int i = 0; i < this.conjuntoVacio.length; i++) {
            for (int j = 0; j < copiaNuevoConjunto.length; j++) {
                if (this.conjuntoVacio[i] == copiaNuevoConjunto[j])
                    contador++;
            }
        }
        return contador == copiaNuevoConjunto.length ? true : false;
    }
    
    /**
     * Metodo para obtener los elementos del Conjunto original
     * 
     * @return Los elementos del Conjunto
     */
    public String[] elementos() {
        String[] elemento = new String[cardinal()];
        for (int i = 0; i < elemento.length; i++) {
            elemento[i] = this.conjuntoVacio[i];
        }
        return elemento;
    }
}
