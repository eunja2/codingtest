public class Q04_lv2_행렬의곱셈2 {
	public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
    	
        for(int i=0;i<arr1.length;i++) {
        	for(int j=0;j<arr1[i].length;j++) {
        		answer[i][j] = 0;
        		for(int k=0;k<arr1[i].length;k++)
        			answer[i][j] += arr1[i][k] * arr2[k][j];
        	}
        }
        
        return answer;
    }
}
