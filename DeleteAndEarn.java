// Time Complexity : O(N) || O(Max(nums))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// This problem is similar to house robber problem.

public class DeleteAndEarn {
    
    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10001];

        // Generating the total sum that can be obtained for a given number.
        for (int num: nums){
            arr[num] += num;
        }

        int skip = 0, take = 0, prev = 0;
        for (int k = 0; k <= 10000; ++k){
            if (arr[k] == 0) continue;
            int temp = skip; // prev skip
            skip = Math.max(skip, take); // current skip
            if (prev < k - 1) {
                // If previous number is not in the range of current number then we can take the max of the previous number.
                // Setting the current take
                take = arr[k] + skip;
            } else {
                // If previous number is in the range of current number then we need to skip it if we are taking the current number.
                // Setting the current take
                take = arr[k] + temp;
            }
            // Setting the current key as previous since we are using this for referencing it later.
            prev = k;
        }
        return Math.max(skip, take);
    }

}
