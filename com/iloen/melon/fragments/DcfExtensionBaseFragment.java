package com.iloen.melon.fragments;

import R8.A;
import R8.y;
import android.app.RecoverableSecurityException;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.CType;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.drm.CollectionRulesDcf;
import com.iloen.melon.drm.DcfError;
import com.iloen.melon.drm.DcfExtendResult;
import com.iloen.melon.drm.DcfFile;
import com.iloen.melon.net.v4x.request.DeviceInformDeviceCheckReq.CallerType;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.CompatUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import e9.a;
import e9.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.jvm.internal.q;
import v9.e;
import v9.h;
import v9.i;
import v9.o;

public class DcfExtensionBaseFragment extends FetcherBaseFragment implements a {
    public class DcfExtendResultAdapter extends p {
        private static final String TAG = "DcfExtendResultAdapter";
        private static final int VIEW_TYPE_HEADER = 0;
        private static final int VIEW_TYPE_ITEM = 1;
        private String dcfExtensionInfoText;
        private String dcfExtensionMinusSongCount;
        private String dcfExtensionMinusSongCountText;
        private String dcfExtensionRemainSong;
        private String dcfExtensionRemainSongText;
        private boolean isAllSuccess;
        private boolean mHideDcfExtensionCountLayout;

        public DcfExtendResultAdapter(Context context0, ArrayList arrayList0, a a0) {
            super(context0, arrayList0);
            this.isAllSuccess = this.checkAllSuccess(arrayList0);
        }

        private boolean checkAllSuccess(ArrayList arrayList0) {
            for(Object object0: arrayList0) {
                if(((DcfExtendResult)object0).b.a != 0) {
                    return false;
                }
                if(false) {
                    break;
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getAvailableHeaderPosition() == v ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            int v2 = o00.getItemViewType();
            LogU.w("DcfExtendResultAdapter", "onBindViewImpl() viewType:" + v2);
            if(v2 == 0) {
                ViewUtils.hideWhen(HeaderViewHolder.c(((HeaderViewHolder)o00)), this.mHideDcfExtensionCountLayout);
                HeaderViewHolder.f(((HeaderViewHolder)o00)).setText(this.dcfExtensionMinusSongCountText);
                HeaderViewHolder.h(((HeaderViewHolder)o00)).setText(this.dcfExtensionRemainSongText);
                HeaderViewHolder.e(((HeaderViewHolder)o00)).setText(this.dcfExtensionMinusSongCount);
                HeaderViewHolder.g(((HeaderViewHolder)o00)).setText(this.dcfExtensionRemainSong);
                HeaderViewHolder.d(((HeaderViewHolder)o00)).setText(this.dcfExtensionInfoText);
                ViewUtils.setOnClickListener(HeaderViewHolder.b(((HeaderViewHolder)o00)), DcfExtensionBaseFragment.this.mDcfExtensionRetryListener);
                ViewUtils.setOnClickListener(HeaderViewHolder.a(((HeaderViewHolder)o00)), DcfExtensionBaseFragment.this.mDcfExtensionAllDeleteListener);
                ViewUtils.hideWhen(HeaderViewHolder.i(((HeaderViewHolder)o00)), this.isAllSuccess);
                return;
            }
            DcfExtendResult dcfExtendResult0 = (DcfExtendResult)this.getItem(v1);
            if(dcfExtendResult0 != null) {
                DcfFile dcfFile0 = dcfExtendResult0.a;
                DcfError dcfError0 = dcfExtendResult0.b;
                if(dcfFile0 != null) {
                    ViewHolder.b(((ViewHolder)o00)).setText(FilenameUtils.getBasename(dcfFile0.b()));
                }
                ViewHolder.a(((ViewHolder)o00)).setImageResource((dcfError0.a == 0 ? 0x7F080426 : 0x7F080425));  // drawable:ic_dcf_success
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return v == 0 ? new HeaderViewHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D01E2, viewGroup0, false)) : new ViewHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D01DE, viewGroup0, false));  // layout:dcf_extension_success_of_failure_header
        }

        public void setDcfExtensionCountLayoutVisible(boolean z) {
            this.mHideDcfExtensionCountLayout = !z;
        }

