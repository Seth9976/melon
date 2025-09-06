package com.iloen.melon.fragments.searchandadd;

import a9.d;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.LikeListSongBaseReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicDjPlaylistInsertLikeListSongReq;
import com.iloen.melon.net.v4x.request.MyMusicDjPlaylistUpdateLikeListSongReq;
import com.iloen.melon.net.v4x.request.MyMusicGiftBoxLikeListSongReq;
import com.iloen.melon.net.v4x.request.MyMusicMessageLikeListSongReq;
import com.iloen.melon.net.v4x.request.MyMusicPlaylistInsertLikeListSongReq;
import com.iloen.melon.net.v4x.request.MyMusicPlaylistUpdateLikeListSongReq;
import com.iloen.melon.net.v4x.request.MyMusicProfileLikeListSongReq;
import com.iloen.melon.net.v4x.request.NowPlayingInsertLikeListSongReq;
import com.iloen.melon.net.v4x.request.NowPlayingUpdateLikeListSongReq;
import com.iloen.melon.net.v4x.response.LikeListSongBaseRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.model.Sharable;
import com.melon.net.res.common.SongInfoBase;
import e1.u;
import java.util.List;
import v9.h;
import v9.i;
import va.e0;
import va.o;

public class SongLikeSearchAndAddFragment extends SearchAndAddBaseFragment {
    class SearchAndAddSongLikeAdapter extends SearchAndAddBaseAdapter {
        private static final int VIEW_TYPE_ITEM = 2;
        private static final int VIEW_TYPE_SORTBAR = 1;

        public SearchAndAddSongLikeAdapter(Context context0, List list0, int v) {
            super(context0, list0, v);
            this.setListContentType(1);
            if(this.mSearchViewType != 1 && this.mSearchViewType != 2 && this.mSearchViewType != 3 && this.mSearchViewType != 4) {
                return;
            }
            this.setMarkedMode(true);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return !this.getList().isEmpty();
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? 2 : 1;
        }

        @Override  // com.iloen.melon.fragments.searchandadd.SearchAndAddBaseAdapter
        public Sharable getSharable(int v) {
            SongInfoBase songInfoBase0 = (SongInfoBase)this.getItem(v);
            return songInfoBase0 != null ? Playable.from(songInfoBase0, songInfoBase0.getMenuId(), null) : null;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(o00.getItemViewType() == 2 && o00 instanceof SearchAndAddSongViewHolder) {
                ((SearchAndAddSongViewHolder)o00).bindView(((SongInfoBase)this.getItem(v1)), v, v1);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            switch(v) {
                case 1: {
                    O0 o00 = new SearchAndAddSortbarViewHolder(this.mInflater.inflate(0x7F0D085D, viewGroup0, false), SongLikeSearchAndAddFragment.this.getResources().getStringArray(0x7F03003B));  // layout:sortbar_view
                    ((SearchAndAddSortbarViewHolder)o00).setOnSortSelectionListener(new d() {
                        @Override  // a9.d
                        public void onSelected(int v) {
                            SongLikeSearchAndAddFragment songLikeSearchAndAddFragment0 = SongLikeSearchAndAddFragment.this;
                            if(v == songLikeSearchAndAddFragment0.mSortType) {
                                return;
                            }
                            songLikeSearchAndAddFragment0.mSortType = v;
                            if(v == 0) {
                                songLikeSearchAndAddFragment0.mOrderBy = "NEW";
                            }
                            else {
                                switch(v) {
                                    case 1: {
                                        songLikeSearchAndAddFragment0.mOrderBy = "ALPHABET";
                                        break;
                                    }
                                    case 2: {
                                        songLikeSearchAndAddFragment0.mOrderBy = "ARTIST";
                                    }
                                }
                            }
                            SongLikeSearchAndAddFragment.this.startFetch("onSortSelected");
                        }
                    });
                    return o00;
                }
                case 2: {
                    return new SearchAndAddSongViewHolder(this.mInflater.inflate(0x7F0D04A8, viewGroup0, false), this);  // layout:listitem_song
                }
                default: {
                    return null;
                }
            }
        }
    }

    private static final int PAGE_SIZE = 100;
    private static final String TAG = "SongLikeSearchAndAddFragment";
    private String mOrderBy;

