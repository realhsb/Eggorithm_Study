import java.io.*;
import java.util.*;

public class BOJ_15651 {
    static int[] data;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        data = new int[2];
        data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        arr = new int[data[1]];
        visit = new boolean[data[0]];
        backTracking(1,0);
        System.out.println(sb);
    }

    private static void backTracking(int at,int limit) {
        if(limit == data[1]){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=at; i<=data[0]; i++){
            arr[limit] = i;
            backTracking(i,limit+1);
        }
    }
}
