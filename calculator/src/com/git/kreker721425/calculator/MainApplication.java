package com.git.kreker721425.calculator;

import com.git.kreker721425.calculator.exception.NumberOfArgumentsException;
import com.git.kreker721425.calculator.exception.OperationException;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        System.out.println("***** Доброго времени суток, дорогой друг!\n" +
                "***** Этот калькулятор умеет выполнять арифметические операции (+, -, *, /) над двумя числами.\n");

        //Считываем пример
        System.out.print(">");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        try {

            //Ищем введенную арифм.операцию
            //Если не находим, выбрасываем исключение
            if (line.split("\\*").length > 1) {

                //Проверка на кол-во введенных чисел
                if (line.split("\\*").length > 3)
                    throw new NumberOfArgumentsException();

                System.out.println(
                        new Example(line.split("\\*")[0], line.split("\\*")[1], "\\*").getResult()
                );
            } else {
                if (line.split("/").length > 1) {

                    if (line.split("/").length > 3)
                        throw new NumberOfArgumentsException();

                    System.out.println(
                            new Example(line.split("/")[0], line.split("/")[1], "/").getResult()
                    );
                } else {
                    if (line.split("-").length > 1) {

                        if (line.split("-").length > 3)
                            throw new NumberOfArgumentsException();

                        System.out.println(
                                new Example(line.split("-")[0], line.split("-")[1], "-").getResult()
                        );
                    } else {
                        if (line.split("\\+").length > 1) {

                            if (line.split("\\+").length > 3)
                                throw new NumberOfArgumentsException();

                            System.out.println(
                                    new Example(line.split("\\+")[0], line.split("\\+")[1], "\\+").getResult()
                            );
                        } else
                            throw new OperationException();
                    }
                }
            }
        } catch (OperationException | NumberOfArgumentsException e) {
            System.out.println(e);
        }
    }
}
