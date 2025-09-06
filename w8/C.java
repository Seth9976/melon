package W8;

import androidx.compose.runtime.l;
import com.iloen.melon.fragments.detail.ui.ListeningGraphKt;
import java.util.List;
import we.n;

public final class c implements n {
    public final List a;
    public final float b;
    public final int c;

    public c(List list0, float f, int v) {
        this.a = list0;
        this.b = f;
        this.c = v;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ListeningGraphKt.c(this.a, this.b, this.c, ((l)object0), ((int)(((Integer)object1))));
    }
}

