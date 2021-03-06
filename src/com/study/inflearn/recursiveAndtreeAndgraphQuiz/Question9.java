package com.study.inflearn.recursiveAndtreeAndgraphQuiz;

/***
 * 9. Tree 말단 노드까지의 가장 짧은 경로 (DFS)
 *
 * 설명
 * 아래 그림과 같은 이진트리에서 루트 노드 1에서 말단노드까지 길이 중 가장 짧은 길이를
 * 구하는 프로그램을 작성하세요.
 * 각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를 즉 간선(에지)의 개수를
 * 길이로 하겠습니다.
 *
 * 가장 짧은 길이의 3번 노드까지의 길이인 1이다.
 *
 * 2022.07.12 해결
 */
public class Question9 {
    static class Node{
        int data;
        Node lt,rt;

        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }
    Node root;
    public static void main(String[] args) {
        Question9 tree = new Question9();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.dfs(0, tree.root));
    }
    private int dfs(int L, Node root) {
        if(root.lt == null & root.rt == null) return L;
        else return Math.min(dfs(L+1, root.lt), dfs(L+1, root.rt));
    }
}
