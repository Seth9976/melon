package androidx.media3.exoplayer.upstream;

import android.content.Context;
import e3.r;
import e3.x;
import java.util.HashMap;
import w3.f;

public final class DefaultBandwidthMeter.Builder {
    public final Context a;
    public final HashMap b;
    public final int c;
    public final r d;
    public final boolean e;

    public DefaultBandwidthMeter.Builder(Context context0) {
        int[] arr_v;
        this.a = context0 == null ? null : context0.getApplicationContext();
        String s = x.t(context0);
        s.getClass();
        switch(s) {
            case "AD": {
                arr_v = new int[]{1, 2, 0, 0, 2, 2};
                break;
            }
            case "AE": {
                arr_v = new int[]{1, 4, 2, 3, 4, 1};
                break;
            }
            case "AF": {
                arr_v = new int[]{4, 4, 3, 4, 2, 2};
                break;
            }
            case "AG": {
                arr_v = new int[]{2, 4, 3, 4, 2, 2};
                break;
            }
            case "AI": {
                arr_v = new int[]{1, 2, 0, 0, 2, 2};
                break;
            }
            case "AL": {
                arr_v = new int[]{1, 1, 1, 2, 2, 2};
                break;
            }
            case "AM": {
                arr_v = new int[]{2, 3, 2, 3, 2, 2};
                break;
            }
            case "AO": {
                arr_v = new int[]{3, 4, 4, 3, 2, 2};
                break;
            }
            case "AQ": {
                arr_v = new int[]{4, 2, 2, 2, 2, 2};
                break;
            }
            case "AR": {
                arr_v = new int[]{2, 2, 2, 2, 1, 2};
                break;
            }
            case "AS": {
                arr_v = new int[]{2, 2, 3, 3, 2, 2};
                break;
            }
            case "AT": {
                arr_v = new int[]{0, 0, 0, 0, 0, 2};
                break;
            }
            case "AU": {
                arr_v = new int[]{0, 3, 1, 1, 3, 0};
                break;
            }
            case "AW": {
                arr_v = new int[]{2, 2, 3, 4, 2, 2};
                break;
            }
            case "AX": {
                arr_v = new int[]{0, 2, 2, 2, 2, 2};
                break;
            }
            case "AZ": {
                arr_v = new int[]{4, 2, 3, 3, 2, 2};
                break;
            }
            case "BA": {
                arr_v = new int[]{1, 1, 1, 1, 2, 2};
                break;
            }
            case "BB": {
                arr_v = new int[]{1, 2, 0, 0, 2, 2};
                break;
            }
            case "BD": {
                arr_v = new int[]{2, 1, 3, 2, 4, 2};
                break;
            }
            case "BE": {
                arr_v = new int[]{0, 0, 1, 0, 1, 2};
                break;
            }
            case "BF": {
                arr_v = new int[]{4, 3, 4, 4, 2, 2};
                break;
            }
            case "BG": {
                arr_v = new int[]{0, 0, 0, 0, 1, 2};
                break;
            }
            case "BH": {
                arr_v = new int[]{1, 3, 1, 3, 4, 2};
                break;
            }
            case "BI": {
                arr_v = new int[]{4, 4, 4, 4, 2, 2};
                break;
            }
            case "BJ": {
                arr_v = new int[]{4, 4, 2, 3, 2, 2};
                break;
            }
            case "BL": {
                arr_v = new int[]{1, 2, 2, 2, 2, 2};
                break;
            }
            case "BM": {
                arr_v = new int[]{0, 2, 0, 0, 2, 2};
                break;
            }
            case "BN": {
                arr_v = new int[]{3, 2, 0, 0, 2, 2};
                break;
            }
            case "BO": {
                arr_v = new int[]{1, 2, 4, 4, 2, 2};
                break;
            }
            case "BQ": {
                arr_v = new int[]{1, 2, 0, 0, 2, 2};
                break;
            }
            case "BR": {
                arr_v = new int[]{1, 1, 1, 1, 2, 4};
                break;
            }
            case "BS": {
                arr_v = new int[]{3, 2, 1, 1, 2, 2};
                break;
            }
            case "BT": {
                arr_v = new int[]{3, 1, 2, 2, 3, 2};
                break;
            }
            case "BW": {
                arr_v = new int[]{3, 2, 1, 0, 2, 2};
                break;
            }
            case "BY": {
                arr_v = new int[]{1, 2, 3, 3, 2, 2};
                break;
            }
            case "BZ": {
                arr_v = new int[]{2, 2, 2, 1, 2, 2};
                break;
            }
            case "CA": {
                arr_v = new int[]{0, 2, 1, 2, 3, 3};
                break;
            }
            case "CD": {
                arr_v = new int[]{3, 3, 2, 2, 2, 2};
                break;
            }
            case "CF": {
                arr_v = new int[]{4, 2, 4, 2, 2, 2};
                break;
            }
            case "CG": {
                arr_v = new int[]{3, 4, 3, 3, 2, 2};
                break;
            }
            case "CH": {
                arr_v = new int[]{0, 1, 0, 0, 0, 2};
                break;
            }
            case "CI": {
                arr_v = new int[]{2, 4, 3, 4, 2, 2};
                break;
            }
            case "CK": {
                arr_v = new int[]{2, 2, 2, 1, 2, 2};
                break;
            }
            case "CL": {
                arr_v = new int[]{0, 1, 2, 2, 2, 2};
                break;
            }
            case "CM": {
                arr_v = new int[]{4, 3, 3, 4, 2, 2};
                break;
            }
            case "CN": {
                arr_v = new int[]{2, 0, 1, 1, 3, 1};
                break;
            }
            case "CO": {
                arr_v = new int[]{2, 3, 3, 2, 2, 2};
                break;
            }
            case "CR": {
                arr_v = new int[]{2, 4, 4, 4, 2, 2};
                break;
            }
            case "CU": {
                arr_v = new int[]{4, 2, 4, 4, 2, 2};
                break;
            }
            case "CV": {
                arr_v = new int[]{2, 3, 0, 1, 2, 2};
                break;
            }
            case "CW": {
                arr_v = new int[]{1, 2, 0, 0, 2, 2};
                break;
            }
            case "CX": {
                arr_v = new int[]{0, 2, 2, 2, 2, 2};
                break;
            }
            case "CY": {
                arr_v = new int[]{1, 0, 1, 0, 0, 2};
                break;
            }
            case "CZ": {
                arr_v = new int[]{0, 0, 2, 0, 1, 2};
                break;
            }
            case "DE": {
                arr_v = new int[]{0, 1, 4, 2, 2, 1};
                break;
            }
            case "DJ": {
                arr_v = new int[]{4, 2, 3, 3, 2, 2};
                break;
            }
            case "DK": {
                arr_v = new int[]{0, 0, 2, 0, 0, 2};
                break;
            }
            case "DM": {
                arr_v = new int[]{1, 2, 0, 0, 2, 2};
                break;
            }
            case "DO": {
                arr_v = new int[]{3, 4, 4, 4, 2, 2};
                break;
            }
            case "DZ": {
                arr_v = new int[]{3, 3, 4, 4, 2, 2};
                break;
            }
            case "EC": {
                arr_v = new int[]{1, 3, 2, 1, 2, 2};
                break;
            }
            case "EE": {
                arr_v = new int[]{0, 0, 0, 0, 0, 2};
                break;
            }
            case "EG": {
                arr_v = new int[]{3, 4, 3, 3, 2, 2};
                break;
            }
            case "ER": {
                arr_v = new int[]{4, 2, 2, 2, 2, 2};
                break;
            }
            case "ES": {
                arr_v = new int[]{0, 0, 0, 0, 1, 0};
                break;
            }
            case "ET": {
                arr_v = new int[]{4, 3, 4, 4, 4, 2};
                break;
            }
            case "FI": {
                arr_v = new int[]{0, 0, 0, 1, 0, 2};
                break;
            }
            case "FJ": {
                arr_v = new int[]{3, 2, 2, 3, 2, 2};
                break;
            }
            case "FK": {
                arr_v = new int[]{3, 2, 2, 2, 2, 2};
                break;
            }
            case "FM": {
                arr_v = new int[]{4, 2, 4, 0, 2, 2};
                break;
            }
            case "FO": {
                arr_v = new int[]{0, 2, 2, 0, 2, 2};
                break;
            }
            case "FR": {
                arr_v = new int[]{1, 1, 1, 1, 0, 2};
                break;
            }
            case "GA": {
                arr_v = new int[]{3, 4, 0, 0, 2, 2};
                break;
            }
            case "GB": {
                arr_v = new int[]{1, 1, 3, 2, 2, 2};
                break;
            }
            case "GD": {
                arr_v = new int[]{2, 2, 0, 0, 2, 2};
                break;
            }
            case "GE": {
                arr_v = new int[]{1, 1, 0, 2, 2, 2};
                break;
            }
            case "GF": {
                arr_v = new int[]{3, 2, 3, 3, 2, 2};
                break;
            }
            case "GG": {
                arr_v = new int[]{0, 2, 1, 1, 2, 2};
                break;
            }
            case "GH": {
                arr_v = new int[]{3, 3, 3, 2, 2, 2};
                break;
            }
            case "GI": {
                arr_v = new int[]{0, 2, 0, 1, 2, 2};
                break;
            }
            case "GL": {
                arr_v = new int[]{1, 2, 2, 0, 2, 2};
                break;
            }
            case "GM": {
                arr_v = new int[]{4, 3, 2, 4, 2, 2};
                break;
            }
            case "GN": {
                arr_v = new int[]{3, 4, 4, 2, 2, 2};
                break;
            }
            case "GP": {
                arr_v = new int[]{2, 1, 1, 3, 2, 2};
                break;
            }
            case "GQ": {
                arr_v = new int[]{4, 4, 4, 4, 2, 2};
                break;
            }
            case "GR": {
                arr_v = new int[]{1, 0, 0, 0, 1, 2};
                break;
            }
            case "GT": {
                arr_v = new int[]{2, 1, 2, 1, 2, 2};
                break;
            }
            case "GU": {
                arr_v = new int[]{2, 2, 4, 3, 3, 2};
                break;
            }
            case "GW": {
                arr_v = new int[]{4, 4, 1, 2, 2, 2};
                break;
            }
            case "GY": {
                arr_v = new int[]{3, 1, 1, 3, 2, 2};
                break;
            }
            case "HK": {
                arr_v = new int[]{0, 1, 0, 1, 1, 0};
                break;
            }
            case "HR": {
                arr_v = new int[]{1, 0, 0, 0, 0, 2};
                break;
            }
            case "HT": {
                arr_v = new int[]{4, 4, 4, 4, 2, 2};
                break;
            }
            case "HU": {
                arr_v = new int[]{0, 0, 0, 0, 0, 2};
                break;
            }
            case "ID": {
                arr_v = new int[]{3, 1, 3, 3, 2, 4};
                break;
            }
            case "IE": {
                arr_v = new int[]{1, 1, 1, 1, 1, 2};
                break;
            }
            case "IL": {
                arr_v = new int[]{1, 2, 2, 3, 4, 2};
                break;
            }
            case "IM": {
                arr_v = new int[]{0, 2, 0, 1, 2, 2};
                break;
            }
            case "IN": {
                arr_v = new int[]{1, 1, 3, 2, 2, 3};
                break;
            }
            case "IO": {
                arr_v = new int[]{3, 2, 2, 0, 2, 2};
                break;
            }
            case "IQ": {
                arr_v = new int[]{3, 2, 3, 2, 2, 2};
                break;
            }
            case "IR": {
                arr_v = new int[]{4, 2, 3, 3, 4, 3};
                break;
            }
            case "IS": {
                arr_v = new int[]{0, 0, 0, 0, 0, 2};
                break;
            }
            case "IT": {
                arr_v = new int[]{0, 1, 1, 2, 1, 2};
                break;
            }
            case "JE": {
                arr_v = new int[]{0, 2, 0, 1, 2, 2};
                break;
            }
            case "JM": {
                arr_v = new int[]{2, 4, 3, 1, 2, 2};
                break;
            }
            case "JO": {
                arr_v = new int[]{1, 1, 1, 1, 2, 2};
                break;
            }
            case "JP": {
                arr_v = new int[]{0, 3, 2, 3, 4, 2};
                break;
            }
            case "KE": {
                arr_v = new int[]{3, 2, 1, 1, 1, 2};
                break;
            }
            case "KG": {
                arr_v = new int[]{2, 1, 1, 2, 2, 2};
                break;
            }
            case "KH": {
                arr_v = new int[]{1, 0, 4, 2, 2, 2};
                break;
            }
            case "KI": {
                arr_v = new int[]{4, 2, 4, 4, 2, 2};
                break;
            }
            case "KM": {
                arr_v = new int[]{4, 3, 3, 2, 2, 2};
                break;
            }
            case "KN": {
                arr_v = new int[]{1, 2, 0, 0, 2, 2};
                break;
            }
            case "KR": {
                arr_v = new int[]{0, 2, 2, 4, 4, 4};
                break;
            }
            case "KW": {
                arr_v = new int[]{1, 0, 0, 0, 0, 2};
                break;
            }
            case "KY": {
                arr_v = new int[]{1, 2, 0, 0, 2, 2};
                break;
            }
            case "KZ": {
                arr_v = new int[]{2, 1, 2, 2, 3, 2};
                break;
            }
            case "LA": {
                arr_v = new int[]{1, 2, 1, 3, 2, 2};
                break;
            }
            case "LB": {
                arr_v = new int[]{3, 1, 1, 2, 2, 2};
                break;
            }
            case "LC": {
                arr_v = new int[]{2, 2, 1, 1, 2, 2};
                break;
            }
            case "LI": {
                arr_v = new int[]{0, 2, 2, 2, 2, 2};
                break;
            }
            case "LK": {
                arr_v = new int[]{3, 2, 3, 3, 4, 2};
                break;
            }
            case "LR": {
                arr_v = new int[]{3, 4, 4, 4, 2, 2};
                break;
            }
            case "LS": {
                arr_v = new int[]{4, 3, 3, 3, 2, 2};
                break;
            }
            case "LT": {
                arr_v = new int[]{0, 1, 0, 1, 0, 2};
                break;
            }
            case "LU": {
                arr_v = new int[]{4, 0, 3, 2, 1, 3};
                break;
            }
            case "LV": {
                arr_v = new int[]{0, 0, 0, 0, 0, 2};
                break;
            }
            case "LY": {
                arr_v = new int[]{4, 2, 3, 3, 2, 2};
                break;
            }
            case "MA": {
                arr_v = new int[]{3, 3, 1, 1, 2, 2};
                break;
            }
            case "MC": {
                arr_v = new int[]{1, 2, 2, 0, 2, 2};
                break;
            }
            case "MD": {
                arr_v = new int[]{1, 0, 0, 0, 2, 2};
                break;
            }
            case "ME": {
                arr_v = new int[]{2, 0, 0, 1, 3, 2};
                break;
            }
            case "MF": {
                arr_v = new int[]{1, 2, 2, 3, 2, 2};
                break;
            }
            case "MG": {
                arr_v = new int[]{3, 4, 3, 3, 2, 2};
                break;
            }
            case "MH": {
                arr_v = new int[]{4, 2, 2, 4, 2, 2};
                break;
            }
            case "MK": {
                arr_v = new int[]{1, 0, 0, 1, 3, 2};
                break;
            }
            case "ML": {
                arr_v = new int[]{3, 3, 2, 2, 2, 2};
                break;
            }
            case "MM": {
                arr_v = new int[]{3, 2, 3, 3, 4, 2};
                break;
            }
            case "MN": {
                arr_v = new int[]{2, 0, 2, 2, 2, 2};
                break;
            }
            case "MO": {
                arr_v = new int[]{0, 2, 4, 4, 3, 1};
                break;
            }
            case "MP": {
                arr_v = new int[]{1, 2, 2, 2, 2, 2};
                break;
            }
            case "MQ": {
                arr_v = new int[]{2, 1, 2, 3, 2, 2};
                break;
            }
            case "MR": {
                arr_v = new int[]{4, 3, 3, 4, 2, 2};
                break;
            }
            case "MS": {
                arr_v = new int[]{0, 2, 2, 2, 2, 2};
                break;
            }
            case "MT": {
                arr_v = new int[]{0, 0, 0, 0, 0, 2};
                break;
            }
            case "MU": {
                arr_v = new int[]{3, 1, 0, 2, 2, 2};
                break;
            }
            case "MV": {
                arr_v = new int[]{3, 2, 1, 3, 4, 2};
                break;
            }
            case "MW": {
                arr_v = new int[]{3, 2, 2, 1, 2, 2};
                break;
            }
            case "MX": {
                arr_v = new int[]{2, 4, 4, 4, 3, 2};
                break;
            }
            case "MY": {
                arr_v = new int[]{1, 0, 4, 1, 1, 0};
                break;
            }
            case "MZ": {
                arr_v = new int[]{3, 1, 2, 2, 2, 2};
                break;
            }
            case "NA": {
                arr_v = new int[]{3, 4, 3, 2, 2, 2};
                break;
            }
            case "NC": {
                arr_v = new int[]{2, 3, 3, 4, 2, 2};
                break;
            }
            case "NE": {
                arr_v = new int[]{4, 4, 4, 4, 2, 2};
                break;
            }
            case "NF": {
                arr_v = new int[]{3, 2, 2, 2, 2, 2};
                break;
            }
            case "NG": {
                arr_v = new int[]{3, 4, 2, 1, 2, 2};
                break;
            }
            case "NI": {
                arr_v = new int[]{2, 4, 4, 4, 2, 2};
                break;
            }
            case "NL": {
                arr_v = new int[]{2, 1, 4, 3, 0, 4};
                break;
            }
            case "NO": {
                arr_v = new int[]{0, 0, 3, 0, 0, 2};
                break;
            }
            case "NP": {
                arr_v = new int[]{2, 2, 4, 3, 2, 2};
                break;
            }
            case "NR": {
                arr_v = new int[]{4, 2, 4, 4, 2, 2};
                break;
            }
            case "NU": {
                arr_v = new int[]{4, 2, 2, 2, 2, 2};
                break;
            }
            case "NZ": {
                arr_v = new int[]{0, 0, 1, 2, 4, 2};
                break;
            }
            case "OM": {
                arr_v = new int[]{2, 3, 1, 2, 4, 2};
                break;
            }
            case "PA": {
                arr_v = new int[]{2, 3, 2, 3, 2, 2};
                break;
            }
            case "PE": {
                arr_v = new int[]{1, 2, 4, 4, 3, 2};
                break;
            }
            case "PF": {
                arr_v = new int[]{2, 2, 3, 1, 2, 2};
                break;
            }
            case "PG": {
                arr_v = new int[]{4, 3, 3, 3, 2, 2};
                break;
            }
            case "PH": {
                arr_v = new int[]{2, 1, 2, 3, 2, 1};
                break;
            }
            case "PK": {
                arr_v = new int[]{3, 3, 3, 3, 2, 2};
                break;
            }
            case "PL": {
                arr_v = new int[]{1, 0, 2, 2, 4, 4};
                break;
            }
            case "PM": {
                arr_v = new int[]{0, 2, 2, 2, 2, 2};
                break;
            }
            case "PR": {
                arr_v = new int[]{2, 0, 2, 1, 2, 0};
                break;
            }
            case "PS": {
                arr_v = new int[]{3, 4, 1, 3, 2, 2};
                break;
            }
            case "PT": {
                arr_v = new int[]{0, 0, 0, 0, 1, 2};
                break;
            }
            case "PW": {
                arr_v = new int[]{2, 2, 4, 1, 2, 2};
                break;
            }
            case "PY": {
                arr_v = new int[]{1, 2, 2, 2, 2, 2};
                break;
            }
            case "QA": {
                arr_v = new int[]{1, 4, 4, 4, 4, 2};
                break;
            }
            case "RE": {
                arr_v = new int[]{0, 3, 2, 3, 1, 2};
                break;
            }
            case "RO": {
                arr_v = new int[]{0, 0, 1, 1, 3, 2};
                break;
            }
            case "RS": {
                arr_v = new int[]{1, 0, 0, 1, 2, 2};
                break;
            }
            case "RU": {
                arr_v = new int[]{1, 0, 0, 1, 3, 3};
                break;
            }
            case "RW": {
                arr_v = new int[]{3, 3, 2, 0, 2, 2};
                break;
            }
            case "SA": {
                arr_v = new int[]{3, 1, 1, 2, 2, 0};
                break;
            }
            case "SB": {
                arr_v = new int[]{4, 2, 4, 3, 2, 2};
                break;
            }
            case "SC": {
                arr_v = new int[]{4, 2, 2, 2, 2, 2};
                break;
            }
            case "SD": {
                arr_v = new int[]{4, 3, 4, 4, 2, 2};
                break;
            }
            case "SE": {
                arr_v = new int[]{0, 0, 0, 0, 0, 2};
                break;
            }
            case "SG": {
                arr_v = new int[]{2, 3, 3, 3, 1, 1};
                break;
            }
            case "SH": {
                arr_v = new int[]{4, 2, 2, 2, 2, 2};
                break;
            }
            case "SI": {
                arr_v = new int[]{0, 0, 0, 0, 1, 2};
                break;
            }
            case "SJ": {
                arr_v = new int[]{3, 2, 2, 2, 2, 2};
                break;
            }
            case "SK": {
                arr_v = new int[]{0, 1, 1, 1, 2, 2};
                break;
            }
            case "SL": {
                arr_v = new int[]{4, 2, 3, 3, 2, 2};
                break;
            }
            case "SM": {
                arr_v = new int[]{0, 2, 2, 2, 2, 2};
                break;
            }
            case "SN": {
                arr_v = new int[]{4, 4, 3, 2, 2, 2};
                break;
            }
            case "SO": {
                arr_v = new int[]{2, 2, 3, 4, 4, 2};
                break;
            }
            case "SR": {
                arr_v = new int[]{2, 4, 4, 1, 2, 2};
                break;
            }
            case "SS": {
                arr_v = new int[]{4, 3, 2, 4, 2, 2};
                break;
            }
            case "ST": {
                arr_v = new int[]{2, 2, 1, 2, 2, 2};
                break;
            }
            case "SV": {
                arr_v = new int[]{2, 3, 2, 1, 2, 2};
                break;
            }
            case "SX": {
                arr_v = new int[]{1, 2, 0, 0, 2, 2};
                break;
            }
            case "SY": {
                arr_v = new int[]{4, 3, 4, 4, 2, 2};
                break;
            }
            case "SZ": {
                arr_v = new int[]{4, 4, 3, 4, 2, 2};
                break;
            }
            case "TC": {
                arr_v = new int[]{3, 2, 1, 2, 2, 2};
                break;
            }
            case "TD": {
                arr_v = new int[]{4, 3, 4, 4, 2, 2};
                break;
            }
            case "TG": {
                arr_v = new int[]{3, 4, 1, 0, 2, 2};
                break;
            }
            case "TH": {
                arr_v = new int[]{0, 1, 2, 2, 2, 2};
                break;
            }
            case "TJ": {
                arr_v = new int[]{3, 3, 4, 4, 2, 2};
                break;
            }
            case "TL": {
                arr_v = new int[]{4, 2, 4, 4, 2, 2};
                break;
            }
            case "TM": {
                arr_v = new int[]{4, 2, 2, 4, 2, 2};
                break;
            }
            case "TN": {
                arr_v = new int[]{3, 1, 1, 1, 2, 2};
                break;
            }
            case "TO": {
                arr_v = new int[]{3, 2, 4, 3, 2, 2};
                break;
            }
            case "TR": {
                arr_v = new int[]{1, 1, 1, 1, 2, 2};
                break;
            }
            case "TT": {
                arr_v = new int[]{2, 4, 1, 0, 2, 2};
                break;
            }
            case "TV": {
                arr_v = new int[]{4, 2, 2, 4, 2, 2};
                break;
            }
            case "TW": {
                arr_v = new int[]{0, 0, 0, 0, 0, 0};
                break;
            }
            case "TZ": {
                arr_v = new int[]{3, 4, 2, 1, 3, 2};
                break;
            }
            case "UA": {
                arr_v = new int[]{0, 2, 1, 2, 3, 3};
                break;
            }
            case "UG": {
                arr_v = new int[]{3, 3, 2, 3, 4, 2};
                break;
            }
            case "US": {
                arr_v = new int[]{2, 2, 4, 1, 3, 1};
                break;
            }
            case "UY": {
                arr_v = new int[]{2, 1, 1, 2, 1, 2};
                break;
            }
            case "UZ": {
                arr_v = new int[]{1, 2, 3, 4, 3, 2};
                break;
            }
            case "VA": {
                arr_v = new int[]{0, 2, 2, 2, 2, 2};
                break;
            }
            case "VC": {
                arr_v = new int[]{1, 2, 0, 0, 2, 2};
                break;
            }
            case "VE": {
                arr_v = new int[]{4, 4, 4, 4, 2, 2};
                break;
            }
            case "VG": {
                arr_v = new int[]{2, 2, 1, 1, 2, 4};
                break;
            }
            case "VI": {
                arr_v = new int[]{0, 2, 1, 2, 2, 2};
                break;
            }
            case "VN": {
                arr_v = new int[]{0, 0, 1, 2, 2, 2};
                break;
            }
            case "VU": {
                arr_v = new int[]{4, 3, 3, 2, 2, 2};
                break;
            }
            case "WF": {
                arr_v = new int[]{4, 2, 2, 4, 2, 2};
                break;
            }
            case "WS": {
                arr_v = new int[]{3, 1, 2, 2, 2, 2};
                break;
            }
            case "XK": {
                arr_v = new int[]{1, 2, 1, 1, 2, 2};
                break;
            }
            case "YE": {
                arr_v = new int[]{4, 4, 4, 4, 2, 2};
                break;
            }
            case "YT": {
                arr_v = new int[]{2, 3, 3, 4, 2, 2};
                break;
            }
            case "ZA": {
                arr_v = new int[]{2, 4, 2, 1, 1, 2};
                break;
            }
            case "ZM": {
                arr_v = new int[]{4, 4, 4, 3, 2, 2};
                break;
            }
            case "ZW": {
                arr_v = new int[]{4, 2, 4, 3, 2, 2};
                break;
            }
            default: {
                arr_v = new int[]{2, 2, 2, 2, 2, 2};
            }
        }
        HashMap hashMap0 = new HashMap(8);
        hashMap0.put(0, 1000000L);
        hashMap0.put(2, ((Long)f.n.get(arr_v[0])));
        hashMap0.put(3, ((Long)f.o.get(arr_v[1])));
        hashMap0.put(4, ((Long)f.p.get(arr_v[2])));
        hashMap0.put(5, ((Long)f.q.get(arr_v[3])));
        hashMap0.put(10, ((Long)f.r.get(arr_v[4])));
        hashMap0.put(9, ((Long)f.s.get(arr_v[5])));
        hashMap0.put(7, ((Long)f.n.get(arr_v[0])));
        this.b = hashMap0;
        this.c = 2000;
        this.d = r.a;
        this.e = true;
    }
}

