package o8;

import android.content.Context;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.alarm.MusicAlarmParcelable;
import com.melon.net.res.VoiceAlarm.Track;
import e.k;
import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import je.o;
import k8.Y;
import kotlin.jvm.internal.q;

public abstract class e {
    public static final String a(d d0) {
        MelonAppBase.Companion.getClass();
        String s = e.c(d0) + " " + e.b(d0) + " " + e.f(d0) + "\n" + "알람이 울렸습니다.";
        q.f(s, "toString(...)");
        return s;
    }

    public static final String b(d d0) {
        q.g(d0, "<this>");
        String s = Y.a(MelonAppBase.Companion).getString((12 > d0.b || d0.b >= 24 ? 0x7F1308AE : 0x7F1308AF));  // string:protocol_utils_am "오전"
        q.f(s, "getString(...)");
        return s;
    }

    public static final String c(d d0) {
        int v2;
        StringBuilder stringBuilder0 = new StringBuilder();
        boolean[] arr_z = d0.f;
        q.g(arr_z, "<this>");
        int v;
        for(v = 0; true; ++v) {
            if(v >= arr_z.length) {
                v = -1;
                break;
            }
            if(!arr_z[v]) {
                break;
            }
        }
        if(v >= 0) {
            if(!d0.h) {
                MelonAppBase.Companion.getClass();
                stringBuilder0.append("매주");
                stringBuilder0.append(" ");
            }
            boolean[] arr_z1 = d0.f;
            q.g(arr_z1, "<this>");
            int v1 = 0;
            for(Object object0: new o(arr_z1, 1)) {
                if(v1 >= 0) {
                    if(((Boolean)object0).booleanValue()) {
                        Context context0 = Y.a(MelonAppBase.Companion);
                        switch(v1) {
                            case 0: {
                                v2 = 0x7F1309D6;  // string:setting_timer_alarm_sunday "일"
                                break;
                            }
                            case 1: {
                                v2 = 0x7F1309D4;  // string:setting_timer_alarm_monday "월"
                                break;
                            }
                            case 2: {
                                v2 = 0x7F1309D8;  // string:setting_timer_alarm_tuesday "화"
                                break;
                            }
                            case 3: {
                                v2 = 0x7F1309D9;  // string:setting_timer_alarm_wednesday "수"
                                break;
                            }
                            case 4: {
                                v2 = 0x7F1309D7;  // string:setting_timer_alarm_thursday "목"
                                break;
                            }
                            case 5: {
                                v2 = 0x7F1309D3;  // string:setting_timer_alarm_friday "금"
                                break;
                            }
                            default: {
                                v2 = 0x7F1309D5;  // string:setting_timer_alarm_saturday "토"
                            }
                        }
                        stringBuilder0.append(context0.getString(v2));
                        stringBuilder0.append(", ");
                    }
                    if(v1 == 6) {
                        q.f(stringBuilder0.delete(stringBuilder0.length() - 2, stringBuilder0.length()), "delete(...)");
                        boolean[] arr_z2 = d0.f;
                        int v4 = 0;
                        for(int v3 = 0; v3 < arr_z2.length; ++v3) {
                            if(arr_z2[v3]) {
                                ++v4;
                            }
                        }
                        if(v4 == 1) {
                            MelonAppBase.Companion.getClass();
                            stringBuilder0.append("요일");
                        }
                    }
                    ++v1;
                    continue;
                }
                k.O();
                throw null;
            }
        }
        else {
            MelonAppBase.Companion.getClass();
            stringBuilder0.append("매일");
        }
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    public static final long d(d d0) {
        int v1;
        q.g(d0, "<this>");
        Calendar calendar0 = Calendar.getInstance();
        calendar0.set(11, d0.b);
        calendar0.set(12, d0.c);
        calendar0.set(13, 0);
        calendar0.set(14, 0);
        int v = 1;
        if(Long.compare(calendar0.getTimeInMillis(), System.currentTimeMillis()) >= 0) {
            boolean[] arr_z = d0.f;
            if(!arr_z[calendar0.get(7) - 1]) {
                v1 = calendar0.get(7);
                goto label_13;
            }
        }
        else {
            v1 = calendar0.get(7);
            do {
            label_13:
                int v2 = v1 - 1 + v;
                if(d0.f[(v2 <= 6 ? v1 - 1 + v : v2 - 7)]) {
                    break;
                }
                ++v;
            }
            while(v <= 6);
            calendar0.add(5, v);
        }
        return calendar0.getTimeInMillis();
    }

    public static final String e(Track voiceAlarm$Track0) {
        q.g(voiceAlarm$Track0, "<this>");
        ZoneId zoneId0 = ZoneId.of("Asia/Seoul");
        ZonedDateTime zonedDateTime0 = ZonedDateTime.of(LocalDate.parse(voiceAlarm$Track0.getEndDate(), DateTimeFormatter.ofPattern("yyyy.MM.dd")).atStartOfDay(), zoneId0);
        long v = Duration.between(ZonedDateTime.of(LocalDate.now(zoneId0).atStartOfDay(), zoneId0), zonedDateTime0).toDays();
        int v1 = Long.compare(v, 0L);
        if(v1 > 0) {
            String s = Y.a(MelonAppBase.Companion).getString(0x7F130944, new Object[]{v});  // string:setting_alarm_voice_remain_day "상품 만료 %d 일 전"
            q.f(s, "getString(...)");
            return s;
        }
        return v1 == 0 ? Z.m(MelonAppBase.Companion, 0x7F130945, "getString(...)") : Z.m(MelonAppBase.Companion, 0x7F130942, "getString(...)");  // string:setting_alarm_voice_remain_today "오늘은 상품 만료일입니다."
    }

    public static final String f(d d0) {
        StringBuilder stringBuilder0 = new StringBuilder();
        int v = d0.b;
        if(v > 12) {
            v -= 12;
        }
        else if(v == 0) {
            v = 12;
        }
        stringBuilder0.append(v);
        stringBuilder0.append(":");
        if(d0.c < 10) {
            stringBuilder0.append(BigInteger.ZERO);
        }
        stringBuilder0.append(d0.c);
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    public static final int g(d d0) {
        q.g(d0, "<this>");
        boolean[] arr_z = d0.f;
        int v = 0;
        int v1 = 0;
        for(int v2 = 0; v < arr_z.length; ++v2) {
            boolean z = arr_z[v];
            switch(v2) {
                case 0: {
                    if(z) {
                        ++v1;
                    }
                    break;
                }
                case 1: {
                    if(z) {
                        v1 += 1000000;
                    }
                    break;
                }
                case 2: {
                    if(z) {
                        v1 += 100000;
                    }
                    break;
                }
                case 3: {
                    if(z) {
                        v1 += 10000;
                    }
                    break;
                }
                case 4: {
                    if(z) {
                        v1 += 1000;
                    }
                    break;
                }
                case 5: {
                    if(z) {
                        v1 += 100;
                    }
                    break;
                }
                case 6: {
                    if(z) {
                        v1 += 10;
                    }
                }
            }
            ++v;
        }
        return v1;
    }

    public static final d h(MusicAlarmParcelable musicAlarmParcelable0) {
        return new d(musicAlarmParcelable0.a, musicAlarmParcelable0.b, musicAlarmParcelable0.c, musicAlarmParcelable0.d, musicAlarmParcelable0.e, musicAlarmParcelable0.f, musicAlarmParcelable0.g, musicAlarmParcelable0.h, musicAlarmParcelable0.i, musicAlarmParcelable0.j, musicAlarmParcelable0.k, musicAlarmParcelable0.l, musicAlarmParcelable0.m);
    }
}

