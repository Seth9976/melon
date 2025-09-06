package androidx.car.app.model;

import java.util.Objects;

public class TabContents {
    public static final String CONTENT_ID = "TAB_CONTENTS_CONTENT_ID";
    private final Y mTemplate;

    private TabContents() {
        this.mTemplate = null;
    }

    public TabContents(V v0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof TabContents ? Objects.equals(this.mTemplate, ((TabContents)object0).mTemplate) : false;
    }

    public String getContentId() {
        return "TAB_CONTENTS_CONTENT_ID";
    }

    public Y getTemplate() {
        Objects.requireNonNull(this.mTemplate);
        return this.mTemplate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mTemplate});
    }

    @Override
    public String toString() {
        return "[template: " + this.mTemplate + "]";
    }
}

