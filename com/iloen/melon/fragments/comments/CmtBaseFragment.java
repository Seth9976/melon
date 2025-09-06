package com.iloen.melon.fragments.comments;

import Ac.o4;
import Ac.v2;
import Jc.t0;
import Zc.N;
import a9.a;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.appcompat.app.o;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.RecyclerView;
import b.l;
import b3.Z;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.eventbus.EventComment;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.CancelRecmReq;
import com.iloen.melon.net.v3x.comments.CancelRecmRes.CancelResult.RecmInfo;
import com.iloen.melon.net.v3x.comments.CancelRecmRes.CancelResult;
import com.iloen.melon.net.v3x.comments.CancelRecmRes;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.CMTINFO;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.MEMBERINFO;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase;
import com.iloen.melon.net.v3x.comments.DeleteCmtReq.Params;
import com.iloen.melon.net.v3x.comments.DeleteCmtReq;
import com.iloen.melon.net.v3x.comments.DeleteCmtRes;
import com.iloen.melon.net.v3x.comments.InsertRecmReq;
import com.iloen.melon.net.v3x.comments.InsertRecmRes.InsertResult;
import com.iloen.melon.net.v3x.comments.InsertRecmRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.CHNLINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v3x.comments.PinnedReq;
import com.iloen.melon.net.v3x.comments.PinnedRes.PinnedResult;
import com.iloen.melon.net.v3x.comments.PinnedRes;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.v3.CommentConfig;
import com.melon.ui.popup.b;
import e1.u;
import ie.H;
import ie.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.q;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import p8.f;
import p8.g;
import v9.c;
import va.e0;
import vd.E;

public abstract class CmtBaseFragment extends DetailMetaContentBaseFragment {
    static class CmtPositionInfo {
        public int adapterPosition;
        public String cacheKey;
        public int chnlSeq;
        public int cmtSeq;
        public int dataPosition;

        public CmtPositionInfo(int v, int v1, int v2, int v3, String s) {
            this.chnlSeq = v;
            this.cmtSeq = v1;
            this.adapterPosition = v2;
            this.dataPosition = v3;
            this.cacheKey = s;
        }
    }

    public interface OnCmtRemoveListener {
        void onDataChanged();

        void onRemoveItem();
    }

    public static class Param implements Serializable {
        public String cacheKeyOfAdcmtList;
        public String cacheKeyOfCmtList;
        public String cacheKeyOfTargetPage;
        public int chnlSeq;
        public String contsRefValue;
        public boolean isReadOnly;
        private static final long serialVersionUID = 0x505A11130BEBD609L;
        public c theme;

        public Param() {
            this.chnlSeq = -1;
            this.isReadOnly = false;
            this.theme = c.a;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 == null || this.getClass() != object0.getClass() || this.chnlSeq != ((Param)object0).chnlSeq) {
                return false;
            }
            if(this.isReadOnly != ((Param)object0).isReadOnly) {
                return false;
            }
            String s = this.contsRefValue;
            if(s != null) {
                if(!s.equals(((Param)object0).contsRefValue)) {
                    return false;
                }
            }
            else if(((Param)object0).contsRefValue != null) {
                return false;
            }
            String s1 = this.cacheKeyOfCmtList;
            if(s1 != null) {
                if(!s1.equals(((Param)object0).cacheKeyOfCmtList)) {
                    return false;
                }
            }
            else if(((Param)object0).cacheKeyOfCmtList != null) {
                return false;
            }
            String s2 = this.cacheKeyOfAdcmtList;
            if(s2 != null) {
                return s2.equals(((Param)object0).cacheKeyOfAdcmtList) ? this.theme == ((Param)object0).theme : false;
            }
            return ((Param)object0).cacheKeyOfAdcmtList == null ? this.theme == ((Param)object0).theme : false;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = (((this.chnlSeq + 0x1F) * 0x1F + (this.contsRefValue == null ? 0 : this.contsRefValue.hashCode())) * 0x1F + this.isReadOnly) * 0x1F;
            int v2 = this.cacheKeyOfCmtList == null ? 0 : this.cacheKeyOfCmtList.hashCode();
            int v3 = this.cacheKeyOfAdcmtList == null ? 0 : this.cacheKeyOfAdcmtList.hashCode();
            c c0 = this.theme;
            if(c0 != null) {
                v = c0.hashCode();
            }
            return ((v1 + v2) * 0x1F + v3) * 0x1F + v;
        }

