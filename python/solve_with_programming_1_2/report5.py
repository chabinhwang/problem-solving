arr=[50,10,40,20,30]
print("정렬이전: ",arr,"\n")
for i in range(len(arr)):
    for k in range(i):
        if(arr[i]<arr[k]):
            arr.insert(k,arr.pop(i))
            print(f"{i}단계 후: ",arr,"\n")