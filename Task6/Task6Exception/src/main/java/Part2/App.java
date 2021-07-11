package Part2;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception { // предупреждаем о Exception
        throw new Exception(); // и кидаем Exception
    }
}

class App2 {
    public static void main(String[] args) throws Throwable { // предупреждаем "целом" Throwable
        throw new Exception(); // а кидаем только Exception
    }
}

class App3 {
    public static void main(String[] args) throws Exception { // пугаем
        // но ничего не бросаем
    }
}

class App4 {
    // они пугают целым Throwable
    public static void main(String[] args) throws Throwable {
        f();
    }
    // хотя мы пугали всего-лишь Exception
    public static void f() throws Exception {
    }
}

class App5 {
    public static void main(String[] args) {
        f();
    }
    public static void f() throws RuntimeException {
    }
}

class App6 {
    // пугаем ОБОИМИ исключениями
    public static void main(String[] args) throws EOFException, FileNotFoundException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        } else {
            throw new FileNotFoundException();
        }
    }
}

class App7 {
    // пугаем ОБОИМИ исключениями
    public static void main(String[] args) throws EOFException, FileNotFoundException {
        f0();
        f1();
    }
    public static void f0() throws EOFException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        }
    }
    public static void f1() throws FileNotFoundException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new FileNotFoundException();
        }
    }
}

class App8 {
    // пугаем ПРЕДКОМ исключений
    public static void main(String[] args) throws IOException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        } else {
            throw new FileNotFoundException();
        }
    }
}

class App9 {
    // пугаем ПРЕДКОМ исключений
    public static void main(String[] args) throws IOException {
        f0();
        f1();
    }
    public static void f0() throws EOFException {
        throw new EOFException();
    }
    public static void f1() throws FileNotFoundException {
        throw new FileNotFoundException();

    }
}

class App10 {
    public static void main(String[] args) throws IOException, InterruptedException {
        f0();
        f1();
        f2();
    }
    public static void f0() throws EOFException {
        throw new EOFException();
    }
    public static void f1() throws FileNotFoundException {
        throw new FileNotFoundException();
    }
    public static void f2() throws InterruptedException {
        throw new InterruptedException();
    }
}

class App11 {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e) {
            // ...
        }
    }
}

class App12 {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Throwable e) {
            // ...
        }
    }
}

class App13 {
    // EOFException перехватили catch-ом, им не пугаем
    public static void main(String[] args) throws FileNotFoundException {
        try {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new EOFException();
            } else {
                throw new FileNotFoundException();
            }
        } catch (EOFException e) {
            // ...
        }
    }
}

class App14 {
    // ТЕПЕРЬ пугаем Throwable
    public static void main(String[] args) throws Throwable {
        try {
            Throwable t = new Exception(); // а лететь будет Exception
            throw t;
        } catch (Exception e) { // и мы перехватим Exception
            System.out.println("Перехвачено!");
        }
    }
}

class App15 {
    public class Parent {
        // предок пугает IOException и InterruptedException
        public void f() throws IOException, InterruptedException {}
    }

    class Child extends Parent {
        // а потомок пугает только потомком IOException
        @Override
        public void f() throws FileNotFoundException {}
    }
}

