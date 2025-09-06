package com.iloen.melon.player.video;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.SONG;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class p0 implements View.OnClickListener {
    public final int a;
    public final SongListFragment b;
    public final SONG c;

    public p0(SONG liveTimedMetaSongRes$SONG0, SongListFragment videoSongListBottomSheetFragment$SongListFragment0, int v) {
        this.a = v;
        this.c = liveTimedMetaSongRes$SONG0;
        this.b = videoSongListBottomSheetFragment$SongListFragment0;
        super();
    }

    public p0(SongListFragment videoSongListBottomSheetFragment$SongListFragment0, SONG liveTimedMetaSongRes$SONG0) {
        this.a = 1;
        super();
        this.b = videoSongListBottomSheetFragment$SongListFragment0;
        this.c = liveTimedMetaSongRes$SONG0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        String s = "";
        SongListFragment videoSongListBottomSheetFragment$SongListFragment0 = this.b;
        SONG liveTimedMetaSongRes$SONG0 = this.c;
        switch(this.a) {
            case 0: {
                ArrayList arrayList0 = new ArrayList();
                arrayList0.add(liveTimedMetaSongRes$SONG0);
                SongListFragment.access$setAddSongInfo(videoSongListBottomSheetFragment$SongListFragment0, arrayList0);
                videoSongListBottomSheetFragment$SongListFragment0.showContextMenuAddTo();
                String s4 = videoSongListBottomSheetFragment$SongListFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                q.f(s4, "getString(...)");
                String s5 = videoSongListBottomSheetFragment$SongListFragment0.getString(0x7F130D19);  // string:tiara_click_copy_context_add "담기"
                q.f(s5, "getString(...)");
                String s6 = liveTimedMetaSongRes$SONG0.songId == null ? "" : liveTimedMetaSongRes$SONG0.songId;
                String s7 = videoSongListBottomSheetFragment$SongListFragment0.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
                q.f(s7, "getString(...)");
                String s8 = liveTimedMetaSongRes$SONG0.songName;
                if(s8 != null) {
                    s = s8;
                }
                SongListFragment.access$sendTiaraLogPlayer(videoSongListBottomSheetFragment$SongListFragment0, s4, null, s5, new EventMeta(s6, s7, s));
                return;
            }
            case 1: {
                MetaContentBaseFragment metaContentBaseFragment0 = SongListFragment.access$getRootFragment(videoSongListBottomSheetFragment$SongListFragment0);
                if(metaContentBaseFragment0 != null) {
                    metaContentBaseFragment0.showContextPopupSong(Playable.from(liveTimedMetaSongRes$SONG0, videoSongListBottomSheetFragment$SongListFragment0.mMenuId, null));
                }
                String s9 = videoSongListBottomSheetFragment$SongListFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                q.f(s9, "getString(...)");
                String s10 = videoSongListBottomSheetFragment$SongListFragment0.getString(0x7F130D54);  // string:tiara_click_copy_more "더보기"
                q.f(s10, "getString(...)");
                String s11 = liveTimedMetaSongRes$SONG0.songId == null ? "" : liveTimedMetaSongRes$SONG0.songId;
                String s12 = videoSongListBottomSheetFragment$SongListFragment0.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
                q.f(s12, "getString(...)");
                String s13 = liveTimedMetaSongRes$SONG0.songName;
                if(s13 != null) {
                    s = s13;
                }
                SongListFragment.access$sendTiaraLogPlayer(videoSongListBottomSheetFragment$SongListFragment0, s9, null, s10, new EventMeta(s11, s12, s));
                return;
            }
            default: {
                Navigator.openAlbumInfo(liveTimedMetaSongRes$SONG0.albumId);
                String s1 = videoSongListBottomSheetFragment$SongListFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                q.f(s1, "getString(...)");
                String s2 = liveTimedMetaSongRes$SONG0.albumId == null ? "" : liveTimedMetaSongRes$SONG0.albumId;
                String s3 = videoSongListBottomSheetFragment$SongListFragment0.getString(0x7F130EF0);  // string:tiara_meta_type_album "앨범"
                q.f(s3, "getString(...)");
                SongListFragment.access$sendTiaraLogPlayer(videoSongListBottomSheetFragment$SongListFragment0, s1, ActionKind.ClickContent, "", new EventMeta(s2, s3, (liveTimedMetaSongRes$SONG0.albumName == null ? "" : liveTimedMetaSongRes$SONG0.albumName)));
                SongListFragment.access$closeBottomSheet(videoSongListBottomSheetFragment$SongListFragment0);
            }
        }
    }
}

