package io.github.bersoncrios.tangramdoberson;

import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class Triangulo extends Geometria{

    float[] coordenadas = {0, 0, 0, lado, lado, lado};

    public Triangulo(){
        setCoordenadas(coordenadas);
    }


}