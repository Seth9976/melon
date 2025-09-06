package K0;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.appcompat.app.z;
import i.n.i.b.a.s.e.Bc;
import i.n.i.b.a.s.e.L7;
import i.n.i.b.a.s.e.M3;
import i.n.i.b.a.s.e.M7;
import i.n.i.b.a.s.e.S6;
import i.n.i.b.a.s.e.vb;
import i.n.i.b.a.s.e.zc;

public final class d {
    public int a;
    public int b;
    public boolean c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;
    public Object h;

    public d() {
        this(false, c.a);
    }

    public d(int v) {
        this(true, c.b);
    }

    public d(Context context0, Handler handler0, zc zc0) {
        Context context1 = context0.getApplicationContext();
        this.d = context1;
        this.e = handler0;
        this.f = zc0;
        AudioManager audioManager0 = (AudioManager)context1.getSystemService("audio");
        M7.G(audioManager0);
        this.g = audioManager0;
        this.a = 3;
        this.b = d.c(audioManager0, 3);
        int v = this.a;
        this.c = L7.a < 23 ? d.c(audioManager0, v) == 0 : audioManager0.isStreamMute(v);
        z z0 = new z(this, 6);
        IntentFilter intentFilter0 = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
        try {
            context1.registerReceiver(z0, intentFilter0);
            this.h = z0;
        }
        catch(RuntimeException runtimeException0) {
            M7.M(runtimeException0, "StreamVolumeManager", "Error registering stream volume receiver");
        }
    }

    public d(boolean z, c c0) {
        int v;
        this.c = z;
        this.d = c0;
        if(z && c0.equals(c.a)) {
            throw new IllegalStateException("Lsq2 not (yet) supported for differential axes");
        }
        switch(c0.ordinal()) {
            case 0: {
                v = 3;
                break;
            }
            case 1: {
                v = 2;
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        this.a = v;
        this.e = new a[20];
        this.f = new float[20];
        this.g = new float[20];
        this.h = new float[3];
    }

    public void a(int v) {
        if(this.a != v) {
            this.a = v;
            this.e();
            Bc bc0 = ((zc)this.f).a;
            vb vb0 = Bc.C1(bc0.n);
            if(!vb0.equals(bc0.d0)) {
                bc0.d0 = vb0;
                for(Object object0: bc0.j) {
                    ((S6)object0).getClass();
                }
            }
        }
    }

    public void b(long v, float f) {
        int v1 = (this.b + 1) % 20;
        this.b = v1;
        a[] arr_a = (a[])this.e;
        a a0 = arr_a[v1];
        if(a0 == null) {
            a a1 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
            a1.a = v;
            a1.b = f;
            arr_a[v1] = a1;
            return;
        }
        a0.a = v;
        a0.b = f;
    }

    public static int c(AudioManager audioManager0, int v) {
        try {
            return audioManager0.getStreamVolume(v);
        }
        catch(RuntimeException runtimeException0) {
            M7.M(runtimeException0, "StreamVolumeManager", "Could not retrieve stream volume for stream type " + v);
            return audioManager0.getStreamMaxVolume(v);
        }
    }

    public float d(float f) {
        float f4;
        boolean z1;
        float f1 = 0.0f;
        if(f <= 0.0f) {
            M0.a.b(("maximumVelocity should be a positive value. You specified=" + f));
        }
        boolean z = this.c;
        c c0 = (c)this.d;
        float[] arr_f = (float[])this.f;
        float[] arr_f1 = (float[])this.g;
        int v = this.b;
        a[] arr_a = (a[])this.e;
        a a0 = arr_a[v];
        if(a0 != null) {
            int v1 = 0;
            a a1 = a0;
            while(true) {
                a a2 = arr_a[v];
                if(a2 == null) {
                    z1 = z;
                    break;
                }
                z1 = z;
                float f2 = (float)(a0.a - a2.a);
                float f3 = (float)Math.abs(a2.a - a1.a);
                a1 = c0 == c.a || z1 ? a2 : a0;
                if(f2 > 100.0f || f3 > 40.0f) {
                    break;
                }
                arr_f[v1] = a2.b;
                arr_f1[v1] = -f2;
                if(v == 0) {
                    v = 20;
                }
                --v;
                ++v1;
                if(v1 >= 20) {
                    break;
                }
                z = z1;
            }
            if(v1 >= this.a) {
                switch(c0.ordinal()) {
                    case 0: {
                        try {
                            float[] arr_f2 = (float[])this.h;
                            B.a.U(arr_f1, arr_f, v1, arr_f2);
                            f4 = 0.0f;
                            f4 = arr_f2[1];
                        }
                        catch(IllegalArgumentException unused_ex) {
                        }
                        break;
                    }
                    case 1: {
                        float f5 = arr_f1[v1 - 1];
                        int v2 = v1 - 1;
                        float f6 = 0.0f;
                        while(v2 > 0) {
                            float f7 = arr_f1[v2 - 1];
                            if(f5 != f7) {
                                float f8 = (z1 ? -arr_f[v2 - 1] : arr_f[v2] - arr_f[v2 - 1]) / (f5 - f7);
                                f6 += Math.abs(f8) * (f8 - Math.signum(f6) * ((float)Math.sqrt(Math.abs(f6) * 2.0f)));
                                if(v2 == v1 - 1) {
                                    f6 *= 0.5f;
                                }
                            }
                            --v2;
                            f5 = f7;
                        }
                        f4 = Math.signum(f6) * ((float)Math.sqrt(Math.abs(f6) * 2.0f));
                        break;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                f1 = f4 * 1000.0f;
            }
        }
        if(f1 == 0.0f || Float.isNaN(f1)) {
            return 0.0f;
        }
        if(f1 > 0.0f) {
            return f1 > f ? f : f1;
        }
        f = -f;
        return f1 < f ? f : f1;
    }

    public void e() {
        AudioManager audioManager0 = (AudioManager)this.g;
        int v = d.c(audioManager0, this.a);
        int v1 = this.a;
        boolean z = L7.a < 23 ? d.c(audioManager0, v1) == 0 : audioManager0.isStreamMute(v1);
        if(this.b != v || this.c != z) {
            this.b = v;
            this.c = z;
            for(Object object0: ((zc)this.f).a.j) {
                ((S6)object0).getClass();
            }
        }
    }
}

