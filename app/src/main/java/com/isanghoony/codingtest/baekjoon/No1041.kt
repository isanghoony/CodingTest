package com.isanghoony.codingtest.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * 주사위는 위와 같이 생겼다. 주사위의 여섯 면에는 수가 쓰여 있다. 위의 전개도를 수가 밖으로 나오게 접는다.
 * A, B, C, D, E, F에 쓰여 있는 수가 주어진다. 지민이는 현재 동일한 주사위를 N3개 가지고 있다.
 * 이 주사위를 적절히 회전시키고 쌓아서, N×N×N크기의 정육면체를 만들려고 한다. 이 정육면체는 탁자위에 있으므로, 5개의 면만 보인다.
 * N과 주사위에 쓰여 있는 수가 주어질 때, 보이는 5개의 면에 쓰여 있는 수의 합의 최솟값을 출력하는 프로그램을 작성하시오.
 * */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`)) // 입력을 받기 위한 BufferedReader 설정
    val bw = BufferedWriter(OutputStreamWriter(System.out)) // 출력을 위한 BufferedWriter 설정
    val inputN = br.readLine().toInt() // 첫 번째 입력값을 정수로 변환
    val array = IntArray(6) // 주사위의 면들을 저장할 배열
    val st = StringTokenizer(br.readLine(), " ") // 두 번째 입력값을 공백을 기준으로 나눔

    var oneNum = Int.MAX_VALUE // 주사위의 가장 작은 숫자를 저장할 변수
    for (i in 0..5) {
        array[i] = st.nextToken().toInt() // 주사위 면의 숫자를 배열에 저장
        oneNum = minOf(array[i], oneNum) // 가장 작은 숫자를 찾음
    }

    if (inputN == 1) { // 주사위가 1개일 때
        array.sort() // 주사위 면의 숫자를 오름차순으로 정렬
        val answer = array.take(5).sum() // 가장 큰 숫자 하나를 제외한 나머지의 합
        bw.write(answer.toString()) // 결과 출력
    } else {
        val three = 4L // 꼭짓점에 해당하는 주사위 수
        val two = 4L * (inputN - 1) + (inputN - 2) * 4L // 모서리에 해당하는 주사위 수
        val one = inputN.toLong() * inputN * 5 - (three * 3 + two * 2) // 나머지 면에 해당하는 주사위 수

        // 각 꼭짓점에서의 최소값 계산
        val threeNum = minOf(array[0], array[5]) + minOf(array[1], array[4]) + minOf(array[2], array[3])

        var twoNum = Int.MAX_VALUE // 모서리의 최소값을 저장할 변수
        for (i in 0..5) {
            for (j in i + 1..5) {
                if (i + j != 5) { // 마주보는 면을 제외한 조합의 합 중 최소값 찾기
                    twoNum = minOf(twoNum, array[i] + array[j])
                }
            }
        }

        // 최종 결과 계산
        val answer = one * oneNum + two * twoNum + three * threeNum
        bw.write(answer.toString()) // 결과 출력
    }

    bw.flush()
    bw.close()
    br.close()
}

    /*
    입력 예시:
    2
    1 2 3 4 5 6
    출력: 36
    ------------
    3
    1 2 3 4 5 6
    출력: 69
    */