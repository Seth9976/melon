package com.iloen.melon.player.video;

import android.view.View.OnClickListener;
import android.view.View;
import com.melon.net.res.common.ArtistsInfoBase;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class w implements View.OnClickListener {
    public final int a;
    public final VideoInfoAdapter b;
    public final ArtistsInfoBase c;
    public final int d;

    public w(VideoInfoAdapter videoInfoAdapter0, int v, ArtistsInfoBase artistsInfoBase0) {
        this.a = 0;
        super();
        this.b = videoInfoAdapter0;
        this.d = v;
        this.c = artistsInfoBase0;
    }

    public w(VideoInfoAdapter videoInfoAdapter0, ArtistsInfoBase artistsInfoBase0, int v) {
        this.a = 1;
        super();
        this.b = videoInfoAdapter0;
        this.c = artistsInfoBase0;
        this.d = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            VideoInfoClickListener videoInfoFragment$VideoInfoClickListener0 = this.b.b;
            if(videoInfoFragment$VideoInfoClickListener0 != null) {
                q.d(view0);
                videoInfoFragment$VideoInfoClickListener0.onArtistFan(view0, this.c, this.d);
            }
            return;
        }
        VideoInfoClickListener videoInfoFragment$VideoInfoClickListener1 = this.b.b;
        if(videoInfoFragment$VideoInfoClickListener1 != null) {
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(this.c);
            CommonClickListener.onArtist$default(videoInfoFragment$VideoInfoClickListener1, arrayList0, false, "FROM_RELATIVE_ARTIST", this.d, 2, null);
        }
    }
}

