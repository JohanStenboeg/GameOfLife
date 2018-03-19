/*package HanYo;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;
import java.util.Random;
import javax.swing.JFrame;

    public class GameOfLife extends Canvas implements Runnable {
        private static final long serialVersionUID = 1L;
        public static int frameSize = 360;
        public static String title = "Game Of Life";
        public Random r = new Random();
        public int gridSize = 100;
        public double generationSpeed = 100;
        public BufferedImage image;
        public int[] pixels;
        public boolean[] cGrid;
        public boolean[] pGrid;

        public GameOfLife() {
            Dimension d = new Dimension(frameSize, frameSize);
            this.setMinimumSize(d);
            this.setMaximumSize(d);
            this.setPreferredSize(d);
            this.image = new BufferedImage(this.gridSize, this.gridSize, 1);
            this.pixels = ((DataBufferInt)this.image.getRaster().getDataBuffer()).getData();
        }

        public void start() {
            this.cGrid = new boolean[this.pixels.length];
            this.pGrid = new boolean[this.pixels.length];

            for(int i = 0; i < this.cGrid.length; ++i) {
                this.cGrid[i] = (double)this.r.nextInt(100) / 100.0D > 0.8D;
            }

            (new Thread(this)).start();
        }

        public void run() {
            double frameCut = 1.0E9D / this.generationSpeed;
            long currentTime = System.nanoTime();
            long passedTime = 0L;
            double unprocessedTime = 0.0D;
            long frameCounter = System.currentTimeMillis();
            int generations = 1;

            while(true) {
                long previouseTime = currentTime;
                currentTime = System.nanoTime();
                passedTime = currentTime - previouseTime;
                unprocessedTime += (double)passedTime;
                if (unprocessedTime > frameCut) {
                    unprocessedTime = 0.0D;
                    this.update();
                    ++generations;
                }

                if (System.currentTimeMillis() - frameCounter >= 1000L) {
                    frameCounter = System.currentTimeMillis();
                    System.out.println("Generation : " + generations);
                }

                this.render();
            }
        }

        public void update() {
            int y;
            for(y = 0; y < this.pixels.length; ++y) {
                this.pGrid[y] = this.cGrid[y];
            }

            for(y = 0; y < this.gridSize; ++y) {
                for(int x = 0; x < this.gridSize; ++x) {
                    int res = 0;
                    int xx0 = x - 1;
                    int yy0 = y - 1;
                    int xx1 = x + 1;
                    int yy1 = y + 1;
                    if (x != 0) {
                        res += this.pGrid[xx0 + this.gridSize * y] ? 1 : 0;
                    }

                    if (y != 0) {
                        res += this.pGrid[x + this.gridSize * yy0] ? 1 : 0;
                    }

                    if (x != this.gridSize - 1) {
                        res += this.pGrid[xx1 + this.gridSize * y] ? 1 : 0;
                    }

                    if (y != this.gridSize - 1) {
                        res += this.pGrid[x + this.gridSize * yy1] ? 1 : 0;
                    }

                    if (x != 0 && y != 0) {
                        res += this.pGrid[xx0 + this.gridSize * yy0] ? 1 : 0;
                    }

                    if (x != 0 && y != this.gridSize - 1) {
                        res += this.pGrid[xx0 + this.gridSize * yy1] ? 1 : 0;
                    }

                    if (x != this.gridSize - 1 && y != 0) {
                        res += this.pGrid[xx1 + this.gridSize * yy0] ? 1 : 0;
                    }

                    if (x != this.gridSize - 1 && y != this.gridSize - 1) {
                        res += this.pGrid[xx1 + this.gridSize * yy1] ? 1 : 0;
                    }

                    if (!this.pGrid[x + this.gridSize * y] || res != 3 && res != 2) {
                        this.cGrid[x + this.gridSize * y] = false;
                    }

                    if (!this.pGrid[x + this.gridSize * y] && res == 3) {
                        this.cGrid[x + this.gridSize * y] = true;
                    }
                }
            }

        }

        public void render() {
            BufferStrategy bs = this.getBufferStrategy();
            if (bs == null) {
                this.createBufferStrategy(3);
            } else {
                Graphics g = bs.getDrawGraphics();

                int i;
                for(i = 0; i < this.pixels.length; ++i) {
                    this.pixels[i] = 0;
                }

                for(i = 0; i < this.pixels.length; ++i) {
                    this.pixels[i] = this.cGrid[i] ? 16777215 : 0;
                }

                g.drawImage(this.image, 0, 0, frameSize, frameSize, (ImageObserver)null);
                g.dispose();
                bs.show();
            }
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame();
            frame.setTitle(title);
            frame.setDefaultCloseOperation(3);
            frame.setResizable(false);
            frame.setAlwaysOnTop(true);
            GameOfLife gol = new GameOfLife();
            frame.add(gol);
            frame.pack();
            frame.setLocationRelativeTo((Component)null);
            frame.setVisible(true);
            gol.start();
        }
    }
*/