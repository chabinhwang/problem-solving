import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(bf.readLine());
        int b=Integer.parseInt(bf.readLine());
        int c=Integer.parseInt(bf.readLine());
        int result=a*b*c;
        int temp=0;
        ArrayList<Integer> list = new ArrayList<>(Collections.nCopies(10, 0));
        while(result>=1){
            int temp2=result%10;//1의자릿수==temp2
            result=result/10;
            list.set(temp2,list.get(temp2)+1);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i));
        }
    }
}