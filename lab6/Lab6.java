import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Помідор");
        list.add("Огірок");
        list.add("Морква");

        System.out.println("Список: " + list);

        Scanner sc = new Scanner(System.in, "UTF-8");

        // Запит на введення індексу для видалення
        System.out.print("Введіть індекс елемента, який видалити: ");
        int indexToRemove = sc.nextInt();
        sc.nextLine(); // Очищення залишків нового рядка після числа

        if (indexToRemove >= 0 && indexToRemove < list.size()) {
            list.remove(indexToRemove);
            System.out.println("Після видалення елемента на позиції " + indexToRemove + ": " + list);
        } else {
            System.out.println("Невірний індекс. Спробуйте ще раз.");
        }

        // Запит на введення рядка для перевірки
        System.out.print("Введіть овоч для перевірки його наявності в списку: ");
        String elementToCheck = sc.nextLine().trim(); // Видалити зайві пробіли

        System.out.println("Введений текст: '" + elementToCheck + "'"); // Відладковий вивід
        boolean contains = list.contains(elementToCheck);
        System.out.println("Чи містить '" + elementToCheck + "': " + contains);

        sc.close();
    }
}
