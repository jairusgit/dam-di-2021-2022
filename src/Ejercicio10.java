import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Ejercicio10 extends JFrame{

    BorderLayout miBorderLayout;
    FlowLayout miFlowLayout;
    JPanel panelEste, panelOeste;
    JButton[] boton;
    JLabel titulo, pie;
    JTextArea textArea;


    public Ejercicio10(){

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
        titulo.setBackground(Color.RED);
        add(titulo, NORTH);

        //Text Area
        textArea = new JTextArea("Este es el Text Area");
        add(textArea, CENTER);

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
        }

        setVisible(true);



    }
    public static void main(String[] args) {
        new Ejercicio10();
    }

}
