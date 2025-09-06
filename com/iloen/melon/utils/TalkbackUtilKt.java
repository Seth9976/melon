package com.iloen.melon.utils;

import A7.d;
import Tf.o;
import Tf.v;
import U4.x;
import android.content.Context;
import com.iloen.melon.custom.l1;
import com.iloen.melon.playback.Playable;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u001A\"\u0010\u0005\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u00012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0001\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u0004\u0018\u00010\b2\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u0004\u0018\u00010\t2\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u001A\u001E\u0010\n\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f\u001A\u001E\u0010\n\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0001\u001A\u0018\u0010\u0010\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001¨\u0006\u0012"}, d2 = {"getTalkbackInfo", "", "Lcom/iloen/melon/playback/Playable;", "context", "Landroid/content/Context;", "getPlayableTalkbackInfo", "songName", "artistNames", "Lcom/melon/net/res/common/AlbumInfoBase;", "Lcom/melon/net/res/common/DjPlayListInfoBase;", "getPlayProgressTalkbackInfo", "durationMs", "", "playTimeMs", "durationString", "playTimeString", "getTimeTalkbackInfo", "timeString", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class TalkbackUtilKt {
    @NotNull
    public static final String getPlayProgressTalkbackInfo(@NotNull Context context0, long v, long v1) {
        q.g(context0, "context");
        return TalkbackUtilKt.getPlayProgressTalkbackInfo(context0, StringUtils.INSTANCE.getTimeContentDescription(v), StringUtils.INSTANCE.getTimeContentDescription(v1));
    }

    @NotNull
    public static final String getPlayProgressTalkbackInfo(@NotNull Context context0, @NotNull String s, @NotNull String s1) {
        q.g(context0, "context");
        q.g(s, "durationString");
        q.g(s1, "playTimeString");
        q.f("트랙위치,", "getString(...)");
        q.f("중", "getString(...)");
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("트랙위치,");
        stringBuilder0.append(" ");
        stringBuilder0.append(s);
        String s2 = d.n(stringBuilder0, " ", "중", " ", s1);
        q.f(s2, "toString(...)");
        return s2;
    }

    @NotNull
    public static final String getPlayableTalkbackInfo(@NotNull Context context0, @Nullable String s, @Nullable String s1) {
        q.g(context0, "context");
        return s + ", " + "아티스트" + ": " + s1;
    }

    @NotNull
    public static final String getTalkbackInfo(@Nullable Playable playable0, @Nullable Context context0) {
        if(playable0 == null) {
            return "";
        }
        return context0 == null ? "" : TalkbackUtilKt.getPlayableTalkbackInfo(context0, "", "");
    }

    @NotNull
    public static final String getTalkbackInfo(@Nullable AlbumInfoBase albumInfoBase0, @Nullable Context context0) {
        if(albumInfoBase0 == null) {
            return "";
        }
        if(context0 == null) {
            return "";
        }
        String s = albumInfoBase0.albumName;
        String s1 = albumInfoBase0.getArtistNames();
        String s2 = albumInfoBase0.issueDate;
        return x.m(a.o(s, ", ", "아티스트", ": ", s1), ", ", s2);
    }

    @NotNull
    public static final String getTalkbackInfo(@Nullable DjPlayListInfoBase djPlayListInfoBase0, @Nullable Context context0) {
        if(djPlayListInfoBase0 == null) {
            return "";
        }
        return context0 == null ? "" : djPlayListInfoBase0.plylsttitle + ", " + "DJ" + ": " + djPlayListInfoBase0.ownernickname;
    }

    @NotNull
    public static final String getTimeTalkbackInfo(@NotNull Context context0, @Nullable String s) {
        String s11;
        String s10;
        String s5;
        q.g(context0, "context");
        q.f("시간", "getString(...)");
        String s1 = l1.m("분", "getString(...)", context0, 0x7F130C3B, "getString(...)");  // string:talkback_second "초"
        String s2 = "";
        if(s == null) {
            return "";
        }
        int v1 = 0;
        for(int v = 0; v < s.length(); ++v) {
            if(s.charAt(v) == 58) {
                ++v1;
            }
        }
        if(v1 == 1) {
            List list0 = o.R0(s, new String[]{":"}, 0, 6);
            String s3 = (String)list0.get(0);
            String s4 = (String)list0.get(1);
            Integer integer0 = v.t0(s3);
            if(integer0 == null) {
                s5 = "";
            }
            else {
                s5 = androidx.appcompat.app.o.i(integer0.intValue(), "분");
                if(s5 == null) {
                    s5 = "";
                }
            }
            Integer integer1 = v.t0(s4);
            if(integer1 != null) {
                String s6 = androidx.appcompat.app.o.i(integer1.intValue(), s1);
                if(s6 != null) {
                    s2 = s6;
                }
            }
            return s5 + s2;
        }
        List list1 = o.R0(s, new String[]{":"}, 0, 6);
        String s7 = (String)list1.get(0);
        String s8 = (String)list1.get(1);
        String s9 = (String)list1.get(2);
        Integer integer2 = v.t0(s7);
        if(integer2 == null) {
            s10 = "";
        }
        else {
            s10 = androidx.appcompat.app.o.i(integer2.intValue(), "시간");
            if(s10 == null) {
                s10 = "";
            }
        }
        Integer integer3 = v.t0(s8);
        if(integer3 == null) {
            s11 = "";
        }
        else {
            s11 = androidx.appcompat.app.o.i(integer3.intValue(), "분");
            if(s11 == null) {
                s11 = "";
            }
        }
        Integer integer4 = v.t0(s9);
        if(integer4 != null) {
            String s12 = androidx.appcompat.app.o.i(integer4.intValue(), s1);
            if(s12 != null) {
                s2 = s12;
            }
        }
        return s10 + s11 + s2;
    }
}

