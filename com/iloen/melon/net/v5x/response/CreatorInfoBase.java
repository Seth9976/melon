package com.iloen.melon.net.v5x.response;

import S7.b;
import android.content.Context;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.types.StringIds;
import java.io.Serializable;
import java.util.ArrayList;

public class CreatorInfoBase implements Serializable {
    public static class ContsList implements Serializable {
        @b("ID")
        public String id;
        @b("IMGURL")
        public String imgUrl;
        @b("ISOFFICIAL")
        public boolean isOfficial;
        @b("MEMBERDJICONTYPE")
        public String memberDjIconType;
        @b("MEMBERDJTYPE")
        public String memberDjType;
        @b("NAME")
        public String name;
        private static final long serialVersionUID = 0x78E138E6014D1497L;

        public ContsList() {
            this.memberDjType = "";
            this.memberDjIconType = "";
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("CONTSLIST")
    public ArrayList contsList;
    @b("CONTSTYPECODE")
    public String contsTypeCode;
    @b("CREATORLEVEL")
    public String creatorLevel;
    private static final long serialVersionUID = 0x78E138EC20E73B97L;

    public static String getCreatorNames(Context context0, CreatorInfoBase creatorInfoBase0) {
        if(context0 != null && creatorInfoBase0 != null && (creatorInfoBase0.contsList != null && !creatorInfoBase0.contsList.isEmpty())) {
            int v = creatorInfoBase0.contsList.size();
            switch(v) {
                case 1: {
                    return ((ContsList)creatorInfoBase0.contsList.get(0)).name;
                }
                case 2: {
                    return String.format("%1$s, %2$s", ((ContsList)creatorInfoBase0.contsList.get(0)).name, ((ContsList)creatorInfoBase0.contsList.get(1)).name);
                }
                case 3: {
                    return String.format("%1$s, %2$s, %3$s", ((ContsList)creatorInfoBase0.contsList.get(0)).name, ((ContsList)creatorInfoBase0.contsList.get(1)).name, ((ContsList)creatorInfoBase0.contsList.get(2)).name);
                }
                default: {
                    return String.format("%1$s, %2$s, %3$s 외 %4$d명", ((ContsList)creatorInfoBase0.contsList.get(0)).name, ((ContsList)creatorInfoBase0.contsList.get(1)).name, ((ContsList)creatorInfoBase0.contsList.get(2)).name, ((int)(v - 3)));
                }
            }
        }
        return "";
    }

    public static String getCreatorNames(Context context0, CreatorInfoBase creatorInfoBase0, boolean z) {
        if(!z) {
            return CreatorInfoBase.getCreatorNames(context0, creatorInfoBase0);
        }
        if(context0 != null && creatorInfoBase0 != null && (creatorInfoBase0.contsList != null && !creatorInfoBase0.contsList.isEmpty())) {
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: creatorInfoBase0.contsList) {
                stringBuilder0.append(((ContsList)object0).name);
                stringBuilder0.append(", ");
            }
            stringBuilder0.setLength(stringBuilder0.length() - 2);
            return stringBuilder0.toString();
        }
        return "";
    }

    public ContsList getFirstCreator() {
        return this.contsList == null || this.contsList.isEmpty() ? null : ((ContsList)this.contsList.get(0));
    }

    public static String getFirstNameAndNumber(Context context0, CreatorInfoBase creatorInfoBase0) {
        if(context0 != null && creatorInfoBase0 != null && (creatorInfoBase0.contsList != null && !creatorInfoBase0.contsList.isEmpty())) {
            int v = creatorInfoBase0.contsList.size();
            return v == 1 ? ((ContsList)creatorInfoBase0.contsList.get(0)).name : context0.getString(0x7F1307B5, new Object[]{creatorInfoBase0.getFirstCreator().name, ((int)(v - 1))});  // string:number_of_except_one_format2 "%1$s 외 %2$d명"
        }
        return "";
    }

    public static boolean isValid(CreatorInfoBase creatorInfoBase0) {
        if(creatorInfoBase0 != null && (creatorInfoBase0.contsList != null && !creatorInfoBase0.contsList.isEmpty())) {
            return creatorInfoBase0.contsList.size() <= 1 ? !StringIds.a(((ContsList)creatorInfoBase0.contsList.get(0)).id, StringIds.d) : true;
        }
        return false;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

