package com.melon.net.res;

import S7.b;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import je.w;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/melon/net/res/MelonSimplePreviewRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/melon/net/res/MelonSimplePreviewRes$Response;", "getResponse", "()Lcom/melon/net/res/MelonSimplePreviewRes$Response;", "Response", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonSimplePreviewRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\f¨\u0006\u000E"}, d2 = {"Lcom/melon/net/res/MelonSimplePreviewRes$Response;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "playlist", "", "Lcom/melon/net/res/DjMalrangPlaylist;", "getPlaylist", "()Ljava/util/List;", "success", "", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static class Response extends ResponseBase {
        public static final int $stable = 8;
        @b("PLAYLIST")
        @Nullable
        private final List playlist;
        @b("SUCCESS")
        @Nullable
        private final Boolean success;

        public Response() {
            this.playlist = w.a;
            this.success = Boolean.FALSE;
        }

        @Nullable
        public final List getPlaylist() {
            return this.playlist;
        }

        @Nullable
        public final Boolean getSuccess() {
            return this.success;
        }
    }

    public static final int $stable = 8;
    @b("response")
    @NotNull
    private final Response response;

    public MelonSimplePreviewRes() {
        this.response = new Response();
    }

    @NotNull
    public final Response getResponse() {
        return this.response;
    }
}

