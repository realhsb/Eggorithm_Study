package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657 {
    static int[] answer;
    static int limit;
    static int dataSize;
    static StringBuilder sb = new StringBuilder();
    static int[] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dataSize = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());

        answer = new int[limit];


        st = new StringTokenizer(br.readLine());

        data = new int[dataSize + 1];

        for (int i = 1; i <= dataSize; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);

        for (int i = 1; i <= dataSize; i++) {
            answer[0] = data[i];
            backTracking(i,0);
        }

        System.out.print(sb);
    }

    private static void backTracking(int at, int depth) {
        if (depth + 1 == limit) {
            for (int i = 0; i < answer.length; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= dataSize; i++) {
            answer[depth + 1] = data[i];
            backTracking(i,depth + 1);
        }

    }
}