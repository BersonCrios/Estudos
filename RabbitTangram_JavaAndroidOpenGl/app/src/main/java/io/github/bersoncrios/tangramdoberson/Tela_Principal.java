package io.github.bersoncrios.tangramdoberson;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class Tela_Principal extends Activity {
    //Cria uma variavel de referencia para a OpenGL - SUPERFICIE DE DESENHO
    GLSurfaceView superficieDesenho = null;
    Renderizador render = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Valida a variavel de referencia com uma instancia da superficie
        superficieDesenho = new GLSurfaceView(this);
        render = new Renderizador();

        superficieDesenho.setRenderer(render);

        //configura a tela do aparelho para mostrar a sup. de desenho
        setContentView(superficieDesenho);

        //configura modo fullscreen  na largura e altura
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //solicita que o aplicativo fique ativo na tela mesmo por inatividade do usuário
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
}