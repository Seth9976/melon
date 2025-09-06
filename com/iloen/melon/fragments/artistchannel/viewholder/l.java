package com.iloen.melon.fragments.artistchannel.viewholder;

import android.graphics.Bitmap;
import androidx.recyclerview.widget.O0;
import com.android.volley.Response.Listener;
import com.iloen.melon.net.v6x.response.ArtistMusicRecmtrackSongListRes;
import com.iloen.melon.utils.template.TemplateImageLoader.CaptureStateListener;

public final class l implements Listener, CaptureStateListener {
    public final O0 a;

    public l(O0 o00) {
        this.a = o00;
        super();
    }

    @Override  // com.iloen.melon.utils.template.TemplateImageLoader$CaptureStateListener
    public void onCaptureComplete(Bitmap bitmap0) {
        ArtistRecommendTrackHolder.bindItem$lambda$2$lambda$1(((ViewHolder)this.a), bitmap0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        ArtistRecommendTrackHolder.bindItem$lambda$9$lambda$6(((ArtistRecommendTrackHolder)this.a), ((ArtistMusicRecmtrackSongListRes)object0));
    }
}

