package com.iloen.melon.drm;

import android.content.Context;
import com.iloen.melon.constants.CType;
import com.iloen.melon.net.v4x.common.DcfContentBase;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.DcfExtensionBaseInfoRes.Response.NoticeList;
import com.iloen.melon.net.v4x.response.DcfExtensionBaseInfoRes.Response;
import com.iloen.melon.net.v4x.response.DcfExtensionBaseInfoRes;
import java.io.Serializable;
import java.util.ArrayList;

public class CollectionRulesDcf implements Serializable {
    public final CType a;
    public final String[] b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public int f;

    public CollectionRulesDcf(Context context0, CType cType0, DcfExtensionBaseInfoRes dcfExtensionBaseInfoRes0) {
        if(dcfExtensionBaseInfoRes0 != null) {
            Response dcfExtensionBaseInfoRes$Response0 = dcfExtensionBaseInfoRes0.response;
            if(dcfExtensionBaseInfoRes$Response0 != null) {
                this.a = cType0;
                ArrayList arrayList0 = CType.SONG.equals(cType0) ? dcfExtensionBaseInfoRes$Response0.songContentList : dcfExtensionBaseInfoRes$Response0.langContentList;
                ArrayList arrayList1 = dcfExtensionBaseInfoRes$Response0.noticeList;
                if(arrayList1 == null) {
                    String[] arr_s = new String[3];
                    this.b = arr_s;
                    arr_s[0] = "권리사의 요청으로 DCF 기간연장 파일은 보유 이용권의 다운로드 수에서 차감됩니다.";
                    arr_s[1] = "리스트에서 원하는 파일을 선택하신 후, 기간 연장을 진행해주세요. 기간 연장 실패 시에는 차감되지 않습니다.";
                    arr_s[2] = "원하는 파일만 다운로드 하실 경우에는 기간만료 목록 전체 삭제 후, 설정 > 구매 목록에서 선택 다운로드 해 주세요.";
                }
                else {
                    int v = arrayList1.size();
                    this.b = new String[v];
                    for(int v1 = 1; v1 <= v; ++v1) {
                        for(Object object0: arrayList1) {
                            NoticeList dcfExtensionBaseInfoRes$Response$NoticeList0 = (NoticeList)object0;
                            if(String.valueOf(v1).equals(dcfExtensionBaseInfoRes$Response$NoticeList0.order)) {
                                this.b[v1 - 1] = dcfExtensionBaseInfoRes$Response$NoticeList0.content;
                                break;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                }
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    DcfContentBase dcfContentBase0 = (DcfContentBase)arrayList0.get(0);
                    this.d = ProtocolUtils.parseBoolean(dcfContentBase0.dllimityn);
                    this.e = dcfContentBase0.dllimitcnt;
                    this.f = dcfContentBase0.rmdcnt;
                    this.c = true;
                }
            }
        }
    }
}

