package com.iloen.melon.fragments;

import L4.h;
import P4.a;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AbsListView;
import androidx.fragment.app.I;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.W0;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.w0;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.volley.NetworkError;
import com.android.volley.Request.Priority;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.adapters.common.B;
import com.iloen.melon.adapters.common.C;
import com.iloen.melon.adapters.common.e;
import com.iloen.melon.adapters.common.g;
import com.iloen.melon.adapters.common.l;
import com.iloen.melon.adapters.common.n;
import com.iloen.melon.adapters.common.w;
import com.iloen.melon.adapters.common.x;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.settings.SettingMainFragment;
import com.iloen.melon.net.HttpConnectionError;
import com.iloen.melon.net.HttpResponse.Notification.Buttons;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.HttpResponseError;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.VolleyRequest;
import com.iloen.melon.net.v4x.common.NotificationActionTypeHelper;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v4x.response.PvLogDummyRes;
import com.iloen.melon.task.ReportService;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.MenuIdQueue;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.ui.EmptyOrErrorViewHelper;
import com.iloen.melon.utils.ui.ViewUtils;
import p8.r;
import v9.i;
import v9.o;

public abstract class FetcherBaseFragment extends MelonAdapterViewBaseFragment implements h, w {
    protected static final String ARG_PREVENT_DEFAULT_FETCHER = "argPreventDefaultFetcher";
    public static final long EXPIRED_TIME_LIMIT = 0L;
    private static final String TAG = "FetcherBaseFragment";
    protected final View.OnClickListener mConfirmButtonListener;
    private Handler mFetchHandler;
    private final AbsListView.OnScrollListener mListViewScrollListener;
    private x mPersonalizedInfoAdapter;
    protected boolean mPreventDefaultFetcher;
    protected ErrorListener mResponseErrorListener;
    protected final View.OnClickListener mRetryButtonListener;
    private final g mScrollListener;
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected static final v9.h sFragmentVisibilityChangedParam;

    static {
        FetcherBaseFragment.EXPIRED_TIME_LIMIT = a.a * 5L;
        FetcherBaseFragment.sFragmentVisibilityChangedParam = new v9.h("onFragmentVisibilityChanged");
    }

