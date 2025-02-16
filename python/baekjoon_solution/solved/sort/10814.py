from sys import stdin
def input():
    return stdin.readline().rstrip()

N=int(input())

user_list=sorted(list(input().split() for _ in range(N)), key=lambda x:x[0])

for i in range(N):
    print(user_list[i][0]+" "+user_list[i][1])
