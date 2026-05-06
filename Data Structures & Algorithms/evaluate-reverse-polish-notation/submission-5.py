class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        sta = []

        for t in tokens:
            if t in "+*/-":
                b = int(sta.pop())
                a = int(sta.pop())
                if t == "+":
                    sta.append(a+b)
                elif t == "-":
                    sta.append(a-b)
                elif t == "*":
                    sta.append(a*b)
                elif t == "/":
                    sta.append(int(a/b))
            else:
                sta.append(t)

        return int(sta.pop())