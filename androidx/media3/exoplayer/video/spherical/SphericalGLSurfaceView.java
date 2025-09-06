package androidx.media3.exoplayer.video.spherical;

import A3.a;
import A3.d;
import A3.e;
import A3.k;
import A3.l;
import A3.n;
import A3.o;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.WindowManager;
import java.util.concurrent.CopyOnWriteArrayList;
import z3.j;

public final class SphericalGLSurfaceView extends GLSurfaceView {
    public final CopyOnWriteArrayList a;
    public final SensorManager b;
    public final Sensor c;
    public final e d;
    public final Handler e;
    public final k f;
    public SurfaceTexture g;
    public Surface h;
    public boolean i;
    public boolean j;
    public boolean k;

    public SphericalGLSurfaceView(Context context0) {
        this(context0, null);
    }

    public SphericalGLSurfaceView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = new CopyOnWriteArrayList();
        this.e = new Handler(Looper.getMainLooper());
        Object object0 = context0.getSystemService("sensor");
        object0.getClass();
        this.b = (SensorManager)object0;
        Sensor sensor0 = ((SensorManager)object0).getDefaultSensor(15);
        if(sensor0 == null) {
            sensor0 = ((SensorManager)object0).getDefaultSensor(11);
        }
        this.c = sensor0;
        k k0 = new k();
        this.f = k0;
        n n0 = new n(this, k0);
        o o0 = new o(context0, n0);
        WindowManager windowManager0 = (WindowManager)context0.getSystemService("window");
        windowManager0.getClass();
        this.d = new e(windowManager0.getDefaultDisplay(), new d[]{o0, n0});
        this.i = true;
        this.setEGLContextClientVersion(2);
        this.setRenderer(n0);
        this.setOnTouchListener(o0);
    }

    public final void a() {
        boolean z = this.i && this.j;
        Sensor sensor0 = this.c;
        if(sensor0 != null && z != this.k) {
            e e0 = this.d;
            SensorManager sensorManager0 = this.b;
            if(z) {
                sensorManager0.registerListener(e0, sensor0, 0);
            }
            else {
                sensorManager0.unregisterListener(e0);
            }
            this.k = z;
        }
    }

    public a getCameraMotionListener() {
        return this.f;
    }

    public j getVideoFrameMetadataListener() {
        return this.f;
    }

    public Surface getVideoSurface() {
        return this.h;
    }

    @Override  // android.opengl.GLSurfaceView
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l l0 = new l(this, 0);
        this.e.post(l0);
    }

    @Override  // android.opengl.GLSurfaceView
    public final void onPause() {
        this.j = false;
        this.a();
        super.onPause();
    }

    @Override  // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        this.j = true;
        this.a();
    }

    public void setDefaultStereoMode(int v) {
        this.f.k = v;
    }

    public void setUseSensorRotation(boolean z) {
        this.i = z;
        this.a();
    }
}

