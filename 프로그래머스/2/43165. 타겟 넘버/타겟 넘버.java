class Solution {
    static int count;
    
    public int solution(int[] numbers, int target) {
        back(0, numbers, 0, target);
        
        return count;
    }
    
    public void back(int index, int[] numbers, int temp, int target) {
        if (index == numbers.length) {
            if (temp == target) {
                count++;
            }
            return;
        }
        back(index + 1, numbers, temp + numbers[index], target);
        back(index + 1, numbers, temp - numbers[index], target);
    }
}