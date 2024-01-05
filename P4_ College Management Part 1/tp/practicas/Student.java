package tp.practicas;
import java.util.*;

/**
 * Clase Student que representa un estudiante del centro educativo
 */
 public class Student {
    private int id;
    private String name;
    // Lista de asignaturas a las que esta matriculado el estudiante
    List<Course> registeredCourse = new ArrayList<Course>();
    
    /**
     * Constructor del estudiante
     * 
     * @param id Identificador del estudiante
     * @param name Nombre del estudiante
     */
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    /**
     * Metodo getter que devuelve el identificador del estudiante
     * 
     * @return Identificador del estudiante
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Metodo getter que devuelve el nombre del estudiante
     * 
     * @return Nombre del estudiante
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Metodo para añadir asignaturas al estudiante
     * Si esta matriculado a la asignatura pasada como parametro
     * de entrada no lo añade
     *
     * @param newCourse Nueva asignatura para asignar al estudiante
     * @return Devuelve verdadero si lo añade y falso si no
     */
    public boolean enrollCourse(Course newCourse) {
        for(Course courses : registeredCourse){
            if(courses.getCode() == newCourse.getCode())
                return false;
        }
        return registeredCourse.add(newCourse);
    }
    
    /**
     * Metodo para quitar asignaturas al estudiante
     * Quita asignaturas por el codigo de asignatura
     * pasado como parametro de entrada
     * 
     * @param code Codigo de la asignatura
     * @return Devuelve verdadero si lo quita y falso si no
     */
    public boolean unenrollCourse(int code) {
        Course reserveCourse = null;
        for(Course courses : registeredCourse) {
            if(courses.getCode() == code)
                reserveCourse = courses;
        }
        return registeredCourse.remove(reserveCourse);
    }
    
    /**
     * Metodo que devuelve las asignaturas a la 
     * que este matriculado el estudiante
     * 
     * @param code Codigo de la asignatura.
     * @return Devuelve verdadero si lo quita y falso si no
     */
    public Collection<Course> getEnrolledCourses() {
        // Lo ordenamos por el codigo del curso
        Collections.sort(registeredCourse, (c1,  c2) -> c1.getCode() - c2.getCode());
        Collection<Course> orderCourses = new ArrayList<Course>();
        orderCourses.addAll(registeredCourse);   
        return  orderCourses;
    }
    
    /**
     * Representacion String del conjunto de asignaturas
     * matriculadas por el estudiante
     * 
     * @return Identificador del estudiante con su nombre y el conjunto
     * de asignaturas matriculadas
     */
    public String toString() {
        StringBuilder studentCourses = new StringBuilder();
        studentCourses.append(getId()).append("-").append(getName()).append(getEnrolledCourses().toString());
        return studentCourses.toString();
    }
}
