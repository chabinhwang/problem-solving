def time_gone():#1시간이 지났을때, 위치전부변경
    for i in stick:
        if i[3]==0:#왼쪽>오른쪽
            i[0]+=1
            i[1]+=1
        else:      #오른쪽>왼쪽
            i[0]-=1
            i[1]-=1
        if i[3]==0 and i[1]==l:     #왼쪽>오른쪽이고, 반대편에 도착한 경우, 방향전환
            i[3]=1
        elif i[3]==1 and i[0]==0:   #오른쪽>왼쪽이고, 반대편에 도착한 경우, 방향전환
            i[3]=0
n,l=map(int, input().split())
stick=[]#[스틱의 시작점좌표,끝점좌표,층수,방향 지표] n by 3행렬, 좌표는 좌 0, 우 l 시작,층은 0 시작
for i in range(n):
    length,way=map(int,input().split())
    if way==0:      #왼쪽>오른쪽
        stick.append([0,length,i,way])
    else:           #오른쪽>왼쪽
        stick.append([l-length,l,i,way])
person=0            #철수의 층수
time=0              #시간
while person<n-1:   #철수의 층수<최고층수 일 때
    for i in range(person,n-1):#철수올리기
        if not(stick[i][1]<stick[i+1][0] or stick[i][0]>stick[i+1][1]):#겹치는경우
            person+=1
        else:break
    if person<n-1:
        time_gone()
        time+=1
print(time)