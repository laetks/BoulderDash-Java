package model.entity.motionless;

import model.entity.Permeability;
import model.entity.Sprite;

public class Ground extends MotionlessElement{
	 /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ', "Door.png");

    /**
     * Instantiates a new obstacle.
     */
    Ground() {
        super(SPRITE, Permeability.PENETRABLE);
    }

}
