# List Comprehension - 정렬까지 한번에 가능함
from sys import stdin
def input():
    return stdin.readline().rstrip()
N=int(input())
arr=[]
for i in range(N):
    arr.append(list(map(int,input().split())))

result=sorted([[a, b] for a, b in arr], key=lambda x: (x[0], x[1]))

for a, b in result:
    print(a,b)
