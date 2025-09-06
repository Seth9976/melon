package Cc;

import Od.b;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.util.LruCache;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.common.composable.PlayBgColorData;
import com.melon.utils.image.ImageUtils;
import d5.n;
import java.util.ArrayList;
import je.p;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import m4.g;
import m4.h;
import m4.i;
import ne.a;
import oe.c;

public final class x2 {
    public final Context a;
    public final ImageUtils b;
    public final LogU c;
    public final LruCache d;

    public x2(Context context0, ImageUtils imageUtils0) {
        q.g(context0, "applicationContext");
        super();
        this.a = context0;
        this.b = imageUtils0;
        this.c = new LogU("PlayBgColorExtractor");
        this.d = new LruCache(3);
    }

    public final Object a(Uri uri0, c c0) {
        w2 w20;
        if(c0 instanceof w2) {
            w20 = (w2)c0;
            int v = w20.D;
            if((v & 0x80000000) == 0) {
                w20 = new w2(this, c0);
            }
            else {
                w20.D = v ^ 0x80000000;
            }
        }
        else {
            w20 = new w2(this, c0);
        }
        Object object0 = w20.w;
        a a0 = a.a;
        LruCache lruCache0 = this.d;
        Integer integer0 = null;
        switch(w20.D) {
            case 0: {
                n.D(object0);
                if(uri0 == null) {
                    return null;
                }
                PlayBgColorData playBgColorData0 = (PlayBgColorData)lruCache0.get(uri0);
                if(playBgColorData0 != null) {
                    LogU.debug$default(this.c, "Cache hit for URI: " + uri0, null, false, 6, null);
                    return playBgColorData0;
                }
                w20.r = uri0;
                w20.D = 1;
                object0 = this.b.a(this.a, uri0, w20);
                if(object0 == a0) {
                    return a0;
                }
                goto label_28;
            }
            case 1: {
                uri0 = w20.r;
                n.D(object0);
            label_28:
                if(((Bitmap)object0) == null) {
                    return null;
                }
                w20.r = uri0;
                w20.D = 2;
                object0 = ((Bitmap)object0).isRecycled() ? null : BuildersKt.withContext(Dispatchers.getDefault(), new b(((Bitmap)object0), y2.a, null), w20);
                if(object0 == a0) {
                    return a0;
                }
                goto label_36;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        uri0 = w20.r;
        n.D(object0);
    label_36:
        if(((h)object0) == null) {
            return null;
        }
        g g0 = ((h)object0).e;
        Integer integer1 = x2.b((g0 == null ? null : g0.d));
        g g1 = ((h)object0).a(i.d);
        Integer integer2 = x2.b((g1 == null ? null : g1.d));
        g g2 = ((h)object0).a(i.f);
        ArrayList arrayList0 = je.n.g0(new Integer[]{integer1, integer2, x2.b((g2 == null ? null : g2.d))});
        g g3 = ((h)object0).a(i.e);
        Integer integer3 = x2.b((g3 == null ? null : g3.d));
        g g4 = ((h)object0).a(i.g);
        Integer integer4 = x2.b((g4 == null ? null : g4.d));
        g g5 = ((h)object0).a(i.h);
        Integer integer5 = x2.b((g5 == null ? null : g5.d));
        g g6 = ((h)object0).a(i.i);
        if(g6 != null) {
            integer0 = g6.d;
        }
        Integer integer6 = x2.b(integer0);
        g g7 = ((h)object0).a(y2.a);
        PlayBgColorData playBgColorData1 = new PlayBgColorData(arrayList0.size(), p.A0(arrayList0, je.n.g0(new Integer[]{integer3, integer4, integer5, integer6, x2.b(((int)(g7 == null ? -1 : g7.d)))})));
        lruCache0.put(uri0, playBgColorData1);
        return playBgColorData1;
    }

    public static Integer b(Integer integer0) {
        if(integer0 != null && ((int)integer0) != -1) {
            float[] arr_f = new float[3];
            S1.c.b(Color.red(((int)integer0)), Color.green(((int)integer0)), Color.blue(((int)integer0)), arr_f);
            if(arr_f[1] > 0.8f) {
                arr_f[1] = 0.8f;
            }
            float f = arr_f[2] > 0.7f ? 0.7f : arr_f[2];
            if(f < 0.15f) {
                f = 0.15f;
            }
            arr_f[2] = f;
            return S1.c.a(arr_f);
        }
        return null;
    }
}