        @Override
        public String toString() {
            return "Param{chnlSeq=" + this.chnlSeq + ", contsRefValue=\'" + this.contsRefValue + "\', isReadOnly=" + this.isReadOnly + ", cacheKeyOfCmtList=\'" + this.cacheKeyOfCmtList + "\', cacheKeyOfAdcmtList=\'" + this.cacheKeyOfAdcmtList + "\', theme=" + this.theme + '}';
        }
    }

    public static final String ACTION_TYPE_COUNT_UPDATED = "count";
    public static final String ACTION_TYPE_RECOMMEND = "recommend";
    public static final String ACTION_TYPE_REPORT = "report";
    public static final String ARG_ATTACH_RESULT_VALUES = "attachResultValues";
    public static final String ARG_CMT_PARAM = "argCmtParam";
    protected static final int MAX_ADCMT_STRING_LENGTH = 200;
    protected static final int MAX_ATTACH_COUNT = 1;
    protected static final int MAX_CMT_STRING_LENGTH = 1000;
    protected static final int MIN_STRING_LENGTH = 3;
    protected static final int PAGE_MAX = 15;
    public static final int REQUEST_CODE_FOR_ATTACHMENT = 100;
    public static final String RESULT_PARAM_DATA = "data";
    public static final String RESULT_PARAM_TYPE = "type";
    public static final String RESULT_REQUEST_KEY = "comment_request_key";
    protected static final String TAG = "CmtBaseFragment";
    protected static final float TITLE_BAR_HEIGHT = 60.0f;
    protected static final float TITLE_BAR_TOP_PADDING = 6.0f;
    private HashMap cmtPositionInfoHashMap;
    private boolean isRequestRecmDone;
    protected LoadPgnRes mLoadPgnRes;
    protected ArrayList mOnCmtRemoveListenerList;
    protected Param mParam;

    public CmtBaseFragment() {
        this.isRequestRecmDone = true;
        this.cmtPositionInfoHashMap = null;
    }

    public void addOnCmtRemoveListener(OnCmtRemoveListener cmtBaseFragment$OnCmtRemoveListener0) {
        if(this.mOnCmtRemoveListenerList == null) {
            this.mOnCmtRemoveListenerList = new ArrayList();
        }
        if(!this.mOnCmtRemoveListenerList.contains(cmtBaseFragment$OnCmtRemoveListener0)) {
            this.mOnCmtRemoveListenerList.add(cmtBaseFragment$OnCmtRemoveListener0);
        }
    }

    public void contentsItemClickLog(ActionKind actionKind0, String s, String s1, String s2, String s3) {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = actionKind0;
            f0.y = this.getString(0x7F130DEC);  // string:tiara_common_layer1_comment_list "댓글리스트"
            f0.F = s;
            f0.e = s1;
            f0.f = s2;
            f0.g = s3;
            if(this.getString(0x7F130D82).equals(s)) {  // string:tiara_click_copy_profile "프로필"
                f0.e = null;
                f0.f = null;
                f0.g = null;
                f0.h = s3;
            }
            f0.a().track();
        }
    }

    public void contentsItemReplyClickLog(ActionKind actionKind0, String s, String s1, String s2, String s3) {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = actionKind0;
            f0.y = this.getString(0x7F130D17);  // string:tiara_click_copy_comment_reply "답글"
            f0.F = s;
            f0.e = s1;
            f0.f = s2;
            f0.g = s3;
            if(this.getString(0x7F130D82).equals(s)) {  // string:tiara_click_copy_profile "프로필"
                f0.e = null;
                f0.f = null;
                f0.g = null;
                f0.h = s3;
            }
            f0.a().track();
        }
    }

    public String getImageUploadDomain() {
        LoadPgnRes loadPgnRes0 = this.mLoadPgnRes;
        if(loadPgnRes0 != null) {
            result loadPgnRes$result0 = loadPgnRes0.result;
            if(loadPgnRes$result0 != null) {
                return loadPgnRes$result0.chnlinfo == null ? null : loadPgnRes$result0.chnlinfo.cmtImageUploadDomain;
            }
        }
        return null;
    }

    public p getMelonArrayAdapter() {
        return (p)this.getAdapter();
    }

    public f getTiaraEventBuilder() {
        String s;
        if(this.mResponse == null) {
            return null;
        }
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        f0.b = this.mResponse.section;
        f0.c = this.mResponse.page;
        Param cmtBaseFragment$Param0 = this.mParam;
        f0.o = cmtBaseFragment$Param0.contsRefValue;
        LoadPgnRes loadPgnRes0 = this.mLoadPgnRes;
        if(loadPgnRes0 == null) {
            s = "";
        }
        else {
            result loadPgnRes$result0 = loadPgnRes0.result;
            if(loadPgnRes$result0 == null) {
                s = "";
            }
            else {
                CHNLINFO loadPgnRes$result$CHNLINFO0 = loadPgnRes$result0.chnlinfo;
                s = loadPgnRes$result$CHNLINFO0 == null ? "" : loadPgnRes$result$CHNLINFO0.chnlname;
            }
        }
        f0.r = s;
        f0.s = String.valueOf(cmtBaseFragment$Param0.chnlSeq);
        f0.I = this.mResponse.menuId;
        return f0;
    }

    public cmtList getValidAdpterItem(int v) {
        cmtList cmtResViewModel$result$cmtList0;
        if(v < 0) {
            cmtResViewModel$result$cmtList0 = ((AdcmtListAdapter)this.getMelonArrayAdapter()).getHeaderItem();
            return !(cmtResViewModel$result$cmtList0 instanceof cmtList) || cmtResViewModel$result$cmtList0.cmtinfo == null || cmtResViewModel$result$cmtList0.memberinfo == null ? null : cmtResViewModel$result$cmtList0;
        }
        cmtResViewModel$result$cmtList0 = this.getMelonArrayAdapter().getItem(v);
        return !(cmtResViewModel$result$cmtList0 instanceof cmtList) || cmtResViewModel$result$cmtList0.cmtinfo == null || cmtResViewModel$result$cmtList0.memberinfo == null ? null : cmtResViewModel$result$cmtList0;
    }

    public boolean isFragmentAddable() {
        return this.getParentFragment() instanceof a;
    }

    public boolean isLoadPgnResValid(String s) {
        if(this.mLoadPgnRes != null && (this.mLoadPgnRes.result != null && this.mLoadPgnRes.result.chnlinfo != null && this.mLoadPgnRes.result.spaminfo != null)) {
            return true;
        }
        LogU.w("CmtBaseFragment", "isLoadPgnResValid :" + s + " : invalid LoadPgnRes dataset!");
        return false;
    }

    public void itemClickLog(String s, ActionKind actionKind0, String s1, String s2, boolean z, String s3, String s4, String s5) {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = s;
            f0.d = actionKind0;
            f0.y = s1;
            f0.F = s2;
            f0.B = s4;
            f0.e = s3;
            f0.h = s5;
            if(ActionKind.Like == actionKind0) {
                f0.U = this.getString((z ? 0x7F130FCD : 0x7F130FCC));  // string:tiara_props_like "like"
            }
            f0.a().track();
        }
    }

    private H lambda$performCmtFetchErrorPopup$0(String s) {
        if("405".equals(s)) {
            this.startActivity(new Intent("android.intent.action.VIEW", r8.f.l));
        }
        return null;
    }

    private H lambda$removeCmt$1(cmtList cmtResViewModel$result$cmtList0, int v, String s) {
        Params deleteCmtReq$Params0 = new Params();
        deleteCmtReq$Params0.chnlSeq = this.mParam.chnlSeq;
        deleteCmtReq$Params0.contsRefValue = this.mParam.contsRefValue;
        deleteCmtReq$Params0.cmtSeq = cmtResViewModel$result$cmtList0.cmtinfo.cmtseq;
        RequestBuilder.newInstance(new DeleteCmtReq(this.getContext(), deleteCmtReq$Params0)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.comments.CmtBaseFragment.3(this, v, s, cmtResViewModel$result$cmtList0)).errorListener(new com.iloen.melon.fragments.comments.CmtBaseFragment.2(this)).request();
        return null;
    }

    private void lambda$removeItem$3(cmtList cmtResViewModel$result$cmtList0) {
        if(this.isFragmentValid()) {
            this.getMelonArrayAdapter().remove(cmtResViewModel$result$cmtList0);
            this.getMelonArrayAdapter().notifyDataSetChanged();
            this.removeRelatedCache();
            if(this.getMelonArrayAdapter().getCount() == 0) {
                this.startFetch();
            }
            ArrayList arrayList0 = this.mOnCmtRemoveListenerList;
            if(arrayList0 != null) {
                for(Object object0: arrayList0) {
                    ((OnCmtRemoveListener)object0).onRemoveItem();
                }
            }
        }
    }

    private H lambda$requestPinned$2(cmtList cmtResViewModel$result$cmtList0, boolean z, int v, String s) {
        com.iloen.melon.net.v3x.comments.PinnedReq.Params pinnedReq$Params0 = new com.iloen.melon.net.v3x.comments.PinnedReq.Params();
        pinnedReq$Params0.chnlSeq = this.mParam.chnlSeq;
        pinnedReq$Params0.contsRefValue = this.mParam.contsRefValue;
        pinnedReq$Params0.cmtSeq = cmtResViewModel$result$cmtList0.cmtinfo.cmtseq;
        pinnedReq$Params0.unpinnedFlag = z;
        RequestBuilder.newInstance(new PinnedReq(this.getContext(), pinnedReq$Params0)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.comments.CmtBaseFragment.5(this, cmtResViewModel$result$cmtList0, v, s)).errorListener(new com.iloen.melon.fragments.comments.CmtBaseFragment.4(this)).request();
        return null;
    }

    public void notifyCommentDataChanged() {
        ArrayList arrayList0 = this.mOnCmtRemoveListenerList;
        if(arrayList0 != null) {
            for(Object object0: arrayList0) {
                ((OnCmtRemoveListener)object0).onDataChanged();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(EventComment eventComment0) {
        if(eventComment0 != null) {
            this.updateCmt(eventComment0);
        }
    }

    public void openAdcmtView(int v, int v1, String s) {
        LogU.d("CmtBaseFragment", "openAdcmtView adapterposition:" + v + ", dataposition:" + v1);
        if(this.isLoadPgnResValid("openAdcmtView") && this.isFragmentValid()) {
            cmtList cmtResViewModel$result$cmtList0 = this.getValidAdpterItem(v1);
            if(cmtResViewModel$result$cmtList0 == null) {
                LogU.w("CmtBaseFragment", "openAdcmtView : invalid item dataset!");
                return;
            }
            this.setEventPosition(v, v1, s, cmtResViewModel$result$cmtList0);
            int v2 = this.mParam.chnlSeq;
            String s1 = this.mParam.contsRefValue;
            int v3 = cmtResViewModel$result$cmtList0.cmtinfo.cmtseq;
            CommentConfig commentConfig0 = CommentActionImplKt.convertLoadPgnToUiModel(this.mLoadPgnRes);
            q.g(s1, "contentRefValue");
            q.g(commentConfig0, "config");
            v2 v20 = new v2();
            v20.setArguments(d5.f.j(new m[]{new m("key_cmt_seq", v3), new m("key_channel_seq", v2), new m("key_content_ref_value", s1), new m("key_cmt_config", commentConfig0)}));
            v20.m(this.getParentFragment());
        }
    }

    public void openCmtEditView(int v, int v1) {
        LogU.d("CmtBaseFragment", "openCmtEditView adapterposition:" + v + ", dataposition:" + v1);
        if(this.isLoadPgnResValid("openCmtEditView") && this.isFragmentValid()) {
            if(!this.isLoginUser()) {
                this.showLoginPopup();
                return;
            }
            cmtList cmtResViewModel$result$cmtList0 = this.getValidAdpterItem(v1);
            if(cmtResViewModel$result$cmtList0 == null) {
                LogU.w("CmtBaseFragment", "openCmtEditView : invalid item dataset!");
                return;
            }
            Navigator.openCommentWrite(this.mParam.chnlSeq, this.mParam.contsRefValue, CommentActionImplKt.convertLoadPgnToUiModel(this.mLoadPgnRes), o4.b, cmtResViewModel$result$cmtList0.cmtinfo.cmtseq);
        }
    }

    public void openCmtWriteView() {
        LogU.d("CmtBaseFragment", "openCmtWriteView");
        if(this.isLoadPgnResValid("openCmtWriteView") && this.isFragmentValid()) {
            if(!this.isLoginUser()) {
                this.showLoginPopup();
                return;
            }
            LoadPgnRes loadPgnRes0 = this.mLoadPgnRes;
            result loadPgnRes$result0 = loadPgnRes0.result;
            if(loadPgnRes$result0.chnlinfo.blindContsCmtWriteFlag) {
                l0 l00 = this.getChildFragmentManager();
                String s = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                b.a.c(l00, s, this.mLoadPgnRes.result.chnlinfo.blindContsDsplyText);
                return;
            }
            if(loadPgnRes$result0.spaminfo.breakmemberflag) {
                this.showBreakMemberGuidePopup();
                return;
            }
            Navigator.openCommentWrite(this.mParam.chnlSeq, this.mParam.contsRefValue, CommentActionImplKt.convertLoadPgnToUiModel(loadPgnRes0), o4.a, -1);
        }
    }

    public void openUserView(int v, int v1) {
        LogU.d("CmtBaseFragment", "openUserView : adapterposition:" + v + ", dataposition:" + v1);
        if(this.isLoadPgnResValid("openUserView") && this.isFragmentValid()) {
            cmtList cmtResViewModel$result$cmtList0 = this.getValidAdpterItem(v1);
            if(cmtResViewModel$result$cmtList0 == null) {
                LogU.w("CmtBaseFragment", "openUserView : invalid cmtlist dataset!");
                return;
            }
            StringBuilder stringBuilder0 = new StringBuilder("artistId:");
            stringBuilder0.append(cmtResViewModel$result$cmtList0.memberinfo.artistid);
            stringBuilder0.append(", memberKey:");
            Z.x(stringBuilder0, cmtResViewModel$result$cmtList0.memberinfo.memberkey, "CmtBaseFragment");
            MEMBERINFO cmtSharedTypeRes$CmtListBase$MEMBERINFO0 = cmtResViewModel$result$cmtList0.memberinfo;
            if(cmtSharedTypeRes$CmtListBase$MEMBERINFO0.artistflag) {
                Navigator.openArtistInfo(String.valueOf(cmtSharedTypeRes$CmtListBase$MEMBERINFO0.artistid));
                return;
            }
            String s = cmtSharedTypeRes$CmtListBase$MEMBERINFO0.memberkey;
            if(!StringIds.a(s, StringIds.i)) {
                if(StringIds.a(s, StringIds.j)) {
                    Navigator.openMelGunsCollection();
                    return;
                }
                Navigator.openUserMain(s);
            }
        }
    }

    public void performCmtFetchErrorPopup(String s, String s1) {
        LogU.w("CmtBaseFragment", "performCmtFetchErrorPopup : " + s);
        if(!this.isFragmentValid()) {
            return;
        }
        if(s == null) {
            s = "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요.";
        }
        l0 l00 = this.getChildFragmentManager();
        String s2 = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
        N n0 = new N(8, this, s1);
        b.d(b.a, l00, s2, s, true, false, false, null, E.a, null, n0, null, 0x400);
    }

    public void performCmtFetchErrorToast(String s) {
        LogU.w("CmtBaseFragment", "performCmtFetchErrorToast : " + s);
        if(s == null) {
            ToastManager.showShort(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        }
        else {
            ToastManager.showShort(s);
        }
        this.performFetchCompleteOnlyViews();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void performFetchCompleteOnlyViews() {
        super.performFetchCompleteOnlyViews();
        if(this.isFragmentAddable()) {
            RecyclerView recyclerView0 = this.mRecyclerView;
            if(recyclerView0 != null) {
                recyclerView0.post(new Runnable() {
                    @Override
                    public void run() {
                        CmtBaseFragment.this.mRecyclerView.scrollBy(0, 0);
                    }
                });
            }
        }
    }

    public void pinCmt(int v, int v1, boolean z, String s) {
        LogU.d("CmtBaseFragment", "fixCmt adapterposition:" + v + ", dataposition:" + v1);
        if(this.isLoadPgnResValid("fixCmt") && this.isFragmentValid()) {
            if(!this.isLoginUser()) {
                this.showLoginPopup();
                return;
            }
            cmtList cmtResViewModel$result$cmtList0 = this.getValidAdpterItem(v1);
            if(cmtResViewModel$result$cmtList0 == null) {
                LogU.w("CmtBaseFragment", "fixCmt : invalid item dataset!");
                return;
            }
            this.requestPinned(cmtResViewModel$result$cmtList0, v, v1, z, s);
        }
    }

    public void recomCmt(int v, int v1, boolean z, String s) {
        StringBuilder stringBuilder0 = o.t(v, v1, "recomCmt adapterposition:", ", dataposition:", " , recom:");
        stringBuilder0.append(z);
        LogU.d("CmtBaseFragment", stringBuilder0.toString());
        if(this.isLoadPgnResValid("recomCmt") && this.isFragmentValid()) {
            if(!this.isLoginUser()) {
                this.showLoginPopup();
                return;
            }
            if(this.mLoadPgnRes.result.spaminfo.breakmemberflag) {
                this.showBreakMemberGuidePopup();
                return;
            }
            cmtList cmtResViewModel$result$cmtList0 = this.getValidAdpterItem(v1);
            if(cmtResViewModel$result$cmtList0 == null) {
                LogU.w("CmtBaseFragment", "recomCmt : invalid item dataset!");
                return;
            }
            this.setEventPosition(v, v1, s, cmtResViewModel$result$cmtList0);
            if(!TextUtils.isEmpty(u.v(((e0)va.o.a()).j())) && u.v(((e0)va.o.a()).j()).equals(cmtResViewModel$result$cmtList0.memberinfo.memberkey)) {
                ToastManager.showShort(0x7F1301ED);  // string:cmt_self_can_not_recm_norecm_msg "본인이 작성한 글은 추천 또는 비추천 할 수 없습니다."
                return;
            }
            if(this.isRequestRecmDone) {
                if(z && cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag) {
                    this.requestCancelRecm(cmtResViewModel$result$cmtList0, v, v1, z, s);
                }
                else if(z || !cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag) {
                    this.requestInsertRecm(cmtResViewModel$result$cmtList0, v, v1, z, s);
                }
                else {
                    this.requestCancelRecm(cmtResViewModel$result$cmtList0, v, v1, z, s);
                }
                this.isRequestRecmDone = false;
            }
        }
    }

    public void removeCmt(int v, int v1, String s) {
        LogU.d("CmtBaseFragment", "removeCmt adapterposition:" + v + ", dataposition:" + v1);
        if(this.isLoadPgnResValid("removeCmt") && this.isFragmentValid()) {
            if(!this.isLoginUser()) {
                this.showLoginPopup();
                return;
            }
            cmtList cmtResViewModel$result$cmtList0 = this.getValidAdpterItem(v1);
            if(cmtResViewModel$result$cmtList0 == null) {
                LogU.w("CmtBaseFragment", "removeCmt : invalid item dataset!");
                return;
            }
            this.setEventPosition(v, v1, s, cmtResViewModel$result$cmtList0);
            b.v(this.getChildFragmentManager(), this.getString(0x7F130798), this.getString(0x7F1301DE), false, null, null, new t0(this, cmtResViewModel$result$cmtList0, v1, s, 2), null);  // string:notice "알림"
        }

        class com.iloen.melon.fragments.comments.CmtBaseFragment.2 implements ErrorListener {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }


        class com.iloen.melon.fragments.comments.CmtBaseFragment.3 implements Listener {
            public com.iloen.melon.fragments.comments.CmtBaseFragment.3(int v, String s, cmtList cmtResViewModel$result$cmtList0) {
            }

            public void onResponse(DeleteCmtRes deleteCmtRes0) {
                if(deleteCmtRes0.isSuccessful()) {
                    ToastManager.showShort(0x7F1301DF);  // string:cmt_delete_success "삭제되었습니다."
                    Bundle bundle0 = new Bundle();
                    bundle0.putString("type", "count");
                    bundle0.putSerializable("data", new EventComment("count", CmtBaseFragment.this.mParam.chnlSeq, -1, false, null, CmtBaseFragment.this.mParam.contsRefValue, false));
                    CmtBaseFragment.this.requireActivity().getSupportFragmentManager().i0(bundle0, "comment_request_key");
                    TimeExpiredCache.getInstance().remove(CmtBaseFragment.this.mParam.cacheKeyOfTargetPage);
                    if(this.val$dataposition < 0) {
                        TimeExpiredCache.getInstance().remove(this.val$cacheKey);
                        CmtBaseFragment.this.removeRelatedCache();
                        CmtBaseFragment.this.performBackPress();
                        return;
                    }
                    CmtBaseFragment.this.removeItem(this.val$item);
                    return;
                }
                if("405".equals(deleteCmtRes0.status)) {
                    CmtBaseFragment.this.performCmtFetchErrorPopup(deleteCmtRes0.errormessage, deleteCmtRes0.status);
                    return;
                }
                CmtBaseFragment.this.performCmtFetchErrorToast(deleteCmtRes0.errormessage);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((DeleteCmtRes)object0));
            }
        }

    }

    private void removeItem(cmtList cmtResViewModel$result$cmtList0) {
        if(cmtResViewModel$result$cmtList0 == null) {
            return;
        }
        this.initParallaxFooterHeight();
        new Handler(Looper.getMainLooper()).post(new l(20, this, cmtResViewModel$result$cmtList0));
    }

    public void removeRelatedCache() {
        Param cmtBaseFragment$Param0 = this.mParam;
        if(cmtBaseFragment$Param0 == null) {
            return;
        }
        String s = cmtBaseFragment$Param0.contsRefValue;
        TimeExpiredCache.getInstance().remove(MelonContentUris.R0.buildUpon().appendQueryParameter("nowPlayingSeq", s).build().toString());
    }

    public void reportCmt(int v, int v1, String s) {
        LogU.d("CmtBaseFragment", "reportCmt adapterposition:" + v + ", dataposition:" + v1);
        if(this.isLoadPgnResValid("reportCmt") && this.isFragmentValid()) {
            if(!this.isLoginUser()) {
                this.showLoginPopup();
                return;
            }
            if(this.mLoadPgnRes.result.spaminfo.breakmemberflag) {
                this.showBreakMemberGuidePopup();
                return;
            }
            cmtList cmtResViewModel$result$cmtList0 = this.getValidAdpterItem(v1);
            if(cmtResViewModel$result$cmtList0 == null) {
                LogU.w("CmtBaseFragment", "reportCmt : invalid item dataset!");
                return;
            }
            if(!TextUtils.isEmpty(this.mLoadPgnRes.result.chnlinfo.reprtWindowUrl)) {
                int v2 = this.mParam.chnlSeq;
                String s1 = this.mParam.contsRefValue;
                int v3 = cmtResViewModel$result$cmtList0.cmtinfo.cmtseq;
                if(this.cmtPositionInfoHashMap == null) {
                    this.cmtPositionInfoHashMap = new HashMap();
                }
                this.cmtPositionInfoHashMap.put(v3, new CmtPositionInfo(v2, v3, v, v1, s));
                Navigator.openUrl(Uri.parse(this.mLoadPgnRes.result.chnlinfo.reprtWindowUrl).buildUpon().appendQueryParameter("templateType", "m.list").appendQueryParameter("cmtPocType", "m.web").appendQueryParameter("pocId", MelonAppBase.instance.getMelonCpId()).appendQueryParameter("chnlSeq", String.valueOf(v2)).appendQueryParameter("contsRefValue", s1).appendQueryParameter("cmtSeq", String.valueOf(v3)).build().toString(), OpenType.FullScreenWithBar);
            }
        }
    }

    private void requestCancelRecm(cmtList cmtResViewModel$result$cmtList0, int v, int v1, boolean z, String s) {
        com.iloen.melon.net.v3x.comments.CancelRecmReq.Params cancelRecmReq$Params0 = new com.iloen.melon.net.v3x.comments.CancelRecmReq.Params();
        cancelRecmReq$Params0.chnlSeq = this.mParam.chnlSeq;
        cancelRecmReq$Params0.contsRefValue = this.mParam.contsRefValue;
        cancelRecmReq$Params0.cmtSeq = cmtResViewModel$result$cmtList0.cmtinfo.cmtseq;
        cancelRecmReq$Params0.nonRecmFlag = !z;
        RequestBuilder.newInstance(new CancelRecmReq(this.getContext(), cancelRecmReq$Params0)).tag(this.getRequestTag()).listener(new Listener() {
            public void onResponse(CancelRecmRes cancelRecmRes0) {
                CmtBaseFragment.v0(CmtBaseFragment.this);
                if(CmtBaseFragment.this.isFragmentValid() && cancelRecmRes0.isSuccessful()) {
                    CancelResult cancelRecmRes$CancelResult0 = cancelRecmRes0.result;
                    if(cancelRecmRes$CancelResult0 != null) {
                        RecmInfo cancelRecmRes$CancelResult$RecmInfo0 = cancelRecmRes$CancelResult0.recmInfo;
                        if(cancelRecmRes$CancelResult$RecmInfo0 != null) {
                            if(!TextUtils.isEmpty(cancelRecmRes$CancelResult$RecmInfo0.message)) {
                                ToastManager.show(cancelRecmRes$CancelResult$RecmInfo0.message);
                            }
                            cmtResViewModel$result$cmtList0.cmtinfo.recmcnt += cancelRecmRes$CancelResult$RecmInfo0.recmChgCount;
                            cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag = cancelRecmRes$CancelResult$RecmInfo0.recmFlag;
                            cmtResViewModel$result$cmtList0.cmtinfo.nonrecmcnt += cancelRecmRes$CancelResult$RecmInfo0.nonRecmChgCount;
                            cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag = cancelRecmRes$CancelResult$RecmInfo0.nonrecmflag;
                            cmtResViewModel$result$cmtList0.recommenderInfo = cancelRecmRes$CancelResult$RecmInfo0.recommenderInfo;
                            CmtBaseFragment.this.getMelonArrayAdapter().notifyItemChanged(v);
                            Bundle bundle0 = new Bundle();
                            bundle0.putSerializable("data", new EventComment("recommend", CmtBaseFragment.this.mParam.chnlSeq, cancelRecmReq$Params0.cmtSeq, false, cmtResViewModel$result$cmtList0, CmtBaseFragment.this.mParam.contsRefValue));
                            if(v1 < 0) {
                                CmtBaseFragment.this.removeRelatedCache();
                                CmtBaseFragment.this.getParentFragmentManager().i0(bundle0, "comment_request_key");
                            }
                            CmtBaseFragment.this.requireActivity().getSupportFragmentManager().i0(bundle0, "comment_request_key");
                        }
                    }
                    return;
                }
                CmtBaseFragment.this.performCmtFetchErrorToast(cancelRecmRes0.errormessage);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((CancelRecmRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                CmtBaseFragment.v0(CmtBaseFragment.this);
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }).request();
    }

    private void requestInsertRecm(cmtList cmtResViewModel$result$cmtList0, int v, int v1, boolean z, String s) {
        com.iloen.melon.net.v3x.comments.InsertRecmReq.Params insertRecmReq$Params0 = new com.iloen.melon.net.v3x.comments.InsertRecmReq.Params();
        insertRecmReq$Params0.chnlSeq = this.mParam.chnlSeq;
        insertRecmReq$Params0.contsRefValue = this.mParam.contsRefValue;
        insertRecmReq$Params0.cmtSeq = cmtResViewModel$result$cmtList0.cmtinfo.cmtseq;
        insertRecmReq$Params0.nonRecmFlag = !z;
        RequestBuilder.newInstance(new InsertRecmReq(this.getContext(), insertRecmReq$Params0)).tag(this.getRequestTag()).listener(new Listener() {
            public void onResponse(InsertRecmRes insertRecmRes0) {
                CmtBaseFragment.v0(CmtBaseFragment.this);
                if(CmtBaseFragment.this.isFragmentValid() && insertRecmRes0.isSuccessful()) {
                    InsertResult insertRecmRes$InsertResult0 = insertRecmRes0.result;
                    if(insertRecmRes$InsertResult0 != null) {
                        com.iloen.melon.net.v3x.comments.InsertRecmRes.InsertResult.RecmInfo insertRecmRes$InsertResult$RecmInfo0 = insertRecmRes$InsertResult0.recmInfo;
                        if(insertRecmRes$InsertResult$RecmInfo0 != null) {
                            if(!TextUtils.isEmpty(insertRecmRes$InsertResult$RecmInfo0.message)) {
                                ToastManager.show(insertRecmRes$InsertResult$RecmInfo0.message);
                            }
                            cmtResViewModel$result$cmtList0.cmtinfo.recmcnt += insertRecmRes$InsertResult$RecmInfo0.recmChgCount;
                            cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag = insertRecmRes$InsertResult$RecmInfo0.recmFlag;
                            cmtResViewModel$result$cmtList0.cmtinfo.nonrecmcnt += insertRecmRes$InsertResult$RecmInfo0.nonRecmChgCount;
                            cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag = insertRecmRes$InsertResult$RecmInfo0.nonrecmflag;
                            cmtResViewModel$result$cmtList0.recommenderInfo = insertRecmRes$InsertResult$RecmInfo0.recommenderInfo;
                            CmtBaseFragment.this.getMelonArrayAdapter().notifyItemChanged(v);
                            Bundle bundle0 = new Bundle();
                            bundle0.putSerializable("data", new EventComment("recommend", CmtBaseFragment.this.mParam.chnlSeq, insertRecmReq$Params0.cmtSeq, false, cmtResViewModel$result$cmtList0, CmtBaseFragment.this.mParam.contsRefValue));
                            if(v1 < 0) {
                                CmtBaseFragment.this.removeRelatedCache();
                                CmtBaseFragment.this.getParentFragmentManager().i0(bundle0, "comment_request_key");
                            }
                            CmtBaseFragment.this.requireActivity().getSupportFragmentManager().i0(bundle0, "comment_request_key");
                        }
                    }
                    return;
                }
                CmtBaseFragment.this.performCmtFetchErrorToast(insertRecmRes0.errormessage);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((InsertRecmRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                CmtBaseFragment.v0(CmtBaseFragment.this);
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }).request();
    }

    private void requestPinned(cmtList cmtResViewModel$result$cmtList0, int v, int v1, boolean z, String s) {
        b.v(this.getChildFragmentManager(), this.getString(0x7F130798), this.getString((z ? 0x7F13084A : 0x7F130849)), false, null, null, new Hc.E(this, cmtResViewModel$result$cmtList0, z, v1, s), null);  // string:notice "알림"

        class com.iloen.melon.fragments.comments.CmtBaseFragment.4 implements ErrorListener {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }


        class com.iloen.melon.fragments.comments.CmtBaseFragment.5 implements Listener {
            public com.iloen.melon.fragments.comments.CmtBaseFragment.5(cmtList cmtResViewModel$result$cmtList0, int v, String s) {
            }

            public void onResponse(PinnedRes pinnedRes0) {
                if(pinnedRes0.isSuccessful()) {
                    PinnedResult pinnedRes$PinnedResult0 = pinnedRes0.result;
                    if(pinnedRes$PinnedResult0 != null) {
                        this.val$item.cmtinfo.pinnedFlag = pinnedRes$PinnedResult0.unpinnedFlag;
                        CmtBaseFragment.this.startFetch("refresh");
                        if(this.val$dataposition < 0) {
                            TimeExpiredCache.getInstance().remove(this.val$cacheKey);
                            CmtBaseFragment.this.removeRelatedCache();
                        }
                    }
                    return;
                }
                CmtBaseFragment.this.performCmtFetchErrorToast(pinnedRes0.errormessage);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((PinnedRes)object0));
            }
        }

    }

    private void setEventPosition(int v, int v1, String s, CmtListBase cmtSharedTypeRes$CmtListBase0) {
        if(this.cmtPositionInfoHashMap == null) {
            this.cmtPositionInfoHashMap = new HashMap();
        }
        this.cmtPositionInfoHashMap.put(cmtSharedTypeRes$CmtListBase0.cmtinfo.cmtseq, new CmtPositionInfo(this.mParam.chnlSeq, cmtSharedTypeRes$CmtListBase0.cmtinfo.cmtseq, v, v1, s));
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean shouldIgnoreSetUIOnForegroundEvent() {
        return this.isFragmentAddable();
    }

    public void showBreakMemberGuidePopup() {
        if(!TextUtils.isEmpty(this.mLoadPgnRes.result.spaminfo.breakMemberGuideUrl)) {
            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
            melonLinkInfo0.c = this.mLoadPgnRes.result.spaminfo.breakMemberGuideAppSchme;
            MelonLinkExecutor.open(melonLinkInfo0);
            return;
        }
        l0 l00 = this.getChildFragmentManager();
        String s = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
        b.a.c(l00, s, this.mLoadPgnRes.result.spaminfo.breakMemberGuideText);
    }

    public static void t0(CmtBaseFragment cmtBaseFragment0, cmtList cmtResViewModel$result$cmtList0) {
        cmtBaseFragment0.lambda$removeItem$3(cmtResViewModel$result$cmtList0);
    }

    public void updateCmt(EventComment eventComment0) {
        if(this.cmtPositionInfoHashMap != null && this.cmtPositionInfoHashMap.containsKey(eventComment0.cmtSeq)) {
            CmtPositionInfo cmtBaseFragment$CmtPositionInfo0 = (CmtPositionInfo)this.cmtPositionInfoHashMap.get(eventComment0.cmtSeq);
            if(cmtBaseFragment$CmtPositionInfo0 != null) {
                cmtList cmtResViewModel$result$cmtList0 = this.getValidAdpterItem(cmtBaseFragment$CmtPositionInfo0.dataPosition);
                if(cmtResViewModel$result$cmtList0 != null) {
                    eventComment0.actiontype.getClass();
                    int v = -1;
                    switch(eventComment0.actiontype) {
                        case "count": {
                            CMTINFO cmtSharedTypeRes$CmtListBase$CMTINFO0 = cmtResViewModel$result$cmtList0.cmtinfo;
                            int v1 = cmtSharedTypeRes$CmtListBase$CMTINFO0.validadcmtcnt;
                            if(eventComment0.isReplyAdded) {
                                v = 1;
                            }
                            cmtSharedTypeRes$CmtListBase$CMTINFO0.validadcmtcnt = v1 + v;
                            break;
                        }
                        case "recommend": {
                            cmtList cmtResViewModel$result$cmtList1 = eventComment0.item;
                            if(cmtResViewModel$result$cmtList1 != null) {
                                cmtResViewModel$result$cmtList0.cmtinfo.recmcnt = cmtResViewModel$result$cmtList1.cmtinfo.recmcnt;
                                cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag = cmtResViewModel$result$cmtList1.cmtinfo.memberrecmflag;
                                cmtResViewModel$result$cmtList0.cmtinfo.nonrecmcnt = cmtResViewModel$result$cmtList1.cmtinfo.nonrecmcnt;
                                cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag = cmtResViewModel$result$cmtList1.cmtinfo.membernonrecmflag;
                                cmtResViewModel$result$cmtList0.recommenderInfo = cmtResViewModel$result$cmtList1.recommenderInfo;
                            }
                            break;
                        }
                        case "report": {
                            cmtResViewModel$result$cmtList0.cmtinfo.memberreprtflag = true;
                            break;
                        }
                        default: {
                            return;
                        }
                    }
                    this.getMelonArrayAdapter().notifyItemChanged(cmtBaseFragment$CmtPositionInfo0.adapterPosition);
                    this.cmtPositionInfoHashMap.remove(eventComment0.cmtSeq);
                }
            }
        }
        else if(eventComment0.actiontype.equals("count") && (eventComment0.chnlSeq == this.mParam.chnlSeq && eventComment0.contsRefValue.equals(this.mParam.contsRefValue))) {
            this.startFetch();
        }
    }

    public static void v0(CmtBaseFragment cmtBaseFragment0) {
        cmtBaseFragment0.isRequestRecmDone = true;
    }
}

