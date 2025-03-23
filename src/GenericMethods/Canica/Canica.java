package GenericMethods.Canica;

public class Canica implements Comparable<Canica> {

    double xCentro, yCentro, zCentro;
    double radio;
    //color int;

    public Canica(){
        xCentro = yCentro = zCentro = 0.0;
        radio = 1;
        //color
    }

    public Canica(double radio){
        xCentro = yCentro = zCentro = 0.0;
        this.radio = radio;
    }

    //------------------------------------------------------------
    @Override
    public int compareTo(Canica otra) {
        if(radio < otra.radio) return -1;
        if(radio > otra.radio) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("(%10.7f)",radio);
    }

    public static <T extends Comparable<T>> T maximum(T x, T y, T z){
        T max = x;
        if(y.compareTo(max) > 0){
            max = y; //y is the largest so far
        }
        if(z.compareTo(max) > 0){
            max = z; //z is the largest
        }

        return max; //returns the largest object
    } //end method maximum
}
