package com.iloen.melon.fragments.mymusic;

import B.a;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v5x.request.DjSeriesModifyListPlylstReq;
import com.iloen.melon.net.v5x.response.DjSeriesModifyListPlylstRes.RESPONSE.PLYLSTLIST;
import com.iloen.melon.net.v5x.response.DjSeriesModifyListPlylstRes.RESPONSE;
import com.iloen.melon.net.v5x.response.DjSeriesModifyListPlylstRes;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.DjPlaylistHolder;
import com.melon.net.res.common.DjPlayListInfoBase;
import java.util.ArrayList;
import java.util.List;
import v9.h;
import v9.i;

public class SeriesDjPlaylistSelectFragment extends MetaContentBaseFragment {
    class SelectAdapter extends p {
        private static final int VIEW_TYPE_DJ_PLAYLIST = 1;

        public SelectAdapter(Context context0, List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(String s, i i0, HttpResponse httpResponse0) {
            if(httpResponse0 instanceof DjSeriesModifyListPlylstRes && ((DjSeriesModifyListPlylstRes)httpResponse0) != null) {
                RESPONSE djSeriesModifyListPlylstRes$RESPONSE0 = ((DjSeriesModifyListPlylstRes)httpResponse0).response;
                if(djSeriesModifyListPlylstRes$RESPONSE0 != null) {
                    this.setMenuId(djSeriesModifyListPlylstRes$RESPONSE0.menuId);
                    this.updateModifiedTime(this.getCacheKey());
                    ArrayList arrayList0 = ((DjSeriesModifyListPlylstRes)httpResponse0).response.playlistList;
                    if(arrayList0 != null && !arrayList0.isEmpty()) {
                        if(TextUtils.isEmpty(SeriesDjPlaylistSelectFragment.this.mSelectedPlaylist)) {
                            this.addAll(arrayList0);
                            return true;
                        }
                        for(int v = 0; v < arrayList0.size(); ++v) {
                            PLYLSTLIST djSeriesModifyListPlylstRes$RESPONSE$PLYLSTLIST0 = (PLYLSTLIST)arrayList0.get(v);
                            if(!SeriesDjPlaylistSelectFragment.this.mSelectedPlaylist.contains(djSeriesModifyListPlylstRes$RESPONSE$PLYLSTLIST0.plylstseq)) {
                                this.add(djSeriesModifyListPlylstRes$RESPONSE$PLYLSTLIST0);
                            }
                        }
                    }
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(o00.getItemViewType() == 1) {
                DjPlaylistHolder djPlaylistHolder0 = (DjPlaylistHolder)o00;
                DjPlayListInfoBase djPlayListInfoBase0 = (DjPlayListInfoBase)this.getItem(v1);
                Context context0 = this.getContext();
                if(context0 != null && djPlayListInfoBase0 != null) {
                    com.iloen.melon.fragments.mymusic.SeriesDjPlaylistSelectFragment.SelectAdapter.1 seriesDjPlaylistSelectFragment$SelectAdapter$10 = new View.OnClickListener() {
                        @Override  // android.view.View$OnClickListener
                        public void onClick(View view0) {
                            SeriesDjPlaylistSelectFragment.this.onItemClick(view0, v);
                        }
                    };
                    ViewUtils.setOnClickListener(djPlaylistHolder0.itemView, seriesDjPlaylistSelectFragment$SelectAdapter$10);
                    if(this.isMarked(v1)) {
                        djPlaylistHolder0.rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
                        djPlaylistHolder0.checkIv.setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                    }
                    else {
                        djPlaylistHolder0.rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                        djPlaylistHolder0.checkIv.setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                    }
                    ViewUtils.hideWhen(djPlaylistHolder0.playIv, true);
                    ViewUtils.showWhen(djPlaylistHolder0.djName, true);
                    ViewUtils.showWhen(djPlaylistHolder0.checkIv, true);
                    ViewUtils.showWhen(djPlaylistHolder0.newIv, ProtocolUtils.parseBoolean(djPlayListInfoBase0.upyn));
                    ViewUtils.showWhen(djPlaylistHolder0.crownIcon, ProtocolUtils.parseBoolean(djPlayListInfoBase0.fameregyn));
                    Glide.with(context0).load(djPlayListInfoBase0.thumbimg).into(djPlaylistHolder0.playlistImage);
                    djPlaylistHolder0.songCount.setText(String.format("%s곡", StringUtils.getCountString(djPlayListInfoBase0.songcnt, -1)));
                    djPlaylistHolder0.title.setText(djPlayListInfoBase0.plylsttitle);
                    djPlaylistHolder0.likeCount.setText(StringUtils.getCountString(djPlayListInfoBase0.likecnt, 0x98967F));
                    djPlaylistHolder0.djName.setText(djPlayListInfoBase0.ownernickname);
                    ViewUtils.hideWhen(djPlaylistHolder0.tagName1, true);
                    ViewUtils.hideWhen(djPlaylistHolder0.tagName2, true);
                    if(djPlayListInfoBase0.taglist != null && !djPlayListInfoBase0.taglist.isEmpty()) {
                        if(djPlayListInfoBase0.taglist.size() > 0) {
                            ViewUtils.showWhen(djPlaylistHolder0.tagName1, true);
                            TagInfoBase tagInfoBase0 = (TagInfoBase)djPlayListInfoBase0.taglist.get(0);
                            djPlaylistHolder0.tagName1.setText(tagInfoBase0.tagName);
                        }
                        if(djPlayListInfoBase0.taglist.size() > 1) {
                            ViewUtils.showWhen(djPlaylistHolder0.tagName2, true);
                            TagInfoBase tagInfoBase1 = (TagInfoBase)djPlayListInfoBase0.taglist.get(1);
                            djPlaylistHolder0.tagName2.setText(tagInfoBase1.tagName);
                        }
                    }
                    djPlaylistHolder0.showMoreButton(true);
                    ViewUtils.showWhen(djPlaylistHolder0.moreIv, false);
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return v != 1 ? null : new DjPlaylistHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D048D, viewGroup0, false));  // layout:listitem_djplaylist
        }
    }

    private static final String ARG_PLAY_LIST = "argPlaylist";
    private static final String ARG_SERIES_SEQ = "argSeriesSeq";
    private static final String TAG = "SeriesDjPlaylistSelectFragment";
    private String mSelectedPlaylist;
    private String mSeriesSeq;

    public static boolean access$000(SeriesDjPlaylistSelectFragment seriesDjPlaylistSelectFragment0, HttpResponse httpResponse0) {
        return seriesDjPlaylistSelectFragment0.prepareFetchComplete(httpResponse0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public ToolBar buildToolBar() {
        return ToolBar.f(((ToolBar)this.findViewById(0x7F0A0BC6)), 0x201);  // id:toolbar_layout
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new SelectAdapter(this, context0, null);
        ((j)j00).setMarkedMode(true);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.h0.buildUpon().appendQueryParameter("seriesSeq", this.mSeriesSeq).build().toString();
    }

    public static SeriesDjPlaylistSelectFragment newInstance(String s, String s1) {
        SeriesDjPlaylistSelectFragment seriesDjPlaylistSelectFragment0 = new SeriesDjPlaylistSelectFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argPlaylist", s);
        bundle0.putString("argSeriesSeq", s1);
        seriesDjPlaylistSelectFragment0.setArguments(bundle0);
        return seriesDjPlaylistSelectFragment0;
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
        return layoutInflater0.inflate(0x7F0D081A, viewGroup0, false);  // layout:series_djplaylist_select
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        SelectAdapter seriesDjPlaylistSelectFragment$SelectAdapter0 = (SelectAdapter)this.mAdapter;
        if(i.b.equals(i0)) {
            seriesDjPlaylistSelectFragment$SelectAdapter0.clear();
        }
        RequestBuilder.newInstance(new DjSeriesModifyListPlylstReq(this.getContext(), this.mSeriesSeq)).tag("SeriesDjPlaylistSelectFragment").listener(new Listener() {
            public void onResponse(DjSeriesModifyListPlylstRes djSeriesModifyListPlylstRes0) {
                if(!SeriesDjPlaylistSelectFragment.access$000(SeriesDjPlaylistSelectFragment.this, djSeriesModifyListPlylstRes0)) {
                    return;
                }
                SeriesDjPlaylistSelectFragment.this.performFetchComplete(i0, djSeriesModifyListPlylstRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((DjSeriesModifyListPlylstRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        this.mSelectedPlaylist = bundle0.getString("argPlaylist");
        this.mSeriesSeq = bundle0.getString("argSeriesSeq");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putString("argPlaylist", this.mSelectedPlaylist);
            bundle0.putString("argSeriesSeq", this.mSeriesSeq);
        }
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(ToolBarItem toolBar$ToolBarItem0, int v) {
        if(28 == v) {
            if(!this.isLoginUser()) {
                ToastManager.showShort(0x7F1308D1);  // string:retry_after_login "로그인 후 이용해 주세요."
                return;
            }
            FragmentActivity fragmentActivity0 = this.getActivity();
            if(fragmentActivity0 == null) {
                this.performBackPress();
                return;
            }
            ArrayList arrayList0 = this.getMarkedList(false).d;
            int v2 = arrayList0.size();
            SelectAdapter seriesDjPlaylistSelectFragment$SelectAdapter0 = (SelectAdapter)this.mAdapter;
            ArrayList arrayList1 = new ArrayList();
            for(int v1 = 0; v1 < v2; ++v1) {
                arrayList1.add(((DjPlayListInfoBase)seriesDjPlaylistSelectFragment$SelectAdapter0.getItem(((int)(((Integer)arrayList0.get(v1)))))));
            }
            ArrayList arrayList2 = SeriesDjPlaylist.getInstance().getDjPlaylistList();
            if(arrayList2 != null && !arrayList2.isEmpty()) {
                arrayList1.addAll(arrayList2);
            }
            SeriesDjPlaylist.getInstance().setDjPlaylistList(arrayList1);
            ToastManager.show(String.format(this.getString(0x7F130920), v2));  // string:series_folder_add_dj_playlist "%d개의 플레이리스트가 담겼습니다."
            if(fragmentActivity0.getParent() == null) {
                if(!TextUtils.isEmpty(this.mSeriesSeq)) {
                    TimeExpiredCache.getInstance().removeLike(MelonContentUris.j0.toString());
                }
                fragmentActivity0.setResult(-1);
            }
            else {
                fragmentActivity0.getParent().setResult(-1);
            }
            fragmentActivity0.getOnBackPressedDispatcher().c();
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = (TitleBar)view0.findViewById(0x7F0A0BAD);  // id:titlebar
        titleBar0.a(a.s(1));
        titleBar0.setTitle(this.getString(0x7F13065B));  // string:melondj_select_djplaylist "DJ플레이리스트 선택"
        titleBar0.f(true);
    }
}

