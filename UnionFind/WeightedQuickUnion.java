package unionfind;

import mytool.Stdin;

public class WeightedQuickUnion
{
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnion(int n)
    {
        count = n;
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++)
        {
            id[i] = i;
            sz[i] = 1;
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

        if (sz[pRoot] < sz[qRoot])
        {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else
        {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
 

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
        WeightedQuickUnion uf = new WeightedQuickUnion(n);
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
