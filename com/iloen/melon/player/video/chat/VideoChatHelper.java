package com.iloen.melon.player.video.chat;

import A7.d;
import Tf.o;
import Tf.v;
import U4.x;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import com.iloen.melon.utils.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001JU\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u00062\b\b\u0002\u0010\n\u001A\u00020\u00062\b\b\u0002\u0010\u000B\u001A\u00020\u00042\b\b\u0002\u0010\f\u001A\u00020\u0004¢\u0006\u0004\b\u000E\u0010\u000FJ\u0019\u0010\u0012\u001A\u00020\u0004*\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001D\u0010\u0017\u001A\u00020\u00162\u000E\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/player/video/chat/VideoChatHelper;", "", "Landroid/content/Context;", "context", "", "isFullMode", "", "name", "degreeStr", "content", "time", "isArtist", "isMyMessage", "Landroid/text/SpannableStringBuilder;", "getChatMessageSpan", "(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Landroid/text/SpannableStringBuilder;", "", "Lcom/kakaoent/leonchat/data/messages/MessageEntity;", "isOverLimit", "(Ljava/util/List;)Z", "", "list", "", "handleOverMessageCount", "(Ljava/util/List;)I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoChatHelper {
    public static final int $stable;
    @NotNull
    public static final VideoChatHelper INSTANCE;

    static {
        VideoChatHelper.INSTANCE = new VideoChatHelper();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @NotNull
    public final SpannableStringBuilder getChatMessageSpan(@NotNull Context context0, boolean z, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, boolean z1, boolean z2) {
        int v4;
        String s6;
        q.g(context0, "context");
        q.g(s, "name");
        q.g(s1, "degreeStr");
        q.g(s2, "content");
        q.g(s3, "time");
        Integer integer0 = v.t0(s1);
        int v = integer0 == null ? 0 : ((int)integer0);
        String s4 = "";
        String s5 = v <= 80 ? " " + v + "°" : "";
        if(z1) {
            s6 = x.m(d.o("ARTIST ", s, s5, " ", s2), " ", s3);
            s4 = "ARTIST";
        }
        else {
            StringBuilder stringBuilder0 = a.o(s, s5, " ", s2, " ");
            stringBuilder0.append(s3);
            s6 = stringBuilder0.toString();
        }
        SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder(s6);
        if(z1) {
            int v1 = o.F0(spannableStringBuilder0, s4, 0, false, 6);
            spannableStringBuilder0.setSpan(new TextAppearanceSpan(context0, (z ? 0x7F140131 : 0x7F140132)), v1, s4.length() + v1, 33);  // style:ChatArtistFullAppearance
        }
        int v2 = o.F0(spannableStringBuilder0, s, 0, false, 6);
        int v3 = s.length();
        if(!z2) {
            v4 = z ? 0x7F140139 : 0x7F14013A;  // style:ChatUserNameFullAppearance
        }
        else if(z) {
            v4 = 0x7F140135;  // style:ChatMyNameFullAppearance
        }
        else {
            v4 = 0x7F140136;  // style:ChatMyNameNormalAppearance
        }
        spannableStringBuilder0.setSpan(new TextAppearanceSpan(context0, v4), v2, v3 + v2, 33);
        if(v > 80) {
            int v5 = o.F0(spannableStringBuilder0, s5, 0, false, 6);
            spannableStringBuilder0.setSpan(new TextAppearanceSpan(context0, (v <= 90 ? 0x7F140133 : 0x7F140134)), v5, s5.length() + v5, 33);  // style:ChatDegreePurpleAppearance
        }
        int v6 = o.K0(spannableStringBuilder0, s3, 0, 6);
        spannableStringBuilder0.setSpan(new TextAppearanceSpan(context0, (z ? 0x7F140137 : 0x7F140138)), v6, s3.length() + v6, 33);  // style:ChatTimeFullAppearance
        return spannableStringBuilder0;
    }

    public static SpannableStringBuilder getChatMessageSpan$default(VideoChatHelper videoChatHelper0, Context context0, boolean z, String s, String s1, String s2, String s3, boolean z1, boolean z2, int v, Object object0) {
        if((v & 8) != 0) {
            s1 = "";
        }
        if((v & 0x20) != 0) {
            s3 = "";
        }
        if((v & 0x40) != 0) {
            z1 = false;
        }
        if((v & 0x80) != 0) {
            z2 = false;
        }
        return videoChatHelper0.getChatMessageSpan(context0, z, s, s1, s2, s3, z1, z2);
    }

    public final int handleOverMessageCount(@Nullable List list0) {
        if(list0 == null) {
            return 0;
        }
        if(this.isOverLimit(list0)) {
            int v = list0.size();
            list0.subList(0, v / 2).clear();
            return v / 2;
        }
        return 0;
    }

    public final boolean isOverLimit(@Nullable List list0) {
        return list0 == null ? false : list0.size() - 10000 > 0;
    }
}

