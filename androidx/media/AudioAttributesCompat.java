package androidx.media;

import P4.d;
import android.util.SparseIntArray;

public class AudioAttributesCompat implements d {
    public AudioAttributesImpl a;
    public static final int b;

    static {
        SparseIntArray sparseIntArray0 = new SparseIntArray();
        sparseIntArray0.put(5, 1);
        sparseIntArray0.put(6, 2);
        sparseIntArray0.put(7, 2);
        sparseIntArray0.put(8, 1);
        sparseIntArray0.put(9, 1);
        sparseIntArray0.put(10, 1);
    }

    public AudioAttributesCompat() {
    }

    public AudioAttributesCompat(AudioAttributesImplApi26 audioAttributesImplApi260) {
        this.a = audioAttributesImplApi260;
    }

    public static int b(int v, int v1) {
        if((v & 1) == 1) {
            return 7;
        }
        if((v & 4) == 4) {
            return 6;
        }
        switch(v1) {
            case 2: {
                return 0;
            }
            case 3: {
                return 8;
            }
            case 4: {
                return 4;
            }
            case 6: {
                return 2;
            }
            case 5: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                return 5;
            }
            case 11: {
                return 10;
            }
            case 13: {
                return 1;
            }
            default: {
                return 3;
            }
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(!(object0 instanceof AudioAttributesCompat)) {
            return false;
        }
        return this.a == null ? ((AudioAttributesCompat)object0).a == null : this.a.equals(((AudioAttributesCompat)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return this.a.toString();
    }
}

