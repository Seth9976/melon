package com.iloen.melon.net.v3x.comments;

import android.content.Context;
import java.util.List;

public class ListCmtContsSummReq extends CmtBaseReq {
    public ListCmtContsSummReq(Context context0, int v, List list0) {
        super(context0, 0, ListCmtContsSummRes.class, null);
        this.addParam("chnlSeq", String.valueOf(v));
        if(list0 != null && list0.size() > 0) {
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: list0) {
                stringBuilder0.append(((String)object0));
                stringBuilder0.append("_");
            }
            if(stringBuilder0.length() > 0) {
                stringBuilder0.setLength(stringBuilder0.length() - 1);
                this.addParam("contsRefValueList", stringBuilder0.toString());
            }
        }
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cmt/api/api_listCmtContsSumm.json";
    }
}

