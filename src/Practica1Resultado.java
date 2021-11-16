import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ThreadLocalRandom;

import static java.awt.Font.PLAIN;

public class Practica1Resultado extends JDialog implements ActionListener, MouseListener {

    JButton boton;
    JTextArea textArea;

    //Le paso los parámetros de clase principal y modal
    public Practica1Resultado(Practica1 parent, boolean modal, int opcion){

        //Invoco a la clase principal
        super(parent,modal);

        //JPanel
        setTitle("Práctica1 : Resultado");
        setBounds(460,10,440,450);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK); //Color de fondo del JFrame

        //Textarea
        textArea = new JTextArea(textoSalida(opcion));
        textArea.setBounds(15,15,395,320); //Tamaño y posición
        textArea.setOpaque(true); //Hago el componente opaco para poder darle un color de fondo
        textArea.setBackground(Color.BLACK); //Color de fondo
        textArea.setForeground(Color.GREEN); //Color de fuente
        textArea.setBorder(new LineBorder(Color.GRAY)); //Color del borde
        textArea.setFont(new Font("MONOSPACED",PLAIN,16)); //Tipo de fuente
        textArea.setEditable(false);
        add(textArea); //Añado al JPanel

        //Botón
        boton = new JButton("Volver");
        boton.setBounds(15,350,395,50);
        boton.setFont(new Font("MONOSPACED",PLAIN,16));
        boton.setOpaque(true);
        boton.setFocusPainted(false);
        boton.setBackground(Color.DARK_GRAY);
        boton.setBorder(new LineBorder(Color.DARK_GRAY));
        boton.setForeground(Color.WHITE);
        add(boton);

        //Añado el botón al action listener
        boton.addActionListener(this);

        //Muestro JPanel
        setVisible(true);
    }

    String textoSalida(int opcion){

        int maquina = ThreadLocalRandom.current().nextInt(1, 6);
        int resultado = maquina + opcion;

        String texto = "Tú eres pares y has elegido " + opcion + "\n";
        texto += "La máquina es nones y ha elegido " + maquina + "\n";

        texto += (resultado % 2 == 0) ? "¡Tú ganas!" : "La máquina gana";

        return texto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton){
            setVisible(false);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //Cambio el color de fondo, el borde y la fuente al pasar por encima del botón
        boton.setBackground(Color.GREEN);
        boton.setBorder(new LineBorder(Color.GREEN));
        boton.setForeground(Color.DARK_GRAY);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //Pongo el color de fondo, el borde y la fuente original al salir del botón
        boton.setBackground(Color.DARK_GRAY);
        boton.setBorder(new LineBorder(Color.DARK_GRAY));
        boton.setForeground(Color.WHITE);
    }
}
