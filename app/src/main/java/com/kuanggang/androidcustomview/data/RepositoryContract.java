package com.kuanggang.androidcustomview.data;


import com.kuanggang.androidcustomview.base.BaseLocalRepository;
import com.kuanggang.androidcustomview.base.BaseRemoteRepository;

/**
 * @author KG on 2017/6/7.
 */

public interface RepositoryContract {

    interface GetDataCallback<T> {

        void onDataLoaded(T entity);

        void onDataNotAvailable(Throwable throwable);
    }

    interface RemoteRepository extends BaseRemoteRepository {
        void getGankListByCategory(String category, int page, int size, GetDataCallback getDataCallback);

        void onDestory();
    }

    interface LocalRepository extends BaseLocalRepository {

    }
}
