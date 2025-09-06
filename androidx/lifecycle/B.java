package androidx.lifecycle;

import B0.t;
import Ba.h;
import N4.z;
import V6.c;
import android.content.ClipData;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.ContentInfo.Builder;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsetsController;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.media3.session.k0;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import androidx.media3.session.legacy.s;
import androidx.media3.session.v0;
import c2.B0;
import c2.d;
import c2.f;
import c2.g;
import c2.v;
import c2.y0;
import c7.a;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.internal.B;
import com.google.android.material.internal.D;
import com.google.android.material.internal.E;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.i;
import com.google.android.material.navigation.k;
import com.google.android.material.navigationrail.NavigationRailView;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.custom.Q;
import com.iloen.melon.custom.RadioGroup;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.b0;
import com.iloen.melon.custom.f0;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import e1.u;
import e7.m;
import j3.n;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import k.j;
import kotlin.jvm.internal.q;
import org.json.JSONException;
import org.json.JSONObject;
import va.e0;
import va.o;

public final class b implements v0, d, f, v, a, c7.b, com.google.android.material.button.a, D, com.google.android.material.internal.f, Q, b0, f0, d7.a, j {
    public final int a;
    public Object b;

    public b() {
        this.a = 0;
        super();
        this.b = new AtomicReference(null);
    }

    public b(int v) {
        this.a = v;
        super();
    }

    public b(h h0) {
        this.a = 6;
        q.g(h0, "api");
        super();
        this.b = h0;
    }

    public b(ClipData clipData0, int v) {
        this.a = 7;
        super();
        this.b = t.g(clipData0, v);
    }

    public b(ContentInfo contentInfo0) {
        this.a = 8;
        super();
        contentInfo0.getClass();
        this.b = contentInfo0;
    }

    public b(View view0) {
        this.a = 9;
        super();
        if(Build.VERSION.SDK_INT >= 30) {
            c2.D d0 = new c2.D(view0);  // 初始化器: LN4/z;-><init>(Landroid/view/View;)V
            d0.h = view0;
            this.b = d0;
            return;
        }
        this.b = new z(view0);
    }

    public b(ViewGroup viewGroup0) {
        this.a = 21;
        super();
        this.b = viewGroup0.getOverlay();
    }

    public b(WindowInsetsController windowInsetsController0) {
        this.a = 9;
        super();
        c2.D d0 = new c2.D(null);  // 初始化器: LN4/z;-><init>(Landroid/view/View;)V
        d0.i = windowInsetsController0;
        this.b = d0;
    }

