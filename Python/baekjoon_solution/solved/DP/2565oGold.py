n=int(input())
arr=[]#전깃줄연결 저장
for i in range(n):
    temp=input().split()
    arr.append([int(temp[0]),int(temp[1])])#전깃줄을 2차원배열로 저장,[[왼쪽칸,오른쪽칸]....]
arr.sort(key=lambda x:(x[0]))#첫번째값기준 정렬
temparr=[1 for _ in range(n)]#덩어리들확인하기위해
for i in range(len(arr)):
    for k in range(i):
        if arr[i][1]>arr[k][1]:#어차피 x는 오름차순정렬, 따라서 y값만 비교하면됨
            if temparr[i]<temparr[k]+1:
                temparr[i]=temparr[k]+1
print(len(arr)-max(temparr))#가장 큰 덩어리를빼면, 빼야할 전선들만 남음









# 가장 많이 꼬인전깃줄순으로 보는법, 물론틀림
#n=int(input())
# arr=[]#전깃줄연결 저장
# for i in range(n):
#     temp=input().split()
#     arr.append(tuple([int(temp[0]),int(temp[1])]))#튜플로해야 키값으로쓸수있음
# arr.sort(key=lambda x:(x[0]))
# tuple1=tuple(arr)
# count=0#교차점 수
# num=0#전깃줄 뺀 값
# dictionary={}#배열
# for i in range(len(arr)):#전깃줄을 배치하고, 그 후에 앞과 비교
#     cross=0
#     dictionary[tuple1[i]]=[cross]
#     for k in range(len(arr)):
#         if (arr[i][0]>arr[k][0] and arr[i][1]<arr[k][1])or(arr[i][0]<arr[k][0] and arr[i][1]>arr[k][1]):
#             dictionary[tuple1[i]][0]+=1
#             dictionary[tuple1[i]].append([arr[k][0],arr[k][1]])
#             count+=1
# #dictionary는 {전깃줄:[겹치는수,[겹치는줄1],[겹치는줄2].....]}여기서 벨류 첫째항을 기준으로 정렬
# #예시
# #{(1, 8): [5, [2, 2], [4, 1], [6, 4], [7, 6], [9, 7]], (3, 9): [4, [4, 1], [6, 4], [7, 6], [9, 7]],
# dictionary=dict(sorted(dictionary.items(),key=lambda x:x[1][0],reverse=True))#겹치는거큰수부터
# for i in dictionary:#i는 딕셔너리 키갑의미
#     #dictionary에 있는 전선에 가서 벨류index0값 하나씩 빼기(0이 아니면)
#     if dictionary[i][0]!=0:#i키에 벨류(배열) index0(겹치는수)
#         count-=dictionary[i][0]*2#겹치는전깃줄확인
#         num+=1#전깃줄 한개 뺀거 의미
#         for k in range(len(dictionary[i])-1):#두번째값부터마지막까지 전깃줄정보있음
#             dictionary[tuple(dictionary[i][k+1])].remove(list(i))
#             dictionary[tuple(dictionary[i][k+1])][0]-=1
#         #본인도빼야됨
#         dictionary[i][0]=0
#         dictionary=dict(sorted(dictionary.items(),key=lambda x:x[1][0],reverse=True))#정렬한번다시함
#     elif count==0:
#         break
#     print(dictionary)
# print(num)