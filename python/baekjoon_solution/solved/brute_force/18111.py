from sys import stdin
def input():
    return stdin.readline().rstrip()
N,M,B=map(int,input().split())
ground_extent=N*M

# height[n]은, 높이 n에 존재하는 블럭. 높이가 7인 좌표에는, height[7]에만 1이 찍히고, 6,5..에는 0
height=[0]*257
ground_block_sum=0
max_height=0 # 블럭이 쌓인 최고 높이
for i in range(N):
    temp_arr=list(map(int,input().split()))
    for j in temp_arr:
        height[j]+=1
        max_height=max(max_height,j)
    ground_block_sum+=sum(temp_arr)

result_max_height=(ground_block_sum+B)//ground_extent #결과로 나올 수 있는 최고 높이
answer_time=float('inf')
answer_height=0

for i in range(result_max_height+1): #계산할 높이들
    remove_time=0
    build_time=0
    for j in range(max_height+1): #j 높이에서, 블럭을 더하고 뺄 때의 소모 시간을 계산해야 
        if height[j]:
            if i>j:
                build_time+=(i-j)*height[j]
            elif j>i:
                remove_time+=2*(j-i)*height[j]
    total_time=build_time+remove_time
    if answer_time>total_time:
        answer_time=total_time
        answer_height=i
    elif answer_time==total_time:
        if answer_height<i:
            answer_height=i
print(answer_time, answer_height)
