package heroes;

import main.Map;

public class Base {
	int xp;
	int hp;
	int maxhp;
	int level;
	int row;
	int col;
	String type = new String();
	int dotRounds;
	boolean moves;
	float dot;
	boolean hasFought;
	boolean deathFromDot;

	public boolean isDeathFromDot() {
		return deathFromDot;
	}

	public void setDeathFromDot(boolean deathFromDot) {
		this.deathFromDot = deathFromDot;
	}

	public boolean isHasFought() {
		return hasFought;
	}

	public void setHasFought(boolean hasFought) {
		this.hasFought = hasFought;
	}

	public float getDot() {
		return dot;
	}

	public void setDot(float dot) {
		this.dot = dot;
	}

	public boolean isMoves() {
		return moves;
	}

	public void setMoves(boolean moves) {
		this.moves = moves;
	}

	public int getDotRounds() {
		return dotRounds;
	}

	public void setDotRounds(int dotRounds) {
		this.dotRounds = dotRounds;
	}

	public int getRow() {
		return this.row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return this.col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setHeroType(String string) {
		this.type = string;
	}

	public String getHeroType() {
		return this.type;
	}

	public int getXp() {
		return this.xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMaxHp() {
		return this.maxhp;

	}

	public void setMaxHp(int hp) {
		this.maxhp = hp;
	}

	Map map;

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Base() {
		// TODO Auto-generated constructor stub
		setXp(0);
		setLevel(0);
		setDotRounds(0);
		setDot(0);
		setMoves(true);
		setHasFought(false);
		setDeathFromDot(false);
	}

	public void increaseMaxHp() {

	}

	public boolean levelUp() {
		if (getXp() >= 250 && getXp() < 300) {
			setLevel(1);
			return true;
		} else {
			setLevel(((getXp() - 250) / 50 + 1));
			return true;
		}
		
		
	}

	public float abilityOne(Base enemy) {
		float damage = 0;
		return damage;
	}

	public float abilityTwo(Base enemy) {
		float damage = 0;
		return damage;
	}

	public float raceModifiersOne(Base enemy) { // race modifier pentru
												// abilitatea 1

		float modifier = 0f;
		switch (getHeroType()) {
		case "P":
			switch (enemy.getHeroType()) {
			case "R":
				modifier = 0.8f;
				break;
			case "K":
				modifier = 1.2f;
				break;
			case "P":
				modifier = 0.9f;
				break;
			case "W":
				modifier = 1.1f;
				break;
			default:
				break;
			}
			break;

		case "K":
			switch (enemy.getHeroType()) {
			case "R":
				modifier = 1.15f;
				break;
			case "K":
				modifier = 0f;
				break;
			case "P":
				modifier = 1.1f;
				break;
			case "W":
				modifier = 0.8f;
				break;
			default:
				break;
			}

		case "W":
			switch (enemy.getHeroType()) {
			case "R":
				modifier = 0.8f;
				break;
			case "K":
				modifier = 1.2f;
				break;
			case "P":
				modifier = 0.9f;
				break;
			case "W":
				modifier = 1.05f;
				break;
			default:
				break;
			}

		case "R":
			switch (enemy.getHeroType()) {
			case "R":
				modifier = 1.2f;
				break;
			case "K":
				modifier = 0.9f;
				break;
			case "P":
				modifier = 1.25f;
				break;
			case "W":
				modifier = 1.15f;
				break;
			default:
				break;
			}

		default:
			break;
		}
		return modifier;
	}

	public float raceModifiersTwo(Base enemy) { // race modifier pentru
												// abilitatea 2

		float modifier = 0f;
		switch (getHeroType()) {
		case "P":
			switch (enemy.getHeroType()) {
			case "R":
				modifier = 0.8f;
				break;
			case "K":
				modifier = 1.2f;
				break;
			case "P":
				modifier = 0.9f;
				break;
			case "W":
				modifier = 1.1f;
				break;
			default:
				break;
			}
			break;

		case "K":
			switch (enemy.getHeroType()) {
			case "R":
				modifier = 0.8f;
				break;
			case "K":
				modifier = 1.2f;
				break;
			case "P":
				modifier = 0.9f;
				break;
			case "W":
				modifier = 1.15f;
				break;
			default:
				break;
			}

		case "W":
			switch (enemy.getHeroType()) {
			case "R":
				modifier = 1.2f;
				break;
			case "K":
				modifier = 1.4f;
				break;
			case "P":
				modifier = 1.3f;
				break;
			case "W":
				modifier = 0f;
				break;
			default:
				break;
			}

		case "R":
			switch (enemy.getHeroType()) {
			case "R":
				modifier = 0.9f;
				break;
			case "K":
				modifier = 0.8f;
				break;
			case "P":
				modifier = 1.2f;
				break;
			case "W":
				modifier = 1.25f;
				break;
			default:
				break;
			}

		default:
			break;
		}
		return modifier;
	}

	public void stun(int rounds, Base enemy) {
		enemy.setDotRounds(rounds);
		enemy.setDot(0);
		enemy.setMoves(false);
		// if moves = false -> nu apelez moves si scad dotRounds (in main)
	}

	public void dot(int rounds, float damage, boolean moves, Base enemy) {
		enemy.setDotRounds(rounds);
		enemy.setDot(Math.round(damage * raceModifiersTwo(enemy)));
		enemy.setMoves(moves);
		// if dot > 0 -> hp curent = hp curent - dot; scad dotRounds (in main)
	}

	public void moveHero(char direction) {
		if (isMoves() == false) {
			return;
		}
		switch (direction) {
		case 'U':
			setRow(getRow() - 1);
			break;

		case 'D':
			setRow(getRow() + 1);
			break;

		case 'L':
			setCol(getCol() - 1);
			break;

		case 'R':
			setCol(getCol() + 1);
			break;

		default:
			break;
		}

	}

	public float fight(Base enemy) {
		float damage = 0;
		damage += (Math.round(abilityOne(enemy) * raceModifiersOne(enemy)) + Math.round(abilityTwo(enemy) * raceModifiersTwo(enemy)));
		System.out.println("Fight " + damage);
		return damage;
	}

	public void applyDot() {
		if (getDotRounds() == 0) {
			setDot(0);
			setMoves(true);
			return;
		}
		if (getDotRounds() > 0) {
			setHp(getHp() - Math.round(getDot()));
			System.out.println(getDot() + " " + getDotRounds());
			setDotRounds(getDotRounds() - 1);
		}

	}

	public boolean isAlive() {
		if (getHp() > 0) {
			return true;
		} else {
			return false;
		}
	}

	// apelata la inceputul fiecarei runde
	// if(rounds == 0){
	// dot = 0;
	// moves = true;
	// }else{
	// if(rounds > 0){
	// hp = hp - dot;
	// rounds--;
	// }
	// }

}
