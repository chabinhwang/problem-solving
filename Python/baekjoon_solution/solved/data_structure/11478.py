from sys import stdin
def input():
    return stdin.readline().rstrip()
arr=list(input())
size=len(arr)
length=0
resultset=set()
while True:
    length+=1
    for i in range(size+1-length):
        resultset.add("".join(arr[i:i+length]))
    if length==size:
        break
print(len(resultset))