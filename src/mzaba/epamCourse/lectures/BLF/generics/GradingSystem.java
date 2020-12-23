package mzaba.epamCourse.lectures.BLF.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

class GradingSystem {

    private final Comparator<PreAcademyStudent> byTaskPoints = Comparator.comparing((PreAcademyStudent::points),
            Comparator.comparingInt(p -> p.get(Evaluated.TASKS)));
    private final Comparator<PreAcademyStudent> byQuizzesPoints = Comparator.comparing((PreAcademyStudent::points),
            Comparator.comparingInt(p -> p.get(Evaluated.QUIZZES)));
    private final Comparator<PreAcademyStudent> byActivityPoints = Comparator.comparing((PreAcademyStudent::points),
            Comparator.comparingInt(p -> p.get(Evaluated.ACTIVITY)));

    ArrayList<PreAcademyStudent> sortListByTotalPointsAsc(ArrayList<PreAcademyStudent>  list){
        return list.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
    }

    ArrayList<PreAcademyStudent> sortListByTotalPointsDesc (ArrayList<PreAcademyStudent>  list){
        var sortedList = sortListByTotalPointsAsc(list);
        Collections.reverse(sortedList);
        return sortedList;
    }

    ArrayList<PreAcademyStudent> sortStudentsListByTaskPointsAsc (ArrayList<PreAcademyStudent>  list){
        return list.stream().sorted(byTaskPoints).collect(Collectors.toCollection(ArrayList::new));
    }

    ArrayList<PreAcademyStudent> sortStudentsListByTaskPointsDesc (ArrayList<PreAcademyStudent>  list){
        return list.stream().sorted((byTaskPoints).reversed()).collect(Collectors.toCollection(ArrayList::new));
    }

    ArrayList<PreAcademyStudent> sortStudentsListByQuizzesPointsAsc (ArrayList<PreAcademyStudent>  list){
        return list.stream().sorted(byQuizzesPoints).collect(Collectors.toCollection(ArrayList::new));
    }

    ArrayList<PreAcademyStudent> sortStudentsListByQuizzesPointsDesc (ArrayList<PreAcademyStudent>  list){
        return list.stream().sorted((byQuizzesPoints).reversed()).collect(Collectors.toCollection(ArrayList::new));
    }

    ArrayList<PreAcademyStudent> sortStudentsListByActivityPointsAsc(ArrayList<PreAcademyStudent>  list){
        return list.stream().sorted(byActivityPoints).collect(Collectors.toCollection(ArrayList::new));
    }

    ArrayList<PreAcademyStudent> sortStudentsListByActivityPointsDesc (ArrayList<PreAcademyStudent>  list){
        return list.stream().sorted((byActivityPoints).reversed()).collect(Collectors.toCollection(ArrayList::new));
    }
}