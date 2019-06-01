package entity.mobile;

import java.awt.Point;
import java.io.IOException;

import entity.IMap;
import entity.Permeability;
import entity.Sprite;
import fr.exia.showboard.IPawn;

public class Monster extends Mobile implements IPawn {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('X', "MDown.png");

	private Point position;
	

	
	/** The random. */
	//private final Random random = new Random();
	
	/**
	 * Instantiates a new monster.
	 */
	public Monster() {
		super(SPRITE, Permeability.KILLING);
	}
	
	//AJOUT
	public Monster(final Sprite sprite, final Permeability permeability) {
		super(sprite, permeability);
		this.position = new Point();
	}
	
	//AJOUT
	public Monster(int x, int y) {
		this(SPRITE, Permeability.KILLING);
		this.setX(x);
		this.setY(y);

	}
	

	@Override
	public final void moveRight() {
		super.moveRight();
		this.setSprite(SPRITE);
	}
	public final void moveDown() {
		super.moveDown();
		this.setSprite(SPRITE);
	}
	public final void moveUp() {
		super.moveUp();
		this.setSprite(SPRITE);
	}
	

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.showboard.IPawn#getX()
	 */
	@Override
	public final int getX() {
		return this.getPosition().x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.showboard.IPawn#getY()
	 */
	@Override
	public final int getY() {
		return this.getPosition().y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.showboard.IPawn#getPosition()
	 */
	@Override
	public final Point getPosition() {
		return this.position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the position to set
	 */
	public final void setPosition(final Point position) {
		this.position = position;
	}

	/**
	 * Sets the position.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public final void setPosition(final int x, final int y) {
		this.position = new Point(x, y);
	}

	
}
