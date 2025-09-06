package c3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface d {
    public static final ByteBuffer a;

    static {
        d.a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
    }

    b a(b arg1);

    void flush();

    ByteBuffer getOutput();

    boolean isActive();

    boolean isEnded();

    void queueEndOfStream();

    void queueInput(ByteBuffer arg1);

    void reset();
}

