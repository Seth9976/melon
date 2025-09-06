package com.iloen.melon.fragments.comments;

import B.a;
import Cc.P0;
import De.I;
import E9.w;
import F8.q;
import J8.E1;
import J8.K1;
import J8.x;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import c2.W;
import c2.b;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.eventbus.EventComment;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.net.v3x.comments.DeleteAdcmtReq;
import com.iloen.melon.net.v3x.comments.DeleteAdcmtRes;
import com.iloen.melon.net.v3x.comments.InformCmtReq;
import com.iloen.melon.net.v3x.comments.InformCmtRes.result;
import com.iloen.melon.net.v3x.comments.InformCmtRes;
import com.iloen.melon.net.v3x.comments.InsertAdcmtReq;
import com.iloen.melon.net.v3x.comments.InsertAdcmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v4x.request.CmtPvLogDummyReq.Params;
import com.iloen.melon.net.v4x.request.CmtPvLogDummyReq;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.CompatUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import v9.e;
import v9.h;
import v9.i;
import vd.E;

public class AdcmtListFragment extends CmtBaseFragment {
    class AdcmtListAdapter extends p {
        private static final int VIEW_TYPE_ADCMT = 2;
        private static final int VIEW_TYPE_HEADER_CMT = 1;
        private CmtResViewModel headerViewModel;

        public AdcmtListAdapter(Context context0, List list0, MetaContentBaseFragment metaContentBaseFragment0) {
            super(context0, list0);
            this.headerViewModel = new CmtResViewModel();
        }

        public void addHeader(CmtResViewModel cmtResViewModel0) {
            this.headerViewModel = cmtResViewModel0;
        }

