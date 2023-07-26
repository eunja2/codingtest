

public class Q14_lv1_신규아이디추천 {
	public String solution(String new_id) {
		// 소문자로 치환
		new_id = new_id.toLowerCase();
		// 소문자, 숫자, -, _, . 제외한 모든 문자 제거
		new_id = new_id.replaceAll("[^a-z0-9\\-_.]","");
		// 마침표 2개 이상 연속된 부분 하나의 마침표로 치환
		new_id = new_id.replaceAll("\\.{2,}",".");
		// 마침표가 처음이나 끝에 위치한다면 제거
		new_id = new_id.replaceAll("^\\.+|\\.+$","");
		// 빈문자열이라면 "a"를 대입
		if("".equals(new_id)) new_id = "a";
		// 길이가 16자 이상이면 첫 15문자를 제외한 나머지 문자들을 모두 제거
		if(new_id.length() > 15) {
			new_id = new_id.substring(0,15);
			new_id = new_id.replaceAll("^\\.+|\\.+$","");
		} 
		// 2자 이하라면 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 이어서 붙임
		while(new_id.length() < 3)
			new_id += new_id.charAt(new_id.length() - 1);
		
        return new_id;
    }
}
