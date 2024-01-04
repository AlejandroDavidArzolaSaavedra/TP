package tp.practicas;
/**
 * Clase Persona para representar las personas de la aplicacion
 */
public class Person extends Contact {
    private String telephoneNumber;
  
    /**
     * Constructor con parametros de la clase Persona
     * 
     * @param name Nombre de la persona
     * @param telephoneNumber El numero de telefono de la persona
     */
    public Person(String name, String telephoneNumber){
        super(name);
        this.telephoneNumber = telephoneNumber;
    }
    
    /**
     * Representacion del objeto
     * 
     * @return String con el nombre y el telefono del contacto 
     */
    @Override
    public String toString(){
        StringBuilder resultado = new StringBuilder();
        resultado.append(super.getName() + ": " + this.telephoneNumber);
        return resultado.toString();
    }
    
    /**
     * Metodo para enviar el mensaje
     *
     * @param msg Mensaje que desea enviar la persona 
     */
    @Override
    public void sendSMS(String msg) {
        SMSTools.sendMessage(this.telephoneNumber, msg);
    }
}
