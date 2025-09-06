package com.iloen.melon.fragments.mymusic;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v4x.response.PlaylistUploadRepntImgRes;

public final class j0 implements ErrorListener, Listener {
    public final int a;
    public final SeriesPlaylistMakeFragment b;

    public j0(SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0, int v) {
        this.a = v;
        this.b = seriesPlaylistMakeFragment0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.imageSelectorListener.1.onImageSelectorComplete$lambda$1(this.b, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        switch(this.a) {
            case 0: {
                SeriesPlaylistMakeFragment.initTitleBar$lambda$4$lambda$1(this.b, object0);
                return;
            }
            case 1: {
                SeriesPlaylistMakeFragment.requestDjSeriesDelete$lambda$6(this.b, object0);
                return;
            }
            case 2: {
                SeriesPlaylistMakeFragment.requestDjSeriesModify$lambda$8(this.b, object0);
                return;
            }
            case 3: {
                SeriesPlaylistMakeFragment.requestDjSeriesCreate$lambda$5(this.b, object0);
                return;
            }
            default: {
                com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.imageSelectorListener.1.onImageSelectorComplete$lambda$0(this.b, ((PlaylistUploadRepntImgRes)object0));
            }
        }
    }
}

