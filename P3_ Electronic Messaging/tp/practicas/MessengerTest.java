package tp.practicas;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
/**
 * Clase MessengerTest para probar el funcionamiento de la aplicacion
 */
public class MessengerTest {
    @Test
    public void TestPersonAndGroupConstructor() {
        // Comprobacion de constructor
        Contact personCorto =  new Person("P", "6");
        Contact personLargo = new Person("EvaristoSanJuan", "683267912");
        Group familia = new Group("familia");
        Group amigos = new Group("amigos");
        Group amigas = new Group("amigas");
        Group todos =  new Group("todos");
        Group noFamilia = new Group("no familiares");
        /**
         * Comprobacion del constructor con mismos parametros pero que tienen id distintas
         *  porque es una variable estatica
         */
        Person personCopia =  new Person("P", "6");
        assertFalse(personCorto.getId() == personCopia.getId());
       // Ahora comprobamos que tienen el mismo nombre
       assertTrue(personCorto.getName() == personCopia.getName());
       
    }
    
    @Test
    public void TestPersonToString() {
        // Comprobacion de representacion string corta
        Person stringCorta = new Person("P", "6");
        assertTrue(stringCorta.toString().equals("P: 6"));
        
        // Comprobacion de representacion string larga
        Person stringLarga = new Person("EvaristoSanJuan", "683267912");
        assertTrue(stringLarga.toString().equals("EvaristoSanJuan: 683267912"));
        
        // Comprobacion de strings distintas
        assertFalse(stringLarga.toString().equals(stringCorta.toString()));
    }

    /**
     * Test para el funcionamiento del metodo isMember()
     */
    @Test
    public void TestGroupIsMember() {
        Person pepe = new Person("pepe", "123");
        Person luis = new Person("luis", "133323");
        Person contactoAnonimo = new Person("anonimo", "0");
        Group grupo = new Group("grupo");
        Group grupoDentro = new Group("grupo dentro");
        
        // Comprobacion si 1 persona es de un grupo
        grupo.add(pepe);
        assertTrue(grupo.isMember(pepe.getId()));
        
        // Comprobacion indirecta
        grupo.add(grupoDentro);
        grupoDentro.add(luis);
        assertTrue(grupo.isMember(luis.getId()));
        
        // Comrpobacion de un contacto no dentro del grupo
        assertFalse(grupo.isMember(contactoAnonimo.getId()));
        
    }
    
    /**
     * Test para el funcionamiento del metodo add()
     */
    @Test
    public void TestGroupAdd() {
        Person pepe = new Person("pepe", "123");
        Person juan = new Person("juan", "123");
        Person pedro = new Person("pedro", "123");
        Group grupo = new Group("grupo");
        
        // Comprobacion ningun miembro en el grupo
        //assertTrue(grupo.getContacts().size() == 0);
        
        // Comprobacion añadir miembros al grupo
        grupo.add(pepe);
        grupo.add(juan);
        grupo.add(pedro);
        //assertTrue(grupo.getContacts().size() == 3);
        
        // Comprobacion añadir miembros al grupo repetidos directamente
        grupo.add(juan);
        //assertTrue(grupo.getContacts().size() == 3);
        
        // Comprobacion añadir miembros al grupo repetidos indirectamente
        Group grupo2= new Group("grupo2");;
        grupo2.add(pedro);
        grupo2.add(juan);
        grupo.add(pepe);
        grupo.add(grupo2);//4 miembros;
        //Añadimos 2 mas de manera indirecta
        grupo.add(juan);
        grupo.add(pedro);
        // El tamaño es 4 porque cuenta el nombre del grupo
        // pero no cuenta los contactos repetidos indirectamente
        assertTrue(grupo.getContacts().size() == 4);
    }
    
    /**
     * Test para el funcionamiento del metodo remove()
     */
    @Test
    public void TestGroupRemove() {

        // Caso 1 Añadir y eliminar
        Person juan = new Person("Juan", "55541501");  
        Group grupo = new Group("grupo");
        grupo.add(juan);
        grupo.remove(juan.getId());
        assertTrue(grupo.getContacts().size() == 0); 

        //Caso 2 Eliminar por el medio
        Person pepe = new Person("pepe", "111");
        Person juanSegundo = new Person("juan segundo", "222");
        Person pedro = new Person("pedro", "333");
        Group grupo2 = new Group("grupo2");
        grupo2.add(pepe);
        grupo2.add(juanSegundo);
        grupo2.add(pedro);
        grupo2.remove(pedro.getId());
        assertTrue(grupo2.getContacts().size() == 2); 
        
        //Caso 3 Eliminar ultimo miembro
        Group grupo3 = new Group("grupo3");
        grupo3.add(pepe);
        grupo3.add(juanSegundo);
        grupo3.add(pedro);
        grupo3.remove(pedro.getId());
        assertTrue(grupo3.getContacts().size() == 2);

        //Caso 4 Eliminar contacto indirectamente
        Group grupo4 = new Group("grupo3");
        Group grupoEspecial = new Group("grupo dentro");
        grupo4.add(pepe);
        grupo4.add(juanSegundo);
        Person juanTercero = new Person("juan tercero", "23432232");
        Person pedroSegundo = new Person("pedro segundo", "3123313");
        grupoEspecial.add(pedro);
        grupoEspecial.add(juanTercero);
        grupoEspecial.add(pedroSegundo);
        grupo4.add(grupoEspecial);// 6 miembros en total
        
        //Eliminamos un miembro del grupo interior
        grupo4.remove(pedroSegundo.getId());
        int sizeTotal = grupo4.getContacts().size();
        // Recorremos tanto el grupo exterior como el interior
        for (Contact contactos: grupo4.getContacts()) {
            if(contactos instanceof Group) {
                Group grupoInterior = (Group)contactos;
                for (Contact contactosDentro: grupoInterior.getContacts()) {
                    sizeTotal++;
                }
            }
        }
        assertTrue(sizeTotal == 6);
         
        //Caso 5 Eliminar un contacto que no esta en el grupo
        Person jorge = new Person("jorge", "000");
        Group grupo5 = new Group("grupo4");
        grupo5.add(pepe);
        grupo5.add(juanSegundo);
        grupo5.add(pedro);
        grupo5.remove(jorge.getId());// Eliminamos el que no existe
        assertTrue(grupo5.getContacts().size() == 3);

    }
    
