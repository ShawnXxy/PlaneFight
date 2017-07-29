package play;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.rupeng.game.GameCore;

public class Game implements Runnable {
	
	private GameSprite hero;
	
	void fireBullet() {
		GameSprite bullet = new GameSprite("Bullet");
		bullet.playAnimate("fly");
		Point heroPosition = hero.getPosition();
		bullet.setPosition(heroPosition.x, heroPosition.y);
		while (!bullet.isTopEdge()) {
			bullet.moveUp();
			GameCore.pause(1);
		}
		bullet.remove();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		// game window
		GameCore.setGameSize(338, 600);
		GameCore.loadBgView("background.png");
		
		// generate plane
		this.hero = new GameSprite("HeroPlane");
		hero.setPosition(150, 430);
		hero.playAnimate("normal");
		
		GameCore.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					fireBullet();
				}
			}
		});
		
		// move action
		while (true) {
			int keycode = GameCore.getPressedKeyCode();
			if (keycode == KeyEvent.VK_LEFT || keycode == KeyEvent.VK_A && !hero.isLeftEdge()) {
				hero.moveLeft();
			}
			if (keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_D && !hero.isRightEdge()) {
				hero.moveRight();
			}
			if (keycode == KeyEvent.VK_UP || keycode == KeyEvent.VK_W && !hero.isTopEdge()) {
				hero.moveUp();
			}
			if (keycode == KeyEvent.VK_DOWN || keycode == KeyEvent.VK_S && !hero.isBottomEdge()) {
				hero.moveDown();
			}
			GameCore.pause(1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new Game());
	}

}