    public b(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    public static String A(Bundle bundle0, String s) {
        JSONObject jSONObject0 = new JSONObject();
        JSONObject jSONObject1 = new JSONObject();
        for(Object object0: bundle0.keySet()) {
            jSONObject1.put(((String)object0), bundle0.get(((String)object0)));
        }
        jSONObject0.put("name", s);
        jSONObject0.put("parameters", jSONObject1);
        return jSONObject0.toString();
    }

    @Override  // c2.d
    public void b(Uri uri0) {
        ((ContentInfo.Builder)this.b).setLinkUri(uri0);
    }

    @Override  // c2.d
    public g build() {
        return new g(new b(((ContentInfo.Builder)this.b).build()));
    }

    @Override  // k.j
    public boolean c(MenuBuilder menuBuilder0, MenuItem menuItem0) {
        if(this.a != 22) {
            ((NavigationView)this.b).getClass();
            return false;
        }
        i i0 = ((k)this.b).e;
        return i0 != null && !MusicBrowserActivity.m0(((MusicBrowserActivity)((n)i0).b), menuItem0);
    }

    @Override  // c2.f
    public int getFlags() {
        return ((ContentInfo)this.b).getFlags();
    }

    @Override  // c2.f
    public int getSource() {
        return ((ContentInfo)this.b).getSource();
    }

    @Override  // c2.f
    public ContentInfo h() {
        return (ContentInfo)this.b;
    }

    @Override  // k.j
    public void j(MenuBuilder menuBuilder0) {
    }

    @Override  // com.google.android.material.internal.D
    public B0 k(View view0, B0 b00, E e0) {
        S1.d d0 = b00.a.g(0x207);
        NavigationRailView navigationRailView0 = (NavigationRailView)this.b;
        if((navigationRailView0.h == null ? navigationRailView0.getFitsSystemWindows() : navigationRailView0.h.booleanValue())) {
            e0.b += d0.b;
        }
        if((navigationRailView0.i == null ? navigationRailView0.getFitsSystemWindows() : navigationRailView0.i.booleanValue())) {
            e0.d += d0.d;
        }
        if((navigationRailView0.j == null ? navigationRailView0.getFitsSystemWindows() : navigationRailView0.j.booleanValue())) {
            e0.a += (B.l(view0) ? d0.c : d0.a);
        }
        view0.setPaddingRelative(e0.a, e0.b, e0.c, e0.d);
        return b00;
    }

    @Override  // c2.f
    public ClipData l() {
        return ((ContentInfo)this.b).getClip();
    }

    @Override  // com.iloen.melon.custom.Q
    public void n(S s0, boolean z) {
        RadioGroup radioGroup0 = (RadioGroup)this.b;
        if(radioGroup0.c) {
            return;
        }
        radioGroup0.c = true;
        int v = radioGroup0.a;
        if(v != -1) {
            radioGroup0.b(v, false);
        }
        radioGroup0.c = false;
        radioGroup0.setCheckedId(((View)s0).getId());
    }

    @Override  // c7.b
    public void onEvent(String s, Bundle bundle0) {
        e7.n n0 = (e7.n)this.b;
        if(n0 != null) {
            try {
                m m0 = new m(n0.a, System.currentTimeMillis() - n0.a.d, "$A$:" + b.A(bundle0, s), 0);
                n0.a.o.a.a(m0);
            }
            catch(JSONException unused_ex) {
                Log.w("FirebaseCrashlytics", "Unable to serialize Firebase Analytics event to breadcrumb.", null);
            }
        }
    }

    @Override  // androidx.media3.session.v0
    public void p(int v, String s) {
        s s1 = ((k0)this.b).a;
        s1.getClass();
        s1.n(null, s);
        X4.d d0 = new X4.d(s1, s, null, 2);
        ((MediaBrowserServiceCompat)s1.d).g.post(d0);
    }

    @Override  // c2.v
    public B0 s(View view0, B0 b00) {
        B0 b01 = null;
        boolean z = true;
        int v = 0;
        switch(this.a) {
            case 16: {
                AppBarLayout appBarLayout0 = (AppBarLayout)this.b;
                if(appBarLayout0.getFitsSystemWindows()) {
                    b01 = b00;
                }
                if(!Objects.equals(appBarLayout0.g, b01)) {
                    appBarLayout0.g = b01;
                    if(appBarLayout0.I != null && appBarLayout0.getTopInset() > 0) {
                        v = 1;
                    }
                    appBarLayout0.setWillNotDraw(((boolean)(v ^ 1)));
                    appBarLayout0.requestLayout();
                }
                return b00;
            }
            case 17: {
                CollapsingToolbarLayout collapsingToolbarLayout0 = (CollapsingToolbarLayout)this.b;
                if(collapsingToolbarLayout0.getFitsSystemWindows()) {
                    b01 = b00;
                }
                if(!Objects.equals(collapsingToolbarLayout0.V, b01)) {
                    collapsingToolbarLayout0.V = b01;
                    collapsingToolbarLayout0.requestLayout();
                }
                return b00.a.c();
            }
            default: {
                ScrimInsetsFrameLayout scrimInsetsFrameLayout0 = (ScrimInsetsFrameLayout)this.b;
                if(scrimInsetsFrameLayout0.b == null) {
                    scrimInsetsFrameLayout0.b = new Rect();
                }
                Rect rect0 = scrimInsetsFrameLayout0.b;
                int v1 = b00.b();
                y0 y00 = b00.a;
                rect0.set(v1, b00.d(), b00.c(), b00.a());
                scrimInsetsFrameLayout0.e(b00);
                if(!y00.l().equals(S1.d.e) && scrimInsetsFrameLayout0.a != null) {
                    z = false;
                }
                scrimInsetsFrameLayout0.setWillNotDraw(z);
                scrimInsetsFrameLayout0.postInvalidateOnAnimation();
                return y00.c();
            }
        }
    }

    @Override  // c2.d
    public void setExtras(Bundle bundle0) {
        ((ContentInfo.Builder)this.b).setExtras(bundle0);
    }

    @Override  // c2.d
    public void setFlags(int v) {
        ((ContentInfo.Builder)this.b).setFlags(v);
    }

    @Override  // d7.a
    public void t(e7.n n0) {
        this.b = n0;
        if(Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Registered Firebase Analytics event receiver for breadcrumbs", null);
        }
    }

    @Override
    public String toString() {
        return this.a == 8 ? "ContentInfoCompat{" + ((ContentInfo)this.b) + "}" : super.toString();
    }

    @Override  // c7.a
    public void u(Bundle bundle0) {
        ((c)(((V6.b)this.b))).a("clx", "_ae", bundle0);
    }

    public Object v(String s, String s1, oe.c c0) {
        ca.a a0;
        if(c0 instanceof ca.a) {
            a0 = (ca.a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new ca.a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new ca.a(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                d5.n.D(object0);
                a0.B = 1;
                object0 = ((Ba.i)((b)this.b).b).b(s, s1, u.w(((e0)o.a()).j()), a0);
                return object0 == a1 ? a1 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                d5.n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    private final void w(MenuBuilder menuBuilder0) {
    }

    private final void x(MenuBuilder menuBuilder0) {
    }

    public Object y(String s, String s1, oe.c c0) {
        ca.b b0;
        if(c0 instanceof ca.b) {
            b0 = (ca.b)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new ca.b(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new ca.b(this, c0);
        }
        Object object0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                d5.n.D(object0);
                b0.B = 1;
                object0 = ((Ba.i)((b)this.b).b).a(s, s1, b0);
                return object0 == a0 ? a0 : ApiResultKt.getOrNull(((ApiResult)object0));
            }
            case 1: {
                d5.n.D(object0);
                return ApiResultKt.getOrNull(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public com.google.gson.q z(Object object0) {
        com.google.gson.n n0 = ((com.google.gson.internal.bind.t)this.b).b;
        n0.getClass();
        if(object0 == null) {
            return com.google.gson.s.a;
        }
        Class class0 = object0.getClass();
        com.google.gson.internal.bind.j j0 = new com.google.gson.internal.bind.j();
        n0.n(object0, class0, j0);
        ArrayList arrayList0 = j0.o;
        if(!arrayList0.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + arrayList0);
        }
        return j0.w;
    }
}

