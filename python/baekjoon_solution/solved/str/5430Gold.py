from sys import stdin


def input():
    return stdin.readline().rstrip()


T = int(input())
result = []
for _ in range(T):
    func = list(input())
    input()
    temp = input()
    temp = temp.replace("[", "").replace("]", "")
    if len(temp) != 0:
        intlist = list(map(int, temp.split(",")))
    else:
        intlist = []
    # print(f"intlist: {intlist}")
    flag = False  # 오류 발생 여부 flag
    reverse_flag = False  # 뒤집었는지 여부 - 뒤집는데 시간 복잡도 N이기에
    for i in func:
        if i == "D":  # 버리기
            if len(intlist) == 0:
                result.append("error")
                flag = True
                break
            else:
                if reverse_flag: # 뒤집었다면
                    intlist.pop(-1)
                else:
                    intlist.pop(0)
        elif i == "R":  # 뒤집기
            reverse_flag = not reverse_flag
    if reverse_flag: # 뒤집었다면
        intlist.reverse()
        
    if len(intlist) != 0:
        result.append(f"[{','.join(map(str,intlist))}]")
    elif not flag and len(intlist) == 0:  # 오류는 발생하지 않았지만 빈 리스트인 경우
        result.append("[]")
print("\n".join(result))
