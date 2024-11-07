//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.LinkedList;

public class Hashtable {
    private final int tableSize = 101;
    private int numElements;
    private Object[] table;

    public Hashtable(int var1) {
        this.table = new Object[var1];
        this.numElements = 0;
    }

    public Hashtable() {
        this.getClass();
        this.table = new Object[101];
        this.numElements = 0;
    }

    private int hash(Object var1) {
        int var2 = 42;
        String var3 = var1.toString().toLowerCase();
        char[] var4 = var3.toCharArray();

        for(int var5 = 0; var5 < var4.length; ++var5) {
            char var6 = var4[var5];
            var2 += var6;
        }

        return var2 % this.table.length;
    }

    public void put(Object var1, Object var2) {
        if (var2 != null && var1 != null) {
            if (this.contains(var1)) {
                this.remove(var1);
            }

            int var3 = this.hash(var1);
            if (this.table[var3] == null) {
                this.table[var3] = new LinkedList();
            }

            LinkedList var4 = (LinkedList)this.table[var3];
            var4.add(new HashtableRecord(var1, var2));
            ++this.numElements;
        } else {
            System.err.println("ERROR: Either the key or the data are null");
        }
    }

    public void put(Object[] var1, Object[] var2) {
        for(int var3 = 0; var3 < var2.length; ++var3) {
            this.put(var1[var3], var2[var3]);
        }

    }

    public Object get(Object var1) {
        int i = 0;
        int pos = this.hash(var1);
        LinkedList<HashtableRecord> theList = (LinkedList<HashtableRecord>) this.table[pos];
        if(theList != null){
            while(i < theList.size()){
                HashtableRecord c = theList.get(i);
                if(var1.equals(c.key))
                    return c.value;
                i++;
            }
        }
        return null;
    }

    public void remove(Object var1) {
        int var2 = this.hash(var1);
        if (this.table[var2] != null) {
            HashtableRecord var3 = new HashtableRecord();
            var3.key = var1;
            LinkedList var4 = (LinkedList)this.table[var2];
            boolean var5 = var4.remove(var3);
            if (var4.size() == 0) {
                this.table[var2] = null;
            }

            if (var5) {
                --this.numElements;
            }
        }

    }

    public void remove(Object[] var1) {
        for(int var2 = 0; var2 < var1.length; ++var2) {
            this.remove(var1[var2]);
        }

    }

    public String toString() {
        String var1 = "";
        var1 = var1 + "{\n";

        for(int var2 = 0; var2 < this.table.length; ++var2) {
            if (this.table[var2] != null) {
                var1 = var1 + "\t" + (LinkedList)this.table[var2] + "\n";
            }
        }

        var1 = var1 + "}";
        return var1;
    }

    public int getNumElements() {
        return this.numElements;
    }

    public boolean contains(Object var1) {
        boolean var2 = false;
        int var3 = this.hash(var1);
        if (this.table[var3] != null) {
            HashtableRecord var4 = new HashtableRecord();
            var4.key = var1;
            if (((LinkedList)this.table[var3]).indexOf(var4) > -1) {
                var2 = true;
            }
        }

        return var2;
    }

    public static void main(String[] var0) {
        Hashtable var1 = new Hashtable();
        System.out.println("Inital hash table is: \n" + var1);
        var1.put((Object)"smith", (int)30);
        var1.put((Object)"john", (int)10);
        System.out.println("After two adds, hashtalbe is: \n" + var1);
        var1.put((Object)"green", (int)10);
        var1.put((Object)"green", (int)60);
        System.out.println("After four adds, hashtalbe is: \n" + var1);
        var1.remove((Object)"green");
        System.out.println("After remove green, hashtalbe is: \n" + var1);
    }

    private class HashtableRecord {
        private Object key;
        private Object value;

        public HashtableRecord() {
            this.key = null;
            this.value = null;
        }

        public HashtableRecord(Object var2, Object var3) {
            this.key = var2;
            this.value = var3;
        }

        public boolean equals(Object var1) {
            if (var1 instanceof HashtableRecord) {
                HashtableRecord var2 = (HashtableRecord)var1;
                return this.key.equals(var2.key);
            } else {
                return false;
            }
        }

        public String toString() {
            return "Key: [" + this.key + "] Value: [" + this.value + "]";
        }
    }
}

