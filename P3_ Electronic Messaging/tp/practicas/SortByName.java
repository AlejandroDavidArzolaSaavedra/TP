package tp.practicas;
import java.util.Comparator;
/**
 * Clase SortByName para ordenar los contactos por su nombre
 * 
 * @return la comparacion entre 2 contactos para ordenarlos
 */
public class SortByName implements Comparator<Contact> {
    @Override
    public int compare(Contact c1, Contact c2) {
        return c1.getName().compareTo(c2.getName());
    }
}
