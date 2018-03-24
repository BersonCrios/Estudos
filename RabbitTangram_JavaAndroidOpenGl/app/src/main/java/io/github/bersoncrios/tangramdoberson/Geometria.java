package io.github.bersoncrios.tangramdoberson;

import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class Geometria{

    public static float lado = 300;
    private float[] coordenadas = new float[8];
    private float angulo = 0;
    private float escala = 1;
    private float posicaoX = 0;
    private float posicaoY = 0;
    private float[] cor = new float[3];
    private FloatBuffer coordenadasBuffer = null;

    public static float getLado() {
        return lado;
    }

    public static void setLado(float lado) {
        Geometria.lado = lado;
    }

    public float[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(float[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public float getAngulo() {
        return angulo;
    }

    public void setAngulo(float angulo) {
        this.angulo = angulo;
    }

    public float getEscala() {
        return escala;
    }

    public void setEscala(float escala) {
        this.escala = escala;
    }

    public float getPosicaoX() {
        return posicaoX;
    }

    public float getPosicaoY() {
        return posicaoY;
    }

    public void setXY(float posicaoX, float posicaoY) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
    }

    public float[] getCor() {
        return cor;
    }

    public void setCor(float red, float green, float blue) {
        this.cor[0] = red;
        this.cor[1] = green;
        this.cor[2] = blue;
    }

    public void translate(GL10 vrOpenGL, float x, float y){
        vrOpenGL.glTranslatef(x, y, 0);
    }

    public void scale(GL10 vrOpenGL, float x, float y){
        vrOpenGL.glScalef(x, y, 1);
    }

    public void rotate(GL10 vrOpenGL, float angulo){
        vrOpenGL.glRotatef(angulo, 0, 0, 1);
    }

    public void setFloatBuffer(float[] coordenadas) {
        coordenadasBuffer = VertexBuffer.generateNioBuffer(coordenadas);
    }

    public FloatBuffer getCoordenadasBuffer() {
        return coordenadasBuffer;
    }

    public void desenha(GL10 vrOpenGL){

        setFloatBuffer(coordenadas);

        //SOLICITAR A LIBERACAO DO RECURSO ARRAY DOS VERTICES PARA A OPENGL
        vrOpenGL.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        vrOpenGL.glLoadIdentity();

        vrOpenGL.glTranslatef(posicaoX, posicaoY, 0);
        vrOpenGL.glRotatef(angulo, 0, 0, 1);
        vrOpenGL.glScalef(escala, escala, 1);

        //REGISTRAR O VETOR DE VERTICES CRIADO (FLOATBUFFER) NA OPENGL
        vrOpenGL.glVertexPointer(2, GL10.GL_FLOAT, 0, coordenadasBuffer);

        vrOpenGL.glColor4f(cor[0], cor[1], cor[2], 1);
        vrOpenGL.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 3);


    }
}
