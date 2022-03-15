package coding_interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPalindrome {

//    test Palindrome Use Boolean function
//    Case1 menggunakan Reverse String jika string yang di reverse sama dengan string
//    Original maka kata tersebut Palindrome

    public boolean PalindromeTest1(String Value) {
        StringBuilder temp = new StringBuilder();
        for (int i = Value.length()-1; i >= 0 ; i--) {
            temp.append(Value.charAt(i));
        }
        System.out.println("Kata Original : "+Value);
        System.out.println("Kata Reverse  : "+temp);
        return temp.toString().equals(Value);
    }


//    Optimize Palindrome Case dengan membagi 2 kata dan membandingkan nya kata bagian pertama yang di bagi dengan kata terakhir yang dibagi
//    Misal "abba" => ab <> ba dan dibandingkan dari index pertama dengan Index terakhir jika sama maka palindrome jika tidak sama maka tidak palindrome

    public boolean PalindromeTest2(String Value){
        for (int i = Value.length()/ 2; i >= 1 ; i--) {
            int lastIndex = Value.length()- i-1;
            if (Value.charAt(i) != Value.charAt(lastIndex)){
                return false;
            }
        }
        return true;
    }

//    Menggunakan teknik Rekursif
    public boolean PalindromeRekursifTest3(String Value, int i){
        if (i < Value.length()/2){
            int lastIndex = Value.length()-i-1;
//            Membagi 2 kata dan membandingkan nya kata index awal dan akhir jika sama maka palindrome
//            Jika tidak maka tidak palindrome
            if (Value.charAt(i) != Value.charAt(lastIndex)){
                return false;
            } else {
                // func rekursif
                return PalindromeRekursifTest3(Value, i+1);
            }
        } else {
            return true;
        }
    }

//  Untuk test function Run UNIT TEST


    @Test
    public void testPalindromeTest1() {
        System.out.println(PalindromeTest1("hello"));
        System.out.println(PalindromeTest1("abba"));

        Assertions.assertAll(
//        Using Assertion Condition True
                () -> Assertions.assertTrue(PalindromeTest1("abba")),
//        Using Assertion Condition False
                () -> Assertions.assertFalse(PalindromeTest1("hello"))
        );
    }

    @Test
    public void testPalindromeTest2() {
        System.out.println(PalindromeTest2("hello"));
        System.out.println(PalindromeTest2("abba"));

        Assertions.assertAll(
//        Using Assertion Condition True
                () -> Assertions.assertTrue(PalindromeTest2("abba")),
//        Using Assertion Condition False
                () -> Assertions.assertFalse(PalindromeTest2("hello"))
        );
    }

    @Test
    public void testPalindromeTest3() {
        System.out.println(PalindromeRekursifTest3("hello", 0));
        System.out.println(PalindromeRekursifTest3("abba", 0));

        Assertions.assertAll(
//        Using Assertion Condition True
                () -> Assertions.assertTrue(PalindromeRekursifTest3("abba", 0)),
//        Using Assertion Condition False
                () -> Assertions.assertFalse(PalindromeRekursifTest3("hello", 0))
        );
    }


}
