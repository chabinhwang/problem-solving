n=int(input())
array=[]
array=list(map(int,input().split()))
result=[]
for i in range(6):#5-i만 temparr에 못들어감, 현재 첫번째 면은 i
    arr=[]
    temparr=[]#후보 넣을 배열
    for k in range(6):
        if not(k==5-i or k==i):
            temparr.append([array[k],k])
        #temparr에 i, 5-i빼고 다들어감
    arr.append(array[i])
    for j in range(4):
        for p in range(4):
            if j!=p and temparr[j][1]+temparr[p][1]!=5:
                arr.append(temparr[j][0])
                arr.append(temparr[p][0])
                if n==1:    #n이 1이면, 작은 5면
                    result.append(sum(array)-arr[-1])
                elif n==2:  #n이 2면, 작은3면*8-아래쪽1면
                    result.append(8*(arr[0]+arr[1]+arr[2])-4*(arr[2]))
                else:       #n이 3이상이면
                    result.append(8*(arr[0]+arr[1]+arr[2])-4*(arr[2])+12*(n-
                    2)*(arr[0]+arr[1])-4*arr[1]*(n-2)+(n-2)*(n-2)*5*(arr[0]))
                arr=[]
                arr.append(array[i])
print(min(result))