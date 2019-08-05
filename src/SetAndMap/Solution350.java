package SetAndMap;

import java.util.ArrayList;
import java.util.TreeMap;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        for(Integer num1:nums1){
           if(treeMap.containsKey(num1)){
               treeMap.put(num1,treeMap.get(num1)+1);         //这里同样的要设置对应的key
           }else {
               treeMap.put(num1,1);
           }
        }

        ArrayList<Integer> arrayList=new ArrayList<>();
        for(Integer num2:nums2){
            if(treeMap.containsKey(num2)){
                arrayList.add(num2);
                treeMap.put(num2,treeMap.get(num2)-1);
                if(treeMap.get(num2)==0)             //there is a little problem
                    treeMap.remove(num2);             //there is a little problem
            }
        }
        int res[]=new int[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            res[i]=arrayList.get(i);
        }
        return res;
    }
}
