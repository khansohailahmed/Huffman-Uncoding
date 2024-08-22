
package advancedsa;


import java.util.*;

public class HuffmanEncoding {
    public static void main(String[] args) {
        String message = "aa bbbb a bbb ccc ddd eee ccc eee dd eee fff fff ";// enter the charcter as per your choice 
        Map<Character, Integer> frequency = new HashMap<>();

        // Calculate frequency of each character
        for (char c : message.toCharArray()) {
            if (frequency.containsKey(c)) {
                frequency.put(c, frequency.get(c) + 1);
            } else {
                frequency.put(c, 1);
            }
        }

        // Build Huffman tree
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            queue.add(node);
        }

        while (queue.size() > 1) {
            Node node1 = queue.poll();
            Node node2 = queue.poll();
            Node newNode = new Node(null, node1.weight + node2.weight);
            newNode.left = node1;
            newNode.right = node2;
            queue.add(newNode);
        }

        // Calculate Huffman codes
        Node root = queue.poll();
        Map<Character, String> huffmanCodes = new HashMap<>();
        calculateHuffmanCodes(root, "", huffmanCodes);

        // Calculate total bits and average bits per character
        int totalBits = 0;
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            totalBits += entry.getValue().length() * frequency.get(entry.getKey());
        }
        double averageBitsPerCharacter = (double) totalBits / message.length();

        System.out.println("Huffman codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Total bits: " + totalBits);
        System.out.println("Average bits per character: " + averageBitsPerCharacter);
    }

    private static void calculateHuffmanCodes(Node node, String code, Map<Character, String> huffmanCodes) {
        if (node == null) {
            return;
        }
        if (node.character != null) {
            huffmanCodes.put(node.character, code);
        }
        calculateHuffmanCodes(node.left, code + "0", huffmanCodes);
        calculateHuffmanCodes(node.right, code + "1", huffmanCodes);
    }

    private static class Node implements Comparable<Node> {
        Character character;
        int weight;
        Node left;
        Node right;

        Node(Character character, int weight) {
            this.character = character;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
}