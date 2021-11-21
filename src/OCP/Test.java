package OCP;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Test extends Thread{

    @Override
    public void run() {
        System.out.println("hello");
    }

    public static void main(String[] args) {

        List <Integer> list0      = new ArrayList <> (Arrays.asList(1, 2, 3, 4, 5));
        List <Integer> list1      = new ArrayList <> (Arrays.asList(1, 2, 3, 4, 5));
        List <Integer> list2      = new ArrayList <> (Arrays.asList(1, 2, 3, 4, 5));
        List <List<Integer>> list = new ArrayList <> (Arrays.asList(list0,list1,list2));

        Iterator iterator = list.stream()
                .flatMapToInt(x -> x.stream().mapToInt(q -> q))
                .iterator();
        while (iterator.hasNext()) System.out.print(iterator.next()+" ");
        System.out.println();

        Iterator iterator1 = list.stream()
                .mapToInt(List::size)
                .iterator();
        while (iterator1.hasNext()) System.out.print(iterator1.next()+" ");
        System.out.println();

        List <Integer> list3      = new ArrayList <> (Arrays.asList(1, 1, 2, 2, 3));
        Iterator iterator2 = list3.stream()
                .distinct()
                .iterator();
        while (iterator2.hasNext()) System.out.print(iterator2.next()+" ");
        System.out.println();


        Integer [] integers = list.stream()
                .flatMap(Collection::stream)
                .toArray(Integer[]::new);
        List <Integer> aaa = new ArrayList<>(Arrays.asList(integers));
        System.out.println(aaa);

        int sum = list0.stream().reduce(2, Integer::sum);
        System.out.println(sum);

        Optional sum1 = list0.stream().reduce(Integer::sum);
        System.out.println(sum1);

        List <String> strings = new ArrayList <> (Arrays.asList("1","22","333"));
        int sum2 = strings
                .stream()
                .parallel()
                .reduce(0,
                        (x,y) -> {int n = x+y.length(); System.out.println("accumulator " +x+ "+" +y+ " -> " +n); return n;},
                        (x,y) -> {int n = x*x*y;        System.out.println("combiner " +x+ "*" +x+ "*" +y+ " -> " +n);    return n;});
        System.out.println(sum2);

        Optional <Integer> optional = list0.stream().min(Comparator.comparingInt(x -> x));
        System.out.println(optional);

        Stream stream  = Stream.of(1,2,3,4);
        Stream stream1 = Stream.empty();

        Stream <Integer> stream2 = Stream.iterate(1,x->x+1);
        Integer [] integers1 = stream2.limit(4).toArray(Integer[]::new);
        List<Integer>list4 = new ArrayList<>(Arrays.asList(integers1));
        System.out.println(list4);

        Stream <Integer> stream3 = Stream.generate(()->1);
        Integer [] integers2 = stream3.limit(4).toArray(Integer[]::new);
        List<Integer>list5 = new ArrayList<>(Arrays.asList(integers2));
        System.out.println(list5);

        Stream stream4 = Stream.concat(stream,stream1);
        stream4.forEach(System.out::println);




        Map map = Stream.generate(()->1).limit(3).collect(Collectors.partitioningBy(x->x>2));
        System.out.println(map);

    }}


    class group extends Thread{
        @Override
        public void run() {

        }

        String a;
        String b;

        public group(String a, String b) {
            this.a = a;
            this.b = b;
        }


        public String getA() {
            return a;
        }

        public String getB() {
            return b;
        }



        public static void main(String[] args) {
            TreeMap map = Stream.of(new group("1","a"),new group("1","b"),new group("2","c"))
                    .collect(Collectors.groupingBy(group::getA,TreeMap::new,Collectors.groupingBy(group::getB)));
            System.out.println(map);

            IntSummaryStatistics iss = Stream.of(1,2,3).collect(Collectors.summarizingInt(x->x));
            System.out.println(iss);

            Optional  optional = Optional.of(2);
            Object integer = optional.orElse(3);
            System.out.println(integer);


        }
    }

    class path {
        public static void main(String[] args) {

            Stream.of(Paths.get("C:\\C1\\C2").resolve(Paths.get("B:\\B1\\B2"))).forEach(System.out::println); // B:\B1\B2
            Stream.of(Paths.get(    "C1\\C2").resolve(Paths.get("B:\\B1\\B2"))).forEach(System.out::println); // B:\B1\B2
            Stream.of(Paths.get("C:\\C1\\C2").resolve(Paths.get(    "B1\\B2"))).forEach(System.out::println); // C:\C1\C2\B1\B2
            Stream.of(Paths.get(    "C1\\C2").resolve(Paths.get(    "B1\\B2"))).forEach(System.out::println); // C1\C2\B1\B2
            System.out.println();
            Stream.of(Paths.get("C:\\C1\\C2").resolveSibling(Paths.get("B:\\B1\\B2"))).forEach(System.out::println); // B:\B1\B2
            Stream.of(Paths.get(    "C1\\C2").resolveSibling(Paths.get("B:\\B1\\B2"))).forEach(System.out::println); // B:\B1\B2
            Stream.of(Paths.get("C:\\C1\\C2").resolveSibling(Paths.get(    "B1\\B2"))).forEach(System.out::println); // C:\C1\B1\B2
            Stream.of(Paths.get(    "C1\\C2").resolveSibling(Paths.get(    "B1\\B2"))).forEach(System.out::println); // C1\B1\B2
            System.out.println();
            Stream.of(Paths.get("C:\\C1\\C2").relativize(Paths.get("C:\\C1\\C2"))).forEach(System.out::println); //
            Stream.of(Paths.get("C:\\C1\\C2").relativize(Paths.get("C:\\C1\\X2"))).forEach(System.out::println); // ..\X2
            Stream.of(Paths.get(    "C1\\C2").relativize(Paths.get(    "X1\\X2"))).forEach(System.out::println); // ..\..\X1\X2
            System.out.println();
            Stream.of(Paths.get("C:\\C1\\C2").toAbsolutePath()).forEach(System.out::println);   // C:\C1\C2
            Stream.of(Paths.get("C1\\C2").toAbsolutePath()).forEach(System.out::println);       // C:\Users\Танюшка\Desktop\Java\JavaRush\Проекты\New Project\C1\C2
            System.out.println();
            Stream.of(Paths.get("C:\\..\\..\\..\\C2").normalize()).forEach(System.out::println);                // C:\C2
            Stream.of(Paths.get(    "..\\C1\\..\\.\\..\\C2").normalize()).forEach(System.out::println);         // ..\..\C2
            System.out.println();
            Stream.of(Paths.get("C:\\..\\..\\..\\C2").getNameCount()).forEach(System.out::println);                // 4
            Stream.of(Paths.get(    "..\\C1\\..\\.\\..\\C2").getNameCount()).forEach(System.out::println);         // 6

            Stream.of(Paths.get("C:\\..\\..\\..\\C2").getFileSystem()).forEach(System.out::println);                // sun.nio.fs.WindowsFileSystem@3d494fbf
            Stream.of(Paths.get(    "..\\C1\\..\\.\\..\\C2").getFileSystem()).forEach(System.out::println);         // sun.nio.fs.WindowsFileSystem@3d494fbf
        }
    }


    class file{
        public static void main(String[] args) {


            System.out.println(new File("C:\\dir1\\dir2").getName());       // dir2
            System.out.println(new File("C:\\dir1\\dir2").getParent());     // C:\dir1
            System.out.println(new File("C:\\dir1\\dir2").getParentFile()); // C:\dir1
            System.out.println(new File("C:\\dir1\\dir2").getPath());       // C:\dir1\dir2

            Stream.of(File.listRoots()).forEach(System.out::print);
        }
    }


    class streamIO{
        public static void main(String[] args) throws IOException{
            InputStream inputStream = new BufferedInputStream(new FileInputStream(Paths.get("C:\\dir").toFile()),100);
            Integer i = inputStream.read();

            InputStream inputStream1 = new BufferedInputStream(new InputStream() {
                @Override
                public int read() throws IOException {
                    return 0;
                }
            });


            OutputStream outputStream = new BufferedOutputStream(new FilterOutputStream(new FileOutputStream(Paths.get("C:\\dir").toFile())),10);
            outputStream.write(12);

            PrintStream printStream = new PrintStream(Paths.get("C\\:dir").toFile());
            printStream.print(12);


            Reader reader = new InputStreamReader(new FileInputStream("C\\file.txt"));
            Reader reader1 = new BufferedReader(new FileReader("C\\file.txt"));

        }
    }

    class qwe  {
            public static void main(String[] args) {
            ExecutorService executorService = null;
            ScheduledExecutorService scheduledExecutorService =null;
            try {
                executorService = Executors.newSingleThreadScheduledExecutor();
                executorService.execute(()-> System.out.println(1));

                scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
                scheduledExecutorService.schedule(()-> System.out.println(2),1,TimeUnit.SECONDS);

                scheduledExecutorService.scheduleAtFixedRate(()-> System.out.println(3),3,3,TimeUnit.SECONDS);

                scheduledExecutorService.scheduleWithFixedDelay(()-> System.out.println(4),3,3,TimeUnit.SECONDS);


                    }
            finally {
                if (executorService!=null) executorService.shutdown();
                if (scheduledExecutorService!=null) executorService.shutdown();
            }
        }
    }


    class pop {
        public static void main(String[] args) {
            List <Integer> list = Arrays.asList(1,2,3,4);
            Object [] integers = list.toArray();
            for (int i = 0; i<integers.length;i++) System.out.print(integers[i]);
            System.out.println();
            Integer [] integers1 = list.toArray(new Integer[0]);
            for (int i = 0; i<integers1.length;i++) System.out.print(integers1[i]);
        }
    }

