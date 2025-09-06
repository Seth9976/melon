package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001A\u00020\u000BH\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/net/v4x/response/MyMusicPlaylistPlayDeleteSongRes;", "Lcom/iloen/melon/net/v4x/response/ResponseV4Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v4x/response/MyMusicPlaylistPlayDeleteSongRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v4x/response/MyMusicPlaylistPlayDeleteSongRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v4x/response/MyMusicPlaylistPlayDeleteSongRes$RESPONSE;)V", "toString", "", "RESPONSE", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicPlaylistPlayDeleteSongRes extends ResponseV4Res {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v4x/response/MyMusicPlaylistPlayDeleteSongRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/net/v4x/response/MyMusicPlaylistPlayDeleteSongRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "deleteSongCnt", "", "getDeleteSongCnt", "()I", "setDeleteSongCnt", "(I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        public static final int $stable = 8;
        @b("DELETESONGCNT")
        private int deleteSongCnt;

        public final int getDeleteSongCnt() {
            return this.deleteSongCnt;
        }

        public final void setDeleteSongCnt(int v) {
            this.deleteSongCnt = v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @b("response")
    @Nullable
    private RESPONSE response;
    private static final long serialVersionUID = 1293410000421085937L;

    static {
        MyMusicPlaylistPlayDeleteSongRes.Companion = new Companion(null);
        MyMusicPlaylistPlayDeleteSongRes.$stable = 8;
    }

    @Nullable
    public final RESPONSE getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable RESPONSE myMusicPlaylistPlayDeleteSongRes$RESPONSE0) {
        this.response = myMusicPlaylistPlayDeleteSongRes$RESPONSE0;
    }

    @Override
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

