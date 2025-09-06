package com.iloen.melon.fragments.searchandadd;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.GiftBoxRecentListSongRecntReq;
import com.iloen.melon.net.v4x.request.MyMusicMessageRecentListSongRecntReq;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.iloen.melon.net.v5x.request.DjPlaylistRecentListSongRecntReq;
import com.iloen.melon.net.v5x.request.MyMusicRecentListSongRecntReq;
import com.iloen.melon.net.v5x.request.RecentListSongRecntBaseReq.Params;
import com.iloen.melon.net.v5x.request.RecentListSongRecntBaseReq;
import com.iloen.melon.net.v5x.response.RecentListSongRecntResBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.model.Sharable;
import com.melon.net.res.common.SongInfoBase;
import e1.u;
import java.util.List;
import v9.h;
import v9.i;
import va.e0;
import va.o;

public class SongRecentSearchAndAddFragment extends SearchAndAddBaseFragment {
    class SearchAndAddSongRecentAdapter extends SearchAndAddBaseAdapter {
        private static final int VIEW_TYPE_ITEM = 1;

        public SearchAndAddSongRecentAdapter(Context context0, List list0, int v) {
            super(context0, list0, v);
            this.setListContentType(1);
            if(this.mSearchViewType != 1 && this.mSearchViewType != 2 && this.mSearchViewType != 3 && this.mSearchViewType != 4) {
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
            SongInfoBase songInfoBase0 = (SongInfoBase)this.getItem(v);
            return songInfoBase0 != null ? Playable.from(songInfoBase0, songInfoBase0.getMenuId(), null) : null;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(o00.getItemViewType() == 1 && o00 instanceof SearchAndAddSongViewHolder) {
                ((SearchAndAddSongViewHolder)o00).bindView(((SongInfoBase)this.getItem(v1)), v, v1);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return v != 1 ? null : new SearchAndAddSongViewHolder(this.mInflater.inflate(0x7F0D04A8, viewGroup0, false), this);  // layout:listitem_song
        }
    }

    private static final String TAG = "SongRecentSearchAndAddFragment";

    public static void access$300(SongRecentSearchAndAddFragment songRecentSearchAndAddFragment0, i i0, HttpResponse httpResponse0) {
        songRecentSearchAndAddFragment0.performFetchComplete(i0, httpResponse0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new SearchAndAddSongRecentAdapter(this, context0, null, this.mSearchViewType);
        ((SearchAndAddBaseAdapter)j00).setOnItemEventListener(this.mSongItemEventListener);
        ((SearchAndAddBaseAdapter)j00).setOnItemViewClickListener(this.mOnItemViewClickListener);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.h.buildUpon().appendPath("songRecent").appendQueryParameter("searchViewType", String.valueOf(this.mSearchViewType)).appendQueryParameter("caller", String.valueOf(this.mCaller)).build().toString();
    }

    private RecentListSongRecntBaseReq getRecentListSongReq() {
        Params recentListSongRecntBaseReq$Params0 = new Params();
        recentListSongRecntBaseReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        switch(this.mCaller) {
            case 1: 
            case 2: {
                return new MyMusicRecentListSongRecntReq(this.getContext(), recentListSongRecntBaseReq$Params0);
            }
            case 3: 
            case 4: {
                return new DjPlaylistRecentListSongRecntReq(this.getContext(), recentListSongRecntBaseReq$Params0);
            }
            default: {
                return null;
            }
        }
    }

    public static SongRecentSearchAndAddFragment newInstance(int v, int v1, int v2) {
        if(v == -1) {
            throw new IllegalArgumentException("Invalid searchViewType - " + -1);
        }
        SongRecentSearchAndAddFragment songRecentSearchAndAddFragment0 = new SongRecentSearchAndAddFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argSearchViewType", v);
        bundle0.putInt("argCaller", v1);
        bundle0.putInt("argMaxContentCount", v2);
        songRecentSearchAndAddFragment0.setArguments(bundle0);
        return songRecentSearchAndAddFragment0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        MyMusicMessageRecentListSongRecntReq myMusicMessageRecentListSongRecntReq0;
        if(i.b.equals(i0)) {
            this.clearData();
        }
        RecentListSongRecntBaseReq recentListSongRecntBaseReq0 = this.getRecentListSongReq();
        if(recentListSongRecntBaseReq0 != null) {
            RequestBuilder.newInstance(recentListSongRecntBaseReq0).tag("SongRecentSearchAndAddFragment").listener(new Listener() {
                public void onResponse(RecentListSongRecntResBase recentListSongRecntResBase0) {
                    if(!SongRecentSearchAndAddFragment.this.prepareFetchComplete(recentListSongRecntResBase0)) {
                        return;
                    }
                    SongRecentSearchAndAddFragment.this.performFetchComplete(i0, recentListSongRecntResBase0);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((RecentListSongRecntResBase)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        int v = this.mCaller;
        boolean z = false;
        if(v == 5) {
            z = true;
            com.iloen.melon.net.v4x.request.MyMusicMessageRecentListSongRecntReq.Params myMusicMessageRecentListSongRecntReq$Params0 = new com.iloen.melon.net.v4x.request.MyMusicMessageRecentListSongRecntReq.Params();
            myMusicMessageRecentListSongRecntReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
            myMusicMessageRecentListSongRecntReq0 = new MyMusicMessageRecentListSongRecntReq(this.getContext(), myMusicMessageRecentListSongRecntReq$Params0);
        }
        else if(v == 11) {
            z = true;
            myMusicMessageRecentListSongRecntReq0 = new GiftBoxRecentListSongRecntReq(this.getContext(), u.v(((e0)o.a()).j()));
        }
        if(z) {
            RequestBuilder.newInstance(myMusicMessageRecentListSongRecntReq0).tag("SongRecentSearchAndAddFragment").listener(new Listener() {
                public void onResponse(ResponseV4Res responseV4Res0) {
                    if(!SongRecentSearchAndAddFragment.this.prepareFetchComplete(responseV4Res0)) {
                        return;
                    }
                    SongRecentSearchAndAddFragment.access$300(SongRecentSearchAndAddFragment.this, i0, responseV4Res0);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((ResponseV4Res)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        this.performFetchCompleteOnlyViews();
        return true;
    }
}

