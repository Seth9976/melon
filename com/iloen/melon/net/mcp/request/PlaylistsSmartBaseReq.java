package com.iloen.melon.net.mcp.request;

import A8.M;
import android.content.Context;
import com.iloen.melon.net.HttpRequest;

public abstract class PlaylistsSmartBaseReq extends HttpRequest {
    public static final String HEADER_MCP_TOKEN = "melonToken";

    public PlaylistsSmartBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0, true);
        this.init();
    }

    public PlaylistsSmartBaseReq(Context context0, int v, Class class0, boolean z) {
        super(context0, v, class0, z);
        this.init();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.p;
    }

    private void init() {
        this.addHeader("melonToken", "");
    }
}

