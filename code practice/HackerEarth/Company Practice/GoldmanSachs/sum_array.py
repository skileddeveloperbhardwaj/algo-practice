#This program calculates sum array that stores for each i in sum array the sum minus arr[i]
def SumArray(arr,n):
    sumArr = [None]*n
    sum = 0
    for i in range(0,n):
        sum = sum+arr[i]
    for i in range(0,n):
        sumArr[i] = sum-arr[i]
        print(sumArr[i],end=" ")
	
sumArray([3,6,4,8,9],5)