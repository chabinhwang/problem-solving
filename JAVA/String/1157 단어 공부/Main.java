package JAVA;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toLowerCase();
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            String s = word.charAt(i)+"";
            if (map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        if(entryList.size()==1){
            bw.write(entryList.get(0).getKey().toUpperCase());
        }else if (!entryList.get(0).getValue().equals( entryList.get(1).getValue())){
            bw.write(entryList.get(0).getKey().toUpperCase());
        }else{
            bw.write("?");
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
