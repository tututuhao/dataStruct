package SegmentTree;

public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger){
        this.merger=merger;
        data=(E[])new Object[arr.length];
        for(int i=0;i<arr.length;i++)
            data[i]=arr[i];

        tree=(E[])new Object[arr.length*4];
        buildSegmentTree(0,0,arr.length-1);
    }

    private void buildSegmentTree(int treeIndex,int l,int r){
        if(l==r){
            tree[treeIndex]=data[l];
            return;
        }
        int leftIndex=leftChild(treeIndex);
        int rightIndex=rightChild(treeIndex);

        int mid=l+(r-l)/2;
        buildSegmentTree(leftIndex,l,mid);
        buildSegmentTree(rightIndex,mid+1,r);

        tree[treeIndex]=merger.merge(tree[leftIndex],tree[rightIndex]);
    }

    public int size(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    public E query(int queryL,int queryR){
        if(queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");

       return query(0,0,data.length-1,queryL,queryR);
    }

    public E query(int treeIndex,int l,int r,int queryL,int queryR){
        if(l==queryL&&r==queryR){
            return tree[treeIndex];
        }
        int mid=l+(r-l)/2;

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(queryL>=mid+1)
            return query(rightTreeIndex,mid+1,r,queryL,queryR);
        else if(queryL<=mid)
            return query(leftTreeIndex,l,mid,queryL,queryR);
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }



    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return 2*index + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return 2*index + 2;
    }
}