    /**
     * Test para el funcionamiento del metodo getContacts()
     */
    @Test
    public void TestGroupGetContacts() {
        Person juan = new Person("Juan","55541501"); 
        Person pepe = new Person("pepe", "123");
        Person pedro = new Person("pedro", "123");
        
        //Caso 1 Varios contactos
        Group grupo = new Group("grupo");
        grupo.add(juan);
        grupo.add(pepe);
        grupo.add(pedro);
        int sizeGrupo = grupo.getContacts().size();
        int contadorIgual = 0;
        for(Contact contactos: grupo.getContacts()) {
            contadorIgual++;
        }
        assertTrue(sizeGrupo == contadorIgual);
        
        
        // caso 2 Añadir Contactos y grupos con contactos
        Group grupo2 = new Group("grupo2");                
        Person marquez = new Person("marquez","55541501"); 
        Person jesus = new Person("jesus", "123");
        Person pancho = new Person("pancho", "123");
        grupo2.add(marquez);
        grupo2.add(jesus);
        grupo2.add(pancho);
        grupo.add(grupo2);
        int contador = 0;
        int valor = grupo.getContacts().size() - 1 ;
        int contador2 = 0;
        for(Contact contacto: grupo.getContacts()){
            if (contacto instanceof Group){
                Group minigrupo = (Group) contacto;
                for (Contact recorre: minigrupo.getContacts()){
                    contador++;
                    contador2++;
                }
                
            }else{
                contador++;
            }
        }
        assertEquals(contador,contador2 + valor);
        
        //Caso 3 Modificar la lista devuelta para ver si cambia la original
        List<Contact> contactos = new ArrayList<Contact>();
        contactos.addAll(grupo.getContacts());
        contactos.remove(0);
        assertNotEquals(contactos.size(), grupo.getContacts());
        
    }
    
    /**
     * Test para el funcionamiento del metodo toString()
     */
    @Test
    public void TestGroupToString() {
        Group grupo = new Group("grupo");
        
        // Caso 1 grupo vacio
        assertTrue(grupo.toString().equals("grupo\n"));
        
        
        // Caso 2 grupo con 1 contacto
        Person juan = new Person("Juan", "55541501");
        grupo.add(juan);
        assertTrue(grupo.toString().equals("grupo\nJuan: 55541501\n"));
       
        // Caso 3 grupo con varios contacto(Comprobacion ordenacion por nombre)
        Person pepe = new Person("pepe", "1233423");
        Person pedro = new Person("pedro", "123");
        grupo.add(pepe);
        grupo.add(pedro);
        assertTrue(grupo.toString().equals("grupo\nJuan: 55541501\npedro: 123\npepe: 1233423\n"));
       
        // Caso 4 grupo con varios contactos y un grupo con otros contactos
        Group grupo2= new Group("grupo2");
        Person rene = new Person("rene", "123232");
        Person descartes = new Person("descartes", "134323");
        grupo.add(grupo2);
        grupo2.add(rene);
        grupo2.add(descartes);
        String comprobacion = "grupo\nJuan: 55541501\n";
        String comprobacionSegunda = "grupo2\ndescartes: 134323\nrene: 123232\n\n";
        String comprobacionTercera = "pedro: 123\npepe: 1233423\n";
        assertTrue(grupo.toString().equals(comprobacion + comprobacionSegunda + comprobacionTercera));
       
        // Caso 5 grupo con varios contactos y un grupo con mismos contactos
        // No se deberia poder b
        Group grupoNuevo = new Group("grupo");
        Group grupoNuevoInterior = new Group("Interior");
        grupoNuevo.add(pepe);
        grupoNuevo.add(grupoNuevoInterior);
        grupoNuevoInterior.add(rene);
        // Añadimos de manera indirecta el mismo contacto
        grupoNuevo.add(rene);
        String comprobacionUltima = "grupo\nInterior\nrene: 123232\n\npepe: 1233423\n";
        assertTrue(grupoNuevo.toString().equals(comprobacionUltima));

    }
    
    /**
     * Test utilizado para comprobar el codigo puesto de ejemplo
     * para comprobar ningun fallo en la aplicacion
     */
    @Test
    public void TestCodigoEjemplo() {
        Person pepe = new Person("Pepe", "5555380");
        Person juan = new Person("Juan", "55541501");
        Person antonio = new Person("Antonio", "5556380");
        Person maría = new Person("María", "5557780");
        Person ana = new Person("Ana", "5557781");
        Group familia = new Group("familia");
        Group amigos = new Group("amigos");
        Group amigas = new Group("amigas");
        Group todos =  new Group("todos");
        Group noFamilia= new Group("no familiares");
        familia.add(juan);
        familia.add(maría);
        amigos.add(pepe);
        amigos.add(antonio);
        amigas.add(ana);
        noFamilia.add(amigos);
        noFamilia.add(amigas);
        todos.add(familia);
        todos.add(noFamilia);
    }
}
