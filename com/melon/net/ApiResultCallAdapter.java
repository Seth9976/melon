package com.melon.net;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import tg.d;
import tg.f;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u001A\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00030\u0002B\u000F\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/melon/net/ApiResultCallAdapter;", "T", "Ltg/f;", "Ltg/d;", "Lcom/melon/net/ApiResult;", "Ljava/lang/reflect/Type;", "dataType", "<init>", "(Ljava/lang/reflect/Type;)V", "responseType", "()Ljava/lang/reflect/Type;", "call", "adapt", "(Ltg/d;)Ltg/d;", "Ljava/lang/reflect/Type;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ApiResultCallAdapter implements f {
    public static final int $stable = 8;
    @NotNull
    private final Type dataType;

    public ApiResultCallAdapter(@NotNull Type type0) {
        q.g(type0, "dataType");
        super();
        this.dataType = type0;
    }

    @Override  // tg.f
    public Object adapt(d d0) {
        return this.adapt(d0);
    }

    @NotNull
    public d adapt(@NotNull d d0) {
        q.g(d0, "call");
        return new ApiResultCall(d0, this.dataType);
    }

    @Override  // tg.f
    @NotNull
    public Type responseType() {
        return this.dataType;
    }
}

