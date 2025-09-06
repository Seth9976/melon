package androidx.media3.exoplayer;

import A3.a;
import android.media.MediaFormat;
import androidx.media3.common.b;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import z3.j;

public final class z implements a, d0, j {
    public j a;
    public a b;
    public j c;
    public a d;

    @Override  // z3.j
    public final void a(long v, long v1, b b0, MediaFormat mediaFormat0) {
        j j0 = this.c;
        if(j0 != null) {
            j0.a(v, v1, b0, mediaFormat0);
        }
        j j1 = this.a;
        if(j1 != null) {
            j1.a(v, v1, b0, mediaFormat0);
        }
    }

    @Override  // androidx.media3.exoplayer.d0
    public final void handleMessage(int v, Object object0) {
        switch(v) {
            case 7: {
                this.a = (j)object0;
                return;
            }
            case 8: {
                this.b = (a)object0;
                return;
            }
            case 10000: {
                if(((SphericalGLSurfaceView)object0) == null) {
                    this.c = null;
                    this.d = null;
                    return;
                }
                this.c = ((SphericalGLSurfaceView)object0).getVideoFrameMetadataListener();
                this.d = ((SphericalGLSurfaceView)object0).getCameraMotionListener();
            }
        }
    }

    @Override  // A3.a
    public final void onCameraMotion(long v, float[] arr_f) {
        a a0 = this.d;
        if(a0 != null) {
            a0.onCameraMotion(v, arr_f);
        }
        a a1 = this.b;
        if(a1 != null) {
            a1.onCameraMotion(v, arr_f);
        }
    }

    @Override  // A3.a
    public final void onCameraMotionReset() {
        a a0 = this.d;
        if(a0 != null) {
            a0.onCameraMotionReset();
        }
        a a1 = this.b;
        if(a1 != null) {
            a1.onCameraMotionReset();
        }
    }
}

