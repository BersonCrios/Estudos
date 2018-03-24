package io.github.bersoncrios.tangramdoberson;

import javax.microedition.khronos.opengles.GL10;


public class Paralelogramo extends Triangulo{

    private float coordenadas[] = {0, 0, lado, 0, lado/2, 140, lado*1.5f, 140};

    public Paralelogramo() {
        setCoordenadas(coordenadas);
    }

    @Override
    public void desenha(GL10 vrOpenGL) {

        setFloatBuffer(coordenadas);

        vrOpenGL.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        float rgb[] = getCor();

        vrOpenGL.glLoadIdentity();

        vrOpenGL.glTranslatef(getPosicaoX(), getPosicaoY(), 0);
        vrOpenGL.glRotatef(getAngulo(), 0, 0, 1);
        vrOpenGL.glScalef(getEscala(), getEscala(), 1);

        //REGISTRAR O VETOR DE VERTICES CRIADO (FLOATBUFFER) NA OPENGL
        vrOpenGL.glVertexPointer(2, GL10.GL_FLOAT, 0, getCoordenadasBuffer());
        vrOpenGL.glColor4f(rgb[0], rgb[1], rgb[2], 1);
        vrOpenGL.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
    }
}