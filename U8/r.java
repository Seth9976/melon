package U8;

import A7.d;
import Cc.U3;
import U4.x;
import com.gaudiolab.sol.android.SolMusicOne.LoudnessType;
import com.melon.ui.K4;
import java.util.Arrays;
import kotlin.jvm.internal.q;
import y8.p;

public final class r implements K4 {
    public final boolean a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public final LoudnessType e;
    public final int f;
    public final p g;
    public final float[] h;
    public final float i;
    public final U3 j;

    public r(boolean z, int v, boolean z1, boolean z2, LoudnessType solMusicOne$LoudnessType0, int v1, p p0, float[] arr_f, float f, U3 u30) {
        q.g(solMusicOne$LoudnessType0, "loudnessType");
        q.g(p0, "presetType");
        q.g(arr_f, "equalizerBandGainDb");
        super();
        this.a = z;
        this.b = v;
        this.c = z1;
        this.d = z2;
        this.e = solMusicOne$LoudnessType0;
        this.f = v1;
        this.g = p0;
        this.h = arr_f;
        this.i = f;
        this.j = u30;
    }

    public static r a(r r0, boolean z, int v, boolean z1, int v1, float[] arr_f, U3 u30, int v2) {
        if((v2 & 1) != 0) {
            z = r0.a;
        }
        float[] arr_f1 = (v2 & 0x80) == 0 ? arr_f : r0.h;
        q.g(r0.e, "loudnessType");
        q.g(r0.g, "presetType");
        q.g(arr_f1, "equalizerBandGainDb");
        return new r(z, ((v2 & 2) == 0 ? v : r0.b), ((v2 & 4) == 0 ? z1 : r0.c), ((v2 & 8) == 0 ? false : r0.d), r0.e, ((v2 & 0x20) == 0 ? v1 : r0.f), r0.g, arr_f1, r0.i, ((v2 & 0x200) == 0 ? u30 : r0.j));
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof r)) {
            return false;
        }
        if(this.a != ((r)object0).a) {
            return false;
        }
        if(this.b != ((r)object0).b) {
            return false;
        }
        if(this.c != ((r)object0).c) {
            return false;
        }
        if(this.d != ((r)object0).d) {
            return false;
        }
        if(this.e != ((r)object0).e) {
            return false;
        }
        if(this.f != ((r)object0).f) {
            return false;
        }
        if(this.g != ((r)object0).g) {
            return false;
        }
        if(!q.b(this.h, ((r)object0).h)) {
            return false;
        }
        return Float.compare(this.i, ((r)object0).i) == 0 ? q.b(this.j, ((r)object0).j) : false;
    }

    @Override
    public final int hashCode() {
        int v = Arrays.hashCode(this.h);
        return this.j.hashCode() + d.a(this.i, (v + (this.g.hashCode() + d.b(this.f, (this.e.hashCode() + d.e(d.e(d.b(this.b, Boolean.hashCode(this.a) * 0x1F, 0x1F), 0x1F, this.c), 0x1F, this.d)) * 0x1F, 0x1F)) * 0x1F) * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        String s = Arrays.toString(this.h);
        StringBuilder stringBuilder0 = new StringBuilder("EqualizerSettingUiState(isEqualizerEnable=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", selectedTabIndex=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isAiMasterGenuisEnable=");
        x.y(stringBuilder0, this.c, ", isAiMasterAmbientEnable=", this.d, ", loudnessType=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", selectedPresetTabIndex=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", presetType=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", equalizerBandGainDb=");
        stringBuilder0.append(s);
        stringBuilder0.append(", targetLoudness=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", toolBarUiState=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

