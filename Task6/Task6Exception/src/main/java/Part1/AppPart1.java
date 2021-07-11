package Part1;

public class AppPart1 {
    public static void main(String[] args) throws Throwable {}
}

class App2 {
    public static void main(String[] args) {
        try {
        } catch (Throwable t) {}
    }
}

class App3 {
    public static void main(String[] args) {
        // Error - потомок Throwable
        throw new Error();
    }
}

class App4 {
    public static void main(String[] args) {
        Error ref = new Error(); // создаем экземпляр
        throw ref;               // "бросаем" его
    }
}

class App5 {
    public static void main(String[] args) {
        f(null);
    }
    public static void f(NullPointerException e) {
        try {
            throw e;
        } catch (NullPointerException npe) {
            f(npe);
        }
    }
}

class App6 {
    public static void main(String[] args) {
        System.out.println("sout");
        throw new Error();
    }
}

class App7 {
    public double sqr(double arg) { // надо double
        return arg * arg;           // double * double - это double
    }
}

class App8 {
    public double sqr(double arg) { // надо double
        int k = 1;                  // есть int
        return k;                   // можно неявно преобразовать int в double
    }
}

class App9 {
    public static double sqr(double arg) {
        while (true);
    }
}

class App10 {
    public static void main(String[] args) {
        double d = sqr(10.0);  // sqr - навсегда "повиснет", и
        System.out.println(d); // d - НИКОГДА НИЧЕГО НЕ БУДЕТ ПРИСВОЕНО!
    }
    public static double sqr(double arg) {
        while (true); // Вот тут мы на века "повисли"
    }
}

class App11 {
    public static double sqr(double arg) {
        if (System.currentTimeMillis() % 2 == 0) {
            return arg * arg; // ну ладно, вот твой double
        } else {
            while (true);     // а тут "виснем" навсегда
        }
    }
}

class App12 {
    public static double sqr(double arg) {
        throw new RuntimeException();
    }
}

class App13 {
    public static double sqr(double arg) {// согласно объявлению метода ты должен вернуть double
        long time = System.currentTimeMillis();
        if (time % 2 == 0) {
            return arg * arg;             // ок, вот твой double
        } else if (time % 2 == 1) {
                while (true) ;                 // не, я решил "повиснуть"
        } else{
                throw new RuntimeException(); // или бросить исключение
            }
        }
    }

class App14 {
    public static void main(String[] args) {
        // sqr - "сломается" (из него "выскочит" исключение),
        double d = sqr(10.0);  // выполнение метода main() прервется в этой строчке и
        // d - НИКОГДА НИЧЕГО НЕ БУДЕТ ПРИСВОЕНО!
        System.out.println(d); // и печатать нам ничего не придется!
    }
    public static double sqr(double arg) {
        throw new RuntimeException(); // "бросаем" исключение
    }
}

class App15{
    public static void main(String[] args) {
        area(15,-9);
    }

    public static int area(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        }
        return width * height;
    }
}

class App16 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // вернулись
    } // выходим из текущего фрейма, кончились инструкции

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out");  //вернулись
    } // выходим из текущего фрейма, кончились инструкции

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // вернулись
    } // выходим из текущего фрейма, кончились инструкции

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.RETURN");
            return; // выходим из текущего фрейма по 'return'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСКАЕМ
    }
}

class App17 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // ПРОПУСТИЛИ!
    }

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out"); // ПРОПУСТИЛИ!
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}

class App18 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        try {
            f(); // создаем фрейм, помещаем в стек, передаем в него управление
        } catch (Error e) { // "перехватили" "летящее" исключение
            System.err.println("#1.CATCH");  // и работаем
        }
        System.err.println("#1.out");  // работаем дальше
    }

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out"); // ПРОПУСТИЛИ!
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}

