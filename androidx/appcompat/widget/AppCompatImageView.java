package androidx.appcompat.widget;

import Y1.b;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageView extends ImageView {
    private final v mBackgroundTintHelper;
    private boolean mHasLevel;
    private final A mImageHelper;

    public AppCompatImageView(Context context0) {
        this(context0, null);
    }

    public AppCompatImageView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public AppCompatImageView(Context context0, AttributeSet attributeSet0, int v) {
        TintContextWrapper.a(context0);
        super(context0, attributeSet0, v);
        this.mHasLevel = false;
        a1.a(this.getContext(), this);
        v v1 = new v(this);
        this.mBackgroundTintHelper = v1;
        v1.d(attributeSet0, v);
        A a0 = new A(this);
        this.mImageHelper = a0;
        a0.b(attributeSet0, v);
    }

    @Override  // android.widget.ImageView
    public void drawableStateChanged() {
        super.drawableStateChanged();
        v v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.a();
        }
        A a0 = this.mImageHelper;
        if(a0 != null) {
            a0.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.mBackgroundTintHelper == null ? null : this.mBackgroundTintHelper.b();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.mBackgroundTintHelper == null ? null : this.mBackgroundTintHelper.c();
    }

    public ColorStateList getSupportImageTintList() {
        A a0 = this.mImageHelper;
        if(a0 != null) {
            return a0.b == null ? null : ((ColorStateList)a0.b.c);
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        A a0 = this.mImageHelper;
        if(a0 != null) {
            return a0.b == null ? null : ((PorterDuff.Mode)a0.b.d);
        }
        return null;
    }

    // 去混淆评级： 低(20)
    @Override  // android.widget.ImageView
    public boolean hasOverlappingRendering() {
        return !(this.mImageHelper.a.getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override  // android.view.View
    public void setBackgroundDrawable(Drawable drawable0) {
        super.setBackgroundDrawable(drawable0);
        v v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.e();
        }
    }

    @Override  // android.view.View
    public void setBackgroundResource(int v) {
        super.setBackgroundResource(v);
        v v1 = this.mBackgroundTintHelper;
        if(v1 != null) {
            v1.f(v);
        }
    }

    @Override  // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap0) {
        super.setImageBitmap(bitmap0);
        A a0 = this.mImageHelper;
        if(a0 != null) {
            a0.a();
        }
    }

    @Override  // android.widget.ImageView
    public void setImageDrawable(Drawable drawable0) {
        A a0 = this.mImageHelper;
        if(a0 != null && drawable0 != null && !this.mHasLevel) {
            a0.c = drawable0.getLevel();
        }
        super.setImageDrawable(drawable0);
        A a1 = this.mImageHelper;
        if(a1 != null) {
            a1.a();
            if(!this.mHasLevel) {
                A a2 = this.mImageHelper;
                ImageView imageView0 = a2.a;
                if(imageView0.getDrawable() != null) {
                    imageView0.getDrawable().setLevel(a2.c);
                }
            }
        }
    }

    @Override  // android.widget.ImageView
    public void setImageLevel(int v) {
        super.setImageLevel(v);
        this.mHasLevel = true;
    }

    @Override  // android.widget.ImageView
    public void setImageResource(int v) {
        A a0 = this.mImageHelper;
        if(a0 != null) {
            a0.c(v);
        }
    }

    @Override  // android.widget.ImageView
    public void setImageURI(Uri uri0) {
        super.setImageURI(uri0);
        A a0 = this.mImageHelper;
        if(a0 != null) {
            a0.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList0) {
        v v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.h(colorStateList0);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode0) {
        v v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.i(porterDuff$Mode0);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList0) {
        A a0 = this.mImageHelper;
        if(a0 != null) {
            if(a0.b == null) {
                a0.b = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
            a0.b.c = colorStateList0;
            a0.b.b = true;
            a0.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode porterDuff$Mode0) {
        A a0 = this.mImageHelper;
        if(a0 != null) {
            if(a0.b == null) {
                a0.b = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
            a0.b.d = porterDuff$Mode0;
            a0.b.a = true;
            a0.a();
        }
    }
}

