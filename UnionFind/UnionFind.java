package UnionFind;

import mytool.Stdin;

public class UnionFind
{
    private int[] id;
    private int count;
    public UnionFind(int n)
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
        return id[p];
    }

    public void union(int p, int q)
    {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        for (int i = 0; i < id.length; i++)
        {
            if (id[i] == pId)
            {
                id[i] = qId;
            }
        }

        count--;

    }

    public boolean connected(int p, int q)
    {
        return id[p] == id[q];
    }
    public static void main(String[] args)
    {
        int n = Stdin.readInt();
        UnionFind uf = new UnionFind(n);
        while(!Stdin.isEmpty())
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
