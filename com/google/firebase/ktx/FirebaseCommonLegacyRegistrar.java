package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import e.k;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import x1.a;

@Keep
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/firebase/ktx/FirebaseCommonLegacyRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "<init>", "()V", "", "LY6/c;", "getComponents", "()Ljava/util/List;", "com.google.firebase-firebase-common-ktx"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FirebaseCommonLegacyRegistrar implements ComponentRegistrar {
    @Override  // com.google.firebase.components.ComponentRegistrar
    @NotNull
    public List getComponents() {
        return k.z(a.q("fire-core-ktx", "21.0.0"));
    }
}

