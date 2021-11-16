import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio123 extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JButton botonCarne, botonPescado;

    public Ejercicio123(){

        //Layout absoluto
        setLayout(null);

        //Tamaño de la ventana de 1024x800
        setBounds(10,10,1024,800);

        //Título
        setTitle("Ejercicios 1,2 y 3");

        //No redimensionable
        setResizable(false);

        //Cerrar proceso al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Labels
        label1 = new JLabel("Jairo");
        label2 = new JLabel("Marcos");
        label3 = new JLabel("Mario");

        label1.setBounds(10,10,200,30);
        label2.setBounds(10,50,200,30);
        label3.setBounds(10,90,200,30);

        add(label1);
        add(label2);
        add(label3);

        //Botones
        botonCarne = new JButton("Carne");
        botonPescado = new JButton("Pescado");

        botonCarne.setBounds(10,130,200,30);
        botonPescado.setBounds(10,170,200,30);

        botonCarne.addActionListener(this);
        botonPescado.addActionListener(this);

        add(botonCarne);
        add(botonPescado);

        //Muestro el Jframe
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCarne){
            abrirVentana("Carne");
        }
        else if (e.getSource() == botonPescado){
            abrirVentana("Pescado");
        }
    }

    private void abrirVentana(String opcion){
        Ejercicio123Secundaria secundaria = new Ejercicio123Secundaria(this,true,opcion);
        secundaria.setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio123();
    }
}
