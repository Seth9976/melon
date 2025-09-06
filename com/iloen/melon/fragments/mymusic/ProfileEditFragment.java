package com.iloen.melon.fragments.mymusic;

import F8.C;
import F8.m;
import F8.o;
import F8.p;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.EditorBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.UpdateNickNameReq;
import com.iloen.melon.net.v4x.request.UpdateUserDescReq;
import com.iloen.melon.net.v4x.response.UpdateNickNameRes;
import com.iloen.melon.net.v4x.response.UpdateUserDescRes;
import com.iloen.melon.net.v6x.request.MyMusicDeleteSiteChannelReq;
import com.iloen.melon.net.v6x.request.MyMusicInsertDjTitleReq;
import com.iloen.melon.net.v6x.request.MyMusicInsertSiteChannelReq.Params;
import com.iloen.melon.net.v6x.request.MyMusicInsertSiteChannelReq;
import com.iloen.melon.net.v6x.response.MyMusicDeleteSiteChannelRes;
import com.iloen.melon.net.v6x.response.MyMusicInsertDjTitleRes;
import com.iloen.melon.net.v6x.response.MyMusicInsertSiteChannelRes;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import e1.u;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import va.d0;
import va.e0;

public class ProfileEditFragment extends EditorBaseFragment {
    private static final String ARG_EDIT_STRING = "argEditString";
    private static final String ARG_EDIT_TYPE = "argEditType";
    private static final String ARG_SNS_TYPE = "argSnsType";
    private static final String ARG_TITLE_TEXT = "argTitleText";
    public static final String TAG = "ProfileEditFragment";
    public static final int TYPE_DJ_INTRO_EDIT = 2;
    public static final int TYPE_EDIT_SNS_CONNECT = 4;
    public static final int TYPE_INTRO_EDIT = 1;
    public static final int TYPE_NICK_NAME_EDIT = 0;
    public static final int TYPE_REPNT_SNS_CONNECT = 5;
    public static final int TYPE_SNS_CONNECT = 3;
    private final int defaultLandscapeLimitLine;
    private int mCurrentType;
    private String mEditTextString;
    private C registerButton;
    private String snsType;
    private String titleText;

    public ProfileEditFragment() {
        this.mCurrentType = 0;
        this.mEditTextString = "";
        this.titleText = "";
        this.snsType = "";
        this.defaultLandscapeLimitLine = 5;
    }

