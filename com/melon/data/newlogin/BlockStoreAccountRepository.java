package com.melon.data.newlogin;

import android.content.Context;
import android.provider.Settings.Secure;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import d5.n;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import va.b;
import va.d;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/data/newlogin/BlockStoreAccountRepository;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BlockStoreAccountRepository {
    public final Context a;
    public final LogU b;

    @Inject
    public BlockStoreAccountRepository(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = context0;
        this.b = new LogU("BlockStoreAccountRepository");
    }

    public final Object a(c c0) {
        va.c c1;
        if(c0 instanceof va.c) {
            c1 = (va.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new va.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new va.c(this, c0);
        }
        Object object0 = c1.r;
        a a0 = a.a;
        switch(c1.B) {
            case 0: {
                n.D(object0);
                if(!NetUtils.isConnected()) {
                    return null;
                }
                try {
                    c1.B = 1;
                    object0 = BuildersKt.withContext(Dispatchers.getIO(), new d(this, null), c1);
                    if(object0 == a0) {
                        return a0;
                    label_20:
                        n.D(object0);
                    }
                    Charset charset0 = StandardCharsets.UTF_8;
                    q.f(charset0, "UTF_8");
                    String s = new String(((byte[])object0), charset0);
                    if(s.length() == 0) {
                        LogU.debug$default(this.b, "empty data", null, false, 6, null);
                        return null;
                    }
                    b b0 = (b)new com.google.gson.n().e(s, b.class);
                    String s1 = b0.c;
                    if(b0.a.length() == 0 || b0.b.length() == 0 || s1.length() == 0) {
                        throw new Exception("Invalid data");
                    }
                    String s2 = Settings.Secure.getString(this.a.getContentResolver(), "android_id");
                    q.f(s2, "getString(...)");
                    if(s1.equals(s2)) {
                        LogU.debug$default(this.b, "same device", null, false, 6, null);
                        return null;
                    }
                    return b0;
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_20;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.error$default(this.b, "retrieveAccount", exception0, false, 4, null);
        return null;
    }
}

