import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node{
    char ch;
    int freq;
    Node left=null,right=null;
    Node(char ch,int freq){
        this.ch=ch;
        this.freq=freq;
    }
    Node(char ch,int freq,Node left,Node right){
        this.ch=ch;
        this.freq=freq;
        this.left=left;
        this.right=right;
    }
}

public class Huffman {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter text:");
        String text = input.nextLine();
        buildHuffmanTree(text);
    }
    public static void buildHuffmanTree(String text){
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if(!map.containsKey(text.charAt(i))){
                map.put(text.charAt(i),0);
            }
            map.put(text.charAt(i),map.get(text.charAt(i))+1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((l,r)-> l.freq-r.freq);
        for (Map.Entry<Character,Integer> entry : map.entrySet() ){
            pq.add(new Node(entry.getKey(),entry.getValue()));
        }

        while(pq.size()!=1){
            Node left=pq.poll();
            Node right=pq.poll();
            int sum = left.freq+right.freq;
            pq.add(new Node('\0',sum,left,right));
        }

        Node root = pq.peek();

        Map<Character,String> huffmanCode = new HashMap<>();
        encode(root,"",huffmanCode);

        System.out.println("Huffman Codes are:");
        for(Map.Entry<Character,String> entry : huffmanCode.entrySet()){
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }

    }

    private static void encode(Node root, String s, Map<Character, String> huffmanCode) {
        if(root==null) {
            return;
        }
        if(root.left==null && root.right==null){
            huffmanCode.put(root.ch,s);
        }
        encode(root.left,s+"0",huffmanCode);
        encode(root.right,s+"1",huffmanCode);
    }
}
