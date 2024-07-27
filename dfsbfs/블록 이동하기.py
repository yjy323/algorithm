'''
	1회 20240725
	2회 20240725
	3회

	아이디어
		1.
'''
from collections import deque

def check_next_pos(board, pos):
    next_pos = []
    dx = (1, 0, -1 ,0)
    dy = (0, 1, 0, -1)
    
    left, right = pos
    lx, ly = left
    rx, ry = right
    for i in range(4):
          nlx, nly, nrx, nry = lx + dx[i], ly + dy[i], rx + dx[i], ry + dy[i]
          if board[nlx][nly] == 0 and board[nrx][nry] == 0:
              next_pos.append({(nlx, nly), (nrx, nry)})
    if lx == rx:
        for i in [-1, 1]:
            if board[lx + i][ly] == 0 and board[rx + i][ry] == 0:
                next_pos.append({(lx, ly), (lx + i, ly)})
                next_pos.append({(rx, ry), (rx + i, ry)})
    if ly == ry:
        for i in [-1, 1]:
            if board[lx][ly + i] == 0 and board[rx][ry + i] == 0:
                next_pos.append({(lx, ly), (lx, ly + i)})
                next_pos.append({(rx, ry), (rx, ry + i)})
    return next_pos

def process(board, n):
    pos = {(1, 1), (1, 2)}
    q = deque([(pos, 0)])
    visited = [pos]
    
    while q:
        pos, cost = q.popleft()
        if (n, n) in pos:
            return cost
        for next_pos in check_next_pos(board, pos):
            if next_pos not in visited:
                visited.append(next_pos)
                q.append((next_pos, cost + 1))
    return -1
        

def solution(board):
    n = len(board)
    padding_board = [[1] * (n + 2) for _ in range(n + 2)]
    for i in range(n):
        for j in range(n):
            padding_board[i + 1][j + 1] = board[i][j]
    answer = process(padding_board, n)
    return answer

print(solution([[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]))
