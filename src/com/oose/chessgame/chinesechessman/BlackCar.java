/*******************************************************************************
 * Copyright (c) 2013 AUTHORS.txt
 * All rights reserved. Distributed under the terms of the MIT License.
 ******************************************************************************/
package com.oose.chessgame.chinesechessman;

import android.graphics.Bitmap;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;

public class BlackCar extends ChineseChessMan {

  private static final long serialVersionUID = 2267427798908938020L;

  public BlackCar(int x, int y, ChineseChessBoard board) {
    super(x, y, ChessMan.BLACK, board);
  }

  public BlackCar(BlackCar bc) {
    super(bc);
  }

  @Override
  public BlackCar clone() throws CloneNotSupportedException {
    return new BlackCar(this);
  }

  public Bitmap getIcon() {
    return ChineseChessPictureList.getIcon(this.getClass().getName());
  }


  public Bitmap getSelectedIcon() {
    return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
  }

  public boolean move(int x, int y) {
    if (currentX == x) {
      if (currentY < y) {
        for (int nowY = currentY + 1; nowY < y; nowY++) {
          if (board.hasChess(x, nowY)) {
            return false;
          }
        }
      } else {
        for (int nowY = currentY - 1; nowY > y; nowY--) {
          if (nowY >= board.getBoardYSize())
            continue;
          // this != getChess, boundry check
          if (board.hasChess(x, nowY)) {
            return false;
          }
        }
      }
      inBoardMoveChess(x, y);
      return true;
    } else if (currentY == y) {
      if (currentX < x) {
        for (int nowX = currentX + 1; nowX < x; nowX++) {
          if (board.hasChess(nowX, y)) {
            return false;
          }
        }
      } else {
        for (int nowX = currentX - 1; nowX > x; nowX--) {
          if (nowX >= board.getBoardXSize())
            continue;
          if (board.hasChess(nowX, y)) {
            return false;
          }
        }
      }
      inBoardMoveChess(x, y);
      return true;
    }
    return false;

  }

  public boolean eat(int x, int y) {
    return move(x, y);
  }
}
