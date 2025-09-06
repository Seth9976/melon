package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u0004\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/custom/BottomSheetScrollBlockBehavior;", "Landroid/view/View;", "V", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BottomSheetScrollBlockBehavior extends BottomSheetBehavior {
    public BottomSheetScrollBlockBehavior() {
    }

    public BottomSheetScrollBlockBehavior(@NotNull Context context0, @NotNull AttributeSet attributeSet0) {
        q.g(context0, "context");
        q.g(attributeSet0, "attrs");
        super(context0, attributeSet0);
    }

    @Override  // com.google.android.material.bottomsheet.BottomSheetBehavior
    public final boolean k(CoordinatorLayout coordinatorLayout0, View view0, MotionEvent motionEvent0) {
        q.g(motionEvent0, "event");
        return false;
    }
}

