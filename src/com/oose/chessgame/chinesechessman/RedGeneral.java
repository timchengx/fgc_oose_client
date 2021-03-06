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

public class RedGeneral extends ChineseChessMan {

  private static final long serialVersionUID = -4341507506939393102L;

  public RedGeneral(int x, int y, ChineseChessBoard board) {
    super(x, y, ChessMan.RED, board);
  }

  public RedGeneral(RedGeneral rg) {
    super(rg);
  }

  @Override
  public RedGeneral clone() throws CloneNotSupportedException {
    return new RedGeneral(this);
  }

  public Bitmap getIcon() {
    return ChineseChessPictureList.getIcon(this.getClass().getName());
  }

  public Bitmap getSelectedIcon() {
    return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
  }

  @Override
  public boolean move(int x, int y) {

    if (((0 <= y && y <= 2) || (7 <= y && y <= 9)) && (3 <= x && x <= 5)) {
      if (Math.abs(x - currentX) + Math.abs(y - currentY) == 1) {
        inBoardMoveChess(x, y);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean eat(int x, int y) {
    return move(x, y);
  }

}
