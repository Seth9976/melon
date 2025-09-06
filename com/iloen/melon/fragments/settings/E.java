package com.iloen.melon.fragments.settings;

import com.iloen.melon.custom.b1;

public final class e implements b1 {
    public final int a;
    public final SettingAdvancedFragment b;

    public e(SettingAdvancedFragment settingAdvancedFragment0, int v) {
        this.a = v;
        this.b = settingAdvancedFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.b1
    public final void onRadioBtnClick(boolean z) {
        switch(this.a) {
            case 0: {
                this.b.lambda$initUseFloatingLyric$1(z);
                return;
            }
            case 1: {
                this.b.lambda$initUsePlayingScreenOn$0(z);
                return;
            }
            default: {
                this.b.lambda$initUseAudioFocusKeeping$3(z);
            }
        }
    }
}

