package heroes;



public class Knight extends Base {

	public Knight() {
		setHp(900);
		setMaxHp(900);
		setHeroType("K");	
	}
	
	public float abilityOne(Base enemy){ //execute
		float damage = 0;
		if(enemy.getHp() <= Math.min(((20 + getLevel()) * 0.01f) * enemy.getMaxHp(),
		  (0.4f * enemy.getMaxHp()))){
			damage = enemy.getHp();
		}else{
			damage = 200 + 30 * getLevel();
		}
		if(this.getMap().getLand(this.getRow(), this.getCol()) == 'L'){
			damage = 1.5f * damage;
		}
		return damage;
	
		
	}
	
	public float abilityTwo(Base enemy){ //slam
		float damage = 100 + 40 * getLevel();
		if(this.getMap().getLand(this.getRow(), this.getCol()) == 'L'){
			damage = 1.5f * damage;
		}
		stun(1, enemy);
		return damage;
	}
	
	
	@Override
	public void increaseMaxHp() {
		// TODO Auto-generated method stub
		
		setMaxHp(900 + 80 * getLevel());
		setHp(getMaxHp());
	}
	
}
