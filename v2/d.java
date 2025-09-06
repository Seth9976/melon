package v2;

import B3.q;
import Z1.a;
import a7.b;
import android.os.Build.VERSION;
import df.v;
import java.util.ArrayList;
import java.util.Set;
import y8.s;

public final class d extends df.d {
    public final b g;

    public d(b b0) {
        this.g = b0;
    }

    @Override  // df.d
    public final void C(Throwable throwable0) {
        ((h)this.g.a).f(throwable0);
    }

    @Override  // df.d
    public final void D(o9.b b0) {
        b b1 = this.g;
        b1.c = b0;
        o9.b b2 = (o9.b)b1.c;
        Set set0 = Build.VERSION.SDK_INT < 34 ? v.x() : k.a();
        s s0 = new s();  // 初始化器: Ljava/lang/Object;-><init>()V
        s0.a = ((h)b1.a).g;
        s0.b = b2;
        s0.c = ((h)b1.a).i;
        if(!set0.isEmpty()) {
            for(Object object0: set0) {
                String s1 = new String(((int[])object0), 0, ((int[])object0).length);
                s0.t(s1, 0, s1.length(), 1, true, new q(s1, 8));
            }
        }
        b1.b = s0;
        ((h)b1.a).getClass();
        ArrayList arrayList0 = new ArrayList();
        ((h)b1.a).a.writeLock().lock();
        try {
            ((h)b1.a).c = 1;
            arrayList0.addAll(((h)b1.a).b);
            ((h)b1.a).b.clear();
        }
        finally {
            ((h)b1.a).a.writeLock().unlock();
        }
        a a0 = new a(arrayList0, ((h)b1.a).c, null);
        ((h)b1.a).d.post(a0);
    }
}

