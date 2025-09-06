package com.iloen.melon.utils.datastore;

import df.v;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import q2.f;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001R\u001D\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007R\u001D\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001A\u0004\b\n\u0010\u0007R\u001D\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001A\u0004\b\r\u0010\u0007¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/utils/datastore/VoiceAlarmPreferenceKeys;", "", "Lq2/f;", "", "a", "Lq2/f;", "getDO_NOT_SHOW_VOICE_ALARM_SAVE_POPUP", "()Lq2/f;", "DO_NOT_SHOW_VOICE_ALARM_SAVE_POPUP", "b", "getDO_NOT_SHOW_VOICE_TRACK_LIST_INFO_POPUP", "DO_NOT_SHOW_VOICE_TRACK_LIST_INFO_POPUP", "c", "getIS_SHOWN_ONBOARDING_VOICE_ALARM", "IS_SHOWN_ONBOARDING_VOICE_ALARM", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VoiceAlarmPreferenceKeys {
    public static final int $stable;
    @NotNull
    public static final VoiceAlarmPreferenceKeys INSTANCE;
    public static final f a;
    public static final f b;
    public static final f c;

    static {
        VoiceAlarmPreferenceKeys.INSTANCE = new VoiceAlarmPreferenceKeys();  // 初始化器: Ljava/lang/Object;-><init>()V
        VoiceAlarmPreferenceKeys.a = v.n("do_not_show_voice_alarm_save_popup");
        VoiceAlarmPreferenceKeys.b = v.n("do_not_show_voice_track_list_info_popup");
        VoiceAlarmPreferenceKeys.c = v.n("is_shown_onboarding_voice_alarm");
        VoiceAlarmPreferenceKeys.$stable = 8;
    }

    @NotNull
    public final f getDO_NOT_SHOW_VOICE_ALARM_SAVE_POPUP() {
        return VoiceAlarmPreferenceKeys.a;
    }

    @NotNull
    public final f getDO_NOT_SHOW_VOICE_TRACK_LIST_INFO_POPUP() {
        return VoiceAlarmPreferenceKeys.b;
    }

    @NotNull
    public final f getIS_SHOWN_ONBOARDING_VOICE_ALARM() {
        return VoiceAlarmPreferenceKeys.c;
    }
}

