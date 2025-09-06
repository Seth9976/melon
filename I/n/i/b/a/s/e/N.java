package i.n.i.b.a.s.e;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.provider.Settings.Global;
import java.util.ArrayList;

public class n {
    public final Context a;
    public Gd b;
    public boolean c;
    public boolean d;
    public A6[] e;

    public n(Context context0) {
        this.a = context0;
        this.b = Gd.h0;
        this.c = false;
        this.d = false;
        this.e = new A6[0];
    }

    public final d2[] a(Handler handler0, S3 s30, W6 w60, d8 d80, Y y0) {
        e5 e50;
        ArrayList arrayList0 = new ArrayList();
        Context context0 = this.a;
        if(!this.d) {
            I0 i00 = new I0(context0, handler0, s30, this.b);
            i00.c0 = 20L;
            arrayList0.add(i00);
        }
        if(this.c) {
            return (d2[])arrayList0.toArray(new d2[0]);
        }
        Intent intent0 = context0.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        int v = L7.a;
        if(v >= 17 && (("Amazon".equals(L7.d) || "Xiaomi".equals(L7.d)) && Settings.Global.getInt(context0.getContentResolver(), "external_surround_sound_enabled", 0) == 1)) {
            e50 = e5.e;
        }
        else if(intent0 == null || intent0.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            e50 = !L7.c.startsWith("BRAVIA") || v < 26 ? e5.c : e5.d;
        }
        else {
            e50 = new e5(intent0.getIntArrayExtra("android.media.extra.ENCODINGS"), intent0.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        }
        ub ub0 = new ub(e50, new sa(this.e));
        arrayList0.add(new od(this.a, handler0, w60, ub0, this.b));
        arrayList0.add(new X8(d80, handler0.getLooper()));
        arrayList0.add(new s0(y0, handler0.getLooper()));
        arrayList0.add(new X4());
        return (d2[])arrayList0.toArray(new d2[0]);
    }
}

