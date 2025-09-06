package com.melon.net.res;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0003\u001A\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, d2 = {"isValidDate", "", "Lcom/melon/net/res/VoiceAlarm$Track;", "isValidate", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class VoiceAlarmKt {
    public static final boolean isValidDate(@NotNull Track voiceAlarm$Track0) {
        q.g(voiceAlarm$Track0, "<this>");
        try {
            Calendar calendar0 = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault());
            String s = voiceAlarm$Track0.getEndDate();
            if(s == null) {
                s = "";
            }
            Date date0 = simpleDateFormat0.parse(s);
            if(date0 == null) {
                return false;
            }
            calendar0.setTime(date0);
            return Calendar.getInstance().before(calendar0);
        }
        catch(Exception unused_ex) {
            return false;
        }
    }

    public static final boolean isValidate(@NotNull Track voiceAlarm$Track0) {
        q.g(voiceAlarm$Track0, "<this>");
        return q.b(voiceAlarm$Track0.getStatus(), "0");
    }
}

