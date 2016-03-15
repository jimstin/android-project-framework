package com.jimstin.frameworklib.net;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jim on 16-2-13.
 */
public class DefaultThreadPool {

    private static ThreadPoolExecutor mExecutor;
    private static DefaultThreadPool mDefaultThreadPool;
    private static ArrayBlockingQueue<Runnable> mQueue;

    public static DefaultThreadPool getInstance() {
        if (mDefaultThreadPool == null) {
            mDefaultThreadPool = new DefaultThreadPool();
            mQueue = new ArrayBlockingQueue<Runnable>(1);
            mExecutor = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, mQueue,
                    new ThreadPoolExecutor.CallerRunsPolicy());
        }
        return mDefaultThreadPool;
    }

    public ArrayBlockingQueue<Runnable> getTaskQuene() {
        return mQueue;
    }

    public void startRequest(HttpRequest request) {
        mExecutor.execute(request);
    }

}
