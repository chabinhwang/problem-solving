# 등차수열->공차를 기준으로 나누기
# 행과 열 공차 따로 적용해서 계산하기
# 공차범위 행렬 크기 안넘게 주의하기
# 공차가 작을때, 원소2개일때 ,3개일때..이렇게 적용하기
import math
def sol(n):#제곱근 있으면 제곱근반환, 없으면-1반환
    x=math.sqrt(n)
    if x!=int(x):
        return -1
    return int(x)**2
n,m=map(int,input().split())
arr=[]
resultarr=[]#제곱수가 있는 수들을 모아놓는 배열
for i in range(n):
    arr.append(list(map(int,input())))
#한개의 원소로 제곱수를 나타낼 수 있는 경우
for i in range(n):#세로 공차
    for j in range(m):#가로 공차
        if sol(arr[i][j])!=-1:
            resultarr.append(sol(arr[i][j]))
#두개의 원소로 제곱수를 나타낼 수 있는 경우
for i in range(n):#세로 공차
    for j in range(m):#가로 공차
        for k in range(n):#세로 공차
            for l in range(m):#가로 공차
                if sol(arr[i][j]*10+arr[k][l])!=-1:
                    resultarr.append(sol(arr[i][j]*10+arr[k][l]))
#세개 이상의 원소로 제곱수를 나타낼 수 있는 경우
#가능한 공차 추려내기
maxrow=n//3#행 최대공차,n==8이면 최대공차는 2 최소공차 1
maxcol=m//3#열 최대공차
for i in range(n):#행,렬 index
    for j in range(m):
        #arr[i][j]기준으로 사방팔방으로 원소추려내기
        for k in range(maxrow):#k와l은 공차의 크기(0부터시작하므로+1해줘야함)
            for l in range(maxcol):
                temp=arr[i][j]
                #row+col+대각선은 몇개들어가는지 미리 세서 계산해야함
                a=0
                while i+a*(k+1)<=n-1 and j+a*(l+1)<=m-1:
                    a+=1#a갯수가 추가 항 갯수(a가3개면 [i][j], 다음1,다음2,다음3)
                a-=1
                for t in range(a):
                    temp+=arr[i+(t+1)*(k+1)][j+(t+1)*(l+1)]*(10**(t+1))
                    if sol(temp)!=-1:
                        resultarr.append(sol(temp))
                temp=arr[i][j]
                #row+col-
                a=0
                while i+a*(k+1)<=n-1 and j-a*(l+1)>=0:
                    a+=1#a갯수가 추가 항 갯수(a가3개면 [i][j], 다음1,다음2,다음3)
                a-=1
                for t in range(a):
                    temp+=arr[i+(t+1)*(k+1)][j-(t+1)*(l+1)]*(10**(t+1))
                    if sol(temp)!=-1:
                        resultarr.append(sol(temp))
                temp=arr[i][j]
                #row-col+
                a=0
                while i-a*(k+1)>=0 and j+a*(l+1)<=m-1:
                    a+=1#a갯수가 추가 항 갯수(a가3개면 [i][j], 다음1,다음2,다음3)
                a-=1
                for t in range(1,a+1):
                    temp+=arr[i-(t)*(k+1)][j+(t)*(l+1)]*(10**(t))
                    if sol(temp)!=-1:
                        resultarr.append(sol(temp))                
                temp=arr[i][j]
                #row+
                for p in range(1,(n-i)//(k+1)):#i에서 row끝까지 최대 몇개 들어갈 수 있나. 0개~최대-1
                    temp+=arr[i+p*k][j]*(10**(p+1))
                    if sol(temp)!=-1:
                        resultarr.append(sol(temp))
                temp=arr[i][j]
                #col+
                for p in range(1,(m-j)//(l+1)):#i에서 row끝까지 최대 몇개 들어갈 수 있나. 0개~최대-1
                    temp+=arr[i][j+p*l]*(10**(p+1))
                    if sol(temp)!=-1:
                        resultarr.append(sol(temp))
                temp=arr[i][j]
                #row-col-
                a=0
                while i-a*(k+1)>=0 and j-a*(l+1)>=0:
                    a+=1#a갯수가 추가 항 갯수(a가3개면 [i][j], 다음1,다음2,다음3)
                a-=1
                for t in range(a):
                    temp+=arr[i-(t+1)*(k+1)][j-(t+1)*(l+1)]*(10**(t+1))
                    if sol(temp)!=-1:
                        resultarr.append(sol(temp))
                temp=arr[i][j]                        
                #row-
                for p in range(1,(i+1)//(k+1)):#i에서 row끝까지 최대 몇개 들어갈 수 있나. 0개~최대-1
                    temp+=arr[i-p*k][j]*(10**(p+1))
                    if sol(temp)!=-1:
                        resultarr.append(sol(temp))
                temp=arr[i][j]
                #col-
                for p in range(1,(j+1)//(l+1)):#i에서 row끝까지 최대 몇개 들어갈 수 있나. 0개~최대-1
                    temp+=arr[i][j-p*(l+1)]*(10**(p+1))
                    if arr[i][j-p*(l+1)]==0:
                        temp+=10**(p+1)
                    if sol(temp)!=-1:
                        resultarr.append(sol(temp))
                temp=arr[i][j]
                if 0 in resultarr:
                    print(i,j,k,l)
if len(resultarr)==0:
    print(-1)
else:
    print(max(resultarr))
