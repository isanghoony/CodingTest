package com.isanghoony.codingtest.baekjoon

/**
옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.
길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
S = A[0] × B[0] + ... + A[N-1] × B[N-1]
S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
S의 최솟값을 출력하는 프로그램을 작성하시오.

첫째 줄에 N이 주어진다. 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 셋째 줄에는 B에 있는 수가 순서대로 주어진다.
N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.
 * */
fun main() {
    // 사용자로부터 배열의 크기 N을 입력받는다.
    var nSize = readln().toInt()

    if (nSize > 50) return

    // 사용자로부터 배열 A의 원소들을 입력받고 정수 리스트로 변환하여 arrayA에 저장한다.
    val arrayA = readln()
        .split(" ") // 입력된 문자열을 공백으로 분리하여 리스트로 만든다.
        .map {
            it.toInt() // 각 문자열 원소를 정수로 변환한다.
        }
        .toMutableList()

    // 사용자로부터 배열 B의 원소들을 입력받고 정수 리스트로 변환하여 arrayB에 저장한다.
    val arrayB = readln()
        .split(" ") // 입력된 문자열을 공백으로 분리하여 리스트로 만든다.
        .map {
            it.toInt() // 각 문자열 원소를 정수로 변환한다.
        }

    if (arrayA.any { it > 100 } || arrayB.any { it > 100 }) return

    arrayA.sort() // 배열 A를 오름차순으로 정렬한다.

    val sortedB = arrayB.sortedDescending() // 배열 B를 내림차순으로 정렬한 새로운 리스트를 만든다.

    var result = 0
    for (i in 0 until nSize) {  // 0부터 nSize-1까지 반복
        result += arrayA[i] * sortedB[i]  // 배열 A와 B의 각 원소를 곱한 값을 S에 더한다.
    }
    // S의 최솟값을 출력한다.
    println(result)
}
    /*
    입력 예시:
    5
    1 1 1 6 0
    2 7 8 3 1
    출력: 18

    3
    1 1 3
    10 30 20
    출력: 80

    9
    5 15 100 31 39 0 0 3 26
    11 12 13 2 3 4 5 9 1
    출력: 528
    */