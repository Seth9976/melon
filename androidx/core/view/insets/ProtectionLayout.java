package androidx.core.view.insets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.o;
import com.facebook.appevents.c;
import f2.a;
import f2.d;
import java.util.ArrayList;
import java.util.List;

public class ProtectionLayout extends FrameLayout {
    public final ArrayList a;
    public a b;
    public static final Object c;

    static {
        ProtectionLayout.c = new Object();
    }

    public ProtectionLayout(Context context0) {
        super(context0);
        this.a = new ArrayList();
    }

    public ProtectionLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public ProtectionLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v, 0);
        this.a = new ArrayList();
    }

    public final void a() {
        ArrayList arrayList0 = this.a;
        if(!arrayList0.isEmpty()) {
            this.b = new a(this.getOrInstallSystemBarStateMonitor(), arrayList0);
            this.getChildCount();
            if(this.b.a.size() > 0) {
                if(this.b.a.get(0) != null) {
                    throw new ClassCastException();
                }
                this.getContext();
                throw null;
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(view0 != null && view0.getTag() != ProtectionLayout.c) {
            int v1 = this.b == null ? 0 : this.b.a.size();
            int v2 = this.getChildCount() - v1;
            if(v > v2 || v < 0) {
                v = v2;
            }
        }
        super.addView(view0, v, viewGroup$LayoutParams0);
    }

    public final void b() {
        if(this.b != null) {
            this.removeViews(this.getChildCount() - this.b.a.size(), this.b.a.size());
            if(this.b.a.size() > 0) {
                throw o.g(0, this.b.a);
            }
            a a0 = this.b;
            ArrayList arrayList0 = a0.a;
            if(!a0.d) {
                a0.d = true;
                a0.b.b.remove(a0);
                int v = arrayList0.size();
                if(v - 1 >= 0) {
                    throw o.g(v - 1, arrayList0);
                }
                arrayList0.clear();
            }
            this.b = null;
        }
    }

    private d getOrInstallSystemBarStateMonitor() {
        ViewGroup viewGroup0 = (ViewGroup)this.getRootView();
        Object object0 = viewGroup0.getTag(0x7F0A0B31);  // id:tag_system_bar_state_monitor
        if(object0 instanceof d) {
            return (d)object0;
        }
        d d0 = new d(viewGroup0);
        viewGroup0.setTag(0x7F0A0B31, d0);  // id:tag_system_bar_state_monitor
        return d0;
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.b != null) {
            this.b();
        }
        this.a();
        this.requestApplyInsets();
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b();
        ViewGroup viewGroup0 = (ViewGroup)this.getRootView();
        Object object0 = viewGroup0.getTag(0x7F0A0B31);  // id:tag_system_bar_state_monitor
        if(!(object0 instanceof d) || !((d)object0).b.isEmpty()) {
            return;
        }
        c c0 = new c(((d)object0), 24);
        ((d)object0).a.post(c0);
        viewGroup0.setTag(0x7F0A0B31, null);  // id:tag_system_bar_state_monitor
    }

    public void setProtections(List list0) {
        this.a.clear();
        this.a.addAll(list0);
        if(this.isAttachedToWindow()) {
            this.b();
            this.a();
            this.requestApplyInsets();
        }
    }
}

