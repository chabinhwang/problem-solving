size=int(input())
arr=[0 for _ in range(size)]
arr[0]=1#Duck
i=0#Duck위치index
arr[-1]=1#Goose
k=size-1#Goose위치index
while True:
    if i==0:
        if arr[1]==1:
            print("Duck")
            break
        else:#duck를1로이동
            arr[0]=0
            arr[1]=1
            i=1
    elif i>=1:
        if arr[i+1]==1:#적만나면
            print("Duck")
            break
        if (k-i)%2==1:#홀수거리
            arr[i]=0
            i+=1
            arr[i]=1
        else:#짝수거리
            if k>=size-2:#상대 뒤에1칸이하
                arr[i]=0
                i+=1
                arr[i]=1
            else:
                arr[i]=0
                i-=1
                arr[i]=1
            
    if k==size-1:
        if arr[-2]==1:
            print("Goose")
            break
        else:#Goose1칸이동
            arr[-1]=0
            arr[-2]=1
            k=size-2
    elif k<=size-2:
        if arr[k-1]==1:#적만나면
            print("Goose")
            break
        if(k-1)%2==1:#홀수거리
            arr[k]=0
            k-=1
            arr[k]=1
        else:#짝수거리
            if i<=2:#상대 뒤에 1칸이하
                arr[k]=0
                k-=1
                arr[k]=1
            else:
                arr[k]=0
                k+=1
                arr[k]=1