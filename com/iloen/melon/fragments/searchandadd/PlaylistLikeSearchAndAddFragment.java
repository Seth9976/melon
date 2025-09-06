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
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v4x.request.LikeListDjPlaylistBaseReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicMessageLikeListArtistPlaylistReq;
import com.iloen.melon.net.v4x.request.MyMusicMessageLikeListDjPlaylistReq;
import com.iloen.melon.net.v4x.request.MyMusicMessageLikeListPlaylistReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeListArtistPlaylistRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeListDjPlaylistRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeListPlaylistRes;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableArtistPlaylist;
import com.iloen.melon.sns.model.SharableDJCollection;
import com.iloen.melon.sns.model.SharablePlaylist;
import com.iloen.melon.sns.model.b;
import com.iloen.melon.sns.model.c;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.DjPlaylistNewHolderImpl;
import e1.u;
import java.util.List;
import v9.h;
import v9.i;
import va.e0;
import va.o;

public class PlaylistLikeSearchAndAddFragment extends SearchAndAddBaseFragment {
    class SearchAndAddPlaylistLikeAdapter extends SearchAndAddBaseAdapter {
        private static final int VIEW_TYPE_FILTER_SORTBAR = 1;
        private static final int VIEW_TYPE_ITEM = 2;
        private static final int VIEW_TYPE_ITEM_DJ = 3;

        public SearchAndAddPlaylistLikeAdapter(Context context0, List list0, int v) {
            super(context0, list0, v);
            this.setListContentType(4);
            this.setMarkedMode(true);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            if(v == this.getAvailableHeaderPosition()) {
                return 1;
            }
            return "M20002".equals(PlaylistLikeSearchAndAddFragment.this.mFilterType) ? 3 : 2;
        }

