package List.Util;

import Util.RandomGenerator;

public enum Position {
    //Posicion a insertar
    FRONT,
    BACK,
    MIDDLE,
    RANDOM;

    public Position getRandom(){
        int r = RandomGenerator.genRandomInt(1,4);

        if(r == 1) return FRONT;
        if(r == 2) return BACK;
        else return MIDDLE;
    }
}
