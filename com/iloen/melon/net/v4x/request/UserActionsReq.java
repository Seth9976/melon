package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.melon.net.res.common.ArtistsInfoBase;
import java.util.ArrayList;

public class UserActionsReq extends PersonalBaseReq {
    public static final class Fields {
        public static final String BRAVO = "bravo";
        public static final String FAN = "fan";
        public static final String FRIEND = "friend";
        public static final String LIKE = "like";
        public static final String TEMPERATURE = "temperature";

    }

    public static final class Params {
        public String contsId;
        public String contsTypeCode;
        public String fields;

        public String getContsIdsFromArtistList(ArrayList arrayList0) {
            if(arrayList0 != null && !arrayList0.isEmpty()) {
                if(arrayList0.size() == 1) {
                    return ((ArtistsInfoBase)arrayList0.get(0)).getArtistId();
                }
                StringBuilder stringBuilder0 = new StringBuilder();
                for(Object object0: arrayList0) {
                    stringBuilder0.append(((ArtistsInfoBase)object0).getArtistId());
                    stringBuilder0.append(",");
                }
                return l1.q(stringBuilder0, 1, 0);
            }
            return null;
        }
    }

    public UserActionsReq(Context context0, Params userActionsReq$Params0) {
        super(context0, 0, UserActionsRes.class);
        this.addParams(userActionsReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/user/actions.json";
    }
}

