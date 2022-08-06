package coding_interview;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestReverseNumber {
    public int ReverseNumber(int n) {
        int temp = 0;
        while (n !=0 ) {
            int number = n % 10;
            temp = temp * 10 + number;
            n = n / 10;
        }
        return temp;
    }

    @Test
    public void testReverseNumber() {
        System.out.println(ReverseNumber(
                543201
        ));
        assertEquals(102005, ReverseNumber(500201), "OK!");
    }
}
