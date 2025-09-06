package org.androidannotations.api.sharedpreferences;

public final class StringPrefEditorField extends AbstractPrefEditorField {
    public StringPrefEditorField(EditorHelper editorHelper0, String s) {
        super(editorHelper0, s);
    }

    public EditorHelper put(String s) {
        this.editorHelper.getEditor().putString(this.key, s);
        return this.editorHelper;
    }
}

