import javax.swing.*;

public class Ejemplo7a extends JFrame {

    JTextField textfield1;
    JTextArea textarea1;

    public Ejemplo7a(){

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
        textarea1.setBounds(10,50,400,300);
        add(textarea1);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Ejemplo7a();
    }

}
