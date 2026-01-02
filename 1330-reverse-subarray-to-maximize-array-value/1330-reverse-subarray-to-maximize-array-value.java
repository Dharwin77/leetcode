class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length;
        int total = 0;
        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
        for (int i = 0; i + 1 < n; ++i) {
            int a = nums[i], b = nums[i + 1];
            total += Math.abs(a - b);
            mn = Math.min(mn, Math.max(a, b));
            mx = Math.max(mx, Math.min(a, b));
        }
        int diff = Math.max(0, (mx - mn) * 2);
        for (int i = 0; i + 1 < n; ++i) {
            int a = nums[i], b = nums[i + 1];
            int head = -Math.abs(a - b) + Math.abs(nums[0] - b);
            int tail = -Math.abs(a - b) + Math.abs(nums[n - 1] - a);
            diff = Math.max(diff, Math.max(head, tail));
        }
        return total + diff;
    }
}