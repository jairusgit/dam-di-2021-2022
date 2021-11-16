import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//JFrame me permite añadir una ventana a mi aplicación
//Implemento ActionListener para la funcionalidad del botón
public class Ejemplo1 extends JFrame implements ActionListener {

    //Declaro la variable
    JButton boton1;

    public Ejemplo1(){

        //Layout absoluto (No hay layout, tengo que especificar todos los valores en px)
        setLayout(null);

        //Tamaño de la ventana (posición en x, posición en y, ancho y el alto)
        setBounds(0,0,450,350);

        //Título de la ventana
        setTitle("Ejemplo 1");

        //Hago la ventana no redimensionable
        setResizable(false);

        //Cerrar el proceso cuando se cierre la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Inicializo el botón
        boton1 = new JButton("Finalizar");

        //Dimensiones y posición del botón
        boton1.setBounds(300,250,100,30);

        //Añado el botón al JFrame
        add(boton1);

        //Añado el botón al ActionListener
        boton1.addActionListener(this);

        //Muestro el JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejemplo1();
    }


    //Método que se ejecuta al pulsar el botón
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            //Salir de la aplicación
            System.exit(0);
        }
    }
}
