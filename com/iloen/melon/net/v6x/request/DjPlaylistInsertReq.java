package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjPlaylistInsertRes;

public class DjPlaylistInsertReq extends PlaylistInsertBaseReq {
    public static class Builder extends BuilderBase {
        @Override  // com.iloen.melon.net.v6x.request.PlaylistInsertBaseReq$BuilderBase
        public PlaylistInsertBaseReq build(Context context0) {
            return new DjPlaylistInsertReq(context0, this, 0);
        }

        public Builder introdCont(String s) {
            this.introdCont = s;
            return this;
        }

        public Builder ocrGroupId(String s) {
            this.ocrGroupId = s;
            return this;
        }

        public Builder plylstTitle(String s) {
            this.plylstTitle = s;
            return this;
        }

        public Builder plylstTypeCode(String s) {
            this.plylstTypeCode = s;
            return this;
        }

        public Builder repntImg(String s) {
            this.repntImg = s;
            return this;
        }

        public Builder songIds(String s) {
            this.songIds = s;
            return this;
        }
    }

    private DjPlaylistInsertReq(Context context0, Builder djPlaylistInsertReq$Builder0) {
        super(context0, djPlaylistInsertReq$Builder0, DjPlaylistInsertRes.class);
    }

    public DjPlaylistInsertReq(Context context0, Builder djPlaylistInsertReq$Builder0, int v) {
        this(context0, djPlaylistInsertReq$Builder0);
    }

    @Override  // com.iloen.melon.net.v6x.request.PlaylistInsertBaseReq
    public String getApiPath() {
        return "/dj/playlist/insert.json";
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}

