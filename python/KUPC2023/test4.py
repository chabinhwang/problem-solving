import sys
n=int(sys.stdin.readline().strip())
arr=input().split()
arr=[int(i) for i in arr]
arr.sort(reverse=True)#내림차순정렬
resultarr=[]
count=0
for i in range(len(arr)):
    if len(resultarr)==0:
        resultarr.insert(0,arr[0])
        count+=1
    elif len(resultarr)==1:
        resultarr.insert(0,arr[1])
        count+=1
    else:
        if resultarr[0]>arr[i] and resultarr[-1]>arr[i]:#둘보다작으면, 차이적은쪽
            if resultarr[0]-arr[i]>resultarr[-1]-arr[i]:
                resultarr.append(arr[i])
                count+=1
            else:
                resultarr.insert(0,arr[i])
                count+=1
        elif resultarr[0]>arr[i] or resultarr[-1]>arr[i]:
            if resultarr[0]>arr[i]:
                resultarr.insert(0,arr[i])
                count+=1
            else:
                resultarr.append(arr[i])
                count+=1
                
print(count)