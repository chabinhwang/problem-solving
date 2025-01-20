N=int(input())
for i in range(N):
    arr=list(map(int,input().split()))
    if arr[0]==arr[3] and arr[1]==arr[4]: # 터렛이 같은 위치
        if arr[2]==arr[5]: # 마린이 같은 거리일 경우
            print(-1)
        else:# 마린이 다른 거리일 경우
            print(0)
    else: # 터렛이 다른 위치
        dist1=((arr[3]-arr[0])**2+(arr[4]-arr[1])**2) # 터렛의 거리
        dist2=(arr[2]+arr[5])**2 # 마린의 거리 합
        if (arr[5]-arr[2])**2==dist1 or (arr[2]-arr[5])**2==dist1:# 원 속에 원 있으면서 걸치면
            print(1)
        elif (arr[5]-arr[2])**2>dist1 or (arr[2]-arr[5])**2>dist1:# 원 속에 원 있으면서 안걸치면
            print(0)
        else:
            if dist1>dist2:
                print(0)
            elif dist1==dist2:
                print(1)
            else:
                print(2)