package com.iloen.melon.net.mcp.response;

import S7.b;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001E\u0010\n\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR \u0010\u0010\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/net/mcp/response/PlayDjMalrangResponse;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/mcp/response/PlayDjMalrangBase;", "getResponse", "()Lcom/iloen/melon/net/mcp/response/PlayDjMalrangBase;", "setResponse", "(Lcom/iloen/melon/net/mcp/response/PlayDjMalrangBase;)V", "success", "", "getSuccess", "()Z", "setSuccess", "(Z)V", "error", "Lcom/iloen/melon/net/mcp/response/MixupPlayResponseBase$Error;", "getError", "()Lcom/iloen/melon/net/mcp/response/MixupPlayResponseBase$Error;", "setError", "(Lcom/iloen/melon/net/mcp/response/MixupPlayResponseBase$Error;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlayDjMalrangResponse extends ResponseV6Res {
    public static final int $stable = 8;
    @b("ERROR")
    @Nullable
    private Error error;
    @b("response")
    @Nullable
    private PlayDjMalrangBase response;
    @b("SUCCESS")
    private boolean success;

    @Nullable
    public final Error getError() {
        return this.error;
    }

    @Nullable
    public final PlayDjMalrangBase getResponse() {
        return this.response;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final void setError(@Nullable Error mixupPlayResponseBase$Error0) {
        this.error = mixupPlayResponseBase$Error0;
    }

    public final void setResponse(@Nullable PlayDjMalrangBase playDjMalrangBase0) {
        this.response = playDjMalrangBase0;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }
}

