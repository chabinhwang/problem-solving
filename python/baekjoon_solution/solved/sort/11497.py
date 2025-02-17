"""
42013 이런식으로만 나옴.
0번 1번, -1번 -2번도 겹치지만, 무시할 수치임
왜냐하면 0-1보다 0-2, -1 -2보다 -1 -3이 항상 크기 때문
"""

from sys import stdin


def input():
    return stdin.readline().rstrip()

T = int(input())
max_lv_list = []
for _ in range(T):
    N = int(input())
    tree_list = sorted(list(map(int, input().split())), key=lambda x: x)
    max_lv = 0
    for i in range(2,N):
        max_lv=max(max_lv,tree_list[i]-tree_list[i-2])
    max_lv_list.append(max_lv)
print("\n".join(map(str, max_lv_list)))