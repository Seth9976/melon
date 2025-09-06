package com.melon.net;

import com.iloen.melon.MelonAppBase;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0017\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u001F\u0010\u0007\u001A\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\b\u001A\u001D\u0010\t\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\b\u001A\u0015\u0010\u000B\u001A\u00020\n*\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"", "resId", "", "fromResourceMessage", "(I)Ljava/lang/String;", "T", "Lcom/melon/net/ApiResult;", "getOrNull", "(Lcom/melon/net/ApiResult;)Ljava/lang/Object;", "getOrThrow", "Lie/H;", "throwOnFailure", "(Lcom/melon/net/ApiResult;)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class ApiResultKt {
    private static final String fromResourceMessage(int v) {
        MelonAppBase.Companion.getClass();
        String s = t.a().getContext().getResources().getString(v);
        q.f(s, "getString(...)");
        return s;
    }

    @Nullable
    public static final Object getOrNull(@NotNull ApiResult apiResult0) {
        q.g(apiResult0, "<this>");
        return apiResult0 instanceof Success ? ((Success)apiResult0).getData() : null;
    }

    public static final Object getOrThrow(@NotNull ApiResult apiResult0) {
        q.g(apiResult0, "<this>");
        ApiResultKt.throwOnFailure(apiResult0);
        return ((Success)apiResult0).getData();
    }

    public static final void throwOnFailure(@NotNull ApiResult apiResult0) {
        q.g(apiResult0, "<this>");
        if(apiResult0 instanceof Failure) {
            throw ((Failure)apiResult0).throwCommonException();
        }
    }
}

