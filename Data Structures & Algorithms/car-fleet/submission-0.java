class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];

        for(int i =0; i < position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> fleets = new Stack<>();

        for( int[] car : cars ){
            fleets.push((double) (target-car[0])/car[1]);
            if(fleets.size() >=2 && fleets.peek()
                <= fleets.get(fleets.size()-2)){
                    fleets.pop();
                }
        }

        return fleets.size();

    }
}
