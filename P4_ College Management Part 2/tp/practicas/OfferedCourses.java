package tp.practicas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OfferedCourses {
    // Lista de asignaturas del centro educativo.
    List<Course> offeredCourses = new ArrayList<>();
    
    /**
     * Constructor vacio del conjunto de asignaturas ofertadas.
     */
    public OfferedCourses(){}
    
    /**
     * Metodo para añadir asignaturas al contenedor
     * de asignaturas.
     * 
     * @param newCourse Nueva asignatura a añadir
     * @return Devuelve trur si la añade y false si  existe con ese identificador
     */
    public boolean addCourse(Course newCourse) {
        for(Course courses: offeredCourses) {
            if(newCourse.getCode() == courses.getCode())
                return false;
        }
        return offeredCourses.add(newCourse);
    }
    
    /**
     * Metodo para quitar asignaturas del contenedor
     * de asignaturas.
     * 
     * @param code Identificador de la asignatura a quitar
     * @return Devuelve verdadero si la quita y falso si no la encuentra
     */
    public boolean removeCourse(int code){
        Course reserveCourse = null;
        for(Course courses: offeredCourses) {
            if(courses.getCode() == code)
               reserveCourse = courses; 
        }
        return offeredCourses.remove(reserveCourse);
    }
    
    /**
     * Metodo para devolver una asignatura
     * a partir de su identificador.
     * 
     * @param code Identificador de la asignatura a quitar
     * @return Devuelve la asignatura si la encuentra por
     * su identificador o un null si no la encuentra
     */
    public Course getCourse(int code){
        for(Course courses: offeredCourses) {
            if(courses.getCode() == code)
                return courses;
        }
        return null;
    }
    
    /**
     * Metodo para devolver las asignaturas ofertadas por el centro
     * 
     * @return Devuelve las asignaturas ordenadas por el toString() de Course
     */
    public List<Course> getCourses() {
        List<Course> listaNew = new ArrayList<>();
        listaNew.addAll(offeredCourses);
        // Lo ordenamos segun el toString() de la clase Course
        Collections.sort(listaNew, (c1, c2) -> c1.toString().compareTo(c2.toString()));
        return listaNew;
    }
}
