package tp.practicas;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

/**
 * Clase CollegeTest para probar el funcionamiento de la aplicacion
 */
public class CollegeTest {
    
    //////////////////////////////////////////
    //Test de la clase Course (asignatura)///
    ////////////////////////////////////////
    
    /**
     * Metodo Course() para probar el funcionamiento del constructor
     */
    @Test
    public void CourseConstructorTest(){
        
        // Caso 1 crear varias asignaturas
        Course language = new Course(40940, "Language");
        Course mathematic = new Course(40941, "Mathematic");
        Course geography = new Course(40943, "Geography");
        assertTrue(language.equals(language));
        assertFalse(geography.equals(mathematic));
    }
    
    /**
     * Metodo para probar los getters (getCode() , getName())
     */
    @Test
    public void CoursetogetCodeAndGetNameTest(){
        
        // Caso 1 crear una asignatura  devolver su codigo y nombre
        Course language = new Course(40940, "Language");
        assertTrue(language.getName().equals("Language"));
        assertEquals(language.getCode(), 40940);
    }
    
    /**
     * Metodo para probar el toString()
     */
    @Test
    public void CoursetoStringTest(){
        
        // Caso 1 Crear  asignaturas y devolver la string esperada
        Course language = new Course(40940, "Language");
        assertTrue(language.toString().equals("(40940)Language"));
        Course mathematic = new Course(40941, "Mathematic");
        assertTrue(mathematic.toString().equals("(40941)Mathematic"));
    }
    
    ///////////////////////////////////////////
    //Test de la clase Student (estudiantes)//
    /////////////////////////////////////////
    
    /**
     * Metodo Student() para probar el constructor
     */
    @Test
    public void StudentConstructorTest(){
        
        // Caso 1 crear varios estudiantes 
        Student juan = new Student(42223928, "Juan");
        Student luis = new Student(42223428, "Luis");
        Student jorge = new Student(23442928, "Jorge");
        assertTrue(juan.equals(juan));
        assertFalse(jorge.equals(juan));
    }
    
    /**
     * Metodo para probar los getter (getId(), getName())
     */
    @Test
    public void StudentGetIdAndGetNameTest(){
        
        // Caso 1 crear un estudiante y devoulver su id y nombre
        Student juan = new Student(42223928, "Juan");
        assertTrue(juan.getName().equals("Juan"));
        assertFalse(juan.getId() == 0);
    }
    
  
    /**
     * Metodo para probar si se puede  añadir asignaturas a un estudiante
     */
    @Test
    public void StudentEnrollCourseTest(){
        Student juan = new Student(42223928, "Juan");
        Course mathematic = new Course(40941, "Mathematic");
        Course language = new Course(40940, "Language");
        Course english = new Course(40942, "English");
        Course[] array = {mathematic,language,english};
        
        // Caso 1 añadir una asignatura al estudiante nueva
        assertTrue(juan.enrollCourse(mathematic));
        
        // Caso 2 añadir varias asignaturas al estudiante no repetidas
        assertTrue(juan.enrollCourse(language));
        assertTrue(juan.enrollCourse(english));
        
        // Caso 3 Comprobar añadir una asignatura
        // repetida el metodo devuelve false
        assertFalse(juan.enrollCourse(mathematic));
    }
    
    /**
     * Metodo para probar si se puede quitar asignaturas a un estudiante
     */
    @Test
    public void StudentUnenrollCourseTest(){
        Student juan = new Student(42223928, "Juan");
        Course mathematic = new Course(40941, "Mathematic");
        Course language = new Course(40940, "Language");
        Course english = new Course(40942, "English");
        Course geography = new Course(40943, "Geography");
        
        // Caso 1 añadir una asignatura al estudiante nueva y eliminarla
        juan.enrollCourse(mathematic);
        assertTrue(juan.unenrollCourse(40941));
        
        // Caso 2 añadir varias asignaturas al estudiante
        // no repetidas y eliminar los siguientes:
        juan.enrollCourse(mathematic);
        juan.enrollCourse(language);
        juan.enrollCourse(english);
        
        // 2.1 Eliminar uno del principio
        assertTrue(juan.unenrollCourse(40940));
        juan.enrollCourse(language);
        
        // 2.2 Eliminar uno del medio
        assertTrue(juan.unenrollCourse(40941));
        juan.enrollCourse(mathematic);
        
        // 2.3 Eliminar uno del final
        assertTrue(juan.unenrollCourse(40942));
        juan.enrollCourse(english);
        
        // Caso 3 Comprobar que devuelve false
        // sino encuentra la asignatura
        assertFalse(juan.unenrollCourse(40943));
    }
    
