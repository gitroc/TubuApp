package com.tubu.tubuapp.module.examples.rxandroid;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by roc on 2016/10/31.
 */

public class RxJava {
    private static String TAG = "[RxJava]";

    public static void testRxJava1() {
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("testRxJava1");
                        sub.onCompleted();
                    }
                }
        );

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }
        };

        myObservable.subscribe(mySubscriber);
    }

    public static void testRxJava2() {
        Observable.just("testRxJava2")
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }

    public static void testRxJava3() {
        Observable.just("testRxJava3")
                .subscribeOn(Schedulers.newThread())
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        Logger.i("String to Integer");
                        return s.hashCode();
                    }
                })
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        Logger.i("Integer to String");
                        return integer.toString();
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.i(s);
                    }
                });
    }

    public static void testRxJava4() {
        Observable.from(new String[]{"testRxJava1", "testRxJava2", "testRxJava3"})
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.t(TAG).i(s);
                    }
                });
    }

    public static void testRxJava5() {
        String java5[] = {"testRxJava4", "testRxJava5", "Logger.t(TAG).i(s);"};
        Observable.just(java5)
                .subscribeOn(Schedulers.newThread())
                .flatMap(new Func1<String[], Observable<?>>() {
                    @Override
                    public Observable<?> call(String[] strings) {
                        return Observable.from(strings);
                    }
                })
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        Logger.t(TAG).i(o.toString());
                    }
                });
    }

    public static void testRxJava6() {
        List<String> list = new ArrayList<String>();
        list.add("hello1");
        list.add("hello2");
        list.add("hello3");
        list.add("haha1");
        list.add("haha2");
        list.add("haha3");
        list.add("haha4");
        Observable.just(list)
                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<List<String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(List<String> strings) {
                        return Observable.from(strings);
                    }
                })
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return filterString(s, "haha");
                    }
                })
                .take(5)
                .doOnNext(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        saveText(s);
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String o) {
                        Logger.t(TAG).i(o);
                    }
                });
    }

    private static boolean filterString(String str, String str1) {
        String subs = str.substring(0, str1.length());
        if (!subs.equals(str1))
            return true;
        return false;
    }

    private static void saveText(String text) {
        Logger.t(TAG).i("save text to file");
    }

    /**
     * 这有什么屌用？？？？
     */
    private static void testRxJava7() {

        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
//                Drawable drawable = getTheme().getDrawable(drawableRes));
//                subscriber.onNext(drawable);
//                subscriber.onCompleted();
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onNext(String drawable) {
//                imageView.setImageDrawable(drawable);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
//                Toast.makeText(activity, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void testRxJava8() {
        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer number) {
                        Logger.t(TAG).i("testRxJava8 " + "number:" + number);
                    }
                });
    }

    public static void testRxJava9() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("1");
        list1.add("2");
        list1.add("3");

        list2.add("a");
        list2.add("b");
        list2.add("c");

        Observable observable1 = Observable.from(list1);
        Observable observable2 = Observable.from(list2);

        //合并数据  先发送observable2的全部数据，然后发送 observable1的全部数据
        Observable observable = Observable.merge(observable2, observable1);

        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
