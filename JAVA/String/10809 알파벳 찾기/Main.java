import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args)throws IOException{
        int arr[] = new int[26];
        Arrays.fill(arr,-1);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        for (int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            int index = c - 'a';
            if(arr[index] == -1){
                arr[index] = i;
            } // 처음 나타난 글자인 경우에만 위치 저장
        }
        for (int i = 0; i < 26; i++){
            bw.write(arr[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}