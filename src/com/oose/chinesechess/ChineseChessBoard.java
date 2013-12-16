package com.oose.chinesechess;

import java.util.Iterator;

import android.graphics.Bitmap;
import android.util.Log;

import com.oose.factory.ChineseChessBoardFactory;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessBoard;
import com.oose.prototype.ChessMan;

public class ChineseChessBoard extends ChessBoard {
	public ChineseChessBoard() {
		super(9, 10);
		this.nowBoard = ChineseChessBoardFactory.makeNewChineseChessBoard(this);
	}

	@Override
	public Iterator<ChessMan> iterator() {
		return new ChessIterator();
	}

	private class ChessIterator implements Iterator<ChessMan> {
		private final int totalX = 9;
		private final int totalY = 10;
		private int X = 0;
		private int Y = 0;

		@Override
		public boolean hasNext() {
			if (X < totalX) {
				return true;
			} else if (Y < totalY - 1) {
				X = 0;
				Y++;
				return true;
			}
			return false;
		}

		@Override
		public ChessMan next() {
			ChessMan currentChess = nowBoard[X][Y];
			if (X < totalX)
				X++;
			return currentChess;
		}

		@Override
		public void remove() {
		}

	}

	public Bitmap getBackGround() {
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}
	public void copy() {
		Log.d("timcheng", "start copy.");
		snapshot = new ChineseChessMan[boardXSize][boardYSize];
		for(int i = 0; i < boardXSize; i++)
			for(int j = 0; j < boardYSize; j++) {
				if(snapshot[i][j] == null) continue;
				Log.d("timcheng", snapshot[i][j].getClass().getName());
				snapshot[i][j] = new ChineseChessMan((ChineseChessMan)nowBoard[i][j]);
			}
	}
}
