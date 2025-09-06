package com.iloen.melon.fragments;

import R6.c;
import R8.A;
import R8.B;
import R8.l;
import R8.t;
import R8.w;
import R8.x;
import a9.d;
import android.app.RecoverableSecurityException;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import b3.Z;
import com.iloen.melon.adapters.common.ListMarkerArrayAdapter;
import com.iloen.melon.constants.CType;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.drm.CollectionRulesDcf;
import com.iloen.melon.drm.DcfExtendResult;
import com.iloen.melon.drm.DcfFile;
import com.iloen.melon.net.v4x.request.DeviceInformDeviceCheckReq.CallerType;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.task.TaskState;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import e9.a;
import e9.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import v9.h;
import v9.i;
import x8.g;

public class DcfExtensionNeededBrowserFragment extends FetcherBaseFragment implements a {
    public static class DcfExtendNeededAdapter extends ListMarkerArrayAdapter {
        public static class Composer implements Serializable {
            private DcfFile dcfFile;
            private static final long serialVersionUID = 0x2B0D2F5523E0B8B2L;

            public Composer(DcfFile dcfFile0) {
                this.dcfFile = dcfFile0;
            }

            public DcfFile getDcfFile() {
                return this.dcfFile;
            }

            public void setDcfFile(DcfFile dcfFile0) {
                this.dcfFile = dcfFile0;
            }
        }

        public static final String TAG = "DcfExtendNeededAdapter";

        public DcfExtendNeededAdapter(Context context0) {
            super(context0);
            this.setMarkedMode(true);
        }

        @Override  // com.iloen.melon.adapters.common.ListMarkerArrayAdapter
        public long getItemId(int v) {
            return (long)v;
        }

        @Override  // android.widget.ArrayAdapter
        public View getView(int v, View view0, ViewGroup viewGroup0) {
            if(view0 == null) {
                view0 = LayoutInflater.from(this.mContext).inflate(0x7F0D01E0, null);  // layout:dcf_extension_needed_item
            }
            boolean z = this.isMarked(v);
            view0.findViewById(0x7F0A0792).setBackgroundResource((z ? 0x7F060199 : 0x7F06048A));  // id:ll_dcf_extension_fail_song_title
            ((ImageView)view0.findViewById(0x7F0A0149)).setImageResource((z ? 0x7F080123 : 0x7F080121));  // id:btn_check
            MelonTextView melonTextView0 = (MelonTextView)view0.findViewById(0x7F0A0C5B);  // id:tv_dcf_extension_need_song_title
            ViewUtils.setTextViewMarquee(melonTextView0, this.isMarqueeNeeded(v));
            melonTextView0.setText(FilenameUtils.getBasename(((Composer)this.getItem(v)).getDcfFile().b()));
            return view0;
        }

        public void setListComposer(ArrayList arrayList0) {
            this.clear();
            this.addAll(arrayList0);
        }
    }

    static class DeleteAllComposer {
        int countOfEdu;
        int countOfMusic;

        public DeleteAllComposer(int v, int v1) {
            this.countOfMusic = v;
            this.countOfEdu = v1;
        }

        public int getCountOfEdu() {
            return this.countOfEdu;
        }

        public int getCountOfMusic() {
            return this.countOfMusic;
        }

        public void setCountOfEdu(int v) {
            this.countOfEdu = v;
        }

        public void setCountOfMusic(int v) {
            this.countOfMusic = v;
        }
    }

    static class DeleteSelectedComposer {
        int countOfSelection;

        public DeleteSelectedComposer(int v) {
            this.countOfSelection = v;
        }

        public int getCountOfSelection() {
            return this.countOfSelection;
        }

        public void setCountOfSelection(int v) {
            this.countOfSelection = v;
        }
    }

