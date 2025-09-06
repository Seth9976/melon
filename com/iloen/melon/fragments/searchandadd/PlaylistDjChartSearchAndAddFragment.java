package com.iloen.melon.fragments.searchandadd;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.bumptech.glide.Glide;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v4x.request.DjPopularListCateReq;
import com.iloen.melon.net.v4x.request.MyMusicMessageDjPopularListPlylstReq;
import com.iloen.melon.net.v4x.response.DjPopularListCateRes;
import com.iloen.melon.net.v4x.response.DjPopularListPlylstRes;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableDJCollection;
import com.iloen.melon.sns.model.c;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.DjPlaylistNewHolderImpl;
import java.util.ArrayList;
import java.util.List;
import v9.h;
import v9.i;

public class PlaylistDjChartSearchAndAddFragment extends SearchAndAddBaseFragment {
    class SearchAndAddPlaylistDjChartAdapter extends SearchAndAddBaseAdapter {
        private static final int VIEW_TYPE_FILTER = 1;
        private static final int VIEW_TYPE_ITEM = 2;
        private ArrayList cateList;

        public SearchAndAddPlaylistDjChartAdapter(Context context0, List list0, int v) {
            super(context0, list0, v);
            this.cateList = null;
            this.setListContentType(4);
            this.setMarkedMode(true);
        }

        public static ArrayList a(SearchAndAddPlaylistDjChartAdapter playlistDjChartSearchAndAddFragment$SearchAndAddPlaylistDjChartAdapter0) {
            return playlistDjChartSearchAndAddFragment$SearchAndAddPlaylistDjChartAdapter0.getCateList();
        }

        public void addCateList(ArrayList arrayList0) {
            this.cateList = arrayList0;
        }

        public void clearCateList() {
            this.cateList = null;
        }

        private ArrayList getCateList() {
            return this.cateList == null || this.cateList.size() <= 0 ? null : this.cateList;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return v == this.getAvailableHeaderPosition() ? 1 : 2;
        }

