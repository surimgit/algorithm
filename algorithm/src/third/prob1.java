package third;

import java.util.*;

class Node{
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class prob1{
    static Node binaryTree(int nodeCount, int[] parents) {
    	Node[] nodes = new Node[nodeCount];

        for(int i = 0; i < nodeCount; i++) {
            nodes[i] = new Node(i);
        }
        
        Node root = null;
        
        for(int i = 0; i < nodeCount; i++) {
            int parent = parents[i];
            if (parent == -1) {
                root = nodes[i];
            }else {
                if(nodes[parent].left == null) {
                    nodes[parent].left = nodes[i];
                }else {
                    nodes[parent].right = nodes[i];
                }
            }
        }

        return root;
    }

    static void preorder(Node root){
        if(root != null) {
            System.out.print(root.value + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void inorder(Node root){
        if(root != null) {
        	inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    static void postorder(Node root){
        if(root != null) {
        	postorder(root.left);
        	postorder(root.right);
            System.out.print(root.value + " ");
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("노드의 개수를 입력하세요: ");
        int nodeCount = scanner.nextInt();
        
        int[] parentSequence = new int[nodeCount];
        System.out.print("부모 노드 수열을 입력하세요: ");
        for(int i = 0; i < nodeCount; i++) {
            parentSequence[i] = scanner.nextInt();
        }

        Node root = binaryTree(nodeCount, parentSequence);

        System.out.println("선순위 순회 결과:");
        preorder(root);
        System.out.println("\n중순위 순회 결과:");
        inorder(root);
        System.out.println("\n후순위 순회 결과:");
        postorder(root);
    }
}
