package UnionFind;

import mytool.Stdin;

public class QuickUnion
{
    private int[] id;
    private int count;

    public QuickUnion(int n)
    {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
        {
            id[i] = i;
        }
    }
    public int count()
    {
        return count;
    }

    public int find(int p)
    {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q)
    {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        id[pRoot] = qRoot;

        count--;

    }

    public boolean connected(int p, int q)
    {
        //return id[p] == id[q];
        return find(p) == find(q);
    }
    public static void main(String[] args)
    {
        int n = Stdin.readInt();
        QuickUnion uf = new QuickUnion(n);
        while (!Stdin.isEmpty())
        {
            int p = Stdin.readInt();
            int q = Stdin.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + " components");
    }
}
