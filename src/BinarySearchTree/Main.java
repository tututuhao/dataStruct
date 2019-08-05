package BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3,6, 8, 4, 2};
        for(int num: nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
//        bst.preOrder();
//        System.out.println();
//
//        bst.inOrder();
//        System.out.println();
//
//        bst.postOrder();
//        System.out.println();
//
//        bst.preOrderNR();
//        System.out.println();

        bst.yaw();
        System.out.println();
//
//        System.out.println(bst.maxmun());


        bst.removeMin();
        System.out.println(bst);
    }
}
