package com.example.mknizewski.paint;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class PaintActivity extends Activity {

    PaintView paintView;
    Context ctx;
    RadioGroup radioGroup;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        //this.requestWindowFeature(Window.FEATURE_ACTION_BAR);

        paintView = (PaintView) findViewById(R.id.paintView);
        ctx = getApplicationContext();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.paint, menu);


        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_kolor:

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Wybor koloru");
                final CharSequence[] items = { "Czerwony", "Zielony", "Niebieski","Czarny", "Biały" };

                alertDialogBuilder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                paintView.setColor(Color.RED);
                                break;
                            case 1:
                                paintView.setColor(Color.GREEN);
                                break;
                            case 2:
                                paintView.setColor(Color.BLUE);
                                break;
                            case 3:
                                paintView.setColor(Color.BLACK);
                                break;
                            case 4:
                                paintView.setColor(Color.WHITE);
                                break;

                        }
                    }

                }

                );

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                break;
            case R.id.menu_rozmiar:

                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.rozmiar, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setView(layout);
                alertDialog = builder.create();
                alertDialog.show();
                SeekBar sb = (SeekBar)layout.findViewById(R.id.seekBar);
                sb.setMax(30);
                sb.setProgress(paintView.getRozmiar()-20);
                sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    public void onStartTrackingTouch(SeekBar arg0) {
                        // TODO Auto-generated method stub

                    }

                    public void onStopTrackingTouch(SeekBar arg0) {
                        // TODO Auto-generated method stub

                    }

                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        paintView.setRozmiar(20+progress);

                    }
                });
                break;
            case R.id.menu_clear:
                paintView.clearView();
                break;
        }
        return true;
    }
}