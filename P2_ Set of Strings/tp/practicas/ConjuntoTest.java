package tp.practicas;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * Clase de test unitarios para comprobar la clase ConjuntoDeStrings
 * @date : 30/10/2021
 */
public class ConjuntoTest{
    
    @Test
    public void TestCardinal() {
        // Test con contructor vacío
        ConjuntoDeStrings constructorVacio = new ConjuntoDeStrings();
        assertEquals(constructorVacio.cardinal(), 0);
        
        // Test con contructor lleno
        String[] array = {"1", "2"};
        ConjuntoDeStrings constructorLleno = new ConjuntoDeStrings(array);
        assertEquals(constructorLleno.cardinal(), 2);
        
        // Test  con elementos repetidos
        String[] repetidos = {"1", "1"};
        ConjuntoDeStrings constructorRepetidos = new ConjuntoDeStrings(repetidos);
        assertEquals(constructorRepetidos.cardinal(), 1);
        
        // Test  con nulls
        String[] nulls = {"1", null};
        ConjuntoDeStrings constructorNulls = new ConjuntoDeStrings(nulls);
        assertEquals(constructorRepetidos.cardinal(), 1);
    }
    
    @Test
    public void TestEstáVacio() {
        // Test de constructor vacío
        ConjuntoDeStrings constructorVacio = new ConjuntoDeStrings();
        assertTrue(constructorVacio.estáVacío() == true);
        
        // Test de contructor lleno
        String[] array = {"1", "2"};
        ConjuntoDeStrings constructorLleno = new ConjuntoDeStrings(array);
        assertFalse(constructorLleno.estáVacío() == true);
    }
    
    @Test
    public void TestAñade(){
        // Test con constructor vacio y añadiendo 1 elemento
        String elemento = "elemento"; 
        ConjuntoDeStrings constructorVacio = new ConjuntoDeStrings();
        constructorVacio.añade(elemento);
        String[] copiaElemento = {"elemento"};
        assertArrayEquals(copiaElemento, constructorVacio.elementos());
        
        // Test con varios elementos  y añadiendo 1 elemento
        String[] array = {"1", "2"};
        ConjuntoDeStrings constructorLleno = new ConjuntoDeStrings(array);
        constructorLleno.añade("elemento");
        String[] sumaElemento = {"1", "2", "elemento"};
        assertArrayEquals(sumaElemento, constructorLleno.elementos());
    }
    
    @Test
    public void TestPertenece(){
        String[] array = {"1", "2"};
        ConjuntoDeStrings constructorLleno = new ConjuntoDeStrings(array);
        // Test 1 elemento que pertenece al conjunto
        assertTrue(constructorLleno.pertenece("2"));
        
        // Test 1 elemento que no pertenece al conjunto
        assertFalse(constructorLleno.pertenece("4"));
    }
    
