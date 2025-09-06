package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import com.facebook.appevents.c;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

public class DefaultTimeBar extends View implements TimeBar {
    private static final String ACCESSIBILITY_CLASS_NAME = "android.widget.SeekBar";
    public static final int DEFAULT_AD_MARKER_COLOR = 0xB2FFFF00;
    public static final int DEFAULT_AD_MARKER_WIDTH_DP = 4;
    public static final int DEFAULT_BAR_HEIGHT_DP = 4;
    public static final int DEFAULT_BUFFERED_COLOR = 0xCCFFFFFF;
    private static final int DEFAULT_INCREMENT_COUNT = 20;
    public static final int DEFAULT_PLAYED_AD_MARKER_COLOR = 0x33FFFF00;
    public static final int DEFAULT_PLAYED_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_DISABLED_SIZE_DP = 0;
    public static final int DEFAULT_SCRUBBER_DRAGGED_SIZE_DP = 16;
    public static final int DEFAULT_SCRUBBER_ENABLED_SIZE_DP = 12;
    public static final int DEFAULT_TOUCH_TARGET_HEIGHT_DP = 26;
    public static final int DEFAULT_UNPLAYED_COLOR = 0x33FFFFFF;
    private static final int FINE_SCRUB_RATIO = 3;
    private static final int FINE_SCRUB_Y_THRESHOLD_DP = -50;
    private static final float HIDDEN_SCRUBBER_SCALE = 0.0f;
    private static final float SHOWN_SCRUBBER_SCALE = 1.0f;
    private static final long STOP_SCRUBBING_TIMEOUT_MS = 1000L;
    private int adGroupCount;
    private long[] adGroupTimesMs;
    private final Paint adMarkerPaint;
    private final int adMarkerWidth;
    private final int barHeight;
    private final Rect bufferedBar;
    private final Paint bufferedPaint;
    private long bufferedPosition;
    private final float density;
    private long duration;
    private final int fineScrubYThreshold;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;
    private int keyCountIncrement;
    private long keyTimeIncrement;
    private int lastCoarseScrubXPosition;
    private Rect lastExclusionRectangle;
    private final CopyOnWriteArraySet listeners;
    private boolean[] playedAdGroups;
    private final Paint playedAdMarkerPaint;
    private final Paint playedPaint;
    private long position;
    private final Rect progressBar;
    private long scrubPosition;
    private final Rect scrubberBar;
    private final int scrubberDisabledSize;
    private final int scrubberDraggedSize;
    private final Drawable scrubberDrawable;
    private final int scrubberEnabledSize;
    private final int scrubberPadding;
    private final Paint scrubberPaint;
    private float scrubberScale;
    private ValueAnimator scrubberScalingAnimator;
    private boolean scrubbing;
    private final Rect seekBounds;
    private final Runnable stopScrubbingRunnable;
    private final Point touchPosition;
    private final int touchTargetHeight;
    private final Paint unplayedPaint;

    public DefaultTimeBar(Context context0) {
        this(context0, null);
    }

