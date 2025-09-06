package com.iloen.melon.fragments.mymusic;

import B.a;
import B9.q;
import B9.t;
import B9.u;
import F8.G;
import F8.m;
import H0.e;
import J8.Q1;
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
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v5x.request.DjSeriesDeleteReq;
import com.iloen.melon.net.v5x.response.DjSeriesDeleteRes;
import com.iloen.melon.net.v6x.request.DjSeriesInformReq;
import com.iloen.melon.net.v6x.response.DjSeriesInformRes.RESPONSE.SERIESPLAYLIST;
import com.iloen.melon.net.v6x.response.DjSeriesInformRes.RESPONSE;
import com.iloen.melon.net.v6x.response.DjSeriesInformRes;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.ui.K1;
import com.melon.ui.k2;
import com.melon.ui.popup.b;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;
import va.e0;
import va.o;
import vd.E;
import zd.M;
import zd.x;

public class SeriesFolderDetailFragment extends MetaContentBaseFragment implements OnCheckMyself {
    class DetailAdapter extends p {
        class EmptyViewHolder extends O0 {
            private View emptyLayout;
            private TextView emptyTv;

            public EmptyViewHolder(View view0) {
                super(view0);
                this.emptyLayout = view0.findViewById(0x7F0A042B);  // id:empty_layout
                TextView textView0 = (TextView)view0.findViewById(0x7F0A042F);  // id:empty_text
                this.emptyTv = textView0;
                textView0.setText(SeriesFolderDetailFragment.this.getString(0x7F13065E));  // string:melondj_series_folder_empty "시리즈 플레이리스트에 담긴\n플레이리스트가 없습니다."
                ViewUtils.showWhen(this.emptyLayout, true);
            }
        }

        class ServerDataWrapper {
            public Object data;
            public int viewType;

            private ServerDataWrapper() {
            }

            public ServerDataWrapper(int v) {
            }
        }

        class TopViewHolder extends O0 {
            private TextView titleTv;

            public TopViewHolder(View view0) {
                super(view0);
                this.titleTv = (TextView)view0.findViewById(0x7F0A0BAA);  // id:title_tv
            }
        }

        private static final int VIEW_TYPE_EMPTY_VIEW = 3;
        private static final int VIEW_TYPE_PLAYLIST = 2;
        private static final int VIEW_TYPE_TOP = 1;
        private t listener;

        public DetailAdapter(Context context0, List list0, t t0) {
            super(context0, list0);
            this.listener = t0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            Object object0 = this.getItem(v1);
            if(object0 instanceof ServerDataWrapper) {
                return ((ServerDataWrapper)object0).viewType;
            }
            if(object0 instanceof DjPlayListInfoBase) {
                return 2;
            }
            return !(object0 instanceof String) || !"EMPTY_VIEW".equals(((String)object0)) ? -1 : 3;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(String s, i i0, HttpResponse httpResponse0) {
            if(httpResponse0 instanceof DjSeriesInformRes && ((DjSeriesInformRes)httpResponse0) != null) {
                RESPONSE djSeriesInformRes$RESPONSE0 = ((DjSeriesInformRes)httpResponse0).response;
                if(djSeriesInformRes$RESPONSE0 != null) {
                    this.setMenuId(djSeriesInformRes$RESPONSE0.menuId);
                    this.updateModifiedTime(this.getCacheKey());
                    this.setHasMore(false);
                    SERIESPLAYLIST djSeriesInformRes$RESPONSE$SERIESPLAYLIST0 = ((DjSeriesInformRes)httpResponse0).response.seriesPlaylist;
                    if(djSeriesInformRes$RESPONSE$SERIESPLAYLIST0 != null) {
                        ServerDataWrapper seriesFolderDetailFragment$DetailAdapter$ServerDataWrapper0 = new ServerDataWrapper(this, 0);
                        seriesFolderDetailFragment$DetailAdapter$ServerDataWrapper0.data = djSeriesInformRes$RESPONSE$SERIESPLAYLIST0.plylstTitle;
                        seriesFolderDetailFragment$DetailAdapter$ServerDataWrapper0.viewType = 1;
                        this.add(seriesFolderDetailFragment$DetailAdapter$ServerDataWrapper0);
                        SeriesFolderDetailFragment.this.playlistTitle = djSeriesInformRes$RESPONSE$SERIESPLAYLIST0.plylstTitle;
                        SeriesFolderDetailFragment.this.ownerMemberKey = djSeriesInformRes$RESPONSE$SERIESPLAYLIST0.ownerMemberKey;
                        SeriesFolderDetailFragment.this.updateTitleBar();
                        ArrayList arrayList0 = djSeriesInformRes$RESPONSE$SERIESPLAYLIST0.djPlaylistList;
                        if(arrayList0 != null && !arrayList0.isEmpty()) {
                            this.addAll(arrayList0);
                            return true;
                        }
                        this.add("EMPTY_VIEW");
                    }
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            boolean z = true;
            switch(o00.getItemViewType()) {
                case 1: {
                    String s = (String)((ServerDataWrapper)this.getItem(v1)).data;
                    if(s != null && !s.isEmpty()) {
                        s = s.replaceAll("\n+", " ");
                    }
                    ((TopViewHolder)o00).titleTv.setText(s);
                    return;
                }
                case 2: {
                    DjPlayListInfoBase djPlayListInfoBase0 = (DjPlayListInfoBase)this.getItem(v1);
                    ((u)o00).c(djPlayListInfoBase0, v1, this.listener, true);
                    Q1 q10 = (Q1)((u)o00).a.f;
                    ImageView imageView0 = ((u)o00).a.c;
                    ViewUtils.showWhen(q10.c, djPlayListInfoBase0.withOfficialSeries);
                    ViewUtils.showWhen(q10.k, true);
                    q10.k.setText(djPlayListInfoBase0.songcnt + SeriesFolderDetailFragment.this.getString(0x7F130A63));  // string:song "곡"
                    if(TextUtils.isEmpty(SeriesFolderDetailFragment.this.ownerMemberKey) || !SeriesFolderDetailFragment.this.ownerMemberKey.equals(djPlayListInfoBase0.ownermemberkey)) {
                        z = false;
                    }
                    ViewUtils.showWhen(imageView0, z);
                    imageView0.setOnClickListener(new View.OnClickListener() {
                        @Override  // android.view.View$OnClickListener
                        public void onClick(View view0) {
                            SeriesFolderDetailFragment.this.showContextPopupDjPlaylist(djPlayListInfoBase0);
                        }
                    });
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            switch(v) {
                case 1: {
                    return new TopViewHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D081B, viewGroup0, false));  // layout:series_folder_detail_top
                }
                case 2: {
                    return e.P(viewGroup0, q.d);
                }
                case 3: {
                    return new EmptyViewHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D0022, viewGroup0, false));  // layout:adapter_empty_view
                }
                default: {
                    return null;
                }
            }
        }
    }

