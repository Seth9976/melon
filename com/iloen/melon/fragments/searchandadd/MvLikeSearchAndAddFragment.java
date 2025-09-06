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
import com.iloen.melon.net.v4x.request.LikeListMvBaseReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicMessageLikeListMvReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeListMvRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.model.Sharable;
import com.melon.net.res.common.MvInfoBase;
import e1.u;
import java.util.List;
import v9.h;
import v9.i;
import va.e0;
import va.o;

public class MvLikeSearchAndAddFragment extends SearchAndAddBaseFragment {
    class SearchAndAddMvLikeAdapter extends SearchAndAddBaseAdapter {
        private static final int VIEW_TYPE_ITEM = 2;
        private static final int VIEW_TYPE_SORTBAR = 1;

        public SearchAndAddMvLikeAdapter(Context context0, List list0, int v) {
            super(context0, list0, v);
            this.setListContentType(3);
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
            MvInfoBase mvInfoBase0 = (MvInfoBase)this.getItem(v);
            return mvInfoBase0 == null ? null : Playable.from(mvInfoBase0, mvInfoBase0.getMenuId(), null);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(o00.getItemViewType() == 2 && o00 instanceof SearchAndAddMvViewHolder) {
                ((SearchAndAddMvViewHolder)o00).bindView(((MvInfoBase)this.getItem(v1)), v, v1);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            switch(v) {
                case 1: {
                    O0 o00 = new SearchAndAddSortbarViewHolder(this.mInflater.inflate(0x7F0D085D, viewGroup0, false), MvLikeSearchAndAddFragment.this.getResources().getStringArray(0x7F03003B));  // layout:sortbar_view
                    ((SearchAndAddSortbarViewHolder)o00).setOnSortSelectionListener(new d() {
                        @Override  // a9.d
                        public void onSelected(int v) {
                            MvLikeSearchAndAddFragment mvLikeSearchAndAddFragment0 = MvLikeSearchAndAddFragment.this;
                            if(v == mvLikeSearchAndAddFragment0.mSortType) {
                                return;
                            }
                            mvLikeSearchAndAddFragment0.mSortType = v;
                            if(v == 0) {
                                mvLikeSearchAndAddFragment0.mOrderBy = "NEW";
                            }
                            else {
                                switch(v) {
                                    case 1: {
                                        mvLikeSearchAndAddFragment0.mOrderBy = "ALPHABET";
                                        break;
                                    }
                                    case 2: {
                                        mvLikeSearchAndAddFragment0.mOrderBy = "ARTIST";
                                    }
                                }
                            }
                            MvLikeSearchAndAddFragment.this.startFetch("onSortSelected");
                        }
                    });
                    return o00;
                }
                case 2: {
                    return new SearchAndAddMvViewHolder(this.mInflater.inflate(0x7F0D04BB, viewGroup0, false), this);  // layout:listitem_video
                }
                default: {
                    return null;
                }
            }
        }
    }

    private static final int PAGE_SIZE = 100;
    private static final String TAG = "MvLikeSearchAndAddFragment";
    private String mOrderBy;

    public MvLikeSearchAndAddFragment() {
        this.mOrderBy = "NEW";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new SearchAndAddMvLikeAdapter(this, context0, null, this.mSearchViewType);
        ((SearchAndAddBaseAdapter)j00).setOnItemEventListener(this.mMvItemEventListener);
        ((SearchAndAddBaseAdapter)j00).setOnItemViewClickListener(this.mOnItemViewClickListener);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.h.buildUpon().appendPath("mvLike").appendQueryParameter("searchViewType", String.valueOf(this.mSearchViewType)).appendQueryParameter("orderBy", String.valueOf(this.mOrderBy)).appendQueryParameter("caller", String.valueOf(this.mCaller)).build().toString();
    }

    public static MvLikeSearchAndAddFragment newInstance(int v, int v1, int v2) {
        if(v == -1) {
            throw new IllegalArgumentException("Invalid searchViewType - " + -1);
        }
        MvLikeSearchAndAddFragment mvLikeSearchAndAddFragment0 = new MvLikeSearchAndAddFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argSearchViewType", v);
        bundle0.putInt("argCaller", v1);
        bundle0.putInt("argMaxContentCount", v2);
        mvLikeSearchAndAddFragment0.setArguments(bundle0);
        return mvLikeSearchAndAddFragment0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        int v;
        if(i.c.equals(i0)) {
            v = this.getMelonArrayAdapter().getCount() + 1;
        }
        else {
            this.clearData();
            v = 1;
        }
        Params likeListMvBaseReq$Params0 = new Params();
        likeListMvBaseReq$Params0.startIndex = v;
        likeListMvBaseReq$Params0.pageSize = 100;
        likeListMvBaseReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        likeListMvBaseReq$Params0.orderBy = this.mOrderBy;
        if(this.mCaller == 6) {
            RequestBuilder.newInstance(new MyMusicMessageLikeListMvReq(this.getContext(), likeListMvBaseReq$Params0)).tag("MvLikeSearchAndAddFragment").listener(new Listener() {
                public void onResponse(MyMusicLikeListMvRes myMusicLikeListMvRes0) {
                    if(!MvLikeSearchAndAddFragment.this.prepareFetchComplete(myMusicLikeListMvRes0)) {
                        return;
                    }
                    MvLikeSearchAndAddFragment.this.performFetchComplete(i0, myMusicLikeListMvRes0);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((MyMusicLikeListMvRes)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        this.performFetchCompleteOnlyViews();
        return true;
    }
}

