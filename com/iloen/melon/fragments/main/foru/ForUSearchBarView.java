package com.iloen.melon.fragments.main.foru;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TextView;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import k8.t1;

public class ForUSearchBarView extends LinearLayout implements TextWatcher, View.OnClickListener, TextView.OnEditorActionListener {
    public interface OnSearchBarListener {
        void onClearClick(ForUSearchBarView arg1);

        void onClearKeyword(ForUSearchBarView arg1);

        void onSearchClick(ForUSearchBarView arg1, String arg2);

        void onSearchKeyword(ForUSearchBarView arg1, String arg2);
    }

    private static final String TAG = "ForUSearchBarView";
    protected View mClearButton;
    protected ImageView mDeleteIcon;
    protected MelonEditText mInputText;
    protected int mInputTextHintSize;
    protected int mInputTextSize;
    private OnSearchBarListener mListener;
    protected ImageView mSearchButton;

    public ForUSearchBarView(Context context0) {
        this(context0, null);
    }

    public ForUSearchBarView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.mListener = null;
        if(this.isInEditMode()) {
            return;
        }
        this.init();
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.m);
        try {
            String s = typedArray0.getString(7);
            if(!TextUtils.isEmpty(s)) {
                this.mInputText.setHint(s);
            }
            this.mInputTextSize = (int)typedArray0.getDimension(34, ((float)ScreenUtils.dipToPixel(context0, 15.0f)));
            this.mInputTextHintSize = (int)typedArray0.getDimension(0x1F, ((float)ScreenUtils.dipToPixel(context0, 14.0f)));
            this.toggleInputTextSize(true);
        }
        finally {
            typedArray0.recycle();
        }
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    public String getInputText() {
        if(ViewUtils.hasStringEditText(this.mInputText)) {
            return this.mInputText == null ? "" : this.mInputText.getText().toString();
        }
        return "";
    }

    public void hideInputMethod() {
        InputMethodUtils.hideInputMethod(this.getContext(), this.mInputText);
    }

    private void init() {
        View.inflate(this.getContext(), 0x7F0D028B, this);  // layout:for_u_searchbar
        MelonEditText melonEditText0 = (MelonEditText)this.findViewById(0x7F0A0A42);  // id:search_keyword
        this.mInputText = melonEditText0;
        melonEditText0.addTextChangedListener(this);
        this.mInputText.setImeOptions(3);
        this.mInputText.setOnEditorActionListener(this);
        this.mClearButton = this.findViewById(0x7F0A0157);  // id:btn_delete
        this.mDeleteIcon = (ImageView)this.findViewById(0x7F0A039D);  // id:delete_icon
        ViewUtils.setOnClickListener(this.mClearButton, this);
        ImageView imageView0 = (ImageView)this.findViewById(0x7F0A0A40);  // id:search_icon
        this.mSearchButton = imageView0;
        ViewUtils.setOnClickListener(imageView0, this);
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == this.mClearButton) {
            this.reset();
            OnSearchBarListener forUSearchBarView$OnSearchBarListener0 = this.mListener;
            if(forUSearchBarView$OnSearchBarListener0 != null) {
                forUSearchBarView$OnSearchBarListener0.onClearClick(this);
            }
        }
        else if(view0 == this.mSearchButton) {
            if(ViewUtils.hasStringEditText(this.mInputText)) {
                OnSearchBarListener forUSearchBarView$OnSearchBarListener1 = this.mListener;
                if(forUSearchBarView$OnSearchBarListener1 != null) {
                    forUSearchBarView$OnSearchBarListener1.onSearchClick(this, this.mInputText.getText().toString());
                }
                InputMethodUtils.hideInputMethod(this.getContext(), this.mInputText);
                return;
            }
            ToastManager.showShort(0x7F1300B9);  // string:alert_dlg_body_search_text_empty "검색어를 입력해주세요."
        }
    }

    @Override  // android.widget.TextView$OnEditorActionListener
    public boolean onEditorAction(TextView textView0, int v, KeyEvent keyEvent0) {
        if(v != 3 && v != 6) {
            return true;
        }
        if(!ViewUtils.hasStringEditText(this.mInputText)) {
            ToastManager.showShort(0x7F1300B9);  // string:alert_dlg_body_search_text_empty "검색어를 입력해주세요."
            return false;
        }
        OnSearchBarListener forUSearchBarView$OnSearchBarListener0 = this.mListener;
        if(forUSearchBarView$OnSearchBarListener0 != null) {
            forUSearchBarView$OnSearchBarListener0.onSearchClick(this, this.mInputText.getText().toString());
        }
        InputMethodUtils.hideInputMethod(this.getContext(), this.mInputText);
        return true;
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        MelonEditText melonEditText0 = this.mInputText;
        if(melonEditText0 == null) {
            LogU.w("ForUSearchBarView", "onTextChanged() - invalid EditText");
            return;
        }
        String s = melonEditText0.getText().toString();
        if(TextUtils.isEmpty(s)) {
            this.setClearButtonVisibility(false);
            this.toggleInputTextSize(true);
            OnSearchBarListener forUSearchBarView$OnSearchBarListener0 = this.mListener;
            if(forUSearchBarView$OnSearchBarListener0 != null) {
                forUSearchBarView$OnSearchBarListener0.onClearKeyword(this);
            }
        }
        else {
            this.setClearButtonVisibility(true);
            this.toggleInputTextSize(false);
            OnSearchBarListener forUSearchBarView$OnSearchBarListener1 = this.mListener;
            if(forUSearchBarView$OnSearchBarListener1 != null) {
                forUSearchBarView$OnSearchBarListener1.onSearchKeyword(this, s);
            }
        }
    }

    public void reset() {
        this.mInputText.setText("");
        this.setClearButtonVisibility(false);
        this.hideInputMethod();
    }

    private void setClearButtonVisibility(boolean z) {
        ViewUtils.showWhen(this.mClearButton, z);
        ViewUtils.showWhen(this.mDeleteIcon, z);
    }

    public void setHint(int v) {
        MelonEditText melonEditText0 = this.mInputText;
        if(melonEditText0 != null) {
            melonEditText0.setHint(this.getResources().getString(v));
        }
    }

    public void setHint(String s) {
        MelonEditText melonEditText0 = this.mInputText;
        if(melonEditText0 != null) {
            melonEditText0.setHint(s);
        }
    }

    public void setInputText(String s) {
        MelonEditText melonEditText0 = this.mInputText;
        if(melonEditText0 != null) {
            melonEditText0.setText(s);
        }
    }

    @Override  // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener view$OnFocusChangeListener0) {
        this.mInputText.setOnFocusChangeListener(view$OnFocusChangeListener0);
    }

    public void setOnSearchBarListener(OnSearchBarListener forUSearchBarView$OnSearchBarListener0) {
        this.mListener = forUSearchBarView$OnSearchBarListener0;
    }

    private void toggleInputTextSize(boolean z) {
        this.mInputText.setTextSize(0, ((float)(z ? this.mInputTextHintSize : this.mInputTextSize)));
    }
}

