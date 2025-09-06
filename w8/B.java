package W8;

import A0.f;
import android.content.Context;
import com.iloen.melon.fragments.detail.ui.ListeningGraphKt;
import java.util.List;
import we.k;

public final class b implements k {
    public final float a;
    public final Context b;
    public final List c;
    public final long d;
    public final float e;

    public b(float f, Context context0, List list0, long v, float f1) {
        this.a = f;
        this.b = context0;
        this.c = list0;
        this.d = v;
        this.e = f1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ListeningGraphKt.a(this.a, this.b, this.c, this.d, this.e, ((f)object0));
    }
}

