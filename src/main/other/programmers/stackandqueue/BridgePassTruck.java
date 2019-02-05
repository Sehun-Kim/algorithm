package other.programmers.stackandqueue;

import java.util.*;

public class BridgePassTruck {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        int result = solution(bridge_length, weight, truck_weights);
        System.out.println(result);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int truckCount = truck_weights.length;
        List<Truck> trucks = new ArrayList<>();
        for (int truck_weight : truck_weights) {
            trucks.add(new Truck(truck_weight));
        }
        List<Truck> passedTrucks = new ArrayList<>();

        Bridge bridge = new Bridge(bridge_length, weight);
        int result = 1;

        while (passedTrucks.size() != truckCount) {
            result++;
            int truckWeight = 0;

            if (!trucks.isEmpty()) {
                System.out.println(trucks.get(0));
                truckWeight = trucks.get(0).weight;
            }

            if (bridge.isInTruck(truckWeight)) {
                Truck truck = trucks.remove(0);
                bridge.inTruck(truck);
            }

            if (bridge.hasOutTruck())
                passedTrucks.add(bridge.outTruck());
        }

        return result;
    }

    static class Truck {
        private int move;
        private int weight;

        public Truck(int weight) {
            this.move = 0;
            this.weight = weight;
        }

        public void move() {
            this.move++;
        }

        @Override
        public String toString() {
            return "Truck{" +
                    "isInTruck=" + move +
                    ", weight=" + weight +
                    '}';
        }
    }

    static class Bridge {
        private int length;
        private int weight;
        private List<Truck> movingTruck;
        private int size;

        public Bridge(int length, int weight) {
            this.length = length;
            this.weight = weight;
            this.movingTruck = new ArrayList<>();
            this.size = 0;
        }

        public boolean isInTruck(int weight) {
            for (Truck truck : this.movingTruck)
                truck.move();

            if (this.size + weight <= this.weight && weight != 0)
                return true;
            return false;
        }

        public void inTruck(Truck truck) {
            truck.move();
            movingTruck.add(truck);
            this.size += truck.weight;
        }


        public boolean hasOutTruck() {
            if (movingTruck.get(0).move == this.length)
                return true;
            return false;
        }

        public Truck outTruck() {
            Truck truck = movingTruck.remove(0);
            this.size -= truck.weight;
            return truck;
        }
    }
}