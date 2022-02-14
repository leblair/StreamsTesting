import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Testing {
    public static void main(String[] args){
//        List<Book> books = Arrays.asList(
//                new Book("book1",1,10.5),
//                new Book("book2",10,8.99),
//                new Book("book3",4,12.99),
//                new Book("book4",5,11.65)
//        );
//        List<Book> filteredBooks = books.stream()
//                .filter(b -> b.price>10)
//                .collect(Collectors.toList());
//        System.out.println(filteredBooks);
//
//        filteredBooks.stream()
//                .forEach(book -> {
//                    book.price = book.price*2;
//                });
//        //System.out.println(filteredBooks);
//        books.stream()
//                .collect(toMap(
//                        book -> book.getName() +"-" + book.getVol(),
//                        book -> book.getPrice()
//                ))
//                .forEach((s, aDouble) -> System.out.println(s+ " " + aDouble));

        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
        cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
        cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
        cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
        cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300 ));

        //Obtener la cantidad de cursos con una duración mayor a 5 horas.

        int cant = (int) cursos.stream()
                .filter(curso -> curso.getDuracion()>5 )
                .count();
        int cant2 = (int) cursos.stream()
                .filter(curso -> curso.getDuracion()<2)
                .count();
        StringBuilder str = new StringBuilder();
        str.append("Cursos con duración mayor a 5 horas: ");
        str.append(cant);
        System.out.println(str);
        str.append("Cursos con duración menor a 2 horas: ");
        str.append(cant2);
        System.out.println(str);

        //Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.

        cursos.stream()
                .filter(curso -> curso.getVideos()>50)
                .forEach(curso -> {
                    System.out.println(curso.getTitulo());
                });
        //Mostrar en consola el título de los 3 cursos con mayor duración.

        System.out.println("Los 3 cursos con mayor duracion son: \n");
        AtomicInteger count = new AtomicInteger();
         cursos.stream()
                .sorted((f1,f2) -> {
                    return -Float.compare(f1.getDuracion(),f2.getDuracion());
                })
                .forEach(curso -> {
                    if(count.get() <3){
                        System.out.println(curso.getTitulo());
                        count.getAndIncrement();
                    }
                });

        System.out.println("La duracion total de todos los cursos es: " );
        float duration = cursos.stream()
                .reduce(0.0f,(carry , curso) -> carry+ curso.getDuracion(),Float::sum);
        System.out.println(duration);

        //Mostrar en consola todos aquellos libros que superen el promedio en cuanto a duración se refiere.
        System.out.println("Cursos que superan el promedio de duración: ");
        cursos.stream()
                .filter(curso -> curso.getDuracion()>duration/cursos.size())
                .forEach(curso -> {
                    System.out.println(curso.getTitulo());
                });

        //Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500
        System.out.println("Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500");
        cursos.stream()
                .filter(curso -> curso.getAlumnos()<500)
                .forEach(curso -> {
                    System.out.println(curso.getDuracion());
                });
        //Obtener el curso con mayor duración.
        System.out.println("Obtener el curso con mayor duración.");
        System.out.println(cursos.stream()
                .max((c1,c2) -> {
                    return Float.compare(c1.getDuracion(),c2.getDuracion());
                }).get().getTitulo());

        //Crear una lista de Strings con todos los titulos de los cursos.
        System.out.println("Crear una lista de Strings con todos los titulos de los cursos.");
        List<String> titulos = cursos.stream()
                .map(Curso::getTitulo)
                .collect(Collectors.toList());
        titulos.stream()
                .forEach(System.out::println);
    }


}
