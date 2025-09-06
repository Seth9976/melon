package com.kakao.emoticon.net;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import tg.p;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0002J\u0012\u0010\t\u001A\u00020\u00042\n\u0010\n\u001A\u00060\u000Bj\u0002`\f¨\u0006\r"}, d2 = {"Lcom/kakao/emoticon/net/EmoticonApiErrorHandler;", "", "()V", "createError", "Lcom/kakao/emoticon/net/EmoticonApiError;", "errorCode", "", "serverMessage", "", "createErrorFromException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonApiErrorHandler {
    public static final EmoticonApiErrorHandler INSTANCE;

    static {
        EmoticonApiErrorHandler.INSTANCE = new EmoticonApiErrorHandler();
    }

    private final EmoticonApiError createError(int v, String s) {
        return new EmoticonApiError(v, s);
    }

    @NotNull
    public final EmoticonApiError createErrorFromException(@NotNull Exception exception0) {
        q.g(exception0, "e");
        if(exception0 instanceof p) {
            q.f(((p)exception0).b, "e.message()");
            return this.createError(((p)exception0).a, ((p)exception0).b);
        }
        return this.createError(-600, "");
    }
}

