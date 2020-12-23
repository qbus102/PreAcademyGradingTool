
package mzaba.epamCourse.lectures.BLF.generics;
import java.util.EnumMap;

record PreAcademyStudent  (String name, EnumMap<Evaluated,Integer> points) implements Comparable<PreAcademyStudent> {


    int calculateTotal(){
        return points.values().stream().reduce(0,Integer::sum);
    }

    @Override
    public int compareTo(PreAcademyStudent student) {
        return Integer.compare(this.calculateTotal(), student.calculateTotal());
    }

    @Override
    public String toString() {
        return "["+name+", "+points.toString()+"   TOTAL SCORE:"+calculateTotal()+"]";
    }

    static PreAcademyStudent newStudent(String name, Integer taskPoints, int quizzesPoints, int activityPoints){
        var points = new EnumMap<Evaluated,Integer>(Evaluated.class);
        points.put(Evaluated.TASKS,taskPoints);
        points.put(Evaluated.QUIZZES,quizzesPoints);
        points.put(Evaluated.ACTIVITY,activityPoints);
        return new PreAcademyStudent(name,points);
    }
}