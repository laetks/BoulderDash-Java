package model.entity.motionless;

import model.entity.Permeability;
import model.entity.Sprite;

public class Door extends MotionlessElement {
	
	    /** The Constant SPRITE. */
	    private static final Sprite SPRITE = new Sprite('D', "Door.png");

	    /**
	     * Instantiates a new obstacle.
	     */
	    Door() {
	        super(SPRITE, Permeability.BLOCKING);
	    }
	}
