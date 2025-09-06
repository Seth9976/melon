package com.iloen.melon.custom;

import Bd.I;
import J8.J0;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.iloen.melon.popup.EqualizerSelectPopup;
import com.iloen.melon.popup.v;
import com.iloen.melon.utils.ResourceUtilsKt;
import e1.b;
import kotlin.jvm.internal.q;
import y8.l;

public class CheckableImageView extends AppCompatImageView implements Checkable {
    public boolean a;
    public k b;
    public static final int[] c;

    static {
        CheckableImageView.c = new int[]{0x10100A0};
    }

    public CheckableImageView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    @Override  // androidx.appcompat.widget.AppCompatImageView
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this.invalidate();
    }

    @Override  // android.widget.Checkable
    public final boolean isChecked() {
        return this.a;
    }

    @Override  // android.widget.ImageView
    public final int[] onCreateDrawableState(int v) {
        int[] arr_v = super.onCreateDrawableState(v + 1);
        if(this.a) {
            View.mergeDrawableStates(arr_v, CheckableImageView.c);
        }
        return arr_v;
    }

    @Override  // android.widget.Checkable
    public void setChecked(boolean z) {
        if(this.a == z) {
            return;
        }
        this.a = z;
        k k0 = this.b;
        if(k0 != null) {
            EqualizerSelectPopup equalizerSelectPopup0 = ((v)k0).a;
            l.a.h(z);
            if(z) {
                J0 j00 = equalizerSelectPopup0.b;
                if(j00 != null) {
                    y8.k k1 = b.F();
                    ((MelonTextView)j00.g).setText(k1.d);
                    this.setContentDescription("," + ResourceUtilsKt.getString(0x7F130B2A, new Object[0]));  // string:talkback_feature_on "사용 중"
                    equalizerSelectPopup0.trackTiaraEventLog(new I(true, 3));
                    this.refreshDrawableState();
                    return;
                }
            }
            else {
                J0 j01 = equalizerSelectPopup0.b;
                if(j01 != null) {
                    ((MelonTextView)j01.g).setText("");
                    this.setContentDescription("," + ResourceUtilsKt.getString(0x7F130B29, new Object[0]));  // string:talkback_feature_off "사용 안 함"
                    equalizerSelectPopup0.trackTiaraEventLog(new I(false, 3));
                    this.refreshDrawableState();
                    return;
                }
            }
            q.m("binding");
            throw null;
        }
        this.refreshDrawableState();
    }

    public void setOnCheckedChangeListener(k k0) {
        this.b = k0;
    }

    @Override  // android.widget.Checkable
    public final void toggle() {
        this.setChecked(!this.a);
    }
}

