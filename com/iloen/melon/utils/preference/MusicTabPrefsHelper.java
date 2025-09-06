package com.iloen.melon.utils.preference;

import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import com.iloen.melon.player.playlist.common.h;
import com.melon.net.res.RedDotInfo;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001B\u0010\n\u001A\u00020\u00042\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000BJ)\u0010\u000E\u001A\u001E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\fj\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002`\r¢\u0006\u0004\b\u000E\u0010\u000FJ\u001D\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0015\u001A\u001E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\fj\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0014`\r¢\u0006\u0004\b\u0015\u0010\u000FJ\u0015\u0010\u0016\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0018\u001A\u001E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\fj\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0014`\r¢\u0006\u0004\b\u0018\u0010\u000FJ\u0015\u0010\u0019\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\b¢\u0006\u0004\b\u0019\u0010\u0017J)\u0010\u001A\u001A\u001E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\fj\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0014`\r¢\u0006\u0004\b\u001A\u0010\u000F¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/utils/preference/MusicTabPrefsHelper;", "", "Lcom/melon/net/res/RedDotInfo;", "redDot", "Lie/H;", "putCommerceRedDot", "(Lcom/melon/net/res/RedDotInfo;)V", "", "", "ids", "removeCommerceRedDot", "(Ljava/util/List;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getCommerceRedDot", "()Ljava/util/HashMap;", "id", "dpType", "putBottomSlideBanner", "(Ljava/lang/String;Ljava/lang/String;)V", "", "getBottomSlideBanner", "putTopNotification", "(Ljava/lang/String;)V", "getTopNotification", "putTopNotificationBadge", "getTopNotificationBadge", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicTabPrefsHelper {
    public static final int $stable;
    @NotNull
    public static final MusicTabPrefsHelper INSTANCE;

    static {
        MusicTabPrefsHelper.INSTANCE = new MusicTabPrefsHelper();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @NotNull
    public final HashMap getBottomSlideBanner() {
        try {
            Object object0 = new n().f(MelonPrefs.getInstance().getString("MUSIC_BOTTOM_SLIDE_BANNER", "[]"), new com.iloen.melon.utils.preference.MusicTabPrefsHelper.getBottomSlideBanner.1().getType());
            q.d(object0);
            return (HashMap)object0;
        }
        catch(Exception unused_ex) {
            return new HashMap();
        }

        @Metadata(d1 = {"\u0000\u001B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/iloen/melon/utils/preference/MusicTabPrefsHelper$getBottomSlideBanner$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.utils.preference.MusicTabPrefsHelper.getBottomSlideBanner.1 extends TypeToken {
        }

    }

    @NotNull
    public final HashMap getCommerceRedDot() {
        try {
            Object object0 = new n().f(MelonPrefs.getInstance().getString("COMMERCE_RED_DOT", "[]"), new com.iloen.melon.utils.preference.MusicTabPrefsHelper.getCommerceRedDot.1().getType());
            q.d(object0);
            return (HashMap)object0;
        }
        catch(Exception unused_ex) {
            return new HashMap();
        }

        @Metadata(d1 = {"\u0000\u001B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/iloen/melon/utils/preference/MusicTabPrefsHelper$getCommerceRedDot$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "Lcom/melon/net/res/RedDotInfo;", "Lkotlin/collections/HashMap;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.utils.preference.MusicTabPrefsHelper.getCommerceRedDot.1 extends TypeToken {
        }

    }

    @NotNull
    public final HashMap getTopNotification() {
        try {
            HashMap hashMap0 = (HashMap)new n().f(MelonPrefs.getInstance().getString("MUSIC_TOP_NOTIFICATION", "{}"), new com.iloen.melon.utils.preference.MusicTabPrefsHelper.getTopNotification.1().getType());
            return hashMap0 == null ? new HashMap() : hashMap0;
        }
        catch(Exception unused_ex) {
            return new HashMap();
        }

        @Metadata(d1 = {"\u0000\u001B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/iloen/melon/utils/preference/MusicTabPrefsHelper$getTopNotification$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.utils.preference.MusicTabPrefsHelper.getTopNotification.1 extends TypeToken {
        }

    }

    @NotNull
    public final HashMap getTopNotificationBadge() {
        try {
            Object object0 = new n().f(MelonPrefs.getInstance().getString("MUSIC_TOP_NOTIFICATION_BADGE", "[]"), new com.iloen.melon.utils.preference.MusicTabPrefsHelper.getTopNotificationBadge.1().getType());
            q.d(object0);
            return (HashMap)object0;
        }
        catch(Exception unused_ex) {
            return new HashMap();
        }

        @Metadata(d1 = {"\u0000\u001B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/iloen/melon/utils/preference/MusicTabPrefsHelper$getTopNotificationBadge$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.utils.preference.MusicTabPrefsHelper.getTopNotificationBadge.1 extends TypeToken {
        }

    }

    public final void putBottomSlideBanner(@NotNull String s, @NotNull String s1) {
        int v;
        q.g(s, "id");
        q.g(s1, "dpType");
        HashMap hashMap0 = this.getBottomSlideBanner();
        hashMap0.entrySet().removeIf(new a(2, new h(26)));
        Calendar calendar0 = Calendar.getInstance();
        calendar0.set(11, 0);
        calendar0.set(12, 0);
        calendar0.set(13, 0);
        calendar0.set(14, 0);
        try {
            v = 1;
            v = Integer.parseInt(s1);
        }
        catch(NumberFormatException unused_ex) {
        }
        calendar0.add(5, v);
        hashMap0.put(s, calendar0.getTimeInMillis());
        MelonPrefs.getInstance().setString("MUSIC_BOTTOM_SLIDE_BANNER", new n().k(hashMap0));
    }

    // 去混淆评级： 低(45)
    public final void putCommerceRedDot(@NotNull RedDotInfo redDotInfo0) {
        q.g(redDotInfo0, "redDot");
    }

    public final void putTopNotification(@NotNull String s) {
        q.g(s, "id");
        HashMap hashMap0 = this.getTopNotification();
        if(hashMap0 != null) {
            Set set0 = hashMap0.entrySet();
            if(set0 != null) {
                set0.removeIf(new a(1, new h(25)));
            }
        }
        if(hashMap0 != null) {
            hashMap0.put(s, System.currentTimeMillis());
        }
        MelonPrefs.getInstance().setString("MUSIC_TOP_NOTIFICATION", new n().k(hashMap0));
    }

    public final void putTopNotificationBadge(@NotNull String s) {
        q.g(s, "id");
        HashMap hashMap0 = this.getTopNotificationBadge();
        hashMap0.entrySet().removeIf(new a(0, new h(24)));
        hashMap0.put(s, System.currentTimeMillis());
        MelonPrefs.getInstance().setString("MUSIC_TOP_NOTIFICATION_BADGE", new n().k(hashMap0));
    }

    public final void removeCommerceRedDot(@NotNull List list0) {
        q.g(list0, "ids");
        HashMap hashMap0 = this.getCommerceRedDot();
        for(Object object0: list0) {
            hashMap0.remove(((String)object0));
        }
        MelonPrefs.getInstance().setString("COMMERCE_RED_DOT", new n().k(hashMap0));
    }
}

