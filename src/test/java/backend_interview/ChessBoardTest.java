package backend_interview;

import java.util.Collections;

public class ChessBoardTest {
    public void chessBoard(int x, int y){
        String blankSpace = "";
        for (int i =0; i < (y-4); i++) {
            for (int j = 0; j < 4; j++) {
                if ((i+j) % 2 == 0) {
                    if ((i+j)+2 >= 0) {
                        String x1 = "X";
                        System.out.print(String.join("", Collections.nCopies(x, x1)));
                    }
                } else {
                    if ((i+j)-1 >= 0){
                        String x1 = "-";
                        System.out.print(String.join("", Collections.nCopies(x, x1)));
                    }
                }
            }
            System.out.println(blankSpace);
            for (int j = 0; j < 4; j++) {
                if ((i+j) % 2 == 0) {
                    if ((i+j)+2 >= 0) {
                        String x1 = "X";
                        System.out.print(String.join("", Collections.nCopies(x, x1)));
                    }
                } else {
                    if ((i+j)-1 >= 0){
                        String x1 = "-";
                        System.out.print(String.join("", Collections.nCopies(x, x1)));
                    }                }
            }
            System.out.println(blankSpace);
        }
    }

    public static void main(String []args){
        ChessBoardTest cB = new ChessBoardTest();
        // Value x : 2
        // Value y : 8
        cB.chessBoard(2,8);
    }

}

/*
Params :
X = Size of Square
Y = Size of Board

Example Output :
XX--XX--
XX--XX--
--XX--XX
--XX--XX
XX--XX--
XX--XX--
--XX--XX
--XX--XX
*/