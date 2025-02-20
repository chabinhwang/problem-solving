"""
sol : - 다음부터 나오는 모든 숫자와 +를 한 괄호에 묶음. -나올때까지 묶음.
만약 15+12+234-12-235+122-23+12일 경우
15+12+234-(12)-(235+122)-(23+12)
"""

a=input()
temp=''
result=0
m_flag=False

for i in a:
    if i == '-': # -가 뜬 경우
        # print("-기호")
        if not m_flag: # 처음 -인 경우 : 앞에 것 까진 더하고, 앞으로 전부 빼기임
            result+=int(temp)
            temp=''
            m_flag=True
        else:
            result-=int(temp)
            temp=''
    elif i== '+' : 
        if m_flag: # -가 떴으면서 +가 보인 경우 : 빼기
            result-=int(temp)
            temp=''
        else: # -가 한번도 안떴으면서 +가 보인 경우 : 더하기
            # print("+기호")
            result+=int(temp)
            temp=''
    else:
        temp=temp+i
        # print(temp)
    # print(f"result : {result}")
if m_flag: # - 가 한번 뜬 경우
    result-=int(temp)
else:
    result+=int(temp)
# print(f"final result : {result}")
print(result)