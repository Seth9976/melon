package com.kakao.emoticon.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q0;
import com.kakao.emoticon.R.string;
import com.kakao.emoticon.activity.EmoticonSettingActivity;
import com.kakao.emoticon.activity.adapter.EmoticonDownloadAdapter.AddDownloadItemListener;
import com.kakao.emoticon.activity.adapter.EmoticonDownloadAdapter;
import com.kakao.emoticon.controller.EmoticonManager.EmoticonCallback;
import com.kakao.emoticon.controller.EmoticonManager;
import com.kakao.emoticon.databinding.LayoutEmoticonDownloadBinding;
import com.kakao.emoticon.db.model.EmoticonDAO;
import com.kakao.emoticon.net.EmoticonApiError;
import com.kakao.emoticon.net.response.Emoticon;
import com.kakao.emoticon.ui.widget.EmoticonPullToRefreshLayout.OnRefreshListener;
import com.kakao.emoticon.util.ActionTracker;
import e1.b;
import ie.H;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0004J\u000F\u0010\u0007\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b\u0007\u0010\u0004J\u000F\u0010\b\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b\b\u0010\u0004J\u000F\u0010\t\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b\t\u0010\u0004J-\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0016\u0010\u0004J\u000F\u0010\u0017\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0004J\u001B\u0010\u001B\u001A\u00020\u00052\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00190\u0018\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001F\u001A\u00020\u00052\u0006\u0010\u001E\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b\u001F\u0010 R\u0018\u0010\"\u001A\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\"\u0010#R\u001C\u0010%\u001A\b\u0012\u0004\u0012\u00020\u00190$8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001A\u00020\'8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001A\u00020\'8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b*\u0010)R\u0016\u0010,\u001A\u00020+8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001A\u00020.8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b/\u00100\u00A8\u00061"}, d2 = {"Lcom/kakao/emoticon/activity/fragment/EmoticonDownloadFragment;", "Landroidx/fragment/app/I;", "Lcom/kakao/emoticon/ui/widget/EmoticonPullToRefreshLayout$OnRefreshListener;", "<init>", "()V", "Lie/H;", "initView", "filterExpiredEventList", "reloadEmoticonList", "stopRefreshing", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "startRefreshing", "onDestroy", "", "Lcom/kakao/emoticon/net/response/Emoticon;", "items", "addDownloadableEmoticons", "(Ljava/util/List;)V", "", "direction", "onRefresh", "(I)V", "Lcom/kakao/emoticon/activity/adapter/EmoticonDownloadAdapter;", "mAdapter", "Lcom/kakao/emoticon/activity/adapter/EmoticonDownloadAdapter;", "", "emoticonList", "Ljava/util/List;", "", "isFirstSync", "Z", "isDestroy", "Lcom/kakao/emoticon/databinding/LayoutEmoticonDownloadBinding;", "binding", "Lcom/kakao/emoticon/databinding/LayoutEmoticonDownloadBinding;", "Landroidx/recyclerview/widget/A0;", "recyclerViewScrollListener", "Landroidx/recyclerview/widget/A0;", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonDownloadFragment extends I implements OnRefreshListener {
    private HashMap _$_findViewCache;
    private LayoutEmoticonDownloadBinding binding;
    private List emoticonList;
    private boolean isDestroy;
    private boolean isFirstSync;
    private EmoticonDownloadAdapter mAdapter;
    private final A0 recyclerViewScrollListener;

    public EmoticonDownloadFragment() {
        this.emoticonList = new ArrayList();
        this.recyclerViewScrollListener = new A0() {
            @Override  // androidx.recyclerview.widget.A0
            public void onScrolled(@NotNull RecyclerView recyclerView0, int v, int v1) {
                q.g(recyclerView0, "recyclerView");
                super.onScrolled(recyclerView0, v, v1);
                if(recyclerView0.computeVerticalScrollOffset() <= 0) {
                    LayoutEmoticonDownloadBinding layoutEmoticonDownloadBinding0 = EmoticonDownloadFragment.access$getBinding$p(EmoticonDownloadFragment.this);
                    q.f(layoutEmoticonDownloadBinding0.swipeLayout, "binding.swipeLayout");
                    layoutEmoticonDownloadBinding0.swipeLayout.setEnabled(true);
                    EmoticonDownloadFragment.access$getBinding$p(EmoticonDownloadFragment.this).swipeLayout.setDragRefresh(true);
                    return;
                }
                LayoutEmoticonDownloadBinding layoutEmoticonDownloadBinding1 = EmoticonDownloadFragment.access$getBinding$p(EmoticonDownloadFragment.this);
                q.f(layoutEmoticonDownloadBinding1.swipeLayout, "binding.swipeLayout");
                layoutEmoticonDownloadBinding1.swipeLayout.setEnabled(false);
                EmoticonDownloadFragment.access$getBinding$p(EmoticonDownloadFragment.this).swipeLayout.setDragRefresh(false);
            }
        };
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap0 = this._$_findViewCache;
        if(hashMap0 != null) {
            hashMap0.clear();
        }
    }

    public View _$_findCachedViewById(int v) {
        if(this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view0 = (View)this._$_findViewCache.get(v);
        if(view0 == null) {
            View view1 = this.getView();
            if(view1 == null) {
                return null;
            }
            view0 = view1.findViewById(v);
            this._$_findViewCache.put(v, view0);
        }
        return view0;
    }

    public static final LayoutEmoticonDownloadBinding access$getBinding$p(EmoticonDownloadFragment emoticonDownloadFragment0) {
        LayoutEmoticonDownloadBinding layoutEmoticonDownloadBinding0 = emoticonDownloadFragment0.binding;
        if(layoutEmoticonDownloadBinding0 != null) {
            return layoutEmoticonDownloadBinding0;
        }
        q.m("binding");
        throw null;
    }

    public static final boolean access$isFirstSync$p(EmoticonDownloadFragment emoticonDownloadFragment0) {
        return emoticonDownloadFragment0.isFirstSync;
    }

    public static final void access$setBinding$p(EmoticonDownloadFragment emoticonDownloadFragment0, LayoutEmoticonDownloadBinding layoutEmoticonDownloadBinding0) {
        emoticonDownloadFragment0.binding = layoutEmoticonDownloadBinding0;
    }

    public static final void access$setDestroy$p(EmoticonDownloadFragment emoticonDownloadFragment0, boolean z) {
        emoticonDownloadFragment0.isDestroy = z;
    }

    public static final void access$setEmoticonList$p(EmoticonDownloadFragment emoticonDownloadFragment0, List list0) {
        emoticonDownloadFragment0.emoticonList = list0;
    }

    public static final void access$setMAdapter$p(EmoticonDownloadFragment emoticonDownloadFragment0, EmoticonDownloadAdapter emoticonDownloadAdapter0) {
        emoticonDownloadFragment0.mAdapter = emoticonDownloadAdapter0;
    }

    public final void addDownloadableEmoticons(@NotNull List list0) {
        q.g(list0, "items");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            if(!((Emoticon)object0).isEventItem() && !this.emoticonList.contains(((Emoticon)object0))) {
                arrayList0.add(object0);
            }
        }
        for(Object object1: arrayList0) {
            this.emoticonList.add(((Emoticon)object1));
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object2: list0) {
            if(!((Emoticon)object2).isEventItem() && this.emoticonList.contains(((Emoticon)object2))) {
                arrayList1.add(object2);
            }
        }
        for(Object object3: arrayList1) {
            ((Emoticon)object3).setShow(false);
        }
        EmoticonDownloadAdapter emoticonDownloadAdapter0 = this.mAdapter;
        if(emoticonDownloadAdapter0 != null) {
            emoticonDownloadAdapter0.notifyDataSetChanged();
        }
    }

    private final void filterExpiredEventList() {
        Iterable iterable0 = EmoticonManager.INSTANCE.getAllEmoticonList();
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: iterable0) {
            Emoticon emoticon0 = (Emoticon)object0;
            if(!emoticon0.isEventItem() || emoticon0.getExpiredAt() <= 0L || emoticon0.getExpiredAt() * 1000L >= System.currentTimeMillis()) {
                arrayList0.add(object0);
            }
        }
        this.emoticonList = p.Q0(p.J0(arrayList0, new com.kakao.emoticon.activity.fragment.EmoticonDownloadFragment.filterExpiredEventList..inlined.sortedBy.1()));

        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000E\u0010\u0002\u001A\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000E\u0010\u0003\u001A\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        public final class com.kakao.emoticon.activity.fragment.EmoticonDownloadFragment.filterExpiredEventList..inlined.sortedBy.1 implements Comparator {
            @Override
            public final int compare(Object object0, Object object1) {
                return b.r(((Emoticon)object0).getServerOrderIndex(), ((Emoticon)object1).getServerOrderIndex());
            }
        }

    }

    private final void initView() {
        LayoutEmoticonDownloadBinding layoutEmoticonDownloadBinding0 = this.binding;
        if(layoutEmoticonDownloadBinding0 != null) {
            layoutEmoticonDownloadBinding0.swipeLayout.setOnRefreshListener(this);
            layoutEmoticonDownloadBinding0.swipeLayout.setDragRefresh(true);
            layoutEmoticonDownloadBinding0.swipeLayout.setDirection(1);
            layoutEmoticonDownloadBinding0.swipeLayout.setNestedScrollingEnabled(true);
            this.filterExpiredEventList();
            EmoticonDownloadAdapter emoticonDownloadAdapter0 = new EmoticonDownloadAdapter();
            emoticonDownloadAdapter0.setEmoticonList(this.emoticonList, EmoticonManager.INSTANCE.getSettingBannerImageUrl());
            emoticonDownloadAdapter0.setDownloadItemListener(new AddDownloadItemListener() {
                @Override  // com.kakao.emoticon.activity.adapter.EmoticonDownloadAdapter$AddDownloadItemListener
                public final void onAddItem(@NotNull Emoticon emoticon0) {
                    q.g(emoticon0, "emoticon");
                    EmoticonSettingActivity emoticonSettingActivity0 = (EmoticonSettingActivity)EmoticonDownloadFragment.this.getActivity();
                    if(emoticonSettingActivity0 != null) {
                        EmoticonEditFragment emoticonEditFragment0 = emoticonSettingActivity0.getEmoticonEditFragment();
                        if(emoticonEditFragment0 != null) {
                            emoticonEditFragment0.addDownloadedItem(emoticon0);
                        }
                    }
                }
            });
            this.mAdapter = emoticonDownloadAdapter0;
            LayoutEmoticonDownloadBinding layoutEmoticonDownloadBinding1 = this.binding;
            if(layoutEmoticonDownloadBinding1 != null) {
                RecyclerView recyclerView0 = layoutEmoticonDownloadBinding1.rvDownload;
                recyclerView0.setHasFixedSize(true);
                q0 q00 = recyclerView0.getItemAnimator();
                if(q00 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
                }
                ((androidx.recyclerview.widget.q)q00).g = false;
                recyclerView0.setLayoutManager(new LinearLayoutManager(recyclerView0.getContext()));
                recyclerView0.setAdapter(this.mAdapter);
                recyclerView0.addOnScrollListener(this.recyclerViewScrollListener);
                return;
            }
            q.m("binding");
            throw null;
        }
        q.m("binding");
        throw null;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        LayoutEmoticonDownloadBinding layoutEmoticonDownloadBinding0 = LayoutEmoticonDownloadBinding.inflate(layoutInflater0, viewGroup0, false);
        q.f(layoutEmoticonDownloadBinding0, "LayoutEmoticonDownloadBi…flater, container, false)");
        this.binding = layoutEmoticonDownloadBinding0;
        return layoutEmoticonDownloadBinding0.getRoot();
    }

    @Override  // androidx.fragment.app.I
    public void onDestroy() {
        this.isDestroy = true;
        LayoutEmoticonDownloadBinding layoutEmoticonDownloadBinding0 = this.binding;
        if(layoutEmoticonDownloadBinding0 != null) {
            layoutEmoticonDownloadBinding0.rvDownload.removeOnScrollListener(this.recyclerViewScrollListener);
            super.onDestroy();
            return;
        }
        q.m("binding");
        throw null;
    }

    @Override  // androidx.fragment.app.I
    public void onDestroyView() {
        super.onDestroyView();
        this._$_clearFindViewByIdCache();
    }

    @Override  // com.kakao.emoticon.ui.widget.EmoticonPullToRefreshLayout$OnRefreshListener
    public void onRefresh(int v) {
        if(this.isFirstSync) {
            this.isFirstSync = false;
        }
        else {
            ActionTracker.pushLog$default("A002", "04", null, 4, null);
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(null) {
            int label;
            private CoroutineScope p$;

            {
                EmoticonDownloadFragment.this = emoticonDownloadFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.activity.fragment.EmoticonDownloadFragment.onRefresh.1(EmoticonDownloadFragment.this, continuation0);
                continuation1.p$ = (CoroutineScope)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.activity.fragment.EmoticonDownloadFragment.onRefresh.1)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                EmoticonDAO.instance().insertOrUpdate(EmoticonDownloadFragment.this.emoticonList);
                EmoticonDownloadFragment.this.reloadEmoticonList();
                com.kakao.emoticon.activity.fragment.EmoticonDownloadFragment.onRefresh.1.1 emoticonDownloadFragment$onRefresh$1$10 = new EmoticonCallback() {
                    @Override  // com.kakao.emoticon.controller.EmoticonManager$EmoticonCallback
                    public void onFailure(@NotNull EmoticonApiError emoticonApiError0) {
                        q.g(emoticonApiError0, "errorResult");
                        EmoticonDownloadFragment.this.stopRefreshing();
                        Toast.makeText(EmoticonDownloadFragment.this.getContext(), string.label_load_failed_msg, 0).show();
                        EmoticonDownloadFragment.this.reloadEmoticonList();
                    }

                    @Override  // com.kakao.emoticon.controller.EmoticonManager$EmoticonCallback
                    public void onSuccess() {
                        EmoticonManager.INSTANCE.setNeedRefreshKeyboard(true);
                        if(EmoticonDownloadFragment.this.isDestroy) {
                            return;
                        }
                        EmoticonDownloadFragment.this.stopRefreshing();
                        EmoticonDownloadFragment.this.reloadEmoticonList();
                    }
                };
                EmoticonManager.requestSyncEmoticons$default(EmoticonManager.INSTANCE, emoticonDownloadFragment$onRefresh$1$10, null, 2, null);
                return H.a;
            }
        }, 3, null);
    }

    @Override  // androidx.fragment.app.I
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        this.initView();
    }

    private final void reloadEmoticonList() {
        this.filterExpiredEventList();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new n(null) {
            int label;
            private CoroutineScope p$;

            {
                EmoticonDownloadFragment.this = emoticonDownloadFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.activity.fragment.EmoticonDownloadFragment.reloadEmoticonList.1(EmoticonDownloadFragment.this, continuation0);
                continuation1.p$ = (CoroutineScope)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.activity.fragment.EmoticonDownloadFragment.reloadEmoticonList.1)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                EmoticonDownloadAdapter emoticonDownloadAdapter0 = EmoticonDownloadFragment.this.mAdapter;
                if(emoticonDownloadAdapter0 != null) {
                    emoticonDownloadAdapter0.setEmoticonList(EmoticonDownloadFragment.this.emoticonList, EmoticonManager.INSTANCE.getSettingBannerImageUrl());
                }
                FragmentActivity fragmentActivity0 = EmoticonDownloadFragment.this.getActivity();
                if(fragmentActivity0 != null && !fragmentActivity0.isFinishing()) {
                    EmoticonSettingActivity emoticonSettingActivity0 = (EmoticonSettingActivity)EmoticonDownloadFragment.this.getActivity();
                    if((emoticonSettingActivity0 == null ? null : emoticonSettingActivity0.getEmoticonEditFragment()) != null) {
                        EmoticonSettingActivity emoticonSettingActivity1 = (EmoticonSettingActivity)EmoticonDownloadFragment.this.getActivity();
                        if(emoticonSettingActivity1 != null) {
                            EmoticonEditFragment emoticonEditFragment0 = emoticonSettingActivity1.getEmoticonEditFragment();
                            if(emoticonEditFragment0 != null) {
                                emoticonEditFragment0.reloadEditList();
                            }
                        }
                    }
                }
                return H.a;
            }
        }, 3, null);
    }

    public final void startRefreshing() {
        LayoutEmoticonDownloadBinding layoutEmoticonDownloadBinding0 = this.binding;
        if(layoutEmoticonDownloadBinding0 != null) {
            com.kakao.emoticon.activity.fragment.EmoticonDownloadFragment.startRefreshing.1 emoticonDownloadFragment$startRefreshing$10 = new Runnable() {
                @Override
                public final void run() {
                    if(EmoticonDownloadFragment.this.isDestroy) {
                        return;
                    }
                    EmoticonDownloadFragment.access$getBinding$p(EmoticonDownloadFragment.this).swipeLayout.startRefreshing(1);
                    LayoutEmoticonDownloadBinding layoutEmoticonDownloadBinding0 = EmoticonDownloadFragment.access$getBinding$p(EmoticonDownloadFragment.this);
                    com.kakao.emoticon.activity.fragment.EmoticonDownloadFragment.startRefreshing.1.1 emoticonDownloadFragment$startRefreshing$1$10 = new Runnable() {
                        @Override
                        public final void run() {
                            if(EmoticonDownloadFragment.this.isDestroy) {
                                return;
                            }
                            EmoticonDownloadFragment.this.isFirstSync = true;
                            EmoticonDownloadFragment.this.onRefresh(1);
                        }
                    };
                    layoutEmoticonDownloadBinding0.swipeLayout.postDelayed(emoticonDownloadFragment$startRefreshing$1$10, 800L);
                }
            };
            layoutEmoticonDownloadBinding0.swipeLayout.post(emoticonDownloadFragment$startRefreshing$10);
            return;
        }
        q.m("binding");
        throw null;
    }

    private final void stopRefreshing() {
        LayoutEmoticonDownloadBinding layoutEmoticonDownloadBinding0 = this.binding;
        if(layoutEmoticonDownloadBinding0 != null) {
            layoutEmoticonDownloadBinding0.swipeLayout.stopRefreshing();
            return;
        }
        q.m("binding");
        throw null;
    }
}

