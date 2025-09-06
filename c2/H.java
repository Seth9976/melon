package c2;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.core.widget.l;
import java.util.Map;
import java.util.Objects;

public final class h {
    public final Context a;
    public final i b;
    public VelocityTracker c;
    public float d;
    public int e;
    public int f;
    public int g;
    public final int[] h;

    public h(Context context0, i i0) {
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = new int[]{0x7FFFFFFF, 0};
        this.a = context0;
        this.b = i0;
    }

    public final void a(MotionEvent motionEvent0, int v) {
        float f6;
        float f4;
        float f2;
        long v18;
        boolean z;
        int v10;
        int v6;
        int v1 = motionEvent0.getSource();
        int v2 = motionEvent0.getDeviceId();
        int[] arr_v = this.h;
        if(this.f != v1 || this.g != v2 || this.e != v) {
            Context context0 = this.a;
            ViewConfiguration viewConfiguration0 = ViewConfiguration.get(context0);
            int v3 = motionEvent0.getDeviceId();
            int v4 = motionEvent0.getSource();
            int v5 = Build.VERSION.SDK_INT;
            if(v5 >= 34) {
                v6 = l.h(viewConfiguration0, v3, v, v4);
            }
            else {
                InputDevice inputDevice0 = InputDevice.getDevice(v3);
                if(inputDevice0 == null || inputDevice0.getMotionRange(v, v4) == null) {
                    v6 = 0x7FFFFFFF;
                }
                else {
                    Resources resources0 = context0.getResources();
                    int v7 = v4 != 0x400000 || v != 26 ? -1 : resources0.getIdentifier("config_viewMinRotaryEncoderFlingVelocity", "dimen", "android");
                    Objects.requireNonNull(viewConfiguration0);
                    switch(v7) {
                        case -1: {
                            v6 = viewConfiguration0.getScaledMinimumFlingVelocity();
                            break;
                        }
                        case 0: {
                            v6 = 0x7FFFFFFF;
                            break;
                        }
                        default: {
                            v6 = resources0.getDimensionPixelSize(v7);
                            if(v6 < 0) {
                                v6 = 0x7FFFFFFF;
                            }
                        }
                    }
                }
            }
            arr_v[0] = v6;
            int v8 = motionEvent0.getDeviceId();
            int v9 = motionEvent0.getSource();
            if(v5 >= 34) {
                v10 = l.g(viewConfiguration0, v8, v, v9);
            }
            else {
                InputDevice inputDevice1 = InputDevice.getDevice(v8);
                if(inputDevice1 == null || inputDevice1.getMotionRange(v, v9) == null) {
                    v10 = 0x80000000;
                }
                else {
                    Resources resources1 = context0.getResources();
                    int v11 = v9 != 0x400000 || v != 26 ? -1 : resources1.getIdentifier("config_viewMaxRotaryEncoderFlingVelocity", "dimen", "android");
                    Objects.requireNonNull(viewConfiguration0);
                    switch(v11) {
                        case -1: {
                            v10 = viewConfiguration0.getScaledMaximumFlingVelocity();
                            break;
                        }
                        case 0: {
                            v10 = 0x80000000;
                            break;
                        }
                        default: {
                            v10 = resources1.getDimensionPixelSize(v11);
                            if(v10 < 0) {
                                v10 = 0x80000000;
                            }
                        }
                    }
                }
            }
            arr_v[1] = v10;
            this.f = v1;
            this.g = v2;
            this.e = v;
            z = true;
        }
        else {
            z = false;
        }
        if(arr_v[0] == 0x7FFFFFFF) {
            VelocityTracker velocityTracker0 = this.c;
            if(velocityTracker0 == null) {
                return;
            }
            velocityTracker0.recycle();
            this.c = null;
            return;
        }
        if(this.c == null) {
            this.c = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker1 = this.c;
        velocityTracker1.addMovement(motionEvent0);
        if(Build.VERSION.SDK_INT < 34 && motionEvent0.getSource() == 0x400000) {
            Map map0 = E.a;
            if(!map0.containsKey(velocityTracker1)) {
                map0.put(velocityTracker1, new F());
            }
            F f0 = (F)map0.get(velocityTracker1);
            long[] arr_v1 = f0.b;
            long v12 = motionEvent0.getEventTime();
            if(f0.d != 0 && v12 - arr_v1[f0.e] > 40L) {
                f0.d = 0;
                f0.c = 0.0f;
            }
            int v13 = (f0.e + 1) % 20;
            f0.e = v13;
            int v14 = f0.d;
            if(v14 != 20) {
                f0.d = v14 + 1;
            }
            f0.a[v13] = motionEvent0.getAxisValue(26);
            arr_v1[f0.e] = v12;
        }
        velocityTracker1.computeCurrentVelocity(1000, 3.402823E+38f);
        F f1 = (F)E.a.get(velocityTracker1);
        if(f1 != null) {
            float[] arr_f = f1.a;
            long[] arr_v2 = f1.b;
            int v15 = f1.d;
            if(v15 >= 2) {
                int v16 = (f1.e + 20 - (v15 - 1)) % 20;
                long v17 = arr_v2[f1.e];
                while(true) {
                    v18 = arr_v2[v16];
                    if(v17 - v18 <= 100L) {
                        break;
                    }
                    --f1.d;
                    v16 = (v16 + 1) % 20;
                }
                int v19 = f1.d;
                if(v19 < 2) {
                    f2 = 0.0f;
                }
                else if(v19 == 2) {
                    int v20 = (v16 + 1) % 20;
                    long v21 = arr_v2[v20];
                    f2 = v18 == v21 ? 0.0f : arr_f[v20] / ((float)(v21 - v18));
                }
                else {
                    float f3 = 0.0f;
                    int v23 = 0;
                    for(int v22 = 0; true; ++v22) {
                        f4 = 1.0f;
                        if(v22 >= f1.d - 1) {
                            break;
                        }
                        int v24 = v22 + v16;
                        long v25 = arr_v2[v24 % 20];
                        int v26 = (v24 + 1) % 20;
                        if(arr_v2[v26] != v25) {
                            ++v23;
                            if(f3 < 0.0f) {
                                f4 = -1.0f;
                            }
                            float f5 = arr_f[v26] / ((float)(arr_v2[v26] - v25));
                            f3 += Math.abs(f5) * (f5 - f4 * ((float)Math.sqrt(Math.abs(f3) * 2.0f)));
                            if(v23 == 1) {
                                f3 *= 0.5f;
                            }
                        }
                    }
                    if(f3 < 0.0f) {
                        f4 = -1.0f;
                    }
                    f2 = f4 * ((float)Math.sqrt(Math.abs(f3) * 2.0f));
                }
            }
            else {
                f2 = 0.0f;
            }
            f1.c = f2 * 1000.0f;
            if(f2 * 1000.0f < -3.402823E+38f) {
                f1.c = -3.402823E+38f;
            }
            else if(f1.c > 3.402823E+38f) {
                f1.c = 3.402823E+38f;
            }
        }
        if(Build.VERSION.SDK_INT >= 34) {
            f6 = l.c(velocityTracker1, v);
        }
        else if(v == 0) {
            f6 = velocityTracker1.getXVelocity();
        }
        else if(v == 1) {
            f6 = velocityTracker1.getYVelocity();
        }
        else {
            F f7 = (F)E.a.get(velocityTracker1);
            f6 = f7 == null || v != 26 ? 0.0f : f7.c;
        }
        i i0 = this.b;
        float f8 = i0.b() * f6;
        float f9 = Math.signum(f8);
        if(z || f9 != Math.signum(this.d) && f9 != 0.0f) {
            i0.c();
        }
        if(Math.abs(f8) < ((float)arr_v[0])) {
            return;
        }
        float f10 = Math.max(-arr_v[1], Math.min(f8, arr_v[1]));
        this.d = i0.a(f10) ? f10 : 0.0f;
    }
}

