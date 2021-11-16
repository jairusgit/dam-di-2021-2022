import javax.swing.*;

public class Ejemplo7b extends JFrame {

    JTextField textfield1;
    JTextArea textarea1;
    JScrollPane scrollpane1;

    public Ejemplo7b(){

        /* Configuración del JFrame */
        setLayout(null);
        setBounds(0,0,540,400);
        setTitle("Ejemplo 7: JTextArea");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /* Campo de email */
        textfield1=new JTextField();
        textfield1.setBounds(10,10,200,30);
        add(textfield1);

        /* Cuerpo de mensaje */
        textarea1=new JTextArea();
        textarea1.setLineWrap(true); //Cuando llego al final de la línea salta a la siguiente
        textarea1.setBounds(10,50,400,300);

        /* Creo el jScrollPane con el jTextArea dentro */
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(10,50,400,300);
        add(scrollpane1);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Ejemplo7b();
    }

}
