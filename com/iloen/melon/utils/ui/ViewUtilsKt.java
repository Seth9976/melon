package com.iloen.melon.utils.ui;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import c2.W;
import c2.b;
import com.iloen.melon.MelonAppBase;
import d2.d;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0011\u0010\u0001\u001A\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001A\u0011\u0010\u0001\u001A\u00020\u0000*\u00020\u0003¢\u0006\u0004\b\u0001\u0010\u0004\u001A\u0011\u0010\u0005\u001A\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0002\u001A\u0011\u0010\u0005\u001A\u00020\u0000*\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0004\u001A\u0019\u0010\u0001\u001A\u00020\u0000*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\u0001\u0010\b\u001A\u0019\u0010\u0001\u001A\u00020\u0000*\u00020\t2\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\u0001\u0010\n\u001AA\u0010\u0010\u001A\u00020\u000F*\u00020\u00062\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011\u001A\u0011\u0010\u0012\u001A\u00020\u000F*\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"", "dpToPx", "(I)I", "", "(F)I", "pxToDp", "Landroid/view/View;", "dp", "(Landroid/view/View;F)I", "Landroid/content/Context;", "(Landroid/content/Context;F)I", "left", "top", "right", "bottom", "Lie/H;", "setMarginToDp", "(Landroid/view/View;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "setAccessibilityButtonClassName", "(Landroid/view/View;)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class ViewUtilsKt {
    public static final int dpToPx(float f) {
        MelonAppBase.Companion.getClass();
        return (int)TypedValue.applyDimension(1, f, t.a().getContext().getResources().getDisplayMetrics());
    }

    public static final int dpToPx(int v) {
        MelonAppBase.Companion.getClass();
        return (int)TypedValue.applyDimension(1, ((float)v), t.a().getContext().getResources().getDisplayMetrics());
    }

    public static final int dpToPx(@NotNull Context context0, float f) {
        q.g(context0, "<this>");
        return (int)TypedValue.applyDimension(1, f, context0.getResources().getDisplayMetrics());
    }

    public static final int dpToPx(@NotNull View view0, float f) {
        q.g(view0, "<this>");
        Context context0 = view0.getContext();
        q.f(context0, "getContext(...)");
        return ViewUtilsKt.dpToPx(context0, f);
    }

    public static final int pxToDp(float f) {
        MelonAppBase.Companion.getClass();
        return (int)TypedValue.applyDimension(0, f, t.a().getContext().getResources().getDisplayMetrics());
    }

    public static final int pxToDp(int v) {
        MelonAppBase.Companion.getClass();
        return (int)TypedValue.applyDimension(0, ((float)v), t.a().getContext().getResources().getDisplayMetrics());
    }

    public static final void setAccessibilityButtonClassName(@NotNull View view0) {
        q.g(view0, "<this>");
        W.o(view0, new b() {  // 初始化器: Lc2/b;-><init>()V
            @Override  // c2.b
            public void onInitializeAccessibilityNodeInfo(View view0, d d0) {
                q.g(view0, "host");
                q.g(d0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                d0.l("android.widget.Button");
            }
        });
    }

    public static final void setMarginToDp(@NotNull View view0, @Nullable Float float0, @Nullable Float float1, @Nullable Float float2, @Nullable Float float3) {
        q.g(view0, "<this>");
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
            if(float0 != null) {
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).leftMargin = ViewUtilsKt.dpToPx(view0, float0.floatValue());
            }
            if(float1 != null) {
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = ViewUtilsKt.dpToPx(view0, float1.floatValue());
            }
            if(float2 != null) {
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin = ViewUtilsKt.dpToPx(view0, float2.floatValue());
            }
            if(float3 != null) {
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).bottomMargin = ViewUtilsKt.dpToPx(view0, float3.floatValue());
            }
        }
    }

    public static void setMarginToDp$default(View view0, Float float0, Float float1, Float float2, Float float3, int v, Object object0) {
        if((v & 1) != 0) {
            float0 = null;
        }
        if((v & 2) != 0) {
            float1 = null;
        }
        if((v & 4) != 0) {
            float2 = null;
        }
        if((v & 8) != 0) {
            float3 = null;
        }
        ViewUtilsKt.setMarginToDp(view0, float0, float1, float2, float3);
    }
}

