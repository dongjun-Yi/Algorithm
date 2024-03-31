class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        table = {
            ')' : '(',
            '}' : '{',
            ']' : '['
        }

        for x in s:
            if x not in table:
                stack.append(x)
            else:
                if stack:
                    if table[x] != stack.pop():
                        return False
                else:
                    return False

        return len(stack) == 0