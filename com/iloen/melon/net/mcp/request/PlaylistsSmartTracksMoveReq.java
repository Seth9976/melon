package com.iloen.melon.net.mcp.request;

import android.content.Context;
import com.google.gson.n;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import com.iloen.melon.utils.system.DeviceIdentifier;
import java.util.ArrayList;
import java.util.List;

public class PlaylistsSmartTracksMoveReq extends PlaylistsSmartBaseReq {
    static class Tracks {
        String memberKey;
        String pcId;
        int position;
        ArrayList trackIdList;
        long updatedDate;

        public Tracks(String s, long v, int v1, List list0) {
            this.memberKey = "";
            this.pcId = "";
            this.updatedDate = 0L;
            this.position = 0;
            this.trackIdList = new ArrayList();
            this.memberKey = s;
            this.pcId = DeviceIdentifier.id(MelonAppBase.instance.getDeviceData().a);
            this.updatedDate = v;
            this.position = v1;
            if(list0 != null) {
                this.trackIdList.addAll(list0);
            }
        }
    }

    public PlaylistsSmartTracksMoveReq(Context context0, String s, long v, int v1, List list0) {
        super(context0, 1, PlaylistsSmartEditRes.class);
        Tracks playlistsSmartTracksMoveReq$Tracks0 = new Tracks(s, v, v1, list0);
        this.setJsonString(new n().k(playlistsSmartTracksMoveReq$Tracks0));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/playlists/smart/tracks/move";
    }
}

