package io.github.bersoncrios.tangramdoberson;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class VertexBuffer {
    public VertexBuffer() {
    }

    public static FloatBuffer generateNioBuffer(float[] vetorCoordenadas){
        ByteBuffer vrByteBuffer = ByteBuffer.allocateDirect(vetorCoordenadas.length * 4);
        vrByteBuffer.order(ByteOrder.nativeOrder());

        FloatBuffer vrFloatBuffer = vrByteBuffer.asFloatBuffer();
        vrFloatBuffer.clear();

        vrFloatBuffer.put(vetorCoordenadas);
        vrFloatBuffer.flip();


        return vrFloatBuffer;
    }
}