//                System.out.println("rx-- " + o);
                Logger.t(TAG).i("testRxJava9 " + "String merge:" + o);
            }
        });
    }

    public static void testRxJava10() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");

        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");

        Observable observable1 = Observable.from(list1);
        Observable observable2 = Observable.from(list2);

        Observable observable = Observable.zip(observable1, observable2, new Func2<String, String, String>() {
            @Override
            public String call(String o, String o2) {
                return o + o2;
            }
        });

        observable.subscribe(new Action1<String>() {
            @Override
            public void call(String o) {
                Logger.t(TAG).i("testRxJava10 = " + "String merge:" + o);
            }
        });
    }


    public static void testRxJava11() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .scan(new Func2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer, Integer integer2) {
                        return integer + integer2;
                    }
                })
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Logger.t(TAG).i("testRxJava11 = " + integer);
                    }
                });
    }

    public static void testRxJava12() {
        Observable.just(1, 2, 3, 4, 5, 6, 7)
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer > 4;
                    }
                })
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Logger.t(TAG).i("testRxJava12 = " + integer);
                    }
                });
    }

    public static void testRxJava13() {
        Integer[] integerArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Observable.from(integerArray)
                .take(3)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Logger.t(TAG).i("testRxJava13 take = " + integer);
                    }
                });

        Observable.from(integerArray)
                .takeLast(5)
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        Logger.t(TAG).i("testRxJava13 takeLast = " + o);
                    }
                });

        Observable.from(integerArray)
                .first()
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Logger.t(TAG).i("testRxJava13 first = " + integer);
                    }
                });

        Observable.from(integerArray)
                .last()
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Logger.t(TAG).i("testRxJava13 last = " + integer);
                    }
                });

        Observable.from(integerArray)
                .skipLast(2)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Logger.t(TAG).i("testRxJava13 skipLast = " + integer);
                    }
                });

        Observable.from(integerArray)
                .elementAt(5)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Logger.t(TAG).i("testRxJava13 elementAt(5) = " + integer);
                    }
                });

        Observable.from(integerArray)
                .elementAtOrDefault(13, 1000)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Logger.t(TAG).i("testRxJava13 .elementAtOrDefault(3, 1000) = " + integer);
                    }
                });
    }

    public static void testRxJava14() {
        String[] stringArray = {"aa", "bb", "cc"};

        Observable observable = Observable.from(stringArray);

        observable
                .startWith("11", "22")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.t(TAG).i("testRxJava14 startWith1 = " + s);
                    }
                });

        List<String> list = new ArrayList<>();
        list.add("ww");
        list.add("tt");

        observable.startWith(Observable.from(list))
                .subscribe(new Action1() {
                    @Override
                    public void call(Object o) {
                        Logger.t(TAG).i("testRxJava14 startWith2 = " + o);
                    }
                });
    }

    public static void testRxJava15() {
        Integer[] integerArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Logger.t(TAG).i("testRxJava15 start = " + integerArray.toString());
        Observable.from(integerArray)
                .delay(5, TimeUnit.SECONDS)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Logger.t(TAG).i("testRxJava15 delay = " + integer);
                    }
                });
    }

    public static void testRxJava16() {
        Observable.timer(5, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Logger.t(TAG).i("testRxJava16 timer = " + aLong);
                    }
                });
    }

    public static void testRxJava17() {
        //参数一：延迟时间  参数二：间隔时间  参数三：时间颗粒度

        Observable.interval(3000, 3000, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Logger.t(TAG).i("testRxJava17 interval = " + aLong);
                    }
                });
    }

    public static void testRxJava18() {
        Integer[] integerArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Observable.from(integerArray)
                .doOnNext(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Logger.t(TAG).i("testRxJava18 doOnNext 数据缓存 = " + integer);
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Logger.t(TAG).i("testRxJava18 onNext！");
                    }
                });
    }


    public static void testRxJava19() {
        List<String> list = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            list.add("" + i);
        }

        Observable.from(list)
                .buffer(2)
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> strings) {
                        Logger.t(TAG).i("testRxJava19 i am list ------");
                        Observable.from(strings)
                                .subscribe(new Action1<String>() {
                                    @Override
                                    public void call(String s) {
                                        Logger.t(TAG).i("testRxJava19 i am String = " + s);
                                    }
                                });
                    }
                });
    }

    public static void testRxJava20() {
        List<String> list = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            list.add("" + i);
        }

        Observable.from(list)
                .buffer(2, 3)
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> strings) {
                        Logger.t(TAG).i("testRxJava20 i am list ------");

                        Observable.from(strings)
                                .subscribe(new Action1<String>() {
                                    @Override
                                    public void call(String s) {
                                        Logger.t(TAG).i("testRxJava20 i am String = " + s);
                                    }
                                });
                    }
                });
    }

    public static void testRxJava21() {
        Observable.interval(1, TimeUnit.SECONDS)
                .throttleFirst(3, TimeUnit.SECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Logger.t(TAG).i("testRxJava21 throttleFirst = " + aLong);
                    }
                });
    }

    public static void testRxJava22() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("5");
        list.add("4");
        list.add("2");
        list.add("1");
        list.add("1");

        Observable.from(list)
                .distinct()
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.t(TAG).i("testRxJava22 distinct = " + s);
                    }
                });
    }

    public static void testRxJava23() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("1");
        list.add("3");
        list.add("4");
        list.add("4");
        list.add("2");
        list.add("1");
        list.add("1");

        Observable.from(list)
                .distinctUntilChanged()
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.t(TAG).i("testRxJava23 distinctUntilChanged = " + s);
                    }
                });
    }

    public static void testRxJava24() {
        Observable.interval(10, TimeUnit.SECONDS)
                .debounce(3, TimeUnit.SECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Logger.t(TAG).i("testRxJava24 debounce = " + aLong);
                    }
                });
    }

    /**
     * In fact, i do not know why this example.
     */
    public static void testRxJava25() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("1");
        list.add("3");
        list.add("4");
        list.add("4");
        list.add("2");
        list.add("1");
        list.add("1");

        Observable.from(list)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        Logger.t(TAG).i("testRxJava25 hello doOnSubscribe, i am on Schedulers.io()");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Logger.t(TAG).i("testRxJava25 onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.t(TAG).i("testRxJava25 onError");
                    }

                    @Override
                    public void onNext(String s) {
                        Logger.t(TAG).i("testRxJava25 onNext");
                    }
                });

    }

    public static void testRxJava26() {
        Observable.range(1, 8)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Logger.t(TAG).i("testRxJava26 range = " + integer);
                    }
                });
    }

    /**
     * I hope you know why
     */
    public static void testRxJava27() {
        final String i = "10";
        Observable<String> defer = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just(i);
            }
        });

        Observable test = Observable.just(i);

        defer.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Logger.t(TAG).v("rx_defer  = " + s);
            }
        });

        test.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Logger.t(TAG).v("rx_just  = " + o);
            }
        });
    }
}
