package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        int select = 0;
        boolean run = true;
        while (run) {
            showMenu();
            try {
                select = input.askInt("Select: ");
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод.");
                continue;
            }
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Заявка успешно добавлена");
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] items = tracker.findAll();
                for (int index = 0; index < items.length; index++) {
                    System.out.println("" + (index + 1) + ". " + items[index]);
                }
                System.out.println();
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                int id = input.askInt("Enter id: ");
                String name = input.askStr("Enter name of the new item: ");
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка успешно обновлена");
                } else {
                    System.out.println("Не удалось обновить заявку");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                int id = input.askInt("Enter id: ");
                if (tracker.delete(id)) {
                    System.out.println("Заявка успешно удалена");
                } else {
                    System.out.println("Не удалось удалить заявку");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                int id = input.askInt("Enter id: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
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
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

}
