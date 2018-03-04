package heroes;



public class Rogue extends Base {
	int c = 0;
	public Rogue() {
		setHp(600);
		setMaxHp(600);
		setHeroType("R");
	}
	
	@Override
	public float abilityOne(Base enemy) {//backstab
		// TODO Auto-generated method stub
		float damage = 200 + 20 * getLevel();
		if(this.c % 3 == 0){
			if(this.getMap().getLand(this.getRow(), this.getCol()) == 'W'){
				damage = 1.5f * damage;
			}
		}
		this.c++;
		if(this.getMap().getLand(this.getRow(), this.getCol()) == 'W'){
			damage = 1.5f * damage;
		}
		System.out.println("Backstab " + damage);
		return damage;
	}
	
	@Override
	public float abilityTwo(Base enemy) {//paralysis
		// TODO Auto-generated method stub
		//TODO STUN + DOT
		float damage = 40 + 10 * getLevel();
		int rounds = 3;
		if(this.getMap().getLand(this.getRow(), this.getCol()) == 'W'){
			damage = 1.5f * damage;
			System.out.println("Damage crit: " + damage);
			rounds = 6;
		}
		float dotDamage = damage;
		dot(rounds, dotDamage, false, enemy);
		System.out.println("Paralasys " + damage + " Dot Damage Paralasys " + dotDamage);
		return damage;
	}
	
	@Override
	public void increaseMaxHp() {
		// TODO Auto-generated method stub
		setMaxHp(900 + 80 * getLevel());
		setHp(getMaxHp());
	}
}
