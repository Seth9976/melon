package com.iloen.melon.net.mcp.request;

import android.content.Context;
import com.google.gson.n;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import com.iloen.melon.utils.system.DeviceIdentifier;
import java.util.ArrayList;
import java.util.List;

public class PlaylistsSmartTracksDeleteReq extends PlaylistsSmartBaseReq {
    static class Tracks {
        String memberKey;
        String pcId;
        ArrayList trackIdList;
        long updatedDate;

        public Tracks(String s, long v, List list0) {
            this.memberKey = "";
            this.pcId = "";
            this.updatedDate = 0L;
            this.trackIdList = new ArrayList();
            this.memberKey = s;
            this.pcId = DeviceIdentifier.id(MelonAppBase.instance.getDeviceData().a);
            this.updatedDate = v;
            if(list0 != null) {
                this.trackIdList.addAll(list0);
            }
        }
    }

    public PlaylistsSmartTracksDeleteReq(Context context0, String s, long v, List list0) {
        super(context0, 1, PlaylistsSmartEditRes.class);
        Tracks playlistsSmartTracksDeleteReq$Tracks0 = new Tracks(s, v, list0);
        this.setJsonString(new n().k(playlistsSmartTracksDeleteReq$Tracks0));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/playlists/smart/tracks/delete";
    }
}

