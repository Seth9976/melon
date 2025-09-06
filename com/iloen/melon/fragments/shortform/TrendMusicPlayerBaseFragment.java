package com.iloen.melon.fragments.shortform;

import Ob.b;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import com.iloen.melon.mcache.CacheUrlBuilder;
import com.iloen.melon.mcache.error.MCacheError;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST.MEDIAINFO;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import com.iloen.melon.player.trackzero.SinglePlayer.SinglePlayerCallback;
import com.iloen.melon.player.trackzero.SinglePlayer;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import ie.H;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000F\u0010\u000E\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u000E\u0010\u0003J\r\u0010\u000F\u001A\u00020\u0006¢\u0006\u0004\b\u000F\u0010\u0003J\r\u0010\u0010\u001A\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0003J\r\u0010\u0011\u001A\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0003J\u0015\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001A\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendMusicPlayerBaseFragment;", "Lcom/iloen/melon/fragments/shortform/TrendShortBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onPause", "onDestroy", "play", "pause", "stop", "", "url", "setPath", "(Ljava/lang/String;)V", "Lcom/iloen/melon/player/trackzero/SinglePlayer;", "trendPlayer", "Lcom/iloen/melon/player/trackzero/SinglePlayer;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class TrendMusicPlayerBaseFragment extends TrendShortBaseFragment {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendMusicPlayerBaseFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_POSITION", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final String ARG_POSITION = "argPosition";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "TrendVideoPlayerBaseFragment";
    private SinglePlayer trendPlayer;

    static {
        TrendMusicPlayerBaseFragment.Companion = new Companion(null);
        TrendMusicPlayerBaseFragment.$stable = 8;
    }

    @Override  // androidx.fragment.app.I
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        SinglePlayer singlePlayer0 = new SinglePlayer(context0);
        singlePlayer0.setCallback(new SinglePlayerCallback() {
            @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
            public void onCompletion() {
            }

            @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
            public void onError(String s) {
                q.g(s, "error");
                if(TrendMusicPlayerBaseFragment.this.getLifecycle().b() == s.e) {
                    TrendMusicPlayerBaseFragment.this.failToPlayMedia();
                }
            }

            @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
            public void onPlaybackStateChanged(boolean z, int v) {
            }

            @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
            public void onPlaybackTransitions() {
            }
        });
        this.trendPlayer = singlePlayer0;
    }

    @Override  // androidx.fragment.app.I
    public void onDestroy() {
        SinglePlayer singlePlayer0 = this.trendPlayer;
        if(singlePlayer0 != null) {
            singlePlayer0.release();
        }
        super.onDestroy();
    }

    @Override  // androidx.fragment.app.I
    public void onPause() {
        super.onPause();
        this.pause();
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        List list0 = (List)this.getViewModel().getList().getValue();
        SLOTLIST trendShortFormRes$Response$SLOTLIST0 = list0 == null ? null : ((SLOTLIST)p.n0(this.getTabPosition(), list0));
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getMain(), null, new n(trendShortFormRes$Response$SLOTLIST0, null) {
            final SLOTLIST $item;
            int label;

            {
                TrendMusicPlayerBaseFragment.this = trendMusicPlayerBaseFragment0;
                this.$item = trendShortFormRes$Response$SLOTLIST0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.shortform.TrendMusicPlayerBaseFragment.onViewCreated.1(TrendMusicPlayerBaseFragment.this, this.$item, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.shortform.TrendMusicPlayerBaseFragment.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = TrendMusicPlayerBaseFragment.this.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.fragments.shortform.TrendMusicPlayerBaseFragment.onViewCreated.1.1 trendMusicPlayerBaseFragment$onViewCreated$1$10 = new n(this.$item, null) {
                            final SLOTLIST $item;
                            int label;

                            {
                                TrendMusicPlayerBaseFragment.this = trendMusicPlayerBaseFragment0;
                                this.$item = trendShortFormRes$Response$SLOTLIST0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.shortform.TrendMusicPlayerBaseFragment.onViewCreated.1.1(TrendMusicPlayerBaseFragment.this, this.$item, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.shortform.TrendMusicPlayerBaseFragment.onViewCreated.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = TrendMusicPlayerBaseFragment.this.getViewModel().getSoundAble();
                                        com.iloen.melon.fragments.shortform.TrendMusicPlayerBaseFragment.onViewCreated.1.1.1 trendMusicPlayerBaseFragment$onViewCreated$1$1$10 = new n(this.$item, null) {
                                            final SLOTLIST $item;
                                            boolean Z$0;
                                            int label;

                                            {
                                                TrendMusicPlayerBaseFragment.this = trendMusicPlayerBaseFragment0;
                                                this.$item = trendShortFormRes$Response$SLOTLIST0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.fragments.shortform.TrendMusicPlayerBaseFragment.onViewCreated.1.1.1(TrendMusicPlayerBaseFragment.this, this.$item, continuation0);
                                                continuation1.Z$0 = ((Boolean)object0).booleanValue();
                                                return continuation1;
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                                            }

                                            public final Object invoke(boolean z, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.shortform.TrendMusicPlayerBaseFragment.onViewCreated.1.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                String s5;
                                                String s1;
                                                boolean z = this.Z$0;
                                                if(this.label != 0) {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                                d5.n.D(object0);
                                                SinglePlayer singlePlayer0 = TrendMusicPlayerBaseFragment.this.trendPlayer;
                                                String s = null;
                                                if(singlePlayer0 != null) {
                                                    boolean z1 = singlePlayer0.isReadyToPlay();
                                                    H h0 = H.a;
                                                    if(!z1 && z) {
                                                        SLOTLIST trendShortFormRes$Response$SLOTLIST0 = this.$item;
                                                        if(trendShortFormRes$Response$SLOTLIST0 == null) {
                                                            s1 = null;
                                                        }
                                                        else {
                                                            MEDIAINFO trendShortFormRes$Response$SLOTLIST$MEDIAINFO0 = trendShortFormRes$Response$SLOTLIST0.mediaInfo;
                                                            s1 = trendShortFormRes$Response$SLOTLIST$MEDIAINFO0 == null ? null : trendShortFormRes$Response$SLOTLIST$MEDIAINFO0.protocolType;
                                                        }
                                                        String s2 = "";
                                                        if("MCACHE".equals(s1)) {
                                                            MEDIAINFO trendShortFormRes$Response$SLOTLIST$MEDIAINFO1 = this.$item.mediaInfo;
                                                            String s3 = new CacheUrlBuilder((trendShortFormRes$Response$SLOTLIST$MEDIAINFO1 == null ? null : trendShortFormRes$Response$SLOTLIST$MEDIAINFO1.path), (trendShortFormRes$Response$SLOTLIST$MEDIAINFO1 == null ? null : trendShortFormRes$Response$SLOTLIST$MEDIAINFO1.contsId)).cacheEnable(b.b()).build();
                                                            try {
                                                                q.d(s3);
                                                                MEDIAINFO trendShortFormRes$Response$SLOTLIST$MEDIAINFO2 = this.$item.mediaInfo;
                                                                String s4 = trendShortFormRes$Response$SLOTLIST$MEDIAINFO2 == null ? null : trendShortFormRes$Response$SLOTLIST$MEDIAINFO2.c;
                                                                q.d(s4);
                                                                s5 = "";
                                                                s5 = b.c(s3, s4);
                                                                if(!URLUtil.isNetworkUrl(s5)) {
                                                                    throw new MCacheError("Wrong mcache path: " + s5 + ", src:" + s3);
                                                                }
                                                            }
                                                            catch(Exception exception0) {
                                                                LogU.Companion.e("TrendVideoPlayerBaseFragment", "mcache path error: " + exception0);
                                                            }
                                                        }
                                                        else {
                                                            SLOTLIST trendShortFormRes$Response$SLOTLIST1 = this.$item;
                                                            if(trendShortFormRes$Response$SLOTLIST1 == null) {
                                                                s5 = "";
                                                            }
                                                            else {
                                                                MEDIAINFO trendShortFormRes$Response$SLOTLIST$MEDIAINFO3 = trendShortFormRes$Response$SLOTLIST1.mediaInfo;
                                                                if(trendShortFormRes$Response$SLOTLIST$MEDIAINFO3 == null) {
                                                                    s5 = "";
                                                                }
                                                                else {
                                                                    String s6 = trendShortFormRes$Response$SLOTLIST$MEDIAINFO3.path;
                                                                    s5 = s6 == null ? "" : s6;
                                                                }
                                                            }
                                                        }
                                                        SLOTLIST trendShortFormRes$Response$SLOTLIST2 = this.$item;
                                                        if(trendShortFormRes$Response$SLOTLIST2 != null) {
                                                            s = trendShortFormRes$Response$SLOTLIST2.uiType;
                                                        }
                                                        if(s != null) {
                                                            s2 = s;
                                                        }
                                                        if(s5.length() == 0 && "M03".equals(s2)) {
                                                            ToastManager.show(0x7F1303DB);  // string:error_no_sound_contents "사운드가 없는 콘텐츠입니다"
                                                            return h0;
                                                        }
                                                        TrendMusicPlayerBaseFragment.this.setPath(s5);
                                                    }
                                                    if(z) {
                                                        TrendMusicPlayerBaseFragment.this.play();
                                                        return h0;
                                                    }
                                                    TrendMusicPlayerBaseFragment.this.pause();
                                                    return h0;
                                                }
                                                q.m("trendPlayer");
                                                throw null;
                                            }
                                        };
                                        this.label = 1;
                                        return FlowKt.collectLatest(stateFlow0, trendMusicPlayerBaseFragment$onViewCreated$1$1$10, this) == a0 ? a0 : H.a;
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
                        this.label = 1;
                        return f0.j(d0, s.e, trendMusicPlayerBaseFragment$onViewCreated$1$10, this) == a0 ? a0 : H.a;
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

    public final void pause() {
        SinglePlayer singlePlayer0 = this.trendPlayer;
        if(singlePlayer0 != null) {
            singlePlayer0.seekTo(0L);
            SinglePlayer singlePlayer1 = this.trendPlayer;
            if(singlePlayer1 != null) {
                singlePlayer1.pause();
                return;
            }
            q.m("trendPlayer");
            throw null;
        }
    }

    public final void play() {
        SinglePlayer singlePlayer0 = this.trendPlayer;
        if(singlePlayer0 != null) {
            singlePlayer0.start();
        }
    }

    public final void setPath(@NotNull String s) {
        q.g(s, "url");
        SinglePlayer singlePlayer0 = this.trendPlayer;
        if(singlePlayer0 != null) {
            Uri uri0 = Uri.parse(s);
            q.f(uri0, "parse(...)");
            singlePlayer0.setDataSource(uri0, true);
        }
    }

    public final void stop() {
        SinglePlayer singlePlayer0 = this.trendPlayer;
        if(singlePlayer0 != null) {
            singlePlayer0.stop(false);
        }
    }
}

