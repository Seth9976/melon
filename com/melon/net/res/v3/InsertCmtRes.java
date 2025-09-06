package com.melon.net.res.v3;

import S7.b;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/melon/net/res/v3/InsertCmtRes;", "Lcom/melon/net/res/v3/CmtBaseRes;", "<init>", "()V", "result", "Lcom/melon/net/res/v3/InsertCmtRes$Result;", "getResult", "()Lcom/melon/net/res/v3/InsertCmtRes$Result;", "setResult", "(Lcom/melon/net/res/v3/InsertCmtRes$Result;)V", "Result", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class InsertCmtRes extends CmtBaseRes {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/melon/net/res/v3/InsertCmtRes$Result;", "Ljava/io/Serializable;", "<init>", "()V", "cmtSeq", "", "getCmtSeq", "()I", "setCmtSeq", "(I)V", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Result implements Serializable {
        public static final int $stable = 8;
        @b("cmtSeq")
        private int cmtSeq;
        @b("message")
        @Nullable
        private String message;

        public Result() {
            this.cmtSeq = -1;
        }

        public final int getCmtSeq() {
            return this.cmtSeq;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        public final void setCmtSeq(int v) {
            this.cmtSeq = v;
        }

        public final void setMessage(@Nullable String s) {
            this.message = s;
        }
    }

    public static final int $stable = 8;
    @b("result")
    @Nullable
    private Result result;

    @Nullable
    public final Result getResult() {
        return this.result;
    }

    public final void setResult(@Nullable Result insertCmtRes$Result0) {
        this.result = insertCmtRes$Result0;
    }
}

