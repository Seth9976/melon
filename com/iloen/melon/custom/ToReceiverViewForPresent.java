package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;

public class ToReceiverViewForPresent extends ToReceiverView {
    public ToReceiverViewForPresent(Context context0) {
        this(context0, null);
    }

    public ToReceiverViewForPresent(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public ToReceiverViewForPresent(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @Override  // com.iloen.melon.custom.ToReceiverView
    public int getAddButton() {
        return 0x7F0A0072;  // id:add_button
    }

    @Override  // com.iloen.melon.custom.ToReceiverView
    public int getHintTextView() {
        return 0x7F0A0532;  // id:hint
    }

    @Override  // com.iloen.melon.custom.ToReceiverView
    public int getLayoutId() {
        return 0x7F0D0896;  // layout:to_senders_view_for_present_send
    }

    @Override  // com.iloen.melon.custom.ToReceiverView
    public float getToUserViewHorizontalSpace() {
        return 12.0f;
    }

    @Override  // com.iloen.melon.custom.ToReceiverView
    public int getToUserViewLayoutId() {
        return 0x7F0D0898;  // layout:to_user_view_for_present
    }

    @Override  // com.iloen.melon.custom.ToReceiverView
    public float getToUserViewVerticalSpace() {
        return 1.0f;
    }

    @Override  // com.iloen.melon.custom.ToReceiverView
    public int getUserLayout() {
        return 0x7F0A0D88;  // id:user_list
    }
}

