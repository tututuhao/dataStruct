package SetAndMap;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

//两个数组的交集
public class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet=new TreeSet<>();
        for(int num1:nums1){
            treeSet.add(num1);
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int num2:nums2){
            if(treeSet.contains(num2)){
                list.add(num2);
                treeSet.remove(num2);
            }
        }
        int res[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
