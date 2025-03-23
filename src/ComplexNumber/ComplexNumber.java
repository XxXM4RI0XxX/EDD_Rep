package ComplexNumber;

import javax.swing.*;

/*
CLASE RECORD

Es una clase que ya tiene inlcuido un constructor, los atributos a declarar van en los parentesis de la clase
Los atributos de la clase son siempre "private final", por que se convierte en una clase inmutable
La clase ya tiene incluidos metodos GETTERS
 */

public record ComplexNumber(double real, double img) {

    //METHODS//////////////////////////////////////////
    static ComplexNumber getFromString(String value) {
            try {
                if(!value.endsWith("i"))
                    throw new NumberFormatException(); //Error si no termina en 'i'
                value = value.replace('i',' ');

                String[] val = value.split("(?=[+-])",2);
                // split("(?=[+-]), 2"; Divide cada vez que se encuentra con uno de los caracteres dentro
                //de los [corchetes], este metodo ignora la posicion 0,
                // 2: Divide un numero limitado de veces el valor.

                double real = Double.parseDouble(val[0]);
                double img = Double.parseDouble(val[1]);

                return new ComplexNumber(real, img);
            } catch (NumberFormatException e) { //Error si no existe un valor numerico en la cadena
                value = JOptionPane.showInputDialog(null, "Entrada invalida...\nIntente de nuevo:",
                        "ERROR 404", JOptionPane.ERROR_MESSAGE);
                return getFromString(value);
            }
    }

    static ComplexNumber addition(ComplexNumber cn1, ComplexNumber cn2) {
        //(a+bi) + (c+di) = (a+c) + (b+d)i

        double realRes = cn1.real + cn2.real;
        double imgRes = cn1.img + cn2.img;

        return new ComplexNumber(realRes, imgRes);
    }

    static ComplexNumber subtraction(ComplexNumber cn1, ComplexNumber cn2) {
        //(a+bi) - (c+di) = (a-c) + (b-d)i

        double realRes = cn1.real - cn2.real;
        double imgRes = cn1.img - cn2.img;

        return new ComplexNumber(realRes, imgRes);
    }

    static ComplexNumber multiplication(ComplexNumber cn1, ComplexNumber cn2) {
        //(a + bi)(c + di) = (ac - bd) + (ad + bc)i

        double realRes = cn1.real * cn2.real - cn1.img * cn2.img;
        double imgRes = cn1.real * cn2.img + cn1.img * cn2.real;

        return new ComplexNumber(realRes, imgRes);
    }

    static ComplexNumber division(ComplexNumber cn1, ComplexNumber cn2) {
        //(a + bi)/(c + di) = [(ac + bd) + (bc - ad)i]/(c^2 + d^2)

        double div = Math.pow(cn2.real, 2) + Math.pow(cn2.img, 2); //(c^2 + d^2)

        double realRes = (cn1.real * cn2.real + cn1.img * cn2.img) / div; //(ac + bd)
        double imgRes = (cn1.img * cn2.real - cn1.real * cn2.img) / div;

        return new ComplexNumber(realRes, imgRes);
    }

    //OVERRIDES////////////////////////////////

    @Override
    public String toString() {
        if (img == 0)
            return String.valueOf(real);
        else {
            if (img > 0)
                return String.format("%.2f+%.2fi", real, img);
            else return String.format("%.2f-%.2fi", real, img * -1);
        }
    }
}
