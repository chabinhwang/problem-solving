import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
        StringBuilder result = new StringBuilder(); // 결과를 담을 StringBuilder

        for (int i = 0; i < N; i++) {
            String input = br.readLine(); // 입력을 한 줄로 읽어옴
            StringBuilder sb = new StringBuilder(); // 각 테스트 케이스에 대한 결과를 담을 StringBuilder
            int cursor = 0; // 커서 위치

            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);

                if (c == '<') {
                    if (cursor > 0) cursor--;
                } else if (c == '>') {
                    if (cursor < sb.length()) cursor++;
                } else if (c == '-') {
                    if (cursor > 0) {
                        sb.deleteCharAt(cursor - 1);
                        cursor--;
                    }
                } else { // 그냥 단어가 올 경우
                    sb.insert(cursor, c);
                    cursor++;
                }
            }
            result.append(sb); // StringBuilder의 내용을 결과에 추가
            if (i < N - 1) {
                result.append('\n');
            }
        }
        System.out.println(result.toString()); // 전체 결과 출력
    }
}