        @Override  // com.iloen.melon.fragments.searchandadd.SearchAndAddBaseAdapter
        public Sharable getSharable(int v) {
            ArtistPlayListInfoBase artistPlayListInfoBase0 = (ArtistPlayListInfoBase)this.getItem(v);
            if(artistPlayListInfoBase0 == null) {
                return null;
            }
            c c0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
            c0.a = artistPlayListInfoBase0.plylstseq;
            c0.h = artistPlayListInfoBase0.openyn;
            return new SharableDJCollection(c0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            switch(o00.getItemViewType()) {
                case 1: {
                    if(o00 instanceof SearchAndAddFilterViewHolder) {
                        ((SearchAndAddFilterViewHolder)o00).setFilterItems(this.cateList);
                        return;
                    }
                    break;
                }
                case 2: {
                    DjPlaylistNewHolderImpl djPlaylistNewHolderImpl0 = (DjPlaylistNewHolderImpl)o00;
                    ArtistPlayListInfoBase artistPlayListInfoBase0 = (ArtistPlayListInfoBase)this.getItem(v1);
                    if(artistPlayListInfoBase0 != null) {
                        com.iloen.melon.fragments.searchandadd.PlaylistDjChartSearchAndAddFragment.SearchAndAddPlaylistDjChartAdapter.2 playlistDjChartSearchAndAddFragment$SearchAndAddPlaylistDjChartAdapter$20 = new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                SearchAndAddPlaylistDjChartAdapter playlistDjChartSearchAndAddFragment$SearchAndAddPlaylistDjChartAdapter0 = SearchAndAddPlaylistDjChartAdapter.this;
                                if(playlistDjChartSearchAndAddFragment$SearchAndAddPlaylistDjChartAdapter0.mOnItemEventListener != null) {
                                    playlistDjChartSearchAndAddFragment$SearchAndAddPlaylistDjChartAdapter0.mOnItemViewClickListener.onItemViewClick(view0, v);
                                }
                            }
                        };
                        ViewUtils.setOnClickListener(djPlaylistNewHolderImpl0.itemView, playlistDjChartSearchAndAddFragment$SearchAndAddPlaylistDjChartAdapter$20);
                        ViewUtils.showWhen(djPlaylistNewHolderImpl0.checkIv, true);
                        if(this.isMarked(v1)) {
                            djPlaylistNewHolderImpl0.checkIv.setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                            djPlaylistNewHolderImpl0.checkIv.setContentDescription("선택 취소 버튼");
                            int v2 = ColorUtils.getColor(this.getContext(), 0x7F060199);  // color:list_item_marked
                            djPlaylistNewHolderImpl0.itemView.setBackgroundColor(v2);
                        }
                        else {
                            djPlaylistNewHolderImpl0.checkIv.setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                            djPlaylistNewHolderImpl0.checkIv.setContentDescription("선택 버튼");
                            int v3 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                            djPlaylistNewHolderImpl0.itemView.setBackgroundColor(v3);
                        }
                        ViewUtils.setEnable(djPlaylistNewHolderImpl0.itemView, ProtocolUtils.parseBoolean(artistPlayListInfoBase0.openyn) && !ProtocolUtils.parseBoolean(artistPlayListInfoBase0.dimYn));
                        Glide.with(this.getContext()).load(artistPlayListInfoBase0.thumbimg).into(djPlaylistNewHolderImpl0.thumbIv);
                        ViewUtils.hideWhen(djPlaylistNewHolderImpl0.playIv, true);
                        djPlaylistNewHolderImpl0.titleTv.setText(artistPlayListInfoBase0.plylsttitle);
                        djPlaylistNewHolderImpl0.titleTv.setMaxLines(2);
                        djPlaylistNewHolderImpl0.artistTv.setText(StringUtils.getTrimmed(artistPlayListInfoBase0.ownernickname, 13));
                        djPlaylistNewHolderImpl0.artistTv.requestLayout();
                        djPlaylistNewHolderImpl0.likeTv.setText(StringUtils.getCountString(artistPlayListInfoBase0.likecnt, 0x98967F));
                        ViewUtils.showWhen(djPlaylistNewHolderImpl0.likeTv, true);
                        ViewUtils.showWhen(djPlaylistNewHolderImpl0.newIv, "Y".equals(artistPlayListInfoBase0.upyn));
                        ViewUtils.showWhen(djPlaylistNewHolderImpl0.crownIv, "Y".equals(artistPlayListInfoBase0.fameregyn));
                        ViewUtils.showWhen(djPlaylistNewHolderImpl0.songCountTv, false);
                        djPlaylistNewHolderImpl0.songCountTv.setText(String.format(PlaylistDjChartSearchAndAddFragment.this.getString(0x7F130655), artistPlayListInfoBase0.songcnt));  // string:melondj_playlist_song_count "%s곡"
                        ViewUtils.hideWhen(djPlaylistNewHolderImpl0.tagName1Tv, true);
                        ViewUtils.hideWhen(djPlaylistNewHolderImpl0.tagName2Tv, true);
                        if(artistPlayListInfoBase0.taglist != null && !artistPlayListInfoBase0.taglist.isEmpty()) {
                            int v4 = artistPlayListInfoBase0.taglist.size();
                            if(v4 > 0) {
                                ViewUtils.showWhen(djPlaylistNewHolderImpl0.tagName1Tv, true);
                                TagInfoBase tagInfoBase0 = (TagInfoBase)artistPlayListInfoBase0.taglist.get(0);
                                djPlaylistNewHolderImpl0.tagName1Tv.setText(tagInfoBase0.tagName);
                            }
                            if(v4 > 1) {
                                ViewUtils.showWhen(djPlaylistNewHolderImpl0.tagName2Tv, true);
                                TagInfoBase tagInfoBase1 = (TagInfoBase)artistPlayListInfoBase0.taglist.get(1);
                                djPlaylistNewHolderImpl0.tagName2Tv.setText(tagInfoBase1.tagName);
                            }
                        }
                        ViewUtils.showWhen(djPlaylistNewHolderImpl0.underline, artistPlayListInfoBase0.isFullLine);
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
                    O0 o00 = new SearchAndAddFilterViewHolder(this.mInflater.inflate(0x7F0D0815, viewGroup0, false), PlaylistDjChartSearchAndAddFragment.this.getActivity(), PlaylistDjChartSearchAndAddFragment.this);  // layout:searchandadd_filter
                    ((SearchAndAddFilterViewHolder)o00).setOnFilterListener(new OnFilterListener() {
                        @Override  // com.iloen.melon.fragments.searchandadd.SearchAndAddFilterViewHolder$OnFilterListener
                        public void onSelected(String s) {
                            if(s.equals(PlaylistDjChartSearchAndAddFragment.this.mFilterType)) {
                                return;
                            }
                            PlaylistDjChartSearchAndAddFragment.this.mFilterType = s;
                            PlaylistDjChartSearchAndAddFragment.this.startFetch("onSelected");
                        }
                    });
                    return o00;
                }
                case 2: {
                    return new DjPlaylistNewHolderImpl(this.mInflater.inflate(0x7F0D048E, viewGroup0, false));  // layout:listitem_djplaylist_new
                }
                default: {
                    return null;
                }
            }
        }
    }

