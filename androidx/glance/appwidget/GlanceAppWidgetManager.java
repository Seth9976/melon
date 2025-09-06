package androidx.glance.appwidget;

import B2.o;
import D2.W;
import D2.X;
import D2.Y;
import D2.a0;
import D2.b0;
import D2.c0;
import D2.i0;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import d3.g;
import d5.n;
import e1.x;
import ie.H;
import ie.m;
import ie.r;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import je.C;
import je.u;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import l2.i;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import p2.b;
import q2.f;
import q2.h;
import w8.T;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Landroidx/glance/appwidget/GlanceAppWidgetManager;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "D2/W", "D2/X", "glance-appwidget_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class GlanceAppWidgetManager {
    public final Context a;
    public final AppWidgetManager b;
    public final r c;
    public static final W d;
    public static final b e;
    public static i f;
    public static final f g;

    static {
        GlanceAppWidgetManager.d = new W();  // 初始化器: Ljava/lang/Object;-><init>()V
        GlanceAppWidgetManager.e = x.M("GlanceAppWidgetManager", null, null, 14);
        GlanceAppWidgetManager.g = new f("list::Providers");
    }

    public GlanceAppWidgetManager(@NotNull Context context0) {
        this.a = context0;
        this.b = AppWidgetManager.getInstance(context0);
        this.c = g.Q(new o(this, 3));
    }

    public final Serializable a(Class class0, c c0) {
        GlanceAppWidgetManager glanceAppWidgetManager0;
        a0 a00;
        if(c0 instanceof a0) {
            a00 = (a0)c0;
            int v = a00.E;
            if((v & 0x80000000) == 0) {
                a00 = new a0(this, c0);
            }
            else {
                a00.E = v ^ 0x80000000;
            }
        }
        else {
            a00 = new a0(this, c0);
        }
        Object object0 = a00.B;
        Serializable serializable0 = a.a;
        switch(a00.E) {
            case 0: {
                n.D(object0);
                a00.r = this;
                a00.w = class0;
                a00.E = 1;
                object0 = this.b(a00);
                if(object0 == serializable0) {
                    return serializable0;
                }
                glanceAppWidgetManager0 = this;
                break;
            }
            case 1: {
                class0 = a00.w;
                glanceAppWidgetManager0 = a00.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        String s = class0.getCanonicalName();
        if(s == null) {
            throw new IllegalArgumentException("no canonical provider name");
        }
        List list0 = (List)((X)object0).b.get(s);
        if(list0 == null) {
            return w.a;
        }
        Serializable serializable1 = new ArrayList();
        for(Object object1: list0) {
            int[] arr_v = glanceAppWidgetManager0.b.getAppWidgetIds(((ComponentName)object1));
            ArrayList arrayList0 = new ArrayList(arr_v.length);
            for(int v1 = 0; v1 < arr_v.length; ++v1) {
                arrayList0.add(new D2.f(arr_v[v1]));
            }
            u.U(((Collection)serializable1), arrayList0);
        }
        return serializable1;
    }

    public final Object b(c c0) {
        h h0;
        GlanceAppWidgetManager glanceAppWidgetManager1;
        GlanceAppWidgetManager glanceAppWidgetManager0;
        b0 b00;
        if(c0 instanceof b0) {
            b00 = (b0)c0;
            int v = b00.E;
            if((v & 0x80000000) == 0) {
                b00 = new b0(this, c0);
            }
            else {
                b00.E = v ^ 0x80000000;
            }
        }
        else {
            b00 = new b0(this, c0);
        }
        Object object0 = b00.B;
        a a0 = a.a;
        W w0 = GlanceAppWidgetManager.d;
        f f0 = GlanceAppWidgetManager.g;
        switch(b00.E) {
            case 0: {
                n.D(object0);
                Flow flow0 = ((i)this.c.getValue()).getData();
                b00.r = this;
                b00.w = this;
                b00.E = 1;
                object0 = FlowKt.first(flow0, b00);
                if(object0 == a0) {
                    return a0;
                }
                glanceAppWidgetManager0 = this;
                glanceAppWidgetManager1 = glanceAppWidgetManager0;
                goto label_28;
            }
            case 1: {
                glanceAppWidgetManager0 = b00.w;
                glanceAppWidgetManager1 = b00.r;
                n.D(object0);
            label_28:
                if(((h)object0).b(f0) == null) {
                    object0 = null;
                }
                h0 = (h)object0;
                if(h0 == null) {
                    b00.r = glanceAppWidgetManager0;
                    b00.w = null;
                    b00.E = 2;
                    Iterable iterable0 = glanceAppWidgetManager1.b.getInstalledProviders();
                    ArrayList arrayList0 = new ArrayList();
                    for(Object object1: iterable0) {
                        if(q.b(((AppWidgetProviderInfo)object1).provider.getPackageName(), "com.iloen.melon")) {
                            arrayList0.add(object1);
                        }
                    }
                    ArrayList arrayList1 = new ArrayList();
                    for(Object object2: arrayList0) {
                        w0.getClass();
                        Object object3 = Class.forName(((AppWidgetProviderInfo)object2).provider.getClassName()).getDeclaredConstructor(null).newInstance(null);
                        GlanceAppWidgetReceiver glanceAppWidgetReceiver0 = object3 instanceof GlanceAppWidgetReceiver ? ((GlanceAppWidgetReceiver)object3) : null;
                        if(glanceAppWidgetReceiver0 != null) {
                            arrayList1.add(glanceAppWidgetReceiver0);
                        }
                    }
                    object0 = ((i)glanceAppWidgetManager1.c.getValue()).a(new Y(arrayList1, null), b00);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_57;
                }
                goto label_58;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        n.D(object0);
    label_57:
        h0 = (h)object0;
    label_58:
        Set set0 = (Set)h0.b(f0);
        if(set0 == null) {
            return new X(je.x.a, je.x.a);
        }
        ArrayList arrayList2 = new ArrayList();
        for(Object object4: set0) {
            ComponentName componentName0 = new ComponentName("com.iloen.melon", ((String)object4));
            String s = (String)h0.b(W.a(w0, ((String)object4)));
            m m0 = s == null ? null : new m(componentName0, s);
            if(m0 != null) {
                arrayList2.add(m0);
            }
        }
        Map map0 = C.Y(arrayList2);
        Iterable iterable1 = map0.entrySet();
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        for(Object object5: iterable1) {
            String s1 = (String)((Map.Entry)object5).getValue();
            ArrayList arrayList3 = linkedHashMap0.get(s1);
            if(arrayList3 == null) {
                arrayList3 = new ArrayList();
                linkedHashMap0.put(s1, arrayList3);
            }
            arrayList3.add(((ComponentName)((Map.Entry)object5).getKey()));
        }
        return new X(map0, linkedHashMap0);
    }

    public final Object c(GlanceAppWidgetReceiver glanceAppWidgetReceiver0, T t0, i0 i00) {
        GlanceAppWidgetManager.d.getClass();
        String s = glanceAppWidgetReceiver0.getClass().getCanonicalName();
        if(s == null) {
            throw new IllegalArgumentException("no receiver name");
        }
        String s1 = t0.getClass().getCanonicalName();
        if(s1 == null) {
            throw new IllegalArgumentException("no provider name");
        }
        Object object0 = ((i)this.c.getValue()).a(new c0(s, s1, null), i00);
        return object0 == a.a ? object0 : H.a;
    }
}

