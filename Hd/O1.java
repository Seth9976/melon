package hd;

import com.iloen.melon.utils.Navigator;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class o1 implements k {
    public final int a;
    public final s1 b;

    public o1(s1 s10, int v) {
        this.a = v;
        this.b = s10;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((String)object0), "yearMonth");
            this.b.f = (String)object0;
            Navigator.INSTANCE.openMusicDnaMonthlyLog(((String)object0), false);
            return H.a;
        }
        q.g(((String)object0), "yearMonth");
        O1 o10 = (O1)this.b.getViewModel();
        o10.getClass();
        o10.f = (String)object0;
        com.melon.ui.o1.loadPage$default(this.b, true, null, 2, null);
        return H.a;
    }
}

