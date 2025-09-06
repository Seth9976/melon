package R5;

import android.content.Context;
import com.google.android.datatransport.cct.CctBackendFactory;
import java.util.HashMap;
import x9.a;

public final class f {
    public final a a;
    public final d b;
    public final HashMap c;

    public f(Context context0, d d0) {
        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.b = null;
        a0.a = context0;
        super();
        this.c = new HashMap();
        this.a = a0;
        this.b = d0;
    }

    public final h a(String s) {
        synchronized(this) {
            if(this.c.containsKey(s)) {
                return (h)this.c.get(s);
            }
            CctBackendFactory cctBackendFactory0 = this.a.r(s);
            if(cctBackendFactory0 == null) {
                return null;
            }
            h h1 = cctBackendFactory0.create(new b(this.b.a, this.b.b, this.b.c, s));
            this.c.put(s, h1);
            return h1;
        }
    }
}

