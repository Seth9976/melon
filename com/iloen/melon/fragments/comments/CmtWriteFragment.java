package com.iloen.melon.fragments.comments;

import B0.s;
import E9.w;
import F8.A;
import F8.m;
import F8.o;
import F8.p;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Insets;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.f0;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import b.l;
import b3.Z;
import b9.d;
import c2.n0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.google.android.material.internal.F;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.activity.CmtAttachActivity;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MediaAttachmentLayout;
import com.iloen.melon.custom.MediaAttachmentView;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.c0;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.eventbus.EventComment;
import com.iloen.melon.eventbus.EventKakaoLogin;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.AuthhsJsonReq;
import com.iloen.melon.net.v3x.comments.AuthhsJsonRes;
import com.iloen.melon.net.v3x.comments.HsUploadJsonReq;
import com.iloen.melon.net.v3x.comments.HsUploadJsonRes;
import com.iloen.melon.net.v3x.comments.InformCmtReq.Params;
import com.iloen.melon.net.v3x.comments.InformCmtReq;
import com.iloen.melon.net.v3x.comments.InformCmtRes.result.ATACHLIST;
import com.iloen.melon.net.v3x.comments.InformCmtRes.result.CMTINFO;
import com.iloen.melon.net.v3x.comments.InformCmtRes;
import com.iloen.melon.net.v3x.comments.InsertCmtReq.Params.AtachList;
import com.iloen.melon.net.v3x.comments.InsertCmtReq;
import com.iloen.melon.net.v3x.comments.InsertCmtRes.result;
import com.iloen.melon.net.v3x.comments.InsertCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.CHNLINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v3x.comments.UpdateCmtReq;
import com.iloen.melon.net.v3x.comments.UpdateCmtRes;
import com.iloen.melon.net.v4x.request.CmtPvLogDummyReq;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.popup.PopupHelper;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.types.MediaAttachInfo;
import com.iloen.melon.types.MediaAttachType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.image.ImageSelector.ImageSelectorListener;
import com.iloen.melon.utils.image.ImageSelector.Request;
import com.iloen.melon.utils.image.ImageSelector;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.CompatUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.interfaces.EmoticonClickListener;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.tiara.data.ActionKind;
import e.b;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import kotlin.jvm.internal.q;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import v9.h;
import v9.i;

@Deprecated
public class CmtWriteFragment extends CmtBaseFragment {
    public static class Param extends com.iloen.melon.fragments.comments.CmtBaseFragment.Param {
        public int cmtseq;
        public LoadPgnRes loadPgnRes;
        private static final long serialVersionUID = -7671277805386482075L;

        public Param() {
            this.cmtseq = -1;
        }
    }

    public static final String ARG_CMT_BUNDLE_PARAM_KEY = "argCmtBundleParamKey";
    private static final String TAG = "CmtWriteFragment";
    private static final boolean USE_SERVER_CONF = false;
    private b activityResult;
    private View containerLayout;
    private EmoticonClickListener emoticonClickListener;
    private EmoticonViewParam emoticonViewParam;
    private MediaAttachmentLayout mAttachmentLayout;
    private ImageView mBtnAttachKakaoEmoticon;
    private ImageView mBtnAttachLink;
    private ImageView mBtnAttachPhoto;
    private ImageView mBtnAttachSong;
    private ImageView mBtnAttachVideo;
    private MelonEditText mEdtRegister;
    private ImageSelector mImageSelector;
    private ImageSelectorListener mImageSelectorListener;
    private TextWatcher mTextWatcher;
    private A registerButton;

