package com.android.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.volley.VolleyError;

public class NetworkImageView extends AppCompatImageView {
    private int mDefaultImageId;
    private int mErrorImageId;
    private ImageContainer mImageContainer;
    private ImageLoader mImageLoader;
    private String mUrl;

    public NetworkImageView(Context context0) {
        this(context0, null);
    }

    public NetworkImageView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public NetworkImageView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @Override  // androidx.appcompat.widget.AppCompatImageView
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.invalidate();
    }

    public void loadImageIfNecessary(boolean z) {
        boolean z3;
        boolean z2;
        int v = this.getWidth();
        int v1 = this.getHeight();
        ImageView.ScaleType imageView$ScaleType0 = this.getScaleType();
        boolean z1 = true;
        if(this.getLayoutParams() == null) {
            z2 = false;
            z3 = false;
        }
        else {
            z2 = this.getLayoutParams().width == -2;
            z3 = this.getLayoutParams().height == -2;
        }
        if(!z2 || !z3) {
            z1 = false;
        }
        if(v != 0 || v1 != 0 || z1) {
            if(TextUtils.isEmpty(this.mUrl)) {
                ImageContainer imageLoader$ImageContainer0 = this.mImageContainer;
                if(imageLoader$ImageContainer0 != null) {
                    imageLoader$ImageContainer0.cancelRequest();
                    this.mImageContainer = null;
                }
                this.setDefaultImageOrNull();
                return;
            }
            boolean z4 = false;
            if(this.mImageContainer == null || this.mImageContainer.getRequestUrl() == null) {
                z4 = true;
            }
            else if(!this.mImageContainer.getRequestUrl().equals(this.mUrl)) {
                z4 = true;
                this.mImageContainer.cancelRequest();
                this.setDefaultImageOrNull();
            }
            if(z4) {
                if(z2) {
                    v = 0;
                }
                this.mImageContainer = this.mImageLoader.get(this.mUrl, new ImageListener() {
                    @Override  // com.android.volley.Response$ErrorListener
                    public void onErrorResponse(VolleyError volleyError0) {
                        if(NetworkImageView.this.mErrorImageId != 0) {
                            NetworkImageView.this.setImageResource(NetworkImageView.this.mErrorImageId);
                        }
                    }

                    // 检测为 Lambda 实现
                    @Override  // com.android.volley.toolbox.ImageLoader$ImageListener
                    public void onResponse(ImageContainer imageLoader$ImageContainer0, boolean z) [...]
                }, v, (z3 ? 0 : v1), imageView$ScaleType0);
            }
        }
    }

    @Override  // android.widget.ImageView
    public void onDetachedFromWindow() {
        ImageContainer imageLoader$ImageContainer0 = this.mImageContainer;
        if(imageLoader$ImageContainer0 != null) {
            imageLoader$ImageContainer0.cancelRequest();
            this.setImageBitmap(null);
            this.mImageContainer = null;
        }
        super.onDetachedFromWindow();
    }

    @Override  // android.view.View
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        this.loadImageIfNecessary(true);
    }

    private void setDefaultImageOrNull() {
        int v = this.mDefaultImageId;
        if(v != 0) {
            this.setImageResource(v);
            return;
        }
        this.setImageBitmap(null);
    }

    public void setDefaultImageResId(int v) {
        this.mDefaultImageId = v;
    }

    public void setErrorImageResId(int v) {
        this.mErrorImageId = v;
    }

    public void setImageUrl(String s, ImageLoader imageLoader0) {
        Threads.throwIfNotOnMainThread();
        this.mUrl = s;
        this.mImageLoader = imageLoader0;
        this.loadImageIfNecessary(false);
    }
}

