import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Font.PLAIN;

public class Practica2 extends JFrame implements ChangeListener, MouseListener{

    //Etiqueta para el display
    JLabel display;
    JSlider nivel, diana;

    public Practica2(){

        initDisplay();
        initNivel();
        initDiana();
        initPantalla(); //El JFrame lo último para que me pinte correctamente los botones
    }

    private void initPantalla(){

        setTitle("Práctica2 : Diana horizontal");
        setBounds(10,10,440,450);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK); //Color de fondo del JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void initDisplay(){

        //Propiedades y estilos el display
        display = new JLabel("Intenta acertar al centro de la diana");
        display.setBounds(15,15,395,60); //Tamaño y posición
        display.setOpaque(true); //Hago el componente opaco para poder darle un color de fondo
        display.setBackground(Color.BLACK); //Color de fondo
        display.setForeground(Color.GREEN); //Color de fuente
        display.setBorder(new LineBorder(Color.GRAY)); //Color del borde
        display.setFont(new Font("MONOSPACED",PLAIN,16)); //Tipo de fuente
        display.setHorizontalAlignment(SwingConstants.CENTER); //Alineación al centro
        add(display); //Añado el display al JFrame
    }

    private void initNivel(){

        nivel = new JSlider(JSlider.HORIZONTAL, 1, 3, 2);
        nivel.setBounds(150,90,100,60);
        nivel.setBackground(Color.BLACK); //Color de fondo
        nivel.setForeground(Color.GREEN); //Color de fuente
        nivel.setBorder(new LineBorder(Color.BLACK)); //Color del borde
        nivel.setPaintLabels(true); //Para que aparezcan los números
        nivel.setPaintTicks(true); //Para que aparezcan las barras
        nivel.setMajorTickSpacing(1); //Cada cuánto queremos ver los números
        nivel.setMinorTickSpacing(1); //Cada cuánto queremos ver las barras
        add(nivel);

        nivel.addChangeListener(this);


    }

    private void initDiana(){

        diana = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        diana.setBounds(110, 200, 200, 60);
        diana.setBackground(Color.BLACK); //Color de fondo
        diana.setForeground(Color.GREEN); //Color de fuente
        diana.setBorder(new LineBorder(Color.BLACK)); //Color del borde
        diana.setPaintLabels(false); //Para que aparezcan los números
        diana.setPaintTicks(true); //Para que aparezcan las barras
        diana.setMajorTickSpacing(100); //Cada cuánto queremos ver los números
        diana.setMinorTickSpacing(100); //Cada cuánto queremos ver las barras

        add(diana);

        diana.addMouseListener(this);

    }

    public void reset(){

        //reseteo para volver a jugar
        diana.setValue(0);
    }

    public static void main(String[] args) {
        new Practica2();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getSource() == diana){

            //Capturo el valor de X, lo asocio al valor de la diana y llamo a la ventana de resultado
            BasicSliderUI ui = (BasicSliderUI) diana.getUI();
            int valor = ui.valueForXPosition(e.getX());
            diana.setValue(valor);
            new Practica2Resultado(this,true, valor);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

        if (e.getSource() == nivel){

            //Cambio el ancho y la posición de la diana
            switch (nivel.getValue()) {
                case 1 -> diana.setBounds(15, 200, 395, 60);
                case 2 -> diana.setBounds(110, 200, 200, 60);
                case 3 -> diana.setBounds(160, 200, 70, 60);
            }

        }

    }
}
