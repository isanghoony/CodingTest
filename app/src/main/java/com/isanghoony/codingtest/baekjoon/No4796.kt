package com.isanghoony.codingtest.baekjoon

/**
 * 등산가 김강산은 가족들과 함께 캠핑을 떠났다. 하지만, 캠핑장에는 다음과 같은 경고문이 쓰여 있었다.
 * 캠핑장은 연속하는 20일 중 10일동안만 사용할 수 있습니다.
 * 강산이는 이제 막 28일 휴가를 시작했다. 이번 휴가 기간 동안 강산이는 캠핑장을 며칠동안 사용할 수 있을까?
 * 강산이는 조금 더 일반화해서 문제를 풀려고 한다.
 * 캠핑장을 연속하는 P일 중, L일동안만 사용할 수 있다. 강산이는 이제 막 V일짜리 휴가를 시작했다. 강산이가 캠핑장을 최대 며칠동안 사용할 수 있을까? (1 < L < P < V)
 * */

fun main() {
    var lDay = 0 // 캠핑장을 사용할 수 있는 최대 일수
    var pDay = 0 // 캠핑장의 휴업 주기
    var vDay = 0 // 총 휴가 일수
    var cnt = 0 // 캠핑장에서 보낼 수 있는 최대 일수

    for (testCase in 1..Int.MAX_VALUE) {
        // 입력을 읽어와서 공백으로 나누고 lDay, pDay, vDay에 할당
        readlnOrNull()?.split(" ")?.let {
            lDay = it[0].toInt()
            pDay = it[1].toInt()
            vDay = it[2].toInt()
        }

        // 모든 입력값이 0이면 종료
        if (lDay == 0 && pDay == 0 && vDay == 0) break

        // 캠핑장에서 보낼 수 있는 일수 계산
        cnt = (vDay.div(pDay)).times(lDay) // 전체 주기 동안 캠핑할 수 있는 일수 계산
        vDay = vDay.rem(pDay) // 남은 휴가 일수 계산
        cnt += if (vDay < lDay) vDay else lDay // 남은 일수 중 가능한 최대 일수를 더함

        println("Case $testCase: $cnt")
    }

    /*
    입력 예시:
    5 8 20
    출력: Case 1: 14
    5 8 17
    출력: Case 2: 11
    0 0 0
    */
}