package com.iloen.melon.net.v5x.common;

import S7.b;
import android.text.TextUtils;
import com.google.gson.n;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;

public class StatsElementsBase implements Serializable {
    private static final boolean LOGV = false;
    private static final String TAG = "StatsElementsBase";
    private static n gson = null;
    @b(alternate = {"impArea"}, value = "IMPAREA")
    public String impArea;
    @b(alternate = {"impType"}, value = "IMPTYPE")
    public String impType;
    @b(alternate = {"impressionId"}, value = "IMPRESSIONID")
    public String impressionId;
    @b(alternate = {"impressionProvider"}, value = "IMPRESSIONPROVIDER")
    public String impressionProvider;
    @b(alternate = {"parentContsId"}, value = "PARENTCONTSID")
    public String parentContsId;
    @b(alternate = {"parentContsType"}, value = "PARENTCONTSTYPE")
    public String parentContsType;
    @b(alternate = {"rangeCode"}, value = "RANGECODE")
    public String rangeCode;
    @b(alternate = {"seedContsId"}, value = "SEEDCONTSID")
    public String seedContsId;
    @b(alternate = {"seedContsTypeCode"}, value = "SEEDCONTSTYPECODE")
    public String seedContsTypeCode;
    private static final long serialVersionUID = 0x4DF83B4DE517796FL;
    @b(alternate = {"slotTargetId"}, value = "SLOTTARGETID")
    public String slotTargetId;

    static {
        StatsElementsBase.gson = new n();
    }

    public StatsElementsBase() {
        this.rangeCode = "";
        this.seedContsTypeCode = "";
        this.seedContsId = "";
        this.parentContsType = "";
        this.parentContsId = "";
        this.impressionId = "";
        this.impressionProvider = "";
        this.slotTargetId = "";
    }

    public static StatsElementsBase mergeStatsElements(StatsElementsBase statsElementsBase0, StatsElementsBase statsElementsBase1) {
        if(statsElementsBase0 == null && statsElementsBase1 == null) {
            return null;
        }
        if(statsElementsBase0 == null) {
            return statsElementsBase1;
        }
        if(statsElementsBase1 != null) {
            if(!TextUtils.isEmpty(statsElementsBase1.impressionId)) {
                statsElementsBase0.impressionId = statsElementsBase1.impressionId;
            }
            if(!TextUtils.isEmpty(statsElementsBase1.parentContsId)) {
                statsElementsBase0.parentContsId = statsElementsBase1.parentContsId;
            }
            if(!TextUtils.isEmpty(statsElementsBase1.parentContsType)) {
                statsElementsBase0.parentContsType = statsElementsBase1.parentContsType;
            }
            if(!TextUtils.isEmpty(statsElementsBase1.rangeCode)) {
                statsElementsBase0.rangeCode = statsElementsBase1.rangeCode;
            }
            if(!TextUtils.isEmpty(statsElementsBase1.seedContsId)) {
                statsElementsBase0.seedContsId = statsElementsBase1.seedContsId;
            }
            if(!TextUtils.isEmpty(statsElementsBase1.seedContsTypeCode)) {
                statsElementsBase0.seedContsTypeCode = statsElementsBase1.seedContsTypeCode;
            }
        }
        return statsElementsBase0;
    }

    public static String toJsonString(StatsElementsBase statsElementsBase0) {
        return statsElementsBase0 == null ? "" : StatsElementsBase.gson.l(statsElementsBase0, StatsElementsBase.class);
    }

    public static StatsElementsBase toStatsElementsBase(String s) {
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        try {
            return (StatsElementsBase)StatsElementsBase.gson.e(s, StatsElementsBase.class);
        }
        catch(Exception unused_ex) {
            return null;
        }
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

