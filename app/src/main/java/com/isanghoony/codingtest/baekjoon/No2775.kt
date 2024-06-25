package com.isanghoony.codingtest.baekjoon

import java.util.Scanner

/**
 * 평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.
 * 이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.
 * 아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라. 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
 */

fun main() {
    val scanner = Scanner(System.`in`)

    val t = scanner.nextInt() // 테스트 케이스 수 입력
    val results = mutableListOf<Int>() // 결과를 저장할 리스트

    repeat(t) {
        val k = scanner.nextInt() // 현재 테스트 케이스의 층 수
        val n = scanner.nextInt() // 현재 테스트 케이스의 호 수

        // k층 n호에 사는 사람 수를 저장할 배열 초기화
        val people = Array(k + 1) {
            IntArray(n + 1) { 0 }
        }

        // 0층 초기화
        for (i in 1..n) {
            people[0][i] = i // 0층 i호에는 i명이 사는 것으로 초기화
        }

        // 1층부터 k층까지 채우기
        for (floor in 1..k) { // 층 수만큼 반복
            for (room in 1..n) { // 호 수만큼 반복

                // 현재 층의 현재 호수에 사는 사람 수는 이전 호수까지의 누적 사람 수와 같은 층의 현재 호수까지의 누적 사람 수를 더한 값
                people[floor][room] = people[floor][room - 1] + people[floor - 1][room]
            }
        }

        val result = people[k][n] // k층 n호에 사는 사람 수
        results.add(result) // 결과 리스트에 추가
    }
    results.forEach { println(it) }
}