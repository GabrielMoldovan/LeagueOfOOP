package heroes;



public class Wizard extends Base {
	public Wizard() {
		setHp(400);
		setMaxHp(400);
		setHeroType("W");
	}
	
	@Override
	public float abilityOne(Base enemy) {//drain
		// TODO Auto-generated method stub
		float procent = 0.2f + 0.05f * getLevel();
		float damage = Math.round(procent * Math.round(Math.min(0.3f * enemy.getMaxHp(), enemy.getHp())));
		if(this.getMap().getLand(this.getRow(), this.getCol()) == 'D'){
			damage = Math.round(1.1f * damage);
		}
		System.out.println("Drain " + damage);
		return damage;
	}
	
	@Override
	public float abilityTwo(Base enemy) {//deflect
		// TODO Auto-generated method stub
		float damage;
		if(enemy.getHeroType() == "W"){
			damage = 0;
		}else{
			float procent = Math.min(0.35f + 0.02f * getLevel(), 0.7f);
			damage = Math.round(procent * (enemy.abilityOne(this) +
						   enemy.abilityTwo(this)));
			if(this.getMap().getLand(this.getRow(), this.getCol()) == 'D'){
				damage = Math.round(1.1f * damage);
			}
		}
		System.out.println(enemy.abilityOne(this) + " " + enemy.abilityTwo(this));
		System.out.println("Deflect " + damage);
		return damage;
	}
	
	@Override
	public void increaseMaxHp() {
		// TODO Auto-generated method stub
		setMaxHp(400 + 30 * getLevel());
		setHp(getMaxHp());
	}
	
}
