package Q;

import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import we.a;

public final class s extends r implements a {
    public final int f;
    public final K g;
    public final CoroutineScope h;

    public s(K k0, CoroutineScope coroutineScope0, int v) {
        this.f = v;
        this.g = k0;
        this.h = coroutineScope0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                K k1 = this.g;
                if(k1.c()) {
                    u u0 = new u(k1, null);
                    BuildersKt__Builders_commonKt.launch$default(this.h, null, null, u0, 3, null);
                    return true;
                }
                return false;
            }
            case 1: {
                K k2 = this.g;
                if(k2.d()) {
                    v v1 = new v(k2, null);
                    BuildersKt__Builders_commonKt.launch$default(this.h, null, null, v1, 3, null);
                    return true;
                }
                return false;
            }
            case 2: {
                K k3 = this.g;
                if(k3.c()) {
                    u u1 = new u(k3, null);
                    BuildersKt__Builders_commonKt.launch$default(this.h, null, null, u1, 3, null);
                    return true;
                }
                return false;
            }
            default: {
                K k0 = this.g;
                if(k0.d()) {
                    v v0 = new v(k0, null);
                    BuildersKt__Builders_commonKt.launch$default(this.h, null, null, v0, 3, null);
                    return true;
                }
                return false;
            }
        }
    }
}

