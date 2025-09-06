package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import d3.g;
import ie.r;
import k8.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000ER\u001B\u0010\u0013\u001A\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/custom/MelonBigButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "text", "Lie/H;", "setText", "(Ljava/lang/String;)V", "w", "Lie/j;", "getDefaultDrawablePadding", "()I", "defaultDrawablePadding", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonBigButton extends ConstraintLayout {
    public static final int B;
    public final Flow o;
    public final TextView r;
    public final r w;

    public MelonBigButton(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 6, 0);
    }

    public MelonBigButton(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 4, 0);
    }

    public MelonBigButton(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        this.w = g.Q(new h0(context0, 0));
        View.inflate(context0, 0x7F0D012B, this);  // layout:button_big
        this.setBackgroundResource(0x7F0808B2);  // drawable:shape_rectangle_gray050s_round4
        View view0 = this.findViewById(0x7F0A04CB);  // id:flow
        q.f(view0, "findViewById(...)");
        Flow flow0 = (Flow)view0;
        this.o = flow0;
        View view1 = this.findViewById(0x7F0A054C);  // id:icon_iv
        q.f(view1, "findViewById(...)");
        ImageView imageView0 = (ImageView)view1;
        View view2 = this.findViewById(0x7F0A0B61);  // id:text_tv
        q.f(view2, "findViewById(...)");
        this.r = (TextView)view2;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.q, v, 0);
        q.f(typedArray0, "obtainStyledAttributes(...)");
        try {
            if(typedArray0.hasValue(1)) {
                imageView0.setImageResource(typedArray0.getResourceId(1, 0));
                flow0.setHorizontalGap(this.getDefaultDrawablePadding());
                goto label_22;
            }
        }
        catch(Exception unused_ex) {
        }
        this.o.setHorizontalGap(0);
    label_22:
        TextView textView0 = this.r;
        if(textView0 != null) {
            textView0.setText(typedArray0.getString(0));
            textView0.setPadding(0, 0, 0, ((int)typedArray0.getDimension(2, ((float)ScreenUtils.dipToPixel(context0, 2.0f)))));
        }
        ViewUtils.setContentDescriptionWithButtonClassName(this, (this.r == null ? null : this.r.getText()));
        typedArray0.recycle();
    }

    public MelonBigButton(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    private final int getDefaultDrawablePadding() {
        return ((Number)this.w.getValue()).intValue();
    }

    public final void setText(@Nullable String s) {
        this.r.setText(s);
    }
}

