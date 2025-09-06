package o3;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import h3.b;
import i.n.i.b.a.s.e.H0;
import java.nio.ByteBuffer;
import kb.D;

public interface j {
    void a(int arg1, b arg2, long arg3, int arg4);

    void c(Bundle arg1);

    void d(int arg1, int arg2, int arg3, long arg4);

    MediaFormat e();

    void f();

    void flush();

    default boolean g(D d0) {
        return false;
    }

    ByteBuffer h(int arg1);

    void i(Surface arg1);

    void k(int arg1);

    void m(H0 arg1, Handler arg2);

    void n(int arg1, long arg2);

    int o();

    int q(MediaCodec.BufferInfo arg1);

    void release();

    ByteBuffer s(int arg1);

    void setVideoScalingMode(int arg1);
}

