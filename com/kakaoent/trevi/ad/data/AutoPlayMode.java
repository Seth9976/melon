package com.kakaoent.trevi.ad.data;

import android.content.Context;
import androidx.annotation.Keep;
import com.kakaoent.trevi.ad.util.NetworkManager;
import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Keep
@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/kakaoent/trevi/ad/data/AutoPlayMode;", "", "(Ljava/lang/String;I)V", "isAvailableAutoPlay", "", "context", "Landroid/content/Context;", "AUTO_PLAY", "ONLY_WIFI", "MANUAL_PLAY", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public enum AutoPlayMode {
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 0x30)
    public abstract class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[AutoPlayMode.values().length];
            try {
                arr_v[AutoPlayMode.MANUAL_PLAY.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[AutoPlayMode.AUTO_PLAY.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[AutoPlayMode.ONLY_WIFI.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    AUTO_PLAY,
    ONLY_WIFI,
    MANUAL_PLAY;

    private static final a $ENTRIES;
    private static final AutoPlayMode[] $VALUES;

    private static final AutoPlayMode[] $values() [...] // Inlined contents

    static {
        AutoPlayMode.$VALUES = arr_autoPlayMode;
        q.g(arr_autoPlayMode, "entries");
        AutoPlayMode.$ENTRIES = new b(arr_autoPlayMode);
    }

    @NotNull
    public static a getEntries() {
        return AutoPlayMode.$ENTRIES;
    }

    public final boolean isAvailableAutoPlay(@NotNull Context context0) {
        q.g(context0, "context");
        switch(WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1: {
                return false;
            }
            case 2: {
                return true;
            }
            case 3: {
                return NetworkManager.INSTANCE.isWifiConnected(context0);
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }
}

