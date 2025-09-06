package com.iloen.melon.fragments.shortform;

import De.d;
import H8.i;
import S2.c;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.n;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.lifecycle.s;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.eventbus.EventComment;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.common.YNType;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response;
import com.iloen.melon.net.v6x.response.TrendShortFormRes;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.melon.ui.popup.b;
import d3.g;
import ie.H;
import ie.j;
import ie.k;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import va.o;
import we.a;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\'\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u000FH\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\u0013\u0010\u0003J\u001F\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001A\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u0014H&¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001D\u001A\u0004\u0018\u00010\u001C¢\u0006\u0004\b\u001D\u0010\u001ER\"\u0010\u001F\u001A\u00020\u00148\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"\"\u0004\b#\u0010\u001BR\u001B\u0010)\u001A\u00020$8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001A\u0004\b\'\u0010(¨\u0006+"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortBaseFragment;", "Landroidx/fragment/app/I;", "<init>", "()V", "Lcom/iloen/melon/eventbus/EventComment;", "comment", "Lie/H;", "updateComment", "(Lcom/iloen/melon/eventbus/EventComment;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/iloen/melon/net/v6x/response/TrendShortFormRes$Response$SLOTLIST;", "slotItem", "updateLike", "(Landroid/view/View;Lcom/iloen/melon/net/v6x/response/TrendShortFormRes$Response$SLOTLIST;)V", "failToPlayMedia", "", "sumCount", "", "isLike", "updateLikeView", "(IZ)V", "updateCommentCountView", "(I)V", "Lp8/g;", "getTiaraDefaultBuilder", "()Lp8/g;", "tabPosition", "I", "getTabPosition", "()I", "setTabPosition", "Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel;", "viewModel$delegate", "Lie/j;", "getViewModel", "()Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel;", "viewModel", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class TrendShortBaseFragment extends I {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortBaseFragment$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "TrendShortBaseFragment";
    private int tabPosition;
    @NotNull
    private final j viewModel$delegate;

    static {
        TrendShortBaseFragment.Companion = new Companion(null);
        TrendShortBaseFragment.$stable = 8;
    }

    public TrendShortBaseFragment() {
        this.tabPosition = -1;
        com.iloen.melon.fragments.shortform.TrendShortBaseFragment.special..inlined.viewModels.default.1 trendShortBaseFragment$special$$inlined$viewModels$default$10 = new a() {
            final a $ownerProducer;

            {
                this.$ownerProducer = a0;
                super(0);
            }

            @NotNull
            public final r0 invoke() {
                return (r0)this.$ownerProducer.invoke();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        j j0 = g.P(k.c, trendShortBaseFragment$special$$inlined$viewModels$default$10);
        d d0 = kotlin.jvm.internal.I.a.b(TrendShortFormViewModel.class);
        com.iloen.melon.fragments.shortform.TrendShortBaseFragment.special..inlined.viewModels.default.2 trendShortBaseFragment$special$$inlined$viewModels$default$20 = new a() {
            final j $owner$delegate;

            {
                this.$owner$delegate = j0;
                super(0);
            }

            @NotNull
            public final q0 invoke() {
                return ((r0)this.$owner$delegate.getValue()).getViewModelStore();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        com.iloen.melon.fragments.shortform.TrendShortBaseFragment.special..inlined.viewModels.default.3 trendShortBaseFragment$special$$inlined$viewModels$default$30 = new a(j0) {
            final a $extrasProducer;
            final j $owner$delegate;

            {
                this.$extrasProducer = a0;
                this.$owner$delegate = j0;
                super(0);
            }

            @NotNull
            public final c invoke() {
                a a0 = this.$extrasProducer;
                if(a0 != null) {
                    c c0 = (c)a0.invoke();
                    if(c0 != null) {
                        return c0;
                    }
                }
                r0 r00 = (r0)this.$owner$delegate.getValue();
                n n0 = r00 instanceof n ? ((n)r00) : null;
                return n0 != null ? n0.getDefaultViewModelCreationExtras() : S2.a.b;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        this.viewModel$delegate = new i(d0, trendShortBaseFragment$special$$inlined$viewModels$default$20, new a(j0) {
            final j $owner$delegate;
            final I $this_viewModels;

            {
                this.$this_viewModels = i0;
                this.$owner$delegate = j0;
                super(0);
            }

            @NotNull
            public final o0 invoke() {
                r0 r00 = (r0)this.$owner$delegate.getValue();
                n n0 = r00 instanceof n ? ((n)r00) : null;
                if(n0 != null) {
                    o0 o00 = n0.getDefaultViewModelProviderFactory();
                    return o00 == null ? this.$this_viewModels.getDefaultViewModelProviderFactory() : o00;
                }
                return this.$this_viewModels.getDefaultViewModelProviderFactory();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }, trendShortBaseFragment$special$$inlined$viewModels$default$30);
    }

    public void failToPlayMedia() {
        l0 l00 = this.getChildFragmentManager();
        String s = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
        String s1 = this.getString(0x7F1300BD);  // string:alert_dlg_body_trend_play_error "데이터 통신이 불안정합니다.\n네트워크 연결을 확인하시거나,\n재시도 해주세요"
        b.d(b.a, l00, s, s1, false, false, false, null, null, null, null, null, 2040);
    }

    public final int getTabPosition() {
        return this.tabPosition;
    }

    @Nullable
    public final p8.g getTiaraDefaultBuilder() {
        List list0 = (List)this.getViewModel().getList().getValue();
        if(list0 != null) {
            SLOTLIST trendShortFormRes$Response$SLOTLIST0 = (SLOTLIST)list0.get(this.tabPosition);
            if(trendShortFormRes$Response$SLOTLIST0 != null) {
                v8.i i0 = (v8.i)this.getViewModel().getResponse().getValue();
                if(i0 != null) {
                    TrendShortFormRes trendShortFormRes0 = (TrendShortFormRes)i0.c;
                    if(trendShortFormRes0 != null) {
                        Response trendShortFormRes$Response0 = trendShortFormRes0.response;
                        if(trendShortFormRes$Response0 != null) {
                            String s = this.getViewModel().getMenuId();
                            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                            g0.b = trendShortFormRes$Response0.section;
                            g0.c = trendShortFormRes$Response0.page;
                            g0.y = trendShortFormRes$Response$SLOTLIST0.slotName;
                            g0.I = s;
                            return g0;
                        }
                    }
                }
            }
        }
        return null;
    }

    @NotNull
    public final TrendShortFormViewModel getViewModel() {
        return (TrendShortFormViewModel)this.viewModel$delegate.getValue();
    }

    @Override  // androidx.fragment.app.I
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getMain(), null, new we.n(null) {
            int label;

            {
                TrendShortBaseFragment.this = trendShortBaseFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.shortform.TrendShortBaseFragment.onViewCreated.1(TrendShortBaseFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.shortform.TrendShortBaseFragment.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = TrendShortBaseFragment.this.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.fragments.shortform.TrendShortBaseFragment.onViewCreated.1.1 trendShortBaseFragment$onViewCreated$1$10 = new we.n(null) {
                            int label;

                            {
                                TrendShortBaseFragment.this = trendShortBaseFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.shortform.TrendShortBaseFragment.onViewCreated.1.1(TrendShortBaseFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.shortform.TrendShortBaseFragment.onViewCreated.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                TrendShortBaseFragment.this.requireActivity().getSupportFragmentManager().j0("comment_request_key", TrendShortBaseFragment.this.getViewLifecycleOwner(), new com.iloen.melon.fragments.shortform.j(TrendShortBaseFragment.this));
                                return H.a;
                            }

                            private static final void invokeSuspend$lambda$0(TrendShortBaseFragment trendShortBaseFragment0, String s, Bundle bundle0) {
                                Serializable serializable0 = bundle0.getSerializable("data");
                                q.e(serializable0, "null cannot be cast to non-null type com.iloen.melon.eventbus.EventComment");
                                trendShortBaseFragment0.updateComment(((EventComment)serializable0));
                            }
                        };
                        this.label = 1;
                        return f0.j(d0, s.e, trendShortBaseFragment$onViewCreated$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 2, null);
    }

    public final void setTabPosition(int v) {
        this.tabPosition = v;
    }

    private final void updateComment(EventComment eventComment0) {
        int v2;
        List list0 = (List)this.getViewModel().getList().getValue();
        if(list0 != null) {
            SLOTLIST trendShortFormRes$Response$SLOTLIST0 = (SLOTLIST)list0.get(this.tabPosition);
            if(trendShortFormRes$Response$SLOTLIST0 != null && q.b(trendShortFormRes$Response$SLOTLIST0.contsId, eventComment0.contsRefValue) && q.b(eventComment0.actiontype, "count")) {
                int v = 0;
                int v1 = ProtocolUtils.parseInt(trendShortFormRes$Response$SLOTLIST0.cmtCnt, 0);
                if(eventComment0.isCountAdded) {
                    v2 = v1 + 1;
                }
                else {
                    if(v1 - 1 >= 0) {
                        v = v1 - 1;
                    }
                    v2 = v;
                }
                trendShortFormRes$Response$SLOTLIST0.cmtCnt = String.valueOf(v2);
                this.updateCommentCountView(v2);
            }
        }
    }

    public abstract void updateCommentCountView(int arg1);

    public final void updateLike(@NotNull View view0, @NotNull SLOTLIST trendShortFormRes$Response$SLOTLIST0) {
        q.g(view0, "view");
        q.g(trendShortFormRes$Response$SLOTLIST0, "slotItem");
        if(!(view0 instanceof CheckableImageView)) {
            return;
        }
        if(!((e0)o.a()).m()) {
            this.getViewModel().showLoginPopup();
            return;
        }
        String s = trendShortFormRes$Response$SLOTLIST0.contsId;
        String s1 = trendShortFormRes$Response$SLOTLIST0.contsTypeCode;
        q.f(s1, "contsTypeCode");
        TrendUtils.updateLike(this, s, s1, !((CheckableImageView)view0).a, this.getViewModel().getMenuId(), new OnJobFinishListener() {
            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onJobComplete(String s, int v, boolean z) {
                int v1;
                TrendShortBaseFragment trendShortBaseFragment0;
                q.g(s, "errorMsg");
                ((CheckableImageView)trendShortFormRes$Response$SLOTLIST0).setEnabled(true);
                ((CheckableImageView)trendShortFormRes$Response$SLOTLIST0).setClickable(true);
                this.likeCnt = String.valueOf(v);
                this.likeYn = YNType.valueOf(z);
                if(TrendShortBaseFragment.this.isAdded()) {
                    TrendShortBaseFragment.this.updateLikeView(v, z);
                    View view0 = trendShortFormRes$Response$SLOTLIST0;
                    if(((CheckableImageView)view0).a) {
                        trendShortBaseFragment0 = TrendShortBaseFragment.this;
                        v1 = 0x7F130B5C;  // string:talkback_like_off "좋아요 취소"
                    }
                    else {
                        trendShortBaseFragment0 = TrendShortBaseFragment.this;
                        v1 = 0x7F130B5F;  // string:talkback_like_on "좋아요"
                    }
                    view0.setContentDescription(trendShortBaseFragment0.getString(v1));
                }
            }

            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onStartAsyncTask() {
                ((CheckableImageView)trendShortFormRes$Response$SLOTLIST0).setEnabled(false);
                ((CheckableImageView)trendShortFormRes$Response$SLOTLIST0).setClickable(false);
            }
        });
    }

    public abstract void updateLikeView(int arg1, boolean arg2);

    private static final r0 viewModel_delegate$lambda$0(TrendShortBaseFragment trendShortBaseFragment0) {
        r0 r00 = trendShortBaseFragment0.requireParentFragment();
        q.f(r00, "requireParentFragment(...)");
        return r00;
    }
}