    @Override  // com.iloen.melon.fragments.EditorBaseFragment
    public void buildTitleLayout() {
        p p0 = new p(1);
        p0.h(this.getString(0x7F130ADF));  // string:talkback_cancel_button "취소"
        p0.c = new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                ProfileEditFragment.this.onLeftButtonCliked();
            }
        };
        m m0 = new m(2, false);
        C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.registerButton = c0;
        c0.h(this.getString(0x7F130C1E));  // string:talkback_registration_btn "등록 버튼"
        C c1 = this.registerButton;
        c1.c = (/* 缺少LAMBDA参数 */) -> if(ProfileEditFragment.this.isFragmentValid()) {
            switch(ProfileEditFragment.this.mCurrentType) {
                case 1: {
                    if(StringUtils.hasEmoji(ProfileEditFragment.this.getTextContent())) {
                        ToastManager.show(ProfileEditFragment.this.getString(0x7F130820));  // string:playlist_alert_msg_mobile_only_characters "모바일 전용 특수문자는 입력하실 수 없습니다.\n수정 
                                                                                            // 후에 다시 시도해주세요."
                        return;
                    }
                    ProfileEditFragment.this.reqUpdateUserDesc();
                    return;
                }
                case 2: {
                    if(StringUtils.hasEmoji(ProfileEditFragment.this.getTextContent())) {
                        ToastManager.show(ProfileEditFragment.this.getString(0x7F130820));  // string:playlist_alert_msg_mobile_only_characters "모바일 전용 특수문자는 입력하실 수 없습니다.\n수정 
                                                                                            // 후에 다시 시도해주세요."
                        return;
                    }
                    ProfileEditFragment.this.reqInsertDjTitle();
                    return;
                }
                case 4: {
                    if(TextUtils.isEmpty(ProfileEditFragment.this.getTextContent().trim())) {
                        ProfileEditFragment.this.reqSiteChanneldelete();
                        return;
                    }
                    ProfileEditFragment.this.reqInsertSiteChannel();
                    break;
                }
                case 3: 
                case 5: {
                    ProfileEditFragment.this.reqInsertSiteChannel();
                }
            }
        };
        TitleBar titleBar0 = this.mTitleBarLayout;
        o[] arr_o = {p0, m0, this.registerButton};
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
        this.mTitleBarLayout.f(false);

        class com.iloen.melon.fragments.mymusic.ProfileEditFragment.2 implements View.OnClickListener {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                ProfileEditFragment.this.onRightButtonClicked();
            }
        }

    }

    private int getLimitLine(Configuration configuration0) {
        return configuration0.orientation == 2 ? 5 : 20;
    }

    public static ProfileEditFragment newInstance(int v, String s) {
        return ProfileEditFragment.newInstance(v, s, "", "NONE");
    }

    public static ProfileEditFragment newInstance(int v, String s, String s1, String s2) {
        ProfileEditFragment profileEditFragment0 = new ProfileEditFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argEditType", v);
        bundle0.putString("argEditString", s);
        bundle0.putString("argTitleText", s1);
        bundle0.putString("argSnsType", s2);
        profileEditFragment0.setArguments(bundle0);
        return profileEditFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        int v = this.getLimitLine(configuration0);
        if(this.mCurrentType == 1) {
            this.setTextCountLimit(110, v);
        }
    }

    @Override  // com.iloen.melon.fragments.EditorBaseFragment
    public void onEditorUISettingProc() {
        int v = 5;
        int v1 = this.mCurrentType;
        if(v1 == 0) {
            this.setTitle(this.getString(0x7F130776));  // string:mymusic_nickname_edit "닉네임 편집"
            this.setTextContent(this.mEditTextString);
            this.setEtTextBold();
            this.setEnterBlock(true);
            this.setGuideText(this.getString(0x7F130CA7));  // string:text_nickname_info "한글, 영문, 숫자, 일부 특수문자(-, _, .)만 사용 가능"
            this.setTextContentHint(this.getString(0x7F13077E));  // string:mymusic_profile_nickname_input_hint "닉네임"
            this.setTextCountLayoutEnable(true);
            this.setTextCountLimit(15, 2);
            return;
        }
        switch(v1) {
            case 1: {
                if(ScreenUtils.isPortrait(this.getContext())) {
                    v = 20;
                }
                this.setTitle(this.getString(0x7F13076F));  // string:mymusic_intro_edit "소개글 편집"
                this.setTextContent(this.mEditTextString);
                this.setGuideText("");
                this.setEditTextSize(14.0f);
                this.setTextContentHint(this.getString(0x7F13077D));  // string:mymusic_profile_introduction_input_hint "소개글을 입력해주세요."
                this.setTextCountLayoutEnable(true);
                this.setTextCountLimit(110, v);
                return;
            }
            case 2: {
                this.setTitle(this.getString(0x7F13076C));  // string:mymusic_dj_intro_edit "DJ 소개 한마디 편집"
                this.setTextContent(this.mEditTextString);
                this.setEnterBlock(true);
                this.setGuideText("");
                this.setEditTextSize(14.0f);
                this.setTextContentHint(this.getString(0x7F13077C));  // string:mymusic_profile_dj_introduction_input_hint "DJ 컨셉을 한 줄로 표현해주세요."
                this.setTextCountLayoutEnable(true);
                this.setTextCountLimit(20, 2);
                return;
            label_33:
                if(v1 != 4 && v1 != 5) {
                    return;
                }
                break;
            }
            case 3: {
                break;
            }
            default: {
                goto label_33;
            }
        }
        this.setTitle(String.format(this.getString(0x7F130782), this.titleText));  // string:mymusic_sns_connect "%1$s 연결"
        this.setTextContent(this.mEditTextString);
        this.setGuideText(this.getString(0x7F130CB9));  // string:text_sns_connect_info "타인의 SNS 주소를 입력하여 사칭하는 행위는 관련 정책에 따라 계정 정지 사유가 될 수 
                                                        // 있습니다."
        this.setEditTextSize(14.0f);
        this.setTextContentHint(this.getString(0x7F13077F));  // string:mymusic_profile_sns_connect_input_hint "URL을 입력해주세요."
        this.setTextCountLayoutEnable(false);
    }

    @Override  // com.iloen.melon.fragments.EditorBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        super.onRestoreInstanceState(bundle0);
        this.mCurrentType = bundle0.getInt("argEditType");
        this.mEditTextString = bundle0.getString("argEditString");
        this.titleText = bundle0.getString("argTitleText");
        this.snsType = bundle0.getString("argSnsType");
    }

    // 检测为 Lambda 实现
    @Override  // com.iloen.melon.fragments.EditorBaseFragment
    public void onRightButtonClicked() [...]

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putInt("argEditType", this.mCurrentType);
            bundle0.putString("argEditString", this.mEditTextString);
            bundle0.putString("argTitleText", this.titleText);
            bundle0.putString("argSnsType", this.snsType);
        }
    }

    private void reqInsertDjTitle() {
        RequestBuilder.newInstance(new MyMusicInsertDjTitleReq(this.getContext(), this.getTextContent())).tag("ProfileEditFragment").listener(new Listener() {
            public void onResponse(MyMusicInsertDjTitleRes myMusicInsertDjTitleRes0) {
                if(ProfileEditFragment.this.isFragmentValid() && myMusicInsertDjTitleRes0.isSuccessful()) {
                    LogU.d("ProfileEditFragment", "intro : " + ProfileEditFragment.this.getTextContent());
                    TimeExpiredCache.getInstance().removeLike(MelonContentUris.Z0.toString());
                    ProfileEditFragment.this.setInputMethodVisibility(false);
                    ProfileEditFragment.this.performBackPress();
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicInsertDjTitleRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                if(!ProfileEditFragment.this.isFragmentValid()) {
                    return;
                }
                ToastManager.show(ProfileEditFragment.this.getString(0x7F1303C6));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }).request();
    }

    private void reqInsertSiteChannel() {
        Params myMusicInsertSiteChannelReq$Params0 = new Params();
        myMusicInsertSiteChannelReq$Params0.infoCode = this.snsType;
        myMusicInsertSiteChannelReq$Params0.infoVal = this.getTextContent().trim();
        myMusicInsertSiteChannelReq$Params0.repntYn = this.mCurrentType == 5 ? "Y" : "N";
        RequestBuilder.newInstance(new MyMusicInsertSiteChannelReq(this.getContext(), myMusicInsertSiteChannelReq$Params0)).tag("ProfileEditFragment").listener(new Listener() {
            public void onResponse(MyMusicInsertSiteChannelRes myMusicInsertSiteChannelRes0) {
                if(ProfileEditFragment.this.isFragmentValid() && myMusicInsertSiteChannelRes0.isSuccessful()) {
                    LogU.d("ProfileEditFragment", "intro : " + ProfileEditFragment.this.getTextContent());
                    TimeExpiredCache.getInstance().removeLike(MelonContentUris.Z0.toString());
                    ProfileEditFragment.this.setInputMethodVisibility(false);
                    ProfileEditFragment.this.performBackPress();
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicInsertSiteChannelRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                if(!ProfileEditFragment.this.isFragmentValid()) {
                    return;
                }
                ToastManager.show(ProfileEditFragment.this.getString(0x7F1303C6));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }).request();
    }

    private void reqSiteChanneldelete() {
        RequestBuilder.newInstance(new MyMusicDeleteSiteChannelReq(this.getContext(), this.snsType)).tag("ProfileEditFragment").listener(new Listener() {
            public void onResponse(MyMusicDeleteSiteChannelRes myMusicDeleteSiteChannelRes0) {
                if(ProfileEditFragment.this.isFragmentValid() && myMusicDeleteSiteChannelRes0.isSuccessful()) {
                    LogU.d("ProfileEditFragment", "intro : " + ProfileEditFragment.this.getTextContent());
                    TimeExpiredCache.getInstance().removeLike(MelonContentUris.Z0.toString());
                    ProfileEditFragment.this.setInputMethodVisibility(false);
                    ProfileEditFragment.this.performBackPress();
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicDeleteSiteChannelRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                if(!ProfileEditFragment.this.isFragmentValid()) {
                    return;
                }
                ToastManager.show(ProfileEditFragment.this.getString(0x7F1303C6));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }).request();
    }

    private void reqUpdateNickName() {
        RequestBuilder.newInstance(new UpdateNickNameReq(this.getContext(), this.getTextContent().trim())).tag("ProfileEditFragment").listener(new Listener() {
            public void onResponse(UpdateNickNameRes updateNickNameRes0) {
                if(ProfileEditFragment.this.isFragmentValid() && updateNickNameRes0.isSuccessful()) {
                    String s = ProfileEditFragment.this.getTextContent();
                    LogU.d("ProfileEditFragment", "nickname : " + s);
                    e0 e00 = (e0)va.o.a();
                    e00.getClass();
                    q.g(s, "memberNickName");
                    d0 d00 = new d0(e00, s, null);
                    BuildersKt__Builders_commonKt.launch$default(e00.i, null, null, d00, 3, null);
                    TimeExpiredCache.getInstance().removeLike(MelonContentUris.Z0.toString());
                    ProfileEditFragment.this.setInputMethodVisibility(false);
                    ProfileEditFragment.this.performBackPress();
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((UpdateNickNameRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                if(!ProfileEditFragment.this.isFragmentValid()) {
                    return;
                }
                ToastManager.show(ProfileEditFragment.this.getString(0x7F1303C6));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }).request();
    }

    private void reqUpdateUserDesc() {
        RequestBuilder.newInstance(new UpdateUserDescReq(this.getContext(), u.v(((e0)va.o.a()).j()), this.getTextContent().trim())).tag("ProfileEditFragment").listener(new Listener() {
            public void onResponse(UpdateUserDescRes updateUserDescRes0) {
                if(ProfileEditFragment.this.isFragmentValid() && updateUserDescRes0.isSuccessful()) {
                    LogU.d("ProfileEditFragment", "intro : " + ProfileEditFragment.this.getTextContent());
                    TimeExpiredCache.getInstance().removeLike(MelonContentUris.Z0.toString());
                    ProfileEditFragment.this.setInputMethodVisibility(false);
                    ProfileEditFragment.this.performBackPress();
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((UpdateUserDescRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                if(!ProfileEditFragment.this.isFragmentValid()) {
                    return;
                }
                ToastManager.show(ProfileEditFragment.this.getString(0x7F1303C6));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }).request();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.EditorBaseFragment
    public void updateCompleteBtn(String s) {
        C c0 = this.registerButton;
        if(c0 != null && (this.mCurrentType == 0 || this.mCurrentType == 3 || this.mCurrentType == 5)) {
            boolean z = TextUtils.isEmpty(s.trim());
            MelonTextView melonTextView0 = c0.g;
            if(melonTextView0 != null) {
                if(!z) {
                    melonTextView0.setTextColor(ColorUtils.getColor(c0.h, 0x7F06017C));  // color:green500s_support_high_contrast
                    MelonTextView melonTextView1 = c0.g;
                    if(melonTextView1 != null) {
                        melonTextView1.setEnabled(true);
                        return;
                    }
                    q.m("btnEdit");
                    throw null;
                }
                melonTextView0.setTextColor(ColorUtils.getColor(c0.h, 0x7F060154));  // color:gray200s_support_high_contrast
                MelonTextView melonTextView2 = c0.g;
                if(melonTextView2 != null) {
                    melonTextView2.setEnabled(false);
                    return;
                }
                q.m("btnEdit");
                throw null;
            }
        }
    }
}

