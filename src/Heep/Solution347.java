package Heep;

import java.util.*;

public class Solution347 {


    public static  List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (Integer num : nums) {
            if (treeMap.containsKey(num))
                treeMap.put(num, treeMap.get(num) + 1);
            else
                treeMap.put(num, 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (a,b) -> treeMap.get(a)-treeMap.get(b)
        );
       for(int key:treeMap.keySet()){
           if(priorityQueue.size()<k)
               priorityQueue.add(key);
           else if(treeMap.get(key)>treeMap.get(priorityQueue.peek())){
               priorityQueue.remove();
               priorityQueue.add(key);
           }
       }

        LinkedList<Integer> linkedList=new LinkedList<>();
         while (!priorityQueue.isEmpty()){
           linkedList.add(priorityQueue.remove());
       }
       return linkedList;
    }

    public static void main(String[] args){
       int[] nums = {1,1,1,2,2,3,5,5,6,6,6,6};
        System.out.println(topKFrequent(nums,3));
    }
}
