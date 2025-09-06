package m8;

import A8.j;
import com.iloen.melon.activity.BaseActivity;
import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mb.f;
import we.k;

public final class z implements k {
    public final int a;
    public final f b;
    public final BaseActivity c;
    public final o d;

    public z(f f0, BaseActivity baseActivity0, o o0, int v) {
        this.a = v;
        this.b = f0;
        this.c = baseActivity0;
        this.d = o0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new E(this.b, this.c, ((j)object0), this.d, null), 3, null);
            return H.a;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new A(this.b, this.c, ((j)object0), this.d, null), 3, null);
        return H.a;
    }
}

