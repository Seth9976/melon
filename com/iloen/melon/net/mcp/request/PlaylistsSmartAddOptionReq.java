package com.iloen.melon.net.mcp.request;

import android.content.Context;
import com.google.gson.n;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.mcp.AddOptionServer;
import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import com.iloen.melon.utils.system.DeviceIdentifier;

public class PlaylistsSmartAddOptionReq extends PlaylistsSmartBaseReq {
    static class Preference {
        String addOption;
        String memberKey;
        String pcId;
        long updatedDate;

        public Preference(String s, long v, AddOptionServer addOptionServer0) {
            this.updatedDate = 0L;
            this.addOption = "";
            this.memberKey = s;
            this.pcId = DeviceIdentifier.id(MelonAppBase.instance.getDeviceData().a);
            this.updatedDate = v;
            this.addOption = addOptionServer0.getValue();
        }
    }

    public PlaylistsSmartAddOptionReq(Context context0, String s, long v, AddOptionServer addOptionServer0) {
        super(context0, 2, PlaylistsSmartEditRes.class);
        Preference playlistsSmartAddOptionReq$Preference0 = new Preference(s, v, addOptionServer0);
        this.setJsonString(new n().k(playlistsSmartAddOptionReq$Preference0));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/playlists/smart/add-option";
    }
}

