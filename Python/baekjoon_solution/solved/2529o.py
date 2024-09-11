#2529 부등호
#https://www.acmicpc.net/problem/2529
count=int(input())
arr=input().split()##부등호 배열 저장
countleft=0#<
countright=0#>

def findmaxinarr(arr):
    max=0
    for i in arr:
        if i>max:
            max=i
    return max
def findminarr(arr):
    min=9
    for i in arr:
        if i<min:
            min=i
    return min

def carculatemin(count,arr):#최소 숫자 배열 반환
    minarr=[0]
    for i in range(len(arr)):
        if arr[i]=='<':#<만나면 앞숫자보다 큰 숫자 append(중복확인)
            #숫자 추가할 때, 배열의 가장 큰수보다 1 큰수 넣으면됨
            minarr.append(findmaxinarr(minarr)+1)
        else:#>만났을때
            minarr[-1]+=1
            for k in range(1, len(minarr)):
                if arr[i-k]=='>':
                    minarr[i-k]+=1
                else:
                    break
            #숫자 추가할 때, 앞의 수보다 1작으면됨.
            minarr.append(minarr[-1]-1)
    return minarr

def carculatemax(count,arr):
    maxarr=[9]
    for i in range(len(arr)):
        if arr[i]=='>':#>만났을 때
            #배열 최소값-1 append
            maxarr.append(findminarr(maxarr)-1)
        else:#<만났을 때
            maxarr[-1]-=1
            for k in range(1,len(maxarr)):
                if arr[i-k]=='<':
                    maxarr[i-k]-=1
                else:
                    break
            #숫자 추가할 때, 앞의 수보다 1크면됨.
            maxarr.append(maxarr[-1]+1)


    return maxarr
            


for i in arr:
    if i=='<':
        countleft+=1
    elif i=='>':
        countright+=1

print(''.join([str(i) for i in carculatemax(count,arr)])) 
print(''.join([str(i) for i in carculatemin(count,arr)]))
