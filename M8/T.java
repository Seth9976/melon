package m8;

import com.iloen.melon.activity.BaseActivity;
import ie.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mb.f;
import mb.j;
import we.k;

public final class t implements k {
    public final int a;
    public final f b;
    public final BaseActivity c;
    public final o d;
    public final String e;
    public final j f;
    public final String g;
    public final String h;

    public t(f f0, BaseActivity baseActivity0, o o0, String s, j j0, String s1, String s2) {
        this.a = 1;
        super();
        this.b = f0;
        this.c = baseActivity0;
        this.d = o0;
        this.e = s;
        this.f = j0;
        this.g = s1;
        this.h = s2;
    }

    public t(f f0, BaseActivity baseActivity0, o o0, j j0, String s, String s1, String s2) {
        this.a = 0;
        super();
        this.b = f0;
        this.c = baseActivity0;
        this.d = o0;
        this.f = j0;
        this.e = s;
        this.g = s1;
        this.h = s2;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new J(((A8.j)object0), this.c, this.e, this.g, this.h, null, this.d, this.b, this.f), 3, null);
            return H.a;
        }
        q.g(((A8.j)object0), "kakaoAuthType");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new m8.H(((A8.j)object0), this.c, this.e, this.g, this.h, null, this.d, this.b, this.f), 3, null);
        return H.a;
    }
}