    private static final String ARG_CATE_CODE = "arg_cate_code";
    private static final String ARG_CATE_NAME = "arg_cate_name";
    private static final String DEFAULT_CATE_CODE = "all";
    private static final int PAGE_SIZE = 100;
    private static final String TAG = "PlaylistDjChartSearchAndAddFragment";
    private String mFilterType;

    public PlaylistDjChartSearchAndAddFragment() {
        this.mFilterType = "all";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new SearchAndAddPlaylistDjChartAdapter(this, context0, null, this.mSearchViewType);
        ((SearchAndAddBaseAdapter)j00).setOnItemEventListener(this.mContentItemEventListener);
        ((SearchAndAddBaseAdapter)j00).setOnItemViewClickListener(this.mOnItemViewClickListener);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.h.buildUpon().appendPath("playlistDjChart").appendQueryParameter("searchViewType", String.valueOf(this.mSearchViewType)).appendQueryParameter("filterType", this.mFilterType).appendQueryParameter("caller", String.valueOf(this.mCaller)).build().toString();
    }

    public static PlaylistDjChartSearchAndAddFragment newInstance(int v, int v1, int v2) {
        if(v == -1) {
            throw new IllegalArgumentException("Invalid searchViewType - " + -1);
        }
        PlaylistDjChartSearchAndAddFragment playlistDjChartSearchAndAddFragment0 = new PlaylistDjChartSearchAndAddFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argSearchViewType", v);
        bundle0.putInt("argCaller", v1);
        bundle0.putInt("argMaxContentCount", v2);
        playlistDjChartSearchAndAddFragment0.setArguments(bundle0);
        return playlistDjChartSearchAndAddFragment0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        if(i.c.equals(i0)) {
            this.getMelonArrayAdapter().getCount();
        }
        else {
            this.clearData();
        }
        if(SearchAndAddPlaylistDjChartAdapter.a(((SearchAndAddPlaylistDjChartAdapter)this.getAdapter())) == null) {
            RequestBuilder.newInstance(new DjPopularListCateReq(this.getContext())).tag("PlaylistDjChartSearchAndAddFragment").listener(new Listener() {
                public void onResponse(DjPopularListCateRes djPopularListCateRes0) {
                    if(djPopularListCateRes0.isSuccessful()) {
                        ArrayList arrayList0 = djPopularListCateRes0.response.cateList;
                        ((SearchAndAddPlaylistDjChartAdapter)PlaylistDjChartSearchAndAddFragment.this.getAdapter()).addCateList(arrayList0);
                        PlaylistDjChartSearchAndAddFragment.this.getAdapter().notifyItemChanged(0);
                    }
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((DjPopularListCateRes)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
        }
        if(this.mCaller == 10) {
            RequestBuilder.newInstance(new MyMusicMessageDjPopularListPlylstReq(this.getContext(), this.mFilterType)).tag("PlaylistDjChartSearchAndAddFragment").listener(new Listener() {
                public void onResponse(DjPopularListPlylstRes djPopularListPlylstRes0) {
                    if(!PlaylistDjChartSearchAndAddFragment.this.prepareFetchComplete(djPopularListPlylstRes0)) {
                        return;
                    }
                    PlaylistDjChartSearchAndAddFragment.this.performFetchComplete(i0, djPopularListPlylstRes0);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((DjPopularListPlylstRes)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        this.performFetchCompleteOnlyViews();
        return true;
    }
}

