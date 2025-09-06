package com.iloen.melon.fragments.settings;

import U4.F;
import Ub.q;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.constants.ListKeepOption;
import com.iloen.melon.custom.RadioGroup;
import com.iloen.melon.custom.SettingItemView;
import com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.playlist.b;
import ie.H;
import ie.m;
import java.util.GregorianCalendar;
import javax.inject.Inject;
import kc.d3;
import kc.m0;
import kc.n0;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\u000F\u0010\u000EJ\u001F\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\u0010\u0010\u000EJ\u000F\u0010\u0011\u001A\u00020\u0006H\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u001A\u001A\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ!\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001C\u001A\u00020\u00192\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001F\u0010\u0003J\u000F\u0010 \u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b \u0010\u0003J\u000F\u0010\"\u001A\u00020!H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b%\u0010&R\"\u0010(\u001A\u00020\'8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001A\u00020.8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b/\u00100\u001A\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00105\u001A\u00020!8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b5\u0010#\u00A8\u00067"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingAddPositionFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "Lie/H;", "initViews", "", "state", "updateScheduleStopView", "(I)V", "Lcom/iloen/melon/custom/RadioGroup;", "radioGroup", "checkedId", "setAccessibilityAddPlaylist", "(Lcom/iloen/melon/custom/RadioGroup;I)V", "setAccessibilityAddDuplicatedSong", "setAccessibilityPlaylistDelete", "getTitleResId", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "onStop", "", "onBackPressed", "()Z", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "Lkc/s2;", "playlistManager", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "setPlaylistManager", "(Lkc/s2;)V", "LUb/q;", "playbackManager", "LUb/q;", "getPlaybackManager", "()LUb/q;", "setPlaybackManager", "(LUb/q;)V", "isStopTimerRunning", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingAddPositionFragment extends Hilt_SettingAddPositionFragment {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001A\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingAddPositionFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/settings/SettingAddPositionFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingAddPositionFragment newInstance() {
            return new SettingAddPositionFragment();
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @Inject
    public q playbackManager;
    @Inject
    public s2 playlistManager;

    static {
        SettingAddPositionFragment.Companion = new Companion(null);
        SettingAddPositionFragment.$stable = 8;
    }

    @NotNull
    public final q getPlaybackManager() {
        q q0 = this.playbackManager;
        if(q0 != null) {
            return q0;
        }
        kotlin.jvm.internal.q.m("playbackManager");
        throw null;
    }

    @NotNull
    public final s2 getPlaylistManager() {
        s2 s20 = this.playlistManager;
        if(s20 != null) {
            return s20;
        }
        kotlin.jvm.internal.q.m("playlistManager");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "settingsPlaylist");
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F131059;  // string:title_setting_playlist_setting "재생목록 설정"
    }

    private final void initViews() {
        Log.d("SettingAddPositionFragment", "initViews()");
        View view0 = this.findViewById(0x7F0A05C9);  // id:item_scheduled_stop
        kotlin.jvm.internal.q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        ((SettingItemView)view0).setSubTextOnOff(this.isStopTimerRunning());
        ((SettingItemView)view0).setViewType(10);
        ViewUtils.setOnClickListener(((SettingItemView)view0), new c(this, 0));
        D d0 = this.getViewLifecycleOwner();
        kotlin.jvm.internal.q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(((SettingItemView)view0), null) {
            final SettingItemView $schedulStopView;
            int label;

            {
                SettingAddPositionFragment.this = settingAddPositionFragment0;
                this.$schedulStopView = settingItemView0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.SettingAddPositionFragment.initViews.2(SettingAddPositionFragment.this, this.$schedulStopView, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.SettingAddPositionFragment.initViews.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Flow flow0 = FlowKt.distinctUntilChanged(new Flow() {
                            @Override  // kotlinx.coroutines.flow.Flow
                            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                                com.iloen.melon.fragments.settings.SettingAddPositionFragment.initViews.2.invokeSuspend..inlined.map.1.2 settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$20 = new FlowCollector() {
                                    @Override  // kotlinx.coroutines.flow.FlowCollector
                                    public final Object emit(Object object0, Continuation continuation0) {
                                        com.iloen.melon.fragments.settings.SettingAddPositionFragment.initViews.2.invokeSuspend..inlined.map.1.2.1 settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10;
                                        if(continuation0 instanceof com.iloen.melon.fragments.settings.SettingAddPositionFragment.initViews.2.invokeSuspend..inlined.map.1.2.1) {
                                            settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10 = (com.iloen.melon.fragments.settings.SettingAddPositionFragment.initViews.2.invokeSuspend..inlined.map.1.2.1)continuation0;
                                            int v = settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10.label;
                                            if((v & 0x80000000) == 0) {
                                                settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                                                    int I$0;
                                                    Object L$0;
                                                    Object L$1;
                                                    Object L$2;
                                                    Object L$3;
                                                    int label;
                                                    Object result;

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        this.result = object0;
                                                        this.label |= 0x80000000;
                                                        return continuation0.emit(null, this);
                                                    }
                                                };
                                            }
                                            else {
                                                settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10.label = v ^ 0x80000000;
                                            }
                                        }
                                        else {
                                            settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                                                int I$0;
                                                Object L$0;
                                                Object L$1;
                                                Object L$2;
                                                Object L$3;
                                                int label;
                                                Object result;

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    this.result = object0;
                                                    this.label |= 0x80000000;
                                                    return continuation0.emit(null, this);
                                                }
                                            };
                                        }
                                        Object object1 = settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10.result;
                                        a a0 = a.a;
                                        switch(settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10.label) {
                                            case 0: {
                                                d5.n.D(object1);
                                                m m0 = new m(new Integer(((fc.a)object0).a), Boolean.valueOf(((fc.a)object0).b));
                                                settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10.L$0 = null;
                                                settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10.L$1 = null;
                                                settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10.L$2 = null;
                                                settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10.L$3 = null;
                                                settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10.I$0 = 0;
                                                settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10.label = 1;
                                                return this.$this_unsafeFlow.emit(m0, settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10) == a0 ? a0 : H.a;
                                            }
                                            case 1: {
                                                FlowCollector flowCollector0 = (FlowCollector)settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10.L$3;
                                                com.iloen.melon.fragments.settings.SettingAddPositionFragment.initViews.2.invokeSuspend..inlined.map.1.2.1 settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$11 = (com.iloen.melon.fragments.settings.SettingAddPositionFragment.initViews.2.invokeSuspend..inlined.map.1.2.1)settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$2$10.L$1;
                                                d5.n.D(object1);
                                                return H.a;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                };
                                Object object0 = this.$this_unsafeTransform$inlined.collect(settingAddPositionFragment$initViews$2$invokeSuspend$$inlined$map$1$20, continuation0);
                                return object0 == a.a ? object0 : H.a;
                            }
                        });
                        com.iloen.melon.fragments.settings.SettingAddPositionFragment.initViews.2.2 settingAddPositionFragment$initViews$2$20 = new n(SettingAddPositionFragment.this, null) {
                            final SettingItemView $schedulStopView;
                            Object L$0;
                            int label;

                            {
                                this.$schedulStopView = settingItemView0;
                                SettingAddPositionFragment.this = settingAddPositionFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.fragments.settings.SettingAddPositionFragment.initViews.2.2(this.$schedulStopView, SettingAddPositionFragment.this, continuation0);
                                continuation1.L$0 = object0;
                                return continuation1;
                            }

                            public final Object invoke(m m0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.settings.SettingAddPositionFragment.initViews.2.2)this.create(m0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((m)object0), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                m m0 = (m)this.L$0;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                Log.d("SettingAddPositionFragment", "stateFlow: " + F.a0(((Number)m0.a).intValue()) + ", isPlaying: " + ((Boolean)m0.b).booleanValue());
                                boolean z = SettingAddPositionFragment.this.isStopTimerRunning();
                                this.$schedulStopView.setSubTextOnOff(z);
                                return H.a;
                            }
                        };
                        this.label = 1;
                        return FlowKt.collectLatest(flow0, settingAddPositionFragment$initViews$2$20, this) == a0 ? a0 : H.a;
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
        View view1 = this.findViewById(0x7F0A09A2);  // id:radiogroup_addto
        kotlin.jvm.internal.q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.RadioGroup");
        AddPosition addPosition0 = MelonSettingInfo.getPlayListAddPosition();
        if(AddPosition.d == addPosition0) {
            ((RadioGroup)view1).a(0x7F0A0070);  // id:add_after_current
            this.setAccessibilityAddPlaylist(((RadioGroup)view1), 0x7F0A0070);  // id:add_after_current
        }
        else if(AddPosition.c == addPosition0) {
            ((RadioGroup)view1).a(0x7F0A0074);  // id:add_to_end
            this.setAccessibilityAddPlaylist(((RadioGroup)view1), 0x7F0A0074);  // id:add_to_end
        }
        else {
            ((RadioGroup)view1).a(0x7F0A0075);  // id:add_to_first
            this.setAccessibilityAddPlaylist(((RadioGroup)view1), 0x7F0A0075);  // id:add_to_first
        }
        ((RadioGroup)view1).setOnCheckedChangeListener(new d(this, 0));
        View view2 = this.findViewById(0x7F0A09A6);  // id:radiogroup_duplication_options
        kotlin.jvm.internal.q.e(view2, "null cannot be cast to non-null type com.iloen.melon.custom.RadioGroup");
        if(MelonSettingInfo.getUseRemoveDuplicatedPlaylist()) {
            ((RadioGroup)view2).a(0x7F0A0400);  // id:duplicate_delete_layout
            this.setAccessibilityAddDuplicatedSong(((RadioGroup)view2), 0x7F0A0400);  // id:duplicate_delete_layout
        }
        else {
            ((RadioGroup)view2).a(0x7F0A0402);  // id:duplicate_keep_layout
            this.setAccessibilityAddDuplicatedSong(((RadioGroup)view2), 0x7F0A0402);  // id:duplicate_keep_layout
        }
        ((RadioGroup)view2).setOnCheckedChangeListener(new d(this, 1));
        View view3 = this.findViewById(0x7F0A09A7);  // id:radiogroup_keepoptions
        kotlin.jvm.internal.q.e(view3, "null cannot be cast to non-null type com.iloen.melon.custom.RadioGroup");
        if(ListKeepOption.b == MelonSettingInfo.getCurrentListKeepOption()) {
            ((RadioGroup)view3).a(0x7F0A08CD);  // id:oldlist_keep_layout
            this.setAccessibilityPlaylistDelete(((RadioGroup)view3), 0x7F0A08CD);  // id:oldlist_keep_layout
        }
        else {
            ((RadioGroup)view3).a(0x7F0A08CB);  // id:oldlist_delete_layout
            this.setAccessibilityPlaylistDelete(((RadioGroup)view3), 0x7F0A08CB);  // id:oldlist_delete_layout
        }
        ((RadioGroup)view3).setOnCheckedChangeListener(new d(this, 2));
        this.calculateScrollView(this.findViewById(0x7F0A0A78));  // id:setting_scrollview
    }

    private static final void initViews$lambda$0(SettingAddPositionFragment settingAddPositionFragment0, View view0) {
        Context context0 = settingAddPositionFragment0.getContext();
        if(com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper.Companion.canScheduleExactAlarms$default(AlarmPermissionHelper.Companion, context0, null, null, 6, null)) {
            SettingStopTimerFragment.Companion.newInstance().open();
        }
    }

    private static final void initViews$lambda$1(SettingAddPositionFragment settingAddPositionFragment0, RadioGroup radioGroup0, int v) {
        AddPosition addPosition0;
        switch(v) {
            case 0x7F0A0070: {  // id:add_after_current
                addPosition0 = AddPosition.d;
                break;
            }
            case 0x7F0A0074: {  // id:add_to_end
                addPosition0 = AddPosition.c;
                break;
            }
            case 0x7F0A0075: {  // id:add_to_first
                addPosition0 = AddPosition.b;
                break;
            }
            default: {
                addPosition0 = null;
            }
        }
        if(addPosition0 != null) {
            MelonSettingInfo.setPlayListAddPosition(addPosition0);
            ((d3)settingAddPositionFragment0.getPlaylistManager()).v(addPosition0);
            kotlin.jvm.internal.q.d(radioGroup0);
            settingAddPositionFragment0.setAccessibilityAddPlaylist(radioGroup0, v);
        }
    }

    private static final void initViews$lambda$2(SettingAddPositionFragment settingAddPositionFragment0, RadioGroup radioGroup0, int v) {
        Boolean boolean0;
        switch(v) {
            case 0x7F0A0400: {  // id:duplicate_delete_layout
                boolean0 = Boolean.TRUE;
            label_4:
                if(boolean0 != null) {
                    goto label_7;
                }
                break;
            }
            case 0x7F0A0402: {  // id:duplicate_keep_layout
                boolean0 = Boolean.FALSE;
            label_7:
                MelonSettingInfo.setUseRemoveDuplicatedPlaylist(boolean0.booleanValue());
                s2 s20 = settingAddPositionFragment0.getPlaylistManager();
                n0 n00 = new n0(((b)((d3)s20).a), boolean0.booleanValue(), null);
                BuildersKt__Builders_commonKt.launch$default(((b)((d3)s20).a).m, null, null, n00, 3, null);
                kotlin.jvm.internal.q.d(radioGroup0);
                settingAddPositionFragment0.setAccessibilityAddDuplicatedSong(radioGroup0, v);
                break;
            }
            default: {
                boolean0 = null;
                goto label_4;
            }
        }
    }

    private static final void initViews$lambda$3(SettingAddPositionFragment settingAddPositionFragment0, RadioGroup radioGroup0, int v) {
        ListKeepOption listKeepOption0;
        switch(v) {
            case 0x7F0A08CB: {  // id:oldlist_delete_layout
                listKeepOption0 = ListKeepOption.c;
                break;
            }
            case 0x7F0A08CD: {  // id:oldlist_keep_layout
                listKeepOption0 = ListKeepOption.b;
                break;
            }
            default: {
                listKeepOption0 = null;
            }
        }
        if(listKeepOption0 != null) {
            MelonSettingInfo.setCurrentListKeepOption(listKeepOption0);
            d3 d30 = (d3)settingAddPositionFragment0.getPlaylistManager();
            d30.getClass();
            ((b)d30.a).getClass();
            m0 m00 = new m0(((b)d30.a), listKeepOption0, null);
            BuildersKt__Builders_commonKt.launch$default(((b)d30.a).m, null, null, m00, 3, null);
            kotlin.jvm.internal.q.d(radioGroup0);
            settingAddPositionFragment0.setAccessibilityPlaylistDelete(radioGroup0, v);
        }
    }

    private final boolean isStopTimerRunning() {
        return new GregorianCalendar().getTimeInMillis() <= MelonSettingInfo.getMelonTimer();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        return false;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        kotlin.jvm.internal.q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0820, viewGroup0, false);  // layout:setting_addposition
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStart() {
        super.onStart();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStop() {
        super.onStop();
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        kotlin.jvm.internal.q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initViews();
    }

    private final void setAccessibilityAddDuplicatedSong(RadioGroup radioGroup0, int v) {
        this.setAccessibilityRadioGroup(radioGroup0, v, new String[]{this.getString(0x7F130983), this.getString(0x7F130982)}, new int[]{0x7F0A0402, 0x7F0A0400});  // string:setting_duplicate_song_keep "중복곡 포함하고 담기"
    }

    private final void setAccessibilityAddPlaylist(RadioGroup radioGroup0, int v) {
        this.setAccessibilityRadioGroup(radioGroup0, v, new String[]{this.getString(0x7F13002B), this.getString(0x7F130028), this.getString(0x7F130027)}, new int[]{0x7F0A0075, 0x7F0A0074, 0x7F0A0070});  // string:addposition_first "목록 맨 처음"
    }

    private final void setAccessibilityPlaylistDelete(RadioGroup radioGroup0, int v) {
        this.setAccessibilityRadioGroup(radioGroup0, v, new String[]{this.getString(0x7F130976), this.getString(0x7F130974)}, new int[]{0x7F0A08CD, 0x7F0A08CB});  // string:setting_current_song_old_list_keep "재생목록 유지"
    }

    public final void setPlaybackManager(@NotNull q q0) {
        kotlin.jvm.internal.q.g(q0, "<set-?>");
        this.playbackManager = q0;
    }

    public final void setPlaylistManager(@NotNull s2 s20) {
        kotlin.jvm.internal.q.g(s20, "<set-?>");
        this.playlistManager = s20;
    }

    private final void updateScheduleStopView(int v) {
        Log.d("SettingAddPositionFragment", "updateScheduleStopView() state: " + F.a0(v));
        if(this.isAdded()) {
            View view0 = this.findViewById(0x7F0A05C9);  // id:item_scheduled_stop
            SettingItemView settingItemView0 = view0 instanceof SettingItemView ? ((SettingItemView)view0) : null;
            if(settingItemView0 != null) {
                settingItemView0.setSubTextOnOff(this.isStopTimerRunning());
            }
        }
    }
}

