package array;

public class main {
    public static void main(String[] args) {
        Array<Integer> array=new Array(20);

        for(int i=0;i<10;i++){
            array.addLast(i);
    }
        System.out.println(array);

        array.addLast(6);
        System.out.println(array);

        array.remove(5);
        System.out.println(array);

    }
}
