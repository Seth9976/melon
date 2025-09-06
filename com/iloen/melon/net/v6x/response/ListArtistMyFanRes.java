package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001A\u00020\u000BH\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ListArtistMyFanRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/ListArtistMyFanRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/ListArtistMyFanRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/ListArtistMyFanRes$RESPONSE;)V", "toString", "", "RESPONSE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ListArtistMyFanRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR6\u0010\n\u001A\u001A\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000Bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\r8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ListArtistMyFanRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "artistList", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v6x/response/ListArtistMyFanRes$RESPONSE$ARTISTLIST;", "Lkotlin/collections/ArrayList;", "getArtistList", "()Ljava/util/ArrayList;", "setArtistList", "(Ljava/util/ArrayList;)V", "ARTISTLIST", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ListArtistMyFanRes$RESPONSE$ARTISTLIST;", "Lcom/melon/net/res/common/ArtistInfoBase;", "<init>", "()V", "contstypeCode", "", "getContstypeCode", "()Ljava/lang/String;", "setContstypeCode", "(Ljava/lang/String;)V", "temperature", "getTemperature", "setTemperature", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class ARTISTLIST extends ArtistInfoBase {
            public static final int $stable = 8;
            @b("CONTSTYPECODE")
            @Nullable
            private String contstypeCode;
            @NotNull
            private String temperature;

            public ARTISTLIST() {
                this.temperature = "";
            }

            @Nullable
            public final String getContstypeCode() {
                return this.contstypeCode;
            }

            @NotNull
            public final String getTemperature() [...] // 潜在的解密器

            public final void setContstypeCode(@Nullable String s) {
                this.contstypeCode = s;
            }

            public final void setTemperature(@NotNull String s) {
                q.g(s, "<set-?>");
                this.temperature = s;
            }
        }

        public static final int $stable = 8;
        @b("ARTISTLIST")
        @Nullable
        private ArrayList artistList;
        @b("HASMORE")
        private boolean hasMore;

        @Nullable
        public final ArrayList getArtistList() {
            return this.artistList;
        }

        public final boolean getHasMore() {
            return this.hasMore;
        }

        public final void setArtistList(@Nullable ArrayList arrayList0) {
            this.artistList = arrayList0;
        }

        public final void setHasMore(boolean z) {
            this.hasMore = z;
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

    public final void setResponse(@Nullable RESPONSE listArtistMyFanRes$RESPONSE0) {
        this.response = listArtistMyFanRes$RESPONSE0;
    }

    @Override
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

