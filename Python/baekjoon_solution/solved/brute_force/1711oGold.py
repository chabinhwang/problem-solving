dotcount=int(input())
arr=[]
for i in range(dotcount):
    arr.append(list(map(int,input().split())))
arr_steepness=[]
#i점과 k, j점으로 직각삼각형이 만들어지는지(만들어지면 카운트)
count=0
for i in range(len(arr)-2):#arr[i][0] arr[i][1]
    for k in range(i+1,len(arr)-1):#arr[k][0] arr[k][1]
        for j in range(k+1,len(arr)):#arr[j][0] arr[j][1]
            a=(arr[k][0]-arr[i][0])**2+(arr[k][1]-arr[i][1])**2
            b=(arr[j][0]-arr[i][0])**2+(arr[j][1]-arr[i][1])**2
            c=(arr[k][0]-arr[j][0])**2+(arr[k][1]-arr[j][1])**2
            if a==b+c or b==a+c or c==a+b:
                count+=1
print(count)