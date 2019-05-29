package model.entity.motionless;

import model.entity.Permeability;
import model.entity.Sprite;

public class Background extends MotionlessElement{
	
	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('.', "Background.png");

    /**
     * Instantiates a new macadam.
     */
    Background() {
        super(SPRITE, Permeability.PENETRABLE);
    }

}
