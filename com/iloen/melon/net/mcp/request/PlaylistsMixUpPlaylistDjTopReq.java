package com.iloen.melon.net.mcp.request;

import android.content.Context;
import com.iloen.melon.net.mcp.response.MixupPlayResponseBase;
import e1.u;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/iloen/melon/net/mcp/request/PlaylistsMixUpPlaylistDjTopReq;", "Lcom/iloen/melon/net/mcp/request/PlaylistsSmartBaseReq;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getApiPath", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistsMixUpPlaylistDjTopReq extends PlaylistsSmartBaseReq {
    public static final int $stable = 8;

    public PlaylistsMixUpPlaylistDjTopReq(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0, 0, MixupPlayResponseBase.class);
        if(u.w(((e0)o.a()).j()) != null) {
            this.addMemberKey();
        }
    }

    @Override  // com.iloen.melon.net.HttpRequest
    @NotNull
    public String getApiPath() {
        return "/playlists/mix-up/playlist/dj/top";
    }
}

