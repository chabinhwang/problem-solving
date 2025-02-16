import copy
arr=[[]]
arr2=[[]]
arr.pop()
count=int(input())

def canIgetthisleft_right(arr,row,col):#왼쪽위에서 오른쪽아래 대각선 비숍있나?
    sum=abs(row-col)
    if row<=col:
        for i in range(count-sum):
            if arr[i][sum+i]==2:
                return False
    else:
        for i in range(count-sum):
            if arr[sum+i][i]==2:
                return False
    return True

def canIgetthisright_left(arr,row,col):#오른쪽위에서 왼쪽아래 대각선 비숍있나?
    sum=row+col
    if sum<count-1:
        for i in range(sum):
            if arr[i][sum-i]==2:
                return False
    else:
        for i in range(count-(sum-count+1)):
            if arr[sum-count+1+i][count-1-i]==2:
                return False
    return True

def left_right(arr,row,col):#왼쪽위에서 오른쪽아래 대각선 놓을 수 있는 칸 몇개?(이미 놓은 칸 포함)
    sum=abs(row-col)
    avail=0
    if row<=col:
        for i in range(count-sum):
            if arr[i][sum+i]>=1:
                avail+=1
    else:
        for i in range(count-sum):
            if arr[sum+i][i]>=1:
                avail+=1
    return avail

def right_left(arr,row,col):#오른쪽위에서 왼쪽아래 대각선 놓을 수 있는 칸 몇개?(이미 놓은 칸 포함)
    sum=row+col
    avail=0
    if sum<count-1:
        for i in range(sum+1):
            if arr[i][sum-i]>=1:
                avail+=1
    else:
        for i in range(count-(sum-count+1)):
            if arr[sum-count+1+i][count-1-i]>=1:
                avail+=1
    return avail

for i in range(count):#체스판 입력받기-arr에 저장
    arr.append(input().split())
#0은 놓을 수 없는곳, 1은 놓을 수 있는 곳
#0,0부터 아래로 쭉 내려가며 시작, 놓을 수 있는 곳에 놓고 숫자 2 올리기
for i in range(len(arr)):#배열 인트형으로 변환
    for k in range(len(arr[i])):
        arr[i][k]=int(arr[i][k])
result1=0

array=[[]for _ in range(count)]#빈배열, 0 1 행 렬 2 3 행 렬 이렇게 저장
for i in range(1):#i는 겹치는 수-1
    for k in range(count):
        for j in range(count):#count*count배열 전부 찾기
            if arr[k][j]==1:#비숍가능 칸이 대각선으로 몇개 겹치나
                            #겹치는갯수반환하는 함수 좌대각 우대각 두개필요함.
                if left_right(arr,k,j)+right_left(arr,k,j)==i+2:
                    #print(left_right(arr,k,j))
                    # print("두번째값",right_left(arr,k,j))
                    #print(k,",",j)
                    array[i].append(k)#행
                    array[i].append(j)#열
    for a in range(len(array[i])//2):#array의 첫번째가 행 두번째가 열
        if canIgetthisleft_right(arr,array[i][a*2],array[i][a*2+1]) and canIgetthisright_left(arr,array[i][a*2],array[i][a*2+1]):
            #print(array[i][a*2],array[i][a*2+1])
            arr[array[i][a*2]][array[i][a*2+1]]+=1
            result1+=1
#여기까지하면, 대각선에 아무것도없는애들은 꽉 찼음(2로바뀜)
print(result1)
#1.대각선에 1개씩 넣어보고, 안되면다른데바꿔보고>반복. 어차피 경우의수별로없음.
#2.대각선 돌아보면서, Dictionary활용하기
for i in range(count**2-result1):
    arr2=copy.deepcopy(arr)
    for j in range(len(arr)):
        for k in range(len(arr[0])):#j는 행 k는 열
            for p in range(i+1):#비숍 갯수
                

# 7
# 0 0 0 0 0 0 0
# 0 0 0 0 0 0 1
# 0 1 0 0 0 0 0
# 1 0 0 0 0 0 0
# 1 0 0 0 0 0 0
# 0 0 0 1 0 1 0
# 0 0 0 0 0 0 0
##젤위에서부터 젤아래까지 순차적으로
# for i in range(len(arr)):#어느 행에 넣을수 있는 경우가 많으면, 다 해보고 배열로 최대갯수 저장후 최대값을 출력해야함.
#     for k in range(len(arr[i])):#i행의 원소 하나씩...>끝까지 반복
#         if arr[i][k]==1:#arr이 str형배열이니까 int형으로바꿔줘야함
#             if canIgetthisleft_right(arr,i,k) and canIgetthisright_left(arr,i,k):
#                 arr[i][k]+=1
#                 result1+=1
##젤아래부터 젤위까지 순차적으로    
# result2=0
# for i in range(len(arr2)):#어느 행에 넣을수 있는 경우가 많으면, 다 해보고 배열로 최대갯수 저장후 최대값을 출력해야함.
#     for k in range(len(arr2[i])):#i행의 원소 하나씩...>끝까지 반복
#         if arr2[count-1-i][count-1-k]==1:#arr이 str형배열이니까 int형으로바꿔줘야함
#             if canIgetthisleft_right(arr2,count-1-i,count-1-k) and canIgetthisright_left(arr2,count-1-i,count-1-k):
#                 arr2[count-1-i][count-1-k]+=1
#                 result2+=1

# #정사각형 틀로 하기
# for i in range(count//2+1):#정사각형 틀 갯수, 가운데하나도 틀이라고침
#     for k in range(i,count-i):#상단 가로
#         if arr[i][k]==1:
#             if canIgetthisleft_right(arr,i,k) and canIgetthisright_left(arr,i,k):
#                 arr[i][k]+=1
#                 result1+=1
#     for j in range(i,count-i):#우측 세로
#         if arr[j][count-i-1]==1:
#             if canIgetthisleft_right(arr,j,count-i-1) and canIgetthisright_left(arr,j,count-i-1):
#                 arr[j][count-i-1]+=1
#                 result1+=1
#     for n in range(i,count-i):#하단 가로
#         if arr[count-i-1][n]==1:
#             if canIgetthisleft_right(arr,count-i-1,n) and canIgetthisright_left(arr,count-i-1,n):
#                 arr[count-i-1][n]+=1
#                 result1+=1
#     for p in range(i,count-i):# 좌측 세로
#         if arr[p][i]==1:
#             if canIgetthisleft_right(arr,p,i) and canIgetthisright_left(arr,p,i):
#                 arr[p][i]+=1
#                 result1+=1 

#대각선에 겹치는 자리 0인거>1인거>2인거>3인거, 0인거에 일단 다 넣고
#1인거에 넣고, 2인거에 넣고, 3인거에 넣고