    private static final String ARG_FILTER_TYPE = "argFilterType";
    public static final int FILTER_EDU = 1;
    public static final int FILTER_SONG = 0;
    private static final String TAG = "DcfExtensionNeededBrowserFragment";
    private DcfExtendNeededAdapter adaptorDcfFileEdu;
    private DcfExtendNeededAdapter adaptorDcfFileMusic;
    private int countOfdeduct;
    private DcfExtendNeededAdapter currentDcfExtendNeededAdapter;
    protected MelonTextView dcfExtensionInfoText1;
    protected MelonTextView dcfExtensionInfoText2;
    protected MelonTextView dcfExtensionInfoText3;
    protected MelonTextView dcfExtensionRemainedSong;
    protected MelonTextView dcfExtensionRemainedSongExplain;
    private LinkedList linkedListDcfFile;
    private ArrayList listDcfFileEdu;
    private ArrayList listDcfFileMusic;
    private TextView mBtnDeleteAll;
    private CheckedTextView mCheckButton;
    protected int mCurrentFilterIndex;
    private View mSelectBar;
    protected TextView mTitle;

    public DcfExtensionNeededBrowserFragment() {
        this.mCurrentFilterIndex = 0;
        this.listDcfFileMusic = new ArrayList();
        this.listDcfFileEdu = new ArrayList();
        this.linkedListDcfFile = new LinkedList();
        this.countOfdeduct = 0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public ToolBar buildToolBar() {
        return ToolBar.f(((ToolBar)this.findViewById(0x7F0A0BC6)), 101);  // id:toolbar_layout
    }

    private void changeFilter(int v) {
        if(v == 0) {
            this.currentDcfExtendNeededAdapter = this.adaptorDcfFileMusic;
        }
        else if(1 == v) {
            this.currentDcfExtendNeededAdapter = this.adaptorDcfFileEdu;
        }
        else {
            LogU.w("DcfExtensionNeededBrowserFragment", "changeFilter() unknown type:" + v);
        }
        this.setListViewAdapter(this.currentDcfExtendNeededAdapter);
        this.showBottomButtonsIfPossible();
        this.updateViews();
        l l0 = c.g();
        if(l0 != null) {
            this.updateNotice((v == 0 ? l0.d : l0.e), null);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "dcfCapExtensionList");
    }

    private int getSelectedCount() {
        return this.currentDcfExtendNeededAdapter == null ? 0 : this.currentDcfExtendNeededAdapter.getMarkedCount();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasEmptyViewInAbsListView() {
        return false;
    }

    private void initView() {
        this.createAbsListView(0x7F0A0779);  // id:list
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D01E1, null, true);  // layout:dcf_extension_needed_item_header
        this.dcfExtensionRemainedSongExplain = (MelonTextView)view0.findViewById(0x7F0A038C);  // id:dcf_extension_remained_song_explain
        this.dcfExtensionRemainedSong = (MelonTextView)view0.findViewById(0x7F0A038B);  // id:dcf_extension_remained_song
        this.dcfExtensionInfoText1 = (MelonTextView)view0.findViewById(0x7F0A0386);  // id:dcf_extension_info_text1
        this.dcfExtensionInfoText2 = (MelonTextView)view0.findViewById(0x7F0A0387);  // id:dcf_extension_info_text2
        this.dcfExtensionInfoText3 = (MelonTextView)view0.findViewById(0x7F0A0388);  // id:dcf_extension_info_text3
        TextView textView0 = (TextView)view0.findViewById(0x7F0A0155);  // id:btn_dcf_extension_list_delete_all
        this.mBtnDeleteAll = textView0;
        ViewUtils.setOnClickListener(textView0, new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(!DcfExtensionNeededBrowserFragment.this.linkedListDcfFile.isEmpty()) {
                    MelonTextPopup melonTextPopup0 = new MelonTextPopup(DcfExtensionNeededBrowserFragment.this.getActivity());
                    melonTextPopup0.setTitleName(DcfExtensionNeededBrowserFragment.this.getString(0x7F1300D0));  // string:alert_dlg_title_info "안내"
                    melonTextPopup0.setBodyMsg(DcfExtensionNeededBrowserFragment.this.getString(0x7F1302B8));  // string:dcf_extend_delete_all_expired "재생기간이 만료된 DCF 파일을\n전체 삭제하시겠습니까?\n\n다운로드 이력은 
                                                                                                               // 음악서랍>다운로드>구매목록에서 확인 가능합니다."
                    melonTextPopup0.setPopupOnClickListener(new DialogInterface.OnClickListener() {
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface dialogInterface0, int v) {
                            String[] arr_s;
                            if(v == -1 && DcfExtensionNeededBrowserFragment.this.listDcfFileEdu.size() + DcfExtensionNeededBrowserFragment.this.listDcfFileMusic.size() != 0) {
                                int v1 = DcfExtensionNeededBrowserFragment.this.listDcfFileMusic.size();
                                int v2 = DcfExtensionNeededBrowserFragment.this.listDcfFileEdu.size();
                                DcfExtensionNeededBrowserFragment.this.showProgressDialog();
                                DcfExtensionNeededBrowserFragment dcfExtensionNeededBrowserFragment0 = DcfExtensionNeededBrowserFragment.this;
                                if(dcfExtensionNeededBrowserFragment0.mCurrentFilterIndex == 0) {
                                    arr_s = new String[v1];
                                    int v3 = 0;
                                    for(Object object0: dcfExtensionNeededBrowserFragment0.listDcfFileMusic) {
                                        String s = ((Composer)object0).getDcfFile().c();
                                        Z.w("delete - strList = ", s, "DcfExtensionNeededBrowserFragment");
                                        arr_s[v3] = s;
                                        ++v3;
                                    }
                                }
                                else {
                                    arr_s = new String[v2];
                                    int v4 = 0;
                                    for(Object object1: dcfExtensionNeededBrowserFragment0.listDcfFileEdu) {
                                        String s1 = ((Composer)object1).getDcfFile().c();
                                        Z.w("delete - strList = ", s1, "DcfExtensionNeededBrowserFragment");
                                        arr_s[v4] = s1;
                                        ++v4;
                                    }
                                }
                                DeleteAllComposer dcfExtensionNeededBrowserFragment$DeleteAllComposer0 = new DeleteAllComposer(v1, v2);
                                b b0 = new b(DcfExtensionNeededBrowserFragment.this.getContext(), DcfExtensionNeededBrowserFragment.this);
                                b0.d = 0;
                                b0.a(arr_s, dcfExtensionNeededBrowserFragment$DeleteAllComposer0);
                            }
                        }
                    });
                    melonTextPopup0.show();
                }
            }
        });
        SortingBarView sortingBarView0 = (SortingBarView)view0.findViewById(0x7F0A0AB8);  // id:sort_bar
        sortingBarView0.setSelection(this.mCurrentFilterIndex);
        sortingBarView0.setOnSortSelectionListener(new d() {
            @Override  // a9.d
            public void onSelected(int v) {
                DcfExtensionNeededBrowserFragment dcfExtensionNeededBrowserFragment0 = DcfExtensionNeededBrowserFragment.this;
                if(dcfExtensionNeededBrowserFragment0.mCurrentFilterIndex == v) {
                    return;
                }
                dcfExtensionNeededBrowserFragment0.mCurrentFilterIndex = v;
                if(dcfExtensionNeededBrowserFragment0.mCheckButton != null && DcfExtensionNeededBrowserFragment.this.currentDcfExtendNeededAdapter != null) {
                    DcfExtensionNeededBrowserFragment.this.mCheckButton.setChecked(false);
                    DcfExtensionNeededBrowserFragment.this.currentDcfExtendNeededAdapter.setUnmarkedAll();
                }
                DcfExtensionNeededBrowserFragment.this.changeFilter(v);
            }
        });
        this.mSelectBar = view0.findViewById(0x7F0A0A57);  // id:select_bar
        CheckedTextView checkedTextView0 = (CheckedTextView)view0.findViewById(0x7F0A0096);  // id:all_select_ctv
        this.mCheckButton = checkedTextView0;
        ViewUtils.setOnClickListener(checkedTextView0, new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                boolean z = DcfExtensionNeededBrowserFragment.this.mCheckButton.isChecked();
                DcfExtensionNeededBrowserFragment.this.mCheckButton.setChecked(!z);
                DcfExtendNeededAdapter dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0 = DcfExtensionNeededBrowserFragment.this.currentDcfExtendNeededAdapter;
                if(dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0 != null) {
                    if(z) {
                        dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0.setUnmarkedAll();
                    }
                    else {
                        dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0.setMarkedAll();
                    }
                    dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0.notifyDataSetInvalidated();
                    DcfExtensionNeededBrowserFragment.this.showBottomButtonsIfPossible();
                }
            }
        });
        this.addListHeaderView(view0);
        this.adaptorDcfFileMusic = new DcfExtendNeededAdapter(this.getContext());
        this.adaptorDcfFileEdu = new DcfExtendNeededAdapter(this.getContext());
        this.changeFilter(this.mCurrentFilterIndex);
        this.startTask();
    }

    public static DcfExtensionNeededBrowserFragment newInstance() {
        return DcfExtensionNeededBrowserFragment.newInstance(0);
    }

    public static DcfExtensionNeededBrowserFragment newInstance(int v) {
        DcfExtensionNeededBrowserFragment dcfExtensionNeededBrowserFragment0 = new DcfExtensionNeededBrowserFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argFilterType", v);
        dcfExtensionNeededBrowserFragment0.setArguments(bundle0);
        return dcfExtensionNeededBrowserFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D01DF, viewGroup0, false);  // layout:dcf_extension_needed_browser
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(g g0) {
        x8.b b0 = g0.a;
        TaskState taskState0 = g0.b;
        if(b0 instanceof w) {
            if(taskState0.equals(TaskState.FINISHED) && 1 == this.mCurrentFilterIndex) {
                l l0 = c.g();
                if(l0 != null) {
                    this.updateNotice(l0.e, ((w)b0).a);
                }
            }
        }
        else if(b0 instanceof B) {
            if(taskState0.equals(TaskState.FINISHED)) {
                LinkedList linkedList0 = ((B)b0).a;
                ArrayList arrayList0 = new ArrayList();
                ArrayList arrayList1 = new ArrayList();
                LogU.i("DcfExtensionNeededBrowserFragment", linkedList0.toString());
                for(Object object0: linkedList0) {
                    LogU.i("DcfExtensionNeededBrowserFragment", ((DcfFile)object0).toString());
                    Composer dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter$Composer0 = new Composer(((DcfFile)object0));
                    if(CType.SONG.equals(((DcfFile)object0).c)) {
                        arrayList0.add(dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter$Composer0);
                    }
                    else {
                        arrayList1.add(dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter$Composer0);
                    }
                }
                this.linkedListDcfFile = linkedList0;
                this.listDcfFileMusic = arrayList0;
                this.listDcfFileEdu = arrayList1;
                this.adaptorDcfFileMusic.setListComposer(arrayList0);
                this.adaptorDcfFileMusic.notifyDataSetChanged();
                this.adaptorDcfFileEdu.setListComposer(this.listDcfFileEdu);
                this.adaptorDcfFileEdu.notifyDataSetChanged();
                this.dismissProgressDialog();
                this.showBottomButtonsIfPossible();
                this.updateViews();
            }
        }
        else if(b0 instanceof A) {
            if(taskState0.equals(TaskState.FINISHED)) {
                this.dismissProgressDialog();
                this.countOfdeduct = ((A)b0).d;
                ArrayList arrayList2 = ((A)b0).c;
                if(arrayList2 != null) {
                    goto label_49;
                }
                LogU.e("DcfExtensionNeededBrowserFragment", "onEventMainThread::EventCoroutineAsyncTask :: TaskExtendDueDateForMrCap :: listDcfExtendResultInSync is null - error = " + ((A)b0).f);
                if(((A)b0).f != null) {
                    MelonTextPopup melonTextPopup0 = new MelonTextPopup(this.getActivity(), 1);
                    melonTextPopup0.setTitleName(this.getString(0x7F1300D0));  // string:alert_dlg_title_info "안내"
                    melonTextPopup0.setBodyMsg(((A)b0).f.getMessage());
                    melonTextPopup0.setPopupOnClickListener(new DialogInterface.OnClickListener() {
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface dialogInterface0, int v) {
                            DcfExtensionNeededBrowserFragment.this.getActivity().getOnBackPressedDispatcher().c();
                        }
                    });
                    melonTextPopup0.show();
                    return;
                label_49:
                    int v = 0;
                    for(Object object1: arrayList2) {
                        if(((DcfExtendResult)object1).b.a != 0) {
                            ++v;
                        }
                    }
                    CollectionRulesDcf collectionRulesDcf0 = ((A)b0).h;
                    if(v == 0) {
                        Navigator.open(DcfExtensionSuccessBrowserFragment.newInstance(arrayList2, this.countOfdeduct, collectionRulesDcf0, this.mCurrentFilterIndex));
                        return;
                    }
                    Navigator.open(DcfExtensionFailBrowserFragment.newInstance(arrayList2, this.countOfdeduct, collectionRulesDcf0, this.mCurrentFilterIndex));
                }
            }
        }
        else if(b0 instanceof x && taskState0.equals(TaskState.FINISHED) && this.mCurrentFilterIndex == 0) {
            l l1 = c.g();
            if(l1 != null) {
                this.updateNotice(l1.d, ((x)b0).a);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        this.mCheckButton.setChecked(false);
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onListItemClick(AdapterView adapterView0, View view0, int v, long v1, Object object0) {
        DcfExtendNeededAdapter dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0 = this.currentDcfExtendNeededAdapter;
        boolean z = false;
        if(dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0 == null) {
            LogU.w("DcfExtensionNeededBrowserFragment", "onListItemClick() invalid adapter");
            return false;
        }
        dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0.setMarked(v, !dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0.isMarked(v));
        dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0.notifyDataSetInvalidated();
        this.showBottomButtonsIfPossible();
        CheckedTextView checkedTextView0 = this.mCheckButton;
        if(dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0.getMarkedCount() > 0) {
            z = true;
        }
        checkedTextView0.setChecked(z);
        return true;
    }

    @Override  // e9.a
    public void onRemoveComplete(int v, Object object0) {
        DeleteSelectedComposer dcfExtensionNeededBrowserFragment$DeleteSelectedComposer0;
        DeleteAllComposer dcfExtensionNeededBrowserFragment$DeleteAllComposer0;
        this.dismissProgressDialog();
        DcfExtendNeededAdapter dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0 = this.currentDcfExtendNeededAdapter;
        if(dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0 != null) {
            this.mCheckButton.setChecked(false);
            dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0.setUnmarkedAll();
        }
        if(object0 instanceof DeleteAllComposer) {
            dcfExtensionNeededBrowserFragment$DeleteAllComposer0 = (DeleteAllComposer)object0;
            dcfExtensionNeededBrowserFragment$DeleteSelectedComposer0 = null;
        }
        else if(object0 instanceof DeleteSelectedComposer) {
            dcfExtensionNeededBrowserFragment$DeleteSelectedComposer0 = (DeleteSelectedComposer)object0;
            dcfExtensionNeededBrowserFragment$DeleteAllComposer0 = null;
        }
        else {
            dcfExtensionNeededBrowserFragment$DeleteAllComposer0 = null;
            dcfExtensionNeededBrowserFragment$DeleteSelectedComposer0 = null;
        }
        switch(v) {
            case 1: {
                ToastManager.show(0x7F1302EC);  // string:delete_now_playlist_failed "재생중인 곡은 삭제 할 수 없습니다."
                new B().execute(null);
                return;
            }
            case 2: {
                ToastManager.show(0x7F1302E8);  // string:delete_now_multi_failed "재생중인곡을 제외하고 삭제하였습니다."
                new B().execute(null);
                return;
            }
            default: {
                if(dcfExtensionNeededBrowserFragment$DeleteAllComposer0 != null) {
                    int v1 = this.mCurrentFilterIndex;
                    if(v1 == 0) {
                        ToastManager.show(this.getString(0x7F1302C9, new Object[]{dcfExtensionNeededBrowserFragment$DeleteAllComposer0.getCountOfMusic()}));  // string:dcf_extend_result_delete_selected_expired_song "요청하신 파일이 삭제 되었습니다.\n(음악 %1$d개)"
                        this.listDcfFileMusic.clear();
                    }
                    else if(1 == v1) {
                        ToastManager.show(this.getString(0x7F1302C8, new Object[]{dcfExtensionNeededBrowserFragment$DeleteAllComposer0.getCountOfEdu()}));  // string:dcf_extend_result_delete_selected_expired_edu "요청하신 파일이 삭제 되었습니다.\n(어학 %1$d개)"
                        this.listDcfFileEdu.clear();
                    }
                    if(this.listDcfFileMusic.isEmpty() && this.listDcfFileEdu.isEmpty()) {
                        this.getActivity().getOnBackPressedDispatcher().c();
                        return;
                    }
                    new B().execute(null);
                    return;
                }
                if(dcfExtensionNeededBrowserFragment$DeleteSelectedComposer0 != null) {
                    String s = String.format(this.getString(0x7F1302C9), dcfExtensionNeededBrowserFragment$DeleteSelectedComposer0.getCountOfSelection());  // string:dcf_extend_result_delete_selected_expired_song "요청하신 파일이 삭제 되었습니다.\n(음악 %1$d개)"
                    if(1 == this.mCurrentFilterIndex) {
                        s = String.format(this.getString(0x7F1302C8), dcfExtensionNeededBrowserFragment$DeleteSelectedComposer0.getCountOfSelection());  // string:dcf_extend_result_delete_selected_expired_edu "요청하신 파일이 삭제 되었습니다.\n(어학 %1$d개)"
                    }
                    ToastManager.show(s);
                    new B().execute(null);
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        this.mCurrentFilterIndex = bundle0.getInt("argFilterType", 0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putInt("argFilterType", this.mCurrentFilterIndex);
        }
    }

    @Override  // e9.a
    public void onThrowRecoverableSecurityException(RecoverableSecurityException recoverableSecurityException0) {
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onToolBarClick(ToolBarItem toolBar$ToolBarItem0, int v) {
        if(6 == v) {
            int v1 = this.getSelectedCount();
            if(v1 != 0) {
                l l0 = c.g();
                CollectionRulesDcf collectionRulesDcf0 = this.mCurrentFilterIndex == 0 ? l0.d : l0.e;
                ArrayList arrayList0 = new ArrayList();
                DcfExtendNeededAdapter dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0 = this.currentDcfExtendNeededAdapter;
                if(dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0 != null) {
                    for(Object object0: dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0.getMarkedItems()) {
                        DcfFile dcfFile0 = ((Composer)dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0.getItem(((int)(((Integer)object0))))).getDcfFile();
                        arrayList0.add(dcfFile0);
                        LogU.d("DcfExtensionNeededBrowserFragment", "selected for extend - dcfFile = " + dcfFile0);
                    }
                }
                if(collectionRulesDcf0 != null && collectionRulesDcf0.f < arrayList0.size()) {
                    String s = String.format(this.getString(0x7F1302B7), v1, collectionRulesDcf0.f);  // string:dcf_extend_confirm_not_enough_cap "보유 중인 이용권의 잔여 곡 수가 부족\n하여 기간연장을 진행할 수 
                                                                                                      // 없습니다.\n(요청 %1$d/잔여 %2$d곡)"
                    l0 l00 = this.getChildFragmentManager();
                    String s1 = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                    com.melon.ui.popup.b.a.c(l00, s1, s);
                    return;
                }
                if(collectionRulesDcf0 != null) {
                    MelonTextPopup melonTextPopup0 = new MelonTextPopup(this.getActivity());
                    melonTextPopup0.setTitleName(this.getString(0x7F1300D0));  // string:alert_dlg_title_info "안내"
                    melonTextPopup0.setBodyMsg(String.format(this.getString(0x7F1302B6), v1));  // string:dcf_extend_confirm_extend_selected_contents "선택한 %1$d개 파일의 재생 기간연장을\n진행하시겠습니까?"
                    melonTextPopup0.setPopupOnClickListener(new DialogInterface.OnClickListener() {
                        @Override  // android.content.DialogInterface$OnClickListener
                        public void onClick(DialogInterface dialogInterface0, int v) {
                            if(v == -1) {
                                DcfExtensionNeededBrowserFragment.this.showProgressDialog();
                                CType cType0 = DcfExtensionNeededBrowserFragment.this.mCurrentFilterIndex == 0 ? CType.SONG : CType.EDU;
                                A a0 = new A(arrayList0, CallerType.DCF);
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
        else if(7 == v) {
            MelonTextPopup melonTextPopup1 = new MelonTextPopup(this.getActivity());
            melonTextPopup1.setTitleName(this.getString(0x7F1300D0));  // string:alert_dlg_title_info "안내"
            melonTextPopup1.setBodyMsg(this.getString(0x7F1302B5));  // string:dcf_extend_confirm_delete_selected_contents "선택한 DCF 파일을 삭제하시겠습니까?\n\n다운로드 
                                                                     // 이력은 음악서랍>다운로드>구매목록에서 확인 가능합니다."
            melonTextPopup1.setPopupOnClickListener(new DialogInterface.OnClickListener() {
                @Override  // android.content.DialogInterface$OnClickListener
                public void onClick(DialogInterface dialogInterface0, int v) {
                    if(v == -1) {
                        int v1 = DcfExtensionNeededBrowserFragment.this.getSelectedCount();
                        if(v1 != 0) {
                            DcfExtensionNeededBrowserFragment.this.showProgressDialog();
                            String[] arr_s = new String[v1];
                            DcfExtendNeededAdapter dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0 = DcfExtensionNeededBrowserFragment.this.currentDcfExtendNeededAdapter;
                            if(dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0 != null) {
                                int v2 = 0;
                                for(Object object0: dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0.getMarkedItems()) {
                                    String s = ((Composer)dcfExtensionNeededBrowserFragment$DcfExtendNeededAdapter0.getItem(((int)(((Integer)object0))))).getDcfFile().c();
                                    Z.w("delete - strList = ", s, "DcfExtensionNeededBrowserFragment");
                                    arr_s[v2] = s;
                                    ++v2;
                                }
                            }
                            DeleteSelectedComposer dcfExtensionNeededBrowserFragment$DeleteSelectedComposer0 = new DeleteSelectedComposer(v1);
                            b b0 = new b(DcfExtensionNeededBrowserFragment.this.getContext(), DcfExtensionNeededBrowserFragment.this);
                            b0.d = 0;
                            b0.a(arr_s, dcfExtensionNeededBrowserFragment$DeleteSelectedComposer0);
                        }
                    }
                }
            });
            melonTextPopup1.show();
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle("DCF 기간연장");
            titleBar0.f(true);
        }
        this.initView();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    private void showBottomButtonsIfPossible() {
        boolean z = this.currentDcfExtendNeededAdapter != null && this.currentDcfExtendNeededAdapter.getMarkedCount() > 0;
        this.updateToolBar(z);
        this.setScrollBottomMargin(z);
    }

    private void startTask() {
        this.showProgressDialog();
        new t(1).execute(null);
        new x().execute(null);  // 初始化器: Lx8/f;-><init>()V
        new w().execute(null);  // 初始化器: Lx8/f;-><init>()V
        new B().execute(null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new R8.c(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    private void updateNotice(CollectionRulesDcf collectionRulesDcf0, Exception exception0) {
        if(collectionRulesDcf0 != null) {
            String[] arr_s = collectionRulesDcf0.b;
            if(arr_s.length > 0) {
                this.dcfExtensionInfoText1.setText(arr_s[0]);
            }
            if(arr_s.length > 1) {
                this.dcfExtensionInfoText2.setText(arr_s[1]);
            }
            if(arr_s.length > 2) {
                this.dcfExtensionInfoText3.setText(arr_s[2]);
            }
            this.dcfExtensionRemainedSongExplain.setText((this.mCurrentFilterIndex == 0 ? 0x7F1302C7 : 0x7F1302C6));  // string:dcf_extend_remained_text_song "잔여 곡 수 : "
            this.dcfExtensionRemainedSong.setText(collectionRulesDcf0.f + "/" + collectionRulesDcf0.e);
            if(exception0 != null) {
                MelonTextPopup melonTextPopup0 = new MelonTextPopup(this.getActivity(), 1);
                melonTextPopup0.setTitleName(this.getString(0x7F1300D0));  // string:alert_dlg_title_info "안내"
                melonTextPopup0.setBodyMsg(exception0.getMessage());
                melonTextPopup0.setPopupOnClickListener(new DialogInterface.OnClickListener() {
                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface dialogInterface0, int v) {
                        DcfExtensionNeededBrowserFragment.this.getActivity().getOnBackPressedDispatcher().c();
                    }
                });
                melonTextPopup0.show();
            }
        }
    }

    private void updateViews() {
        if(this.mCurrentFilterIndex == 0) {
            this.mBtnDeleteAll.setText(0x7F1302BF);  // string:dcf_extend_list_delete_all_song "기간 만료 곡 파일 전체 삭제"
        }
        else {
            this.mBtnDeleteAll.setText(0x7F1302BE);  // string:dcf_extend_list_delete_all_edu "기간 만료 어학파일 전체 삭제"
        }
        boolean z = this.currentDcfExtendNeededAdapter.getCount() > 0;
        ViewUtils.setEnable(this.mBtnDeleteAll, z);
        ViewUtils.showWhen(this.mSelectBar, z);
    }
}

