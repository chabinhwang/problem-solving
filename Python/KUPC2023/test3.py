layer,num=map(int,input().split())
def get_divisor(n):#약수구하는 함수
    n = int(n)
    divisors = []
    divisors_back = [] 

    for i in range(1, int(n**(1/2)) + 1): 
        if (n % i == 0):            
            divisors.append(i)
            if (i != (n // i)): 
                divisors_back.append(n//i)

    return divisors + divisors_back[::-1]
#약수 갯수 홀수짝수 나누고, 숫자갯수가 num갯수랑같아지면바로종료?
#약수갯수재귀
def aaa(arr):
    temp=[]
    if len(arr)%2==1:
        for k in range(len(arr)//2):#가운데거빼고
