package com.iloen.melon.player.video;

import De.d;
import H8.i;
import J8.g2;
import J8.u;
import J8.w3;
import J8.x;
import S2.c;
import Tf.o;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.n;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.s;
import androidx.media3.session.G0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.google.android.material.imageview.ShapeableImageView;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v6x.response.LiveChatRes.Response.CHATSDKINFO.USER;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.RESPONSE;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.SONG;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.video.chat.ChatAdapter.OnDataChangedListener;
import com.iloen.melon.player.video.chat.ChatAdapter.OnItemLongClickListener;
import com.iloen.melon.player.video.chat.ChatAdapter;
import com.iloen.melon.player.video.chat.ChatUi.ChatView;
import com.iloen.melon.player.video.chat.ChatUi.ErrorView;
import com.iloen.melon.player.video.chat.ChatUi.Type;
import com.iloen.melon.player.video.chat.ChatUi;
import com.iloen.melon.player.video.chat.VideoChatInputPopup;
import com.iloen.melon.player.video.chat.VideoChatViewModel;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.kakaoent.leonchat.data.messages.InputMessage;
import d3.g;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.j;
import ie.k;
import ie.m;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 12\u00020\u0001:\u000212B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000E\u0010\fJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J+\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010 \u001A\u00020\u000F2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001EH\u0014¢\u0006\u0004\b \u0010!J!\u0010#\u001A\u00020\u00062\u0006\u0010\"\u001A\u00020\u00172\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\u0003J\u000F\u0010\'\u001A\u00020&H\u0014¢\u0006\u0004\b\'\u0010(J\u000F\u0010*\u001A\u00020)H\u0014¢\u0006\u0004\b*\u0010+J\u001B\u0010/\u001A\u0006\u0012\u0002\b\u00030.2\u0006\u0010-\u001A\u00020,H\u0014¢\u0006\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/iloen/melon/player/video/VideoChatFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Landroid/content/res/Configuration;", "newConfig", "Lie/H;", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/os/Bundle;", "savedInstanceState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "", "shouldIgnoreSetUIOnForegroundEvent", "()Z", "shouldShowMiniPlayer", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Companion", "ChatItemDecoration", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoChatFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/player/video/VideoChatFragment$ChatItemDecoration;", "Landroidx/recyclerview/widget/r0;", "", "itemSpacing", "<init>", "(F)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ChatItemDecoration extends r0 {
        public static final int $stable = 8;
        public final float a;

        public ChatItemDecoration(float f) {
            this.a = f;
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(recyclerView0, "parent");
            q.g(k00, "state");
            Context context0 = view0.getContext();
            rect0.top = ScreenUtils.dipToPixel(context0, this.a / 2.0f);
            rect0.bottom = ScreenUtils.dipToPixel(context0, this.a / 2.0f);
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/player/video/VideoChatFragment$Companion;", "", "", "isFull", "Lcom/iloen/melon/player/video/VideoChatFragment;", "newInstance", "(Z)Lcom/iloen/melon/player/video/VideoChatFragment;", "", "TAG", "Ljava/lang/String;", "ARG_IS_FULL", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final VideoChatFragment newInstance(boolean z) {
            VideoChatFragment videoChatFragment0 = new VideoChatFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("argIsFull", z);
            videoChatFragment0.setArguments(bundle0);
            return videoChatFragment0;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public VideoSongListBottomSheetFragment a;
    public final i b;
    public final i c;
    public boolean d;
    public VideoChatInputPopup e;
    public w3 f;
    public ChatUi g;
    public final com.iloen.melon.player.video.VideoChatFragment.endlessRecyclerOnScrollListener.1 h;

    static {
        VideoChatFragment.Companion = new Companion(null);
        VideoChatFragment.$stable = 8;
    }

    public VideoChatFragment() {
        com.iloen.melon.player.video.VideoChatFragment.special..inlined.viewModels.default.1 videoChatFragment$special$$inlined$viewModels$default$10 = new a() {
            public final a f;

            {
                this.f = a0;
                super(0);
            }

            @NotNull
            public final androidx.lifecycle.r0 invoke() {
                return (androidx.lifecycle.r0)this.f.invoke();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        j j0 = g.P(k.c, videoChatFragment$special$$inlined$viewModels$default$10);
        d d0 = I.a.b(LiveViewModel.class);
        com.iloen.melon.player.video.VideoChatFragment.special..inlined.viewModels.default.2 videoChatFragment$special$$inlined$viewModels$default$20 = new a() {
            public final j f;

            {
                this.f = j0;
                super(0);
            }

            @NotNull
            public final q0 invoke() {
                return ((androidx.lifecycle.r0)this.f.getValue()).getViewModelStore();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        com.iloen.melon.player.video.VideoChatFragment.special..inlined.viewModels.default.3 videoChatFragment$special$$inlined$viewModels$default$30 = new a(j0) {
            public final a f;
            public final j g;

            {
                this.f = a0;
                this.g = j0;
                super(0);
            }

            @NotNull
            public final c invoke() {
                a a0 = this.f;
                if(a0 != null) {
                    c c0 = (c)a0.invoke();
                    if(c0 != null) {
                        return c0;
                    }
                }
                androidx.lifecycle.r0 r00 = (androidx.lifecycle.r0)this.g.getValue();
                n n0 = r00 instanceof n ? ((n)r00) : null;
                return n0 != null ? n0.getDefaultViewModelCreationExtras() : S2.a.b;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        this.b = new i(d0, videoChatFragment$special$$inlined$viewModels$default$20, new a(j0) {
            public final androidx.fragment.app.I f;
            public final j g;

            {
                this.f = i0;
                this.g = j0;
                super(0);
            }

            @NotNull
            public final o0 invoke() {
                androidx.lifecycle.r0 r00 = (androidx.lifecycle.r0)this.g.getValue();
                n n0 = r00 instanceof n ? ((n)r00) : null;
                if(n0 != null) {
                    o0 o00 = n0.getDefaultViewModelProviderFactory();
                    return o00 == null ? this.f.getDefaultViewModelProviderFactory() : o00;
                }
                return this.f.getDefaultViewModelProviderFactory();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }, videoChatFragment$special$$inlined$viewModels$default$30);
        com.iloen.melon.player.video.VideoChatFragment.special..inlined.viewModels.default.5 videoChatFragment$special$$inlined$viewModels$default$50 = new a() {
            public final a f;

            {
                this.f = a0;
                super(0);
            }

            @NotNull
            public final androidx.lifecycle.r0 invoke() {
                return (androidx.lifecycle.r0)this.f.invoke();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        j j1 = g.P(k.c, videoChatFragment$special$$inlined$viewModels$default$50);
        d d1 = I.a.b(VideoChatViewModel.class);
        com.iloen.melon.player.video.VideoChatFragment.special..inlined.viewModels.default.6 videoChatFragment$special$$inlined$viewModels$default$60 = new a() {
            public final j f;

            {
                this.f = j0;
                super(0);
            }

            @NotNull
            public final q0 invoke() {
                return ((androidx.lifecycle.r0)this.f.getValue()).getViewModelStore();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        com.iloen.melon.player.video.VideoChatFragment.special..inlined.viewModels.default.7 videoChatFragment$special$$inlined$viewModels$default$70 = new a(j1) {
            public final a f;
            public final j g;

            {
                this.f = a0;
                this.g = j0;
                super(0);
            }

            @NotNull
            public final c invoke() {
                a a0 = this.f;
                if(a0 != null) {
                    c c0 = (c)a0.invoke();
                    if(c0 != null) {
                        return c0;
                    }
                }
                androidx.lifecycle.r0 r00 = (androidx.lifecycle.r0)this.g.getValue();
                n n0 = r00 instanceof n ? ((n)r00) : null;
                return n0 != null ? n0.getDefaultViewModelCreationExtras() : S2.a.b;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        this.c = new i(d1, videoChatFragment$special$$inlined$viewModels$default$60, new a(j1) {
            public final androidx.fragment.app.I f;
            public final j g;

            {
                this.f = i0;
                this.g = j0;
                super(0);
            }

            @NotNull
            public final o0 invoke() {
                androidx.lifecycle.r0 r00 = (androidx.lifecycle.r0)this.g.getValue();
                n n0 = r00 instanceof n ? ((n)r00) : null;
                if(n0 != null) {
                    o0 o00 = n0.getDefaultViewModelProviderFactory();
                    return o00 == null ? this.f.getDefaultViewModelProviderFactory() : o00;
                }
                return this.f.getDefaultViewModelProviderFactory();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }, videoChatFragment$special$$inlined$viewModels$default$70);
        this.g = new ChatView(Type.NONE, false);
        this.h = new com.iloen.melon.adapters.common.g() {
            @Override  // com.iloen.melon.adapters.common.g
            public void onLastItemVisibleChanged(RecyclerView recyclerView0, boolean z) {
                q.g(recyclerView0, "recyclerView");
                ViewUtils.hideWhen(VideoChatFragment.access$getBinding(this.a).l, z);
            }

            @Override  // com.iloen.melon.adapters.common.g
            public void onParallax(float f) {
            }

            @Override  // com.iloen.melon.adapters.common.g
            public void onScrollDown() {
            }

            @Override  // com.iloen.melon.adapters.common.g
            public void onScrollUp() {
            }
        };
    }

    public static final w3 access$getBinding(VideoChatFragment videoChatFragment0) {
        w3 w30 = videoChatFragment0.f;
        q.d(w30);
        return w30;
    }

    public static final boolean access$isFullMode$p(VideoChatFragment videoChatFragment0) {
        return videoChatFragment0.d;
    }

    public static final void access$sendMessage(VideoChatFragment videoChatFragment0) {
        videoChatFragment0.i0();
    }

    public static final void access$showReportPopup(VideoChatFragment videoChatFragment0, InputMessage inputMessage0, USER liveChatRes$Response$CHATSDKINFO$USER0) {
        boolean z = ((Playable)videoChatFragment0.f0().getCurrentVideoPlayable().getValue()) == null;
        if(o.H0("")) {
            LogU.Companion.d("VideoChatFragment", "showReportPopup() liveSeq is empty");
            return;
        }
        FragmentActivity fragmentActivity0 = videoChatFragment0.getActivity();
        if(fragmentActivity0 != null) {
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add("프로필 신고하기");
            arrayList0.add("채팅 신고하기");
            BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
            bottomSingleFilterListPopup0.setFilterItem(arrayList0, -1);
            bottomSingleFilterListPopup0.setFilterListener(new G0("", inputMessage0, liveChatRes$Response$CHATSDKINFO$USER0, videoChatFragment0));
            bottomSingleFilterListPopup0.setOnDismissListener(videoChatFragment0.getDialogDismissListener());
            videoChatFragment0.setRetainDialog(bottomSingleFilterListPopup0);
            bottomSingleFilterListPopup0.show();
        }
    }

    public static final void access$updateChatUI(VideoChatFragment videoChatFragment0, ChatUi chatUi0) {
        videoChatFragment0.g = chatUi0;
        w3 w30 = videoChatFragment0.f;
        q.d(w30);
        VideoChatCustomRecyclerView videoChatCustomRecyclerView0 = w30.o;
        q.f(videoChatCustomRecyclerView0, "recyclerView");
        w3 w31 = videoChatFragment0.f;
        q.d(w31);
        MelonTextView melonTextView0 = w31.j;
        q.f(melonTextView0, "errorView");
        if(chatUi0 instanceof ChatView) {
            Type chatUi$Type0 = ((ChatView)chatUi0).getType();
            LogU.Companion.d("VideoChatFragment", "updateChatUI() - type : " + chatUi$Type0);
            w3 w32 = videoChatFragment0.f;
            q.d(w32);
            w32.r.setHint(0x7F13061E);  // string:melon_tv_live_chat_input_message "채팅을 입력해주세요."
            m m0 = new m(videoChatCustomRecyclerView0, melonTextView0);
            ViewUtils.INSTANCE.switchShowAndHide(m0, true);
            if(((ChatView)chatUi0).getEnableSendMessage()) {
                w3 w33 = videoChatFragment0.f;
                q.d(w33);
                w33.r.setHint(0x7F13061E);  // string:melon_tv_live_chat_input_message "채팅을 입력해주세요."
                w3 w34 = videoChatFragment0.f;
                q.d(w34);
                w3 w35 = videoChatFragment0.f;
                q.d(w35);
                CharSequence charSequence0 = w35.r.getText();
                q.f(charSequence0, "getText(...)");
                boolean z = o.H0(charSequence0);
                ViewUtils.showWhen(w34.p, !z);
                return;
            }
            VideoChatInputPopup videoChatInputPopup0 = videoChatFragment0.e;
            if(videoChatInputPopup0 != null) {
                videoChatInputPopup0.dismiss();
            }
            w3 w36 = videoChatFragment0.f;
            q.d(w36);
            w36.r.setText("");
            w3 w37 = videoChatFragment0.f;
            q.d(w37);
            w37.r.setHint(0x7F13061C);  // string:melon_tv_live_chat_disable "채팅 입력이 불가합니다."
            w3 w38 = videoChatFragment0.f;
            q.d(w38);
            ViewUtils.hideWhen(w38.p, true);
            return;
        }
        if(!(chatUi0 instanceof ErrorView)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        w3 w39 = videoChatFragment0.f;
        q.d(w39);
        w39.r.setText("");
        w3 w310 = videoChatFragment0.f;
        q.d(w310);
        w310.r.setHint(0x7F13061C);  // string:melon_tv_live_chat_disable "채팅 입력이 불가합니다."
        melonTextView0.setText(((ErrorView)chatUi0).getGroundMessage());
        m m1 = new m(videoChatCustomRecyclerView0, melonTextView0);
        ViewUtils.INSTANCE.switchShowAndHide(m1, false);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new ChatAdapter(this, this.d);
        ((ChatAdapter)j00).setOnItemLongClickListener(new OnItemLongClickListener() {
            public final VideoChatFragment a;

            {
                this.a = videoChatFragment0;
            }

            @Override  // com.iloen.melon.player.video.chat.ChatAdapter$OnItemLongClickListener
            public void onItemLongClick(InputMessage inputMessage0, USER liveChatRes$Response$CHATSDKINFO$USER0) {
                q.g(inputMessage0, "message");
                q.g(liveChatRes$Response$CHATSDKINFO$USER0, "userData");
                VideoChatFragment.access$showReportPopup(this.a, inputMessage0, liveChatRes$Response$CHATSDKINFO$USER0);
            }
        });
        ((ChatAdapter)j00).setOnDataChangedListener(new OnDataChangedListener() {
            public final VideoChatFragment a;
            public final ChatAdapter b;

            {
                VideoChatFragment videoChatFragment0 = (ChatAdapter)j00;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.a = videoChatFragment0;
                this.b = chatAdapter0;
            }

            @Override  // com.iloen.melon.player.video.chat.ChatAdapter$OnDataChangedListener
            public void onDataChangedListener(boolean z) {
                VideoChatFragment videoChatFragment0 = this.a;
                w3 w30 = videoChatFragment0.f;
                if(w30 != null && (w30.l != null && w30.l.getVisibility() == 8) || z) {
                    w3 w31 = videoChatFragment0.f;
                    if(w31 != null) {
                        VideoChatCustomRecyclerView videoChatCustomRecyclerView0 = w31.o;
                        if(videoChatCustomRecyclerView0 != null) {
                            videoChatCustomRecyclerView0.scrollToPosition(this.b.getItemCount() - 1);
                        }
                    }
                }
            }
        });
        return j00;
    }

    public static String d0(VideoChatFragment videoChatFragment0) {
        String s = videoChatFragment0.mMenuId;
        q.f(s, "mMenuId");
        return s;
    }

    public final VideoChatViewModel e0() {
        return (VideoChatViewModel)this.c.getValue();
    }

    public final LiveViewModel f0() {
        return (LiveViewModel)this.b.getValue();
    }

    public static SONG g0(RESPONSE liveTimedMetaSongRes$RESPONSE0) {
        ArrayList arrayList0 = liveTimedMetaSongRes$RESPONSE0.songList;
        q.f(arrayList0, "songList");
        for(Object object0: arrayList0) {
            SONG liveTimedMetaSongRes$SONG0 = (SONG)object0;
            if(liveTimedMetaSongRes$SONG0.isPick) {
                return liveTimedMetaSongRes$SONG0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        Context context0 = this.getContext();
        return this.isEditMode() ? new PvLogDummyReq(context0, "playlistVideoEdit") : new PvLogDummyReq(context0, "playlistVideo");
    }

    public final void h0() {
        if(!this.d) {
            return;
        }
        if(!((Boolean)this.f0().isOrientationPortrait().getValue()).booleanValue()) {
            w3 w30 = this.f;
            q.d(w30);
            w30.d.setBackgroundResource(0x7F08093C);  // drawable:transparent
            w3 w31 = this.f;
            q.d(w31);
            w31.b.setBackgroundResource(0x7F08093C);  // drawable:transparent
            w3 w32 = this.f;
            q.d(w32);
            w32.a.setBackgroundResource(0x7F08088A);  // drawable:shape_gradient_gray600e_transparent_angle180
            w3 w33 = this.f;
            q.d(w33);
            ConstraintLayout constraintLayout0 = w33.d;
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = constraintLayout0.getLayoutParams();
            if(viewGroup$LayoutParams0 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            viewGroup$LayoutParams0.height = ScreenUtils.dipToPixel(this.requireContext(), 40.0f);
            constraintLayout0.setLayoutParams(viewGroup$LayoutParams0);
            return;
        }
        w3 w34 = this.f;
        q.d(w34);
        w34.d.setBackgroundResource(0x7F08088B);  // drawable:shape_gradient_gray600e_transparent_angle270
        w3 w35 = this.f;
        q.d(w35);
        w35.b.setBackgroundResource(0x7F06015F);  // color:gray600e
        w3 w36 = this.f;
        q.d(w36);
        w36.a.setBackgroundResource(0x7F08093C);  // drawable:transparent
        w3 w37 = this.f;
        q.d(w37);
        ConstraintLayout constraintLayout1 = w37.d;
        ViewGroup.LayoutParams viewGroup$LayoutParams1 = constraintLayout1.getLayoutParams();
        if(viewGroup$LayoutParams1 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        viewGroup$LayoutParams1.height = ScreenUtils.dipToPixel(this.requireContext(), 160.0f);
        constraintLayout1.setLayoutParams(viewGroup$LayoutParams1);
    }

    public final void i0() {
        String s;
        if(!this.e0().isConnected()) {
            s = this.getString(0x7F13061D);  // string:melon_tv_live_chat_disconnected "네트워크 연결 상태를 확인하거나,\n잠시 후 다시 시도해주세요."
        }
        else if(this.e0().hasMessage()) {
            this.e0().sendMessage();
            w3 w30 = this.f;
            if(w30 != null) {
                w30.r.setText("");
            }
            s = null;
        }
        else {
            s = this.getString(0x7F130629);  // string:melon_tv_live_send_empty_msg "1자 이상 입력해야 전송이 가능합니다."
        }
        if(s != null && !o.H0(s) == 1) {
            MelonTextPopup melonTextPopup0 = new MelonTextPopup(this.getActivity(), 1);
            melonTextPopup0.setTitleName(this.getString(0x7F1300D0));  // string:alert_dlg_title_info "안내"
            melonTextPopup0.setBodyMsg(s);
            melonTextPopup0.setPopupOnClickListener(new h(melonTextPopup0, 0));
            melonTextPopup0.show();
            this.e0().clearMessage();
            w3 w31 = this.f;
            if(w31 != null) {
                w31.r.setText("");
            }
        }
    }

    public static void j0(VideoChatFragment videoChatFragment0, ActionKind actionKind0, String s, String s1, String s2, String s3, String s4, int v) {
        Object object0 = videoChatFragment0.f0().getCurrentVideoPlayable().getValue();
        if(((Playable)object0) == null) {
            return;
        }
        e1.m.F(new com.iloen.melon.player.video.i(videoChatFragment0, ((v & 1) == 0 ? actionKind0 : null), ((v & 2) == 0 ? s : null), ((Playable)object0).isLiveContent(), ((Playable)object0), ((v & 8) == 0 ? s2 : null), ((v & 4) == 0 ? s1 : null), ((v & 16) == 0 ? s3 : null), ((v & 0x20) == 0 ? s4 : null))).track();
    }

    public final void k0(View view0, boolean z) {
        ViewUtils.showWhen(view0, z);
        this.getRecyclerView().scrollToPosition(this.getAdapter().getItemCount() - 1);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        VideoSongListBottomSheetFragment videoSongListBottomSheetFragment0 = this.a;
        if(videoSongListBottomSheetFragment0 != null) {
            videoSongListBottomSheetFragment0.dismiss();
        }
        this.h0();
        if(this.f != null && this.f.l.getVisibility() == 8) {
            w3 w30 = this.f;
            if(w30 != null) {
                com.iloen.melon.player.video.q q0 = new com.iloen.melon.player.video.q(this, 0);
                w30.o.postDelayed(q0, 50L);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        w3 w30 = this.f;
        q.d(w30);
        w30.o.setItemAnimator(null);
        LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(w30.o.getContext());
        w30.o.setLayoutManager(linearLayoutManager0);
        w30.o.setAdapter(this.mAdapter);
        ChatItemDecoration videoChatFragment$ChatItemDecoration0 = new ChatItemDecoration(12.0f);
        w30.o.addItemDecoration(videoChatFragment$ChatItemDecoration0);
        w30.o.setHasFixedSize(true);
        w30.o.addOnScrollListener(this.h);
        return w30.o;
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = this.getLayoutInflater().inflate(0x7F0D08D6, viewGroup0, false);  // layout:video_chat_layout
        int v = 0x7F0A0118;  // id:bottom_container
        View view1 = De.I.C(view0, 0x7F0A0118);  // id:bottom_container
        if(((ConstraintLayout)view1) != null) {
            v = 0x7F0A019C;  // id:btn_reaction
            View view2 = De.I.C(view0, 0x7F0A019C);  // id:btn_reaction
            if(((ImageButton)view2) != null) {
                v = 0x7F0A02CB;  // id:close_container
                View view3 = De.I.C(view0, 0x7F0A02CB);  // id:close_container
                if(((ConstraintLayout)view3) != null) {
                    v = 0x7F0A0322;  // id:container_chat_banner_artist_message
                    View view4 = De.I.C(view0, 0x7F0A0322);  // id:container_chat_banner_artist_message
                    if(view4 != null) {
                        int v1 = 0x7F0A00C0;  // id:artist_thumbnail
                        ShapeableImageView shapeableImageView0 = (ShapeableImageView)De.I.C(view4, 0x7F0A00C0);  // id:artist_thumbnail
                        if(shapeableImageView0 == null) {
                            throw new NullPointerException("Missing required view with ID: " + view4.getResources().getResourceName(v1));
                        }
                        v1 = 0x7F0A0CD1;  // id:tv_notice_title
                        MelonTextView melonTextView0 = (MelonTextView)De.I.C(view4, 0x7F0A0CD1);  // id:tv_notice_title
                        if(melonTextView0 == null) {
                            throw new NullPointerException("Missing required view with ID: " + view4.getResources().getResourceName(v1));
                        }
                        int v2 = 0x7F0A036A;  // id:ctl_action
                        x x0 = new x(((CardView)view4), shapeableImageView0, melonTextView0, 8);
                        View view5 = De.I.C(view0, 0x7F0A0323);  // id:container_chat_banner_notice
                        if(view5 == null) {
                            v = 0x7F0A0323;  // id:container_chat_banner_notice
                            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
                        }
                        else {
                            if(((ConstraintLayout)De.I.C(view5, 0x7F0A036A)) == null) {  // id:ctl_action
                                v1 = v2;
                                throw new NullPointerException("Missing required view with ID: " + view5.getResources().getResourceName(v1));
                            }
                            v2 = 0x7F0A0C03;  // id:tv_action_text
                            MelonTextView melonTextView1 = (MelonTextView)De.I.C(view5, 0x7F0A0C03);  // id:tv_action_text
                            if(melonTextView1 == null) {
                                v1 = v2;
                                throw new NullPointerException("Missing required view with ID: " + view5.getResources().getResourceName(v1));
                            }
                            v2 = 0x7F0A0CD0;  // id:tv_notice_text
                            MelonTextView melonTextView2 = (MelonTextView)De.I.C(view5, 0x7F0A0CD0);  // id:tv_notice_text
                            if(melonTextView2 == null) {
                                v1 = v2;
                                throw new NullPointerException("Missing required view with ID: " + view5.getResources().getResourceName(v1));
                            }
                            MelonTextView melonTextView3 = (MelonTextView)De.I.C(view5, 0x7F0A0CD1);  // id:tv_notice_title
                            if(melonTextView3 == null) {
                                throw new NullPointerException("Missing required view with ID: " + view5.getResources().getResourceName(v1));
                            }
                            u u0 = new u(((CardView)view5), melonTextView1, melonTextView2, melonTextView3);
                            v = 0x7F0A0324;  // id:container_chat_banner_song
                            View view6 = De.I.C(view0, 0x7F0A0324);  // id:container_chat_banner_song
                            if(view6 != null) {
                                int v3 = 0x7F0A0325;  // id:container_chat_banner_song_full
                                View view7 = De.I.C(view6, 0x7F0A0325);  // id:container_chat_banner_song_full
                                if(view7 == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v3));
                                }
                                int v4 = 0x7F0A016F;  // id:btn_like
                                View view8 = De.I.C(view7, 0x7F0A016F);  // id:btn_like
                                if(((CheckableImageView)view8) == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view7.getResources().getResourceName(v4));
                                }
                                if(((CardView)De.I.C(view7, 0x7F0A0210)) == null) {  // id:card_thumb
                                    v4 = 0x7F0A0210;  // id:card_thumb
                                    throw new NullPointerException("Missing required view with ID: " + view7.getResources().getResourceName(v4));
                                }
                                int v5 = 0x7F0A069A;  // id:iv_thumb
                                View view9 = De.I.C(view7, 0x7F0A069A);  // id:iv_thumb
                                if(((ImageView)view9) == null) {
                                    v4 = v5;
                                    throw new NullPointerException("Missing required view with ID: " + view7.getResources().getResourceName(v4));
                                }
                                if(((LinearLayout)De.I.C(view7, 0x7F0A0796)) == null) {  // id:ll_info
                                    v5 = 0x7F0A0796;  // id:ll_info
                                    v4 = v5;
                                    throw new NullPointerException("Missing required view with ID: " + view7.getResources().getResourceName(v4));
                                }
                                MelonTextView melonTextView4 = (MelonTextView)De.I.C(view7, 0x7F0A0C12);  // id:tv_artist
                                if(melonTextView4 == null) {
                                    v4 = 0x7F0A0C12;  // id:tv_artist
                                    throw new NullPointerException("Missing required view with ID: " + view7.getResources().getResourceName(v4));
                                }
                                v5 = 0x7F0A0D14;  // id:tv_song
                                MelonTextView melonTextView5 = (MelonTextView)De.I.C(view7, 0x7F0A0D14);  // id:tv_song
                                if(melonTextView5 == null) {
                                    v4 = v5;
                                    throw new NullPointerException("Missing required view with ID: " + view7.getResources().getResourceName(v4));
                                }
                                g2 g20 = new g2(((ConstraintLayout)view7), ((CheckableImageView)view8), ((ImageView)view9), melonTextView4, melonTextView5, 2);
                                View view10 = De.I.C(view6, 0x7F0A0326);  // id:container_chat_banner_song_normal
                                if(view10 == null) {
                                    v3 = 0x7F0A0326;  // id:container_chat_banner_song_normal
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v3));
                                }
                                View view11 = De.I.C(view10, 0x7F0A016F);  // id:btn_like
                                if(((CheckableImageView)view11) == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view10.getResources().getResourceName(v4));
                                }
                                if(((CardView)De.I.C(view10, 0x7F0A0210)) == null) {  // id:card_thumb
                                    v4 = 0x7F0A0210;  // id:card_thumb
                                    throw new NullPointerException("Missing required view with ID: " + view10.getResources().getResourceName(v4));
                                }
                                v4 = 0x7F0A069A;  // id:iv_thumb
                                View view12 = De.I.C(view10, 0x7F0A069A);  // id:iv_thumb
                                if(((ImageView)view12) == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view10.getResources().getResourceName(v4));
                                }
                                if(((LinearLayout)De.I.C(view10, 0x7F0A0796)) == null) {  // id:ll_info
                                    v4 = 0x7F0A0796;  // id:ll_info
                                    throw new NullPointerException("Missing required view with ID: " + view10.getResources().getResourceName(v4));
                                }
                                View view13 = De.I.C(view10, 0x7F0A0C12);  // id:tv_artist
                                if(((MelonTextView)view13) == null) {
                                    v4 = 0x7F0A0C12;  // id:tv_artist
                                    throw new NullPointerException("Missing required view with ID: " + view10.getResources().getResourceName(v4));
                                }
                                v4 = 0x7F0A0D14;  // id:tv_song
                                View view14 = De.I.C(view10, 0x7F0A0D14);  // id:tv_song
                                if(((MelonTextView)view14) == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view10.getResources().getResourceName(v4));
                                }
                                x x1 = new x(((ConstraintLayout)view6), g20, new g2(((CardView)view10), ((CheckableImageView)view11), ((ImageView)view12), ((MelonTextView)view13), ((MelonTextView)view14), 3), 9);
                                v = 0x7F0A0327;  // id:container_chat_input
                                ConstraintLayout constraintLayout0 = (ConstraintLayout)De.I.C(view0, 0x7F0A0327);  // id:container_chat_input
                                if(constraintLayout0 != null) {
                                    v = 0x7F0A032F;  // id:container_message
                                    View view15 = De.I.C(view0, 0x7F0A032F);  // id:container_message
                                    if(((LinearLayout)view15) != null) {
                                        v = 0x7F0A044E;  // id:error_view
                                        View view16 = De.I.C(view0, 0x7F0A044E);  // id:error_view
                                        if(((MelonTextView)view16) != null && ((ImageView)De.I.C(view0, 0x7F0A0560)) != null) {  // id:img_dot
                                            v = 0x7F0A0613;  // id:iv_close
                                            View view17 = De.I.C(view0, 0x7F0A0613);  // id:iv_close
                                            if(((ImageView)view17) != null && ((ImageView)De.I.C(view0, 0x7F0A0660)) != null && ((ImageView)De.I.C(view0, 0x7F0A0662)) != null) {  // id:iv_play_cnt
                                                v = 0x7F0A0683;  // id:iv_scroll_arrow
                                                View view18 = De.I.C(view0, 0x7F0A0683);  // id:iv_scroll_arrow
                                                if(((ImageView)view18) != null && ((LinearLayout)De.I.C(view0, 0x7F0A06FF)) != null) {  // id:layout_banner_back
                                                    v = 0x7F0A0724;  // id:layout_like_cnt
                                                    View view19 = De.I.C(view0, 0x7F0A0724);  // id:layout_like_cnt
                                                    if(((LinearLayout)view19) != null) {
                                                        v = 0x7F0A0735;  // id:layout_play_cnt
                                                        View view20 = De.I.C(view0, 0x7F0A0735);  // id:layout_play_cnt
                                                        if(((LinearLayout)view20) != null) {
                                                            v = 0x7F0A09D1;  // id:recycler_view
                                                            View view21 = De.I.C(view0, 0x7F0A09D1);  // id:recycler_view
                                                            if(((VideoChatCustomRecyclerView)view21) != null) {
                                                                v = 0x7F0A0B5F;  // id:text_send
                                                                View view22 = De.I.C(view0, 0x7F0A0B5F);  // id:text_send
                                                                if(((MelonTextView)view22) != null) {
                                                                    v = 0x7F0A0B96;  // id:title_container
                                                                    View view23 = De.I.C(view0, 0x7F0A0B96);  // id:title_container
                                                                    if(((ConstraintLayout)view23) != null && ((ConstraintLayout)De.I.C(view0, 0x7F0A0BCE)) != null) {  // id:top_container
                                                                        v = 0x7F0A0CB5;  // id:tv_message
                                                                        View view24 = De.I.C(view0, 0x7F0A0CB5);  // id:tv_message
                                                                        if(((MelonTextView)view24) != null) {
                                                                            v = 0x7F0A0CDD;  // id:tv_play_cnt
                                                                            View view25 = De.I.C(view0, 0x7F0A0CDD);  // id:tv_play_cnt
                                                                            if(((MelonTextView)view25) != null) {
                                                                                v = 0x7F0A0CDE;  // id:tv_play_reaction
                                                                                View view26 = De.I.C(view0, 0x7F0A0CDE);  // id:tv_play_reaction
                                                                                if(((MelonTextView)view26) != null && ((MelonTextView)De.I.C(view0, 0x7F0A0D34)) != null) {  // id:tv_title
                                                                                    this.f = new w3(((ConstraintLayout)view0), ((ConstraintLayout)view1), ((ImageButton)view2), ((ConstraintLayout)view3), x0, u0, x1, constraintLayout0, ((LinearLayout)view15), ((MelonTextView)view16), ((ImageView)view17), ((ImageView)view18), ((LinearLayout)view19), ((LinearLayout)view20), ((VideoChatCustomRecyclerView)view21), ((MelonTextView)view22), ((ConstraintLayout)view23), ((MelonTextView)view24), ((MelonTextView)view25), ((MelonTextView)view26));
                                                                                    q.f(((ConstraintLayout)view0), "getRoot(...)");
                                                                                    return (ConstraintLayout)view0;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        LogU.Companion.i("VideoChatFragment", "onDestroyView()");
        if(this.e != null && this.e.isShowing()) {
            VideoChatInputPopup videoChatInputPopup0 = this.e;
            if(videoChatInputPopup0 != null) {
                videoChatInputPopup0.dismiss();
            }
        }
        VideoSongListBottomSheetFragment videoSongListBottomSheetFragment0 = this.a;
        if(videoSongListBottomSheetFragment0 != null) {
            videoSongListBottomSheetFragment0.dismiss();
        }
        w3 w30 = this.f;
        q.d(w30);
        w30.o.removeOnScrollListener(this.h);
        super.onDestroyView();
        this.f = null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable v9.h h0, @Nullable String s) {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "savedInstanceState");
        this.d = bundle0.getBoolean("argIsFull");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putBoolean("argIsFull", this.d);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.mMenuId = "1000002967";
        w3 w30 = this.f;
        if(w30 != null) {
            String s = this.e0().getInputMessage();
            w30.r.setText(s);
        }
        l1.B("handleFullMode() isFullMode:", this.d, LogU.Companion, "VideoChatFragment");
        w3 w31 = this.f;
        q.d(w31);
        w3 w32 = this.f;
        q.d(w32);
        m m0 = new m(w31.d, w32.q);
        ViewUtils.INSTANCE.switchShowAndHide(m0, this.d);
        int v = this.d ? 0x7F06048A : 0x7F0604AA;  // color:transparent
        int v1 = ColorUtils.getColor(this.getContext(), v);
        if(this.d) {
            this.h0();
        }
        else {
            w3 w33 = this.f;
            q.d(w33);
            w33.a.setBackgroundColor(v1);
        }
        int v2 = 0x7F060145;  // color:gray050s
        int v3 = this.d ? 0x7F060153 : 0x7F060145;  // color:gray200e
        int v4 = ColorUtils.getColor(this.getContext(), v3);
        w3 w34 = this.f;
        q.d(w34);
        ((CardView)w34.f.c).setCardBackgroundColor(v4);
        w3 w35 = this.f;
        q.d(w35);
        ((CardView)w35.e.b).setCardBackgroundColor(v4);
        int v5 = 0x7F06016D;  // color:gray900s
        int v6 = ColorUtils.getColor(this.getContext(), (this.d ? 0x7F0604A1 : 0x7F06016D));  // color:white000e
        int v7 = ColorUtils.getColor(this.getContext(), (this.d ? 0x7F060179 : 0x7F06017C));  // color:green490e
        w3 w36 = this.f;
        q.d(w36);
        ((MelonTextView)w36.f.e).setTextColor(v6);
        w3 w37 = this.f;
        q.d(w37);
        ((MelonTextView)w37.f.d).setTextColor(v6);
        w3 w38 = this.f;
        q.d(w38);
        ((MelonTextView)w38.f.b).setTextColor(v7);
        w3 w39 = this.f;
        q.d(w39);
        ((MelonTextView)w39.e.d).setTextColor(v6);
        float f = this.d ? 12.0f : 4.0f;
        w3 w310 = this.f;
        q.d(w310);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = ((ConstraintLayout)w310.g.b).getLayoutParams();
        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).bottomMargin = ScreenUtils.dipToPixel(this.getContext(), f);
        boolean z = this.d;
        if(z) {
            v2 = 0x7F060144;  // color:gray050e
        }
        w3 w311 = this.f;
        q.d(w311);
        int v8 = ColorUtils.getColor(this.getContext(), v2);
        ((ShapeableImageView)w311.e.c).setBackgroundColor(v8);
        ((ShapeableImageView)w311.e.c).setStrokeColorResource((z ? 0x7F0604AE : 0x7F06014A));  // color:white120e
        boolean z1 = this.d;
        int v9 = 0x7F0604B7;  // color:white700e
        if(z1) {
            v5 = 0x7F0604B7;  // color:white700e
        }
        w3 w312 = this.f;
        q.d(w312);
        int v10 = ColorUtils.getColor(this.getContext(), v5);
        w312.r.setTextColor(v10);
        w3 w313 = this.f;
        q.d(w313);
        int v11 = ColorUtils.getColor(this.getContext(), (z1 ? 0x7F0604B4 : 0x7F06015D));  // color:white500e_support_high_contrast
        w313.r.setHintTextColor(v11);
        w3 w314 = this.f;
        q.d(w314);
        w314.i.setBackgroundResource((z1 ? 0x7F080912 : 0x7F0808CE));  // drawable:shape_rectangle_white220e_1dp_stroke_round20
        if(!this.d) {
            v9 = 0x7F06008E;  // color:color_7b7b7b
        }
        w3 w315 = this.f;
        q.d(w315);
        int v12 = ColorUtils.getColor(this.getContext(), v9);
        w315.j.setTextColor(v12);
        int v13 = this.d ? 0x7F08009E : 0x7F08009D;  // drawable:arrow_scroll_down_dark
        w3 w316 = this.f;
        q.d(w316);
        w316.l.setImageResource(v13);
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.player.video.chat.ChatAdapter");
        ((ChatAdapter)j00).addMessageList(this.e0().getMessageList());
        this.e0().clearNewMessageList(true);
        this.e0().getNewMessageList().observe(this.getViewLifecycleOwner(), new f(this, 1));
        this.e0().getEventClear().observe(this.getViewLifecycleOwner(), new f(this, 5));
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new we.n(null) {
            public int r;
            public final VideoChatFragment w;

            {
                this.w = videoChatFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoChatFragment.onViewCreated.3(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoChatFragment.onViewCreated.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.player.video.VideoChatFragment.onViewCreated.3.1 videoChatFragment$onViewCreated$3$10 = new we.n(null) {
                            public int r;
                            public final VideoChatFragment w;

                            {
                                this.w = videoChatFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoChatFragment.onViewCreated.3.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoChatFragment.onViewCreated.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = this.w.f0().getChatCheerIconVisibility();
                                        com.iloen.melon.player.video.VideoChatFragment.onViewCreated.3.1.1 videoChatFragment$onViewCreated$3$1$10 = new FlowCollector() {
                                            public final VideoChatFragment a;

                                            {
                                                this.a = videoChatFragment0;
                                            }

                                            public final Object emit(int v, Continuation continuation0) {
                                                VideoChatFragment.access$getBinding(this.a).c.setVisibility(v);
                                                return H.a;
                                            }

                                            @Override  // kotlinx.coroutines.flow.FlowCollector
                                            public Object emit(Object object0, Continuation continuation0) {
                                                return this.emit(((Number)object0).intValue(), continuation0);
                                            }
                                        };
                                        this.r = 1;
                                        if(stateFlow0.collect(videoChatFragment$onViewCreated$3$1$10, this) == a0) {
                                            return a0;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                        };
                        this.r = 1;
                        return f0.j(this.w, s.e, videoChatFragment$onViewCreated$3$10, this) == a0 ? a0 : H.a;
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
        }, 3, null);
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new we.n(null) {
            public int r;
            public final VideoChatFragment w;

            {
                this.w = videoChatFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoChatFragment.onViewCreated.4(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoChatFragment.onViewCreated.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.video.VideoChatFragment.onViewCreated.4.1 videoChatFragment$onViewCreated$4$10 = new we.n(null) {
                            public int r;
                            public final VideoChatFragment w;

                            {
                                this.w = videoChatFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoChatFragment.onViewCreated.4.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoChatFragment.onViewCreated.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = this.w.e0().getUpdateChatOrErrorFlow();
                                        com.iloen.melon.player.video.VideoChatFragment.onViewCreated.4.1.1 videoChatFragment$onViewCreated$4$1$10 = new we.n(null) {
                                            public Object r;
                                            public final VideoChatFragment w;

                                            {
                                                this.w = videoChatFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.player.video.VideoChatFragment.onViewCreated.4.1.1(this.w, continuation0);
                                                continuation1.r = object0;
                                                return continuation1;
                                            }

                                            public final Object invoke(ChatUi chatUi0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.VideoChatFragment.onViewCreated.4.1.1)this.create(chatUi0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((ChatUi)object0), ((Continuation)object1));
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                ChatUi chatUi0 = (ChatUi)this.r;
                                                d5.n.D(object0);
                                                LogU.Companion.d("VideoChatFragment", "onViewCreated() - chatUi : " + chatUi0);
                                                VideoChatFragment.access$updateChatUI(this.w, chatUi0);
                                                return H.a;
                                            }
                                        };
                                        this.r = 1;
                                        return FlowKt.collectLatest(stateFlow0, videoChatFragment$onViewCreated$4$1$10, this) == a0 ? a0 : H.a;
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
                        };
                        this.r = 1;
                        return f0.j(d0, s.e, videoChatFragment$onViewCreated$4$10, this) == a0 ? a0 : H.a;
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
        }, 3, null);
        w3 w317 = this.f;
        q.d(w317);
        e e0 = new e(this, 4);
        w317.r.setOnClickListener(e0);
        w3 w318 = this.f;
        q.d(w318);
        e e1 = new e(this, 0);
        w318.p.setOnClickListener(e1);
        w3 w319 = this.f;
        q.d(w319);
        e e2 = new e(this, 1);
        w319.c.setOnClickListener(e2);
        w3 w320 = this.f;
        q.d(w320);
        e e3 = new e(this, 2);
        w320.l.setOnClickListener(e3);
        w3 w321 = this.f;
        q.d(w321);
        e e4 = new e(this, 3);
        w321.k.setOnClickListener(e4);
        D d0 = this.getViewLifecycleOwner();
        f f1 = new f(this, 0);
        A9.f.h.observe(d0, f1);
        D d1 = this.getViewLifecycleOwner();
        VideoChatFragment.sam.androidx_lifecycle_Observer.0 videoChatFragment$sam$androidx_lifecycle_Observer$00 = new VideoChatFragment.sam.androidx_lifecycle_Observer.0(new com.iloen.melon.player.video.g(this, 0));
        A9.f.g.observe(d1, videoChatFragment$sam$androidx_lifecycle_Observer$00);
        D d2 = this.getViewLifecycleOwner();
        VideoChatFragment.sam.androidx_lifecycle_Observer.0 videoChatFragment$sam$androidx_lifecycle_Observer$01 = new VideoChatFragment.sam.androidx_lifecycle_Observer.0(new com.iloen.melon.player.video.g(this, 1));
        A9.f.f.observe(d2, videoChatFragment$sam$androidx_lifecycle_Observer$01);
        this.f0().getLiveRes().observe(this.getViewLifecycleOwner(), new f(this, 2));
        D d3 = this.getViewLifecycleOwner();
        q.f(d3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d3), null, null, new we.n(null) {
            public int r;
            public final VideoChatFragment w;

            {
                this.w = videoChatFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoChatFragment.onViewCreated.14(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoChatFragment.onViewCreated.14)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        StateFlow stateFlow0 = this.w.f0().getPollingAble();
                        com.iloen.melon.player.video.VideoChatFragment.onViewCreated.14.1 videoChatFragment$onViewCreated$14$10 = new FlowCollector() {
                            public final VideoChatFragment a;

                            {
                                this.a = videoChatFragment0;
                            }

                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public Object emit(Object object0, Continuation continuation0) {
                                return this.emit(((Boolean)object0).booleanValue(), continuation0);
                            }

                            public final Object emit(boolean z, Continuation continuation0) {
                                VideoChatFragment.access$getBinding(this.a).m.setVisibility((z ? 0 : 8));
                                VideoChatFragment.access$getBinding(this.a).n.setVisibility((z ? 0 : 8));
                                return H.a;
                            }
                        };
                        this.r = 1;
                        if(stateFlow0.collect(videoChatFragment$onViewCreated$14$10, this) == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }, 3, null);
        D d4 = this.getViewLifecycleOwner();
        q.f(d4, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d4), null, null, new we.n(null) {
            public int r;
            public final VideoChatFragment w;

            {
                this.w = videoChatFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoChatFragment.onViewCreated.15(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoChatFragment.onViewCreated.15)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        StateFlow stateFlow0 = this.w.f0().getViewCnt();
                        com.iloen.melon.player.video.VideoChatFragment.onViewCreated.15.1 videoChatFragment$onViewCreated$15$10 = new we.n(null) {
                            public Object r;
                            public final VideoChatFragment w;

                            {
                                this.w = videoChatFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.VideoChatFragment.onViewCreated.15.1(this.w, continuation0);
                                continuation1.r = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((String)object0), ((Continuation)object1));
                            }

                            public final Object invoke(String s, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoChatFragment.onViewCreated.15.1)this.create(s, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                String s = (String)this.r;
                                d5.n.D(object0);
                                w3 w30 = VideoChatFragment.access$getBinding(this.w);
                                Context context0 = this.w.requireContext();
                                q.f(context0, "requireContext(...)");
                                String s1 = Cb.k.a(context0, s);
                                w30.s.setText(s1);
                                return H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(stateFlow0, videoChatFragment$onViewCreated$15$10, this) == a0 ? a0 : H.a;
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
        }, 3, null);
        this.f0().getLikeCnt().observe(this.getViewLifecycleOwner(), new f(this, 3));
        this.f0().isLiked().observe(this.getViewLifecycleOwner(), new f(this, 4));
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean shouldIgnoreSetUIOnForegroundEvent() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }
}

