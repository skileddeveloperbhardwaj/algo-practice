def checkCycles(n,s):
    ff = True
    for i in range(1,n):
        x = int(s[i:]+s[0:i])
        if (x >= int(s)):
            continue
        ff = False
        break
    if(ff):
        print("True")
    else:
        print("False")
s = "123"
checkCycles(len(s),s)