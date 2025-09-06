package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.utils.color.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0017\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u001A\u0010\u000F\u001A\u00020\n8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER\u001A\u0010\u0015\u001A\u00020\u00108\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R*\u0010\u001D\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u00068\u0016@VX\u0096\u000E¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/custom/FollowToggleButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/ImageView;", "o", "Landroid/widget/ImageView;", "getIconIv", "()Landroid/widget/ImageView;", "iconIv", "Landroid/widget/TextView;", "r", "Landroid/widget/TextView;", "getTextTv", "()Landroid/widget/TextView;", "textTv", "value", "w", "I", "getType", "()I", "setType", "(I)V", "type", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class FollowToggleButton extends ConstraintLayout {
    public final ImageView o;
    public final TextView r;
    public int w;

    public FollowToggleButton(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 6, 0);
    }

    public FollowToggleButton(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 4, 0);
    }

    public FollowToggleButton(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        View.inflate(context0, 0x7F0D0899, this);  // layout:toggle_common_button
        View view0 = this.findViewById(0x7F0A054C);  // id:icon_iv
        q.f(view0, "findViewById(...)");
        this.o = (ImageView)view0;
        View view1 = this.findViewById(0x7F0A0B61);  // id:text_tv
        q.f(view1, "findViewById(...)");
        this.r = (TextView)view1;
    }

    public FollowToggleButton(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    @NotNull
    public final ImageView getIconIv() {
        return this.o;
    }

    @NotNull
    public final TextView getTextTv() {
        return this.r;
    }

    public int getType() {
        return this.w;
    }

    public void setType(int v) {
        TextView textView0 = this.r;
        ImageView imageView0 = this.o;
        if(v == 0) {
            this.setBackgroundResource(0x7F0808E3);  // drawable:shape_rectangle_gray900s_0_5dp_stroke_round4
            imageView0.setImageResource(0x7F080141);  // drawable:btn_common_follow_18_off
            textView0.setTextColor(ColorUtils.getColor(textView0.getContext(), 0x7F06016D));  // color:gray900s
            textView0.setText("팔로우");
            this.w = 0;
            return;
        }
        this.setBackgroundResource(0x7F0808CB);  // drawable:shape_rectangle_gray200a_0_5dp_stroke_round4
        imageView0.setImageResource(0x7F080143);  // drawable:btn_common_follow_18_on
        textView0.setTextColor(ColorUtils.getColor(textView0.getContext(), 0x7F060165));  // color:gray800s
        textView0.setText("팔로잉");
        this.w = 1;
    }
}

