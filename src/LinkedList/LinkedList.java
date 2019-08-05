package LinkedList;

public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;



        public  Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public  Node(E e) {
            this(e, null);
        }

        public  Node() {
            this(null, null);
        }


        @Override
        public String toString() {
            return e.toString();
        }
    }

        private Node dommyHead;
        private int size;

        public LinkedList(){
            dommyHead=new Node();
            size=0;
        }

        public int getSize(){
            return size;
        }

        public boolean isEmpty(){
            return size==0;
        }

        //add e in first
        public void addFirst(E e){
           add(0,e);
        }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
        public void add(int index,E e){
            if(index < 0 || index > size)
                throw new IllegalArgumentException("Add failed. Illegal index.");


                Node prev=dommyHead;
                for(int i=0;i<index;i++) {
                    prev = prev.next;
                }
//                    Node node=new Node(e);
//                    prev.next=node.next;
//                    prev.next=node;
                    prev.next=new Node(e, prev.next);
                    size++;
        }

        public void addLast(E e){
            add(size,e);
        }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cut=dommyHead.next;
        for(int i=0;i<index;i++)
            cut=cut.next;
        cut.e=e;
    }

    public boolean contain(E e){
            Node cur=dommyHead.next;
            while (cur!=null){
                if(cur.e.equals(e))
                    return true;
                cur=cur.next;
            }
            return false;
    }

    public E remove(int index){
            Node prev=dommyHead;
            for(int i=0;i<index;i++){
                prev=prev.next;
            }
            Node cur=prev.next;
            prev.next=prev.next.next;
            cur.next=null;         //del node ,cur.next=>null;NOT cur=next;
            size--;         //Don't forget
            return cur.e;
    }
    @Override
    public String toString(){
            StringBuilder stringBuilder=new StringBuilder();

            Node cur=dommyHead.next;
            for(int i=0;i<size;i++){
                stringBuilder.append(cur);
                stringBuilder.append("=>");
                cur=cur.next;
            }
            stringBuilder.append("NULL");
            return stringBuilder.toString();
    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<Integer>();
        for (int i=0;i<5;i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.getSize();
        System.out.println(linkedList.getSize());

        linkedList.remove(2);
        System.out.println(linkedList);
    }



}
