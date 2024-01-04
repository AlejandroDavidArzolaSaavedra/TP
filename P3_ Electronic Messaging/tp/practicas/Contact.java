package tp.practicas;
/**
 * Clase contacto para representar los contactos del envio de SMS
 */
public abstract class Contact {
    private String name;
    private int id;
    
    /**
     * Constructor con parametros del contacto
     * 
     * @param nombreContacto nombre del contacto 
     */
    public Contact(String name) {
        this.name = name;
        this.id = SMSTools.getUniqueId();
    }
    
    /**
     * Getter de la id del cotacto
     * 
     * @return la id asociada al contacto 
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Getter de nombre del cotacto
     * 
     * @return el nombre asociada al contacto 
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Metodo abstracto que envia un mensaje a un contacto
     * 
     * @param msg Mensaje asociado al contacto 
     */
    public abstract void sendSMS(String msg);
}
