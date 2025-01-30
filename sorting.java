public class sorting {
    

    public static void sort(int [] nums){

        int s = 0 , m = 0 , e = nums.length -1;

        while(s <=e){
            if(nums[m] ==0){
              int temp = nums[s];
              nums[s] = nums[m];
              nums[m] = temp;
              s++;
              m++;
            }else if(nums[m] ==1){
              m++;
            }else {
                int temp = nums[e];
                nums[e] = nums[m];
                nums[m] = temp;
                s++;
                e--;
            }
        }
    }
}
