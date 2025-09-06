package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.H;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textview.MaterialTextView;

public class MaterialComponentsViewInflater extends H {
    @Override  // androidx.appcompat.app.H
    public final AppCompatAutoCompleteTextView a(Context context0, AttributeSet attributeSet0) {
        return new MaterialAutoCompleteTextView(context0, attributeSet0);
    }

    @Override  // androidx.appcompat.app.H
    public final AppCompatButton b(Context context0, AttributeSet attributeSet0) {
        return new MaterialButton(context0, attributeSet0);
    }

    @Override  // androidx.appcompat.app.H
    public final AppCompatCheckBox c(Context context0, AttributeSet attributeSet0) {
        return new MaterialCheckBox(context0, attributeSet0);
    }

    @Override  // androidx.appcompat.app.H
    public final AppCompatRadioButton d(Context context0, AttributeSet attributeSet0) {
        return new MaterialRadioButton(context0, attributeSet0);
    }

    @Override  // androidx.appcompat.app.H
    public final AppCompatTextView e(Context context0, AttributeSet attributeSet0) {
        return new MaterialTextView(context0, attributeSet0);
    }
}

