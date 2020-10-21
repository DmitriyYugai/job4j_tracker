package ru.job4j.collection;

import ru.job4j.tracker.Item;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String leftTrimmed = left.trim();
        String rightTrimmed = right.trim();
        Pattern p = Pattern.compile("^\\d+");
        Matcher m = p.matcher(leftTrimmed);
        int leftNumber = 0;
        int rightNumber = 0;
        if (m.find()) {
            leftNumber = Integer.valueOf(m.group());
        }
        m.reset(rightTrimmed);
        if (m.find()) {
            rightNumber = Integer.valueOf(m.group());
        }
        return Integer.compare(leftNumber, rightNumber);
    }
}
