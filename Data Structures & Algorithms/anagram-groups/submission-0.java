class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] strArr = s.toCharArray();
            Arrays.sort(strArr);
            String str = new String(strArr);
            if(map.containsKey(str)){
                map.get(str).add(s);
            }
            else {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(str, l);
            }
        }
        return new ArrayList<>(map.values());
    }
}
