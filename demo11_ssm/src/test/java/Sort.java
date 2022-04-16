import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        int[] nums = new int[] {10,9,3,2,4,5,37,100};
        monkeySort(nums);
        System.out.println(Arrays.toString(nums));
        sleepSort(nums);
    }

    public static void monkeySort(int[] nums) {
        //需要将nums打乱,打乱前先将nums转为一个list集合
        List<Integer> integers = Ints.asList(nums);
        out:while (true) {
            Collections.shuffle(integers);
            //判断当前的集合或者数组是否有序，判断前要将list集合转为数据
            int[] result = Ints.toArray(integers);
            for (int i = 0; i < result.length - 1; i++) {
                if (result[i] > result[i + 1]) {
                    continue out;
                }
            }
            //证明了result是有序的
            //从哪里来、下标几开始、到那里去、下表几开始、拷贝长度
            System.arraycopy(result,0,nums,0,result.length);
            break;
        }
    }

    /**
     * 多线程同时睡眠排序大法
     * @param nums
     */
    public static void sleepSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            new Thread(()->{
                try {
                    Thread.sleep(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(num);
            }).start();
        }
    }

    //获取邮箱
}
