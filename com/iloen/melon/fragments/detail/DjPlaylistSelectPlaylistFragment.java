package com.iloen.melon.fragments.detail;

import F8.m;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MyMusicPlaylistListReq;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistListRes.RESPONSE.PLAYLISTLIST;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistListRes;
import com.iloen.melon.net.v5x.request.MyMusicPlaylistListSongReq;
import com.iloen.melon.net.v5x.request.PlaylistListSongBaseReq.Params;
import com.iloen.melon.net.v5x.response.MyMusicPlaylistListSongRes;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.SongInfoBase;
import e1.u;
import java.util.ArrayList;
import v9.h;
import v9.i;
import va.e0;
import va.o;

public class DjPlaylistSelectPlaylistFragment extends MetaContentBaseFragment {
    class ItemViewHolder extends O0 {
        protected View layoutItemContainer;
        protected TextView tvSelectButton;
        protected TextView tvSongCnt;
        protected TextView tvText;
        protected View vBottomLine;

        public ItemViewHolder(View view0) {
            super(view0);
            this.layoutItemContainer = view0.findViewById(0x7F0A0DF5);  // id:wrapper_layout
            this.tvText = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
            this.tvSongCnt = (TextView)view0.findViewById(0x7F0A0C50);  // id:tv_count
            TextView textView0 = (TextView)view0.findViewById(0x7F0A0D0A);  // id:tv_select_button
            this.tvSelectButton = textView0;
            textView0.setVisibility(0);
            this.vBottomLine = view0.findViewById(0x7F0A0D6B);  // id:underline
        }
    }

    class PlaylistAdapter extends p {
        private Context mContext;

