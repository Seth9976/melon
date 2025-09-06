package Q5;

import S5.a;
import V5.b;
import W5.i;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.google.android.exoplayer2.util.e;
import df.d;
import i.n.i.b.a.s.e.I2;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Provider;
import v2.g;

public final class k implements g {
    public Context a;

    @Override  // v2.g
    public void a(d d0) {
        e e0 = new e("EmojiCompatInitializer", 3);
        ThreadPoolExecutor threadPoolExecutor0 = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), e0);
        threadPoolExecutor0.allowCoreThreadTimeOut(true);
        threadPoolExecutor0.execute(new I2(this, d0, threadPoolExecutor0, 10));
    }

    public l b() {
        Context context0 = this.a;
        if(context0 == null) {
            throw new IllegalStateException("android.content.Context must be set");
        }
        l l0 = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        l0.a = a.a(o.a);
        R5.e e0 = new R5.e(context0, 1);
        l0.b = e0;
        l0.c = a.a(new R5.g(e0, new R5.e(e0, 0), 0));
        R5.e e1 = l0.b;
        l0.d = new X5.e(e1, 1);
        Provider provider0 = a.a(new X5.e(e1, 0));
        l0.e = provider0;
        Provider provider1 = a.a(new R5.g(l0.d, provider0, 1));
        l0.f = provider1;
        p p0 = new p(1);
        R5.e e2 = l0.b;
        v v0 = new v(e2, provider1, p0, 1);
        Provider provider2 = l0.a;
        Provider provider3 = l0.c;
        l0.g = a.a(new v(new b(provider2, provider3, v0, provider1, provider1), new i(e2, provider3, provider1, v0, provider2, provider1, provider1), new W5.k(provider2, provider1, v0, provider1), 0));
        return l0;
    }

    public static k c(Context context0) {
        k k0 = new k();  // 初始化器: Ljava/lang/Object;-><init>()V
        k0.a = context0;
        return k0;
    }

    public int d() {
        Configuration configuration0 = this.a.getResources().getConfiguration();
        int v = configuration0.screenWidthDp;
        int v1 = configuration0.screenHeightDp;
        if(configuration0.smallestScreenWidthDp <= 600 && v <= 600 && (v <= 960 || v1 <= 720) && (v <= 720 || v1 <= 960)) {
            if(v < 500 && (v <= 640 || v1 <= 480) && (v <= 480 || v1 <= 640)) {
                return v < 360 ? 2 : 3;
            }
            return 4;
        }
        return 5;
    }

    public int e() {
        Context context0 = this.a;
        TypedArray typedArray0 = context0.obtainStyledAttributes(null, g.a.a, 0x7F040008, 0);  // attr:actionBarStyle
        int v = typedArray0.getLayoutDimension(13, 0);
        Resources resources0 = context0.getResources();
        if(!this.a.getResources().getBoolean(0x7F050000)) {  // bool:abc_action_bar_embed_tabs
            v = Math.min(v, resources0.getDimensionPixelSize(0x7F070009));  // dimen:abc_action_bar_stacked_max_height
        }
        typedArray0.recycle();
        return v;
    }
}

