import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Font.PLAIN;

public class Ejemplo3 extends JFrame {

    //Etiqueta para el display
    JLabel display;
    //Botones
    JButton boton1, boton2, boton3, botonLimpiar;

    public Ejemplo3(){

        initDisplay();
        initBotones();
        initAcciones();
        initHovers();
        initPantalla(); //El JFrame lo último para que me pinte correctamente los botones
    }

    private void initPantalla(){

        setTitle("Ejemplo 3: Eventos");
        setSize(240,390); //Si no pongo posición x e y, entiende que es 0,0
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK); //Color de fondo del JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void initDisplay(){

        //Propiedades y estilos el display
        display = new JLabel("");
        display.setBounds(15,15,195,60); //Tamaño y posición
        display.setOpaque(true); //Hago el componente opaco para poder darle un color de fondo
        display.setBackground(Color.BLACK); //Color de fondo
        display.setForeground(Color.GREEN); //Color de fuente
        display.setBorder(new LineBorder(Color.GRAY)); //Color del borde
        display.setFont(new Font("MONOSPACED",PLAIN,24)); //Tipo de fuente
        display.setHorizontalAlignment(SwingConstants.RIGHT); //Alineación a la derecha
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
                //Si pulso las teclas 1, 2 o 3
                if ("1".equals(ch) || "2".equals(ch) || "3".equals(ch)){
                    //Encadeno el valor pulsado
                    display.setText( display.getText() + ch);
                }
                //Si pulso la tecla c
                else if ("c".equals(ch)){
                    display.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void initBotones(){

        //Inicializo los botones
        boton1 = new JButton("Pulsa o teclea 1");
        boton2 = new JButton("Pulsa o teclea 2");
        boton3 = new JButton("Pulsa o teclea 3");
        botonLimpiar = new JButton("Limpiar display");

        //Posición y tamaño de los botones
        boton1.setBounds(15,90,195,50);
        boton2.setBounds(15,155,195,50);
        boton3.setBounds(15,220,195,50);
        botonLimpiar.setBounds(15,285,195,50);

        //Tipo de fuente
        boton1.setFont(new Font("MONOSPACED",PLAIN,16));
        boton2.setFont(new Font("MONOSPACED",PLAIN,16));
        boton3.setFont(new Font("MONOSPACED",PLAIN,16));
        botonLimpiar.setFont(new Font("MONOSPACED",PLAIN,16));

        //Botones opacos
        boton1.setOpaque(true);
        boton2.setOpaque(true);
        boton3.setOpaque(true);
        botonLimpiar.setOpaque(true);

        //Botón 1: quito el focus painted, pongo color de fondo, borde y color de fuente
        boton1.setFocusPainted(false); //quita el recuadro de color que aparece cuando el botón tiene el foco)
        boton1.setBackground(Color.DARK_GRAY);
        boton1.setBorder(new LineBorder(Color.DARK_GRAY));
        boton1.setForeground(Color.WHITE);

        //Botón 2: quito el focus painted, pongo color de fondo, borde y color de fuente
        boton2.setFocusPainted(false);
        boton2.setBackground(Color.DARK_GRAY);
        boton2.setBorder(new LineBorder(Color.DARK_GRAY));
        boton2.setForeground(Color.WHITE);

        //Botón 3: quito el focus painted, pongo color de fondo, borde y color de fuente
        boton3.setFocusPainted(false);
        boton3.setBackground(Color.DARK_GRAY);
        boton3.setBorder(new LineBorder(Color.DARK_GRAY));
        boton3.setForeground(Color.WHITE);

        //Botón Limpiar: quito el focus painted, pongo color de fondo, borde y color de fuente
        botonLimpiar.setFocusPainted(false);
        botonLimpiar.setBackground(Color.DARK_GRAY);
        botonLimpiar.setBorder(new LineBorder(Color.DARK_GRAY));
        botonLimpiar.setForeground(Color.WHITE);

        //Añado los botones al JFrame
        add(boton1);
        add(boton2);
        add(boton3);
        add(botonLimpiar);
    }

    private void initAcciones(){

        //Acciones del botón 1
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText( display.getText() + "1" );
                //Para devolver el foco al display y que vuelva a funcionar el KeyListener
                display.requestFocus();
            }
        });

        //Acciones del botón 2
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText( display.getText() + "2" );
                //Para devolver el foco al display y que vuelva a funcionar el KeyListener
                display.requestFocus();
            }
        });

        //Acciones del botón 3
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText( display.getText() + "3" );
                //Para devolver el foco al display y que vuelva a funcionar el KeyListener
                display.requestFocus();
            }
        });

        //Acciones del botón limpiar
        botonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                //Para devolver el foco al display y que vuelva a funcionar el KeyListener
                display.requestFocus();
            }
        });

    }

    private void initHovers(){

        boton1.addMouseListener(new MouseListener() {
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
                boton1.setBackground(Color.GREEN);
                boton1.setBorder(new LineBorder(Color.GREEN));
                boton1.setForeground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //Pongo el color de fondo, el borde y la fuente original al salir del botón
                boton1.setBackground(Color.DARK_GRAY);
                boton1.setBorder(new LineBorder(Color.DARK_GRAY));
                boton1.setForeground(Color.WHITE);
            }
        });

        boton2.addMouseListener(new MouseListener() {
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
                boton2.setBackground(Color.GREEN);
                boton2.setBorder(new LineBorder(Color.GREEN));
                boton2.setForeground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //Pongo el color de fondo, el borde y la fuente original al salir del botón
                boton2.setBackground(Color.DARK_GRAY);
                boton2.setBorder(new LineBorder(Color.DARK_GRAY));
                boton2.setForeground(Color.WHITE);
            }
        });

        boton3.addMouseListener(new MouseListener() {
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
                boton3.setBackground(Color.GREEN);
                boton3.setBorder(new LineBorder(Color.GREEN));
                boton3.setForeground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //Pongo el color de fondo, el borde y la fuente original al salir del botón
                boton3.setBackground(Color.DARK_GRAY);
                boton3.setBorder(new LineBorder(Color.DARK_GRAY));
                boton3.setForeground(Color.WHITE);
            }
        });

        botonLimpiar.addMouseListener(new MouseListener() {
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
                botonLimpiar.setBackground(Color.GREEN);
                botonLimpiar.setBorder(new LineBorder(Color.GREEN));
                botonLimpiar.setForeground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //Pongo el color de fondo, el borde y la fuente original al salir del botón
                botonLimpiar.setBackground(Color.DARK_GRAY);
                botonLimpiar.setBorder(new LineBorder(Color.DARK_GRAY));
                botonLimpiar.setForeground(Color.WHITE);
            }
        });

    }

    public static void main(String[] args) {
        new Ejemplo3();
    }
}
