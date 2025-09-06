package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.InsertHiddenFriendRes;
import com.iloen.melon.utils.StringUtils;
import java.util.ArrayList;

public class InsertHiddenFriendReq extends RequestV4_1Req {
    public InsertHiddenFriendReq(Context context0, ArrayList arrayList0, String s) {
        super(context0, 1, InsertHiddenFriendRes.class);
        this.addMemberKey();
        this.addParam("fMemberKeys", StringUtils.convertToCommaSeparatedText(arrayList0));
        this.addParam("menuId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/friend/insertHiddenFriend.json";
    }
}

