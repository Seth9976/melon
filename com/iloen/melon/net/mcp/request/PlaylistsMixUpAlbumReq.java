package com.iloen.melon.net.mcp.request;

import android.content.Context;
import com.iloen.melon.net.mcp.response.MixupPlayResponseBase;
import e1.u;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pc.G0;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/mcp/request/PlaylistsMixUpAlbumReq;", "Lcom/iloen/melon/net/mcp/request/PlaylistsSmartBaseReq;", "Landroid/content/Context;", "context", "Lpc/G0;", "data", "<init>", "(Landroid/content/Context;Lpc/G0;)V", "", "getApiPath", "()Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistsMixUpAlbumReq extends PlaylistsSmartBaseReq {
    public static final int $stable = 8;

    public PlaylistsMixUpAlbumReq(@NotNull Context context0, @NotNull G0 g00) {
        q.g(context0, "context");
        q.g(g00, "data");
        super(context0, 0, MixupPlayResponseBase.class);
        if(u.w(((e0)o.a()).j()) != null) {
            this.addMemberKey();
        }
        this.addParam("albumId", g00.c);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    @NotNull
    public String getApiPath() {
        return "/playlists/mix-up/album";
    }
}

