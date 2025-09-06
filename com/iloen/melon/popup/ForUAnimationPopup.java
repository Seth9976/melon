package com.iloen.melon.popup;

import android.app.Activity;

public class ForUAnimationPopup extends MotionAnimationPopup {
    public ForUAnimationPopup(Activity activity0) {
        super(activity0, "animation/ic_loading.json", 1, -1);
    }

    @Override  // com.iloen.melon.popup.MotionAnimationPopup
    public int getLayoutId() {
        return 0x7F0D05A8;  // layout:popup_foru_music_favor
    }
}

