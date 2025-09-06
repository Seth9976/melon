package com.facebook;

import P1.c;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.I;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.R.color;
import com.facebook.common.R.style;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import e.i;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressLint({"ResourceType"})
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u00002\u00020\u0001B;\b\u0004\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0006\u0012\u0006\u0010\n\u001A\u00020\t\u0012\u0006\u0010\u000B\u001A\u00020\t\u00A2\u0006\u0004\b\f\u0010\rJ1\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J1\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0003\u00A2\u0006\u0004\b\u0011\u0010\u0010J1\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0010J1\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0010J\u000F\u0010\u0014\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001A\u00020\u000E2\u0006\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0018\u001A\u00020\u000E2\u0006\u0010\u0017\u001A\u00020\u001A\u00A2\u0006\u0004\b\u0018\u0010\u001BJ\u0019\u0010\u001E\u001A\u00020\u000E2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001CH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b \u0010\u0015J\u0017\u0010#\u001A\u00020\u000E2\u0006\u0010\"\u001A\u00020!H\u0014\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010\'\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\'\u0010&J\u0019\u0010)\u001A\u00020\u00062\b\u0010(\u001A\u0004\u0018\u00010\tH\u0014\u00A2\u0006\u0004\b)\u0010*J1\u0010+\u001A\u00020\u000E2\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0014\u00A2\u0006\u0004\b+\u0010\u0010J\u0019\u0010.\u001A\u00020\u000E2\b\u0010-\u001A\u0004\u0018\u00010,H\u0014\u00A2\u0006\u0004\b.\u0010/J\u0019\u00100\u001A\u00020\u000E2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001CH\u0014\u00A2\u0006\u0004\b0\u0010\u001FJ\u0019\u00101\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0014\u00A2\u0006\u0004\b1\u00102J\u0019\u00103\u001A\u00020\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0014\u00A2\u0006\u0004\b3\u00102R\u001A\u0010\n\u001A\u00020\t8\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\b\n\u00104\u001A\u0004\b5\u00106R\u001A\u0010\u000B\u001A\u00020\t8\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\b\u000B\u00104\u001A\u0004\b7\u00106R\u0018\u00108\u001A\u0004\u0018\u00010\u001C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010:\u001A\u0004\u0018\u00010\u001C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b:\u00109R\u0016\u0010<\u001A\u00020;8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u0010?R\u0018\u0010B\u001A\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bB\u0010CR\u001A\u0010D\u001A\u00020\u00068\u0014X\u0094D\u00A2\u0006\f\n\u0004\bD\u0010?\u001A\u0004\bE\u0010&R\u0014\u0010G\u001A\u00020\u00068$X\u00A4\u0004\u00A2\u0006\u0006\u001A\u0004\bF\u0010&R\u0013\u0010J\u001A\u0004\u0018\u00010\u00168F\u00A2\u0006\u0006\u001A\u0004\bH\u0010IR\u0013\u0010\u0017\u001A\u0004\u0018\u00010\u001A8F\u00A2\u0006\u0006\u001A\u0004\bK\u0010LR\u0013\u0010P\u001A\u0004\u0018\u00010M8F\u00A2\u0006\u0006\u001A\u0004\bN\u0010OR\u0014\u0010R\u001A\u00020\u00068VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bQ\u0010&R\u0014\u0010V\u001A\u00020S8TX\u0094\u0004\u00A2\u0006\u0006\u001A\u0004\bT\u0010U\u00A8\u0006W"}, d2 = {"Lcom/facebook/FacebookButtonBase;", "Landroid/widget/Button;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "", "analyticsButtonCreatedEventName", "analyticsButtonTappedEventName", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILjava/lang/String;Ljava/lang/String;)V", "Lie/H;", "parseBackgroundAttributes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "parseCompoundDrawableAttributes", "parseContentAttributes", "parseTextAttributes", "setupOnClickListener", "()V", "Landroid/app/Fragment;", "fragment", "setFragment", "(Landroid/app/Fragment;)V", "Landroidx/fragment/app/I;", "(Landroidx/fragment/app/I;)V", "Landroid/view/View$OnClickListener;", "l", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "onAttachedToWindow", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "getCompoundPaddingLeft", "()I", "getCompoundPaddingRight", "text", "measureTextWidth", "(Ljava/lang/String;)I", "configureButton", "Landroid/view/View;", "v", "callExternalOnClickListener", "(Landroid/view/View;)V", "setInternalOnClickListener", "logButtonCreated", "(Landroid/content/Context;)V", "logButtonTapped", "Ljava/lang/String;", "getAnalyticsButtonCreatedEventName", "()Ljava/lang/String;", "getAnalyticsButtonTappedEventName", "externalOnClickListener", "Landroid/view/View$OnClickListener;", "internalOnClickListener", "", "overrideCompoundPadding", "Z", "overrideCompoundPaddingLeft", "I", "overrideCompoundPaddingRight", "Lcom/facebook/internal/FragmentWrapper;", "parentFragment", "Lcom/facebook/internal/FragmentWrapper;", "defaultStyleResource", "getDefaultStyleResource", "getDefaultRequestCode", "defaultRequestCode", "getNativeFragment", "()Landroid/app/Fragment;", "nativeFragment", "getFragment", "()Landroidx/fragment/app/I;", "Le/i;", "getAndroidxActivityResultRegistryOwner", "()Le/i;", "androidxActivityResultRegistryOwner", "getRequestCode", "requestCode", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class FacebookButtonBase extends Button {
    @NotNull
    private final String analyticsButtonCreatedEventName;
    @NotNull
    private final String analyticsButtonTappedEventName;
    private final int defaultStyleResource;
    @Nullable
    private View.OnClickListener externalOnClickListener;
    @Nullable
    private View.OnClickListener internalOnClickListener;
    private boolean overrideCompoundPadding;
    private int overrideCompoundPaddingLeft;
    private int overrideCompoundPaddingRight;
    @Nullable
    private FragmentWrapper parentFragment;

    public FacebookButtonBase(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v, int v1, @NotNull String s, @NotNull String s1) {
        q.g(context0, "context");
        q.g(s, "analyticsButtonCreatedEventName");
        q.g(s1, "analyticsButtonTappedEventName");
        super(context0, attributeSet0, 0);
        if(v1 == 0) {
            v1 = this.getDefaultStyleResource();
        }
        if(v1 == 0) {
            v1 = style.com_facebook_button;
        }
        this.configureButton(context0, attributeSet0, v, v1);
        this.analyticsButtonCreatedEventName = s;
        this.analyticsButtonTappedEventName = s1;
        this.setClickable(true);
        this.setFocusable(true);
    }

    public void callExternalOnClickListener(@Nullable View view0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                View.OnClickListener view$OnClickListener0 = this.externalOnClickListener;
                if(view$OnClickListener0 != null) {
                    view$OnClickListener0.onClick(view0);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public void configureButton(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v, int v1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(context0, "context");
            this.parseBackgroundAttributes(context0, attributeSet0, v, v1);
            this.parseCompoundDrawableAttributes(context0, attributeSet0, v, v1);
            this.parseContentAttributes(context0, attributeSet0, v, v1);
            this.parseTextAttributes(context0, attributeSet0, v, v1);
            this.setupOnClickListener();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    @NotNull
    public Activity getActivity() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Context context0;
            for(context0 = this.getContext(); !(context0 instanceof Activity) && context0 instanceof ContextWrapper; context0 = ((ContextWrapper)context0).getBaseContext()) {
            }
            if(!(context0 instanceof Activity)) {
                throw new FacebookException("Unable to get Activity.");
            }
            return (Activity)context0;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final String getAnalyticsButtonCreatedEventName() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.analyticsButtonCreatedEventName;
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final String getAnalyticsButtonTappedEventName() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.analyticsButtonTappedEventName;
    }

    @Nullable
    public final i getAndroidxActivityResultRegistryOwner() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Activity activity0 = this.getActivity();
            return activity0 instanceof i ? ((i)activity0) : null;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @Override  // android.widget.TextView
    public int getCompoundPaddingLeft() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.overrideCompoundPadding ? this.overrideCompoundPaddingLeft : super.getCompoundPaddingLeft();
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return 0;
    }

    @Override  // android.widget.TextView
    public int getCompoundPaddingRight() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.overrideCompoundPadding ? this.overrideCompoundPaddingRight : super.getCompoundPaddingRight();
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return 0;
    }

    public abstract int getDefaultRequestCode();

    // 去混淆评级： 低(20)
    public int getDefaultStyleResource() {
        return CrashShieldHandler.isObjectCrashing(this) ? 0 : this.defaultStyleResource;
    }

    @Nullable
    public final I getFragment() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.parentFragment == null ? null : this.parentFragment.getSupportFragment();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @Nullable
    public final Fragment getNativeFragment() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.parentFragment == null ? null : this.parentFragment.getNativeFragment();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    public int getRequestCode() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.getDefaultRequestCode();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return 0;
        }
    }

    public void logButtonCreated(@Nullable Context context0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            InternalAppEventsLogger.Companion.createInstance(context0, null).logEventImplicitly(this.analyticsButtonCreatedEventName);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public void logButtonTapped(@Nullable Context context0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            InternalAppEventsLogger.Companion.createInstance(context0, null).logEventImplicitly(this.analyticsButtonTappedEventName);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public int measureTextWidth(@Nullable String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return (int)Math.ceil(this.getPaint().measureText(s));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return 0;
        }
    }

    @Override  // android.widget.TextView
    public void onAttachedToWindow() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                super.onAttachedToWindow();
                if(!this.isInEditMode()) {
                    this.logButtonCreated(this.getContext());
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    @Override  // android.widget.TextView
    public void onDraw(@NotNull Canvas canvas0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(canvas0, "canvas");
            if((this.getGravity() & 1) != 0) {
                int v = this.getCompoundPaddingLeft();
                int v1 = this.getCompoundPaddingRight();
                int v2 = this.getCompoundDrawablePadding();
                int v3 = Math.min((this.getWidth() - (v2 + v) - v1 - this.measureTextWidth(this.getText().toString())) / 2, (v - this.getPaddingLeft()) / 2);
                this.overrideCompoundPaddingLeft = v - v3;
                this.overrideCompoundPaddingRight = v1 + v3;
                this.overrideCompoundPadding = true;
            }
            super.onDraw(canvas0);
            this.overrideCompoundPadding = false;
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void parseBackgroundAttributes(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                if(!this.isInEditMode()) {
                    TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(attributeSet0, new int[]{0x10100D4}, v, v1);
                    q.f(typedArray0, "context.theme.obtainStyl…efStyleAttr, defStyleRes)");
                    try {
                        if(typedArray0.hasValue(0)) {
                            int v3 = typedArray0.getResourceId(0, 0);
                            if(v3 == 0) {
                                this.setBackgroundColor(typedArray0.getColor(0, 0));
                            }
                            else {
                                this.setBackgroundResource(v3);
                            }
                        }
                        else {
                            this.setBackgroundColor(c.getColor(context0, color.com_facebook_blue));
                        }
                    }
                    finally {
                        typedArray0.recycle();
                    }
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    @SuppressLint({"ResourceType"})
    private final void parseCompoundDrawableAttributes(Context context0, AttributeSet attributeSet0, int v, int v1) {
        int v3;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(attributeSet0, new int[]{0x101016F, 0x101016D, 0x1010170, 0x101016E, 0x1010171}, v, v1);
            q.f(typedArray0, "context.theme.obtainStyl…efStyleAttr, defStyleRes)");
            try {
                this.setCompoundDrawablesWithIntrinsicBounds(typedArray0.getResourceId(0, 0), typedArray0.getResourceId(1, 0), typedArray0.getResourceId(2, 0), typedArray0.getResourceId(3, 0));
                v3 = typedArray0.getDimensionPixelSize(4, 0);
            }
            finally {
                typedArray0.recycle();
            }
            this.setCompoundDrawablePadding(v3);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void parseContentAttributes(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(attributeSet0, new int[]{0x10100D6, 0x10100D7, 0x10100D8, 0x10100D9}, v, v1);
            q.f(typedArray0, "context.theme.obtainStyl…efStyleAttr, defStyleRes)");
            try {
                this.setPadding(typedArray0.getDimensionPixelSize(0, 0), typedArray0.getDimensionPixelSize(1, 0), typedArray0.getDimensionPixelSize(2, 0), typedArray0.getDimensionPixelSize(3, 0));
            }
            finally {
                typedArray0.recycle();
            }
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void parseTextAttributes(Context context0, AttributeSet attributeSet0, int v, int v1) {
        String s;
        int v4;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(attributeSet0, new int[]{0x1010098}, v, v1);
            q.f(typedArray0, "context.theme.obtainStyl…efStyleAttr, defStyleRes)");
            try {
                this.setTextColor(typedArray0.getColorStateList(0));
            }
            finally {
                typedArray0.recycle();
            }
            TypedArray typedArray1 = context0.getTheme().obtainStyledAttributes(attributeSet0, new int[]{0x10100AF}, v, v1);
            q.f(typedArray1, "context.theme.obtainStyl…efStyleAttr, defStyleRes)");
            try {
                v4 = typedArray1.getInt(0, 17);
            }
            finally {
                typedArray1.recycle();
            }
            this.setGravity(v4);
            TypedArray typedArray2 = context0.getTheme().obtainStyledAttributes(attributeSet0, new int[]{0x1010095, 0x1010097, 0x101014F}, v, v1);
            q.f(typedArray2, "context.theme.obtainStyl…efStyleAttr, defStyleRes)");
            try {
                this.setTextSize(0, ((float)typedArray2.getDimensionPixelSize(0, 0)));
                this.setTypeface(Typeface.create(this.getTypeface(), 1));
                s = typedArray2.getString(2);
            }
            finally {
                typedArray2.recycle();
            }
            this.setText(s);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public final void setFragment(@NotNull Fragment fragment0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(fragment0, "fragment");
            this.parentFragment = new FragmentWrapper(fragment0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void setFragment(@NotNull I i0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(i0, "fragment");
            this.parentFragment = new FragmentWrapper(i0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public void setInternalOnClickListener(@Nullable View.OnClickListener view$OnClickListener0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        this.internalOnClickListener = view$OnClickListener0;
    }

    @Override  // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener view$OnClickListener0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        this.externalOnClickListener = view$OnClickListener0;
    }

    private final void setupOnClickListener() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.setOnClickListener(new d(this));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private static final void setupOnClickListener$lambda$0(FacebookButtonBase facebookButtonBase0, View view0) {
        Class class0 = FacebookButtonBase.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(facebookButtonBase0, "this$0");
                facebookButtonBase0.logButtonTapped(facebookButtonBase0.getContext());
                View.OnClickListener view$OnClickListener0 = facebookButtonBase0.internalOnClickListener;
                if(view$OnClickListener0 != null) {
                    view$OnClickListener0.onClick(view0);
                    return;
                }
                View.OnClickListener view$OnClickListener1 = facebookButtonBase0.externalOnClickListener;
                if(view$OnClickListener1 != null) {
                    view$OnClickListener1.onClick(view0);
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }
}

