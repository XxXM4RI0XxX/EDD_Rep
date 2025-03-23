package ComplexNumber;

import javax.swing.*;
import java.util.InputMismatchException;

public class Main {

    private static ComplexNumber cn1;

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Bienvenido al calcualdor complejo", "Boli uwu", JOptionPane.INFORMATION_MESSAGE);

        Object oper = JOptionPane.showInputDialog(null, "Elija operacion a realizar", "Operacion",
                JOptionPane.QUESTION_MESSAGE, new ImageIcon("Util\\tether_usdt_crypto_icon_264385.png"),
                new Object[]{"Suma", "Resta", "Multiplicacion", "Division"}, "Elija una...");

        Object val1 = JOptionPane.showInputDialog(null, "Ingrese primer numero complejo", "Numero complejo 1",
                JOptionPane.QUESTION_MESSAGE, new ImageIcon("Util\\tether_usdt_crypto_icon_264385.png"),
                null, "a+bi");
        ComplexNumber cn1 = ComplexNumber.getFromString(val1.toString());

        // Object _name_ = JOptionPane.showInputDialog(GUI_Padre, "Mensaje a mostrar", "Titulo", "Icono por defecto",
        // new ImageIcon("Ubicacion de imagen icono"),
        // !!!!!OJO!!!!!: Valores de tipo Objeto pueden tomar cualquier tipo de valor asignado :o

        Object val2 = JOptionPane.showInputDialog(null, "Ingrese segundo numero complejo", "Numero complejo 2",
                JOptionPane.QUESTION_MESSAGE, new ImageIcon("Util\\tether_usdt_crypto_icon_264385.png"),
                null, "a+bi");
        ComplexNumber cn2 = ComplexNumber.getFromString(val2.toString());

        ComplexNumber res;
        char ope;

        switch (oper.toString()) {
            case "Suma" -> {
                res = ComplexNumber.addition(cn1, cn2);
                ope = '+';
            }
            case "Resta" -> {
                res = ComplexNumber.subtraction(cn1, cn2);
                ope = '-';
            }
            case "Multiplicacion" -> {
                res = ComplexNumber.multiplication(cn1, cn2);
                ope = '*';
            }
            case "Division" -> {
                res = ComplexNumber.division(cn1, cn2);
                ope = '/';
            }
            default -> {
                res = null;
                ope = ' ';
                System.out.println("Wtf");
            }
        }
        JOptionPane.showMessageDialog(null, String.format("Operacion: [%s]%c[%s]\nResultado: %s", cn1, ope, cn2, res));
    }
}
