package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        int select = 0;
        UserAction action = actions[6];
        boolean run = true;
        while (run) {
            showMenu(actions);
            try {
                select = input.askInt("Select: ");
                action = actions[select];
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод.");
                System.out.println();
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Некорректный ввод.");
                System.out.println();
                continue;
            }
            run = action.execute(input, tracker);
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Заявка успешно добавлена");
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] items = tracker.findAll();
        for (int index = 0; index < items.length; index++) {
            System.out.println("" + (index + 1) + ". " + items[index]);
        }
        System.out.println();
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name of the new item: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка успешно обновлена");
        } else {
            System.out.println("Не удалось обновить заявку");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка успешно удалена");
        } else {
            System.out.println("Не удалось удалить заявку");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
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
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowItemsAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }

}
