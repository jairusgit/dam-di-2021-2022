import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;

public class Ejercicio9 extends JFrame {

    JLabel rojo, verde, azul, rgb, hex, rgbCalculado, hexCalculado, inputHex;
    JComboBox comboRojo, comboVerde, comboAzul;
    JButton botonRGB, botonHEX;
    JTextField textFieldHex;
    int r, g, b;

    Ejercicio9() {

        initLabel();
        initComboBox();
        initBotones();
        initVentana();
        initAcciones();

    }

    private void initLabel() {
        rojo = new JLabel("R : ");
        rojo.setBounds(10, 10, 50, 30);
        add(rojo);

        verde = new JLabel("G : ");
        verde.setBounds(10, 50, 50, 30);
        add(verde);

        azul = new JLabel("B : ");
        azul.setBounds(10, 90, 50, 30);
        add(azul);

        rgb = new JLabel("RGB : ");
        rgb.setBounds(200, 10, 50, 30);
        add(rgb);

        hex = new JLabel("HEX : ");
        hex.setBounds(200, 50, 50, 30);
        add(hex);

        rgbCalculado = new JLabel("Pulsa un botón");
        rgbCalculado.setBounds(250, 10, 100, 30);
        add(rgbCalculado);

        hexCalculado = new JLabel("Pulsa un botón");
        hexCalculado.setBounds(250, 50, 100, 30);
        add(hexCalculado);

        inputHex = new JLabel("Color Hex:");
        inputHex.setBounds(200, 90, 100, 30);
        add(inputHex);

        textFieldHex = new JTextField();
        textFieldHex.setBounds(275, 90, 75, 30);
        add(textFieldHex);

    }

    private void initComboBox() {
        comboRojo = new JComboBox();
        comboRojo.setBounds(60, 10, 100, 30);
        add(comboRojo);
        anadirItem(comboRojo);

        comboVerde = new JComboBox();
        comboVerde.setBounds(60, 50, 100, 30);
        add(comboVerde);
        anadirItem(comboVerde);

        comboAzul = new JComboBox();
        comboAzul.setBounds(60, 90, 100, 30);
        add(comboAzul);
        anadirItem(comboAzul);

    }

    public void anadirItem(JComboBox combo) {

        for (int i = 0; i < 256; i++) {
            combo.addItem(String.valueOf(i));
        }
    }

    private void initBotones() {
        botonRGB = new JButton("RGB a HEX");
        botonRGB.setBounds(35, 150, 120, 30);
        add(botonRGB);
        botonHEX = new JButton("HEX a RGB");
        botonHEX.setBounds(200, 150, 120, 30);
        add(botonHEX);
    }

    private void initVentana() {
        setLayout(null);
        setTitle("Ejercicio 9");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 250);
        setVisible(true);

    }

    private void initAcciones() {
        botonRGB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Texto r,g,b
                String textoRGB =   comboRojo.getSelectedItem() + "," +
                                    comboVerde.getSelectedItem() + "," +
                                    comboAzul.getSelectedItem();
                rgbCalculado.setText(textoRGB);

                //Enteros r,g,b
                r = Integer.parseInt((String) comboRojo.getSelectedItem());
                g = Integer.parseInt((String) Objects.requireNonNull(comboVerde.getSelectedItem()));
                b = Integer.parseInt((String) Objects.requireNonNull(comboAzul.getSelectedItem()));

                //Cambio el color de fondo
                Color color = new Color(r, g, b);
                getContentPane().setBackground(color);

                //Conversión a hex
                String textoHex = "#" + String.format("%2s",Integer.toHexString(r)).replace(' ', '0') +
                                        String.format("%2s",Integer.toHexString(g)).replace(' ', '0') +
                                        String.format("%2s",Integer.toHexString(b)).replace(' ', '0');
                hexCalculado.setText(textoHex);

            }
        });
        botonHEX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (textFieldHex.getText().length() == 6){

                    //Recupero el color hexadecimal
                    String colorHex = textFieldHex.getText();
                    hexCalculado.setText("#" + colorHex);

                    //Convierto a RGB
                    r = Integer.valueOf(colorHex.substring(0, 2), 16);
                    g = Integer.valueOf(colorHex.substring(2, 4), 16);
                    b = Integer.valueOf(colorHex.substring(4, 6), 16);
                    rgbCalculado.setText(r + "," + g + "," + b);

                    //Cambio el color de fondo
                    Color color = new Color(r, g, b);
                    getContentPane().setBackground(color);
                }
            }
        });

    }

    public static void main(String[] args) {
        new Ejercicio9();
    }

}
