from sys import stdin
def input():
    return stdin.readline().rstrip()
N,M=map(int,input().split())

hear=set()
result=[]

for _ in range(N):
    hear.add(input())

for _ in range(M):
    tempinput=input()
    if tempinput in hear:
        result.append(tempinput)

result.sort()
print(len(result))
for i in result:
    print(i)