package by.stepanenko.notebook;

import by.stepanenko.notebook.controller.Controller;
import by.stepanenko.notebook.entity.ControllerParams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {


//        Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
//        System.out.println(pattern.matcher("2025-01-65").matches());
//        System.out.println(pattern.matcher("2025-01-651").matches());
//
//        System.out.println(pattern.matcher("dsf sdf sdfd;df ;;f;ds").matches());
//        System.out.println(pattern.matcher("dsf sdf sdfd df fds").matches());

        String response = "";
        String menuItem = "";
        Scanner scanner = new Scanner(System.in);
        Scanner data = new Scanner(System.in);
        Controller controller = new Controller();
        ControllerParams controllerParams;
        String needSave = "";

        String menu = """
                1 - Создать Блокнот
                2 - Добавить запись в Блокнот
                3 - Найти записи в блокноте по содержимому
                4 - Найти записи в блокноте по дате создания
                5 - Показать записи в блокноте
                6 - Изменить запись
                7 - Сохранить блокнот
                0 - Выход""";

        while (!menuItem.equals("0")){
            System.out.println(menu);
            menuItem = scanner.nextLine();

            controllerParams = new ControllerParams();

            switch (menuItem){
                case ("1"):
                    controllerParams.setCommand("CREATENEWFILE");
                    break;
                case ("2"):
                    controllerParams.setCommand("ADD");

                    System.out.println("Введите данные для создания новой записи. Симол ';' не допускается.");
                    controllerParams.setContent(data.nextLine());
                    break;
                case ("3"):
                    controllerParams.setCommand("GETNOTESBYCONTENT");

                    System.out.println("Введите данные для поиска записей по содержимому.");
                    controllerParams.setContent(data.nextLine());
                    break;
                case ("4"):
                    controllerParams.setCommand("GETNOTEBYDATE");

                    System.out.println("Введите дату для поиска записей по дате в формате (гггг-мм-дд):");
                    controllerParams.setDate(data.nextLine());
                    break;
                case ("5"):
                    controllerParams.setCommand("GETALLNOTES");
                    break;
                case ("6"):
                    controllerParams.setCommand("UPDATENOTEBYID");

                    System.out.println("Введите id записи, которую хотите изменить");
                    controllerParams.setId(scanner.nextLine());

                    System.out.println("Введите новое значение");
                    controllerParams.setContent(scanner.nextLine());
                    break;
                case ("7"):
                    controllerParams.setCommand("SAVE");
                    break;
                case ("0"):
                    while (!(needSave.equalsIgnoreCase("y") || needSave.equalsIgnoreCase("n"))){
                        controllerParams.setCommand("EXIT");
                        System.out.println("Желаете сохранить блокнот? (Y/N)");
                        needSave = scanner.nextLine();
                        if (needSave.equalsIgnoreCase("y")){
                            controllerParams.setCommand("SAVE");
                        }
                    }
                    break;
                default:
                    controllerParams.setCommand("WRONG_REQUEST");
            }
            response = controller.doAction(controllerParams);
            System.out.println(response);
        }

    }
}
