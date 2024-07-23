'''
	1회 20240723
	2회
	3회

	아이디어
		1.
'''

def is_good(p):
    cnt = 0
    for c in p:
        if c == '(':
            cnt += 1
        else:
            cnt -= 1
    return True if cnt == 0 else False

def is_perfect(p):
    stack = []
    for c in p:
        if c == '(':
            stack.append(c)
        elif len(stack) > 0 and stack[-1] == '(':
            stack.pop()
        else:
            stack.append(c)
    return True if len(stack) == 0 else False


def dfs(w):
    if w == '':
        return ['']
    elif is_perfect(w):
        return w
    else:
        for i in range(2, len(w) + 1, 2):
            u = w[:i]
            v = w[i:]
            if is_perfect(u):
                u.extend(dfs(v))
                if is_perfect(u):
                       return u
            elif is_good(u):
                p = ['(']
                p.extend(dfs(v))
                p.append(')')
                u.pop()
                u.pop(0)
                for c in u:
                    if c == '(':
                        p.append(')')
                    else:
                        p.append('(')
                if is_perfect(p):
                       return p

def solution(p):
    list_p = dfs(list(p))
    return ''.join(list_p)
