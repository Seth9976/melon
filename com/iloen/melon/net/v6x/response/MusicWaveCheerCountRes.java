package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveCheerCountRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/MusicWaveCheerCountRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/MusicWaveCheerCountRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/MusicWaveCheerCountRes$RESPONSE;)V", "RESPONSE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveCheerCountRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveCheerCountRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "cheerCount", "", "getCheerCount", "()Ljava/lang/String;", "setCheerCount", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        public static final int $stable = 8;
        @b("COUNT")
        @Nullable
        private String cheerCount;

        @Nullable
        public final String getCheerCount() {
            return this.cheerCount;
        }

        public final void setCheerCount(@Nullable String s) {
            this.cheerCount = s;
        }
    }

    public static final int $stable = 8;
    @b("response")
    @Nullable
    private RESPONSE response;

    @Nullable
    public final RESPONSE getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable RESPONSE musicWaveCheerCountRes$RESPONSE0) {
        this.response = musicWaveCheerCountRes$RESPONSE0;
    }
}