    public CmtWriteFragment() {
        this.mAttachmentLayout = null;
        this.activityResult = this.registerForActivityResult(new f0(2), new g(this));
        this.emoticonClickListener = new EmoticonClickListener() {
            @Override  // com.kakao.emoticon.interfaces.EmoticonClickListener
            public void onEmoticonClick(EmoticonViewParam emoticonViewParam0) {
                CmtWriteFragment.this.addAttachInfo(emoticonViewParam0);
            }

            @Override  // com.kakao.emoticon.interfaces.EmoticonClickListener
            public void onEmoticonDoubleClick(EmoticonViewParam emoticonViewParam0) {
            }
        };
        this.mTextWatcher = new TextWatcher() {
            @Override  // android.text.TextWatcher
            public void afterTextChanged(Editable editable0) {
            }

            @Override  // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
            }

            @Override  // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                int v3 = CmtWriteFragment.this.mEdtRegister.getText().toString().length();
                if(CmtWriteFragment.this.registerButton != null) {
                    CmtWriteFragment.this.registerButton.j(v3 > 0);
                }
                if(v3 >= (CmtWriteFragment.this.mLoadPgnRes.result.chnlinfo.cmtregmaxlength > 0 ? CmtWriteFragment.this.mLoadPgnRes.result.chnlinfo.cmtregmaxlength : 1000) && v2 - v1 == 0 && (CmtWriteFragment.this.mRetainDialog == null || !CmtWriteFragment.this.mRetainDialog.isShowing())) {
                    MelonTextPopup melonTextPopup0 = PopupHelper.showAlertPopup(CmtWriteFragment.this.getActivity(), 0x7F1300D0, 0x7F13084B, new DialogInterface.OnClickListener() {  // string:alert_dlg_title_info "안내"
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface dialogInterface0, int v) {
                        }
                    });
                    CmtWriteFragment.this.mRetainDialog = melonTextPopup0;
                }
            }
        };
        this.mImageSelectorListener = new ImageSelectorListener() {
            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onFinishBackgroundLoading() {
            }

            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onImageSelectorCanceled(ImageSelector imageSelector0, Request imageSelector$Request0) {
            }

            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onImageSelectorComplete(ImageSelector imageSelector0, Request imageSelector$Request0, Uri uri0) {
                if(uri0 != null) {
                    String s = uri0.getPath();
                    CmtWriteFragment.this.updateAttachmentLayout(s);
                    ToastManager.show(0x7F1301D9);  // string:cmt_attachment_add_message "첨부 되었습니다."
                }
            }

            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onStartBackgroundLoading() {
            }
        };
    }

    public static void J0(CmtWriteFragment cmtWriteFragment0) {
        cmtWriteFragment0.updateAttachBtn(-1);
    }

    public void addAttachInfo(EmoticonViewParam emoticonViewParam0) {
        LogU.d("CmtWriteFragment", "addAttachInfo");
        if(emoticonViewParam0 != null) {
            LogU.d("CmtWriteFragment", "param : " + emoticonViewParam0.toJsonString());
            MediaAttachInfo mediaAttachInfo0 = new MediaAttachInfo();
            mediaAttachInfo0.a = MediaAttachType.j;
            mediaAttachInfo0.W = this.mParam.theme;
            mediaAttachInfo0.X = emoticonViewParam0.toJsonString();
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(mediaAttachInfo0);
            this.updateAttachmentLayout(arrayList0);
            ToastManager.show(0x7F1301D9);  // string:cmt_attachment_add_message "첨부 되었습니다."
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return null;
    }

    private boolean fetchStartForEdit(i i0, h h0, String s) {
        Z.w("fetchStartForEdit reason:", s, "CmtWriteFragment");
        if(((Param)this.mParam).cmtseq < 0) {
            LogU.d("CmtWriteFragment", "onFetchStart : Invalid cmtseq. This must be write event.");
            return false;
        }
        Params informCmtReq$Params0 = new Params();
        informCmtReq$Params0.chnlSeq = this.mParam.chnlSeq;
        informCmtReq$Params0.contsRefValue = this.mParam.contsRefValue;
        informCmtReq$Params0.cmtSeq = ((Param)this.mParam).cmtseq;
        informCmtReq$Params0.adcmtListFlag = false;
        RequestBuilder.newInstance(new InformCmtReq(this.getContext(), informCmtReq$Params0)).tag("CmtWriteFragment").listener(new Listener() {
            public void onResponse(InformCmtRes informCmtRes0) {
                if(!CmtWriteFragment.this.prepareFetchComplete(informCmtRes0)) {
                    return;
                }
                if(informCmtRes0.isSuccessful() && CmtWriteFragment.this.isLoadPgnResValid("InformCmtReq")) {
                    CmtWriteFragment.this.updateView(informCmtRes0);
                    CmtWriteFragment.this.performFetchCompleteOnlyViews();
                    return;
                }
                CmtWriteFragment.this.performCmtFetchErrorToast(informCmtRes0.errormessage);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((InformCmtRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.g.buildUpon().appendPath("cmtwrite").appendQueryParameter("chnlSeq", String.valueOf(this.mParam.chnlSeq)).appendQueryParameter("contsRef", this.mParam.contsRefValue).appendQueryParameter("cmtseq", String.valueOf(((Param)this.mParam).cmtseq)).build().toString();
    }

    private Param getCachedLoadPgnRes(String s) {
        Cursor cursor0 = a.f(this.getContext(), s);
        if(cursor0 == null) {
            LogU.w("CmtWriteFragment", "fetchData() invalid cursor");
            return null;
        }
        Param cmtWriteFragment$Param0 = (Param)a.d(cursor0, Param.class);
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        if(cmtWriteFragment$Param0 == null) {
            LogU.w("CmtWriteFragment", "fetchData() failed to extract contents");
            return null;
        }
        return cmtWriteFragment$Param0;
    }

    public CmtPvLogDummyReq getPvDummyLogRequest() {
        com.iloen.melon.net.v4x.request.CmtPvLogDummyReq.Params cmtPvLogDummyReq$Params0 = new com.iloen.melon.net.v4x.request.CmtPvLogDummyReq.Params();
        cmtPvLogDummyReq$Params0.type = "write";
        cmtPvLogDummyReq$Params0.chnlSeq = String.valueOf(this.mParam.chnlSeq);
        cmtPvLogDummyReq$Params0.cmtSeq = String.valueOf(((Param)this.mParam).cmtseq);
        cmtPvLogDummyReq$Params0.contsRefValue = this.mParam.contsRefValue;
        return new CmtPvLogDummyReq(this.getContext(), cmtPvLogDummyReq$Params0);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public PvLogDummyReq getPvDummyLogRequest() {
        return this.getPvDummyLogRequest();
    }

    private void hideKeyboard(EditText editText0) {
        if(editText0 == null) {
            return;
        }
        InputMethodUtils.hideInputMethod(this.getContext(), editText0);
    }

    private void lambda$new$0(ActivityResult activityResult0) {
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                this.updateAttachmentLayout(((ArrayList)CompatUtils.getSerializableExtra(intent0, "attachResultValues", ArrayList.class)));
            }
        }
    }

    private void lambda$showKeyboard$1(EditText editText0) {
        InputMethodUtils.showInputMethod(this.getContext(), editText0);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        MediaAttachmentLayout mediaAttachmentLayout0 = this.mAttachmentLayout;
        if(mediaAttachmentLayout0 != null) {
            List list0 = mediaAttachmentLayout0.getAttachInfos();
            this.mAttachmentLayout.removeAllViews();
            this.updateAttachmentLayout(((ArrayList)list0));
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            Window window0 = fragmentActivity0.getWindow();
            if(window0 != null) {
                F.v(window0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        LogU.d("CmtWriteFragment", "Layout theme = " + this.mParam.theme);
        return layoutInflater0.inflate(0x7F0D02A2, viewGroup0, false);  // layout:fragment_cmt_write
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onDestroy() {
        ImageSelector imageSelector0 = this.mImageSelector;
        if(imageSelector0 != null) {
            imageSelector0.cleanUp();
        }
        if(d.h == null) {
            d.h = new d();
        }
        d d0 = d.h;
        if(d0 != null) {
            d0.e = this;
            d0.a();
            super.onDestroy();
            return;
        }
        q.m("mInstance");
        throw null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(EventKakaoLogin eventKakaoLogin0) {
        StringBuilder stringBuilder0 = new StringBuilder("EventKakaoLogin >> loginType: ");
        Z.s(eventKakaoLogin0.loginType, "CmtWriteFragment", stringBuilder0);
        if(eventKakaoLogin0.loginType == 2) {
            if(d.h == null) {
                d.h = new d();
            }
            d d0 = d.h;
            if(d0 != null) {
                d0.e = this;
                d0.b(this.emoticonClickListener);
                return;
            }
            q.m("mInstance");
            throw null;
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        Z.w("onFetchStart reason:", s, "CmtWriteFragment");
        return false;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onForeground() {
        super.onForeground();
        this.showKeyboard(this.mEdtRegister);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onPause() {
        super.onPause();
        this.hideKeyboard(this.mEdtRegister);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        String s = bundle0.getString("argCmtBundleParamKey");
        Param cmtWriteFragment$Param0 = this.getCachedLoadPgnRes(s);
        this.mParam = cmtWriteFragment$Param0;
        if(cmtWriteFragment$Param0 != null) {
            this.mLoadPgnRes = cmtWriteFragment$Param0.loadPgnRes;
            a.c(this.getContext(), s, true);
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onResume() {
        super.onResume();
        MediaAttachmentLayout mediaAttachmentLayout0 = this.mAttachmentLayout;
        if(mediaAttachmentLayout0 != null) {
            List list0 = mediaAttachmentLayout0.getAttachInfos();
            if(list0.size() > 0) {
                this.mAttachmentLayout.removeAllViews();
                this.updateAttachmentLayout(((ArrayList)list0));
            }
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            String s = MelonContentUris.g.buildUpon().appendPath("argCmtBundleParamKey").appendPath(String.valueOf(this.mParam.chnlSeq)).build().toString();
            bundle0.putString("argCmtBundleParamKey", s);
            a.a(MelonAppBase.instance.getContext(), this.mParam, s);
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        int v1;
        super.onViewCreated(view0, bundle0);
        View view1 = view0.findViewById(0x7F0A032D);  // id:container_layout
        this.containerLayout = view1;
        view1.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override  // android.view.View$OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view0, WindowInsets windowInsets0) {
                int v = s.B();
                Insets insets0 = windowInsets0.getInsets(v);
                ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
                viewGroup$MarginLayoutParams0.topMargin = 0;
                viewGroup$MarginLayoutParams0.bottomMargin = insets0.bottom;
                view0.setLayoutParams(viewGroup$MarginLayoutParams0);
                view0.requestLayout();
                return n0.j().setInsets(v, insets0).build();
            }
        });
        if(!this.isLoadPgnResValid("onViewCreated")) {
            return;
        }
        o o0 = null;
        this.fetchStartForEdit(i.b, null, "onViewCreated");
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            p p0 = new p(1);
            m m0 = new m(2, 0);
            m0.m = this.getString(0x7F130B32);  // string:talkback_gnb_cmt_write_info "댓글쓰기 안내 열기"
            com.iloen.melon.fragments.comments.CmtWriteFragment.3 cmtWriteFragment$30 = (/* 缺少LAMBDA参数 */) -> {
                LogU.d("CmtWriteFragment", "openCautionPopup()");
                com.melon.ui.popup.b.f(CmtWriteFragment.this.getContext(), CmtWriteFragment.this.getChildFragmentManager(), CmtWriteFragment.this.getString(0x7F1300D0));  // string:alert_dlg_title_info "안내"
            };
            if(m0.j != 0) {
                m0.l = cmtWriteFragment$30;
            }
            A a0 = new A();  // 初始化器: Ljava/lang/Object;-><init>()V
            this.registerButton = a0;
            a0.h(this.getString(0x7F130C1E));  // string:talkback_registration_btn "등록 버튼"
            A a1 = this.registerButton;
            a1.c = (/* 缺少LAMBDA参数 */) -> {
                LogU.d("CmtWriteFragment", "performRegister()");
                if(CmtWriteFragment.this.isLoadPgnResValid("writeAdcmt") && CmtWriteFragment.this.isFragmentValid()) {
                    if(!CmtWriteFragment.this.isLoginUser()) {
                        CmtWriteFragment.this.showLoginPopup();
                        return;
                    }
                    MelonEditText melonEditText0 = CmtWriteFragment.this.mEdtRegister;
                    if(melonEditText0 != null && CmtWriteFragment.this.mAttachmentLayout != null) {
                        int v = melonEditText0.getText().toString().trim().length();
                        int v1 = CmtWriteFragment.this.mLoadPgnRes.result.chnlinfo.cmtregminlength > 0 ? CmtWriteFragment.this.mLoadPgnRes.result.chnlinfo.cmtregminlength : 3;
                        if(v < v1) {
                            String s = v == 0 ? "내용을 입력해주세요." : String.format(CmtWriteFragment.this.getString(0x7F13084C), v1);  // string:popup_cmt_write_min_limit "%d자 이상의 글을 작성해주세요."
                            l0 l00 = CmtWriteFragment.this.getChildFragmentManager();
                            String s1 = CmtWriteFragment.this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                            com.melon.ui.popup.b.a.c(l00, s1, s);
                            return;
                        }
                        List list0 = CmtWriteFragment.this.mAttachmentLayout.getAttachInfos();
                        if(list0 != null) {
                            for(Object object0: list0) {
                                MediaAttachInfo mediaAttachInfo0 = (MediaAttachInfo)object0;
                                if((MediaAttachType.f.equals(mediaAttachInfo0.a) || MediaAttachType.g.equals(mediaAttachInfo0.a)) && TextUtils.isEmpty(mediaAttachInfo0.h)) {
                                    String s2 = mediaAttachInfo0.g;
                                    if(!TextUtils.isEmpty(s2) && !s2.startsWith("http://") && !s2.startsWith("https://")) {
                                        CmtWriteFragment.this.uploadAuthPhotoAttachment(mediaAttachInfo0);
                                        return;
                                    }
                                    if(false) {
                                        break;
                                    }
                                }
                            }
                        }
                        CmtWriteFragment.this.registerOrUpdateCmt();
                        return;
                    }
                    LogU.w("CmtWriteFragment", "onClick() register - invalid object");
                }
            };
            o[] arr_o = {p0, m0, this.registerButton};
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
            titleBar0.setTitle("글쓰기");
            titleBar0.f(true);
        }
        this.mImageSelector = new ImageSelector(this, this.mImageSelectorListener);
        MediaAttachmentLayout mediaAttachmentLayout0 = (MediaAttachmentLayout)view0.findViewById(0x7F0A00C9);  // id:attach_container
        this.mAttachmentLayout = mediaAttachmentLayout0;
        mediaAttachmentLayout0.setOnAttachmentClickListener(new c0() {
            // 检测为 Lambda 实现
            private H lambda$onAttachmentBtnClick$0(MediaAttachmentLayout mediaAttachmentLayout0, MediaAttachmentView mediaAttachmentView0) [...]

            @Override  // com.iloen.melon.custom.c0
            public void onAttachmentBtnClick(MediaAttachmentLayout mediaAttachmentLayout0, MediaAttachmentView mediaAttachmentView0) {
                com.melon.ui.popup.b.v(CmtWriteFragment.this.getChildFragmentManager(), CmtWriteFragment.this.getString(0x7F1300D0), CmtWriteFragment.this.getString(0x7F1301DA), false, null, null, () -> {
                    CmtWriteFragment.J0(CmtWriteFragment.this);
                    mediaAttachmentLayout0.removeView(mediaAttachmentView0);
                    return null;
                }, null);
            }

            @Override  // com.iloen.melon.custom.c0
            public void onAttachmentClick(MediaAttachmentLayout mediaAttachmentLayout0, MediaAttachmentView mediaAttachmentView0) {
            }

            @Override  // com.iloen.melon.custom.c0
            public void onAttachmentImageClick(MediaAttachmentLayout mediaAttachmentLayout0, MediaAttachmentView mediaAttachmentView0) {
                MediaAttachInfo mediaAttachInfo0 = mediaAttachmentView0.getAttachInfo();
                if(!MediaAttachType.g.equals(mediaAttachInfo0.a) && !MediaAttachType.f.equals(mediaAttachInfo0.a)) {
                    return;
                }
                Navigator.openPhotoUrl((TextUtils.isEmpty(mediaAttachInfo0.h) ? mediaAttachInfo0.g : mediaAttachInfo0.h));
            }
        });
        view0.findViewById(0x7F0A0589).setOnTouchListener(new View.OnTouchListener() {  // id:input_text_scrollview
            @Override  // android.view.View$OnTouchListener
            public boolean onTouch(View view0, MotionEvent motionEvent0) {
                if(motionEvent0.getAction() == 1) {
                    CmtWriteFragment.this.showKeyboard(CmtWriteFragment.this.mEdtRegister);
                }
                return false;
            }
        });
        MelonEditText melonEditText0 = (MelonEditText)view0.findViewById(0x7F0A0412);  // id:edt_register
        this.mEdtRegister = melonEditText0;
        melonEditText0.setImeOptions(6);
        this.mEdtRegister.setTextLimitUpdate(true);
        this.mEdtRegister.setTextWatcher(this.mTextWatcher);
        TextView textView0 = (TextView)view0.findViewById(0x7F0A0588);  // id:input_text_limit
        CHNLINFO loadPgnRes$result$CHNLINFO0 = this.mLoadPgnRes.result.chnlinfo;
        if(loadPgnRes$result$CHNLINFO0 == null) {
            v1 = 1000;
        }
        else {
            String s = loadPgnRes$result$CHNLINFO0.mobilecmtplaceholdertext;
            if(!TextUtils.isEmpty(s)) {
                this.mEdtRegister.setHint(s);
            }
            v1 = this.mLoadPgnRes.result.chnlinfo.cmtregmaxlength;
        }
        this.mEdtRegister.b(w.I(v1), textView0);
        this.mBtnAttachSong = (ImageView)view0.findViewById(0x7F0A060B);  // id:iv_btn_attach_song
        this.mBtnAttachPhoto = (ImageView)view0.findViewById(0x7F0A060A);  // id:iv_btn_attach_photo
        this.mBtnAttachVideo = (ImageView)view0.findViewById(0x7F0A060C);  // id:iv_btn_attach_video
        this.mBtnAttachLink = (ImageView)view0.findViewById(0x7F0A0609);  // id:iv_btn_attach_link
        this.mBtnAttachKakaoEmoticon = (ImageView)view0.findViewById(0x7F0A0608);  // id:iv_btn_attach_kakao_emoticon
        ViewUtils.showWhen(this.mBtnAttachSong, this.mLoadPgnRes.result.chnlinfo.musicatachuseflag);
        ViewUtils.showWhen(this.mBtnAttachPhoto, this.mLoadPgnRes.result.chnlinfo.imageatachuseflag);
        ViewUtils.showWhen(this.mBtnAttachVideo, this.mLoadPgnRes.result.chnlinfo.vdoatachuseflag);
        ViewUtils.showWhen(this.mBtnAttachLink, this.mLoadPgnRes.result.chnlinfo.linkatachuseflag);
        ViewUtils.showWhen(this.mBtnAttachKakaoEmoticon, this.mLoadPgnRes.result.chnlinfo.kakaoemoticonatachuseflag);
        ViewUtils.hideWhen(this.findViewById(0x7F0A0115), !this.mLoadPgnRes.result.chnlinfo.atachuseflag);  // id:bottom_btn_container
        this.mBtnAttachSong.setOnClickListener(new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                String s = CmtWriteFragment.this.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
                String s1 = CmtWriteFragment.this.getString(0x7F130E02);  // string:tiara_common_layer1_page_menu "Pagemenu"
                String s2 = CmtWriteFragment.this.getString(0x7F130D02);  // string:tiara_click_copy_attach_music "음악첨부"
                CmtWriteFragment.this.itemClickLog(s, ActionKind.ClickContent, s1, s2, false, null, null, null);
                com.iloen.melon.fragments.comments.CmtAttachFragment.Param cmtAttachFragment$Param0 = new com.iloen.melon.fragments.comments.CmtAttachFragment.Param();
                cmtAttachFragment$Param0.viewType = 0;
                cmtAttachFragment$Param0.theme = CmtWriteFragment.this.mParam.theme;
                Intent intent0 = new Intent(CmtWriteFragment.this.getActivity(), CmtAttachActivity.class);
                intent0.putExtra("argCmtParam", cmtAttachFragment$Param0);
                CmtWriteFragment.this.activityResult.b(intent0);
            }
        });
        this.mBtnAttachPhoto.setOnClickListener(new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(CmtWriteFragment.this.mImageSelector != null) {
                    String s = CmtWriteFragment.this.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
                    String s1 = CmtWriteFragment.this.getString(0x7F130E02);  // string:tiara_common_layer1_page_menu "Pagemenu"
                    String s2 = CmtWriteFragment.this.getString(0x7F130D00);  // string:tiara_click_copy_attach_image "사진첨부"
                    CmtWriteFragment.this.itemClickLog(s, ActionKind.ClickContent, s1, s2, false, null, null, null);
                    Request imageSelector$Request0 = Request.newNormalImage(null);
                    CmtWriteFragment.this.mImageSelector.startSelector(imageSelector$Request0);
                }
            }
        });
        this.mBtnAttachVideo.setOnClickListener(new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                String s = CmtWriteFragment.this.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
                String s1 = CmtWriteFragment.this.getString(0x7F130E02);  // string:tiara_common_layer1_page_menu "Pagemenu"
                String s2 = CmtWriteFragment.this.getString(0x7F130D03);  // string:tiara_click_copy_attach_mv "비디오첨부"
                CmtWriteFragment.this.itemClickLog(s, ActionKind.ClickContent, s1, s2, false, null, null, null);
                com.iloen.melon.fragments.comments.CmtAttachFragment.Param cmtAttachFragment$Param0 = new com.iloen.melon.fragments.comments.CmtAttachFragment.Param();
                cmtAttachFragment$Param0.viewType = 1;
                cmtAttachFragment$Param0.searchType = "video";
                cmtAttachFragment$Param0.theme = CmtWriteFragment.this.mParam.theme;
                Intent intent0 = new Intent(CmtWriteFragment.this.getActivity(), CmtAttachActivity.class);
                intent0.putExtra("argCmtParam", cmtAttachFragment$Param0);
                CmtWriteFragment.this.activityResult.b(intent0);
            }
        });
        this.mBtnAttachLink.setOnClickListener(new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                String s = CmtWriteFragment.this.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
                String s1 = CmtWriteFragment.this.getString(0x7F130E02);  // string:tiara_common_layer1_page_menu "Pagemenu"
                String s2 = CmtWriteFragment.this.getString(0x7F130D01);  // string:tiara_click_copy_attach_link "링크첨부"
                CmtWriteFragment.this.itemClickLog(s, ActionKind.ClickContent, s1, s2, false, null, null, null);
                com.iloen.melon.fragments.comments.CmtAttachFragment.Param cmtAttachFragment$Param0 = new com.iloen.melon.fragments.comments.CmtAttachFragment.Param();
                cmtAttachFragment$Param0.viewType = 2;
                cmtAttachFragment$Param0.spamInfo = CmtWriteFragment.this.mLoadPgnRes.result.spaminfo;
                cmtAttachFragment$Param0.theme = CmtWriteFragment.this.mParam.theme;
                Intent intent0 = new Intent(CmtWriteFragment.this.getActivity(), CmtAttachActivity.class);
                intent0.putExtra("argCmtParam", cmtAttachFragment$Param0);
                CmtWriteFragment.this.activityResult.b(intent0);
            }
        });
        this.mBtnAttachKakaoEmoticon.setOnClickListener(new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                String s = CmtWriteFragment.this.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
                String s1 = CmtWriteFragment.this.getString(0x7F130E02);  // string:tiara_common_layer1_page_menu "Pagemenu"
                String s2 = CmtWriteFragment.this.getString(0x7F130CFF);  // string:tiara_click_copy_attach_emoticon "이모지첨부"
                CmtWriteFragment.this.itemClickLog(s, ActionKind.ClickContent, s1, s2, false, null, null, null);
                CmtWriteFragment cmtWriteFragment0 = CmtWriteFragment.this;
                q.g(cmtWriteFragment0, "fragment");
                if(d.h == null) {
                    d.h = new d();
                }
                d d0 = d.h;
                if(d0 != null) {
                    d0.e = cmtWriteFragment0;
                    d0.b(CmtWriteFragment.this.emoticonClickListener);
                    return;
                }
                q.m("mInstance");
                throw null;
            }
        });

        class com.iloen.melon.fragments.comments.CmtWriteFragment.3 implements View.OnClickListener {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                CmtWriteFragment.this.openCautionPopup();
            }
        }


        class com.iloen.melon.fragments.comments.CmtWriteFragment.4 implements View.OnClickListener {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                CmtWriteFragment.this.performRegister();
            }
        }

    }

    // 检测为 Lambda 实现
    private void openCautionPopup() [...]

    // 检测为 Lambda 实现
    private void performRegister() [...]

    private void registerCmt() {
        LogU.d("CmtWriteFragment", "registerCmt()");
        com.iloen.melon.net.v3x.comments.InsertCmtReq.Params insertCmtReq$Params0 = new com.iloen.melon.net.v3x.comments.InsertCmtReq.Params();
        insertCmtReq$Params0.chnlSeq = this.mParam.chnlSeq;
        insertCmtReq$Params0.contsRefValue = this.mParam.contsRefValue;
        insertCmtReq$Params0.secrtFlag = false;
        insertCmtReq$Params0.stickerSeq = "-1";
        insertCmtReq$Params0.atachList = new ArrayList();
        AtachList insertCmtReq$Params$AtachList0 = new AtachList();
        insertCmtReq$Params$AtachList0.atachType = "text";
        insertCmtReq$Params$AtachList0.atachValue = this.mEdtRegister.getText().toString();
        insertCmtReq$Params0.atachList.add(insertCmtReq$Params$AtachList0);
        this.emoticonViewParam = null;
        List list0 = this.mAttachmentLayout.getAttachInfos();
        if(list0 != null) {
            for(Object object0: list0) {
                MediaAttachInfo mediaAttachInfo0 = (MediaAttachInfo)object0;
                ArrayList arrayList0 = insertCmtReq$Params0.atachList;
                AtachList insertCmtReq$Params$AtachList1 = new AtachList();
                v9.a a0 = v9.b.b(mediaAttachInfo0);
                if(a0 != null) {
                    insertCmtReq$Params$AtachList1.atachType = a0.a;
                    insertCmtReq$Params$AtachList1.atachValue = a0.b;
                    if(MediaAttachType.i.equals(mediaAttachInfo0.a)) {
                        insertCmtReq$Params$AtachList1.atachVideoTitle = a0.c;
                        insertCmtReq$Params$AtachList1.atachThumbUrl = a0.d;
                        insertCmtReq$Params$AtachList1.atachVideoWidth = a0.e;
                        insertCmtReq$Params$AtachList1.atachVideoHeight = a0.f;
                    }
                }
                arrayList0.add(insertCmtReq$Params$AtachList1);
                if(MediaAttachType.j.equals(mediaAttachInfo0.a)) {
                    this.emoticonViewParam = EmoticonViewParam.get(mediaAttachInfo0.X);
                }
            }
        }
        RequestBuilder.newInstance(new InsertCmtReq(this.getContext(), insertCmtReq$Params0)).tag("CmtWriteFragment").listener(new Listener() {
            public void onResponse(InsertCmtRes insertCmtRes0) {
                if(insertCmtRes0.isSuccessful()) {
                    String s = insertCmtRes0.getClass().getName();
                    if(CmtWriteFragment.this.isLoadPgnResValid(s)) {
                        result insertCmtRes$result0 = insertCmtRes0.result;
                        if(insertCmtRes$result0 == null || TextUtils.isEmpty(insertCmtRes$result0.message)) {
                            ToastManager.showShort(0x7F1301F2);  // string:cmt_write_success "등록되었습니다."
                        }
                        else if(CmtWriteFragment.this.isFragmentValid()) {
                            l0 l00 = CmtWriteFragment.this.getChildFragmentManager();
                            String s1 = CmtWriteFragment.this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                            com.melon.ui.popup.b.a.c(l00, s1, insertCmtRes$result0.message);
                        }
                        if(CmtWriteFragment.this.emoticonViewParam != null) {
                            EmoticonViewParam emoticonViewParam0 = CmtWriteFragment.this.emoticonViewParam;
                            q.g(emoticonViewParam0, "param");
                            KakaoEmoticon.pushLog(emoticonViewParam0);
                        }
                        if(CmtWriteFragment.this.isFragmentValid()) {
                            Bundle bundle0 = Y.b("type", "count");
                            bundle0.putSerializable("data", new EventComment("count", CmtWriteFragment.this.mParam.chnlSeq, -1, false, null, CmtWriteFragment.this.mParam.contsRefValue, true));
                            CmtWriteFragment.this.requireActivity().getSupportFragmentManager().i0(bundle0, "comment_request_key");
                        }
                        TimeExpiredCache.getInstance().remove(CmtWriteFragment.this.mParam.cacheKeyOfCmtList);
                        CmtWriteFragment.this.removeRelatedCache();
                        TimeExpiredCache.getInstance().remove(CmtWriteFragment.this.mParam.cacheKeyOfTargetPage);
                        CmtWriteFragment.this.performBackPress();
                        return;
                    }
                }
                CmtWriteFragment.this.performCmtFetchErrorPopup(insertCmtRes0.errormessage, insertCmtRes0.status);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((InsertCmtRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }).request();
    }

    private void registerOrUpdateCmt() {
        if(((Param)this.mParam).cmtseq == -1) {
            this.registerCmt();
            return;
        }
        this.updateCmt();
    }

    private boolean setAttachInfo(MediaAttachInfo mediaAttachInfo0) {
        if(mediaAttachInfo0 == null) {
            LogU.d("CmtWriteFragment", "setAttachInfo() invalid paramter");
            return false;
        }
        MediaAttachmentLayout mediaAttachmentLayout0 = this.mAttachmentLayout;
        if(mediaAttachmentLayout0 == null) {
            LogU.d("CmtWriteFragment", "setAttachInfo() invalid mAttachmentLayout");
            return false;
        }
        mediaAttachmentLayout0.removeAllViews();
        if(this.mAttachmentLayout.getCount() >= 1) {
            LogU.w("CmtWriteFragment", "setAttachInfo() attach max limit");
            return false;
        }
        mediaAttachInfo0.b = 3;
        mediaAttachInfo0.W = this.mParam.theme;
        this.mAttachmentLayout.a(mediaAttachInfo0);
        if(!MediaAttachType.c.equals(mediaAttachInfo0.a) && !MediaAttachType.d.equals(mediaAttachInfo0.a) && !MediaAttachType.e.equals(mediaAttachInfo0.a)) {
            if(MediaAttachType.h.equals(mediaAttachInfo0.a)) {
                this.updateAttachBtn(0x7F0A060C);  // id:iv_btn_attach_video
                return true;
            }
            if(!MediaAttachType.g.equals(mediaAttachInfo0.a) && !MediaAttachType.f.equals(mediaAttachInfo0.a)) {
                if(MediaAttachType.i.equals(mediaAttachInfo0.a)) {
                    this.updateAttachBtn(0x7F0A0609);  // id:iv_btn_attach_link
                    return true;
                }
                if(MediaAttachType.j.equals(mediaAttachInfo0.a)) {
                    this.updateAttachBtn(0x7F0A0608);  // id:iv_btn_attach_kakao_emoticon
                }
                return true;
            }
            this.updateAttachBtn(0x7F0A060A);  // id:iv_btn_attach_photo
            return true;
        }
        this.updateAttachBtn(0x7F0A060B);  // id:iv_btn_attach_song
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    private void showKeyboard(EditText editText0) {
        if(editText0 == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new l(21, this, editText0), 100L);
    }

    private void updateAttachBtn(int v) {
        ImageView imageView0 = this.mBtnAttachSong;
        if(imageView0 != null && this.mBtnAttachPhoto != null && this.mBtnAttachVideo != null && this.mBtnAttachLink != null && this.mBtnAttachKakaoEmoticon != null) {
            if(0x7F0A060B == v) {  // id:iv_btn_attach_song
                imageView0.setImageResource(0x7F0800ED);  // drawable:btn_attach_song_on
                this.mBtnAttachPhoto.setImageResource(0x7F0800EA);  // drawable:btn_attach_photo_off
                this.mBtnAttachVideo.setImageResource(0x7F0800EE);  // drawable:btn_attach_video_off
                this.mBtnAttachLink.setImageResource(0x7F0800E8);  // drawable:btn_attach_link_off
                this.mBtnAttachKakaoEmoticon.setImageResource(0x7F0800E6);  // drawable:btn_attach_kakao_off
                return;
            }
            if(0x7F0A060A == v) {  // id:iv_btn_attach_photo
                imageView0.setImageResource(0x7F0800EC);  // drawable:btn_attach_song_off
                this.mBtnAttachPhoto.setImageResource(0x7F0800EB);  // drawable:btn_attach_photo_on
                this.mBtnAttachVideo.setImageResource(0x7F0800EE);  // drawable:btn_attach_video_off
                this.mBtnAttachLink.setImageResource(0x7F0800E8);  // drawable:btn_attach_link_off
                this.mBtnAttachKakaoEmoticon.setImageResource(0x7F0800E6);  // drawable:btn_attach_kakao_off
                return;
            }
            if(0x7F0A060C == v) {  // id:iv_btn_attach_video
                imageView0.setImageResource(0x7F0800EC);  // drawable:btn_attach_song_off
                this.mBtnAttachPhoto.setImageResource(0x7F0800EA);  // drawable:btn_attach_photo_off
                this.mBtnAttachVideo.setImageResource(0x7F0800EF);  // drawable:btn_attach_video_on
                this.mBtnAttachLink.setImageResource(0x7F0800E8);  // drawable:btn_attach_link_off
                this.mBtnAttachKakaoEmoticon.setImageResource(0x7F0800E6);  // drawable:btn_attach_kakao_off
                return;
            }
            if(0x7F0A0609 == v) {  // id:iv_btn_attach_link
                imageView0.setImageResource(0x7F0800EC);  // drawable:btn_attach_song_off
                this.mBtnAttachPhoto.setImageResource(0x7F0800EA);  // drawable:btn_attach_photo_off
                this.mBtnAttachVideo.setImageResource(0x7F0800EE);  // drawable:btn_attach_video_off
                this.mBtnAttachLink.setImageResource(0x7F0800E9);  // drawable:btn_attach_link_on
                this.mBtnAttachKakaoEmoticon.setImageResource(0x7F0800E6);  // drawable:btn_attach_kakao_off
                return;
            }
            if(0x7F0A0608 == v) {  // id:iv_btn_attach_kakao_emoticon
                imageView0.setImageResource(0x7F0800EC);  // drawable:btn_attach_song_off
                this.mBtnAttachPhoto.setImageResource(0x7F0800EA);  // drawable:btn_attach_photo_off
                this.mBtnAttachVideo.setImageResource(0x7F0800EE);  // drawable:btn_attach_video_off
                this.mBtnAttachLink.setImageResource(0x7F0800E8);  // drawable:btn_attach_link_off
                this.mBtnAttachKakaoEmoticon.setImageResource(0x7F0800E7);  // drawable:btn_attach_kakao_on
                return;
            }
            imageView0.setImageResource(0x7F0800EC);  // drawable:btn_attach_song_off
            this.mBtnAttachPhoto.setImageResource(0x7F0800EA);  // drawable:btn_attach_photo_off
            this.mBtnAttachVideo.setImageResource(0x7F0800EE);  // drawable:btn_attach_video_off
            this.mBtnAttachLink.setImageResource(0x7F0800E8);  // drawable:btn_attach_link_off
            this.mBtnAttachKakaoEmoticon.setImageResource(0x7F0800E6);  // drawable:btn_attach_kakao_off
        }
    }

    private void updateAttachmentLayout(String s) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("CmtWriteFragment", "updateAttachmentLayout() invalid paramter");
            return;
        }
        MediaAttachInfo mediaAttachInfo0 = new MediaAttachInfo();
        mediaAttachInfo0.a = MediaAttachType.g;
        mediaAttachInfo0.g = s;
        this.setAttachInfo(mediaAttachInfo0);
    }

    private void updateAttachmentLayout(ArrayList arrayList0) {
        if(this.mAttachmentLayout == null) {
            LogU.w("CmtWriteFragment", "updateAttachmentLayout() mAttachmentLayout invalid");
            return;
        }
        if(arrayList0 == null) {
            LogU.w("CmtWriteFragment", "updateAttachmentLayout() invalid paramter");
            return;
        }
        for(Object object0: arrayList0) {
            if(!this.setAttachInfo(((MediaAttachInfo)object0))) {
                break;
            }
        }
    }

    private void updateCmt() {
        LogU.d("CmtWriteFragment", "updateCmt()");
        com.iloen.melon.net.v3x.comments.UpdateCmtReq.Params updateCmtReq$Params0 = new com.iloen.melon.net.v3x.comments.UpdateCmtReq.Params();
        updateCmtReq$Params0.chnlSeq = this.mParam.chnlSeq;
        updateCmtReq$Params0.contsRefValue = this.mParam.contsRefValue;
        updateCmtReq$Params0.cmtSeq = ((Param)this.mParam).cmtseq;
        updateCmtReq$Params0.stickerSeq = "-1";
        updateCmtReq$Params0.atachList = new ArrayList();
        com.iloen.melon.net.v3x.comments.UpdateCmtReq.Params.AtachList updateCmtReq$Params$AtachList0 = new com.iloen.melon.net.v3x.comments.UpdateCmtReq.Params.AtachList();
        updateCmtReq$Params$AtachList0.atachType = "text";
        updateCmtReq$Params$AtachList0.atachValue = this.mEdtRegister.getText().toString();
        updateCmtReq$Params0.atachList.add(updateCmtReq$Params$AtachList0);
        this.emoticonViewParam = null;
        List list0 = this.mAttachmentLayout.getAttachInfos();
        if(list0 != null) {
            for(Object object0: list0) {
                MediaAttachInfo mediaAttachInfo0 = (MediaAttachInfo)object0;
                ArrayList arrayList0 = updateCmtReq$Params0.atachList;
                com.iloen.melon.net.v3x.comments.UpdateCmtReq.Params.AtachList updateCmtReq$Params$AtachList1 = new com.iloen.melon.net.v3x.comments.UpdateCmtReq.Params.AtachList();
                v9.a a0 = v9.b.b(mediaAttachInfo0);
                if(a0 != null) {
                    updateCmtReq$Params$AtachList1.atachType = a0.a;
                    updateCmtReq$Params$AtachList1.atachValue = a0.b;
                    if(MediaAttachType.i.equals(mediaAttachInfo0.a)) {
                        updateCmtReq$Params$AtachList1.atachVideoTitle = a0.c;
                        updateCmtReq$Params$AtachList1.atachThumbUrl = a0.d;
                        updateCmtReq$Params$AtachList1.atachVideoWidth = a0.e;
                        updateCmtReq$Params$AtachList1.atachVideoHeight = a0.f;
                    }
                }
                arrayList0.add(updateCmtReq$Params$AtachList1);
                if(MediaAttachType.j.equals(mediaAttachInfo0.a)) {
                    this.emoticonViewParam = EmoticonViewParam.get(mediaAttachInfo0.X);
                }
            }
        }
        RequestBuilder.newInstance(new UpdateCmtReq(this.getContext(), updateCmtReq$Params0)).tag("CmtWriteFragment").listener(new Listener() {
            public void onResponse(UpdateCmtRes updateCmtRes0) {
                if(updateCmtRes0.isSuccessful()) {
                    String s = updateCmtRes0.getClass().getName();
                    if(CmtWriteFragment.this.isLoadPgnResValid(s)) {
                        com.iloen.melon.net.v3x.comments.UpdateCmtRes.result updateCmtRes$result0 = updateCmtRes0.result;
                        if(updateCmtRes$result0 == null || TextUtils.isEmpty(updateCmtRes$result0.message)) {
                            ToastManager.showShort(0x7F1301F2);  // string:cmt_write_success "등록되었습니다."
                        }
                        else if(CmtWriteFragment.this.isFragmentValid()) {
                            l0 l00 = CmtWriteFragment.this.getChildFragmentManager();
                            String s1 = CmtWriteFragment.this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                            com.melon.ui.popup.b.a.c(l00, s1, updateCmtRes$result0.message);
                        }
                        if(CmtWriteFragment.this.emoticonViewParam != null) {
                            EmoticonViewParam emoticonViewParam0 = CmtWriteFragment.this.emoticonViewParam;
                            q.g(emoticonViewParam0, "param");
                            KakaoEmoticon.pushLog(emoticonViewParam0);
                        }
                        TimeExpiredCache.getInstance().remove(CmtWriteFragment.this.mParam.cacheKeyOfCmtList);
                        TimeExpiredCache.getInstance().remove(CmtWriteFragment.this.mParam.cacheKeyOfAdcmtList);
                        CmtWriteFragment.this.removeRelatedCache();
                        TimeExpiredCache.getInstance().remove(CmtWriteFragment.this.mParam.cacheKeyOfTargetPage);
                        if(CmtWriteFragment.this.isFragmentValid()) {
                            Bundle bundle0 = Y.b("type", "count");
                            com.iloen.melon.fragments.comments.CmtBaseFragment.Param cmtBaseFragment$Param0 = CmtWriteFragment.this.mParam;
                            bundle0.putSerializable("data", new EventComment("count", cmtBaseFragment$Param0.chnlSeq, ((Param)cmtBaseFragment$Param0).cmtseq, false, null, cmtBaseFragment$Param0.contsRefValue, false));
                            CmtWriteFragment.this.requireActivity().getSupportFragmentManager().i0(bundle0, "comment_request_key");
                        }
                        CmtWriteFragment.this.performBackPress();
                        return;
                    }
                }
                CmtWriteFragment.this.performCmtFetchErrorPopup(updateCmtRes0.errormessage, updateCmtRes0.status);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((UpdateCmtRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }).request();
    }

    private void updateView(InformCmtRes informCmtRes0) {
        if(informCmtRes0 != null) {
            com.iloen.melon.net.v3x.comments.InformCmtRes.result informCmtRes$result0 = informCmtRes0.result;
            if(informCmtRes$result0 != null) {
                CMTINFO informCmtRes$result$CMTINFO0 = informCmtRes$result0.cmtinfo;
                if(informCmtRes$result$CMTINFO0 != null) {
                    if(this.mEdtRegister != null) {
                        String s = informCmtRes$result$CMTINFO0.cmtcont;
                        s = TextUtils.isEmpty(s) ? informCmtRes$result$CMTINFO0.cmtcont : s.replaceAll("\n", "<br>");
                        this.mEdtRegister.setText(Html.fromHtml(s, 0));
                        ViewUtils.setSelection(this.mEdtRegister);
                    }
                    com.iloen.melon.net.v3x.comments.InformCmtRes.result informCmtRes$result1 = informCmtRes0.result;
                    if(informCmtRes$result1.cmtinfo.atachcnt > 0) {
                        ArrayList arrayList0 = informCmtRes$result1.atachlist;
                        if(arrayList0 != null) {
                            ArrayList arrayList1 = new ArrayList();
                            for(Object object0: arrayList0) {
                                ATACHLIST informCmtRes$result$ATACHLIST0 = (ATACHLIST)object0;
                                String s1 = informCmtRes$result$ATACHLIST0.atachtype;
                                if(!"image".equals(s1) && !"music_album".equals(s1) && !"music_artist".equals(s1) && !"music_song".equals(s1) && !"video".equals(s1) && !"link_video".equals(s1) && !"kakao_emoticon".equals(s1)) {
                                    LogU.w("CmtWriteFragment", "updateView() not supported atachType:" + s1);
                                }
                                else {
                                    MediaAttachInfo mediaAttachInfo0 = v9.b.a(informCmtRes$result$ATACHLIST0);
                                    if(mediaAttachInfo0 != null) {
                                        arrayList1.add(mediaAttachInfo0);
                                    }
                                }
                            }
                            if(arrayList1.size() > 0) {
                                this.updateAttachmentLayout(arrayList1);
                            }
                        }
                    }
                    return;
                }
            }
        }
        LogU.w("CmtWriteFragment", "updateView() invalid response");
    }

    private void uploadAuthPhotoAttachment(MediaAttachInfo mediaAttachInfo0) {
        RequestBuilder.newInstance(new AuthhsJsonReq(this.getContext(), this.getImageUploadDomain())).tag("CmtWriteFragment").listener(new Listener() {
            public void onResponse(AuthhsJsonRes authhsJsonRes0) {
                if(!CmtWriteFragment.this.isFragmentValid()) {
                    return;
                }
                LogU.d("CmtWriteFragment", "response:" + authhsJsonRes0.toString());
                CmtWriteFragment.this.uploadPhotoAttachment(mediaAttachInfo0, authhsJsonRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((AuthhsJsonRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                ToastManager.showShort(0x7F1301EA);  // string:cmt_photo_upload_fail "이미지를 첨부하는데 문제가 발생하였습니다."
                CmtWriteFragment.this.performFetchError(volleyError0);
            }
        }).request();
    }

    private void uploadPhotoAttachment(MediaAttachInfo mediaAttachInfo0, AuthhsJsonRes authhsJsonRes0) {
        RequestBuilder.newInstance(new HsUploadJsonReq(this.getContext(), authhsJsonRes0, mediaAttachInfo0.g, this.getImageUploadDomain())).tag("CmtWriteFragment").listener(new Listener() {
            public void onResponse(HsUploadJsonRes hsUploadJsonRes0) {
                if(!CmtWriteFragment.this.isFragmentValid()) {
                    return;
                }
                LogU.d("CmtWriteFragment", "response:" + hsUploadJsonRes0.toString());
                if(hsUploadJsonRes0.code == 0) {
                    mediaAttachInfo0.h = hsUploadJsonRes0.getFileUrl();
                    Z.x(new StringBuilder("uploadPhotoAttachment() originalUrl:"), mediaAttachInfo0.h, "CmtWriteFragment");
                    if(CmtWriteFragment.this.mImageSelector != null) {
                        CmtWriteFragment.this.mImageSelector.cleanUp();
                    }
                }
                CmtWriteFragment.this.registerOrUpdateCmt();
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((HsUploadJsonRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                ToastManager.showShort(0x7F1301EA);  // string:cmt_photo_upload_fail "이미지를 첨부하는데 문제가 발생하였습니다."
                CmtWriteFragment.this.performFetchError(volleyError0);
            }
        }).request();
    }

    public static void x0(CmtWriteFragment cmtWriteFragment0, EditText editText0) {
        cmtWriteFragment0.lambda$showKeyboard$1(editText0);
    }
}

