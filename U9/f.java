package u9;

import Cb.i;
import android.content.Context;
import com.iloen.melon.utils.log.LogU;
import d3.g;
import ie.j;
import ie.k;
import ie.r;
import java.io.File;
import java.util.HashMap;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import va.e;

public final class f {
    public final Context a;
    public final String b;
    public final LogU c;
    public final Object d;
    public final r e;
    public final String f;
    public static final c g;
    public static final HashMap h;
    public static final CoroutineDispatcher i;

    static {
        f.g = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        f.h = new HashMap();
        f.i = Dispatchers.getIO();
    }

    public f(Context context0, String s) {
        this.a = context0;
        this.b = s;
        this.c = new LogU("Storage");
        b b0 = new b(this, 0);
        this.d = g.P(k.c, b0);
        this.e = g.Q(new b(this, 1));
        this.f = e.h(i.i(this.a()), "/");
    }

    public final File a() {
        return (File)this.e.getValue();
    }

    public final void b() {
        if(!((File)((j)this.d).getValue()).exists()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(f.i), null, null, new u9.e(this, null), 3, null);
    }
}