    @Test
    public void TestUnión(){
        // Test uniendo 2 conjuntos con elementos
        String[] conjunto1 = {"1"};
        String[] conjunto2 = {"2"};
        String[] suma = {"1", "2"};
        ConjuntoDeStrings caso1 = new ConjuntoDeStrings(conjunto1); 
        ConjuntoDeStrings caso12 = new ConjuntoDeStrings(conjunto2);
        ConjuntoDeStrings casoResultante1 = new ConjuntoDeStrings(); 
        casoResultante1 = caso1.unión(caso12);
        String[] resultado1 = new String[casoResultante1.cardinal()];
        resultado1 = casoResultante1.elementos();
        
        assertArrayEquals(resultado1,suma);
        
        // Test uniendo 2 conjuntos y el segundo conjunto sin elementos
        String[] conjunto3 = {"1"};
        String[] conjunto4 = {};
        String[] suma2 = {"1"};
        ConjuntoDeStrings caso2 = new ConjuntoDeStrings(conjunto3); 
        ConjuntoDeStrings caso21 = new ConjuntoDeStrings(conjunto4);
        ConjuntoDeStrings casoResultante2 = new ConjuntoDeStrings();
        casoResultante2 = caso2.unión(caso21);
        String[] resultado2 = new String[casoResultante2.cardinal()];
        resultado2 = casoResultante2.elementos();
        
        assertArrayEquals(resultado2,suma2);
        
        // Test uniendo 2 conjuntos y el primero conjunto sin elementos
        String[] conjunto5 = {};
        String[] conjunto6 = {"1"};
        String[] suma3 = {"1"};
        ConjuntoDeStrings caso3 = new ConjuntoDeStrings(conjunto5); 
        ConjuntoDeStrings caso31 = new ConjuntoDeStrings(conjunto6);
        ConjuntoDeStrings casoResultante3 = new ConjuntoDeStrings();
        casoResultante3 = caso3.unión(caso31);
        String[] resultado3 = new String[casoResultante3.cardinal()];
        resultado3 = casoResultante3.elementos();
        
        assertArrayEquals(resultado3,suma3);
    }
    
    @Test
    public void TestIntersección(){
        // Test 2 conjuntos y elemento en comun para la intersección
        String[] conjunto1 = {"1", "2"};
        String[] conjunto2 = {"1"};
        String[] interseccion = {"1"};
        ConjuntoDeStrings caso1 = new ConjuntoDeStrings(conjunto1); 
        ConjuntoDeStrings caso12 = new ConjuntoDeStrings(conjunto2);
        ConjuntoDeStrings casoResultante1 = new ConjuntoDeStrings();
        casoResultante1 = caso1.intersección(caso12);
        String[] resultado1 = new String[casoResultante1.cardinal()];
        resultado1 = casoResultante1.elementos();
        
        assertArrayEquals(resultado1,interseccion);
        
        // Test 2 conjuntos y el segundo conjunto vacio
        String[] conjunto3 = {"1", "2"};
        String[] conjunto4 = {};
        String[] interseccion2 = {};
        ConjuntoDeStrings caso2 = new ConjuntoDeStrings(conjunto3); 
        ConjuntoDeStrings caso21 = new ConjuntoDeStrings(conjunto4);
        ConjuntoDeStrings casoResultante2 = new ConjuntoDeStrings();
        casoResultante2 = caso2.intersección(caso21);
        String[] resultado2 = new String[casoResultante2.cardinal()];
        resultado2 = casoResultante2.elementos();
        
        assertArrayEquals(resultado2,interseccion2);
        
        // Test 2 conjuntos y el primer conjunto vacio
        String[] conjunto5 = {};
        String[] conjunto6 = {"1", "2"};
        String[] interseccion3 = {};
        
        ConjuntoDeStrings caso3 = new ConjuntoDeStrings(conjunto5); 
        ConjuntoDeStrings caso31 = new ConjuntoDeStrings(conjunto6);
        ConjuntoDeStrings casoResultante3 = new ConjuntoDeStrings();
        casoResultante3 = caso3.intersección(caso31);
        String[] resultado3 = new String[casoResultante3.cardinal()];
        resultado3 = casoResultante3.elementos();
        
        assertArrayEquals(resultado3,interseccion3);
    }
    
