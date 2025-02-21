# cmp_to_py 연습
from functools import cmp_to_key
def compare(n1, n2):
    return -1 if n1 + n2 > n2 + n1 else 1
input()
numbers=list(map(str,input().split()))
numbers.sort(key=cmp_to_key(compare)) 
print('0' if numbers[0]=='0' else "".join(numbers))