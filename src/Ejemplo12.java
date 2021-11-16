import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ejemplo12 extends JFrame implements ItemListener {

    private JComboBox combo1;
    private JLabel label1;

    public Ejemplo12() {

        //Añado el ComboBox con sus items y su ItemListener, así como la etiqueta
        combo1=new JComboBox();
        combo1.setBounds(10,10,80,20);
        add(combo1);

        combo1.addItem("ninguno");
        combo1.addItem("rojo");
        combo1.addItem("verde");
        combo1.addItem("azul");
        combo1.addItemListener(this);

        label1 = new JLabel("Color seleccionado: ninguno");
        label1.setBounds(10,80,200,30);
        add(label1);

        //Configurar y mostrar JFrame
        initPantalla();
    }

    private void initPantalla() {

        setLayout(null); //Layout absoluto
        setTitle("Ejemplo 12"); //Título del JFrame
        setSize(300, 200); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
        setVisible(true); //Mostrar JFrame
    }

    public static void main(String[] args) {
        new Ejemplo12();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        String texto = "Color seleccionado:  ";

        if (e.getSource() == combo1) {
            String seleccionado = (String)combo1.getSelectedItem();
            texto += seleccionado;
            label1.setText(texto);
        }

    }
}