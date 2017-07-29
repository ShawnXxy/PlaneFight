package play;

import java.awt.Dimension;

import com.rupeng.game.GameCore;

public abstract class GameRect extends GameObj {
	
	public abstract Dimension getSize();
	
	public boolean isLeftEdge() {
		return getPosition().x <= 0;
	}
	public boolean isRightEdge() {
		Dimension gameSize = GameCore.getGameSize();
		return getPosition().x >= gameSize.width - getSize().width;
	}
	public boolean isTopEdge() {
		return getPosition().y <= 0;
	}
	public boolean isBottomEdge() {
		Dimension gameSize = GameCore.getGameSize();
		return getPosition().y >= gameSize.height - getSize().height;
	}

	/*
	 * Check if two rectangle obj are intersected
	 */
	public boolean isIntersectWith (GameRect rect) {
		
		//if intersect at left: x coordinates of this at left is less than x coordinates of rect at right
		//NOT intersect: this's left side x coordinate is greater then rect's right side x coordinate
		boolean isNotIntersectLeft = this.getPosition().x > rect.getPosition().x + getSize().width;
		
		//if intersect at right: x coordinates of this at right is greater than x coordinates of rect at left
		// NOT intersect: this's right side x coordinate is less than rect's left side x coordinate
		boolean isNotIntersectRight = this.getPosition().x + getSize().width < rect.getPosition().x;
		
		//if intersect at top: y coordinates of this at top is less than y coordinates of rect at bottom
		// NOT intersect: this's top side y coordinate is greater than rect's bottom side y coordinate
		boolean isNotIntersectUp = this.getPosition().y > rect.getPosition().y + getSize().height;
		
		//if intersect at bottom: y coordinates of this at bottom is greater than y coordinates of rect at top
		// NOT intersect: this's bottom side y coordinate is less than rect's top side y coordinate
		boolean isNotIntersectDown = this.getPosition().y + getSize().height < rect.getPosition().y;
		
		return !(isNotIntersectLeft || isNotIntersectRight || isNotIntersectUp || isNotIntersectDown);
	}
	
}
