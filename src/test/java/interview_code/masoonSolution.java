package interview_code;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class masoonSolution {
    public static int getUmbrellas(int requirement, List<Integer> sizes) {
        // Write your code here
        int n = sizes.size();
        if (n == 0) return -1;
        Collections.sort(sizes);


        int[] dp = new int[requirement+1];
        dp[0] = 0;
        for (int i = 1; i <= requirement; i++)
            dp[i] = Integer.MAX_VALUE-10;

        for (int umbre: sizes) {
            if (umbre > requirement) break;
            for (int i = umbre; i <= requirement; i++) {
                dp[i] = Math.min(dp[i], dp[i-umbre] + 1);
            }
        }
        if (dp[requirement] >= Integer.MAX_VALUE-10)
            return -1;
        return dp[requirement];

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int requirement = Integer.parseInt(bufferedReader.readLine().trim());

        int sizesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sizes = IntStream.range(0, sizesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = getUmbrellas(requirement, sizes);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
