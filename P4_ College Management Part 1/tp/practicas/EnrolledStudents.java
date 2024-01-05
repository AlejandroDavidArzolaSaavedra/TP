package tp.practicas;
import java.util.*;

/**
 * Clase EnrolledStudents que representa el conjunto de estudiantes
 * matriculados en el centro educativo
 */
public class EnrolledStudents {
    // Lista de estudiantes matriculados
    List<Student> collegeEnrolledStudents = new ArrayList<Student>();
    
    // Constructor vacio del conjunto de estudiantes
    public EnrolledStudents(){}
    
    /**
     * Metodo para añadir estudiantes al conjunto
     * de estudiantes matriculados
     * 
     * @param newStudent Nuevo estudiante a matricular
     * @return Devuelve verdadero si lo añade o falso
     * si ya esta registrado un alumno con el mismo identificador
     * 
     */
    public boolean addStudent(Student newStudent) {
        for(Student registeredStudents: collegeEnrolledStudents) {
            if(registeredStudents.getId() == newStudent.getId())
                return false;
        }
        return collegeEnrolledStudents.add(newStudent);
    }
    
    /**
     * Metodo para quitar estudiantes del conjunto 
     * de estudiantes matriculados
     * 
     * @param id Identificador del estudiante
     * @return Devuelve verdadero si lo quita o falso si no lo encuentra
     */
    public boolean removeStudent(int id) {
        Student reserveStudent = null;
        for(Student registeredStudents: collegeEnrolledStudents) {
            if( registeredStudents.getId() == id )
                reserveStudent = registeredStudents;
        }
        return collegeEnrolledStudents.remove(reserveStudent);
    }
    
    /**
     * Metodo para devolver un estudiante a partir
     * de su identificador
     * 
     * @param id Identificador del estudiante
     * @return Devuelve el estudiante si esta matriculado
     * en el centro educativo o null si no lo esta
     */
    public Student getStudent(int id) {
         for(Student students: collegeEnrolledStudents) {
            if( students.getId() == id )
                return students;
        }
        return null;
    }
    
    /**
     * Metodo para devolver una lista de estudiantes
     * matriculados en la asignatura con el codigo
     * pasado como parametro de entrada
     * 
     * @param code Codigo de la asignatura
     * @return Devuelve lista de estudiantes ordenadas por el nombre 
     * del estudiante y si tienen mismo nombre por su identificador
     */
    public List<Student>getStudentsByCourse(int code) {
        List<Student> orderStudents = new ArrayList<Student>();
        // Primero accedemos al estudiante y luego a sus asignaturas
        for(Student students : collegeEnrolledStudents) {
            for( Course courses : students.getEnrolledCourses()){
                // Si tiene el mismo codigo identificador lo añadimos
                if (courses.getCode() == code)
                    orderStudents.add(students);
            }
        }
        // Lo ordenamos por el nombre o su identificador
        Collections.sort(orderStudents, new OrderByNameOrId());
        return orderStudents;
    }
    
    /**
     * Metodo para devolver una lista de estudiantes
     * del centro educativo
     * 
     * @return Devuelve lista de estudiantes ordenadas por el nombre 
     * del estudiante y si tienen mismo nombre por su identificador
     */
    public List<Student> getStudentsOrderByName() {
        List<Student> orderStudents = new ArrayList<Student>();
        orderStudents.addAll(collegeEnrolledStudents);
        // Lo ordenamos por el nombre o su identificador
        Collections.sort(orderStudents, new OrderByNameOrId());
        return orderStudents;
    }
    
    /**
     * Metodo para devolver una lista de estudiantes
     * del centro educativo
     * 
     * @return Devuelve lista de estudiantes ordenadas por su identificador
     */
    public List<Student> getStudentsOrderById() {
        List<Student>orderStudents = new ArrayList<Student>();
        orderStudents.addAll(collegeEnrolledStudents);
        // Lo ordenamos por el identificador del estudiante
        Collections.sort(orderStudents, (c1, c2) -> c1.getId() - c2.getId());
        return orderStudents;
    }
    /**
     * Clase para ordenar el conjunto de estudiantes
     * por su nombre o identificador si tienen el mismo nombre
     */
    private class OrderByNameOrId implements Comparator<Student> {
        @Override
        public int compare(Student c1, Student c2) {
            return c1.getName().compareTo(c2.getName()) == 0 ? 
                    c1.getId() - c2.getId() : c1.getName().compareTo(c2.getName());
        }
    }
}
