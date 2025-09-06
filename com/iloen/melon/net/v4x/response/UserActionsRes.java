package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class UserActionsRes extends ResponseV4Res {
    public static final class Response extends ResponseBase {
        public static final class RelationList {
            public static final class Fields {
                @b("bravo")
                public String bravo;
                @b("fan")
                public String fan;
                @b("friend")
                public String friend;
                @b("like")
                public String like;
                @b("temperature")
                public String temperature;

                @Override
                public String toString() {
                    return ToStringUtil.toStringFields(this);
                }
            }

            @b("contentsTypeCode")
            public String contentsTypeCode;
            @b("contentsTypeId")
            public String contentsTypeId;
            @b("fields")
            public Fields fields;
            @b("memberKey")
            public String memberKey;

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("relationList")
        public ArrayList relationList;
        private static final long serialVersionUID = -7703925872051127358L;

        public boolean isFan() {
            if(this.relationList != null && this.relationList.size() > 0) {
                int v = this.relationList.size();
                int v1 = 0;
                for(Object object0: this.relationList) {
                    if(ProtocolUtils.parseBoolean(((RelationList)object0).fields.fan)) {
                        ++v1;
                    }
                }
                return v == v1;
            }
            return false;
        }

        public boolean isLike() {
            if(this.relationList != null && this.relationList.size() > 0) {
                for(Object object0: this.relationList) {
                    if(ProtocolUtils.parseBoolean(((RelationList)object0).fields.like)) {
                        return true;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            return false;
        }

        public boolean isOnePeopleOrMoreFan() {
            if(this.relationList != null && this.relationList.size() > 0) {
                for(Object object0: this.relationList) {
                    if(ProtocolUtils.parseBoolean(((RelationList)object0).fields.fan)) {
                        return true;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            return false;
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x2A69A6683445689AL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

