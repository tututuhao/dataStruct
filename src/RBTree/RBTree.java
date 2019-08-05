package RBTree;

public class RBTree<K extends Comparable<K>,V> {

    private static final boolean RED =true;
    private static final boolean BLACK=false;

    private class Node{
        private K key;
        private V value;
        private Node left,right;
        private boolean color;

        private Node(K key,V value){
            this.key=key;
            this.value=value;
            left=null;
            right=null;
            color=RED;
        }
    }

    private Node root;
    private int size;

    public RBTree(){
        root=null;
        size=0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(K key,V value){
        root=add(key,value,root);
    }

    public Node add(K key,V value,Node node){
        if(node==null){
            size++;
            return new Node(key, value);
        }
        if(key.compareTo(node.left.key)<0)
            add(key, value, node.left);
        else if(key.compareTo(node.right.key)>0)
            add(key,value,node.right);
        else
            node.value=value;
        return node;
    }

    public Node getNode(Node node,K key){
        if(node==null){
            return null;
        }
        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key)<0)
            return node;
        else{
            return getNode(node.right,key);
        }
    }

    public V contain(K key){
        Node node= getNode(root,key);
        return node==null?null:node.value;
    }

    public void set(K key,V newValue){
        Node node=getNode(root,key);
        if(node==null)
            throw new IllegalArgumentException(key+"doesn't exist");
        node.value=newValue;
    }

    public Node minimum(Node node){
        if(node.left==null)
            return node;
        return minimum(node.left);
    }

    public Node leftRemote(Node node){

       Node  x=node.right;
       x.left=node;

       x.color=node.color;
       node.color=RED;

       return x;
    }
}
