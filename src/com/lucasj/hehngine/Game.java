package com.lucasj.hehngine;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyboardFocusManager;
import java.awt.image.BufferStrategy;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JFrame;

import com.lucasj.hehngine.input.InputManager;
import com.lucasj.hehngine.ui.rendering.Camera;
import com.lucasj.hehngine.ui.rendering.Render;

public abstract class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = -171090556192089278L;

    public boolean isRunning = false;
	
	private Thread gameThread;
    private boolean running = false;
    
    private JFrame frame;
    
    private int fpslimit = 165;

    private Camera camera;
    private InputManager input;
    
    public Game(String title, int width, int height) {
    	frame = new JFrame(title);
        Dimension size = new Dimension(width, height);
        setPreferredSize(size);
        
        frame.add(this);
        
        frame.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.emptySet());
        
        frame.pack();
        frame.setMinimumSize(new Dimension(1920, 1080));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        this.camera = new Camera(this);
        this.input = new InputManager(this);
        frame.addMouseListener(input);
        frame.addKeyListener(input);
        frame.addMouseWheelListener(input);
        frame.addMouseMotionListener(input);
        
    }
    
    public synchronized void start() {
        if (running) return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public synchronized void stop() {
        if (!running) return;
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        isRunning = true;
        double timePerFrame = 1000000000 / fpslimit;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        
        int frames = 0;
        long lastCheck = System.currentTimeMillis();
        
        while (true ) {
            timePerFrame = 1000000000 / fpslimit;
        	
        	now = System.nanoTime();
    		double deltaTime = (now - lastFrame) / 1_000_000_000.0;
        	if (now - lastFrame >= timePerFrame) {
        		
        		update(deltaTime);
        		render();
        		
        		lastFrame = now;
        		frames++;
        		
        	}
        	
        	if (System.currentTimeMillis() - lastCheck >= 1000) {
        		lastCheck = System.currentTimeMillis();
        		frame.setTitle(Integer.toString(frames));
        		frames = 0;
        	}
        	
        }
    }

    public abstract void update(double deltaTime);
    public abstract List<Render> addRender();

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);  // Triple buffering
            return;
        }

        Graphics g = bs.getDrawGraphics();
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));

        // 1. Draw the gray background
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        
        List<Render> renders = addRender();
        
        renders.sort(Comparator.comparingInt(Render::getLayer).reversed());
        
        for(Render render : renders) {
        	render.render(g);
        }
        
        g.dispose();
        bs.show();

    }

	public int getFpslimit() {
		return fpslimit;
	}

	public void setFpslimit(int fpslimit) {
		this.fpslimit = fpslimit;
	}

	public Camera getCamera() {
		return camera;
	}

	public InputManager getInput() {
		return input;
	}
}
