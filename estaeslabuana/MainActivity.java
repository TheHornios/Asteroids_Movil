package com.example.ronri.estaeslabuana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import com.example.ronri.estaeslabuana.constantes.Constantes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constantes.ANCHO = dm.widthPixels;
        Constantes.ALTO =dm.heightPixels;


        setContentView(new GamePanel(this));
    }
}
