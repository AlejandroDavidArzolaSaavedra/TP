import java.util.Arrays;
import java.lang.Math;
/**
 * Clase que representa distintas operaciones con polinomios
 * @author: Alejandro David Arzola Saavedra
 * @date : 11/10/2021
 */
public class Polinomio {
    
    private int grado;
    private int [] polinomio;
    
    // Constructor por omision
    public Polinomio() {
        this.grado = 0;
        this.polinomio = new int[1];
        this.polinomio[0] = 0;
    }
    /**
     * Constructor
     * @param nuevoVector El vector de nuestro polinomio
     */
    public Polinomio( int [] nuevoVector ) {
            this.polinomio =  Arrays.copyOf( nuevoVector , nuevoVector.length );
            this.grado = this.polinomio.length - 1; // grado del polinommio
    }
    
    /**
     * Metodo que devuelve el grado del polinomio
     * @return El coeficiente del polinomio
     */
    public int grado() {
        int gradoPolinomio = 0;
        for ( int i = 0 ; i < this.polinomio.length  ; i++ ) {
            if ( this.polinomio[i] != 0 ){
                gradoPolinomio = i;
            }
        }
        return gradoPolinomio;
    }
   
   /**
    * Metodo que devuelve el coficiente del polinomio
    * @param i Posicion del polinomio
    * @return El coeficiente del polinomio
    */
    public int coeficiente( int i ) {
        if ( i < this.polinomio.length && i >= 0 ) {
            return this.polinomio[i];
        }else{
            return 0;
        }
    }
    
    /**
     * Metodo para cambiar un coeficiente del polinomio
     * @param i Posicion del Polinomio
     * @param v Valor a sustituir en el polinomio
     * Devuelve un vector de tamaño erróneo. Debe devolver {3, 0, 0, 0, 1} y devuelve {3, 0} para objeto polinomio "x^4+3"
     * resultado de modificar polinomio "3" llamando a coeficiente(4,1)
     */
    public void coeficiente( int i , int v ) {
        // Copia del polinomio original
        Polinomio polReserva = new Polinomio( Arrays.copyOf( this.polinomio , 
            Math.max(( i + 1) , this.polinomio.length ))); 
        
        // 1 Ampliamos la longitud el polinomio si el indice es mayor
        this.polinomio = new int[Math.max(( i + 1 ) , this.polinomio.length )];
        this.grado = Math.max( i , this.grado ) ;
        
        for ( int k = 0 ; k < this.polinomio.length ; k++ ) {
            if (i == k) {
                this.polinomio[k] = v; 
            }else{
                this.polinomio[k] = polReserva.polinomio[k]; 
            }
        }
    }
    
    /**
     * Metodo que devuelve los coeficientes del polinomio
     * @return copia del polinomio
     */
    public int [] coeficientes() {
        int [] nuevoArray = new int[grado()+1];
        for (int i = 0 ; i < nuevoArray.length;i++ ) {
                nuevoArray[i]=this.polinomio[i];
        }
        return nuevoArray;
    }
    
    /**
     * Metodo para representar el Polinomio
     * @return El polinomio en forma de String
     */
    @Override
    public String toString() {
        String resultado = ""; 
        int contador = 0;
        int gradoCopia = this.polinomio.length-1;
        
        for ( int i = this.grado ; i >= 0 ; i-- ) {
            
            // Grado mayor que 1 del polinomio
            if( this.polinomio[i] != 0 && gradoCopia > 1 ) {
                // Si se trata de numero positivo o no
                if ( this.polinomio[i] > 0) {
                    if ( this.polinomio[i] == 1 ) {
                        resultado += "+"+ "x^"+gradoCopia;
                        contador += 1;
                    }else{
                        resultado += "+" + this.polinomio[i] + "x^" + gradoCopia;
                        contador += 1;
                    }
                }else{
                    if( this.polinomio[i] == -1 ) {
                        resultado += "-x^" + gradoCopia;
                        contador += 1;
                    }else{
                        resultado += this.polinomio[i] + "x^" + gradoCopia;
                        contador += 1;
                    }
                }
            }
            // Grado 1 del polinomio
            if( this.polinomio[i] != 0 && gradoCopia == 1 ) {
                // Si se trata de numero positivo o no
                if ( this.polinomio[i] > 0 ) {
                    if ( this.polinomio[i]== 1 ){
                        resultado += "+"+ "x";
                        contador += 1;
                    }else{
                        resultado += "+" + this.polinomio[i] + "x";
                        contador += 1;
                    }
                }else{
                    if( this.polinomio[i] == -1 ) {
                        resultado += "-"+ "x";
                        contador += 1;
                    }else{
                        resultado += this.polinomio[i] + "x";
                        contador += 1;
                    }
                }
            }
            // Grado 0 del polinomio
            if( this.polinomio[i] != 0 && gradoCopia == 0 ) {
                // Si se trata de numero positivo o no
                if ( this.polinomio[i] > 0 ) {
                    resultado +=  "+" + this.polinomio[i];
                    contador += 1;
                }else{
                    resultado += this.polinomio[i];
                    contador += 1;
                }
            }
            gradoCopia--;
        }
        // Caso en el que todos los coeficientes sean 0
        if ( contador == 0 ) {
            resultado = "0";
        }else{
            // Eliminacion del 1 caracter "+" sobrante
            if ( this.polinomio[ grado() ] > 0 ) {
                resultado = resultado.substring( 0 , 0 ) + 
                    resultado.substring( 1 );
            }
        }
        return resultado;
    }
    