    public DefaultTimeBar(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public DefaultTimeBar(Context context0, AttributeSet attributeSet0, int v) {
        this(context0, attributeSet0, v, attributeSet0);
    }

    public DefaultTimeBar(Context context0, AttributeSet attributeSet0, int v, AttributeSet attributeSet1) {
        super(context0, attributeSet0, v);
        this.seekBounds = new Rect();
        this.progressBar = new Rect();
        this.bufferedBar = new Rect();
        this.scrubberBar = new Rect();
        Paint paint0 = new Paint();
        this.playedPaint = paint0;
        Paint paint1 = new Paint();
        this.bufferedPaint = paint1;
        Paint paint2 = new Paint();
        this.unplayedPaint = paint2;
        Paint paint3 = new Paint();
        this.adMarkerPaint = paint3;
        Paint paint4 = new Paint();
        this.playedAdMarkerPaint = paint4;
        Paint paint5 = new Paint();
        this.scrubberPaint = paint5;
        paint5.setAntiAlias(true);
        this.listeners = new CopyOnWriteArraySet();
        this.touchPosition = new Point();
        float f = context0.getResources().getDisplayMetrics().density;
        this.density = f;
        this.fineScrubYThreshold = (int)(-50.0f * f + 0.5f);
        int v1 = (int)(4.0f * f + 0.5f);
        int v2 = (int)(26.0f * f + 0.5f);
        int v3 = (int)(4.0f * f + 0.5f);
        int v4 = (int)(12.0f * f + 0.5f);
        int v5 = (int)(0.0f * f + 0.5f);
        int v6 = (int)(16.0f * f + 0.5f);
        if(attributeSet1 == null) {
            this.barHeight = v1;
            this.touchTargetHeight = v2;
            this.adMarkerWidth = v3;
            this.scrubberEnabledSize = v4;
            this.scrubberDisabledSize = v5;
            this.scrubberDraggedSize = v6;
            paint0.setColor(-1);
            paint5.setColor(-1);
            paint1.setColor(0xCCFFFFFF);
            paint2.setColor(0x33FFFFFF);
            paint3.setColor(0xB2FFFF00);
            paint4.setColor(0x33FFFF00);
            this.scrubberDrawable = null;
        }
        else {
            TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(attributeSet1, styleable.DefaultTimeBar, 0, 0);
            try {
                Drawable drawable0 = typedArray0.getDrawable(styleable.DefaultTimeBar_scrubber_drawable);
                this.scrubberDrawable = drawable0;
                if(drawable0 != null) {
                    this.setDrawableLayoutDirection(drawable0);
                    v2 = Math.max(drawable0.getMinimumHeight(), v2);
                }
                this.barHeight = typedArray0.getDimensionPixelSize(styleable.DefaultTimeBar_bar_height, v1);
                this.touchTargetHeight = typedArray0.getDimensionPixelSize(styleable.DefaultTimeBar_touch_target_height, v2);
                this.adMarkerWidth = typedArray0.getDimensionPixelSize(styleable.DefaultTimeBar_ad_marker_width, v3);
                this.scrubberEnabledSize = typedArray0.getDimensionPixelSize(styleable.DefaultTimeBar_scrubber_enabled_size, v4);
                this.scrubberDisabledSize = typedArray0.getDimensionPixelSize(styleable.DefaultTimeBar_scrubber_disabled_size, v5);
                this.scrubberDraggedSize = typedArray0.getDimensionPixelSize(styleable.DefaultTimeBar_scrubber_dragged_size, v6);
                int v8 = typedArray0.getInt(styleable.DefaultTimeBar_played_color, -1);
                int v9 = typedArray0.getInt(styleable.DefaultTimeBar_scrubber_color, -1);
                int v10 = typedArray0.getInt(styleable.DefaultTimeBar_buffered_color, 0xCCFFFFFF);
                int v11 = typedArray0.getInt(styleable.DefaultTimeBar_unplayed_color, 0x33FFFFFF);
                int v12 = typedArray0.getInt(styleable.DefaultTimeBar_ad_marker_color, 0xB2FFFF00);
                int v13 = typedArray0.getInt(styleable.DefaultTimeBar_played_ad_marker_color, 0x33FFFF00);
                paint0.setColor(v8);
                paint5.setColor(v9);
                paint1.setColor(v10);
                paint2.setColor(v11);
                paint3.setColor(v12);
                paint4.setColor(v13);
            }
            finally {
                typedArray0.recycle();
            }
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        this.formatBuilder = stringBuilder0;
        this.formatter = new Formatter(stringBuilder0, Locale.getDefault());
        this.stopScrubbingRunnable = new c(this, 13);
        Drawable drawable1 = this.scrubberDrawable;
        this.scrubberPadding = drawable1 == null ? (Math.max(this.scrubberDisabledSize, Math.max(this.scrubberEnabledSize, this.scrubberDraggedSize)) + 1) / 2 : (drawable1.getMinimumWidth() + 1) / 2;
        this.scrubberScale = 1.0f;
        ValueAnimator valueAnimator0 = new ValueAnimator();
        this.scrubberScalingAnimator = valueAnimator0;
        valueAnimator0.addUpdateListener(new a(this, 0));
        this.duration = 0x8000000000000001L;
        this.keyTimeIncrement = 0x8000000000000001L;
        this.keyCountIncrement = 20;
        this.setFocusable(true);
        if(this.getImportantForAccessibility() == 0) {
            this.setImportantForAccessibility(1);
        }
    }

    @Override  // com.google.android.exoplayer2.ui.TimeBar
    public void addListener(OnScrubListener timeBar$OnScrubListener0) {
        this.listeners.add(timeBar$OnScrubListener0);
    }

    public static void b(DefaultTimeBar defaultTimeBar0) {
        defaultTimeBar0.lambda$new$0();
    }

    private static int dpToPx(float f, int v) [...] // Inlined contents

    private void drawPlayhead(Canvas canvas0) {
        int v2;
        if(this.duration <= 0L) {
            return;
        }
        int v = Util.constrainValue(this.scrubberBar.right, this.scrubberBar.left, this.progressBar.right);
        int v1 = this.scrubberBar.centerY();
        Drawable drawable0 = this.scrubberDrawable;
        if(drawable0 == null) {
            if(this.scrubbing || this.isFocused()) {
                v2 = this.scrubberDraggedSize;
            }
            else if(this.isEnabled()) {
                v2 = this.scrubberEnabledSize;
            }
            else {
                v2 = this.scrubberDisabledSize;
            }
            canvas0.drawCircle(((float)v), ((float)v1), ((float)(((int)(((float)v2) * this.scrubberScale / 2.0f)))), this.scrubberPaint);
            return;
        }
        int v3 = (int)(((float)drawable0.getIntrinsicWidth()) * this.scrubberScale);
        int v4 = ((int)(((float)this.scrubberDrawable.getIntrinsicHeight()) * this.scrubberScale)) / 2;
        this.scrubberDrawable.setBounds(v - v3 / 2, v1 - v4, v + v3 / 2, v1 + v4);
        this.scrubberDrawable.draw(canvas0);
    }

    private void drawTimeBar(Canvas canvas0) {
        int v = this.progressBar.height();
        int v1 = this.progressBar.centerY() - v / 2;
        int v2 = v + v1;
        if(this.duration <= 0L) {
            canvas0.drawRect(((float)this.progressBar.left), ((float)v1), ((float)this.progressBar.right), ((float)v2), this.unplayedPaint);
            return;
        }
        int v3 = this.bufferedBar.left;
        int v4 = this.bufferedBar.right;
        int v5 = Math.max(Math.max(this.progressBar.left, v4), this.scrubberBar.right);
        int v6 = this.progressBar.right;
        if(v5 < v6) {
            canvas0.drawRect(((float)v5), ((float)v1), ((float)v6), ((float)v2), this.unplayedPaint);
        }
        int v7 = Math.max(v3, this.scrubberBar.right);
        if(v4 > v7) {
            canvas0.drawRect(((float)v7), ((float)v1), ((float)v4), ((float)v2), this.bufferedPaint);
        }
        if(this.scrubberBar.width() > 0) {
            canvas0.drawRect(((float)this.scrubberBar.left), ((float)v1), ((float)this.scrubberBar.right), ((float)v2), this.playedPaint);
        }
        if(this.adGroupCount != 0) {
            long[] arr_v = (long[])Assertions.checkNotNull(this.adGroupTimesMs);
            boolean[] arr_z = (boolean[])Assertions.checkNotNull(this.playedAdGroups);
            int v8 = this.adMarkerWidth / 2;
            for(int v9 = 0; v9 < this.adGroupCount; ++v9) {
                long v10 = Util.constrainValue(arr_v[v9], 0L, this.duration);
                int v11 = ((int)(((long)this.progressBar.width()) * v10 / this.duration)) - v8;
                int v12 = this.progressBar.left;
                int v13 = Math.min(this.progressBar.width() - this.adMarkerWidth, Math.max(0, v11)) + v12;
                canvas0.drawRect(((float)v13), ((float)v1), ((float)(v13 + this.adMarkerWidth)), ((float)v2), (arr_z[v9] ? this.playedAdMarkerPaint : this.adMarkerPaint));
            }
        }
    }

    @Override  // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.updateDrawableState();
    }

    private long getPositionIncrement() {
        long v = this.keyTimeIncrement;
        if(v == 0x8000000000000001L) {
            return this.duration == 0x8000000000000001L ? 0L : this.duration / ((long)this.keyCountIncrement);
        }
        return v;
    }

    @Override  // com.google.android.exoplayer2.ui.TimeBar
    public long getPreferredUpdateDelay() {
        int v = (int)(((float)this.progressBar.width()) / this.density);
        if(v != 0) {
            return this.duration == 0L || this.duration == 0x8000000000000001L ? 0x7FFFFFFFFFFFFFFFL : this.duration / ((long)v);
        }
        return 0x7FFFFFFFFFFFFFFFL;
    }

    private String getProgressText() {
        return Util.getStringForTime(this.formatBuilder, this.formatter, this.position);
    }

    private long getScrubberPosition() {
        return this.progressBar.width() <= 0 || this.duration == 0x8000000000000001L ? 0L : ((long)this.scrubberBar.width()) * this.duration / ((long)this.progressBar.width());
    }

    public void hideScrubber() {
        this.hideScrubber(0L);
    }

    public void hideScrubber(long v) {
        if(this.scrubberScalingAnimator.isStarted()) {
            this.scrubberScalingAnimator.cancel();
        }
        this.scrubberScalingAnimator.setFloatValues(new float[]{this.scrubberScale, 0.0f});
        this.scrubberScalingAnimator.setDuration(v);
        this.scrubberScalingAnimator.start();
    }

    private boolean isInSeekBar(float f, float f1) {
        return this.seekBounds.contains(((int)f), ((int)f1));
    }

    @Override  // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable0 = this.scrubberDrawable;
        if(drawable0 != null) {
            drawable0.jumpToCurrentState();
        }
    }

