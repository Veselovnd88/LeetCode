package problems;

/**
 * @author VeselovND <br>
 * created at 01.07.2024 <br>
 */
public class Trie {

    public static void main(String[] args) {

    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        //разбираем слово
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            //проверяю потомков у ноды, если такого потомка нет - то создаем нового, если есть то присваемваем текущую ноду,
            //следующий символ будет искаться уже от текущей ноды
            int charIndex = c - 'a';
            if (node.child[charIndex] == null) {
                node.child[charIndex] = new TrieNode();
                node.child[charIndex].value = c;
            }
            node = node.child[charIndex];
        }
        node.end = true; //когда слово закончилось, маркируем
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int charIndex = c - 'a';
            if (node.child[charIndex] == null) {
                return false;
            }
            node = node.child[charIndex];
        }
        //проходка по всем нодам, и проверяем, было ли введено слово до этого, если были все совпадения но при этом на последнем
        //совпадении слово не заканчивалось, то будет фолс
        return node.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int charIndex = c - 'a';
            if (node.child[charIndex] == null) {
                return false;
            }
            node = node.child[charIndex];
        }
        return true;
    }

    public static class TrieNode {
        public char value;
        public boolean end;
        public TrieNode[] child = new TrieNode[26];

        public TrieNode() {
        }

    }
}
