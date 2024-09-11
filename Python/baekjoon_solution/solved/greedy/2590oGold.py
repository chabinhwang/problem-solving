#1~6까지 색종이 갯수 파악
a1,a2,a3,a4,a5,a6=[int(input()) for _ in range(6)]
count=(a3//4+1)+a4+a5+a6#3 4 5 6은 무조건 1장씩 필요함. 이후 남는칸에 12들어가는지 확인 후 추가
#남는칸이 2x2인지 1x1인지, 몇개인지 파악
remain22=a4*5#22가 되는 칸의 최소단위갯수(2x2몇칸인지)
remain11=a5*11#11가 되는 칸의 최소단위갯수(1x1몇칸인지)
remain33=4-a3%4#33가 되는 칸의 최소단위갯수(3x3몇칸인지)
must11=remain11#11만가능한칸
if a3%4==0:#3x3가 0개거나 4개면, 남는33은 없음
    remain33=0
    count-=1
#남는3x3 2x2칸에 a2넣을 수 있나 확인,이후 1x1넣기, 부족하면 count 추가
#남는3x3이 3개일때, 2개일때, 1개일때에 따라 전부 달라짐
#22만 다 넣으면, 어차피 마지막에 넣을건 11이므로, 22들어갈수있는칸이든 뭐든 11가능칸으로 체크
if remain33==3:
    remain33_22=5#33으로이뤄진빈칸에 22가 최대5개까지들어갈수있음
    a2=remain33_22-a2
    if a2<0:
        must11+=7
        a2=-a2#2x2남은갯수
        a2=remain22-a2#22되는칸에 넣기
        if a2<0:#칸이부족해서, 1칸추가
            a2=-a2
            must11+=36-a2%9*4
            count=count+a2//9+1
            if a2%9==0:
                must11-=36
                count-=1
        else:#22칸에 22넣고 남은경우, 이때 a2는 남은a2가아니다
            must11+=a2*4
    else:#33칸에 22넣고 남은경우, 이때 a2는 남은a2갯수가 아니다
        must11+=7+a2*4
        must11+=remain22*4
elif remain33==2:
    remain33_22=3
    a2=remain33_22-a2
    if a2<0:
        must11+=6
        a2=-a2#2x2남은갯수
        a2=remain22-a2#22되는칸에 넣기
        if a2<0:#칸이부족해서, 1칸추가
            a2=-a2
            must11+=36-a2%9*4
            count=count+a2//9+1
            if a2%9==0:
                must11-=36
                count-=1
        else:#22칸에 22넣고 남은경우, 이때 a2는 남은a2가아니다
            must11+=a2*4
    else:#33칸에 22넣고 남은경우, 이때 a2는 남은a2갯수가 아니다
        must11+=6+a2*4
        must11+=remain22*4        
elif remain33==1:
    remain33_22=1
    a2=remain33_22-a2
    if a2<0:
        must11+=5
        a2=-a2#2x2남은갯수
        a2=remain22-a2#22되는칸에 넣기
        if a2<0:#칸이부족해서, 1칸추가
            a2=-a2
            must11+=36-a2%9*4
            count=count+a2//9+1
            if a2%9==0:
                must11-=36
                count-=1
        else:#22칸에 22넣고 남은경우, 이때 a2는 남은a2가아니다
            must11+=a2*4
    else:#33칸에 22넣고 남은경우, 이때 a2는 남은a2갯수가 아니다
        must11+=5+a2*4
        must11+=remain22*4
else:#remain33==0
    a2=remain22-a2
    if a2<0:
        a2=-a2#2x2남은갯수
        must11+=36-a2%9*4
        count=count+a2//9+1
        if a2%9==0:
            must11-=36
            count-=1
    else:#22칸에 22넣고 남은경우, 이때 a2는 남은a2갯수가 아니다
        must11+=a2*4
a1=must11-a1
if a1<0:
    a1=-a1#남은11갯수
    count=count+a1//36+1
    if a1%36==0:
        count-=1
print(count)