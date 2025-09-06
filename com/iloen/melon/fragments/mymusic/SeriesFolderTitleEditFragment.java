package com.iloen.melon.fragments.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import b3.Z;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.fragments.EditorBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v5x.request.DjSeriesCreateInsertCheckTitleReq;
import com.iloen.melon.net.v5x.response.DjSeriesCreateInsertCheckTitleRes;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.system.ToastManager;

public class SeriesFolderTitleEditFragment extends EditorBaseFragment {
    private static final String ARG_EDIT_STRING = "argEditString";
    public static final String TAG = "SeriesFolderEditFragment";
    private String mEditTextString;

    public SeriesFolderTitleEditFragment() {
        this.mEditTextString = "";
    }

    public static SeriesFolderTitleEditFragment newInstance(String s) {
        SeriesFolderTitleEditFragment seriesFolderTitleEditFragment0 = new SeriesFolderTitleEditFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argEditString", s);
        seriesFolderTitleEditFragment0.setArguments(bundle0);
        return seriesFolderTitleEditFragment0;
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onDestroy() {
        super.onDestroy();
        this.setInputMethodVisibility(false);
    }

    @Override  // com.iloen.melon.fragments.EditorBaseFragment
    public void onEditorUISettingProc() {
        this.setTitle(this.getString(0x7F130780));  // string:mymusic_series_title_edit "제목 편집"
        this.setTextContentHint(this.getString(0x7F130830));  // string:playlist_input_title_hint "플레이리스트 제목"
        this.setTextCountLayoutEnable(true);
        this.setTextContent(this.mEditTextString);
        this.setTextCountLimit(40, 4);
        this.setInputMethodVisibility(true);
    }

    @Override  // com.iloen.melon.fragments.EditorBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        super.onRestoreInstanceState(bundle0);
        this.mEditTextString = bundle0.getString("argEditString");
    }

    @Override  // com.iloen.melon.fragments.EditorBaseFragment
    public void onRightButtonClicked() {
        if(!this.isFragmentValid()) {
            return;
        }
        if(TextUtils.isEmpty(this.getTextContent())) {
            ToastManager.show(this.getString(0x7F130834));  // string:playlist_no_title_msg "제목을 입력해주세요."
            return;
        }
        if(StringUtils.hasEmoji(this.getTextContent())) {
            ToastManager.show(this.getString(0x7F130820));  // string:playlist_alert_msg_mobile_only_characters "모바일 전용 특수문자는 입력하실 수 없습니다.\n수정 
                                                            // 후에 다시 시도해주세요."
            return;
        }
        RequestBuilder.newInstance(new DjSeriesCreateInsertCheckTitleReq(this.getContext(), this.getTextContent())).tag("SeriesFolderEditFragment").listener(new Listener() {
            public void onResponse(DjSeriesCreateInsertCheckTitleRes djSeriesCreateInsertCheckTitleRes0) {
                if(SeriesFolderTitleEditFragment.this.isFragmentValid() && djSeriesCreateInsertCheckTitleRes0 != null && djSeriesCreateInsertCheckTitleRes0.isSuccessful()) {
                    Z.w("title : ", SeriesFolderTitleEditFragment.this.getTextContent(), "SeriesFolderEditFragment");
                    FragmentActivity fragmentActivity0 = SeriesFolderTitleEditFragment.this.getActivity();
                    if(fragmentActivity0 == null) {
                        SeriesFolderTitleEditFragment.this.performBackPress();
                        return;
                    }
                    Intent intent0 = new Intent();
                    intent0.putExtra("argTitleText", SeriesFolderTitleEditFragment.this.getTextContent());
                    if(fragmentActivity0.getParent() == null) {
                        fragmentActivity0.setResult(-1, intent0);
                    }
                    else {
                        fragmentActivity0.getParent().setResult(-1, intent0);
                    }
                    fragmentActivity0.getOnBackPressedDispatcher().c();
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((DjSeriesCreateInsertCheckTitleRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                if(!SeriesFolderTitleEditFragment.this.isFragmentValid()) {
                    return;
                }
                ToastManager.show(SeriesFolderTitleEditFragment.this.getString(0x7F1303C6));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }).request();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putString("argEditString", this.mEditTextString);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }
}