    private static final String ARG_SERIES_SEQ = "argSeriesSeq";
    private static final String EMPTY_VIEW = "EMPTY_VIEW";
    private static final String TAG = "SeriesFolderDetailFragment";
    private String ownerMemberKey;
    private String playlistTitle;
    private String seriesSeq;

    public SeriesFolderDetailFragment() {
        this.ownerMemberKey = "";
        this.playlistTitle = "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return new DetailAdapter(this, context0, null, new t() {
            @Override  // B9.t
            public void clickBody(@Nullable DjPlayListInfoBase djPlayListInfoBase0, int v) {
                if(djPlayListInfoBase0 != null) {
                    Navigator.openDjPlaylistDetail(djPlayListInfoBase0.plylstseq);
                }
            }

            @Override  // B9.t
            public void clickThumbnail(@Nullable DjPlayListInfoBase djPlayListInfoBase0, int v) {
                if(djPlayListInfoBase0 != null) {
                    Navigator.openDjPlaylistDetail(djPlayListInfoBase0.plylstseq);
                }
            }

            @Override  // B9.t
            public boolean longClickBody(@Nullable DjPlayListInfoBase djPlayListInfoBase0, int v) {
                if(djPlayListInfoBase0 != null) {
                    SeriesFolderDetailFragment.this.showContextPopupDjPlaylist(djPlayListInfoBase0);
                    return false;
                }
                return true;
            }

            @Override  // B9.t
            public void playDjPlaylist(@Nullable DjPlayListInfoBase djPlayListInfoBase0, int v) {
                if(djPlayListInfoBase0 != null) {
                    String s = djPlayListInfoBase0.plylstseq;
                    String s1 = djPlayListInfoBase0.contsTypeCode;
                    String s2 = SeriesFolderDetailFragment.this.getMenuId();
                    SeriesFolderDetailFragment.this.playPlaylist(s, s1, s2, djPlayListInfoBase0.statsElements);
                }
            }
        });
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.i0.buildUpon().appendQueryParameter("seriesSeq", this.seriesSeq).build().toString();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.mymusic.OnCheckMyself
    public boolean isMyself() {
        return !TextUtils.isEmpty(this.ownerMemberKey) && e1.u.v(((e0)o.a()).j()).equals(this.ownerMemberKey);
    }

    private H lambda$showEditPopup$0(String s) {
        this.requestDeleteSeries(s);
        return null;
    }

