package com.iloen.melon.fragments.settings.alarm;

import Cc.G3;
import Cc.N1;
import Cc.U;
import Cc.c1;
import Cc.e0;
import J8.y;
import K.m;
import M.b;
import M.c;
import M.j;
import M.p0;
import O.F;
import O.I;
import P0.h;
import P0.i;
import P0.k;
import Q0.k0;
import Q0.t0;
import T.e;
import Zc.N;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.w;
import androidx.fragment.app.FragmentActivity;
import com.android.volley.VolleyError;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.custom.B1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.settings.SettingBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.ListMusicReq.Params;
import com.iloen.melon.net.v3x.comments.ListMusicReq.SortType;
import com.iloen.melon.net.v3x.comments.ListMusicReq;
import com.iloen.melon.net.v3x.comments.ListMusicRes.result.MUSICLIST;
import com.iloen.melon.net.v3x.comments.ListMusicRes;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.c3;
import d5.f;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.p;
import r0.a;
import r0.d;
import r0.n;
import r0.q;
import we.o;
import y0.M;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000E\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\u00072\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0003J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0003J\u000F\u0010\u0019\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b\u0019\u0010\u0003J\u000F\u0010\u001A\u001A\u00020\u0011H\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BJC\u0010#\u001A\u00020\u00112\b\b\u0002\u0010\u001D\u001A\u00020\u001C2\u0010\b\u0002\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020\u001F0\u001E2\u0016\b\u0002\u0010\"\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010!H\u0003\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\u0011H\u0003\u00A2\u0006\u0004\b%\u0010\u001BJ\u0017\u0010(\u001A\u00020\u00112\u0006\u0010\'\u001A\u00020&H\u0003\u00A2\u0006\u0004\b(\u0010)J\u000F\u0010*\u001A\u00020\u0011H\u0003\u00A2\u0006\u0004\b*\u0010\u001BR\u0018\u0010,\u001A\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u001C\u0010/\u001A\b\u0012\u0004\u0012\u00020&0.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001A\u00020\u001F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001A\u00020\u00158\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001A\u0002078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u00109R\u001C\u0010;\u001A\b\u0012\u0004\u0012\u00020\u00150:8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010=\u001A\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010>R\u001C\u0010?\u001A\b\u0012\u0004\u0012\u00020\u00150:8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010<R\u001C\u0010@\u001A\b\u0012\u0004\u0012\u00020\u00150:8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u0010<R\u0014\u0010C\u001A\u00020+8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bA\u0010B\u00A8\u0006E"}, d2 = {"Lcom/iloen/melon/fragments/settings/alarm/SettingMusicAlarmSongFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "", "getTitleResId", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "", "onBackPressed", "()Z", "initViews", "searchMusic", "Body", "(Landroidx/compose/runtime/l;I)V", "Lr0/q;", "modifier", "", "", "sortingTypeList", "Lkotlin/Function1;", "onSortSelected", "SortingSelectionView", "(Lr0/q;[Ljava/lang/String;Lwe/k;Landroidx/compose/runtime/l;II)V", "MusicList", "Lcom/iloen/melon/net/v3x/comments/ListMusicRes$result$MUSICLIST;", "music", "ListItem", "(Lcom/iloen/melon/net/v3x/comments/ListMusicRes$result$MUSICLIST;Landroidx/compose/runtime/l;I)V", "EmptyBody", "LJ8/y;", "_binding", "LJ8/y;", "Lp0/p;", "musicList", "Lp0/p;", "searchText", "Ljava/lang/String;", "pageNo", "I", "hasMore", "Z", "Landroidx/compose/runtime/a0;", "sortType", "Landroidx/compose/runtime/a0;", "Landroidx/compose/runtime/b0;", "showSortingBar", "Landroidx/compose/runtime/b0;", "selectMusic", "Lcom/iloen/melon/net/v3x/comments/ListMusicRes$result$MUSICLIST;", "isApiLoading", "isApiError", "getBinding", "()LJ8/y;", "binding", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingMusicAlarmSongFragment extends SettingBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001A\u00020\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/settings/alarm/SettingMusicAlarmSongFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/settings/alarm/SettingMusicAlarmSongFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingMusicAlarmSongFragment newInstance() {
            return new SettingMusicAlarmSongFragment();
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "SettingMusicAlarmSongFragment";
    @Nullable
    private y _binding;
    private boolean hasMore;
    @NotNull
    private b0 isApiError;
    @NotNull
    private b0 isApiLoading;
    @NotNull
    private p musicList;
    private int pageNo;
    @NotNull
    private String searchText;
    @Nullable
    private MUSICLIST selectMusic;
    @NotNull
    private b0 showSortingBar;
    @NotNull
    private a0 sortType;

    static {
        SettingMusicAlarmSongFragment.Companion = new Companion(null);
        SettingMusicAlarmSongFragment.$stable = 8;
    }

    public SettingMusicAlarmSongFragment() {
        this.musicList = new p();
        this.searchText = "";
        this.pageNo = 1;
        this.hasMore = true;
        this.sortType = w.p(SortType.ACCURACY);
        this.showSortingBar = w.s(Boolean.FALSE);
        this.isApiLoading = w.s(Boolean.FALSE);
        this.isApiError = w.s(Boolean.FALSE);
    }

    private final void Body(l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(970748776);
        int v1 = (v & 6) == 0 ? (p0.i(this) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            M.y y0 = M.w.a(j.c, d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q0 = a.d(p0, n.a);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q0, P0.j.d);
            boolean z = p0.i(this);
            com.iloen.melon.fragments.settings.alarm.k k0 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(z || k0 == v3) {
                k0 = new com.iloen.melon.fragments.settings.alarm.k(this, 0);
                p0.l0(k0);
            }
            c1.O(null, k0, p0, 0);
            if(((Boolean)this.showSortingBar.getValue()).booleanValue()) {
                p0.a0(0x4696A676);
                boolean z1 = p0.i(this);
                com.iloen.melon.fragments.settings.alarm.k k1 = p0.N();
                if(z1 || k1 == v3) {
                    k1 = new com.iloen.melon.fragments.settings.alarm.k(this, 1);
                    p0.l0(k1);
                }
                this.SortingSelectionView(null, null, k1, p0, v1 << 9 & 0x1C00, 3);
            }
            else {
                p0.a0(0x463373E4);
            }
            p0.p(false);
            if(this.musicList.isEmpty()) {
                p0.a0(0x469E0786);
                if(((Boolean)this.isApiError.getValue()).booleanValue()) {
                    p0.a0(1184797043);
                    String s = this.getString(0x7F1303D9);  // string:error_network_connectivity "해당 페이지의 접속이 지연되고 있습니다.\n네트워크 연결 상태를 확인하거나,\n잠시 
                                                            // 후 다시 이용해주세요."
                    kotlin.jvm.internal.q.f(s, "getString(...)");
                    c1.w(new c3(s, 0x7F080430, false, null, 12), null, null, 0.0f, 0.0f, p0, 0, 30);  // drawable:ic_error_wifi
                }
                else if(((Boolean)this.isApiLoading.getValue()).booleanValue()) {
                    p0.a0(0x463373E4);
                }
                else {
                    p0.a0(1185065937);
                    this.EmptyBody(p0, v1 & 14);
                }
                p0.p(false);
            }
            else {
                p0.a0(0x469D2099);
                this.MusicList(p0, v1 & 14);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.settings.alarm.l(this, v, 0);
        }
    }

    private static final H Body$lambda$10(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, int v, l l0, int v1) {
        settingMusicAlarmSongFragment0.Body(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    private static final H Body$lambda$9$lambda$6$lambda$5(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, String s) {
        kotlin.jvm.internal.q.g(s, "it");
        settingMusicAlarmSongFragment0.pageNo = 1;
        settingMusicAlarmSongFragment0.searchText = s;
        settingMusicAlarmSongFragment0.searchMusic();
        return H.a;
    }

    private static final H Body$lambda$9$lambda$8$lambda$7(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, int v) {
        int v1;
        a0 a00 = settingMusicAlarmSongFragment0.sortType;
        switch(v) {
            case 0: {
                v1 = SortType.ACCURACY;
                break;
            }
            case 1: {
                v1 = SortType.POPULARITY;
                break;
            }
            default: {
                v1 = SortType.RECENTLY;
            }
        }
        ((K0)a00).n(v1);
        settingMusicAlarmSongFragment0.pageNo = 1;
        settingMusicAlarmSongFragment0.searchMusic();
        return H.a;
    }

    private final void EmptyBody(l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x389AE4B7);
        int v1 = (v & 6) == 0 ? (p0.i(this) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            String s = this.searchText.length() == 0 ? this.getString(0x7F130938) : this.getString(0x7F13078F);  // string:setting_alarm_search_song_desc "알람에서 재생하고 싶은 곡을 찾아보세요."
            kotlin.jvm.internal.q.d(s);
            M.y y0 = M.w.a(j.c, d.n, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q0 = a.d(p0, androidx.compose.foundation.layout.d.c);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q0, P0.j.d);
            c.d(p0, androidx.compose.foundation.layout.d.h(n.a, 100.0f));
            N1.b(s, null, e0.T(p0, 0x7F060163), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray700s
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.settings.alarm.l(this, v, 2);
        }
    }

    private static final H EmptyBody$lambda$29(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, int v, l l0, int v1) {
        settingMusicAlarmSongFragment0.EmptyBody(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    private final void ListItem(MUSICLIST listMusicRes$result$MUSICLIST0, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(882977610);
        int v1 = (v & 6) == 0 ? v | (p0.i(listMusicRes$result$MUSICLIST0) ? 4 : 2) : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(this) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = n.a;
            q q0 = a.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 60.0f), new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final q invoke(q q0, l l0, int v) {
                    kotlin.jvm.internal.q.g(q0, "$this$composed");
                    ((androidx.compose.runtime.p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((androidx.compose.runtime.p)l0).k(k0.i);
                    m m0 = ((androidx.compose.runtime.p)l0).N();
                    if(m0 == androidx.compose.runtime.k.a) {
                        m0 = androidx.appcompat.app.o.d(((androidx.compose.runtime.p)l0));
                    }
                    X0.i i0 = new X0.i(this);
                    com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmSongFragment.ListItem..inlined.noRippleClickable-YQRRFTQ.default.1.1 settingMusicAlarmSongFragment$ListItem$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(SettingMusicAlarmSongFragment.this);
                            SettingMusicAlarmSongFragment.access$setSelectMusic$p(this.$music$inlined, this.$music$inlined);
                            FragmentActivity fragmentActivity0 = this.$music$inlined.requireActivity();
                            kotlin.jvm.internal.q.e(fragmentActivity0, "null cannot be cast to non-null type com.iloen.melon.MusicBrowserActivity");
                            ((MusicBrowserActivity)fragmentActivity0).onBackPressed();
                        }
                    };
                    q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, settingMusicAlarmSongFragment$ListItem$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((androidx.compose.runtime.p)l0).p(false);
                    return q1;
                }
            });
            r0.h h0 = d.k;
            b b0 = j.a;
            p0 p00 = M.n0.a(b0, h0, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h1 = P0.j.f;
            w.x(p0, p00, h1);
            h h2 = P0.j.e;
            w.x(p0, i00, h2);
            h h3 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h3);
            }
            w.x(p0, q1, P0.j.d);
            c.d(p0, androidx.compose.foundation.layout.d.n(n0, 20.0f));
            q q2 = d5.n.o(androidx.compose.foundation.layout.d.n(n0, 44.0f), e.b(4.0f));
            androidx.compose.foundation.y y0 = androidx.compose.foundation.q.a(ye.a.v(p0, 0x7F06014A), 0.5f);  // color:gray100a
            T.d d0 = e.b(4.0f);
            q q3 = androidx.compose.foundation.q.f(androidx.compose.foundation.q.j(q2, y0.a, y0.b, d0), e0.T(p0, 0x7F060145), M.a);  // color:gray050s
            h h4 = P0.j.d;
            c1.n(q3, listMusicRes$result$MUSICLIST0.albumimagepath, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0, 0, 0x7FFC);
            c.d(p0, androidx.compose.foundation.layout.d.n(n0, 6.0f));
            q q4 = androidx.compose.foundation.layout.d.c.then(new LayoutWeightElement(1.0f, true));
            M.y y1 = M.w.a(j.e, d.m, p0, 6);
            int v3 = p0.P;
            i0 i01 = p0.m();
            q q5 = a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h1);
            w.x(p0, i01, h2);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h3);
            }
            w.x(p0, q5, h4);
            p0 p01 = M.n0.a(b0, h0, p0, 0x30);
            int v4 = p0.P;
            i0 i02 = p0.m();
            q q6 = a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p01, h1);
            w.x(p0, i02, h2);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h3);
            }
            w.x(p0, q6, h4);
            c1.b(listMusicRes$result$MUSICLIST0.adultflag, false, false, false, false, false, p0, 0, 0x3FE);
            q q7 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 2);
            String s = listMusicRes$result$MUSICLIST0.songname;
            kotlin.jvm.internal.q.f(s, "songname");
            N1.b(s, q7, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:gray900s
            p0.p(true);
            q q8 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 0.0f, 4.0f, 0.0f, 0.0f, 13), 1.0f), 2);
            String s1 = ListMusicRes.getArtistNames(listMusicRes$result$MUSICLIST0.artistlist);
            kotlin.jvm.internal.q.f(s1, "getArtistNames(...)");
            N1.b(s1, q8, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:gray600s_support_high_contrast
            p0.p(true);
            c.d(p0, androidx.compose.foundation.layout.d.n(n0, 10.0f));
            String s2 = this.getString(0x7F130783);  // string:myprofile_select "선택"
            kotlin.jvm.internal.q.f(s2, "getString(...)");
            boolean z = p0.i(this);
            boolean z1 = p0.i(listMusicRes$result$MUSICLIST0);
            N n1 = p0.N();
            if(z || z1 || n1 == androidx.compose.runtime.k.a) {
                n1 = new N(16, this, listMusicRes$result$MUSICLIST0);
                p0.l0(n1);
            }
            c1.M(s2, null, 13.0f, 26.0f, 0.0f, false, n1, p0, 200064, 18);
            c.d(p0, androidx.compose.foundation.layout.d.n(n0, 14.0f));
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U(this, listMusicRes$result$MUSICLIST0, v, 11);
        }
    }

    private static final H ListItem$lambda$26$lambda$25$lambda$24(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, MUSICLIST listMusicRes$result$MUSICLIST0) {
        settingMusicAlarmSongFragment0.selectMusic = listMusicRes$result$MUSICLIST0;
        FragmentActivity fragmentActivity0 = settingMusicAlarmSongFragment0.requireActivity();
        kotlin.jvm.internal.q.e(fragmentActivity0, "null cannot be cast to non-null type com.iloen.melon.MusicBrowserActivity");
        ((MusicBrowserActivity)fragmentActivity0).onBackPressed();
        return H.a;
    }

    private static final H ListItem$lambda$27(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, MUSICLIST listMusicRes$result$MUSICLIST0, int v, l l0, int v1) {
        settingMusicAlarmSongFragment0.ListItem(listMusicRes$result$MUSICLIST0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    private final void MusicList(l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(1798840675);
        int v1 = (v & 6) == 0 ? (((androidx.compose.runtime.p)l0).i(this) ? 4 : 2) | v : v;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            F f0 = I.a(0, 0, 3, ((androidx.compose.runtime.p)l0));
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            boolean z = ((androidx.compose.runtime.p)l0).i(this);
            com.iloen.melon.fragments.settings.alarm.k k0 = ((androidx.compose.runtime.p)l0).N();
            V v2 = androidx.compose.runtime.k.a;
            if(z || k0 == v2) {
                k0 = new com.iloen.melon.fragments.settings.alarm.k(this, 2);
                ((androidx.compose.runtime.p)l0).l0(k0);
            }
            c1.o(fillElement0, f0, null, false, null, null, null, false, k0, ((androidx.compose.runtime.p)l0), 6, 0xFC);
            boolean z1 = ((androidx.compose.runtime.p)l0).i(this);
            com.iloen.melon.fragments.settings.alarm.b b0 = ((androidx.compose.runtime.p)l0).N();
            if(z1 || b0 == v2) {
                b0 = new com.iloen.melon.fragments.settings.alarm.b(this, 3);
                ((androidx.compose.runtime.p)l0).l0(b0);
            }
            e0.W(f0, 3, b0, ((androidx.compose.runtime.p)l0), 0x30);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.settings.alarm.l(this, v, 1);
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmSongFragment.MusicList.lambda.17.lambda.16..inlined.itemsIndexed.default.1 extends r implements we.k {
            final List $items;
            final we.n $key;

            public com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmSongFragment.MusicList.lambda.17.lambda.16..inlined.itemsIndexed.default.1(we.n n0, List list0) {
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
        public final class com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmSongFragment.MusicList.lambda.17.lambda.16..inlined.itemsIndexed.default.2 extends r implements we.k {
            final List $items;

            public com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmSongFragment.MusicList.lambda.17.lambda.16..inlined.itemsIndexed.default.2(List list0) {
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
        public final class com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmSongFragment.MusicList.lambda.17.lambda.16..inlined.itemsIndexed.default.3 extends r implements we.p {
            final List $items;

            public com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmSongFragment.MusicList.lambda.17.lambda.16..inlined.itemsIndexed.default.3(List list0, SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0) {
                this.$items = list0;
                SettingMusicAlarmSongFragment.this = settingMusicAlarmSongFragment0;
                super(4);
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((androidx.compose.foundation.lazy.a)object0), ((Number)object1).intValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(androidx.compose.foundation.lazy.a a0, int v, l l0, int v1) {
                int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)l0).g(a0) ? 4 : 2) | v1 : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((androidx.compose.runtime.p)l0).e(v) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    MUSICLIST listMusicRes$result$MUSICLIST0 = (MUSICLIST)this.$items.get(v);
                    ((androidx.compose.runtime.p)l0).a0(0xD3C614CE);
                    SettingMusicAlarmSongFragment.access$ListItem(SettingMusicAlarmSongFragment.this, listMusicRes$result$MUSICLIST0, ((androidx.compose.runtime.p)l0), 0);
                    ((androidx.compose.runtime.p)l0).p(false);
                    return;
                }
                ((androidx.compose.runtime.p)l0).T();
            }
        }

    }

    private static final H MusicList$lambda$17$lambda$16(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, O.w w0) {
        kotlin.jvm.internal.q.g(w0, "$this$MelonLazyColumn");
        p p0 = settingMusicAlarmSongFragment0.musicList;
        ((O.j)w0).u(p0.size(), new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmSongFragment.MusicList.lambda.17.lambda.16..inlined.itemsIndexed.default.1(new B1(4), p0), new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmSongFragment.MusicList.lambda.17.lambda.16..inlined.itemsIndexed.default.2(p0), new m0.b(0xBEF78951, new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmSongFragment.MusicList.lambda.17.lambda.16..inlined.itemsIndexed.default.3(p0, settingMusicAlarmSongFragment0), true));
        O.w.a(w0, ComposableSingletons.SettingMusicAlarmSongFragmentKt.INSTANCE.getLambda$-757654162$app_playstoreProdRelease());
        return H.a;
    }

    private static final Object MusicList$lambda$17$lambda$16$lambda$14(int v, MUSICLIST listMusicRes$result$MUSICLIST0) {
        kotlin.jvm.internal.q.g(listMusicRes$result$MUSICLIST0, "item");
        return listMusicRes$result$MUSICLIST0.songid;
    }

    private static final H MusicList$lambda$19$lambda$18(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0) {
        if(settingMusicAlarmSongFragment0.hasMore) {
            ++settingMusicAlarmSongFragment0.pageNo;
            settingMusicAlarmSongFragment0.searchMusic();
        }
        return H.a;
    }

    private static final H MusicList$lambda$20(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, int v, l l0, int v1) {
        settingMusicAlarmSongFragment0.MusicList(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    public static H S(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, l l0, int v) {
        return SettingMusicAlarmSongFragment.initViews$lambda$2$lambda$1(settingMusicAlarmSongFragment0, l0, v);
    }

    private final void SortingSelectionView(q q0, String[] arr_s, we.k k0, l l0, int v, int v1) {
        q q5;
        we.k k2;
        String[] arr_s2;
        q q1;
        we.k k1;
        int v3;
        int v2;
        String[] arr_s1;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x8C499E0E);
        if((v & 0x30) == 0) {
            if((v1 & 2) == 0) {
                arr_s1 = arr_s;
                v2 = p0.i(arr_s1) ? 0x20 : 16;
            }
            else {
                arr_s1 = arr_s;
                v2 = 16;
            }
            v3 = v2 | v;
        }
        else {
            arr_s1 = arr_s;
            v3 = v;
        }
        if((v1 & 4) != 0) {
            v3 |= 0x180;
            k1 = k0;
        }
        else if((v & 0x180) == 0) {
            k1 = k0;
            v3 |= (p0.i(k1) ? 0x100 : 0x80);
        }
        else {
            k1 = k0;
        }
        if((v & 0xC00) == 0) {
            v3 |= (p0.i(this) ? 0x800 : 0x400);
        }
        if(p0.Q(v3 & 1, (v3 & 0x491) != 0x490)) {
            p0.V();
            n n0 = n.a;
            if((v & 1) == 0 || p0.B()) {
                q q2 = (v1 & 1) == 0 ? q0 : n0;
                if((v1 & 2) != 0) {
                    arr_s1 = this.getResources().getStringArray(0x7F03004B);  // array:sortingbar_search
                    kotlin.jvm.internal.q.f(arr_s1, "getStringArray(...)");
                }
                if((v1 & 4) == 0) {
                    arr_s2 = arr_s1;
                    q1 = q2;
                    k2 = k1;
                }
                else {
                    arr_s2 = arr_s1;
                    q1 = q2;
                    k2 = null;
                }
            }
            else {
                p0.T();
                q1 = q0;
                arr_s2 = arr_s1;
                k2 = k1;
            }
            p0.q();
            q q3 = a.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 0.0f, 18.0f, 20.0f, 0.0f, 9), 1.0f), 38.0f), new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final q invoke(q q0, l l0, int v) {
                    kotlin.jvm.internal.q.g(q0, "$this$composed");
                    ((androidx.compose.runtime.p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((androidx.compose.runtime.p)l0).k(k0.i);
                    m m0 = ((androidx.compose.runtime.p)l0).N();
                    if(m0 == androidx.compose.runtime.k.a) {
                        m0 = androidx.appcompat.app.o.d(((androidx.compose.runtime.p)l0));
                    }
                    X0.i i0 = new X0.i(this);
                    com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmSongFragment.SortingSelectionView..inlined.noRippleClickable-YQRRFTQ.default.1.1 settingMusicAlarmSongFragment$SortingSelectionView$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(SettingMusicAlarmSongFragment.this);
                            K0 k00 = (K0)SettingMusicAlarmSongFragment.access$getSortType$p(this.$onSortSelected$inlined);
                            k00.n(k00.m() + 1);
                            if(((K0)SettingMusicAlarmSongFragment.access$getSortType$p(this.$onSortSelected$inlined)).m() > 2) {
                                ((K0)SettingMusicAlarmSongFragment.access$getSortType$p(this.$onSortSelected$inlined)).n(0);
                            }
                            we.k k0 = this.$onSortSelected$inlined;
                            if(k0 != null) {
                                k0.invoke(((K0)SettingMusicAlarmSongFragment.access$getSortType$p(this.$onSortSelected$inlined)).m());
                            }
                        }
                    };
                    q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, settingMusicAlarmSongFragment$SortingSelectionView$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((androidx.compose.runtime.p)l0).p(false);
                    return q1;
                }
            });
            p0 p00 = M.n0.a(j.b, d.k, p0, 54);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q4 = a.d(p0, q3);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q4, P0.j.d);
            arr_s1 = arr_s2;
            androidx.compose.foundation.q.c(De.I.Q(0x7F08017C, p0, 6), "", null, null, null, 0.0f, null, p0, 0x30, 0x7C);  // drawable:btn_common_toggle_14
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 3.0f));
            String s = (String)je.n.n0(((K0)this.sortType).m(), arr_s1);
            if(s == null) {
                s = arr_s1[0];
            }
            N1.b(s, null, e0.T(p0, 0x7F060165), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray800s
            p0.p(true);
            k1 = k2;
            q5 = q1;
        }
        else {
            p0.T();
            q5 = q0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new G3(this, q5, arr_s1, k1, v, v1, 3);
        }
    }

    private static final H SortingSelectionView$lambda$13(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, q q0, String[] arr_s, we.k k0, int v, int v1, l l0, int v2) {
        settingMusicAlarmSongFragment0.SortingSelectionView(q0, arr_s, k0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)), v1);
        return H.a;
    }

    public static H V(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0) {
        return SettingMusicAlarmSongFragment.MusicList$lambda$19$lambda$18(settingMusicAlarmSongFragment0);
    }

    public static Object X(int v, MUSICLIST listMusicRes$result$MUSICLIST0) {
        return SettingMusicAlarmSongFragment.MusicList$lambda$17$lambda$16$lambda$14(v, listMusicRes$result$MUSICLIST0);
    }

    public static final void access$ListItem(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, MUSICLIST listMusicRes$result$MUSICLIST0, l l0, int v) {
        settingMusicAlarmSongFragment0.ListItem(listMusicRes$result$MUSICLIST0, l0, v);
    }

    public static final a0 access$getSortType$p(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0) {
        return settingMusicAlarmSongFragment0.sortType;
    }

    public static final void access$setSelectMusic$p(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, MUSICLIST listMusicRes$result$MUSICLIST0) {
        settingMusicAlarmSongFragment0.selectMusic = listMusicRes$result$MUSICLIST0;
    }

    private final y getBinding() {
        y y0 = this._binding;
        kotlin.jvm.internal.q.d(y0);
        return y0;
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F1309E5;  // string:setting_title_etc_alarm "알람"
    }

    private final void initViews() {
        TitleBar titleBar0 = this.getTitleBar();
        titleBar0.a(B.a.s(1));
        titleBar0.setTitle(this.getString(0x7F130937));  // string:setting_alarm_search_song "곡 검색"
        y y0 = this.getBinding();
        y0.b.setViewCompositionStrategy(t0.d);
        m0.b b0 = new m0.b(0xCD2A6A5B, new com.iloen.melon.fragments.settings.alarm.a(this, 2), true);
        y0.b.setContent(b0);
    }

    private static final H initViews$lambda$2$lambda$1(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, l l0, int v) {
        if(((androidx.compose.runtime.p)l0).Q(v & 1, (v & 3) != 2)) {
            settingMusicAlarmSongFragment0.Body(((androidx.compose.runtime.p)l0), 0);
            return H.a;
        }
        ((androidx.compose.runtime.p)l0).T();
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        Bundle bundle0 = f.j(new ie.m[]{new ie.m("music", this.selectMusic)});
        this.getParentFragmentManager().i0(bundle0, "music_alarm_search_song_request_key");
        return super.onBackPressed();
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        kotlin.jvm.internal.q.g(layoutInflater0, "inflater");
        this.musicList.clear();
        this._binding = y.a(layoutInflater0, viewGroup0);
        y y0 = this.getBinding();
        kotlin.jvm.internal.q.f(y0.a, "getRoot(...)");
        return y0.a;
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        kotlin.jvm.internal.q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initViews();
    }

    private final void searchMusic() {
        this.isApiLoading.setValue(Boolean.TRUE);
        if(this.pageNo == 1) {
            this.musicList.clear();
        }
        Params listMusicReq$Params0 = new Params();
        listMusicReq$Params0.srchWord = this.searchText;
        listMusicReq$Params0.sortType = ((K0)this.sortType).m();
        listMusicReq$Params0.pageNo = this.pageNo;
        listMusicReq$Params0.pageSize = 100;
        this.showProgress(true);
        RequestBuilder.newInstance(new ListMusicReq(this.getContext(), listMusicReq$Params0)).tag("SettingMusicAlarmSongFragment").listener(new com.iloen.melon.fragments.settings.alarm.m(this, 0)).errorListener(new com.iloen.melon.fragments.settings.alarm.m(this, 1)).request();
    }

    private static final void searchMusic$lambda$3(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, ListMusicRes listMusicRes0) {
        boolean z = false;
        settingMusicAlarmSongFragment0.showProgress(false);
        settingMusicAlarmSongFragment0.isApiLoading.setValue(Boolean.FALSE);
        if(!settingMusicAlarmSongFragment0.prepareFetchComplete(listMusicRes0)) {
            settingMusicAlarmSongFragment0.isApiError.setValue(Boolean.TRUE);
            return;
        }
        settingMusicAlarmSongFragment0.isApiError.setValue(Boolean.FALSE);
        if(listMusicRes0.isSuccessful()) {
            b0 b00 = settingMusicAlarmSongFragment0.showSortingBar;
            ArrayList arrayList0 = listMusicRes0.result.musiclist;
            kotlin.jvm.internal.q.f(arrayList0, "musiclist");
            b00.setValue(Boolean.valueOf(!arrayList0.isEmpty()));
            p p0 = settingMusicAlarmSongFragment0.musicList;
            ArrayList arrayList1 = listMusicRes0.result.musiclist;
            kotlin.jvm.internal.q.f(arrayList1, "musiclist");
            p0.addAll(arrayList1);
            if(listMusicRes0.result.pageinfo.pageno < listMusicRes0.result.paginginfo.nextpageno) {
                z = true;
            }
            settingMusicAlarmSongFragment0.hasMore = z;
            return;
        }
        ToastManager.show(listMusicRes0.errormessage);
    }

    private static final void searchMusic$lambda$4(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, VolleyError volleyError0) {
        settingMusicAlarmSongFragment0.isApiError.setValue(Boolean.TRUE);
        settingMusicAlarmSongFragment0.isApiLoading.setValue(Boolean.FALSE);
        settingMusicAlarmSongFragment0.showProgress(false);
    }
}

