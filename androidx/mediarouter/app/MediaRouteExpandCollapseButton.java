package androidx.mediarouter.app;

import De.I;
import P1.c;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import androidx.appcompat.widget.AppCompatImageButton;

class MediaRouteExpandCollapseButton extends AppCompatImageButton {
    public final AnimationDrawable d;
    public final AnimationDrawable e;
    public final String f;
    public final String g;
    public boolean h;
    public View.OnClickListener i;

    public MediaRouteExpandCollapseButton(Context context0) {
        this(context0, null);
    }

    public MediaRouteExpandCollapseButton(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public MediaRouteExpandCollapseButton(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        AnimationDrawable animationDrawable0 = (AnimationDrawable)c.getDrawable(context0, 0x7F080751);  // drawable:mr_group_expand
        this.d = animationDrawable0;
        AnimationDrawable animationDrawable1 = (AnimationDrawable)c.getDrawable(context0, 0x7F080750);  // drawable:mr_group_collapse
        this.e = animationDrawable1;
        PorterDuffColorFilter porterDuffColorFilter0 = new PorterDuffColorFilter(I.E(context0, v), PorterDuff.Mode.SRC_IN);
        animationDrawable0.setColorFilter(porterDuffColorFilter0);
        animationDrawable1.setColorFilter(porterDuffColorFilter0);
        this.f = "Expand";
        this.g = "Collapse";
        this.setImageDrawable(animationDrawable0.getFrame(0));
        this.setContentDescription("Expand");
        super.setOnClickListener(new B(this, 1));
    }

    @Override  // android.view.View
    public final void setOnClickListener(View.OnClickListener view$OnClickListener0) {
        this.i = view$OnClickListener0;
    }
}

