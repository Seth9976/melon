package org.androidannotations.api.sharedpreferences;

public abstract class AbstractPrefEditorField {
    protected final EditorHelper editorHelper;
    protected final String key;

    public AbstractPrefEditorField(EditorHelper editorHelper0, String s) {
        this.editorHelper = editorHelper0;
        this.key = s;
    }

    public final EditorHelper remove() {
        this.editorHelper.getEditor().remove(this.key);
        return this.editorHelper;
    }
}

