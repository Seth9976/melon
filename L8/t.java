package l8;

import b.n;
import com.iloen.melon.activity.MelonAppSvcActivity;

public final class t extends n {
    public final MelonAppSvcActivity a;

    public t(MelonAppSvcActivity melonAppSvcActivity0) {
        this.a = melonAppSvcActivity0;
        super(true);
    }

    @Override  // b.n
    public final void handleOnBackPressed() {
        this.a.onBackPressedCallback();
    }
}

