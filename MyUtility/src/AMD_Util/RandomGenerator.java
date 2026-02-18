package AMD_Util;

import java.util.Random;

public class RandomGenerator {

    private static final Random r = new Random();

    public static int genRandomInt(){
        return r.nextInt();
    }
    public static int genRandomInt(int origin, int bound){
        return r.nextInt(origin,bound);
    }
    public static double genRandomDouble(){
        return r.nextDouble();
    }
    public static double genRandomDouble(double origin, double bound){
        return r.nextDouble(origin,bound);
    }
    public static float genRandomFloat(){
        return r.nextFloat();
    }
    public static float genRandomFloat(float origin, float bound){
        return r.nextFloat(origin,bound);
    }

    public static char genRandomLowerCaseLetter(){ return (char) r.nextInt(97,123); }
    public static char genRandomUpperCaseLetter(){ return (char) r.nextInt(65,91);}
    public static boolean genRandomBoolean(){ return r.nextBoolean();}

    /// @param prob Set random chance of the object generates another object (0.00 - 100.00)
    public static RandomObject genRandomObject(float prob){return new RandomObject("",null,true,null, prob);}

    /// @param prob Set random chance of the person to have a child (0 - 100)
    public static RandomPerson genRandomPerson(int prob){return new RandomPerson("","",-1,-1,null,null,prob);}
}
