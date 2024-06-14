class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int nt = nums[0] + 1;
        for(int i = 1; i<nums.length; i++)
        {    
            if(nt >= nums[i]){
                 count += (nt++ - nums[i]);
            }
            else{
                nt = nums[i] + 1;
                }                
        }
        return count;

    }
}