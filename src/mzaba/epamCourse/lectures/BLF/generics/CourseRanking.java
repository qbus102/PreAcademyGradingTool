package mzaba.epamCourse.lectures.BLF.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class CourseRanking {

    private final ArrayList<PreAcademyStudent> courseList;
    private final GradingSystem gradingSystem;


    CourseRanking(List<PreAcademyStudent> courseList, GradingSystem gradingSystem) {
        this.courseList = new ArrayList<>(courseList);
        this.gradingSystem = gradingSystem;
    }

    public static void main(String[] args) {
        var fileReader = new InputFileReader("./files/preAcademyStudents.csv");
        var sortingOrder = getSortingOrder();
       // var fileReader = new InputFileReader(args[0]);
       // var sortingOrder = SortingSystem.valueOf(args[1]);
        var preAcademyStudents = fileReader.readFile();
        var courseResults = new CourseRanking(preAcademyStudents, new GradingSystem() );
        System.out.println("PreAcademy Students Sorted by "+sortingOrder.toString()+":");
        courseResults.sort(sortingOrder).forEach(System.out::println);
    }

    private static SortingSystem getSortingOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You can sort the list by:");
        Stream.of(SortingSystem.values()).forEach(System.out::println);
        System.out.print("What sorting order do you want to choose: ");
        return SortingSystem.valueOf(scanner.nextLine().toUpperCase());
    }

    ArrayList<PreAcademyStudent> sort(SortingSystem sortMethod){
        return switch (sortMethod) {
            case TOTAL_ASC -> gradingSystem.sortListByTotalPointsAsc(courseList);
            case TOTAL_DESC -> gradingSystem.sortListByTotalPointsDesc(courseList);
            case TASKS_ASC -> gradingSystem.sortStudentsListByTaskPointsAsc(courseList);
            case TASKS_DESC -> gradingSystem.sortStudentsListByTaskPointsDesc(courseList);
            case QUIZZES_ASC -> gradingSystem.sortStudentsListByQuizzesPointsAsc(courseList);
            case QUIZZES_DESC -> gradingSystem.sortStudentsListByQuizzesPointsDesc(courseList);
            case ACTIVITY_ASC -> gradingSystem.sortStudentsListByActivityPointsAsc(courseList);
            case ACTIVITY_DESC -> gradingSystem.sortStudentsListByActivityPointsDesc(courseList);
        };
    }

}