    /**
     * Metodo para  probar si devuelve  una collecion de las asignaturas
     * a las que el estudiante esta matriculado
     */
    @Test
    public void StudentGetEnrolledCoursesTest(){
        Student juan = new Student(42223928, "Juan");
        Course mathematic = new Course(40941, "Mathematic");
        Course language = new Course(40940, "Language");
        Course english = new Course(40942, "English");

        // Caso 1 Añadir 1 asignatura al estudiante
        juan.enrollCourse(mathematic);
        assertTrue(juan.getEnrolledCourses().toString().equals("[(40941)Mathematic]"));
        
        // Caso 2 añadir varias asignaturas al estudiante.
        // Y comprobar que estan ordenadas por el codigo de la asignatura.
        juan.enrollCourse(language);
        juan.enrollCourse(english);
        StringBuilder courses = new StringBuilder();
        courses.append("[(40940)Language, (40941)Mathematic, (40942)English]");
        assertTrue(juan.getEnrolledCourses().toString().equals(courses.toString()));
    }
    
    /**
     * Metodo para probar toString() del estudiante
     */
    @Test
    public void StudentToStringTest(){
        Student juan = new Student(42223928, "Juan");
        Course mathematic = new Course(40941, "Mathematic");
        Course language = new Course(40940, "Language");
        Course english = new Course(40942, "English");
        Student juanRepeat = new Student(4222398, "Juan");
        
        // Caso 1 Añadir 1 asignatura al estudiante
        // y comprobar que devuelve el estudiante  con su asignatura
        // ordenadas por el codigo de la asignatura
        juan.enrollCourse(mathematic);
        StringBuilder student  = new StringBuilder();
        student.append("42223928-Juan[(40941)Mathematic]");
        assertTrue(juan.toString().equals(student.toString()));
        
        // Caso 2 añadir varias asignaturas al estudiante
        // y comprobar que devuelve  el estudiante con su asignatura
        // ordenadas por el codigo de la asignatura
        juan.enrollCourse(language);
        juan.enrollCourse(english);
        StringBuilder studentCourses  = new StringBuilder();
        studentCourses.append("42223928-Juan");
        studentCourses.append("[(40940)Language, (40941)Mathematic, (40942)English]");
        assertTrue(juan.toString().equals(studentCourses.toString()));

        // Caso 3 Comprobar  dos estudiantes
        // con mismo nombre pero distinto id y con misma asignatura
        juan.unenrollCourse(40940);
        juan.unenrollCourse(40942);
        juanRepeat.enrollCourse(mathematic);
        assertFalse(juan.toString().equals(juanRepeat.toString()));
    }
    
    /////////////////////////////////////////////////////////////////////////
    //Test de la clase EnrolledStudents(conjunto estudiantes matriculados)//
    ///////////////////////////////////////////////////////////////////////

    /**
     * Metodo para probar el funcionamiento del constructor
     */
    @Test
    public void EnrolledStudentsConstructorTest(){
        
        // Caso 1 crear varios conjuntos de estudiantes 
        EnrolledStudents enrolledStudentsMath = new EnrolledStudents();
        EnrolledStudents enrolledStudentsLanguage = new EnrolledStudents();
        EnrolledStudents enrolledStudentsenglish = new EnrolledStudents();
        assertFalse(enrolledStudentsMath.equals(enrolledStudentsLanguage));
        assertTrue(enrolledStudentsLanguage.equals(enrolledStudentsLanguage));
    }
    
    /**
     * Metodo para probar si se pueden añadir estudiantes al 
     * conjunto de estudiantes
     */
    @Test
    public void EnrolledStudentsAddStudentTest(){
        EnrolledStudents enrolledStudentsMath = new EnrolledStudents();
        Student juan = new Student(42223928, "Juan");
        Student luis = new Student(42223428, "Luis");
        Student jorge = new Student(23442928, "Jorge");
        
        // Caso 1 Añadir 1 estudiante al conjunto
        assertTrue(enrolledStudentsMath.addStudent(juan));
        
        // Caso 2 Añadir varios estudiantes sin repetir
        assertTrue(enrolledStudentsMath.addStudent(luis));
        assertTrue(enrolledStudentsMath.addStudent(jorge));
        
        // Caso 3 Añadir varios estudiantes y alguno repetido
        assertFalse(enrolledStudentsMath.addStudent(jorge));
    }
    
