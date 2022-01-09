package y2021.mockassesment;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
/*
he school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.

The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:

If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
Otherwise, they will leave it and go to the queue's end.
This continues until none of the queue students want to take the top sandwich and are thus unable to eat.

You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the i​​​​​​th sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the j​​​​​​th student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.



Example 1:

Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
Output: 0
Explanation:
- Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
- Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
- Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
- Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
- Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
Hence all students are able to eat.
Example 2:

Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
Output: 3


Constraints:

1 <= students.length, sandwiches.length <= 100
students.length == sandwiches.length
sandwiches[i] is 0 or 1.
students[i] is 0 or 1.
 */
public class Sandwiches {
    public static void main(String... args) {
        Sandwiches app = new Sandwiches();
        System.out.println(app.countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
        System.out.println(app.countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int sand_0 = 0;
        int sand_1 = 0;
        int stud_0 = 0;
        int stud_1 = 0;
        Queue<Boolean> sand = new LinkedList<>();
        Queue<Boolean> stud = new LinkedList<>();

        for (int i:sandwiches)  {
            if (i == 1) {
                sand.add(true);
                sand_1++;
            } else {
                sand.add(false);
                sand_0++;
            }
        }

        for (int i:students)  {
            if (i == 1) {
                stud.add(true);
                stud_1++;
            } else {
                stud.add(false);
                stud_0++;
            }
        }

        if (sand_0 == sandwiches.length) {
            return sandwiches.length - stud_1;
        }

        if (sand_1 == sandwiches.length) {
            return sandwiches.length - stud_0;
        }

        while (true && !sand.isEmpty() && !stud.isEmpty()) {

            boolean currentSand = sand.peek();
            boolean currentStud = stud.peek();
            if(!currentSand && stud_0==0 && stud_1>0) break;
            if(currentSand && stud_1==0 && stud_0>0) break;

            if(currentSand == currentStud) {
                sand.poll();
                stud.poll();
                if (currentSand) {
                    stud_1--;
                    sand_1 --;
                } else {
                    stud_0 --;
                    sand_0--;
                }
            } else {
                stud.add(stud.poll());
            }
        }
        return stud_0+stud_1;
    }
}
