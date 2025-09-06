package com.iloen.melon.fragments.main.foru;

import B.a;
import a9.d;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.common.SearchOrderBy;
import com.iloen.melon.net.v4x.request.ForUSearchArtistListReq;
import com.iloen.melon.net.v4x.request.ForUSearchSongListReq;
import com.iloen.melon.net.v4x.request.SearchArtistListBaseReq.Params;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.SongHolder;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.SongInfoBase;
import e1.u;
import java.util.List;
import v9.h;
import v9.i;
import va.e0;
import va.o;

public class ForUSelfRecommendSearchMoreFragment extends MetaContentBaseFragment {
    class RecommendMoreAdapter extends p {
        public class ArtistViewHolder extends O0 {
            private TextView artistName;
            private View btnRecom;
            private TextView genreText;
            private ImageView thumbnail;

            public ArtistViewHolder(View view0) {
                super(view0);
                this.thumbnail = (ImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                ViewUtils.setDefaultImage(((ImageView)view0.findViewById(0x7F0A069C)), ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), 65.0f), true);  // id:iv_thumb_circle_default
                this.artistName = (TextView)view0.findViewById(0x7F0A00B8);  // id:artist_name
                this.genreText = (TextView)view0.findViewById(0x7F0A04ED);  // id:genre_text
                this.btnRecom = view0.findViewById(0x7F0A019D);  // id:btn_recommend
            }
        }

        public class SortBarViewHolder extends O0 {
            private SortingBarView sortBarView;