    /**
     * Metodo para probar si se pueden quitar estudiantes al 
     * conjunto de estudiantes
     */
    @Test
    public void EnrolledStudentsRemoveStudentTest(){
        EnrolledStudents enrolledStudentsMath = new EnrolledStudents();
        Student juan = new Student(42223928, "Juan");
        Student luis = new Student(41223428, "Luis");
        Student jorge = new Student(23442928, "Jorge");
        Student lili = new Student(93333928, "Lili");
        Student clara = new Student(222928, "Clara");
        Student fux = new Student(13233928, "Fux");
        Student estudianteAnonimo = new Student(696969, "Estudiante Anonimo");

        // Caso 1 Añadir 1 estudiante al conjunto y eliminarlo 
        enrolledStudentsMath.addStudent(juan);
        enrolledStudentsMath.removeStudent(42223928);
        assertTrue(enrolledStudentsMath.getStudentsOrderById().size() == 0);
        
        // Caso 2 Añadir varios estudiantes sin repetir
        enrolledStudentsMath.addStudent(juan);
        enrolledStudentsMath.addStudent(luis);
        enrolledStudentsMath.addStudent(jorge);
        enrolledStudentsMath.addStudent(lili);
        enrolledStudentsMath.addStudent(clara);
        enrolledStudentsMath.addStudent(fux);
        
        // Caso 2.1 Eliminamos uno del principio
        enrolledStudentsMath.removeStudent(42223928);
        assertTrue(enrolledStudentsMath.getStudentsOrderById().size() == 5);
        enrolledStudentsMath.addStudent(juan);
        
        // Caso 2.2 Eliminamos uno del medio
        enrolledStudentsMath.removeStudent(23442928);
        assertTrue(enrolledStudentsMath.getStudent(23442928) == null);
        enrolledStudentsMath.addStudent(jorge);
        
        // Caso 2.3 Eliminamos uno del final
        enrolledStudentsMath.removeStudent(13233928);
        assertTrue(enrolledStudentsMath.getStudent(13233928) == null);
        enrolledStudentsMath.addStudent(fux);
        
        // Caso 3 Añadir varios estudiantes y eliminar
        // uno que  no existe comprobar que da falso
        assertEquals(enrolledStudentsMath.removeStudent(696969), false);
    }
    
    /**
     * Metodo para probar si se devuelve el estudiante
     * a partir de su identificador
     */
    @Test
    public void EnrolledStudentsGetStudentTest(){
        EnrolledStudents enrolledStudentsMath = new EnrolledStudents();
        Student juan = new Student(42223928, "Juan");
        Student luis = new Student(41223428, "Luis");
        Student jorge = new Student(23442928, "Jorge");
        Student lili = new Student(93333928, "Lili");
        Student clara = new Student(222928, "Clara");
        Student fux = new Student(13233928, "Fux");
        Student estudianteAnonimo = new Student(696969, "Estudiante Anonimo");

        // Caso 1 Añadir 1 estudiante al conjunto y comprobar que lo devuelve
        enrolledStudentsMath.addStudent(juan);
        assertTrue(enrolledStudentsMath.getStudent(42223928).
            toString().equals("42223928-Juan[]"));
        enrolledStudentsMath.removeStudent(42223928);
        
        // Caso 2 Añadir varios estudiantes sin repetido
        enrolledStudentsMath.addStudent(juan);
        enrolledStudentsMath.addStudent(luis);
        enrolledStudentsMath.addStudent(jorge);
        enrolledStudentsMath.addStudent(lili);
        enrolledStudentsMath.addStudent(clara);
        enrolledStudentsMath.addStudent(fux);
        
        // Caso 2.1 Devolver uno del principio
        assertTrue(enrolledStudentsMath.getStudent(42223928).
            toString().equals("42223928-Juan[]"));
        // Caso 2.2 Devolver uno del medio
        assertTrue(enrolledStudentsMath.getStudent(23442928).
            toString().equals("23442928-Jorge[]"));
        
        // Caso 2.3 Devolver uno del final
        assertTrue(enrolledStudentsMath.getStudent(13233928).
            toString().equals("13233928-Fux[]"));
        
        // Caso 3 Añadir varios estudiantes y pedirle
        // que devuelva uno que no esta-> debe devolver null
        assertTrue(enrolledStudentsMath.getStudent(696969) == null);
    }

