package com.iloen.melon.utils.playlist;

import android.content.Context;
import com.iloen.melon.net.v4x.request.DjPlaylistInformReq;
import com.iloen.melon.net.v4x.request.DjPlaylistInsertCheckTitleReq;
import com.iloen.melon.net.v4x.request.DjPlaylistIntrodContReq;
import com.iloen.melon.net.v4x.request.DjPlaylistUpdDjListRepntImgReq;
import com.iloen.melon.net.v4x.request.PlaylistInformBaseReq;
import com.iloen.melon.net.v4x.request.PlaylistInsertCheckTitleBaseReq;
import com.iloen.melon.net.v4x.request.PlaylistIntrodContBaseReq;
import com.iloen.melon.net.v4x.request.PlaylistUpdateBaseReq;
import com.iloen.melon.net.v4x.request.PlaylistUpdateRepntImageBaseReq;
import com.iloen.melon.net.v4x.request.PlaylistUploadRepntImgBaseReq;
import com.iloen.melon.net.v5x.request.MelonDjPlaylistListSongReq;
import com.iloen.melon.net.v5x.request.PlaylistListSongBaseReq;
import com.iloen.melon.net.v6x.request.DjPlaylistAddDjSongReq;
import com.iloen.melon.net.v6x.request.DjPlaylistUpdateReq;
import com.iloen.melon.net.v6x.request.DjPlaylistUploadDjRepntImgReq;
import com.iloen.melon.net.v6x.request.DjTagSearchRecommendsReq;
import com.iloen.melon.net.v6x.request.PlaylistAddSongBaseReq.Params;
import com.iloen.melon.net.v6x.request.PlaylistAddSongBaseReq;
import com.iloen.melon.net.v6x.request.PlaylistInsertBaseReq.BuilderBase;
import com.iloen.melon.net.v6x.request.PlaylistInsertBaseReq;

public class DjPlaylistDetailFactory extends PlaylistDetailFactoryBase {
    public final String a;

    public DjPlaylistDetailFactory(String s) {
        this.a = s;
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistAddSongBaseReq addSongList(Context context0, Params playlistAddSongBaseReq$Params0) {
        return new DjPlaylistAddDjSongReq(context0, playlistAddSongBaseReq$Params0);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistInsertCheckTitleBaseReq checkTitle(Context context0, String s) {
        return new DjPlaylistInsertCheckTitleReq(context0, s);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistInsertBaseReq createPlaylist(Context context0, BuilderBase playlistInsertBaseReq$BuilderBase0) {
        return playlistInsertBaseReq$BuilderBase0.build(context0);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistCacheCreatorBase getCacheCreator() {
        return new DjPlaylistCacheCreator();
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistIntrodContBaseReq introdCont(Context context0, com.iloen.melon.net.v4x.request.PlaylistIntrodContBaseReq.Params playlistIntrodContBaseReq$Params0) {
        return new DjPlaylistIntrodContReq(context0, playlistIntrodContBaseReq$Params0);
    }

    public DjTagSearchRecommendsReq listRecmTag(Context context0) {
        return new DjTagSearchRecommendsReq(context0);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistInformBaseReq playlistInform(Context context0, com.iloen.melon.net.v4x.request.PlaylistInformBaseReq.Params playlistInformBaseReq$Params0) {
        playlistInformBaseReq$Params0.plylstTypeCode = this.a;
        return new DjPlaylistInformReq(context0, playlistInformBaseReq$Params0);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistListSongBaseReq songList(Context context0, com.iloen.melon.net.v5x.request.PlaylistListSongBaseReq.Params playlistListSongBaseReq$Params0, int v) {
        return new MelonDjPlaylistListSongReq(context0, playlistListSongBaseReq$Params0);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistUpdateBaseReq update(Context context0, com.iloen.melon.net.v4x.request.PlaylistUpdateBaseReq.Params playlistUpdateBaseReq$Params0) {
        return new DjPlaylistUpdateReq(context0, playlistUpdateBaseReq$Params0);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistUpdateRepntImageBaseReq updateRepntImage(Context context0, com.iloen.melon.net.v4x.request.PlaylistUpdateRepntImageBaseReq.Params playlistUpdateRepntImageBaseReq$Params0) {
        return new DjPlaylistUpdDjListRepntImgReq(context0, playlistUpdateRepntImageBaseReq$Params0);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistUploadRepntImgBaseReq uploadRepntImage(Context context0, com.iloen.melon.net.v4x.request.PlaylistUploadRepntImgBaseReq.Params playlistUploadRepntImgBaseReq$Params0) {
        return this.uploadRepntImage(context0, playlistUploadRepntImgBaseReq$Params0);
    }

    public DjPlaylistUploadDjRepntImgReq uploadRepntImage(Context context0, com.iloen.melon.net.v4x.request.PlaylistUploadRepntImgBaseReq.Params playlistUploadRepntImgBaseReq$Params0) {
        return new DjPlaylistUploadDjRepntImgReq(context0, playlistUploadRepntImgBaseReq$Params0);
    }
}

