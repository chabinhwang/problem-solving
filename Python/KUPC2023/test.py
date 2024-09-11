<<<<<<< HEAD
arr=[0,0]
arr.insert(10,123)
print(arr)
=======

import sys


horse,length=map(int, input().split())
horsearr=[]#1100..이런거저장

for _ in range(horse):
    horsearr.append(sys.stdin.readline().strip())
for i in range(len(horsearr)):#int형변환
    horsearr[i]=[int(k) for k in horsearr[i]]

if len(horsearr[0])<2:#검은줄이 하나있는것만 출력하면됨
    count=0
    for i in range(len(horsearr)):
        if horsearr[i][0]==1:
            count+=1
    print(1,count)
else:#흰줄에서 검은줄 바뀌는거 카운트, 검은줄시작이면 바로카운트+1
    blackarr=[0 for _ in range(len(horsearr))]#각 인덱스별검은줄이 몇개인가 0으로초기화
    for i in range(len(horsearr)):#말 한개씩 탐색
        if horsearr[i][0]==0:#시작이흰색
            for k in range(1,len(horsearr[i])):
                if horsearr[i][k]==1 and horsearr[i][k-1]==0:#백>흑
                    blackarr[i]+=1
        else:#시작이검은색
            for k in range(1,len(horsearr[i])):
                if horsearr[i][k]==1 and horsearr[i][k-1]==0:#백>흑
                    blackarr[i]+=1
            blackarr[i]+=1
    result=max(blackarr)
    resultcount=0
    for i in blackarr:
        if i==result:
            resultcount+=1
    print(result,resultcount)
>>>>>>> 980dfb3404d26a462139843e19df7526a5d7eb6a
