package BinarySearchTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node{
        public  E e;
        public Node left,right;

        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root=null;
        size=0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(E e){
        root=add(root,e);
    }

    private Node add(Node node,E e){
        if(node==null){
            size++;
            return node=new Node(e);
        }

        if(e.compareTo(node.e)<0){
            node.left=add(node.left,e);
        }else if(e.compareTo(node.e)>0)
            node.right=add(node.right,e);
        return node;
    }

    public boolean contain(E e){
        return contain(root,e);
    }

    private boolean contain(Node node,E e){
        if(node==null){
            return false;
        }

        if(e.compareTo(node.e)==0)
            return true;
         if(e.compareTo(node.e)<0)
            contain(node.left,e);
         if(e.compareTo(node.e)>0)
            contain(node.right,e);
         return false;
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node==null)
            return;;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // ???????????????????
    public void inOrder(){
        inOrder(root);
    }

    // ?????????node??????????????, ?????
    private void inOrder(Node node){
        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // ??????????????????
    public void postOrder(){
        postOrder(root);
    }

    // ?????????node??????????????, ?????
    private void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // ?????????????????????
    public void preOrderNR(){

        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur=stack.pop();
            System.out.println(cur.e);

            if(cur.right!=null)
                stack.push(cur.right);
            if(cur.left!=null)
                stack.push(cur.left);
        }
    }

    //??¦Á???
    public void yaw(){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur=q.remove();
            System.out.println(cur.e);
            if(cur.left!=null)
                q.add(cur.left);
            if(cur.right!=null)
                q.add(cur.right);
        }

    }

    //?????§³???
    public E minimun(){
        if(size==0)
            throw new IllegalArgumentException("BST is empty");
        Node minNode=minimun(root);
        return minNode.e;
    }

    //?????????
    public E maxmun(){
        if(size==0)
            throw new IllegalArgumentException("BST is empty");
        Node maxNode=maxmun(root);
        return maxNode.e;
    }

    private Node minimun(Node node){
        if(node.left==null)
            return node;
        return minimun(node.left);
    }

    private Node maxmun(Node node){
        if(node.right==null)
            return node;
        return maxmun(node.right);
    }

    //??????????
    public E removeMin(){
        E e=minimun();
        root=removeMin(root);
        return e;
    }

    private Node removeMin(Node node){
        if(node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            System.out.println(rightNode);
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }

    public E removeMax(){
        E e=maxmun();
        root=removeMax(root);
        return e;
    }

    private Node removeMax(Node node){
        if(node.right==null){
            Node leftNode=node.left;
            node.left=null;
            size--;
            return leftNode;
        }

        node.right=removeMin(node.right);
        return node;
    }

    //????????????????????e????
    public void remove(E e){
        root=remove(root,e);
    }
    private Node remove(Node node,E e){
        if(node==null)
            return null;

        if(e.compareTo(node.e)<0){
            node.left=remove(node.left,e);
            return node;
        }
        if(e.compareTo(node.e)>0){
            node.right=remove(node.right,e);
            return node;
        }else {    //e.compareTo(node.e)==0
            //?????????????????????
            if(node.left==null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            if(node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            Node successor=new Node(removeMin(node.right).e);
            size++;
            successor.right=removeMin(node.right);
            successor.left=node.left;

            node.left=node.right=null;
            size--;
            return successor;
        }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // ??????node??????????depth???????????????????
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
}
