package com.iloen.melon.net.mcp.request;

import android.content.Context;
import com.google.gson.n;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import com.iloen.melon.utils.system.DeviceIdentifier;
import java.util.ArrayList;
import java.util.List;

public class PlaylistsSmartTracksAddReq extends PlaylistsSmartBaseReq {
    static class Tracks {
        List addTrackList;
        boolean deleteExisting;
        List deleteTrackIdList;
        String memberKey;
        String pcId;
        int position;
        long updatedDate;

        public Tracks(String s, long v, int v1, List list0, List list1) {
            this.memberKey = "";
            this.pcId = "";
            this.updatedDate = 0L;
            this.position = 0;
            this.deleteTrackIdList = new ArrayList();
            this.addTrackList = new ArrayList();
            this.deleteExisting = false;
            this.memberKey = s;
            this.pcId = DeviceIdentifier.id(MelonAppBase.instance.getDeviceData().a);
            this.updatedDate = v;
            this.position = v1;
            if(list0 != null) {
                this.addTrackList.addAll(list0);
            }
            if(list1 != null) {
                this.deleteTrackIdList.addAll(list1);
            }
        }

        public Tracks(String s, long v, int v1, List list0, boolean z) {
            this.memberKey = "";
            this.pcId = "";
            this.updatedDate = 0L;
            this.position = 0;
            this.deleteTrackIdList = new ArrayList();
            this.addTrackList = new ArrayList();
            this.deleteExisting = false;
            this.memberKey = s;
            this.pcId = DeviceIdentifier.id(MelonAppBase.instance.getDeviceData().a);
            this.updatedDate = v;
            this.position = v1;
            if(list0 != null) {
                this.addTrackList.addAll(list0);
            }
            List list1 = this.deleteTrackIdList;
            if(list1 != null) {
                list1.addAll(list1);
            }
            this.deleteExisting = z;
        }
    }

    public PlaylistsSmartTracksAddReq(Context context0, String s, long v, int v1, List list0, List list1) {
        super(context0, 1, PlaylistsSmartEditRes.class);
        Tracks playlistsSmartTracksAddReq$Tracks0 = new Tracks(s, v, v1, list0, list1);
        this.setJsonString(new n().k(playlistsSmartTracksAddReq$Tracks0));
    }

    public PlaylistsSmartTracksAddReq(Context context0, String s, long v, int v1, List list0, boolean z) {
        super(context0, 1, PlaylistsSmartEditRes.class);
        Tracks playlistsSmartTracksAddReq$Tracks0 = new Tracks(s, v, v1, list0, z);
        this.setJsonString(new n().k(playlistsSmartTracksAddReq$Tracks0));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/playlists/smart/tracks/add";
    }
}

