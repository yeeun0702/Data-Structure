package AVLtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class AVL<Key extends Comparable<Key>, Value> {
        private Node root;
        public class Node {
                private Key id;               
                private Value name;           
                private int height;           
                private Node left, right;  
                public Node(Key newID, Value newName, int newHt) { // 생성자
                        id = newID;
                        name = newName;
                        height = newHt;
                        left = right = null;
                }
        }


        private int height(Node n) { // 높이 계산 
                if (n == null) return 0;
                return n.height;
        }


        public void put(Key k, Value v) {root = put(root, k, v);}  // 삽입 연산
        private Node put(Node n, Key k, Value v) {
                if (n == null)         return new Node(k, v, 1);
                int t = k.compareTo(n.id);
                if (t < 0)                 n.left  = put(n.left,  k, v);
                else if (t > 0) n.right = put(n.right, k, v);
                else {
                        n.name = v;  // k가 이미 트리에 있으므로 Value v만 갱신
                        return n;
                }
                n.height = tallerHeight(height(n.left), height(n.right)) + 1;
                return balance(n); // 노드 n의 균형 점검 및 불균형을 바로 잡음
        }


        private Node balance(Node n) { // 불균형 처리
                if (bf(n) > 1) {  //노드 n의 왼쪽 서브트리가 높아서 불균형 발생
                        if (bf(n.left) < 0) { // 노드 n의 왼쪽자식노드의 오른쪽서브트리가 높은 경우
                                n.left = rotateLeft(n.left);    // LR-회전
                        }
                        n = rotateRight(n);  // LL-회전
                }
                else if (bf(n) < -1) {  //노드 n의 오른쪽 서브트리가 높아서 불균형 발생
                        if (bf(n.right) > 0) {  // 노드 n의 오른쪽자식노드의 왼쪽 서브트리가 높은 경우
                                n.right = rotateRight(n.right); // RL-회전
                        }
                        n = rotateLeft(n);  // RR-회전
                }
                return n;
        }


        private int bf(Node n) {  // bf 계산
                return height(n.left) - height(n.right);  // bf = 왼쪽 서브트리 높이 - 오른쪽 서브트리 높이         
        }


        private Node rotateRight(Node n) {  //우로 회전
                Node x = n.left;
                n.left = x.right;
                x.right = n;
                n.height = tallerHeight(height(n.left), height(n.right)) + 1; // 높이 갱신
                x.height = tallerHeight(height(x.left), height(x.right)) + 1; // 높이 갱신
                return x;  // 회전 후 x가 n의 이전 자리로 이동되었으므로 
        }


        private Node rotateLeft(Node n) {   //좌로 회전
                Node x = n.right;
                n.right = x.left;
                x.left = n;
                n.height = tallerHeight(height(n.left), height(n.right)) + 1; // 높이 갱신
                x.height = tallerHeight(height(x.left), height(x.right)) + 1; // 높이 갱신
                return x;  // 회전 후 x가 n의 이전 자리로 이동되었으므로 
        }


        private int tallerHeight(int x, int y){  // 높이 비교
                if (x>y) return x;
                else return y;
        }


        public void delete(Key k) {        root = delete(root, k);}  // 삭제 연산
        private Node delete(Node n, Key k) {
                int t = k.compareTo(n.id);
                if (t < 0)                 n.left  = delete(n.left, k);
                else if (t > 0) n.right = delete(n.right, k);
                else {
                        if (n.left == null)            return n.right;
                        else if (n.right == null) return n.left;
                        else {
                                Node y = n;
                                n = min(y.right);
                                n.right = deleteMin(y.right);
                                n.left = y.left;
                        }
                }
                n.height = tallerHeight(height(n.left), height(n.right)) + 1;
                return balance(n);
        }


        public void deleteMin() {root = deleteMin(root);}  // 최솟값 삭제
        private Node deleteMin(Node n) {
                if (n.left == null) return n.right;
                n.left = deleteMin(n.left);
                n.height = tallerHeight(height(n.left), height(n.right)) + 1;
                return balance(n);
        }


        public Key min() {return min(root).id;}  // 최솟값 찾기
        private Node min(Node n) {
                if (n.left == null) return n;
                return min(n.left);
        }


        public void print(Node root)  {  // 트리 출력
/*
                 System.out.printf("\ninorder:\n");
                inorder(root);
                System.out.printf("\npreorder:\n");
                preorder(root);
                System.out.printf("\nlevel order:\n");
                levelorder(root);
                System.out.printf("\nTree Visualization\n");
*/
                printNode(root);
        }
        public void inorder(Node n){       // 중위 순회
                if (n != null) {
                        inorder(n.left);   // n의 왼쪽 서브 트리를 순회하기 위해
                        System.out.print(n.id+" ");  // 노드 n 방문
                        inorder(n.right);  // n의 오른쪽 서브 트리를 순회하기 위해
                }
        }
        public void levelorder(Node root) { // 레벨 순회
                Queue<Node> q = new LinkedList<Node>(); // 큐 자료구조 이용
                Node t;
                q.add(root);  // 루트 노드 큐에 삽입
                while (!q.isEmpty()) { 
                        t = q.remove();   //큐에서 가장 앞에 있는 노드 제거
                        System.out.print(t.id+" "); // 제거된 노드 출력(방문)
                        if (t.left != null)      // 제거된 왼쪽 자식이 null이 아니면
                                q.add(t.left);       // 큐에 왼쪽 자식 삽입
                        if (t.right != null)     // 제거된 오른쪽 자식이 null이 아니면
                                q.add(t.right);      // 큐에  오른쪽 자식 삽입
                } 
        }
        public void preorder(Node n) {     // 전위 순회
                if (n != null) {
                        System.out.print(n.id+" ");  // 노드 n 방문
                        preorder(n.left);  // n의 왼쪽    서브 트리를 순회하기 위해
                        preorder(n.right); // n의 오른쪽 서브 트리를 순회하기 위해
                }
        }


    public <T extends Comparable<?>> void printNode(Node root) {
        int maxLevel = maxLevel(root);


        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }


    private <T extends Comparable<?>> void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;


        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;


        printWhitespaces(firstSpaces);


        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.id);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }


            printWhitespaces(betweenSpaces);
        }
        System.out.println("");


        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }


                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);


                printWhitespaces(i + i - 1);


                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);


                printWhitespaces(endgeLines + endgeLines - i);
            }


            System.out.println("");
        }


        printNodeInternal(newNodes, level + 1, maxLevel);
    }


    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }


    private <T extends Comparable<?>> int maxLevel(Node node) {
        if (node == null)
            return 0;


        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }


    private <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }


        return true;
    }


        


        public static void main(String[] args) {
                AVL<Integer, String> st = new AVL<Integer, String>();




                 st.put(1, "Apple"); st.print(st.root);
                 st.put(2, "Grape"); st.print(st.root);
                 st.put(3, "Lime"); st.print(st.root);
                 st.put(5, "Mango"); st.print(st.root);
                 st.put(4, "Strawberry");st.print(st.root);


                 st.delete(2);st.print(st.root);


        }
}