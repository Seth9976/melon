package com.google.firebase;

import X6.a;
import X6.d;
import Y6.b;
import Y6.c;
import Y6.k;
import Y6.s;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/firebase/FirebaseCommonKtxRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "<init>", "()V", "", "LY6/c;", "getComponents", "()Ljava/util/List;", "com.google.firebase-firebase-common"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    @Override  // com.google.firebase.components.ComponentRegistrar
    @NotNull
    public List getComponents() {
        b b0 = c.a(new s(a.class, CoroutineDispatcher.class));
        b0.a(new k(new s(a.class, Executor.class), 1, 0));
        b0.g = f.b;
        c c0 = b0.b();
        b b1 = c.a(new s(X6.c.class, CoroutineDispatcher.class));
        b1.a(new k(new s(X6.c.class, Executor.class), 1, 0));
        b1.g = f.c;
        c c1 = b1.b();
        b b2 = c.a(new s(X6.b.class, CoroutineDispatcher.class));
        b2.a(new k(new s(X6.b.class, Executor.class), 1, 0));
        b2.g = f.d;
        c c2 = b2.b();
        b b3 = c.a(new s(d.class, CoroutineDispatcher.class));
        b3.a(new k(new s(d.class, Executor.class), 1, 0));
        b3.g = f.e;
        return e.k.A(new c[]{c0, c1, c2, b3.b()});
    }
}

