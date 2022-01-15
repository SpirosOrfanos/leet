package y2022.mid;
//https://leetcode.com/problems/robot-bounded-in-circle/
public class RobotBoundedInCircle {
    public static void main(String... args) {

        //System.out.println(isRobotBounded("GGLLGG"));
        //System.out.println(isRobotBounded("GL"));
       //// System.out.println(isRobotBounded2("GLRLLGLL"));
        System.out.println(isRobotBounded2("GGLLGG"));

        System.out.println(isRobotBounded2("GGRRRRRRRRG"));
    }

    public static boolean isRobotBounded2(String instructions) {
        int dir[][] = {{0,1}, {-1, 0}, {0, -1}, {1,0}};
        int i = 0;
        int x = 0;
        int y = 0;

        for(int s = 0; s < instructions.length(); s++){
            if(instructions.charAt(s) == 'L'){
                i = (i + 1) % 4;
            }
            else if(instructions.charAt(s) == 'R'){
                i = (i + 3) % 4;
            }
            else{
                x = x + dir[i][0];
                y = y + dir[i][1];
            }
        }
        return x == 0 && y == 0 || i != 0;
    }

    public static boolean isRobotBounded(String instructions) {

        int r = 0;
        int rnd = 0;
        for (char c:  instructions.toCharArray()) {
            if (rnd%360==0) rnd = 0;
            if (c == 'L') {
                rnd += 90;
            } else if (c == 'R') {
                rnd -= 90;
            } else {
                 r++;
            }
        }
        if(r == 0) return true;
        if (rnd%360 == 0 && r%2!=0) return false;
        return rnd!=0;
    }
}
