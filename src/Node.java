/**
 * Created by benya on 20/09/2017.
 */
public class Node {
    public int key;
    public int height;
    public Node parent;
    public Node right;
    public Node left;

    public Node(int key)
    {
        this.key = key;
    }

    public int CalcHeight()
    {
        int RightHeight = 0;
        int LeftHeight = 0;

        if (this.right != null)
            RightHeight += this.right.CalcHeight();
        if (this.left != null)
            LeftHeight += this.left.CalcHeight();

        this.height = 1 + Math.max(RightHeight, LeftHeight);

        return this.height;
    }
}
