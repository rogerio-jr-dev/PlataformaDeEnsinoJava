package application;

import entities.Lesson;
import entities.Task;
import entities.Video;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    private static final List<Lesson> list = new ArrayList<>();

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas aulas tem o curso? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.printf("Dados da %da aula: \n", i);
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char type = sc.next().charAt(0);
            System.out.print("Título: ");
            sc.nextLine(); //Limpeza de Buffer
            String title = sc.nextLine();
            if (type == 'c') {
                System.out.print("URL do vídeo: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                Integer duration = sc.nextInt();
                list.add(new Video(title, url, duration));
            } else {
                System.out.print("Descrição: ");
                String description = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                Integer quantity = sc.nextInt();
                list.add(new Task(title, description, quantity));
            }
            System.out.println();
        }
        System.out.println();//Pular linha
        System.out.println("DURAÇÃO TOTAL DO CURSO = " + totalSeconds() + " segundos");
        sc.close();
    }

    private static Integer totalSeconds() {
        Integer sum = 0;
        for (Lesson lesson : list) {
            sum += lesson.duration();
        }
        return sum;
    }
}
