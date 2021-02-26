package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence;

import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.graphic.TowerDefenceViewer;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.maps.TowerDefenceMapMaker;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * This is our "main-loop". By running the main method the game will start.
 */

//No need for a constructor since we do not create an instance of the class
public final class TowerDefenceStart {

    private static final int DELAY = 2;
    private static final int MAP_NR = 2;

    private TowerDefenceStart() {}

    public static void main(String[] args) {

	TowerDefenceMapMaker maker= new TowerDefenceMapMaker();
	BlockType[][] towerDefenceMap = maker.mapSelector(MAP_NR);
	Controller controller = new Controller();
	Board board = new Board(towerDefenceMap, controller);
	controller.setBoard(board);
	controller.setSpawn();
	TowerDefenceViewer viewer = new TowerDefenceViewer(board, controller);
	board.setViewer(viewer);

	final Action doOneStep = new AbstractAction() {
	    //ActionListener doOneStep  = new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		    board.tick();

	    }
	};

	final Timer clockTimer = new Timer(DELAY, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();

    }
}
