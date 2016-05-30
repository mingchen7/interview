'''
Created on Oct 16, 2015

@author: matthew
'''

class Solution(object):
    def evalRPN(self, tokens):
        stack = []
        leng = len(tokens)
        for i in range(leng):
            tmp = tokens[i]
            if tmp.isdigit() == True:
                stack.append(int(tmp))
            elif len(tmp) > 1: # more than 1 char
                tmpSuffix = tmp[1:len(tmp)]
                if tmpSuffix.isdigit() and tmp[0] in ['+','-']:
                    if tmp[0] == '+':
                        value = int(tmpSuffix)
                    elif tmp[0] == '-':
                        value = -1* int(tmpSuffix)
                    stack.append(value)
                else:
                    return -99
            else:
                if len(stack) >= 2:
                    opB = stack.pop()
                    opA = stack.pop()
                else:
                    return -99
                if tokens[i] == '+':
                    rslt = opA + opB
                elif tokens[i] == '-':
                    rslt = opA - opB
                elif tokens[i] == '*':
                    rslt = opA * opB
                elif tokens[i] == '/':
                    rslt = int(round(float(opA) / float(opB)))
                else:
                    print "Invalid Operator"
                    return -99
                stack.append(rslt)
        
        if(len(stack) == 1):
            return stack.pop()
        else:
            return -99

s = Solution()
str = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
print(s.evalRPN(str))        
        
