package com.iloen.melon.fragments.searchandadd;

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
import com.iloen.melon.net.v4x.request.MyMusicMessageSearchMovieListReq;
import com.iloen.melon.net.v4x.request.SearchMovieListBaseReq.Params;
import com.iloen.melon.net.v4x.response.SearchMovieListRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.melon.net.res.common.MvInfoBase;
import java.util.List;
import v9.e;
import v9.h;
import v9.i;

public class MvSearchSearchAndAddFragment extends SearchAndAddSearchBaseFragment {
    class SearchAndAddMvSearchAdapter extends SearchAndAddBaseAdapter {
        private static final int VIEW_TYPE_ITEM = 3;
        private static final int VIEW_TYPE_SEARCHBAR = 1;
        private static final int VIEW_TYPE_SORTBAR = 2;

        public SearchAndAddMvSearchAdapter(Context context0, List list0, int v) {
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
            MvInfoBase mvInfoBase0 = (MvInfoBase)this.getItem(v);
            return mvInfoBase0 == null ? null : Playable.from(mvInfoBase0, mvInfoBase0.getMenuId(), null);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            switch(o00.getItemViewType()) {
                case 1: {
                    if(o00 instanceof SearchAndAddSearchbarViewHolder) {
                        ((SearchAndAddSearchbarViewHolder)o00).setKeyword(MvSearchSearchAndAddFragment.this.mKeyword);
                        return;
                    }
                    break;
                }
                case 3: {
                    if(o00 instanceof SearchAndAddMvViewHolder) {
                        ((SearchAndAddMvViewHolder)o00).bindView(((MvInfoBase)this.getItem(v1)), v, v1);
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
                    ((SearchAndAddSearchbarViewHolder)o00).setOnSearchBarListener(MvSearchSearchAndAddFragment.this.onSearchBarListener);
                    return o00;
                }
                case 2: {
                    O0 o01 = new SearchAndAddSortbarViewHolder(this.mInflater.inflate(0x7F0D085D, viewGroup0, false), MvSearchSearchAndAddFragment.this.getResources().getStringArray(0x7F03004B));  // layout:sortbar_view
                    ((SearchAndAddSortbarViewHolder)o01).setOnSortSelectionListener(new d() {
                        @Override  // a9.d
                        public void onSelected(int v) {
                            MvSearchSearchAndAddFragment mvSearchSearchAndAddFragment0 = MvSearchSearchAndAddFragment.this;
                            if(v == mvSearchSearchAndAddFragment0.mSortType) {
                                return;
                            }
                            mvSearchSearchAndAddFragment0.mSortType = v;
                            mvSearchSearchAndAddFragment0.orderBy = mvSearchSearchAndAddFragment0.convertSortTypeToOrderBy(v);
                            MvSearchSearchAndAddFragment.this.searchKeyword("onSortSelected");
                        }
                    });
                    return o01;
                }
                case 3: {
                    return new SearchAndAddMvViewHolder(this.mInflater.inflate(0x7F0D04BB, viewGroup0, false), this);  // layout:listitem_video
                }
                default: {
                    return null;
                }
            }
        }
    }

    private static final String TAG = "MvSearchSearchAndAddFragment";

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new SearchAndAddMvSearchAdapter(this, context0, null, this.mSearchViewType);
        ((SearchAndAddBaseAdapter)j00).setOnItemEventListener(this.mMvItemEventListener);
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
        return MelonContentUris.h.buildUpon().appendPath("mvSearch").appendQueryParameter("searchViewType", String.valueOf(this.mSearchViewType)).appendQueryParameter("orderBy", String.valueOf(this.orderBy)).appendQueryParameter("keyword", this.mKeyword).appendQueryParameter("caller", String.valueOf(this.mCaller)).build().toString();
    }

    public static MvSearchSearchAndAddFragment newInstance(int v, int v1, int v2) {
        if(v == -1) {
            throw new IllegalArgumentException("Invalid searchViewType - " + -1);
        }
        MvSearchSearchAndAddFragment mvSearchSearchAndAddFragment0 = new MvSearchSearchAndAddFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argSearchViewType", v);
        bundle0.putInt("argCaller", v1);
        bundle0.putInt("argMaxContentCount", v2);
        mvSearchSearchAndAddFragment0.setArguments(bundle0);
        return mvSearchSearchAndAddFragment0;
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
            Params searchMovieListBaseReq$Params0 = new Params();
            searchMovieListBaseReq$Params0.startIndex = v;
            searchMovieListBaseReq$Params0.pageSize = 25;
            searchMovieListBaseReq$Params0.orderBy = this.orderBy;
            if(this.mCaller == 6) {
                RequestBuilder.newInstance(new MyMusicMessageSearchMovieListReq(this.getContext(), this.mKeyword, searchMovieListBaseReq$Params0)).tag("MvSearchSearchAndAddFragment").listener(new Listener() {
                    public void onResponse(SearchMovieListRes searchMovieListRes0) {
                        if(!MvSearchSearchAndAddFragment.this.prepareFetchComplete(searchMovieListRes0)) {
                            return;
                        }
                        MvSearchSearchAndAddFragment.this.getAdapter().notifyItemChanged(0);
                        MvSearchSearchAndAddFragment.this.performFetchComplete(i0, searchMovieListRes0);
                    }

                    @Override  // com.android.volley.Response$Listener
                    public void onResponse(Object object0) {
                        this.onResponse(((SearchMovieListRes)object0));
                    }
                }).errorListener(this.mResponseErrorListener).request();
                return true;
            }
            this.performFetchCompleteOnlyViews();
            return true;
        }
        LogU.d("MvSearchSearchAndAddFragment", "onFetchStart : Invalid mKeyword.");
        return false;
    }
}

