import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.*;

public class Ejercicio11 extends JFrame implements ActionListener {

    BorderLayout miBorderLayout;
    FlowLayout miFlowLayout;
    JPanel panelEste, panelOeste, panelCentro, panelRojo, panelVerde, panelAzul;
    JButton[] boton;
    JLabel titulo, pie;
    CardLayout miCardLayout;


    public Ejercicio11(){

        //JFrame
        miBorderLayout = new BorderLayout();
        setLayout(miBorderLayout);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0,0,800,600);

        //Título
        titulo = new JLabel("Este es el título");
        titulo.setPreferredSize(new Dimension(800,100));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setBackground(Color.ORANGE);
        add(titulo, NORTH);

        //Pie
        pie = new JLabel("Este es el pie");
        pie.setPreferredSize(new Dimension(800,100));
        pie.setHorizontalAlignment(SwingConstants.CENTER);
        pie.setOpaque(true);
        pie.setBackground(Color.YELLOW);
        add(pie, SOUTH);

        //FlowLayout para Este y Oeste
        miFlowLayout = new FlowLayout(FlowLayout.CENTER,5,5);

        panelOeste = new JPanel();
        panelOeste.setLayout(miFlowLayout);
        panelOeste.setPreferredSize(new Dimension(100,400));
        panelEste = new JPanel();
        panelEste.setPreferredSize(new Dimension(100,400));
        panelEste.setLayout(miFlowLayout);

        add(panelEste, EAST);
        add(panelOeste, WEST);

        boton = new JButton[10];

        for (int i = 0; i <= 9; i++){
            boton[i] = new JButton("Botón " + (i+1));
            boton[i].setPreferredSize(new Dimension(90,66));
            if (i <= 4){
                panelOeste.add(boton[i]);
            }
            else{
                panelEste.add(boton[i]);
            }
            boton[i].addActionListener(this);
        }

        //Panel centro
        miCardLayout = new CardLayout();
        panelCentro = new JPanel(miCardLayout);
        add(panelCentro, CENTER);

        //Tarjetas de colores
        panelRojo = new JPanel();
        panelRojo.setBackground(Color.RED);
        panelCentro.add(panelRojo, "Rojo");
        panelVerde = new JPanel();
        panelVerde.setBackground(Color.GREEN);
        panelCentro.add(panelVerde, "Verde");
        panelAzul = new JPanel();
        panelAzul.setBackground(Color.BLUE);
        panelCentro.add(panelAzul, "Azul");

        setVisible(true);



    }
    public static void main(String[] args) {
        new Ejercicio11();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton[0] || e.getSource() == boton[5]){
            //Tarjeta anterior
            miCardLayout.previous(panelCentro);
        }
        else if (e.getSource() == boton[1] || e.getSource() == boton[6]){
            //Tarjeta Rojo
            miCardLayout.show(panelCentro,"Rojo");
        }
        else if (e.getSource() == boton[2] || e.getSource() == boton[7]){
            //Tarjeta Verde
            miCardLayout.show(panelCentro,"Verde");
        }
        else if (e.getSource() == boton[3] || e.getSource() == boton[8]){
            //Tarjeta Azul
            miCardLayout.show(panelCentro,"Azul");
        }
        else if (e.getSource() == boton[4] || e.getSource() == boton[9]){
            //Tarjeta siguiente
            miCardLayout.next(panelCentro);
        }

    }
}