    /**
     * Metodo para sustitucion de x en el polinomio
     * @param v El valor a sustituir en la incognita
     * @return  El resultado de despejar la incognita 
     */
    public float valor( float v ) {
        float resultado = 0.0f;
        int gradoCopia = this.polinomio.length-1;
        
        for ( int i = this.grado ; i >= 0 ; i-- ) {
            // Caso que el grado sea 0
            if ( gradoCopia == 0 ) {
                resultado += this.polinomio[i];
                gradoCopia--;
            }
            if ( gradoCopia > 0 ) {
                resultado +=  this.polinomio[i] * Math.pow( v , gradoCopia );
                gradoCopia--;
            }
        }
        return resultado;
    }
    
    /**
     * Metodo para sumar dos polinomios
     * @param nuevoPolinomio El segundo polinomio para sumar
     * @return El resultado de sumar dos polinomios
     */
    public Polinomio suma( Polinomio  nuevoPolinomio ) {
        Polinomio polinomioFinal = new Polinomio();
        
        // Contadores para el control de flujo de elementos del polinomio
        int contadorPolinomio = grado()+1;
        int contadorNuevoPolinomio = nuevoPolinomio.grado()+1; 
        
        polinomioFinal.polinomio = new int[Math.max( nuevoPolinomio.grado()+1 , 
            grado()+1)];
            
        polinomioFinal.grado = Math.max( nuevoPolinomio.grado() , grado() );
        for ( int i = 0 ; i < (polinomioFinal.grado+1) ; i++ ) {
            if ( contadorPolinomio == 0 ) {
                polinomioFinal.polinomio[i] += nuevoPolinomio.polinomio[i];
                contadorNuevoPolinomio--;
            }
            // 2 condicion solo quedan elementos en el polimonio  por parametros
            else if ( contadorNuevoPolinomio == 0) {
                polinomioFinal.polinomio[i] += this.polinomio[i];
                contadorPolinomio--;
                
            }
            // 3 condicion quedan elementos en los dos polinomios
            else if ( contadorNuevoPolinomio > 0 &&  contadorPolinomio > 0 ) {
                polinomioFinal.polinomio[i] += ( this.polinomio[i] + nuevoPolinomio.polinomio[i] );
                contadorPolinomio--;
                contadorNuevoPolinomio--;
            }
        }
        return polinomioFinal;
    }
    
    /**
     * Metodo para restar dos polinomios
     * @param nuevoPolinomio El segundo polinomio para restar
     * @return El resultado de restar dos polinomios
     */
    public Polinomio resta( Polinomio  nuevoPolinomio ) {
        Polinomio polinomioFinal = new Polinomio();
        
        // Contadores para el control de flujo de elementos del polinomio
        int contadorPolinomio = grado()+1;
        int contadorNuevoPolinomio = nuevoPolinomio.grado()+1; 
        
        polinomioFinal.polinomio = new int[Math.max( nuevoPolinomio.grado()+1 , 
            grado()+1)];
            
        polinomioFinal.grado = Math.max( nuevoPolinomio.grado() , grado() );
        for ( int i = 0 ; i < (polinomioFinal.grado+1) ; i++ ) {
            if ( contadorPolinomio == 0 ) {
                polinomioFinal.polinomio[i] -= nuevoPolinomio.polinomio[i];
                contadorNuevoPolinomio--;
            }
            // 2 condicion solo quedan elementos en el polimonio  por parametros
            else if ( contadorNuevoPolinomio == 0) {
                polinomioFinal.polinomio[i] += this.polinomio[i];
                contadorPolinomio--;
                
            }
            // 3 condicion quedan elementos en los dos polinomios
            else if ( contadorNuevoPolinomio > 0 &&  contadorPolinomio > 0 ) {
                polinomioFinal.polinomio[i] += ( this.polinomio[i] - nuevoPolinomio.polinomio[i] );
                contadorPolinomio--;
                contadorNuevoPolinomio--;
            }
        }
        return polinomioFinal;
    }
}
