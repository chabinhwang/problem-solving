arr = [10, 20, 30, 40, 50, 60, 70]
search=1
low=0
high=6
count=0
mid=0
def sfunction(arr):
    global low
    global high
    global count
    global mid
    global search
    while low<=high:
        mid=int((low+high)/2)
        print(mid)
        if search==arr[mid]:
            count+=1
            return True
        elif search>arr[mid]:
            low=mid
            count+=1
        else:
            high=mid
            count+=1
    return False
while True:
    search=int(input("탐색할 숫자를 입력하세요: "))
    if search==0:
        break
    torf=sfunction(arr)
    print()
    if torf:
        print("성공 여부: 성공")
        print(f"비교 횟수:{count}")
        print(f"인덱스: {mid}")
        low=0
        high=6
        count=0
        mid=0
    else:
        print("성공 여부: 실패")
        print(f"비교 횟수:{count}")
        low=0
        high=6
        count=0
        mid=0
    print()
print("프로그램을 종료합니다")