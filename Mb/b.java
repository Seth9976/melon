package mb;

import b3.Z;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.melon.data.newlogin.BlockStoreAccountRepository;
import d5.n;
import ie.H;
import kb.D;
import kotlin.jvm.internal.q;
import oe.c;
import va.e0;

public final class b {
    public final D a;
    public final s b;
    public final k c;
    public final LogU d;

    public b(D d0, s s0, k k0) {
        q.g(k0, "loginUseCase");
        super();
        this.a = d0;
        this.b = s0;
        this.c = k0;
        LogU logU0 = Z.g("BlockStoreLoginUseCase", true);
        logU0.setCategory(Category.Login);
        this.d = logU0;
    }

    public final Object a(c c0) {
        va.b b0;
        a a0;
        if(c0 instanceof a) {
            a0 = (a)c0;
            int v = a0.D;
            if((v & 0x80000000) == 0) {
                a0 = new a(this, c0);
            }
            else {
                a0.D = v ^ 0x80000000;
            }
        }
        else {
            a0 = new a(this, c0);
        }
        Object object0 = a0.w;
        ne.a a1 = ne.a.a;
        D d0 = this.a;
        k k0 = this.c;
        H h0 = H.a;
        switch(a0.D) {
            case 0: {
                n.D(object0);
                if(!NetUtils.isConnected()) {
                    LogU.debug$default(this.d, "retrieveAccountFromBlockStoreAndLogin skipped because of no network connection", null, false, 6, null);
                    return h0;
                }
                if(((e0)k0).m()) {
                    LogU.debug$default(this.d, "retrieveAccountFromBlockStoreAndLogin skipped because of already login", null, false, 6, null);
                    return h0;
                }
                a0.D = 1;
                object0 = ((BlockStoreAccountRepository)d0.b).a(a0);
                if(object0 == a1) {
                    return a1;
                }
                goto label_30;
            }
            case 1: {
                n.D(object0);
            label_30:
                b0 = (va.b)object0;
                d0.q();
                if(b0 == null) {
                    LogU.debug$default(this.d, "retrieveAccountFromBlockStoreAndLogin fail", null, false, 6, null);
                    return h0;
                }
                a0.r = b0;
                a0.D = 2;
                object0 = this.b.b(b0.a, b0.b, a0);
                if(object0 == a1) {
                    return a1;
                }
                break;
            }
            case 2: {
                b0 = a0.r;
                n.D(object0);
                break;
            }
            case 3: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!((Boolean)object0).booleanValue()) {
            LogU.debug$default(this.d, "tokenChecking fail", null, false, 6, null);
            return h0;
        }
        a0.r = null;
        a0.D = 3;
        return ((e0)k0).x(b0.a, b0.b, a0) == a1 ? a1 : h0;
    }
}

