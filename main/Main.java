package main;

import java.io.IOException;
import fileio.implementations.FileReader;
import fileio.implementations.FileWriter;
import heroes.Base;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Main {
	public static void main(String[] args) throws IOException {
		String input = args[0];
		FileReader fileReader = new FileReader(input);
		int n, m;
		n = fileReader.nextInt();
		m = fileReader.nextInt();
		Map map = new Map();
		map.setN(n);
		map.setM(m);



		String[] string = new String[n];
		for (int i = 0; i < n; i++) {
			string[i] = fileReader.nextWord();
			System.out.println(string[i]);
		}
		map.setMap(string);
		//
		int nrEroi = fileReader.nextInt();
		Base[] heroes = new Base[nrEroi];
		for (int i = 0; i < nrEroi; i++) {
			char type = fileReader.nextWord().charAt(0);
			int x = fileReader.nextInt();
			int y = fileReader.nextInt();
			switch (type) {
			case 'P':
				heroes[i] = new Pyromancer();
				
				break;

			case 'K':
				heroes[i] = new Knight();
				break;

			case 'W':
				heroes[i] = new Wizard();
				break;

			case 'R':
				heroes[i] = new Rogue();
				break;

			default:
				break;
			}
			heroes[i].setRow(x);
			heroes[i].setCol(y);
			heroes[i].setMap(map);
		}

		int r = fileReader.nextInt();
		for (int i = 0; i < r; i++) {
			String runda = new String();
			runda = fileReader.nextWord();
			
			for (int j = 0; j < nrEroi; j++) {
				char direction = runda.charAt(j);
				if (heroes[j].isAlive()) {
					heroes[j].applyDot();
//					if(heroes[j].isAlive() == false){
//						heroes[j].setDeathFromDot(true);
//					}
					if (heroes[j].isMoves()) {
						heroes[j].moveHero(direction);
					}
				}

			}
			
			for (int j = 0; j < nrEroi; j++) {
				for (int k = 0; k < nrEroi; k++) {
					if (j != k) {
						if ((heroes[j].isHasFought() == false && heroes[k].isHasFought() == false)
								&& (heroes[j].getRow() == heroes[k].getRow()
										&& heroes[j].getCol() == heroes[k].getCol())
								&& (heroes[j].isAlive() && heroes[k].isAlive())) {
							heroes[k].setHp(heroes[k].getHp() - Math.round(heroes[j].fight(heroes[k])));
							heroes[j].setHp(heroes[j].getHp() - Math.round(heroes[k].fight(heroes[j])));
							if(heroes[k].isAlive() && heroes[j].isAlive() == false){
								int oldLevel = heroes[k].getLevel();
								heroes[k].setXp(heroes[k].getXp() + Math.max(0, 200 - (heroes[k].getLevel() - heroes[j].getLevel() * 40)));
								heroes[k].levelUp();
								if(heroes[k].getLevel() > oldLevel){
									heroes[k].increaseMaxHp();
								}
							}
							if(heroes[j].isAlive() && heroes[k].isAlive() == false){
								int oldLevel = heroes[j].getLevel();
								heroes[j].setXp(heroes[j].getXp() + Math.max(0, 200 - (heroes[j].getLevel() - heroes[k].getLevel() * 40)));
								heroes[j].levelUp();
								if(heroes[j].getLevel() > oldLevel){
									heroes[j].increaseMaxHp();
								}
								
							}
						}
					}
				}
			}
			

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map.map[i][j] + " ");
			}
			System.out.println();
		}
		for (int q = 0; q < nrEroi; q++) {
			System.out.println(heroes[q].getHeroType() + " " + heroes[q].getLevel() + " " + heroes[q].getXp() + " "
					+ heroes[q].getHp() + " " + heroes[q].getRow() + " " + heroes[q].getCol());
		}
		
		fileReader.close();
		String output = args[1];
		FileWriter fileWriter  = new FileWriter(output);
		for(int i = 0; i < nrEroi; i++){
			if(heroes[i].isAlive()){
				fileWriter.writeWord(heroes[i].getHeroType());
				fileWriter.writeWord(" ");
				fileWriter.writeInt(heroes[i].getLevel());
				fileWriter.writeWord(" ");
				fileWriter.writeInt(heroes[i].getXp());
				fileWriter.writeWord(" ");
				fileWriter.writeInt(heroes[i].getHp());
				fileWriter.writeWord(" ");
				fileWriter.writeInt(heroes[i].getRow());
				fileWriter.writeWord(" ");
				fileWriter.writeInt(heroes[i].getCol());
				fileWriter.writeWord(" ");
			}else{
				fileWriter.writeWord(heroes[i].getHeroType());
				fileWriter.writeWord(" dead");
			}
			fileWriter.writeNewLine();
			
		}
		fileWriter.close();
		
	}

}
