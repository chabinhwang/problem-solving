dict_1={}
n,m,t,k=map(int, input().split())
#n=지도 가로, m=지도 세로, t=금광석 수, k=정사각형크기
for i in range(t):
    dict_1[i]=[int(i) for i in input().split()]
#배열에 x,y형으로 저장
#x를 작은것부터 정렬
sortdict=dict(sorted(dict_1.items(), key=lambda item:item[1][0]))
#키값 순서대로 정렬
sortdict={i: v for i,(k,v) in enumerate(sortdict.items(),start=0)}
maxx=0
maxy=0
maxcount=0
for i in range(len(sortdict)):
    temparr=[]
    for j in range(i,len(sortdict)):#x확인
        if sortdict[i][0]+k<=n:#i번째 x에 k더한게 끝을 넘냐마냐 판단
            if sortdict[i][0]+k>=sortdict[j][0]>=sortdict[i][0]:#안넘는경우
                temparr.append(sortdict[j][1])
        else:
            if n>=sortdict[j][0]>=sortdict[i][0]:#넘는경우
                temparr.append(sortdict[j][1])
    temparr=sorted(temparr)#temparr은 y값들이 배열로 저장되어있음. 정렬완료
    temp2=0#실제 광석갯수
    for a in range(len(temparr)):#y확인
        for q in range(a,len(temparr)):
            if temparr[a]+k<=m:#a번째 y에 k더한게 끝을 넘냐마냐 판단(천장끝)
                if temparr[a]<=temparr[q]<=temparr[a]+k:#안넘는경우
                    temp2+=1
            else:
                if m>=temparr[q]>=temparr[a]:#넘는경우
                    temp2+=1
        if temp2>maxcount:
            maxcount=temp2
            maxy=temparr[a]+k
            maxx=sortdict[i][0]
        temp2=0
#maxx랑maxy기준으로 그린 사각형이 테두리를 안넘게 해야함
if maxx+k>n:
    maxx=n-k
if maxy>m:
    maxy=m
print(maxx,maxy)
print(maxcount)