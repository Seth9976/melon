package m8;

import A8.j;
import com.iloen.melon.activity.BaseActivity;
import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mb.f;
import we.k;

public final class u implements k {
    public final int a;
    public final f b;
    public final BaseActivity c;
    public final mb.k d;

    public u(f f0, BaseActivity baseActivity0, mb.k k0, int v) {
        this.a = v;
        this.b = f0;
        this.c = baseActivity0;
        this.d = k0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new v(this.b, this.c, ((j)object0), this.d, null), 3, null);
                return H.a;
            }
            case 1: {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new x(this.b, this.c, ((j)object0), this.d, null), 3, null);
                return H.a;
            }
            default: {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new L(this.b, this.c, ((j)object0), this.d, null), 3, null);
                return H.a;
            }
        }
    }
}

