

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Q29_lv2_메뉴리뉴얼 {
	private static class Course {
		public final String course; // 코스 구성
		public final int occurrences; // 주문 목록에서 등장한 횟수
		
		public Course(String course, int occurrences) {
			this.course = course;
			this.occurrences = occurrences;
		}
	}
	
	private void getCourses(char nextMenu, // 포함 여부 결정할 메뉴
							Set<String> selectedMenus, // 현재까지 선택한 메뉴 
							List<Set<String>> orderList, // 주문 목록
							Map<Integer, List<Course>> courses) { // 구한 코스를 저장할 자료구조
		
		int occurrences = (int) orderList.stream() // stream으로 변환
				.filter(order -> order.containsAll(selectedMenus)) // 현재까지 조합인 메뉴 포함하는 주문목록 검사
				.count(); // 원소 개수를 long형으로 반환
		
		if(occurrences < 2) return;
		int size = selectedMenus.size(); // 지금까지 구한 메뉴 조합에 포함된 메뉴 개수
		
		if(courses.containsKey(size)) { // 구해야 하는 코스 크기에 size가 포함되어 있다면
			List<Course> courseList = courses.get(size); // 해당 리스트 가져오기
			Course course = new Course(selectedMenus.stream()
					.sorted()
					.collect(Collectors.joining("")), // 하나의 문자열로 합치기
					occurrences);
			
			// 기존에 찾은 다른 코스들과 비교하여 등장횟수 갖거나 더 많을 때만 저장해야 하므로
			Course original = courseList.get(0); // 기존 코스 가져오기. 빈 코스 아니어야 한다는 조건 아래서 충족시켜줌
			if(original.occurrences < occurrences) {
				courseList.clear();
				courseList.add(course);
			} else if(original.occurrences == occurrences) {
				courseList.add(course);
			}
		}
		
		if(size >= 10) return;
		for(char menuChar = nextMenu; menuChar<= 'Z'; menuChar++) {
			String menu = String.valueOf(menuChar);
			selectedMenus.add(menu);
			getCourses((char)(menuChar+1), selectedMenus, orderList, courses);
			selectedMenus.remove(menu);
		}
	}
	
	public String[] solution(String[] orders, int[] course) {
		// 주문목록을 List<Set<String>> 으로 변환하기
		List<Set<String>> orderList = Arrays.stream(orders)
					.map(String::chars) // String.chars() : 문자열에 포함된 문자의 아스키코드를 IntStream으로 변환
										// map(String.chars()) : Stream<IntStream>으로 변환
					.map(charStream -> charStream
						.mapToObj(menu -> String.valueOf((char) menu)) // 아스키 코드를 문자열로 변환
					.collect(Collectors.toSet())) // Set으로 변환
					.collect(Collectors.toList());
		
		// 생성된 코스들을 담을 Map<Integer, List<Course>> 객체 생성하기
		Map<Integer, List<Course>> courses = new HashMap<>();
		for(int length : course) {
			List<Course> list = new ArrayList<>();
			list.add(new Course("",0)); // 리스트는 비어있지 않아야 한다는 조건
			courses.put(length, list);
		}
		
		getCourses('A', new HashSet<>(), orderList, courses);
		// courses -> 길이별 가장 많이 등장한 코스 저장됨. 이를 사전 순으로 정렬하여 1차원 배열로 변환
		return courses.values().stream()
				.filter(list -> list.get(0).occurrences > 0)
				.flatMap(List::stream) // Stream<List<Course>> -> Stream<Course>
				.map(c-> c.course) // Course 클래스의 course 필드 가져오기
				.sorted()
				.toArray(String[]::new);
    }
}

