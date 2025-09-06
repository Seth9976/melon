package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        this.T();
    }

    public AutoTransition(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.T();
    }

    public final void T() {
        this.S(1);
        this.O(new Fade(2));
        ChangeBounds changeBounds0 = new ChangeBounds();  // 初始化器: Landroidx/transition/Transition;-><init>()V
        changeBounds0.b0 = false;
        this.O(changeBounds0);
        this.O(new Fade(1));
    }
}

