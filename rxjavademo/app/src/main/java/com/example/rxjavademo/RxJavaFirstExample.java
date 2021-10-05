package com.example.rxjavademo;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

import static com.example.rxjavademo.Alphabet.englishletter;


public class RxJavaFirstExample {

    public static void main(String[] args) {
        Observable<String> stringObservable = Observable.fromArray(englishletter);
//        stringObservable.subscribe(System.out::println);

//        stringObservable.subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                System.out.println(s);
//            }
//        });

//        stringObservable.subscribe(s -> System.out.println(s));

//        System.out.println("_______");
//        Observable<Integer> integerObservable = Observable.fromArray(new Integer[] {1, 2, 3});
//        integerObservable.subscribe(System.out::println);


        stringObservable.filter(new Predicate<String>() {
            @Override
            public boolean test(@NotNull String s) throws Exception {
                List<String> list = Arrays.asList(new String[]{"a", "e", "i", "o", "u"});
                if (list.contains(s)) {
//                    System.out.println(s);
                    return true;
                }
                return false;
            }
        }).subscribe(System.out::println);


//        stringObservable.subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                List<String> list = Arrays.asList(new String[]{"a", "e", "i", "o", "u"});
//                if (list.contains(s)) {
//                    System.out.println(s);
//                }
//            }
//        });
    }
}
