package com.github.chrisbanes;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView.ScaleType;
import com.iloen.melon.custom.RecyclingImageView;

public class PhotoView extends RecyclingImageView {
    private PhotoViewAttacher attacher;
    private ImageView.ScaleType pendingScaleType;

    public PhotoView(Context context0) {
        this(context0, null);
    }

    public PhotoView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public PhotoView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.init();
    }

    public PhotoViewAttacher getAttacher() {
        return this.attacher;
    }

    public void getDisplayMatrix(Matrix matrix0) {
        this.attacher.getDisplayMatrix(matrix0);
    }

    public RectF getDisplayRect() {
        return this.attacher.getDisplayRect();
    }

    @Override  // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.attacher.getImageMatrix();
    }

    public float getMaximumScale() {
        return this.attacher.getMaximumScale();
    }

    public float getMediumScale() {
        return this.attacher.getMediumScale();
    }

    public float getMinimumScale() {
        return this.attacher.getMinimumScale();
    }

    public float getScale() {
        return this.attacher.getScale();
    }

    @Override  // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.attacher.getScaleType();
    }

    public void getSuppMatrix(Matrix matrix0) {
        this.attacher.getSuppMatrix(matrix0);
    }

    private void init() {
        this.attacher = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType imageView$ScaleType0 = this.pendingScaleType;
        if(imageView$ScaleType0 != null) {
            this.setScaleType(imageView$ScaleType0);
            this.pendingScaleType = null;
        }
    }

    public boolean isZoomable() {
        return this.attacher.isZoomable();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.attacher.setAllowParentInterceptOnEdge(z);
    }

    public boolean setDisplayMatrix(Matrix matrix0) {
        return this.attacher.setDisplayMatrix(matrix0);
    }

    @Override  // android.widget.ImageView
    public boolean setFrame(int v, int v1, int v2, int v3) {
        boolean z = super.setFrame(v, v1, v2, v3);
        if(z) {
            this.attacher.update();
        }
        return z;
    }

    @Override  // androidx.appcompat.widget.AppCompatImageView
    public void setImageDrawable(Drawable drawable0) {
        super.setImageDrawable(drawable0);
        PhotoViewAttacher photoViewAttacher0 = this.attacher;
        if(photoViewAttacher0 != null) {
            photoViewAttacher0.update();
        }
    }

    @Override  // androidx.appcompat.widget.AppCompatImageView
    public void setImageResource(int v) {
        super.setImageResource(v);
        PhotoViewAttacher photoViewAttacher0 = this.attacher;
        if(photoViewAttacher0 != null) {
            photoViewAttacher0.update();
        }
    }

    @Override  // androidx.appcompat.widget.AppCompatImageView
    public void setImageURI(Uri uri0) {
        super.setImageURI(uri0);
        PhotoViewAttacher photoViewAttacher0 = this.attacher;
        if(photoViewAttacher0 != null) {
            photoViewAttacher0.update();
        }
    }

    public void setMaximumScale(float f) {
        this.attacher.setMaximumScale(f);
    }

    public void setMediumScale(float f) {
        this.attacher.setMediumScale(f);
    }

    public void setMinimumScale(float f) {
        this.attacher.setMinimumScale(f);
    }

    @Override  // android.view.View
    public void setOnClickListener(View.OnClickListener view$OnClickListener0) {
        this.attacher.setOnClickListener(view$OnClickListener0);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener gestureDetector$OnDoubleTapListener0) {
        this.attacher.setOnDoubleTapListener(gestureDetector$OnDoubleTapListener0);
    }

    @Override  // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener view$OnLongClickListener0) {
        this.attacher.setOnLongClickListener(view$OnLongClickListener0);
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener0) {
        this.attacher.setOnMatrixChangeListener(onMatrixChangedListener0);
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener0) {
        this.attacher.setOnOutsidePhotoTapListener(onOutsidePhotoTapListener0);
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener0) {
        this.attacher.setOnPhotoTapListener(onPhotoTapListener0);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener0) {
        this.attacher.setOnScaleChangeListener(onScaleChangedListener0);
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener0) {
        this.attacher.setOnSingleFlingListener(onSingleFlingListener0);
    }

    public void setOnSwipeListener(OnSwipeListener onSwipeListener0) {
        this.attacher.setOnSwipeListener(onSwipeListener0);
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener0) {
        this.attacher.setOnViewDragListener(onViewDragListener0);
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener0) {
        this.attacher.setOnViewTapListener(onViewTapListener0);
    }

    public void setRotationBy(float f) {
        this.attacher.setRotationBy(f);
    }

    public void setRotationTo(float f) {
        this.attacher.setRotationTo(f);
    }

    public void setScale(float f) {
        this.attacher.setScale(f);
    }

    public void setScale(float f, float f1, float f2, boolean z) {
        this.attacher.setScale(f, f1, f2, z);
    }

    public void setScale(float f, boolean z) {
        this.attacher.setScale(f, z);
    }

    public void setScaleLevels(float f, float f1, float f2) {
        this.attacher.setScaleLevels(f, f1, f2);
    }

    @Override  // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType imageView$ScaleType0) {
        PhotoViewAttacher photoViewAttacher0 = this.attacher;
        if(photoViewAttacher0 == null) {
            this.pendingScaleType = imageView$ScaleType0;
            return;
        }
        photoViewAttacher0.setScaleType(imageView$ScaleType0);
    }

    public boolean setSuppMatrix(Matrix matrix0) {
        return this.attacher.setDisplayMatrix(matrix0);
    }

    public void setZoomTransitionDuration(int v) {
        this.attacher.setZoomTransitionDuration(v);
    }

    public void setZoomable(boolean z) {
        this.attacher.setZoomable(z);
    }
}

