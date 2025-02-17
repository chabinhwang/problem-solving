"""
모든 인원이 소비하는 총 시간의 합 최솟값 구하기
예 : 1번째 사람이 1분, 2번째 사람이 2분, 3번째 사람이 3분소요 시
총 시간 = 1번째 사람은 1분기다림, 2번째 사람은 1+2=3분 3번째 사람은 1+2+3=6분 총 10분

풀이 : 정렬 후, 첫번째 사람이 가중하는 총 소요시간 = 소요시간 x N
        두번째 사람이 가중하는 총 소요시간 = 소요시간 x (N-1)
        ...
"""

from sys import stdin


def input():
    return stdin.readline().rstrip()


N = int(input())

time_list = sorted(list(map(int, input().split())), key=lambda x: x)

result = 0
for i in range(N):
    result+=time_list[i]*(N-i)
print(result)