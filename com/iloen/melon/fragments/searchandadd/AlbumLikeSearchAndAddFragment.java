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
import com.iloen.melon.net.v4x.request.LikeListAlbumBaseReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicMessageLikeListAlbumReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeListAlbumRes;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableAlbum;
import com.iloen.melon.sns.model.a;
import com.melon.net.res.common.AlbumInfoBase;
import e1.u;
import java.util.List;
import v9.h;
import v9.i;
import va.e0;
import va.o;

public class AlbumLikeSearchAndAddFragment extends SearchAndAddBaseFragment {
    class SearchAndAddAlbumLikeAdapter extends SearchAndAddBaseAdapter {
        private static final int VIEW_TYPE_ITEM = 2;
        private static final int VIEW_TYPE_SORTBAR = 1;

        public SearchAndAddAlbumLikeAdapter(Context context0, List list0, int v) {
            super(context0, list0, v);
            this.setListContentType(2);
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
            AlbumInfoBase albumInfoBase0 = (AlbumInfoBase)this.getItem(v);
            if(albumInfoBase0 == null) {
                return null;
            }
            a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
            a0.b = albumInfoBase0.albumId;
            return new SharableAlbum(a0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(o00.getItemViewType() == 2 && o00 instanceof SearchAndAddAlbumViewHolder) {
                ((SearchAndAddAlbumViewHolder)o00).bindView(((AlbumInfoBase)this.getItem(v1)), v, v1);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            switch(v) {
                case 1: {
                    O0 o00 = new SearchAndAddSortbarViewHolder(this.mInflater.inflate(0x7F0D085D, viewGroup0, false), AlbumLikeSearchAndAddFragment.this.getResources().getStringArray(0x7F03003B));  // layout:sortbar_view
                    ((SearchAndAddSortbarViewHolder)o00).setOnSortSelectionListener(new d() {
                        @Override  // a9.d
                        public void onSelected(int v) {
                            AlbumLikeSearchAndAddFragment albumLikeSearchAndAddFragment0 = AlbumLikeSearchAndAddFragment.this;
                            if(v == albumLikeSearchAndAddFragment0.mSortType) {
                                return;
                            }
                            albumLikeSearchAndAddFragment0.mSortType = v;
                            if(v == 0) {
                                albumLikeSearchAndAddFragment0.mOrderBy = "NEW";
                            }
                            else {
                                switch(v) {
                                    case 1: {
                                        albumLikeSearchAndAddFragment0.mOrderBy = "ALPHABET";
                                        break;
                                    }
                                    case 2: {
                                        albumLikeSearchAndAddFragment0.mOrderBy = "ARTIST";
                                    }
                                }
                            }
                            AlbumLikeSearchAndAddFragment.this.startFetch("onSortSelected");
                        }
                    });
                    return o00;
                }
                case 2: {
                    return new SearchAndAddAlbumViewHolder(this.mInflater.inflate(0x7F0D0455, viewGroup0, false), this);  // layout:listitem_album
                }
                default: {
                    return null;
                }
            }
        }
    }

    private static final int PAGE_SIZE = 100;
    private static final String TAG = "AlbumLikeSearchAndAddFragment";
    private String mOrderBy;

    public AlbumLikeSearchAndAddFragment() {
        this.mOrderBy = "NEW";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new SearchAndAddAlbumLikeAdapter(this, context0, null, this.mSearchViewType);
        ((SearchAndAddBaseAdapter)j00).setOnItemEventListener(this.mContentItemEventListener);
        ((SearchAndAddBaseAdapter)j00).setOnItemViewClickListener(this.mOnItemViewClickListener);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.h.buildUpon().appendPath("albumLike").appendQueryParameter("searchViewType", String.valueOf(this.mSearchViewType)).appendQueryParameter("orderBy", this.mOrderBy).appendQueryParameter("caller", String.valueOf(this.mCaller)).build().toString();
    }

    public static AlbumLikeSearchAndAddFragment newInstance(int v, int v1, int v2) {
        if(v == -1) {
            throw new IllegalArgumentException("Invalid searchViewType - " + -1);
        }
        AlbumLikeSearchAndAddFragment albumLikeSearchAndAddFragment0 = new AlbumLikeSearchAndAddFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argSearchViewType", v);
        bundle0.putInt("argCaller", v1);
        bundle0.putInt("argMaxContentCount", v2);
        albumLikeSearchAndAddFragment0.setArguments(bundle0);
        return albumLikeSearchAndAddFragment0;
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
        Params likeListAlbumBaseReq$Params0 = new Params();
        likeListAlbumBaseReq$Params0.startIndex = v;
        likeListAlbumBaseReq$Params0.pageSize = 100;
        likeListAlbumBaseReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        likeListAlbumBaseReq$Params0.orderBy = this.mOrderBy;
        if(this.mCaller == 7) {
            RequestBuilder.newInstance(new MyMusicMessageLikeListAlbumReq(this.getContext(), likeListAlbumBaseReq$Params0)).tag("AlbumLikeSearchAndAddFragment").listener(new Listener() {
                public void onResponse(MyMusicLikeListAlbumRes myMusicLikeListAlbumRes0) {
                    if(!AlbumLikeSearchAndAddFragment.this.prepareFetchComplete(myMusicLikeListAlbumRes0)) {
                        return;
                    }
                    AlbumLikeSearchAndAddFragment.this.performFetchComplete(i0, myMusicLikeListAlbumRes0);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((MyMusicLikeListAlbumRes)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        this.performFetchCompleteOnlyViews();
        return true;
    }
}

