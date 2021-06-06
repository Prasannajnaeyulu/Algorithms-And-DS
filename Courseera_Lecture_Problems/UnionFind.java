/**
 * Union Find Data Type which represents the Objects of a component (a.k.a set)
 * and provides operations like find and union to operate on the component Objects
 */
class UnionFind {
    int[] id;

    UnionFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    /**
     * Find the component(a.k.a set) of object 'a'
     *
     * @param a - Object to find
     * @return the component Id the element belongs to
     */
    int find(int a) {
        return id[a];
    }

    /**
     * check whether a and b are connected or not
     *
     * @param a - Object a
     * @param b - Object b
     * @return true if a and b are in same component(a.k.a set) false otherwise
     */
    boolean connected(int a, int b) {
        return id[a] == id[b];
    }

    /**
     * merge the two components(a.k.a sets) of a and b into one
     *
     * @param a - element to union with b
     * @param b - element to union with a
     */
    union(int a, int b) {
        int a_componetId = find(a);
        int b_componetId = find(b);
        for (int i = 0; i < N; i++) {
            if (id[i] == a_componetId)
                id[i] = b_componetId;
        }
    }
}
