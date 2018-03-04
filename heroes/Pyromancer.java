package heroes;



public class Pyromancer extends Base {
	public Pyromancer() {
		setHp(500);
		setMaxHp(500);
		setHeroType("P");
	}
	@Override
	public float abilityOne(Base enemy) {//fireblast
		// TODO Auto-generated method stub
		float damage = 350 + 50 * getLevel();
		if(this.getMap().getLand(this.getRow(), this.getCol()) == 'V'){
			damage = Math.round(1.25f * damage);
		}
		
		return damage;
	}
	@Override
	public float abilityTwo(Base enemy) {//ignite
		// TODO Auto-generated method stub
		float damage = 150 + 20 * getLevel();
		float dotDamage = 50 + 30 * getLevel();
		if(this.getMap().getLand(this.getRow(), this.getCol()) == 'V'){
			damage = Math.round(1.25f * damage);
			dotDamage = Math.round(1.25f * dotDamage);
		}
		dot(2, dotDamage, true, enemy);
		System.out.println(enemy.getDot() + "  " + enemy.getDotRounds());
		return damage;
	}
	
	@Override
	public void increaseMaxHp() {
		// TODO Auto-generated method stub
		setMaxHp(500 + 50 * getLevel());
		setHp(getMaxHp());
	}
}
