package com.iloen.melon.fragments.main.foru.template;

import com.iloen.melon.utils.template.TemplateData;
import com.iloen.melon.utils.template.TemplateImageLoader.DownloadStateListener;

public class TemplateCoverForURecentRecm extends TemplateCoverForURecmBase {
    public TemplateCoverForURecentRecm(TemplateData templateData0) {
        super(templateData0);
    }

    @Override  // com.iloen.melon.fragments.main.foru.template.TemplateCoverForURecmBase
    public int getLayoutResId() {
        return this.standardSizeDp > 144.0f ? 0x7F0D01CB : 0x7F0D01CA;  // layout:cover_template_foru_recent_recm_200
    }

    @Override  // com.iloen.melon.fragments.main.foru.template.TemplateCoverForURecmBase
    public void load(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        super.load(templateImageLoader$DownloadStateListener0);
    }
}

