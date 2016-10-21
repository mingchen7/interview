class UnionFind {
    HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
    UnionFind(HashSet<Integer> hashSet)
    {
        for (Integer now : hashSet) {
            father.put(now, now);
        }
    }
    int find(int x)
    {
        int parent = father.get(x);
        while (parent != father.get(parent)) {
            parent = father.get(parent);
        }
        return parent;
    }
    int compressed_find(int x)
    {
        int parent = father.get(x);
        while (parent != father.get(parent)) {
            parent = father.get(parent);
        }
        int next;
        while (x != father.get(x)) {
            next = father.get(x);
            father.put(x, parent);
            x = next;
        }
        return parent;
    }

    void union(int x, int y)
    {
        int fa_x = compressed_find(x);
        int fa_y = compressed_find(y);
        if (fa_x != fa_y)
            father.put(fa_x, fa_y);
    }
}