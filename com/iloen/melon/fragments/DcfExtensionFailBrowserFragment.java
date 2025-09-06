package com.iloen.melon.fragments;

import R8.A;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.l0;
import com.iloen.melon.drm.CollectionRulesDcf;
import com.iloen.melon.drm.DcfError;
import com.iloen.melon.drm.DcfExtendResult;
import com.iloen.melon.task.TaskState;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import x8.b;
import x8.g;

public class DcfExtensionFailBrowserFragment extends DcfExtensionBaseFragment {
    private static final String TAG = "DcfExtensionFailBrowserFragment";

    public static DcfExtensionFailBrowserFragment newInstance(Serializable serializable0, int v, CollectionRulesDcf collectionRulesDcf0) {
        DcfExtensionFailBrowserFragment dcfExtensionFailBrowserFragment0 = new DcfExtensionFailBrowserFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putSerializable("dcf_extend_result_list", serializable0);
        bundle0.putInt("dcf_extend_count_deduct", v);
        bundle0.putSerializable("dcf_extend_dcf_info", collectionRulesDcf0);
        dcfExtensionFailBrowserFragment0.setArguments(bundle0);
        return dcfExtensionFailBrowserFragment0;
    }

    public static DcfExtensionFailBrowserFragment newInstance(Serializable serializable0, int v, CollectionRulesDcf collectionRulesDcf0, int v1) {
        DcfExtensionFailBrowserFragment dcfExtensionFailBrowserFragment0 = new DcfExtensionFailBrowserFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putSerializable("dcf_extend_result_list", serializable0);
        bundle0.putInt("dcf_extend_count_deduct", v);
        bundle0.putSerializable("dcf_extend_dcf_info", collectionRulesDcf0);
        bundle0.putInt("dcf_extend_dcf_type", v1);
        dcfExtensionFailBrowserFragment0.setArguments(bundle0);
        return dcfExtensionFailBrowserFragment0;
    }

    public static DcfExtensionFailBrowserFragment newInstance(List list0) {
        if(list0 == null) {
            list0 = new ArrayList();
            LogU.w("DcfExtensionFailBrowserFragment", "instantiate - listDcfExtendResult is null");
        }
        int v = 0;
        for(Object object0: list0) {
            DcfError dcfError0 = ((DcfExtendResult)object0).b;
            if(dcfError0 != null && dcfError0.a == 0) {
                ++v;
            }
        }
        DcfExtensionFailBrowserFragment dcfExtensionFailBrowserFragment0 = new DcfExtensionFailBrowserFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putSerializable("dcf_extend_result_list", ((Serializable)list0));
        bundle0.putInt("dcf_extend_count_deduct", v);
        dcfExtensionFailBrowserFragment0.setArguments(bundle0);
        return dcfExtensionFailBrowserFragment0;
    }

    public static DcfExtensionFailBrowserFragment newInstance(List list0, int v) {
        DcfExtensionFailBrowserFragment dcfExtensionFailBrowserFragment0 = new DcfExtensionFailBrowserFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putSerializable("dcf_extend_result_list", ((Serializable)list0));
        bundle0.putInt("dcf_extend_count_deduct", v);
        dcfExtensionFailBrowserFragment0.setArguments(bundle0);
        return dcfExtensionFailBrowserFragment0;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(g g0) {
        b b0 = g0.a;
        if(b0 instanceof A && TaskState.FINISHED.equals(g0.b)) {
            ArrayList arrayList0 = ((A)b0).c;
            if(arrayList0 == null) {
                LogU.e("DcfExtensionFailBrowserFragment", "onEventMainThread::EventCoroutineAsyncTask :: TaskExtendDueDateForMrCap :: listDcfExtendResultInSync is null - error = " + ((A)b0).f);
                Exception exception0 = ((A)b0).f;
                if(exception0 != null) {
                    ToastManager.show(exception0.getMessage());
                }
            }
            else {
                int v = 0;
                for(Object object0: arrayList0) {
                    if(((DcfExtendResult)object0).b.a != 0) {
                        ++v;
                    }
                }
                CollectionRulesDcf collectionRulesDcf0 = ((A)b0).h;
                if(v == 0) {
                    if(collectionRulesDcf0 != null && collectionRulesDcf0.c && collectionRulesDcf0.d) {
                        String s = this.getString(0x7F1302A6, new Object[]{((A)b0).d, collectionRulesDcf0.f, collectionRulesDcf0.e});  // string:dcf_auto_extend_result_stat "요청하신 DCF 파일의 재생 기간연장을 완료했습니다.\n(차감 %1$d, 잔여 
                                                                                                                                       // %2$d/전체 %3$d)"
                        l0 l00 = this.getChildFragmentManager();
                        String s1 = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                        com.melon.ui.popup.b.a.c(l00, s1, s);
                        return;
                    }
                    this.getActivity().getOnBackPressedDispatcher().c();
                    return;
                }
                this.listDcfExtendResult.clear();
                this.listDcfExtendResult.addAll(arrayList0);
                this.getAdapter().notifyDataSetChanged();
            }
        }
    }

    @Override  // com.iloen.melon.fragments.DcfExtensionBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        DcfExtendResultAdapter dcfExtensionBaseFragment$DcfExtendResultAdapter0 = (DcfExtendResultAdapter)this.getAdapter();
        int v = this.listDcfExtendResult.size();
        int v1 = 0;
        for(Object object0: this.listDcfExtendResult) {
            if(((DcfExtendResult)object0).b.a != 0) {
                ++v1;
            }
        }
        if(this.collectionRulesDcf != null) {
            dcfExtensionBaseFragment$DcfExtendResultAdapter0.setDcfExtensionMinusSongCount(String.valueOf(this.countOfDeduct));
            dcfExtensionBaseFragment$DcfExtendResultAdapter0.setDcfExtensionRemainSong(this.collectionRulesDcf.f + "/" + this.collectionRulesDcf.e);
        }
        boolean z = this.dcfType == 0;
        String s = z ? this.getString(0x7F1302C1) : this.getString(0x7F1302C0);  // string:dcf_extend_minus_song_count_text "차감 곡 수 : "
        String s1 = z ? this.getString(0x7F1302C7) : this.getString(0x7F1302C6);  // string:dcf_extend_remained_text_song "잔여 곡 수 : "
        if(this.collectionRulesDcf == null) {
            dcfExtensionBaseFragment$DcfExtendResultAdapter0.setDcfExtensionCountLayoutVisible(false);
        }
        else if(v == v1) {
            dcfExtensionBaseFragment$DcfExtendResultAdapter0.setDcfExtensionCountLayoutVisible(false);
        }
        else {
            dcfExtensionBaseFragment$DcfExtendResultAdapter0.setDcfExtensionSongTexts(s, s1);
        }
        dcfExtensionBaseFragment$DcfExtendResultAdapter0.setDcfExtensionInfoText((v1 == 0 ? String.format((z ? this.getString(0x7F1302D7) : this.getString(0x7F1302D5)), v) : String.format((z ? this.getString(0x7F1302D9) : this.getString(0x7F1302CF)), v, v1)));  // string:dcf_extension_success_title_text "요청하신 %1$d곡의 기간연장을 완료했습니다."
    }
}

