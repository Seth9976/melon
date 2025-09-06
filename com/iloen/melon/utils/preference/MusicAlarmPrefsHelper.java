package com.iloen.melon.utils.preference;

import Ba.I;
import Cb.j;
import E9.w;
import Ma.l;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.text.TextUtils;
import com.google.gson.n;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.alarm.AlarmReceiver;
import com.iloen.melon.alarm.MusicAlarmStaticForm;
import com.iloen.melon.alarm.SongStaticForm;
import com.iloen.melon.alarm.VoiceTrackStaticForm;
import com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper.Companion;
import com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import com.melon.data.service.AlarmListRequest;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import com.melon.net.res.VoiceAlarm.Track;
import e1.b;
import ie.H;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import je.p;
import k8.Y;
import k8.o;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import o8.c;
import o8.d;
import o8.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tg.U;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001B\u0010\t\u001A\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u0004\u0018\u00010\u00022\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000EJ\u0013\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u0015\u0010\u0014\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001A\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001A\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/utils/preference/MusicAlarmPrefsHelper;", "", "Lo8/d;", "alarm", "Lie/H;", "addAlarm", "(Lo8/d;)V", "", "removeAlarmList", "removeAlarm", "(Ljava/util/List;)V", "", "id", "getAlarm", "(I)Lo8/d;", "getAlarmList", "()Ljava/util/List;", "updateAlarm", "Landroid/content/Context;", "context", "migrationSingleToMultiple", "(Landroid/content/Context;)V", "", "isSendMusicAlarmListLog", "()Z", "sendMusicAlarmListLog", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicAlarmPrefsHelper {
    public static final int $stable;
    @NotNull
    public static final MusicAlarmPrefsHelper INSTANCE;

    static {
        MusicAlarmPrefsHelper.INSTANCE = new MusicAlarmPrefsHelper();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static HashMap a() {
        try {
            Object object0 = new n().f(MelonPrefs.getInstance().getString("MUSIC_ALARM_LIST", "[]"), new MusicAlarmPrefsHelper.getAlarmMap.1().getType());
            q.d(object0);
            return (HashMap)object0;
        }
        catch(Exception unused_ex) {
            return new HashMap();
        }
    }

    public final void addAlarm(@NotNull d d0) {
        q.g(d0, "alarm");
        HashMap hashMap0 = MusicAlarmPrefsHelper.a();
        hashMap0.put(d0.a, d0);
        MelonPrefs.getInstance().setString("MUSIC_ALARM_LIST", new n().k(hashMap0));
    }

    @Nullable
    public final d getAlarm(int v) {
        return (d)MusicAlarmPrefsHelper.a().get(v);
    }

    @NotNull
    public final List getAlarmList() {
        HashMap hashMap0 = MusicAlarmPrefsHelper.a();
        ArrayList arrayList0 = new ArrayList(hashMap0.size());
        for(Object object0: hashMap0.entrySet()) {
            arrayList0.add(((d)((Map.Entry)object0).getValue()));
        }
        return p.J0(p.J0(arrayList0, new com.iloen.melon.utils.preference.MusicAlarmPrefsHelper.getAlarmList..inlined.sortedByDescending.1()), new com.iloen.melon.utils.preference.MusicAlarmPrefsHelper.getAlarmList..inlined.sortedBy.1());

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.utils.preference.MusicAlarmPrefsHelper.getAlarmList..inlined.sortedBy.1 implements Comparator {
            @Override
            public final int compare(Object object0, Object object1) {
                return b.r(((int)(((d)object0).b * 100 + ((d)object0).c)), ((int)(((d)object1).b * 100 + ((d)object1).c)));
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.utils.preference.MusicAlarmPrefsHelper.getAlarmList..inlined.sortedByDescending.1 implements Comparator {
            @Override
            public final int compare(Object object0, Object object1) {
                return b.r(e.g(((d)object1)), e.g(((d)object0)));
            }
        }

    }

    public final boolean isSendMusicAlarmListLog() {
        return MelonPrefs.getInstance().getLong("KEY_MUSIC_ALARM_LAST_SEND_DATE", -1L) > 0L;
    }

    public final void migrationSingleToMultiple(@NotNull Context context0) {
        PendingIntent pendingIntent0;
        q.g(context0, "context");
        if(MelonSettingInfo.getAutoPlayTime() != 0L && MelonSettingInfo.isUseAutoPlay() && Companion.canScheduleExactAlarms$default(AlarmPermissionHelper.Companion, context0, null, null, 6, null)) {
            Calendar calendar0 = Calendar.getInstance();
            calendar0.setTimeInMillis(MelonSettingInfo.getAutoPlayTime());
            d d0 = new d(0, 0, 0, 0, null, 0x1FFF);
            d0.a = MusicAlarmPrefsHelper.INSTANCE.getAlarmList().size() + 1;
            d0.b = calendar0.get(11);
            d0.c = calendar0.get(12);
            d0.e = MelonSettingInfo.isUseAutoPlay();
            d0.d = MelonSettingInfo.getAutoPlayVolume();
            boolean[] arr_z = MelonSettingInfo.getAutoPlayWeekSetting();
            q.f(arr_z, "getAutoPlayWeekSetting(...)");
            d0.f = arr_z;
            Context context1 = Y.a(MelonAppBase.Companion);
            for(int v = 0; v < 7; ++v) {
                if(context1 == null || TextUtils.isEmpty(("com.iloen.melon.intent.action.AUTO_PLAY_TIMER" + v))) {
                    LogU.Companion.w("AlarmTrigger", "getPendingBroadcastIntent() invalid parameter.");
                    pendingIntent0 = null;
                }
                else {
                    Intent intent0 = new Intent(context1, AlarmReceiver.class);
                    intent0.setAction("com.iloen.melon.intent.action.AUTO_PLAY_TIMER" + v);
                    pendingIntent0 = PendingIntent.getBroadcast(context1, 0, intent0, 0x1C000000);
                    q.f(pendingIntent0, "getBroadcast(...)");
                }
                c.a(context1, pendingIntent0);
            }
            this.addAlarm(d0);
            if(calendar0.getTimeInMillis() > System.currentTimeMillis()) {
                c.f(e.d(d0), d0.a, false);
            }
            MelonPrefs melonPrefs0 = MelonPrefs.getInstance();
            melonPrefs0.removeAndCommit("AutoPlayTime");
            melonPrefs0.removeAndCommit("AutoPlayVolume");
            melonPrefs0.removeAndCommit("AutoPlayCheckValue");
            melonPrefs0.removeAndCommit("AutoPlayPlayWeekRepeatState");
            melonPrefs0.removeAndCommit("FirstAutoPlayPlayTime");
            melonPrefs0.removeAndCommit("UseAutoPlayState");
            melonPrefs0.removeAndCommit("AutoPlayPlayAllWeekRepeat");
        }
    }

    public final void removeAlarm(@NotNull List list0) {
        q.g(list0, "removeAlarmList");
        HashMap hashMap0 = MusicAlarmPrefsHelper.a();
        for(Object object0: list0) {
            hashMap0.remove(((d)object0).a);
        }
        MelonPrefs.getInstance().setString("MUSIC_ALARM_LIST", new n().k(hashMap0));
    }

    public final void sendMusicAlarmListLog() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new we.n(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
            public int r;

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.utils.preference.MusicAlarmPrefsHelper.sendMusicAlarmListLog.1(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.utils.preference.MusicAlarmPrefsHelper.sendMusicAlarmListLog.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                H h0 = H.a;
                switch(this.r) {
                    case 0: {
                        ArrayList arrayList0 = H0.b.m(object0);
                        for(Object object1: MusicAlarmPrefsHelper.INSTANCE.getAlarmList()) {
                            d d0 = (d)object1;
                            q.g(d0, "<this>");
                            int v = d0.a;
                            int v1 = d0.b;
                            int v2 = d0.c;
                            boolean[] arr_z = d0.f;
                            boolean z = d0.h;
                            int v3 = d0.i;
                            int v4 = d0.d;
                            boolean z1 = d0.e;
                            SongStaticForm songStaticForm0 = new SongStaticForm(d0.g, d0.j, d0.k, d0.l);
                            String s = null;
                            String s1 = d0.m == null ? null : d0.m.getTrackId();
                            String s2 = d0.m == null ? null : d0.m.getTrackName();
                            String s3 = d0.m == null ? null : d0.m.getArtistId();
                            String s4 = d0.m == null ? null : d0.m.getArtistName();
                            String s5 = d0.m == null ? null : d0.m.getAlbumId();
                            String s6 = d0.m == null ? null : d0.m.getAlbumName();
                            String s7 = d0.m == null ? null : d0.m.getAlbumImage();
                            String s8 = d0.m == null ? null : d0.m.getStartDate();
                            String s9 = d0.m == null ? null : d0.m.getEndDate();
                            Track voiceAlarm$Track0 = d0.m;
                            if(voiceAlarm$Track0 != null) {
                                s = voiceAlarm$Track0.getPlayTime();
                            }
                            arrayList0.add(new MusicAlarmStaticForm(v, v1, v2, v4, z1, arr_z, z, v3, songStaticForm0, new VoiceTrackStaticForm(s1, s2, s3, s4, s5, s6, s7, s8, s9, s)));
                        }
                        if(arrayList0.isEmpty()) {
                            return h0;
                        }
                        AlarmListRequest alarmListRequest0 = new AlarmListRequest(null, null, null, null, arrayList0, 15, null);
                        try {
                            MelonAppBase.Companion.getClass();
                            U u0 = (U)((o)(((l)w.s(t.a().getContext(), l.class)))).e.get();
                            q.g(u0, "retrofit");
                            Object object2 = u0.b(I.class);
                            q.f(object2, "create(...)");
                            this.r = 1;
                            Object object3 = ((I)object2).a(alarmListRequest0, this);
                            if(object3 == a0) {
                                return a0;
                            label_46:
                                d5.n.D(object0);
                                object3 = object0;
                            }
                            HttpResponse httpResponse0 = (HttpResponse)ApiResultKt.getOrThrow(((ApiResult)object3));
                            MelonPrefs.getInstance().setLong("KEY_MUSIC_ALARM_LAST_SEND_DATE", new Date().getTime());
                            boolean z2 = j.d(httpResponse0);
                            LogU.Companion.d("MusicAlarmPrefsHelper", "sendMusicAlarmListLog() isSucess: " + z2);
                            return h0;
                        }
                        catch(Exception exception0) {
                            break;
                        }
                    }
                    case 1: {
                        goto label_46;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                LogU.Companion.e("MusicAlarmPrefsHelper", "requestSettingAlarmLog() FAILED", exception0);
                return h0;
            }
        }, 3, null);
    }

    public final void updateAlarm(@NotNull d d0) {
        q.g(d0, "alarm");
        HashMap hashMap0 = MusicAlarmPrefsHelper.a();
        hashMap0.put(d0.a, d0);
        MelonPrefs.getInstance().setString("MUSIC_ALARM_LIST", new n().k(hashMap0));
    }
}

