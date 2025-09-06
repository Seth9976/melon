package com.iloen.melon.fragments;

import F8.m;
import F8.o;
import F8.p;
import F8.x;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.constants.MelonLimits.TextLimit;
import com.iloen.melon.custom.GestureTouchListener;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.popup.PopupHelper;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import v9.h;
import v9.i;

public class EditIntroductionFragment extends MetaContentBaseFragment {
    static class EditState {
        private static final int NORMAL = 0;
        private static final int OVER_LENGTH = 2;

    }

    public static final String ARG_TEXT_RESULT_VALUES = "arg_text_result_values";
    public static final String ARG_TEXT_VALUES = "arg_text_value";
    private static final int MAX_TEXT_LENGTH = 1000;
    private static final String TAG = "EditIntroductionFragment";
    private String mBeforeText;
    private int mEditState;
    private MelonEditText mInputEditText;
    private String mTextValue;
    private TextWatcher mTextWatcher;

    public EditIntroductionFragment() {
        this.mBeforeText = "";
        this.mEditState = 0;
        this.mTextWatcher = new TextWatcher() {
            @Override  // android.text.TextWatcher
            public void afterTextChanged(Editable editable0) {
                if(EditIntroductionFragment.this.mEditState != 0) {
                    LogU.d("EditIntroductionFragment", "afterTextChanged - mBeforeText - " + EditIntroductionFragment.this.mBeforeText);
                    if(!TextUtils.isEmpty(editable0)) {
                        editable0.clear();
                    }
                }
            }

            @Override  // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                LogU.d("EditIntroductionFragment", "beforeTextChanged - " + charSequence0);
                if(EditIntroductionFragment.this.mEditState == 0) {
                    EditIntroductionFragment.this.mBeforeText = charSequence0.toString();
                    if(TextUtils.isEmpty(EditIntroductionFragment.this.mBeforeText)) {
                        EditIntroductionFragment.this.mBeforeText = "";
                    }
                }
            }

            @Override  // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                if(charSequence0.length() != 0) {
                    EditIntroductionFragment.this.mEditState = 0;
                    if(EditIntroductionFragment.this.mInputEditText.getText().toString().length() > 1000) {
                        EditIntroductionFragment.this.mEditState = 2;
                    }
                }
            }
        };
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return null;
    }

    private void finishForResult() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 == null) {
            this.performBackPress();
            return;
        }
        Intent intent0 = new Intent();
        intent0.putExtra("arg_text_result_values", this.mInputEditText.getText().toString());
        if(fragmentActivity0.getParent() == null) {
            fragmentActivity0.setResult(-1, intent0);
        }
        else {
            fragmentActivity0.getParent().setResult(-1, intent0);
        }
        this.getActivity().getOnBackPressedDispatcher().c();
    }

    public static EditIntroductionFragment newInstance(String s) {
        EditIntroductionFragment editIntroductionFragment0 = new EditIntroductionFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putString("arg_text_value", s);
        editIntroductionFragment0.setArguments(bundle0);
        return editIntroductionFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(this.getArguments() != null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            this.mTextValue = bundle0.getString("arg_text_value");
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D0246, viewGroup0, false);  // layout:edit_introduction
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            p p0 = new p(1);
            p0.c = new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    InputMethodUtils.hideInputMethod(EditIntroductionFragment.this.getActivity(), EditIntroductionFragment.this.mInputEditText);
                    EditIntroductionFragment.this.performBackPress();
                }
            };
            m m0 = new m(2, false);
            x x0 = new x(5);
            x0.c = new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    InputMethodUtils.hideInputMethod(EditIntroductionFragment.this.getContext(), EditIntroductionFragment.this.mInputEditText);
                    if(TextUtils.isEmpty(EditIntroductionFragment.this.mInputEditText.getText().toString().trim())) {
                        MelonTextPopup melonTextPopup0 = PopupHelper.showAlertPopup(EditIntroductionFragment.this.getActivity(), 0x7F1300D0, 0x7F13082E, null);  // string:alert_dlg_title_info "안내"
                        melonTextPopup0.setOnDismissListener(EditIntroductionFragment.this.mDialogDismissListener);
                        EditIntroductionFragment.this.mRetainDialog = melonTextPopup0;
                        melonTextPopup0.show();
                        return;
                    }
                    EditIntroductionFragment.this.finishForResult();
                }
            };
            o[] arr_o = {p0, m0, x0};
            o o0 = null;
            for(int v = 0; v < 3; ++v) {
                o o1 = arr_o[v];
                if(o0 == null) {
                    o0 = o1;
                }
                else {
                    o0.g(o1);
                }
            }
            titleBar0.a(o0);
            titleBar0.setTitle(this.getString(0x7F13076F));  // string:mymusic_intro_edit "소개글 편집"
            titleBar0.f(true);
        }
        MelonEditText melonEditText0 = (MelonEditText)this.findViewById(0x7F0A0585);  // id:input_text
        this.mInputEditText = melonEditText0;
        melonEditText0.setTextLimit(MelonLimits.TextLimit.d);
        this.mInputEditText.setTextLimitUpdate(true);
        this.mInputEditText.setText(this.mTextValue);
        this.mInputEditText.setTextWatcher(this.mTextWatcher);
        this.findViewById(0x7F0A0589).setOnTouchListener(new View.OnTouchListener() {  // id:input_text_scrollview
            @Override  // android.view.View$OnTouchListener
            public boolean onTouch(View view0, MotionEvent motionEvent0) {
                if(motionEvent0.getAction() == 1) {
                    ViewUtils.setSelection(EditIntroductionFragment.this.mInputEditText);
                    InputMethodUtils.showInputMethod(EditIntroductionFragment.this.getContext(), EditIntroductionFragment.this.mInputEditText);
                }
                return false;
            }
        });
        this.findViewById(0x7F0A0586).setOnTouchListener(new GestureTouchListener(this.getContext()) {  // id:input_text_container
            @Override  // com.iloen.melon.custom.GestureTouchListener
            public void onSingleTouchUp() {
                ViewUtils.setSelection(EditIntroductionFragment.this.mInputEditText);
                InputMethodUtils.showInputMethod(EditIntroductionFragment.this.getContext(), EditIntroductionFragment.this.mInputEditText);
            }

            @Override  // com.iloen.melon.custom.GestureTouchListener
            public void onSwipeBottom() {
            }

            @Override  // com.iloen.melon.custom.GestureTouchListener
            public void onSwipeLeft() {
            }

            @Override  // com.iloen.melon.custom.GestureTouchListener
            public void onSwipeRight() {
            }

            @Override  // com.iloen.melon.custom.GestureTouchListener
            public void onSwipeTop() {
            }
        });
        InputMethodUtils.showInputMethod(this.getActivity(), this.mInputEditText);
    }
}

