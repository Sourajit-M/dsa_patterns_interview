package backtracking;

import java.util.ArrayList;

public class Subsets {
    public static ArrayList<ArrayList<Integer>> generate_subsets(int[] nums){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res, new ArrayList<>());
        return res;
    }
    private static void backtrack(int[] nums, int index, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp){
        res.add(new ArrayList<>(temp));

        for(int i=index; i<nums.length; i++){
            temp.add(nums[i]);
            backtrack(nums, i+1, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
    public static ArrayList<String> generate_subsets(String str){
        ArrayList<String> res = new ArrayList<>();
        backtrack(str, 0, res, new StringBuilder());
        return res;
    }
    private static void backtrack(String str, int index, ArrayList<String> res, StringBuilder sb){
        res.add(sb.toString());

        for(int i=index; i<str.length(); i++){
            sb.append(str.charAt(i));
            backtrack(str, i+1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(generate_subsets(nums));

        String str = "abc";
        System.out.println(generate_subsets(str));
    }
}
