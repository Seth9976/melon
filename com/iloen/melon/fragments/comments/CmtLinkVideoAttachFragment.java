package com.iloen.melon.fragments.comments;

import B.a;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import b3.Z;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.activity.CmtAttachActivity;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.InputBarView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.InformOembedReq;
import com.iloen.melon.net.v3x.comments.InformOembedRes.result;
import com.iloen.melon.net.v3x.comments.InformOembedRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.SPAMINFO.VDOLINKATACHPERMURLLIST;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.SPAMINFO;
import com.iloen.melon.types.MediaAttachInfo;
import com.iloen.melon.types.MediaAttachType;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.CompatUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.popup.b;
import java.util.ArrayList;
import v9.h;
import v9.i;

public class CmtLinkVideoAttachFragment extends CmtBaseFragment implements View.OnClickListener {
    private static final String TAG = "CmtLinkVideoAttachFragment";
    private TextView mBtnConfirm;
    private InputBarView mInputBarView;
    private String mKeyword;
    private SPAMINFO mSpamInfo;
    private int mViewType;

    private void addAttachInfo(result informOembedRes$result0) {
        LogU.d("CmtLinkVideoAttachFragment", "addAttachInfo");
        if(informOembedRes$result0 != null) {
            MediaAttachInfo mediaAttachInfo0 = new MediaAttachInfo();
            mediaAttachInfo0.a = MediaAttachType.i;
            mediaAttachInfo0.h = informOembedRes$result0.videourl;
            mediaAttachInfo0.g = informOembedRes$result0.thumburl;
            mediaAttachInfo0.E = informOembedRes$result0.videotitle;
            mediaAttachInfo0.W = this.mParam.theme;
            FragmentActivity fragmentActivity0 = this.getActivity();
            if(fragmentActivity0 != null && fragmentActivity0 instanceof CmtAttachActivity) {
                ArrayList arrayList0 = new ArrayList();
                arrayList0.add(mediaAttachInfo0);
                Intent intent0 = new Intent();
                intent0.putExtra("attachResultValues", arrayList0);
                if(fragmentActivity0.getParent() == null) {
                    fragmentActivity0.setResult(-1, intent0);
                }
                else {
                    fragmentActivity0.getParent().setResult(-1, intent0);
                }
                fragmentActivity0.getOnBackPressedDispatcher().c();
                ToastManager.show(0x7F1301D9);  // string:cmt_attachment_add_message "첨부 되었습니다."
                return;
            }
            LogU.e("CmtLinkVideoAttachFragment", "addAttachInfo() invalid actvitiy");
        }
    }

    private void clearData() {
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.g.buildUpon().appendPath("cmtattachlinkvideo").appendQueryParameter("viewType", String.valueOf(this.mViewType)).build().toString();
    }

    public static CmtLinkVideoAttachFragment newInstance(Param cmtAttachFragment$Param0) {
        CmtLinkVideoAttachFragment cmtLinkVideoAttachFragment0 = new CmtLinkVideoAttachFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putSerializable("argCmtParam", cmtAttachFragment$Param0);
        cmtLinkVideoAttachFragment0.setArguments(bundle0);
        return cmtLinkVideoAttachFragment0;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == this.mBtnConfirm) {
            this.performSave();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
        LogU.d("CmtLinkVideoAttachFragment", "onCreate()");
        super.onCreate(bundle0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        LogU.d("CmtLinkVideoAttachFragment", "Layout theme = " + this.mParam.theme);
        return layoutInflater0.inflate(0x7F0D02A1, viewGroup0, false);  // layout:fragment_cmt_linkvideo_attach
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        Z.w("onFetchStart reason:", s, "CmtLinkVideoAttachFragment");
        return false;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onPause() {
        super.onPause();
        InputBarView inputBarView0 = this.mInputBarView;
        if(inputBarView0 != null) {
            inputBarView0.a();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        com.iloen.melon.fragments.comments.CmtBaseFragment.Param cmtBaseFragment$Param0 = (com.iloen.melon.fragments.comments.CmtBaseFragment.Param)CompatUtils.getSerializable(bundle0, "argCmtParam", Param.class);
        this.mParam = cmtBaseFragment$Param0;
        if(cmtBaseFragment$Param0 != null) {
            this.mViewType = ((Param)cmtBaseFragment$Param0).viewType;
            this.mSpamInfo = ((Param)cmtBaseFragment$Param0).spamInfo;
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putSerializable("argCmtParam", this.mParam);
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(2));
            titleBar0.setTitle("링크첨부");
            titleBar0.f(true);
        }
        this.mInputBarView = (InputBarView)this.findViewById(0x7F0A0582);  // id:input_bar
        TextView textView0 = (TextView)this.findViewById(0x7F0A0150);  // id:btn_confirm
        this.mBtnConfirm = textView0;
        ViewUtils.setOnClickListener(textView0, this);
    }

    private void performSave() {
        LogU.d("CmtLinkVideoAttachFragment", "performSave");
        InputBarView inputBarView0 = this.mInputBarView;
        if(inputBarView0 == null) {
            LogU.e("CmtLinkVideoAttachFragment", "performSave() invalid editText");
            return;
        }
        String s = inputBarView0.getInputText().trim();
        if(s.length() == 0) {
            this.showInvalidPopup();
            return;
        }
        SPAMINFO loadPgnRes$result$SPAMINFO0 = this.mSpamInfo;
        if(loadPgnRes$result$SPAMINFO0 != null) {
            ArrayList arrayList0 = loadPgnRes$result$SPAMINFO0.vdolinkatachpermurllist;
            if(arrayList0 != null && arrayList0.size() > 0) {
                for(Object object0: arrayList0) {
                    if(s.equals(((VDOLINKATACHPERMURLLIST)object0))) {
                        this.showInvalidPopup();
                        return;
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }
        RequestBuilder.newInstance(new InformOembedReq(this.getContext(), s)).tag("CmtLinkVideoAttachFragment").listener(new Listener() {
            public void onResponse(InformOembedRes informOembedRes0) {
                if(informOembedRes0.isSuccessful()) {
                    CmtLinkVideoAttachFragment.x0(CmtLinkVideoAttachFragment.this, informOembedRes0.result);
                    return;
                }
                CmtLinkVideoAttachFragment.this.performCmtFetchErrorToast(informOembedRes0.errormessage);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((InformOembedRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }).request();
    }

    private void showInvalidPopup() {
        l0 l00 = this.getChildFragmentManager();
        String s = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
        String s1 = this.getString(0x7F1301E2);  // string:cmt_invalid_link_video_attachment "링크 첨부는 유튜브 영상 링크만 가능합니다."
        b.a.c(l00, s, s1);
    }

    public void startFetchWithKeyword(String s) {
        if(TextUtils.isEmpty(s)) {
            ToastManager.showShort(0x7F1300B9);  // string:alert_dlg_body_search_text_empty "검색어를 입력해주세요."
            return;
        }
        this.mKeyword = s;
        this.startFetch("startFetchWithKeyword");
    }

    public static void x0(CmtLinkVideoAttachFragment cmtLinkVideoAttachFragment0, result informOembedRes$result0) {
        cmtLinkVideoAttachFragment0.addAttachInfo(informOembedRes$result0);
    }
}

