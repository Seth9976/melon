package com.iloen.melon.utils.playlist;

import android.content.Context;
import com.iloen.melon.net.v4x.common.PlaylistType;
import com.iloen.melon.net.v4x.request.PlaylistInformBaseReq;
import com.iloen.melon.net.v4x.request.PlaylistInsertCheckTitleBaseReq;
import com.iloen.melon.net.v4x.request.PlaylistIntrodContBaseReq;
import com.iloen.melon.net.v4x.request.PlaylistUpdateBaseReq;
import com.iloen.melon.net.v4x.request.PlaylistUpdateRepntImageBaseReq;
import com.iloen.melon.net.v4x.request.PlaylistUploadRepntImgBaseReq;
import com.iloen.melon.net.v5x.request.PlaylistListSongBaseReq;
import com.iloen.melon.net.v6x.request.PlaylistAddSongBaseReq.Params;
import com.iloen.melon.net.v6x.request.PlaylistAddSongBaseReq;
import com.iloen.melon.net.v6x.request.PlaylistInsertBaseReq.BuilderBase;
import com.iloen.melon.net.v6x.request.PlaylistInsertBaseReq;

public abstract class PlaylistDetailFactoryBase {
    public static final int LIST_SONG_PROTOCOL_TYPE_DETAIL = 1;
    public static final int LIST_SONG_PROTOCOL_TYPE_LIST = 0;
    public static final int LIST_SONG_PROTOCOL_TYPE_UPDATE = 2;

    public abstract PlaylistAddSongBaseReq addSongList(Context arg1, Params arg2);

    public abstract PlaylistInsertCheckTitleBaseReq checkTitle(Context arg1, String arg2);

    public static PlaylistDetailFactoryBase create(PlaylistType playlistType0) {
        return PlaylistDetailFactoryBase.create(playlistType0.toString());
    }

    public static PlaylistDetailFactoryBase create(String s) {
        if("M20001".equals(s)) {
            return new NormalPlaylistDetailFactory();
        }
        return !"M20002".equals(s) && !"M20003".equals(s) ? null : new DjPlaylistDetailFactory(s);
    }

    public abstract PlaylistInsertBaseReq createPlaylist(Context arg1, BuilderBase arg2);

    public abstract PlaylistCacheCreatorBase getCacheCreator();

    public abstract PlaylistIntrodContBaseReq introdCont(Context arg1, com.iloen.melon.net.v4x.request.PlaylistIntrodContBaseReq.Params arg2);

    // 去混淆评级： 低(30)
    public static Boolean isValidPlylstType(String s) {
        return "M20001".equals(s) || "M20002".equals(s) || "M20003".equals(s);
    }

    public abstract PlaylistInformBaseReq playlistInform(Context arg1, com.iloen.melon.net.v4x.request.PlaylistInformBaseReq.Params arg2);

    public abstract PlaylistListSongBaseReq songList(Context arg1, com.iloen.melon.net.v5x.request.PlaylistListSongBaseReq.Params arg2, int arg3);

    public abstract PlaylistUpdateBaseReq update(Context arg1, com.iloen.melon.net.v4x.request.PlaylistUpdateBaseReq.Params arg2);

    public abstract PlaylistUpdateRepntImageBaseReq updateRepntImage(Context arg1, com.iloen.melon.net.v4x.request.PlaylistUpdateRepntImageBaseReq.Params arg2);

    public abstract PlaylistUploadRepntImgBaseReq uploadRepntImage(Context arg1, com.iloen.melon.net.v4x.request.PlaylistUploadRepntImgBaseReq.Params arg2);
}

