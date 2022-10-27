package BT4;

/* Give a list of integers, how many triples that sum of them equal 0 ? */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeSum
{
    public static int countThreeSum(List <Integer> nums)
    {
        int count = 0;
        Collections.sort(nums);
        for (int first = 0; first < nums.size() - 2; first++) 
        {
            if (first > 0 && nums.get(first) == nums.get(first - 1))
            {
                continue;
            }
            int second = first + 1;
            int last = nums.size() - 1;
            while (second < last)
            {
                int sum = nums.get(first) + nums.get(second) + nums.get(last);
                if (sum == 0)
                {
                    count++;
                    last--;
                    while (second < last && nums.get(last) == nums.get(last + 1))
                    {
                        last--;
                    }
                }
                else if (sum > 0)
                {
                    last--;
                }
                else
                {
                    second++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};
    
        List<Integer> nums = new ArrayList<Integer>();
        for (Integer integer : arr) {
            nums.add(integer);
        }
        System.out.println(countThreeSum(nums));
    }
}