    public SongLikeSearchAndAddFragment() {
        this.mOrderBy = "NEW";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new SearchAndAddSongLikeAdapter(this, context0, null, this.mSearchViewType);
        ((SearchAndAddBaseAdapter)j00).setOnItemEventListener(this.mSongItemEventListener);
        ((SearchAndAddBaseAdapter)j00).setOnItemViewClickListener(this.mOnItemViewClickListener);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.h.buildUpon().appendPath("songLike").appendQueryParameter("orderBy", this.mOrderBy).appendQueryParameter("caller", String.valueOf(this.mCaller)).build().toString();
    }

    public static SongLikeSearchAndAddFragment newInstance(int v, int v1, int v2) {
        if(v == -1) {
            throw new IllegalArgumentException("Invalid searchViewType - " + -1);
        }
        SongLikeSearchAndAddFragment songLikeSearchAndAddFragment0 = new SongLikeSearchAndAddFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argSearchViewType", v);
        bundle0.putInt("argCaller", v1);
        bundle0.putInt("argMaxContentCount", v2);
        songLikeSearchAndAddFragment0.setArguments(bundle0);
        return songLikeSearchAndAddFragment0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        MyMusicProfileLikeListSongReq myMusicProfileLikeListSongReq0;
        int v;
        if(i.c.equals(i0)) {
            v = this.getMelonArrayAdapter().getCount() + 1;
        }
        else {
            this.clearData();
            v = 1;
        }
        Params likeListSongBaseReq$Params0 = new Params();
        likeListSongBaseReq$Params0.startIndex = v;
        likeListSongBaseReq$Params0.pageSize = 100;
        likeListSongBaseReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        likeListSongBaseReq$Params0.orderBy = this.mOrderBy;
        switch(this.mCaller) {
            case 0: {
                myMusicProfileLikeListSongReq0 = new MyMusicProfileLikeListSongReq(this.getContext(), likeListSongBaseReq$Params0);
                break;
            }
            case 1: {
                myMusicProfileLikeListSongReq0 = new MyMusicPlaylistInsertLikeListSongReq(this.getContext(), likeListSongBaseReq$Params0);
                break;
            }
            case 2: {
                myMusicProfileLikeListSongReq0 = new MyMusicPlaylistUpdateLikeListSongReq(this.getContext(), likeListSongBaseReq$Params0);
                break;
            }
            case 3: {
                myMusicProfileLikeListSongReq0 = new MyMusicDjPlaylistInsertLikeListSongReq(this.getContext(), likeListSongBaseReq$Params0);
                break;
            }
            case 4: {
                myMusicProfileLikeListSongReq0 = new MyMusicDjPlaylistUpdateLikeListSongReq(this.getContext(), likeListSongBaseReq$Params0);
                break;
            }
            case 5: {
                myMusicProfileLikeListSongReq0 = new MyMusicMessageLikeListSongReq(this.getContext(), likeListSongBaseReq$Params0);
                break;
            }
            case 11: {
                myMusicProfileLikeListSongReq0 = new MyMusicGiftBoxLikeListSongReq(this.getContext(), likeListSongBaseReq$Params0);
                break;
            }
            case 12: {
                myMusicProfileLikeListSongReq0 = new NowPlayingInsertLikeListSongReq(this.getContext(), likeListSongBaseReq$Params0);
                break;
            }
            case 13: {
                myMusicProfileLikeListSongReq0 = new NowPlayingUpdateLikeListSongReq(this.getContext(), likeListSongBaseReq$Params0);
                break;
            }
            default: {
                this.performFetchCompleteOnlyViews();
                return true;
            }
        }
        RequestBuilder.newInstance(myMusicProfileLikeListSongReq0).tag("SongLikeSearchAndAddFragment").listener(new Listener() {
            public void onResponse(LikeListSongBaseRes likeListSongBaseRes0) {
                if(!SongLikeSearchAndAddFragment.this.prepareFetchComplete(likeListSongBaseRes0)) {
                    return;
                }
                SongLikeSearchAndAddFragment.this.performFetchComplete(i0, likeListSongBaseRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((LikeListSongBaseRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }
}

