package com.iloen.melon.net.mcp.request;

import android.content.Context;
import com.google.gson.n;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import com.iloen.melon.utils.system.DeviceIdentifier;

public class PlaylistsSmartDeleteExistingReq extends PlaylistsSmartBaseReq {
    static class Preference {
        String memberKey;
        boolean on;
        String pcId;
        long updatedDate;

        public Preference(String s, long v, boolean z) {
            this.updatedDate = 0L;
            this.on = false;
            this.memberKey = s;
            this.pcId = DeviceIdentifier.id(MelonAppBase.instance.getDeviceData().a);
            this.updatedDate = v;
            this.on = z;
        }
    }

    public PlaylistsSmartDeleteExistingReq(Context context0, String s, long v, boolean z) {
        super(context0, 2, PlaylistsSmartEditRes.class);
        Preference playlistsSmartDeleteExistingReq$Preference0 = new Preference(s, v, z);
        this.setJsonString(new n().k(playlistsSmartDeleteExistingReq$Preference0));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/playlists/smart/delete-existing";
    }
}

