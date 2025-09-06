package androidx.car.app.model;

import java.util.Objects;

public final class TemplateInfo {
    private final Class mTemplateClass;
    private final String mTemplateId;

    private TemplateInfo() {
        this.mTemplateClass = null;
        this.mTemplateId = null;
    }

    public TemplateInfo(Class class0, String s) {
        this.mTemplateClass = class0;
        this.mTemplateId = s;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof TemplateInfo ? Objects.equals(this.mTemplateClass, ((TemplateInfo)object0).mTemplateClass) && Objects.equals(this.mTemplateId, ((TemplateInfo)object0).mTemplateId) : false;
    }

    public Class getTemplateClass() {
        Objects.requireNonNull(this.mTemplateClass);
        return this.mTemplateClass;
    }

    public String getTemplateId() {
        Objects.requireNonNull(this.mTemplateId);
        return this.mTemplateId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mTemplateClass, this.mTemplateId});
    }
}

