package org.androidannotations.api.sharedpreferences;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;

public abstract class EditorHelper {
    private final SharedPreferences.Editor editor;

    public EditorHelper(SharedPreferences sharedPreferences0) {
        this.editor = sharedPreferences0.edit();
    }

    public final void apply() {
        SharedPreferencesCompat.apply(this.editor);
    }

    public BooleanPrefEditorField booleanField(String s) {
        return new BooleanPrefEditorField(this, s);
    }

    private EditorHelper cast() [...] // Inlined contents

    public final EditorHelper clear() {
        this.editor.clear();
        return this;
    }

    public FloatPrefEditorField floatField(String s) {
        return new FloatPrefEditorField(this, s);
    }

    public SharedPreferences.Editor getEditor() {
        return this.editor;
    }

    public IntPrefEditorField intField(String s) {
        return new IntPrefEditorField(this, s);
    }

    public LongPrefEditorField longField(String s) {
        return new LongPrefEditorField(this, s);
    }

    public StringPrefEditorField stringField(String s) {
        return new StringPrefEditorField(this, s);
    }

    public StringSetPrefEditorField stringSetField(String s) {
        return new StringSetPrefEditorField(this, s);
    }
}

