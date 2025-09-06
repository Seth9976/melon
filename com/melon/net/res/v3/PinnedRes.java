package com.melon.net.res.v3;

import S7.b;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/melon/net/res/v3/PinnedRes;", "Lcom/melon/net/res/v3/CmtBaseRes;", "<init>", "()V", "response", "Lcom/melon/net/res/v3/PinnedRes$Response;", "getResponse", "()Lcom/melon/net/res/v3/PinnedRes$Response;", "setResponse", "(Lcom/melon/net/res/v3/PinnedRes$Response;)V", "Response", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PinnedRes extends CmtBaseRes {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001E\u0010\n\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/melon/net/res/v3/PinnedRes$Response;", "Ljava/io/Serializable;", "<init>", "()V", "cmtSeq", "", "getCmtSeq", "()I", "setCmtSeq", "(I)V", "unpinnedFlag", "", "getUnpinnedFlag", "()Z", "setUnpinnedFlag", "(Z)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response implements Serializable {
        public static final int $stable = 8;
        @b("cmtSeq")
        private int cmtSeq;
        @b("unpinnedFlag")
        private boolean unpinnedFlag;

        public Response() {
            this.cmtSeq = -1;
        }

        public final int getCmtSeq() {
            return this.cmtSeq;
        }

        public final boolean getUnpinnedFlag() {
            return this.unpinnedFlag;
        }

        public final void setCmtSeq(int v) {
            this.cmtSeq = v;
        }

        public final void setUnpinnedFlag(boolean z) {
            this.unpinnedFlag = z;
        }
    }

    public static final int $stable = 8;
    @b("result")
    @Nullable
    private Response response;

    @Nullable
    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable Response pinnedRes$Response0) {
        this.response = pinnedRes$Response0;
    }
}

