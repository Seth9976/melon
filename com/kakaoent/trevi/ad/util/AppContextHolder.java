package com.kakaoent.trevi.ad.util;

import android.content.Context;
import com.kakaoent.trevi.ad.exception.TreviAdContextNotFoundException;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001A\u0004\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/kakaoent/trevi/ad/util/AppContextHolder;", "", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "contextHolder", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class AppContextHolder {
    @NotNull
    public static final AppContextHolder INSTANCE;
    @Nullable
    private static Context contextHolder;

    static {
        AppContextHolder.INSTANCE = new AppContextHolder();
    }

    @NotNull
    public final Context getContext() {
        try {
            Context context0 = AppContextHolder.contextHolder;
            q.d(context0);
            return context0;
        }
        catch(Exception unused_ex) {
            throw new TreviAdContextNotFoundException(null, 1, null);
        }
    }

    public final void setContext(@NotNull Context context0) {
        q.g(context0, "context");
        AppContextHolder.contextHolder = context0;
    }
}

