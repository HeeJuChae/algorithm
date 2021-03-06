package com.study.inflearn.queueAndstackQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/***
 * 2. 괄호문자제거
 * 설명
 * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력
 * 남은 문자만 출력한다.
 *
 * 예시 입력 1
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)
 *
 * 예시 출력 1
 * EFLM
 *
 * 2022.07.06 해결
 */
public class Question2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char s : str.toCharArray()){
            if(s == '(') stack.push(s);
            else if(s == ')') stack.pop();
            else if(stack.isEmpty()) answer += s;
        }
        return answer;
    }
}
