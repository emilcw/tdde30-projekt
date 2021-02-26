package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.graphic;

import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.Board;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.Controller;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.OurMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class controls the GUI in our game. We handle different panels, buttons and labels here.
 *
 */

public class TowerDefenceViewer {

    private JFrame frame;
    private JLabel healthLabel;
    private JLabel moneyLabel;
    private JLabel waveLabel;

    public TowerDefenceViewer(Board brd, Controller cont) {

        //Creating the frame
        frame = new JFrame("BasicTower Defence");
	TowerDefenceComponent comp = new TowerDefenceComponent(brd, cont);
	brd.addBoardListener(comp);
     	frame.setLayout(new BorderLayout());
     	frame.add(comp,BorderLayout.CENTER);
     	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
	frame.setLocationRelativeTo(null);
        frame.setVisible(true);

	//Creating the menu
        JPanel mainPanel = new JPanel(new BorderLayout());
	frame.add(mainPanel,BorderLayout.EAST);

	//Creating the button and label panels
	JPanel panel1 = new JPanel();
	panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
	JPanel panel2 = new JPanel();
	panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
	JPanel panel3 = new JPanel();
	panel3.setLayout(new BorderLayout());

	mainPanel.add(panel1,BorderLayout.WEST);
	mainPanel.add(panel2,BorderLayout.EAST);
	mainPanel.add(panel3,BorderLayout.SOUTH);

	//Creating different labels
	healthLabel = new JLabel();
	panel1.add(healthLabel);
	moneyLabel = new JLabel();
	panel2.add(moneyLabel);
	waveLabel = new JLabel();
	panel3.add(waveLabel,BorderLayout.NORTH);

	//Creating differnt buttons
        JButton basicButton = new JButton("Basic Tower");
        //basicButton.setSize(100,100);
	basicButton.setVisible(true);
        panel2.add(basicButton);

        JButton nextWaveButton = new JButton("Next Wave");
        nextWaveButton.setVisible(true);
        panel3.add(nextWaveButton);

	JButton sellButton = new JButton("Sell Tower");
	//sellButton.setSize(100,100);
	sellButton.setVisible(true);
	panel1.add(sellButton);

	//Creating MouseListener
	OurMouseListener mml = new OurMouseListener(cont, brd , this);
	frame.addMouseListener(mml);


    	//Creating different ActionListeners to our buttons
	basicButton.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
		mml.setButtonClicked(se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.graphic.Button.BASICTOWER);
	    }
	});


	sellButton.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
		mml.setButtonClicked(Button.SELLTOWER);
	    }
	});


	nextWaveButton.addActionListener(new ActionListener () {
	   @Override
	   public void actionPerformed(ActionEvent e){
	       if((brd.getWaveNr() != 10) && (!brd.isWaveActive())){
		   brd.startWave();
	       }
	   }
	});
    }

    public JFrame getFrame() { return frame; }

    public void setHealthLabel(String health) {
	this.healthLabel.setText("Health " + health);
    }

    public void setMoneyLabel(String money) {
	this.moneyLabel.setText("Money: " + money);
    }

    public void setWaveLabel(String wave) {
   	this.waveLabel.setText("Wave " + wave);
       }

}
