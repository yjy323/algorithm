steps = [(1, 2), (1, -2), (-1, 2), (-1, -2), (2, 1), (2, -1), (-2, 1), (-2, -1)]

data = input()
row = ord(data[0]) - ord('a') + 1
col = int(data[1])

count = 0
for step in steps:
	nx = row + step[0]
	ny = col + step[1]
	if 1 <= nx <= 8 and 1 <= ny <= 8:
		count += 1
print(count)
