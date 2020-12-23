package mzaba.epamCourse.lectures.BLF.generics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.stream.Stream;


class PreAcademyStudentTest {


    private static final PreAcademyStudent BASIC_STUDENT = createStudent("John Java", 50, 150, 50);
    private static final PreAcademyStudent STUDENT_ANNA = createStudent("Anna Lambda", 26, 130, 12);
    private static final PreAcademyStudent STUDENT_ROBERT = createStudent("Robert Enum", 41, 152, 84);
    private static final PreAcademyStudent STUDENT_ALAN = createStudent("Alan Map", 48, 164, 92);
    private static final PreAcademyStudent STUDENT_CHARLES = createStudent("Charles Stream", 52, 141, 5);
    private static final PreAcademyStudent STUDENT_CHRIS = createStudent("Chris Record", 66, 158, 67);
    private static final PreAcademyStudent STUDENT_EVA = createStudent("Eva Set", 49, 164, 28);
    private static final ArrayList<PreAcademyStudent> TEST_STUDENT_LIST = createTestList();


    static ArrayList<PreAcademyStudent> createTestList() {
        var testList = new ArrayList<PreAcademyStudent>();
        testList.add(STUDENT_ANNA);
        testList.add(STUDENT_ROBERT);
        testList.add(STUDENT_ALAN);
        testList.add(STUDENT_CHARLES);
        testList.add(STUDENT_CHRIS);
        testList.add(STUDENT_EVA);
        return testList;
    }


    private static PreAcademyStudent createStudent(String name, int tasksPoints, int quizzesPoints, int activityPoints) {
        var points = new EnumMap<Evaluated, Integer>(Evaluated.class);
        points.put(Evaluated.TASKS, tasksPoints);
        points.put(Evaluated.QUIZZES, quizzesPoints);
        points.put(Evaluated.ACTIVITY, activityPoints);
        return new PreAcademyStudent(name, points);
    }

    static Stream<PreAcademyStudent> allStudentsForTests() {
        return TEST_STUDENT_LIST.stream();
    }

    @ParameterizedTest
    @MethodSource("allStudentsForTests")
    void calculateTotalShouldReturnCorrectSum(PreAcademyStudent student) {
        var expected = student.points().get(Evaluated.TASKS)
                + student.points().get(Evaluated.QUIZZES)
                + student.points().get(Evaluated.ACTIVITY);
        assertEquals(expected, student.calculateTotal());
    }

    @ParameterizedTest
    @MethodSource("allStudentsForTests")
    void compareToShouldReturnZeroForTheSameStudent(PreAcademyStudent student){
        assertTrue(student.compareTo(student)==0);
    }

    static Stream<PreAcademyStudent> compareToShouldReturnNegativeForStudentWithGreaterTotal(){
        return TEST_STUDENT_LIST.stream().filter(student -> student.calculateTotal()>BASIC_STUDENT.calculateTotal());
    }

    @ParameterizedTest
    @MethodSource()
    void compareToShouldReturnNegativeForStudentWithGreaterTotal(PreAcademyStudent student){
        assertTrue(BASIC_STUDENT.compareTo(student)==-1);
    }

    static Stream<PreAcademyStudent> compareToShouldReturnPositiveForStudentWithFewerTotal(){
        return TEST_STUDENT_LIST.stream().filter(student -> student.calculateTotal()<BASIC_STUDENT.calculateTotal());
    }

    @ParameterizedTest
    @MethodSource()
    void compareToShouldReturnPositiveForStudentWithFewerTotal(PreAcademyStudent student){
        assertTrue(BASIC_STUDENT.compareTo(student)==1);
    }


}