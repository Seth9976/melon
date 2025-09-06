package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001A\u00020\u000BH\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ListMyFriendlyArtistRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/ListMyFriendlyArtistRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/ListMyFriendlyArtistRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/ListMyFriendlyArtistRes$RESPONSE;)V", "toString", "", "RESPONSE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ListMyFriendlyArtistRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR6\u0010\n\u001A\u001A\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000Bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\r8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ListMyFriendlyArtistRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "myOftenArtistStr", "", "getMyOftenArtistStr", "()Ljava/lang/String;", "setMyOftenArtistStr", "(Ljava/lang/String;)V", "contentsList", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v6x/response/ListMyFriendlyArtistRes$RESPONSE$CONTENTSLIST;", "Lkotlin/collections/ArrayList;", "getContentsList", "()Ljava/util/ArrayList;", "setContentsList", "(Ljava/util/ArrayList;)V", "CONTENTSLIST", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u001D\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\tR \u0010\u001C\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0007\"\u0004\b\u001E\u0010\tR \u0010\u001F\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u0007\"\u0004\b!\u0010\t¨\u0006\""}, d2 = {"Lcom/iloen/melon/net/v6x/response/ListMyFriendlyArtistRes$RESPONSE$CONTENTSLIST;", "Lcom/melon/net/res/common/ArtistsInfoBase;", "<init>", "()V", "newIconYn", "", "getNewIconYn", "()Ljava/lang/String;", "setNewIconYn", "(Ljava/lang/String;)V", "curRank", "getCurRank", "setCurRank", "pastRank", "getPastRank", "setPastRank", "rankType", "getRankType", "setRankType", "rankGap", "getRankGap", "setRankGap", "userTemper", "getUserTemper", "setUserTemper", "userRank", "getUserRank", "setUserRank", "totalUserRank", "getTotalUserRank", "setTotalUserRank", "meetDayCnt", "getMeetDayCnt", "setMeetDayCnt", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class CONTENTSLIST extends ArtistsInfoBase {
            public static final int $stable = 8;
            @b("CURRANK")
            @Nullable
            private String curRank;
            @b("MEETDAYCNT")
            @Nullable
            private String meetDayCnt;
            @b("NEWICONYN")
            @Nullable
            private String newIconYn;
            @b("PASTRANK")
            @Nullable
            private String pastRank;
            @b("RANKGAP")
            @Nullable
            private String rankGap;
            @b("RANKTYPE")
            @Nullable
            private String rankType;
            @b("TOTALUSERRANK")
            @Nullable
            private String totalUserRank;
            @b("USERRANK")
            @Nullable
            private String userRank;
            @b("USERTEMPER")
            @Nullable
            private String userTemper;

            @Nullable
            public final String getCurRank() {
                return this.curRank;
            }

            @Nullable
            public final String getMeetDayCnt() {
                return this.meetDayCnt;
            }

            @Nullable
            public final String getNewIconYn() {
                return this.newIconYn;
            }

            @Nullable
            public final String getPastRank() {
                return this.pastRank;
            }

            @Nullable
            public final String getRankGap() {
                return this.rankGap;
            }

            @Nullable
            public final String getRankType() {
                return this.rankType;
            }

            @Nullable
            public final String getTotalUserRank() {
                return this.totalUserRank;
            }

            @Nullable
            public final String getUserRank() {
                return this.userRank;
            }

            @Nullable
            public final String getUserTemper() {
                return this.userTemper;
            }

            public final void setCurRank(@Nullable String s) {
                this.curRank = s;
            }

            public final void setMeetDayCnt(@Nullable String s) {
                this.meetDayCnt = s;
            }

            public final void setNewIconYn(@Nullable String s) {
                this.newIconYn = s;
            }

            public final void setPastRank(@Nullable String s) {
                this.pastRank = s;
            }

            public final void setRankGap(@Nullable String s) {
                this.rankGap = s;
            }

            public final void setRankType(@Nullable String s) {
                this.rankType = s;
            }

            public final void setTotalUserRank(@Nullable String s) {
                this.totalUserRank = s;
            }

            public final void setUserRank(@Nullable String s) {
                this.userRank = s;
            }

            public final void setUserTemper(@Nullable String s) {
                this.userTemper = s;
            }
        }

        public static final int $stable = 8;
        @b("CONTENTSLIST")
        @Nullable
        private ArrayList contentsList;
        @b("MYOFTENARTISTSTR")
        @Nullable
        private String myOftenArtistStr;

        @Nullable
        public final ArrayList getContentsList() {
            return this.contentsList;
        }

        @Nullable
        public final String getMyOftenArtistStr() {
            return this.myOftenArtistStr;
        }

        public final void setContentsList(@Nullable ArrayList arrayList0) {
            this.contentsList = arrayList0;
        }

        public final void setMyOftenArtistStr(@Nullable String s) {
            this.myOftenArtistStr = s;
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

    public final void setResponse(@Nullable RESPONSE listMyFriendlyArtistRes$RESPONSE0) {
        this.response = listMyFriendlyArtistRes$RESPONSE0;
    }

    @Override
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

