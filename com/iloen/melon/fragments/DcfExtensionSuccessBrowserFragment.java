package com.iloen.melon.fragments;

import android.os.Bundle;
import android.view.View;
import com.iloen.melon.drm.CollectionRulesDcf;
import java.io.Serializable;

public class DcfExtensionSuccessBrowserFragment extends DcfExtensionBaseFragment {
    @Deprecated
    public static DcfExtensionSuccessBrowserFragment newInstance(Serializable serializable0, int v) {
        DcfExtensionSuccessBrowserFragment dcfExtensionSuccessBrowserFragment0 = new DcfExtensionSuccessBrowserFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putSerializable("dcf_extend_result_list", serializable0);
        bundle0.putInt("dcf_extend_count_deduct", v);
        dcfExtensionSuccessBrowserFragment0.setArguments(bundle0);
        return dcfExtensionSuccessBrowserFragment0;
    }

    @Deprecated
    public static DcfExtensionSuccessBrowserFragment newInstance(Serializable serializable0, int v, CollectionRulesDcf collectionRulesDcf0) {
        DcfExtensionSuccessBrowserFragment dcfExtensionSuccessBrowserFragment0 = new DcfExtensionSuccessBrowserFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putSerializable("dcf_extend_result_list", serializable0);
        bundle0.putInt("dcf_extend_count_deduct", v);
        bundle0.putSerializable("dcf_extend_dcf_info", collectionRulesDcf0);
        dcfExtensionSuccessBrowserFragment0.setArguments(bundle0);
        return dcfExtensionSuccessBrowserFragment0;
    }

    public static DcfExtensionSuccessBrowserFragment newInstance(Serializable serializable0, int v, CollectionRulesDcf collectionRulesDcf0, int v1) {
        DcfExtensionSuccessBrowserFragment dcfExtensionSuccessBrowserFragment0 = new DcfExtensionSuccessBrowserFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putSerializable("dcf_extend_result_list", serializable0);
        bundle0.putInt("dcf_extend_count_deduct", v);
        bundle0.putSerializable("dcf_extend_dcf_info", collectionRulesDcf0);
        bundle0.putInt("dcf_extend_dcf_type", v1);
        dcfExtensionSuccessBrowserFragment0.setArguments(bundle0);
        return dcfExtensionSuccessBrowserFragment0;
    }

    @Override  // com.iloen.melon.fragments.DcfExtensionBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        DcfExtendResultAdapter dcfExtensionBaseFragment$DcfExtendResultAdapter0 = (DcfExtendResultAdapter)this.getAdapter();
        if(this.collectionRulesDcf != null) {
            dcfExtensionBaseFragment$DcfExtendResultAdapter0.setDcfExtensionMinusSongCount(String.valueOf(this.countOfDeduct));
            dcfExtensionBaseFragment$DcfExtendResultAdapter0.setDcfExtensionRemainSong(this.collectionRulesDcf.f + "/" + this.collectionRulesDcf.e);
        }
        boolean z = this.dcfType == 0;
        dcfExtensionBaseFragment$DcfExtendResultAdapter0.setDcfExtensionSongTexts((z ? this.getString(0x7F1302C1) : this.getString(0x7F1302C0)), (z ? this.getString(0x7F1302C7) : this.getString(0x7F1302C6)));  // string:dcf_extend_minus_song_count_text "차감 곡 수 : "
        dcfExtensionBaseFragment$DcfExtendResultAdapter0.setDcfExtensionInfoText(String.format((z ? this.getString(0x7F1302D7) : this.getString(0x7F1302D5)), this.listDcfExtendResult.size()));  // string:dcf_extension_success_title_text "요청하신 %1$d곡의 기간연장을 완료했습니다."
    }
}

