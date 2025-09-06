package com.iloen.melon.custom.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.iloen.melon.utils.ui.ViewUtils;

public class ProfileImageView extends RelativeLayout {
    public ImageView a;
    public ImageView b;

    public ProfileImageView(Context context0) {
        super(context0, null);
        this.a();
    }

    public ProfileImageView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a();
    }

    public final void a() {
        LayoutInflater.from(this.getContext()).inflate(0x7F0D05C1, this);  // layout:profile_image_view
        this.a = (ImageView)this.findViewById(0x7F0A05D7);  // id:ivBackground
        this.b = (ImageView)this.findViewById(0x7F0A05DD);  // id:ivThumb
    }

    public ImageView getImageView() {
        return this.b;
    }

    @Override  // android.view.View
    public void setAlpha(float f) {
        ImageView imageView0 = this.b;
        if(imageView0 != null) {
            imageView0.setAlpha(f);
        }
        ImageView imageView1 = this.a;
        if(imageView1 != null) {
            imageView1.setAlpha(f);
        }
    }

    public void setDefaultImg(int v) {
        ViewUtils.setDefaultImage(this.a, v, true);
    }
}

