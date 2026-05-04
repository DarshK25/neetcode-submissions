class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] count = new int[2001];
        int n = nums.length;
        for(int i = 0; i < n; i++){
            count[nums[i] + 1000]++;
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int i = 0; i < count.length; i++){
            if(count[i] > 0){
                int freq = count[i];
                if(bucket[freq] == null){
                    bucket[freq] = new ArrayList<>();
                }
                bucket[freq].add(i - 1000);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for(int i = bucket.length - 1; i >= 0 && idx < k; i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    res[idx++] = num;
                    if(idx == k) return res;
                }
            }
        }
        return res;
    }
}
