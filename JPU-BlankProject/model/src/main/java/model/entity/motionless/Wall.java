package model.entity.motionless;

import model.entity.Permeability;
import model.entity.Sprite;

class Wall extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('#', "wall.png");

    /**
     * Instantiates a new ditchLeft.
     */
    Wall() {
        super(SPRITE, Permeability.BLOCKING);
    }
}