    /**
     * Metodo para probar si devuelve una lista de estudiantes matriculados 
     * ordenados por su nombre o por su identificador
     */
    @Test
    public void EnrolledStudentsGetStudentsByCourseTest(){
        EnrolledStudents enrolledStudentsMath = new EnrolledStudents();
        Student juan = new Student(42223928, "Juan");
        Student luis = new Student(41223428, "Luis");
        Student jorge = new Student(23442928, "Jorge");
        Student jorgeRepeat = new Student(13442928, "Jorge");
        Course mathematic = new Course(40941, "Mathematic");
        
        // Caso 1 Añadir 1 estudiante al conjunto y añadirle asignaturas 
        juan.enrollCourse(mathematic);
        enrolledStudentsMath.addStudent(juan);
        assertEquals(enrolledStudentsMath.getStudentsByCourse(40941).size(),1);
        
        // Caso 2 Añadir varios estudiantes sin repetir y con varias asignaturas
        luis.enrollCourse(mathematic);
        jorge.enrollCourse(mathematic);
        enrolledStudentsMath.addStudent(luis);
        enrolledStudentsMath.addStudent(jorge);
        StringBuilder studentsNoNameRepeat = new StringBuilder(); 
        studentsNoNameRepeat.append("[23442928-Jorge[(40941)Mathematic], ");
        studentsNoNameRepeat.append("42223928-Juan[(40941)Mathematic], ");
        studentsNoNameRepeat.append("41223428-Luis[(40941)Mathematic]]");
        assertTrue(enrolledStudentsMath.getStudentsByCourse(40941).
            toString().equals(studentsNoNameRepeat.toString()));
        
        // Caso 3 Comprobar 2 personas con mismo nombre
        jorgeRepeat.enrollCourse(mathematic);
        enrolledStudentsMath.addStudent(jorgeRepeat);
        StringBuilder studentsNameRepeat = new StringBuilder(); 
        studentsNameRepeat.append("[13442928-Jorge[(40941)Mathematic], ");
        studentsNameRepeat.append("23442928-Jorge[(40941)Mathematic], ");
        studentsNameRepeat.append("42223928-Juan[(40941)Mathematic], ");
        studentsNameRepeat.append("41223428-Luis[(40941)Mathematic]]");
        assertTrue(enrolledStudentsMath.getStudentsByCourse(40941).toString()
            .equals(studentsNameRepeat.toString()));
    }
    
    /**
     * Metodo para probar si devuelve una lista de estudiantes  del centro 
     * educativo ordenados por su nombre u ordenados por su identificador
     */
    @Test
    public void EnrolledStudentsGetStudentsOrderByNameTest(){
        EnrolledStudents enrolledStudentsMath = new EnrolledStudents();
        Student juan = new Student(42223928, "Juan");
        Student luis = new Student(41223428, "Luis");
        Student jorge = new Student(23442928, "Jorge");
        Student jorgeRepeat = new Student(13442928, "Jorge");
        
        // Caso 1 Añadir 1 estudiante al conjunto y añadirle asignaturas
        enrolledStudentsMath.addStudent(juan);
        assertTrue(enrolledStudentsMath.getStudentsOrderByName().
            toString().equals("[42223928-Juan[]]"));
        
        // Caso 2 Añadir varios estudiantes sin repetir y 
        // con varias asignaturas 
        enrolledStudentsMath.addStudent(luis);
        enrolledStudentsMath.addStudent(jorge);
        assertTrue(enrolledStudentsMath.getStudentsOrderByName().
            toString().equals("[23442928-Jorge[], 42223928-Juan[], 41223428-Luis[]]"));
        
        // Caso 3 Comprobar con el  mismo nombre y que aplica
        // el identicador para ordenarlo
        enrolledStudentsMath.addStudent(jorgeRepeat);
        StringBuilder enrolledStudents = new StringBuilder(); 
        enrolledStudents.append("[13442928-Jorge[], 23442928-Jorge[], ");
        enrolledStudents.append("42223928-Juan[], 41223428-Luis[]]");
        assertTrue(enrolledStudentsMath.getStudentsOrderByName().
            toString().equals(enrolledStudents.toString()));
    }
    
