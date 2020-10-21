package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void whenAscByName() {
        Comparator<Job> comp = new JobAscByName();
        int rsl = comp.compare(new Job("xxxcve", 2), new Job("xxxcvf", 6));
        assertEquals(rsl, -1);
    }

    @Test
    public void whenDescByName() {
        Comparator<Job> comp = new JobDescByName();
        int rsl = comp.compare(new Job("xxxcve", 2), new Job("xxxcvf", 6));
        assertEquals(rsl, 1);
    }

    @Test
    public void whenAscByPriority() {
        Comparator<Job> comp = new JobAscByPriority();
        int rsl = comp.compare(new Job("xxxcve", 2), new Job("xxxcvf", 6));
        assertEquals(rsl, -1);
    }

    @Test
    public void whenDescByPriority() {
        Comparator<Job> comp = new JobDescByPriority();
        int rsl = comp.compare(new Job("xxxcve", 2), new Job("xxxcvf", 6));
        assertEquals(rsl, 1);
    }

    @Test
    public void whenDescByNameAndAscByPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDescByPriorityAndAscByName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 5),
                new Job("Impl ta", 5)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenAscByNameAndDescByProrityWithCollection() {
        List<Job> jobs = Arrays.asList(
                new Job("fff", 5),
                new Job("ccc", 5),
                new Job("fff", 1),
                new Job("ddd", 5),
                new Job("fff", 3),
                new Job("eee", 5)
        );
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("ccc", 5),
                new Job("ddd", 5),
                new Job("eee", 5),
                new Job("fff", 5),
                new Job("fff", 3),
                new Job("fff", 1)
        );
        Collections.sort(jobs, cmpNamePriority);
        assertThat(jobs, is(expected));
    }

    @Test
    public void whenAscByPriorityAndDescByNameWithCollection() {
        List<Job> jobs = Arrays.asList(
                new Job("fff", 5),
                new Job("ccc", 5),
                new Job("fff", 1),
                new Job("ddd", 5),
                new Job("fff", 3),
                new Job("eee", 5)
        );
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("fff", 1),
                new Job("fff", 3),
                new Job("fff", 5),
                new Job("eee", 5),
                new Job("ddd", 5),
                new Job("ccc", 5)
        );
        Collections.sort(jobs, cmpNamePriority);
        assertThat(jobs, is(expected));
    }
}