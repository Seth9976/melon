package com.kakao.emoticon.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.O;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.l0;
import com.kakao.emoticon.R.string;
import com.kakao.emoticon.activity.EmoticonSettingActivity;
import com.kakao.emoticon.activity.adapter.EmoticonEditAdapter;
import com.kakao.emoticon.activity.helper.DragSortTouchHelperCallback;
import com.kakao.emoticon.activity.helper.OnStartDragListener;
import com.kakao.emoticon.controller.EmoticonManager;
import com.kakao.emoticon.databinding.LayoutEmoticonEditBinding;
import com.kakao.emoticon.db.model.EmoticonDAO;
import com.kakao.emoticon.net.response.Emoticon;
import com.kakao.emoticon.util.ActionTracker;
import e.k;
import ie.H;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import we.n;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J-\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\t\u001A\u00020\b2\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J!\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u000E2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001A\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0003J\r\u0010\u0015\u001A\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0003J\u0015\u0010\u0018\u001A\u00020\u00042\u0006\u0010\u0017\u001A\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001C\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00160\u001A8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0018\u0010\u001E\u001A\u0004\u0018\u00010\u001D8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\u0016\u0010!\u001A\u00020 8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001A\u00020 8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b#\u0010\"R\u0016\u0010%\u001A\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001A\u00020\'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001A\u00020*8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/kakao/emoticon/activity/fragment/EmoticonEditFragment;", "Landroidx/fragment/app/I;", "<init>", "()V", "Lie/H;", "initView", "refreshDeleteLayout", "hiddenItems", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onBackPressed", "reloadEditList", "Lcom/kakao/emoticon/net/response/Emoticon;", "emoticon", "addDownloadedItem", "(Lcom/kakao/emoticon/net/response/Emoticon;)V", "", "emoticonGlobalList", "Ljava/util/List;", "Landroidx/recyclerview/widget/O;", "itemTouchHelper", "Landroidx/recyclerview/widget/O;", "", "isItemAdded", "Z", "isDeleted", "Lcom/kakao/emoticon/databinding/LayoutEmoticonEditBinding;", "binding", "Lcom/kakao/emoticon/databinding/LayoutEmoticonEditBinding;", "Lcom/kakao/emoticon/activity/adapter/EmoticonEditAdapter;", "adapter", "Lcom/kakao/emoticon/activity/adapter/EmoticonEditAdapter;", "Lorg/json/JSONObject;", "getLogValue", "()Lorg/json/JSONObject;", "logValue", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonEditFragment extends I {
    private HashMap _$_findViewCache;
    private EmoticonEditAdapter adapter;
    private LayoutEmoticonEditBinding binding;
    private List emoticonGlobalList;
    private boolean isDeleted;
    private boolean isItemAdded;
    private O itemTouchHelper;

    public EmoticonEditFragment() {
        this.emoticonGlobalList = new ArrayList();
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

    public static final EmoticonEditAdapter access$getAdapter$p(EmoticonEditFragment emoticonEditFragment0) {
        EmoticonEditAdapter emoticonEditAdapter0 = emoticonEditFragment0.adapter;
        if(emoticonEditAdapter0 != null) {
            return emoticonEditAdapter0;
        }
        q.m("adapter");
        throw null;
    }

    public static final LayoutEmoticonEditBinding access$getBinding$p(EmoticonEditFragment emoticonEditFragment0) {
        LayoutEmoticonEditBinding layoutEmoticonEditBinding0 = emoticonEditFragment0.binding;
        if(layoutEmoticonEditBinding0 != null) {
            return layoutEmoticonEditBinding0;
        }
        q.m("binding");
        throw null;
    }

    public static final void access$setAdapter$p(EmoticonEditFragment emoticonEditFragment0, EmoticonEditAdapter emoticonEditAdapter0) {
        emoticonEditFragment0.adapter = emoticonEditAdapter0;
    }

    public static final void access$setBinding$p(EmoticonEditFragment emoticonEditFragment0, LayoutEmoticonEditBinding layoutEmoticonEditBinding0) {
        emoticonEditFragment0.binding = layoutEmoticonEditBinding0;
    }

    public static final void access$setEmoticonGlobalList$p(EmoticonEditFragment emoticonEditFragment0, List list0) {
        emoticonEditFragment0.emoticonGlobalList = list0;
    }

    public static final void access$setItemTouchHelper$p(EmoticonEditFragment emoticonEditFragment0, O o0) {
        emoticonEditFragment0.itemTouchHelper = o0;
    }

    public final void addDownloadedItem(@NotNull Emoticon emoticon0) {
        q.g(emoticon0, "emoticon");
        this.isItemAdded = true;
        emoticon0.setShow(true);
        if(!this.emoticonGlobalList.contains(emoticon0)) {
            this.emoticonGlobalList.add(0, emoticon0);
            EmoticonEditAdapter emoticonEditAdapter0 = this.adapter;
            if(emoticonEditAdapter0 != null) {
                emoticonEditAdapter0.notifyDataSetChanged();
                return;
            }
            q.m("adapter");
            throw null;
        }
    }

    private final JSONObject getLogValue() {
        JSONObject jSONObject0 = new JSONObject();
        EmoticonEditAdapter emoticonEditAdapter0 = this.adapter;
        if(emoticonEditAdapter0 != null) {
            jSONObject0.put("o", emoticonEditAdapter0.isReOrder());
            jSONObject0.put("d", this.isDeleted);
            jSONObject0.put("a", this.isItemAdded);
            return jSONObject0;
        }
        q.m("adapter");
        throw null;
    }

    // 检测为 Lambda 实现
    private final void hiddenItems() [...]

    private final void initView() {
        LayoutEmoticonEditBinding layoutEmoticonEditBinding0 = this.binding;
        if(layoutEmoticonEditBinding0 != null) {
            layoutEmoticonEditBinding0.emoticonSetList.setHasFixedSize(true);
            LayoutEmoticonEditBinding layoutEmoticonEditBinding1 = this.binding;
            if(layoutEmoticonEditBinding1 != null) {
                q.f(layoutEmoticonEditBinding1.emoticonSetList, "binding.emoticonSetList");
                this.getContext();
                LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(1, false);
                layoutEmoticonEditBinding1.emoticonSetList.setLayoutManager(linearLayoutManager0);
                this.emoticonGlobalList = EmoticonManager.INSTANCE.getEmoticonList(true);
                List list0 = this.emoticonGlobalList;
                this.adapter = new EmoticonEditAdapter(this.getContext(), list0, new OnStartDragListener() {
                    @Override  // com.kakao.emoticon.activity.helper.OnStartDragListener
                    public void onStartDrag(@Nullable O0 o00) {
                        if(o00 != null) {
                            O o0 = EmoticonEditFragment.this.itemTouchHelper;
                            if(o0 != null) {
                                o0.n(o00);
                            }
                        }
                    }
                });
                LayoutEmoticonEditBinding layoutEmoticonEditBinding2 = this.binding;
                if(layoutEmoticonEditBinding2 != null) {
                    RecyclerView recyclerView0 = layoutEmoticonEditBinding2.emoticonSetList;
                    q.f(recyclerView0, "binding.emoticonSetList");
                    EmoticonEditAdapter emoticonEditAdapter0 = this.adapter;
                    if(emoticonEditAdapter0 != null) {
                        recyclerView0.setAdapter(emoticonEditAdapter0);
                        EmoticonEditAdapter emoticonEditAdapter1 = this.adapter;
                        if(emoticonEditAdapter1 != null) {
                            O o0 = new O(new DragSortTouchHelperCallback(emoticonEditAdapter1));
                            LayoutEmoticonEditBinding layoutEmoticonEditBinding3 = this.binding;
                            if(layoutEmoticonEditBinding3 != null) {
                                o0.c(layoutEmoticonEditBinding3.emoticonSetList);
                                this.itemTouchHelper = o0;
                                LayoutEmoticonEditBinding layoutEmoticonEditBinding4 = this.binding;
                                if(layoutEmoticonEditBinding4 != null) {
                                    com.kakao.emoticon.activity.fragment.EmoticonEditFragment.initView.3 emoticonEditFragment$initView$30 = (/* 缺少LAMBDA参数 */) -> {
                                        EmoticonEditFragment.this.isDeleted = true;
                                        EmoticonEditAdapter emoticonEditAdapter0 = EmoticonEditFragment.this.adapter;
                                        if(emoticonEditAdapter0 != null) {
                                            Set set0 = emoticonEditAdapter0.getSelectedItems();
                                            ArrayList arrayList0 = new ArrayList();
                                            ArrayList arrayList1 = new ArrayList();
                                            for(Object object0: EmoticonEditFragment.this.emoticonGlobalList) {
                                                Emoticon emoticon0 = (Emoticon)object0;
                                                if(set0.contains(emoticon0.getId())) {
                                                    emoticon0.setShow(false);
                                                    arrayList1.add(emoticon0);
                                                    EmoticonDAO.instance().insertOrUpdate(emoticon0);
                                                }
                                                else {
                                                    arrayList0.add(emoticon0);
                                                }
                                            }
                                            EmoticonEditAdapter emoticonEditAdapter1 = EmoticonEditFragment.this.adapter;
                                            if(emoticonEditAdapter1 != null) {
                                                emoticonEditAdapter1.clearSelectedItems();
                                                EmoticonEditAdapter emoticonEditAdapter2 = EmoticonEditFragment.this.adapter;
                                                if(emoticonEditAdapter2 != null) {
                                                    EmoticonEditFragment.this.emoticonGlobalList = arrayList0;
                                                    emoticonEditAdapter2.setEmoticonList(arrayList0);
                                                    FragmentActivity fragmentActivity0 = EmoticonEditFragment.this.getActivity();
                                                    if(fragmentActivity0 == null) {
                                                        throw new NullPointerException("null cannot be cast to non-null type com.kakao.emoticon.activity.EmoticonSettingActivity");
                                                    }
                                                    EmoticonDownloadFragment emoticonDownloadFragment0 = ((EmoticonSettingActivity)fragmentActivity0).getEmoticonDownloadFragment();
                                                    if(emoticonDownloadFragment0 != null) {
                                                        emoticonDownloadFragment0.addDownloadableEmoticons(arrayList1);
                                                    }
                                                    EmoticonEditFragment.this.refreshDeleteLayout();
                                                    return;
                                                }
                                                q.m("adapter");
                                                throw null;
                                            }
                                            q.m("adapter");
                                            throw null;
                                        }
                                        q.m("adapter");
                                        throw null;
                                    };
                                    layoutEmoticonEditBinding4.btnDelete.setOnClickListener(emoticonEditFragment$initView$30);
                                    LayoutEmoticonEditBinding layoutEmoticonEditBinding5 = this.binding;
                                    if(layoutEmoticonEditBinding5 != null) {
                                        q.f(layoutEmoticonEditBinding5.emoticonSetList, "binding.emoticonSetList");
                                        j0 j00 = layoutEmoticonEditBinding5.emoticonSetList.getAdapter();
                                        if(j00 != null) {
                                            ((EmoticonEditAdapter)j00).registerAdapterDataObserver(new l0() {
                                                @Override  // androidx.recyclerview.widget.l0
                                                public void onChanged() {
                                                    if(EmoticonEditFragment.access$getAdapter$p(EmoticonEditFragment.this).getItemCount() == 0) {
                                                        LayoutEmoticonEditBinding layoutEmoticonEditBinding0 = EmoticonEditFragment.access$getBinding$p(EmoticonEditFragment.this);
                                                        q.f(layoutEmoticonEditBinding0.emoticonEditEmpty, "binding.emoticonEditEmpty");
                                                        if(layoutEmoticonEditBinding0.emoticonEditEmpty.getVisibility() != 0) {
                                                            LayoutEmoticonEditBinding layoutEmoticonEditBinding1 = EmoticonEditFragment.access$getBinding$p(EmoticonEditFragment.this);
                                                            q.f(layoutEmoticonEditBinding1.emoticonEditEmpty, "binding.emoticonEditEmpty");
                                                            layoutEmoticonEditBinding1.emoticonEditEmpty.setVisibility(0);
                                                            return;
                                                        }
                                                    }
                                                    LayoutEmoticonEditBinding layoutEmoticonEditBinding2 = EmoticonEditFragment.access$getBinding$p(EmoticonEditFragment.this);
                                                    q.f(layoutEmoticonEditBinding2.emoticonEditEmpty, "binding.emoticonEditEmpty");
                                                    if(8 != layoutEmoticonEditBinding2.emoticonEditEmpty.getVisibility()) {
                                                        LayoutEmoticonEditBinding layoutEmoticonEditBinding3 = EmoticonEditFragment.access$getBinding$p(EmoticonEditFragment.this);
                                                        q.f(layoutEmoticonEditBinding3.emoticonEditEmpty, "binding.emoticonEditEmpty");
                                                        layoutEmoticonEditBinding3.emoticonEditEmpty.setVisibility(8);
                                                    }
                                                }

                                                @Override  // androidx.recyclerview.widget.l0
                                                public void onItemRangeChanged(int v, int v1) {
                                                    super.onItemRangeChanged(v, v1);
                                                    EmoticonEditFragment.this.refreshDeleteLayout();
                                                }
                                            });
                                        }
                                        EmoticonEditAdapter emoticonEditAdapter2 = this.adapter;
                                        if(emoticonEditAdapter2 != null) {
                                            emoticonEditAdapter2.notifyDataSetChanged();
                                            return;
                                        }
                                        q.m("adapter");
                                        throw null;
                                    }
                                    q.m("binding");
                                    throw null;
                                }
                                q.m("binding");
                                throw null;
                            }
                            q.m("binding");
                            throw null;
                        }
                        q.m("adapter");
                        throw null;
                    }
                    q.m("adapter");
                    throw null;
                }
                q.m("binding");
                throw null;
            }
            q.m("binding");
            throw null;
        }
        q.m("binding");
        throw null;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u00032\u000E\u0010\u0002\u001A\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "Lie/H;", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        final class com.kakao.emoticon.activity.fragment.EmoticonEditFragment.initView.3 implements View.OnClickListener {
            public com.kakao.emoticon.activity.fragment.EmoticonEditFragment.initView.3(EmoticonEditFragment emoticonEditFragment0) {
            }

            @Override  // android.view.View$OnClickListener
            public final void onClick(View view0) {
                EmoticonEditFragment.this.hiddenItems();
            }
        }

    }

    public final void onBackPressed() {
        int v;
        EmoticonEditAdapter emoticonEditAdapter0 = this.adapter;
        if(emoticonEditAdapter0 != null) {
            if(!emoticonEditAdapter0.isReOrder() && !this.isItemAdded && !this.isDeleted) {
                FragmentActivity fragmentActivity0 = this.getActivity();
                if(fragmentActivity0 != null) {
                    fragmentActivity0.finish();
                }
                return;
            }
            try {
                ActionTracker.pushLog("A002", "05", this.getLogValue());
                v = 0;
            }
            catch(JSONException unused_ex) {
            }
            for(Object object0: this.emoticonGlobalList) {
                if(v >= 0) {
                    ((Emoticon)object0).setOrderIndex(v);
                    ++v;
                    continue;
                }
                k.O();
                throw null;
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(null) {
                Object L$0;
                int label;
                private CoroutineScope p$;

                {
                    EmoticonEditFragment.this = emoticonEditFragment0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                @NotNull
                public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                    q.g(continuation0, "completion");
                    Continuation continuation1 = new com.kakao.emoticon.activity.fragment.EmoticonEditFragment.onBackPressed.2(EmoticonEditFragment.this, continuation0);
                    continuation1.p$ = (CoroutineScope)object0;
                    return continuation1;
                }

                @Override  // we.n
                public final Object invoke(Object object0, Object object1) {
                    return ((com.kakao.emoticon.activity.fragment.EmoticonEditFragment.onBackPressed.2)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                }

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    CoroutineScope coroutineScope1;
                    a a0 = a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            coroutineScope1 = this.p$;
                            EmoticonDAO.instance().insertOrUpdate(EmoticonEditFragment.this.emoticonGlobalList);
                            this.L$0 = coroutineScope1;
                            this.label = 1;
                            if(EmoticonManager.INSTANCE.reloadLocalEmoticons(this) == a0) {
                                return a0;
                            }
                            break;
                        }
                        case 1: {
                            coroutineScope1 = (CoroutineScope)this.L$0;
                            d5.n.D(object0);
                            break;
                        }
                        case 2: {
                            CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                            d5.n.D(object0);
                            return H.a;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                    EmoticonManager.INSTANCE.setNeedRefreshKeyboard(true);
                    com.kakao.emoticon.activity.fragment.EmoticonEditFragment.onBackPressed.2.1 emoticonEditFragment$onBackPressed$2$10 = new n(null) {
                        int label;
                        private CoroutineScope p$;

                        {
                            com.kakao.emoticon.activity.fragment.EmoticonEditFragment.onBackPressed.2.this = emoticonEditFragment$onBackPressed$20;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        @NotNull
                        public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                            q.g(continuation0, "completion");
                            Continuation continuation1 = new com.kakao.emoticon.activity.fragment.EmoticonEditFragment.onBackPressed.2.1(com.kakao.emoticon.activity.fragment.EmoticonEditFragment.onBackPressed.2.this, continuation0);
                            continuation1.p$ = (CoroutineScope)object0;
                            return continuation1;
                        }

                        @Override  // we.n
                        public final Object invoke(Object object0, Object object1) {
                            return ((com.kakao.emoticon.activity.fragment.EmoticonEditFragment.onBackPressed.2.1)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            d5.n.D(object0);
                            FragmentActivity fragmentActivity0 = EmoticonEditFragment.this.getActivity();
                            if(fragmentActivity0 != null) {
                                fragmentActivity0.finish();
                            }
                            return H.a;
                        }
                    };
                    this.L$0 = coroutineScope1;
                    this.label = 2;
                    return BuildersKt.withContext(Dispatchers.getMain(), emoticonEditFragment$onBackPressed$2$10, this) == a0 ? a0 : H.a;
                }
            }, 3, null);
            return;
        }
        q.m("adapter");
        throw null;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        LayoutEmoticonEditBinding layoutEmoticonEditBinding0 = LayoutEmoticonEditBinding.inflate(layoutInflater0, viewGroup0, false);
        q.f(layoutEmoticonEditBinding0, "LayoutEmoticonEditBindin…flater, container, false)");
        this.binding = layoutEmoticonEditBinding0;
        return layoutEmoticonEditBinding0.getRoot();
    }

    @Override  // androidx.fragment.app.I
    public void onDestroyView() {
        super.onDestroyView();
        this._$_clearFindViewByIdCache();
    }

    @Override  // androidx.fragment.app.I
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initView();
    }

    private final void refreshDeleteLayout() {
        EmoticonEditAdapter emoticonEditAdapter0 = this.adapter;
        if(emoticonEditAdapter0 != null) {
            Set set0 = emoticonEditAdapter0.getSelectedItems();
            q.f(set0, "adapter.selectedItems");
            if(!set0.isEmpty()) {
                LayoutEmoticonEditBinding layoutEmoticonEditBinding0 = this.binding;
                if(layoutEmoticonEditBinding0 != null) {
                    Button button0 = layoutEmoticonEditBinding0.btnDelete;
                    q.f(button0, "binding.btnDelete");
                    String s = this.getResources().getString(string.emoticon_delete);
                    EmoticonEditAdapter emoticonEditAdapter1 = this.adapter;
                    if(emoticonEditAdapter1 != null) {
                        button0.setText(String.format("%s(%d)", Arrays.copyOf(new Object[]{s, emoticonEditAdapter1.getSelectedItems().size()}, 2)));
                        LayoutEmoticonEditBinding layoutEmoticonEditBinding1 = this.binding;
                        if(layoutEmoticonEditBinding1 != null) {
                            q.f(layoutEmoticonEditBinding1.btnDelete, "binding.btnDelete");
                            layoutEmoticonEditBinding1.btnDelete.setEnabled(true);
                            return;
                        }
                        q.m("binding");
                        throw null;
                    }
                    q.m("adapter");
                    throw null;
                }
                q.m("binding");
                throw null;
            }
            LayoutEmoticonEditBinding layoutEmoticonEditBinding2 = this.binding;
            if(layoutEmoticonEditBinding2 != null) {
                layoutEmoticonEditBinding2.btnDelete.setText(string.emoticon_delete);
                LayoutEmoticonEditBinding layoutEmoticonEditBinding3 = this.binding;
                if(layoutEmoticonEditBinding3 != null) {
                    q.f(layoutEmoticonEditBinding3.btnDelete, "binding.btnDelete");
                    layoutEmoticonEditBinding3.btnDelete.setEnabled(false);
                    return;
                }
                q.m("binding");
                throw null;
            }
            q.m("binding");
            throw null;
        }
        q.m("adapter");
        throw null;
    }

    public final void reloadEditList() {
        Iterable iterable0 = EmoticonManager.INSTANCE.getEmoticonList(true);
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: iterable0) {
            if(!this.emoticonGlobalList.contains(((Emoticon)object0))) {
                arrayList0.add(object0);
            }
        }
        int v = 0;
        for(Object object1: arrayList0) {
            if(v >= 0) {
                this.emoticonGlobalList.add(v, ((Emoticon)object1));
                ++v;
                continue;
            }
            k.O();
            throw null;
        }
        EmoticonEditAdapter emoticonEditAdapter0 = this.adapter;
        if(emoticonEditAdapter0 != null) {
            emoticonEditAdapter0.setEmoticonList(this.emoticonGlobalList);
            EmoticonEditAdapter emoticonEditAdapter1 = this.adapter;
            if(emoticonEditAdapter1 != null) {
                emoticonEditAdapter1.notifyDataSetChanged();
                return;
            }
            q.m("adapter");
            throw null;
        }
        q.m("adapter");
        throw null;
    }
}

