listx=[1,0]
listy=[0,1]
days,ttuk=map(int, input().split())
for i in range(2,days):#index는 1적음
    listx.append(listx[i-1]+listx[i-2])
    listy.append(listy[i-1]+listy[i-2])
x=listx[-1]
y=listy[-1]
if x>y:
    max=x
    min=y
else:
    max=y
    min=x
boundary=ttuk//max#부정방정식범위
boundarymin=ttuk//min
firstday=0
secondday=0
for i in range(boundary):
    if (ttuk-i*max)%min==0:
        firstday=i
        secondday=(ttuk-i*max)//min

print(secondday)
print(firstday)