from sys import stdin
def input():
    return stdin.readline().rstrip()
N,M=map(int,input().split())
arr=[] # W는 1 B 는 0 으로 저장할 계획
for _ in range(N):
    templist=list(input())
    inputlist=[]
    for i in range(M):
        if templist[i]=='W':
            inputlist.append(1)
        else:# B
            inputlist.append(0)
    arr.append(inputlist)

result=float('inf')
for i in range(2):
    for j in range(N-7):
        for k in range(M-7):
            temp=0
            for p in range(8):

                for m in range(4):
                    if arr[j+p][k+m*2]==(i+p%2)%2:temp+=1
                    if arr[j+p][k+m*2+1]==(i+(p+1)%2)%2:temp+=1
            result=min(result,temp)
print(result)
