import javax.swing.*;

public class Ejercicio5 extends JFrame {

    JTextArea textarea1;
    JScrollPane scrollpane1;

    public Ejercicio5(){

        /* Configuración del JFrame */
        setLayout(null);
        setBounds(0,0,540,400);
        setTitle("Ejercicio 5");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /* Cuerpo de mensaje */
        textarea1=new JTextArea(tablas());
        textarea1.setLineWrap(true); //Cuando llego al final de la línea salta a la siguiente
        textarea1.setBounds(10,10,400,300);
        textarea1.setEditable(false);

        /* Creo el jScrollPane con el jTextArea dentro */
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(10,10,400,300);
        add(scrollpane1);

        setVisible(true);

    }

    String tablas(){

        String texto = "";
        for (int i = 1; i <=10; i++){

            for (int j = 1; j <=10; j++){

                texto += i + " x " + j + " = " + (i*j) + "\n";

            }

            texto += "----------------------\n";
        }


        return texto;
    }

    public static void main(String[] args) {
        new Ejercicio5();
    }

}
