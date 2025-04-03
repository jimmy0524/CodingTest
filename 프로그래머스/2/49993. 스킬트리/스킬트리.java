class Solution {
    public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            for (String tree : skill_trees) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < tree.length(); i++) {
                    if (skill.contains(String.valueOf(tree.charAt(i)))) {
                        sb.append(tree.charAt(i));
                    }
                }
                if (skill.startsWith(sb.toString())) {
                    answer++;
                }
             }
        return answer;
        }
}