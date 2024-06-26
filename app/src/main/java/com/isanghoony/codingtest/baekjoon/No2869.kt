package com.isanghoony.codingtest.baekjoon

import java.util.Scanner

/**
 * 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
 * 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
 * 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
 * */

fun main() {
    val scanner = Scanner(System.`in`)

    val A = scanner.nextInt()
    val B = scanner.nextInt()
    val V = scanner.nextInt()

    // (V - B) 높이에 도달하려면 필요한 일수
    val days = (V - B) / (A - B)

    // 나머지가 있다면 하루 더 필요함
    if ((V - B) % (A - B) != 0) {
        println(days + 1)
    } else {
        println(days)
    }
}

/*
    입력 예시:
    2 1 5
    출력: 4
    ------------
    5 1 6
    출력: 2
    ------------
    100 99 1000000000
    출력: 999999901
    */