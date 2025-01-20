import sys
sys.setrecursionlimit(10**6)
T=int(input())

def dfs(target):
    # 사방위에 배추가 있는지 확인하고, 있으면 그 지점에서 다시 dfs 작동
    global arr
    targetarr=[[target[0]+1,target[1]],[target[0],target[1]+1]
                   ,[target[0]-1,target[1]],[target[0],target[1]-1]]
    arr.remove(target)
    for i in targetarr:
        if i in arr: # 그 방향에 배추가 존재한다면
            dfs(i)
    
arr=[] # 검증하기 전 배추들 저장
count=0
for _ in range(T):
    arr=[]
    end=[]
    count=0
    _,_,K=map(int, input().split())
    for i in range(K):
        temp=list(map(int,input().split()))
        arr.append(temp)
    arr.sort(key=lambda x:(x[0],x[1]))
    while arr:
        dfs(arr[0])
        count+=1
    print(count)