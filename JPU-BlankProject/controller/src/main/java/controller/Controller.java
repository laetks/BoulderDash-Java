package controller;

import java.io.IOException;
import java.util.Random;

import contract.IOrderPerformer;
import contract.IBoulderDashController;
import contract.IModel;
import contract.IView;
import contract.UserOrder;
import entity.Permeability;
import entity.mobile.MobileElementsFactory;
import entity.motionless.MotionlessElementsFactory;

/**
 * The Class Controller.
 */
public final class Controller implements IBoulderDashController, IOrderPerformer {

	/** The Constant speed */
	private static final int speed = 200;

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

	/** The stack order */
	private UserOrder stackOrder;

	Random rand = new Random();
	private int direction;
	
	/**
	 * Instantiates a new controller.
	 *
	 * @param view  the view
	 * @param model the model
	 */

	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
	}

	/**
	 * Order perform.
	 *
	 * @param controllerOrder the controller order
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	@Override
	public final void play() throws InterruptedException {
		while (this.getModel().getMyPlayer().isAlive() == true) {
			Thread.sleep(speed);
			switch (this.getStackOrder()) {
			case UP:
				this.getModel().getMyPlayer().moveUp();
				break;
			case DOWN:
				this.getModel().getMyPlayer().moveDown();
				break;
			case RIGHT:
				this.getModel().getMyPlayer().moveRight();

				break;
			case LEFT:
				this.getModel().getMyPlayer().moveLeft();
				break;
			case NOP:
			default:
				this.getModel().getMyPlayer().doNothing();
				break;
			}

			this.clearStackOrder();
			this.getView().followMyPlayer();

			// ALED SA MARCHE BG
			getView().test1();

			this.moveH();
			
			direction = rand.nextInt(4);
			System.out.println(direction);

		}
	}

	public void moveH() {
		switch (direction) {
		case 0:
			MMoveRight();
			break;
		case 1:
			MMoveLeft();
			break;
		case 2:
			MMoveUp();
			break;
		case 3:
			MMoveDown();
			break;

		default:
			break;
		}

	}

	public void MMoveRight() {
		for (int x = 0; x < this.getModel().getMap().getWidth(); x++) {
			for (int y = 0; y < this.getModel().getMap().getHeight(); y++) {
				if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.KILLING && this
						.getModel().getMap().getOnTheMapXY(x + 1, y).getPermeability() == Permeability.PENETRABLE) {
					this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.getFromFileSymbol('.'), x, y);
					this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.getFromFileSymbol('X', x + 1, y),
							x + 1, y);
					System.out.println("bouge");
				}
			}
		}
	}

	public void MMoveLeft() {
		for (int x = 0; x < this.getModel().getMap().getWidth(); x++) {
			for (int y = 0; y < this.getModel().getMap().getHeight(); y++) {
				if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.KILLING && this
						.getModel().getMap().getOnTheMapXY(x - 1, y).getPermeability() == Permeability.PENETRABLE) {
					this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.getFromFileSymbol('.'), x, y);
					this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.getFromFileSymbol('X', x - 1, y),
							x - 1, y);
					System.out.println("bouge");
				}
			}
		}
	}

	public void MMoveUp() {
		for (int x = 0; x < this.getModel().getMap().getWidth(); x++) {
			for (int y = 0; y < this.getModel().getMap().getHeight(); y++) {
				if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.KILLING && this
						.getModel().getMap().getOnTheMapXY(x, y - 1).getPermeability() == Permeability.PENETRABLE) {
					this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.getFromFileSymbol('.'), x, y);
					this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.getFromFileSymbol('X', x, y - 1), x,
							y - 1);
					System.out.println("bouge");
				}
			}
		}
	}

	public void MMoveDown() {
		for (int x = 0; x < this.getModel().getMap().getWidth(); x++) {
			for (int y = 0; y < this.getModel().getMap().getHeight(); y++) {
				if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.KILLING && this
						.getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability() == Permeability.PENETRABLE) {
					this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.getFromFileSymbol('.'), x, y);
					this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.getFromFileSymbol('X', x, y + 1), x,
							y + 1);
					System.out.println("bouge");
				}
			}
		}
	}

	@Override
	public final void orderPerform(final UserOrder userOrder) throws IOException {
		this.setStackOrder(userOrder);
	}

	private IView getView() {
		return this.view;
	}

	private void setView(final IView view) {
		this.view = view;
	}

	private IModel getModel() {
		return this.model;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}

	private UserOrder getStackOrder() {
		return this.stackOrder;
	}

	private void setStackOrder(final UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	@Override
	public IOrderPerformer getOrderPerformer() {
		return this;
	}

}
