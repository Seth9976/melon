package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistInsertRes;

public class MyMusicPlaylistInsertReq extends PlaylistInsertBaseReq {
    public static class Builder extends BuilderBase {
        @Override  // com.iloen.melon.net.v6x.request.PlaylistInsertBaseReq$BuilderBase
        public PlaylistInsertBaseReq build(Context context0) {
            return new MyMusicPlaylistInsertReq(context0, this);
        }

        public Builder introdCont(String s) {
            this.introdCont = s;
            return this;
        }

        public Builder openYn(String s) {
            this.openYn = s;
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

        public Builder repntImgDefaultYn(String s) {
            this.repntImgDefaultYn = s;
            return this;
        }

        public Builder songIds(String s) {
            this.songIds = s;
            return this;
        }

        public Builder type(String s) {
            this.type = s;
            return this;
        }
    }

    public MyMusicPlaylistInsertReq(Context context0, Builder myMusicPlaylistInsertReq$Builder0) {
        super(context0, myMusicPlaylistInsertReq$Builder0, MyMusicPlaylistInsertRes.class);
    }

    @Override  // com.iloen.melon.net.v6x.request.PlaylistInsertBaseReq
    public String getApiPath() {
        return "/mymusic/playlist/insert.json";
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}

