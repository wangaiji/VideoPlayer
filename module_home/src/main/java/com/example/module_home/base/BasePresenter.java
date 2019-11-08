package com.example.module_home.base;

public abstract class BasePresenter<T>{
    private T mView;

    /**
     * 绑定view
     * @param view
     */
    public void attachView(T view) {
        mView = view;
    }

    /**
     * 解绑view
     */

    public void detachView() {
        mView = null;
    }
    public abstract void unSubscribe();
    public T getView() {
        return mView;
    }
}
