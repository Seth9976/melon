package com.kakao.sdk.network;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\"\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"origin", "", "getOrigin", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "network_release"}, k = 2, mv = {1, 8, 0}, xi = 0x30)
public final class ExceptionWrapperKt {
    @NotNull
    public static final Throwable getOrigin(@NotNull Throwable throwable0) {
        q.g(throwable0, "<this>");
        return throwable0 instanceof ExceptionWrapper ? ((ExceptionWrapper)throwable0).getOrigin() : throwable0;
    }
}

