def up(n):#n만큼움직이면됨
    global count
    if now_row-n<0:#벗어나면
        return False
    else:#벗어나지 않으면
        count+=1
        move()
def down(n):

def left(n):

def right(n):

def move():
    global count
    global now_row
    global now_col
    temp=row_arr[now_row][now_col]#temp는 격자 바로 밑
    up(temp)
    down(temp)
    left(temp)
    right(temp)

row, col= map(int,input().split())
row_arr=[]
for i in range(row):
    row_arr.append(list(input()))
print(row_arr)
if(row_arr[0][1]=='H'):
    print("true")
now_row=0
now_col=0
count=0

