package com.github.chrisbanes;

import android.content.Context;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView.ScaleType;
import android.widget.ImageView;
import android.widget.OverScroller;

public class PhotoViewAttacher implements View.OnLayoutChangeListener, View.OnTouchListener {
    class AnimatedZoomRunnable implements Runnable {
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime;
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f, float f1, float f2, float f3) {
            this.mFocalX = f2;
            this.mFocalY = f3;
            this.mStartTime = System.currentTimeMillis();
            this.mZoomStart = f;
            this.mZoomEnd = f1;
        }

        private float interpolate() {
            return PhotoViewAttacher.this.mInterpolator.getInterpolation(Math.min(1.0f, ((float)(System.currentTimeMillis() - this.mStartTime)) * 1.0f / ((float)PhotoViewAttacher.this.mZoomDuration)));
        }

        @Override
        public void run() {
            float f = this.interpolate();
            float f1 = PhotoViewAttacher.this.getScale();
            PhotoViewAttacher.this.onGestureListener.onScale(((this.mZoomEnd - this.mZoomStart) * f + this.mZoomStart) / f1, this.mFocalX, this.mFocalY);
            if(f < 1.0f) {
                PhotoViewAttacher.this.mImageView.postOnAnimation(this);
            }
        }
    }

    class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final OverScroller mScroller;

        public FlingRunnable(Context context0) {
            this.mScroller = new OverScroller(context0);
        }

        public void cancelFling() {
            this.mScroller.forceFinished(true);
        }

        public void fling(int v, int v1, int v2, int v3) {
            int v9;
            int v8;
            int v6;
            int v5;
            RectF rectF0 = PhotoViewAttacher.this.getDisplayRect();
            if(rectF0 != null) {
                int v4 = Math.round(-rectF0.left);
                if(Float.compare(v, rectF0.width()) < 0) {
                    v5 = Math.round(rectF0.width() - ((float)v));
                    v6 = 0;
                }
                else {
                    v6 = v4;
                    v5 = v6;
                }
                int v7 = Math.round(-rectF0.top);
                if(((float)v1) < rectF0.height()) {
                    v8 = Math.round(rectF0.height() - ((float)v1));
                    v9 = 0;
                }
                else {
                    v9 = v7;
                    v8 = v9;
                }
                this.mCurrentX = v4;
                this.mCurrentY = v7;
                if(v4 != v5 || v7 != v8) {
                    this.mScroller.fling(v4, v7, v2, v3, v6, v5, v9, v8, 0, 0);
                }
            }
        }

        @Override
        public void run() {
            if(!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int v = this.mScroller.getCurrX();
                int v1 = this.mScroller.getCurrY();
                PhotoViewAttacher.this.mSuppMatrix.postTranslate(((float)(this.mCurrentX - v)), ((float)(this.mCurrentY - v1)));
                PhotoViewAttacher.this.checkAndDisplayMatrix();
                this.mCurrentX = v;
                this.mCurrentY = v1;
                PhotoViewAttacher.this.mImageView.postOnAnimation(this);
            }
        }
    }

    private static float DEFAULT_MAX_SCALE = 8.0f;
    private static float DEFAULT_MID_SCALE = 1.75f;
    private static float DEFAULT_MIN_SCALE = 1.0f;
    private static int DEFAULT_ZOOM_DURATION = 200;
    private static final int HORIZONTAL_EDGE_BOTH = 2;
    private static final int HORIZONTAL_EDGE_LEFT = 0;
    private static final int HORIZONTAL_EDGE_NONE = -1;
    private static final int HORIZONTAL_EDGE_RIGHT = 1;
    private static int SINGLE_TOUCH = 1;
    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;
    private static final int VERTICAL_EDGE_BOTH = 2;
    private static final int VERTICAL_EDGE_BOTTOM = 1;
    private static final int VERTICAL_EDGE_NONE = -1;
    private static final int VERTICAL_EDGE_TOP;
    private boolean mAllowParentInterceptOnEdge;
    private final Matrix mBaseMatrix;
    private float mBaseRotation;
    private boolean mBlockParentIntercept;
    private FlingRunnable mCurrentFlingRunnable;
    private final RectF mDisplayRect;
    private final Matrix mDrawMatrix;
    private GestureDetector mGestureDetector;
    private int mHorizontalScrollEdge;
    private ImageView mImageView;
    private Interpolator mInterpolator;
    private View.OnLongClickListener mLongClickListener;
    private OnMatrixChangedListener mMatrixChangeListener;
    private final float[] mMatrixValues;
    private float mMaxScale;
    private float mMidScale;
    private float mMinScale;
    private View.OnClickListener mOnClickListener;
    private OnViewDragListener mOnViewDragListener;
    private OnOutsidePhotoTapListener mOutsidePhotoTapListener;
    private OnPhotoTapListener mPhotoTapListener;
    private OnScaleChangedListener mScaleChangeListener;
    private CustomGestureDetector mScaleDragDetector;
    private ImageView.ScaleType mScaleType;
    private OnSingleFlingListener mSingleFlingListener;
    private final Matrix mSuppMatrix;
    private OnSwipeListener mSwipeListener;
    private int mVerticalScrollEdge;
    private OnViewTapListener mViewTapListener;
    private int mZoomDuration;
    private boolean mZoomEnabled;
    private OnGestureListener onGestureListener;

    public PhotoViewAttacher(ImageView imageView0) {
        this.mInterpolator = new AccelerateDecelerateInterpolator();
        this.mZoomDuration = PhotoViewAttacher.DEFAULT_ZOOM_DURATION;
        this.mMinScale = 1.0f;
        this.mMidScale = PhotoViewAttacher.DEFAULT_MID_SCALE;
        this.mMaxScale = PhotoViewAttacher.DEFAULT_MAX_SCALE;
        this.mAllowParentInterceptOnEdge = true;
        this.mBlockParentIntercept = false;
        this.mBaseMatrix = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mDisplayRect = new RectF();
        this.mMatrixValues = new float[9];
        this.mHorizontalScrollEdge = 2;
        this.mVerticalScrollEdge = 2;
        this.mZoomEnabled = true;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.onGestureListener = new OnGestureListener() {
            @Override  // com.github.chrisbanes.OnGestureListener
            public void onDrag(float f, float f1) {
                if(!PhotoViewAttacher.this.mScaleDragDetector.isScaling()) {
                    if(PhotoViewAttacher.this.mOnViewDragListener != null) {
                        PhotoViewAttacher.this.mOnViewDragListener.onDrag(f, f1);
                    }
                    PhotoViewAttacher.this.mSuppMatrix.postTranslate(f, f1);
                    PhotoViewAttacher.this.checkAndDisplayMatrix();
                    ViewParent viewParent0 = PhotoViewAttacher.this.mImageView.getParent();
                    if(PhotoViewAttacher.this.mAllowParentInterceptOnEdge && !PhotoViewAttacher.this.mScaleDragDetector.isScaling() && !PhotoViewAttacher.this.mBlockParentIntercept) {
                        if((PhotoViewAttacher.this.mHorizontalScrollEdge == 2 || PhotoViewAttacher.this.mHorizontalScrollEdge == 0 && f >= 1.0f || PhotoViewAttacher.this.mHorizontalScrollEdge == 1 && f <= -1.0f || PhotoViewAttacher.this.mVerticalScrollEdge == 0 && f1 >= 1.0f || PhotoViewAttacher.this.mVerticalScrollEdge == 1 && f1 <= -1.0f) && viewParent0 != null) {
                            viewParent0.requestDisallowInterceptTouchEvent(false);
                        }
                    }
                    else if(viewParent0 != null) {
                        viewParent0.requestDisallowInterceptTouchEvent(true);
                    }
                }
            }

            @Override  // com.github.chrisbanes.OnGestureListener
            public void onFling(float f, float f1, float f2, float f3) {
                Context context0 = PhotoViewAttacher.this.mImageView.getContext();
                FlingRunnable photoViewAttacher$FlingRunnable0 = new FlingRunnable(PhotoViewAttacher.this, context0);
                PhotoViewAttacher.this.mCurrentFlingRunnable = photoViewAttacher$FlingRunnable0;
                int v = PhotoViewAttacher.this.getImageViewWidth(PhotoViewAttacher.this.mImageView);
                int v1 = PhotoViewAttacher.this.getImageViewHeight(PhotoViewAttacher.this.mImageView);
                PhotoViewAttacher.this.mCurrentFlingRunnable.fling(v, v1, ((int)f2), ((int)f3));
                PhotoViewAttacher.this.mImageView.post(PhotoViewAttacher.this.mCurrentFlingRunnable);
            }

            @Override  // com.github.chrisbanes.OnGestureListener
            public void onScale(float f, float f1, float f2) {
                if(PhotoViewAttacher.this.getScale() >= PhotoViewAttacher.this.mMaxScale && f >= 1.0f) {
                    return;
                }
                if(PhotoViewAttacher.this.mScaleChangeListener != null) {
                    PhotoViewAttacher.this.mScaleChangeListener.onScaleChange(f, f1, f2);
                }
                PhotoViewAttacher.this.mSuppMatrix.postScale(f, f, f1, f2);
                PhotoViewAttacher.this.checkAndDisplayMatrix();
            }
        };
        this.mImageView = imageView0;
        imageView0.setOnTouchListener(this);
        imageView0.addOnLayoutChangeListener(this);
        if(imageView0.isInEditMode()) {
            return;
        }
        this.mBaseRotation = 0.0f;
        this.mScaleDragDetector = new CustomGestureDetector(imageView0.getContext(), this.onGestureListener);
        GestureDetector gestureDetector0 = new GestureDetector(imageView0.getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override  // android.view.GestureDetector$SimpleOnGestureListener
            public boolean onFling(MotionEvent motionEvent0, MotionEvent motionEvent1, float f, float f1) {
                if(motionEvent0 != null && motionEvent1 != null) {
                    if(PhotoViewAttacher.q(PhotoViewAttacher.this) != null && PhotoViewAttacher.this.getScale() == 1.0f) {
                        try {
                            float f2 = motionEvent1.getY();
                            float f3 = motionEvent0.getY();
                            float f4 = motionEvent1.getX() - motionEvent0.getX();
                            if(Math.abs(f4) > Math.abs(f2 - f3) && Math.abs(f4) > 100.0f && Math.abs(f) > 100.0f) {
                                if(f4 > 0.0f) {
                                    PhotoViewAttacher.q(PhotoViewAttacher.this).onSwipeRight();
                                    return true;
                                }
                                PhotoViewAttacher.q(PhotoViewAttacher.this).onSwipeLeft();
                                return true;
                            }
                        }
                        catch(Exception unused_ex) {
                        }
                    }
                    if(PhotoViewAttacher.o(PhotoViewAttacher.this) == null || PhotoViewAttacher.this.getScale() > 1.0f) {
                        return false;
                    }
                    return motionEvent0.getPointerCount() > 1 || motionEvent1.getPointerCount() > 1 ? false : PhotoViewAttacher.o(PhotoViewAttacher.this).onFling(motionEvent0, motionEvent1, f, f1);
                }
                return false;
            }

            @Override  // android.view.GestureDetector$SimpleOnGestureListener
            public void onLongPress(MotionEvent motionEvent0) {
                if(PhotoViewAttacher.g(PhotoViewAttacher.this) != null) {
                    PhotoViewAttacher.g(PhotoViewAttacher.this).onLongClick(PhotoViewAttacher.e(PhotoViewAttacher.this));
                }
            }
        });
        this.mGestureDetector = gestureDetector0;
        gestureDetector0.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
            @Override  // android.view.GestureDetector$OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent0) {
                if(motionEvent0 == null) {
                    return false;
                }
                try {
                    float f = PhotoViewAttacher.this.getScale();
                    float f1 = motionEvent0.getX();
                    float f2 = motionEvent0.getY();
                    if(f < PhotoViewAttacher.this.getMediumScale()) {
                        PhotoViewAttacher.this.setScale(PhotoViewAttacher.this.getMediumScale(), f1, f2, true);
                        return true;
                    }
                    if(f >= PhotoViewAttacher.this.getMediumScale() && f < PhotoViewAttacher.this.getMaximumScale()) {
                        PhotoViewAttacher.this.setScale(PhotoViewAttacher.this.getMaximumScale(), f1, f2, true);
                        return true;
                    }
                    PhotoViewAttacher.this.setScale(PhotoViewAttacher.this.getMinimumScale(), f1, f2, true);
                }
                catch(ArrayIndexOutOfBoundsException unused_ex) {
                }
                return true;
            }

            @Override  // android.view.GestureDetector$OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent0) {
                return false;
            }

            @Override  // android.view.GestureDetector$OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent0) {
                if(motionEvent0 == null) {
                    return false;
                }
                if(PhotoViewAttacher.i(PhotoViewAttacher.this) != null) {
                    PhotoViewAttacher.i(PhotoViewAttacher.this).onClick(PhotoViewAttacher.e(PhotoViewAttacher.this));
                }
                RectF rectF0 = PhotoViewAttacher.this.getDisplayRect();
                float f = motionEvent0.getX();
                float f1 = motionEvent0.getY();
                if(PhotoViewAttacher.s(PhotoViewAttacher.this) != null) {
                    PhotoViewAttacher.s(PhotoViewAttacher.this).onViewTap(PhotoViewAttacher.e(PhotoViewAttacher.this), f, f1);
                }
                if(rectF0 != null) {
                    if(rectF0.contains(f, f1)) {
                        float f2 = f - rectF0.left;
                        float f3 = rectF0.width();
                        float f4 = f1 - rectF0.top;
                        float f5 = rectF0.height();
                        if(PhotoViewAttacher.l(PhotoViewAttacher.this) != null) {
                            PhotoViewAttacher.l(PhotoViewAttacher.this).onPhotoTap(PhotoViewAttacher.e(PhotoViewAttacher.this), f2 / f3, f4 / f5);
                        }
                        return true;
                    }
                    if(PhotoViewAttacher.k(PhotoViewAttacher.this) != null) {
                        PhotoViewAttacher.k(PhotoViewAttacher.this).onOutsidePhotoTap(PhotoViewAttacher.e(PhotoViewAttacher.this));
                    }
                }
                return false;
            }
        });
    }

    public static int A() [...] // 潜在的解密器

    private void cancelFling() {
        FlingRunnable photoViewAttacher$FlingRunnable0 = this.mCurrentFlingRunnable;
        if(photoViewAttacher$FlingRunnable0 != null) {
            photoViewAttacher$FlingRunnable0.cancelFling();
            this.mCurrentFlingRunnable = null;
        }
    }

    private void checkAndDisplayMatrix() {
        if(this.checkMatrixBounds()) {
            this.setImageViewMatrix(this.getDrawMatrix());
        }
    }

    private boolean checkMatrixBounds() {
        float f4;
        RectF rectF0 = this.getDisplayRect(this.getDrawMatrix());
        if(rectF0 == null) {
            return false;
        }
        float f = rectF0.height();
        float f1 = rectF0.width();
        float f2 = (float)this.getImageViewHeight(this.mImageView);
        float f3 = 0.0f;
        if(Float.compare(f, f2) <= 0) {
            switch(com.github.chrisbanes.PhotoViewAttacher.4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                case 3: {
                    f4 = -rectF0.top;
                    break;
                }
                case 4: {
                    f4 = f2 - f - rectF0.top;
                    break;
                }
                default: {
                    f4 = (f2 - f) / 2.0f - rectF0.top;
                }
            }
            this.mVerticalScrollEdge = 2;
        }
        else {
            float f5 = rectF0.top;
            if(f5 > 0.0f) {
                this.mVerticalScrollEdge = 0;
                f4 = -f5;
            }
            else {
                float f6 = rectF0.bottom;
                if(f6 < f2) {
                    this.mVerticalScrollEdge = 1;
                    f4 = f2 - f6;
                }
                else {
                    this.mVerticalScrollEdge = -1;
                    f4 = 0.0f;
                }
            }
        }
        float f7 = (float)this.getImageViewWidth(this.mImageView);
        if(f1 <= f7) {
            switch(com.github.chrisbanes.PhotoViewAttacher.4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                case 3: {
                    f3 = -rectF0.left;
                    break;
                }
                case 4: {
                    f3 = f7 - f1 - rectF0.left;
                    break;
                }
                default: {
                    f3 = (f7 - f1) / 2.0f - rectF0.left;
                }
            }
            this.mHorizontalScrollEdge = 2;
        }
        else {
            float f8 = rectF0.left;
            if(f8 > 0.0f) {
                this.mHorizontalScrollEdge = 0;
                f3 = -f8;
            }
            else {
                float f9 = rectF0.right;
                if(f9 < f7) {
                    f3 = f7 - f9;
                    this.mHorizontalScrollEdge = 1;
                }
                else {
                    this.mHorizontalScrollEdge = -1;
                }
            }
        }
        this.mSuppMatrix.postTranslate(f3, f4);
        return true;
    }

    private static void checkZoomLevels(float f, float f1, float f2) {
        if(f >= f1) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if(f1 >= f2) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    public static View.OnLongClickListener g(PhotoViewAttacher photoViewAttacher0) {
        return photoViewAttacher0.mLongClickListener;
    }

    public void getDisplayMatrix(Matrix matrix0) {
        matrix0.set(this.getDrawMatrix());
    }

    private RectF getDisplayRect(Matrix matrix0) {
        Drawable drawable0 = this.mImageView.getDrawable();
        if(drawable0 != null) {
            float f = (float)drawable0.getIntrinsicWidth();
            float f1 = (float)drawable0.getIntrinsicHeight();
            this.mDisplayRect.set(0.0f, 0.0f, f, f1);
            matrix0.mapRect(this.mDisplayRect);
            return this.mDisplayRect;
        }
        return null;
    }

    public RectF getDisplayRect() {
        this.checkMatrixBounds();
        return this.getDisplayRect(this.getDrawMatrix());
    }

    private Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.mBaseMatrix);
        this.mDrawMatrix.postConcat(this.mSuppMatrix);
        return this.mDrawMatrix;
    }

    public Matrix getImageMatrix() {
        return this.mDrawMatrix;
    }

    private int getImageViewHeight(ImageView imageView0) {
        return imageView0.getHeight() - imageView0.getPaddingTop() - imageView0.getPaddingBottom();
    }

    private int getImageViewWidth(ImageView imageView0) {
        return imageView0.getWidth() - imageView0.getPaddingLeft() - imageView0.getPaddingRight();
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getMediumScale() {
        return this.mMidScale;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getScale() {
        return (float)Math.sqrt(((float)Math.pow(this.getValue(this.mSuppMatrix, 0), 2.0)) + ((float)Math.pow(this.getValue(this.mSuppMatrix, 3), 2.0)));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void getSuppMatrix(Matrix matrix0) {
        matrix0.set(this.mSuppMatrix);
    }

    private float getValue(Matrix matrix0, int v) {
        matrix0.getValues(this.mMatrixValues);
        return this.mMatrixValues[v];
    }

    private static boolean hasDrawable(View view0) {
        return view0 instanceof ImageView && ((ImageView)view0).getDrawable() != null;
    }

    public static View.OnClickListener i(PhotoViewAttacher photoViewAttacher0) {
        return photoViewAttacher0.mOnClickListener;
    }

    private static boolean isSupportedScaleType(ImageView.ScaleType imageView$ScaleType0) {
        if(imageView$ScaleType0 == null) {
            return false;
        }
        if(com.github.chrisbanes.PhotoViewAttacher.4.$SwitchMap$android$widget$ImageView$ScaleType[imageView$ScaleType0.ordinal()] == 1) {
            throw new IllegalStateException("Matrix scale type is not supported");
        }
        return true;
    }

    @Deprecated
    public boolean isZoomEnabled() {
        return this.mZoomEnabled;
    }

    public boolean isZoomable() {
        return this.mZoomEnabled;
    }

    public static OnOutsidePhotoTapListener k(PhotoViewAttacher photoViewAttacher0) {
        return photoViewAttacher0.mOutsidePhotoTapListener;
    }

    public static OnPhotoTapListener l(PhotoViewAttacher photoViewAttacher0) {
        return photoViewAttacher0.mPhotoTapListener;
    }

    public static OnSingleFlingListener o(PhotoViewAttacher photoViewAttacher0) {
        return photoViewAttacher0.mSingleFlingListener;
    }

    @Override  // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view0, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
        if(v == v4 && v1 == v5 && v2 == v6 && v3 == v7) {
            return;
        }
        this.updateBaseMatrix(this.mImageView.getDrawable());
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View view0, MotionEvent motionEvent0) {
        boolean z1;
        boolean z = false;
        if(this.mZoomEnabled && PhotoViewAttacher.hasDrawable(view0)) {
            int v = motionEvent0.getAction();
            switch(v) {
                case 0: {
                    ViewParent viewParent0 = view0.getParent();
                    if(viewParent0 != null) {
                        viewParent0.requestDisallowInterceptTouchEvent(true);
                    }
                    this.cancelFling();
                    z1 = false;
                    break;
                }
                case 1: {
                label_13:
                    if(this.getScale() < this.mMinScale) {
                        RectF rectF0 = this.getDisplayRect();
                        if(rectF0 == null) {
                            z1 = false;
                        }
                        else {
                            view0.post(new AnimatedZoomRunnable(this, this.getScale(), this.mMinScale, rectF0.centerX(), rectF0.centerY()));
                            z1 = true;
                        }
                    }
                    else if(this.getScale() > this.mMaxScale) {
                        RectF rectF1 = this.getDisplayRect();
                        if(rectF1 == null) {
                            z1 = false;
                        }
                        else {
                            view0.post(new AnimatedZoomRunnable(this, this.getScale(), this.mMaxScale, rectF1.centerX(), rectF1.centerY()));
                            z1 = true;
                        }
                    }
                    else {
                        z1 = false;
                    }
                    break;
                }
                default: {
                    if(v == 3) {
                        goto label_13;
                    }
                    else {
                        z1 = false;
                    }
                }
            }
            CustomGestureDetector customGestureDetector0 = this.mScaleDragDetector;
            if(customGestureDetector0 != null) {
                boolean z2 = customGestureDetector0.isScaling();
                boolean z3 = this.mScaleDragDetector.isDragging();
                boolean z4 = this.mScaleDragDetector.onTouchEvent(motionEvent0);
                if(!z2 && !this.mScaleDragDetector.isScaling() && (!z3 && !this.mScaleDragDetector.isDragging())) {
                    z = true;
                }
                this.mBlockParentIntercept = z;
                z1 = z4;
            }
            return this.mGestureDetector == null || !this.mGestureDetector.onTouchEvent(motionEvent0) ? z1 : true;
        }
        return false;
    }

    public static OnSwipeListener q(PhotoViewAttacher photoViewAttacher0) {
        return photoViewAttacher0.mSwipeListener;
    }

    private void resetMatrix() {
        this.mSuppMatrix.reset();
        this.setRotationBy(this.mBaseRotation);
        this.setImageViewMatrix(this.getDrawMatrix());
        this.checkMatrixBounds();
    }

    public static OnViewTapListener s(PhotoViewAttacher photoViewAttacher0) {
        return photoViewAttacher0.mViewTapListener;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.mAllowParentInterceptOnEdge = z;
    }

    public void setBaseRotation(float f) {
        this.mBaseRotation = f % 360.0f;
        this.update();
        this.setRotationBy(this.mBaseRotation);
        this.checkAndDisplayMatrix();
    }

    public boolean setDisplayMatrix(Matrix matrix0) {
        if(matrix0 == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        if(this.mImageView.getDrawable() == null) {
            return false;
        }
        this.mSuppMatrix.set(matrix0);
        this.checkAndDisplayMatrix();
        return true;
    }

    private void setImageViewMatrix(Matrix matrix0) {
        this.mImageView.setImageMatrix(matrix0);
        if(this.mMatrixChangeListener != null) {
            RectF rectF0 = this.getDisplayRect(matrix0);
            if(rectF0 != null) {
                this.mMatrixChangeListener.onMatrixChanged(rectF0);
            }
        }
    }

    public void setMaximumScale(float f) {
        PhotoViewAttacher.checkZoomLevels(this.mMinScale, this.mMidScale, f);
        this.mMaxScale = f;
    }

    public void setMediumScale(float f) {
        PhotoViewAttacher.checkZoomLevels(this.mMinScale, f, this.mMaxScale);
        this.mMidScale = f;
    }

    public void setMinimumScale(float f) {
        PhotoViewAttacher.checkZoomLevels(f, this.mMidScale, this.mMaxScale);
        this.mMinScale = f;
    }

    public void setOnClickListener(View.OnClickListener view$OnClickListener0) {
        this.mOnClickListener = view$OnClickListener0;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener gestureDetector$OnDoubleTapListener0) {
        this.mGestureDetector.setOnDoubleTapListener(gestureDetector$OnDoubleTapListener0);
    }

    public void setOnLongClickListener(View.OnLongClickListener view$OnLongClickListener0) {
        this.mLongClickListener = view$OnLongClickListener0;
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener0) {
        this.mMatrixChangeListener = onMatrixChangedListener0;
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener0) {
        this.mOutsidePhotoTapListener = onOutsidePhotoTapListener0;
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener0) {
        this.mPhotoTapListener = onPhotoTapListener0;
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener0) {
        this.mScaleChangeListener = onScaleChangedListener0;
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener0) {
        this.mSingleFlingListener = onSingleFlingListener0;
    }

    public void setOnSwipeListener(OnSwipeListener onSwipeListener0) {
        this.mSwipeListener = onSwipeListener0;
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener0) {
        this.mOnViewDragListener = onViewDragListener0;
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener0) {
        this.mViewTapListener = onViewTapListener0;
    }

    public void setRotationBy(float f) {
        this.mSuppMatrix.postRotate(f % 360.0f);
        this.checkAndDisplayMatrix();
    }

    public void setRotationTo(float f) {
        this.mSuppMatrix.setRotate(f % 360.0f);
        this.checkAndDisplayMatrix();
    }

    public void setScale(float f) {
        this.setScale(f, false);
    }

    public void setScale(float f, float f1, float f2, boolean z) {
        if(f < this.mMinScale || f > this.mMaxScale) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if(z) {
            this.mImageView.post(new AnimatedZoomRunnable(this, this.getScale(), f, f1, f2));
            return;
        }
        this.mSuppMatrix.setScale(f, f, f1, f2);
        this.checkAndDisplayMatrix();
    }

    public void setScale(float f, boolean z) {
        this.setScale(f, ((float)(this.mImageView.getRight() / 2)), ((float)(this.mImageView.getBottom() / 2)), z);
    }

    public void setScaleLevels(float f, float f1, float f2) {
        PhotoViewAttacher.checkZoomLevels(f, f1, f2);
        this.mMinScale = f;
        this.mMidScale = f1;
        this.mMaxScale = f2;
    }

    public void setScaleType(ImageView.ScaleType imageView$ScaleType0) {
        if(PhotoViewAttacher.isSupportedScaleType(imageView$ScaleType0) && imageView$ScaleType0 != this.mScaleType) {
            this.mScaleType = imageView$ScaleType0;
            this.update();
        }
    }

    public void setZoomInterpolator(Interpolator interpolator0) {
        this.mInterpolator = interpolator0;
    }

    public void setZoomTransitionDuration(int v) {
        this.mZoomDuration = v;
    }

    public void setZoomable(boolean z) {
        this.mZoomEnabled = z;
        this.update();
    }

    public void update() {
        if(this.mZoomEnabled) {
            this.updateBaseMatrix(this.mImageView.getDrawable());
            return;
        }
        this.resetMatrix();
    }

    private void updateBaseMatrix(Drawable drawable0) {
        if(drawable0 == null) {
            return;
        }
        float f = (float)this.getImageViewWidth(this.mImageView);
        float f1 = (float)this.getImageViewHeight(this.mImageView);
        int v = drawable0.getIntrinsicWidth();
        int v1 = drawable0.getIntrinsicHeight();
        this.mBaseMatrix.reset();
        float f2 = f / ((float)v);
        float f3 = f1 / ((float)v1);
        ImageView.ScaleType imageView$ScaleType0 = this.mScaleType;
        if(imageView$ScaleType0 == ImageView.ScaleType.CENTER) {
            this.mBaseMatrix.postTranslate((f - ((float)v)) / 2.0f, (f1 - ((float)v1)) / 2.0f);
        }
        else if(imageView$ScaleType0 == ImageView.ScaleType.CENTER_CROP) {
            float f4 = Math.max(f2, f3);
            this.mBaseMatrix.postScale(f4, f4);
            this.mBaseMatrix.postTranslate((f - ((float)v) * f4) / 2.0f, (f1 - ((float)v1) * f4) / 2.0f);
        }
        else if(imageView$ScaleType0 == ImageView.ScaleType.CENTER_INSIDE) {
            float f5 = Math.min(1.0f, Math.min(f2, f3));
            this.mBaseMatrix.postScale(f5, f5);
            this.mBaseMatrix.postTranslate((f - ((float)v) * f5) / 2.0f, (f1 - ((float)v1) * f5) / 2.0f);
        }
        else {
            RectF rectF0 = new RectF(0.0f, 0.0f, ((float)v), ((float)v1));
            RectF rectF1 = new RectF(0.0f, 0.0f, f, f1);
            if(((int)this.mBaseRotation) % 180 != 0) {
                rectF0 = new RectF(0.0f, 0.0f, ((float)v1), ((float)v));
            }
            switch(com.github.chrisbanes.PhotoViewAttacher.4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                case 2: {
                    this.mBaseMatrix.setRectToRect(rectF0, rectF1, Matrix.ScaleToFit.CENTER);
                    break;
                }
                case 3: {
                    this.mBaseMatrix.setRectToRect(rectF0, rectF1, Matrix.ScaleToFit.START);
                    break;
                }
                case 4: {
                    this.mBaseMatrix.setRectToRect(rectF0, rectF1, Matrix.ScaleToFit.END);
                    break;
                }
                case 5: {
                    this.mBaseMatrix.setRectToRect(rectF0, rectF1, Matrix.ScaleToFit.FILL);
                }
            }
        }
        this.resetMatrix();
    }

    public static float z() [...] // 潜在的解密器

    class com.github.chrisbanes.PhotoViewAttacher.4 {
        static final int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] arr_v = new int[ImageView.ScaleType.values().length];
            com.github.chrisbanes.PhotoViewAttacher.4.$SwitchMap$android$widget$ImageView$ScaleType = arr_v;
            try {
                arr_v[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.github.chrisbanes.PhotoViewAttacher.4.$SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.github.chrisbanes.PhotoViewAttacher.4.$SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.github.chrisbanes.PhotoViewAttacher.4.$SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.github.chrisbanes.PhotoViewAttacher.4.$SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

