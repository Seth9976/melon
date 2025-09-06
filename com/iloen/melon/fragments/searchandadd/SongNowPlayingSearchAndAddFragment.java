package com.iloen.melon.fragments.searchandadd;

import M6.B;
import M6.s;
import M6.t;
import M6.u;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.interfaces.PlayableData;
import e1.b;
import java.util.List;
import javax.inject.Inject;
import kc.B2;
import kc.d3;
import kc.s2;
import kotlinx.coroutines.guava.ListenableFutureKt;
import oc.H;
import oc.Q;
import v9.h;
import v9.i;

public class SongNowPlayingSearchAndAddFragment extends Hilt_SongNowPlayingSearchAndAddFragment {
    class SearchAndAddNowPlayingSongAdapter extends SearchAndAddBaseAdapter {
        private static final int VIEW_TYPE_ITEM = 1;

        public SearchAndAddNowPlayingSongAdapter(Context context0, List list0, int v) {
            super(context0, list0, v);
            this.setListContentType(1);
            if(v != 1 && v != 2) {
                return;
            }
            this.setMarkedMode(true);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 1;
        }

        @Override  // com.iloen.melon.fragments.searchandadd.SearchAndAddBaseAdapter
        public Sharable getSharable(int v) {
            return ((PlayableData)this.getItem(v)).a;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(o00.getItemViewType() == 1 && o00 instanceof SearchAndAddSongViewHolder) {
                ((SearchAndAddSongViewHolder)o00).bindView(((PlayableData)this.getItem(v1)), v, v1);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return v != 1 ? null : new SearchAndAddSongViewHolder(this.mInflater.inflate(0x7F0D04A8, viewGroup0, false), this);  // layout:listitem_song
        }
    }

    private static final String TAG = "SongNowPlayingSearchAndAddFragment";
    @Inject
    s2 playlistManager;

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new SearchAndAddNowPlayingSongAdapter(this, context0, null, this.mSearchViewType);
        ((SearchAndAddBaseAdapter)j00).setOnItemEventListener(this.mSongItemEventListener);
        ((SearchAndAddBaseAdapter)j00).setOnItemViewClickListener(this.mOnItemViewClickListener);
        return j00;
    }

    private List fetchNowplayingData(Q q0) {
        LogU.v("SongNowPlayingSearchAndAddFragment", "fetchNowplayingData()");
        for(Object object0: q0.c()) {
            ((PlayableData)object0).a.setService(true);
        }
        return b.w(q0);
    }

    public static SongNowPlayingSearchAndAddFragment newInstance(int v, int v1) {
        if(v == -1) {
            throw new IllegalArgumentException("Invalid searchViewType - " + -1);
        }
        SongNowPlayingSearchAndAddFragment songNowPlayingSearchAndAddFragment0 = new SongNowPlayingSearchAndAddFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argSearchViewType", v);
        bundle0.putInt("argMaxContentCount", v1);
        songNowPlayingSearchAndAddFragment0.setArguments(bundle0);
        return songNowPlayingSearchAndAddFragment0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        B b0 = ListenableFutureKt.future$default(((d3)this.playlistManager).b, null, null, new B2(((d3)this.playlistManager), null), 3, null);
        b0.addListener(new u(0, b0, new t() {
            @Override  // M6.t
            public void onFailure(Throwable throwable0) {
            }

            @Override  // M6.t
            public void onSuccess(Object object0) {
                this.onSuccess(((H)object0));
            }

            public void onSuccess(H h0) {
                SearchAndAddNowPlayingSongAdapter songNowPlayingSearchAndAddFragment$SearchAndAddNowPlayingSongAdapter0 = (SearchAndAddNowPlayingSongAdapter)SongNowPlayingSearchAndAddFragment.this.getMelonArrayAdapter();
                songNowPlayingSearchAndAddFragment$SearchAndAddNowPlayingSongAdapter0.clear();
                Q q0 = h0.getState();
                songNowPlayingSearchAndAddFragment$SearchAndAddNowPlayingSongAdapter0.addAll(SongNowPlayingSearchAndAddFragment.this.fetchNowplayingData(q0));
            }
        }), s.a);
        return false;
    }
}

