import java.io.IOException;
import java.security.acl.Group;

/**
 * reading data from input stream
 */
public class Scaner {
    static Enter scan(String str) {
        try {
            str = str.trim();
            String[] words = str.split(" ");
            if (words[0].equals("help") == true) {

                System.out.println("Available commands: help : вывести справку по доступным командам");
                System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
                System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
                System.out.println("add {element} : добавить новый элемент в коллекцию");
                System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
                System.out.println("remove_by_id id : удалить элемент из коллекции по его id");
                System.out.println("clear : очистить коллекцию");
                System.out.println("save : сохранить коллекцию в файл");
                System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
                System.out.println("exit : завершить программу (без сохранения в файл)");
                System.out.println("add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
                System.out.println("remove_greater {element} : удалить из коллекции все элементы, превышающие заданный");
                System.out.println("remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный");
                System.out.println("min_by_name : вывести любой объект из коллекции, значение поля name которого является минимальным");
                System.out.println("filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку");
                System.out.println("print_unique_students_count : вывести уникальные значения поля studentsCount всех элементов в коллекции");
                System.out.println("If something goes horribly wrong and you want forget it: Ctrl+D");
                return Enter.INFO;
            } else if (words[0].equals("info")) {
                return Enter.INFO;
            } else if (words[0].equals("show") == true) {
                return Enter.SHOW;
            } else if (words[0].equals("execute_script")){
                return Enter.EXECUTE;
            } else if (words[0].equals("clear") == true) {
                return Enter.CLEAR;
            } else if (words[0].equals("save") == true) {
                return Enter.SAVE;
            }  else if (words[0].equals("add") == true) {
                return Enter.ADD;
            } else if (words[0].equals("add_if_min") == true){
                return Enter.ADD_MIN;
            } else if (words[0].equals("exit") == true) {
                return Enter.EXIT;
            } else if (words[0].equals("min_by_name") == true) {
                return Enter.MIN;
            } else if (words[0].equals("print_unique_students_count") == true) {
                return Enter.PRINT;
            } else if (words[0].equals("filter_contains_name")){
                return Enter.FILTER;
            }
            else if (words[0].equals("remove_by_id")) {
                return Enter.REMOVE_ID;
            } else if (words[0].equals("remove_greater")){
                return Enter.REMOVE_G;
            } else if (words[0].equals("remove_lower")){
                return  Enter.REMOVE_L;
            }
            else if (words.length > 0 && words[0].equals("update") == true) {
                int i = 1;
                while (words[i].equals("") == true) {
                    i = i + 1;
                }
                if (words[i].equals("id") == true) {
                    //System.out.println("Update Id");
                    return Enter.UPDATE;
                } else {
                    return Enter.ERROR;
                }
            } else {
                return Enter.ERROR;
            }
        } catch (ArrayIndexOutOfBoundsException expection) {
            System.out.println("неправильный ввод");
            return Enter.ERROR;
        }
    }
}


