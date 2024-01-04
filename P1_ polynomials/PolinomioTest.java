import org.junit.*;
import static org.junit.Assert.*;
/**
 * Clase que prueba el funcionamiento de la clase Polinomio
 * @author: Alejandro David Arzola Saavedra
 * @date : 11/10/2021
 */
public class PolinomioTest {
   
    @Test
    public void testGradoConstructorVacio() {
        int [] array = {};// Polinomio vacio
        Polinomio polinomio = new Polinomio();
        assertEquals( 0 , polinomio.grado()  );// Prueba funcionamiento constuctor vacio
    }
   
    @Test
    public void testGradoConstructorLleno() {
        int [] array = { 0 };
        int [] arraySegundo = { 1 };
        int [] arrayTercero = { 0 , 0 , 0 , 3 , 0 , 0 , 0 , 4 };
        int [] arrayCuarto = { -2 , -1 , -1 , -3 , -4 , -3 , -2 , -4 };
        
        Polinomio p = new Polinomio( array );
        Polinomio p2 = new Polinomio( arraySegundo );
        Polinomio p3 = new Polinomio( arrayTercero );
        Polinomio p4 = new Polinomio( arrayCuarto );
        
        assertEquals( 0 , p.grado() );// Prueba longitud 1 valor 0
        assertEquals( 0 , p2.grado() );// Prueba longitud 1 valor 1
        assertEquals( 7 , p3.grado() );// Prueba Con varios elementos
        assertNotEquals( 0 , p4.grado() );// Prueba con numeros negativos
        assertEquals( 7 , p4.grado() );// Prueba con numeros negativos
        
    }
    
    @Test
    public void testCoeficiente() {
        int [] array = { 0 };
        int [] arraySegundo = { 0 , 0 , 0 , 3 , 0 , 0 , 0 , 4 };
        int [] arrayTercero = { -2 , -1 , -1 , -3 , -4 , -3 , -2 , -4 };
        
        Polinomio p = new Polinomio( array );
        Polinomio p2 = new Polinomio( arraySegundo );
        Polinomio p4 = new Polinomio( arrayTercero );
        
        assertTrue( p.coeficiente(0) == 0 );// Prueba 1 elemento
        assertFalse( p4.coeficiente(1) == 1 );// Prueba 2 elemento
        assertTrue( p2.coeficiente(3) == 3 );// Prueba  elemento en medio
        assertFalse( p2.coeficiente(6) == 10 );// Prueba  penultimo elemento
        assertTrue( p4.coeficiente(7) == -4 );// Prueba elemento final
        assertFalse( p4.coeficiente(20) == -4 );// Prueba elemento fuera 
    }
    
    @Test
    public void testValor() {
        int [] arrayPrimero = { 1 };
        int [] arraySegundo = { 1 , 10 , 10 };
        int [] arrayTercero = { -1 , -1 , -1 , -1 , -1 , -1 };
        int [] arrayCuarto = { 1 , 2 };
        int [] arrayQuinto = { 0 , 0 , 0 , 0 , 0 };
        float resultado = 1.0f;
        float resultado2 = 3.0f;
        
        Polinomio p = new Polinomio( arrayPrimero );
        Polinomio p2 = new Polinomio( arraySegundo );
        Polinomio p3 = new Polinomio( arrayTercero );
        Polinomio p4 = new Polinomio( arrayCuarto );
        Polinomio p5 = new Polinomio( arrayQuinto );
        
        
        assertTrue( p.valor(1) == 1.0f );// Prueba solo termino independiente
        assertNotEquals( p4.valor(1) , resultado );// Prueba  con grado 2
        String res = String.valueOf( p4.valor(1) );
        assertEquals( res , "3.0" );
        assertTrue( p2.valor(1) == 21.0f );// Prueba grado 3
        assertFalse( p3.valor(1) == 100.0f );// Prueba con grado > 5
        assertEquals( res , "3.0" );
        
        String res2 = String.valueOf( p5.valor(10) );
        assertEquals( res2 , "0.0" );// Prueba  con todos los elementos 0
        
    }
        
    @Test
    public void testToString() {
        int [] arrayPrimero = { 0 };
        int [] arraySegundo = { -2 , 3 };
        int [] arrayTercero = { 2 , 0 , -8 , 0 , 0 , 4 };
        int [] arrayCuarto = { 0 , 0 , 0 , 0 , 0 , 0 , 0 , -3 };
        
        Polinomio p = new Polinomio( arrayPrimero );
        Polinomio p2 = new Polinomio( arraySegundo );
        Polinomio p3 = new Polinomio( arrayTercero );
        Polinomio p4 = new Polinomio( arrayCuarto );
 
        String resultado = p.toString();
        assertTrue( resultado == "0" );// Prueba solo un termino independiente
        String resultado2 = p2.toString();
        assertEquals( resultado2 , "3x-2" );// Prueba solo 2 coeficientes
        String resultado3 = p3.toString();
        assertEquals( resultado3 , "4x^5-8x^2+2" );// Prueba con 0 en medios
        assertEquals( p4.toString() , "-3x^7" );// Prueba solo un elemento al final 
        assertNotSame( resultado3 , "0x^3+0x^2+0x+0" );// Prueba con todo 0
        
    }
    
