def remove_edge(arr):#자기 자리에 있는 가장자리 덩어리 없에기
    global remainN
    if arr[0][1]-1==arr[0][2]:
        remainN-=arr[0][2]+1
        arr.pop(0)
    if arr[-1][1]-1==arr[-1][2] and len(arr)!=0:
        remainN-=arr[-1][1]-arr[-1][0]+1
        arr.pop()

def change_all(arr):
    global remainN
    for i in range(len(arr)):
        arr[i][2]=remainN-1-arr[i][2]+abs(arr[i][1]-arr[i][0])
        arr[i][0],arr[i][1]=arr[i][1],arr[i][0]
        
def change_two(arr,a):#여기서 a는 앞쪽 두 덩어리인지 뒤쪽 두 덩어린지 알려줌. 앞인경우0 뒤인경우1
    if a==0:
        length=arr[1][2]#length는 돌릴 덩어리들 총 길이
        arr[1][2]=length-arr[1][2]+abs(arr[1][1]-arr[1][0])
        arr[1][0],arr[1][1]=arr[1][1],arr[1][0]
        arr[0][2]=length-arr[0][2]+abs(arr[0][1]-arr[0][0])
        arr[0][0],arr[0][1]=arr[0][1],arr[0][0]
    elif a==1:
        first_index=arr[0][2]+1#처음 시작 칸 인덱스
        arr[2][0],arr[2][1]=arr[2][1],arr[2][0]
        arr[1][0],arr[1][1]=arr[1][1],arr[1][0]
        arr[2][2]=first_index+abs(arr[2][0]-arr[2][1])
        arr[1][2]=arr[2][2]+abs(arr[1][0]-arr[1][1])+1
def change_one(arr,a):#a는 0,1,2중 하나. 몇번째 덩어리를 뒤집을지 생각하기
    arr[a][0],arr[a][1]=arr[a][1],arr[a][0]#한덩어리만 뒤집으므로 이게 끝
def arr_print_012(arr):
    if len(arr)==0:#모든게 정배열이여서 arr이 없어진경우
        print(1,1)
    elif len(arr)==1:#덩어리가 한개 인 경우
        print(arr[0][1],arr[0][0])
    elif arr[1][1]+1==arr[0][1]:#case:10 6,1 5
        print(arr[1][0],arr[1][1])
    elif arr[1][0]+1==arr[0][0]:#case:6 10,5 1
        print(arr[0][0],arr[0][1])
        
    
import copy as cp
#https://www.acmicpc.net/problem/2505
n=int(input())
arr=[]#[연속된 숫자 첫번째수, 마지막 수 ,마지막 수 실제 위치 인덱스]
temparr=[]
temp=list(map(int,input().split()))
for i in range(len(temp)):
    if len(temparr)==0:#temparr이 비어있으면, input값 추가
        temparr.append(temp[i])
    elif temparr[-1]-temp[i]==1 or temp[i]-temparr[-1]==1:#input값이 연속될경우
        temparr.append(temp[i])
    else:#다른 묶음일 경우
        arr.append([temparr[0],temparr[-1],i-1])
        temparr=[]
        temparr.append(temp[i])
arr.append([temparr[0],temparr[-1],len(temp)-1])
remainN=n#remainN으로 남은 수의 갯수 파악
#숫자 덩어리(arr에 들어있는 크기)가 몇개인지 확인해서, 3개일때~1개일때로 나눠야함.
arr=sorted(arr,key=lambda x:x[2])#인덱스순(3열)으로 정렬
#뒤집는거 역산 구현, 이때, 다뒤집기-하나뒤집기, 다뒤집기-두개뒤집기...등 전부 구현해야함

remove_edge(arr)
if len(arr)<3:
    if len(arr)==0:#모든게 정배열이여서 arr이 없어진경우
        print(1,1)
        print(1,1)
    elif len(arr)==1:#덩어리가 한개 인 경우
        print(arr[0][1],arr[0][0])
        print(1,1)
    elif len(arr)==2:#시작과 끝을 맞추기
        if arr[0][0]+1==arr[1][1]:#case:5 1, 10 6
            print(arr[0][1],arr[0][0])
            print(arr[1][1],arr[1][0])
    elif arr[1][1]+1==arr[0][1]:#case:10 6,1 5
        print(arr[1][0],arr[1][1])
        print(1,n)
    elif arr[1][0]+1==arr[0][0]:#case:6 10,5 1
        print(arr[0][0],arr[0][1])
        print(1,n)
# elif len(arr)==3:#뒤집어서 이어지는 수를 만들 수 있는지 확인, 왼편-오른편 끼리만 만들어짐
#                  #예를들어, 678/21/543의 경우: 6은 2와 5만 비교. 8은 1과 3만 비교.
#         if abs(arr[0][0]-arr[1][0])==1:
#
#         elif abs(arr[1][0]-arr[2][0])==1:
#
#         elif abs(arr[0][0]-arr[2][0])==1:
            