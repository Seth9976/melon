package com.iloen.melon.fragments.main.foru.template;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.template.TemplateCoverBase;
import com.iloen.melon.utils.template.TemplateData;
import com.iloen.melon.utils.template.TemplateImageLoader.DownloadStateListener;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;

public class TemplateCoverForUArtist extends TemplateCoverBase {
    protected static final int STANDARD_SIZE_144_MIN = 0x90;
    private static final String TAG = "TemplateCoverForUArtist";
    int downCnt;
    private boolean enableCache;

    public TemplateCoverForUArtist(TemplateData templateData0) {
        super(templateData0);
        this.downCnt = 0;
        this.enableCache = true;
    }

    public static void a(TemplateCoverForUArtist templateCoverForUArtist0) {
        templateCoverForUArtist0.enableCache = false;
    }

    public void checkDownloadCompleted(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        if(this.getImageListSize() < this.viewResId.size()) {
            this.enableCache = false;
        }
        int v = this.downCnt + 1;
        this.downCnt = v;
        if(v < this.getImageListSize() && this.downCnt < this.viewResId.size()) {
            return;
        }
        TextView textView0 = (TextView)this.templateView.findViewById(0x7F0A0C12);  // id:tv_artist
        String s = this.getTitle();
        if(!TextUtils.isEmpty(s)) {
            ViewUtils.setText(textView0, s);
        }
        if(((ImageView)this.templateView.findViewById(0x7F0A0617)).getDrawable() != null) {  // id:iv_cover
            templateImageLoader$DownloadStateListener0.onDownloadCompleted(this.templateView, this.enableCache);
            return;
        }
        FrameLayout frameLayout0 = (FrameLayout)LayoutInflater.from(this.context).inflate(0x7F0D01B7, null, false);  // layout:cover_template_foru_artist_noimage
        int v1 = ScreenUtils.dipToPixel(this.context, this.standardSizeDp);
        frameLayout0.findViewById(0x7F0A0732).setLayoutParams(new FrameLayout.LayoutParams(v1, v1));  // id:layout_no_image_view
        int v2 = this.getNoImageViewSize();
        ImageView imageView0 = (ImageView)frameLayout0.findViewById(0x7F0A08B9);  // id:no_image_view
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = imageView0.getLayoutParams();
        viewGroup$LayoutParams0.width = v2;
        viewGroup$LayoutParams0.height = v2;
        imageView0.setLayoutParams(viewGroup$LayoutParams0);
        imageView0.setImageResource(this.getNoImageResId());
        templateImageLoader$DownloadStateListener0.onDownloadCompleted(frameLayout0, false, this.getDefalutShadowColor());
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public int getLayoutResId() {
        String s = this.getSubType();
        if("31".equals(s)) {
            return 0x7F0D01B2;  // layout:cover_template_foru_artist_basic_200
        }
        if("32".equals(s)) {
            return 0x7F0D01B3;  // layout:cover_template_foru_artist_hidden_track_200
        }
        if("33".equals(s)) {
            return 0x7F0D01B6;  // layout:cover_template_foru_artist_mood_200
        }
        return this.standardSizeDp > 144.0f ? 0x7F0D01B5 : 0x7F0D01B4;  // layout:cover_template_foru_artist_legacy_200
    }

    private int getNoImageResId() {
        float f = this.standardSizeDp;
        if(f >= 112.0f) {
            return 0x7F080798;  // drawable:noimage_man_big
        }
        if(f >= 65.0f) {
            return 0x7F080799;  // drawable:noimage_man_medium
        }
        return f >= 48.0f ? 0x7F08079C : 0x7F08079A;  // drawable:noimage_man_small
    }

    private int getNoImageViewSize() {
        float f = this.standardSizeDp;
        if(f >= 112.0f) {
            return ScreenUtils.dipToPixel(this.context, 59.0f);
        }
        if(f >= 65.0f) {
            return ScreenUtils.dipToPixel(this.context, 43.0f);
        }
        return f >= 48.0f ? ScreenUtils.dipToPixel(this.context, 33.0f) : ScreenUtils.dipToPixel(this.context, 27.0f);
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public ArrayList getViewIds() {
        ArrayList arrayList0 = new ArrayList();
        if("33".equals(this.getSubType())) {
            arrayList0.add(0x7F0A0617);  // id:iv_cover
            arrayList0.add(0x7F0A05F3);  // id:iv_artist1
            arrayList0.add(0x7F0A05F4);  // id:iv_artist2
            return arrayList0;
        }
        arrayList0.add(0x7F0A0617);  // id:iv_cover
        arrayList0.add(0x7F0A05F3);  // id:iv_artist1
        return arrayList0;
    }

    @Override  // com.iloen.melon.utils.template.TemplateCoverBase
    public void load(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        if(this.getImageListSize() > 0) {
            int v1 = this.viewResId.size();
            for(int v = 0; v < v1; ++v) {
                ImageView imageView0 = (ImageView)this.templateView.findViewById(((int)(((Integer)this.viewResId.get(v)))));
                if(imageView0 != null) {
                    RequestBuilder requestBuilder0 = Glide.with(this.context).load(this.getImageData(v));
                    if("33".equals(this.getSubType())) {
                        switch(imageView0.getId()) {
                            case 0x7F0A05F3:   // id:iv_artist1
                            case 0x7F0A05F4: {  // id:iv_artist2
                                requestBuilder0.apply(RequestOptions.circleCropTransform());
                            }
                        }
                    }
                    requestBuilder0.into(new CustomTarget() {
                        @Override  // com.bumptech.glide.request.target.Target
                        public void onLoadCleared(Drawable drawable0) {
                        }

                        @Override  // com.bumptech.glide.request.target.CustomTarget
                        public void onLoadFailed(Drawable drawable0) {
                            super.onLoadFailed(drawable0);
                            TemplateCoverForUArtist.a(TemplateCoverForUArtist.this);
                            TemplateCoverForUArtist.this.checkDownloadCompleted(templateImageLoader$DownloadStateListener0);
                        }

                        public void onResourceReady(Drawable drawable0, Transition transition0) {
                            imageView0.setImageDrawable(drawable0);
                            TemplateCoverForUArtist.this.checkDownloadCompleted(templateImageLoader$DownloadStateListener0);
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

