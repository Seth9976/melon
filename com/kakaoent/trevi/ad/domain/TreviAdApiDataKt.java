package com.kakaoent.trevi.ad.domain;

import com.kakaoent.trevi.ad.ui.view.TreviBannerAdView.AssetValueType;
import e.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u001A\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005\u001A\u0018\u0010\u0006\u001A\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\t\u001A\u00020\n¨\u0006\u000B"}, d2 = {"copyAsset", "Lcom/kakaoent/trevi/ad/domain/TreviCreative;", "assetIdx", "", "needSendVImp", "", "valueOfType", "", "", "type", "Lcom/kakaoent/trevi/ad/ui/view/TreviBannerAdView$AssetValueType;", "trevi-ad-android-sdk_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class TreviAdApiDataKt {
    @NotNull
    public static final TreviCreative copyAsset(@NotNull TreviCreative treviCreative0, int v, boolean z) {
        q.g(treviCreative0, "<this>");
        String s = treviCreative0.getImpId();
        int v1 = treviCreative0.getImpType();
        ArrayList arrayList0 = treviCreative0.getIntegrationInfos();
        String s1 = treviCreative0.getCreativeFormat();
        String s2 = treviCreative0.getLandingUrl();
        TreviAdInfo treviAdInfo0 = treviCreative0.getAdInfo();
        ArrayList arrayList1 = treviCreative0.getAssets();
        if(arrayList1 != null && !arrayList1.isEmpty() && v >= 0 && v < treviCreative0.getAssets().size()) {
            TreviAsset[] arr_treviAsset = new TreviAsset[1];
            Object object0 = treviCreative0.getAssets().get(v);
            q.f(object0, "get(...)");
            arr_treviAsset[0] = object0;
            return new TreviCreative(s, v1, arrayList0, s1, s2, treviAdInfo0, k.e(arr_treviAsset), treviCreative0.getUserInfo(), treviCreative0.getAdReward(), treviCreative0.getTrackers(), treviCreative0.getApply(), z);
        }
        return new TreviCreative(s, v1, arrayList0, s1, s2, treviAdInfo0, null, treviCreative0.getUserInfo(), treviCreative0.getAdReward(), treviCreative0.getTrackers(), treviCreative0.getApply(), z);
    }

    @NotNull
    public static final String valueOfType(@NotNull List list0, @NotNull AssetValueType treviBannerAdView$AssetValueType0) {
        TreviAsset treviAsset0;
        q.g(list0, "<this>");
        q.g(treviBannerAdView$AssetValueType0, "type");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        Iterator iterator0 = list0.iterator();
        while(true) {
            treviAsset0 = null;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            ArrayList arrayList1 = ((TreviCreative)object0).getAssets();
            if(arrayList1 != null) {
                treviAsset0 = (TreviAsset)p.m0(arrayList1);
            }
            arrayList0.add(treviAsset0);
        }
        for(Object object1: arrayList0) {
            TreviAsset treviAsset1 = (TreviAsset)object1;
            if(q.b((treviAsset1 == null ? null : treviAsset1.getType()), treviBannerAdView$AssetValueType0.name())) {
                treviAsset0 = object1;
                break;
            }
            if(false) {
                break;
            }
        }
        if(treviAsset0 != null) {
            String s = treviAsset0.getValue();
            return s == null ? "" : s;
        }
        return "";
    }
}

