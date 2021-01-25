package com.example.assignmenttmdbapiunittest;

import com.example.assignmenttmdbapiunittest.api.TmdbApiClient;
import com.example.assignmenttmdbapiunittest.util.ApplicationConstants;

import org.junit.BeforeClass;


public abstract class BaseTestCase {

    private final static TmdbApiClient mTmdbApiClient = new TmdbApiClient();

    @BeforeClass
    public static void setUpOnce() {
        //mTmdbApiClient.setIsDebug(ApplicationConstants.DEBUG);
    }


    protected final TmdbApiClient getTmdbApiClient() {
        return mTmdbApiClient;
    }
}
