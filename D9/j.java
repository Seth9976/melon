package d9;

import De.d;
import S2.a;
import S2.c;
import androidx.lifecycle.f0;
import androidx.lifecycle.n0;
import androidx.lifecycle.n;
import androidx.lifecycle.q0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.LogU;
import java.util.LinkedHashSet;
import k8.t;
import kc.d3;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import o9.b;

public abstract class j {
    public static final LinkedHashSet a;

    static {
        j.a = new LinkedHashSet();
    }

    public static h a() {
        k k0 = () -> ((q0)k.b.getValue());
        MelonAppBase.Companion.getClass();
        n0 n00 = new n0(t.a());
        q0 q00 = k0.getViewModelStore();
        c c0 = k0 instanceof n ? ((n)k0).getDefaultViewModelCreationExtras() : a.b;
        q.g(q00, "store");
        q.g(c0, "defaultCreationExtras");
        b b0 = new b(q00, n00, c0);
        d d0 = df.d.y(h.class);
        String s = d0.l();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (h)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
    }

    public static h b(String s) {
        q.g(s, "tag");
        j.c(s);
        return j.a();
    }

    public static void c(String s) {
        q.g(s, "tag");
        LogU.Companion.d("LyricViewModelProvider", "registerView() tag = " + s);
        h h0 = j.a();
        if(!h0.s) {
            h0.s = true;
            h0.e(((d3)h0.f).f());
        }
        LinkedHashSet linkedHashSet0 = j.a;
        if(!linkedHashSet0.contains(s)) {
            linkedHashSet0.add(s);
            if(linkedHashSet0.size() == 1) {
                BuildersKt__Builders_commonKt.launch$default(f0.h(j.a()), null, null, new i(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
            }
        }
    }

    public static void d(String s) {
        q.g(s, "tag");
        LogU.Companion.d("LyricViewModelProvider", "unregisterView() tag = " + s);
        j.a.remove(s);
        if(j.a.isEmpty()) {
            h h0 = j.a();
            LogU.debug$default(h0.b, "cancelJob", null, false, 6, null);
            Job job0 = h0.g;
            if(job0 != null) {
                DefaultImpls.cancel$default(job0, null, 1, null);
            }
        }
    }
}