    /**
     * Metodo para probar si devuelve una lista de estudiantes  del centro 
     * educativo ordenados por su identificador
     */
    @Test
    public void EnrolledStudentsGetStudentsOrderByIdTest(){
        EnrolledStudents enrolledStudentsMath = new EnrolledStudents();
        Student juan = new Student(42223928, "Juan");
        Student luis = new Student(41223428, "Luis");
        Student jorge = new Student(23442928, "Jorge");
      
        // Caso 1 Añadir 1 estudiante al conjunto y añadirle asignaturas
        enrolledStudentsMath.addStudent(juan);
        assertTrue(enrolledStudentsMath.getStudentsOrderById().
            toString().equals("[42223928-Juan[]]"));
        
        // Caso 2 Añadir varios estudiantes sin repetir y con varias asignaturas 
        enrolledStudentsMath.addStudent(luis);
        enrolledStudentsMath.addStudent(jorge);
        StringBuilder students = new StringBuilder(); 
        students.append("[23442928-Jorge[], 41223428-Luis[], 42223928-Juan[]]");
        assertTrue(enrolledStudentsMath.getStudentsOrderById().
            toString().equals(students.toString()));
    }
    
    //////////////////////////////////////////////////////////////////////
    //Test de la clase OfferedCourses(conjunto asignaturas del centro)//
    //////////////////////////////////////////////////////////////////
    
    /**
     * Metodo para probar si el constructor funciona
     */
    @Test
    public void OfferedCoursesConstructorTest(){
        
        // Caso 1 crear varios conjuntos de asignaturas
        OfferedCourses enrolledProgrammingCourse = new OfferedCourses();
        OfferedCourses enrolledStadisticCourse = new OfferedCourses();
        OfferedCourses enrolledDataBaseCourse= new OfferedCourses();
        assertTrue(enrolledProgrammingCourse.equals(enrolledProgrammingCourse));
        assertFalse(enrolledStadisticCourse.equals(enrolledDataBaseCourse));
    }
    
    /**
     * Metodo para probar si añade una asignatura a un contenedor de asignaturas
     */
    @Test
    public void OfferedCoursesAddCourseTest(){
        OfferedCourses cursos = new OfferedCourses();
        Course math = new Course(42223928, "Math");
        Course language = new Course(42223428, "Language");
        Course history = new Course(23442928, "History");

        // Caso 1 Añadir 1 asignatura al conjunto
        assertTrue(cursos.addCourse(math));
   
        // Caso 2 Añadir varios asignaturas al conjunto
        // sin repetir
        assertTrue(cursos.addCourse(language));
        assertTrue(cursos.addCourse(history));
        
        // Caso 3 Añadir varios asignaturas al conjunto
        //y alguno repetido comprobar que da falso
        assertFalse(cursos.addCourse(math));
    }
    
    /**
     * Metodo para probar si quita una asignatura a un 
     * contenedor de asignaturas
     */
    @Test
    public void OfferedCoursesRemoveCourseTest(){
        OfferedCourses courses= new OfferedCourses();
        Course math = new Course(42223928, "Math");
        Course language = new Course(42223428, "Language");
        Course history = new Course(23442928, "History");
        
        // Caso 1 Añadir 1 asignatura al conjunto
        // y eliminarlo
        courses.addCourse(math);
        courses.removeCourse(42223928);
        assertTrue(courses.getCourses().size() == 0);
        
        // Caso 2 Añadir varios asignaturas al conjunto sin repetir y eliminar:
        courses.addCourse(math);
        courses.addCourse(language);
        courses.addCourse(history);
        courses.removeCourse(23442928);
        assertTrue(courses.getCourses().size() == 2);
        
        // Caso 2.1 : Eliminar una asignatura del principio
        courses.removeCourse(42223928);
        assertTrue(courses.getCourses().size() == 1);
        
        // Caso 2.2 :Eliminar una asignatura del medio
        courses.removeCourse(42223428);
        courses.addCourse(math);
        courses.addCourse(language);
        courses.addCourse(history);
        courses.removeCourse(42223428);
        assertTrue(courses.getCourses().size() == 2);
        
        // Caso 2.3 :Eliminar una asignatura del final
        courses.removeCourse(23442928);
        assertTrue(courses.getCourses().size() == 1);
        
        // Caso 3 Añadir varios asignaturas al conjunto
        // y eliminar uno que no existe y que da falso limpiamos la lista
        courses.removeCourse(42223928);
        courses.addCourse(math);
        courses.addCourse(language);
        courses.addCourse(history);
        courses.removeCourse(23442958);
        assertTrue(courses.getCourses().size() == 3);
    }
    
