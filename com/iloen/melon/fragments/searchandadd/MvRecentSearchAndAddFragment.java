package com.iloen.melon.fragments.searchandadd;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MyMusicMessageRecentListMvRecntReq;
import com.iloen.melon.net.v4x.request.RecentListMvRecntBaseReq.Params;
import com.iloen.melon.net.v4x.response.MyMusicRecentListMvRecntRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.model.Sharable;
import com.melon.net.res.common.MvInfoBase;
import e1.u;
import java.util.List;
import v9.h;
import v9.i;
import va.e0;
import va.o;

public class MvRecentSearchAndAddFragment extends SearchAndAddBaseFragment {
    class SearchAndAddMvRecentAdapter extends SearchAndAddBaseAdapter {
        private static final int VIEW_TYPE_ITEM = 1;

        public SearchAndAddMvRecentAdapter(Context context0, List list0, int v) {
            super(context0, list0, v);
            this.setListContentType(3);
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
            MvInfoBase mvInfoBase0 = (MvInfoBase)this.getItem(v);
            return mvInfoBase0 == null ? null : Playable.from(mvInfoBase0, mvInfoBase0.getMenuId(), null);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(o00.getItemViewType() == 1 && o00 instanceof SearchAndAddMvViewHolder) {
                ((SearchAndAddMvViewHolder)o00).bindView(((MvInfoBase)this.getItem(v1)), v, v1);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return v != 1 ? null : new SearchAndAddMvViewHolder(this.mInflater.inflate(0x7F0D04BB, viewGroup0, false), this);  // layout:listitem_video
        }
    }

    private static final String TAG = "MvRecentSearchAndAddFragment";

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new SearchAndAddMvRecentAdapter(this, context0, null, this.mSearchViewType);
        ((SearchAndAddBaseAdapter)j00).setOnItemEventListener(this.mMvItemEventListener);
        ((SearchAndAddBaseAdapter)j00).setOnItemViewClickListener(this.mOnItemViewClickListener);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.h.buildUpon().appendPath("mvRecent").appendQueryParameter("searchViewType", String.valueOf(this.mSearchViewType)).appendQueryParameter("caller", String.valueOf(this.mCaller)).build().toString();
    }

    public static MvRecentSearchAndAddFragment newInstance(int v, int v1, int v2) {
        if(v == -1) {
            throw new IllegalArgumentException("Invalid searchViewType - " + -1);
        }
        MvRecentSearchAndAddFragment mvRecentSearchAndAddFragment0 = new MvRecentSearchAndAddFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argSearchViewType", v);
        bundle0.putInt("argCaller", v1);
        bundle0.putInt("argMaxContentCount", v2);
        mvRecentSearchAndAddFragment0.setArguments(bundle0);
        return mvRecentSearchAndAddFragment0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        if(i.b.equals(i0)) {
            this.clearData();
        }
        Params recentListMvRecntBaseReq$Params0 = new Params();
        recentListMvRecntBaseReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        if(this.mCaller == 6) {
            RequestBuilder.newInstance(new MyMusicMessageRecentListMvRecntReq(this.getContext(), recentListMvRecntBaseReq$Params0)).tag("MvRecentSearchAndAddFragment").listener(new Listener() {
                public void onResponse(MyMusicRecentListMvRecntRes myMusicRecentListMvRecntRes0) {
                    if(!MvRecentSearchAndAddFragment.this.prepareFetchComplete(myMusicRecentListMvRecntRes0)) {
                        return;
                    }
                    MvRecentSearchAndAddFragment.this.performFetchComplete(i0, myMusicRecentListMvRecntRes0);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((MyMusicRecentListMvRecntRes)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        this.performFetchCompleteOnlyViews();
        return true;
    }
}

