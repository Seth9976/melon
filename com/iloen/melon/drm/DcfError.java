package com.iloen.melon.drm;

import U4.x;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.response.DcfExtensionExpireDateRes.Response.RejectList;
import com.iloen.melon.utils.log.LogU;

public class DcfError extends Exception {
    public int a;
    public DcfFile b;
    public static final DcfError c = null;
    public static final DcfError d = null;
    private static final long serialVersionUID = 0x4849D2204DB1CD32L;

    static {
        DcfError.c = new DcfError(0);
        DcfError.d = new DcfError(-1);
    }

    public DcfError(int v) {
        this.a = v;
    }

    public DcfError(RejectList dcfExtensionExpireDateRes$Response$RejectList0) {
        super(dcfExtensionExpireDateRes$Response$RejectList0.rejectmsg);
        this.a = -1;
        try {
            this.a = Integer.parseInt(dcfExtensionExpireDateRes$Response$RejectList0.rejectcd);
        }
        catch(Exception exception0) {
            LogU.e("DcfError", exception0.toString());
        }
    }

    public DcfError(Exception exception0) {
        super(exception0);
        this.a = -1;
    }

    @Override
    public final String getMessage() {
        String s = super.getMessage();
        if(TextUtils.isEmpty(s)) {
            MelonAppBase.instance.getContext();
            switch(this.a) {
                case -103: {
                    return "재생 권한 확인을 위해 기기 설정에서 시간정보를 자동으로 변경해주세요.";
                }
                case -2300: 
                case -102: {
                    return "파일 재생권한이 없습니다. 기기등록 여부 확인 후 파일 재다운로드 해주세요.";
                }
                case -203: 
                case -100: {
                    return "통신망에 인증되지 않았거나 유효하지 않는 단말입니다.";
                }
                case -22: {
                    return "메모리가 부족하여 재생할 수 없습니다. 메모리 정리 후 다시 시도해 주세요.";
                }
                case 0xFFFFD8F1: 
                case 0xFFFFD908: 
                case -13: 
                case -8: 
                case -1: {
                    return "파일이 손상되었거나, 저장된 경로가 올바르지 않아 재생할 수 없습니다.";
                }
                case 0: {
                    break;
                }
                default: {
                    return "파일을 재생할 수 없습니다.";
                }
            }
        }
        return s;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DcfError {code: ");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", msg:");
        String s = super.getMessage();
        if(TextUtils.isEmpty(s)) {
            switch(this.a) {
                case -2400: {
                    s = "업데이트 에러";
                    break;
                }
                case -2300: {
                    return x.m(stringBuilder0, "업데이트 권한 없음", "}");
                }
                case -2201: {
                    return x.m(stringBuilder0, "원본 컨텐트의 UsageControl Header 길이와 입력한 Header 길이가 다름", "}");
                }
                case -2200: {
                    return x.m(stringBuilder0, "잘못된 형식의 UsageControl Header 입력", "}");
                }
                case -2100: {
                    return x.m(stringBuilder0, "업데이트할 컨텐트 파일 없음", "}");
                }
                case -2020: {
                    return x.m(stringBuilder0, "잘못된 형식 혹은 중복된 TimeNoAfter 값의 입력", "}");
                }
                case -2010: {
                    return x.m(stringBuilder0, "잘못된 형식의 Client ID Value 에러", "}");
                }
                case -2000: {
                    return x.m(stringBuilder0, "잘못된 형식의 Client ID Type 에러", "}");
                }
                case -300: {
                    return x.m(stringBuilder0, "가사를 찾을 수 없는 에러", "}");
                }
                case -104: {
                    return x.m(stringBuilder0, "잘못된 서비스 타입", "}");
                }
                case -103: {
                    return x.m(stringBuilder0, "단말에서 유효한 시간을 가져 올 수 없음", "}");
                }
                case -102: {
                    return x.m(stringBuilder0, "DCF의 소유자와 단말의 Min 번호가 다름", "}");
                }
                case -101: {
                    return x.m(stringBuilder0, "유효기간 지남", "}");
                }
                case -100: {
                    return x.m(stringBuilder0, "단말이 망에 등록 되지 않음", "}");
                }
                case -26: {
                    return x.m(stringBuilder0, "최대 열 수 있는 파일 초과 에러", "}");
                }
                case -25: {
                    return x.m(stringBuilder0, "DRM_UCH_init() 초기화 안함", "}");
                }
                case -22: {
                    return x.m(stringBuilder0, "메모리 할당 에러", "}");
                }
                case -13: {
                    return x.m(stringBuilder0, "파일 Tell 에러", "}");
                }
                case -12: {
                    return x.m(stringBuilder0, "파일 Seek 에러", "}");
                }
                case -11: {
                    return x.m(stringBuilder0, "파일 쓰기 에러", "}");
                }
                case -10: {
                    return x.m(stringBuilder0, "파일 읽기 에러", "}");
                }
                case -8: {
                    return x.m(stringBuilder0, "잘못된 DCF Header 오류", "}");
                }
                case -3: 
                case -2: {
                    return x.m(stringBuilder0, "알 수 없는 파일 IO error - open 되지 않은 fd 를 닫을 때", "}");
                }
                case -1: {
                    return x.m(stringBuilder0, "지정되지 않은 오류입니다.", "}");
                }
                default: {
                    return x.m(stringBuilder0, s, "}");
                }
            }
        }
        return x.m(stringBuilder0, s, "}");
    }
}

