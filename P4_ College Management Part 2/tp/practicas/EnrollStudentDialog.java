package tp.practicas;
import javax.swing.*;
import java.awt.*;
public class EnrollStudentDialog extends JDialog {
    private final JTextField nombre;
    private final JTextField clave;
    private JComboBox<Course> asignaturas;
    private JComboBox<String> estudiantes;
    private final JButton aceptar, cancelar;
    private boolean aceptarEnrollStudent = false;

   /**
     * Metodo para saber si se ha pulsado aceptar o cancelar de la interfaz grafica
     * @return Verdadero si pulso aceptar y Falso si pulso cancelar 
     */
    public boolean isAccepted() {
        return aceptarEnrollStudent;
    }
    
    /**
     * Metodo para obtener el nombre del estudiante la interfaz grafica
     * @return Nombre del estudiante
     */
    public String getStudent() {
        return  (String)estudiantes.getSelectedItem();
    }
    
    /**
     * Metodo para obtener el curso interesado por el estudiante de la interfaz grafica
     * @return Curso interesado por el estudiante
     */
    public Course getCourse() {
        Course cours = (Course)asignaturas.getSelectedItem();
        return  cours;
    }
    
    /**
     * Constructor para crear el dialogo de la interfaz con el estudiante 
     */
    public EnrollStudentDialog(JFrame f){
        setTitle("Enroll student");
        setModal(true);
        setMinimumSize(new Dimension(300, 100));
        setLocationRelativeTo(f);
        
        nombre = new JTextField(10); clave = new JTextField(12);
        asignaturas = new JComboBox<>(); estudiantes = new JComboBox<>();
        aceptar = new JButton("Aceptar"); cancelar = new JButton("Cancelar");
        	
        // Añadimos al comboBox las asignaturas y estudiantes
        CollegeGUI.offeredCourses.getCourses().forEach( nuevasAsignaturas -> asignaturas.addItem(nuevasAsignaturas));
        CollegeGUI.enrolledStudents.getStudentsOrderById().forEach( estudiante -> estudiantes.addItem(estudiante.getId() + "-" + estudiante.getName()));	
        
        Container panel= getContentPane();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        estudiantes.setPrototypeDisplayValue("XXXXXXXXX");
        
        c.insets = new Insets(2,2,2,2);
        c.gridx = 0; c.gridy = 0;
        c.ipadx = 5; c.ipady = 5;
        panel.add(new JLabel("Student:"), c);
        c.gridx = 1;
        panel.add(estudiantes);
    
        c.gridx = 2;
        panel.add(new JLabel("Course:"), c);
        c.gridx = 3;
        panel.add(asignaturas, c);
        
        c.gridx = 0; c.gridy = 1;
        c.gridwidth = 3;
        panel.add(aceptar, c);
        c.gridx = 1; c.gridwidth = 4;
        panel.add(cancelar, c);
        
        // Aceptar o Cancelar añadir asignatura
        aceptar.addActionListener( e -> {aceptarEnrollStudent = true; setVisible(false);});
        cancelar.addActionListener( e -> setVisible(false));
        
        setResizable(false);
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        }
    }
