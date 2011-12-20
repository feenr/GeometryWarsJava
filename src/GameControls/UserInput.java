package GameControls;

import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UserInput implements KeyListener, MouseListener{
	public static Boolean Up=false, Down=false, Left=false, Right=false, Space=false, Restart=false, Shoot=false, incDiff=false, decDiff=false;
	
	public UserInput(){
		Up=Down=Left=Right=Space=false;
	}
	
    public void keyPressed(KeyEvent e) {
    	if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W){
    		Up = true;
    	}
    	
    	if(e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_S){
    		Down = true;
    	}
    	
    	if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A){
    		Left = true;
    	}
    	
    	if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D){
    		Right = true;
    	}
    	if(e.getKeyCode()==KeyEvent.VK_R){
    		Restart = true;
    	}
    	if(e.getKeyCode()==KeyEvent.VK_Q){
    		GameInfo.difficulty++;
    	}
    	if(e.getKeyCode()==KeyEvent.VK_E){
    		GameInfo.difficulty--;
    	}
    }

    public void keyReleased(KeyEvent e) {
    	if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W){
    		Up = false;
    	}
    	
    	if(e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_S){
    		Down = false;
    	}
    	
    	if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A){
    		Left = false;
    	}
    	
    	if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D){
    		Right = false;
    	}

    	if(e.getKeyCode()==KeyEvent.VK_R){
    		Restart = false;
    	}
    }

	public void keyTyped(KeyEvent arg0) {
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
		Shoot=true;		
	}

	public void mouseReleased(MouseEvent arg0) {
		Shoot=false;
	}
}
