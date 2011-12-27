package GameControls;

import Utilities.SoundUtilities;
import java.awt.Color;

import javax.swing.JFrame;

public class Main {
	public static void main(String args[]){
		GameControl game = new GameControl();
		Thread gameThread = new Thread(game);
		gameThread.start();
		JFrame gameFrame = new JFrame();
		gameFrame.setIgnoreRepaint(true);
		GameScreen gameScreen = new GameScreen();
                SoundUtilities gameSound = new SoundUtilities();
		Thread gameScreenThread = new Thread(gameScreen);
		gameScreenThread.start();
		gameFrame.setBounds(20, 20, 1200, 800);
		gameFrame.add(gameScreen);
		UserInput ui = new UserInput();
		gameFrame.addKeyListener(ui);
		gameFrame.addMouseListener(ui);
		gameScreen.setBackground(Color.WHITE);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setResizable(false);
		gameFrame.setVisible(true);
                
	}
}
