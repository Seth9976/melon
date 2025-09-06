package com.facebook.share;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/facebook/share/Sharer;", "", "", "getShouldFailOnDataError", "()Z", "shouldFailOnDataError", "Lie/H;", "setShouldFailOnDataError", "(Z)V", "Result", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface Sharer {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/share/Sharer$Result;", "", "postId", "", "(Ljava/lang/String;)V", "getPostId", "()Ljava/lang/String;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Result {
        @Nullable
        private final String postId;

        public Result(@Nullable String s) {
            this.postId = s;
        }

        @Nullable
        public final String getPostId() {
            return this.postId;
        }
    }

    boolean getShouldFailOnDataError();

    void setShouldFailOnDataError(boolean arg1);
}

