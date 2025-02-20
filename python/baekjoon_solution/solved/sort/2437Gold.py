"""
1 ~ K까지의 저울을 활용해 측정 가능한 무게의 범위가 1 ~ M 이라 하자. 이때, D 의 무게를 가진
저울이 추가되면 측정 범위 최대는 M+D 이다. 그러나 만약, K가 5인데 D가 10이면
측정 가능한 범위는 1~5, 11~15가 되므로 6은 측정이 불가능하다. 따라서 이 빈틈을 찾으면 됀다.
"""

from sys import stdin

N = int(input())
wlist = sorted(list(map(int, stdin.readline().rstrip().split())))
if wlist[0]!=1:
    print(1)
else:
    boundary = wlist[0]  # 무게 측정 가능 바운더리
    result = sum(wlist)+1
    for i in range(1, N):
        if (
            wlist[i] > boundary+1
        ):  # 만일 바운더리보다 wlist[i]값이 큰경우, 빈칸이 필연적으로 발생(1~6에서 7일경우 1~6 8~13)
            result=boundary+1
            break
        else:
            boundary+=wlist[i]
    print(result)