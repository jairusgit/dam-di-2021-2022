import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ejercicio7 extends JFrame
{
    private JButton button;
    private boolean botonActivo = false;

    public Ejercicio7()
    {
        initLabel();
        initButton();
        initCheckBox();
        initVentana();
    }

    private void initVentana()
    {
        setLayout(null);
        setTitle("Ejercicio 7");
        setBounds(0, 0, 300, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(179, 181, 183));
        setVisible(true);
    }

    private void initLabel()
    {
        JLabel label = new JLabel("¿Acepta las condiciones del servicio?");
        label.setBounds(10, 10, 280, 30);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Trebuchet MS", BOLD, 14));
        add(label);
    }

    private void initButton()
    {
        button = new JButton("Continuar");
        button.setBounds(75, 120, 150, 30);
        button.setEnabled(false);
        button.setBackground(new Color(125, 138, 160));
        button.setFont(new Font("Trebuchet MS", BOLD, 14));
        button.setFocusPainted(false);
        button.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                if(botonActivo)
                {
                    System.exit(0);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                if(botonActivo)
                {
                    button.setBackground(new Color(63, 70, 84));
                    button.setForeground(Color.white);
                }
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                if(botonActivo)
                {
                    button.setBackground(new Color(125, 138, 160));
                    button.setForeground(Color.black);
                }
            }
        });
        add(button);
    }

    private void initCheckBox()
    {
        JCheckBox checkbox = new JCheckBox("Acepto");
        checkbox.setBounds(115, 50, 100, 30);
        checkbox.setBackground(new Color(179, 181, 183));
        checkbox.setFont(new Font("Trebuchet MS", BOLD, 14));
        checkbox.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                button.setEnabled(checkbox.isSelected());
                botonActivo = checkbox.isSelected();
            }
        });
        add(checkbox);
    }

    public static void main(String[] args)
    {
        new Ejercicio7();
    }
}