class Solution {
    static int answer = 0;
    static int[] numbers;
    static int target;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);
        return answer;
    }
    
    public void dfs(int count, int sum) {
        if (count == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        dfs(count + 1, sum + numbers[count]);
        dfs(count + 1, sum - numbers[count]);
    }
}