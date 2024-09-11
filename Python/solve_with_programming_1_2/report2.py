arr=[]

def push(pushdata):
    arr.append(pushdata)
    print(f"push({pushdata})")

def pop(i,k):
    if (i==')'and arr[-1]=='{') or (i=='}'and arr[-1]=='('):
        k+=1
    arr.remove(arr[-1])
    print("pop()")
    return k



a=list(input("괄호를 입력하세요 : "))#띄어쓰기로 구분받음

if a[0]=='}'or a[0]==')':
    print("스텍 empty 에러\n프로그램을 종료합니다")

  
    
else:
    k=0         #k라는 판정 변수, 짝이 안맞는 pop일경우 k값1추가
    left=0      #왼쪽괄호 판정변수
    right=0     #오른쪽 괄호 판정변수
    for i in a:    
        if i=='{'or i=='(':
            push(i)
            left+=1
        elif i=='}'or i==')':
            k=pop(i,k)
            right+=1
    if k==0 and left==right:
        print("괄호 짝이 맞습니다")
    else:
        print("괄호의 좌우가 맞지 않습니다.\n괄호 짝이 맞지 않습니다.")
