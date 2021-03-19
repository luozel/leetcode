package LeetCode1603;

public class solution {
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(3));
    }
}

class ParkingSystem {
    int[] carPark;

    public ParkingSystem(int big, int medium, int small) {
        carPark = new int[3];
        carPark[0] = big;
        carPark[1] = medium;
        carPark[2] = small;

    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (carPark[0] > 0) {
                carPark[0]--;
                return true;
            }
        } else if (carType == 2) {
            if (carPark[1] > 0) {
                carPark[1]--;
                return true;
            }
        } else if (carType == 3) {
            if (carPark[2] > 0) {
                carPark[2]--;
                return true;
            }
        }
        return false;
    }
}

class ParkingSystem1 {
    int[] carPark;

    public ParkingSystem1(int big, int medium, int small) {
        carPark = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return carPark[carType - 1]-- > 0;
    }
}