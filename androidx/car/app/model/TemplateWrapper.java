package androidx.car.app.model;

import U4.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class TemplateWrapper {
    private int mCurrentTaskStep;
    private String mId;
    private boolean mIsRefresh;
    private Y mTemplate;
    private List mTemplateInfoForScreenStack;

    private TemplateWrapper() {
        this.mTemplateInfoForScreenStack = new ArrayList();
        this.mTemplate = null;
        this.mId = "";
    }

    private TemplateWrapper(Y y0, String s) {
        this.mTemplateInfoForScreenStack = new ArrayList();
        this.mTemplate = y0;
        this.mId = s;
    }

    public static TemplateWrapper copyOf(TemplateWrapper templateWrapper0) {
        TemplateWrapper templateWrapper1 = TemplateWrapper.wrap(templateWrapper0.getTemplate(), "");
        templateWrapper1.setRefresh(templateWrapper0.isRefresh());
        templateWrapper1.setCurrentTaskStep(templateWrapper0.getCurrentTaskStep());
        List list0 = templateWrapper0.getTemplateInfosForScreenStack();
        if(list0 != null) {
            templateWrapper1.setTemplateInfosForScreenStack(list0);
        }
        return templateWrapper1;
    }

    // 去混淆评级： 低(20)
    private static String createRandomId() [...] // 潜在的解密器

    public int getCurrentTaskStep() {
        return this.mCurrentTaskStep;
    }

    public String getId() [...] // 潜在的解密器

    public Y getTemplate() {
        Y y0 = this.mTemplate;
        Objects.requireNonNull(y0);
        return y0;
    }

    public List getTemplateInfosForScreenStack() {
        return this.mTemplateInfoForScreenStack == null ? Collections.EMPTY_LIST : this.mTemplateInfoForScreenStack;
    }

    public boolean isRefresh() {
        return this.mIsRefresh;
    }

    public void setCurrentTaskStep(int v) {
        this.mCurrentTaskStep = v;
    }

    public void setId(String s) {
        this.mId = s;
    }

    public void setRefresh(boolean z) {
        this.mIsRefresh = z;
    }

    public void setTemplate(Y y0) {
        this.mTemplate = y0;
    }

    public void setTemplateInfosForScreenStack(List list0) {
        this.mTemplateInfoForScreenStack = list0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[template: ");
        stringBuilder0.append(this.mTemplate);
        stringBuilder0.append(", ID: ");
        return x.m(stringBuilder0, this.mId, "]");
    }

    // 去混淆评级： 低(20)
    public static TemplateWrapper wrap(Y y0) {
        return TemplateWrapper.wrap(y0, "7b1a53a3-c853-4de4-9e47-cfff96bb1920");
    }

    public static TemplateWrapper wrap(Y y0, String s) {
        Objects.requireNonNull(y0);
        Objects.requireNonNull(s);
        return new TemplateWrapper(y0, s);
    }
}

