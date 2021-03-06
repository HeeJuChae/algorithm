package com.study.inflearn.greedyQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/***
 * 4. 최대 수입 스케쥴(PriorityQueue 응용문제)
 * 설명
 * 현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
 * 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
 * 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
 *
 * 입력
 * 첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.
 *
 * 출력
 * 첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
 *
 * 예시 입력 1
 * 6
 * 50 2
 * 20 1
 * 40 2
 * 60 3
 * 30 3
 * 30 1
 *
 * 예시 출력 1
 * 150
 *
 * 2022.07.21 해결
 */
public class Question4 {
    static class Price implements Comparable<Price>{
        int fee;
        int day;

        public Price(int fee, int day) {
            this.fee = fee;
            this.day = day;
        }

        @Override
        public int compareTo(Price o) {
            return o.day - this.day;
        }
    }
    static int maxDay, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ArrayList<Price> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int fee = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            list.add(new Price(fee, day));
            maxDay = Math.max(maxDay, day);
        }
        System.out.println(solution(list));
    }

    private static int solution(ArrayList<Price> list) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(list);
        int j = 0;
        for(int i = maxDay; i>=1; i--){
            for( ; j < n; j++){
                if(list.get(j).day < i)break;
                priorityQueue.offer(list.get(j).fee);
            }
            if(!priorityQueue.isEmpty()) answer += priorityQueue.poll();
        }
        return answer;
    }
}
