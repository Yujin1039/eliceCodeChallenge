package elice1;

import java.util.Scanner;

/*
 [목표량]
시간 제한: 1초
엘리스 토끼는 목표량을 정해 수학 문제를 열심히 풉니다. 목표량은 정수입니다.

내일 풀 수학 문제의 개수는 오늘 푼 문제 개수의 수와 숫자의 구성이 같으면서, 오늘 푼 문제 개수의 수보다 큰 수 중 가장 작은 수입니다.

예를 들어, 오늘 67문제를 풀었으면 다음 날 76문제를 풉니다.

오늘 푼 문제의 개수를 줬을 때 다음날 풀 문제의 개수를 출력하는 프로그램을 작성하세요.


[지시사항]
입력
첫 번째 줄에 오늘 푼 문제의 개수인 자연수 N을 입력합니다.

1≤N≤999999

정답이 반드시 있는 경우만 입력값으로 주어집니다.
[출력]
다음날 풀 문제의 개수를 출력합니다.

[입력 예시]
364
[출력 예시]
436
 * */
public class Q1 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        char[] digits = String.valueOf(N).toCharArray();
        int length = digits.length;

        // Step 1: Find the first decreasing element from the right
        int i = length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        System.out.println("first i: "+i);

        // Step 2: If such an element is found
        if (i >= 0) {
            int j = length - 1;
            // Step 3: Find the smallest element on the right side of 'i' that is larger than digits[i]
            while (j >= 0 && digits[j] <= digits[i]) {
                j--;
            }
            System.out.println("2nd i: "+i);
            System.out.println("first j: "+j);
            // Step 4: Swap the elements at i and j
            swap(digits, i, j);
        }

        // Step 5: Reverse the elements from i+1 to the end of the array
        reverse(digits, i + 1, length - 1);

        // Convert back to integer and print the result
        int result = Integer.parseInt(new String(digits));
        System.out.println(result);
    }

    // Helper method to swap two elements in a character array
    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Helper method to reverse a portion of a character array
    private static void reverse(char[] array, int start, int end) {
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }
	
}
//~보다 큰 가장 작은 정수 찾기
//① 역순으로 탐색하여 이전 수보다 작은 숫자가 있는 곳(=역순기준 내림차순)의 index(=i) 저장하기
//② i번째 숫자의 뒷 부분에서 역순으로 탐색하여 가장 먼저 발견되는 큰 수의 index(=j) 저장 -> 둘을 swap
//  : 제시한 수보다 크지만 가장 작은(=변화가 작은) 수 생성을 위함
//③ i번째 숫자의 뒤에 오는 숫자를 오름차순으로 정렬한다(reverse메서드)

