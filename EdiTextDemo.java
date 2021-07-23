public class EdiTextDemo {
    public static void main(String[] args) {
        //EdiText editor = new EdiText();      // without singleton pattern, created an object from EdiText class
        SingletonEditor.getEditor();               // with singleton pattern

    }
}
