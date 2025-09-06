package com.iloen.melon.fragments.searchandadd;

import a9.d;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.SearchOrderBy;
import com.iloen.melon.net.v4x.request.DjPlaylistAddSearchSongListReq;
import com.iloen.melon.net.v4x.request.DjPlaylistEditSearchSongListReq;
import com.iloen.melon.net.v4x.request.MyMusicGiftBoxSearchSongListReq;
import com.iloen.melon.net.v4x.request.MyMusicMessageSearchSongListReq;
import com.iloen.melon.net.v4x.request.MyMusicProgileEditSearchSongListReq;
import com.iloen.melon.net.v4x.request.NowPlayingInsertSearchSongListReq;
import com.iloen.melon.net.v4x.request.NowPlayingUpdateSearchSongListReq;
import com.iloen.melon.net.v4x.request.PlaylistAddSearchSongListReq;
import com.iloen.melon.net.v4x.request.PlaylistEditSearchSongListReq;
import com.iloen.melon.net.v4x.request.SearchSongListBaseReq.Params;
import com.iloen.melon.net.v4x.response.SearchSongListRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.SongInfoBase;
import java.util.List;
import v9.e;
import v9.h;
import v9.i;

public class SongSearchSearchAndAddFragment extends SearchAndAddSearchBaseFragment {
    class SearchAndAddSongSearchAdapter extends SearchAndAddBaseAdapter {
        class SortBarFilterHolder extends O0 {
            private SortingBarView sortingBarView;

            public SortBarFilterHolder(View view0) {
                super(view0);
                this.sortingBarView = (SortingBarView)view0.findViewById(0x7F0A0AB8);  // id:sort_bar
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0D6B), true);  // id:underline
            }

