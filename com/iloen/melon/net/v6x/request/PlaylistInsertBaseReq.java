package com.iloen.melon.net.v6x.request;

import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.utils.log.LogU;
import e1.u;
import va.e0;
import va.o;

public class PlaylistInsertBaseReq extends RequestV6_1Req {
    public static class BuilderBase {
        protected String introdCont;
        protected String introdTypeCodes;
        protected String melonMatchYn;
        protected String ocrGroupId;
        protected String openYn;
        protected String plylstTitle;
        protected String plylstTypeCode;
        protected String repntImg;
        protected String repntImgDefaultYn;
        protected String songIds;
        protected String type;

        public BuilderBase() {
            this.repntImgDefaultYn = "N";
        }

        public PlaylistInsertBaseReq build(Context context0) {
            LogU.w("PlaylistInsertBaseReq", "Must Override this function.");
            return null;
        }
    }

    public static final String TAG = "PlaylistInsertBaseReq";

    public PlaylistInsertBaseReq(Context context0, BuilderBase playlistInsertBaseReq$BuilderBase0, Class class0) {
        super(context0, 1, class0);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParam("plylstTitle", String.valueOf(playlistInsertBaseReq$BuilderBase0.plylstTitle));
        if(!TextUtils.isEmpty(playlistInsertBaseReq$BuilderBase0.plylstTypeCode)) {
            this.addParam("plylstTypeCode", String.valueOf(playlistInsertBaseReq$BuilderBase0.plylstTypeCode));
        }
        if(!TextUtils.isEmpty(playlistInsertBaseReq$BuilderBase0.songIds)) {
            this.addParam("songIds", String.valueOf(playlistInsertBaseReq$BuilderBase0.songIds));
        }
        if(!TextUtils.isEmpty(playlistInsertBaseReq$BuilderBase0.introdCont)) {
            this.addParam("introdCont", String.valueOf(playlistInsertBaseReq$BuilderBase0.introdCont));
        }
        if(!TextUtils.isEmpty(playlistInsertBaseReq$BuilderBase0.repntImg)) {
            this.addParam("repntImg", String.valueOf(playlistInsertBaseReq$BuilderBase0.repntImg));
        }
        if(!TextUtils.isEmpty(playlistInsertBaseReq$BuilderBase0.melonMatchYn)) {
            this.addParam("melonMatchYn", String.valueOf(playlistInsertBaseReq$BuilderBase0.melonMatchYn));
        }
        if(!TextUtils.isEmpty(playlistInsertBaseReq$BuilderBase0.introdTypeCodes)) {
            this.addParam("introdTypeCodes", String.valueOf(playlistInsertBaseReq$BuilderBase0.introdTypeCodes));
        }
        if(!TextUtils.isEmpty(playlistInsertBaseReq$BuilderBase0.openYn)) {
            this.addParam("openYn", String.valueOf(playlistInsertBaseReq$BuilderBase0.openYn));
        }
        if(!TextUtils.isEmpty(playlistInsertBaseReq$BuilderBase0.type)) {
            this.addParam("type", String.valueOf(playlistInsertBaseReq$BuilderBase0.type));
        }
        if(!TextUtils.isEmpty(playlistInsertBaseReq$BuilderBase0.repntImgDefaultYn)) {
            this.addParam("repntImgDefaultYn", String.valueOf(playlistInsertBaseReq$BuilderBase0.repntImgDefaultYn));
        }
        if(!TextUtils.isEmpty(playlistInsertBaseReq$BuilderBase0.ocrGroupId)) {
            this.addParam("ocrGroupId", String.valueOf(playlistInsertBaseReq$BuilderBase0.ocrGroupId));
        }
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        LogU.w("PlaylistInsertBaseReq", "Do not use this Req directly.");
        return null;
    }
}

