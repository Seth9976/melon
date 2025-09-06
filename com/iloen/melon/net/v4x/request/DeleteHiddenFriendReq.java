package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DeleteHiddenFriendRes;
import com.iloen.melon.utils.StringUtils;
import e1.u;
import java.util.ArrayList;
import va.e0;
import va.o;

public class DeleteHiddenFriendReq extends RequestV4_1Req {
    public DeleteHiddenFriendReq(Context context0, ArrayList arrayList0, String s) {
        super(context0, 1, DeleteHiddenFriendRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParam("fMemberKeys", StringUtils.convertToCommaSeparatedText(arrayList0));
        this.addParam("menuId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/friend/deleteHiddenFriend.json";
    }
}

