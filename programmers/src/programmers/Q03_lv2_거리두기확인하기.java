package programmers;

public class Q03_lv2_거리두기확인하기 {
	private static final int[] dx = {0, -1, 1, 0}; 
	private static final int[] dy = {-1, 0, 0, 1}; // 상좌우하 -> except idx 구하기 위해 이 순서로 배치
	
	private boolean isDistanced(char[][] room) {
		for(int y=0;y<room.length;y++)
			for(int x=0;x<room[y].length;x++) {
				if(room[y][x] != 'P') continue;
				if(!isDistanced(room, x, y)) return false;
			}
		return true;
	}
	
	private boolean isDistanced(char[][] room, int x, int y) {
		for(int d=0;d<4;d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(ny<0 || ny>=room.length || nx<0 || nx>=room[ny].length) continue;
			
			switch(room[ny][nx]) {
				case 'P' : return false;
				case 'O' :
					// 인접한 곳에 다른 응시자 있는지 검사
					if(isNextToVolunteer(room, nx, ny, 3-d)) return false; // 진행 방향의 반대방향 제외
					break;
			}
		}
		return true;
	}
	
	// 원래 검사 시작한 응시자 제외한 방향에 응시자 있는지 반환
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
	
	public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0;i<answer.length;i++) {
        	String[] place = places[i];
        	char[][] room = new char[place.length][];
        	for(int j=0;j<room.length;j++)
        		room[j] = place[j].toCharArray();
        	
        	if(isDistanced(room))
        		answer[i] = 1;
        	else
        		answer[i] = 0;
        }
        return answer;
    }
}
