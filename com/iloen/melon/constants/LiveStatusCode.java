package com.iloen.melon.constants;

import A8.o;
import S7.b;
import androidx.annotation.Keep;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pe.a;

@Keep
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000E\n\u0002\b\u000E\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\bj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000F¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/constants/LiveStatusCode;", "", "", "code", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getCode", "()Ljava/lang/String;", "Companion", "A8/o", "Standby", "Preview", "LiveStreaming", "ReplayStandby", "Replay", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public enum LiveStatusCode {
    @b("BS01")
    Standby("BS01"),
    @b("BS02")
    Preview("BS02"),
    @b("BS03")
    LiveStreaming("BS03"),
    @b("BS04")
    ReplayStandby("BS04"),
    @b("BS05")
    Replay("BS05");

    private static final a $ENTRIES;
    private static final LiveStatusCode[] $VALUES;
    @NotNull
    public static final o Companion;
    @NotNull
    private static final Map MAP;
    @NotNull
    private final String code;

    private static final LiveStatusCode[] $values() [...] // Inlined contents

    static {
        int v1;
        LiveStatusCode.$VALUES = arr_liveStatusCode;
        LiveStatusCode.$ENTRIES = new pe.b(arr_liveStatusCode);
        LiveStatusCode.Companion = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
        LiveStatusCode[] arr_liveStatusCode1 = (LiveStatusCode[])LiveStatusCode.$VALUES.clone();
        if(arr_liveStatusCode1.length < 0) {
            v1 = arr_liveStatusCode1.length;
        }
        else if(arr_liveStatusCode1.length < 3) {
            v1 = arr_liveStatusCode1.length + 1;
        }
        else {
            v1 = arr_liveStatusCode1.length >= 0x40000000 ? 0x7FFFFFFF : ((int)(((float)arr_liveStatusCode1.length) / 0.75f + 1.0f));
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap((v1 >= 16 ? v1 : 16));
        for(int v = 0; v < arr_liveStatusCode1.length; ++v) {
            LiveStatusCode liveStatusCode0 = arr_liveStatusCode1[v];
            linkedHashMap0.put(liveStatusCode0.code, liveStatusCode0);
        }
        LiveStatusCode.MAP = linkedHashMap0;
    }

    private LiveStatusCode(String s1) {
        this.code = s1;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public static a getEntries() {
        return LiveStatusCode.$ENTRIES;
    }

    @Nullable
    public static final LiveStatusCode of(@NotNull String s) {
        LiveStatusCode.Companion.getClass();
        q.g(s, "code");
        return (LiveStatusCode)LiveStatusCode.MAP.get(s);
    }
}