class App19 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // вернулись и работаем
    }

    public static void f() {
        System.err.println(".   #2.in");
        try {
            g(); // создаем фрейм, помещаем в стек, передаем в него управление
        } catch (Error e) { // "перехватили" "летящее" исключение
            System.err.println(".   #2.CATCH");  // и работаем
        }
        System.err.println(".   #2.out");  // работаем дальше
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}

class App20 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // вернулись и работаем
    }

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out"); // вернулись и работаем
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        try {
            h(); // создаем фрейм, помещаем в стек, передаем в него управление
        } catch (Error e) { // "перехватили" "летящее" исключение
            System.err.println(".   .   #3.CATCH");  // и работаем
        }
        System.err.println(".   .   #3.out");  // работаем дальше
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}

class App21 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (Exception e) { // catch по Exception ПЕРЕХВАТЫВАЕТ RuntimeException
            System.err.print(" 2");
        }
        System.err.println(" 3");
    }
}

class App22 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                RuntimeException re = (RuntimeException) e;
                System.err.print("Это RuntimeException на самом деле!!!");
            } else {
                System.err.print("В каком смысле не RuntimeException???");
            }
        }
    }
}

class App23 {
    public static void main(String[] args) throws Exception { // пока игнорируйте 'throws'
        try {
            System.err.print(" 0");
            if (true) {throw new Exception();}
            System.err.print(" 1");
        } catch (RuntimeException e) {
            System.err.print(" 2");
        }
        System.err.print(" 3");
    }
}

class App24 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new Error();}
            System.err.print(" 1");
        } catch (Exception e) {
            System.err.print(" 2");
        }
        System.err.print(" 3");
    }
}

class App25 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (RuntimeException e) {     // перехватили RuntimeException
            System.err.print(" 2");
            if (true) {throw new Error();} // но бросили Error
        }
        System.err.println(" 3");          // пропускаем - уже летит Error
    }
}

class App26 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (RuntimeException e) { // перехватили RuntimeException
            System.err.print(" 2");
            if (true) {throw e;}       // и бросили ВТОРОЙ раз ЕГО ЖЕ
        }
        System.err.println(" 3");      // пропускаем - опять летит RuntimeException
    }
}

class App27 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (RuntimeException e) {     // перехватили RuntimeException
            System.err.print(" 2");
            if (true) {throw new Error();} // и бросили новый Error
        } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
            System.err.print(" 3");
        }
        System.err.println(" 4");
    }
}

class App28 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (RuntimeException e) { // перехватили RuntimeException
            System.err.print(" 2.1");
            try {
                System.err.print(" 2.2");
                if (true) {throw new Error();} // и бросили новый Error
                System.err.print(" 2.3");
            } catch (Throwable t) {            // перехватили Error
                System.err.print(" 2.4");
            }
            System.err.print(" 2.5");
        } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
            System.err.print(" 3");
        }
        System.err.println(" 4");
    }
}

class App29 {
    public static void main(String[] args) {
        try {
        } catch (Error e) {
        } catch (RuntimeException e) {
        }
    }
}

class App30 {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (RuntimeException e) {
            System.err.println("catch RuntimeException");
        } catch (Exception e) {
            System.err.println("catch Exception");
        } catch (Throwable e) {
            System.err.println("catch Throwable");
        }
        System.err.println("next statement");
    }
}

class App31 {
    public static void main(String[] args) {
        try {
            Throwable t = new Exception(); // ссылка типа Throwable указывает на объект типа Exception
            throw t;
        } catch (RuntimeException e) {
            System.err.println("catch RuntimeException");
        } catch (Exception e) {
            System.err.println("catch Exception");
        } catch (Throwable e) {
            System.err.println("catch Throwable");
        }
        System.err.println("next statement");
    }
}

class App32 {
    public static void main(String[] args) {
        try {
            System.err.println("try");
        } finally {
            System.err.println("finally");
        }
    }
}

class App33 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            System.err.println("finally");
        }
    }
}

class App34 {
    public static void main(String[] args) {
        try {
            return;
        } finally {
            System.err.println("finally");
        }
    }
}

