import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ejercicio8 extends JFrame implements ChangeListener, ActionListener{

    private JTextField caja1, caja2;
    private JRadioButton sumar, restar, multiplicar, dividir;
    private JLabel resultado;
    private JButton reset;
    private double sumatorio;
    private ButtonGroup grupoBotones;

    public Ejercicio8() {
        radioButtons();
        cajas();
        resultado();
        reiniciar();
        initVentana();
    }

    private void initVentana()
    {
        setLayout(null);
        setTitle("Ejercicio 8");
        setBounds(0, 0, 500, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void radioButtons() {
        grupoBotones = new ButtonGroup();

        sumar = new JRadioButton("+");
        sumar.setBounds(10, 100, 130, 30);
        sumar.addChangeListener(this);
        add(sumar);
        grupoBotones.add(sumar);

        restar = new JRadioButton("-");
        restar.setBounds(10, 140, 130, 30);
        restar.addChangeListener(this);
        add(restar);
        grupoBotones.add(restar);

        multiplicar = new JRadioButton("x");
        multiplicar.setBounds(10, 190, 130, 30);
        multiplicar.addChangeListener(this);
        add(multiplicar);
        grupoBotones.add(multiplicar);

        dividir = new JRadioButton("/");
        dividir.setBounds(10, 230, 130, 30);
        dividir.addChangeListener(this);
        add(dividir);
        grupoBotones.add(dividir);

    }

    public void reiniciar() {
        reset = new JButton("Reiniciar");
        reset.setBounds(200, 150, 200, 60);
        reset.addActionListener(this);
        add(reset);
    }

    public void cajas() {
        caja1 = new JTextField();
        caja1.setBounds(10, 10, 50, 30);
        add(caja1);

        caja2 = new JTextField();
        caja2.setBounds(10, 50, 50, 30);
        add(caja2);
    }

    public void resultado() {
        resultado = new JLabel("0");
        resultado.setBounds(200, 50, 130, 40);
        resultado.setOpaque(true);
        add(resultado);
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        if (sumar.isSelected()) {
            sumatorio = Double.parseDouble(caja1.getText()) + Double.parseDouble(caja2.getText());
            if (sumatorio >= 0) {
                resultado.setBackground(Color.GREEN);
            } else {
                resultado.setBackground(Color.RED);
            }
            resultado.setText(sumatorio + "");
        } else if (restar.isSelected()) {
            sumatorio = Double.parseDouble(caja1.getText()) - Double.parseDouble(caja2.getText());
            if (sumatorio >= 0) {
                resultado.setBackground(Color.GREEN);
            } else {
                resultado.setBackground(Color.RED);
            }
            resultado.setText(sumatorio + "");
        } else if (dividir.isSelected()) {
            sumatorio = Double.parseDouble(caja1.getText()) / Double.parseDouble(caja2.getText());
            if (sumatorio >= 0) {
                resultado.setBackground(Color.GREEN);
            } else {
                resultado.setBackground(Color.RED);
            }
            resultado.setText(sumatorio + "");
        } else if (multiplicar.isSelected()) {
            sumatorio = Double.parseDouble(caja1.getText()) * Double.parseDouble(caja2.getText());
            if (sumatorio >= 0) {
                resultado.setBackground(Color.GREEN);
            } else {
                resultado.setBackground(Color.RED);
            }
            resultado.setText(sumatorio + "");
        }
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == reset) {
            grupoBotones.clearSelection();
            resultado.setText("");
            resultado.setBackground(Color.WHITE);
            caja1.setText("");
            caja2.setText("");
        }
    }

    public static void main(String[] args) {
        new Ejercicio8();
    }

}
