from sys import stdin
def input():
    return stdin.readline().rstrip()

N,M=map(int,input().split())

sample=[input() for _ in range(N)]
print(sum(1 for _ in range(M) if input() in sample))