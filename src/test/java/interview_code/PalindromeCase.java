package interview_code;

import org.junit.jupiter.api.Test;

public class PalindromeCase {

    public boolean PalindromeCase(String value){
        StringBuilder temp = new StringBuilder();
        for (int i = value.length()-1; i >= 0 ; i--) {
            temp.append(value.charAt(i));
        }
        System.out.println("String Original : "+value);
        System.out.println("String Reverse  : "+temp);
        return temp.toString().equals(value);
    }

    public boolean PalindromeCase1(String value){
        for (int i = value.length()/ 2; i >= 1 ; i--) {
            int lastIndex = value.length()- i-1;
            if (value.charAt(i) != value.charAt(lastIndex)){
                return false;
            }
        }
        return true;
    }

    public boolean PalindromeRekursifCase(String value, int i){
       if (i < value.length()/2){
           int lastIndex = value.length()-i-1;
           if (value.charAt(i) != value.charAt(lastIndex)){
               return false;
           } else {
               // func rekursif
               return PalindromeRekursifCase(value, i+1);
           }
       } else {
           return true;
       }
    }

    @Test
    void testPalindromeCase(){
        System.out.println(PalindromeCase("katak1"));
        System.out.println(PalindromeCase1("katak"));
        System.out.println(PalindromeRekursifCase("katak", 0));
    }







    public static StringBuilder StringChallenge(String str) {
        // code goes here
        StringBuilder temp = new StringBuilder();
        for(int i = str.length()-1; i>=0; i--){
            temp.append(str.charAt(i));
        }
        return temp;
    }

    @Test
    void test1(){
        System.out.println(StringChallenge("coder"));
    }

    public static String timeConvert(int time){
        String hours, min;
        if(time < 60){
            hours = "0";
            min = Integer.toString(time);

        }else{
            hours = Integer.toString(time / 60);
            min = Integer.toString(time % 60);
        }
        return hours + ":" + min;
    }
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
////        System.out.println(timeConvert(46));
//
//    }



    public static double Tukar(int a, int b){
        if (a != b){
            a = a+b;
            b = a-b;
            a = a-b;
            System.out.println(a+":"+b);
            System.out.println(b+":"+a);
        }
//        return 0;
        return 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        System.out.println(timeConvert(46));
        System.out.println(Tukar(10,20));


    }





}
