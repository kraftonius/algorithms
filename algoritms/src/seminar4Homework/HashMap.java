package seminar4Homework;

public class HashMap<K, V> {
    private Node<K, V>[] hashTable = new Node[16];


    public V objectPut(K key, V value) { // ЕСЛИ по ключу пусто Добавляет пару ключ-значение, ИНАЧЕ возвращает null
        Node<K, V> putNode = new Node<>(key, value);
        int i = putNode.key.hashCode() % 16;
        if (hashTable[i] != null) {
            for (Node<K, V> curNode = hashTable[i]; curNode != null; curNode = curNode.nextnode) {
                if (curNode.key.equals(key)) {
                    return curNode.value;
                }
            }
            putNode.nextnode = hashTable[i];
        }
        hashTable[i] = putNode;
        return null;
    }

    public V objectGet(K key) { // ЕСЛИ по ключу НЕ пусто Возвращает значение по ключу, ИНАЧЕ возвращает null
        int i = key.hashCode() % 16;
        for (Node<K, V> currentNode = hashTable[i]; currentNode != null; currentNode = currentNode.nextnode) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
        }
        return null;
    }

    public V objectRemove(K key) { // ЕСЛИ по ключу НЕ пусто Удаляет пару ключ-значение, ИНАЧЕ возвращает null
        int i = key.hashCode() % 16;
        Node<K, V> currentNode = hashTable[i];
        if (currentNode != null) {
            if (currentNode.key.equals(key)) {
                V result = currentNode.value;
                hashTable[i] = currentNode.nextnode;
                return result;
            }
            for (Node<K, V> nextNode = currentNode.nextnode; nextNode != null; nextNode = nextNode.nextnode) {
                if (nextNode.key.equals(key)) {
                    V result = nextNode.value;
                    currentNode.nextnode = nextNode.nextnode;
                    return result;
                }
                currentNode = nextNode;
            }
        }
        return null;
    }

    public V objectReplace(K key, V value) { // ЕСЛИ по ключу НЕ пусто Заменяет значение, ИНАЧЕ возвращает null

        int i = key.hashCode() % 16;

        if (hashTable[i] != null) {
            for (Node<K, V> currentNode = hashTable[i]; currentNode != null; currentNode = currentNode.nextnode) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value;
                    return currentNode.value;
                }
            }
        }
        return null;
    }

    public int size() { // Считает элементы, возвращает количество элементов
        int count = 0;
        for (int i = 0; i < 16; i++) {
            if (hashTable[i] != null) {
                for (Node<K, V> currentNode = hashTable[i]; currentNode != null; currentNode = currentNode.nextnode) {
                    if (currentNode.key != null) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean keyExists(K key) { // проверяет, есть ли элемент с таким ключом
        int i = key.hashCode() % 16;
        if (hashTable[i] != null){
            for(Node<K, V> currentNode = hashTable[i]; currentNode != null; currentNode = currentNode.nextnode){
                if (currentNode.key.equals(key)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean valueExists(V value) { // проверяет, есть ли элемент с таким значением
        for (int i = 0; i < 16; i++) {
            if (hashTable[i] != null) {
                for (Node<K, V> currentNode = hashTable[i]; currentNode != null; currentNode = currentNode.nextnode) {
                    if (currentNode.value.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> nextnode;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {


        HashMap<Integer, String> myHashTable = new HashMap<>();

        System.out.println();
        System.out.println("Добавляем пары ключ/значение");

        System.out.println(myHashTable.objectPut(1, "Попугай"));
        System.out.println(myHashTable.objectPut(17, "Кот"));
        System.out.println(myHashTable.objectPut(33, "Пес"));
        System.out.println(myHashTable.objectPut(14, "Черепаха"));
        System.out.println(myHashTable.objectPut(5, "Слон"));
        System.out.println(myHashTable.objectPut(88, "Тигр"));

        System.out.println();
        System.out.println("Смотрим, что покажет по ключам, которые добавляли");

        System.out.println(myHashTable.objectGet(1));
        System.out.println(myHashTable.objectGet(17));
        System.out.println(myHashTable.objectGet(33));
        System.out.println(myHashTable.objectGet(14));
        System.out.println(myHashTable.objectGet(5));
        System.out.println(myHashTable.objectGet(88));

        System.out.println();
        System.out.println("Добавляем в существующие ключи");

        System.out.println(myHashTable.objectPut(1, "Крокодил"));
        System.out.println(myHashTable.objectPut(5, "Бегемот"));

        System.out.println("Смотрим, что покажет по ключам, которые добавляли");
        System.out.println(myHashTable.objectGet(1));
        System.out.println(myHashTable.objectGet(5));

        System.out.println();
        System.out.println("Удаляем значения по ключу");

        System.out.println(myHashTable.objectRemove(43));
        System.out.println(myHashTable.objectRemove(88));

        System.out.println();
        System.out.println("Смотрим, что покажет по ключам, которые удаляли");

        System.out.println(myHashTable.objectGet(43));
        System.out.println(myHashTable.objectGet(88));

        System.out.println();
        System.out.println("Заменяем значения по ключу");


        System.out.println(myHashTable.objectReplace(1, "Утка"));
        System.out.println(myHashTable.objectReplace(8, "Бобр"));

        System.out.println();
        System.out.println("Смотрим, что покажет по ключам, которые заменяли");
        System.out.println(myHashTable.objectGet(1));
        System.out.println(myHashTable.objectGet(8));

        System.out.println();
        System.out.println("Посчитаем количество элементов");

        System.out.println(myHashTable.size());

        System.out.println();
        System.out.println("Проверим существует ли элемент с ключом?");

        System.out.println(myHashTable.keyExists(33));
        System.out.println(myHashTable.keyExists(1133));

        System.out.println();
        System.out.println("Проверим существует ли элемент со значением?");

        System.out.println(myHashTable.valueExists("Утка"));
        System.out.println(myHashTable.valueExists("Попугай"));
        System.out.println(myHashTable.valueExists("Слон"));
        System.out.println(myHashTable.valueExists("Панда"));
    }

}
