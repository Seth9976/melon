package k8;

import com.android.volley.Response.Listener;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistPlayListSongRes;
import com.iloen.melon.net.v6x.response.PlaylistListSongBaseRes.RESPONSE;
import com.iloen.melon.playback.Playable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;

public final class d0 implements Listener {
    public final MusicBrowserActivity a;
    public final List b;
    public final String c;

    public d0(MusicBrowserActivity musicBrowserActivity0, List list0, String s) {
        this.a = musicBrowserActivity0;
        this.b = list0;
        this.c = s;
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        q.g(((MyMusicPlaylistPlayListSongRes)object0), "res");
        if(((MyMusicPlaylistPlayListSongRes)object0).isSuccessful()) {
            RESPONSE playlistListSongBaseRes$RESPONSE0 = ((MyMusicPlaylistPlayListSongRes)object0).response;
            if(playlistListSongBaseRes$RESPONSE0 != null) {
                ArrayList arrayList0 = playlistListSongBaseRes$RESPONSE0.songList;
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    ArrayList arrayList1 = Playable.getListFromSongBaseArrayOnlyCanService(arrayList0, "", ((MyMusicPlaylistPlayListSongRes)object0).response.statsElements);
                    if(arrayList1 != null && !arrayList1.isEmpty()) {
                        q.d(this.c);
                        this.a.triggerPremiumDownload(arrayList1, this.b, this.c);
                    }
                }
            }
        }
    }
}

