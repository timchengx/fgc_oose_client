package com.oose.chessgame.chinesechessman;

import android.graphics.Bitmap;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;

public class RedSoldier extends ChineseChessMan {
	
	public RedSoldier(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.RED, board);
	}

	public Bitmap getIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}

	public Bitmap getSelectedIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
	}
	@Override
	public boolean move(int x, int y) {
		inBoardMoveChess(x, y);
		return true;
//		if(currentX == x && currentX >= 5) {
//			if(Math.abs(currentY-y) == 1 ) { 
//				return true;
//			}
//		}
//		else if (currentY == y){  
//			if(currentX < x) {
//				if((currentX + 1) == x) {
//					return true;	
//				}
//			}
//		}
//		return false;
	}
	@Override
	public boolean eat(int x, int y) {
		inBoardMoveChess(x, y);
		return true;
//		if(moveValid(x, y) == true){
//			return true;			
//		}else{
//			return false;
//		}
	}

}
