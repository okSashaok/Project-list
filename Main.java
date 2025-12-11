import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> task = new ArrayList<>();
    private static void addTask(String setTask){
        task.add(setTask);//Дела можно(???) считать уникальными, т. е. без повторов.
    }
    private static void outputTasks(){
        System.out.print("Ваш список дел:\n");
        for(byte i = 0, max = (byte)task.size(); i < max; ){
            System.out.print((i + 1) + ". " + task.get(i++) + "\n");
        }
    }
    private static void deletingTask(char number){
        if(task.size() < number){
            System.out.print("Дел с таким номером нет!\n");
        }else{
            task.remove(number);
        }
    }
    private static void deletingTask(String text){
        if(!task.remove(text)){
            System.out.print("Дел с таким текстом нет!\n");
        }
    }
    private static void deletingTasks(String text){
        if(!task.removeIf(item -> item.contains(text))){
            System.out.print("Дел с таким фрагментом нет!\n");
        }
    }
    private static boolean menu(){
        System.out.print("""
            
            Выберите операцию:
            0. Выход из программы
            1. Добавить дело
            2. Показать дела
            3. Удалить дело по номеру
            4. Удалить дело по названию
            5. Удалить дело по фрагменту
            Ваш выбор:""" + " ");
            switch(scanner.nextLine()){
                case "":return true;
                case "0":return false;
                case "1":{
                    System.out.print("\nВведите название задачи: ");
                    addTask(scanner.nextLine());
                    System.out.print("Добавлено!\n");
                }break;
                case "2":break;
                case "3":{
                    System.out.print("Введите номер для удаления: ");
                    deletingTask((char)(Integer.parseInt(scanner.nextLine()) - 1));
                }break;
                case "4":{
                    System.out.print("Введите задачу для удаления: ");
                    deletingTask(scanner.nextLine());
                }break;
                case "5":{
                    System.out.print("Введите фрагмент задачи для удаления: ");
                    deletingTasks(scanner.nextLine());
                }break;
            }
            outputTasks();
        return true;
    }
    public static void main(String[] args) {
        while(menu());
    }
}