package com.oose.chinesechess;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

import com.oose.prototype.ChessGame;
import com.oose.prototype.ChessMan;

public class ChineseChessGame extends ChessGame {
	//protected ChineseChessBoard board;
	private ChessMan selectedChess;
	private boolean isSelected;

	public ChineseChessGame(String one, String two, Bitmap pOne, Bitmap pTwo,
			int fallback) {
		board = new ChineseChessBoard();
		status = new ChineseChessGameState(one, two, pOne, pTwo, fallback);
		coord = new ChineseChessCoordinate();
		selectedChess = null;
		isSelected = false;
	}
	
	@Override
	public void save() {
	}
	
	private void cleanSelected() {
		selectedChess = null;
		isSelected = false;
	}
	
	@Override
	public void refreshBoard(Canvas c) {
		if(board.getBackGround() != null)
			c.drawBitmap(board.getBackGround(), 0, 0, null);
		for(ChessMan b : board) {
			if(b == null) continue;
			coord.convertToScreen(b.getX(), b.getY());
			if(b == selectedChess)
				c.drawBitmap(b.getSelectedIcon(), coord.getX(), coord.getY(), null);
			else
				c.drawBitmap(b.getIcon(), coord.getX(), coord.getY(), null);
		}
	}

	@Override
	public boolean select(int x, int y) {
		coord.convertToBoard(x, y);
		
		Log.d("timcheng",new String("select enter Who's turn "+status.whosTurn()));
		Log.d("timcheng", coord.getX()+" "+ coord.getY());
		
		if(!isSelected) {
			if(board.hasChess(coord.getX(), coord.getY())) {
				
				selectedChess = board.getChess(coord.getX(), coord.getY());
				
				if(selectedChess.getBelong() == status.whosTurn())	//Log.d("timcheng", "hasSelectChess!");
					isSelected = true;
				else
					selectedChess = null;
			}
		} else {
			boolean moveResult = false;
			board.copy();
			if(board.hasChess(coord.getX(), coord.getY())) {
				if(board.getChess(coord.getX(), coord.getY()) == selectedChess) //Log.d("timcheng","same chess.");
					cleanSelected();
				else
					moveResult = eat(coord.getX(), coord.getY());
			} else {
				moveResult = move(coord.getX(), coord.getY());
			}
			
			if(moveResult) {//Log.d("timcheng", "change to " +status.whosTurn());
				status.changeTurn();
				board.savePreviousBoard();
			}
		}
		return true;
	}
	
	@Override
	protected boolean eat(int x, int y) {
		boolean result = false;
		Log.d("timcheng", "eat.");
		if(selectedChess.getBelong() != board.getChess(x, y).getBelong() && selectedChess.eat(x, y)) {
			//board.removeChess(selectedChess.getX(), selectedChess.getY());
			//board.setBoard(x, y, selectedChess);
			//selectedChess.setXY(x, y);
			result = true;
		} else {
			Log.d("timcheng", "want to eat your own buddy?");
			result = false;
		}
		cleanSelected();
		return result;
	}

	@Override
	protected boolean move(int x, int y) {
		boolean result = false;
		if(x < 9 && x >= 0 && y < 10 && y >= 0 && selectedChess.move(x, y)) {
			//board.removeChess(selectedChess.getX(),selectedChess.getY());
			//board.setBoard(x, y, selectedChess);
			//selectedChess.setXY(x, y);
			Log.d("timcheng", "moveok!");
			result = true;
		} else {
			Log.d("timcheng", "no move");
			result = false;
		}
		cleanSelected();
		return result;
	}
	
}
