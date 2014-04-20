/*******************************************************************************
 * Copyright (c) 2013 AUTHORS.txt All rights reserved. Distributed under the terms of the MIT
 * License.
 ******************************************************************************/
package com.oose.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

/*
 * Chess Start Menu let user to start a new game or load previous save data
 */
public class ChessMainMenu extends Activity {

  /* intent Key and Value, constantize for readability */
  public static final String CHESSTYPE_INT = "CT";
  public static final String LOADSAVEFILE = "LSF";
  public static final int CHINESECHESS = 0;
  public static final int DARKCHESS = 1;
  public static int ERROR = -1;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    /* get data from previous activity */
    //Intent intent = getIntent();

    super.onCreate(savedInstanceState);

    /* setup this activity view's layout */
    setContentView(R.layout.chess_main_menu);
    //getActionBar().setDisplayHomeAsUpEnabled(true);

    getActionBar().setTitle(R.string.chinesechess);
  }

  /* if user push back button, go back to StartMenu */
  public boolean onOptionsItemSelected(MenuItem item) {
    finish();
    return true;
  }

  /* if user push newgame or loadgame, this method will handle it */
  public void selectGame(View view) {
    Intent intent = new Intent();
    /* push new game */
    if (view.getId() == R.id.ButtonNewGame) {
      intent.setClass(this, ChessSetup.class);
      intent.putExtra(ChessMainMenu.CHESSTYPE_INT, ChessMainMenu.CHINESECHESS);
    }
    startActivity(intent);
    onStop();
  }
}