            public SortBarViewHolder(Context context0, View view0) {
                super(view0);
                this.sortBarView = (SortingBarView)view0.findViewById(0x7F0A0AB8);  // id:sort_bar
                this.sortBarView.setSortBarStyle(2);
                this.sortBarView.setItems(new String[]{"정확도", "인기순", "가나다순"});
                this.sortBarView.setSelection(ForUSelfRecommendSearchMoreFragment.this.getSortIndex());
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0D6B), true);  // id:underline
            }

            public static SortingBarView a(SortBarViewHolder forUSelfRecommendSearchMoreFragment$RecommendMoreAdapter$SortBarViewHolder0) {
                return forUSelfRecommendSearchMoreFragment$RecommendMoreAdapter$SortBarViewHolder0.sortBarView;
            }
        }

        private static final int VIEW_TYPE_ARTIST = 3;
        private static final int VIEW_TYPE_HEADER = 1;
        private static final int VIEW_TYPE_SONG = 2;

        public RecommendMoreAdapter(Context context0, List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            if(v == this.getAvailableHeaderPosition()) {
                return 1;
            }
            return this.getItem(v1) instanceof SongInfoBase ? 2 : 3;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            Object object0 = this.getItem(v1);
            if(o00 instanceof SortBarViewHolder) {
                this.updateSortBarView(((SortBarViewHolder)o00));
                return;
            }
            if(o00 instanceof SongHolder) {
                if(object0 instanceof SongInfoBase) {
                    this.updateSongView(((SongHolder)o00), ((SongInfoBase)object0));
                }
            }
            else if(o00 instanceof ArtistViewHolder && object0 instanceof ArtistInfoBase) {
                this.updateArtistView(((ArtistViewHolder)o00), ((ArtistInfoBase)object0));
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            switch(v) {
                case 1: {
                    return new SortBarViewHolder(this, this.getContext(), LayoutInflater.from(this.getContext()).inflate(0x7F0D085D, viewGroup0, false));  // layout:sortbar_view
                }
                case 2: {
                    return new SongHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D04A8, viewGroup0, false));  // layout:listitem_song
                }
                default: {
                    return new ArtistViewHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D028D, viewGroup0, false));  // layout:for_u_self_recommend_artist_list_item
                }
            }
        }

        private void updateArtistView(ArtistViewHolder forUSelfRecommendSearchMoreFragment$RecommendMoreAdapter$ArtistViewHolder0, ArtistInfoBase artistInfoBase0) {
            if(artistInfoBase0 != null && !TextUtils.isEmpty(artistInfoBase0.actType)) {
                if(this.getContext() != null && forUSelfRecommendSearchMoreFragment$RecommendMoreAdapter$ArtistViewHolder0.thumbnail != null) {
                    Glide.with(this.getContext()).load(artistInfoBase0.getArtistImg()).apply(RequestOptions.circleCropTransform()).into(forUSelfRecommendSearchMoreFragment$RecommendMoreAdapter$ArtistViewHolder0.thumbnail);
                }
                forUSelfRecommendSearchMoreFragment$RecommendMoreAdapter$ArtistViewHolder0.artistName.setText(artistInfoBase0.getArtistName());
                StringBuilder stringBuilder0 = new StringBuilder(artistInfoBase0.actType);
                if(stringBuilder0.length() > 0 && !TextUtils.isEmpty(artistInfoBase0.actGenre)) {
                    stringBuilder0.append(" / ");
                }
                stringBuilder0.append(artistInfoBase0.actGenre);
                forUSelfRecommendSearchMoreFragment$RecommendMoreAdapter$ArtistViewHolder0.genreText.setText(stringBuilder0.toString());
                ViewUtils.setOnClickListener(forUSelfRecommendSearchMoreFragment$RecommendMoreAdapter$ArtistViewHolder0.btnRecom, new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        Navigator.openSimilarSongList(artistInfoBase0.getArtistId(), "N10006");
                    }
                });
            }
        }

        private void updateSongView(SongHolder songHolder0, SongInfoBase songInfoBase0) {
            if(songInfoBase0 == null) {
                return;
            }
            if(this.getContext() != null && songHolder0.thumbnailIv != null) {
                Glide.with(this.getContext()).load(songInfoBase0.albumImg).into(songHolder0.thumbnailIv);
            }
            ViewUtils.showWhen(songHolder0.list19Iv, songInfoBase0.isAdult);
            ViewUtils.showWhen(songHolder0.listHoldbackIv, songInfoBase0.isHoldback);
            ViewUtils.showWhen(songHolder0.listFreeIv, songInfoBase0.isFree);
            songHolder0.titleTv.setText(songInfoBase0.songName);
            songHolder0.artistTv.setText(ProtocolUtils.getArtistNames(songInfoBase0.artistList));
            ViewUtils.showWhen(songHolder0.btnRecom, true);
            songHolder0.btnRecom.setOnClickListener(new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    Navigator.openSimilarSongList(songInfoBase0.songId, "N10001");
                }
            });
            ViewUtils.hideWhen(songHolder0.btnPlay, true);
            ViewUtils.hideWhen(songHolder0.btnInfo, true);
        }

        private void updateSortBarView(SortBarViewHolder forUSelfRecommendSearchMoreFragment$RecommendMoreAdapter$SortBarViewHolder0) {
            SortBarViewHolder.a(forUSelfRecommendSearchMoreFragment$RecommendMoreAdapter$SortBarViewHolder0).setOnSortSelectionListener(new d() {
                @Override  // a9.d
                public void onSelected(int v) {
                    if(ForUSelfRecommendSearchMoreFragment.e0(ForUSelfRecommendSearchMoreFragment.this) == v) {
                        return;
                    }
                    if(v == 0) {
                        ForUSelfRecommendSearchMoreFragment.this.mOrderBy = SearchOrderBy.ACCURACY;
                    }
                    else if(v == 1) {
                        ForUSelfRecommendSearchMoreFragment.this.mOrderBy = SearchOrderBy.POPULARITY;
                    }
                    else {
                        ForUSelfRecommendSearchMoreFragment.this.mOrderBy = SearchOrderBy.ALPHABETICAL;
                    }
                    ForUSelfRecommendSearchMoreFragment.this.startFetch("change sortbar");
                }
            });
        }
    }

    private static final String ARG_IS_SEARCH_ARTIST = "argContsTypeCode";
    private static final String ARG_KEYWORD = "argKeyword";
    private static final int PAGE_SIZE = 25;
    private static final int SORT_INDEX_ACCURACY = 0;
    private static final int SORT_INDEX_ALPHABET = 2;
    private static final int SORT_INDEX_POP = 1;
    private static final String TAG = "ForUSelfRecommendSearchMoreFragment";
    private boolean mIsSearchArtist;
    private String mKeyword;
    private int mOrderBy;

    public ForUSelfRecommendSearchMoreFragment() {
        this.mOrderBy = SearchOrderBy.ACCURACY;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return new RecommendMoreAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.m.buildUpon().appendQueryParameter("memberKey", u.v(((e0)o.a()).j())).appendQueryParameter("keyword", this.mKeyword).build().toString();
    }

    private int getSortIndex() {
        int v = this.mOrderBy;
        if(v == SearchOrderBy.ACCURACY) {
            return 0;
        }
        return v == SearchOrderBy.POPULARITY ? 1 : 2;
    }

    private int getStartIndex(i i0) {
        if(i.b.equals(i0)) {
            return 1;
        }
        return this.mAdapter instanceof p ? ((p)this.mAdapter).getCount() + 1 : 1;
    }

    public static ForUSelfRecommendSearchMoreFragment newInstance(String s, boolean z) {
        ForUSelfRecommendSearchMoreFragment forUSelfRecommendSearchMoreFragment0 = new ForUSelfRecommendSearchMoreFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argKeyword", s);
        bundle0.putBoolean("argContsTypeCode", z);
        forUSelfRecommendSearchMoreFragment0.setArguments(bundle0);
        return forUSelfRecommendSearchMoreFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D0291, viewGroup0, false);  // layout:for_u_taste
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        ForUSearchArtistListReq forUSearchArtistListReq0;
        if(this.mIsSearchArtist) {
            Params searchArtistListBaseReq$Params0 = new Params();
            searchArtistListBaseReq$Params0.startIndex = this.getStartIndex(i0);
            searchArtistListBaseReq$Params0.pageSize = 25;
            searchArtistListBaseReq$Params0.orderBy = this.mOrderBy;
            forUSearchArtistListReq0 = new ForUSearchArtistListReq(this.getContext(), this.mKeyword, searchArtistListBaseReq$Params0);
        }
        else {
            com.iloen.melon.net.v4x.request.SearchSongListBaseReq.Params searchSongListBaseReq$Params0 = new com.iloen.melon.net.v4x.request.SearchSongListBaseReq.Params();
            searchSongListBaseReq$Params0.startIndex = this.getStartIndex(i0);
            searchSongListBaseReq$Params0.pageSize = 25;
            searchSongListBaseReq$Params0.orderBy = this.mOrderBy;
            forUSearchArtistListReq0 = new ForUSearchSongListReq(this.getContext(), this.mKeyword, searchSongListBaseReq$Params0);
        }
        RequestBuilder.newInstance(forUSearchArtistListReq0).tag("ForUSelfRecommendSearchMoreFragment").listener(new Listener() {
            public void onResponse(ResponseV4Res responseV4Res0) {
                if(!ForUSelfRecommendSearchMoreFragment.this.prepareFetchComplete(responseV4Res0)) {
                    return;
                }
                ForUSelfRecommendSearchMoreFragment.this.performFetchComplete(i0, responseV4Res0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((ResponseV4Res)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        this.mKeyword = bundle0.getString("argKeyword");
        this.mIsSearchArtist = bundle0.getBoolean("argContsTypeCode");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putString("argKeyword", this.mKeyword);
            bundle0.putBoolean("argContsTypeCode", this.mIsSearchArtist);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle("유사곡 추천");
            titleBar0.f(true);
        }
    }
}

