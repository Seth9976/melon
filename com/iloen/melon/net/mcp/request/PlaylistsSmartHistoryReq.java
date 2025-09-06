package com.iloen.melon.net.mcp.request;

import android.content.Context;
import android.os.Build;
import com.google.gson.n;
import com.iloen.melon.net.mcp.response.PlaylistsSmartRes;

public class PlaylistsSmartHistoryReq extends PlaylistsSmartBaseReq {
    public static class Data {
        public String deviceModel;
        public String memberKey;

        private Data(String s) {
            this.memberKey = s;
            this.deviceModel = Build.MODEL;
        }

        public Data(String s, int v) {
            this(s);
        }
    }

    public PlaylistsSmartHistoryReq(Context context0, String s) {
        super(context0, 1, PlaylistsSmartRes.class);
        Data playlistsSmartHistoryReq$Data0 = new Data(s, 0);
        this.setJsonString(new n().k(playlistsSmartHistoryReq$Data0));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/playlists/smart/history";
    }
}

