n=int(input())
arr=[]
arr=list(map(int,input().split()))
result=[0]*n
stack=[]
for i in range(1,n):
    stack.append([arr[i-1],i])#스텍 앞부분이 기둥높이, 뒷부분이 기둥인덱스+1
    while len(stack)!=0:
        if arr[i]<stack[-1][0]:
            result[i]=stack[-1][1] 
            break
        else:
            stack.pop()
print(*result)

# # 스텍 구조 활용-실패
# n=int(input())
# arr=[]
# arr=list(map(int,input().split()))
# result=[0]*n
# stack=[]
# for i in range(1,n):
#     stack.append([arr[i-1],i])#스텍 앞부분이 기둥높이
#     while len(stack)!=0:
#         if arr[i]<stack[-1]:
#             result[i]=arr.index(stack[-1])+1  
#             break
#         else:
#             stack.pop()
# print(*result)


# #브루투 포스(완전 탐색)
# for i in range(n):#레이저 쏘는 기둥
#     for k in range(i,-1,-1):#레이저 어느기둥이 맞는지 확인, k번째면 k를 result[i]에 저장
#         if arr[i]<arr[k]:
#             if k+1 in result:
#                 if arr[result.index(k+1)]!=arr[i] and result[i]==0:#저장된 k+1의값이 있는 기둥의 높이와 i기둥의 높이가 다를경우
#                     result[i]=k+1
#                     break
#                 elif result[i]==0:#같을경우+안에 값이 없을 경우(있는경우냅두기)
#                     result[i]=0
#             elif result[i]==0:#비어있으면 넣기(안비어있으면 넣으면안됨)
#                 result[i]=k+1
#                 break
#     for i in range(len(result)):
#         print(result[i],end=' ')