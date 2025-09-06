package com.iloen.melon.fragments.main.foru.template;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.fragments.main.foru.TemplateCoverBlurData;
import com.iloen.melon.fragments.main.foru.TemplateCoverBlurUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.template.TemplateCoverBase;
import com.iloen.melon.utils.template.TemplateData;
import com.iloen.melon.utils.template.TemplateImageLoader.DownloadStateListener;
import com.iloen.melon.utils.ui.ViewUtils;
import he.e;
import java.util.ArrayList;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class TemplateCoverForURecentRecmMix extends TemplateCoverBase {
    protected static final int STANDARD_SIZE_144_MIN = 0x90;
    private static final String TAG = "TemplateCoverForURecentRecmMix";
    private int downCnt;
    private boolean enableCache;
    private Bitmap firstThumbBitmap;

    public TemplateCoverForURecentRecmMix(TemplateData templateData0) {
        super(templateData0);
        this.downCnt = 0;
        this.enableCache = true;
    }

    public static void a(TemplateCoverForURecentRecmMix templateCoverForURecentRecmMix0) {
        templateCoverForURecentRecmMix0.enableCache = false;
    }

    public void checkDownloadCompleted(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        TextView textView1;
        if(this.getImageListSize() < this.viewResId.size()) {
            this.enableCache = false;
        }
        if(this.enableCache || this.standardSizeDp > 144.0f) {
            int v1 = this.downCnt + 1;
            this.downCnt = v1;
            if(v1 >= this.getImageListSize() || this.downCnt >= this.viewResId.size()) {
                String s = this.getTitle();
                TextView textView0 = (TextView)this.templateView.findViewById(0x7F0A0D34);  // id:tv_title
                if(!TextUtils.isEmpty(s)) {
                    ViewUtils.setText(textView0, s);
                }
                String s1 = this.getSubTitle();
                if(TextUtils.isEmpty(s1)) {
                    textView1 = null;
                }
                else {
                    textView1 = (TextView)this.templateView.findViewById(0x7F0A0D1F);  // id:tv_subtitle
                    ViewUtils.setText(textView1, s1);
                }
                if(this.enableCache) {
                    int v2 = this.getDefalutShadowColor();
                    if(this.firstThumbBitmap != null) {
                        View view0 = this.templateView.findViewById(0x7F0A06FE);  // id:layout_background
                        TemplateCoverBlurData templateCoverBlurData0 = TemplateCoverBlurUtils.getBlurredBackground(this.firstThumbBitmap);
                        view0.setBackground(new BitmapDrawable(this.context.getResources(), templateCoverBlurData0.getBgBitmap()));
                        v2 = templateCoverBlurData0.getShadowColor();
                    }
                    if(textView0 != null) {
                        textView0.setTextColor(ColorUtils.getColor(this.context, 0x7F06009F));  // color:color_fafafa
                    }
                    if(textView1 != null) {
                        textView1.setTextColor(ColorUtils.getColor(this.context, 0x7F0604A1));  // color:white000e
                    }
                    templateImageLoader$DownloadStateListener0.onDownloadCompleted(this.templateView, this.enableCache, v2);
                    return;
                }
                for(int v = 0; v < this.viewResId.size(); ++v) {
                    ViewUtils.hideWhen(this.templateView.findViewById(((int)(((Integer)this.viewResId.get(v))))), true);
                }
                templateImageLoader$DownloadStateListener0.onDownloadCompleted(this.templateView, this.enableCache, this.getDefalutShadowColor());
            }
        }
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public int getLayoutResId() {
        return this.standardSizeDp > 144.0f ? 0x7F0D01CD : 0x7F0D01CC;  // layout:cover_template_foru_recent_recm_mix_200
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public ArrayList getViewIds() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(0x7F0A05E4);  // id:iv_album1
        arrayList0.add(0x7F0A05E5);  // id:iv_album2
        arrayList0.add(0x7F0A05E6);  // id:iv_album3
        arrayList0.add(0x7F0A05E7);  // id:iv_album4
        return arrayList0;
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public void load(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        if(this.getImageListSize() > 0) {
            int v1 = this.viewResId.size();
            for(int v = 0; v < v1; ++v) {
                ImageView imageView0 = (ImageView)this.templateView.findViewById(((int)(((Integer)this.viewResId.get(v)))));
                if(imageView0 != null) {
                    int v2 = ScreenUtils.dipToPixel(this.context, 3.0f);
                    RoundedCornersTransformation.CornerType roundedCornersTransformation$CornerType0 = RoundedCornersTransformation.CornerType.BOTTOM_RIGHT;
                    if(v == 0) {
                        roundedCornersTransformation$CornerType0 = RoundedCornersTransformation.CornerType.TOP_LEFT;
                    }
                    else {
                        switch(v) {
                            case 1: {
                                roundedCornersTransformation$CornerType0 = RoundedCornersTransformation.CornerType.TOP_RIGHT;
                                break;
                            }
                            case 2: {
                                roundedCornersTransformation$CornerType0 = RoundedCornersTransformation.CornerType.BOTTOM_LEFT;
                            }
                        }
                    }
                    Glide.with(this.context).load(this.getImageData(v)).apply(new RequestOptions().transform(new e(v2, roundedCornersTransformation$CornerType0))).into(new CustomTarget() {
                        @Override  // com.bumptech.glide.request.target.Target
                        public void onLoadCleared(Drawable drawable0) {
                        }

                        @Override  // com.bumptech.glide.request.target.CustomTarget
                        public void onLoadFailed(Drawable drawable0) {
                            super.onLoadFailed(drawable0);
                            TemplateCoverForURecentRecmMix.a(TemplateCoverForURecentRecmMix.this);
                            TemplateCoverForURecentRecmMix.this.checkDownloadCompleted(templateImageLoader$DownloadStateListener0);
                        }

                        public void onResourceReady(Drawable drawable0, Transition transition0) {
                            imageView0.setImageDrawable(drawable0);
                            if(v == 0 && drawable0 instanceof BitmapDrawable) {
                                Bitmap bitmap0 = ((BitmapDrawable)drawable0).getBitmap();
                                TemplateCoverForURecentRecmMix.this.firstThumbBitmap = bitmap0;
                            }
                            TemplateCoverForURecentRecmMix.this.checkDownloadCompleted(templateImageLoader$DownloadStateListener0);
                        }

                        @Override  // com.bumptech.glide.request.target.Target
                        public void onResourceReady(Object object0, Transition transition0) {
                            this.onResourceReady(((Drawable)object0), transition0);
                        }
                    });
                }
            }
            return;
        }
        this.enableCache = false;
        this.checkDownloadCompleted(templateImageLoader$DownloadStateListener0);
    }
}

