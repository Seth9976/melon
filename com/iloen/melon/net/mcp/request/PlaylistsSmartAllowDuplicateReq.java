package com.iloen.melon.net.mcp.request;

import android.content.Context;
import com.google.gson.n;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import com.iloen.melon.utils.system.DeviceIdentifier;

public class PlaylistsSmartAllowDuplicateReq extends PlaylistsSmartBaseReq {
    static class Preference {
        String memberKey;
        boolean on;
        String pcId;
        long updatedDate;

        public Preference(String s, long v, boolean z) {
            this.updatedDate = 0L;
            this.on = true;
            this.memberKey = s;
            this.pcId = DeviceIdentifier.id(MelonAppBase.instance.getDeviceData().a);
            this.updatedDate = v;
            this.on = z;
        }
    }

    public PlaylistsSmartAllowDuplicateReq(Context context0, String s, long v, boolean z) {
        super(context0, 2, PlaylistsSmartEditRes.class);
        Preference playlistsSmartAllowDuplicateReq$Preference0 = new Preference(s, v, z);
        this.setJsonString(new n().k(playlistsSmartAllowDuplicateReq$Preference0));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/playlists/smart/allow-duplicate";
    }
}

