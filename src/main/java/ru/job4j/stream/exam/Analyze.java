package ru.job4j.stream.exam;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(-1);

    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil -> {
                    double average = pupil.getSubjects().stream()
                            .mapToInt(Subject::getScore)
                            .average()
                            .orElse(-1);
                    return new Tuple(pupil.getName(), Math.round(average));
                })
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.averagingInt(Subject::getScore)))
                .entrySet()
                .stream()
                .map(element -> new Tuple(element.getKey(), element.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> {
                    int sum = pupil.getSubjects().stream()
                            .mapToInt(Subject::getScore)
                            .sum();
                    return new Tuple(pupil.getName(), sum);
                })
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("null", -1));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingInt(Subject::getScore)))
                .entrySet()
                .stream()
                .map(element -> new Tuple(element.getKey(), element.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("null", -1));
    }

}
