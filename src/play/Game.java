package play;

import com.rupeng.game.GameCore;

public class Game implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		GameCore.setGameSize(338, 600);
		GameCore.loadBgView("background.png");
		while (true) {
			GameSprite hero = new GameSprite("HeroPlane");
			GameCore.pause(10);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new Game());
	}

}
