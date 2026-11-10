package src;

import java.awt.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Mi Calculadora Java");

        ventana.setSize(400, 450);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(35, 40, 55));

        JLabel titulo = new JLabel("CALCULADORA JAVA");
        titulo.setBounds(70, 20, 280, 40);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(titulo);

        JLabel texto1 = new JLabel("Primer número:");
        texto1.setBounds(40, 85, 150, 25);
        texto1.setForeground(Color.WHITE);
        panel.add(texto1);

        JTextField numero1 = new JTextField();
        numero1.setBounds(40, 115, 300, 35);
        panel.add(numero1);

        JLabel texto2 = new JLabel("Segundo número:");
        texto2.setBounds(40, 165, 150, 25);
        texto2.setForeground(Color.WHITE);
        panel.add(texto2);

        JTextField numero2 = new JTextField();
        numero2.setBounds(40, 195, 300, 35);
        panel.add(numero2);

        JLabel resultado = new JLabel("Resultado: ");
        resultado.setBounds(40, 245, 320, 30);
        resultado.setForeground(Color.GREEN);
        resultado.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(resultado);

        Calculadora calculadora = new Calculadora();

        JButton sumar = new JButton("SUMAR");
        sumar.setBounds(40, 295, 140, 40);
        panel.add(sumar);

        JButton restar = new JButton("RESTAR");
        restar.setBounds(200, 295, 140, 40);
        panel.add(restar);

        JButton multiplicar = new JButton("MULTIPLICAR");
        multiplicar.setBounds(40, 345, 140, 40);
        panel.add(multiplicar);

        JButton dividir = new JButton("DIVIDIR");
        dividir.setBounds(200, 345, 140, 40);
        panel.add(dividir);

        JButton limpiar = new JButton("LIMPIAR");
        limpiar.setBounds(125, 395, 130, 35);
        panel.add(limpiar);

        // Funcion para realizar las operaciones
        sumar.addActionListener(e -> operar(1, numero1, numero2, resultado, calculadora));

        restar.addActionListener(e -> operar(2, numero1, numero2, resultado, calculadora));

        multiplicar.addActionListener(e -> operar(3, numero1, numero2, resultado, calculadora));

        dividir.addActionListener(e -> operar(4, numero1, numero2, resultado, calculadora));

        // Boton para limpiar los campos
        limpiar.addActionListener(e -> {
            numero1.setText("");
            numero2.setText("");
            resultado.setText("Resultado: ");
        });

        ventana.add(panel);
        ventana.setVisible(true);
    }

    public static void operar(int opcion, JTextField numero1,
            JTextField numero2, JLabel resultado, Calculadora calculadora) {

        try {

            double n1 = Double.parseDouble(numero1.getText());
            double n2 = Double.parseDouble(numero2.getText());

            double respuesta = 0;

            switch (opcion) {

                case 1:
                    respuesta = calculadora.sumar(n1, n2);
                    break;

                case 2:
                    respuesta = calculadora.restar(n1, n2);
                    break;

                case 3:
                    respuesta = calculadora.multiplicar(n1, n2);
                    break;

                case 4:
                    if (n2 == 0) {
                        JOptionPane.showMessageDialog(null,
                                "No se puede dividir entre cero.");
                        return;
                    }
                    respuesta = calculadora.dividir(n1, n2);
                    break;
            }

            resultado.setText("Resultado: " + respuesta);

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null,
                    "Por favor, ingresa números válidos.");

        }
    }
}
