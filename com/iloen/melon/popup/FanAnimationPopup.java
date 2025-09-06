package com.iloen.melon.popup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.iloen.melon.utils.system.ScreenUtils;

public class FanAnimationPopup extends MotionAnimationPopup {
    public FanAnimationPopup(Activity activity0) {
        super(activity0, "animation/fan_motion.json", 0, 0x7F080375);  // drawable:fan_motion_single_img
    }

    @Override  // com.iloen.melon.popup.MotionAnimationPopup
    public void onCreate(Bundle bundle0) {
        double f1;
        double f;
        super.onCreate(bundle0);
        int v = ScreenUtils.getScreenHeight(this.getContext());
        if(ScreenUtils.isOrientationPortrait(this.getContext())) {
            f = (double)v;
            f1 = 0.36;
        }
        else {
            f = (double)v;
            f1 = 0.19;
        }
        View view0 = this.findViewById(0x7F0A07B1);  // id:lottie_animation_image
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        viewGroup$MarginLayoutParams0.setMargins(viewGroup$MarginLayoutParams0.leftMargin, ((int)(f * f1)), viewGroup$MarginLayoutParams0.rightMargin, viewGroup$MarginLayoutParams0.bottomMargin);
        view0.setLayoutParams(viewGroup$MarginLayoutParams0);
    }
}

