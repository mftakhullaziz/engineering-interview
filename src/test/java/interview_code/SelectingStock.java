package interview_code;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class SelectingStock {


    /*
     * Complete the 'selectStock' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER saving
     *  2. INTEGER_ARRAY currentValue
     *  3. INTEGER_ARRAY futureValue
     */

    public static int selectStock(int saving, List<Integer> currentValue, List<Integer> futureValue) {
        // Write your code here
        int[] res = new int[saving+1];
        int N = currentValue.size();
        for (int i = 1; i <= N; i++){
            int weight = currentValue.get(i - 1), value = futureValue.get(i - 1) - currentValue.get(i - 1);
            for (int j = saving; j >= weight; j--){
                res[j] = Math.max(res[j], res[j-weight]+value);
            }
        }
        return res[saving];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int saving = Integer.parseInt(bufferedReader.readLine().trim());

        int currentValueCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> currentValue = IntStream.range(0, currentValueCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int futureValueCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> futureValue = IntStream.range(0, futureValueCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = selectStock(saving, currentValue, futureValue);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


