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

public class ChessSetup extends Activity {

  public final static String TIMELIMIT_INT = "tl";
  public final static String LIMITSWITCH_BOOLEAN = "LS";
  public final static String PLAYER1NAME_STRING = "P1N";
  public final static String PLAYER2NAME_STRING = "P2N";
  public final static String PLAYER1ICON_BITMAP = "P1I";
  public final static String PLAYER2ICON_BITMAP = "P2I";
  public final static String INTENT_HAS_ICON_BOOLEAN = "IHI";
  public final static int PICTURERESULTCODE = 1100;
  public final static int TIMERESULTCODE = 1200;
  public final static int CAMERAREQUESTCODE = 2100;
  public final static int FROMFILEREQUESTCODE = 2200;
  public final static int DEFAULTIMELIMIT = 30;
  public final static int DEFAULTTIMELIMIT_MAX = 90;
  public final static int DEFAULTTIMELIMIT_MIN = 30;
  public final static boolean DEFAULTTIMELIMITSWITCH = true;
  public final static int DEFAULTFALLBACKVALUE = 3;

  private SettingBundle setup;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // Intent intent = getIntent();
    super.onCreate(savedInstanceState);
    setup = new SettingBundle();
    setContentView(R.layout.chess_condition_setup);
    //getActionBar().setDisplayHomeAsUpEnabled(true);
  }

  public boolean onOptionsItemSelected(MenuItem item) {
    // switch(item.getItemId()) {
    // case android.R.id.home:
    finish();
    return true;
  }


  public void startGame(View view) {
    Intent intent = new Intent();
    intent.putExtra(PLAYER1NAME_STRING, setup.getPlayerOneName());
    intent.putExtra(PLAYER2NAME_STRING, setup.getPlayerTwoName());
    intent.putExtra(PLAYER1ICON_BITMAP, setup.getPlayerOnePicture());
    intent.putExtra(PLAYER2ICON_BITMAP, setup.getPlayerTwoPicture());
    intent.putExtra(TIMELIMIT_INT, setup.getTimeLimitValue());
    intent.putExtra(LIMITSWITCH_BOOLEAN, setup.isTimeLimitOn());

    intent.setClass(this, ChineseChessMain.class);

    startActivity(intent);
    finish();
    onStop();
  }
}
