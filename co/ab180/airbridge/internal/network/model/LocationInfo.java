package co.ab180.airbridge.internal.network.model;

import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.q;
import kotlin.Metadata;

@RuleWith(q.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000B\b\u0001\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\f\u001A\u00020\u0002\u0012\u0006\u0010\u000E\u001A\u00020\u0002\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0003\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u001C\u0010\b\u001A\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001C\u0010\f\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001A\u0004\b\r\u0010\u0006R\u001C\u0010\u000E\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000E\u0010\u0004\u001A\u0004\b\u000F\u0010\u0006¨\u0006\u0012"}, d2 = {"Lco/ab180/airbridge/internal/network/model/LocationInfo;", "", "", "latitude", "D", "getLatitude", "()D", "", "speed", "F", "getSpeed", "()F", "longitude", "getLongitude", "altitude", "getAltitude", "<init>", "(DDDF)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class LocationInfo {
    @d("altitude")
    private final double altitude;
    @d("latitude")
    private final double latitude;
    @d("longitude")
    private final double longitude;
    @d("speed")
    private final float speed;

    public LocationInfo(double f, double f1, double f2, float f3) {
        this.latitude = f;
        this.longitude = f1;
        this.altitude = f2;
        this.speed = f3;
    }

    public final double getAltitude() {
        return this.altitude;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final float getSpeed() {
        return this.speed;
    }
}

