package com.google.android.exoplayer2.audio;

public final class AuxEffectInfo {
    public static final int NO_AUX_EFFECT_ID;
    public final int effectId;
    public final float sendLevel;

    public AuxEffectInfo(int v, float f) {
        this.effectId = v;
        this.sendLevel = f;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return AuxEffectInfo.class == class0 && this.effectId == ((AuxEffectInfo)object0).effectId && Float.compare(((AuxEffectInfo)object0).sendLevel, this.sendLevel) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Float.floatToIntBits(this.sendLevel) + (this.effectId + 0x20F) * 0x1F;
    }
}

