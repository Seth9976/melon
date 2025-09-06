package com.iloen.melon.fragments.settings.alarm;

import Ab.d;
import Cb.j;
import Na.f;
import P0.r;
import android.app.Application;
import android.content.Context;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import androidx.lifecycle.a;
import androidx.lifecycle.f0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.utils.datastore.VoiceAlarmDataStoreKt;
import com.iloen.melon.utils.datastore.VoiceAlarmPreferenceKeys;
import com.iloen.melon.utils.preference.MusicAlarmPrefsHelper;
import com.melon.net.res.VoiceAlarm.Track;
import com.melon.net.res.VoiceAlarm.TrackDto;
import com.melon.net.res.VoiceAlarmAlbumTracksRes.Response;
import com.melon.net.res.VoiceAlarmAlbumTracksRes;
import d5.n;
import e.k;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import o8.e;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.p;
import q2.b;
import q2.h;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\u0011\u00A2\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001A\u00020\n\u00A2\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001A\u00020\n\u00A2\u0006\u0004\b\u0017\u0010\u0016J\u0015\u0010\u0019\u001A\u00020\u00182\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0015\u0010\u001B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\u001B\u0010\fJ\u0015\u0010\u001D\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\u0018\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\r\u0010\u001C\u001A\u00020\u0018\u00A2\u0006\u0004\b\u001C\u0010\u001FJ\r\u0010 \u001A\u00020\u0018\u00A2\u0006\u0004\b \u0010\u001FJ\u0010\u0010!\u001A\u00020\nH\u0086@\u00A2\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001A\u00020\nH\u0086@\u00A2\u0006\u0004\b#\u0010\"J\u001B\u0010\'\u001A\u00020\n2\f\u0010&\u001A\b\u0012\u0004\u0012\u00020%0$\u00A2\u0006\u0004\b\'\u0010(R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010)R\u001C\u0010+\u001A\b\u0012\u0004\u0012\u00020\b0*8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b+\u0010,R\u001A\u0010-\u001A\b\u0012\u0004\u0012\u00020\b0*8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b-\u0010,R+\u00106\u001A\u00020.2\u0006\u0010/\u001A\u00020.8F@BX\u0086\u008E\u0002\u00A2\u0006\u0012\n\u0004\b0\u00101\u001A\u0004\b2\u00103\"\u0004\b4\u00105R\u001C\u00108\u001A\b\u0012\u0004\u0012\u00020\u0018078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u00101R \u0010:\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$098\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b:\u0010;R#\u0010=\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0<8\u0006\u00A2\u0006\f\n\u0004\b=\u0010>\u001A\u0004\b?\u0010@R\u0011\u0010B\u001A\u00020\u00188F\u00A2\u0006\u0006\u001A\u0004\bA\u0010\u001F\u00A8\u0006C"}, d2 = {"Lcom/iloen/melon/fragments/settings/alarm/SettingAlarmListViewModel;", "Landroidx/lifecycle/a;", "LAb/d;", "voiceAlarmUseCase", "Landroid/app/Application;", "application", "<init>", "(LAb/d;Landroid/app/Application;)V", "Lo8/d;", "alarm", "Lie/H;", "updateOnOffSetting", "(Lo8/d;)V", "", "trackIds", "validateVoiceAlarmTracks", "(Ljava/lang/String;)V", "", "index", "toggleSelection", "(I)V", "initialize", "()V", "deleteSelectedAlarms", "", "isCheckBoxChecked", "(Lo8/d;)Z", "updateCheckBox", "isAllSelected", "selectAllButtonClick", "(Z)V", "()Z", "isAnySelected", "updateOnboarding", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkNeedShowOnboarding", "", "Lcom/melon/net/res/VoiceAlarm$Track;", "list", "updateVoiceAlarmTrackList", "(Ljava/util/List;)V", "LAb/d;", "Lp0/p;", "selectedAlarmList", "Lp0/p;", "alarmList", "Lcom/iloen/melon/fragments/settings/alarm/ViewState;", "<set-?>", "viewState$delegate", "Landroidx/compose/runtime/b0;", "getViewState", "()Lcom/iloen/melon/fragments/settings/alarm/ViewState;", "setViewState", "(Lcom/iloen/melon/fragments/settings/alarm/ViewState;)V", "viewState", "Landroidx/compose/runtime/b0;", "_needShowOnboarding", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_trackList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "trackList", "Lkotlinx/coroutines/flow/StateFlow;", "getTrackList", "()Lkotlinx/coroutines/flow/StateFlow;", "getNeedShowOnboarding", "needShowOnboarding", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingAlarmListViewModel extends a {
    public static final int $stable = 8;
    @NotNull
    private b0 _needShowOnboarding;
    @NotNull
    private final MutableStateFlow _trackList;
    @NotNull
    private final p alarmList;
    @NotNull
    private p selectedAlarmList;
    @NotNull
    private final StateFlow trackList;
    @NotNull
    private final b0 viewState$delegate;
    @NotNull
    private final d voiceAlarmUseCase;

    @Inject
    public SettingAlarmListViewModel(@NotNull d d0, @NotNull Application application0) {
        q.g(d0, "voiceAlarmUseCase");
        q.g(application0, "application");
        super(application0);
        this.voiceAlarmUseCase = d0;
        this.selectedAlarmList = new p();
        this.alarmList = new p();
        this.viewState$delegate = w.s(Loading.INSTANCE);
        this._needShowOnboarding = w.s(Boolean.FALSE);
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(je.w.a);
        this._trackList = mutableStateFlow0;
        this.trackList = mutableStateFlow0;
    }

    @Nullable
    public final Object checkNeedShowOnboarding(@NotNull Continuation continuation0) {
        com.iloen.melon.fragments.settings.alarm.SettingAlarmListViewModel.checkNeedShowOnboarding.1 settingAlarmListViewModel$checkNeedShowOnboarding$10;
        if(continuation0 instanceof com.iloen.melon.fragments.settings.alarm.SettingAlarmListViewModel.checkNeedShowOnboarding.1) {
            settingAlarmListViewModel$checkNeedShowOnboarding$10 = (com.iloen.melon.fragments.settings.alarm.SettingAlarmListViewModel.checkNeedShowOnboarding.1)continuation0;
            int v = settingAlarmListViewModel$checkNeedShowOnboarding$10.label;
            if((v & 0x80000000) == 0) {
                settingAlarmListViewModel$checkNeedShowOnboarding$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.checkNeedShowOnboarding(this);
                    }
                };
            }
            else {
                settingAlarmListViewModel$checkNeedShowOnboarding$10.label = v ^ 0x80000000;
            }
        }
        else {
            settingAlarmListViewModel$checkNeedShowOnboarding$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.checkNeedShowOnboarding(this);
                }
            };
        }
        Object object0 = settingAlarmListViewModel$checkNeedShowOnboarding$10.result;
        ne.a a0 = ne.a.a;
        boolean z = false;
        switch(settingAlarmListViewModel$checkNeedShowOnboarding$10.label) {
            case 0: {
                n.D(object0);
                Flow flow0 = VoiceAlarmDataStoreKt.getVoiceAlarmDataStore(((MelonAppBase)this.getApplication()).getContext()).getData();
                settingAlarmListViewModel$checkNeedShowOnboarding$10.L$0 = null;
                settingAlarmListViewModel$checkNeedShowOnboarding$10.I$0 = 0;
                settingAlarmListViewModel$checkNeedShowOnboarding$10.label = 1;
                object0 = FlowKt.first(flow0, settingAlarmListViewModel$checkNeedShowOnboarding$10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                Context context0 = (Context)settingAlarmListViewModel$checkNeedShowOnboarding$10.L$0;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        b0 b00 = this._needShowOnboarding;
        Boolean boolean0 = (Boolean)((h)object0).b(VoiceAlarmPreferenceKeys.INSTANCE.getIS_SHOWN_ONBOARDING_VOICE_ALARM());
        if(boolean0 == null || !boolean0.booleanValue()) {
            z = true;
        }
        b00.setValue(Boolean.valueOf(z));
        return H.a;
    }

    public final void deleteSelectedAlarms() {
        p p0 = this.selectedAlarmList;
        q.g(p0, "musicAlarmList");
        Iterator iterator0 = p0.iterator();
        while(((r)iterator0).hasNext()) {
            o8.c.b(((o8.d)((r)iterator0).next()).a);
        }
        MusicAlarmPrefsHelper.INSTANCE.removeAlarm(this.selectedAlarmList);
        this.selectedAlarmList.clear();
        this.initialize();
        MusicAlarmPrefsHelper.INSTANCE.sendMusicAlarmListLog();
    }

    public final boolean getNeedShowOnboarding() {
        return ((Boolean)this._needShowOnboarding.getValue()).booleanValue();
    }

    @NotNull
    public final StateFlow getTrackList() {
        return this.trackList;
    }

    @NotNull
    public final ViewState getViewState() {
        return (ViewState)this.viewState$delegate.getValue();
    }

    public final void initialize() {
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new we.n(null) {
            Object L$0;
            Object L$1;
            int label;

            {
                SettingAlarmListViewModel.this = settingAlarmListViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.alarm.SettingAlarmListViewModel.initialize.1(SettingAlarmListViewModel.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.alarm.SettingAlarmListViewModel.initialize.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        SettingAlarmListViewModel.this.alarmList.clear();
                        List list0 = MusicAlarmPrefsHelper.INSTANCE.getAlarmList();
                        ArrayList arrayList0 = new ArrayList();
                        Iterator iterator0 = list0.iterator();
                        while(true) {
                            String s = null;
                            if(!iterator0.hasNext()) {
                                break;
                            }
                            Object object1 = iterator0.next();
                            Track voiceAlarm$Track0 = ((o8.d)object1).m;
                            if(voiceAlarm$Track0 != null) {
                                s = voiceAlarm$Track0.getTrackId();
                            }
                            if(s != null) {
                                arrayList0.add(s);
                            }
                        }
                        String s1 = je.p.q0(arrayList0, ",", null, null, null, 62);
                        if(s1.length() > 0) {
                            SettingAlarmListViewModel.this.validateVoiceAlarmTracks(s1);
                        }
                        SettingAlarmListViewModel.this.alarmList.addAll(list0);
                        Success viewState$Success0 = new Success(SettingAlarmListViewModel.this.alarmList);
                        SettingAlarmListViewModel.this.setViewState(viewState$Success0);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 1;
                        return SettingAlarmListViewModel.this.checkNeedShowOnboarding(this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        String s2 = (String)this.L$1;
                        List list1 = (List)this.L$0;
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }

    public final boolean isAllSelected() {
        return !this.selectedAlarmList.isEmpty() && this.selectedAlarmList.size() == this.alarmList.size();
    }

    public final boolean isAnySelected() {
        return !this.selectedAlarmList.isEmpty();
    }

    public final boolean isCheckBoxChecked(@NotNull o8.d d0) {
        q.g(d0, "alarm");
        return this.selectedAlarmList.contains(d0);
    }

    public final void selectAllButtonClick(boolean z) {
        if(z) {
            this.selectedAlarmList.clear();
            return;
        }
        this.selectedAlarmList.clear();
        this.selectedAlarmList.addAll(this.alarmList);
    }

    private final void setViewState(ViewState viewState0) {
        this.viewState$delegate.setValue(viewState0);
    }

    public final void toggleSelection(int v) {
        p p0 = this.alarmList;
        if(v >= 0 && v < p0.size()) {
            o8.d d0 = (o8.d)p0.get(v);
            o8.d d1 = o8.d.b(d0, !d0.e, null, 0x1FEF);
            this.alarmList.set(v, d1);
            this.updateOnOffSetting(((o8.d)this.alarmList.get(v)));
            this.setViewState(new Success(this.alarmList));
        }
    }

    public final void updateCheckBox(@NotNull o8.d d0) {
        q.g(d0, "alarm");
        if(this.selectedAlarmList.contains(d0)) {
            this.selectedAlarmList.remove(d0);
            return;
        }
        this.selectedAlarmList.add(d0);
    }

    private final void updateOnOffSetting(o8.d d0) {
        if(d0.e) {
            o8.c.f(e.d(d0), d0.a, true);
        }
        else {
            o8.c.b(d0.a);
        }
        MusicAlarmPrefsHelper.INSTANCE.updateAlarm(d0);
    }

    @Nullable
    public final Object updateOnboarding(@NotNull Continuation continuation0) {
        Object object0 = k.n(VoiceAlarmDataStoreKt.getVoiceAlarmDataStore(((MelonAppBase)this.getApplication()).getContext()), new we.n() {
            Object L$0;
            int label;

            {
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.fragments.settings.alarm.SettingAlarmListViewModel.updateOnboarding.2.1(continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((b)object0), ((Continuation)object1));
            }

            public final Object invoke(b b0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.alarm.SettingAlarmListViewModel.updateOnboarding.2.1)this.create(b0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                b b0 = (b)this.L$0;
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                b0.g(VoiceAlarmPreferenceKeys.INSTANCE.getIS_SHOWN_ONBOARDING_VOICE_ALARM(), Boolean.TRUE);
                return H.a;
            }
        }, continuation0);
        if(object0 == ne.a.a) {
            return object0;
        }
        h h0 = (h)object0;
        return H.a;
    }

    public final void updateVoiceAlarmTrackList(@NotNull List list0) {
        String s;
        q.g(list0, "list");
        ListIterator listIterator0 = this.alarmList.listIterator();
        while(((r)listIterator0).hasNext()) {
            o8.d d0 = (o8.d)((r)listIterator0).next();
            Iterator iterator0 = list0.iterator();
            while(true) {
                s = null;
                if(!iterator0.hasNext()) {
                    break;
                }
                Object object0 = iterator0.next();
                String s1 = ((Track)object0).getTrackId();
                Track voiceAlarm$Track0 = d0.m;
                if(voiceAlarm$Track0 != null) {
                    s = voiceAlarm$Track0.getTrackId();
                }
                if(q.b(s1, s)) {
                    s = object0;
                    break;
                }
            }
            if(((Track)s) != null) {
                int v = this.alarmList.indexOf(d0);
                o8.d d1 = o8.d.b(d0, false, ((Track)s), 0xFFF);
                this.alarmList.set(v, d1);
                o8.d d2 = (o8.d)this.alarmList.get(v);
                MusicAlarmPrefsHelper.INSTANCE.updateAlarm(d2);
            }
        }
        this.setViewState(new Success(this.alarmList));
    }

    private final void validateVoiceAlarmTracks(String s) {
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new we.n(s, null) {
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
            public static final class WhenMappings {
                public static final int[] $EnumSwitchMapping$0;

                static {
                    int[] arr_v = new int[Na.a.values().length];
                    try {
                        arr_v[0] = 1;
                    }
                    catch(NoSuchFieldError unused_ex) {
                    }
                    try {
                        arr_v[1] = 2;
                    }
                    catch(NoSuchFieldError unused_ex) {
                    }
                    WhenMappings.$EnumSwitchMapping$0 = arr_v;
                }
            }

            final String $trackIds;
            private Object L$0;
            int label;

            {
                SettingAlarmListViewModel.this = settingAlarmListViewModel0;
                this.$trackIds = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.fragments.settings.alarm.SettingAlarmListViewModel.validateVoiceAlarmTracks.1(SettingAlarmListViewModel.this, this.$trackIds, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.alarm.SettingAlarmListViewModel.validateVoiceAlarmTracks.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                ne.a a0 = ne.a.a;
                VoiceAlarmAlbumTracksRes voiceAlarmAlbumTracksRes0 = null;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new we.n(this.$trackIds, null) {
                            final String $trackIds;
                            int label;

                            {
                                SettingAlarmListViewModel.this = settingAlarmListViewModel0;
                                this.$trackIds = s;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.settings.alarm.SettingAlarmListViewModel.validateVoiceAlarmTracks.1.useCaseResult.1(SettingAlarmListViewModel.this, this.$trackIds, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.settings.alarm.SettingAlarmListViewModel.validateVoiceAlarmTracks.1.useCaseResult.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        n.D(object0);
                                        this.label = 1;
                                        Object object1 = SettingAlarmListViewModel.this.voiceAlarmUseCase.a(this.$trackIds, this);
                                        return object1 == a0 ? a0 : object1;
                                    }
                                    case 1: {
                                        n.D(object0);
                                        return object0;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        }, 3, null);
                        this.L$0 = null;
                        this.label = 1;
                        object0 = deferred0.await(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                int v = ((f)object0).getResult().ordinal();
                je.w w0 = je.w.a;
                switch(v) {
                    case 0: {
                        HttpResponse httpResponse0 = ((f)object0).b();
                        if(httpResponse0 instanceof VoiceAlarmAlbumTracksRes) {
                            voiceAlarmAlbumTracksRes0 = (VoiceAlarmAlbumTracksRes)httpResponse0;
                        }
                        if(voiceAlarmAlbumTracksRes0 != null) {
                            SettingAlarmListViewModel settingAlarmListViewModel0 = SettingAlarmListViewModel.this;
                            j.b(voiceAlarmAlbumTracksRes0.notification, false, 3);
                            if(j.d(voiceAlarmAlbumTracksRes0)) {
                                MutableStateFlow mutableStateFlow0 = settingAlarmListViewModel0._trackList;
                                Response voiceAlarmAlbumTracksRes$Response0 = voiceAlarmAlbumTracksRes0.getResponse();
                                if(voiceAlarmAlbumTracksRes$Response0 != null) {
                                    List list0 = voiceAlarmAlbumTracksRes$Response0.getTrackList();
                                    if(list0 != null) {
                                        w0 = new ArrayList(je.q.Q(10, list0));
                                        for(Object object1: list0) {
                                            ((ArrayList)w0).add(((TrackDto)object1).asDomain());
                                        }
                                    }
                                }
                                mutableStateFlow0.setValue(w0);
                                return H.a;
                            }
                            settingAlarmListViewModel0._trackList.setValue(w0);
                        }
                        return H.a;
                    }
                    case 1: {
                        SettingAlarmListViewModel.this._trackList.setValue(w0);
                        return H.a;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
        }, 2, null);
    }
}

