package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.widget.TextView;
import com.iloen.melon.utils.color.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tR*\u0010\u0011\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u00068\u0016@VX\u0096\u000E¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/custom/FollowToggleColorButton;", "Lcom/iloen/melon/custom/FollowToggleButton;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "B", "I", "getType", "()I", "setType", "(I)V", "type", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FollowToggleColorButton extends FollowToggleButton {
    public int B;

    public FollowToggleColorButton(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 6, 0);
    }

    public FollowToggleColorButton(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 4, 0);
    }

    public FollowToggleColorButton(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
    }

    public FollowToggleColorButton(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    @Override  // com.iloen.melon.custom.FollowToggleButton
    public int getType() {
        return this.B;
    }

    @Override  // com.iloen.melon.custom.FollowToggleButton
    public void setType(int v) {
        if(v == 0) {
            this.setBackgroundResource(0x7F080902);  // drawable:shape_rectangle_white000e_0_5dp_stroke_round4_transparent
            this.getIconIv().setImageResource(0x7F080141);  // drawable:btn_common_follow_18_off
            this.getIconIv().setImageTintList(ColorStateList.valueOf(ColorUtils.getColor(this.getContext(), 0x7F0604A1)));  // color:white000e
            TextView textView0 = this.getTextTv();
            textView0.setTextColor(ColorUtils.getColor(textView0.getContext(), 0x7F0604A1));  // color:white000e
            textView0.setText("팔로우");
            this.B = 0;
            return;
        }
        this.setBackgroundResource(0x7F080910);  // drawable:shape_rectangle_white220e_0_5dp_stroke_round4
        this.getIconIv().setImageResource(0x7F080143);  // drawable:btn_common_follow_18_on
        this.getIconIv().setImageTintList(ColorStateList.valueOf(ColorUtils.getColor(this.getContext(), 0x7F0604B7)));  // color:white700e
        TextView textView1 = this.getTextTv();
        textView1.setTextColor(ColorUtils.getColor(textView1.getContext(), 0x7F0604B7));  // color:white700e
        textView1.setText("팔로잉");
        this.B = 1;
    }
}