    /**
     * Metodo para probar si devuelve
     * una asignatura a partir de su identificador
     */
    @Test
    public void OfferedCoursesGetCourseTest(){
        OfferedCourses cursosGet= new OfferedCourses();
        Course math = new Course(42223928, "Math");
        Course language = new Course(42223428, "Language");
        Course history = new Course(23442928, "History");
        Course geography = new Course(40943, "Geography");
        
         // Caso 1 Añadir 1 asignatura al conjunto
        // Comprobar que devuelve la asignatura
        // a partir de su identificador 
        cursosGet.addCourse(math);
        assertTrue(cursosGet.getCourse(42223928).
            toString().equals("(42223928)Math"));
  
        // Caso 2 Añadir varios asignaturas al conjunto
        // sin repetir y comprobar que devuelve una asignatura
        // del conjunto
        cursosGet.addCourse(language);
        cursosGet.addCourse(history);
        assertTrue(cursosGet.getCourse(23442928).
            toString().equals("(23442928)History"));

        // Caso 3 Añadir varios asignaturas al conjunto
        // y comprobar que al pedir un identificador 
        // de asignatura que no esta da null
        assertNull(cursosGet.getCourse(40943));
    }
    
    /**
     * Metodo para probar si devuelve una lista de asignaturas que oferta
     * el centro educativo ordenadas por el toString() de Course
     */
    @Test
    public void OfferedCoursesGetCoursesTest(){
        OfferedCourses enrolledProgrammingCourse = new OfferedCourses();
        Course ProgrammingI = new Course(40943, "Programming I");
        Course ProgrammingII = new Course(409421, "Programming II");
        Course tecnhologyProgramming = new Course(409412, "Tecnhology Programming");
        
        // caso 1 añadir 1 asignatura al conjunto y ver que devuelve 
        enrolledProgrammingCourse.addCourse(ProgrammingI);
        assertTrue(enrolledProgrammingCourse.getCourses().
            toString().equals("[(40943)Programming I]"));
        
        // caso 2 añadir varias asignaturas al conjunto
        enrolledProgrammingCourse.addCourse(ProgrammingII);
        enrolledProgrammingCourse.addCourse(tecnhologyProgramming);
        StringBuilder courses = new StringBuilder(); 
        courses.append("[(409412)Tecnhology Programming, ");
        courses.append("(409421)Programming II, ");
        courses.append("(40943)Programming I]");
        assertTrue(enrolledProgrammingCourse.getCourses().
            toString().equals(courses.toString()));
    }
    
    /**
     * Metodo donde se prueban los test ofrecidos para comprobar el 
     * funcionamiento de distintos metodos
     */
    @Test
    public void PruebaTestBásicos(){
        OfferedCourses offeredCourses = new OfferedCourses();
        EnrolledStudents enrolledStudents = new EnrolledStudents();
        Student s1 = new Student(4, "Fulano");
        Student s2 = new Student(2, "Mengano");
        
        // Comprobacion de añadir asignaturas
        assertTrue(offeredCourses.addCourse(new Course(100, "Mathematic")));
        assertTrue(offeredCourses.addCourse(new Course(101, "Language")));
        assertTrue(offeredCourses.addCourse(new Course(102, "History")));
        assertTrue(offeredCourses.addCourse(new Course(103, "Geography")));
        assertTrue(offeredCourses.addCourse(new Course(104, "Physics")));
        assertTrue(offeredCourses.addCourse(new Course(108, "Biology")));
        assertTrue(offeredCourses.addCourse(new Course(110, "Chemistry")));
        assertTrue(offeredCourses.addCourse(new Course(111, "Earth Science")));
        
        // Comprobacion de añadir estudiantes al conjunto 
        assertEquals(enrolledStudents.addStudent(s1),true);
        assertEquals(enrolledStudents.addStudent(s2),true);
        assertEquals(enrolledStudents.addStudent(new Student(3, "Zutano")),true);
        
        // Comprobacion de obtener asignaturas
        assertTrue(s1.enrollCourse(offeredCourses.getCourse(101)));
        assertTrue(s2.enrollCourse(offeredCourses.getCourse(101)));
        assertTrue(s2.enrollCourse(offeredCourses.getCourse(103)));
        assertTrue(s2.enrollCourse(offeredCourses.getCourse(100)));
    }
}
