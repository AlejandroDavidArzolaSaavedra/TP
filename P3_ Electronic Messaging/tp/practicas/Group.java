package tp.practicas;
import java.util.*;
/**
 * Clase Grupo para representar las grupos de personas de la aplicacion
 */
public class Group extends Contact {
    private List<Contact> ListContact = new ArrayList<Contact>();
    private static String resultToString = "";
    
    /**
     * Constructor con parametros de la clase Grupo 
     * 
     * @param name nombre del grupo
     */
    public Group(String name) {
        super(name);
    }
    
    /**
     * Metodo para saber si es el identificador pasado por 
     * parametro es miembro del grupo directa o indirectamente
     * 
     * @param id identificador del contacto que se busca
     * @return Devuelve verdadero si esta contenido y falso si no.
     */
    public boolean isMember(int id) {
        for (Contact contactList: ListContact) {
            // Contenido directamente
            if(contactList.getId() == id){
                return true;
                }  
            // Contenido indirectamente
            if(contactList instanceof Group ) {
                Group groupList = (Group) contactList;
                if (groupList.isMember(id)) return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo para añadir un contacto al grupo
     * 
     * @param contactUser Contacto que se quiere añadir al grupo
     * @return Devuelve falso si esta contenido directa
     * o indirectamente o si es el mismo grupo y verdadero sino.
     */
    public boolean add(Contact contactUser) {
        if((this.getId() == contactUser.getId()) ^ isMember(contactUser.getId())) {
             return false;
        }
        ListContact.add(contactUser);
        return true;
    }
    
    /**
     * Metodo para eliminar un contacto al grupo directamente
     * 
     * @param id Identificador del contacto a eliminar
     * @return Devuelve verdadero si lo elimino y falso sino.
     */
    public boolean remove(int id) {
        // Contacto de reserva para eliminarlo despues de iterar
        Contact reserve = null;
        for(Contact contacto : ListContact) {
            if(contacto.getId() == id){
                    reserve = contacto;
                }
            }   
            return ListContact.remove(reserve);
    }
    
     /**
     * Metodo para representar los contactos de los grupos
     * 
     * @return Devuelve una String con todos los contactos
     */
    @Override
    public String toString() {
         // Ordenamiento por nombre
        
        Collections.sort(ListContact, new SortByName());
        resultToString = getName() + "\n";
        for(Contact contactoList : ListContact) {
            if(contactoList instanceof Person ) {
                Person persona = (Person) contactoList;
                resultToString += persona.toString() + "\n";
                }else {
                    // Se llama de nuevo para los contactos que son personas
                    resultToString += contactoList.toString() + "\n";
                }
        }
        return resultToString;
    }
    
     /**
     * Metodo devolver una lista de contactos directos del grupo
     * 
     * @return Una lista de contactos del grupo
     */
    public List<Contact> getContacts() {
        List<Contact> newListContact = new ArrayList<Contact>();
        // Nueva lista para tratar si se modificara la lista devuelva
        for (Contact contactList : ListContact) {
            newListContact.add(contactList);   
            }
        // Ordenamiento por id
        Collections.sort(newListContact, new SortById());
        return newListContact;
    }
    
     /**
     * Metodo sendSms para enviar un mensaje a todo el grupo
     * 
     * @param msg Mensaje a enviar a todo el grupo
     */
    @Override
    public void sendSMS(String msg) {
        for (Contact contactList : ListContact) {
             contactList.sendSMS(msg);
        }
    }
}
