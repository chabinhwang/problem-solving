from sys import stdin


def input():
    return stdin.readline().rstrip()


n = int(input())
if n == 0:
    print(0)
else:
    lev = sorted(list(int(input()) for _ in range(n)), key=lambda x: x)
    erase = int(n * 0.15 + 0.5)
    lev=lev[erase:n-erase]
    print(int(sum(lev) / len(lev) + 0.5))