    @Test
    public void TestDiferencia(){
        // Test diferencia de conjuntos con elementos en los 2 conjuntos
        String[] conjunto1 = {"1", "2", "3", "5", "9"};
        String[] conjunto2 = {"8", "2", "3", "7", "4"};
        String[] diferencia = {"1", "5", "9"};
        ConjuntoDeStrings caso1 = new ConjuntoDeStrings(conjunto1); 
        ConjuntoDeStrings caso12 = new ConjuntoDeStrings(conjunto2);
        ConjuntoDeStrings casoResultante1 = new ConjuntoDeStrings();
        casoResultante1 = caso1.diferencia(caso12);
        String[] resultado1 = new String[casoResultante1.cardinal()];
        resultado1= casoResultante1.elementos();
        
        assertArrayEquals(resultado1,diferencia);
        
        // Test diferencia de conjuntos con el segundo conjunto vacio
        String[] conjunto3 = {"1", "2"};
        String[] conjunto4 = {};
        String[] diferencia2 = {"1", "2"};
        ConjuntoDeStrings caso2 = new ConjuntoDeStrings(conjunto3); 
        ConjuntoDeStrings caso21 = new ConjuntoDeStrings(conjunto4);
        ConjuntoDeStrings casoResultante2 = new ConjuntoDeStrings();
        casoResultante2 = caso2.diferencia(caso21);
        String[] resultado2 = new String[casoResultante2.cardinal()];
        resultado2= casoResultante2.elementos();
        
        assertArrayEquals(resultado2,diferencia2);
        
        // Test diferencia de conjuntos con el primer conjunto vacio
        String[] conjunto5 = {};
        String[] conjunto6 = {"1", "2"};
        String[] diferencia3 = {};
        ConjuntoDeStrings caso3 = new ConjuntoDeStrings(conjunto5); 
        ConjuntoDeStrings caso31 = new ConjuntoDeStrings(conjunto6);
        ConjuntoDeStrings casoResultante3 = new ConjuntoDeStrings();
        casoResultante3 = caso3.diferencia(caso31);
        String[] resultado3 = new String[casoResultante3.cardinal()];
        resultado3= casoResultante3.elementos();
        
        assertArrayEquals(resultado3,diferencia3);
    }
    
    @Test
    public void TestEquals(){
        String[] conjunto1 = {"1", "2"};
        String[] conjunto2 = {"3", "4"};
        String[] conjunto3 = {"2", "1"};
        String[] conjunto4 = {"3", "4"};
        ConjuntoDeStrings c1 =  new ConjuntoDeStrings(conjunto1);
        ConjuntoDeStrings c2 =  new ConjuntoDeStrings(conjunto2);
        ConjuntoDeStrings c3 =  new ConjuntoDeStrings(conjunto3);
        ConjuntoDeStrings c4 =  new ConjuntoDeStrings(conjunto4);
        
        // Test con conjuntos iguales pero en diferente orden 
        assertTrue(c1.equals(c3));
        // Test de conjuntos con mismas referencias
        c1=c2;
        assertTrue(c1.equals(c2));
        // Test de conjuntos iguales en mismo orden
        assertTrue(c2.equals(c4));
    }
        
    @Test
    public void TestContenido(){
        // Test 2 conjuntos con los elementos contenidos en el primero
        String[] conjunto1 = {"1", "2", "3", "4", "5"};
        String[] conjunto2 = {"2", "4"};
        ConjuntoDeStrings c1 = new ConjuntoDeStrings(conjunto1);
        ConjuntoDeStrings c2 = new ConjuntoDeStrings(conjunto2);
        boolean resultado = c1.contenido(c2);
        
        assertTrue(resultado);
        
        // Test 2 conjuntos con los elementos no contenidos en el primero
        String[] conjunto3 = {"1", "2", "3", "4", "5"};
        String[] conjunto4 = {"20", "80"};
        ConjuntoDeStrings c3 = new ConjuntoDeStrings(conjunto3);
        ConjuntoDeStrings c4 = new ConjuntoDeStrings(conjunto4);
        boolean resultado2 = c3.contenido(c4);
        
        assertFalse(resultado2);
    }
    
    @Test
    public void TestElementos(){
        String[] conjunto1 = {"1", "2"};
        String[] resultado = {"1", "2"};
        ConjuntoDeStrings caso1 = new ConjuntoDeStrings(conjunto1);
        String[] casoResultante = caso1.elementos();
        
        // Test conjunto con varios elementos
        assertArrayEquals(casoResultante,resultado);
    }
}