    @Test
    public void testCoeficientes() {
        
        int [] arrayPrimero = { 0 };
        int [] arraySegundo = { -2 , -3 };
        int [] arrayCuarto = { 0 , 0 , 0 , 0 , 0 , 0 , 0 , -3 };
        
        Polinomio p2 = new Polinomio(arraySegundo);
        int [] arrayResultado = new int [arraySegundo.length];
        arrayResultado = p2.coeficientes();
        assertArrayEquals(arrayResultado,arraySegundo);// Prueba copia polinomio grado 1
        
        Polinomio p4 = new Polinomio(arrayCuarto);
        int [] arrayResultado4 = new int [0];
        arrayResultado4 = p4.coeficientes();
        assertArrayEquals(arrayResultado4,arrayCuarto);// Prueba todos ceros menos ultimo elemento
        
        arrayResultado[1]=1;
        String resultado = "";
        for (int i =0 ;i<arraySegundo.length;i++){
            resultado+=Integer.toString(arraySegundo[i])+",";
        }
        resultado = resultado.substring( 0 ,resultado.length()-1 );
        assertNotEquals(resultado , "3x-2");// Prueba modificacion de la copia
    }
    
    @Test
    public void testCoeficienteConParametros() {
        
        int [] arrayPrimero = { 0 };
        int [] resultadoArrayPrimero = { 0 , 2 };
        int [] resultadoArrayPrimero2 = { 0 , 0 , 0 , 0 , 2 , 2 };
        int [] arraySegundo = { -2 , -3 };
        int [] resultadoArraySegundo = { -1 , -3 };
        int [] arrayQuinto = { 0 , 0 , 0 , 0  };
        
        Polinomio p = new Polinomio( arrayPrimero );
        Polinomio pRes = new Polinomio( resultadoArraySegundo );
        Polinomio p2 = new Polinomio( arraySegundo );
        Polinomio p3 = new Polinomio( resultadoArrayPrimero );
        Polinomio p4 = new Polinomio(resultadoArrayPrimero2 );
        
        p2.coeficiente(0,-1);
        String resultado = p2.toString();
        String resultado2 = pRes.toString();;
        assertEquals( resultado , resultado2 );// Prueba 1 elemento mismo tamaño
        
        Polinomio p5 = new Polinomio( arrayQuinto );
        for( int i = 0 ; i < ( p5.grado() + 1) ; i++ ){
            p5.coeficiente( i , -1 );
        }
        
        String resultado3 = p5.toString();
        String comparar = "-1x^3-1x^2-1x-1";
        assertNotEquals( resultado3 , comparar );// Prueba todos los elementos -1
        
        p.coeficiente( 1 , 2 );
        String comparar2 = p.toString();
        String grande = p3.toString();
        assertEquals( grande , comparar2 );// Prueba cambiar 1 grado al polinomio
        
        p.coeficiente( 5 , 2 );
        p.coeficiente( 4 , 2 );
        String comparar3 = p.toString();
        String grande2 = p4.toString();
        assertEquals( grande , comparar2 );// Prueba cambiar varios grados al polinomio
    }
    
    @Test
    public void testSuma() {
        int [] arrayPrimero = { 1 };
        int [] arraySegundo = { 0 , -3 };
        int [] arrayTercero = { 1 , -3 };
        int [] arrayCuarto = { 100 };
    
        Polinomio p = new Polinomio( arrayPrimero );
        Polinomio p2 = new Polinomio( arraySegundo );
        Polinomio p3 = new Polinomio( arrayTercero );
        Polinomio p4 = new Polinomio( arrayCuarto );
        
        String resultado = p.suma(p2).toString();
        assertEquals( "-3x+1" , resultado );// Prueba  menor longitud el polinomio original
        
        String resultado2 = p2.suma(p3).toString();
        assertEquals( "-6x+1" , resultado2 );// Prueba misma longitud
    
        String resultado3 = p3.suma(p4).toString();
        assertEquals( "-3x+101" , resultado3 );// Prueba menor longitud polinomio por parametro

    }
        
    @Test    
    public void testResta() {
        int [] arrayPrimero = { 1 };
        int [] arraySegundo = { 0 , -3 };
        int [] arrayTercero = { 1 , -3 };
        int [] arrayCuarto = { 100 };
        
        Polinomio polinomio = new Polinomio( arrayPrimero );
        Polinomio polinomioSegundo = new Polinomio( arraySegundo );
        Polinomio polinomioTercero = new Polinomio( arrayTercero );
        Polinomio polinomioCuarto = new Polinomio( arrayCuarto );
        
        String resultado =  polinomio.resta(polinomioSegundo).toString();
        assertEquals( "3x+1" , resultado );// Prueba  menor longitud el polinomio original
        
        String resultado2 = polinomioSegundo.suma(polinomioTercero).toString();
        assertEquals( "-6x+1" , resultado2 );// Prueba misma longitud
    
        String resultado3 = polinomioTercero.resta(polinomioCuarto).toString();
        assertEquals( "-3x-99" , resultado3 );// Prueba menor longitud polinomio por parametro
    }
}
