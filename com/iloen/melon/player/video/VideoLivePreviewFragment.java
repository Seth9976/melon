package com.iloen.melon.player.video;

import De.d;
import H8.i;
import J8.H;
import J8.e3;
import Q0.t0;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.n;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.LiveNotificationButton;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.FetcherBaseFragment;
import com.iloen.melon.fragments.MelonBaseFragment.OnArtistClickListener;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response.Live;
import com.iloen.melon.net.v6x.response.LiveDetailRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.ArtistsInfoBase;
import d3.g;
import ie.j;
import ie.k;
import ie.m;
import ie.r;
import java.util.ArrayList;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import m0.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import v8.h;
import we.a;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000EJ-\u0010\u0015\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001A\u00020\u000F2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00112\b\u0010\u0013\u001A\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0018\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\'\u0010\u001F\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\u0007H\u0014¢\u0006\u0004\b\u001F\u0010 J\u0017\u0010\"\u001A\u00020\f2\u0006\u0010!\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010#J\u0011\u0010%\u001A\u0004\u0018\u00010$H\u0014¢\u0006\u0004\b%\u0010&J\u0019\u0010)\u001A\u0004\u0018\u00010$2\u0006\u0010(\u001A\u00020\'H\u0014¢\u0006\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/iloen/melon/player/video/VideoLivePreviewFragment;", "Lcom/iloen/melon/fragments/FetcherBaseFragment;", "<init>", "()V", "", "shouldIgnoreSetUIOnForegroundEvent", "()Z", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "show", "showProgress", "(Z)V", "", "onCreateRecyclerView", "()Ljava/lang/Void;", "Landroid/content/Context;", "context", "createRecyclerViewAdapter", "(Landroid/content/Context;)Ljava/lang/Void;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoLivePreviewFragment extends FetcherBaseFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/player/video/VideoLivePreviewFragment$Companion;", "", "Lcom/iloen/melon/player/video/VideoLivePreviewFragment;", "newInstance", "()Lcom/iloen/melon/player/video/VideoLivePreviewFragment;", "", "TAG", "Ljava/lang/String;", "", "MAX_ARTIST_VISIBLE_COUNT", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final VideoLivePreviewFragment newInstance() {
            return new VideoLivePreviewFragment();
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final r a;
    public final i b;
    public H c;

    static {
        VideoLivePreviewFragment.Companion = new Companion(null);
        VideoLivePreviewFragment.$stable = 8;
    }

    public VideoLivePreviewFragment() {
        new LogU("VideoLivePreviewFragment");
        this.a = g.Q(new c(this, 1));
        com.iloen.melon.player.video.VideoLivePreviewFragment.special..inlined.viewModels.default.2 videoLivePreviewFragment$special$$inlined$viewModels$default$20 = new a() {
            public final a f;

            {
                this.f = a0;
                super(0);
            }

            @NotNull
            public final r0 invoke() {
                return (r0)this.f.invoke();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        j j0 = g.P(k.c, videoLivePreviewFragment$special$$inlined$viewModels$default$20);
        d d0 = I.a.b(VideoLivePreviewViewModel.class);
        com.iloen.melon.player.video.VideoLivePreviewFragment.special..inlined.viewModels.default.3 videoLivePreviewFragment$special$$inlined$viewModels$default$30 = new a() {
            public final j f;

            {
                this.f = j0;
                super(0);
            }

            @NotNull
            public final q0 invoke() {
                return ((r0)this.f.getValue()).getViewModelStore();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        com.iloen.melon.player.video.VideoLivePreviewFragment.special..inlined.viewModels.default.4 videoLivePreviewFragment$special$$inlined$viewModels$default$40 = new a(j0) {
            public final a f;
            public final j g;

            {
                this.f = a0;
                this.g = j0;
                super(0);
            }

            @NotNull
            public final S2.c invoke() {
                a a0 = this.f;
                if(a0 != null) {
                    S2.c c0 = (S2.c)a0.invoke();
                    if(c0 != null) {
                        return c0;
                    }
                }
                r0 r00 = (r0)this.g.getValue();
                n n0 = r00 instanceof n ? ((n)r00) : null;
                return n0 != null ? n0.getDefaultViewModelCreationExtras() : S2.a.b;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        this.b = new i(d0, videoLivePreviewFragment$special$$inlined$viewModels$default$30, new a(j0) {
            public final androidx.fragment.app.I f;
            public final j g;

            {
                this.f = i0;
                this.g = j0;
                super(0);
            }

            @NotNull
            public final o0 invoke() {
                r0 r00 = (r0)this.g.getValue();
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
        }, videoLivePreviewFragment$special$$inlined$viewModels$default$40);

        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001A\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/m0;", "VM", "Landroidx/fragment/app/I;", "invoke", "()Landroidx/fragment/app/I;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.video.VideoLivePreviewFragment.special..inlined.viewModels.default.1 extends kotlin.jvm.internal.r implements a {
            public final androidx.fragment.app.I f;

            public com.iloen.melon.player.video.VideoLivePreviewFragment.special..inlined.viewModels.default.1(androidx.fragment.app.I i0) {
                this.f = i0;
                super(0);
            }

            @NotNull
            public final androidx.fragment.app.I invoke() {
                return this.f;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public static void K(VideoLivePreviewFragment videoLivePreviewFragment0, LiveDetailRes liveDetailRes0) {
        Live liveDetailRes$Response$Live0 = liveDetailRes0.response == null ? null : liveDetailRes0.response.live;
        Iterable iterable0 = e.k.A(new String[]{(liveDetailRes$Response$Live0 == null ? null : liveDetailRes$Response$Live0.text1), (liveDetailRes$Response$Live0 == null ? null : liveDetailRes$Response$Live0.text2)});
        H h0 = videoLivePreviewFragment0.c;
        q.d(h0);
        H h1 = videoLivePreviewFragment0.c;
        q.d(h1);
        for(Object object0: p.W0(iterable0, e.k.A(new MelonTextView[]{h0.d, h1.e}))) {
            String s = (String)((m)object0).a;
            q.f(((m)object0).b, "component2(...)");
            MelonTextView melonTextView0 = (MelonTextView)((m)object0).b;
            if(s != null && s.length() != 0) {
                melonTextView0.setVisibility(0);
                melonTextView0.setText(s);
            }
            else {
                melonTextView0.setVisibility(8);
            }
        }
        ArrayList arrayList0 = liveDetailRes$Response$Live0 == null ? null : liveDetailRes$Response$Live0.artistList;
        Context context0 = videoLivePreviewFragment0.getContext();
        if(context0 != null) {
            if(arrayList0 == null || arrayList0.isEmpty()) {
                H h10 = videoLivePreviewFragment0.c;
                q.d(h10);
                ((RelativeLayout)h10.h).setVisibility(8);
            }
            else {
                H h2 = videoLivePreviewFragment0.c;
                q.d(h2);
                ((RelativeLayout)h2.h).setVisibility(0);
                H h3 = videoLivePreviewFragment0.c;
                q.d(h3);
                H h4 = videoLivePreviewFragment0.c;
                q.d(h4);
                H h5 = videoLivePreviewFragment0.c;
                q.d(h5);
                int v = 0;
                for(Object object1: e.k.A(new e3[]{((e3)h3.m), ((e3)h4.n), ((e3)h5.o)})) {
                    if(v >= 0) {
                        ArtistsInfoBase artistsInfoBase0 = (ArtistsInfoBase)p.n0(v, arrayList0);
                        if(artistsInfoBase0 == null) {
                            ((e3)object1).a.setVisibility(8);
                        }
                        else {
                            ((e3)object1).a.setVisibility(0);
                            Glide.with(context0).load(artistsInfoBase0.getArtistImg()).apply(RequestOptions.circleCropTransform()).into(((e3)object1).b);
                        }
                        ++v;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
                H h6 = videoLivePreviewFragment0.c;
                q.d(h6);
                String s1 = ProtocolUtils.getArtistNames(p.K0(2, arrayList0));
                h6.f.setText(s1);
                int v1 = arrayList0.size();
                if(v1 > 2) {
                    H h7 = videoLivePreviewFragment0.c;
                    q.d(h7);
                    h7.g.setVisibility(0);
                    H h8 = videoLivePreviewFragment0.c;
                    q.d(h8);
                    q.f("외 %d명", "getString(...)");
                    l1.D(new Object[]{((int)(v1 - 2))}, 1, "외 %d명", h8.g);
                }
                else {
                    H h9 = videoLivePreviewFragment0.c;
                    q.d(h9);
                    h9.g.setVisibility(8);
                }
            }
        }
        H h11 = videoLivePreviewFragment0.c;
        q.d(h11);
        h11.c.setVisibility(0);
        videoLivePreviewFragment0.onFetchSuccessUI(new v8.i(h.a, v9.i.b, liveDetailRes0, null));
        ((VideoLivePreviewViewModel)videoLivePreviewFragment0.b.getValue()).updateLiveSeqAndFetchSubApis((liveDetailRes$Response$Live0 == null ? null : liveDetailRes$Response$Live0.liveSeq));
        videoLivePreviewFragment0.mMelonTiaraProperty = new s(liveDetailRes0.response.section, liveDetailRes0.response.page, liveDetailRes0.getMenuId(), null);
    }

    public final LiveViewModel L() {
        return (LiveViewModel)this.a.getValue();
    }

    public static final void access$sendArtistClickLog(VideoLivePreviewFragment videoLivePreviewFragment0, String s, String s1) {
        videoLivePreviewFragment0.getClass();
        if(s != null && s.length() != 0) {
            e1.m.F(new U(videoLivePreviewFragment0, ((Playable)videoLivePreviewFragment0.L().getCurrentVideoPlayable().getValue()), s, s1)).track();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return (j0)this.createRecyclerViewAdapter(context0);
    }

    @Nullable
    public Void createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.c1.buildUpon().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Nullable
    public Void onCreateRecyclerView() [...] // Inlined contents

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = this.getLayoutInflater().inflate(0x7F0D08E5, viewGroup0, false);  // layout:video_live_preview_layout
        int v = 0x7F0A00B7;  // id:artist_layout
        View view1 = De.I.C(view0, 0x7F0A00B7);  // id:artist_layout
        if(((RelativeLayout)view1) != null && ((FrameLayout)De.I.C(view0, 0x7F0A00BE)) != null) {  // id:artist_thumb_container
            v = 0x7F0A01E9;  // id:buttton_subscribe
            View view2 = De.I.C(view0, 0x7F0A01E9);  // id:buttton_subscribe
            if(((LiveNotificationButton)view2) != null) {
                v = 0x7F0A05FA;  // id:iv_banner
                View view3 = De.I.C(view0, 0x7F0A05FA);  // id:iv_banner
                if(((MelonImageView)view3) != null) {
                    v = 0x7F0A07C9;  // id:main_contents_layout
                    View view4 = De.I.C(view0, 0x7F0A07C9);  // id:main_contents_layout
                    if(((LinearLayout)view4) != null) {
                        v = 0x7F0A0804;  // id:mid_compose_view
                        View view5 = De.I.C(view0, 0x7F0A0804);  // id:mid_compose_view
                        if(((ComposeView)view5) != null) {
                            v = 0x7F0A097E;  // id:progress
                            View view6 = De.I.C(view0, 0x7F0A097E);  // id:progress
                            if(((ProgressBar)view6) != null) {
                                v = 0x7F0A0B4A;  // id:text1
                                View view7 = De.I.C(view0, 0x7F0A0B4A);  // id:text1
                                if(((MelonTextView)view7) != null) {
                                    v = 0x7F0A0B4B;  // id:text2
                                    View view8 = De.I.C(view0, 0x7F0A0B4B);  // id:text2
                                    if(((MelonTextView)view8) != null) {
                                        v = 0x7F0A0B7A;  // id:thumb_layout1
                                        View view9 = De.I.C(view0, 0x7F0A0B7A);  // id:thumb_layout1
                                        if(view9 != null) {
                                            e3 e30 = e3.a(view9);
                                            v = 0x7F0A0B7B;  // id:thumb_layout2
                                            View view10 = De.I.C(view0, 0x7F0A0B7B);  // id:thumb_layout2
                                            if(view10 != null) {
                                                e3 e31 = e3.a(view10);
                                                v = 0x7F0A0B7C;  // id:thumb_layout3
                                                View view11 = De.I.C(view0, 0x7F0A0B7C);  // id:thumb_layout3
                                                if(view11 != null) {
                                                    e3 e32 = e3.a(view11);
                                                    v = 0x7F0A0C12;  // id:tv_artist
                                                    View view12 = De.I.C(view0, 0x7F0A0C12);  // id:tv_artist
                                                    if(((MelonTextView)view12) != null) {
                                                        v = 0x7F0A0C72;  // id:tv_exception
                                                        View view13 = De.I.C(view0, 0x7F0A0C72);  // id:tv_exception
                                                        if(((MelonTextView)view13) != null) {
                                                            this.c = new H(((ConstraintLayout)view0), ((RelativeLayout)view1), ((LiveNotificationButton)view2), ((MelonImageView)view3), ((LinearLayout)view4), ((ComposeView)view5), ((ProgressBar)view6), ((MelonTextView)view7), ((MelonTextView)view8), e30, e31, e32, ((MelonTextView)view12), ((MelonTextView)view13));
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
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull v9.i i0, @NotNull v9.h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        H h0 = this.c;
        q.d(h0);
        int v = ScreenUtils.dipToPixel(this.getContext(), 32.0f);
        ViewUtils.setDefaultImage(((e3)h0.m).c, v, true);
        H h1 = this.c;
        q.d(h1);
        int v1 = ScreenUtils.dipToPixel(this.getContext(), 32.0f);
        ViewUtils.setDefaultImage(((e3)h1.n).c, v1, true);
        H h2 = this.c;
        q.d(h2);
        int v2 = ScreenUtils.dipToPixel(this.getContext(), 32.0f);
        ViewUtils.setDefaultImage(((e3)h2.o).c, v2, true);
        this.L().getLiveRes().observe(this.getViewLifecycleOwner(), new VideoLivePreviewFragment.sam.androidx_lifecycle_Observer.0(new S(this, 6)));
        this.L().getLivePreviewSubscribeManager().isSubscribe().observe(this.getViewLifecycleOwner(), new VideoLivePreviewFragment.sam.androidx_lifecycle_Observer.0(new S(this, 11)));
        H h3 = this.c;
        q.d(h3);
        W w0 = new W(this, 0);
        ((LiveNotificationButton)h3.i).setOnClickListener(w0);
        H h4 = this.c;
        q.d(h4);
        W w1 = new W(this, 1);
        ((RelativeLayout)h4.h).setOnClickListener(w1);
        ((VideoLivePreviewViewModel)this.b.getValue()).getBannerRes().observe(this.getViewLifecycleOwner(), new VideoLivePreviewFragment.sam.androidx_lifecycle_Observer.0(new S(this, 15)));
        H h5 = this.c;
        q.d(h5);
        ((ComposeView)h5.k).setViewCompositionStrategy(t0.d);
        b b0 = new b(-476855430, new X(this, 0), true);
        ((ComposeView)h5.k).setContent(b0);

        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0006\u001A\u00020\u00052\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\b\u001A\u00020\u00052\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"com/iloen/melon/player/video/VideoLivePreviewFragment$onViewCreated$4$1$1", "Lcom/iloen/melon/fragments/MelonBaseFragment$OnArtistClickListener;", "", "artistId", "artistName", "Lie/H;", "onBeforeClick", "(Ljava/lang/String;Ljava/lang/String;)V", "onAfterClick", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.video.VideoLivePreviewFragment.onViewCreated.4.1.1 implements OnArtistClickListener {
            public final VideoLivePreviewFragment a;

            public com.iloen.melon.player.video.VideoLivePreviewFragment.onViewCreated.4.1.1(VideoLivePreviewFragment videoLivePreviewFragment0) {
                this.a = videoLivePreviewFragment0;
            }

            @Override  // com.iloen.melon.fragments.MelonBaseFragment$OnArtistClickListener
            public void onAfterClick(String s, String s1) {
                VideoLivePreviewFragment.access$sendArtistClickLog(this.a, s, s1);
            }

            @Override  // com.iloen.melon.fragments.MelonBaseFragment$OnArtistClickListener
            public void onBeforeClick(String s, String s1) {
            }
        }

    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean shouldIgnoreSetUIOnForegroundEvent() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void showProgress(boolean z) {
        super.showProgress(z);
        H h0 = this.c;
        q.d(h0);
        ViewUtils.showWhen(((ProgressBar)h0.l), z);
    }
}

