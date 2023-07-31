public class Q12_lv1_숫자문자열과영단어3 {
	public static String[] nums = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	
	public static int solution(String s) {
		for(int i=0;i<nums.length;i++) {
			s = s.replaceAll(nums[i], i+"");
		}
		return Integer.parseInt(s);
    }
}

