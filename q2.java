import java.util.*;

public class q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        TreeSet<Integer> nums = new TreeSet<>();

        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            nums.add(val);
        }

        System.out.println("Numbers in unique and sorted order");
        System.out.println(nums);
    }
}
