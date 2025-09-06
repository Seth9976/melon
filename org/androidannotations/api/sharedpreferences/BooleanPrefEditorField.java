package org.androidannotations.api.sharedpreferences;

public final class BooleanPrefEditorField extends AbstractPrefEditorField {
    public BooleanPrefEditorField(EditorHelper editorHelper0, String s) {
        super(editorHelper0, s);
    }

    public EditorHelper put(boolean z) {
        this.editorHelper.getEditor().putBoolean(this.key, z);
        return this.editorHelper;
    }
}

