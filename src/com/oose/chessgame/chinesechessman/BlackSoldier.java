package com.oose.chessgame.chinesechessman;

import android.graphics.Bitmap;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;

public class BlackSoldier extends ChineseChessMan {

	private static final long serialVersionUID = -7365495055614093258L;
	public BlackSoldier(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.BLACK, board);
	}
	
	public BlackSoldier(BlackSoldier bs) {
		super(bs);
	}
	
	@Override
	public BlackSoldier clone() throws CloneNotSupportedException {
		return new BlackSoldier(this);
	}
	
	public Bitmap getIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}

	
	public Bitmap getSelectedIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
	}
	@Override
	public boolean move(int x, int y) { 
		if(currentY == x && currentY <= 4) {
			if(Math.abs(currentX-x) == 1 ) { 
				inBoardMoveChess(x, y);
				return true;
			}
		}
		else if (currentX == x){  
			if(currentY > y) {
				if((currentY - 1) == y) {
				inBoardMoveChess(x, y);
				 return true;
				}
			}
		}
		return true;
	}
	@Override
	public boolean eat(int x, int y) {
		return move(x, y);
	}

}
