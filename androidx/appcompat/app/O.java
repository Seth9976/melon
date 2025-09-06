package androidx.appcompat.app;

import K.m;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.p;
import androidx.fragment.app.I;
import androidx.fragment.app.a;
import androidx.fragment.app.l0;
import androidx.media3.common.d;
import androidx.media3.session.legacy.V;
import androidx.recyclerview.widget.RecyclerView;
import b3.i0;
import e0.b;
import java.util.ArrayList;
import java.util.regex.Matcher;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;
import r1.f;
import y0.s;

public abstract class o {
    public static void A(String s, String s1, String s2) {
        Log.w(s2, s + s1);
    }

    public static boolean B(d d0, MutableStateFlow mutableStateFlow0, Object object0) {
        return mutableStateFlow0.compareAndSet(object0, new i0(d0));
    }

    public static int C(int v, int v1, int v2, int v3) [...] // Inlined contents

    public static String D(int v) {
        switch(v) {
            case 1: {
                return "NONE";
            }
            case 2: {
                return "ADDING";
            }
            case 3: {
                return "REMOVING";
            }
            default: {
                return "null";
            }
        }
    }

    public static String E(int v) {
        switch(v) {
            case 1: {
                return "REMOVED";
            }
            case 2: {
                return "VISIBLE";
            }
            case 3: {
                return "GONE";
            }
            case 4: {
                return "INVISIBLE";
            }
            default: {
                return "null";
            }
        }
    }

    public static final void a(int v, View view0, ViewGroup viewGroup0) {
        q.g(view0, "view");
        q.g(viewGroup0, "container");
        if(l0.P(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Calling apply state");
        }
        int v1 = b.b(v);
        ViewGroup viewGroup1 = null;
        if(v1 == 0) {
            ViewParent viewParent1 = view0.getParent();
            if(viewParent1 instanceof ViewGroup) {
                viewGroup1 = (ViewGroup)viewParent1;
            }
            if(viewGroup1 != null) {
                if(l0.P(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view0 + " from container " + viewGroup1);
                }
                viewGroup1.removeView(view0);
            }
        }
        else {
            switch(v1) {
                case 1: {
                    if(l0.P(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view0 + " to VISIBLE");
                    }
                    ViewParent viewParent0 = view0.getParent();
                    if(viewParent0 instanceof ViewGroup) {
                        viewGroup1 = (ViewGroup)viewParent0;
                    }
                    if(viewGroup1 == null) {
                        if(l0.P(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Adding view " + view0 + " to Container " + viewGroup0);
                        }
                        viewGroup0.addView(view0);
                    }
                    view0.setVisibility(0);
                    return;
                }
                case 2: {
                    if(l0.P(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view0 + " to GONE");
                    }
                    view0.setVisibility(8);
                    return;
                }
            }
            if(v1 == 3) {
                if(l0.P(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view0 + " to INVISIBLE");
                }
                view0.setVisibility(4);
            }
        }
    }

    public static int b(int v, int v1, int v2, int v3) [...] // Inlined contents

    public static int c(Matcher matcher0, String s, int v, ArrayList arrayList0) {
        arrayList0.add(s.subSequence(v, matcher0.start()).toString());
        return matcher0.end();
    }

    public static m d(p p0) {
        m m0 = new m();
        p0.l0(m0);
        return m0;
    }

    public static View e(ViewGroup viewGroup0, int v, ViewGroup viewGroup1, boolean z) {
        return LayoutInflater.from(viewGroup0.getContext()).inflate(v, viewGroup1, z);
    }

    public static a f(l0 l00, l0 l01) {
        l00.getClass();
        return new a(l01);
    }

    public static ClassCastException g(int v, ArrayList arrayList0) {
        arrayList0.get(v).getClass();
        return new ClassCastException();
    }

    public static String h(int v, int v1, String s, String s1, String s2) [...] // Inlined contents

    public static String i(int v, String s) [...] // Inlined contents

    public static String j(int v, String s, String s1) [...] // Inlined contents

    public static String k(Uri uri0, String s) [...] // Inlined contents

    public static String l(RecyclerView recyclerView0, StringBuilder stringBuilder0) {
        stringBuilder0.append(recyclerView0.y());
        return stringBuilder0.toString();
    }

    public static String m(Object object0, String s) [...] // Inlined contents

    public static String n(String s, I i0, String s1) [...] // Inlined contents

    public static String o(String s, String s1, String s2, String s3) [...] // Inlined contents

    public static String p(String s, boolean z) [...] // Inlined contents

    public static String q(StringBuilder stringBuilder0, int v, char c) {
        stringBuilder0.append(v);
        stringBuilder0.append(c);
        return stringBuilder0.toString();
    }

    public static String r(StringBuilder stringBuilder0, String s, char c) {
        stringBuilder0.append(s);
        stringBuilder0.append(c);
        return stringBuilder0.toString();
    }

    public static String s(StringBuilder stringBuilder0, boolean z, String s) {
        stringBuilder0.append(z);
        stringBuilder0.append(s);
        return stringBuilder0.toString();
    }

    public static StringBuilder t(int v, int v1, String s, String s1, String s2) {
        StringBuilder stringBuilder0 = new StringBuilder(s);
        stringBuilder0.append(v);
        stringBuilder0.append(s1);
        stringBuilder0.append(v1);
        stringBuilder0.append(s2);
        return stringBuilder0;
    }

    public static StringBuilder u(int v, String s, String s1, String s2, String s3) {
        StringBuilder stringBuilder0 = new StringBuilder(s);
        stringBuilder0.append(s1);
        stringBuilder0.append(s2);
        stringBuilder0.append(v);
        stringBuilder0.append(s3);
        return stringBuilder0;
    }

    public static void v(float f, StringBuilder stringBuilder0, String s) {
        stringBuilder0.append(f.b(f));
        stringBuilder0.append(s);
    }

    public static void w(int v, String s, ArrayList arrayList0) {
        arrayList0.add(s.subSequence(v, s.length()).toString());
    }

    public static void x(long v, String s, StringBuilder stringBuilder0) {
        stringBuilder0.append(s.j(v));
        stringBuilder0.append(s);
    }

    public static void y(V v0, long v1) {
        v0.h().j();
        v0.x(v1);
    }

    public static void z(Object object0) {
        if(object0 != null) {
            throw new ClassCastException();
        }
    }
}