class App35 {
    public static void main(String[] args) {
        try {
            System.exit(42);
        } finally {
            System.err.println("finally");
        }
    }
}

class App36 {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exit(42);
        } finally {
            System.err.println("finally");
        }
    }
}

class App37 {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().halt(42);
        } finally {
            System.err.println("finally");
        }
    }
}

class App38 {
    public static void main(String[] args) {
        try {
            System.err.println("try");
            if (true) {throw new RuntimeException();}
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }
}

class App39 {
    public static void main(String[] args) {
        try {
            System.err.println("try");
            if (true) {return;}
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }
}

class App40 {
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        try {
            return 0;
        } finally {
            return 1;
        }
    }
}

class App41 {
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        try {
            throw new RuntimeException();
        } finally {
            return 1;
        }
    }
}

class App42{
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        try {
            return 0;
        } finally {
            throw new RuntimeException();
        }
    }
}

class App43 {
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        try {
            throw new Error();
        } finally {
            throw new RuntimeException();
        }
    }
}

class App44 {
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        long rnd = System.currentTimeMillis();
        boolean finished = false;
        try {
            if (rnd % 3 == 0) {
                throw new Error();
            } else if (rnd % 3 == 1) {
                throw new RuntimeException();
            } else {
                // nothing
            }
            finished = true;
        } finally {
            if (finished) {
                // не было исключений
            } else {
                // было исключение, но какое?
            }
        }
        return 0;
    }
}

class App45 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            // nothing
            System.err.print(" 1");
        } catch(Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }
}

class App46 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new Error();}
            System.err.print(" 1");
        } catch(Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }
}

class App47 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch(Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }
}

class App48 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                // НИЧЕГО
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3"); // НЕ заходим - нет исключения
            } finally {
                System.err.print(" 4"); // заходим всегда
            }
            System.err.print(" 5");     // заходим - выполнение в норме
        } catch (Exception e) {
            System.err.print(" 6");     // НЕ заходим - нет исключения
        } finally {
            System.err.print(" 7");     // заходим всегда
        }
        System.err.print(" 8");         // заходим - выполнение в норме
    }
}

class App49 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                if (true) {throw new RuntimeException();}
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3"); // ЗАХОДИМ - есть исключение
            } finally {
                System.err.print(" 4"); // заходим всегда
            }
            System.err.print(" 5");     // заходим - выполнение УЖЕ в норме
        } catch (Exception e) {
            System.err.print(" 6");     // не заходим - нет исключения, УЖЕ перехвачено
        } finally {
            System.err.print(" 7");     // заходим всегда
        }
        System.err.print(" 8");         // заходим - выполнение УЖЕ в норме
    }
}

class App50 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                if (true) {throw new Exception();}
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3"); // НЕ заходим - есть исключение, но НЕПОДХОДЯЩЕГО ТИПА
            } finally {
                System.err.print(" 4"); // заходим всегда
            }
            System.err.print(" 5");     // не заходим - выполнение НЕ в норме
        } catch (Exception e) {
            System.err.print(" 6");     // ЗАХОДИМ - есть подходящее исключение
        } finally {
            System.err.print(" 7");     // заходим всегда
        }
        System.err.print(" 8");         // заходим - выполнение УЖЕ в норме
    }
}

class App51 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                if (true) {throw new Error();}
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3"); // НЕ заходим - есть исключение, но НЕПОДХОДЯЩЕГО ТИПА
            } finally {
                System.err.print(" 4"); // заходим всегда
            }
            System.err.print(" 5");     // НЕ заходим - выполнение НЕ в норме
        } catch (Exception e) {
            System.err.print(" 6");     // не заходим - есть исключение, но НЕПОДХОДЯЩЕГО ТИПА
        } finally {
            System.err.print(" 7");     // заходим всегда
        }
        System.err.print(" 8");         // не заходим - выполнение НЕ в норме
    }
}