        @Override  // com.iloen.melon.fragments.searchandadd.SearchAndAddBaseAdapter
        public Sharable getSharable(int v) {
            ArtistPlayListInfoBase artistPlayListInfoBase0 = (ArtistPlayListInfoBase)this.getItem(v);
            if(artistPlayListInfoBase0 == null) {
                return null;
            }
            if("M20004".equals(PlaylistLikeSearchAndAddFragment.this.mFilterType)) {
                b b0 = new b();  // 初始化器: Lcom/iloen/melon/sns/model/c;-><init>()V
                b0.a = artistPlayListInfoBase0.plylstseq;
                b0.i = artistPlayListInfoBase0.openyn;
                return new SharableArtistPlaylist(b0);
            }
            if("M20002".equals(PlaylistLikeSearchAndAddFragment.this.mFilterType)) {
                c c0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
                c0.a = artistPlayListInfoBase0.plylstseq;
                c0.h = artistPlayListInfoBase0.openyn;
                return new SharableDJCollection(c0);
            }
            c c1 = new c();
            c1.a = artistPlayListInfoBase0.plylstseq;
            c1.i = artistPlayListInfoBase0.openyn;
            return new SharablePlaylist(c1);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            switch(o00.getItemViewType()) {
                case 1: {
                    if(o00 instanceof SearchAndAddFilterSortbarViewHolder) {
                        if(this.getList().size() == 0) {
                            ((SearchAndAddFilterSortbarViewHolder)o00).setSortbarVisibility(8);
                            return;
                        }
                        ((SearchAndAddFilterSortbarViewHolder)o00).setSortbarVisibility(0);
                        return;
                    }
                    break;
                }
                case 2: {
                    if(o00 instanceof SearchAndAddPlaylistViewHolder) {
                        ((SearchAndAddPlaylistViewHolder)o00).bindView(((ArtistPlayListInfoBase)this.getItem(v1)), v, v1, PlaylistLikeSearchAndAddFragment.this.mFilterType);
                        return;
                    }
                    break;
                }
                case 3: {
                    DjPlaylistNewHolderImpl djPlaylistNewHolderImpl0 = (DjPlaylistNewHolderImpl)o00;
                    ArtistPlayListInfoBase artistPlayListInfoBase0 = (ArtistPlayListInfoBase)this.getItem(v1);
                    if(artistPlayListInfoBase0 != null) {
                        com.iloen.melon.fragments.searchandadd.PlaylistLikeSearchAndAddFragment.SearchAndAddPlaylistLikeAdapter.2 playlistLikeSearchAndAddFragment$SearchAndAddPlaylistLikeAdapter$20 = new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                SearchAndAddPlaylistLikeAdapter playlistLikeSearchAndAddFragment$SearchAndAddPlaylistLikeAdapter0 = SearchAndAddPlaylistLikeAdapter.this;
                                if(playlistLikeSearchAndAddFragment$SearchAndAddPlaylistLikeAdapter0.mOnItemEventListener != null) {
                                    playlistLikeSearchAndAddFragment$SearchAndAddPlaylistLikeAdapter0.mOnItemViewClickListener.onItemViewClick(view0, v);
                                }
                            }
                        };
                        ViewUtils.setOnClickListener(djPlaylistNewHolderImpl0.itemView, playlistLikeSearchAndAddFragment$SearchAndAddPlaylistLikeAdapter$20);
                        ViewUtils.showWhen(djPlaylistNewHolderImpl0.checkIv, true);
                        MelonAppBase.instance.getContext();
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
                        djPlaylistNewHolderImpl0.songCountTv.setText(String.format(PlaylistLikeSearchAndAddFragment.this.getString(0x7F130655), artistPlayListInfoBase0.songcnt));  // string:melondj_playlist_song_count "%s곡"
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
                    O0 o00 = new SearchAndAddFilterSortbarViewHolder(this.mInflater.inflate(0x7F0D0815, viewGroup0, false), PlaylistLikeSearchAndAddFragment.this.getActivity(), PlaylistLikeSearchAndAddFragment.this, 1, true);  // layout:searchandadd_filter
                    ((SearchAndAddFilterSortbarViewHolder)o00).setOnFilterListener(new OnFilterListener() {
                        @Override  // com.iloen.melon.fragments.searchandadd.SearchAndAddFilterSortbarViewHolder$OnFilterListener
                        public void onSelected(String s, int v) {
                            if(s.equals(PlaylistLikeSearchAndAddFragment.this.mFilterType) && v == PlaylistLikeSearchAndAddFragment.this.mSortType) {
                                return;
                            }
                            PlaylistLikeSearchAndAddFragment.this.mFilterType = s;
                            PlaylistLikeSearchAndAddFragment playlistLikeSearchAndAddFragment0 = PlaylistLikeSearchAndAddFragment.this;
                            playlistLikeSearchAndAddFragment0.mSortType = v;
                            if(v == 0) {
                                playlistLikeSearchAndAddFragment0.mOrderBy = "NEW";
                            }
                            else if(v == 1) {
                                PlaylistLikeSearchAndAddFragment.this.mOrderBy = "M20004".equals(playlistLikeSearchAndAddFragment0.mFilterType) ? "ARTIST" : "MAKER";
                            }
                            PlaylistLikeSearchAndAddFragment.this.startFetch("onSelected");
                        }
                    });
                    return o00;
                }
                case 2: {
                    return new SearchAndAddPlaylistViewHolder(this.mInflater.inflate(0x7F0D049E, viewGroup0, false), this);  // layout:listitem_playlist
                }
                case 3: {
                    return new DjPlaylistNewHolderImpl(this.mInflater.inflate(0x7F0D048E, viewGroup0, false));  // layout:listitem_djplaylist_new
                }
                default: {
                    return null;
                }
            }
        }
    }

    private static final int PAGE_SIZE = 100;
    private static final String TAG = "PlaylistLikeSearchAndAddFragment";
    private String mFilterType;
    private String mOrderBy;

    public PlaylistLikeSearchAndAddFragment() {
        this.mOrderBy = "DSPLY_ORDER";
        this.mFilterType = "M20001";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new SearchAndAddPlaylistLikeAdapter(this, context0, null, this.mSearchViewType);
        ((SearchAndAddBaseAdapter)j00).setOnItemEventListener(this.mContentItemEventListener);
        ((SearchAndAddBaseAdapter)j00).setOnItemViewClickListener(this.mOnItemViewClickListener);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.h.buildUpon().appendPath("playlistLike").appendQueryParameter("searchViewType", String.valueOf(this.mSearchViewType)).appendQueryParameter("orderBy", this.mOrderBy).appendQueryParameter("filterType", this.mFilterType).appendQueryParameter("caller", String.valueOf(this.mCaller)).build().toString();
    }

    public static PlaylistLikeSearchAndAddFragment newInstance(int v, int v1, int v2) {
        if(v == -1) {
            throw new IllegalArgumentException("Invalid searchViewType - " + -1);
        }
        PlaylistLikeSearchAndAddFragment playlistLikeSearchAndAddFragment0 = new PlaylistLikeSearchAndAddFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argSearchViewType", v);
        bundle0.putInt("argCaller", v1);
        bundle0.putInt("argMaxContentCount", v2);
        playlistLikeSearchAndAddFragment0.setArguments(bundle0);
        return playlistLikeSearchAndAddFragment0;
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
        if("M20002".equals(this.mFilterType)) {
            Params likeListDjPlaylistBaseReq$Params0 = new Params();
            likeListDjPlaylistBaseReq$Params0.startIndex = v;
            likeListDjPlaylistBaseReq$Params0.pageSize = 100;
            likeListDjPlaylistBaseReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
            likeListDjPlaylistBaseReq$Params0.orderBy = this.mOrderBy;
            if(this.mCaller == 10) {
                RequestBuilder.newInstance(new MyMusicMessageLikeListDjPlaylistReq(this.getContext(), likeListDjPlaylistBaseReq$Params0)).tag("PlaylistLikeSearchAndAddFragment").listener(new Listener() {
                    public void onResponse(MyMusicLikeListDjPlaylistRes myMusicLikeListDjPlaylistRes0) {
                        if(!PlaylistLikeSearchAndAddFragment.this.prepareFetchComplete(myMusicLikeListDjPlaylistRes0)) {
                            return;
                        }
                        PlaylistLikeSearchAndAddFragment.this.performFetchComplete(i0, myMusicLikeListDjPlaylistRes0);
                    }

                    @Override  // com.android.volley.Response$Listener
                    public void onResponse(Object object0) {
                        this.onResponse(((MyMusicLikeListDjPlaylistRes)object0));
                    }
                }).errorListener(this.mResponseErrorListener).request();
                return true;
            }
            this.performFetchCompleteOnlyViews();
            return true;
        }
        if("M20004".equals(this.mFilterType)) {
            com.iloen.melon.net.v4x.request.LikeListArtistPlaylistBaseReq.Params likeListArtistPlaylistBaseReq$Params0 = new com.iloen.melon.net.v4x.request.LikeListArtistPlaylistBaseReq.Params();
            likeListArtistPlaylistBaseReq$Params0.startIndex = v;
            likeListArtistPlaylistBaseReq$Params0.pageSize = 100;
            likeListArtistPlaylistBaseReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
            likeListArtistPlaylistBaseReq$Params0.orderBy = this.mOrderBy;
            if(this.mCaller == 10) {
                RequestBuilder.newInstance(new MyMusicMessageLikeListArtistPlaylistReq(this.getContext(), likeListArtistPlaylistBaseReq$Params0)).tag("PlaylistLikeSearchAndAddFragment").listener(new Listener() {
                    public void onResponse(MyMusicLikeListArtistPlaylistRes myMusicLikeListArtistPlaylistRes0) {
                        if(!PlaylistLikeSearchAndAddFragment.this.prepareFetchComplete(myMusicLikeListArtistPlaylistRes0)) {
                            return;
                        }
                        PlaylistLikeSearchAndAddFragment.this.performFetchComplete(i0, myMusicLikeListArtistPlaylistRes0);
                    }

                    @Override  // com.android.volley.Response$Listener
                    public void onResponse(Object object0) {
                        this.onResponse(((MyMusicLikeListArtistPlaylistRes)object0));
                    }
                }).errorListener(this.mResponseErrorListener).request();
                return true;
            }
            this.performFetchCompleteOnlyViews();
            return true;
        }
        com.iloen.melon.net.v4x.request.LikeListPlaylistBaseReq.Params likeListPlaylistBaseReq$Params0 = new com.iloen.melon.net.v4x.request.LikeListPlaylistBaseReq.Params();
        likeListPlaylistBaseReq$Params0.startIndex = v;
        likeListPlaylistBaseReq$Params0.pageSize = 100;
        likeListPlaylistBaseReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        likeListPlaylistBaseReq$Params0.orderBy = this.mOrderBy;
        if(this.mCaller == 10) {
            RequestBuilder.newInstance(new MyMusicMessageLikeListPlaylistReq(this.getContext(), likeListPlaylistBaseReq$Params0)).tag("PlaylistLikeSearchAndAddFragment").listener(new Listener() {
                public void onResponse(MyMusicLikeListPlaylistRes myMusicLikeListPlaylistRes0) {
                    if(!PlaylistLikeSearchAndAddFragment.this.prepareFetchComplete(myMusicLikeListPlaylistRes0)) {
                        return;
                    }
                    PlaylistLikeSearchAndAddFragment.this.performFetchComplete(i0, myMusicLikeListPlaylistRes0);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((MyMusicLikeListPlaylistRes)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        this.performFetchCompleteOnlyViews();
        return true;
    }
}

