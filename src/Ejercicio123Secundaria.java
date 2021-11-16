import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio123Secundaria extends JDialog implements ActionListener {

    JButton boton2;
    JLabel label1;

    //Le paso los parámetros de clase principal y modal
    public Ejercicio123Secundaria(Ejercicio123 parent, boolean modal, String opcion){

        //Invoco al constructor de la clase principal
        super(parent,modal);

        /* Layout absoluto y límites */
        setLayout(null);
        setBounds(440,10,410,210);

        //Título
        setTitle("Ejercicio 123 Secundaria");

        //No redimensionable
        setResizable(false);

        //Etiqueta
        label1 = new JLabel(opcion);
        label1.setBounds(115,60,200,30);
        add(label1);

        //Botón
        boton2 = new JButton("Volver");
        boton2.setBounds(105,110,200,40);
        add(boton2);

        //Añado el botón al action listener
        boton2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton2){
            setVisible(false);
        }
    }


}
