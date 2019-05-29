package model.entity.mobile;

import model.entity.Permeability;
import model.entity.Sprite;

public class Rock extends Mobile {

	 /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('O', "rock.png");

    /**
     * Instantiates a new obstacle.
     */
    Rock() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
