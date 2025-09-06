package com.iloen.melon.fragments.comments;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.ListCmtContsSummReq;
import com.iloen.melon.net.v3x.comments.ListCmtContsSummRes.result.CMTCONTSSUMMLIST;
import com.iloen.melon.net.v3x.comments.ListCmtContsSummRes;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import java.util.ArrayList;

public class CmtHelper {
    private static final String TAG = "CmtHelper";

    public static Integer getLatestComment(int v, String s) {
        int v1 = MelonPrefs.getInstance().getInt(v + "," + s, -1);
        return v1 <= -1 ? null : v1;
    }

    public static boolean isVisit(int v, String s) {
        return MelonPrefs.getInstance().contains(CmtHelper.makeKey(v, s));
    }

    private static String makeKey(int v, String s) [...] // Inlined contents

    public static void setLatestComment(int v, String s, int v1) {
        MelonPrefs.getInstance().putInt(v + "," + s, v1).apply();
    }

    public static void updateCommentCount(Context context0, TextView textView0, int v, String s) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("CmtHelper", "updateCommentCount() invalid contsRefValue");
            return;
        }
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(s);
        RequestBuilder.newInstance(new ListCmtContsSummReq(context0, v, arrayList0)).tag("CmtHelper").listener(new Listener() {
            public void onResponse(ListCmtContsSummRes listCmtContsSummRes0) {
                if(listCmtContsSummRes0.isSuccessful()) {
                    ArrayList arrayList0 = listCmtContsSummRes0.result.cmtcontssummlist;
                    if(arrayList0 != null) {
                        for(Object object0: arrayList0) {
                            CMTCONTSSUMMLIST listCmtContsSummRes$result$CMTCONTSSUMMLIST0 = (CMTCONTSSUMMLIST)object0;
                            if(listCmtContsSummRes$result$CMTCONTSSUMMLIST0.chnlseq == v && listCmtContsSummRes$result$CMTCONTSSUMMLIST0.contsrefvalue.equals(s)) {
                                int v = listCmtContsSummRes$result$CMTCONTSSUMMLIST0.validcmtcnt;
                                TextView textView0 = textView0;
                                if(textView0 != null) {
                                    textView0.setText(StringUtils.getCountString(String.valueOf(v), 0xF423F));
                                }
                            }
                        }
                    }
                    return;
                }
                LogU.w("CmtHelper", "onResponse error : " + listCmtContsSummRes0.errormessage);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((ListCmtContsSummRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                LogU.d("CmtHelper", "onErrorResponse() " + volleyError0 + ", " + HttpResponse.getErrorMessage(volleyError0));
            }
        }).request();
    }

    public static void updateCommentCount(Context context0, AbsTabIndicatorLayout absTabIndicatorLayout0, int v, int v1, String s) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("CmtHelper", "updateCommentCount() invalid contsRefValue");
            return;
        }
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(s);
        RequestBuilder.newInstance(new ListCmtContsSummReq(context0, v1, arrayList0)).tag("CmtHelper").listener(new Listener() {
            public void onResponse(ListCmtContsSummRes listCmtContsSummRes0) {
                if(listCmtContsSummRes0.isSuccessful()) {
                    ArrayList arrayList0 = listCmtContsSummRes0.result.cmtcontssummlist;
                    if(arrayList0 == null) {
                        LogU.w("CmtHelper", "updateCommentCount() >> cmtContsSummList is null");
                        return;
                    }
                    for(Object object0: arrayList0) {
                        CMTCONTSSUMMLIST listCmtContsSummRes$result$CMTCONTSSUMMLIST0 = (CMTCONTSSUMMLIST)object0;
                        if(listCmtContsSummRes$result$CMTCONTSSUMMLIST0.chnlseq == v1 && listCmtContsSummRes$result$CMTCONTSSUMMLIST0.contsrefvalue.equals(s)) {
                            int v = listCmtContsSummRes$result$CMTCONTSSUMMLIST0.validcmtcnt;
                            if(absTabIndicatorLayout0 == null) {
                                break;
                            }
                            String s = StringUtils.getCountStringWithoutPlusComma(String.valueOf(v), 0x270F);
                            absTabIndicatorLayout0.c(v, s);
                        }
                    }
                    return;
                }
                LogU.w("CmtHelper", "onResponse error : " + listCmtContsSummRes0.errormessage);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((ListCmtContsSummRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                LogU.d("CmtHelper", "onErrorResponse() " + volleyError0 + ", " + HttpResponse.getErrorMessage(volleyError0));
            }
        }).request();
    }
}

