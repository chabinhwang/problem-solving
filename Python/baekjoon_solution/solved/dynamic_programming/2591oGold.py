number=input()
intarr=[int(i) for i in number]
count=[0 for _ in range(len(intarr))]
for i in range(len(intarr)):
    if i==0 and intarr[i]==0:
        count[-1]=0
        break
    elif i==0 and intarr[i]!=0:#첫숫자가 0이아니면 count+1
        count[i]+=1
    elif i==1:#i가 1일때
        if intarr[1]==0:#i숫자0일때
            if 35>intarr[0]*10+intarr[1]>0:#앞이랑 만들어질때
                count[i]+=1
            else:#앞이랑 안만들어질때
                count[-1]=0
                break
        else:#i숫자0아닐때
            if 35>intarr[0]*10+intarr[1]>0:#앞이랑 만들어질때
                count[i]+=2
            else:#안만들어질때
                count[i]+=1
            
    elif i>1 and intarr[i]!=0:#i의 숫자가 0이 아닐때d
        if intarr[i-1]==0:#i-1수가 0일때
            count[i]=count[i-1]
        elif intarr[i-1]!=0:#i-1수가 0이 아닐때
            if 35>intarr[i-1]*10+intarr[i]>0:#i과i-1로 카드한장나올때
                count[i]=count[i-2]*2+count[i-1]-count[i-2]
            else:#안나올때
                count[i]=count[i-1]
    elif i>1 and intarr[i]==0:#i의 숫자가 0일때
        if intarr[i-1]==0:#i-1수가 0일때
            count[-1]=0
            break
        elif intarr[i-1]!=0:#i-1수가 0이 아닐때
            if not (34>intarr[i-2]*10+intarr[i-1]>0):#i-2와i-1로 카드1장안만들어질때
                if not (34>intarr[i-1]*10+intarr[i]>0):#i-1과i로 카드못만들때
                    count[-1]=0
                    break
                elif 34>intarr[i-1]*10+intarr[i]>0:
                    count[i]=count[i-1]
            elif 34>intarr[i-2]*10+intarr[i-1]>0:#i-2와i-1로 카드1장 만들어질때
                if intarr[i-1]>3:#40 50이런거못만드니까 x
                    count[-1]=0
                    break             
                else:
                    count[i]=count[i-2]
print(count[-1])





#Sol.1 재귀함수(시간초과)
# number=input()
# intnumarr=[int(i) for i in number]
# count=0
# def auto_pop(arr):
#     arr.pop(0)
#     arr2=arr[:]
#     return arr2
# def main(arr):
#     global count
#     temparr=arr[:]
#     if len(temparr)>=2:#2개이상일때,left right
#         if temparr[0]*10+temparr[1]>34:#두개는안됨, 71번카드 없음
#             main(auto_pop(temparr))
#         elif temparr[0]==0:#앞자리가 0인경우, 05번카드는 없고, 0번카드도없음
#             return
#         elif temparr[1]==0:#뒷자리가 0인경우, 한개는안됨. 20이면 0번카드없음
#             main(auto_pop(auto_pop(temparr)))
#             return
#         else:
#             main(auto_pop(temparr))
#             main(auto_pop(temparr))
#     elif len(temparr)==1:
#         if temparr[0]==0:
#             return
#         else:#빈배열이면 count+1해줌 알아서
#             main(auto_pop(temparr))
#     else:
#         count+=1
# main(intnumarr)
# print(count)