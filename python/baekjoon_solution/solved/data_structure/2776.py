"""
너무 쉬운 방법 쓰는것 같지만...자료구조 활용하면 금방 끝나는 문제
"""

from sys import stdin


def input():
    return stdin.readline().rstrip()


T = int(input())
for _ in range(T):
    input()
    note_1 = set(map(int, input().split()))
    input()
    note_2 = list(map(int, input().split()))
    for i in note_2:
        print(1) if i in note_1 else print(0)