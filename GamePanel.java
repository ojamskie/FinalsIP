package game;


import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel<Graphics2D> extends JPanel implements Runnable, KeyListener {

	public static final int WIDTH = 400;
	public static final int HEIGHT = 400; 
	
	
	private Graphics2D g2d;
	
	
	private Thread thread;
	private boolean running;
	private long targetTime;
	public GamePanel(){
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
	}
	public void addNotify(){
		super.addNotify();
		thread = new Thread(this);
		thread.start();
	}
	private void setFPS(int fps){
		targetTime = 100/ fps;
	}
	
	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

	public void run() {
		if(running) return;
		init();
		long startTime;
		long elapsed;
		long wait;
		while(running){
			startTime = System.nanoTime();
			
			update();
			requestRender();
			
			elapsed = System.nanoTime() - startTime;
			wait  = targetTime - elapsed / 1000000;
			if(wait > 0){
				try{
					thread.sleep(wait);
				}catch(Exception e){
					e.printStackTrace();
					
				}
			}
		}
	}
	private void init(){
		running = true;
		setFPS(10);
	}
	private void update() {
		
		
	}
	private void requestRender() {
		
		
	}
	public <Graphics2D> void render(Graphics2D g2d){
	}
	
}
