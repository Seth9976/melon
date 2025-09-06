package com.melon.net.res;

import S7.b;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/melon/net/res/MyMusicOrcRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/melon/net/res/MyMusicOrcRes$Response;", "getResponse", "()Lcom/melon/net/res/MyMusicOrcRes$Response;", "setResponse", "(Lcom/melon/net/res/MyMusicOrcRes$Response;)V", "Response", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicOrcRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R2\u0010\u0004\u001A\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR \u0010\f\u001A\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/melon/net/res/MyMusicOrcRes$Response;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "songList", "Ljava/util/ArrayList;", "Lcom/melon/net/res/common/SongInfoBase;", "Lkotlin/collections/ArrayList;", "getSongList", "()Ljava/util/ArrayList;", "setSongList", "(Ljava/util/ArrayList;)V", "ocrGroupId", "", "getOcrGroupId", "()Ljava/lang/String;", "setOcrGroupId", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response extends ResponseBase {
        public static final int $stable = 8;
        @b("OCRGROUPID")
        @Nullable
        private String ocrGroupId;
        @b("SONGLIST")
        @Nullable
        private ArrayList songList;

        @Nullable
        public final String getOcrGroupId() {
            return this.ocrGroupId;
        }

        @Nullable
        public final ArrayList getSongList() {
            return this.songList;
        }

        public final void setOcrGroupId(@Nullable String s) {
            this.ocrGroupId = s;
        }

        public final void setSongList(@Nullable ArrayList arrayList0) {
            this.songList = arrayList0;
        }
    }

    public static final int $stable = 8;
    @b("response")
    @NotNull
    private Response response;

    public MyMusicOrcRes() {
        this.response = new Response();
    }

    @NotNull
    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(@NotNull Response myMusicOrcRes$Response0) {
        q.g(myMusicOrcRes$Response0, "<set-?>");
        this.response = myMusicOrcRes$Response0;
    }
}

