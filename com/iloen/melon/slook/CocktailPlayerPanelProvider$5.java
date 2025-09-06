package com.iloen.melon.slook;

import android.app.PendingIntent.CanceledException;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.playback.Actor;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.task.request.TaskGetSongInfo.ResultListener;
import com.iloen.melon.task.request.TaskGetSongInfo;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.net.res.common.SongInfoBase;

class CocktailPlayerPanelProvider.5 implements ResultListener {
    public final TaskGetSongInfo a;
    public final Playable b;
    public final Context c;
    public final CocktailPlayerPanelProvider d;

    public CocktailPlayerPanelProvider.5(CocktailPlayerPanelProvider cocktailPlayerPanelProvider0, TaskGetSongInfo taskGetSongInfo0, Playable playable0, Context context0) {
        this.d = cocktailPlayerPanelProvider0;
        this.a = taskGetSongInfo0;
        this.b = playable0;
        this.c = context0;
    }

    @Override  // com.iloen.melon.task.request.TaskGetSongInfo$ResultListener
    public void onFinishTask(Throwable throwable0) {
        SongInfoBase songInfoBase0;
        String s = null;
        if(throwable0 == null) {
            songInfoBase0 = this.a.getSongInfo();
            if(songInfoBase0 != null) {
                this.b.updateFrom(songInfoBase0);
                String s1 = songInfoBase0.albumId;
                if(TextUtils.isEmpty(s1)) {
                    LogU.e("CocktailPlayerPanelProvider", "showAlbumInfoPage() invalid albumId");
                    ToastManager.showShort(0x7F13019A);  // string:cannot_find_album_info "앨범 정보가 없습니다."
                }
                else {
                    this.d.getClass();
                    Intent intent0 = new Intent(this.c, MusicBrowserActivity.class);
                    intent0.setAction("com.iloen.melon.ALBUM_INFO");
                    intent0.putExtra("com.iloen.melon.intent.extra.actor", Actor.EdgeSinglePlus);
                    intent0.putExtra("com.iloen.melon.intent.extra.widget.album_id", s1);
                    PendingIntent pendingIntent0 = PendingIntent.getActivity(this.c, Actor.EdgeSinglePlus.ordinal(), intent0, 0xC000000);
                    try {
                        pendingIntent0.send();
                    }
                    catch(PendingIntent.CanceledException pendingIntent$CanceledException0) {
                        LogU.w("CocktailPlayerPanelProvider", "CanceledException : " + pendingIntent$CanceledException0.getMessage());
                    }
                }
            }
        }
        else {
            songInfoBase0 = null;
        }
        if(throwable0 != null || songInfoBase0 == null) {
            if(throwable0 != null) {
                s = throwable0.getMessage();
            }
            if(TextUtils.isEmpty(s)) {
                ToastManager.showShort(0x7F13019A);  // string:cannot_find_album_info "앨범 정보가 없습니다."
                return;
            }
            ToastManager.showShort(s);
        }
    }

    @Override  // com.iloen.melon.task.request.TaskGetSongInfo$ResultListener
    public void onStartTask() {
    }
}