        public cmtList getHeaderItem() {
            return this.headerViewModel == null || (this.headerViewModel.result == null || (this.headerViewModel.result.cmtlist == null || this.headerViewModel.result.cmtlist.size() <= 0)) ? null : ((cmtList)this.headerViewModel.result.cmtlist.get(0));
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return v == this.getAvailableHeaderPosition() ? 1 : 2;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            cmtList cmtResViewModel$result$cmtList0;
            switch(o00.getItemViewType()) {
                case 1: {
                    cmtResViewModel$result$cmtList0 = this.getHeaderItem();
                    break;
                }
                case 2: {
                    cmtResViewModel$result$cmtList0 = (cmtList)this.getItem(v1);
                    break;
                }
                default: {
                    cmtResViewModel$result$cmtList0 = null;
                }
            }
            if(o00 instanceof CmtBaseViewHolder && cmtResViewModel$result$cmtList0 != null) {
                ((CmtBaseViewHolder)o00).bindView(cmtResViewModel$result$cmtList0, v, v1);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            switch(v) {
                case 1: {
                    return new CommentListRenewalViewHolder(K1.a(LayoutInflater.from(this.getContext()), viewGroup0), AdcmtListFragment.this);
                }
                case 2: {
                    View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0474, viewGroup0, false);  // layout:listitem_detail_ad_comment
                    int v1 = 0x7F0A006E;  // id:adcmt_divider
                    if(((ImageView)I.C(view0, 0x7F0A006E)) != null) {  // id:adcmt_divider
                        v1 = 0x7F0A014D;  // id:btn_cmt_more
                        View view1 = I.C(view0, 0x7F0A014D);  // id:btn_cmt_more
                        if(((ImageView)view1) != null && ((ConstraintLayout)I.C(view0, 0x7F0A02D3)) != null) {  // id:cmt_icon_container
                            v1 = 0x7F0A02D4;  // id:cmt_official_icon
                            View view2 = I.C(view0, 0x7F0A02D4);  // id:cmt_official_icon
                            if(((ImageView)view2) != null) {
                                v1 = 0x7F0A02D5;  // id:cmt_user_icon
                                View view3 = I.C(view0, 0x7F0A02D5);  // id:cmt_user_icon
                                if(((ImageView)view3) != null) {
                                    v1 = 0x7F0A02D6;  // id:cmt_user_level
                                    View view4 = I.C(view0, 0x7F0A02D6);  // id:cmt_user_level
                                    if(((MelonTextView)view4) != null) {
                                        v1 = 0x7F0A02D7;  // id:cmt_user_level_degree
                                        View view5 = I.C(view0, 0x7F0A02D7);  // id:cmt_user_level_degree
                                        if(((ImageView)view5) != null) {
                                            v1 = 0x7F0A04FE;  // id:group_act_temp
                                            View view6 = I.C(view0, 0x7F0A04FE);  // id:group_act_temp
                                            if(((Group)view6) != null) {
                                                v1 = 0x7F0A0502;  // id:group_user_level
                                                View view7 = I.C(view0, 0x7F0A0502);  // id:group_user_level
                                                if(((Group)view7) != null && ((Guideline)I.C(view0, 0x7F0A0518)) != null) {  // id:guideline_end
                                                    v1 = 0x7F0A0615;  // id:iv_cmt_badge
                                                    View view8 = I.C(view0, 0x7F0A0615);  // id:iv_cmt_badge
                                                    if(((ImageView)view8) != null && ((Space)I.C(view0, 0x7F0A0AC3)) != null) {  // id:space_thumb
                                                        v1 = 0x7F0A0B3C;  // id:temp_act_cmt
                                                        View view9 = I.C(view0, 0x7F0A0B3C);  // id:temp_act_cmt
                                                        if(((MelonTextView)view9) != null && ((ImageView)I.C(view0, 0x7F0A0B3D)) != null) {  // id:temp_act_link_icon
                                                            v1 = 0x7F0A0B3E;  // id:temp_act_link_url
                                                            View view10 = I.C(view0, 0x7F0A0B3E);  // id:temp_act_link_url
                                                            if(((MelonTextView)view10) != null && ((Space)I.C(view0, 0x7F0A0B3F)) != null) {  // id:temp_bottom_space
                                                                v1 = 0x7F0A0B79;  // id:thumb_layout
                                                                View view11 = I.C(view0, 0x7F0A0B79);  // id:thumb_layout
                                                                if(view11 != null) {
                                                                    x x0 = x.b(view11);
                                                                    v1 = 0x7F0A0C3E;  // id:tv_cmt_date
                                                                    View view12 = I.C(view0, 0x7F0A0C3E);  // id:tv_cmt_date
                                                                    if(((MelonTextView)view12) != null) {
                                                                        v1 = 0x7F0A0C3F;  // id:tv_cmt_detail
                                                                        View view13 = I.C(view0, 0x7F0A0C3F);  // id:tv_cmt_detail
                                                                        if(((MelonTextView)view13) != null) {
                                                                            v1 = 0x7F0A0C40;  // id:tv_cmt_nickname
                                                                            View view14 = I.C(view0, 0x7F0A0C40);  // id:tv_cmt_nickname
                                                                            if(((MelonTextView)view14) != null) {
                                                                                v1 = 0x7F0A0C42;  // id:tv_cmt_pinned
                                                                                View view15 = I.C(view0, 0x7F0A0C42);  // id:tv_cmt_pinned
                                                                                if(((MelonTextView)view15) != null) {
                                                                                    v1 = 0x7F0A0C43;  // id:tv_cmt_profile_badge
                                                                                    View view16 = I.C(view0, 0x7F0A0C43);  // id:tv_cmt_profile_badge
                                                                                    if(((MelonTextView)view16) != null) {
                                                                                        v1 = 0x7F0A0D6B;  // id:underline
                                                                                        View view17 = I.C(view0, 0x7F0A0D6B);  // id:underline
                                                                                        if(view17 != null) {
                                                                                            return new AdCommentListRenewalViewHolder(new E1(((ConstraintLayout)view0), ((ImageView)view1), ((ImageView)view2), ((ImageView)view3), ((MelonTextView)view4), ((ImageView)view5), ((Group)view6), ((Group)view7), ((ImageView)view8), ((MelonTextView)view9), ((MelonTextView)view10), x0, ((MelonTextView)view12), ((MelonTextView)view13), ((MelonTextView)view14), ((MelonTextView)view15), ((MelonTextView)view16), view17), AdcmtListFragment.this);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
                }
                default: {
                    return null;
                }
            }
        }
    }

    public static class Param extends com.iloen.melon.fragments.comments.CmtBaseFragment.Param {
        public int cmtseq;
        public LoadPgnRes loadPgnRes;
        private static final long serialVersionUID = 0x447BA95CFF3BE792L;

        public Param() {
            this.cmtseq = -1;
        }
    }

    private static final String TAG = "AdcmtListFragment";
    private View containerLayout;
    private CommentInputPopup inputPopupWindow;
    private TextView mBtnRegister;
    private MelonEditText mEdtRegister;
    private View mRegisterContainer;
    private TextWatcher mTextWatcher;
    private final OnEventListener popupListener;

    public AdcmtListFragment() {
        this.popupListener = new OnEventListener() {
            @Override  // com.iloen.melon.fragments.comments.CommentInputPopup$OnEventListener
            public void onDismissEvent(Editable editable0) {
                AdcmtListFragment.this.mEdtRegister.setText(editable0);
                boolean z = TextUtils.isEmpty(editable0);
                AdcmtListFragment.this.mBtnRegister.setEnabled(!z);
            }

            @Override  // com.iloen.melon.fragments.comments.CommentInputPopup$OnEventListener
            public void onSendEvent(String s) {
                AdcmtListFragment.this.writeAdcmt(s);
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
                int v3 = AdcmtListFragment.this.mEdtRegister.getText().toString().length();
                if(AdcmtListFragment.this.mBtnRegister != null) {
                    AdcmtListFragment.this.mBtnRegister.setEnabled(v3 > 0);
                }
                AdcmtListFragment adcmtListFragment0 = AdcmtListFragment.this;
                int v4 = adcmtListFragment0.mLoadPgnRes.result.chnlinfo.adcmtregmaxlength > 0 ? adcmtListFragment0.mLoadPgnRes.result.chnlinfo.adcmtregmaxlength : 200;
                if(v3 > v4) {
                    adcmtListFragment0.mEdtRegister.setTextLimit(w.I(v4));
                    String s = AdcmtListFragment.this.mEdtRegister.getText().toString();
                    AdcmtListFragment.this.mEdtRegister.setText(s.substring(0, v4));
                    AdcmtListFragment.this.mEdtRegister.setSelection(v4);
                    ToastManager.show(0x7F13084B);  // string:popup_cmt_write_max_limit "입력하신 글자 수가 초과되었습니다."
                    return;
                }
                if(v3 < v4) {
                    adcmtListFragment0.mEdtRegister.setTextLimit(null);
                }
            }
        };
    }

    private void clearData() {
        if(this.getMelonArrayAdapter() != null) {
            this.getMelonArrayAdapter().clear(false);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new AdcmtListAdapter(this, context0, null, this);
        ((p)j00).setEmptyViewInfo(e.n);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.g.buildUpon().appendPath("adcmtlist").appendQueryParameter("chnlSeq", String.valueOf(this.mParam.chnlSeq)).appendQueryParameter("contsRef", this.mParam.contsRefValue).appendQueryParameter("cmtseq", String.valueOf(((Param)this.mParam).cmtseq)).build().toString();
    }

    public CmtPvLogDummyReq getPvDummyLogRequest() {
        Params cmtPvLogDummyReq$Params0 = new Params();
        cmtPvLogDummyReq$Params0.type = "view";
        cmtPvLogDummyReq$Params0.chnlSeq = String.valueOf(this.mParam.chnlSeq);
        cmtPvLogDummyReq$Params0.cmtSeq = String.valueOf(((Param)this.mParam).cmtseq);
        cmtPvLogDummyReq$Params0.contsRefValue = this.mParam.contsRefValue;
        return new CmtPvLogDummyReq(this.getContext(), cmtPvLogDummyReq$Params0);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public PvLogDummyReq getPvDummyLogRequest() {
        return this.getPvDummyLogRequest();
    }

    private void initInputPopup() {
        CommentInputPopup commentInputPopup0 = new CommentInputPopup(this.requireContext(), this.mEdtRegister.getText(), this.popupListener, true);
        this.inputPopupWindow = commentInputPopup0;
        commentInputPopup0.setHint(0x7F130022);  // string:adcmt_write_hint_msg "답글을 입력해주세요."
        this.inputPopupWindow.setOnShowListener(new d(this, 0));
        this.inputPopupWindow.setOnDismissListener(new com.iloen.melon.fragments.comments.e(this, 0));
    }

    private void lambda$initInputPopup$2(DialogInterface dialogInterface0) {
        ViewUtils.hideWhen(this.mRegisterContainer, true);
    }

    private void lambda$initInputPopup$3(DialogInterface dialogInterface0) {
        ViewUtils.showWhen(this.mRegisterContainer, true);
    }

    private void lambda$onViewCreated$0(View view0) {
        this.writeAdcmt(this.mEdtRegister.getText().toString());
    }

    private void lambda$onViewCreated$1(View view0) {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        if(this.isLoadPgnResValid("onViewCreated") && this.mLoadPgnRes.result.spaminfo.breakmemberflag) {
            this.showBreakMemberGuidePopup();
            return;
        }
        this.showInputPopup(this.mEdtRegister.getText());
    }

    private H lambda$removeAdcmt$4(cmtList cmtResViewModel$result$cmtList0, int v) {
        com.iloen.melon.net.v3x.comments.DeleteAdcmtReq.Params deleteAdcmtReq$Params0 = new com.iloen.melon.net.v3x.comments.DeleteAdcmtReq.Params();
        deleteAdcmtReq$Params0.chnlSeq = this.mParam.chnlSeq;
        deleteAdcmtReq$Params0.contsRefValue = this.mParam.contsRefValue;
        deleteAdcmtReq$Params0.parntCmtSeq = ((Param)this.mParam).cmtseq;
        deleteAdcmtReq$Params0.cmtSeq = cmtResViewModel$result$cmtList0.cmtinfo.cmtseq;
        RequestBuilder.newInstance(new DeleteAdcmtReq(this.getContext(), deleteAdcmtReq$Params0)).tag("AdcmtListFragment").listener(new com.iloen.melon.fragments.comments.AdcmtListFragment.8(this, cmtResViewModel$result$cmtList0, v, deleteAdcmtReq$Params0)).errorListener(new com.iloen.melon.fragments.comments.AdcmtListFragment.7(this)).request();
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(this.getContext());
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(linearLayoutManager0);
        recyclerView0.setAdapter(this.mAdapter);
        recyclerView0.addItemDecoration(new LastItemSpacingDecoration());
        recyclerView0.addOnScrollListener(new A0() {
            @Override  // androidx.recyclerview.widget.A0
            public void onScrolled(RecyclerView recyclerView0, int v, int v1) {
                if(AdcmtListFragment.this.isFragmentVisible) {
                    boolean z = linearLayoutManager0.findFirstCompletelyVisibleItemPosition() != 0 || v1 > 0;
                    AdcmtListFragment.this.showScrolledLine(z);
                }
            }
        });
        W.o(recyclerView0, new b() {
            @Override  // c2.b
            public void onInitializeAccessibilityNodeInfo(View view0, d2.d d0) {
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                d0.a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", "");
            }
        });
        return recyclerView0;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        LogU.d("AdcmtListFragment", "Layout theme = " + this.mParam.theme);
        return layoutInflater0.inflate(0x7F0D029F, viewGroup0, false);  // layout:fragment_cmt_adcmt_list
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        LogU.d("AdcmtListFragment", "onFetchStart reason:" + s);
        com.iloen.melon.net.v3x.comments.InformCmtReq.Params informCmtReq$Params0 = new com.iloen.melon.net.v3x.comments.InformCmtReq.Params();
        informCmtReq$Params0.chnlSeq = this.mParam.chnlSeq;
        informCmtReq$Params0.contsRefValue = this.mParam.contsRefValue;
        informCmtReq$Params0.cmtSeq = ((Param)this.mParam).cmtseq;
        informCmtReq$Params0.adcmtListFlag = true;
        if(i.b.equals(i0)) {
            this.clearData();
        }
        RequestBuilder.newInstance(new InformCmtReq(this.getContext(), informCmtReq$Params0)).tag(this.getRequestTag()).listener(new Listener() {
            public void onResponse(InformCmtRes informCmtRes0) {
                boolean z2;
                String s1;
                boolean z1;
                int v1;
                if(!AdcmtListFragment.this.prepareFetchComplete(informCmtRes0)) {
                    return;
                }
                if(informCmtRes0.isSuccessful()) {
                    AdcmtListAdapter adcmtListFragment$AdcmtListAdapter0 = (AdcmtListAdapter)AdcmtListFragment.this.getMelonArrayAdapter();
                    CmtResViewModel cmtResViewModel0 = new CmtResViewModel();
                    result informCmtRes$result0 = informCmtRes0.result;
                    AdcmtListFragment adcmtListFragment0 = AdcmtListFragment.this;
                    int v = adcmtListFragment0.mParam.chnlSeq;
                    String s = adcmtListFragment0.mParam.contsRefValue;
                    boolean z = false;
                    if(adcmtListFragment0.mParam.isReadOnly) {
                        v1 = v;
                        z1 = true;
                        s1 = s;
                        z2 = false;
                    }
                    else {
                        z2 = adcmtListFragment0.mLoadPgnRes.result.chnlinfo.reprtuseflag;
                        v1 = v;
                        z1 = false;
                        s1 = s;
                    }
                    cmtResViewModel0.databindInformCmtRes(informCmtRes$result0, v1, s1, z1, z2);
                    adcmtListFragment$AdcmtListAdapter0.addHeader(cmtResViewModel0);
                    adcmtListFragment$AdcmtListAdapter0.notifyItemChanged(0);
                    CmtResViewModel cmtResViewModel1 = new CmtResViewModel();
                    ArrayList arrayList0 = informCmtRes0.result.adcmtlist;
                    AdcmtListFragment adcmtListFragment1 = AdcmtListFragment.this;
                    int v2 = adcmtListFragment1.mParam.chnlSeq;
                    String s2 = adcmtListFragment1.mParam.contsRefValue;
                    boolean z3 = adcmtListFragment1.mParam.isReadOnly;
                    if(!z3) {
                        z = adcmtListFragment1.mLoadPgnRes.result.chnlinfo.reprtuseflag;
                    }
                    cmtResViewModel1.databindAdCmtListBase(arrayList0, v2, s2, z3, z);
                    adcmtListFragment$AdcmtListAdapter0.addAll(cmtResViewModel1.result.cmtlist);
                    adcmtListFragment$AdcmtListAdapter0.updateModifiedTime(AdcmtListFragment.this.getCacheKey());
                    AdcmtListFragment.this.performFetchCompleteOnlyViews();
                    return;
                }
                AdcmtListFragment.this.performCmtFetchErrorToast(informCmtRes0.errormessage);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((InformCmtRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onPause() {
        super.onPause();
        CommentInputPopup commentInputPopup0 = this.inputPopupWindow;
        if(commentInputPopup0 != null) {
            commentInputPopup0.dismiss();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        com.iloen.melon.fragments.comments.CmtBaseFragment.Param cmtBaseFragment$Param0 = (com.iloen.melon.fragments.comments.CmtBaseFragment.Param)CompatUtils.getSerializable(bundle0, "argCmtParam", Param.class);
        this.mParam = cmtBaseFragment$Param0;
        if(cmtBaseFragment$Param0 != null) {
            this.mLoadPgnRes = ((Param)cmtBaseFragment$Param0).loadPgnRes;
            cmtBaseFragment$Param0.cacheKeyOfAdcmtList = this.getCacheKey();
            if(this.mLoadPgnRes == null) {
                this.mParam.isReadOnly = true;
            }
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onResume() {
        super.onResume();
        this.updateEditTextView();
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
        this.containerLayout = view0.findViewById(0x7F0A032D);  // id:container_layout
        if(!this.mParam.isReadOnly && !this.isLoadPgnResValid("onViewCreated")) {
            return;
        }
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            if(this.isFragmentAddable()) {
                titleBar0.setPadding(0, ScreenUtils.dipToPixel(this.requireContext(), 6.0f), 0, 0);
                titleBar0.c(60.0f);
                titleBar0.a(new q("답글"));
            }
            else {
                titleBar0.a(a.s(2));
                titleBar0.setTitle("답글");
            }
            titleBar0.f(false);
        }
        this.mRegisterContainer = this.findViewById(0x7F0A09D9);  // id:register_container
        this.mEdtRegister = (MelonEditText)this.findViewById(0x7F0A0412);  // id:edt_register
        this.mBtnRegister = (TextView)this.findViewById(0x7F0A0C2D);  // id:tv_btn_register
        this.mEdtRegister.setHint(0x7F130022);  // string:adcmt_write_hint_msg "답글을 입력해주세요."
        ViewUtils.setContentDescriptionWithButtonClassName(this.mBtnRegister, this.mBtnRegister.getText());
        if(this.mParam.isReadOnly) {
            ViewUtils.hideWhen(this.mRegisterContainer, true);
        }
        else {
            String s = this.mLoadPgnRes.result.chnlinfo.adcmtplaceholdertext;
            if(!TextUtils.isEmpty(s)) {
                this.mEdtRegister.setHint(s);
            }
            ViewUtils.setOnClickListener(this.mBtnRegister, new c(this, 0));
        }
        this.initInputPopup();
        ViewUtils.setOnClickListener(this.mEdtRegister, new c(this, 1));
    }

    public void removeAdcmt(int v, int v1) {
        LogU.d("AdcmtListFragment", "removeAdcmt adapterposition:" + v + ", dataposition:" + v1);
        if(this.isLoadPgnResValid("removeAdcmt") && this.isFragmentValid()) {
            if(!this.isLoginUser()) {
                this.showLoginPopup();
                return;
            }
            cmtList cmtResViewModel$result$cmtList0 = this.getValidAdpterItem(v1);
            if(cmtResViewModel$result$cmtList0 == null) {
                LogU.w("AdcmtListFragment", "removeAdcmt : invalid item dataset!");
                return;
            }
            com.melon.ui.popup.b.v(this.getChildFragmentManager(), this.getString(0x7F130798), this.getString(0x7F130020), false, null, null, new P0(this, cmtResViewModel$result$cmtList0, v, 4), null);  // string:notice "알림"
        }

        class com.iloen.melon.fragments.comments.AdcmtListFragment.7 implements ErrorListener {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }


        class com.iloen.melon.fragments.comments.AdcmtListFragment.8 implements Listener {
            public com.iloen.melon.fragments.comments.AdcmtListFragment.8(cmtList cmtResViewModel$result$cmtList0, int v, com.iloen.melon.net.v3x.comments.DeleteAdcmtReq.Params deleteAdcmtReq$Params0) {
            }

            public void onResponse(DeleteAdcmtRes deleteAdcmtRes0) {
                if(AdcmtListFragment.this.isFragmentValid() && deleteAdcmtRes0.isSuccessful()) {
                    ToastManager.showShort(0x7F130021);  // string:adcmt_delete_success "삭제되었습니다."
                    AdcmtListFragment.this.getMelonArrayAdapter().remove(this.val$item);
                    AdcmtListFragment.this.getMelonArrayAdapter().notifyItemRemoved(this.val$adapterposition);
                    p p0 = AdcmtListFragment.this.getMelonArrayAdapter();
                    int v = AdcmtListFragment.this.getMelonArrayAdapter().getCount();
                    p0.notifyItemRangeChanged(this.val$adapterposition, v);
                    if(AdcmtListFragment.this.getMelonArrayAdapter().getCount() == 0) {
                        AdcmtListFragment.this.startFetch();
                    }
                    AdcmtListFragment.this.removeRelatedCache();
                    Bundle bundle0 = new Bundle();
                    bundle0.putString("type", "count");
                    bundle0.putSerializable("data", new EventComment("count", AdcmtListFragment.this.mParam.chnlSeq, this.val$params.parntCmtSeq, false));
                    AdcmtListFragment.this.getParentFragmentManager().i0(bundle0, "comment_request_key");
                    return;
                }
                if("405".equals(deleteAdcmtRes0.status)) {
                    AdcmtListFragment.this.performCmtFetchErrorPopup(deleteAdcmtRes0.errormessage, deleteAdcmtRes0.status);
                    return;
                }
                AdcmtListFragment.this.performCmtFetchErrorToast(deleteAdcmtRes0.errormessage);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((DeleteAdcmtRes)object0));
            }
        }

    }

    private void setInputMessage(String s) {
        if(this.isFragmentValid()) {
            this.mEdtRegister.setText(s);
            this.mBtnRegister.setEnabled(!TextUtils.isEmpty(s));
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    private void showInputPopup(Editable editable0) {
        this.inputPopupWindow.setInputText(editable0);
        this.inputPopupWindow.show();
    }

    private void updateEditTextView() {
        if(this.mEdtRegister == null) {
            LogU.w("AdcmtListFragment", "updateEditTextView() mEditText null");
            return;
        }
        if(this.isLoadPgnResValid("updateEditTextView")) {
            boolean z = this.isLoginUser();
            LogU.w("AdcmtListFragment", "updateEditTextView() isLoginUser:" + z);
            boolean z1 = false;
            if(!z || this.mLoadPgnRes.result.spaminfo.breakmemberflag) {
                this.mEdtRegister.clearFocus();
                this.mEdtRegister.setInputType(0);
            }
            else {
                this.mEdtRegister.setInputType(0x20001);
                this.mEdtRegister.addTextChangedListener(this.mTextWatcher);
            }
            if(this.mBtnRegister != null && this.mEdtRegister.getText() != null) {
                int v = this.mEdtRegister.getText().toString().length();
                TextView textView0 = this.mBtnRegister;
                if(v > 0) {
                    z1 = true;
                }
                textView0.setEnabled(z1);
            }
        }
    }

    public void writeAdcmt(String s) {
        LogU.d("AdcmtListFragment", "writeAdcmt");
        if(this.isLoadPgnResValid("writeAdcmt") && this.isFragmentValid()) {
            if(!this.isLoginUser()) {
                this.showLoginPopup();
                return;
            }
            if(this.mLoadPgnRes.result.spaminfo.breakmemberflag) {
                this.showBreakMemberGuidePopup();
                return;
            }
            int v = s.trim().length();
            int v1 = this.mLoadPgnRes.result.chnlinfo.adcmtregminlength > 0 ? this.mLoadPgnRes.result.chnlinfo.adcmtregminlength : 3;
            if(v < v1) {
                String s1 = v == 0 ? "내용을 입력해주세요." : String.format(this.getString(0x7F13084C), v1);  // string:popup_cmt_write_min_limit "%d자 이상의 글을 작성해주세요."
                if(!this.isFragmentAddable()) {
                    l0 l00 = this.getChildFragmentManager();
                    String s2 = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                    com.melon.ui.popup.b.a.c(l00, s2, s1);
                    return;
                }
                ToastManager.show(s1);
                return;
            }
            InputMethodUtils.hideInputMethod(this.getContext(), this.mEdtRegister);
            com.iloen.melon.net.v3x.comments.InsertAdcmtReq.Params insertAdcmtReq$Params0 = new com.iloen.melon.net.v3x.comments.InsertAdcmtReq.Params();
            insertAdcmtReq$Params0.chnlSeq = this.mParam.chnlSeq;
            insertAdcmtReq$Params0.contsRefValue = this.mParam.contsRefValue;
            insertAdcmtReq$Params0.parntCmtSeq = ((Param)this.mParam).cmtseq;
            insertAdcmtReq$Params0.cmtCont = s.trim();
            insertAdcmtReq$Params0.secrtFlag = false;
            insertAdcmtReq$Params0.stickerSeq = "-1";
            RequestBuilder.newInstance(new InsertAdcmtReq(this.getContext(), insertAdcmtReq$Params0)).tag("AdcmtListFragment").listener(new Listener() {
                private H lambda$onResponse$0() {
                    AdcmtListFragment.this.performBackPress();
                    return null;
                }

                public void onResponse(InsertAdcmtRes insertAdcmtRes0) {
                    boolean z = AdcmtListFragment.this.isFragmentValid();
                    com.melon.ui.popup.b b0 = com.melon.ui.popup.b.a;
                    if(z && insertAdcmtRes0.isSuccessful()) {
                        com.iloen.melon.net.v3x.comments.InsertAdcmtRes.result insertAdcmtRes$result0 = insertAdcmtRes0.result;
                        if(insertAdcmtRes$result0 == null || TextUtils.isEmpty(insertAdcmtRes$result0.message)) {
                            ToastManager.showShort(0x7F13001E);  // string:adcmt_add_success "등록되었습니다."
                        }
                        else if(AdcmtListFragment.this.isFragmentValid()) {
                            b0.c(AdcmtListFragment.this.getChildFragmentManager(), AdcmtListFragment.this.getString(0x7F1300D0), insertAdcmtRes$result0.message);  // string:alert_dlg_title_info "안내"
                        }
                        AdcmtListFragment.this.mEdtRegister.setText(null);
                        AdcmtListFragment.this.startFetch(i.b, h.b);
                        AdcmtListFragment.this.removeRelatedCache();
                        Bundle bundle0 = new Bundle();
                        bundle0.putString("type", "count");
                        bundle0.putSerializable("data", new EventComment("count", AdcmtListFragment.this.mParam.chnlSeq, insertAdcmtReq$Params0.parntCmtSeq, true));
                        AdcmtListFragment.this.getParentFragmentManager().i0(bundle0, "comment_request_key");
                        return;
                    }
                    AdcmtListFragment.this.setInputMessage(s);
                    if("605".equals(insertAdcmtRes0.status)) {
                        TimeExpiredCache.getInstance().remove(AdcmtListFragment.this.mParam.cacheKeyOfCmtList);
                        AdcmtListFragment.this.removeRelatedCache();
                        l0 l00 = AdcmtListFragment.this.getChildFragmentManager();
                        String s = AdcmtListFragment.this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                        String s1 = AdcmtListFragment.this.getString(0x7F13001F);  // string:adcmt_can_not_write_on_deleted_cmt "삭제된 글에는 답글을 작성할 수 없습니다."
                        f f0 = new f(this);
                        com.melon.ui.popup.b.d(b0, l00, s, s1, false, false, false, null, E.a, null, f0, null, 0x400);
                        return;
                    }
                    if("405".equals(insertAdcmtRes0.status)) {
                        AdcmtListFragment.this.performCmtFetchErrorPopup(insertAdcmtRes0.errormessage, insertAdcmtRes0.status);
                        return;
                    }
                    AdcmtListFragment.this.performCmtFetchErrorToast(insertAdcmtRes0.errormessage);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((InsertAdcmtRes)object0));
                }
            }).errorListener(new ErrorListener() {
                @Override  // com.android.volley.Response$ErrorListener
                public void onErrorResponse(VolleyError volleyError0) {
                    AdcmtListFragment.this.setInputMessage(s);
                    ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                }
            }).request();
        }
    }
}

