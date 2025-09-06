package com.iloen.melon.fragments.main.foru.template;

import android.widget.ImageView;
import com.iloen.melon.utils.template.TemplateData;
import com.iloen.melon.utils.template.TemplateImageLoader.DownloadStateListener;
import com.iloen.melon.utils.ui.ViewUtils;

public class TemplateCoverForUStationRecm extends TemplateCoverForURecmBase {
    public TemplateCoverForUStationRecm(TemplateData templateData0) {
        super(templateData0);
    }

    @Override  // com.iloen.melon.fragments.main.foru.template.TemplateCoverForURecmBase
    public void drawCover(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        ImageView imageView0 = (ImageView)this.templateView.findViewById(0x7F0A0617);  // id:iv_cover
        ViewUtils.showWhen(((ImageView)this.templateView.findViewById(0x7F0A0694)), imageView0.getDrawable() != null);  // id:iv_station_logo
        super.drawCover(templateImageLoader$DownloadStateListener0);
    }

    @Override  // com.iloen.melon.fragments.main.foru.template.TemplateCoverForURecmBase
    public int getLayoutResId() {
        return 0x7F0D01D0;  // layout:cover_template_foru_station_recm_200
    }

    @Override  // com.iloen.melon.fragments.main.foru.template.TemplateCoverForURecmBase
    public void load(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        super.load(templateImageLoader$DownloadStateListener0);
    }
}

