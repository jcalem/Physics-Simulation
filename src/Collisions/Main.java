package Collisions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JPanel implements Runnable, KeyListener, MouseWheelListener {

	private static final String title = "End of Year Project";
	public static final double WIDTH = 1280;
	public static final double HEIGHT = 720;
	public static final double SCALE = Math.sqrt(3) / 2;

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setSize((int)WIDTH, (int)HEIGHT);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.add(new Main(), BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(title);
		frame.setVisible(true);
	}

	private boolean isRunning = false;
	private Thread thread;

	private boolean movingRight = false;
	private boolean movingLeft = false;
	private boolean movingUp = false;
	private boolean movingDown = false;


	public Main() {

		setFocusable(true);
		start();
	}

	public void start() {

		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	public void run() {

		long start, elapsed, wait;
		while (isRunning) {
			start = System.nanoTime();
			tick();
			repaint();

			elapsed = System.nanoTime() - start;
			wait = (100 / 6) - elapsed / 1000000;
			if (wait <= 0)
				wait = 5;;
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void tick() {

	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, (int)WIDTH, (int)HEIGHT);
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
	}
}