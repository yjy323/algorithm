n, m = map(int, input().split(" "))
x, y, d = map(int, input().split(" "))

directions = [(0, -1), (-1, 0), (0, 1), (1, 0)]
game_map = [list(map(int, input().split(" "))) for _ in range(n)]
visited = [[False for _ in range(m)] for _ in range(n)]
visited[y][x] = True

steps = 1
while True:
	old_d = d
	for i in range(4):
		d = (d + 1) % 4
		nx = x + directions[d][0]
		ny = y + directions[d][1]
		if 0 <= nx < m and 0 <= ny < n and game_map[ny][nx] != 1 and visited[ny][nx] == False:
			visited[ny][nx] = True
			x = nx
			y = ny
			steps += 1
			break
		elif i == 3:
			x -= directions[d][0]
			y -= directions[d][1]
	if game_map[y][x] == 1:
		break

print(steps)
