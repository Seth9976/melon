package com.iloen.melon.utils.playlist;

import android.content.Context;
import com.iloen.melon.net.v4x.request.MyMusicPlaylistInformReq;
import com.iloen.melon.net.v4x.request.MyMusicPlaylistInsertCheckTitleReq;
import com.iloen.melon.net.v4x.request.MyMusicPlaylistIntrodContReq;
import com.iloen.melon.net.v4x.request.MyMusicPlaylistUpdateRepntImgReq;
import com.iloen.melon.net.v4x.request.MyMusicPlaylistUploadRepntImgReq;
import com.iloen.melon.net.v4x.request.PlaylistInformBaseReq;
import com.iloen.melon.net.v4x.request.PlaylistInsertCheckTitleBaseReq;
import com.iloen.melon.net.v4x.request.PlaylistIntrodContBaseReq;
import com.iloen.melon.net.v4x.request.PlaylistUpdateBaseReq;
import com.iloen.melon.net.v4x.request.PlaylistUpdateRepntImageBaseReq;
import com.iloen.melon.net.v4x.request.PlaylistUploadRepntImgBaseReq;
import com.iloen.melon.net.v5x.request.MyMusicPlaylistDetailListSongReq;
import com.iloen.melon.net.v5x.request.MyMusicPlaylistListSongReq;
import com.iloen.melon.net.v5x.request.MyMusicPlaylistUpdateListSongReq;
import com.iloen.melon.net.v5x.request.PlaylistListSongBaseReq;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistInsertSongReq;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistUpdateReq;
import com.iloen.melon.net.v6x.request.PlaylistAddSongBaseReq.Params;
import com.iloen.melon.net.v6x.request.PlaylistAddSongBaseReq;
import com.iloen.melon.net.v6x.request.PlaylistInsertBaseReq.BuilderBase;
import com.iloen.melon.net.v6x.request.PlaylistInsertBaseReq;

public class NormalPlaylistDetailFactory extends PlaylistDetailFactoryBase {
    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistAddSongBaseReq addSongList(Context context0, Params playlistAddSongBaseReq$Params0) {
        playlistAddSongBaseReq$Params0.type = "add";
        return new MyMusicPlaylistInsertSongReq(context0, playlistAddSongBaseReq$Params0);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistInsertCheckTitleBaseReq checkTitle(Context context0, String s) {
        return new MyMusicPlaylistInsertCheckTitleReq(context0, s);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistInsertBaseReq createPlaylist(Context context0, BuilderBase playlistInsertBaseReq$BuilderBase0) {
        return playlistInsertBaseReq$BuilderBase0.build(context0);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistCacheCreatorBase getCacheCreator() {
        return new NormalPlaylistCacheCreator();
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistIntrodContBaseReq introdCont(Context context0, com.iloen.melon.net.v4x.request.PlaylistIntrodContBaseReq.Params playlistIntrodContBaseReq$Params0) {
        return new MyMusicPlaylistIntrodContReq(context0, playlistIntrodContBaseReq$Params0);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistInformBaseReq playlistInform(Context context0, com.iloen.melon.net.v4x.request.PlaylistInformBaseReq.Params playlistInformBaseReq$Params0) {
        return new MyMusicPlaylistInformReq(context0, playlistInformBaseReq$Params0);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistListSongBaseReq songList(Context context0, com.iloen.melon.net.v5x.request.PlaylistListSongBaseReq.Params playlistListSongBaseReq$Params0, int v) {
        if(v == 0) {
            return new MyMusicPlaylistListSongReq(context0, playlistListSongBaseReq$Params0);
        }
        return v == 1 ? new MyMusicPlaylistDetailListSongReq(context0, playlistListSongBaseReq$Params0) : new MyMusicPlaylistUpdateListSongReq(context0, playlistListSongBaseReq$Params0);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistUpdateBaseReq update(Context context0, com.iloen.melon.net.v4x.request.PlaylistUpdateBaseReq.Params playlistUpdateBaseReq$Params0) {
        return new MyMusicPlaylistUpdateReq(context0, playlistUpdateBaseReq$Params0);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistUpdateRepntImageBaseReq updateRepntImage(Context context0, com.iloen.melon.net.v4x.request.PlaylistUpdateRepntImageBaseReq.Params playlistUpdateRepntImageBaseReq$Params0) {
        return new MyMusicPlaylistUpdateRepntImgReq(context0, playlistUpdateRepntImageBaseReq$Params0);
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase
    public PlaylistUploadRepntImgBaseReq uploadRepntImage(Context context0, com.iloen.melon.net.v4x.request.PlaylistUploadRepntImgBaseReq.Params playlistUploadRepntImgBaseReq$Params0) {
        return new MyMusicPlaylistUploadRepntImgReq(context0, playlistUploadRepntImgBaseReq$Params0);
    }
}

