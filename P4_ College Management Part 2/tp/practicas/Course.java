package tp.practicas;


/**
 * Clase Course para representar los asignaturas del centro educativo
 */
public class Course {
    private final int code;
    private final String name;
    
    /**
     * Constructor de la asignatura
     * 
     * @param code Codigo de la asignatura
     * @param name Nombre de la asignatura
     */
    public Course(int code, String name) {
        this.code = code;
        this.name = name;
    }
    
    /**
     *  Metodo getter para devolver el codigo 
     *  de la asignatura del centro
     * 
     * @return el codigo de la asignatura
     */
    public int getCode() {
        return this.code;
    }
    
    /**
     *  Metodo getter para devolver el nombre de la asignatura
     * 
     * @return el nombre de la asignatura
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Representacion string de la asignatura
     * 
     * @return String con el codigo y nombre de la asignatura
     */
    @Override
    public String toString() {
        StringBuilder courseString = new StringBuilder();
        courseString.append("(").append(getCode()).append(")").append(getName());
        return courseString.toString();
    }
}
