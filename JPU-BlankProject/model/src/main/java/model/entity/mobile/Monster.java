package model.entity.mobile;

import model.entity.Permeability;
import model.entity.Sprite;

public class Monster extends Mobile{

	    /** The Constant SPRITE. */
	    private static final Sprite SPRITE = new Sprite('X', "MDown.png");

	    /**
	     * Instantiates a new obstacle.
	     */
	    Monster() {
	        super(SPRITE, Permeability.BLOCKING);
	    }
	}


