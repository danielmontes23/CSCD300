public class Tester {
    public Tester() {
    }

    public static void main(String[] var0) {
        Hashtable var1 = new Hashtable();
        var1.put("abcde", "AA");
        var1.put("acbed", "AB");
        var1.put("abced", "AC");
        var1.put(new Integer(10), "BB");
        var1.put(new Integer(11), "BC");
        var1.put(new Integer(12), "BD");
        var1.put("moist", "CC");
        var1.put("pizza", "CD");
        var1.put("student", "DD");
        var1.put("teacher", "DE");
        var1.put("goodperson", "EE");
        String var2 = (String)var1.get("goodperson");
        System.out.println(var2);
        var2 = (String)var1.get("student");
        System.out.println(var2);
        var2 = (String)var1.get(12);
        System.out.println(var2);
        var2 = (String)var1.get("hello");
        System.out.println(var2);
        var2 = (String)var1.get("acbed");
        System.out.println(var2);
    }
}

