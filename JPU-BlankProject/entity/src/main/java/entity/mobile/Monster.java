package entity.mobile;

import java.awt.Point;

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

	/**
	 * <p>
	 * Move randomly the monster on the board.
	 * </p>
	 */
	public final void move() {
		

	}
}
