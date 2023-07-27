public class Q03_lv2_거리두기확인하기3 {
	private static final int[] dx = {0, -1, 1, 0}; // 상좌우하 : 반대 방향 인덱스 끼리 더하면 3이 됨
	private static final int[] dy = {-1, 0, 0, 1};
	
	public int[] solution(String[][] places) {
		
        int[] answer = new int[places.length];
        
        for(int i=0;i<answer.length;i++) {
        	String[] place = places[i];
        	char[][] room = new char[place.length][];
        	for(int j=0;j<room.length;j++) 
        		room[j] = place[j].toCharArray();
        	
        	// 거리 두기 검사
			if(isDistanced(room)) answer[i] = 1;
			else answer[i] = 0;
        }
        return answer;
    }
	
	// 한 대기실에서 거리두기 지키고 있는지 판별
	private boolean isDistanced(char[][] room) {
		for(int y=0;y<room.length;y++) {
			for(int x=0;x<room[y].length;x++) {
				if(room[y][x] != 'P') continue;
				if(!isDistanced(room, x, y)) return false;
			}
		}
		return true;
	}
	
	// 해당 대기실에서 응시자의 위치(x,y)가 거리두기 지키고 있는지 판별(오버로딩)
	private boolean isDistanced(char[][] room, int x, int y) {
		for(int d=0;d<4;d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(ny<0 || ny>=room.length || nx<0 || nx>=room[ny].length) continue;
			
			switch(room[ny][nx]) {
				case 'P' : return false;
				case 'O' : // 인접한 다른 곳에 응시자 있는지 검사
					if(isNextToVolunteer(room, nx, ny, 3-d)) return false;
					break;
			}
		}
		return true;
	}
	
	// 인접한 다른 곳에 응시자 있는지 검사
	private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
		for(int d=0;d<4;d++) {
			if(d == exclude) continue;
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(ny<0 || ny>=room.length || nx<0 || nx>=room[ny].length) continue;
			if(room[ny][nx] == 'P') return true;
		}
		return false;
	}
}
