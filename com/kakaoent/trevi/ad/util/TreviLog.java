package com.kakaoent.trevi.ad.util;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\b\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001D\u0010\n\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\n\u0010\tJ\u001D\u0010\u000B\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\u000B\u0010\tJ)\u0010\u000B\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\b\u0010\r\u001A\u0004\u0018\u00010\f¢\u0006\u0004\b\u000B\u0010\u000ER\u0014\u0010\u0010\u001A\u00020\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/kakaoent/trevi/ad/util/TreviLog;", "", "<init>", "()V", "", "tag", "message", "Lie/H;", "d", "(Ljava/lang/String;Ljava/lang/String;)V", "i", "e", "", "throwable", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "", "isLogOn", "Z", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TreviLog {
    @NotNull
    public static final TreviLog INSTANCE;
    private static final boolean isLogOn;

    static {
        TreviLog.INSTANCE = new TreviLog();
        TreviLog.isLogOn = false;
    }

    public final void d(@NotNull String s, @NotNull String s1) {
        q.g(s, "tag");
        q.g(s1, "message");
        if(TreviLog.isLogOn) {
            Log.d(s, s1);
        }
    }

    public final void e(@NotNull String s, @NotNull String s1) {
        q.g(s, "tag");
        q.g(s1, "message");
        Log.e(s, s1);
    }

    public final void e(@NotNull String s, @NotNull String s1, @Nullable Throwable throwable0) {
        q.g(s, "tag");
        q.g(s1, "message");
        Log.e(s, s1, throwable0);
    }

    public final void i(@NotNull String s, @NotNull String s1) {
        q.g(s, "tag");
        q.g(s1, "message");
        if(TreviLog.isLogOn) {
            Log.i(s, s1);
        }
    }
}

