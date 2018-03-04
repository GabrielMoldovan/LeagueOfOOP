package main;

public class Map {
	int n;
	int m;
	
	public void setN(final int n){
		this.n = n;
	}
	public void setM(final int m){
		this.m = m;
	}
	public char[][] map;
	public void setMap(String[] string){
		map = new char[n][m];
		for(int i = 0; i < this.n; i++){
			for(int j = 0; j < this.m; j++){
				//System.out.println(i + " " + j);
				map[i][j] = string[i].charAt(j);
			}
		}
	}
	public char getLand(int x, int y){
		return map[x][y];
	}
}
