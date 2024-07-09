package elice2;

import java.io.*;
import java.util.*;

public class Elice2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int arrNum = Integer.parseInt(st.nextToken());
        int inputNum = Integer.parseInt(st.nextToken());

        String[] arr1 = br.readLine().split(" ");

        for(int i=0;i<inputNum;i++){
            String[] arr2 = br.readLine().split(" ");
            int start = Integer.parseInt(arr2[0])-1;
            int end = Integer.parseInt(arr2[1]);
            int k = Integer.parseInt(arr2[2])-1;

            String[] arr3 = Arrays.copyOfRange(arr1,start,end);
            int[] arr4 = new int[arr3.length];

            for(int l=0;l<arr3.length;l++){
                arr4[l] = Integer.parseInt(arr3[l]);
            }
            Arrays.sort(arr4);
            
            bw.write(String.valueOf(arr4[k]));
            bw.newLine();
        }
        bw.flush();
    }
}
