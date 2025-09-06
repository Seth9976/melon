package org.androidannotations.api.sharedpreferences;

public final class IntPrefEditorField extends AbstractPrefEditorField {
    public IntPrefEditorField(EditorHelper editorHelper0, String s) {
        super(editorHelper0, s);
    }

    public EditorHelper put(int v) {
        this.editorHelper.getEditor().putInt(this.key, v);
        return this.editorHelper;
    }
}

