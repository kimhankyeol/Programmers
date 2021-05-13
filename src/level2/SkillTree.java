package level2;

import java.util.*;

class SkillTree {
    static private String skill = "BCD";
    static private String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

    public static void main(String[] args) {
        solution();
    }
    public static int solution() {

        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        //ArrayList<String> skillTrees = new ArrayList<String>();
        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
            if (skill.indexOf(it.next().replaceAll( skill , "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        System.out.println(answer);
        return answer;
    }

}


