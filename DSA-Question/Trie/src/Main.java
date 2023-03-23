public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        TrieImplTwo t = new TrieImplTwo();
        t.insert("apple");
        t.insert("apple");
        t.insert("apps");
        t.insert("apps");
        t.erase("apple");
        System.out.println(t.countWordsEqualTo("apple"));

        System.out.println(t.startsWith("apps"));
    }
}