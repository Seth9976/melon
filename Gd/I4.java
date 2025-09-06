package gd;

import Pc.e;
import android.content.Context;
import com.google.firebase.b;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.melon.ui.i3;
import com.melon.ui.q4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import p8.f;
import p8.g;
import p8.s;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lgd/i4;", "Lcom/melon/ui/i3;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class i4 extends i3 {
    public Context e;
    public final HashMap f;

    @Inject
    public i4() {
        this.f = new HashMap();
    }

    @Override  // com.melon.ui.i3
    public final List c() {
        List list0 = new ArrayList();
        Context context0 = this.e;
        if(context0 != null) {
            String[] arr_s = context0.getResources().getStringArray(0x7F030016);  // array:melondj_playlist_period_tabs
            q.f(arr_s, "getStringArray(...)");
            for(int v = 0; v < arr_s.length; ++v) {
                String s = arr_s[v];
                TabInfo tabInfo0 = new TabInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
                tabInfo0.a = 3;
                tabInfo0.b = s;
                tabInfo0.c = 0;
                tabInfo0.d = null;
                tabInfo0.e = v;
                tabInfo0.f = 0;
                tabInfo0.g = 0;
                tabInfo0.h = 0;
                tabInfo0.i = -1;
                tabInfo0.j = -1.0f;
                tabInfo0.k = -1.0f;
                tabInfo0.l = -1.0f;
                tabInfo0.m = -1.0f;
                tabInfo0.n = 1.0f;
                tabInfo0.o = -1;
                ((ArrayList)list0).add(tabInfo0);
            }
            return list0;
        }
        q.m("context");
        throw null;
    }

    public final f d() {
        String s = null;
        if(this.getTiaraProperty() == null) {
            return null;
        }
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        s s1 = this.getTiaraProperty();
        f0.b = s1 == null ? null : s1.a;
        s s2 = this.getTiaraProperty();
        f0.c = s2 == null ? null : s2.b;
        s s3 = this.getTiaraProperty();
        if(s3 != null) {
            s = s3.c;
        }
        f0.I = s;
        return f0;
    }

    @Override  // com.melon.ui.n0
    public final void onUserEvent(e e0) {
        q.g(e0, "userEvent");
        if(e0 instanceof C4) {
            String s = ((C4)e0).b;
            if(s.length() > 0) {
                this.sendUiEvent(new q4(28, ((C4)e0).a, s, null, null));
                f f0 = this.d();
                if(f0 != null) {
                    Context context0 = this.e;
                    if(context0 != null) {
                        q.f("GNB", "getString(...)");
                        if(this.e != null) {
                            b.O(f0, context0, null, "GNB", null, "안내", 0, null, null, null, null, null, false, 0, 8170);
                            return;
                        }
                        q.m("context");
                        throw null;
                    }
                    q.m("context");
                    throw null;
                }
            }
            return;
        }
        super.onUserEvent(e0);
    }
}

