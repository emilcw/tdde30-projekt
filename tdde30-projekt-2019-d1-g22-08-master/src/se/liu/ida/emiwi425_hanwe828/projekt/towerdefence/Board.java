package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence;


import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.graphic.TowerDefenceViewer;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.mobs.MobType;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is both our game board and the game itself, housing both our tick method and important fields like health and
 * money in addition to information about the board.
 *
 */

public class Board {


    private static final double MIDDLE = 0.5;
    private static final int STARTMONEY = 300;
    private static final int SPAWNTIME_CONSTANT = 200;
    private static final int ENDWAVE = 10;
    private static final int WAVE_BONUS = 50;


    private int width;
    private int height;
    private int playerHealth;
    private int spawnTime;
    private int money;
    private int spawnX,spawnY;
    private int waveNr;
    private boolean gameOver;
    private boolean waveActive;
    private List<BoardListener> listeners;
    private List<MobType> currentWave;
    private BlockType[][] blocks;
    private Controller controller;
    private TowerDefenceViewer viewer;		//To create a TowerDefenceViewer we need a board, thus we set the viewer afterwards.


    public Board(BlockType[][] towerDefenceMap, Controller controller) {
	playerHealth = 10;
	this.controller = controller;
	width = towerDefenceMap.length;
	height = towerDefenceMap[0].length;
	blocks = new BlockType[width][height];
	spawnTime = 0;
	money = STARTMONEY;
	gameOver = false;
	waveActive = false;
	waveNr = 0;
	currentWave = new ArrayList<>();
	listeners = new ArrayList<>();


	for (int w = 0; w < width; w++) {
	    for (int h = 0; h < height; h++) {
		blocks[w][h] = towerDefenceMap[w][h];
		if (blocks[w][h] == BlockType.SPAWN){
		    spawnX = w;
		    spawnY = h;
		}
	    }
	}
    }


    public void takeDamage(int damage) {
	if (playerHealth > 0) {
	    playerHealth -= damage;
	}
    }


    public void addBoardListener(BoardListener bl) {
	listeners.add(bl);

    }


    private void notifyListeners() {
	for (BoardListener boardlistener : listeners) {
	    boardlistener.boardChanged();
	}
    }

// Komplettering:
    // Tog bort middleDistance och skrev om så att withinDistance använder Point2D.
    public boolean withinDistance(double x1, double y1, double x2, double y2, double acceptableDistance) {
	return Point2D.distance(x1 + MIDDLE,y1 + MIDDLE,x2 + MIDDLE,y2 + MIDDLE) <= acceptableDistance;
    }

    public void updateHealth(){
	String health = Integer.toString(playerHealth);
	viewer.setHealthLabel(health);

    }

    public void updateMoney(){
	String cash = Integer.toString(money);
	viewer.setMoneyLabel(cash);

    }

    public void updateWave(){
	String wave = Integer.toString(waveNr);
	viewer.setWaveLabel(wave);
    }

    public void startWave(){
	waveActive = true;
	waveNr ++;
	currentWave = WaveManager.getWave(waveNr);
    }


    public void tick() {

	if(!gameOver) {

	    controller.updateMobs();
	    controller.updateTowers();
	    updateHealth();
	    updateMoney();
	    updateWave();

	    if (waveActive &&(spawnTime < 1)) {
		controller.spawnWave(currentWave);
		spawnTime = SPAWNTIME_CONSTANT;
	    } else spawnTime--;

	    if (playerHealth <= 0 ) {
		System.out.println("Game Over");
		gameOver = true;
	    }
	    if (currentWave.isEmpty() && (controller.getMobListLen() == 0) && waveActive){
		waveActive = false;
		addMoney(WAVE_BONUS);


	    }
	    if((waveNr == ENDWAVE) && !waveActive ){
		gameOver = true;
		System.out.println("You Win!");
	    }
	}
	this.notifyListeners();
    }


    public boolean isGameOver() { return gameOver; }

    public boolean isWaveActive() { return waveActive; }

    public int getSpawnX() { return spawnX; }

    public int getSpawnY() { return spawnY; }

    public int getMoney() { return money; }

    public void addMoney(final int money) { this.money += money; }

    public void setViewer(final TowerDefenceViewer viewer) { this.viewer = viewer; }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public BlockType getBlockType(int width, int height) { return blocks[width][height]; }

    public int getWaveNr() { return waveNr; }
}
