package com.iloen.melon.net.mcp.request;

import android.content.Context;
import com.iloen.melon.net.mcp.response.MixupPlayResponseBase;
import e1.u;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001A\u00020\u0005H\u0014¨\u0006\t"}, d2 = {"Lcom/iloen/melon/net/mcp/request/PlaylistsMixUpMoreReq;", "Lcom/iloen/melon/net/mcp/request/PlaylistsSmartBaseReq;", "context", "Landroid/content/Context;", "songIds", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "getApiPath", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistsMixUpMoreReq extends PlaylistsSmartBaseReq {
    public static final int $stable = 8;

    public PlaylistsMixUpMoreReq(@NotNull Context context0, @NotNull String s) {
        q.g(context0, "context");
        q.g(s, "songIds");
        super(context0, 0, MixupPlayResponseBase.class);
        if(u.w(((e0)o.a()).j()) != null) {
            this.addMemberKey();
        }
        this.addParam("songIds", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    @NotNull
    public String getApiPath() {
        return "/playlists/mix-up/more";
    }
}

