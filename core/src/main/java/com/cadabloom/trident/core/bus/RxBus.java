package com.cadabloom.trident.core.bus;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

@Singleton
public class RxBus {
    private PublishSubject<Object> _subject = PublishSubject.create();

    public void publish(Object event){
        _subject.onNext(event);
    }

    public Observable<?> listen(Class<? extends Object> event){
        return _subject.ofType(event);
    }

    @Inject
    public RxBus(){

    }
}
