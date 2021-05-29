class EvenNumDigits{
    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int num:nums){
            int digits = 0;
            while(num/10!=0){
                num = num/10;
                digits++;
            }
            digits+=1;
            if(digits%2==0)
                count+=1;
        }
        return count;
    }

    public static void main(String... args){
//        int[] nums = {12,345,2,6,7896};
        int[] nums = {555,901,482,1771};
        System.out.println(findNumbers(nums));
    }
}