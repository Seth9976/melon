package j3;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Global;
import androidx.appcompat.app.z;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import e3.x;
import i.n.i.b.a.s.e.Ga;
import java.util.Objects;

public final class e {
    public final Context a;
    public final n b;
    public final Handler c;
    public final c d;
    public final z e;
    public final d f;
    public b g;
    public Ga h;
    public b3.d i;
    public boolean j;

    public e(Context context0, n n0, b3.d d0, Ga ga0) {
        Context context1 = context0.getApplicationContext();
        this.a = context1;
        this.b = n0;
        this.i = d0;
        this.h = ga0;
        d d1 = null;
        Handler handler0 = new Handler(x.u(), null);
        this.c = handler0;
        this.d = new c(this);
        this.e = new z(this, 8);
        Uri uri0 = "Amazon".equals(x.c) || "Xiaomi".equals(x.c) ? Settings.Global.getUriFor("external_surround_sound_enabled") : null;
        if(uri0 != null) {
            d1 = new d(this, handler0, context1.getContentResolver(), uri0);
        }
        this.f = d1;
    }

    public final void a(b b0) {
        DefaultTrackSelector defaultTrackSelector0;
        if(this.j && !b0.equals(this.g)) {
            this.g = b0;
            s s0 = (s)this.b.b;
            Looper looper0 = Looper.myLooper();
            Looper looper1 = s0.f0;
            if(looper1 != looper0) {
                String s1 = looper1 == null ? "null" : looper1.getThread().getName();
                throw new IllegalStateException("Current looper (" + (looper0 == null ? "null" : looper0.getThread().getName()) + ") is not the playback looper (" + s1 + ")");
            }
            if(!b0.equals(s0.w)) {
                s0.w = b0;
                Ga ga0 = s0.r;
                if(ga0 != null) {
                    synchronized(((u)ga0.b).a) {
                        defaultTrackSelector0 = ((u)ga0.b).w;
                    }
                    if(defaultTrackSelector0 != null) {
                        synchronized(defaultTrackSelector0.c) {
                            defaultTrackSelector0.g.getClass();
                        }
                    }
                }
            }
        }
    }

    public final void b(AudioDeviceInfo audioDeviceInfo0) {
        Ga ga0 = null;
        if(Objects.equals(audioDeviceInfo0, (this.h == null ? null : ((AudioDeviceInfo)this.h.b)))) {
            return;
        }
        if(audioDeviceInfo0 != null) {
            ga0 = new Ga(audioDeviceInfo0, 14);
        }
        this.h = ga0;
        this.a(b.c(this.a, this.i, ga0));
    }
}

