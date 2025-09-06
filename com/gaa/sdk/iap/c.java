package com.gaa.sdk.iap;

import com.gaa.sdk.base.d;

public final class c extends d {
    @Override  // com.gaa.sdk.base.d
    public final String a(int v) {
        boolean z = d.c();
        if(v != 0x1869F) {
            switch(v) {
                case 0: {
                    return z ? "성공" : "Success";
                }
                case 1: {
                    return z ? "결제가 취소되었습니다." : "The payment has been canceled.";
                }
                case 2: {
                    return z ? "단말 또는 서버 네트워크 오류가 발생하였습니다." : "A device or server network error has occurred.";
                }
                case 3: {
                    return z ? "구매 처리 과정에서 오류가 발생하였습니다." : "An error occurred during the purchase process.";
                }
                case 4: {
                    return z ? "상품이 판매중이 아니거나 구매할 수 없는 상태입니다." : "The product is not on sale or cannot be purchased.";
                }
                case 5: {
                    return z ? "올바르지 않은 요청입니다." : "Invalid request.";
                }
                case 6: {
                    return z ? "정의되지 않은 기타 오류가 발생했습니다." : "An unknown error has occurred.";
                }
                case 7: {
                    return z ? "이미 아이템을 소유하고 있습니다." : "The item has already been provided.";
                }
                case 8: {
                    return z ? "아이템을 소유하고 있지 않아 소비 할 수 없습니다." : "Can\'t consume it. Please check whether the item has been paid or not.";
                }
                case 9: {
                    return z ? "결제에 실패했습니다. 결제 가능 여부 및 결제 수단 확인 후 다시 결제해주세요." : "Payment failed. Please check the payment availability and payment method and make a payment again.";
                }
                case 10: {
                    return z ? "원스토어 앱 로그인이 필요합니다." : "Available after signing in the ONEstore app.";
                }
                case 11: {
                    return z ? "결제 모듈의 업데이트가 필요합니다." : "The payment module update is required.";
                }
                case 12: {
                    return z ? "비정상 앱에서 결제가 요청되었습니다." : "Payment requested by abnormal app.";
                }
                case 13: {
                    return z ? "요청이 차단되었습니다." : "The request was blocked.";
                }
                case 14: {
                    return z ? "테스트 환경에서는 지원하지 않는 기능입니다." : "Feature not supported in test environment.";
                }
                case 1001: {
                    return z ? "응답 데이터 파싱 오류가 발생했습니다." : "An error occurred while parsing response data.";
                }
                case 1002: {
                    return z ? "구매정보의 서명 검증 에러 발생했습니다." : "A signature verification error has occurred.";
                }
                case 1003: {
                    return z ? "정상적이지 않은 파라미터가 입력 되었습니다." : "Parameter is invalid.";
                }
                case 1004: {
                    return z ? "정의되지 않는 오류가 발생했습니다." : "An unknown error has occurred.";
                }
                case 1005: {
                    return z ? "입력하신 라이센스 키가 유효하지 않습니다." : "The license key is invalid.";
                }
                case 1007: {
                    return z ? "결제 모듈과의 연결이 끊어졌습니다." : "The connection to the payment module has been lost.";
                }
                case 0x3F0: {
                    return z ? "기능을 지원하지 않습니다." : "This feature is not supported.";
                }
                case 1009: {
                    return z ? "서비스와 통신하는 시간이 초과되었습니다." : "Timed out.";
                }
                case 1010: {
                    return z ? "원스토어에 연결할 수 없습니다. 원스토어 앱 실행이 필요합니다." : "Unable to connect to ONE store. Launching the ONE store app is required.";
                }
                default: {
                    return d.b(v, z);
                }
            }
        }
        return z ? "서버 점검중입니다." : "The server is currently under maintenance.";
    }
}

