from math import gcd
def fin(i):#i번째 재료를 의미함
    i
n=int(input())
result_arr=[1]*n
arr=[]
for i in range(n-1):
    arr.append(list(map(int,input().split())))
print(result_arr)
for i in range(n-1):
    temp_a=result_arr[arr[i][0]]*arr[i][2]
    temp_b=result_arr[arr[i][1]]*arr[i][3]
    result_arr[arr[i][0]]*=result_arr[arr[i][1]]
    result_arr[arr[i][1]]=result_arr[arr[i][0]]
    result_arr[arr[i][0]]*=arr[i][2]
    result_arr[arr[i][1]]*=arr[i][3]
    for j in range(i):
        if arr[j][0]==arr[i][0]:
            result_arr[arr[j][0]]*=temp_a
        if arr[j][1]==arr[i][0]:
            result_arr[arr[j][1]]*=temp_a
        if arr[j][0]==arr[i][1] :
            result_arr[arr[j][0]]*=temp_b
        if arr[j][1]==arr[i][1]:
            result_arr[arr[j][1]]*=temp_b
print(result_arr)
#a,b,p,q일때, a*p b*q를함, 이후, 위 행들을 순차탐색하면서
# a나b와 엮인 식이 있으면, 그 식의 나머지에 똑같은 수 곱해주기
#gcd사용법: result=gcd(*array), result가 최대공약수
