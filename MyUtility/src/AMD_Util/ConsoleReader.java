package AMD_Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {

    private static final Scanner q = new Scanner(System.in);

    public static boolean readBoolean(Integer bool){ // 0 False ~ 1 True
        return bool==1;
    }

    public static byte readByte(){
        byte number = 0;
        boolean flag=true;
        System.out.print(">> ");
        do {
            try {
                number = q.nextByte();
                q.nextLine();
                return number;
            } catch (InputMismatchException e) {
                System.out.println(">>> Enter a valid number...");
                System.out.print(">> ");
                q.nextLine();
            }
        }while(flag);

        return number;
    }


    public static int readInt(){
        int number = 0;
        boolean flag=true;
        System.out.print(">> ");
        do {
            try {
                float x = q.nextFloat();
                q.nextLine();
                number = (int) x;
                return number;
            } catch (InputMismatchException e) {
                System.out.println(">>> Enter a valid number...");
                System.out.print(">> ");
                q.nextLine();
            }
        }while(flag);

        return number;
    }

    public static int readInt(int maxValue){
        int number = 0;
        boolean flag=true;
        System.out.print(">> ");
        do {
            try {
                float x = q.nextFloat();
                q.nextLine();
                number = (int) x;
                if(number>maxValue){
                    throw new InputMismatchException();
                }
                return number;
            } catch (InputMismatchException e) {
                System.out.println(">>> Enter a valid number...");
                System.out.print(">> ");
                q.nextLine();
            }
        }while(flag);

        return number;
    }

    public static int readInt(int maxValue, int minValue){
        int number = 0;
        boolean flag=true;
        System.out.print(">> ");
        do {
            try {
                float x = q.nextFloat();
                q.nextLine();
                number = (int) x;
                if(number>=maxValue||number<=minValue){
                    throw new InputMismatchException();
                }
                return number;
            } catch (InputMismatchException e) {
                System.out.println(">>> Enter a valid number...");
                System.out.print(">> ");
                q.nextLine();
            }
        }while(flag);

        return number;
    }

    public static long readLong(){
        long number = 0;
        boolean flag=true;
        System.out.print(">> ");
        do {
            try {
                float x = q.nextFloat();
                number = (long) x;
                return number;
            } catch (InputMismatchException e) {
                System.out.println(">>> Enter a valid number...");
                System.out.print(">> ");
                q.nextLine();
            }
        }while(flag);

        return number;
    }

    public static float readFloat(){
        float number = 0;
        boolean flag = true;
        System.out.print(">> ");
        do{
            try {
                number = q.nextFloat();
                return number;
            } catch (InputMismatchException e){
                System.out.println(">>> Enter a valid number...");
                System.out.print(">> ");
                q.nextLine();
            }
        }while (flag);

        return number;
    }

    public static double readDouble(){
        double number = 0;
        boolean flag = true;
        System.out.print(">> ");
        do{
            try {
                number = q.nextDouble();
                q.nextLine();
                return number;
            } catch (InputMismatchException e){
                System.out.println(">>> Enter a valid number...");
                System.out.print(">> ");
                q.nextLine();
            }
        }while (flag);

        return number;
    }

    public static char readChar(){
        char character = ' ';
        boolean flag = true;
        System.out.print(">> ");
        do {
            String value = q.nextLine();
            if(value.length()>2){
                System.out.println(">>> Enter a valid character...");
                System.out.print(">> ");
            } else if (value.isEmpty()) {
                System.out.print(">> ");
                value = q.nextLine();
                return  value.charAt(0);
            } else {
                return value.charAt(0);
            }
        }while (flag);

        return character;
    }

    public static String readString(){
        System.out.print(">> ");
        return q.nextLine();
    }

    public static String readString(int maxLength){
        String line;
        System.out.print(">> ");
        if(maxLength>0){
            do{
                line = q.nextLine();
                if(line.length()>maxLength) {
                    System.out.println(">>> Invalid length...");
                    System.out.print(">> ");
                }
                else return line;
            }while (line.length()>maxLength);
        }
        else{
            line = q.nextLine();
            return line;
        }return line;
    }

}
