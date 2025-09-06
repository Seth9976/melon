package com.iloen.melon.utils.template;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import java.util.ArrayList;

public class TemplateCoverDefault extends TemplateCoverBase {
    public int a;
    public boolean b;
    public static final int c;

    public TemplateCoverDefault(TemplateData templateData0) {
        super(templateData0);
        this.a = 0;
        this.b = true;
    }

    public final void a(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        int v = this.a + 1;
        this.a = v;
        if(v >= this.viewResId.size()) {
            ImageView imageView0 = (ImageView)this.templateView.findViewById(0x7F0A05E3);  // id:iv_album
            if(imageView0.getDrawable() instanceof BitmapDrawable) {
                int v1 = this.getRepresentativeColor(((BitmapDrawable)imageView0.getDrawable()).getBitmap());
                this.templateView.findViewById(0x7F0A072D).setBackgroundColor(v1);  // id:layout_mix_cover
            }
            templateImageLoader$DownloadStateListener0.onDownloadCompleted(this.templateView, this.b);
        }
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public int getLayoutResId() {
        return this.standardSizeDp > 80.0f ? 0x7F0D01B1 : 0x7F0D01B0;  // layout:cover_template_default_150
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public ArrayList getViewIds() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(0x7F0A05E3);  // id:iv_album
        return arrayList0;
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public void load(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        if(this.getImageListSize() > 0) {
            ImageView imageView0 = (ImageView)this.templateView.findViewById(((int)(((Integer)this.viewResId.get(0)))));
            Glide.with(this.context).load(this.getImageData(0)).into(new CustomTarget() {
                public final TemplateCoverDefault c;

                @Override  // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable drawable0) {
                }

                @Override  // com.bumptech.glide.request.target.CustomTarget
                public void onLoadFailed(Drawable drawable0) {
                    super.onLoadFailed(drawable0);
                    TemplateCoverDefault.this.b = false;
                    TemplateCoverDefault.this.a(templateImageLoader$DownloadStateListener0);
                }

                public void onResourceReady(Drawable drawable0, Transition transition0) {
                    imageView0.setImageDrawable(drawable0);
                    TemplateCoverDefault.this.a(templateImageLoader$DownloadStateListener0);
                }

                @Override  // com.bumptech.glide.request.target.Target
                public void onResourceReady(Object object0, Transition transition0) {
                    this.onResourceReady(((Drawable)object0), transition0);
                }
            });
            return;
        }
        this.b = false;
        this.a(templateImageLoader$DownloadStateListener0);
    }
}

