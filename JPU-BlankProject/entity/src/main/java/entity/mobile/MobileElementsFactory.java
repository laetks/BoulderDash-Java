package entity.mobile;

public class MobileElementsFactory {

	private final static Monster monster = new Monster();
	private final static Diamond diamond = new Diamond();
	private final static Rock rock = new Rock();

	private static Mobile[] mobileElements = { monster, diamond, rock };

	public static Mobile getFromFileSymbol(final char fileSymbol, int x, int y) {
		for (final Mobile mobileElement : mobileElements) {
			if (monster.getSprite().getConsoleImage() == fileSymbol) {
				//AJOUT\\
				createMonster(x, y); 
				
			
			} else if (mobileElement.getSprite().getConsoleImage() == fileSymbol && monster.getSprite().getConsoleImage() != fileSymbol){
				return mobileElement;
			}
		}
		return monster;
	}

	public static Mobile createMonster(int x, int y) {
		//AJOUT\\
		final Monster monster = new Monster(x,y);
	
		return monster;
	}

	public static Mobile createDiamond() {
		return diamond;
	}

	public static Mobile createObstacle() {
		return rock;
	}

}
