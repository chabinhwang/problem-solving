#1번 삽입정렬
# arr = [50, 10, 40, 20, 30]
# print("정렬이전: ",arr)
# for i in range(1,len(arr)):
#     for j in range(i,0,-1):
#         if(arr[j]<arr[j-1]):
#             arr[j],arr[j-1]=arr[j-1],arr[j]
#     if(i<5):
#         print(f"{i}단계 후: ",arr)

#2번 버블정렬
# arr = [50, 30, 40, 20, 10]
# print("정렬이전: ",arr)
# for i in range(0,len(arr)):
#     for j in range(0,len(arr)-i-1):
#         if(arr[j]>arr[j+1]):
#             arr[j],arr[j+1]=arr[j+1],arr[j]
#     if(i<4):
#         print(f"{i+1}단계 후: ",arr)

#3번 선택정렬
# arr = [40, 30, 50, 20, 10]
# print("정렬이전: ",arr)
# for i in range(0,len(arr)):
#     min=arr[i]
#     for j in range(i,len(arr)):
#         if(min>arr[j]):
#             arr[i],arr[j]=arr[j],arr[i]
#             min=arr[i]
#     if(i<4):
#         print(f"{i+1}단계 후: ",arr)

#4번 이진 탐색 알고리즘
# arr = [10, 20, 30, 40, 50, 60, 70]
# a=int(input("탐색할 숫자를 입력하세요: "))
# if a==0:
#     print("프로그램을 종료합니다")
# while(a!=0):
#     low=0
#     high=6
#     count=0
#     while(low<=high):
#         count+=1
#         mid=(low+high)//2
#         if(a==arr[mid]):
#             print("성공 여부: 성공")
#             print(f"비교횟수: {count}")
#             print(f"인덱스: {mid}")
#             break
#         elif a>arr[mid]:
#             low=mid+1
#         else:
#             high=mid-1
#     a=int(input("탐색할 숫자를 입력하세요: "))
#     if a==0:
#         print("프로그램을 종료합니다")


#5순차 탐색 알고리즘
# arr = [70, 20, 50, 60, 40, 30, 10]
# a=int(input("탐색할 숫자를 입력하세요: "))
# if a==0:
#     print("프로그램을 종료합니다")
# while(a!=0):
#     for i in range(len(arr)):
#         if a==arr[i]:
#             print("성공 여부: 성공")
#             print(f"비교횟수: {i+1}")
#             print(f"인덱스: {i}")
#             break
#     a=int(input("탐색할 숫자를 입력하세요: "))
#     if a==0:
#         print("프로그램을 종료합니다")

# 피보나치수열(n)
def fb(n):
    if n==0 or n==1:
        return 1
    elif n==2:
        return 2
    else:
        return fb(n-1)+fb(n-2)
print(fb(5))
sd