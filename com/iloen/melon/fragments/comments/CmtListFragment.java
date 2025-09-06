package com.iloen.melon.fragments.comments;

import B.a;
import J8.K1;
import U4.x;
import a9.b;
import a9.d;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.w0;
import b3.Z;
import com.android.volley.Response.Listener;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.DetailLinearLayoutManager;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.net.v3x.comments.CmtTypes.SortType;
import com.iloen.melon.net.v3x.comments.ListCmtReq.Params;
import com.iloen.melon.net.v3x.comments.ListCmtReq;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnReq;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v4x.request.CmtPvLogDummyReq;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.CompatUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.List;
import v9.c;
import v9.e;
import v9.h;
import v9.i;

public class CmtListFragment extends CmtBaseFragment implements View.OnClickListener {
    class CmtListAdapter extends p {
        public CmtListAdapter(Context context0, List list0, MetaContentBaseFragment metaContentBaseFragment0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(String s, i i0, HttpResponse httpResponse0) {
            if(!(httpResponse0 instanceof ListCmtRes)) {
                return false;
            }
            if(((ListCmtRes)httpResponse0).result == null) {
                return false;
            }
            CmtResViewModel cmtResViewModel0 = new CmtResViewModel();
            cmtResViewModel0.databindCmtListBase(((ListCmtRes)httpResponse0).result.toplist, CmtListFragment.this.mParam.chnlSeq, CmtListFragment.this.mParam.contsRefValue, CmtListFragment.this.mParam.isReadOnly, CmtListFragment.this.mLoadPgnRes.result.chnlinfo.reprtuseflag);
            cmtResViewModel0.databindCmtListBase(((ListCmtRes)httpResponse0).result.cmtlist, CmtListFragment.this.mParam.chnlSeq, CmtListFragment.this.mParam.contsRefValue, CmtListFragment.this.mParam.isReadOnly, CmtListFragment.this.mLoadPgnRes.result.chnlinfo.reprtuseflag);
            this.addAll(cmtResViewModel0.result.cmtlist);
            this.setHasMore(((ListCmtRes)httpResponse0).result.pageinfo.pageno < ((ListCmtRes)httpResponse0).result.paginginfo.nextpageno);
            this.setMenuId(((ListCmtRes)httpResponse0).getMenuId());
            this.updateModifiedTime(s);
            return false;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            cmtList cmtResViewModel$result$cmtList0 = (cmtList)this.getItem(v1);
            if(o00 instanceof CmtBaseViewHolder) {
                ((CmtBaseViewHolder)o00).bindView(cmtResViewModel$result$cmtList0, v, v1);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return new CommentListRenewalViewHolder(K1.a(LayoutInflater.from(this.getContext()), viewGroup0), CmtListFragment.this);
        }
    }

    public static class Param extends com.iloen.melon.fragments.comments.CmtBaseFragment.Param {
        public boolean hasParentLink;
        public String headerTitle;
        private static final long serialVersionUID = 0xA49074A8378709B0L;
        public boolean showMiniPlayer;
        public boolean showTitle;

        public Param() {
            this.showTitle = false;
            this.showMiniPlayer = true;
            this.headerTitle = "";
            this.hasParentLink = false;
        }

        @Override  // com.iloen.melon.fragments.comments.CmtBaseFragment$Param
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 == null || this.getClass() != object0.getClass() || !super.equals(object0)) {
                return false;
            }
            if(this.showTitle != ((Param)object0).showTitle) {
                return false;
            }
            if(this.showMiniPlayer != ((Param)object0).showMiniPlayer) {
                return false;
            }
            String s = this.headerTitle;
            String s1 = ((Param)object0).headerTitle;
            return s == null ? s1 == null : s.equals(s1);
        }

        @Override  // com.iloen.melon.fragments.comments.CmtBaseFragment$Param
        public int hashCode() {
            int v = ((super.hashCode() * 0x1F + this.showTitle) * 0x1F + this.showMiniPlayer) * 0x1F;
            return this.headerTitle == null ? v : v + this.headerTitle.hashCode();
        }

