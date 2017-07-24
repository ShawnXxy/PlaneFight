package play;

import com.rupeng.game.GameCore;

public class Game implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new Game());
	}

}
