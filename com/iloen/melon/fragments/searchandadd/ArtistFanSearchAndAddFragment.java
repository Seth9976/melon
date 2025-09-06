package com.iloen.melon.fragments.searchandadd;

import H8.q;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.ArtistFanListBaseReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicMessageArtistFanListReq;
import com.iloen.melon.net.v4x.response.MyMusicArtistFanListRes;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableArtist;
import com.melon.net.res.common.ArtistInfoBase;
import e1.u;
import java.util.List;
import v9.h;
import v9.i;
import va.e0;
import va.o;

public class ArtistFanSearchAndAddFragment extends SearchAndAddBaseFragment {
    class SearchAndAddArtistFanAdapter extends SearchAndAddBaseAdapter {
        private static final int VIEW_TYPE_ITEM = 1;

        public SearchAndAddArtistFanAdapter(Context context0, List list0, int v) {
            super(context0, list0, v);
            this.setListContentType(3);
            this.setMarkedMode(true);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 1;
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
            if(o00.getItemViewType() == 1 && o00 instanceof SearchAndAddArtistViewHolder) {
                ((SearchAndAddArtistViewHolder)o00).bindView(((ArtistInfoBase)this.getItem(v1)), v, v1);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return v != 1 ? null : new SearchAndAddArtistViewHolder(this.mInflater.inflate(0x7F0D0456, viewGroup0, false), this);  // layout:listitem_artist
        }
    }

    private static final int PAGE_SIZE = 100;
    private static final String TAG = "ArtistFanSearchAndAddFragment";
    private String mOrderBy;

    public ArtistFanSearchAndAddFragment() {
        this.mOrderBy = "ALPHABET";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new SearchAndAddArtistFanAdapter(this, context0, null, this.mSearchViewType);
        ((SearchAndAddBaseAdapter)j00).setOnItemEventListener(this.mContentItemEventListener);
        ((SearchAndAddBaseAdapter)j00).setOnItemViewClickListener(this.mOnItemViewClickListener);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.h.buildUpon().appendPath("artistFan").appendQueryParameter("searchViewType", String.valueOf(this.mSearchViewType)).appendQueryParameter("orderBy", String.valueOf(this.mOrderBy)).appendQueryParameter("caller", String.valueOf(this.mCaller)).build().toString();
    }

    public static ArtistFanSearchAndAddFragment newInstance(int v, int v1, int v2) {
        if(v == -1) {
            throw new IllegalArgumentException("Invalid searchViewType - " + -1);
        }
        ArtistFanSearchAndAddFragment artistFanSearchAndAddFragment0 = new ArtistFanSearchAndAddFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argSearchViewType", v);
        bundle0.putInt("argCaller", v1);
        bundle0.putInt("argMaxContentCount", v2);
        artistFanSearchAndAddFragment0.setArguments(bundle0);
        return artistFanSearchAndAddFragment0;
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
        Params artistFanListBaseReq$Params0 = new Params();
        artistFanListBaseReq$Params0.startIndex = v;
        artistFanListBaseReq$Params0.pageSize = 100;
        artistFanListBaseReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        artistFanListBaseReq$Params0.orderBy = this.mOrderBy;
        if(this.mCaller == 8) {
            RequestBuilder.newInstance(new MyMusicMessageArtistFanListReq(this.getContext(), artistFanListBaseReq$Params0)).tag("ArtistFanSearchAndAddFragment").listener(new Listener() {
                public void onResponse(MyMusicArtistFanListRes myMusicArtistFanListRes0) {
                    if(!ArtistFanSearchAndAddFragment.this.prepareFetchComplete(myMusicArtistFanListRes0)) {
                        return;
                    }
                    ArtistFanSearchAndAddFragment.this.performFetchComplete(i0, myMusicArtistFanListRes0);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((MyMusicArtistFanListRes)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        this.performFetchCompleteOnlyViews();
        return true;
    }
}

