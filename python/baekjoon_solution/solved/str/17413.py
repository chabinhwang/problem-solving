flag = False
temp = ""
string = input()
strlist = []
for i in string:
    if i == "<":# 앞부분은 문자일 것 이므로 뒤집어야함
        flag = True
        temp = temp[::-1]
        strlist.append(temp)
        temp = i
    elif i == ">":
        flag = False
        temp += i
        strlist.append(temp)
        temp = ""
    elif flag:  # 태그 내부임
        temp += i
    elif not flag:  # 태그 내부가 아님
        if i == " ":  # 띄어쓰기 인 경우 - 단어의 끝
            temp = temp[::-1]
            temp+=i
            strlist.append(temp)
            temp=""
        else : # 띄어쓰기가 아닌 경우
            temp+=i

if not flag: # 마지막이 문자인 경우     
    temp = temp[::-1]
    strlist.append(temp)

print(''.join(strlist))