    private void lambda$new$0() {
        this.stopScrubbing(false);
    }

    private void lambda$new$1(ValueAnimator valueAnimator0) {
        this.scrubberScale = (float)(((Float)valueAnimator0.getAnimatedValue()));
        this.invalidate(this.seekBounds);
    }

    @Override  // android.view.View
    public void onDraw(Canvas canvas0) {
        canvas0.save();
        this.drawTimeBar(canvas0);
        this.drawPlayhead(canvas0);
        canvas0.restore();
    }

    @Override  // android.view.View
    public void onFocusChanged(boolean z, int v, Rect rect0) {
        super.onFocusChanged(z, v, rect0);
        if(this.scrubbing && !z) {
            this.stopScrubbing(false);
        }
    }

    @Override  // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(accessibilityEvent0);
        if(accessibilityEvent0.getEventType() == 4) {
            accessibilityEvent0.getText().add(this.getProgressText());
        }
        accessibilityEvent0.setClassName("android.widget.SeekBar");
    }

    @Override  // android.view.View
    @TargetApi(21)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo0.setContentDescription(this.getProgressText());
        if(this.duration <= 0L) {
            return;
        }
        if(Util.SDK_INT >= 21) {
            accessibilityNodeInfo0.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo0.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            return;
        }
        accessibilityNodeInfo0.addAction(0x1000);
        accessibilityNodeInfo0.addAction(0x2000);
    }

    @Override  // android.view.View
    public boolean onKeyDown(int v, KeyEvent keyEvent0) {
        if(this.isEnabled()) {
            long v1 = this.getPositionIncrement();
            if(v == 66) {
            label_10:
                if(this.scrubbing) {
                    this.stopScrubbing(false);
                    return true;
                }
            }
            else {
                switch(v) {
                    case 21: {
                        v1 = -v1;
                        goto label_6;
                    }
                    case 22: {
                    label_6:
                        if(this.scrubIncrementally(v1)) {
                            this.removeCallbacks(this.stopScrubbingRunnable);
                            this.postDelayed(this.stopScrubbingRunnable, 1000L);
                            return true;
                        }
                        break;
                    }
                    case 23: {
                        goto label_10;
                    }
                    default: {
                        return super.onKeyDown(v, keyEvent0);
                    }
                }
            }
        }
        return super.onKeyDown(v, keyEvent0);
    }

    @Override  // android.view.View
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v4 = v2 - v;
        int v5 = v3 - v1;
        int v6 = (v5 - this.touchTargetHeight) / 2;
        int v7 = this.getPaddingLeft();
        int v8 = this.getPaddingRight();
        int v9 = (this.touchTargetHeight - this.barHeight) / 2 + v6;
        this.seekBounds.set(v7, v6, v4 - v8, this.touchTargetHeight + v6);
        this.progressBar.set(this.seekBounds.left + this.scrubberPadding, v9, this.seekBounds.right - this.scrubberPadding, this.barHeight + v9);
        if(Util.SDK_INT >= 29) {
            this.setSystemGestureExclusionRectsV29(v4, v5);
        }
        this.update();
    }

    @Override  // android.view.View
    public void onMeasure(int v, int v1) {
        int v2 = View.MeasureSpec.getMode(v1);
        int v3 = View.MeasureSpec.getSize(v1);
        if(v2 == 0) {
            v3 = this.touchTargetHeight;
        }
        else if(v2 != 0x40000000) {
            v3 = Math.min(this.touchTargetHeight, v3);
        }
        this.setMeasuredDimension(View.MeasureSpec.getSize(v), v3);
        this.updateDrawableState();
    }

    @Override  // android.view.View
    public void onRtlPropertiesChanged(int v) {
        if(this.scrubberDrawable != null && DefaultTimeBar.setDrawableLayoutDirection(this.scrubberDrawable, v)) {
            this.invalidate();
        }
    }

    @Override  // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        boolean z = false;
        if(this.isEnabled() && this.duration > 0L) {
            Point point0 = this.resolveRelativeTouchPosition(motionEvent0);
            int v = point0.x;
            int v1 = point0.y;
            switch(motionEvent0.getAction()) {
                case 0: {
                    if(this.isInSeekBar(((float)v), ((float)v1))) {
                        this.positionScrubber(((float)v));
                        this.startScrubbing(this.getScrubberPosition());
                        this.update();
                        this.invalidate();
                        return true;
                    }
                    break;
                }
                case 2: {
                    if(this.scrubbing) {
                        if(v1 < this.fineScrubYThreshold) {
                            this.positionScrubber(((float)((v - this.lastCoarseScrubXPosition) / 3 + this.lastCoarseScrubXPosition)));
                        }
                        else {
                            this.lastCoarseScrubXPosition = v;
                            this.positionScrubber(((float)v));
                        }
                        this.updateScrubbing(this.getScrubberPosition());
                        this.update();
                        this.invalidate();
                        return true;
                    }
                    break;
                }
                case 1: 
                case 3: {
                    if(this.scrubbing) {
                        if(motionEvent0.getAction() == 3) {
                            z = true;
                        }
                        this.stopScrubbing(z);
                        return true;
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
        }
        return false;
    }

    @Override  // android.view.View
    public boolean performAccessibilityAction(int v, Bundle bundle0) {
        if(super.performAccessibilityAction(v, bundle0)) {
            return true;
        }
        if(Long.compare(this.duration, 0L) <= 0) {
            return false;
        }
        switch(v) {
            case 0x1000: {
                if(this.scrubIncrementally(this.getPositionIncrement())) {
                    this.stopScrubbing(false);
                }
                break;
            }
            case 0x2000: {
                if(this.scrubIncrementally(-this.getPositionIncrement())) {
                    this.stopScrubbing(false);
                }
                break;
            }
            default: {
                return false;
            }
        }
        this.sendAccessibilityEvent(4);
        return true;
    }

    private void positionScrubber(float f) {
        this.scrubberBar.right = Util.constrainValue(((int)f), this.progressBar.left, this.progressBar.right);
    }

    private static int pxToDp(float f, int v) [...] // Inlined contents

    @Override  // com.google.android.exoplayer2.ui.TimeBar
    public void removeListener(OnScrubListener timeBar$OnScrubListener0) {
        this.listeners.remove(timeBar$OnScrubListener0);
    }

    private Point resolveRelativeTouchPosition(MotionEvent motionEvent0) {
        int v = (int)motionEvent0.getX();
        int v1 = (int)motionEvent0.getY();
        this.touchPosition.set(v, v1);
        return this.touchPosition;
    }

    private boolean scrubIncrementally(long v) {
        long v1 = this.duration;
        if(Long.compare(v1, 0L) <= 0) {
            return false;
        }
        long v2 = this.scrubbing ? this.scrubPosition : this.position;
        long v3 = Util.constrainValue(v2 + v, 0L, v1);
        if(v3 == v2) {
            return false;
        }
        if(this.scrubbing) {
            this.updateScrubbing(v3);
        }
        else {
            this.startScrubbing(v3);
        }
        this.update();
        return true;
    }

    @Override  // com.google.android.exoplayer2.ui.TimeBar
    public void setAdGroupTimesMs(long[] arr_v, boolean[] arr_z, int v) {
        Assertions.checkArgument(v == 0 || arr_v != null && arr_z != null);
        this.adGroupCount = v;
        this.adGroupTimesMs = arr_v;
        this.playedAdGroups = arr_z;
        this.update();
    }

    public void setAdMarkerColor(int v) {
        this.adMarkerPaint.setColor(v);
        this.invalidate(this.seekBounds);
    }

    public void setBufferedColor(int v) {
        this.bufferedPaint.setColor(v);
        this.invalidate(this.seekBounds);
    }

    @Override  // com.google.android.exoplayer2.ui.TimeBar
    public void setBufferedPosition(long v) {
        this.bufferedPosition = v;
        this.update();
    }

    private boolean setDrawableLayoutDirection(Drawable drawable0) {
        return Util.SDK_INT >= 23 && DefaultTimeBar.setDrawableLayoutDirection(drawable0, this.getLayoutDirection());
    }

    private static boolean setDrawableLayoutDirection(Drawable drawable0, int v) {
        return Util.SDK_INT >= 23 && drawable0.setLayoutDirection(v);
    }

    @Override  // com.google.android.exoplayer2.ui.TimeBar
    public void setDuration(long v) {
        this.duration = v;
        if(this.scrubbing && v == 0x8000000000000001L) {
            this.stopScrubbing(true);
        }
        this.update();
    }

    @Override  // android.view.View, com.google.android.exoplayer2.ui.TimeBar
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if(this.scrubbing && !z) {
            this.stopScrubbing(true);
        }
    }

    @Override  // com.google.android.exoplayer2.ui.TimeBar
    public void setKeyCountIncrement(int v) {
        Assertions.checkArgument(v > 0);
        this.keyCountIncrement = v;
        this.keyTimeIncrement = 0x8000000000000001L;
    }

    @Override  // com.google.android.exoplayer2.ui.TimeBar
    public void setKeyTimeIncrement(long v) {
        Assertions.checkArgument(v > 0L);
        this.keyCountIncrement = -1;
        this.keyTimeIncrement = v;
    }

    public void setPlayedAdMarkerColor(int v) {
        this.playedAdMarkerPaint.setColor(v);
        this.invalidate(this.seekBounds);
    }

    public void setPlayedColor(int v) {
        this.playedPaint.setColor(v);
        this.invalidate(this.seekBounds);
    }

    @Override  // com.google.android.exoplayer2.ui.TimeBar
    public void setPosition(long v) {
        this.position = v;
        this.setContentDescription(this.getProgressText());
        this.update();
    }

    public void setScrubberColor(int v) {
        this.scrubberPaint.setColor(v);
        this.invalidate(this.seekBounds);
    }

    private void setSystemGestureExclusionRectsV29(int v, int v1) {
        if(this.lastExclusionRectangle != null && this.lastExclusionRectangle.width() == v && this.lastExclusionRectangle.height() == v1) {
            return;
        }
        Rect rect0 = new Rect(0, 0, v, v1);
        this.lastExclusionRectangle = rect0;
        this.setSystemGestureExclusionRects(Collections.singletonList(rect0));
    }

    public void setUnplayedColor(int v) {
        this.unplayedPaint.setColor(v);
        this.invalidate(this.seekBounds);
    }

    public void showScrubber() {
        this.showScrubber(0L);
    }

    public void showScrubber(long v) {
        if(this.scrubberScalingAnimator.isStarted()) {
            this.scrubberScalingAnimator.cancel();
        }
        this.scrubberScalingAnimator.setFloatValues(new float[]{this.scrubberScale, 1.0f});
        this.scrubberScalingAnimator.setDuration(v);
        this.scrubberScalingAnimator.start();
    }

    private void startScrubbing(long v) {
        this.scrubPosition = v;
        this.scrubbing = true;
        this.setPressed(true);
        ViewParent viewParent0 = this.getParent();
        if(viewParent0 != null) {
            viewParent0.requestDisallowInterceptTouchEvent(true);
        }
        for(Object object0: this.listeners) {
            ((OnScrubListener)object0).onScrubStart(this, v);
        }
    }

    private void stopScrubbing(boolean z) {
        this.removeCallbacks(this.stopScrubbingRunnable);
        this.scrubbing = false;
        this.setPressed(false);
        ViewParent viewParent0 = this.getParent();
        if(viewParent0 != null) {
            viewParent0.requestDisallowInterceptTouchEvent(false);
        }
        this.invalidate();
        for(Object object0: this.listeners) {
            ((OnScrubListener)object0).onScrubStop(this, this.scrubPosition, z);
        }
    }

    private void update() {
        this.bufferedBar.set(this.progressBar);
        this.scrubberBar.set(this.progressBar);
        long v = this.scrubbing ? this.scrubPosition : this.position;
        if(this.duration > 0L) {
            long v1 = (long)this.progressBar.width();
            this.bufferedBar.right = Math.min(this.progressBar.left + ((int)(v1 * this.bufferedPosition / this.duration)), this.progressBar.right);
            long v2 = ((long)this.progressBar.width()) * v;
            this.scrubberBar.right = Math.min(this.progressBar.left + ((int)(v2 / this.duration)), this.progressBar.right);
        }
        else {
            this.bufferedBar.right = this.progressBar.left;
            this.scrubberBar.right = this.progressBar.left;
        }
        this.invalidate(this.seekBounds);
    }

    private void updateDrawableState() {
        if(this.scrubberDrawable != null && this.scrubberDrawable.isStateful()) {
            int[] arr_v = this.getDrawableState();
            if(this.scrubberDrawable.setState(arr_v)) {
                this.invalidate();
            }
        }
    }

    private void updateScrubbing(long v) {
        if(this.scrubPosition != v) {
            this.scrubPosition = v;
            for(Object object0: this.listeners) {
                ((OnScrubListener)object0).onScrubMove(this, v);
            }
        }
    }
}

