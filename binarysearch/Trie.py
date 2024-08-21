class Node(object):
    def __init__(self, key, has_end=False):
        self.key = key
        self.children = dict()

class Trie(object):
	# 최초 생성 시 헤드 노드 생성
    def __init__(self):
        self.head = Node(None)
    
    # 트라이에 문자열 삽입
    def insert(self, string):
        curr_node = self.head
        
        for char in string:
            # 현재 노드에 해당하는 글자의 자식이 없다면 추가
            if curr_node.children.get(char) is None:
                curr_node.children[char] = Node()
            # 다음 노드로 이동
            curr_node = curr_node.children[char]
        # 반복 종료 후 단어의 끝 표시
        curr_node.is_termianl = True
        
    def print_data(self):
        curr_node = self.head
        while curr_node.children:
            print(curr_node.children.items)

trie = Trie()
data = []

for d in data:
    trie.insert(d)

