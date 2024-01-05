package tp.practicas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Clase que representa la Interfaz grafica de la aplicacion del centro educativo
 */
public class CollegeGUI extends JFrame {
    static OfferedCourses offeredCourses= new OfferedCourses();
    static EnrolledStudents enrolledStudents = new EnrolledStudents();;
    private JTextArea data;
    private JRadioButton orderName, orderId;
    private JButton addStudent, enrollStudent;
    private AddStudentDialog d;
    private EnrollStudentDialog s;
    private String texto = "";
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem itemAddStudent, itemEnrollStudent, itemExit;
    
    /**
     * Metodo para representar el menu de la interfaz grafica
     */
    private void constructMenu() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menu = new JMenu("Menu");
        itemAddStudent = new JMenuItem("Add new student");
        itemEnrollStudent = new JMenuItem("Enroll student in course");
        itemExit = new JMenuItem("Exit");
        menu.add(itemAddStudent);
        menu.add(itemEnrollStudent);
        menu.add(itemExit);
        menuBar.add(menu);
    }
    
    /**
     * Metodo para representar el controlador de botones de la interfaz grafica
     */
    private Component constructControls() {
        orderName = new JRadioButton("Order by student's name", true);
        orderId = new JRadioButton("Order by student's id", false);
        ButtonGroup bg = new ButtonGroup();
        bg.add(orderName);
        bg.add(orderId);
        addStudent = new JButton("Add new student");
        enrollStudent = new JButton("Enroll student in course");
        JPanel east = new JPanel();
        east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
        JPanel order = new JPanel();
        order.setLayout(new BoxLayout(order, BoxLayout.PAGE_AXIS));
        order.add(orderName);
        order.add(orderId);
        order.setBorder(BorderFactory.createTitledBorder("List order"));
        east.add(order);
        east.add(addStudent);
        east.add(enrollStudent);
        return east;
    }
    
    /**
     * Metodo para representar la informacion del estudiante de la interfaz grafica
     */
    private Component constructInfo() {
        data = new JTextArea();
        data.setEditable(false);
        return new JScrollPane(data);
    }
    
    /**
     * Metodo para añadir a los estudiantes
     */
    private void addStd() {
        if(d.isAccepted()){
            try{
               int id = Integer.parseInt(d.getTextId());
               Student estudiante = new Student(id, d.getTextName());
               enrolledStudents.addStudent(estudiante);
               texto += estudiante + "\n";
               data.setText(texto);
            }catch(NumberFormatException error){}
        }
    }
    
    /**
     * Metodo para añadir a un curso a los estudiantes
     */
    private void enrollStd() {
       if(s.isAccepted()){
                String test = s.getStudent().substring(2,s.getStudent().length());
                for(Student estudiantes:enrolledStudents.getStudentsOrderByName()){
                    if(test.equals(estudiantes.getName())){
                        // Actualizamos la lista de asignaturas matriculadas del estudiante
                        estudiantes.enrollCourse(s.getCourse());
                    }
                }
                orderStudent();
        }
    }
    
    /**
     * Metodo para ordenar los estudiantes o por id o por su nombre
     */
    private void orderStudent() {
        texto = "";
        // Ordenar por nombre
        if(orderName.isSelected()){
            enrolledStudents.getStudentsOrderByName();
            enrolledStudents.getStudentsOrderByName().forEach(estudiante -> texto += estudiante + "\n");
        }else{
            enrolledStudents.getStudentsOrderById();
            enrolledStudents.getStudentsOrderById().forEach(estudiante -> texto += estudiante + "\n");
        }
        data.setText(texto);
    }
    
    
    /**
     * Constructor que contiene todos los componentes de la Interfaz grafica
     */
    public CollegeGUI(){
        super("College Management"); 
        InitialData.init(offeredCourses, enrolledStudents);
        constructMenu();
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        pane.add(constructInfo(), BorderLayout.CENTER);
        pane.add(constructControls(), BorderLayout.EAST);
        setContentPane(pane);
        setLocation(50,50);
        setSize(700,200);
        
        // Datos predefinidos de la aplicacion
        enrolledStudents.getStudentsOrderByName().forEach(estudiante -> {texto += estudiante + "\n";});
        data.setText(texto);
        
        // Añadir estudiante
        addStudent.addActionListener( e -> { d = new AddStudentDialog(CollegeGUI.this); addStd();});
        itemAddStudent.addActionListener( e -> { d = new AddStudentDialog(CollegeGUI.this); addStd();});
        
        // Ordenar estudiantes
        orderName.addActionListener( e -> orderStudent());
        orderId.addActionListener( e -> orderStudent());
        
        // Añadir a un estudiante una asignatura
        enrollStudent.addActionListener( e -> { s = new EnrollStudentDialog(CollegeGUI.this); enrollStd();});
        itemEnrollStudent.addActionListener((ActionEvent e) -> {s = new EnrollStudentDialog(CollegeGUI.this);enrollStd();});

        // Cerrar aplicacion
        itemExit.addActionListener( e -> System.exit(0));
     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main (String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {
        }
        CollegeGUI collegeGUI = new CollegeGUI();
    }
}