    private H lambda$showEditPopup$1(String s, k2 k20) {
        if(k20 instanceof K1) {
            M m0 = ((K1)k20).b.a;
            if(m0.equals(M.x0)) {
                Navigator.open(SeriesPlaylistMakeFragment.newInstance(s, false));
                return null;
            }
            if(m0.equals(M.y0)) {
                List list0 = ((DetailAdapter)this.mAdapter).getList();
                int v1 = 0;
                for(int v = 0; v < list0.size(); ++v) {
                    if(list0.get(v) instanceof DjPlayListInfoBase) {
                        ++v1;
                    }
                }
                b.w(this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString((v1 <= 0 ? 0x7F1300BA : 0x7F1300BB)), true, false, false, this.getString(0x7F130199), this.getString(0x7F130227), new i0(this, s), null, null, E.a);  // string:alert_dlg_title_info "안내"
            }
        }
        return null;
    }

    public static SeriesFolderDetailFragment newInstance(String s) {
        SeriesFolderDetailFragment seriesFolderDetailFragment0 = new SeriesFolderDetailFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argSeriesSeq", s);
        seriesFolderDetailFragment0.setArguments(bundle0);
        return seriesFolderDetailFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setAdapter(this.mAdapter);
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView0.setPadding(recyclerView0.getPaddingLeft(), ScreenUtils.dipToPixel(this.getContext(), 4.0f), recyclerView0.getPaddingRight(), recyclerView0.getPaddingBottom());
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D0206, viewGroup0, false);  // layout:detail_contents_fragment
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        RequestBuilder.newInstance(new DjSeriesInformReq(this.getContext(), this.seriesSeq, false)).tag("SeriesFolderDetailFragment").listener(new Listener() {
            public void onResponse(DjSeriesInformRes djSeriesInformRes0) {
                if(!SeriesFolderDetailFragment.this.prepareFetchComplete(djSeriesInformRes0)) {
                    return;
                }
                SeriesFolderDetailFragment.this.performFetchComplete(i0, djSeriesInformRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((DjSeriesInformRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        this.seriesSeq = bundle0.getString("argSeriesSeq");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putString("argSeriesSeq", this.seriesSeq);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.updateTitleBar();
    }

    private void requestDeleteSeries(String s) {
        RequestBuilder.newInstance(new DjSeriesDeleteReq(this.getContext(), s)).tag("SeriesFolderDetailFragment").listener(new Listener() {
            public void onResponse(DjSeriesDeleteRes djSeriesDeleteRes0) {
                if(SeriesFolderDetailFragment.this.isFragmentValid() && djSeriesDeleteRes0 != null && djSeriesDeleteRes0.isSuccessful()) {
                    TimeExpiredCache.getInstance().removeLike(MelonContentUris.X.toString());
                    TimeExpiredCache.getInstance().removeLike(MelonContentUris.Y.toString());
                    SeriesFolderDetailFragment.this.performBackPress();
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((DjSeriesDeleteRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }).request();
    }

    // 检测为 Lambda 实现
    private void showEditPopup(String s) [...]

    private void updateTitleBar() {
        if(this.isFragmentValid()) {
            TitleBar titleBar0 = this.getTitleBar();
            if(this.isMyself()) {
                m m0 = new m(2, false);
                F8.p p0 = new F8.p(1);
                G g0 = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
                g0.c = (/* 缺少LAMBDA参数 */) -> {
                    if(!SeriesFolderDetailFragment.this.isFragmentValid() || !SeriesFolderDetailFragment.this.isPossiblePopupShow()) {
                        return;
                    }
                    if(TextUtils.isEmpty(SeriesFolderDetailFragment.this.seriesSeq)) {
                        LogU.w("SeriesFolderDetailFragment", "showContextPopup() invalid seriesSeq");
                        return;
                    }
                    ArrayList arrayList0 = new ArrayList();
                    arrayList0.add(x.R);
                    arrayList0.add(x.S);
                    b.u(SeriesFolderDetailFragment.this.getChildFragmentManager(), SeriesFolderDetailFragment.this.getString(0x7F130CB6), arrayList0, new com.iloen.melon.fragments.mymusic.o(1, SeriesFolderDetailFragment.this, SeriesFolderDetailFragment.this.seriesSeq));  // string:text_series_playlist_edit "시리즈 플레이리스트 편집"
                };
                F8.o[] arr_o = {m0, p0, g0};
                F8.o o0 = null;
                for(int v = 0; v < 3; ++v) {
                    F8.o o1 = arr_o[v];
                    if(o0 == null) {
                        o0 = o1;
                    }
                    else {
                        o0.g(o1);
                    }
                }
                titleBar0.a(o0);
                titleBar0.setTitle(this.getString(0x7F13091F));  // string:series_folder "시리즈 플레이리스트"
                return;
            }
            titleBar0.a(a.s(1));
            titleBar0.setTitle(this.getString(0x7F13091F));  // string:series_folder "시리즈 플레이리스트"
        }

        class com.iloen.melon.fragments.mymusic.SeriesFolderDetailFragment.1 implements View.OnClickListener {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                SeriesFolderDetailFragment.this.showEditPopup(SeriesFolderDetailFragment.this.seriesSeq);
            }
        }

    }
}

