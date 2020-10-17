package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name of the items searched: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (int index = 0; index < items.length; index++) {
                System.out.println("" + (index + 1) + ". " + items[index]);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        System.out.println();
        return true;
    }
}
