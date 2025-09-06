package com.iloen.melon.fragments.main.foru.template;

import com.iloen.melon.utils.template.TemplateData;
import com.iloen.melon.utils.template.TemplateImageLoader.DownloadStateListener;

public class TemplateCoverForUGenreRecm extends TemplateCoverForURecmBase {
    public TemplateCoverForUGenreRecm(TemplateData templateData0) {
        super(templateData0);
    }

    @Override  // com.iloen.melon.fragments.main.foru.template.TemplateCoverForURecmBase
    public int getLayoutResId() {
        return this.standardSizeDp > 144.0f ? 0x7F0D01C0 : 0x7F0D01BF;  // layout:cover_template_foru_genre_recm_200
    }

    @Override  // com.iloen.melon.fragments.main.foru.template.TemplateCoverForURecmBase
    public void load(DownloadStateListener templateImageLoader$DownloadStateListener0) {
        super.load(templateImageLoader$DownloadStateListener0);
    }
}

