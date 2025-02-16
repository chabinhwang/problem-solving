import sys
ttuk,flag,R=map(int, input().split())
arr=sys.stdin.readline().split()
flagarr=sys.stdin.readline().split()
arr=[int(a) for a in arr]
flagarr=[int(a) for a in flagarr]
arr.sort()
flagarr.sort()
arrarr=[]
for i in range(len(arr)):
    for k in range(1+i,len(arr)):
        arrarr.append(arr[k]-arr[i])
arrarr.sort()

if flagarr[0]*arrarr[0]>R*2:
    print(-1)
else:
    end=0
    resultarr=[]
    for i in range(len(flagarr)):
        for k in range(len(arrarr)):
            resultarr.append(flagarr[i]*arrarr[k])
            if flagarr[i]*arrarr[k]>2*R:
                break
    resultarr.sort()
    for i in range(len(resultarr)):
        if resultarr[i]>2*R:
            end=resultarr[i-1]/2
            break
    if end==0:
        end=resultarr[-1]/2
    print(end)