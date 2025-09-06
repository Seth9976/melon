package com.kakaoent.leonplayer.core.common;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/kakaoent/leonplayer/core/common/MoshiParseException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class MoshiParseException extends Exception {
    @NotNull
    private final String message;

    public MoshiParseException(@NotNull String s) {
        q.g(s, "message");
        this.message = s;
    }

    @Override
    @NotNull
    public String getMessage() {
        return this.message;
    }
}

