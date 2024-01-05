package tp.practicas;
import javax.swing.*;
import java.awt.*;
public class AddStudentDialog extends JDialog{

    private final JTextField nombre, id ;
    private final JButton aceptar, cancelar;
    boolean botonAceptado = false;
    
    /**
     * Metodo para saber si se ha pulsado aceptar o cancelar de la interfaz grafica
     * @return Verdadero si pulso aceptar y Falso si pulso cancelar 
     */
    public boolean isAccepted() {
        return botonAceptado;
    }
    
    /**
     * Metodo para obtener el id del estudiante la interfaz grafica
     * @return Id del estudiante
     */
    public String getTextId() {
        return id.getText();
    }
    
    /**
     * Metodo para obtener el nombre del estudiante la interfaz grafica
     * @return Nombre del estudiante
     */
    public String getTextName() {
        return nombre.getText();
    }
    
    /**
     * Constructor para crear el dialogo de la interfaz con el estudiante 
     */
    public AddStudentDialog(JFrame f){
        setTitle("Add new Student");
        setModal(true);
        setMinimumSize(new Dimension(250, 150));
        setLocationRelativeTo(f);
        nombre = new JTextField(10);
        id = new JTextField(6); 
        aceptar = new JButton("Aceptar");
        cancelar = new JButton("Cancelar");
        
        Container panel= getContentPane();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
       
        // Colocamos los elementos en el Jdialog
        c.insets = new Insets(2,2,2,2);
        c.gridx = 0; c.gridy = 0;
        c.ipadx = 5; c.ipady = 5;
        
        panel.add(new JLabel("Student Id:"), c);
        c.gridx = 1;
        panel.add(id, c);
        
        c.gridx = 0; c.gridy = 1;
        panel.add(new JLabel("Student Name:"), c);
        c.gridx = 1; c.gridwidth=2;
        panel.add(nombre, c);

        c.gridx = 0; c.gridy = 2;
        c.ipadx = 1;c.gridwidth=1;
        panel.add(aceptar, c);
        c.gridx = 1;
        panel.add(cancelar, c);
        
        // Cancelar y aceptar añadir estudiante
        cancelar.addActionListener( e -> setVisible(false));
        aceptar.addActionListener( e -> {botonAceptado = true;setVisible(false);});
        
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(f);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }
