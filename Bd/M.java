package bd;

import androidx.compose.runtime.l;
import com.google.firebase.b;
import ie.H;
import java.text.SimpleDateFormat;
import we.n;

public final class m implements n {
    public final long a;
    public final boolean b;
    public final SimpleDateFormat c;
    public final long d;

    public m(long v, boolean z, SimpleDateFormat simpleDateFormat0, long v1, int v2) {
        this.a = v;
        this.b = z;
        this.c = simpleDateFormat0;
        this.d = v1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object1).getClass();
        b.k(this.a, this.b, this.c, this.d, ((l)object0), 1);
        return H.a;
    }
}

