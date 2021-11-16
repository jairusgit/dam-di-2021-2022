import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo6 extends JFrame implements ActionListener {

    JLabel label1;
    JTextField textfield1;
    JButton boton1;

    public Ejemplo6(){

        /* Configuración del JFrame */
        setLayout(null);
        setBounds(0,0,300,150);
        setTitle("Ejemplo 6: JTextField");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /* Etiqueta de usuario */
        label1 = new JLabel("Usuario:");
        label1.setBounds(10,10,100,30);
        add(label1);

        /* Campo de texto */
        textfield1 = new JTextField();
        textfield1.setBounds(120,10,150,20);
        add(textfield1);

        /* Botón de Aceptar */
        boton1 = new JButton("Aceptar");
        boton1.setBounds(10,80,100,30);
        add(boton1);

        /* Inicializo escuchador del botón */
        boton1.addActionListener(this);

        /* Muestro el JFrame */
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            setTitle(textfield1.getText());
        }
    }

    public static void main(String[] args) {
        new Ejemplo6();
    }
}
