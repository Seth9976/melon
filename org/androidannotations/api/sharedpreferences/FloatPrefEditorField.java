package org.androidannotations.api.sharedpreferences;

public final class FloatPrefEditorField extends AbstractPrefEditorField {
    public FloatPrefEditorField(EditorHelper editorHelper0, String s) {
        super(editorHelper0, s);
    }

    public EditorHelper put(float f) {
        this.editorHelper.getEditor().putFloat(this.key, f);
        return this.editorHelper;
    }
}

