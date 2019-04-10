package com.example.ronri.estaeslabuana;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.ronri.estaeslabuana.constantes.Constantes;
import com.example.ronri.estaeslabuana.estadosJuego.Audio_Menu;
import com.example.ronri.estaeslabuana.estadosJuego.Estados;
import com.example.ronri.estaeslabuana.estadosJuego.Juego1;
import com.example.ronri.estaeslabuana.estadosJuego.Menu_Prin;
import com.example.ronri.estaeslabuana.estadosJuego.PantallaCarga;
import com.example.ronri.estaeslabuana.graficos.Assets;
import com.example.ronri.estaeslabuana.imput.Teclado;
import com.example.ronri.estaeslabuana.objetosJuego.Cronometro;
import com.example.ronri.estaeslabuana.objetosJuego.Nave;
import com.example.ronri.estaeslabuana.vectores.Vector2D;

import java.io.IOException;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private float firstTouchX;
    private float firstTouchY;
    private Cronometro e1;
    private Cronometro e2;
    public GamePanel(){
        super(null);

    }
    public GamePanel(Context context){
        super(context);
        getHolder().addCallback(this);
        e1 = new Cronometro();
        e2 = new Cronometro();
        thread = new MainThread(getHolder(),this);
        Thread tr = new Thread();
        final Assets as = new Assets(this);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                as.init();
            }
        });
        Estados.setEstadoActual(new PantallaCarga(thread));
        setFocusable(true);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(),this);

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;

        while (true){
            try{
                thread.setRunning(false);
                thread.join();
            }catch (Exception e){

            }
            retry = false;
        }
    }
    public void onSwipeRight(){

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                firstTouchX = event.getX();
                firstTouchY= event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                if(Estados.getEstadoActual() != null){
                    if(Estados.getEstadoActual() instanceof Menu_Prin){
                        if(((Menu_Prin)Estados.getEstadoActual()).getPlay().contains((int)event.getX(),(int)event.getY())){
                            Estados.setEstadoActual(new Juego1());
                        }
                    }
                    if(Estados.getEstadoActual() instanceof Audio_Menu){
                        if(event.getX()>100&&event.getY()>100&&event.getX()<Constantes.ANCHO-100&&event.getY()<Constantes.ALTO-100){
                            Estados.setEstadoActual(new Menu_Prin());
                        }
                    }
                    if(Estados.getEstadoActual() instanceof  Juego1){
                        if(((Juego1)Estados.getEstadoActual()).getDe().contains((int)event.getX(),(int)event.getY())){
                            Teclado.derecha = true;
                            Teclado.izquierda = false;
                        }
                        if(((Juego1)Estados.getEstadoActual()).getIz().contains((int)event.getX(),(int)event.getY())){
                            Teclado.izquierda = true;
                            Teclado.derecha = false;
                        }
                        if(((Juego1)Estados.getEstadoActual()).getUp().contains((int)event.getX(),(int)event.getY())&&!Teclado.arriba&&!e2.isEncendido()){
                            Teclado.arriba = true;
                            e1.run(500);
                        }
                        if(((Juego1)Estados.getEstadoActual()).getUp().contains((int)event.getX(),(int)event.getY())&&Teclado.arriba&&!e1.isEncendido()){
                            Teclado.arriba = false;
                            e2.run(500);
                        }
                        if(((Juego1)Estados.getEstadoActual()).getSh().contains((int)event.getX(),(int)event.getY())){
                            Teclado.tecla_e = true;
                        }

                    }
                }
                break;
        }
        return true;
    }
    public void update(){
        if(Estados.getEstadoActual()!=null){
            Estados.getEstadoActual().update();

        }
        e2.update();
        e1.update();
        Teclado.derecha = false;
        Teclado.izquierda = false;
        Teclado.tecla_e = false;
    }

    public void draw(Canvas canvas){
        super.draw(canvas);
        canvas.drawColor(Color.BLACK);
        Paint g = new Paint();
        if(Estados.getEstadoActual()!=null){
            Estados.getEstadoActual().draw(canvas);
        }
    }
    public Bitmap cargaImagenesEnBuffer(int id){
      /*  if(Assets.tcla_dere != null) {
            de = new Rect();
            iz = new Rect(10, 10, 10 + Assets.tcla_iz.getWidth(), 10 + Assets.tcla_iz.getHeight());
            up = new Rect();
            sh = new Rect(Constantes.ANCHO - 10 - Assets.tcla_iz.getWidth(), Constantes.ALTO - Assets.tcla_iz.getHeight() - 10, Constantes.ANCHO - 10, Constantes.ALTO - 10);
        }*/
        Bitmap eso = null;
        BitmapFactory bf = new BitmapFactory();
        eso = bf.decodeResource(this.getResources(),id);
        Matrix m = new Matrix();
        m.preScale(-1,1);
        eso = Bitmap.createBitmap(eso,0,0,eso.getWidth(),eso.getHeight(),m,false);
        return eso;
    }
}
