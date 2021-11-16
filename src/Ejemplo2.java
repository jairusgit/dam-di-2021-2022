import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo2 extends JFrame implements ActionListener {

    JButton boton1, boton2, boton3;

    public Ejemplo2(){

        //Layout absoluto (No hay layout, tengo que especificar todos los valores en px)
        setLayout(null);

        //Tamaño de la ventana (posición en x, posición en y, ancho y el alto)
        setBounds(0,0,350,200);

        //Título de la ventana
        setTitle("Ejemplo 2");

        //Hago la ventana no redimensionable
        setResizable(false);

        //Cerrar el proceso cuando se cierre la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Botón 1
        boton1 = new JButton("1");
        boton1.setBounds(10,100,90,30);
        add(boton1);
        boton1.addActionListener(this);

        //Botón 2
        boton2 = new JButton("2");
        boton2.setBounds(110,100,90,30);
        add(boton2);
        boton2.addActionListener(this);

        //Botón 3
        boton3 = new JButton("3");
        boton3.setBounds(210,100,90,30);
        add(boton3);
        boton3.addActionListener(this);

        //Muestro el JFrame
        setVisible(true);

    }

    public static void main(String[] args) {
        new Ejemplo2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            setTitle("Has pulsado el botón 1");
        }
        else if (e.getSource() == boton2){
            setTitle("Has pulsado el botón 2");
        }
        else if (e.getSource() == boton3){
            setTitle("Has pulsado el botón 3");
        }

    }
}
