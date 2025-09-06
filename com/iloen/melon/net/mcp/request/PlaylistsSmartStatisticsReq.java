package com.iloen.melon.net.mcp.request;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.gson.n;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.mcp.AddOptionServer;
import com.iloen.melon.net.mcp.response.PlaylistsSmartRes;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.DeviceIdentifier;
import oc.M;
import oc.p0;
import oc.q0;
import oc.r0;
import oc.s0;
import oc.u0;
import oc.v0;
import oc.w0;
import oc.x0;
import oc.y0;

public class PlaylistsSmartStatisticsReq extends PlaylistsSmartBaseReq {
    public static class Statistics {
        public String addOption;
        public boolean allowDuplicate;
        public String appVersion;
        public boolean deleteExisting;
        public String deviceModel;
        public String eqAutoOn;
        public boolean eqOn;
        public boolean loudnessNorm;
        public String memberKey;
        public int myEqCnt;
        public String myEqOptionCnt;
        public String pcId;
        public String playlistTab;
        public String pocCode;
        public String presetCode;
        public String repeat;
        public boolean shuffle;
        public boolean smartPlaylistOn;
        public String sortOption;
        public String targetLufs;
        public int trackListSize;
        public String transParent;

        private Statistics() {
            this.memberKey = "";
            this.trackListSize = 0;
            this.smartPlaylistOn = false;
            this.sortOption = "";
            this.addOption = "";
            this.allowDuplicate = true;
            this.deleteExisting = false;
            this.playlistTab = null;
            this.shuffle = false;
            this.repeat = "";
            this.deviceModel = "";
            this.pocCode = "";
            this.appVersion = "";
            this.eqOn = false;
            this.eqAutoOn = "";
            this.presetCode = "";
            this.myEqCnt = 0;
            this.myEqOptionCnt = "";
            this.pcId = DeviceIdentifier.id(MelonAppBase.instance.getDeviceData().a);
            this.deviceModel = Build.MODEL;
            this.pocCode = MelonAppBase.instance.getMelonCpId();
            this.appVersion = AppUtils.getVersionName(MelonAppBase.instance.getContext());
        }

        public Statistics(String s, int v, boolean z, y0 y00, AddOptionServer addOptionServer0, boolean z1, boolean z2, String s1, boolean z3, M m0, boolean z4, String s2, int v1, boolean z5, float f, boolean z6) {
            this.memberKey = s;
            this.trackListSize = v;
            this.smartPlaylistOn = z;
            this.sortOption = this.convertSortOption(y00);
            this.addOption = addOptionServer0.getValue();
            this.allowDuplicate = z1;
            this.deleteExisting = z2;
            if(TextUtils.isEmpty(s1)) {
                s1 = null;
            }
            this.playlistTab = s1;
            this.shuffle = z3;
            this.repeat = this.convertRepeatOption(m0);
            this.eqOn = z4;
            this.presetCode = s2;
            this.myEqCnt = v1;
            this.loudnessNorm = z5;
            String s3 = "";
            this.targetLufs = z5 ? this.convertTargetLufsOption(f) : "";
            if(z5) {
                s3 = String.valueOf(z6);
            }
            this.transParent = s3;
        }

        private String convertRepeatOption(M m0) {
            if(m0 == M.b) {
                return "ON";
            }
            return m0 == M.c ? "ONE" : "OFF";
        }

        private String convertSortOption(y0 y00) {
            if(y00 instanceof s0) {
                return "PLAY_COUNT";
            }
            if(y00 instanceof u0) {
                return "NEWEST_FIRST";
            }
            if(y00 instanceof v0) {
                return "OLDEST_FIRST";
            }
            if(y00 instanceof q0) {
                return "ARTIST_NAME_ASC";
            }
            if(y00 instanceof r0) {
                return "ARTIST_NAME_DESC";
            }
            if(y00 instanceof w0) {
                return "SONG_NAME_ASC";
            }
            if(y00 instanceof x0) {
                return "SONG_NAME_DESC";
            }
            return y00 instanceof p0 ? "ALBUM_NAME" : "CUSTOM";
        }

        private String convertTargetLufsOption(float f) {
            if(f > -14.0f) {
                return "High";
            }
            return f < -14.0f ? "Low" : "Medium";
        }
    }

    public PlaylistsSmartStatisticsReq(Context context0, Statistics playlistsSmartStatisticsReq$Statistics0) {
        super(context0, 1, PlaylistsSmartRes.class);
        this.setJsonString(new n().k(playlistsSmartStatisticsReq$Statistics0));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/playlists/smart/statistics";
    }
}

