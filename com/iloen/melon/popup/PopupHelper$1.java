package com.iloen.melon.popup;

import android.app.Activity;
import com.iloen.melon.utils.log.LogU;

class PopupHelper.1 implements Runnable {
    public final Activity a;
    public final MelonTextPopup b;

    public PopupHelper.1(Activity activity0, MelonTextPopup melonTextPopup0) {
        this.a = activity0;
        this.b = melonTextPopup0;
    }

    @Override
    public void run() {
        Activity activity0 = this.a;
        if(!PopupHelper.isAvailableActivity(activity0)) {
            LogU.w("PopupHelper", "makeAndShowTextPopupCanTextButton - activity is null or finishing:" + activity0);
            return;
        }
        this.b.show();
    }
}

