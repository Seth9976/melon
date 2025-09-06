package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveStaticsRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/MusicWaveStaticsRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/MusicWaveStaticsRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/MusicWaveStaticsRes$RESPONSE;)V", "RESPONSE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveStaticsRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\t¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveStaticsRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "userCount", "", "getUserCount", "()Ljava/lang/String;", "setUserCount", "(Ljava/lang/String;)V", "viewCount", "getViewCount", "setViewCount", "cheerCount", "getCheerCount", "setCheerCount", "interval", "getInterval", "setInterval", "mapSeq", "getMapSeq", "setMapSeq", "d", "getD", "setD", "nowSec", "getNowSec", "setNowSec", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        public static final int $stable = 8;
        @b("CHEERCOUNT")
        @Nullable
        private String cheerCount;
        @b("D")
        @Nullable
        private String d;
        @b("INTERVAL")
        @Nullable
        private String interval;
        @b("MAPSEQ")
        @Nullable
        private String mapSeq;
        @b("NOWSEC")
        @Nullable
        private String nowSec;
        @b("USERCOUNT")
        @Nullable
        private String userCount;
        @b("VIEWCOUNT")
        @Nullable
        private String viewCount;

        @Nullable
        public final String getCheerCount() {
            return this.cheerCount;
        }

        @Nullable
        public final String getD() {
            return this.d;
        }

        @Nullable
        public final String getInterval() {
            return this.interval;
        }

        @Nullable
        public final String getMapSeq() {
            return this.mapSeq;
        }

        @Nullable
        public final String getNowSec() {
            return this.nowSec;
        }

        @Nullable
        public final String getUserCount() {
            return this.userCount;
        }

        @Nullable
        public final String getViewCount() {
            return this.viewCount;
        }

        public final void setCheerCount(@Nullable String s) {
            this.cheerCount = s;
        }

        public final void setD(@Nullable String s) {
            this.d = s;
        }

        public final void setInterval(@Nullable String s) {
            this.interval = s;
        }

        public final void setMapSeq(@Nullable String s) {
            this.mapSeq = s;
        }

        public final void setNowSec(@Nullable String s) {
            this.nowSec = s;
        }

        public final void setUserCount(@Nullable String s) {
            this.userCount = s;
        }

        public final void setViewCount(@Nullable String s) {
            this.viewCount = s;
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

    public final void setResponse(@Nullable RESPONSE musicWaveStaticsRes$RESPONSE0) {
        this.response = musicWaveStaticsRes$RESPONSE0;
    }
}