        @Override  // com.iloen.melon.fragments.comments.CmtBaseFragment$Param
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("Param{");
            stringBuilder0.append(super.toString());
            stringBuilder0.append("showTitle=");
            stringBuilder0.append(this.showTitle);
            stringBuilder0.append(", showMiniPlayer=");
            stringBuilder0.append(this.showMiniPlayer);
            stringBuilder0.append(", headerTitle=\'");
            return x.m(stringBuilder0, this.headerTitle, "\'}");
        }
    }

    public static final String TAG = "CmtListFragment";
    private boolean bInitialHeader;
    protected int mCmtAllCount;
    protected int mCurrentFilterIndex;
    protected int mFilterType;
    private int mNextPageNo;
    private OnCmtRemoveListener mOnCmtRemoveListener;
    protected int mOrderBy;
    private int mRadioTheme;
    protected int mSortType;
    private SortingBarView mSortingBarView;
    private TextView mTvChannelName;
    private TextView mTvCmtAllCount;
    private TextView mTvCmtRefresh;
    private TextView mTvCmtWrite;

    public CmtListFragment() {
        this.mSortType = 0;
        this.mOrderBy = 0;
        this.mCurrentFilterIndex = 0;
        this.mFilterType = 0;
        this.mNextPageNo = 1;
        this.mCmtAllCount = 0;
        this.mRadioTheme = 0;
        this.bInitialHeader = true;
        this.mOnCmtRemoveListener = new OnCmtRemoveListener() {
            @Override  // com.iloen.melon.fragments.comments.CmtBaseFragment$OnCmtRemoveListener
            public void onDataChanged() {
            }

            @Override  // com.iloen.melon.fragments.comments.CmtBaseFragment$OnCmtRemoveListener
            public void onRemoveItem() {
                CmtListFragment.this.updateCmtAllCount(CmtListFragment.this.mCmtAllCount - 1);
            }
        };
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public View buildParallaxHeaderView() {
        LogU.d("CmtListFragment", "buildParallaxHeaderView: Layout theme = " + this.mParam.theme);
        int v = this.isRadio() ? 0x7F0D013B : 0x7F0D013A;  // layout:cmt_list_header_radio
        View view0 = LayoutInflater.from(this.getContext()).inflate(v, null, false);
        if(this.isRadio()) {
            TextView textView0 = (TextView)view0.findViewById(0x7F0A0C34);  // id:tv_channelname
            this.mTvChannelName = textView0;
            ViewUtils.setText(textView0, ((Param)this.mParam).headerTitle);
        }
        SortingBarView sortingBarView0 = (SortingBarView)view0.findViewById(0x7F0A0AB8);  // id:sort_bar
        this.mSortingBarView = sortingBarView0;
        if(sortingBarView0 != null) {
            sortingBarView0.setOnSortSelectionListener(new d() {
                @Override  // a9.d
                public void onSelected(int v) {
                    CmtListFragment cmtListFragment0 = CmtListFragment.this;
                    if(v == cmtListFragment0.mSortType) {
                        return;
                    }
                    cmtListFragment0.mSortType = v;
                    CmtListFragment.this.mOrderBy = cmtListFragment0.isRecomAvailable() ? SortType.Normal[v] : SortType.WithoutRecom[v];
                    CmtListFragment.this.clearData();
                    CmtListFragment.this.clearListItems();
                    CmtListFragment.this.startFetch("onSortSelected");
                }
            });
            this.mSortingBarView.setSelection(this.mSortType);
        }
        this.mTvCmtAllCount = (TextView)view0.findViewById(0x7F0A0C3C);  // id:tv_cmt_count
        this.updateCmtAllCount(this.mCmtAllCount);
        TextView textView1 = (TextView)view0.findViewById(0x7F0A0C45);  // id:tv_cmt_refresh
        this.mTvCmtRefresh = textView1;
        ViewUtils.setOnClickListener(textView1, this);
        TextView textView2 = (TextView)view0.findViewById(0x7F0A0C46);  // id:tv_cmt_write
        this.mTvCmtWrite = textView2;
        ViewUtils.setOnClickListener(textView2, this);
        return view0;
    }

    private void clearData() {
        this.updateCmtAllCount(this.mCmtAllCount);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new CmtListAdapter(this, context0, null, this);
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.f = this.getString(0x7F1301E0);  // string:cmt_empty_text "등록된 댓글이 없습니다."
        ((p)j00).setEmptyViewInfo(e0);
        return j00;
    }

    private void executeListCmtReq(i i0) {
        if(i.b.equals(i0) && !this.isChildFragment()) {
            this.updateParallaxTranslation(0);
            this.updateHeaderRatio(this.getRatioHeaderHeight());
        }
        Params listCmtReq$Params0 = new Params();
        listCmtReq$Params0.chnlSeq = this.mParam.chnlSeq;
        listCmtReq$Params0.contsRefValue = this.mParam.contsRefValue;
        listCmtReq$Params0.pageNo = this.mNextPageNo;
        listCmtReq$Params0.pageSize = 15;
        listCmtReq$Params0.sortType = this.mOrderBy;
        listCmtReq$Params0.srchType = -1;
        listCmtReq$Params0.filterType = this.mFilterType;
        result loadPgnRes$result0 = this.mLoadPgnRes.result;
        if(loadPgnRes$result0 != null && loadPgnRes$result0.paginginfo != null) {
            listCmtReq$Params0.startSeq = loadPgnRes$result0.pageinfo.startseq;
        }
        RequestBuilder.newInstance(new ListCmtReq(this.getContext(), listCmtReq$Params0)).tag(this.getRequestTag()).listener(new Listener() {
            public void onResponse(ListCmtRes listCmtRes0) {
                if(!CmtListFragment.this.prepareFetchComplete(listCmtRes0)) {
                    return;
                }
                if(listCmtRes0.isSuccessful() && CmtListFragment.this.isLoadPgnResValid("executeListCmtReq")) {
                    CmtListFragment.this.updateCmtAllCount(listCmtRes0.result.pageinfo.validcnt);
                    CmtListFragment.x0(CmtListFragment.this, listCmtRes0.result.paginginfo.nextpageno);
                    CmtListFragment.this.performFetchComplete(i0, listCmtRes0);
                    CmtListFragment.this.updateSortBarView();
                    return;
                }
                CmtListFragment.this.performCmtFetchErrorToast(listCmtRes0.errormessage);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((ListCmtRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
    }

    private float getAlphaValue(float f) {
        if(((double)f) < 0.1) {
            return 1.0f;
        }
        return ((double)f) > 0.4 ? 0.0f : 0.5f - f;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.g.buildUpon().appendPath("cmtlist").appendQueryParameter("chnlSeq", String.valueOf(this.mParam.chnlSeq)).appendQueryParameter("contsRef", this.mParam.contsRefValue).build().toString();
    }

    public int getCmtAllCount() {
        return this.mCmtAllCount;
    }

    private w0 getLayoutManger() {
        return this.getParentFragment() instanceof b ? new DetailLinearLayoutManager(this.getActivity()) : new LinearLayoutManager(this.getActivity());
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 40.0f);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        float f = this.mSortingBarView == null || this.mSortingBarView.getVisibility() != 0 ? 40.0f : 97.0f;
        if(this.isRadio()) {
            f += 44.0f;
        }
        return ScreenUtils.dipToPixel(this.getContext(), f);
    }

    public CmtPvLogDummyReq getPvDummyLogRequest() {
        com.iloen.melon.net.v4x.request.CmtPvLogDummyReq.Params cmtPvLogDummyReq$Params0 = new com.iloen.melon.net.v4x.request.CmtPvLogDummyReq.Params();
        cmtPvLogDummyReq$Params0.type = "list";
        cmtPvLogDummyReq$Params0.chnlSeq = String.valueOf(this.mParam.chnlSeq);
        cmtPvLogDummyReq$Params0.cmtSeq = null;
        cmtPvLogDummyReq$Params0.contsRefValue = this.mParam.contsRefValue;
        return new CmtPvLogDummyReq(this.getContext(), cmtPvLogDummyReq$Params0);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public PvLogDummyReq getPvDummyLogRequest() {
        return this.getPvDummyLogRequest();
    }

    public int getRadioTheme() {
        return this.mRadioTheme;
    }

    private boolean isRadio() {
        return this.mParam != null && this.mParam.theme == c.b;
    }

    // 去混淆评级： 低(20)
    public boolean isRecomAvailable() {
        return this.isLoadPgnResValid("isRecomAvailable") ? this.mLoadPgnRes.result.chnlinfo.recmuseflag : true;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public boolean isRecyclerViewBelowTitleBar() {
        return this.mParam == null ? false : ((Param)this.mParam).showTitle;
    }

    public static CmtListFragment newInstance(Param cmtListFragment$Param0) {
        CmtListFragment cmtListFragment0 = new CmtListFragment();
        Bundle bundle0 = new Bundle();
        cmtListFragment$Param0.theme = c.c;
        bundle0.putSerializable("argCmtParam", cmtListFragment$Param0);
        cmtListFragment0.setArguments(bundle0);
        return cmtListFragment0;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == this.mTvCmtWrite) {
            this.openCmtWriteView();
            return;
        }
        if(view0 == this.mTvCmtRefresh) {
            this.refreshList();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
        LogU.d("CmtListFragment", "onCreate()");
        super.onCreate(bundle0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(this.getLayoutManger());
        recyclerView0.setAdapter(this.mAdapter);
        recyclerView0.addItemDecoration(new LastItemSpacingDecoration());
        LogU.d("CmtListFragment", "onCreateRecyclerView: Layout theme = " + this.mParam.theme);
        return recyclerView0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        Z.w("onFetchStart reason:", s, "CmtListFragment");
        if(i.b.equals(i0)) {
            this.resetScrollPosition();
            com.iloen.melon.net.v3x.comments.LoadPgnReq.Params loadPgnReq$Params0 = new com.iloen.melon.net.v3x.comments.LoadPgnReq.Params();
            loadPgnReq$Params0.chnlSeq = this.mParam.chnlSeq;
            loadPgnReq$Params0.contsRefValue = this.mParam.contsRefValue;
            loadPgnReq$Params0.filterType = this.mFilterType;
            RequestBuilder.newInstance(new LoadPgnReq(this.getContext(), loadPgnReq$Params0)).tag(this.getRequestTag()).listener(new Listener() {
                public void onResponse(LoadPgnRes loadPgnRes0) {
                    result loadPgnRes$result0 = loadPgnRes0.result;
                    if(loadPgnRes$result0 == null) {
                        CmtListFragment.this.performCmtFetchErrorToast(loadPgnRes0.errormessage);
                        return;
                    }
                    CmtListFragment.this.mLoadPgnRes = loadPgnRes0;
                    CmtListFragment.this.mNextPageNo = loadPgnRes$result0.paginginfo.firstpageno;
                    CmtListFragment cmtListFragment0 = CmtListFragment.this;
                    if(cmtListFragment0.mLoadPgnRes.result.chnlinfo.blindContsCmtListFlag) {
                        String s = CmtListFragment.this.mLoadPgnRes.result.chnlinfo.blindContsDsplyText;
                        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
                        e0.d = -1;
                        e0.e = -1;
                        e0.g = -1;
                        e0.i = -1;
                        e0.k = -1;
                        e0.l = -1;
                        e0.f = s;
                        ((CmtListAdapter)cmtListFragment0.mAdapter).setEmptyViewInfo(e0);
                        CmtListFragment.this.performFetchCompleteOnlyViews();
                        return;
                    }
                    cmtListFragment0.executeListCmtReq(i0);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((LoadPgnRes)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        this.executeListCmtReq(i0);
        return true;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        com.iloen.melon.fragments.comments.CmtBaseFragment.Param cmtBaseFragment$Param0 = (com.iloen.melon.fragments.comments.CmtBaseFragment.Param)CompatUtils.getSerializable(bundle0, "argCmtParam", Param.class);
        this.mParam = cmtBaseFragment$Param0;
        if(cmtBaseFragment$Param0 != null) {
            ((Param)cmtBaseFragment$Param0).cacheKeyOfCmtList = this.getCacheKey();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putSerializable("argCmtParam", this.mParam);
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            Param cmtListFragment$Param0 = (Param)this.mParam;
            if(cmtListFragment$Param0.showTitle) {
                titleBar0.a(a.s(1));
                titleBar0.setTitle((TextUtils.isEmpty(cmtListFragment$Param0.headerTitle) ? "댓글" : cmtListFragment$Param0.headerTitle));
                titleBar0.f(true);
            }
            else {
                ViewUtils.hideWhen(titleBar0, true);
            }
        }
        this.updateSortBarView();
        this.addOnCmtRemoveListener(this.mOnCmtRemoveListener);
    }

    public void refreshList() {
        this.clearData();
        this.clearListItems();
        this.notifyCommentDataChanged();
        this.startFetch();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return ((Param)this.mParam).showMiniPlayer;
    }

    public void updateCmtAllCount(int v) {
        this.mCmtAllCount = v;
        TextView textView0 = this.mTvCmtAllCount;
        if(textView0 != null) {
            textView0.setText(StringUtils.getCountFormattedString(v));
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void updateHeaderRatio(float f) {
        super.updateHeaderRatio(f);
        if(this.bInitialHeader) {
            this.bInitialHeader = false;
            return;
        }
        if(this.mParam.theme == c.b) {
            TextView textView0 = this.mTvChannelName;
            if(textView0 != null) {
                textView0.setAlpha(this.getAlphaValue(f));
            }
        }
    }

    public void updateSortBarView() {
        boolean z = true;
        int v = this.getMelonArrayAdapter().getList().size();
        if(this.mSortingBarView != null) {
            if(this.isRecomAvailable()) {
                this.mSortingBarView.setItems(this.getResources().getStringArray(0x7F030049));  // array:sortingbar_review
                this.mSortingBarView.setSortBarStyle(2);
            }
            else {
                this.mSortingBarView.setItems(this.getResources().getStringArray(0x7F03004A));  // array:sortingbar_review_without_recom
                this.mSortingBarView.setSortBarStyle(1);
            }
            this.mSortingBarView.setSelection(this.mSortType);
            SortingBarView sortingBarView0 = this.mSortingBarView;
            if(v <= 0) {
                z = false;
            }
            ViewUtils.showWhen(sortingBarView0, z);
        }
        this.updateParallaxHeaderView();
    }
}