        public PlaylistAdapter(Context context0) {
            super(context0, null);
            this.mContext = context0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(!(o00 instanceof ItemViewHolder)) {
                return;
            }
            PLAYLISTLIST myMusicPlaylistListRes$RESPONSE$PLAYLISTLIST0 = (PLAYLISTLIST)this.getItem(v1);
            ((ItemViewHolder)o00).tvText.requestLayout();
            ((ItemViewHolder)o00).tvText.setText(myMusicPlaylistListRes$RESPONSE$PLAYLISTLIST0.plylsttitle);
            ((ItemViewHolder)o00).tvSongCnt.setText(StringUtils.getCountFormattedString(myMusicPlaylistListRes$RESPONSE$PLAYLISTLIST0.songcnt));
            if(v1 == this.getItemCount()) {
                ((ItemViewHolder)o00).vBottomLine.setVisibility(8);
            }
            ViewUtils.setOnClickListener(((ItemViewHolder)o00).tvSelectButton, new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    PLAYLISTLIST myMusicPlaylistListRes$RESPONSE$PLAYLISTLIST0 = (PLAYLISTLIST)PlaylistAdapter.this.getItem(v1);
                    DjPlaylistSelectPlaylistFragment.this.loadSongListInPlaylist(myMusicPlaylistListRes$RESPONSE$PLAYLISTLIST0.plylstseq);
                }
            });
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0499, viewGroup0, false);  // layout:listitem_local_playlist
            return new ItemViewHolder(DjPlaylistSelectPlaylistFragment.this, view0);
        }
    }

    public static final String ARG_PLYLST_SEQ = "argPlylstSeq";
    public static final String ARG_PLYLST_TYPE = "argPlylstType";
    public static final String ARG_SELECT_PLAYLIST_VALUES = "argSelectPlaylistValues";
    public static final String CACHE_KEY_SUB_NAME = "selectPlaylist";
    public static final String TAG = "DjPlaylistSelectPlaylistFragment";
    private String mPlylstSeq;
    private String mPlylstType;
    private TitleBar mTitleBarLayout;

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return new PlaylistAdapter(this, context0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.j.buildUpon().appendPath("selectPlaylist").build().toString();
    }

    private void loadSongListInPlaylist(String s) {
        Params playlistListSongBaseReq$Params0 = new Params();
        playlistListSongBaseReq$Params0.plylstSeq = s;
        playlistListSongBaseReq$Params0.mode = "all";
        this.showProgress(true);
        RequestBuilder.newInstance(new MyMusicPlaylistListSongReq(this.getContext(), playlistListSongBaseReq$Params0)).listener(new Listener() {
            public void onResponse(MyMusicPlaylistListSongRes myMusicPlaylistListSongRes0) {
                if(!DjPlaylistSelectPlaylistFragment.this.isFragmentValid()) {
                    return;
                }
                if(myMusicPlaylistListSongRes0.isSuccessful() && (myMusicPlaylistListSongRes0.response != null && myMusicPlaylistListSongRes0.response.songList != null)) {
                    new Thread() {
                        @Override
                        public void run() {
                            ArrayList arrayList0 = myMusicPlaylistListSongRes0.response.songList;
                            LogU.d("DjPlaylistSelectPlaylistFragment", "loadSongListInPlaylist() >> Playlist Size: " + arrayList0.size());
                            ArrayList arrayList1 = new ArrayList();
                            for(Object object0: arrayList0) {
                                SongInfoBase songInfoBase0 = (SongInfoBase)object0;
                                if(songInfoBase0.canService) {
                                    arrayList1.add(songInfoBase0.songId);
                                }
                            }
                            DjPlaylistSelectPlaylistFragment.this.showProgress(false);
                            Intent intent0 = new Intent();
                            intent0.putExtra("argSelectPlaylistValues", arrayList1);
                            FragmentActivity fragmentActivity0 = DjPlaylistSelectPlaylistFragment.this.getActivity();
                            if(fragmentActivity0 != null) {
                                Activity activity0 = fragmentActivity0.getParent();
                                if(activity0 == null) {
                                    fragmentActivity0.setResult(-1, intent0);
                                }
                                else {
                                    activity0.setResult(-1, intent0);
                                }
                                fragmentActivity0.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        DjPlaylistSelectPlaylistFragment.this.performBackPress();
                                    }
                                });
                            }
                        }
                    }.start();
                    return;
                }
                DjPlaylistSelectPlaylistFragment.this.showProgress(false);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicPlaylistListSongRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
    }

    public static DjPlaylistSelectPlaylistFragment newInstance(String s, String s1) {
        DjPlaylistSelectPlaylistFragment djPlaylistSelectPlaylistFragment0 = new DjPlaylistSelectPlaylistFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argPlylstSeq", s);
        bundle0.putString("argPlylstType", s1);
        djPlaylistSelectPlaylistFragment0.setArguments(bundle0);
        return djPlaylistSelectPlaylistFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D02A9, viewGroup0, false);  // layout:fragment_detail_basic
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        PlaylistAdapter djPlaylistSelectPlaylistFragment$PlaylistAdapter0 = (PlaylistAdapter)this.mAdapter;
        com.iloen.melon.net.v4x.request.PlaylistListBaseReq.Params playlistListBaseReq$Params0 = new com.iloen.melon.net.v4x.request.PlaylistListBaseReq.Params();
        playlistListBaseReq$Params0.startIndex = i.b.equals(i0) ? 1 : djPlaylistSelectPlaylistFragment$PlaylistAdapter0.getCount() + 1;
        playlistListBaseReq$Params0.pageSize = 100;
        playlistListBaseReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        playlistListBaseReq$Params0.plylstTypeCode = "M20001";
        RequestBuilder.newInstance(new MyMusicPlaylistListReq(this.getContext(), playlistListBaseReq$Params0)).tag("DjPlaylistSelectPlaylistFragment").listener(new Listener() {
            public void onResponse(MyMusicPlaylistListRes myMusicPlaylistListRes0) {
                if(!DjPlaylistSelectPlaylistFragment.this.prepareFetchComplete(myMusicPlaylistListRes0)) {
                    return;
                }
                DjPlaylistSelectPlaylistFragment.this.performFetchComplete(i0, myMusicPlaylistListRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicPlaylistListRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        if(bundle0.containsKey("argPlylstSeq")) {
            this.mPlylstSeq = bundle0.getString("argPlylstSeq");
            this.mPlylstType = bundle0.getString("argPlylstType");
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putString("argPlylstSeq", this.mPlylstSeq);
            bundle0.putString("argPlylstType", this.mPlylstType);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.mTitleBarLayout = (TitleBar)this.mRootView.findViewById(0x7F0A0BAD);  // id:titlebar
        F8.p p0 = new F8.p(1);
        p0.h(this.getString(0x7F130809));  // string:playList_talkback_detail_info_close "상세정보 닫기"
        p0.c = new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                DjPlaylistSelectPlaylistFragment.this.performBackPress();
            }
        };
        m m0 = new m(2, false);
        TitleBar titleBar0 = this.mTitleBarLayout;
        F8.o[] arr_o = {m0, p0};
        F8.o o0 = null;
        for(int v = 0; v < 2; ++v) {
            F8.o o1 = arr_o[v];
            if(o0 == null) {
                o0 = o1;
            }
            else {
                o0.g(o1);
            }
        }
        titleBar0.a(o0);
        this.mTitleBarLayout.setTitle(this.getString(0x7F130831));  // string:playlist_listtype_title "플레이리스트 선택"
        this.mTitleBarLayout.f(true);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return true;
    }
}

