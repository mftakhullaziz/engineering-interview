package coding_interview;

public class TestFactorial {
    // Kompleksitas Linier O(N)
    public int FactorialCase(int value){
        int temp = 1;
        for (int i = value; i >=1 ; i--) {
            temp *= i;
        }
        return temp;
    }
}
