package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence;

import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.graphic.Button;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.graphic.TowerDefenceViewer;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.towers.BasicTower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Here we handle the different events that can occur to our mouse. For example we detect if we click any
 * buttons and make the corresponding event happen.
 *
 *
 */

public class OurMouseListener extends MouseAdapter
{

    private static final int SQUARE_MULTIPLIER = 41;
    private static final int WINDOW_BORDER = 30;

    private Controller cont;
    private Board board;
    private TowerDefenceViewer viewer;
    private se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.graphic.Button
	    buttonClicked = se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.graphic.Button.NOBUTTON;
    private int boardHeight, boardWidth;


    public OurMouseListener(final Controller cont, final Board board, final TowerDefenceViewer viewer) {
	this.cont = cont;
	this.board = board;
	this.viewer = viewer;
	boardHeight = board.getHeight() * SQUARE_MULTIPLIER;
	boardWidth = board.getWidth() * SQUARE_MULTIPLIER + WINDOW_BORDER;

    }


    @Override
/*
  Whenever the mousebutton is clicked we check what it clicked on (in mouseEvent) if the game is "not over", if build/sell
  tower was clicked the mouse is in that mode until a different button (ingame) is clicked or you rightclick.
 */
    public void mouseClicked(MouseEvent e) {

	if (SwingUtilities.isLeftMouseButton(e)) {

	    int pointerX = MouseInfo.getPointerInfo().getLocation().x - viewer.getFrame().getLocationOnScreen().x;
	    int pointerY = MouseInfo.getPointerInfo().getLocation().y - viewer.getFrame().getLocationOnScreen().y;

	    if ((pointerX > 0 && pointerX < boardWidth) && (pointerY > WINDOW_BORDER && pointerY < boardHeight)) {

		int boardX = pointerX / SQUARE_MULTIPLIER;
		int boardY = (pointerY - WINDOW_BORDER) / SQUARE_MULTIPLIER;
		BlockType block = (board.getBlockType(boardX, boardY));

		if(!board.isGameOver() && block.canPlaceTower() && !board.isWaveActive())

			    switch (buttonClicked) {

				case BASICTOWER:

				    if (BasicTower.getBASICCOST() <= board.getMoney() && !cont.towerAtCoord(boardX, boardY)) {
					    board.addMoney(-BasicTower.getBASICCOST());
					    cont.makeTower(boardX, boardY);
				    } else {
					    System.out.println("Not enough money or you have already placed a tower there");
				    }
				    break;

				case SELLTOWER:

				    if(cont.towerAtCoord(boardX,boardY)) {
					board.addMoney(BasicTower.getBASICCOST());
					cont.removeTowerAt(boardX, boardY);
				    }
				    break;

				default:
				    break;

			    }
			}

	    	} else if (SwingUtilities.isRightMouseButton(e)) {
			    buttonClicked = se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.graphic.Button.NOBUTTON;
	}
    }


    public void setButtonClicked(final Button buttonClicked) {
  	this.buttonClicked = buttonClicked;
      }


}

