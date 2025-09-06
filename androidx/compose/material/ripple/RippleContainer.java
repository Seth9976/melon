package androidx.compose.material.ripple;

import a0.h;
import android.content.Context;
import android.view.ViewGroup;
import d5.c;
import e.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material/ripple/RippleContainer;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "material-ripple_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class RippleContainer extends ViewGroup {
    public final int a;
    public final ArrayList b;
    public final ArrayList c;
    public final c d;
    public int e;

    public RippleContainer(@NotNull Context context0) {
        super(context0);
        this.a = 5;
        ArrayList arrayList0 = new ArrayList();
        this.b = arrayList0;
        ArrayList arrayList1 = new ArrayList();
        this.c = arrayList1;
        this.d = new c(5);
        this.setClipChildren(false);
        RippleHostView rippleHostView0 = new RippleHostView(context0);
        this.addView(rippleHostView0);
        arrayList0.add(rippleHostView0);
        arrayList1.add(rippleHostView0);
        this.e = 1;
        this.setTag(0x7F0A052E, Boolean.TRUE);  // id:hide_in_inspector_tag
    }

    public final RippleHostView a(h h0) {
        LinkedHashMap linkedHashMap0 = (LinkedHashMap)this.d.b;
        LinkedHashMap linkedHashMap1 = (LinkedHashMap)this.d.b;
        LinkedHashMap linkedHashMap2 = (LinkedHashMap)this.d.c;
        RippleHostView rippleHostView0 = (RippleHostView)linkedHashMap0.get(h0);
        if(rippleHostView0 != null) {
            return rippleHostView0;
        }
        q.g(this.c, "<this>");
        RippleHostView rippleHostView1 = (RippleHostView)(this.c.isEmpty() ? null : this.c.remove(0));
        if(rippleHostView1 == null) {
            ArrayList arrayList0 = this.b;
            if(this.e > k.s(arrayList0)) {
                rippleHostView1 = new RippleHostView(this.getContext());
                this.addView(rippleHostView1);
                arrayList0.add(rippleHostView1);
            }
            else {
                rippleHostView1 = (RippleHostView)arrayList0.get(this.e);
                h h1 = (h)linkedHashMap2.get(rippleHostView1);
                if(h1 != null) {
                    h1.O();
                    RippleHostView rippleHostView2 = (RippleHostView)linkedHashMap1.get(h1);
                    if(rippleHostView2 != null) {
                        h h2 = (h)linkedHashMap2.remove(rippleHostView2);
                    }
                    linkedHashMap1.remove(h1);
                    rippleHostView1.c();
                }
            }
            int v = this.e;
            this.e = v < this.a - 1 ? v + 1 : 0;
        }
        linkedHashMap1.put(h0, rippleHostView1);
        linkedHashMap2.put(rippleHostView1, h0);
        return rippleHostView1;
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        this.setMeasuredDimension(0, 0);
    }

    @Override  // android.view.View, android.view.ViewParent
    public final void requestLayout() {
    }
}

