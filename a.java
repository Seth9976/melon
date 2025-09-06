import androidx.compose.runtime.l;
import com.google.firebase.b;
import ie.H;
import java.util.List;
import we.n;

public final class a implements n {
    public final List a;
    public final String b;
    public final float c;
    public final float d;
    public final int e;
    public final we.a f;

    public a(List list0, String s, float f, float f1, int v, we.a a0, int v1) {
        this.a = list0;
        this.b = s;
        this.c = f;
        this.d = f1;
        this.e = v;
        this.f = a0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object1).getClass();
        b.c(this.a, this.b, this.c, this.d, this.e, this.f, ((l)object0), 1);
        return H.a;
    }
}

