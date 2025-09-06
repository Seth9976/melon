package com.iloen.melon.fragments.mymusic.playlist;

import C8.b;
import Cc.H3;
import Cc.N1;
import Cc.P0;
import Cc.T3;
import Cc.U;
import Cc.c1;
import Cc.e0;
import Cc.r0;
import G.C;
import G.I;
import G.X;
import G.f;
import H0.e;
import I.l0;
import J8.V0;
import K.m;
import Kd.g;
import M.c;
import M.j0;
import M.j;
import M.p0;
import M.q0;
import M.w;
import M.y;
import N0.M;
import O.F;
import P0.h;
import P0.i;
import P0.k;
import Q0.k0;
import U4.x;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.constants.CType;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.U0;
import com.melon.ui.c3;
import com.melon.ui.k3;
import com.melon.ui.m3;
import com.melon.ui.o3;
import com.melon.ui.p3;
import com.melon.ui.q3;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.a;
import r0.d;
import r0.n;
import we.o;

@Metadata(d1 = {"\u0000\u00B0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u0000 T2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001TB\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0017\u001A\u00020\u00102\u0006\u0010\u0016\u001A\u00020\u0015H\u0014\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001F\u0010\u001D\u001A\u00020\u00102\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u001C\u001A\u00020\u001BH\u0007\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010!\u001A\u00020\u00102\u0006\u0010 \u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b!\u0010\"J\\\u0010.\u001A\u00020\u00102\u0006\u0010 \u001A\u00020#2\u0006\u0010%\u001A\u00020$2\u000E\u0010\'\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010&2\u0012\u0010*\u001A\u000E\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00100(2\u0006\u0010,\u001A\u00020+2\u000E\u0010-\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010&H\u0096\u0001\u00A2\u0006\u0004\b.\u0010/Jb\u00106\u001A\u00020\u00102\u0006\u0010%\u001A\u00020$2\u0006\u00101\u001A\u0002002\f\u00104\u001A\b\u0012\u0004\u0012\u000203022\u000E\u0010\'\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010&2\u0012\u0010*\u001A\u000E\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00100(2\u0006\u0010,\u001A\u00020+2\u0006\u00105\u001A\u000200H\u0096\u0001\u00A2\u0006\u0004\b6\u00107J#\u0010;\u001A\u00020\u00102\b\b\u0002\u00109\u001A\u0002082\b\b\u0002\u0010:\u001A\u000200H\u0003\u00A2\u0006\u0004\b;\u0010<J\u0017\u0010=\u001A\u00020\u00102\u0006\u00109\u001A\u000208H\u0003\u00A2\u0006\u0004\b=\u0010>J?\u0010B\u001A\u00020\u00102\u0016\b\u0002\u0010@\u001A\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010&j\u0004\u0018\u0001`?2\u0016\b\u0002\u0010A\u001A\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010&j\u0004\u0018\u0001`?H\u0003\u00A2\u0006\u0004\bB\u0010CJ!\u0010E\u001A\u00020\u00102\b\b\u0002\u00109\u001A\u0002082\u0006\u0010\u0016\u001A\u00020DH\u0003\u00A2\u0006\u0004\bE\u0010FJ\u000F\u0010G\u001A\u00020\u0010H\u0003\u00A2\u0006\u0004\bG\u0010HJ\u000F\u0010I\u001A\u00020\u0010H\u0003\u00A2\u0006\u0004\bI\u0010HJ\u000F\u0010J\u001A\u00020\u0010H\u0003\u00A2\u0006\u0004\bJ\u0010HR\u0014\u0010L\u001A\u00020K8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bL\u0010MR\"\u0010N\u001A\u00020+8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\bN\u0010O\u001A\u0004\bN\u0010P\"\u0004\bQ\u0010RR\u0014\u0010S\u001A\u00020+8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bS\u0010P\u00A8\u0006W\u00B2\u0006\f\u0010V\u001A\u00020U8\nX\u008A\u0084\u0002"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistFragment;", "Lcom/melon/ui/o1;", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistViewModel;", "LJ8/V0;", "Lcom/melon/ui/k3;", "<init>", "()V", "Ljava/lang/Class;", "getViewModelClass", "()Ljava/lang/Class;", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)LJ8/V0;", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Lcom/melon/ui/K4;", "uiState", "renderUi", "(Lcom/melon/ui/K4;)V", "LKd/g;", "item", "", "position", "SongItem", "(LKd/g;ILandroidx/compose/runtime/l;I)V", "Lcom/melon/ui/I4;", "event", "onUiEvent", "(Lcom/melon/ui/I4;)V", "Lcom/melon/ui/o3;", "Landroidx/fragment/app/I;", "fragment", "Lkotlin/Function0;", "afterAction", "Lkotlin/Function1;", "LPc/e;", "sendUserEvent", "", "isNowPlayingList", "afterDismissAction", "handlePutPopupUiEvent", "(Lcom/melon/ui/o3;Landroidx/fragment/app/I;Lwe/a;Lwe/k;ZLwe/a;)V", "", "menuId", "", "Lcom/iloen/melon/playback/Playable;", "playableList", "ocrGroupId", "showContextMenuAddTo", "(Landroidx/fragment/app/I;Ljava/lang/String;Ljava/util/List;Lwe/a;Lwe/k;ZLjava/lang/String;)V", "Lr0/q;", "modifier", "titleString", "TitleLayout", "(Lr0/q;Ljava/lang/String;Landroidx/compose/runtime/l;II)V", "LoadingAnimation", "(Lr0/q;Landroidx/compose/runtime/l;I)V", "Lcom/melon/ui/Action;", "onButtonClick", "pickEvent", "ReSelectButton", "(Lwe/a;Lwe/a;Landroidx/compose/runtime/l;II)V", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Success;", "MainContent", "(Lr0/q;Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Success;Landroidx/compose/runtime/l;II)V", "LoadingPreview", "(Landroidx/compose/runtime/l;I)V", "errorView", "SongItemPreview", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "isScreenLandscapeSupported", "Z", "()Z", "setScreenLandscapeSupported", "(Z)V", "isShowTabAndMiniPlayer", "Companion", "", "offsetY", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ImageToPlaylistFragment extends Hilt_ImageToPlaylistFragment implements k3 {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001A\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_IMAGE_URI_LIST", "newInstance", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistFragment;", "uris", "", "Landroid/net/Uri;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ImageToPlaylistFragment newInstance(@NotNull List list0) {
            q.g(list0, "uris");
            ImageToPlaylistFragment imageToPlaylistFragment0 = new ImageToPlaylistFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putParcelableArrayList("image_uri_list", new ArrayList(list0));
            imageToPlaylistFragment0.setArguments(bundle0);
            return imageToPlaylistFragment0;
        }
    }

    private final p3 $$delegate_0;
    public static final int $stable = 0;
    @NotNull
    private static final String ARG_IMAGE_URI_LIST = "image_uri_list";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "ImageToPlaylistFragment";
    private boolean isScreenLandscapeSupported;
    @NotNull
    private final LogU log;

    static {
        ImageToPlaylistFragment.Companion = new Companion(null);
        ImageToPlaylistFragment.$stable = 8;
    }

    public ImageToPlaylistFragment() {
        this.$$delegate_0 = new p3();  // 初始化器: Ljava/lang/Object;-><init>()V
        LogU logU0 = new LogU("ImageToPlaylistFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.log = logU0;
    }

    private final void LoadingAnimation(r0.q q0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(1006329484);
        int v1 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            I i0 = f.f(f.p("LoadingAnimation", p0, 0), 8.0f, 64.0f, f.n(f.r(1000, 0, C.d, 2), X.b, 0L, 4), "LoadingAnimation", p0, 0x71B8, 0);
            y y0 = w.a(j.e, d.n, p0, 54);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
            k.y.getClass();
            i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            n n0 = n.a;
            r0.q q2 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 96.0f), 85.0f);
            M m0 = M.p.d(d.b, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            c1.n(androidx.compose.foundation.layout.d.n(n0, 72.0f), 0x7F0805DC, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:ic_song_capture
            c1.n(androidx.compose.foundation.layout.a.h(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 24.0f), 0.0f, ImageToPlaylistFragment.LoadingAnimation$lambda$23(i0), 1), 0x7F080678, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:img_song_rader
            p0.p(true);
            c.d(p0, androidx.compose.foundation.layout.d.h(n0, 10.0f));
            r0.q q4 = androidx.compose.foundation.layout.d.u(n0, 2);
            N1.b(e.Y(p0, 0x7F130CAB), q4, e0.T(p0, 0x7F060163), 15.0f, null, null, 0L, new l1.k(3), 22.0f, 0, false, 0, 0, null, null, p0, 0xC30, 6, 0x1F9F0);  // string:text_ocr_image_recognizing "이미지를 인식 중입니다.\n잠시만 기다려 주세요."
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U(this, q0, v, 10);
        }
    }

    private static final float LoadingAnimation$lambda$23(b1 b10) {
        return ((Number)b10.getValue()).floatValue();
    }

    private static final H LoadingAnimation$lambda$26(ImageToPlaylistFragment imageToPlaylistFragment0, r0.q q0, int v, l l0, int v1) {
        imageToPlaylistFragment0.LoadingAnimation(q0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    private final void LoadingPreview(l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x30FF2A11);
        int v1 = (v & 6) == 0 ? (p0.i(this) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            long v2 = e0.T(p0, 0x7F0604AA);  // color:white000s_support_high_contrast
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.q.f(n0, v2, y0.M.a);
            M m0 = M.p.d(d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            int v4 = v1 << 6 & 0x380;
            this.TitleLayout(null, e.Y(p0, 0x7F130026), p0, v4, 1);  // string:add_song_with_image "이미지로 곡 추가"
            y y0 = w.a(j.c, d.m, p0, 0);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q2 = a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q2, h3);
            this.LoadingAnimation(x.r(1.0f, androidx.compose.foundation.layout.d.f(n0, 1.0f), true), p0, v1 << 3 & 0x70);
            this.ReSelectButton(null, null, p0, v4, 3);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.mymusic.playlist.c(this, v, 2);
        }
    }

    private static final H LoadingPreview$lambda$51(ImageToPlaylistFragment imageToPlaylistFragment0, int v, l l0, int v1) {
        imageToPlaylistFragment0.LoadingPreview(l0, androidx.compose.runtime.w.A(v | 1));
        return H.a;
    }

    private final void MainContent(r0.q q0, Success imageToPlaylistUiState$Success0, l l0, int v, int v1) {
        int v3;
        r0.q q2;
        r0.q q1;
        int v2;
        p p0 = (p)l0;
        p0.c0(161278407);
        if((v1 & 1) != 0) {
            v2 = v | 6;
            q1 = q0;
        }
        else if((v & 6) == 0) {
            q1 = q0;
            v2 = (p0.g(q1) ? 4 : 2) | v;
        }
        else {
            q1 = q0;
            v2 = v;
        }
        if((v & 0x30) == 0) {
            v2 |= (p0.i(imageToPlaylistUiState$Success0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.i(this) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            if((v1 & 1) == 0) {
                v3 = v2;
                q2 = q1;
            }
            else {
                q2 = n.a;
                v3 = v2;
            }
            F f0 = O.I.a(0, 0, 3, p0);
            b b0 = new b(20.0f, 20.0f, 38.0f);
            b0.d = m0.c.e(0x45F298FF, p0, new com.iloen.melon.fragments.mymusic.playlist.a(imageToPlaylistUiState$Success0, this));
            b0.f = m0.c.e(0x7AFCB7D0, p0, new com.iloen.melon.fragments.mymusic.playlist.a(this, imageToPlaylistUiState$Success0, 1));
            b0.a().invoke(p0, 0);
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, 51.0f, 7);
            boolean z = p0.i(imageToPlaylistUiState$Success0);
            boolean z1 = p0.i(this);
            com.iloen.melon.fragments.mymusic.playlist.f f1 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(z || z1 || f1 == v4) {
                f1 = new com.iloen.melon.fragments.mymusic.playlist.f(1, imageToPlaylistUiState$Success0, this);
                p0.l0(f1);
            }
            c1.o(q2, f0, j00, false, null, null, null, false, f1, p0, v3 & 14 | 0x180, 0xF8);
            boolean z2 = p0.i(this);
            com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.MainContent.4.1 imageToPlaylistFragment$MainContent$4$10 = p0.N();
            if(z2 || imageToPlaylistFragment$MainContent$4$10 == v4) {
                imageToPlaylistFragment$MainContent$4$10 = new we.n(null) {
                    int label;

                    {
                        ImageToPlaylistFragment.this = imageToPlaylistFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.MainContent.4.1(ImageToPlaylistFragment.this, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.MainContent.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        d5.n.D(object0);
                        ImageToPlaylistFragment.access$sendUserEvent(ImageToPlaylistFragment.this, ToggleSelectAll.INSTANCE);
                        return H.a;
                    }
                };
                p0.l0(imageToPlaylistFragment$MainContent$4$10);
            }
            J.d(p0, H.a, imageToPlaylistFragment$MainContent$4$10);
            q1 = q2;
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H3(this, q1, imageToPlaylistUiState$Success0, v, v1, 7);
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.MainContent.lambda.36.lambda.35..inlined.itemsIndexed.default.1 extends r implements we.k {
            final List $items;
            final we.n $key;

            public com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.MainContent.lambda.36.lambda.35..inlined.itemsIndexed.default.1(we.n n0, List list0) {
                this.$key = n0;
                this.$items = list0;
                super(1);
            }

            public final Object invoke(int v) {
                Object object0 = this.$items.get(v);
                return this.$key.invoke(v, object0);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.MainContent.lambda.36.lambda.35..inlined.itemsIndexed.default.2 extends r implements we.k {
            final List $items;

            public com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.MainContent.lambda.36.lambda.35..inlined.itemsIndexed.default.2(List list0) {
                this.$items = list0;
                super(1);
            }

            public final Object invoke(int v) {
                this.$items.get(v);
                return null;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u000B¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Landroidx/compose/foundation/lazy/a;", "", "it", "Lie/H;", "invoke", "(Landroidx/compose/foundation/lazy/a;ILandroidx/compose/runtime/l;I)V", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.MainContent.lambda.36.lambda.35..inlined.itemsIndexed.default.3 extends r implements we.p {
            final List $items;

            public com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.MainContent.lambda.36.lambda.35..inlined.itemsIndexed.default.3(List list0, ImageToPlaylistFragment imageToPlaylistFragment0) {
                this.$items = list0;
                ImageToPlaylistFragment.this = imageToPlaylistFragment0;
                super(4);
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((androidx.compose.foundation.lazy.a)object0), ((Number)object1).intValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(androidx.compose.foundation.lazy.a a0, int v, l l0, int v1) {
                int v2 = (v1 & 6) == 0 ? (((p)l0).g(a0) ? 4 : 2) | v1 : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((p)l0).e(v) ? 0x20 : 16);
                }
                if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    g g0 = (g)this.$items.get(v);
                    ((p)l0).a0(-1097412420);
                    ImageToPlaylistFragment.this.SongItem(g0, v, ((p)l0), v2 & 0x70);
                    ((p)l0).p(false);
                    return;
                }
                ((p)l0).T();
            }
        }

    }

    private static final H MainContent$lambda$32(Success imageToPlaylistUiState$Success0, ImageToPlaylistFragment imageToPlaylistFragment0, l l0, int v) {
        if(((p)l0).Q(v & 1, (v & 3) != 2)) {
            b0 b00 = androidx.compose.runtime.w.s(Boolean.valueOf(imageToPlaylistUiState$Success0.getCheckAll()));
            boolean z = ((p)l0).i(imageToPlaylistFragment0);
            com.iloen.melon.fragments.mymusic.playlist.b b0 = ((p)l0).N();
            if(z || b0 == androidx.compose.runtime.k.a) {
                b0 = new com.iloen.melon.fragments.mymusic.playlist.b(imageToPlaylistFragment0, 0);
                ((p)l0).l0(b0);
            }
            x1.a.f(b00, b0, ((p)l0), 0);
            return H.a;
        }
        ((p)l0).T();
        return H.a;
    }

    private static final H MainContent$lambda$32$lambda$31$lambda$30(ImageToPlaylistFragment imageToPlaylistFragment0) {
        imageToPlaylistFragment0.sendUserEvent(ToggleSelectAll.INSTANCE);
        return H.a;
    }

    private static final H MainContent$lambda$33(ImageToPlaylistFragment imageToPlaylistFragment0, Success imageToPlaylistUiState$Success0, l l0, int v) {
        if(((p)l0).Q(v & 1, (v & 3) != 2)) {
            String s = imageToPlaylistFragment0.getString(0x7F13083B, new Object[]{String.valueOf(imageToPlaylistUiState$Success0.getList().size())});  // string:playlist_song_count "%s곡"
            q.f(s, "getString(...)");
            N1.b(s, null, e0.T(((p)l0), 0x7F060165), 14.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, ((p)l0), 0xC00, 0xC00, 0x1DFF2);  // color:gray800s
            return H.a;
        }
        ((p)l0).T();
        return H.a;
    }

    private static final H MainContent$lambda$36$lambda$35(Success imageToPlaylistUiState$Success0, ImageToPlaylistFragment imageToPlaylistFragment0, O.w w0) {
        q.g(w0, "$this$MelonLazyColumn");
        List list0 = imageToPlaylistUiState$Success0.getList();
        ((O.j)w0).u(list0.size(), null, new com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.MainContent.lambda.36.lambda.35..inlined.itemsIndexed.default.2(list0), new m0.b(0xBEF78951, new com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.MainContent.lambda.36.lambda.35..inlined.itemsIndexed.default.3(list0, imageToPlaylistFragment0), true));
        return H.a;
    }

    private static final H MainContent$lambda$38(ImageToPlaylistFragment imageToPlaylistFragment0, r0.q q0, Success imageToPlaylistUiState$Success0, int v, int v1, l l0, int v2) {
        imageToPlaylistFragment0.MainContent(q0, imageToPlaylistUiState$Success0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)), v1);
        return H.a;
    }

    private final void ReSelectButton(we.a a0, we.a a1, l l0, int v, int v1) {
        we.a a5;
        we.a a2;
        int v2;
        p p0 = (p)l0;
        p0.c0(0x50BC5CEE);
        if((v1 & 1) != 0) {
            v2 = v | 6;
            a2 = a0;
        }
        else if((v & 6) == 0) {
            a2 = a0;
            v2 = v | (p0.i(a2) ? 4 : 2);
        }
        else {
            a2 = a0;
            v2 = v;
        }
        if((v1 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v & 0x30) == 0) {
            v2 |= (p0.i(a1) ? 0x20 : 16);
        }
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            we.a a3 = (v1 & 1) == 0 ? a2 : null;
            we.a a4 = (v1 & 2) == 0 ? a1 : null;
            n n0 = n.a;
            r0.q q0 = a.a(androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 20.0f, 0.0f, 20.0f, 20.0f, 2), 1.0f), 3), e0.T(p0, 0x7F060145), T.e.b(4.0f)), new o() {  // color:gray050s
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final r0.q invoke(r0.q q0, l l0, int v) {
                    q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((p)l0).k(k0.i);
                    m m0 = ((p)l0).N();
                    if(m0 == androidx.compose.runtime.k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    X0.i i0 = new X0.i(a3);
                    com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.ReSelectButton..inlined.noRippleClickable-YQRRFTQ.default.1.1 imageToPlaylistFragment$ReSelectButton$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.$onButtonClick$inlined);
                            we.a a0 = this.$pickEvent$inlined;
                            if(a0 != null) {
                                a0.invoke();
                            }
                            we.a a1 = this.$pickEvent$inlined;
                            if(a1 != null) {
                                a1.invoke();
                            }
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, imageToPlaylistFragment$ReSelectButton$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            M m0 = M.p.d(d.e, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            r0.q q2 = androidx.compose.foundation.layout.a.j(n0, 15.0f);
            N1.b(e.Y(p0, 0x7F130CAC), q2, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // string:text_ocr_image_reselect "다시 선택하기"
            p0.p(true);
            a2 = a3;
            a5 = a4;
        }
        else {
            p0.T();
            a5 = a1;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H3(this, a2, a5, v, v1, 8);
        }
    }

    private static final H ReSelectButton$lambda$29(ImageToPlaylistFragment imageToPlaylistFragment0, we.a a0, we.a a1, int v, int v1, l l0, int v2) {
        imageToPlaylistFragment0.ReSelectButton(a0, a1, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)), v1);
        return H.a;
    }

    public final void SongItem(@NotNull g g0, int v, @Nullable l l0, int v1) {
        q.g(g0, "item");
        p p0 = (p)l0;
        p0.c0(-669600885);
        int v2 = (v1 & 6) == 0 ? (p0.i(g0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.i(this) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 60.0f);
            boolean z = p0.i(this);
            boolean z1 = p0.i(g0);
            P0 p00 = p0.N();
            if((((v2 & 0x70) == 0x20 ? 1 : 0) | (z | z1)) != 0 || p00 == androidx.compose.runtime.k.a) {
                p00 = new P0(this, g0, v, 6);
                p0.l0(p00);
            }
            r0.q q1 = androidx.compose.foundation.q.f(a.a(q0, new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final r0.q invoke(r0.q q0, l l0, int v) {
                    q.g(q0, "$this$composed");
                    ((p)l0).a0(0x6D4D6540);
                    m m0 = ((p)l0).N();
                    if(m0 == androidx.compose.runtime.k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    X0.i i0 = new X0.i(null);
                    com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.SongItem..inlined.noRippleClickable-ggzbRbM.default.1.1 imageToPlaylistFragment$SongItem$$inlined$noRippleClickable-ggzbRbM$default$1$10 = new we.a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            g g0 = ImageToPlaylistFragment.this;
                            if(g0.i) {
                                Kd.b b0 = new Kd.b(g0, this.$position$inlined);
                                this.$position$inlined.sendUserEvent(b0);
                            }
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.o(q0, m0, 0, i0, p00, g0, imageToPlaylistFragment$SongItem$$inlined$noRippleClickable-ggzbRbM$default$1$10, 388);
                    ((p)l0).p(false);
                    return q1;
                }
            }), e0.T(p0, (g0.N ? 0x7F060199 : 0x7F06048A)), y0.M.a);  // color:list_item_marked
            if(!g0.i) {
                q1 = e2.a.r(q1, 0.3f);
            }
            M.b b0 = j.a;
            p0 p01 = M.n0.a(b0, d.j, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = a.d(p0, q1);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p01, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 20.0f));
            r0.q q3 = q0.a(androidx.compose.foundation.layout.d.c(n0, 1.0f), 1.0f);
            r0.h h4 = d.k;
            p0 p02 = M.n0.a(b0, h4, p0, 0x30);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p02, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            r0.q q5 = e0.K(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.d.h(n0, 44.0f), 44.0f));
            r0.b.c(q5, g0.f, 44.0f, null, 0L, null, false, false, p0, 0x6000180, 0xF8);
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 10.0f));
            r0.q q6 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3);
            y y0 = w.a(j.c, d.m, p0, 0);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q7 = a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q7, h3);
            p0 p03 = M.n0.a(b0, h4, p0, 0x30);
            int v6 = p0.P;
            i0 i03 = p0.m();
            r0.q q8 = a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p03, h0);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            androidx.compose.runtime.w.x(p0, q8, h3);
            r0.q q9 = q0.a(n0, 1.0f);
            if(g0.M) {
                q9 = androidx.compose.foundation.q.h(q9, 0, 0, null, 0.0f, 62);
            }
            long v7 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b(g0.b, q9, v7, 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);
            p0.p(true);
            c.d(p0, androidx.compose.foundation.layout.d.h(n0, 4.0f));
            N1.b((g0.G == null ? "" : g0.G), null, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray600s_support_high_contrast
            p0.p(true);
            p0.p(true);
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 20.0f));
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Nc.p(this, g0, v, v1, 2);
        }
    }

    private static final H SongItem$lambda$41$lambda$40(ImageToPlaylistFragment imageToPlaylistFragment0, g g0, int v) {
        imageToPlaylistFragment0.sendUserEvent(new Kd.c(g0, v));
        return H.a;
    }

    private static final H SongItem$lambda$47(ImageToPlaylistFragment imageToPlaylistFragment0, g g0, int v, int v1, l l0, int v2) {
        imageToPlaylistFragment0.SongItem(g0, v, l0, (v1 | 1) & -920350135 | ((0x24924924 & (v1 | 1)) >> 1 | 306783378 & (v1 | 1)) | (306783378 & (v1 | 1)) << 1 & (0x24924924 & (v1 | 1)));
        return H.a;
    }

    private final void SongItemPreview(l l0, int v) {
        ((p)l0).c0(-208013383);
        int v1 = (v & 6) == 0 ? (((p)l0).i(this) ? 4 : 2) | v : v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            q.f(CType.SONG, "SONG");
            this.SongItem(new g("songId", "songName", "albumId", "albumName", "albumImg", "albumThumbImg", null, true, true, true, false, true, false, false, "playTime", CType.SONG, false, false, false, "artistName", null, false, 0x10000), 0, ((p)l0), v1 << 6 & 0x380 | 0x30);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.mymusic.playlist.c(this, v, 1);
        }
    }

    private static final H SongItemPreview$lambda$56(ImageToPlaylistFragment imageToPlaylistFragment0, int v, l l0, int v1) {
        imageToPlaylistFragment0.SongItemPreview(l0, androidx.compose.runtime.w.A(v | 1));
        return H.a;
    }

    private final void TitleLayout(r0.q q0, String s, l l0, int v, int v1) {
        String s2;
        r0.q q1;
        int v2;
        p p0 = (p)l0;
        p0.c0(-730155435);
        if((v1 & 1) != 0) {
            v2 = v | 6;
            q1 = q0;
        }
        else if((v & 6) == 0) {
            q1 = q0;
            v2 = (p0.g(q1) ? 4 : 2) | v;
        }
        else {
            q1 = q0;
            v2 = v;
        }
        if((v1 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v & 0x30) == 0) {
            v2 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.i(this) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            n n0 = n.a;
            if((v1 & 1) != 0) {
                q1 = n0;
            }
            String s1 = (v1 & 2) == 0 ? s : "";
            r0.q q2 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(q1, 1.0f), 3);
            M m0 = M.p.d(d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = a.d(p0, q2);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            androidx.compose.runtime.w.x(p0, q3, P0.j.d);
            r0.q q4 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, d.e);
            long v4 = e0.T(p0, 0x7F06016D);  // color:gray900s
            l1.k k0 = new l1.k(3);
            N1.b(s1, q4, v4, 18.0f, e1.y.i, null, 0L, k0, 0.0f, 0, false, 0, 0, null, null, p0, v2 >> 3 & 14 | 0x30C00, 0, 0x1FDD0);
            r0.q q5 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 46.0f), 50.0f);
            r0.q q6 = a.a((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, d.c), new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final r0.q invoke(r0.q q0, l l0, int v) {
                    q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((p)l0).k(k0.i);
                    m m0 = ((p)l0).N();
                    if(m0 == androidx.compose.runtime.k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    X0.i i0 = new X0.i(this);
                    com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.TitleLayout.lambda.21..inlined.noRippleClickable-YQRRFTQ.default.1.1 imageToPlaylistFragment$TitleLayout$lambda$21$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(ImageToPlaylistFragment.this);
                            De.I.S(ImageToPlaylistFragment.this);
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, imageToPlaylistFragment$TitleLayout$lambda$21$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            androidx.compose.foundation.q.c(De.I.Q(0x7F0801D1, p0, 6), e.Y(p0, 0x7F130AE8), q6, null, null, 0.0f, new y0.k(e0.T(p0, 0x7F06016D), 5), p0, 0, 56);  // drawable:btn_gnb_close_w
            p0.p(true);
            s2 = s1;
        }
        else {
            p0.T();
            s2 = s;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H3(this, q1, s2, v, v1);
        }
    }

    private static final H TitleLayout$lambda$22(ImageToPlaylistFragment imageToPlaylistFragment0, r0.q q0, String s, int v, int v1, l l0, int v2) {
        imageToPlaylistFragment0.TitleLayout(q0, s, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)), v1);
        return H.a;
    }

    private final void errorView(l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x4122AD0C);
        int v1 = (v & 6) == 0 ? (p0.i(this) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            M m0 = M.p.d(d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            n n0 = n.a;
            r0.q q0 = a.d(p0, n0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q0, h3);
            int v3 = v1 << 6 & 0x380;
            this.TitleLayout(null, e.Y(p0, 0x7F130026), p0, v3, 1);  // string:add_song_with_image "이미지로 곡 추가"
            y y0 = w.a(j.c, d.m, p0, 0);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q1 = a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q1, h3);
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            M m1 = M.p.d(d.e, false);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q2 = a.d(p0, layoutWeightElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m1, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q2, h3);
            c1.w(new c3(e.Y(p0, 0x7F1303D9), 0x7F080430, false, null, 12), null, null, 0.0f, 0.0f, p0, 0, 30);  // string:error_network_connectivity "해당 페이지의 접속이 지연되고 있습니다.\n네트워크 연결 상태를 확인하거나,\n잠시 
                                                                                                                // 후 다시 이용해주세요."
            p0.p(true);
            this.ReSelectButton(null, null, p0, v3, 3);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.mymusic.playlist.c(this, v, 0);
        }
    }

    private static final H errorView$lambda$55(ImageToPlaylistFragment imageToPlaylistFragment0, int v, l l0, int v1) {
        imageToPlaylistFragment0.errorView(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    @NotNull
    public V0 getViewBinding(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return V0.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.J0
    public Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        return this.getViewBinding(layoutInflater0);
    }

    @Override  // com.melon.ui.J0
    @NotNull
    public Class getViewModelClass() {
        return ImageToPlaylistViewModel.class;
    }

    @Override  // com.melon.ui.k3
    public void handlePutPopupUiEvent(@NotNull o3 o30, @NotNull androidx.fragment.app.I i0, @Nullable we.a a0, @NotNull we.k k0, boolean z, @Nullable we.a a1) {
        q.g(o30, "event");
        q.g(i0, "fragment");
        q.g(k0, "sendUserEvent");
        this.$$delegate_0.handlePutPopupUiEvent(o30, i0, a0, k0, z, a1);
    }

    @Override  // com.melon.ui.c0
    public boolean isScreenLandscapeSupported() {
        return this.isScreenLandscapeSupported;
    }

    @Override  // com.melon.ui.c0
    public boolean isShowTabAndMiniPlayer() {
        return false;
    }

    public static H m(ImageToPlaylistFragment imageToPlaylistFragment0, Success imageToPlaylistUiState$Success0, l l0, int v) {
        return ImageToPlaylistFragment.MainContent$lambda$32(imageToPlaylistUiState$Success0, imageToPlaylistFragment0, l0, v);
    }

    @NotNull
    public static final ImageToPlaylistFragment newInstance(@NotNull List list0) {
        return ImageToPlaylistFragment.Companion.newInstance(list0);
    }

    @Override  // com.melon.ui.o1
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        if(bundle1 != null) {
            ((ImageToPlaylistViewModel)this.getViewModel()).setImageUriList((Build.VERSION.SDK_INT < 34 ? bundle1.getParcelableArrayList("image_uri_list") : P1.e.c(bundle1)));
        }
    }

    @Override  // com.melon.ui.c0
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        bundle0.putParcelableArrayList("image_uri_list", ((ImageToPlaylistViewModel)this.getViewModel()).getImageUriList());
    }

    @Override  // com.melon.ui.J0
    public void onUiEvent(@NotNull I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof o3) {
            if(i40 instanceof m3 && !((va.e0)va.o.a()).j().getIsDj()) {
                this.sendUserEvent(new q3("M20001", ((m3)i40).a, ((m3)i40).c));
                return;
            }
            this.handlePutPopupUiEvent(((o3)i40), this, null, new we.k() {
                {
                    super(1, 0, ImageToPlaylistFragment.class, object0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V");
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    q.g(e0, "p0");
                    ((ImageToPlaylistFragment)this.receiver).sendUserEvent(e0);
                }
            }, true, new com.iloen.melon.fragments.mymusic.playlist.b(this, 1));
            return;
        }
        super.onUiEvent(i40);
    }

    private static final H onUiEvent$lambda$48(ImageToPlaylistFragment imageToPlaylistFragment0) {
        De.I.S(imageToPlaylistFragment0);
        return H.a;
    }

    @Override  // com.melon.ui.J0
    public void renderUi(@NotNull K4 k40) {
        q.g(k40, "uiState");
        V0 v00 = (V0)this.getBinding();
        if(v00 != null) {
            m0.b b0 = new m0.b(0x2C04D16B, new com.iloen.melon.fragments.mymusic.playlist.a(this, k40, 2), true);
            v00.b.setContent(b0);
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.1.2.1 extends kotlin.jvm.internal.n implements we.a {
            public com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.1.2.1(Object object0) {
                super(0, 0, ImageToPlaylistViewModel.class, object0, "reSelectImage", "reSelectImage()V");
            }

            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                ((ImageToPlaylistViewModel)this.receiver).reSelectImage();
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.2.2.1 extends kotlin.jvm.internal.n implements we.a {
            public com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.2.2.1(Object object0) {
                super(0, 0, ImageToPlaylistViewModel.class, object0, "reSelectImage", "reSelectImage()V");
            }

            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                ((ImageToPlaylistViewModel)this.receiver).reSelectImage();
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.3.1.1 extends kotlin.jvm.internal.n implements we.a {
            public com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.3.1.1(Object object0) {
                super(0, 0, ImageToPlaylistViewModel.class, object0, "reSelectImage", "reSelectImage()V");
            }

            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                ((ImageToPlaylistViewModel)this.receiver).reSelectImage();
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.4.2.1 extends kotlin.jvm.internal.n implements we.a {
            public com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.4.2.1(Object object0) {
                super(0, 0, ImageToPlaylistViewModel.class, object0, "reSelectImage", "reSelectImage()V");
            }

            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                ((ImageToPlaylistViewModel)this.receiver).reSelectImage();
            }
        }

    }

    private static final H renderUi$lambda$19(ImageToPlaylistFragment imageToPlaylistFragment0, K4 k40, l l0, int v) {
        p p1;
        l0 l00;
        p p0;
        f.c c1;
        r0.i i0 = d.e;
        r0.g g0 = d.m;
        if(((p)l0).Q(v & 1, (v & 3) != 2)) {
            f.c c0 = new f.c(5);
            boolean z = ((p)l0).i(imageToPlaylistFragment0);
            com.iloen.melon.fragments.mymusic.playlist.g g1 = ((p)l0).N();
            V v1 = androidx.compose.runtime.k.a;
            if(z || g1 == v1) {
                g1 = new com.iloen.melon.fragments.mymusic.playlist.g(imageToPlaylistFragment0, 1);
                ((p)l0).l0(g1);
            }
            b0 b00 = androidx.compose.runtime.w.w(c0, ((p)l0));
            b0 b01 = androidx.compose.runtime.w.w(g1, ((p)l0));
            Object object0 = d5.w.P(new Object[0], null, null, c.b.g, ((p)l0), 0xC00, 6);
            e.i i1 = (e.i)((p)l0).k(c.d.a);
            if(i1 == null) {
                ((p)l0).a0(1006590171);
                Context context0;
                for(context0 = (Context)((p)l0).k(AndroidCompositionLocals_androidKt.b); true; context0 = ((ContextWrapper)context0).getBaseContext()) {
                    if(!(context0 instanceof ContextWrapper)) {
                        context0 = null;
                        break;
                    }
                    if(context0 instanceof e.i) {
                        break;
                    }
                }
                i1 = (e.i)context0;
            }
            else {
                ((p)l0).a0(1006589303);
            }
            ((p)l0).p(false);
            if(i1 == null) {
                throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner");
            }
            e.h h0 = i1.getActivityResultRegistry();
            c.a a0 = ((p)l0).N();
            if(a0 == v1) {
                a0 = new c.a();  // 初始化器: Ljava/lang/Object;-><init>()V
                ((p)l0).l0(a0);
            }
            c.f f0 = ((p)l0).N();
            if(f0 == v1) {
                f0 = new c.f(a0, b00);
                ((p)l0).l0(f0);
            }
            boolean z1 = ((p)l0).i(a0);
            boolean z2 = ((p)l0).i(h0);
            boolean z3 = ((p)l0).g(((String)object0));
            boolean z4 = ((p)l0).i(c0);
            boolean z5 = ((p)l0).g(b01);
            Object object1 = ((p)l0).N();
            if((z1 | z2 | z3 | z4 | z5) != 0 || object1 == v1) {
                c1 = c0;
                p0 = (p)l0;
                l00 = new l0(a0, h0, ((String)object0), c1, b01, 3);
                p0.l0(l00);
            }
            else {
                c1 = c0;
                p0 = (p)l0;
                l00 = object1;
            }
            if((p0.g(h0) | p0.g(((String)object0)) | p0.g(c1)) != 0 || p0.N() == v1) {
                p0.l0(new androidx.compose.runtime.F(l00));
            }
            boolean z6 = p0.i(f0);
            com.iloen.melon.fragments.mymusic.playlist.d d0 = p0.N();
            if(z6 || d0 == v1) {
                d0 = new com.iloen.melon.fragments.mymusic.playlist.d(f0, 0);
                p0.l0(d0);
            }
            long v2 = e0.T(p0, 0x7F0604AA);  // color:white000s_support_high_contrast
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.q.f(n0, v2, y0.M.a);
            M m0 = M.p.d(d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
            k.y.getClass();
            i i2 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            h h1 = P0.j.f;
            androidx.compose.runtime.w.x(p0, m0, h1);
            h h2 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h2);
            h h3 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h3);
            }
            h h4 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h4);
            if(k40 instanceof NotificationScreen) {
                p0.a0(1229419203);
                p1 = p0;
                imageToPlaylistFragment0.TitleLayout(null, e.Y(p0, 0x7F130026), p1, 0, 1);  // string:add_song_with_image "이미지로 곡 추가"
                y y0 = w.a(j.c, g0, p1, 0);
                int v4 = p1.P;
                i0 i01 = p1.m();
                r0.q q2 = a.d(p1, n0);
                p1.e0();
                if(p1.O) {
                    p1.l(i2);
                }
                else {
                    p1.o0();
                }
                androidx.compose.runtime.w.x(p1, y0, h1);
                androidx.compose.runtime.w.x(p1, i01, h2);
                if(p1.O || !q.b(p1.N(), v4)) {
                    A7.d.q(v4, p1, v4, h3);
                }
                androidx.compose.runtime.w.x(p1, q2, h4);
                r0.q q3 = androidx.compose.foundation.layout.a.n(new LayoutWeightElement(1.0f, true), 0.0f, 100.0f, 0.0f, 0.0f, 13);
                M m1 = M.p.d(i0, false);
                int v5 = p1.P;
                i0 i02 = p1.m();
                r0.q q4 = a.d(p1, q3);
                p1.e0();
                if(p1.O) {
                    p1.l(i2);
                }
                else {
                    p1.o0();
                }
                androidx.compose.runtime.w.x(p1, m1, h1);
                androidx.compose.runtime.w.x(p1, i02, h2);
                if(p1.O || !q.b(p1.N(), v5)) {
                    A7.d.q(v5, p1, v5, h3);
                }
                androidx.compose.runtime.w.x(p1, q4, h4);
                c1.y(((NotificationScreen)k40).getNotificationScreenUiState(), p1, 0);
                p1.p(true);
                ImageToPlaylistViewModel imageToPlaylistViewModel0 = (ImageToPlaylistViewModel)imageToPlaylistFragment0.getViewModel();
                boolean z7 = p1.i(imageToPlaylistViewModel0);
                com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.1.2.1 imageToPlaylistFragment$renderUi$1$1$1$2$10 = p1.N();
                if(z7 || imageToPlaylistFragment$renderUi$1$1$1$2$10 == v1) {
                    imageToPlaylistFragment$renderUi$1$1$1$2$10 = new com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.1.2.1(imageToPlaylistViewModel0);
                    p1.l0(imageToPlaylistFragment$renderUi$1$1$1$2$10);
                }
                imageToPlaylistFragment0.ReSelectButton(imageToPlaylistFragment$renderUi$1$1$1$2$10, d0, p1, 0, 0);
                p1.p(true);
            }
            else {
                p1 = p0;
                if(k40 instanceof Error) {
                    p1.a0(1230207006);
                    imageToPlaylistFragment0.TitleLayout(null, e.Y(p1, 0x7F130026), p1, 0, 1);  // string:add_song_with_image "이미지로 곡 추가"
                    y y1 = w.a(j.c, g0, p1, 0);
                    int v6 = p1.P;
                    i0 i03 = p1.m();
                    r0.q q5 = a.d(p1, n0);
                    p1.e0();
                    if(p1.O) {
                        p1.l(i2);
                    }
                    else {
                        p1.o0();
                    }
                    androidx.compose.runtime.w.x(p1, y1, h1);
                    androidx.compose.runtime.w.x(p1, i03, h2);
                    if(p1.O || !q.b(p1.N(), v6)) {
                        A7.d.q(v6, p1, v6, h3);
                    }
                    androidx.compose.runtime.w.x(p1, q5, h4);
                    r0.q q6 = androidx.compose.foundation.layout.a.n(new LayoutWeightElement(1.0f, true), 0.0f, 100.0f, 0.0f, 0.0f, 13);
                    M m2 = M.p.d(i0, false);
                    int v7 = p1.P;
                    i0 i04 = p1.m();
                    r0.q q7 = a.d(p1, q6);
                    p1.e0();
                    if(p1.O) {
                        p1.l(i2);
                    }
                    else {
                        p1.o0();
                    }
                    androidx.compose.runtime.w.x(p1, m2, h1);
                    androidx.compose.runtime.w.x(p1, i04, h2);
                    if(p1.O || !q.b(p1.N(), v7)) {
                        A7.d.q(v7, p1, v7, h3);
                    }
                    androidx.compose.runtime.w.x(p1, q7, h4);
                    c1.w(((Error)k40).getErrorUiState(), null, null, 0.0f, 0.0f, p1, 0, 30);
                    p1.p(true);
                    ImageToPlaylistViewModel imageToPlaylistViewModel1 = (ImageToPlaylistViewModel)imageToPlaylistFragment0.getViewModel();
                    boolean z8 = p1.i(imageToPlaylistViewModel1);
                    com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.2.2.1 imageToPlaylistFragment$renderUi$1$1$2$2$10 = p1.N();
                    if(z8 || imageToPlaylistFragment$renderUi$1$1$2$2$10 == v1) {
                        imageToPlaylistFragment$renderUi$1$1$2$2$10 = new com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.2.2.1(imageToPlaylistViewModel1);
                        p1.l0(imageToPlaylistFragment$renderUi$1$1$2$2$10);
                    }
                    imageToPlaylistFragment0.ReSelectButton(imageToPlaylistFragment$renderUi$1$1$2$2$10, d0, p1, 0, 0);
                    p1.p(true);
                }
                else if(k40 instanceof Loading) {
                    p1.a0(0x4962A870);
                    imageToPlaylistFragment0.TitleLayout(null, e.Y(p1, 0x7F130026), p1, 0, 1);  // string:add_song_with_image "이미지로 곡 추가"
                    y y2 = w.a(j.c, g0, p1, 0);
                    int v8 = p1.P;
                    i0 i05 = p1.m();
                    r0.q q8 = a.d(p1, n0);
                    p1.e0();
                    if(p1.O) {
                        p1.l(i2);
                    }
                    else {
                        p1.o0();
                    }
                    androidx.compose.runtime.w.x(p1, y2, h1);
                    androidx.compose.runtime.w.x(p1, i05, h2);
                    if(p1.O || !q.b(p1.N(), v8)) {
                        A7.d.q(v8, p1, v8, h3);
                    }
                    androidx.compose.runtime.w.x(p1, q8, h4);
                    imageToPlaylistFragment0.LoadingAnimation(x.r(1.0f, androidx.compose.foundation.layout.d.f(n0, 1.0f), true), p1, 0);
                    ImageToPlaylistViewModel imageToPlaylistViewModel2 = (ImageToPlaylistViewModel)imageToPlaylistFragment0.getViewModel();
                    boolean z9 = p1.i(imageToPlaylistViewModel2);
                    com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.3.1.1 imageToPlaylistFragment$renderUi$1$1$3$1$10 = p1.N();
                    if(z9 || imageToPlaylistFragment$renderUi$1$1$3$1$10 == v1) {
                        imageToPlaylistFragment$renderUi$1$1$3$1$10 = new com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.3.1.1(imageToPlaylistViewModel2);
                        p1.l0(imageToPlaylistFragment$renderUi$1$1$3$1$10);
                    }
                    imageToPlaylistFragment0.ReSelectButton(imageToPlaylistFragment$renderUi$1$1$3$1$10, d0, p1, 0, 0);
                    p1.p(true);
                }
                else if(k40 instanceof Empty) {
                    p1.a0(0x496B383C);
                    imageToPlaylistFragment0.TitleLayout(null, e.Y(p1, 0x7F130026), p1, 0, 1);  // string:add_song_with_image "이미지로 곡 추가"
                    y y3 = w.a(j.c, g0, p1, 0);
                    int v9 = p1.P;
                    i0 i06 = p1.m();
                    r0.q q9 = a.d(p1, n0);
                    p1.e0();
                    if(p1.O) {
                        p1.l(i2);
                    }
                    else {
                        p1.o0();
                    }
                    androidx.compose.runtime.w.x(p1, y3, h1);
                    androidx.compose.runtime.w.x(p1, i06, h2);
                    if(p1.O || !q.b(p1.N(), v9)) {
                        A7.d.q(v9, p1, v9, h3);
                    }
                    androidx.compose.runtime.w.x(p1, q9, h4);
                    r0.q q10 = x.r(1.0f, androidx.compose.foundation.layout.d.f(n0, 1.0f), true);
                    M m3 = M.p.d(i0, false);
                    int v10 = p1.P;
                    i0 i07 = p1.m();
                    r0.q q11 = a.d(p1, q10);
                    p1.e0();
                    if(p1.O) {
                        p1.l(i2);
                    }
                    else {
                        p1.o0();
                    }
                    androidx.compose.runtime.w.x(p1, m3, h1);
                    androidx.compose.runtime.w.x(p1, i07, h2);
                    if(p1.O || !q.b(p1.N(), v10)) {
                        A7.d.q(v10, p1, v10, h3);
                    }
                    androidx.compose.runtime.w.x(p1, q11, h4);
                    U0 u00 = ((Empty)k40).getEmptyUiState();
                    long v11 = e0.T(p1, 0x7F060163);  // color:gray700s
                    l1.k k0 = new l1.k(3);
                    N1.b(u00.b, null, v11, 15.0f, null, null, 0L, k0, 22.0f, 0, false, 0, 0, null, null, p1, 0xC00, 6, 0x1F9F2);
                    p1.p(true);
                    ImageToPlaylistViewModel imageToPlaylistViewModel3 = (ImageToPlaylistViewModel)imageToPlaylistFragment0.getViewModel();
                    boolean z10 = p1.i(imageToPlaylistViewModel3);
                    com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.4.2.1 imageToPlaylistFragment$renderUi$1$1$4$2$10 = p1.N();
                    if(z10 || imageToPlaylistFragment$renderUi$1$1$4$2$10 == v1) {
                        imageToPlaylistFragment$renderUi$1$1$4$2$10 = new com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistFragment.renderUi.1.1.4.2.1(imageToPlaylistViewModel3);
                        p1.l0(imageToPlaylistFragment$renderUi$1$1$4$2$10);
                    }
                    imageToPlaylistFragment0.ReSelectButton(imageToPlaylistFragment$renderUi$1$1$4$2$10, d0, p1, 0, 0);
                    p1.p(true);
                }
                else if(k40 instanceof Success) {
                    p1.a0(0x497AF6B8);
                    y y4 = w.a(j.c, g0, p1, 0);
                    int v12 = p1.P;
                    i0 i08 = p1.m();
                    r0.q q12 = a.d(p1, n0);
                    p1.e0();
                    if(p1.O) {
                        p1.l(i2);
                    }
                    else {
                        p1.o0();
                    }
                    androidx.compose.runtime.w.x(p1, y4, h1);
                    androidx.compose.runtime.w.x(p1, i08, h2);
                    if(p1.O || !q.b(p1.N(), v12)) {
                        A7.d.q(v12, p1, v12, h3);
                    }
                    androidx.compose.runtime.w.x(p1, q12, h4);
                    imageToPlaylistFragment0.TitleLayout(null, e.Y(p1, 0x7F130CAD), p1, 0, 1);  // string:text_ocr_result_text "이미지 인식 결과"
                    c.d(p1, androidx.compose.foundation.layout.d.h(n0, 16.0f));
                    imageToPlaylistFragment0.MainContent(null, ((Success)k40), p1, 0, 1);
                    p1.p(true);
                    T3.a((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, d.h), ((Success)k40).getToolBarUiState(), 51.0f, p1, 0x180, 0);
                }
                else {
                    p1.a0(0x48E1C71D);
                }
            }
            p1.p(false);
            p1.p(true);
            return H.a;
        }
        ((p)l0).T();
        return H.a;
    }

    private static final H renderUi$lambda$19$lambda$3$lambda$2(ImageToPlaylistFragment imageToPlaylistFragment0, List list0) {
        q.g(list0, "uris");
        if(!list0.isEmpty()) {
            imageToPlaylistFragment0.sendUserEvent(new StartFetch(list0));
            return H.a;
        }
        LogU.debug$default(imageToPlaylistFragment0.log, "No media selected", null, false, 6, null);
        De.I.S(imageToPlaylistFragment0);
        return H.a;
    }

    private static final H renderUi$lambda$19$lambda$5$lambda$4(c.f f0) {
        f0.b(e.k.c(new f.g()));  // 初始化器: Ljava/lang/Object;-><init>()V
        return H.a;
    }

    @Override  // com.melon.ui.c0
    public void setScreenLandscapeSupported(boolean z) {
        this.isScreenLandscapeSupported = z;
    }

    @Override  // com.melon.ui.k3
    public void showContextMenuAddTo(@NotNull androidx.fragment.app.I i0, @NotNull String s, @NotNull List list0, @Nullable we.a a0, @NotNull we.k k0, boolean z, @NotNull String s1) {
        q.g(i0, "fragment");
        q.g(s, "menuId");
        q.g(list0, "playableList");
        q.g(k0, "sendUserEvent");
        q.g(s1, "ocrGroupId");
        this.$$delegate_0.showContextMenuAddTo(i0, s, list0, a0, k0, z, s1);
    }

    public static H t(ImageToPlaylistFragment imageToPlaylistFragment0, K4 k40, l l0, int v) {
        return ImageToPlaylistFragment.renderUi$lambda$19(imageToPlaylistFragment0, k40, l0, v);
    }

    public static H v(ImageToPlaylistFragment imageToPlaylistFragment0, int v, l l0, int v1) {
        return ImageToPlaylistFragment.SongItemPreview$lambda$56(imageToPlaylistFragment0, v, l0, v1);
    }

    public static H w(ImageToPlaylistFragment imageToPlaylistFragment0, Success imageToPlaylistUiState$Success0, l l0, int v) {
        return ImageToPlaylistFragment.MainContent$lambda$33(imageToPlaylistFragment0, imageToPlaylistUiState$Success0, l0, v);
    }
}

