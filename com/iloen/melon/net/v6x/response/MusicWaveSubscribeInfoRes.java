package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveSubscribeInfoRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/MusicWaveSubscribeInfoRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/MusicWaveSubscribeInfoRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/MusicWaveSubscribeInfoRes$RESPONSE;)V", "RESPONSE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveSubscribeInfoRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0010\n\u0002\u0010\t\u001A\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\n\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveSubscribeInfoRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "isSubscribe", "", "()Ljava/lang/Boolean;", "setSubscribe", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "contentsList", "", "Lcom/iloen/melon/net/v6x/response/MusicWaveSubscribeInfoRes$RESPONSE$CONTENT;", "getContentsList", "()Ljava/util/List;", "setContentsList", "(Ljava/util/List;)V", "CONTENT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveSubscribeInfoRes$RESPONSE$CONTENT;", "", "<init>", "()V", "contsId", "", "getContsId", "()Ljava/lang/String;", "setContsId", "(Ljava/lang/String;)V", "likeYn", "getLikeYn", "setLikeYn", "summCnt", "getSummCnt", "setSummCnt", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class CONTENT {
            public static final int $stable = 8;
            @b("CONTSID")
            @Nullable
            private String contsId;
            @b("LIKEYN")
            @Nullable
            private String likeYn;
            @b("SUMMCNT")
            @Nullable
            private String summCnt;

            @Nullable
            public final String getContsId() {
                return this.contsId;
            }

            @Nullable
            public final String getLikeYn() {
                return this.likeYn;
            }

            @Nullable
            public final String getSummCnt() {
                return this.summCnt;
            }

            public final void setContsId(@Nullable String s) {
                this.contsId = s;
            }

            public final void setLikeYn(@Nullable String s) {
                this.likeYn = s;
            }

            public final void setSummCnt(@Nullable String s) {
                this.summCnt = s;
            }
        }

        public static final int $stable = 8;
        @b("contents")
        @Nullable
        private List contentsList;
        @b("ISSUBSCRIBE")
        @Nullable
        private Boolean isSubscribe;

        @Nullable
        public final List getContentsList() {
            return this.contentsList;
        }

        @Nullable
        public final Boolean isSubscribe() {
            return this.isSubscribe;
        }

        public final void setContentsList(@Nullable List list0) {
            this.contentsList = list0;
        }

        public final void setSubscribe(@Nullable Boolean boolean0) {
            this.isSubscribe = boolean0;
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

    public final void setResponse(@Nullable RESPONSE musicWaveSubscribeInfoRes$RESPONSE0) {
        this.response = musicWaveSubscribeInfoRes$RESPONSE0;
    }
}

