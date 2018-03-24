package io.github.bersoncrios.tangramdoberson;

import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class Renderizador implements GLSurfaceView.Renderer{

    Triangulo triangulo1 = null;
    Triangulo triangulo2 = null;
    Triangulo triangulo3 = null;
    Triangulo triangulo4 = null;
    Triangulo triangulo5 = null;
    Quadrado quadrado = null;
    Paralelogramo paralelogramo = null;

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig)
    {

        triangulo1 = new Triangulo();
        triangulo2 = new Triangulo();
        triangulo3 = new Triangulo();
        triangulo4 = new Triangulo();
        triangulo5 = new Triangulo();
        quadrado = new Quadrado();
        paralelogramo = new Paralelogramo();
    }

    @Override
    public void onSurfaceChanged(GL10 vrOpengl, int largura, int altura)
    {
        //CONFIGURA A AREA DE VISUALIZACAO UTILIZADA NA TELA DO APARELHO
        vrOpengl.glViewport(0, 0, largura, altura);

        //alt = altura;
        // larg = largura;
        //CONFIGURA A MATRIZ DE PROJECAO QUE DEFINE O VOLUME DE RENDER
        //CARREGA A MATRIZ IDENTIDADE PARA TIRAR O LIXO DE MEMORIA
        //CARREGA A MATRIZ IDENTIDADE
        vrOpengl.glMatrixMode(GL10.GL_PROJECTION);
        vrOpengl.glLoadIdentity();
        vrOpengl.glOrthof(0, largura, 0, altura, 1, -1);

        //CONFIGURA A MATRIZ DE CAMERA E MODELOS
        //CARREGA A IDENTIDADE
        vrOpengl.glMatrixMode(GL10.GL_MODELVIEW);
        vrOpengl.glLoadIdentity();

        vrOpengl.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
    }

    @Override
    public void onDrawFrame(GL10 vrOpengl)
    {

        vrOpengl.glClear(GL10.GL_COLOR_BUFFER_BIT);


        //Triangulo Grande Vermelho
        triangulo1.setCor(1,0,0);
        triangulo1.setXY(395, 200);
        triangulo1.setEscala(0.6f);
        triangulo1.setAngulo(180);
        triangulo1.desenha(vrOpengl);

        //Triangulo Grande Azul Claro
        triangulo2.setCor(0,1,1);
        triangulo2.setXY(269, 331);
        triangulo2.setEscala(0.6f);
        triangulo2.setAngulo(-135);
        triangulo2.desenha(vrOpengl);

        //Quadrado Verde
        quadrado.setCor(0,1,0);
        quadrado.setXY(184, 333);
        quadrado.setEscala(0.28f);
        quadrado.desenha(vrOpengl);

        //Triangulo Pequeno Branco
        triangulo4.setCor(1,1,1);
        triangulo4.setXY(270, 337);
        triangulo4.setAngulo(180);
        triangulo4.setEscala(0.2f);
        triangulo4.desenha(vrOpengl);

        //Triangulo pequeno Rosa
        triangulo3.setCor(1,0,1);
        triangulo3.setXY(210, 217);
        triangulo3.setEscala(0.2f);
        triangulo3.setAngulo(0);
        triangulo3.desenha(vrOpengl);

        //Triangulo Médio Amarelo
        triangulo5.setCor(1,1,0);
        triangulo5.setXY(256, 543);
        triangulo5.setAngulo(-135);
        triangulo5.setEscala(0.3f);
        triangulo5.desenha(vrOpengl);

        //Paralelogramo Azul
        paralelogramo.setCor(0, 0, 1);
        paralelogramo.setXY(128, 519);
        paralelogramo.setAngulo(300);
        paralelogramo.setEscala(0.32f);
        paralelogramo.desenha(vrOpengl);
    }


}