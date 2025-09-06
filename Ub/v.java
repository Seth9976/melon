package Ub;

import R6.c;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;

public final class v implements u {
    public final LogU a;
    public final c b;

    public v() {
        this.a = Companion.create$default(LogU.Companion, "VodRepeatManager", false, Category.Playback, 2, null);
        this.b = new c(3);
    }

    public final boolean a() {
        this.b.getClass();
        return MelonSettingInfo.isRepeatModeVideoAuto();
    }

    public final boolean b() {
        this.b.getClass();
        return MelonSettingInfo.isRepeatModeVideoOne();
    }

    public final void c(boolean z) {
        LogU.info$default(this.a, "setEnableAutoPlay() enable: " + z, null, false, 6, null);
        this.b.getClass();
        MelonSettingInfo.setRepeatModeVideoAuto(z);
    }

    public final void d(boolean z) {
        LogU.info$default(this.a, "setEnableRepeatOne() enable: " + z, null, false, 6, null);
        this.b.getClass();
        MelonSettingInfo.setRepeatModeVideoOne(z);
    }
}

