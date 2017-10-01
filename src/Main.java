import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        final int LOW_LIMIT = 1;
        final int HIGH_LIMIT = 1000;
        final int SIZE = 25;

        int[] Nums = new int[SIZE];
        AVLTree avt = new AVLTree();

        System.out.print("Numbers -> ");

        for( int i =0; i< SIZE; i++)
        {
            int num = (int)(Math.random()*(HIGH_LIMIT - LOW_LIMIT + 1)) + LOW_LIMIT;
            Nums[i]= num;
            if(!(i == SIZE -1)){
                System.out.print(num + ", ");
            }else{
                System.out.println(num + " .");
            }

            avt.Insert(Nums[i]);
        }


        System.out.println(avt.PrintInorder());
        System.out.println(avt.PrintPreorder());
        System.out.println(avt.PrintPostorder());

    }

}