    public FetcherBaseFragment() {
        this.mFetchHandler = new Handler(Looper.getMainLooper());
        this.mScrollListener = new g() {
            @Override  // com.iloen.melon.adapters.common.g
            public void onLastItemVisibleChanged(RecyclerView recyclerView0, boolean z) {
                if(z) {
                    Object object0 = FetcherBaseFragment.this.getContentAdapter();
                    l l0 = FetcherBaseFragment.this.getLoadMore();
                    n n0 = FetcherBaseFragment.this.getLoadMoreView();
                    if(l0 != null && n0 != null && l0.hasMore() && !n0.isLoadingShowing()) {
                        LogU.v("FetcherBaseFragment", "onLastItemVisible()");
                        FetcherBaseFragment.this.startFetch(i.c, v9.h.b, false, "onLoadMore");
                        if(recyclerView0 != null && !recyclerView0.isComputingLayout()) {
                            recyclerView0.post(new com.iloen.melon.fragments.l(n0, 0));
                        }
                        if(recyclerView0 != null && object0 instanceof j0) {
                            recyclerView0.scrollToPosition(((j0)object0).getItemCount());
                        }
                    }
                }
            }

            @Override  // com.iloen.melon.adapters.common.g
            public void onParallax(float f) {
            }

            @Override  // com.iloen.melon.adapters.common.g
            public void onScrollDown() {
            }

            @Override  // com.iloen.melon.adapters.common.g
            public void onScrollStateChanged(RecyclerView recyclerView0, int v) {
                super.onScrollStateChanged(recyclerView0, v);
                if(v == 0) {
                    FetcherBaseFragment.this.performFetchPersonalizedInfo();
                }
                Object object0 = FetcherBaseFragment.this.getContentAdapter();
                if(object0 instanceof C) {
                    ((C)object0).onChangedScrollState(v);
                }
            }

            @Override  // com.iloen.melon.adapters.common.g
            public void onScrollUp() {
            }
        };
        this.mListViewScrollListener = new AbsListView.OnScrollListener() {
            private int mLastVisibleItemIndex;

            {
                this.mLastVisibleItemIndex = -1;
            }

            private void onLastItemVisible() {
                Object object0 = FetcherBaseFragment.this.getContentAdapter();
                l l0 = FetcherBaseFragment.this.getLoadMore();
                n n0 = FetcherBaseFragment.this.getLoadMoreView();
                if(l0 != null && n0 != null && l0.hasMore() && !n0.isLoadingShowing()) {
                    LogU.v("FetcherBaseFragment", "onLastItemVisible()");
                    FetcherBaseFragment.J(FetcherBaseFragment.this);
                    FetcherBaseFragment.this.startFetch(i.c, v9.h.b, false, "onLoadMore");
                    RecyclerView recyclerView0 = FetcherBaseFragment.this.mRecyclerView;
                    if(recyclerView0 != null && object0 instanceof j0) {
                        recyclerView0.scrollToPosition(((j0)object0).getItemCount());
                    }
                }
            }

            @Override  // android.widget.AbsListView$OnScrollListener
            public void onScroll(AbsListView absListView0, int v, int v1, int v2) {
                int v3 = v + v1;
                if(v1 > 0 && v3 + 1 >= v2 && v3 != this.mLastVisibleItemIndex) {
                    this.mLastVisibleItemIndex = v3;
                    this.onLastItemVisible();
                }
            }

            @Override  // android.widget.AbsListView$OnScrollListener
            public void onScrollStateChanged(AbsListView absListView0, int v) {
                Object object0 = FetcherBaseFragment.this.getContentAdapter();
                if(object0 instanceof C) {
                    ((C)object0).onChangedScrollState(v);
                }
            }
        };
        this.mConfirmButtonListener = new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                SettingMainFragment.Companion.newInstance(true).open();
            }
        };
        this.mRetryButtonListener = new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(NetUtils.isConnected()) {
                    v9.h h0 = new v9.h("RETRY_FROM_NETWORK_ERROR");
                    FetcherBaseFragment.this.startFetch(i.b, h0, true, "onRetryClick");
                    FetcherBaseFragment fetcherBaseFragment0 = FetcherBaseFragment.this;
                    View view1 = fetcherBaseFragment0.mEmptyView;
                    if(view1 != null) {
                        EmptyOrErrorViewHelper.hideNetworkErrorView(view1);
                        return;
                    }
                    Object object0 = fetcherBaseFragment0.getContentAdapter();
                    if(object0 instanceof e) {
                        ((e)object0).showErrorView(false);
                    }
                    return;
                }
                NetUtils.showNetworkInfoPopupIfNotConnected(FetcherBaseFragment.this.getContext());
            }
        };
        this.mResponseErrorListener = (VolleyError volleyError0) -> FetcherBaseFragment.this.performFetchError(volleyError0, false);
    }

    public static void J(FetcherBaseFragment fetcherBaseFragment0) {
        fetcherBaseFragment0.showLoadingMore(true);
    }

    public void addResponseInAdapter(i i0, HttpResponse httpResponse0) {
        Object object0 = this.getContentAdapter();
        if(!(object0 instanceof B)) {
            LogU.w("FetcherBaseFragment", "addResponseInAdapter() invalid adapter");
            return;
        }
        LogU.d("FetcherBaseFragment", "addResponseInAdapter() " + i0);
        ((B)object0).addResponse("", i0, httpResponse0);
        if(this.mHasPersonalizedContent && i.b.equals(i0) && httpResponse0 != null) {
            this.mFetchHandler.post(new Runnable() {
                @Override
                public void run() {
                    if(!FetcherBaseFragment.this.isFragmentValid()) {
                        return;
                    }
                    FetcherBaseFragment.this.performFetchPersonalizedInfo();
                }
            });
        }
    }

    public void bindSwipeRefreshLayout(int v) {
        SwipeRefreshLayout swipeRefreshLayout0 = (SwipeRefreshLayout)this.findViewById(v);
        if(swipeRefreshLayout0 != null) {
            swipeRefreshLayout0.setColorSchemeResources(new int[]{0x7F06017C});  // color:green500s_support_high_contrast
            swipeRefreshLayout0.setProgressBackgroundColorSchemeColor(ColorUtils.getColor(this.getContext(), 0x7F0604AA));  // color:white000s_support_high_contrast
            swipeRefreshLayout0.setOnRefreshListener(this);
            this.mSwipeRefreshLayout = swipeRefreshLayout0;
        }
    }

    public void bindSwipeRefreshLayout(int v, int v1, int v2) {
        SwipeRefreshLayout swipeRefreshLayout0 = (SwipeRefreshLayout)this.findViewById(v);
        if(swipeRefreshLayout0 != null) {
            swipeRefreshLayout0.setColorSchemeResources(new int[]{0x7F06017C});  // color:green500s_support_high_contrast
            swipeRefreshLayout0.B = true;
            swipeRefreshLayout0.N = v1;
            swipeRefreshLayout0.S = v2;
            swipeRefreshLayout0.h0 = true;
            swipeRefreshLayout0.f();
            swipeRefreshLayout0.c = false;
            swipeRefreshLayout0.setOnRefreshListener(this);
            this.mSwipeRefreshLayout = swipeRefreshLayout0;
        }
    }

    public void cancelRequest() {
        this.cancelRequest(this.getRequestTag());
    }

    public void cancelRequest(Object object0) {
        MelonAppBase.instance.getRequestQueue().cancelAll(object0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public AbsListView createAbsListView(int v) {
        AbsListView absListView0 = super.createAbsListView(v);
        if(absListView0 != null) {
            absListView0.setOnScrollListener(this.mListViewScrollListener);
        }
        return absListView0;
    }

    public long getExpiredTime() [...] // 潜在的解密器

    private l getLoadMore() {
        v8.a a0 = this.getViewModel();
        if(a0 != null) {
            return a0 instanceof l ? ((l)a0) : null;
        }
        Object object0 = this.getContentAdapter();
        return object0 instanceof l ? ((l)object0) : null;
    }

    private n getLoadMoreView() {
        Object object0 = this.getContentAdapter();
        return object0 instanceof n ? ((n)object0) : null;
    }

    public PvLogDummyReq getPvDummyLogRequest() {
        return null;
    }

    private String getPvLogUri(String s, String s1) {
        return HttpResponse.replacePvLogReservedWords(s, s1);
    }

    // 去混淆评级： 中等(60)
    public String getRequestTag() {
        return this.getClass().getName();
    }

    public v8.a getViewModel() {
        return null;
    }

    public boolean handleNotificationStatusWithEmptyView() {
        return false;
    }

    private void handleNotifyScreenNotification(i i0, HttpResponse httpResponse0) {
        String s1;
        String s;
        Notification httpResponse$Notification0 = httpResponse0.notification;
        com.iloen.melon.fragments.FetcherBaseFragment.4 fetcherBaseFragment$40 = null;
        if(httpResponse$Notification0 == null) {
            s = null;
            s1 = null;
        }
        else {
            s = httpResponse$Notification0.message;
            s1 = httpResponse$Notification0.subMessage;
        }
        if(TextUtils.isEmpty(s)) {
            s = "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요.";
        }
        i i1 = i.b;
        if(HttpResponse.hasNotificationButtons(httpResponse0) || !TextUtils.isEmpty(s1) || this.handleNotificationStatusWithEmptyView()) {
            Buttons httpResponse$Notification$Buttons0 = HttpResponse.getNotificationButton(httpResponse$Notification0.buttons, 0);
            String s2 = httpResponse$Notification$Buttons0 == null || httpResponse$Notification$Buttons0.linkUri == null ? null : httpResponse$Notification$Buttons0.label;
            v9.e e0 = new v9.e();  // 初始化器: Ljava/lang/Object;-><init>()V
            e0.d = -1;
            e0.e = -1;
            e0.g = -1;
            e0.i = -1;
            e0.k = -1;
            e0.l = -1;
            e0.f = s;
            e0.h = s1;
            e0.j = s2;
            if(httpResponse$Notification$Buttons0 != null) {
                fetcherBaseFragment$40 = new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        Buttons httpResponse$Notification$Buttons0 = httpResponse$Notification$Buttons0;
                        if(httpResponse$Notification$Buttons0 != null) {
                            MelonLinkExecutor.open(httpResponse$Notification$Buttons0.linkUri);
                        }
                    }
                };
            }
            e0.m = fetcherBaseFragment$40;
            if(this.mEmptyView == null) {
                Object object1 = this.getContentAdapter();
                if(object1 instanceof e) {
                    ((e)object1).setEmptyViewInfo(e0);
                    ((e)object1).showEmptyView(true);
                }
            }
            else if(i1.equals(i0)) {
                EmptyOrErrorViewHelper.showEmptyView(this.mEmptyView, e0);
            }
        }
        else {
            o o0 = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
            o0.b = -1;
            o0.e = -1;
            o0.h = -1;
            o0.i = -1;
            o0.c = 0x7F080786;  // drawable:noimage_logo_large
            o0.d = s;
            if(this.mEmptyView == null) {
                Object object0 = this.getContentAdapter();
                if(object0 instanceof e) {
                    ((e)object0).setErrorViewInfo(o0);
                    ((e)object0).showErrorView(true);
                }
            }
            else if(i1.equals(i0)) {
                EmptyOrErrorViewHelper.showNetworkErrorView(this.mEmptyView, o0);
            }
        }
    }

    private boolean hasCacheKey() {
        Object object0 = this.getContentAdapter();
        if(object0 instanceof B) {
            String s = ((B)object0).getCacheKey();
            LogU.v("FetcherBaseFragment", "hasCacheKey() " + s);
            return !TextUtils.isEmpty(s);
        }
        return false;
    }

    public void hideEmptyAndErrorView() {
        RecyclerView recyclerView0 = this.mRecyclerView;
        if(recyclerView0 != null) {
            recyclerView0.stopScroll();
        }
        View view0 = this.mEmptyView;
        if(view0 != null) {
            EmptyOrErrorViewHelper.hideEmptyView(view0);
            EmptyOrErrorViewHelper.hideNetworkErrorView(this.mEmptyView);
            return;
        }
        Object object0 = this.getContentAdapter();
        if(object0 instanceof e) {
            ((e)object0).showEmptyView(false);
            ((e)object0).showErrorView(false);
        }
    }

    private void hideInteractionViews() {
        LogU.v("FetcherBaseFragment", "hideInteractionViews() " + this);
        this.showProgress(false);
        this.setSwipeRefreshing(false);
        this.showLoadingMore(false);
        n n0 = this.getLoadMoreView();
        if(n0 != null) {
            n0.hideLoading();
        }
    }

    // 去混淆评级： 低(30)
    private boolean isExpired() {
        Object object0 = this.getContentAdapter();
        return object0 instanceof B ? ((B)object0).isExpired("", 300000L) : true;
    }

    private boolean isFetchSuccess(HttpResponse httpResponse0) {
        Notification httpResponse$Notification0 = httpResponse0.notification;
        if(httpResponse$Notification0 != null) {
            LogU.i("FetcherBaseFragment", "isFetchSuccess() actionType:" + httpResponse$Notification0.actionType + ", message:" + httpResponse$Notification0.message);
            return false;
        }
        return true;
    }

    private boolean isLoadingMoreShowing() {
        View view0 = this.findViewById(0x7F0A079C);  // id:loading_more_container
        return view0 != null && view0.getVisibility() == 0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onDestroy() {
        super.onDestroy();
        Object object0 = this.getContentAdapter();
        if(object0 instanceof B) {
            ((B)object0).clearCache("");
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onDestroyView() {
        RecyclerView recyclerView0 = this.mRecyclerView;
        if(recyclerView0 != null) {
            recyclerView0.removeOnScrollListener(this.mScrollListener);
        }
        x x0 = this.mPersonalizedInfoAdapter;
        if(x0 != null) {
            x0.b = null;
        }
        if(this.mSwipeRefreshLayout != null) {
            this.mSwipeRefreshLayout = null;
        }
        super.onDestroyView();
    }

    public void onFetchErrorUI(v8.i i0) {
        if(i0 == null) {
            l1.A("onFetchErrorUI() invalid resource - ", this, "FetcherBaseFragment");
            return;
        }
        v8.h h0 = i0.a;
        if(v8.h.b.equals(h0)) {
            this.onFetchNotificationErrorUI(i0);
            return;
        }
        if(v8.h.c.equals(h0)) {
            this.onFetchNetworkErrorUI(i0);
        }
    }

    public void onFetchNetworkErrorUI(v8.i i0) {
        if(i0 == null) {
            l1.A("onFetchNetworkErrorUI() invalid resource - ", this, "FetcherBaseFragment");
            return;
        }
        if(!v8.h.c.equals(i0.a)) {
            l1.A("onFetchNetworkErrorUI() ,but not network error.", this, "FetcherBaseFragment");
            return;
        }
        this.performFetchError(i0.d);
    }

    public void onFetchNotificationErrorUI(v8.i i0) {
        if(i0 == null) {
            l1.A("onFetchNotificationErrorUI() invalid resource - ", this, "FetcherBaseFragment");
            return;
        }
        if(!v8.h.b.equals(i0.a)) {
            l1.A("onFetchNotificationErrorUI() ,but not notification Error.", this, "FetcherBaseFragment");
            return;
        }
        if(!this.isFragmentValid()) {
            l1.A("onFetchNotificationErrorUI() invalid fragment - ", this, "FetcherBaseFragment");
            return;
        }
        HttpResponse httpResponse0 = (HttpResponse)i0.c;
        if(httpResponse0 == null) {
            l1.A("onFetchNotificationErrorUI() invalid response - ", this, "FetcherBaseFragment");
            return;
        }
        this.performLogging(httpResponse0);
        if(this.isFetchSuccess(httpResponse0) || NotificationActionTypeHelper.isViewTypeNull(httpResponse0.notification)) {
            return;
        }
        this.hideInteractionViews();
        this.handleNotifyScreenNotification(i0.b, httpResponse0);
    }

    public abstract boolean onFetchStart(i arg1, v9.h arg2, String arg3);

    public void onFetchSuccessUI(v8.i i0) {
        if(i0 == null) {
            l1.A("onFetchSuccessUI() invalid resource - ", this, "FetcherBaseFragment");
            return;
        }
        if(!v8.h.a.equals(i0.a)) {
            l1.A("onFetchSuccessUI() ,but not success.", this, "FetcherBaseFragment");
            return;
        }
        if(!this.isFragmentValid()) {
            l1.A("onFetchSuccessUI() invalid fragment - ", this, "FetcherBaseFragment");
            return;
        }
        HttpResponse httpResponse0 = (HttpResponse)i0.c;
        if(httpResponse0 == null) {
            l1.A("onFetchSuccessUI() invalid response - ", this, "FetcherBaseFragment");
            return;
        }
        if(NotificationActionTypeHelper.isViewTypeNotifyScreen(httpResponse0.notification)) {
            this.handleNotifyScreenNotification(i0.b, httpResponse0);
        }
        this.performLogging(httpResponse0);
        this.hideInteractionViews();
    }

    public void onFetchSuccessUINotLogging(v8.i i0) {
        if(i0 == null) {
            l1.A("onFetchSuccessUI() invalid resource - ", this, "FetcherBaseFragment");
            return;
        }
        if(!v8.h.a.equals(i0.a)) {
            l1.A("onFetchSuccessUI() ,but not success.", this, "FetcherBaseFragment");
            return;
        }
        if(!this.isFragmentValid()) {
            l1.A("onFetchSuccessUI() invalid fragment - ", this, "FetcherBaseFragment");
            return;
        }
        HttpResponse httpResponse0 = (HttpResponse)i0.c;
        if(httpResponse0 == null) {
            l1.A("onFetchSuccessUI() invalid response - ", this, "FetcherBaseFragment");
            return;
        }
        if(NotificationActionTypeHelper.isViewTypeNotifyScreen(httpResponse0.notification)) {
            this.handleNotifyScreenNotification(i0.b, httpResponse0);
        }
        this.hideInteractionViews();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onForeground() {
        super.onForeground();
        if(this.mVisibleWhenActivate) {
            i i0 = i.b;
            if(this.getViewModel() != null) {
                this.startFetch(i0, FetcherBaseFragment.sFragmentVisibilityChangedParam, true, "onFragmentVisibilityChangedParam");
            }
            else if((this.isExpired() || !this.hasCacheKey()) && !this.mPreventDefaultFetcher) {
                this.startFetch(i0, FetcherBaseFragment.sFragmentVisibilityChangedParam, true, "onFragmentVisibilityChangedParam");
            }
        }
        if(this.isFragmentVisible) {
            PvLogDummyReq pvLogDummyReq0 = this.getPvDummyLogRequest();
            MenuIdQueue menuIdQueue0 = MenuIdQueue.getInstance();
            if(menuIdQueue0.isSkipAction() && pvLogDummyReq0 == null) {
                menuIdQueue0.setSkipAction(false);
                LogU.v("PvLog", "onForeground() skip logging " + this);
                return;
            }
            if(!TextUtils.isEmpty(this.mLogging)) {
                String s = MenuIdQueue.getInstance().peek();
                this.mPrevMenuId = s;
                ReportService.sendLogging(this.getPvLogUri(this.mLogging, s));
                r.a(this.mResponse, this.mMenuId, this.mPrevMenuId);
                MenuIdQueue.getInstance().offer(this.mMenuId);
                return;
            }
            if(pvLogDummyReq0 != null) {
                this.performPvDummyLog(pvLogDummyReq0);
            }
        }
    }

    @Override  // com.iloen.melon.adapters.common.w
    public void onReadyToFetchPartially(RecyclerView recyclerView0, int[] arr_v) {
        LogU.v("FetcherBaseFragment", "onReadyToFetchPartially()");
    }

    @Override  // L4.h
    public void onRefresh() {
        this.setSwipeRefreshing(false);
        this.startFetch(i.b, v9.h.b, true, "onSwipeRefresh");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onResume() {
        super.onResume();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onStart() {
        super.onStart();
        v9.h h0 = v9.h.b;
        i i0 = i.b;
        if(this.getViewModel() == null) {
            boolean z = this.isExpired();
            boolean z1 = this.hasCacheKey();
            LogU.v("FetcherBaseFragment", "onStart() isExpired: " + z + ", hasCacheKey: " + z1);
            if((z || !z1) && !this.mPreventDefaultFetcher && !this.mVisibleWhenActivate) {
                this.startFetch(i0, h0, true, "onStart");
            }
            return;
        }
        this.startFetch(i0, h0, true, "onStart");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onStop() {
        super.onStop();
        this.cancelRequest();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        RecyclerView recyclerView0 = this.mRecyclerView;
        if(recyclerView0 != null) {
            recyclerView0.addOnScrollListener(this.mScrollListener);
            if(this.mHasPersonalizedContent) {
                x x0 = new x(this.mRecyclerView);
                this.mPersonalizedInfoAdapter = x0;
                x0.b = this;
            }
        }
    }

    public void performFetchComplete(HttpResponse httpResponse0) {
        this.performFetchComplete(i.b, httpResponse0);
    }

    public void performFetchComplete(i i0, HttpResponse httpResponse0) {
        if(!this.isFragmentValid()) {
            l1.A("performFetchComplete() invalid fragment - ", this, "FetcherBaseFragment");
            return;
        }
        LogU.v("FetcherBaseFragment", "performFetchComplete() " + i0);
        this.addResponseInAdapter(i0, httpResponse0);
        this.performFetchCompleteOnlyViews();
    }

    public void performFetchCompleteOnlyViews() {
        if(!this.isFragmentValid()) {
            l1.A("performFetchCompleteOnlyViews() invalid fragment - ", this, "FetcherBaseFragment");
            return;
        }
        boolean z = this.getItemCount() == 0;
        View view0 = this.mEmptyView;
        if(view0 == null) {
            Object object0 = this.getContentAdapter();
            if(object0 instanceof e) {
                ((e)object0).showEmptyView(z);
            }
        }
        else if(z) {
            EmptyOrErrorViewHelper.showEmptyView(view0);
        }
        else {
            EmptyOrErrorViewHelper.hideEmptyView(view0);
        }
        this.hideInteractionViews();
        if(this.mVisibleSnsPopup) {
            this.showSNSListPopup(this.getSNSSharable());
        }
    }

    // 检测为 Lambda 实现
    public void performFetchError(VolleyError volleyError0) [...]

    public void performFetchError(VolleyError volleyError0, boolean z) {
        if(!this.isFragmentValid()) {
            l1.A("performFetchError() invalid fragment - ", this, "FetcherBaseFragment");
            return;
        }
        LogU.d("FetcherBaseFragment", "performFetchError() " + volleyError0 + ", " + HttpResponse.getErrorMessage(volleyError0));
        this.hideInteractionViews();
        boolean z1 = false;
        boolean z2 = volleyError0 instanceof HttpResponseError || volleyError0 instanceof HttpConnectionError;
        if(z2 || volleyError0 instanceof NetworkError || volleyError0 instanceof TimeoutError) {
            z1 = true;
        }
        String s = volleyError0.getMessage();
        if(!z2 || TextUtils.isEmpty(s)) {
            s = "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요.";
        }
        o o0 = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
        o0.b = -1;
        o0.c = -1;
        o0.e = -1;
        o0.h = -1;
        o0.i = -1;
        o0.d = s;
        View.OnClickListener view$OnClickListener0 = null;
        o0.f = z1 ? this.mConfirmButtonListener : null;
        if(z1) {
            view$OnClickListener0 = this.mRetryButtonListener;
        }
        o0.g = view$OnClickListener0;
        View view0 = this.mEmptyView;
        if(view0 == null) {
            Object object0 = this.getContentAdapter();
            if(object0 instanceof e) {
                ((e)object0).setErrorViewInfo(o0);
                ((e)object0).showErrorView(true);
            }
        }
        else {
            EmptyOrErrorViewHelper.showNetworkErrorView(view0, o0);
        }
        if(z) {
            Object object1 = this.getContentAdapter();
            if(object1 instanceof B) {
                ((B)object1).clearCache("");
            }
        }
    }

    public void performFetchPersonalizedInfo() {
        int v5;
        int v3;
        int v2;
        x x0 = this.mPersonalizedInfoAdapter;
        if(x0 != null) {
            RecyclerView recyclerView0 = x0.a;
            if(recyclerView0 == null) {
                LogU.w("PersonalizedInfoRecyclerViewAdapter", "onFetchReady() invalid RecyclerView");
                return;
            }
            j0 j00 = recyclerView0.getAdapter();
            int v = 0;
            int v1 = j00 instanceof com.iloen.melon.adapters.common.i ? ((com.iloen.melon.adapters.common.i)j00).getHeaderCount() : 0;
            if(recyclerView0.getChildAt(v1) == null) {
                LogU.w("PersonalizedInfoRecyclerViewAdapter", "onFetchReady() visibleChild empty");
                return;
            }
            w0 w00 = recyclerView0.getLayoutManager();
            if(w00 instanceof LinearLayoutManager) {
                v2 = ((LinearLayoutManager)w00).findFirstVisibleItemPosition();
                v3 = ((LinearLayoutManager)w00).findLastVisibleItemPosition();
            }
            else if(w00 instanceof GridLayoutManager) {
                v2 = ((GridLayoutManager)w00).findFirstVisibleItemPosition();
                v3 = ((GridLayoutManager)w00).findLastVisibleItemPosition();
            }
            else if(w00 instanceof StaggeredGridLayoutManager) {
                int[] arr_v = new int[((StaggeredGridLayoutManager)w00).a];
                for(int v4 = 0; true; ++v4) {
                    v5 = ((StaggeredGridLayoutManager)w00).a;
                    if(v4 >= v5) {
                        break;
                    }
                    W0 w01 = ((StaggeredGridLayoutManager)w00).b[v4];
                    arr_v[v4] = w01.f.h ? w01.g(w01.a.size() - 1, -1, true, false) : w01.g(0, w01.a.size(), true, false);
                }
                int[] arr_v1 = new int[v5];
                for(int v6 = 0; v6 < ((StaggeredGridLayoutManager)w00).a; ++v6) {
                    W0 w02 = ((StaggeredGridLayoutManager)w00).b[v6];
                    arr_v1[v6] = w02.f.h ? w02.g(0, w02.a.size(), true, false) : w02.g(w02.a.size() - 1, -1, true, false);
                }
                v2 = arr_v[0];
                v3 = arr_v1[v5 - 1];
            }
            else {
                v3 = -1;
                v2 = -1;
            }
            if(v2 != -1 && v3 != -1) {
                int v7 = v3 - v2 + 1 - v1;
                if(v7 > 0) {
                    StringBuilder stringBuilder0 = androidx.appcompat.app.o.t(v2, v3, "onFetchReady() firstVisibleItemPosition: ", ", lastVisibleItemPosition: ", ", headerCount:");
                    stringBuilder0.append(v1);
                    stringBuilder0.append(", size:");
                    stringBuilder0.append(v7);
                    LogU.v("PersonalizedInfoRecyclerViewAdapter", stringBuilder0.toString());
                    int[] arr_v2 = new int[v7];
                    while(v < v7) {
                        arr_v2[v] = v2;
                        ++v;
                        ++v2;
                    }
                    FetcherBaseFragment fetcherBaseFragment0 = x0.b;
                    if(fetcherBaseFragment0 != null) {
                        fetcherBaseFragment0.onReadyToFetchPartially(recyclerView0, arr_v2);
                    }
                }
            }
        }
    }

    public void performLogging(HttpResponse httpResponse0) {
        if(!this.isFragmentValid()) {
            l1.A("performLogging() ", this, "FetcherBaseFragment");
            return;
        }
        if(httpResponse0 == null) {
            LogU.w("FetcherBaseFragment", "performLogging() invalid response)");
            return;
        }
        String s = httpResponse0.logging;
        if(!TextUtils.isEmpty(s)) {
            String s1 = httpResponse0.getMenuId();
            if(this.isFragmentVisible && (TextUtils.isEmpty(this.mLogging) || !s.equals(this.mLogging))) {
                String s2 = MenuIdQueue.getInstance().peek();
                this.mPrevMenuId = s2;
                ReportService.sendLogging(this.getPvLogUri(s, s2));
                r.a(httpResponse0.getResponse(), s1, this.mPrevMenuId);
                MenuIdQueue.getInstance().offer(s1);
            }
            this.mLogging = s;
            this.mMenuId = s1;
            this.mResponse = httpResponse0.getResponse();
        }
    }

    public void performPvDummyLog(PvLogDummyReq pvLogDummyReq0) {
        if(pvLogDummyReq0 == null) {
            LogU.w("FetcherBaseFragment", "performPvDummyLog() invalid response");
            return;
        }
        LogU.v("FetcherBaseFragment", "performPvDummyLog() " + pvLogDummyReq0);
        RequestBuilder.newInstance(pvLogDummyReq0).tag("FetcherBaseFragment").priority(Priority.LOW).listener(new Listener() {
            public void onResponse(PvLogDummyRes pvLogDummyRes0) {
                FetcherBaseFragment.this.performLogging(pvLogDummyRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((PvLogDummyRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                LogU.w("FetcherBaseFragment", "performPvDummyLog() error: " + HttpResponse.getErrorMessage(volleyError0));
            }
        }).request();
    }

    public boolean prepareFetchComplete(HttpResponse httpResponse0) {
        return this.prepareFetchComplete(httpResponse0, false);
    }

    public boolean prepareFetchComplete(HttpResponse httpResponse0, boolean z) {
        return this.prepareFetchComplete(i.b, httpResponse0, z, false);
    }

    public boolean prepareFetchComplete(i i0, HttpResponse httpResponse0) {
        return this.prepareFetchComplete(i0, httpResponse0, false, false);
    }

    public boolean prepareFetchComplete(i i0, HttpResponse httpResponse0, boolean z) {
        return this.prepareFetchComplete(i0, httpResponse0, z, false);
    }

    public boolean prepareFetchComplete(i i0, HttpResponse httpResponse0, boolean z, boolean z1) {
        if(!this.isFragmentValid()) {
            l1.A("prepareFetchComplete() invalid fragment - ", this, "FetcherBaseFragment");
            return false;
        }
        if(httpResponse0 == null) {
            l1.A("prepareFetchComplete() invalid response - ", this, "FetcherBaseFragment");
            return false;
        }
        LogU.d("FetcherBaseFragment", "prepareFetchComplete() handleOnlyError: " + z);
        this.performLogging(httpResponse0);
        if(this.isFetchSuccess(httpResponse0)) {
            return true;
        }
        HttpResponse.handleRedirectScheme(httpResponse0);
        Notification httpResponse$Notification0 = httpResponse0.notification;
        if(NotificationActionTypeHelper.isViewTypeNull(httpResponse$Notification0)) {
            return true;
        }
        if(!NotificationActionTypeHelper.isViewTypeNotifyScreen(httpResponse$Notification0)) {
            NotificationActionTypeHelper.performActionType(httpResponse$Notification0);
            return NotificationActionTypeHelper.isStatusNormal(httpResponse$Notification0);
        }
        if(!z) {
            this.hideInteractionViews();
        }
        this.handleNotifyScreenNotification(i0, httpResponse0);
        if(i.b.equals(i0) && z1) {
            Object object0 = this.getContentAdapter();
            if(object0 instanceof B) {
                ((B)object0).clearCache("");
            }
        }
        return false;
    }

    @Deprecated
    public void sendRequest(VolleyRequest volleyRequest0) {
        if(volleyRequest0 == null) {
            l1.A("sendRequest() invalid request - ", this, "FetcherBaseFragment");
            return;
        }
        if(volleyRequest0.getTag() == null) {
            volleyRequest0.setTag(this.getRequestTag());
        }
        MelonAppBase.instance.getRequestQueue().add(volleyRequest0);
    }

    private void setInteractionOptionViews(boolean z) {
        if(this.isFragmentValid()) {
            LogU.v("FetcherBaseFragment", "setInteractionOptionViews() " + this);
            View view0 = this.findViewById(0x7F0A04A2);  // id:filter_view_check_button
            if(view0 != null && view0.isEnabled() != z) {
                ViewUtils.setEnable(view0, z);
            }
            View view1 = this.findViewById(0x7F0A04A7);  // id:filter_view_play_layout
            if(view1 != null && view1.isEnabled() != z) {
                ViewUtils.setEnable(view1, z);
            }
        }
    }

    private void setSwipeRefreshing(boolean z) {
        SwipeRefreshLayout swipeRefreshLayout0 = this.mSwipeRefreshLayout;
        if(swipeRefreshLayout0 != null) {
            swipeRefreshLayout0.setRefreshing(z);
        }
    }

    private void showLoadingMore(boolean z) {
        ViewUtils.showWhen(this.findViewById(0x7F0A079C), z);  // id:loading_more_container
    }

    public void startFetch() {
        this.startFetch("startFetch");
    }

    public void startFetch(String s) {
        this.startFetch(i.b, v9.h.b, true, s);
    }

    public void startFetch(i i0) {
        this.startFetch(i0, v9.h.b, true, "startFetch");
    }

    public void startFetch(i i0, v9.h h0) {
        this.startFetch(i0, h0, true, "startFetch");
    }

    public void startFetch(i i0, v9.h h0, String s) {
        this.startFetch(i0, h0, true, s);
    }

    public void startFetch(i i0, v9.h h0, boolean z) {
        this.startFetch(i0, h0, z, "startFetch");
    }

    public void startFetch(i i0, v9.h h0, boolean z, String s) {
        if(this.getViewModel() != null) {
            this.startFetchForViewModel(i0, h0, s);
            return;
        }
        this.startFetchForLegacy(i0, h0, z, s);
    }

    public void startFetchForLegacy(i i0, v9.h h0, boolean z, String s) {
        if(z) {
            this.showProgress(true);
        }
        if(!i.c.equals(i0)) {
            this.setSelectAllWithToolbar(false);
        }
        this.getContentAdapter();
        if(i.b.equals(i0)) {
            l l0 = this.getLoadMore();
            if(l0 != null) {
                l0.setHasMore(false);
            }
        }
        this.hideEmptyAndErrorView();
        StringBuilder stringBuilder0 = new StringBuilder("startFetchForLegacy() type:");
        stringBuilder0.append(i0);
        stringBuilder0.append(", param:");
        String s1 = v9.h.b.equals(h0) ? "" : h0;
        stringBuilder0.append(s1);
        stringBuilder0.append(", showProgress:");
        stringBuilder0.append(z);
        stringBuilder0.append(", reason:");
        stringBuilder0.append(s);
        stringBuilder0.append(", ");
        stringBuilder0.append(this);
        LogU.v("FetcherBaseFragment", stringBuilder0.toString());
        if(!this.onFetchStart(i0, h0, s)) {
            this.performFetchCompleteOnlyViews();
        }
    }

    public void startFetchForViewModel(i i0, v9.h h0, String s) {
        this.onFetchStart(i0, h0, s);
        StringBuilder stringBuilder0 = new StringBuilder("startFetchForViewModel() type:");
        stringBuilder0.append(i0);
        stringBuilder0.append(", param:");
        if(v9.h.b.equals(h0)) {
            h0 = "";
        }
        stringBuilder0.append(h0);
        stringBuilder0.append(", reason:");
        stringBuilder0.append(s);
        stringBuilder0.append(", ");
        stringBuilder0.append(this);
        LogU.v("FetcherBaseFragment", stringBuilder0.toString());
    }

    public boolean visibleCheck(I i0) {
        return false;
    }

    class com.iloen.melon.fragments.FetcherBaseFragment.9 implements ErrorListener {
        @Override  // com.android.volley.Response$ErrorListener
        public void onErrorResponse(VolleyError volleyError0) {
            FetcherBaseFragment.this.performFetchError(volleyError0);
        }
    }

}

