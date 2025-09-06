package com.google.android.exoplayer2.upstream.cache;

import androidx.activity.result.ActivityResult;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.material.textfield.v;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistRecommendTrackHolder;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment;
import com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment;
import com.iloen.melon.fragments.melonchart.MelonChartArtistFragment;
import com.iloen.melon.fragments.melontv.MelonTvBroadcastFragment;
import com.iloen.melon.fragments.melontv.MelonTvOriginalFragment;
import com.iloen.melon.fragments.melontv.MelonTvProgramSelectFragment;
import com.iloen.melon.fragments.musicmessage.MusicMessageBlockListFragment;
import com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment;
import com.iloen.melon.utils.system.ToastManager;
import com.kakaoent.trevi.ad.TreviAd.OfferWallNavigationDelegate;

public final class a implements ErrorListener, Listener, CacheKeyFactory, v, OfferWallNavigationDelegate, e.a {
    public final int a;

    public a(int v) {
        this.a = v;
        super();
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.CacheKeyFactory
    public String buildCacheKey(DataSpec dataSpec0) {
        return CacheUtil.lambda$static$0(dataSpec0);
    }

    @Override  // e.a
    public void onActivityResult(Object object0) {
        if(this.a != 22) {
            MelonTvOriginalFragment.f0(((ActivityResult)object0));
            return;
        }
        MelonTvBroadcastFragment.f0(((ActivityResult)object0));
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        switch(this.a) {
            case 10: {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                return;
            }
            case 11: {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                return;
            }
            case 12: {
                ArtistRecommendTrackHolder.d(volleyError0);
                return;
            }
            case 15: {
                PhotoDetailViewFragment.d0(volleyError0);
                return;
            }
            case 16: {
                PhotoDetailViewFragment.s0(volleyError0);
                return;
            }
            case 17: {
                PlaylistDetailBaseFragment.r0(volleyError0);
                return;
            }
            case 19: {
                com.iloen.melon.fragments.detail.SongDetailFragment.getOnViewHolderActionListener.1.b(volleyError0);
                return;
            }
            case 20: {
                return;
            }
            case 21: {
                MelonChartArtistFragment.u0(volleyError0);
                return;
            }
            case 24: {
                MelonTvProgramSelectFragment.e0(volleyError0);
                return;
            }
            case 25: {
                MusicMessageBlockListFragment.f0(volleyError0);
                return;
            }
            case 26: {
                MusicMessageEditorFragment.o0(volleyError0);
                return;
            }
            case 27: {
                MusicMessageEditorFragment.C0(volleyError0);
                return;
            }
            case 28: {
                MusicMessageEditorFragment.p0(volleyError0);
                return;
            }
            default: {
                MusicMessageEditorFragment.n0(volleyError0);
            }
        }
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        if(this.a != 14) {
            com.iloen.melon.fragments.detail.SongDetailFragment.getOnViewHolderActionListener.1.a(object0);
        }
    }
}

