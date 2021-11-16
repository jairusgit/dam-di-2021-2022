import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Ejercicio4 extends JFrame implements ActionListener {

    JLabel labelUsuario, labelClave, labelResultado;
    JTextField textFieldUsuario, textFieldClave;
    JButton boton;
    String usuario = "jairo";
    String clave = "12345678";

    public Ejercicio4(){

        //Layout absoluto
        setLayout(null);

        //Tamaño de la ventana de 1024x800
        setBounds(10,10,400,400);

        //Título
        setTitle("Ejercicio 4");

        //No redimensionable
        setResizable(false);

        //Cerrar proceso al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Labels
        labelUsuario = new JLabel("Usuario:");
        labelClave = new JLabel("Clave:");
        labelResultado = new JLabel();

        labelUsuario.setBounds(10,10,100,30);
        labelClave.setBounds(10,50,100,30);
        labelResultado.setBounds(10,130,100,30);

        add(labelUsuario);
        add(labelClave);
        add(labelResultado);

        //Jtetxfield
        textFieldUsuario = new JTextField("");
        textFieldUsuario.setBounds(120,10,200,30);
        add(textFieldUsuario);
        textFieldClave = new JTextField("");
        textFieldClave.setBounds(120,50,200,30);
        add(textFieldClave);

        //Botón
        boton = new JButton("Comprobar");
        boton.setBounds(10,90,310,30);
        add(boton);

        boton.addActionListener(this);

        //Muestro el Jframe
        setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton){
            if (Objects.equals(textFieldUsuario.getText(), usuario) &&
                Objects.equals(textFieldClave.getText(), clave)){
                labelResultado.setText("Correcto");
                labelResultado.setForeground(Color.GREEN);
            }
            else{
                labelResultado.setText("Incorrecto");
                labelResultado.setForeground(Color.RED);
            }
        }

    }

    public static void main(String[] args) {
        new Ejercicio4();
    }
}
