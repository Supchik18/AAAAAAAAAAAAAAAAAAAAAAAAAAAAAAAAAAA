package org.example;
import java.util.Scanner;


public class Main {
    public static final double EARTH_RADIUS_KM = 6371.0;

    public static void main(String[] args) {
        // Получение координат от пользователя
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите широту первой точки (в градусах): ");
        double latitude1 = scanner.nextDouble();

        System.out.print("Введите долготу первой точки (в градусах): ");
        double longitude1 = scanner.nextDouble();

        System.out.print("Введите широту второй точки (в градусах): ");
        double latitude2 = scanner.nextDouble();

        System.out.print("Введите долготу второй точки (в градусах): ");
        double longitude2 = scanner.nextDouble();

        // Вычисление расстояния
        double distance = calculateDistance(latitude1, longitude1, latitude2, longitude2);

        // Вывод расстояния в километрах
        System.out.println("Расстояние между двумя точками: " + distance + " км");

        scanner.close();
    }

    public static double calculateDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
        // Перевод градусов в радианы
        double lat1Rad = Math.toRadians(latitude1);
        double lon1Rad = Math.toRadians(longitude1);
        double lat2Rad = Math.toRadians(latitude2);
        double lon2Rad = Math.toRadians(longitude2);

        // Разница координат
        double dlat = lat2Rad - lat1Rad;
        double dlon = lon2Rad - lon1Rad;

        // Формула гаверсинусов
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Вычисление расстояния
        double distance = EARTH_RADIUS_KM * c;

        return distance;
    }
}