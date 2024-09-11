import sys
count=int(input())
month=[31,28,31,30,31,30,31,31,30,31,30,31]
flower=[]#2차원배열로 [피는날,지는날] 저장

for i in range(count):
    m1,d1,m2,d2=map(int,sys.stdin.readline().split())
    d1+=m1*100
    d2+=m2*100
    flower.append([d1,d2])
flowercount=count#꽃 갯수\
flower.append([1201,1231])#마지막꽃까지 아래for문 다 돌리기 위한 임시꽃(어차피 영향안줌)
flower.sort(key=lambda x:(x[0],x[1]))#첫번째 요소가 같으면, 두번째 요소 기준으로 정렬
flowercount=0
startday=[]#처음 꽃 피는날들 배열, 배열로하는이유는 첫번째 꽃피는날 인식할라고
endday=301#마지막 꽃 지는날
tempmaxend=0#임시저장 가장 늦게지는꽃
#첫번째 꽃 정하고, 첫번째 꽃 지는날을 벗어나는 새로운꽃 전까지, 가장 큰 지는날 저장해두고
#새로운꽃 나오면 "가장 큰 지는날 저장하고 그 날을 마지막날로 저장, 꽃 갯수 추가" 이후 반복



for i in range(len(flower)):
    if len(startday)>0:#시작 꽃 정한 이후
        if startday[0]>301 or endday>1130:#시작일이 301보다크거나(0출력), 끝나는날이 1201보다 크거나(카운트출력) 처리는for문밖에서
            break
        elif endday>=flower[i][0]:#마지막 꽃 지는날보다 i번째꽃이 피는게 빠르거나같음
            if flower[i][1]>tempmaxend:
                tempmaxend=flower[i][1]
            if tempmaxend>=1201:
                flowercount+=1
                break
        elif endday<flower[i][0]:
            if tempmaxend<flower[i][0]:#꽃 사이의 공백이 있을경우
                flowercount=0
                break
            else:
                endday=tempmaxend
                tempmaxend=flower[i][1]
                flowercount+=1
                # if tempmaxend>=1201:
                #     break
    if flower[i][0]>=301 and len(startday)==0:#시작 꽃 정하기
        if i==0 and flower[i][0]>301:#시작꽃이 3월1일넘을때
            startday.append(302)
        elif i==0 and flower[i][0]==301:#시작꽃이 3월1일일때
            startday.append(301)
            endday=flower[i][1]
            tempmaxend=flower[i][1]
            flowercount+=1
        elif i!=0 and flower[i][0]==301:#i번째 꽃이 3월1일일때
            #그 전꽃이 존재할 경우(3월1일넘은 가장 처음꽃이므로, 그 전 꽃이 3월1일전 시작인녀석 있거나 혹은 없거나)
            #앞에꽃과 크기비교
            tempmax=0
            for k in range(i+1):#0~i번째꽃까지 비교
                if tempmax<flower[k][1]:
                    tempmax=flower[k][1]
            startday.append(301)
            endday=tempmax
            flowercount+=1
            tempmaxend=endday
        elif i!=0 and flower[i][0]>301:#i꽃이 301초과, 앞에꽃o
            temp=0
            for k in range(i):
                if flower[k][0]<=301 and flower[k][1]>=flower[i][0]:#앞에 꽃 1개로, 커버완료시
                    temp=k
            if temp!=0:
                flowercount+=1
                tempmax=flower[temp][1]
                tempmaxend=flower[temp][1]
                endday=flower[temp][1]
            elif temp==0:#앞의 꽃으로 커버가 안될때
                endday=1130
                tempmaxend=1130
                break
            # tempmax=0
            # tempindex=0
            # startday.append(301)
            # for k in range(i):#0번~i 하나 전 꽃 까지 탐색
            #     if tempmax<flower[k][1]:
            #         tempmax=flower[k][1]
            #         tempindex=k
            # if tempmax<flower[i][0]:
            #     break
            # if flower[tempindex][0]<=301 and tempmax>=flower[i][1]:#i번앞에 꽃만으로, i범위 이상 커버가능한경우
            #     flowercount+=1
            #     endday=tempmax
            #     tempmaxend=endday
            # else:#꽃 2개 쓰는 경우, 앞에꽃만 배치후 뒤에꽃은미정
            #     flowercount+=1
            #     endday=tempmax
            #     tempmaxend=flower[i][1]
    elif flower[i][0]<301 and flower[i][1]>1201:
        flowercount=1
        endday=flower[i][1]
        break
if endday<1201 and tempmaxend<1201:
    print(0)
else:
    print(flowercount)

# 4
# 1 1 3 3
# 2 2 2 3
# 3 3 9 9
# 9 9 12 12
# ans:3

# 5
# 3 1 5 1
# 4 1 12 1
# 5 1 7 1
# 7 1 9 1
# 9 1 12 1
# ans: 2

# 2
# 3 1 5 5
# 5 6 12 1
# ans: 0

# 1
# 3 2 12 1
# ans: 0

# 1
# 3 1 11 30
# ans: 0

# 2
# 3 1 11 30
# 11 30 11 30
# ans: 0

# 3
# 3 1 5 5
# 5 5 10 8
# 10 7 11 30
# ans: 0

# 4
# 3 1 4 1
# 4 1 5 1
# 5 1 6 1
# 7 1 12 1
# ans: 0

# 3
# 1 1 11 30
# 11 10 12 5
# 3 1 12 1
# ans: 1

# 11
# 2 28 8 16
# 6 18 7 9
# 9 5 10 25
# 4 22 8 25
# 5 22 6 13
# 8 18 9 16
# 4 29 10 4
# 8 23 11 25
# 6 26 12 1
# 3 3 10 19
# 8 3 10 11
# ans: 2

# 10
# 1 1 11 23
# 11 22 11 24
# 11 23 11 25
# 11 24 11 26
# 11 25 11 27
# 11 26 11 28
# 11 27 11 29
# 11 28 12 1
# 11 23 11 27
# 11 27 12 1
# ans: 3

# 3 
# 1 1 7 10 
# 7 10 7 11
# 7 10 12 31
# ans: 2

# 2 
# 3 1 3 2 
# 3 2 12 1
# ans: 2

# 2 
# 3 1 11 30 
# 11 30 12 1
# ans: 2

# 6
# 1 1 3 2
# 3 1 4 2
# 4 1 5 2
# 5 1 6 2
# 6 1 7 2
# 4 3 12 1
# ans: 3

# 3
# 3 3 11 28
# 1 1 7 1
# 6 30 12 31
# ans: 2