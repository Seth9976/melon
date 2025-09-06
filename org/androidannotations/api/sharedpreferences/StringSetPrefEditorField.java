package org.androidannotations.api.sharedpreferences;

import java.util.Set;

public final class StringSetPrefEditorField extends AbstractPrefEditorField {
    public StringSetPrefEditorField(EditorHelper editorHelper0, String s) {
        super(editorHelper0, s);
    }

    public EditorHelper put(Set set0) {
        SharedPreferencesCompat.putStringSet(this.editorHelper.getEditor(), this.key, set0);
        return this.editorHelper;
    }
}

