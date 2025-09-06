package com.gaa.sdk.base;

import android.content.res.Resources;

public class d {
    public String a(int v) {
        return d.b(v, d.c());
    }

    public static String b(int v, boolean z) {
        switch(v) {
            case 0: {
                return z ? "성공" : "Success";
            }
            case 100: {
                return z ? "업데이트" : "Update";
            }
            case 101: {
                return z ? "원스토어 구성 요소 설치 중 알 수 없는 오류가 발생하였습니다." : "An unknown error has occurred during the ONE store component installation.";
            }
            case 102: {
                return z ? "원스토어 구성 요소  설치가 필요합니다. 설치를 진행 하시겠습니까?" : "Installation of the ONE store component is required. Install now?";
            }
            case 103: {
                return z ? "원스토어 구성 요소 업데이트가 필요합니다. 업데이트를 진행 하시겠습니까?" : "An update for the ONE store component is required. Update now?";
            }
            case 104: {
                return z ? "원스토어 구성 요소를 다운로드하고 있습니다." : "Downloading the ONE store component.";
            }
            case 105: {
                return z ? "원스토어 구성 요소를 설치하고 있습니다." : "Installing the ONE store component.";
            }
            case 106: {
                return z ? "원스토어 구성 요소의 설치가 완료된 후 다시 시도해주세요." : "Please try again after the ONE store component has been installed.";
            }
            case 1003: {
                return z ? "정상적이지 않은 파라미터가 입력 되었습니다." : "Parameter is invalid.";
            }
            case 1006: {
                return z ? "원스토어 구성 요소 설치에 실패하였습니다." : "Failed to install the ONE store component.";
            }
            default: {
                return "";
            }
        }
    }

    public static boolean c() {
        return "KO".equalsIgnoreCase(Resources.getSystem().getConfiguration().getLocales().get(0).getLanguage());
    }
}

