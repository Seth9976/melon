package org.androidannotations.api.sharedpreferences;

public final class LongPrefEditorField extends AbstractPrefEditorField {
    public LongPrefEditorField(EditorHelper editorHelper0, String s) {
        super(editorHelper0, s);
    }

    public EditorHelper put(long v) {
        this.editorHelper.getEditor().putLong(this.key, v);
        return this.editorHelper;
    }
}

