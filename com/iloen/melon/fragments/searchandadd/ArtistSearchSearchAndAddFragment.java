package com.iloen.melon.fragments.searchandadd;

import H8.q;
import a9.d;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.SearchOrderBy;
import com.iloen.melon.net.v4x.request.MyMusicMessageSearchArtistListReq;
import com.iloen.melon.net.v4x.request.SearchArtistListBaseReq.Params;
import com.iloen.melon.net.v4x.response.SearchArtistListRes;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableArtist;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.melon.net.res.common.ArtistInfoBase;
import java.util.List;
import v9.e;
import v9.h;
import v9.i;

public class ArtistSearchSearchAndAddFragment extends SearchAndAddSearchBaseFragment {
    class SearchAndAddArtistSearchAdapter extends SearchAndAddBaseAdapter {
        private static final int VIEW_TYPE_ITEM = 3;
        private static final int VIEW_TYPE_SEARCHBAR = 1;
        private static final int VIEW_TYPE_SORTBAR = 2;

        public SearchAndAddArtistSearchAdapter(Context context0, List list0, int v) {
            super(context0, list0, v);
            this.setListContentType(3);
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
                return v == this.getAvailableHeaderPosition() + 1 ? 2 : 3;
            }
            return 3;
        }

        @Override  // com.iloen.melon.fragments.searchandadd.SearchAndAddBaseAdapter
        public Sharable getSharable(int v) {
            ArtistInfoBase artistInfoBase0 = (ArtistInfoBase)this.getItem(v);
            if(artistInfoBase0 == null) {
                return null;
            }
            q q0 = new q();  // 初始化器: Ljava/lang/Object;-><init>()V
            q0.a = artistInfoBase0.getArtistId();
            return new SharableArtist(q0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            switch(o00.getItemViewType()) {
                case 1: {
                    if(o00 instanceof SearchAndAddSearchbarViewHolder) {
                        ((SearchAndAddSearchbarViewHolder)o00).setKeyword(ArtistSearchSearchAndAddFragment.this.mKeyword);
                        return;
                    }
                    break;
                }
                case 3: {
                    if(o00 instanceof SearchAndAddArtistViewHolder) {
                        ((SearchAndAddArtistViewHolder)o00).bindView(((ArtistInfoBase)this.getItem(v1)), v, v1);
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
                    ((SearchAndAddSearchbarViewHolder)o00).setOnSearchBarListener(ArtistSearchSearchAndAddFragment.this.onSearchBarListener);
                    return o00;
                }
                case 2: {
                    O0 o01 = new SearchAndAddSortbarViewHolder(this.mInflater.inflate(0x7F0D085D, viewGroup0, false), ArtistSearchSearchAndAddFragment.this.getResources().getStringArray(0x7F030033));  // layout:sortbar_view
                    ((SearchAndAddSortbarViewHolder)o01).setOnSortSelectionListener(new d() {
                        @Override  // a9.d
                        public void onSelected(int v) {
                            ArtistSearchSearchAndAddFragment artistSearchSearchAndAddFragment0 = ArtistSearchSearchAndAddFragment.this;
                            if(v == artistSearchSearchAndAddFragment0.mSortType) {
                                return;
                            }
                            artistSearchSearchAndAddFragment0.mSortType = v;
                            artistSearchSearchAndAddFragment0.orderBy = artistSearchSearchAndAddFragment0.convertSortTypeToOrderBy(v);
                            ArtistSearchSearchAndAddFragment.this.searchKeyword("onSortSelected");
                        }
                    });
                    return o01;
                }
                case 3: {
                    return new SearchAndAddArtistViewHolder(this.mInflater.inflate(0x7F0D0456, viewGroup0, false), this);  // layout:listitem_artist
                }
                default: {
                    return null;
                }
            }
        }
    }

    private static final String TAG = "ArtistSearchSearchAndAddFragment";

    @Override  // com.iloen.melon.fragments.searchandadd.SearchAndAddSearchBaseFragment
    public int convertSortTypeToOrderBy(int v) {
        if(v == 0) {
            return SearchOrderBy.ACCURACY;
        }
        switch(v) {
            case 1: {
                return SearchOrderBy.POPULARITY;
            }
            case 2: {
                return SearchOrderBy.ALPHABETICAL;
            }
            default: {
                return SearchOrderBy.ACCURACY;
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new SearchAndAddArtistSearchAdapter(this, context0, null, this.mSearchViewType);
        ((SearchAndAddBaseAdapter)j00).setOnItemEventListener(this.mContentItemEventListener);
        ((SearchAndAddBaseAdapter)j00).setOnItemViewClickListener(this.mOnItemViewClickListener);
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.f = this.getString(0x7F1301DB);  // string:cmt_attachment_search_empty_text "검색 후 첨부할 콘텐츠를 선택하세요."
        ((p)j00).setEmptyViewResId(0x7F0D0023);  // layout:adapter_empty_view_search
        ((p)j00).setEmptyViewInfo(e0);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.h.buildUpon().appendPath("artistSearch").appendQueryParameter("searchViewType", String.valueOf(this.mSearchViewType)).appendQueryParameter("orderBy", String.valueOf(this.orderBy)).appendQueryParameter("keyword", this.mKeyword).appendQueryParameter("caller", String.valueOf(this.mCaller)).build().toString();
    }

    public static ArtistSearchSearchAndAddFragment newInstance(int v, int v1, int v2) {
        if(v == -1) {
            throw new IllegalArgumentException("Invalid searchViewType - " + -1);
        }
        ArtistSearchSearchAndAddFragment artistSearchSearchAndAddFragment0 = new ArtistSearchSearchAndAddFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argSearchViewType", v);
        bundle0.putInt("argCaller", v1);
        bundle0.putInt("argMaxContentCount", v2);
        artistSearchSearchAndAddFragment0.setArguments(bundle0);
        return artistSearchSearchAndAddFragment0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        int v;
        if(this.mKeyword != null && !this.mKeyword.trim().equals("")) {
            InputMethodUtils.hideInputMethod(this.getContext(), this.getRecyclerView());
            if(i.c.equals(i0)) {
                v = this.getMelonArrayAdapter().getCount() + 1;
            }
            else {
                this.clearData();
                v = 1;
            }
            Params searchArtistListBaseReq$Params0 = new Params();
            searchArtistListBaseReq$Params0.startIndex = v;
            searchArtistListBaseReq$Params0.pageSize = 25;
            searchArtistListBaseReq$Params0.orderBy = this.orderBy;
            if(this.mCaller == 8) {
                RequestBuilder.newInstance(new MyMusicMessageSearchArtistListReq(this.getContext(), this.mKeyword, searchArtistListBaseReq$Params0)).tag("ArtistSearchSearchAndAddFragment").listener(new Listener() {
                    public void onResponse(SearchArtistListRes searchArtistListRes0) {
                        if(!ArtistSearchSearchAndAddFragment.this.prepareFetchComplete(searchArtistListRes0)) {
                            return;
                        }
                        ArtistSearchSearchAndAddFragment.this.getAdapter().notifyItemChanged(0);
                        ArtistSearchSearchAndAddFragment.this.performFetchComplete(i0, searchArtistListRes0);
                    }

                    @Override  // com.android.volley.Response$Listener
                    public void onResponse(Object object0) {
                        this.onResponse(((SearchArtistListRes)object0));
                    }
                }).errorListener(this.mResponseErrorListener).request();
                return true;
            }
            this.performFetchCompleteOnlyViews();
            return true;
        }
        LogU.d("ArtistSearchSearchAndAddFragment", "onFetchStart : Invalid mKeyword.");
        return false;
    }
}

