"""
정렬 한 다음, 첫번째 새는 위치-0.5에서 L만큼붙이고 다음 탐색하면 됌
물이 새는 곳의 개수 N
테이프의 길이 L
"""
from sys import stdin
def input():
    return stdin.readline().rstrip()

N, L=map(int,input().split())

leak_list=sorted(list(map(int,input().split())), key=lambda x:x)

tape_end = -L
count=0
for i in range(N):
    if leak_list[i] > tape_end:
        tape_end=max(tape_end+L,leak_list[i]-0.5+L)
        count+=1
        
print(count)