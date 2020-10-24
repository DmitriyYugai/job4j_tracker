package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        Function<Attachment, Boolean> function = new Function<>() {
            @Override
            public Boolean apply(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        return filter(list, function);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Function<Attachment, Boolean> function = new Function<>() {
            @Override
            public Boolean apply(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return filter(list, function);
    }

    private static List<Attachment> filter(List<Attachment> list,
                                           Function<Attachment, Boolean> attachment) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (attachment.apply(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}
