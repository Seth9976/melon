package com.iloen.melon.utils.ui;

import androidx.appcompat.app.D;
import androidx.appcompat.app.n;
import androidx.collection.b;
import com.iloen.melon.utils.preference.MelonPrefs;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\bJ\u000F\u0010\n\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000E\u0010\rR\u0014\u0010\u000F\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000F\u0010\rR\u0014\u0010\u0010\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/utils/ui/MelonThemeUtils;", "", "Lie/H;", "initTheme", "()V", "", "theme", "setTheme", "(I)V", "saveTheme", "getCurrentTheme", "()I", "THEME_WHITE", "I", "THEME_BLACK", "THEME_FOLLOW_SYSTEM", "THEME_DEFAULT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonThemeUtils {
    public static final int $stable = 0;
    @NotNull
    public static final MelonThemeUtils INSTANCE = null;
    public static final int THEME_BLACK = 1;
    public static final int THEME_DEFAULT = 1;
    public static final int THEME_FOLLOW_SYSTEM = 2;
    public static final int THEME_WHITE;

    static {
        MelonThemeUtils.INSTANCE = new MelonThemeUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static final int getCurrentTheme() {
        return MelonPrefs.getInstance().getInt("MELON_IN_APP_THEME", 1);
    }

    public static final void initTheme() {
        MelonThemeUtils.setTheme(MelonThemeUtils.getCurrentTheme());
    }

    public static final void saveTheme(int v) {
        MelonPrefs.getInstance().setInt("MELON_IN_APP_THEME", v);
    }

    public static final void setTheme(int v) {
        int v1;
        switch(v) {
            case 0: {
                v1 = 1;
                break;
            }
            case 2: {
                v1 = -1;
                break;
            }
            default: {
                v1 = 2;
            }
        }
        if(n.b != v1) {
            n.b = v1;
            synchronized(n.h) {
                n.g.getClass();
                b b0 = new b(n.g);
                while(b0.hasNext()) {
                    n n0 = (n)((WeakReference)b0.next()).get();
                    if(n0 != null) {
                        ((D)n0).o(true, true);
                    }
                }
            }
        }
    }
}