            public static SortingBarView a(SortBarFilterHolder songSearchSearchAndAddFragment$SearchAndAddSongSearchAdapter$SortBarFilterHolder0) {
                return songSearchSearchAndAddFragment$SearchAndAddSongSearchAdapter$SortBarFilterHolder0.sortingBarView;
            }
        }

        private static final int VIEW_TYPE_ITEM = 4;
        private static final int VIEW_TYPE_SEARCHBAR = 1;
        private static final int VIEW_TYPE_SORTBAR = 2;
        private static final int VIEW_TYPE_SORTBAR_FILTER = 3;

        public SearchAndAddSongSearchAdapter(Context context0, List list0, int v) {
            super(context0, list0, v);
            this.setListContentType(1);
            if(this.mSearchViewType != 1 && this.mSearchViewType != 2 && this.mSearchViewType != 3 && this.mSearchViewType != 4) {
                return;
            }
            this.setMarkedMode(true);
        }

        // 去混淆评级： 低(20)
        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return this.getList().isEmpty() ? 1 : 2;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            if(this.getHeaderViewItemCount() > 0) {
                if(v == this.getAvailableHeaderPosition()) {
                    return 1;
                }
                if(v == this.getAvailableHeaderPosition() + 1) {
                    return SongSearchSearchAndAddFragment.this.mCaller == 3 || SongSearchSearchAndAddFragment.this.mCaller == 4 || SongSearchSearchAndAddFragment.this.mCaller == 1 || SongSearchSearchAndAddFragment.this.mCaller == 2 ? 3 : 2;
                }
            }
            return 4;
        }

        @Override  // com.iloen.melon.fragments.searchandadd.SearchAndAddBaseAdapter
        public Sharable getSharable(int v) {
            SongInfoBase songInfoBase0 = (SongInfoBase)this.getItem(v);
            return songInfoBase0 != null ? Playable.from(songInfoBase0, songInfoBase0.getMenuId(), null) : null;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            switch(o00.getItemViewType()) {
                case 1: {
                    if(o00 instanceof SearchAndAddSearchbarViewHolder) {
                        ((SearchAndAddSearchbarViewHolder)o00).setKeyword(SongSearchSearchAndAddFragment.this.mKeyword);
                        return;
                    }
                    break;
                }
                case 3: {
                    boolean z = TextUtils.isEmpty(SongSearchSearchAndAddFragment.this.mKeyword);
                    ViewUtils.showWhen(((SortBarFilterHolder)o00).itemView, !z);
                    SortBarFilterHolder.a(((SortBarFilterHolder)o00)).setSortBarStyle(2);
                    SortBarFilterHolder.a(((SortBarFilterHolder)o00)).setItems(SongSearchSearchAndAddFragment.this.getResources().getStringArray(0x7F03004B));  // array:sortingbar_search
                    SortBarFilterHolder.a(((SortBarFilterHolder)o00)).setSelection(SongSearchSearchAndAddFragment.this.mSortType);
                    SortBarFilterHolder.a(((SortBarFilterHolder)o00)).setOnSortSelectionListener(new d() {
                        @Override  // a9.d
                        public void onSelected(int v) {
                            SongSearchSearchAndAddFragment songSearchSearchAndAddFragment0 = SongSearchSearchAndAddFragment.this;
                            if(songSearchSearchAndAddFragment0.mSortType == v) {
                                return;
                            }
                            songSearchSearchAndAddFragment0.mSortType = v;
                            songSearchSearchAndAddFragment0.orderBy = songSearchSearchAndAddFragment0.getOrderBy(v);
                            SongSearchSearchAndAddFragment.this.searchKeyword("onSortSelected");
                        }
                    });
                    return;
                }
                case 4: {
                    if(o00 instanceof SearchAndAddSongViewHolder) {
                        ((SearchAndAddSongViewHolder)o00).bindView(((SongInfoBase)this.getItem(v1)), v, v1);
                        return;
                    }
                    break;
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            switch(v) {
                case 1: {
                    O0 o00 = new SearchAndAddSearchbarViewHolder(this.mInflater.inflate(0x7F0D080A, viewGroup0, false));  // layout:search_bar_view_layout
                    ((SearchAndAddSearchbarViewHolder)o00).setOnSearchBarListener(SongSearchSearchAndAddFragment.this.onSearchBarListener);
                    return o00;
                }
                case 2: {
                    O0 o01 = new SearchAndAddSortbarViewHolder(this.mInflater.inflate(0x7F0D085D, viewGroup0, false), SongSearchSearchAndAddFragment.this.getResources().getStringArray(0x7F03004B));  // layout:sortbar_view
                    ((SearchAndAddSortbarViewHolder)o01).setOnSortSelectionListener(new d() {
                        @Override  // a9.d
                        public void onSelected(int v) {
                            SongSearchSearchAndAddFragment songSearchSearchAndAddFragment0 = SongSearchSearchAndAddFragment.this;
                            if(v == songSearchSearchAndAddFragment0.mSortType) {
                                return;
                            }
                            songSearchSearchAndAddFragment0.mSortType = v;
                            songSearchSearchAndAddFragment0.orderBy = songSearchSearchAndAddFragment0.convertSortTypeToOrderBy(v);
                            SongSearchSearchAndAddFragment.this.searchKeyword("onSortSelected");
                        }
                    });
                    return o01;
                }
                case 3: {
                    return new SortBarFilterHolder(this, this.mInflater.inflate(0x7F0D085D, viewGroup0, false));  // layout:sortbar_view
                }
                case 4: {
                    return new SearchAndAddSongViewHolder(this.mInflater.inflate(0x7F0D04A8, viewGroup0, false), this);  // layout:listitem_song
                }
                default: {
                    return null;
                }
            }
        }
    }

    private static final String TAG = "SongSearchSearchAndAddFragment";

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new SearchAndAddSongSearchAdapter(this, context0, null, this.mSearchViewType);
        ((SearchAndAddBaseAdapter)j00).setOnItemEventListener(this.mSongItemEventListener);
        ((SearchAndAddBaseAdapter)j00).setOnItemViewClickListener(this.mOnItemViewClickListener);
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.f = this.getString(0x7F1301DB);  // string:cmt_attachment_search_empty_text "검색 후 첨부할 콘텐츠를 선택하세요."
        ((p)j00).setEmptyViewInfo(e0);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.h.buildUpon().appendPath("songSearch").appendQueryParameter("searchViewType", String.valueOf(this.mSearchViewType)).appendQueryParameter("orderBy", String.valueOf(this.orderBy)).appendQueryParameter("keyword", this.mKeyword).appendQueryParameter("caller", String.valueOf(this.mCaller)).build().toString();
    }

    private int getOrderBy(int v) {
        if(this.mCaller == 3 || (this.mCaller == 1 || this.mCaller == 2 || this.mCaller == 4)) {
            switch(v) {
                case 0: {
                    return SearchOrderBy.ACCURACY;
                }
                case 1: {
                    return SearchOrderBy.POPULARITY;
                }
                case 2: {
                    return SearchOrderBy.RECENTLY;
                }
                default: {
                    return SearchOrderBy.ACCURACY;
                }
            }
        }
        return SearchOrderBy.ACCURACY;
    }

    public static SongSearchSearchAndAddFragment newInstance(int v, int v1, int v2) {
        LogU.d("SongSearchSearchAndAddFragment", "searchViewType : " + v);
        LogU.d("SongSearchSearchAndAddFragment", "caller : " + v1);
        if(v == -1) {
            throw new IllegalArgumentException("Invalid searchViewType - " + -1);
        }
        SongSearchSearchAndAddFragment songSearchSearchAndAddFragment0 = new SongSearchSearchAndAddFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argSearchViewType", v);
        bundle0.putInt("argCaller", v1);
        bundle0.putInt("argMaxContentCount", v2);
        songSearchSearchAndAddFragment0.setArguments(bundle0);
        return songSearchSearchAndAddFragment0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        MyMusicProgileEditSearchSongListReq myMusicProgileEditSearchSongListReq0;
        if(this.mKeyword != null && !this.mKeyword.trim().equals("")) {
            InputMethodUtils.hideInputMethod(this.getContext(), this.getRecyclerView());
            i i1 = i.b;
            if(i1.equals(i0)) {
                this.clearData();
            }
            Params searchSongListBaseReq$Params0 = new Params();
            searchSongListBaseReq$Params0.startIndex = i1.equals(i0) ? 1 : this.getMelonArrayAdapter().getCount() + 1;
            searchSongListBaseReq$Params0.pageSize = 25;
            searchSongListBaseReq$Params0.orderBy = this.orderBy;
            switch(this.mCaller) {
                case 0: {
                    myMusicProgileEditSearchSongListReq0 = new MyMusicProgileEditSearchSongListReq(this.getContext(), this.mKeyword, searchSongListBaseReq$Params0);
                    break;
                }
                case 1: {
                    myMusicProgileEditSearchSongListReq0 = new PlaylistAddSearchSongListReq(this.getContext(), this.mKeyword, searchSongListBaseReq$Params0);
                    break;
                }
                case 2: {
                    myMusicProgileEditSearchSongListReq0 = new PlaylistEditSearchSongListReq(this.getContext(), this.mKeyword, searchSongListBaseReq$Params0);
                    break;
                }
                case 3: {
                    myMusicProgileEditSearchSongListReq0 = new DjPlaylistAddSearchSongListReq(this.getContext(), this.mKeyword, searchSongListBaseReq$Params0);
                    break;
                }
                case 4: {
                    myMusicProgileEditSearchSongListReq0 = new DjPlaylistEditSearchSongListReq(this.getContext(), this.mKeyword, searchSongListBaseReq$Params0);
                    break;
                }
                case 5: {
                    myMusicProgileEditSearchSongListReq0 = new MyMusicMessageSearchSongListReq(this.getContext(), this.mKeyword, searchSongListBaseReq$Params0);
                    break;
                }
                case 11: {
                    myMusicProgileEditSearchSongListReq0 = new MyMusicGiftBoxSearchSongListReq(this.getContext(), this.mKeyword, searchSongListBaseReq$Params0);
                    break;
                }
                case 12: {
                    myMusicProgileEditSearchSongListReq0 = new NowPlayingInsertSearchSongListReq(this.getContext(), this.mKeyword, searchSongListBaseReq$Params0);
                    break;
                }
                case 13: {
                    myMusicProgileEditSearchSongListReq0 = new NowPlayingUpdateSearchSongListReq(this.getContext(), this.mKeyword, searchSongListBaseReq$Params0);
                    break;
                }
                default: {
                    this.performFetchCompleteOnlyViews();
                    return true;
                }
            }
            RequestBuilder.newInstance(myMusicProgileEditSearchSongListReq0).tag("SongSearchSearchAndAddFragment").listener(new Listener() {
                public void onResponse(SearchSongListRes searchSongListRes0) {
                    if(!SongSearchSearchAndAddFragment.this.prepareFetchComplete(searchSongListRes0)) {
                        return;
                    }
                    SongSearchSearchAndAddFragment.this.getAdapter().notifyItemChanged(0);
                    SongSearchSearchAndAddFragment.this.performFetchComplete(i0, searchSongListRes0);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((SearchSongListRes)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        LogU.d("SongSearchSearchAndAddFragment", "onFetchStart : Invalid mKeyword.");
        return false;
    }

    @Override  // com.iloen.melon.fragments.searchandadd.SearchAndAddBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
    }
}

