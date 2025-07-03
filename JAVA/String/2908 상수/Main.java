import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int fst = Integer.parseInt(st.nextToken());
        int snd = Integer.parseInt(st.nextToken());
        fst = Integer.parseInt(convert(fst));
        snd = Integer.parseInt(convert(snd));

        bw.write(String.valueOf(Math.max(fst,snd)));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
    public static String convert(int result){
        String res = String.valueOf(result);
        char[] c = new char[res.length()];
        for (int i = 0 ; i < res.length(); i++){
            c[i]=res.charAt(res.length()-1-i);
        }
        return String.valueOf(c);
    }
}