package com.google.firebase.crashlytics.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import ie.d;
import java.util.List;
import je.w;
import kotlin.Metadata;
import o7.a;
import org.jetbrains.annotations.NotNull;

@Keep
@d
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/google/firebase/crashlytics/ktx/FirebaseCrashlyticsKtxRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "<init>", "()V", "", "LY6/c;", "getComponents", "()Ljava/util/List;", "Companion", "o7/a", "com.google.firebase-firebase-crashlytics"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FirebaseCrashlyticsKtxRegistrar implements ComponentRegistrar {
    @NotNull
    public static final a Companion;

    static {
        FirebaseCrashlyticsKtxRegistrar.Companion = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // com.google.firebase.components.ComponentRegistrar
    @NotNull
    public List getComponents() {
        return w.a;
    }
}

