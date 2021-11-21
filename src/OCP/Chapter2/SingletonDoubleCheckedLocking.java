package OCP.Chapter2;

public class SingletonDoubleCheckedLocking {
        private SingletonDoubleCheckedLocking() {}
        private static volatile SingletonDoubleCheckedLocking Instance;

        public static SingletonDoubleCheckedLocking getInstance(){
            if(Instance == null){
                synchronized (SingletonDoubleCheckedLocking.class){
                    if (Instance == null)
                        Instance = new SingletonDoubleCheckedLocking(); } }
            return Instance; }
    }
