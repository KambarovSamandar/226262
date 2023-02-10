package org.example;

import java.util.ArrayList;
import java.util.Scanner;

    public class Repair {
        private static ArrayList<Service> services = new ArrayList<>();
        private static double totalCost = 0.0;

        public void Garage() {
            Scanner scanner = new Scanner(System.in);

            // Adding available services
            services.add(new Service("Полировка кузова", 150));
            services.add(new Service("Лакировка", 28.0));
            services.add(new Service("Покраска", 25.0));
            services.add(new Service("Замена колодок", 67.0));
            services.add(new Service("Регулировка клапанов", 55.0));
            services.add(new Service("Промывка коробки передач", 15.0));
            services.add(new Service("Настройка двигателя", 399.0));
            services.add(new Service("Подзарядка кондиционера", 99.0));
            services.add(new Service("Замена масляной насос", 349.0));
            services.add(new Service("Замена гидрокомпенсатора", 179.0));

            // Displaying available services
            System.out.println(" Выбеите доступные услуги");
            for (int i = 0; i < services.size(); i++) {
                System.out.println((i + 1) + ". " + services.get(i).getName() + " - $" +  services.get(i).getCost());
            }

            // Selecting services
            ArrayList<Service> selectedServices = new ArrayList<>();
            while (true) {
                System.out.print("Выберите номер услуги, которую вы хотите выбрать (0 для завершения): ");
                try {
                    int serviceNum = scanner.nextInt();
                    if (serviceNum == 0) {
                        break;
                    }
                    selectedServices.add(services.get(serviceNum - 1));
                    totalCost += services.get(serviceNum - 1).getCost();
                } catch (Exception e) {
                    System.out.println("Неверный ввод, пожалуйста, попробуйте еще раз.");
                    scanner.nextLine();
                }
            }

            // Displaying selected services and their cost
            System.out.println("---- Выбранные услуги ----");
            for (int i = 0; i < selectedServices.size(); i++) {
                System.out.println((i + 1) + ". " + selectedServices.get(i).getName() + " - $"+ selectedServices.get(i).getCost());
            }
            System.out.println("Общая стоимость: $ " + totalCost);

            // Checking funds
            System.out.print("Введите сумму ваших средств: $");
            try {
                double funds = scanner.nextDouble();
                if (funds < totalCost) {
                    System.out.println("У вас недостаточно денег. Пожалуйста, удалите некоторые сервисы.");
                } else {
                    System.out.println("Ваша сдача: $ " + (funds - totalCost));
                }
            } catch (Exception e) {
                System.out.println("Неверный ввод, пожалуйста, попробуйте еще раз.");
                scanner.nextLine();
            }

            scanner.close();
        }
    }

    class Service {
        private String name;
        private double cost;

        public Service(String name, double cost) {
            this.name = name;
            this.cost = cost;
        }

        public String getName() {
            return name;
        }

        public double getCost() {
            return cost;
        }
    }

