public class Q14_lv1_신규아이디추천3 {
	public static String solution(String new_id) {
		
		String replaced_id = new_id.toLowerCase()
							.replaceAll("[^a-z0-9\\-_.]", "")
							.replaceAll("\\.+",".")
							.replaceAll("^\\.+|\\.+$","");
		
		if(replaced_id.equals("")) replaced_id = "a";
			
		if(replaced_id.length()>=16)
			replaced_id = replaced_id.substring(0,15).replaceAll("\\.+$","");
						
		while(replaced_id.length()<=2) {
			replaced_id += replaced_id.substring(replaced_id.length()-1);
		}
		
        return replaced_id;
    }
	
	public static void main(String[] args) {
		System.out.println(solution("z-+.^."));
	}
}
