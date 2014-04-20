/*******************************************************************************
 * Copyright (c) 2013 AUTHORS.txt All rights reserved. Distributed under the terms of the MIT
 * License.
 ******************************************************************************/
package com.oose.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartMenu extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.start_menu);
  }

  public void newChess(View view) {
    Intent intent = new Intent(this, ChessMainMenu.class);

    /* INCOMPLETE, NEED INTEGRATE FGC LOGIN PROCESS */
    /* now only chinese chess */
    intent.putExtra(ChessMainMenu.CHESSTYPE_INT, ChessMainMenu.CHINESECHESS);

    startActivity(intent); // goto Chess Main Menu
    onStop();
  }
}
