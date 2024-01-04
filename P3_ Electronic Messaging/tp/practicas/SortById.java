package tp.practicas;
import java.util.Comparator;
/**
 * Clase SortById para ordenar los contactos por su id
 * 
 * @return la comparacion entre 2 contactos para ordenarlos
 */
public class SortById implements Comparator<Contact> {
    @Override
    public int compare(Contact c1, Contact c2) {
        return c1.getId() - c2.getId();
    }
}
