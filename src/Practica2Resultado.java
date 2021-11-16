import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ThreadLocalRandom;

import static java.awt.Font.PLAIN;

public class Practica2Resultado extends JDialog implements ActionListener, MouseListener {

    JButton boton;
    JTextArea textArea;
    Practica2 principal;

    //Le paso los parámetros de clase principal y modal
    public Practica2Resultado(Practica2 parent, boolean modal, int valor){

        //Invoco a la clase principal
        super(parent,modal);
        principal = parent;

        //JPanel
        setTitle("Práctica2 : Resultado");
        setBounds(460,10,440,450);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK); //Color de fondo del JFrame

        //Textarea
        resultado(valor);

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

    void resultado(int valor){

        String texto = "El valor conseguido es  " + valor + "\n";
        Color color;

        if (valor == 50){
            texto += "¡ENHORABUENA, ACERTASTE";
            color = Color.RED;
        }
        else if (valor > 40 && valor < 60){
            texto += "¡Has estado cerca, prueba otra vez!";
            color = Color.ORANGE;
        }
        else{
            texto += "Vuelve a intentarlo";
            color = Color.GREEN;
        }

        textArea = new JTextArea(texto);
        textArea.setBounds(15,15,395,320); //Tamaño y posición
        textArea.setOpaque(true); //Hago el componente opaco para poder darle un color de fondo
        textArea.setBackground(Color.BLACK); //Color de fondo
        textArea.setForeground(color); //Color de fuente
        textArea.setBorder(new LineBorder(Color.GRAY)); //Color del borde
        textArea.setFont(new Font("MONOSPACED",PLAIN,16)); //Tipo de fuente
        textArea.setEditable(false);
        add(textArea); //Añado al JPanel

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton){
            principal.reset(); //reseteo la diana
            setVisible(false); //cierro el JPanel
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
