import java.util.Queue;

/**
 * Created by benya on 20/09/2017.
 */
public class AVLTree {

    public Node treeRoot;

    public AVLTree()
    {
        this.treeRoot = null;
    }

    public void Insert(int key)
    {
        if (this.treeRoot == null)
            this.treeRoot = new Node(key);
        else
            this.InsertNode(this.treeRoot, new Node(key));
    }

    private Node InsertNode(Node RootNode, Node NewNode)
    {
        if (RootNode == null){
            RootNode = NewNode;
        }
        else {
            if (RootNode.key > NewNode.key)
            {
                RootNode.left = InsertNode(RootNode.left, NewNode);

                if ((RootNode.left != null && RootNode.right != null) &&
                        (RootNode.left.CalcHeight() - RootNode.right.CalcHeight() == 2))
                    if (RootNode.left.key > NewNode.key)
                        RootNode = RotateLeft(RootNode);
                    else
                        RootNode = DoubleRotateLeft(RootNode);
            }
            else if (RootNode.key < NewNode.key)
            {
                RootNode.right = InsertNode(RootNode.right, NewNode);

                if ((RootNode.right != null && RootNode.left != null) &&
                        (RootNode.right.CalcHeight() - RootNode.left.CalcHeight() == 2))
                    if (RootNode.right.key < NewNode.key)
                        RootNode = RotateRight(RootNode);
                    else
                        RootNode = DoubleRotateRight(RootNode);
            }
            else
            {
                RootNode.key = Math.max(RootNode.left == null ? 0 : RootNode.left.CalcHeight(),
                        RootNode.right == null ? 0 : RootNode.right.CalcHeight()) + 1;
            }
        }

        return RootNode;
    }

    private static Node RotateLeft(Node ToRot)
    {
        Node ToRot2 = ToRot.left;
        ToRot.left = ToRot2.right;
        ToRot2.right = ToRot;
        ToRot.height = Math.max(ToRot.left == null ? 0 : ToRot.left.CalcHeight(), ToRot.right == null ? 0 : ToRot.right.CalcHeight()) + 1;
        ToRot2.height = Math.max(ToRot2.left == null ? 0 : ToRot2.left.CalcHeight(), ToRot.CalcHeight()) + 1;
        return ToRot2;
    }

    private static Node RotateRight(Node ToRot)
    {
        Node ToRot2 = ToRot.right;
        ToRot.right = ToRot2.left;
        ToRot2.left = ToRot;
        ToRot.height = Math.max(ToRot.left == null ? 0 : ToRot.left.CalcHeight(), ToRot.right == null ? 0 : ToRot.right.CalcHeight()) + 1;
        ToRot2.height = Math.max(ToRot2.right == null ? 0 : ToRot2.right.CalcHeight(), ToRot.CalcHeight()) + 1;
        return ToRot2;
    }

    private static Node DoubleRotateLeft(Node ToRot)
    {
        ToRot.left = RotateRight(ToRot.left);
        return RotateLeft(ToRot);
    }

    private static Node DoubleRotateRight(Node ToRot)
    {
        ToRot.right = RotateLeft(ToRot.right);
        return RotateRight(ToRot);
    }

    public String PrintInorder()
    {
        return pPrintInorder(this.treeRoot);
    }

    public String PrintPreorder()
    {
        return pPrintPreorder(this.treeRoot);
    }

    public String PrintPostorder()
    {
        return pPrintPostorder(this.treeRoot);
    }

    private String pPrintInorder(Node Node)
    {
        String strPrint = "";
        if (Node == null)
            return strPrint;

        if (Node.left != null)
            strPrint += pPrintInorder(Node.left);
        strPrint += Node.key;
        if (Node.right != null)
            strPrint += pPrintInorder(Node.right);

        return strPrint;
    }

    private String pPrintPreorder(Node Node)
    {
        String strPrint = "";
        if (Node == null)
            return strPrint;

        strPrint += Node.key;
        if (Node.left != null)
            strPrint += pPrintPreorder(Node.left);
        if (Node.right != null)
            strPrint += pPrintPreorder(Node.right);

        return strPrint;
    }

    private String pPrintPostorder(Node Node)
    {
        String strPrint = "";
        if (Node == null)
            return strPrint;

        if (Node.left != null)
            strPrint += pPrintPostorder(Node.left);
        if (Node.right != null)
            strPrint += pPrintPostorder(Node.right);
        strPrint += Node.key;

        return strPrint;
    }

    public void PrintTreeLevels() {
        Node currNode = this.treeRoot;



        //    TODO: enqueue : key
        //    TODO: enqueue : parent
        //    TODO: enqueue : left
        //    TODO: enqueue : right
        //    TODO: dequeue - 4 times
    }
}
