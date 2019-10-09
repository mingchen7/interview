class UnionFind(object):

    def __init__(self, labels):
        self.father = {}
        for x in labels:
            self.father[x] = x

    # amortized time complexity O(1)
    def compress_find(self, x):
        parent = self.father[x]
        while parent != self.father[parent]:
            parent = self.father[parent]

        while x != self.father[x]:
            next_val = self.father[x]
            self.father[x] = parent
            x = next_val

        return parent

    # amortized time complexity O(1)
    def union(self, x, y):
        father_x = self.compress_find(x)
        father_y = self.compress_find(y)

        if father_x != father_y:
            self.father[father_x] = father_y