package com.iloen.melon.player.video;

import android.content.Context;
import android.util.TypedValue;
import androidx.constraintlayout.motion.widget.MotionLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class VideoMainFrameFragmentKt {
    public static final float access$getFloat(Context context0, int v, float f) {
        if(context0 == null) {
            return f;
        }
        TypedValue typedValue0 = new TypedValue();
        context0.getResources().getValue(v, typedValue0, true);
        return typedValue0.getFloat();
    }

    public static final void access$jumpToStateAndSetTransition(MotionLayout motionLayout0, int v) {
        motionLayout0.jumpToState(v);
        switch(v) {
            case 0x7F0A0471: {  // id:expand
                motionLayout0.setTransition(0x7F0A0477);  // id:expand_mini_transition
                motionLayout0.setProgress(0.0f);
                return;
            }
            case 0x7F0A0808: {  // id:mini
                motionLayout0.setTransition(0x7F0A0477);  // id:expand_mini_transition
                motionLayout0.setProgress(1.0f);
            }
        }
    }
}

