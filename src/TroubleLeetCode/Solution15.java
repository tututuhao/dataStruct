package TroubleLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
        List<List<Integer>> res=new ArrayList();
        public List<List<Integer>> threeSum(int[] nums) {
            int len=nums.length;
            Arrays.sort(nums);
            for(int i=0;i<len;i++) {
                if (nums[i] > 0) break;
                if (i > 0 &&nums[i]==nums[i-1]) continue;
                int target=0-nums[i];
                int l=i+1,r=len-1;
                while (l<r){
                    List<Integer> list=new ArrayList();
                    if(nums[l]+nums[r]==target) {
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        while (r>l&&nums[l + 1] == nums[l]) l++;
                        while (r>l&&nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }else if(nums[l]+nums[r]>target) r--;
                    else l++;
                }
            }
            return res;
        }
}
