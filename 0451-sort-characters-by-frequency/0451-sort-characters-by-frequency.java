class Solution {
    public String frequencySort(String s) {
        
        PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<>((a,b) -> {
            return (b.getKey()).compareTo(a.getKey());
        });

        Map<Character, Integer> m = new HashMap<>();

        for (char chr : s.toCharArray()) {
            m.put(chr, m.getOrDefault(chr, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            pq.add(new Pair<>(entry.getValue(), entry.getKey()));
        }

        StringBuilder sol = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair<Integer, Character> pair = pq.poll();
            for (int i = 0; i < pair.getKey(); i++) {
                sol.append(pair.getValue());
            }
        }

        return sol.toString();
    }
}