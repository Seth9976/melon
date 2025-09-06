package androidx.media;

import java.util.Arrays;

public class AudioAttributesImplBase implements AudioAttributesImpl {
    public int a;
    public int b;
    public int c;
    public int d;

    public AudioAttributesImplBase() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = -1;
    }

    @Override  // androidx.media.AudioAttributesImpl
    public final int a() {
        return this.d == -1 ? AudioAttributesCompat.b(this.c, this.a) : this.d;
    }

    @Override
    public final boolean equals(Object object0) {
        if(!(object0 instanceof AudioAttributesImplBase)) {
            return false;
        }
        if(this.b == ((AudioAttributesImplBase)object0).b) {
            int v = this.c;
            int v1 = ((AudioAttributesImplBase)object0).c;
            int v2 = ((AudioAttributesImplBase)object0).a();
            if(v2 == 6) {
                return v == ((v1 | 4) & 273) && this.a == ((AudioAttributesImplBase)object0).a && this.d == ((AudioAttributesImplBase)object0).d;
            }
            if(v2 == 7) {
                v1 |= 1;
            }
            return v == (v1 & 273) && this.a == ((AudioAttributesImplBase)object0).a && this.d == ((AudioAttributesImplBase)object0).d;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.a, this.d});
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder("AudioAttributesCompat:");
        if(this.d != -1) {
            stringBuilder0.append(" stream=");
            stringBuilder0.append(this.d);
            stringBuilder0.append(" derived");
        }
        stringBuilder0.append(" usage=");
        int v = this.a;
        switch(v) {
            case 0: {
                s = "USAGE_UNKNOWN";
                break;
            }
            case 1: {
                s = "USAGE_MEDIA";
                break;
            }
            case 2: {
                s = "USAGE_VOICE_COMMUNICATION";
                break;
            }
            case 3: {
                s = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            }
            case 4: {
                s = "USAGE_ALARM";
                break;
            }
            case 5: {
                s = "USAGE_NOTIFICATION";
                break;
            }
            case 6: {
                s = "USAGE_NOTIFICATION_RINGTONE";
                break;
            }
            case 7: {
                s = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            }
            case 8: {
                s = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            }
            case 9: {
                s = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            }
            case 10: {
                s = "USAGE_NOTIFICATION_EVENT";
                break;
            }
            case 11: {
                s = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            }
            case 12: {
                s = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            }
            case 13: {
                s = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            }
            case 14: {
                s = "USAGE_GAME";
                break;
            }
            case 16: {
                s = "USAGE_ASSISTANT";
                break;
            }
            default: {
                s = "unknown usage " + v;
            }
        }
        stringBuilder0.append(s);
        stringBuilder0.append(" content=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(" flags=0x");
        stringBuilder0.append(Integer.toHexString(this.c).toUpperCase());
        return stringBuilder0.toString();
    }
}