        public void setDcfExtensionInfoText(String s) {
            this.dcfExtensionInfoText = s;
        }

        public void setDcfExtensionMinusSongCount(String s) {
            this.dcfExtensionMinusSongCount = s;
        }

        public void setDcfExtensionRemainSong(String s) {
            this.dcfExtensionRemainSong = s;
        }

        public void setDcfExtensionSongTexts(String s, String s1) {
            this.dcfExtensionMinusSongCountText = s;
            this.dcfExtensionRemainSongText = s1;
        }
    }

    static class DeleteFailedComposer {
        ArrayList listFailedDcfFile;

        public DeleteFailedComposer(ArrayList arrayList0) {
            this.listFailedDcfFile = arrayList0;
        }

        public ArrayList getListFailedDcfFile() {
            return this.listFailedDcfFile;
        }

        public void setListFailedDcfFile(ArrayList arrayList0) {
            this.listFailedDcfFile = arrayList0;
        }
    }

    class DeleteFailedMelonPopupOnClickListener implements DialogInterface.OnClickListener {
        private DeleteFailedMelonPopupOnClickListener() {
        }

        public DeleteFailedMelonPopupOnClickListener(int v) {
        }

        @Override  // android.content.DialogInterface$OnClickListener
        public void onClick(DialogInterface dialogInterface0, int v) {
            FragmentActivity fragmentActivity0 = DcfExtensionBaseFragment.this.getActivity();
            if(fragmentActivity0 != null) {
                fragmentActivity0.getOnBackPressedDispatcher().c();
            }
        }
    }

    public static class DeleteSelectedComposer {
        DcfExtendResult dcfExtendResult;

        public DeleteSelectedComposer(DcfExtendResult dcfExtendResult0) {
            this.dcfExtendResult = dcfExtendResult0;
        }

        public DcfExtendResult getDcfExtendResult() {
            return this.dcfExtendResult;
        }

        public void setDcfExtendResult(DcfExtendResult dcfExtendResult0) {
            this.dcfExtendResult = dcfExtendResult0;
        }
    }

    class DeleteSelectedMelonPopupOnClickListener implements DialogInterface.OnClickListener {
        DeleteSelectedComposer deleteSelectedComposer;

        public DeleteSelectedMelonPopupOnClickListener(DeleteSelectedComposer dcfExtensionBaseFragment$DeleteSelectedComposer0) {
            this.deleteSelectedComposer = dcfExtensionBaseFragment$DeleteSelectedComposer0;
        }

        @Override  // android.content.DialogInterface$OnClickListener
        public void onClick(DialogInterface dialogInterface0, int v) {
            DcfExtendResultAdapter dcfExtensionBaseFragment$DcfExtendResultAdapter0 = (DcfExtendResultAdapter)DcfExtensionBaseFragment.this.getAdapter();
            DcfExtensionBaseFragment.this.listDcfExtendResult.remove(this.deleteSelectedComposer.getDcfExtendResult());
            dcfExtensionBaseFragment$DcfExtendResultAdapter0.notifyDataSetChanged();
        }
    }

    public static class HeaderViewHolder extends O0 {
        private View btnDcfExtensionAllDelete;
        private View btnDcfExtensionRetry;
        private View dcfExtensionCountLayout;
        private TextView dcfExtensionInfoText;
        private TextView dcfExtensionMinusSongCount;
        private TextView dcfExtensionMinusSongCountText;
        private TextView dcfExtensionRemainSong;
        private TextView dcfExtensionRemainSongText;
        private View layoutFailure;

        public HeaderViewHolder(View view0) {
            super(view0);
            this.dcfExtensionCountLayout = view0.findViewById(0x7F0A0382);  // id:dcf_extension_count_layout
            this.dcfExtensionMinusSongCountText = (TextView)view0.findViewById(0x7F0A038A);  // id:dcf_extension_minus_count_song_text
            this.dcfExtensionRemainSongText = (TextView)view0.findViewById(0x7F0A038D);  // id:dcf_extension_remained_song_text
            this.dcfExtensionMinusSongCount = (TextView)view0.findViewById(0x7F0A0389);  // id:dcf_extension_minus_count_song
            this.dcfExtensionRemainSong = (TextView)view0.findViewById(0x7F0A038B);  // id:dcf_extension_remained_song
            this.dcfExtensionInfoText = (TextView)view0.findViewById(0x7F0A0386);  // id:dcf_extension_info_text1
            this.layoutFailure = view0.findViewById(0x7F0A071B);  // id:layout_failure
            this.btnDcfExtensionRetry = view0.findViewById(0x7F0A0156);  // id:btn_dcf_extension_retry
            this.btnDcfExtensionAllDelete = view0.findViewById(0x7F0A0154);  // id:btn_dcf_extension_all_delete
        }

        public static View a(HeaderViewHolder dcfExtensionBaseFragment$HeaderViewHolder0) {
            return dcfExtensionBaseFragment$HeaderViewHolder0.btnDcfExtensionAllDelete;
        }

        public static View b(HeaderViewHolder dcfExtensionBaseFragment$HeaderViewHolder0) {
            return dcfExtensionBaseFragment$HeaderViewHolder0.btnDcfExtensionRetry;
        }

        public static View c(HeaderViewHolder dcfExtensionBaseFragment$HeaderViewHolder0) {
            return dcfExtensionBaseFragment$HeaderViewHolder0.dcfExtensionCountLayout;
        }

        public static TextView d(HeaderViewHolder dcfExtensionBaseFragment$HeaderViewHolder0) {
            return dcfExtensionBaseFragment$HeaderViewHolder0.dcfExtensionInfoText;
        }

        public static TextView e(HeaderViewHolder dcfExtensionBaseFragment$HeaderViewHolder0) {
            return dcfExtensionBaseFragment$HeaderViewHolder0.dcfExtensionMinusSongCount;
        }

        public static TextView f(HeaderViewHolder dcfExtensionBaseFragment$HeaderViewHolder0) {
            return dcfExtensionBaseFragment$HeaderViewHolder0.dcfExtensionMinusSongCountText;
        }

        public static TextView g(HeaderViewHolder dcfExtensionBaseFragment$HeaderViewHolder0) {
            return dcfExtensionBaseFragment$HeaderViewHolder0.dcfExtensionRemainSong;
        }

        public static TextView h(HeaderViewHolder dcfExtensionBaseFragment$HeaderViewHolder0) {
            return dcfExtensionBaseFragment$HeaderViewHolder0.dcfExtensionRemainSongText;
        }

        public static View i(HeaderViewHolder dcfExtensionBaseFragment$HeaderViewHolder0) {
            return dcfExtensionBaseFragment$HeaderViewHolder0.layoutFailure;
        }
    }

    public static class ViewHolder extends O0 {
        private ImageView status;
        private TextView title;

        public ViewHolder(View view0) {
            super(view0);
            this.title = (TextView)view0.findViewById(0x7F0A0C5C);  // id:tv_dcf_extension_result_song_title
            this.status = (ImageView)view0.findViewById(0x7F0A0695);  // id:iv_status
        }

        public static ImageView a(ViewHolder dcfExtensionBaseFragment$ViewHolder0) {
            return dcfExtensionBaseFragment$ViewHolder0.status;
        }

        public static TextView b(ViewHolder dcfExtensionBaseFragment$ViewHolder0) {
            return dcfExtensionBaseFragment$ViewHolder0.title;
        }
    }

    private static final String TAG = "DcfExtensionBaseFragment";
    private static final boolean USE_POPUP_FOR_DELETION_FAIL = false;
    protected CollectionRulesDcf collectionRulesDcf;
    protected int countOfDeduct;
    protected int dcfType;
    protected ArrayList listDcfExtendResult;
    private final View.OnClickListener mDcfExtensionAllDeleteListener;
    private final View.OnClickListener mDcfExtensionRetryListener;
    protected TextView mTitle;

    public DcfExtensionBaseFragment() {
        this.listDcfExtendResult = new ArrayList();
        this.countOfDeduct = 0;
        this.dcfType = -1;
        this.mDcfExtensionRetryListener = new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                LinkedList linkedList0 = new LinkedList();
                for(Object object0: DcfExtensionBaseFragment.this.listDcfExtendResult) {
                    DcfFile dcfFile0 = ((DcfExtendResult)object0).a;
                    if(((DcfExtendResult)object0).b.a != 0) {
                        linkedList0.add(dcfFile0);
                    }
                }
                if(linkedList0.size() != 0) {
                    DcfExtensionBaseFragment dcfExtensionBaseFragment0 = DcfExtensionBaseFragment.this;
                    if(dcfExtensionBaseFragment0.collectionRulesDcf == null) {
                        new y(linkedList0, CallerType.DCF).execute(null);
                        return;
                    }
                    FragmentActivity fragmentActivity0 = dcfExtensionBaseFragment0.getActivity();
                    if(fragmentActivity0 != null && !fragmentActivity0.isFinishing()) {
                        MelonTextPopup melonTextPopup0 = new MelonTextPopup(fragmentActivity0, 2);
                        melonTextPopup0.setTitleName(DcfExtensionBaseFragment.this.getString(0x7F1300D0));  // string:alert_dlg_title_info "안내"
                        melonTextPopup0.setBodyMsg(DcfExtensionBaseFragment.this.getString(0x7F1302D3));  // string:dcf_extension_retry_alert "실패 파일 기간연장을 재시도합니다.\n\n기간연장이 계속 실패할 경우,\n파일 삭제 
                                                                                                          // 후 재다운로드 해주세요."
                        melonTextPopup0.setPopupOnClickListener(new DialogInterface.OnClickListener() {
                            @Override  // android.content.DialogInterface$OnClickListener
                            public void onClick(DialogInterface dialogInterface0, int v) {
                                if(v == -1) {
                                    CType cType0 = 1 == DcfExtensionBaseFragment.this.dcfType ? CType.EDU : CType.SONG;
                                    A a0 = new A(linkedList0, CallerType.DCF);
                                    q.g(cType0, "cType");
                                    a0.g = cType0;
                                    a0.execute(null);
                                }
                            }
                        });
                        melonTextPopup0.show();
                    }
                }
            }
        };
        this.mDcfExtensionAllDeleteListener = new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: DcfExtensionBaseFragment.this.listDcfExtendResult) {
                    DcfExtendResult dcfExtendResult0 = (DcfExtendResult)object0;
                    if(dcfExtendResult0.b.a != 0) {
                        arrayList0.add(dcfExtendResult0);
                    }
                }
                if(arrayList0.size() == 0) {
                    return;
                }
                MelonTextPopup melonTextPopup0 = new MelonTextPopup(DcfExtensionBaseFragment.this.getActivity());
                melonTextPopup0.setTitleName(DcfExtensionBaseFragment.this.getString(0x7F1300D0));  // string:alert_dlg_title_info "안내"
                melonTextPopup0.setBodyMsg(DcfExtensionBaseFragment.this.getString(0x7F1302CD));  // string:dcf_extension_delete_all_failed "실패 파일을 완전히 삭제합니다.\n\n다운로드 이력은 음악서랍>다운로드>구매목록에서 
                                                                                                  // 확인 가능합니다."
                melonTextPopup0.setPopupOnClickListener(new DialogInterface.OnClickListener() {
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface dialogInterface0, int v) {
                        if(v == -1) {
                            DcfExtensionBaseFragment.this.showProgressDialog();
                            String[] arr_s = new String[arrayList0.size()];
                            int v1 = 0;
                            for(Object object0: arrayList0) {
                                arr_s[v1] = ((DcfExtendResult)object0).a.c();
                                LogU.d("DcfExtensionBaseFragment", "delete - strList = " + arr_s[v1]);
                                ++v1;
                            }
                            DeleteFailedComposer dcfExtensionBaseFragment$DeleteFailedComposer0 = new DeleteFailedComposer(arrayList0);
                            b b0 = new b(DcfExtensionBaseFragment.this.getContext(), DcfExtensionBaseFragment.this);
                            b0.d = 0;
                            b0.a(arr_s, dcfExtensionBaseFragment$DeleteFailedComposer0);
                        }
                    }
                });
                melonTextPopup0.show();
            }
        };
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new DcfExtendResultAdapter(this, this.getContext(), this.listDcfExtendResult, this);
        ((p)j00).setEmptyViewInfo(e.n);
        ((p)j00).setErrorViewInfo(o.j);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "dcfCapExtensionResult");
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D02A8, viewGroup0, false);  // layout:fragment_dcf_extension_success_or_failure
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        return false;
    }

    @Override  // e9.a
    public void onRemoveComplete(int v, Object object0) {
        String s1;
        DeleteSelectedComposer dcfExtensionBaseFragment$DeleteSelectedComposer0;
        DeleteFailedComposer dcfExtensionBaseFragment$DeleteFailedComposer0;
        this.dismissProgressDialog();
        if(object0 instanceof DeleteFailedComposer) {
            dcfExtensionBaseFragment$DeleteFailedComposer0 = (DeleteFailedComposer)object0;
            dcfExtensionBaseFragment$DeleteSelectedComposer0 = null;
        }
        else if(object0 instanceof DeleteSelectedComposer) {
            dcfExtensionBaseFragment$DeleteSelectedComposer0 = (DeleteSelectedComposer)object0;
            dcfExtensionBaseFragment$DeleteFailedComposer0 = null;
        }
        else {
            dcfExtensionBaseFragment$DeleteFailedComposer0 = null;
            dcfExtensionBaseFragment$DeleteSelectedComposer0 = null;
        }
        switch(v) {
            case 1: {
                ToastManager.show(0x7F1302EC);  // string:delete_now_playlist_failed "재생중인 곡은 삭제 할 수 없습니다."
                return;
            }
            case 2: {
                ToastManager.show(0x7F1302E8);  // string:delete_now_multi_failed "재생중인곡을 제외하고 삭제하였습니다."
                return;
            }
            default: {
                FragmentActivity fragmentActivity0 = this.getActivity();
                if(fragmentActivity0 != null && !fragmentActivity0.isFinishing()) {
                    new MelonTextPopup(fragmentActivity0, 1);
                    if(dcfExtensionBaseFragment$DeleteFailedComposer0 != null) {
                        String s = this.getString(0x7F1302D1);  // string:dcf_extension_result_delete_all_failed "요청하신 파일이 삭제 되었습니다."
                        int v1 = dcfExtensionBaseFragment$DeleteFailedComposer0.getListFailedDcfFile().size();
                        int v2 = this.dcfType;
                        if(v2 == 0) {
                            s1 = this.getString(0x7F1302D4, new Object[]{v1});  // string:dcf_extension_song_count "\n(음악 %1$d개)"
                        }
                        else {
                            s1 = 1 == v2 ? this.getString(0x7F1302CE, new Object[]{v1}) : "";  // string:dcf_extension_edu_count "\n(어학 %1$d개)"
                        }
                        ToastManager.show((s + s1));
                        new DeleteFailedMelonPopupOnClickListener(this, 0).onClick(null, 0);
                        return;
                    }
                    if(dcfExtensionBaseFragment$DeleteSelectedComposer0 != null) {
                        ToastManager.show(this.getString(0x7F1302D2));  // string:dcf_extension_result_delete_selected_failed "요청하신 파일이 삭제 되었습니다."
                        new DeleteSelectedMelonPopupOnClickListener(this, dcfExtensionBaseFragment$DeleteSelectedComposer0).onClick(null, 0);
                    }
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        this.listDcfExtendResult.addAll(((Collection)CompatUtils.getSerializable(this.getArguments(), "dcf_extend_result_list", ArrayList.class)));
        this.countOfDeduct = this.getArguments().getInt("dcf_extend_count_deduct");
        this.collectionRulesDcf = (CollectionRulesDcf)CompatUtils.getSerializable(this.getArguments(), "dcf_extend_dcf_info", CollectionRulesDcf.class);
        this.dcfType = this.getArguments().getInt("dcf_extend_dcf_type", -1);
    }

    @Override  // e9.a
    public void onThrowRecoverableSecurityException(RecoverableSecurityException recoverableSecurityException0) {
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle("DCF 기간연장");
        }
    }
}

