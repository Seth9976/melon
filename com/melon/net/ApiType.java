package com.melon.net;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0019\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001Aj\u0002\b\u001B¨\u0006\u001C"}, d2 = {"Lcom/melon/net/ApiType;", "", "url", "", "apiVersion", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getApiVersion", "V4", "V4_1", "V4_2", "V5", "V5_1", "V5_2", "V5_5", "V6", "V6_1", "V6_2", "V6_3", "V6_6", "V6_7", "V6_8", "V6_9", "V6_10", "MEMBER", "EMPTY", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public enum ApiType {
    V4("", "4.0"),
    V4_1("", "4.1"),
    V4_2("", "4.2"),
    V5("/m5", "5.0"),
    V5_1("/m5", "5.1"),
    V5_2("/m5", "5.2"),
    V5_5("/m5", "5.5"),
    V6("/m6", ""),
    V6_1("/m6/v1", ""),
    V6_2("/m6/v2", ""),
    V6_3("/m6/v3", ""),
    V6_6("/m6/v6", ""),
    V6_7("/m6/v7", ""),
    V6_8("/m6/v8", ""),
    V6_9("/m6/v9", ""),
    V6_10("/m6/v10", ""),
    MEMBER("", "4.0"),
    EMPTY("", "");

    private static final a $ENTRIES;
    private static final ApiType[] $VALUES;
    @NotNull
    private final String apiVersion;
    @NotNull
    private final String url;

    private static final ApiType[] $values() [...] // Inlined contents

    static {
        ApiType.$VALUES = arr_apiType;
        q.g(arr_apiType, "entries");
        ApiType.$ENTRIES = new b(arr_apiType);
    }

    private ApiType(String s1, String s2) {
        this.url = s1;
        this.apiVersion = s2;
    }

    @NotNull
    public final String getApiVersion() {
        return this.apiVersion;
    }

    @NotNull
    public static a getEntries() {
        return ApiType.$ENTRIES;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }
}

