package com.iloen.melon.fragments.settings.alarm;

import Ac.e;
import Ac.m2;
import Cc.H3;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import De.d;
import F8.x;
import H8.i;
import J8.y;
import K.m;
import M.p0;
import N0.M;
import O.F;
import P0.h;
import Q0.k0;
import Q0.t0;
import S2.c;
import Zc.N;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.E;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.fragment.app.l0;
import androidx.fragment.app.w;
import androidx.lifecycle.f0;
import androidx.lifecycle.n;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.lifecycle.t;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.B1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.eventbus.EventAlarm;
import com.iloen.melon.fragments.settings.SettingUsageOptimizationFragment;
import com.iloen.melon.playback.voicealarm.AlarmPlayService;
import com.iloen.melon.utils.IntentUtils;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.shortcut.ShortCutItem;
import com.iloen.melon.utils.shortcut.ShortcutManager;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.net.res.VoiceAlarm.Track;
import com.melon.net.res.VoiceAlarmKt;
import com.melon.utils.system.SystemSettingUtils;
import d3.g;
import ie.H;
import ie.j;
import ie.k;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wd.u;
import we.a;
import we.o;
import y0.s;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000E\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\u00072\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0019\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0007\u00A2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0003J\u000F\u0010\u0019\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u0003J\u000F\u0010\u001A\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u0003J\u000F\u0010\u001B\u001A\u00020\u0012H\u0007\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b\u001D\u0010\u0003J\u0017\u0010 \u001A\u00020\u00122\u0006\u0010\u001F\u001A\u00020\u001EH\u0003\u00A2\u0006\u0004\b \u0010!J\u0017\u0010\"\u001A\u00020\u00122\u0006\u0010\u001F\u001A\u00020\u001EH\u0003\u00A2\u0006\u0004\b\"\u0010!J1\u0010(\u001A\u00020\u00122\f\u0010%\u001A\b\u0012\u0004\u0012\u00020$0#2\u0012\u0010\'\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120&H\u0003\u00A2\u0006\u0004\b(\u0010)J3\u0010,\u001A\u00020\u00122\u0006\u0010*\u001A\u00020$2\u0006\u0010+\u001A\u00020\u00042\u0012\u0010\'\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120&H\u0003\u00A2\u0006\u0004\b,\u0010-J\u0017\u0010/\u001A\u00020.2\u0006\u0010*\u001A\u00020$H\u0002\u00A2\u0006\u0004\b/\u00100J\u000F\u00101\u001A\u00020\u0012H\u0003\u00A2\u0006\u0004\b1\u0010\u001CJ\u000F\u00102\u001A\u00020\u0012H\u0003\u00A2\u0006\u0004\b2\u0010\u001CJ\u000F\u00103\u001A\u00020\u0012H\u0003\u00A2\u0006\u0004\b3\u0010\u001CR\u0018\u00105\u001A\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00106R\u001B\u0010;\u001A\u00020\u001E8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b7\u00108\u001A\u0004\b9\u0010:R\u001B\u0010@\u001A\u00020<8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b=\u00108\u001A\u0004\b>\u0010?R\u0014\u0010C\u001A\u0002048BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bA\u0010B\u00A8\u0006E"}, d2 = {"Lcom/iloen/melon/fragments/settings/alarm/SettingMusicAlarmListFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "", "getTitleResId", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lcom/iloen/melon/eventbus/EventAlarm;", "event", "Lie/H;", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventAlarm;)V", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroyView", "ShortCutButton", "(Landroidx/compose/runtime/l;I)V", "initViews", "Lcom/iloen/melon/fragments/settings/alarm/SettingAlarmListViewModel;", "viewModel", "Body", "(Lcom/iloen/melon/fragments/settings/alarm/SettingAlarmListViewModel;Landroidx/compose/runtime/l;I)V", "SelectAll", "", "Lo8/d;", "listItem", "Lkotlin/Function1;", "onItemClick", "AlarmList", "(Ljava/util/List;Lwe/k;Landroidx/compose/runtime/l;I)V", "alarm", "index", "ListItem", "(Lo8/d;ILwe/k;Landroidx/compose/runtime/l;I)V", "", "getDisplayTitle", "(Lo8/d;)Ljava/lang/String;", "DeleteButton", "EmptyBody", "OnBoardingPopup", "LJ8/y;", "_binding", "LJ8/y;", "mainViewModel$delegate", "Lie/j;", "getMainViewModel", "()Lcom/iloen/melon/fragments/settings/alarm/SettingAlarmListViewModel;", "mainViewModel", "Landroid/content/BroadcastReceiver;", "broadcastReceiver$delegate", "getBroadcastReceiver", "()Landroid/content/BroadcastReceiver;", "broadcastReceiver", "getBinding", "()LJ8/y;", "binding", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingMusicAlarmListFragment extends Hilt_SettingMusicAlarmListFragment {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001A\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/settings/alarm/SettingMusicAlarmListFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/settings/alarm/SettingMusicAlarmListFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingMusicAlarmListFragment newInstance() {
            return new SettingMusicAlarmListFragment();
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @Nullable
    private y _binding;
    @NotNull
    private final j broadcastReceiver$delegate;
    @NotNull
    private final j mainViewModel$delegate;

    static {
        SettingMusicAlarmListFragment.Companion = new Companion(null);
        SettingMusicAlarmListFragment.$stable = 8;
    }

    public SettingMusicAlarmListFragment() {
        com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.special..inlined.viewModels.default.2 settingMusicAlarmListFragment$special$$inlined$viewModels$default$20 = new a() {
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
        j j0 = g.P(k.c, settingMusicAlarmListFragment$special$$inlined$viewModels$default$20);
        d d0 = I.a.b(SettingAlarmListViewModel.class);
        com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.special..inlined.viewModels.default.3 settingMusicAlarmListFragment$special$$inlined$viewModels$default$30 = new a() {
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
        com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.special..inlined.viewModels.default.4 settingMusicAlarmListFragment$special$$inlined$viewModels$default$40 = new a(j0) {
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
        this.mainViewModel$delegate = new i(d0, settingMusicAlarmListFragment$special$$inlined$viewModels$default$30, new a(j0) {
            final j $owner$delegate;
            final androidx.fragment.app.I $this_viewModels;

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
        }, settingMusicAlarmListFragment$special$$inlined$viewModels$default$40);
        this.broadcastReceiver$delegate = g.Q(new b(this, 1));

        @Metadata(d1 = {"\u0000\u001D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/iloen/melon/fragments/settings/alarm/SettingMusicAlarmListFragment$broadcastReceiver$2$1", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lie/H;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.broadcastReceiver.2.1 extends BroadcastReceiver {
            public com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.broadcastReceiver.2.1(SettingMusicAlarmListFragment settingMusicAlarmListFragment0) {
            }

            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context context0, Intent intent0) {
                u u0 = null;
                String s = intent0 == null ? null : intent0.getAction();
                com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                Y.w("onReceive() action: ", s, logU$Companion0, "SettingMusicAlarmListFragment");
                if(q.b(s, "com.iloen.melon.intent.action.playservice.isvoicetrackplay")) {
                    boolean z = intent0.getBooleanExtra("isVoiceTrackPlaying", false);
                    l1.B("isPlaying: ", z, logU$Companion0, "SettingMusicAlarmListFragment");
                    if(z) {
                        l0 l00 = SettingMusicAlarmListFragment.this.getChildFragmentManager();
                        String s1 = SettingMusicAlarmListFragment.this.getString(0x7F130949);  // string:setting_alarm_voice_track_pause "알람 중지"
                        b b0 = new b(context0, 2);
                        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
                            l00.C();
                            if(com.melon.ui.popup.b.b(l00, "showOnlyGreenButtonPopup", null, null, 12) == null) {
                                u u1 = new u();
                                u1.a = s1;
                                u1.b = b0;
                                u1.showNow(l00, "showOnlyGreenButtonPopup");
                            }
                        }
                    }
                    else {
                        l0 l01 = SettingMusicAlarmListFragment.this.getChildFragmentManager();
                        if(l01 != null && !Y.z(MelonAppBase.Companion) && !l01.T() && !l01.K) {
                            l01.C();
                            w w0 = com.melon.ui.popup.b.b(l01, "showOnlyGreenButtonPopup", null, null, 12);
                            if(w0 != null) {
                                if(w0 instanceof u) {
                                    u0 = (u)w0;
                                }
                                if(u0 != null) {
                                    u0.dismissNow();
                                }
                            }
                        }
                    }
                }
            }

            private static final H onReceive$lambda$1(Context context0) {
                ToastManager.show(0x7F13094A);  // string:setting_alarm_voice_track_pause_done "알람이 중지 되었습니다."
                Intent intent0 = new Intent(context0, AlarmPlayService.class);
                intent0.setAction("com.iloen.melon.intent.action.ALARM_STOP");
                PendingIntent.getService(context0, 0, intent0, 0xC000000).send();
                return H.a;
            }
        }


        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001A\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/m0;", "VM", "Landroidx/fragment/app/I;", "invoke", "()Landroidx/fragment/app/I;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.special..inlined.viewModels.default.1 extends r implements a {
            final androidx.fragment.app.I $this_viewModels;

            public com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.special..inlined.viewModels.default.1(androidx.fragment.app.I i0) {
                this.$this_viewModels = i0;
                super(0);
            }

            @NotNull
            public final androidx.fragment.app.I invoke() {
                return this.$this_viewModels;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final void AlarmList(List list0, we.k k0, l l0, int v) {
        ((p)l0).c0(-1350737040);
        int v1 = (v & 6) == 0 ? (((p)l0).i(list0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).i(k0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (((p)l0).i(this) ? 0x100 : 0x80);
        }
        int v2 = 1;
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            F f0 = O.I.a(0, 0, 3, ((p)l0));
            E e0 = ((p)l0).N();
            V v3 = androidx.compose.runtime.k.a;
            if(e0 == v3) {
                e0 = androidx.compose.runtime.w.i(new com.iloen.melon.fragments.settings.alarm.j(f0, 0));
                ((p)l0).l0(e0);
            }
            E e1 = ((p)l0).N();
            if(e1 == v3) {
                e1 = androidx.compose.runtime.w.i(new com.iloen.melon.fragments.settings.alarm.j(f0, 1));
                ((p)l0).l0(e1);
            }
            this.showScrolledLine(!((Boolean)e0.getValue()).booleanValue() || !((Boolean)e1.getValue()).booleanValue());
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            boolean z = ((p)l0).i(list0);
            boolean z1 = ((p)l0).i(this);
            if((v1 & 0x70) != 0x20) {
                v2 = 0;
            }
            m2 m20 = ((p)l0).N();
            if((z | z1 | v2) != 0 || m20 == v3) {
                m20 = new m2(list0, this, k0, 25);
                ((p)l0).l0(m20);
            }
            c1.o(fillElement0, f0, null, false, null, null, null, false, m20, ((p)l0), 6, 0xFC);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new e(this, list0, k0, v, 8);
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.AlarmList.lambda.24.lambda.23..inlined.itemsIndexed.default.1 extends r implements we.k {
            final List $items;
            final we.n $key;

            public com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.AlarmList.lambda.24.lambda.23..inlined.itemsIndexed.default.1(we.n n0, List list0) {
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
        public final class com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.AlarmList.lambda.24.lambda.23..inlined.itemsIndexed.default.2 extends r implements we.k {
            final List $items;

            public com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.AlarmList.lambda.24.lambda.23..inlined.itemsIndexed.default.2(List list0) {
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
        public final class com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.AlarmList.lambda.24.lambda.23..inlined.itemsIndexed.default.3 extends r implements we.p {
            final List $items;
            final we.k $onItemClick$inlined;

            public com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.AlarmList.lambda.24.lambda.23..inlined.itemsIndexed.default.3(List list0, SettingMusicAlarmListFragment settingMusicAlarmListFragment0, we.k k0) {
                this.$items = list0;
                SettingMusicAlarmListFragment.this = settingMusicAlarmListFragment0;
                this.$onItemClick$inlined = k0;
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
                    Object object0 = this.$items.get(v);
                    ((p)l0).a0(0x80B7AB06);
                    SettingMusicAlarmListFragment.access$ListItem(SettingMusicAlarmListFragment.this, ((o8.d)object0), v, this.$onItemClick$inlined, ((p)l0), v2 & 0x70);
                    P4.a.b(androidx.compose.foundation.layout.a.l(r0.n.a, 20.0f, 0.0f, 2), e0.T(((p)l0), 0x7F06014A), 0.5f, 0.0f, ((p)l0), 390, 8);  // color:gray100a
                    ((p)l0).p(false);
                    return;
                }
                ((p)l0).T();
            }
        }

    }

    private static final boolean AlarmList$lambda$18$lambda$17(F f0) {
        return f0.d.a() == 0;
    }

    private static final boolean AlarmList$lambda$20$lambda$19(F f0) {
        return f0.d.b() <= 0;
    }

    private static final H AlarmList$lambda$24$lambda$23(List list0, SettingMusicAlarmListFragment settingMusicAlarmListFragment0, we.k k0, O.w w0) {
        q.g(w0, "$this$MelonLazyColumn");
        ((O.j)w0).u(list0.size(), new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.AlarmList.lambda.24.lambda.23..inlined.itemsIndexed.default.1(new B1(3), list0), new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.AlarmList.lambda.24.lambda.23..inlined.itemsIndexed.default.2(list0), new m0.b(0xBEF78951, new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.AlarmList.lambda.24.lambda.23..inlined.itemsIndexed.default.3(list0, settingMusicAlarmListFragment0, k0), true));
        O.w.a(w0, ComposableSingletons.SettingMusicAlarmListFragmentKt.INSTANCE.getLambda$1134620731$app_playstoreProdRelease());
        return H.a;
    }

    private static final Object AlarmList$lambda$24$lambda$23$lambda$21(int v, o8.d d0) {
        q.g(d0, "item");
        return d0.hashCode() + "-" + v;
    }

    private static final H AlarmList$lambda$25(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, List list0, we.k k0, int v, l l0, int v1) {
        settingMusicAlarmListFragment0.AlarmList(list0, k0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    private final void Body(SettingAlarmListViewModel settingAlarmListViewModel0, l l0, int v) {
        int v4;
        p p0 = (p)l0;
        p0.c0(-2051374357);
        int v1 = (v & 6) == 0 ? (p0.i(settingAlarmListViewModel0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(this) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            com.iloen.melon.fragments.settings.alarm.g g0 = p0.N();
            if(g0 == androidx.compose.runtime.k.a) {
                g0 = new com.iloen.melon.fragments.settings.alarm.g(settingAlarmListViewModel0, 2);
                p0.l0(g0);
            }
            ViewState viewState0 = settingAlarmListViewModel0.getViewState();
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.d(p0, n0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
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
            androidx.compose.runtime.w.x(p0, q0, h3);
            if(viewState0 instanceof Success) {
                p0.a0(1670614095);
                List list0 = ((Success)viewState0).getAlarmList();
                if(list0.isEmpty()) {
                    v4 = v1;
                    p0.a0(0x639F8512);
                    this.EmptyBody(p0, v4 >> 3 & 14);
                }
                else {
                    p0.a0(1670700895);
                    M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 4.0f));
                    this.SelectAll(settingAlarmListViewModel0, p0, v1 & 0x7E);
                    r0.q q1 = androidx.compose.foundation.layout.d.c.then(new LayoutWeightElement(1.0f, true));
                    M m0 = M.p.d(r0.d.h, false);
                    int v3 = p0.P;
                    i0 i01 = p0.m();
                    r0.q q2 = r0.a.d(p0, q1);
                    p0.e0();
                    v4 = v1;
                    if(p0.O) {
                        p0.l(i0);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, m0, h0);
                    androidx.compose.runtime.w.x(p0, i01, h1);
                    if(p0.O || !q.b(p0.N(), v3)) {
                        A7.d.q(v3, p0, v3, h2);
                    }
                    androidx.compose.runtime.w.x(p0, q2, h3);
                    this.AlarmList(list0, g0, p0, v4 << 3 & 0x380 | 0x30);
                    if(settingAlarmListViewModel0.isAnySelected()) {
                        p0.a0(179651800);
                        this.DeleteButton(p0, v4 >> 3 & 14);
                    }
                    else {
                        p0.a0(179735190);
                        this.ShortCutButton(p0, v4 >> 3 & 14);
                    }
                    p0.p(false);
                    p0.p(true);
                }
                p0.p(false);
                p0.p(false);
                goto label_77;
            }
            else {
                v4 = v1;
                if(!(viewState0 instanceof Loading)) {
                    throw l1.c(p0, 0x76D32FB5, false);
                }
                p0.a0(0x63A14999);
                p0.p(false);
            label_77:
                p0.p(true);
                if(settingAlarmListViewModel0.getNeedShowOnboarding()) {
                    p0.a0(597580430);
                    this.OnBoardingPopup(p0, v4 >> 3 & 14);
                }
                else {
                    p0.a0(0x22FC3097);
                }
                p0.p(false);
            }
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.settings.alarm.i(this, settingAlarmListViewModel0, v, 0);
        }
    }

    private static final H Body$lambda$12(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, SettingAlarmListViewModel settingAlarmListViewModel0, int v, l l0, int v1) {
        settingMusicAlarmListFragment0.Body(settingAlarmListViewModel0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    private static final H Body$lambda$9$lambda$8(SettingAlarmListViewModel settingAlarmListViewModel0, int v) {
        settingAlarmListViewModel0.toggleSelection(v);
        return H.a;
    }

    private final void DeleteButton(l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xD4190FDB);
        int v1 = (v & 6) == 0 ? (p0.i(this) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 62.0f), e0.T(p0, 0x7F06017F), y0.M.a), new o() {  // color:green502s_support_high_contrast
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
                    com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.DeleteButton..inlined.noRippleClickable-YQRRFTQ.default.1.1 settingMusicAlarmListFragment$DeleteButton$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(SettingMusicAlarmListFragment.this);
                            SettingMusicAlarmListFragment.access$getMainViewModel(SettingMusicAlarmListFragment.this).deleteSelectedAlarms();
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, settingMusicAlarmListFragment$DeleteButton$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            p0 p00 = M.n0.a(M.j.e, r0.d.k, p0, 54);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            androidx.compose.foundation.q.c(De.I.Q(0x7F08012F, p0, 6), null, null, null, null, 0.0f, null, p0, 0x30, 0x7C);  // drawable:btn_common_delete_24
            r0.q q2 = androidx.compose.foundation.layout.a.n(n0, 5.0f, 0.0f, 0.0f, 0.0f, 14);
            String s = this.getString(0x7F1302E5);  // string:delete "삭제"
            q.f(s, "getString(...)");
            N1.b(s, q2, e0.T(p0, 0x7F0604A1), 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30, 0, 0x1FFF8);  // color:white000e
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.settings.alarm.h(this, v, 2);
        }
    }

    private static final H DeleteButton$lambda$40(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, int v, l l0, int v1) {
        settingMusicAlarmListFragment0.DeleteButton(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    private final void EmptyBody(l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xFDDDE865);
        if(p0.Q(v & 1, (v & 1) != 0)) {
            M.y y0 = M.w.a(M.j.c, r0.d.n, p0, 0x30);
            int v1 = p0.P;
            i0 i00 = p0.m();
            r0.q q0 = r0.a.d(p0, androidx.compose.foundation.layout.d.c);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h0);
            }
            androidx.compose.runtime.w.x(p0, q0, P0.j.d);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(r0.n.a, 100.0f));
            androidx.compose.foundation.q.c(De.I.Q(0x7F080786, p0, 6), null, null, null, null, 0.0f, null, p0, 0x30, 0x7C);  // drawable:noimage_logo_large
            M.c.d(p0, androidx.compose.foundation.layout.d.h(r0.n.a, 10.0f));
            N1.b(H0.e.Y(p0, 0x7F130934), null, e0.T(p0, 0x7F060163), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:setting_alarm_empty_desc1 "예정된 알람이 없습니다."
            M.c.d(p0, androidx.compose.foundation.layout.d.h(r0.n.a, 4.0f));
            N1.b(H0.e.Y(p0, 0x7F130935), null, e0.T(p0, 0x7F060163), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:setting_alarm_empty_desc2 "우측 상단 + 를 눌러 알람을 추가하세요."
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.settings.alarm.h(this, v, 3);
        }
    }

    private static final H EmptyBody$lambda$45(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, int v, l l0, int v1) {
        settingMusicAlarmListFragment0.EmptyBody(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    public static H L(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, l l0, int v) {
        return SettingMusicAlarmListFragment.initViews$lambda$5$lambda$4(settingMusicAlarmListFragment0, l0, v);
    }

    private final void ListItem(o8.d d0, int v, we.k k0, l l0, int v1) {
        String s2;
        h h4;
        p p0 = (p)l0;
        p0.c0(0x37617B83);
        int v2 = (v1 & 6) == 0 ? (p0.i(d0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v2 |= (p0.i(this) ? 0x800 : 0x400);
        }
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.layout.a.j(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3), 20.0f), new o() {
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
                    X0.i i0 = new X0.i(d0);
                    com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.ListItem..inlined.noRippleClickable-YQRRFTQ.default.1.1 settingMusicAlarmListFragment$ListItem$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.$alarm$inlined);
                            com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.Companion.newInstance$default(SettingMusicAlarmFragment.Companion, this.$alarm$inlined.a, null, 2, null).open();
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, settingMusicAlarmListFragment$ListItem$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            M.d d1 = M.j.c;
            r0.g g0 = r0.d.m;
            M.y y0 = M.w.a(d1, g0, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v4 = p0.P;
            i0 i01 = p0.m();
            M.b b0 = M.j.a;
            r0.q q2 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q2, h3);
            M.y y1 = M.w.a(d1, g0, p0, 0);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q3 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            M.c.d(p0, androidx.compose.foundation.layout.d.n(n0, 20.0f));
            boolean z = this.getMainViewModel().isCheckBoxChecked(d0);
            boolean z1 = p0.i(this);
            boolean z2 = p0.i(d0);
            N n1 = p0.N();
            if(z1 || z2 || n1 == androidx.compose.runtime.k.a) {
                n1 = new N(14, this, d0);
                p0.l0(n1);
            }
            e0.j(z, 0.0f, n1, p0, 0);
            p0.p(true);
            M.c.d(p0, androidx.compose.foundation.layout.d.n(n0, 8.0f));
            r0.q q4 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 20.0f, 0.0f, 11);
            M.y y2 = M.w.a(d1, g0, p0, 0);
            int v6 = p0.P;
            i0 i03 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y2, h0);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            androidx.compose.runtime.w.x(p0, q5, h3);
            p0 p01 = M.n0.a(b0, r0.d.l, p0, 0x30);
            int v7 = p0.P;
            i0 i04 = p0.m();
            r0.q q6 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h0);
            androidx.compose.runtime.w.x(p0, i04, h1);
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            androidx.compose.runtime.w.x(p0, q6, h3);
            r0.q q7 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 0.0f, 5.0f, 7);
            N1.b(o8.e.b(d0), q7, e0.T(p0, (d0.e ? 0x7F06016D : 0x7F060159)), 20.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // color:gray900s
            M.c.d(p0, androidx.compose.foundation.layout.d.n(n0, 4.0f));
            N1.b(o8.e.f(d0), null, e0.T(p0, (d0.e ? 0x7F06016D : 0x7F060159)), 40.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray900s
            p0.p(true);
            M.c.d(p0, androidx.compose.foundation.layout.d.n(n0, 1.0f));
            N1.b(o8.e.c(d0), null, e0.T(p0, (d0.e ? 0x7F060160 : 0x7F060159)), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray600s_support_high_contrast
            p0.p(true);
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            r0.g g1 = r0.d.o;
            M.y y3 = M.w.a(d1, g1, p0, 0x30);
            int v8 = p0.P;
            i0 i05 = p0.m();
            r0.q q8 = r0.a.d(p0, layoutWeightElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y3, h0);
            androidx.compose.runtime.w.x(p0, i05, h1);
            if(!p0.O && q.b(p0.N(), v8)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v8, p0, v8, h4);
            }
            androidx.compose.runtime.w.x(p0, q8, h3);
            M.c.d(p0, androidx.compose.foundation.layout.d.n(n0, 19.0f));
            r0.q q9 = r0.a.a(n0, new o() {
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
                    X0.i i0 = new X0.i(k0);
                    com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.ListItem.lambda.36.lambda.34.lambda.33..inlined.noRippleClickable-YQRRFTQ.default.1.1 settingMusicAlarmListFragment$ListItem$lambda$36$lambda$34$lambda$33$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.$onItemClick$inlined);
                            this.$index$inlined.invoke(this.$index$inlined);
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, settingMusicAlarmListFragment$ListItem$lambda$36$lambda$34$lambda$33$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            androidx.compose.foundation.q.c(De.I.Q((d0.e ? 0x7F0800E4 : 0x7F0800E3), p0, 0), null, q9, null, null, 0.0f, null, p0, 0x30, 120);  // drawable:btn_alarm_on
            M.c.d(p0, androidx.compose.foundation.layout.d.n(n0, 9.0f));
            N1.b(this.getDisplayTitle(d0), null, e0.T(p0, (d0.e ? 0x7F060160 : 0x7F060159)), 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray600s_support_high_contrast
            p0.p(true);
            p0.p(true);
            if(d0.i == 2) {
                p0.a0(0x923B0E84);
                r0.q q10 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.t(n0, 3), 1.0f), 0.0f, 2.0f, 0.0f, 0.0f, 13);
                M.y y4 = M.w.a(d1, g1, p0, 0x30);
                int v9 = p0.P;
                i0 i06 = p0.m();
                r0.q q11 = r0.a.d(p0, q10);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, y4, h0);
                androidx.compose.runtime.w.x(p0, i06, h1);
                if(p0.O || !q.b(p0.N(), v9)) {
                    A7.d.q(v9, p0, v9, h4);
                }
                androidx.compose.runtime.w.x(p0, q11, h3);
                String s = "";
                if(d0.m == null || !VoiceAlarmKt.isValidate(d0.m)) {
                    Track voiceAlarm$Track1 = d0.m;
                    if(voiceAlarm$Track1 == null) {
                        s2 = "";
                    }
                    else {
                        String s3 = voiceAlarm$Track1.getMessage();
                        s2 = s3 == null ? "" : s3;
                    }
                }
                else {
                    Track voiceAlarm$Track0 = d0.m;
                    if(voiceAlarm$Track0 != null) {
                        String s1 = voiceAlarm$Track0.getEndDate();
                        if(s1 != null) {
                            s = s1;
                        }
                    }
                    s2 = this.getString(0x7F130936, new Object[]{s});  // string:setting_alarm_expire_date "상품 종료일 %s"
                }
                q.d(s2);
                N1.b(s2, null, e0.T(p0, (d0.e ? 0x7F060160 : 0x7F060159)), 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray600s_support_high_contrast
                p0.p(true);
            }
            else {
                p0.a0(0x9143D389);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H3(this, d0, v, k0, v1, 9);
        }
    }

    private static final H ListItem$lambda$36$lambda$34$lambda$29$lambda$28$lambda$27(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, o8.d d0) {
        settingMusicAlarmListFragment0.getMainViewModel().updateCheckBox(d0);
        return H.a;
    }

    private static final H ListItem$lambda$37(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, o8.d d0, int v, we.k k0, int v1, l l0, int v2) {
        settingMusicAlarmListFragment0.ListItem(d0, v, k0, l0, (v1 | 1) & -920350135 | ((0x24924924 & (v1 | 1)) >> 1 | 306783378 & (v1 | 1)) | (306783378 & (v1 | 1)) << 1 & (0x24924924 & (v1 | 1)));
        return H.a;
    }

    public static com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.broadcastReceiver.2.1 M(SettingMusicAlarmListFragment settingMusicAlarmListFragment0) {
        return SettingMusicAlarmListFragment.broadcastReceiver_delegate$lambda$0(settingMusicAlarmListFragment0);
    }

    public static H N() {
        return SettingMusicAlarmListFragment.onResume$lambda$6();
    }

    private final void OnBoardingPopup(l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xDCCB283);
        if(p0.Q(v & 1, (v & 1) != 0)) {
            r0.q q0 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.c, 0.0f, 0.0f, 8.0f, 0.0f, 11);
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 6);
            int v1 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h2);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            r0.q q2 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(r0.n.a, 0.0f, 0.0f, 17.0f, 0.0f, 11), 10.0f), 6.0f);
            r0.q q3 = H0.b.q(r0.d.o, q2);
            C0.c c0 = De.I.Q(0x7F08061F, p0, 6);  // drawable:img_common_onboard_arrow_top
            y0.k k0 = new y0.k(e0.T(p0, 0x7F06017F), 5);  // color:green502s_support_high_contrast
            r0.n n0 = r0.n.a;
            h h3 = P0.j.d;
            androidx.compose.foundation.q.c(c0, null, q3, r0.d.i, null, 0.0f, k0, p0, 0xC30, 0x30);
            r0.q q4 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.v(n0, null, 3), 35.0f);
            r0.q q5 = androidx.compose.foundation.q.f(H0.b.q(r0.d.o, q4), e0.T(p0, 0x7F06017F), T.e.b(100.0f));  // color:green502s_support_high_contrast
            M m0 = M.p.d(r0.d.e, false);
            int v2 = p0.P;
            i0 i01 = p0.m();
            r0.q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            androidx.compose.runtime.w.x(p0, q6, h3);
            r0.q q7 = androidx.compose.foundation.layout.a.k(n0, 16.0f, 9.0f);
            N1.b(H0.e.Y(p0, 0x7F130943), q7, e0.T(p0, 0x7F0604A1), 14.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 1, 0, null, null, p0, 0xC30, 0xC00, 0x1DDF0);  // string:setting_alarm_voice_onboarding "NEW! 보이스알람 설정하기"
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.settings.alarm.h(this, v, 1);
        }
    }

    private static final H OnBoardingPopup$lambda$48(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, int v, l l0, int v1) {
        settingMusicAlarmListFragment0.OnBoardingPopup(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    public static boolean P(F f0) {
        return SettingMusicAlarmListFragment.AlarmList$lambda$18$lambda$17(f0);
    }

    public static Object Q(int v, o8.d d0) {
        return SettingMusicAlarmListFragment.AlarmList$lambda$24$lambda$23$lambda$21(v, d0);
    }

    public static void R(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, View view0) {
        SettingMusicAlarmListFragment.initViews$lambda$3$lambda$2$lambda$1(settingMusicAlarmListFragment0, view0);
    }

    private final void SelectAll(SettingAlarmListViewModel settingAlarmListViewModel0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(1301525106);
        int v1 = (v & 6) == 0 ? (p0.i(settingAlarmListViewModel0) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
            c0.a = settingAlarmListViewModel0.isAllSelected();
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.layout.d.h(n0, 38.0f), new o() {
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
                    X0.i i0 = new X0.i(settingAlarmListViewModel0);
                    com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.SelectAll..inlined.noRippleClickable-YQRRFTQ.default.1.1 settingMusicAlarmListFragment$SelectAll$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.$viewModel$inlined);
                            this.$isAllSelected$inlined.selectAllButtonClick(this.$isAllSelected$inlined.a);
                            this.$isAllSelected$inlined.a = !this.$isAllSelected$inlined.a;
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, settingMusicAlarmListFragment$SelectAll$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            M.c.d(p0, androidx.compose.foundation.layout.d.n(n0, 20.0f));
            e0.j(c0.a, 0.0f, new N(15, settingAlarmListViewModel0, c0), p0, 0);
            r0.q q2 = androidx.compose.foundation.layout.a.n(n0, 8.0f, 0.0f, 0.0f, 0.0f, 14);
            N1.b(H0.e.Y(p0, (c0.a ? 0x7F1310D9 : 0x7F130914)), q2, e0.T(p0, (c0.a ? 0x7F06017C : 0x7F06016D)), 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30, 0, 0x1FFF8);  // string:unselect_selection "선택해제"
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.settings.alarm.i(this, settingAlarmListViewModel0, v, 1);
        }
    }

    private static final H SelectAll$lambda$15$lambda$14(SettingAlarmListViewModel settingAlarmListViewModel0, C c0) {
        settingAlarmListViewModel0.selectAllButtonClick(c0.a);
        c0.a = !c0.a;
        return H.a;
    }

    private static final H SelectAll$lambda$16(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, SettingAlarmListViewModel settingAlarmListViewModel0, int v, l l0, int v1) {
        settingMusicAlarmListFragment0.SelectAll(settingAlarmListViewModel0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    public final void ShortCutButton(@Nullable l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xA0AB0F00);
        int v1 = (v & 6) == 0 ? (p0.i(this) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.q.e(androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.q(n0, 221.0f), 0.0f, 0.0f, 0.0f, 24.0f, 7), new y0.E(e.k.A(new s[]{new s(e0.T(p0, 0x7F06017C)), new s(e0.T(p0, 0x7F06047B))}), null, 0L, 0x7F8000007F800000L), T.e.a(50), 4), new o() {  // color:green500s_support_high_contrast
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
                    X0.i i0 = new X0.i(this.$role);
                    com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.ShortCutButton..inlined.noRippleClickable-YQRRFTQ.default.1.1 settingMusicAlarmListFragment$ShortCutButton$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.$focusManager);
                            ShortCutItem shortCutItem0 = ShortCutItem.MELON_ALARM;
                            if(ShortcutManager.getInstance().hasShortcutInHomeScreen(shortCutItem0.getShortcutId(), true)) {
                                ToastManager.show(0x7F130A04);  // string:shortcut_exist_icon "이미 홈 화면에 바로가기가 존재합니다."
                                return;
                            }
                            ShortcutManager.getInstance().requestShortcut(ShortcutManager.createShortcutInfo(shortCutItem0.getShortcutId(), shortCutItem0.getStringId(), 0x7F100001, ShortcutManager.createShortcutDataIntent(shortCutItem0.getShortcutUri())));  // mipmap:icon_launcher_alarm
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, settingMusicAlarmListFragment$ShortCutButton$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            p0 p00 = M.n0.a(M.j.e, r0.d.k, p0, 54);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            r0.q q2 = androidx.compose.foundation.layout.a.l(n0, 0.0f, 12.0f, 1);
            androidx.compose.foundation.q.c(De.I.Q(0x7F080610, p0, 6), null, q2, null, null, 0.0f, null, p0, 0x1B0, 120);  // drawable:img_alarm
            r0.q q3 = androidx.compose.foundation.layout.a.n(n0, 10.0f, 0.0f, 0.0f, 0.0f, 14);
            String s = this.getString(0x7F130231);  // string:ctx_menu_add_shortcut_to_home "홈 화면 바로가기 추가"
            q.f(s, "getString(...)");
            N1.b(s, q3, e0.T(p0, 0x7F0604A1), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // color:white000e
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.settings.alarm.h(this, v, 0);
        }
    }

    private static final H ShortCutButton$lambda$43(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, int v, l l0, int v1) {
        settingMusicAlarmListFragment0.ShortCutButton(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    public static H T(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, SettingAlarmListViewModel settingAlarmListViewModel0, int v, l l0, int v1) {
        return SettingMusicAlarmListFragment.Body$lambda$12(settingMusicAlarmListFragment0, settingAlarmListViewModel0, v, l0, v1);
    }

    public static boolean U(F f0) {
        return SettingMusicAlarmListFragment.AlarmList$lambda$20$lambda$19(f0);
    }

    public static H V(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, int v, l l0, int v1) {
        return SettingMusicAlarmListFragment.OnBoardingPopup$lambda$48(settingMusicAlarmListFragment0, v, l0, v1);
    }

    public static H W(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, int v, l l0, int v1) {
        return SettingMusicAlarmListFragment.EmptyBody$lambda$45(settingMusicAlarmListFragment0, v, l0, v1);
    }

    public static H X(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, int v, l l0, int v1) {
        return SettingMusicAlarmListFragment.DeleteButton$lambda$40(settingMusicAlarmListFragment0, v, l0, v1);
    }

    public static H a0(SettingAlarmListViewModel settingAlarmListViewModel0, int v) {
        return SettingMusicAlarmListFragment.Body$lambda$9$lambda$8(settingAlarmListViewModel0, v);
    }

    public static final void access$ListItem(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, o8.d d0, int v, we.k k0, l l0, int v1) {
        settingMusicAlarmListFragment0.ListItem(d0, v, k0, l0, v1);
    }

    public static H b0(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, int v, l l0, int v1) {
        return SettingMusicAlarmListFragment.ShortCutButton$lambda$43(settingMusicAlarmListFragment0, v, l0, v1);
    }

    private static final com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.broadcastReceiver.2.1 broadcastReceiver_delegate$lambda$0(SettingMusicAlarmListFragment settingMusicAlarmListFragment0) {
        return new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.broadcastReceiver.2.1(settingMusicAlarmListFragment0);
    }

    private final y getBinding() {
        y y0 = this._binding;
        q.d(y0);
        return y0;
    }

    private final BroadcastReceiver getBroadcastReceiver() {
        return (BroadcastReceiver)this.broadcastReceiver$delegate.getValue();
    }

    private final String getDisplayTitle(o8.d d0) {
        switch(d0.i) {
            case 0: {
                String s = this.getString(0x7F130816);  // string:playlist "재생목록"
                q.f(s, "getString(...)");
                return s;
            }
            case 1: {
                return d0.j == null ? "" : d0.j;
            }
            case 2: {
                Track voiceAlarm$Track0 = d0.m;
                if(voiceAlarm$Track0 != null) {
                    String s1 = voiceAlarm$Track0.getTrackName();
                    return s1 == null ? "" : s1;
                }
                return "";
            }
            default: {
                return "";
            }
        }
    }

    private final SettingAlarmListViewModel getMainViewModel() {
        return (SettingAlarmListViewModel)this.mainViewModel$delegate.getValue();
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F1309E5;  // string:setting_title_etc_alarm "알람"
    }

    private final void initViews() {
        TitleBar titleBar0 = this.getTitleBar();
        x x0 = new x(0);
        x0.c = new com.iloen.melon.fragments.settings.alarm.d(this, 1);
        F8.o o0 = B.a.s(1);
        o0.g(x0);
        titleBar0.a(o0);
        titleBar0.setTitle(this.getString(0x7F1309E5));  // string:setting_title_etc_alarm "알람"
        titleBar0.f(false);
        y y0 = this.getBinding();
        y0.b.setViewCompositionStrategy(t0.d);
        m0.b b0 = new m0.b(0x926D6E09, new com.iloen.melon.fragments.settings.alarm.a(this, 1), true);
        y0.b.setContent(b0);

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment$initViews$1$rightItem$1$1$1", f = "SettingMusicAlarmListFragment.kt", l = {0xA5}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.initViews.1.rightItem.1.1.1 extends oe.i implements we.n {
            int label;

            public com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.initViews.1.rightItem.1.1.1(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, Continuation continuation0) {
                SettingMusicAlarmListFragment.this = settingMusicAlarmListFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.initViews.1.rightItem.1.1.1(SettingMusicAlarmListFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.initViews.1.rightItem.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        SettingAlarmListViewModel settingAlarmListViewModel0 = SettingMusicAlarmListFragment.this.getMainViewModel();
                        this.label = 1;
                        return settingAlarmListViewModel0.updateOnboarding(this) == a0 ? a0 : H.a;
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
        }

    }

    private static final void initViews$lambda$3$lambda$2$lambda$1(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, View view0) {
        BuildersKt__Builders_commonKt.launch$default(f0.f(settingMusicAlarmListFragment0), null, null, new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.initViews.1.rightItem.1.1.1(settingMusicAlarmListFragment0, null), 3, null);
        com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.Companion.newInstance$default(SettingMusicAlarmFragment.Companion, 0, null, 3, null).open();
    }

    private static final H initViews$lambda$5$lambda$4(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, l l0, int v) {
        if(((p)l0).Q(v & 1, (v & 3) != 2)) {
            settingMusicAlarmListFragment0.Body(settingMusicAlarmListFragment0.getMainViewModel(), ((p)l0), 0);
            return H.a;
        }
        ((p)l0).T();
        return H.a;
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        this.getMainViewModel().initialize();
        this._binding = y.a(layoutInflater0, viewGroup0);
        y y0 = this.getBinding();
        q.f(y0.a, "getRoot(...)");
        return y0.a;
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@Nullable EventAlarm eventAlarm0) {
        if(eventAlarm0 != null) {
            this.getMainViewModel().initialize();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onPause() {
        super.onPause();
        Context context0 = this.getContext();
        if(context0 != null) {
            context0.unregisterReceiver(this.getBroadcastReceiver());
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        Object object0 = new SystemSettingUtils(context0).a.getSystemService("power");
        q.e(object0, "null cannot be cast to non-null type android.os.PowerManager");
        if(!((PowerManager)object0).isIgnoringBatteryOptimizations("com.iloen.melon")) {
            com.melon.ui.popup.b.x(this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F130079), false, false, null, null, new com.iloen.melon.fragments.mymusic.dna.d(8), null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
        }
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("com.iloen.melon.intent.action.playservice.isvoicetrackplay");
        P1.c.registerReceiver(this.requireContext(), this.getBroadcastReceiver(), intentFilter0, "com.iloen.melon.permission.SIG_PERMISSION", null, 4);
        Intent intent0 = new Intent();
        Q1.c.Z(intent0, "com.iloen.melon.intent.action.playservice.checkvoicetrackplay", 2);
        IntentUtils.sendBroadcast(this.getContext(), intent0);
    }

    private static final H onResume$lambda$6() {
        Navigator.open(SettingUsageOptimizationFragment.Companion.newInstance());
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initViews();
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new we.n(null) {
            int label;

            {
                SettingMusicAlarmListFragment.this = settingMusicAlarmListFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.onViewCreated.1(SettingMusicAlarmListFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        t t0 = SettingMusicAlarmListFragment.this.getViewLifecycleOwner().getLifecycle();
                        com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.onViewCreated.1.1 settingMusicAlarmListFragment$onViewCreated$1$10 = new we.n(null) {
                            int label;

                            {
                                SettingMusicAlarmListFragment.this = settingMusicAlarmListFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.onViewCreated.1.1(SettingMusicAlarmListFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.onViewCreated.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = SettingMusicAlarmListFragment.this.getMainViewModel().getTrackList();
                                        com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.onViewCreated.1.1.1 settingMusicAlarmListFragment$onViewCreated$1$1$10 = new we.n(null) {
                                            Object L$0;
                                            int label;

                                            {
                                                SettingMusicAlarmListFragment.this = settingMusicAlarmListFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.onViewCreated.1.1.1(SettingMusicAlarmListFragment.this, continuation0);
                                                continuation1.L$0 = object0;
                                                return continuation1;
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((List)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(List list0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.onViewCreated.1.1.1)this.create(list0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                List list0 = (List)this.L$0;
                                                if(this.label != 0) {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                                d5.n.D(object0);
                                                LogU.Companion.d("SettingMusicAlarmFragment", "voiceAlarmValidModel.trackList.collectLatest: " + list0);
                                                if(!list0.isEmpty()) {
                                                    SettingMusicAlarmListFragment.this.getMainViewModel().updateVoiceAlarmTrackList(list0);
                                                }
                                                return H.a;
                                            }
                                        };
                                        this.label = 1;
                                        return FlowKt.collectLatest(stateFlow0, settingMusicAlarmListFragment$onViewCreated$1$1$10, this) == a0 ? a0 : H.a;
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
                        return f0.i(t0, androidx.lifecycle.s.d, settingMusicAlarmListFragment$onViewCreated$1$10, this) == a0 ? a0 : H.a;
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
    }
}

