import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Font.PLAIN;

public class Practica1 extends JFrame {

    //Etiqueta para el display
    JLabel display;
    //Botones
    JButton[] botones;
    //Textos y posiciones de X e y
    int x = 15;
    int[] y = new int[]{90, 155, 220, 285, 350};

    public Practica1(){

        initDisplay();
        initBotones();
        initAcciones();
        initHovers();
        initPantalla(); //El JFrame lo último para que me pinte correctamente los botones
    }

    private void initPantalla(){

        setTitle("Práctica1 : Pares o nones");
        setBounds(10,10,440,450);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK); //Color de fondo del JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void initDisplay(){

        //Propiedades y estilos el display
        display = new JLabel("¿Pares o nones? Tú eres pares...");
        display.setBounds(15,15,395,60); //Tamaño y posición
        display.setOpaque(true); //Hago el componente opaco para poder darle un color de fondo
        display.setBackground(Color.BLACK); //Color de fondo
        display.setForeground(Color.GREEN); //Color de fuente
        display.setBorder(new LineBorder(Color.GRAY)); //Color del borde
        display.setFont(new Font("MONOSPACED",PLAIN,16)); //Tipo de fuente
        display.setHorizontalAlignment(SwingConstants.CENTER); //Alineación al centro
        display.setFocusable(true); //Permite hacer foco en el label
        add(display); //Añado el display al JFrame

        display.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //Obtengo el char pulsado y convierto a string
                String ch = String.valueOf(e.getKeyChar());
                //Si pulso las teclas 1 a 5
                if ("1".equals(ch) || "2".equals(ch) || "3".equals(ch) || "4".equals(ch) || "5".equals(ch)){
                    //Calculo resultado
                    resultado(Integer.parseInt(ch));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void initBotones(){

        //Inicializo los botones
        botones = new JButton[5];

        for (int i=0; i< 5; i++){
            botones[i] = new JButton("Pulsa o teclea " + (i+1));
            botones[i].setBounds(x,y[i],395,50);
            botones[i].setFont(new Font("MONOSPACED",PLAIN,16));
            botones[i].setOpaque(true);
            botones[i].setFocusPainted(false);
            botones[i].setBackground(Color.DARK_GRAY);
            botones[i].setBorder(new LineBorder(Color.DARK_GRAY));
            botones[i].setForeground(Color.WHITE);
            add(botones[i]);
        }

    }

    private void initAcciones(){

        for (int i=0; i< 5; i++){

            int numBoton = i;

            //Acciones del botón
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Para devolver el foco al display y que vuelva a funcionar el KeyListener
                    display.requestFocus();
                    //Calculo resultado
                    resultado(numBoton+1);

                }
            });
        }


    }

    private void initHovers(){

        for (int i=0; i< 5; i++){

            int numBoton = i;

            botones[i].addMouseListener(new MouseListener() {
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
                    botones[numBoton].setBackground(Color.GREEN);
                    botones[numBoton].setBorder(new LineBorder(Color.GREEN));
                    botones[numBoton].setForeground(Color.DARK_GRAY);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    //Pongo el color de fondo, el borde y la fuente original al salir del botón
                    botones[numBoton].setBackground(Color.DARK_GRAY);
                    botones[numBoton].setBorder(new LineBorder(Color.DARK_GRAY));
                    botones[numBoton].setForeground(Color.WHITE);
                }
            });

        }

    }

    void resultado(int opcion){

        new Practica1Resultado(this,true, opcion);

    }

    public static void main(String[] args) {
        new Practica1();
    }
}
