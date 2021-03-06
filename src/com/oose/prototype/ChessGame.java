/*******************************************************************************
 * Copyright (c) 2013 AUTHORS.txt
 * All rights reserved. Distributed under the terms of the MIT License.
 ******************************************************************************/
package com.oose.prototype;

import java.io.Serializable;

import android.graphics.Canvas;

/* Main ChessGame Logic(Controller) */
public abstract class ChessGame implements Serializable {

  private static final long serialVersionUID = 3804242090043209356L;

  public static final int GAMECONTINUE = 0;

  /* MVC's Model */
  protected ChessBoard board; // ChessBoard
  protected GameState status; // GameInfo(name, icon, time...etc)

  /* Converter between Model and View */
  protected Coordinate coord; //

  /* Called by View, to refresh screen */
  abstract public void refreshBoard(Canvas c);

  /* Called by View, Player's main action */
  abstract public int select(int x, int y);

  /* Called By select() to check action is valid or not */
  abstract protected boolean move(int x, int y);

  abstract protected boolean eat(int x, int y);

  abstract protected int isEnd();

  /* if someone call give up... */
  public int giveUp() {
    if (status.whosTurn() == GameState.PLAYERONE)
      return GameState.PLAYERTWO;
    else
      return GameState.PLAYERONE;
  }

  /* for the View to print name, icon, time... etc */
  public GameState getStatus() {
    return status;
  }
}
