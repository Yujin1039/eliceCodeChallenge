package elice3;

import java.util.*;
/*
문자열 압축 해제
시간 제한: 1초
엘리스 토끼는 문자열을 직접 압축 해제하려고 합니다.

압축되지 않은 문자열 S가 주어졌을 때, 이 문자열 중 어떤 부분 문자열은 K(Q)와 같이 압축할 수 있습니다. 이것은 Q라는 문자열이 K 번 반복된다는 뜻입니다. K는 한 자릿수의 정수이고, Q는 0자리 이상의 문자열입니다.

예를 들면, 53(8)은 다음과 같이 압축을 해제할 수 있습니다.

53(8) = 5 + 3(8) = 5 + 888 = 5888

압축된 문자열이 주어졌을 때, 이 문자열을 다시 압축을 푸는 프로그램을 작성하세요.

지시사항
[입력]
첫째 줄에 압축된 문자열 S를 입력합니다.
S의 길이는 최대 50입니다.
문자열은 (, ), 숫자로만 구성되어 있습니다.
[출력]
압축되지 않은 문자열의 길이를 출력합니다.
[입력 예시]
11(18(72(7))) -> 26
*/
public class StringDecompressor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String compressedString = sc.nextLine(); // 압축된 문자열 입력
        System.out.println(decompress(compressedString)); // 압축 해제 후 문자열 길이 출력
    }

    private static int decompress(String compressedString) {
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < compressedString.length(); i++) {
            char c = compressedString.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {//stack의 마지막 요소가 ")"일 때까지 
                    stack.pop();//스택의 요소를 제거하고
                    result++;//문자열 길이+1
                }
                stack.pop(); // '(' 제거
                
                //'(' 바로 다음에 오는 수는 곱셈 처리
                int repeatCount = Integer.parseInt(stack.pop().toString());

                result *= repeatCount;
            } else {
                stack.push(c);
            }
        }
        
        //괄호를 제거하고 남은 숫자들은 각 숫자 -> 문자열 길이 + 1
        while (!stack.isEmpty()) {
            result++;
            stack.pop();
        }

        return result;
    }
}
